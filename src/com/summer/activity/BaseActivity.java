package com.summer.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.summer.R;
import com.summer.config.Config;
import com.summer.dialog.CustomProgressDialog;
import com.summer.handler.InfoHandler.InfoReceiver;
import com.summer.logger.XLog;

/**
 * Base activity
 * @author wen zhong
 *
 */
public abstract class BaseActivity extends FragmentActivity implements InfoReceiver {
	
	
	public static ArrayList<Activity> activityList = new ArrayList<Activity>();
	
	private Activity activity;
	
	protected CustomProgressDialog progressDialog;
	
	protected final int NONE = 0;
	
	protected final int PHOTO_GRAPH = 1;// 拍照
	
	protected final int PHOTO_ZOOM = 2; // 相册
	
	protected final int PHOTO_RESOULT = 3;// 结果
	
	protected boolean canCut = true;// 是否裁剪
	
	protected final String IMAGE_UNSPECIFIED = "image/*";
	
	protected String IMAGE_FILE = "";
	
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		super.onCreate(arg0);
		activityList.add(this);
		activity = this;
		XLog.i(Config.hasloadConfig);
		if (!Config.hasloadConfig) {
			File cache = this.getCacheDir();
			Config.setCachePath(cache.getPath());
			XLog.i(cache.getPath());
			Config.setFileDir(getFilesDir().getPath());
			Config.maincontext = this;
			Config.LoadConfig();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (findViewById(R.id.nav_back_view) != null)
		{
			backButton();
		}
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		try {
			activityList.remove(this);
			this.getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Button backButton() {
		Button button = (Button) findViewById(R.id.nav_back_view);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					activity.finish();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return button;
	}
	
	protected void setText(int id, String text)
	{
		TextView t = (TextView) findViewById(id);
		t.setText(text);
	}
	
	/**
	 * Show custom dialog progress
	 * @param title
	 */
	protected void ShowProgressDialog(String title) {
		try {
			if (progressDialog != null) 
			{
				return;
			}
			progressDialog = CustomProgressDialog.CreateDialog(this);
			progressDialog.setMessage(title);
			progressDialog.setCancelable(true);
			progressDialog.show();

			progressDialog.setOnCancelListener(
					new DialogInterface.OnCancelListener() 
					{
						@Override
						public void onCancel(DialogInterface arg0) 
						{
							if (progressDialog != null) {
								progressDialog.dismiss();
								progressDialog = null;
							}
						}
					});
		} 
		catch (Exception e) 
		{
			XLog.e("showProgressDialog exception: " + e.toString(), e);
			e.printStackTrace();
		}
	}
	
	protected void RemoveProgressDialog()
	{
		try {
			if (progressDialog != null) {
				progressDialog.dismiss();
				progressDialog = null;
			}
		} catch (Exception e) {
			 XLog.e("showProgressDialog exception: " + e.toString(), e);
		}
	}

	@Override
	public void onInfoReceived(int errorCode, HashMap<String, Object> items) {
		RemoveProgressDialog();
        if (errorCode == 0)
        {
            XLog.i(errorCode);
            String jsonString = (String) items.get("content");
            if (jsonString != null)
            {
                JSONObject object;
                try {
                    object = new JSONObject(jsonString);
                    String msg = object.optString("msg");
                    int code = object.optInt("status", -1);
                    int taskType = (Integer) items.get("taskType");
                    if (code == 0)
                    {
                        RequestSuccessful(jsonString, taskType);
                    }
                    else
                    {
                        RequestFailed(code, msg, taskType);
                    }
                } catch (JSONException e) {
                    //parse error
                    XLog.e(e);
                    e.printStackTrace();
                    RequestFailed(-1, "Json Parse Error", -1);
                }
            }
        }
		
	}

	@Override
	public void onNotifyText(String notify) {
	}

	/**
	 * Get json string and request success callback
	 * @param jsonString
	 * @param taskType
	 */
	public abstract void RequestSuccessful(String jsonString, int taskType);
	
	/**
	 * Get error and show failed toast
	 * @param errcode
	 * @param message
	 * @param taskType
	 */
    public void RequestFailed(int errcode, String message, int taskType)
    {
        if (errcode == 0) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
    
    public void ObtainImage(String imagePath)
    {
    	
    }
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == NONE)
			return;
		// 拍照
		if (requestCode == PHOTO_GRAPH) {
			// 设置文件保存路径
			if (canCut) {
				File picture = new File(
						Environment.getExternalStorageDirectory(), IMAGE_FILE
								+ ".jpg");
				startPhotoZoom(Uri.fromFile(picture));
			} else {
				File picture = new File(
						Environment.getExternalStorageDirectory(), IMAGE_FILE
								+ ".jpg");
				ObtainImage(picture.getPath());
			}

		}
		if (data == null)
			return;

		// 读取相册缩放图片
		if (requestCode == PHOTO_ZOOM) {
			if (canCut) {
				startPhotoZoom(data.getData());
			} else {
				try {
					Uri originalUri = data.getData(); // 获得图片的uri
					String[] proj = { MediaStore.Images.Media.DATA };
					// 好像是android多媒体数据库的封装接口，具体的看Android文档
					@SuppressWarnings("deprecation")
					Cursor cursor = managedQuery(originalUri, proj, null, null,
							null);
					// 按我个人理解 这个是获得用户选择的图片的索引值
					int column_index = cursor
							.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
					// 将光标移至开头 ，这个很重要，不小心很容易引起越界
					cursor.moveToFirst();
					// 最后根据索引值获取图片路径www.2cto.com
					String path = cursor.getString(column_index);
				} catch (Exception e) {
					XLog.e(e.toString());
				}
			}
		}
		// 处理结果
		if (requestCode == PHOTO_RESOULT) {
			Bundle extras = data.getExtras();
			if (extras != null) {
				Bitmap photo = extras.getParcelable("data");
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
				// 此处可以把Bitmap保存到sd卡中，具体请看：http://www.cnblogs.com/linjiqin/archive/2011/12/28/2304940.html
				// imageView.setImageBitmap(photo); //把图片显示在ImageView控件上
				setImage(new File(Environment.getExternalStorageDirectory(),
						IMAGE_FILE + ".jpg"), photo);
			}

		}

		super.onActivityResult(requestCode, resultCode, data);
	}
	
	/**
	 * 收缩图片
	 * 
	 * @param uri
	 */
	public void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 4);
		intent.putExtra("aspectY", 3);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 400);
		intent.putExtra("outputY", 300);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, PHOTO_RESOULT);
	}
	
	private void setImage(File path, Bitmap bmp) {
		try {
			if (!path.exists()) {
				path.createNewFile();
			}
			FileOutputStream iStream = new FileOutputStream(path);
			bmp.compress(CompressFormat.JPEG, 100, iStream);
			iStream.close();
			ObtainImage(path.getName());
			iStream = null;
			path = null;
		} catch (IOException e) {
			e.printStackTrace();
			XLog.e(e.toString());
		}
	}
}
