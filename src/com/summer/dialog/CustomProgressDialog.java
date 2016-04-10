package com.summer.dialog;

import com.summer.R;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomProgressDialog extends Dialog{
	
	private Context context;

	public CustomProgressDialog(Context context) {
		super(context);
		this.context = context;
	}

	public CustomProgressDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}
	
	/**
	 * set title
	 * @param strTitle
	 * @return
	 */
	public CustomProgressDialog setTitile(String strTitle) {
		return this;
	}
	
	/**
	 * set message
	 * @param strMessage
	 * @return
	 */
	public CustomProgressDialog setMessage(String strMessage) {
		
		TextView tvMsg = (TextView)findViewById(R.id.id_tv_loadingmsg);

		if (tvMsg != null) {
			tvMsg.setText(strMessage);
		}

		return this;
	}
	
	public static CustomProgressDialog CreateDialog(Context context)
	{
		CustomProgressDialog customProgressDialog = new CustomProgressDialog(context,
				R.style.CustomProgressDialog);
		customProgressDialog.context = context;
		customProgressDialog.setContentView(R.layout.dialog_custom_progress);
		customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		customProgressDialog.getWindow().getAttributes().height = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
		customProgressDialog.getWindow().getAttributes().width = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
		return customProgressDialog;
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		Animation animation = AnimationUtils.loadAnimation(context,
				R.anim.dialog_progress_round);
		ImageView imageView = (ImageView)findViewById(R.id.loadingImageView);
		imageView.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				dismiss();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

		});
	}
}
