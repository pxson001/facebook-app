package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Arrays;

/* compiled from: friends/requests_tab */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    @VisibleForTesting
    Type f23032a = Type.OVERLAY_COLOR;
    @VisibleForTesting
    final float[] f23033c = new float[8];
    @VisibleForTesting
    final Paint f23034d = new Paint(1);
    private final float[] f23035e = new float[8];
    private boolean f23036f = false;
    private float f23037g = 0.0f;
    private int f23038h = 0;
    private int f23039i = 0;
    private float f23040j = 0.0f;
    private final Path f23041k = new Path();
    private final Path f23042l = new Path();
    private final RectF f23043m = new RectF();

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) Preconditions.a(drawable));
    }

    public final void mo3382a(boolean z) {
        this.f23036f = z;
        m31159b();
        invalidateSelf();
    }

    public final void mo3380a(float f) {
        Arrays.fill(this.f23035e, f);
        m31159b();
        invalidateSelf();
    }

    public final void mo3383a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f23035e, 0.0f);
        } else {
            boolean z;
            if (fArr.length == 8) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.a(z, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f23035e, 0, 8);
        }
        m31159b();
        invalidateSelf();
    }

    public final void m31161a(int i) {
        this.f23039i = i;
        invalidateSelf();
    }

    public final void mo3381a(int i, float f) {
        this.f23038h = i;
        this.f23037g = f;
        m31159b();
        invalidateSelf();
    }

    public final void mo3384b(float f) {
        this.f23040j = f;
        m31159b();
        invalidateSelf();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m31159b();
    }

    private void m31159b() {
        this.f23041k.reset();
        this.f23042l.reset();
        this.f23043m.set(getBounds());
        this.f23043m.inset(this.f23040j, this.f23040j);
        if (this.f23036f) {
            this.f23041k.addCircle(this.f23043m.centerX(), this.f23043m.centerY(), Math.min(this.f23043m.width(), this.f23043m.height()) / 2.0f, Direction.CW);
        } else {
            this.f23041k.addRoundRect(this.f23043m, this.f23035e, Direction.CW);
        }
        this.f23043m.inset(-this.f23040j, -this.f23040j);
        this.f23043m.inset(this.f23037g / 2.0f, this.f23037g / 2.0f);
        if (this.f23036f) {
            this.f23042l.addCircle(this.f23043m.centerX(), this.f23043m.centerY(), Math.min(this.f23043m.width(), this.f23043m.height()) / 2.0f, Direction.CW);
        } else {
            for (int i = 0; i < this.f23033c.length; i++) {
                this.f23033c[i] = (this.f23035e[i] + this.f23040j) - (this.f23037g / 2.0f);
            }
            this.f23042l.addRoundRect(this.f23043m, this.f23033c, Direction.CW);
        }
        this.f23043m.inset((-this.f23037g) / 2.0f, (-this.f23037g) / 2.0f);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (1.a[this.f23032a.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                int save = canvas.save();
                this.f23041k.setFillType(FillType.EVEN_ODD);
                canvas.clipPath(this.f23041k);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                super.draw(canvas);
                this.f23034d.setColor(this.f23039i);
                this.f23034d.setStyle(Style.FILL);
                this.f23041k.setFillType(FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.f23041k, this.f23034d);
                if (this.f23036f) {
                    float width = (((float) (bounds.width() - bounds.height())) + this.f23037g) / 2.0f;
                    float height = (((float) (bounds.height() - bounds.width())) + this.f23037g) / 2.0f;
                    if (width > 0.0f) {
                        canvas.drawRect((float) bounds.left, (float) bounds.top, ((float) bounds.left) + width, (float) bounds.bottom, this.f23034d);
                        canvas.drawRect(((float) bounds.right) - width, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f23034d);
                    }
                    if (height > 0.0f) {
                        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, ((float) bounds.top) + height, this.f23034d);
                        canvas.drawRect((float) bounds.left, ((float) bounds.bottom) - height, (float) bounds.right, (float) bounds.bottom, this.f23034d);
                        break;
                    }
                }
                break;
        }
        if (this.f23038h != 0) {
            this.f23034d.setStyle(Style.STROKE);
            this.f23034d.setColor(this.f23038h);
            this.f23034d.setStrokeWidth(this.f23037g);
            this.f23041k.setFillType(FillType.EVEN_ODD);
            canvas.drawPath(this.f23042l, this.f23034d);
        }
    }
}
