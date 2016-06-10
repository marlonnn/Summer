package com.summer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BorderImageView extends ImageView {
	
	private Paint paint;
	private int color;
	private Rect rec;

	public BorderImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		color = Color.parseColor("#FFFFFF");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		try {
	        Drawable localDrawable = getDrawable();  
	        if (localDrawable == null) 
	        {
	        	return;
	        }
	        else
	        {
				if (paint == null)
				{
					paint = new Paint();
				}
				paint.setColor(color);
				paint.setStyle(Paint.Style.STROKE);
				canvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), paint);
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
