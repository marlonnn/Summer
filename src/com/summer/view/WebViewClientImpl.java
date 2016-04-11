package com.summer.view;

import com.summer.logger.XLog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientImpl extends WebViewClient{
	
	public interface WebViewClientImplLs {
		void WebViewClientImplLs();
	}

	protected WebViewClientImplLs clientImplLs;
	private Context activity;
	public boolean isLoaded = false;

	public String mUrl;
	private Dialog mProgressDlg = null;
	private NextWeb nextWeb;
	private boolean isShowErrorPage = true;

	public WebViewClientImplLs getClientImplLs() {
		return clientImplLs;
	}

	public void setClientImplLs(WebViewClientImplLs clientImplLs) {
		this.clientImplLs = clientImplLs;
	}

	public interface NextWeb {
		public void nextWebUrl(String str);
	}

	public void setNextWeb(NextWeb nextWeb) {
		this.nextWeb = nextWeb;
	}

	public WebViewClientImpl(Context activity) {
		this.activity = activity;
	}

	protected void onChangeMyWebViewStatus() {
		if (activity == null)
			return;
	}

	@Override
	public void onReceivedError(WebView view, int errorCode,
			String description, String failingUrl) {
		view.stopLoading();
		onPageFinished(view, failingUrl);
		if (this.isShowErrorPage) {
			view.loadUrl("file:///android_asset/error/index.html");
		}
		return;
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		try {
			if (url != null) {
				XLog.i(url);
				mUrl = url;
				if (url.startsWith("tel:")) {
					Intent intent = new Intent("android.intent.action.DIAL",
							Uri.parse(url));
					activity.startActivity(intent);
					return true;
				}

				if (url.startsWith("wtai:")) {
					int position = 0;
					if (url.indexOf(";") > 0) {
						position = url.indexOf(";");
					} else if (url.indexOf("；") > 0) {
						position = url.indexOf("；");
					}
					if (position != 0) {
						url = url.substring(position + 1).trim();

						callTelephoneToDIAL(url, activity);
						return true;
					}
				}

				if (nextWeb != null) {
					nextWeb.nextWebUrl(url);
				}
			}
			showCustomProgressDialog();
		} catch (Exception e) {

			XLog.e(e.toString(), e);
		}
		return super.shouldOverrideUrlLoading(view, url);

	}
	
	private void callTelephoneToDIAL(String phoneNum, Context context) {
		Intent it = new Intent("android.intent.action.DIAL", Uri.parse("tel:"
				+ phoneNum));
		context.startActivity(it);
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {

		super.onPageFinished(view, url);
		if (clientImplLs != null) {
			clientImplLs.WebViewClientImplLs();
		}
		onChangeMyWebViewStatus();
	}

	public void showProgressDialog() {
		mProgressDlg = ProgressDialog.show(activity, null, "数据加载中...", true);
		mProgressDlg.setCancelable(true);
	}

	public void showCustomProgressDialog() {
	}

	public void setShowErrorPage(boolean isShowErrorPage) {
		this.isShowErrorPage = isShowErrorPage;
	}
}
