package com.summer.view;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;

public class BaseWebView extends WebView implements Callback{
	
	WebViewClientImpl client;
	public boolean isProgressDialog = true;
	public String columnid = "";
	public boolean isNews = false;
	public boolean isLoaded = false;
	public boolean isToDownload = false;
	private Context mContext;
	
	public WebViewClientImpl getClient() {
		return client;
	}

	protected void onChangeMyWebViewStatus() {
		if (mContext == null)
			return;
	}
	
	public void setProgressDialog(boolean isProgressDialog) {
		this.isProgressDialog = isProgressDialog;
	}

	public BaseWebView(Context context) {
		super(context);
		mContext = context;
		Init();
	}

	public BaseWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		Init();
	}

	public BaseWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		Init();
	}
	
	@SuppressWarnings("deprecation")
	private void Init() {
		client = new WebViewClientImpl(this.getContext());
		setWebViewClient(client);
		// ��������������Ե��ӣ��������ķ�ʽ��ʾ����ռ�ÿռ�
		this.setVerticalScrollbarOverlay(true);
		this.setDownloadListener(new DownloadListener() {

			@Override
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Uri uri = Uri.parse(url);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				getContext().startActivity(intent);
			}

		});
		this.clearCache(false);
		WebSettings bs = getSettings();
		// bs.setDefaultTextEncodingName("UTF-8");
		bs.setBuiltInZoomControls(true);
		bs.setJavaScriptEnabled(true);

		bs.setSupportMultipleWindows(true);// ��㴥��
		bs.setSupportZoom(false);// �Ƿ�֧�ַŴ���С
		// WebView.enablePlatformNotifications();// cmwap��ȡ�������ݵĽ������
		this.setHorizontalScrollBarEnabled(false);

		/**
		 * ����֧��HTML5���ش洢
		 */
		bs.setDatabaseEnabled(true);// �������ݿ�
		String dir = mContext.getDir("database", Context.MODE_PRIVATE)
				.getPath();
		bs.setDatabasePath(dir);// �������ݿ�·��
		bs.setDomStorageEnabled(true);// ʹ��localStorage������

		/**
		 * ����֧�ֹ���html5����Ӧ��
		 */
		bs.setAppCacheEnabled(true);// ����Ӧ�ó��򻺴�
		String dirCache = mContext.getDir("cache", Context.MODE_PRIVATE)
				.getPath();
		bs.setAppCachePath(dirCache);// ����Ӧ�û����·��
		bs.setCacheMode(WebSettings.LOAD_DEFAULT); // ���û����ģʽ
		bs.setAppCacheMaxSize(1024 * 1024 * 8); // ����Ӧ�û�������ߴ�

		/**
		 * ����֧��html5��λ
		 */
		bs.setJavaScriptCanOpenWindowsAutomatically(true);
		bs.setGeolocationEnabled(true);
		// ���ö�λ�����ݿ�·��
		bs.setGeolocationDatabasePath(dir);
		MyWebClient geo = new MyWebClient();
		this.setWebChromeClient(geo);

	}

	public void setShowErrorPage(boolean isShowErrorPage) {
		if (client != null) {
			client.setShowErrorPage(isShowErrorPage);
		}
	}

	@Override
	public void loadUrl(String url) {
		if ("file:///android_asset/error/index.html".equalsIgnoreCase(url)) {
			goBack();
			return;
		}
		if (isNews) {
			if (!isLoaded) {
				isLoaded = true;
				url = getUrlWithExtra(url);
				Log.d("webviewURL", url);

				super.loadUrl(url);
				if (client != null) {
					if (isProgressDialog) {
						client.showCustomProgressDialog();
					}
				}
			}
			this.isLoaded = false;
			return;
		}
		url = getUrlWithExtra(url);
		super.loadUrl(url);
		if (client != null) {
			if (isProgressDialog) {
				client.showCustomProgressDialog();
			}
		}
		Log.d("webviewURL", url);

	}

	public String getUrlWithExtra(String url) {
		if (url == null || "".equals(url)) {
			return "";
		}

		if (url.endsWith(".html") || isToDownload) {
			return url;
		}

		if (url.indexOf("?") < 0) {
			url = url + "?";
		} else if (url.indexOf("&") > url.indexOf("?") || url.indexOf("&") < 0) {
			url = url + "&";
		}

		if (url.indexOf("token=") < 0) {
		}

		if (url.indexOf("pt=") < 0) {
			url = url + "&pt=pps";
		}

		if (url.indexOf("showinhwclient=") < 0) {
			url = url + "&showinhwclient=1";
		}

		url = url + "&ua=" + android.os.Build.MODEL.trim();
		return url;
	}

	public void showProgressDialog() {
		if (client != null) {
			client.showProgressDialog();
		}
	}

	public boolean isLoaded() {
		return client.isLoaded;
	}

	public String getLastUrl() {

		return client.mUrl;

	}

	@Override
	public void setVisibility(int visibility) {

		super.setVisibility(visibility);
		if (visibility == View.INVISIBLE && client != null) {
			// ProgressBar bar = client.getProgressBar();
			// if (bar != null) {
			// bar.setVisibility(View.INVISIBLE);
			// }

		}
	}

	@Override
	public void invoke(String arg0, boolean arg1, boolean arg2) {

	}

	class MyWebClient extends WebChromeClient {
		private Uri imageUri;

		// For Android > 4.1
		public void openFileChooser(ValueCallback<Uri> uploadMsg,
				String acceptType, String capture) {
			openFileChooser(uploadMsg);
		}

		// Andorid 3.0 +
		public void openFileChooser(ValueCallback<Uri> uploadMsg,
				String acceptType) {
			openFileChooser(uploadMsg);
		}

		// Android 3.0

		public void openFileChooser(ValueCallback<Uri> uploadMsg) {

		}

		// ���仺�������
		@SuppressWarnings("deprecation")
		@Override
		public void onReachedMaxAppCacheSize(long spaceNeeded,
				long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
		}

		// �������ݿ������
		@SuppressWarnings("deprecation")
		@Override
		public void onExceededDatabaseQuota(String url,
				String databaseIdentifier, long currentQuota,
				long estimatedSize, long totalUsedQuota,
				WebStorage.QuotaUpdater quotaUpdater) {
		}

		// ����Ȩ��
		@Override
		public void onGeolocationPermissionsShowPrompt(String origin,
				Callback callback) {
			try {
				Builder builder = new Builder(mContext);
				builder.setTitle("����λ����Ȩ");
				builder.setMessage("����" + origin + "��������ǰ�ĵ���λ����Ϣ��");
				builder.setPositiveButton(android.R.string.ok,
						new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						});
				builder.setNegativeButton(android.R.string.cancel,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						});
				builder.setCancelable(false);
				builder.create();
				builder.show();

				super.onGeolocationPermissionsShowPrompt(origin, callback);
			} catch (Exception e) {
			}
		}

		// ����javascript�е�alert
		@Override
		public boolean onJsAlert(WebView view, String url, String message,
				final JsResult result) {
			// ����һ��Builder����ʾ��ҳ�еĶԻ���
			Builder builder = new Builder(mContext);
			builder.setTitle("��ܰ��ʾ");
			builder.setMessage(message);
			builder.setPositiveButton(android.R.string.ok,
					new AlertDialog.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							result.confirm();
						}
					});
			builder.setCancelable(false);
			builder.create();
			builder.show();
			return true;
		};

		// ����javascript�е�confirm
		@Override
		public boolean onJsConfirm(WebView view, String url, String message,
				final JsResult result) {
			Builder builder = new Builder(mContext);
			builder.setTitle("��ܰ��ʾ");
			builder.setMessage(message);
			builder.setPositiveButton(android.R.string.ok,
					new AlertDialog.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							result.confirm();
						}
					});
			builder.setNegativeButton(android.R.string.cancel,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							result.cancel();
						}
					});
			builder.setCancelable(false);
			builder.create();
			builder.show();
			return true;
		};

		// ������ҳ���صĽ�����
		@Override
		public void onProgressChanged(WebView view, int progress) {
			super.onProgressChanged(view, progress);

		}

		// ����Ӧ�ó���ı���title
		@Override
		public void onReceivedTitle(WebView view, String title) {
			super.onReceivedTitle(view, title);
		}

		// ��ӡweb������Ϣ
		@Override
		public void onConsoleMessage(String message, int lineNumber,
				String sourceID) {
			Log.d("webchrome_consoleMessage", message + " -- From line "
					+ lineNumber + " of " + sourceID);
		}

		// ��ȡ����ַlogo
		@Override
		public void onReceivedIcon(WebView view, Bitmap icon) {
			super.onReceivedIcon(view, icon);
		}
	}
}
