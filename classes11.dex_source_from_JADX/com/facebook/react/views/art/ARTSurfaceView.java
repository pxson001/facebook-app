package com.facebook.react.views.art;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import javax.annotation.Nullable;

/* compiled from: SERVICE */
public class ARTSurfaceView extends View {
    @Nullable
    private Bitmap f11426a;

    public ARTSurfaceView(Context context) {
        super(context);
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.f11426a != null) {
            this.f11426a.recycle();
        }
        this.f11426a = bitmap;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11426a != null) {
            canvas.drawBitmap(this.f11426a, 0.0f, 0.0f, null);
        }
    }
}
