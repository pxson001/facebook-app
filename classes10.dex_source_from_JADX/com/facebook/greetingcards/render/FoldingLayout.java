package com.facebook.greetingcards.render;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.debug.log.BLog;
import com.facebook.widget.CustomViewUtils;

@TargetApi(12)
/* compiled from: z2wvvvjxrvcxvbn */
public class FoldingLayout extends FrameLayout {
    private static final Class<?> f172a = FoldingLayout.class;
    public View f173b;
    public View f174c;
    public FoldingContentView f175d;
    public FoldingContentView f176e;
    public float f177f;
    public float f178g;
    public float f179h;
    public float f180i;
    public float f181j;
    public float f182k;
    public Rect f183l;
    public Rect f184m;
    private Bitmap f185n;
    private boolean f186o;
    private boolean f187p;

    /* compiled from: z2wvvvjxrvcxvbn */
    public class FoldingContentView extends View {
        private Bitmap f169a;
        private final Rect f170b = new Rect();
        private final Paint f171c = new Paint();

        public FoldingContentView(Context context) {
            super(context);
            this.f171c.setDither(true);
            this.f171c.setFilterBitmap(true);
            setCameraDistance((float) (getResources().getDisplayMetrics().densityDpi * 48));
        }

        final void m193a(Bitmap bitmap, int i) {
            this.f169a = bitmap;
            if (this.f169a == null) {
                this.f170b.set(0, 0, 0, 0);
                return;
            }
            int height = this.f169a.getHeight();
            int width = this.f169a.getWidth();
            if (i == 48) {
                this.f170b.set(0, 0, width, (int) ((((float) height) * 0.5f) + 0.5f));
            } else if (i == 80) {
                this.f170b.set(0, (int) ((((float) height) * 0.5f) - 0.5f), width, height);
            }
        }

        public void draw(Canvas canvas) {
            if (this.f169a != null && !this.f169a.isRecycled()) {
                canvas.drawBitmap(this.f169a, this.f170b, new Rect(0, 0, getWidth(), getHeight()), this.f171c);
            }
        }
    }

    public FoldingLayout(Context context) {
        super(context);
    }

    public final void m196a() {
        this.f186o = true;
    }

    public void setFoldFactor(float f) {
        this.f177f = f;
        m194b();
        if (this.f186o) {
            m195e();
            this.f175d.m193a(this.f185n, 48);
            this.f176e.m193a(this.f185n, 80);
            this.f186o = false;
        }
        float f2 = 1.0f - (this.f181j * (1.0f - f));
        float f3 = 1.0f - (this.f182k * (1.0f - f));
        if (f == 1.0f) {
            this.f173b.setVisibility(4);
            this.f174c.setVisibility(0);
            this.f175d.setVisibility(4);
            this.f176e.setVisibility(4);
        } else if (((double) f) > 0.5d) {
            this.f173b.setVisibility(4);
            this.f174c.setVisibility(4);
            this.f175d.setVisibility(0);
            this.f176e.setVisibility(0);
            this.f175d.setScaleX(f2);
            this.f175d.setScaleY(f3);
            this.f175d.setRotationX(-180.0f * (1.0f - f));
            this.f175d.setTranslationY((-((float) (this.f184m.centerY() - this.f183l.top))) * (1.0f - f));
        } else {
            this.f173b.setVisibility(0);
            this.f174c.setVisibility(4);
            this.f175d.setVisibility(4);
            this.f176e.setVisibility(0);
            this.f173b.setTranslationX(this.f179h * f);
            this.f173b.setTranslationY(this.f180i * f);
            float f4 = 1.0f - (this.f178g * f);
            this.f173b.setScaleX(f4);
            this.f173b.setScaleY(f4);
            this.f173b.setRotationX(180.0f * f);
        }
        this.f176e.setScaleX(f2);
        this.f176e.setScaleY(f3);
        this.f176e.setTranslationY((-this.f180i) * (1.0f - f));
    }

    private void m194b() {
        if (!this.f187p && this.f173b != null && this.f174c != null) {
            int round = Math.round(((float) getHeight()) / 2.0f);
            this.f175d = new FoldingContentView(getContext());
            this.f175d.setLayoutParams(new LayoutParams(-1, round, 48));
            this.f175d.setPivotY(((float) getHeight()) / 2.0f);
            this.f175d.setPivotX(((float) getWidth()) / 2.0f);
            this.f176e = new FoldingContentView(getContext());
            this.f176e.setLayoutParams(new LayoutParams(-1, round, 80));
            this.f176e.setPivotY(0.0f);
            this.f176e.setPivotX(((float) getWidth()) / 2.0f);
            this.f173b.setCameraDistance((float) (getResources().getDisplayMetrics().densityDpi * 48));
            this.f173b.setPivotY(0.0f);
            this.f173b.setPivotX((((float) this.f173b.getWidth()) / 2.0f) + 0.1f);
            addView(this.f176e);
            addView(this.f175d);
            this.f173b.bringToFront();
            this.f183l = CustomViewUtils.a(this.f173b);
            this.f184m = CustomViewUtils.a(this.f174c);
            this.f179h = ((float) this.f184m.centerX()) - ((float) this.f183l.centerX());
            this.f180i = ((float) this.f184m.centerY()) - ((float) this.f183l.top);
            float width = (float) this.f183l.width();
            float width2 = (float) this.f184m.width();
            this.f178g = 1.0f - (width2 / width);
            this.f181j = 1.0f - (width / width2);
            this.f182k = 1.0f - (((float) this.f183l.height()) / (((float) this.f184m.height()) / 2.0f));
            this.f187p = true;
        }
    }

    private void m195e() {
        int width = getWidth();
        int height = getHeight();
        if (this.f185n != null) {
            this.f185n.recycle();
            this.f185n = null;
        }
        if (width != 0 && height != 0) {
            try {
                this.f185n = Bitmap.createBitmap(width, height, Config.RGB_565);
                this.f174c.draw(new Canvas(this.f185n));
            } catch (Throwable e) {
                BLog.b(f172a, "Cached bitmap caused an OutOfMemory", e);
                this.f185n = null;
            }
        }
    }
}
