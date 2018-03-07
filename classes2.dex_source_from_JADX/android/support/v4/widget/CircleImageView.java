package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* compiled from: nux_last_shown_time_ms */
public class CircleImageView extends ImageView {
    public AnimationListener f11717a;
    public int f11718b;

    /* compiled from: nux_last_shown_time_ms */
    class OvalShadow extends OvalShape {
        final /* synthetic */ CircleImageView f11719a;
        private RadialGradient f11720b;
        private Paint f11721c = new Paint();
        private int f11722d;

        public OvalShadow(CircleImageView circleImageView, int i, int i2) {
            this.f11719a = circleImageView;
            circleImageView.f11718b = i;
            this.f11722d = i2;
            this.f11720b = new RadialGradient((float) (this.f11722d / 2), (float) (this.f11722d / 2), (float) circleImageView.f11718b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f11721c.setShader(this.f11720b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f11719a.getWidth();
            int height = this.f11719a.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f11722d / 2) + this.f11719a.f11718b), this.f11721c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f11722d / 2), paint);
        }
    }

    public CircleImageView(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f11718b = (int) (3.5f * f2);
        if (m16996a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.m10965g((View) this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new OvalShadow(this, this.f11718b, i2));
            ViewCompat.m10937a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f11718b, (float) i4, (float) i3, 503316480);
            int i5 = this.f11718b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private static boolean m16996a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m16996a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f11718b * 2), getMeasuredHeight() + (this.f11718b * 2));
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f11717a != null) {
            this.f11717a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f11717a != null) {
            this.f11717a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
