package com.facebook.widget.images;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import javax.annotation.Nullable;

/* compiled from: outgoing_payment_message */
public class PathFittingBitmapShaderFactory extends ShaderFactory {
    private final BitmapShader f5760a;
    private final int f5761b;
    private final int f5762c;
    private final Matrix f5763d = new Matrix();
    private final RectF f5764e = new RectF();
    @Nullable
    private PathBoundShape f5765f;

    public PathFittingBitmapShaderFactory(@Nullable PathBoundShape pathBoundShape, Bitmap bitmap) {
        this.f5765f = pathBoundShape;
        this.f5760a = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        this.f5761b = bitmap.getWidth();
        this.f5762c = bitmap.getHeight();
    }

    public Shader resize(int i, int i2) {
        float width;
        float height;
        float f;
        if (this.f5765f != null) {
            this.f5765f.a(this.f5764e);
            width = this.f5764e.width();
            height = this.f5764e.height();
        } else {
            width = (float) i;
            height = (float) i2;
        }
        if (((float) this.f5761b) / ((float) this.f5762c) >= width / height) {
            f = height / ((float) this.f5762c);
        } else {
            f = width / ((float) this.f5762c);
        }
        this.f5763d.reset();
        this.f5763d.postTranslate((float) ((-this.f5761b) / 2), (float) ((-this.f5762c) / 2));
        this.f5763d.postScale(f, f);
        this.f5763d.postTranslate((width / 2.0f) + this.f5764e.left, (height / 2.0f) + this.f5764e.top);
        this.f5760a.setLocalMatrix(this.f5763d);
        return this.f5760a;
    }
}
