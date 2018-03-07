package com.facebook.timeline.refresher.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: unheld_wakelock_details */
public class ProfileRefresherStepProgressBar extends View {
    private final Paint f1103a;
    private final Paint f1104b;
    private final Paint f1105c;
    private float f1106d;
    private int f1107e;
    public float f1108f;
    private int f1109g;
    private int f1110h;
    private int f1111i;
    public float f1112j;

    /* compiled from: unheld_wakelock_details */
    class C01101 implements AnimatorUpdateListener {
        final /* synthetic */ ProfileRefresherStepProgressBar f1102a;

        C01101(ProfileRefresherStepProgressBar profileRefresherStepProgressBar) {
            this.f1102a = profileRefresherStepProgressBar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1102a.f1112j = this.f1102a.f1108f * valueAnimator.getAnimatedFraction();
            this.f1102a.invalidate();
        }
    }

    public ProfileRefresherStepProgressBar(Context context) {
        this(context, null);
    }

    public ProfileRefresherStepProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1103a = new Paint(1);
        this.f1104b = new Paint(1);
        this.f1105c = new Paint(1);
        this.f1111i = -1;
        m1187a();
    }

    private void m1187a() {
        setWillNotDraw(false);
        this.f1103a.setColor(getResources().getColor(2131361939));
        this.f1104b.setColor(getResources().getColor(2131361917));
        this.f1105c.setColor(getResources().getColor(2131361920));
    }

    protected void onMeasure(int i, int i2) {
        this.f1106d = (float) getResources().getDimensionPixelSize(2131429926);
        this.f1109g = getResources().getDimensionPixelSize(2131429928);
        this.f1108f = (this.f1106d - ((float) (this.f1109g * (this.f1110h - 1)))) / ((float) this.f1110h);
        this.f1106d = (this.f1108f * ((float) this.f1110h)) + ((float) (this.f1109g * (this.f1110h - 1)));
        this.f1107e = getResources().getDimensionPixelSize(2131429927);
        setMeasuredDimension((int) this.f1106d, this.f1107e);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1110h >= 2) {
            if (this.f1111i > 0) {
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (((float) this.f1111i) * this.f1108f) + ((float) ((this.f1111i - 1) * this.f1109g)), (float) this.f1107e), (float) (this.f1107e / 2), (float) (this.f1107e / 2), this.f1104b);
            }
            float f = this.f1111i == 0 ? 0.0f : (((float) this.f1111i) * (this.f1108f + ((float) this.f1109g))) - ((float) (this.f1107e / 2));
            canvas.drawRoundRect(new RectF(f, 0.0f, this.f1106d, (float) this.f1107e), (float) (this.f1107e / 2), (float) (this.f1107e / 2), this.f1103a);
            canvas.drawRoundRect(new RectF(f, 0.0f, this.f1112j + f, (float) this.f1107e), (float) (this.f1107e / 2), (float) (this.f1107e / 2), this.f1104b);
            for (int i = 1; i < this.f1110h; i++) {
                float f2 = ((((float) i) * this.f1108f) + ((float) ((i - 1) * this.f1109g))) - ((float) this.f1107e);
                canvas.drawRoundRect(new RectF(f2, 0.0f, (((float) this.f1109g) + f2) + ((float) this.f1107e), (float) this.f1107e), (float) (this.f1107e / 2), (float) (this.f1107e / 2), this.f1105c);
            }
        }
    }

    public final void m1188a(int i, int i2) {
        this.f1110h = i2;
        if (i != this.f1111i) {
            this.f1111i = i;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.2f, 0.5f, 1.0f});
            ofFloat.addUpdateListener(new C01101(this));
            ofFloat.setDuration(800);
            ofFloat.start();
            invalidate();
        }
    }
}
