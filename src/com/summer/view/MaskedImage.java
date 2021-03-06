package com.summer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public abstract class MaskedImage extends ImageView {
	private static final Xfermode MASK_XFERMODE;  
    private Bitmap mask;  
    private Paint paint;
    private Paint p;
    
    static {  
        PorterDuff.Mode localMode = PorterDuff.Mode.DST_IN;  
        MASK_XFERMODE = new PorterDuffXfermode(localMode);  
    }  
    
	public MaskedImage(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MaskedImage(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MaskedImage(Context context) {
		super(context);
	}

	 public abstract Bitmap createMask();  
	  
	    protected void onDraw(Canvas paramCanvas) {  
	        Drawable localDrawable = getDrawable();  
	        if (localDrawable == null)  
	            return;  
	        try {  
	            if (this.paint == null) {  
	                Paint localPaint1 = new Paint();  
	                this.paint = localPaint1;  
	                this.paint.setFilterBitmap(false);  
	                Paint localPaint2 = this.paint;  
	                Xfermode localXfermode1 = MASK_XFERMODE;  
	                @SuppressWarnings("unused")  
	                Xfermode localXfermode2 = localPaint2.setXfermode(localXfermode1);  
	            }  
	            float f1 = getWidth();  
	            float f2 = getHeight();  
	            int i = paramCanvas.saveLayer(0.0F, 0.0F, f1, f2, null, 31);  
	            int j = getWidth();  
	            int k = getHeight();  
	            localDrawable.setBounds(0, 0, j, k);  
	            localDrawable.draw(paramCanvas);  
	            if ((this.mask == null) || (this.mask.isRecycled())) {  
	                Bitmap localBitmap1 = createMask();  
	                this.mask = localBitmap1;  
	            }  
	            Bitmap localBitmap2 = this.mask;  
	            Paint localPaint3 = this.paint;  
	            paramCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint3); 
	            if (p == null)
	            {
	            	p = new Paint(); 
	            }
	            
	            p.setColor(0xffffffff);
	            p.setStrokeWidth(2);
	            p.setStyle(Paint.Style.STROKE);
	  
	            paramCanvas.drawCircle(j/2,k/2,j/2-1,p);
	            paramCanvas.restoreToCount(i);  
	            return;  
	        } catch (Exception localException) {  
	        }  
	    }  
	
}
