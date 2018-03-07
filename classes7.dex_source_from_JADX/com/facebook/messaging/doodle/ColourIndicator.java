package com.facebook.messaging.doodle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: onMetaData */
public class ColourIndicator extends View {
    public Paint f7811a;
    private Bitmap f7812b;
    public Paint f7813c;
    public float f7814d;
    private float f7815e;
    public float f7816f;
    public float f7817g;
    private boolean f7818h;
    private float f7819i;
    private Path f7820j;
    public SpringSystem f7821k;
    private Spring f7822l;
    public boolean f7823m;
    private float f7824n;

    /* compiled from: onMetaData */
    class RevealSpringListener extends SimpleSpringListener {
        final /* synthetic */ ColourIndicator f7808a;
        private float f7809b;
        private float f7810c;

        public RevealSpringListener(ColourIndicator colourIndicator) {
            this.f7808a = colourIndicator;
            this.f7809b = -1.0f;
            this.f7810c = -1.0f;
        }

        public final void m9433a(Spring spring) {
            int i;
            int i2;
            if (this.f7808a.f7823m) {
                i = 255;
                i2 = 230;
            } else {
                if (this.f7809b == -1.0f || this.f7810c == -1.0f) {
                    this.f7809b = ((float) (this.f7808a.getRight() - this.f7808a.getPaddingRight())) - this.f7808a.f7814d;
                    this.f7810c = this.f7808a.f7814d;
                }
                float d = (float) spring.d();
                this.f7808a.f7816f = this.f7808a.f7817g * d;
                this.f7808a.f7814d = this.f7810c + ((1.0f - d) * this.f7809b);
                i = (int) (Math.max(Math.min((double) d, 1.0d), 0.0d) * 255.0d);
                i2 = (int) (Math.max(Math.min((double) d, 1.0d), 0.0d) * 230.0d);
            }
            this.f7808a.f7811a.setAlpha(i2);
            this.f7808a.f7813c.setAlpha(i);
            this.f7808a.invalidate();
        }

        public final void m9434d(Spring spring) {
            super.d(spring);
            this.f7809b = -1.0f;
            this.f7810c = -1.0f;
        }
    }

    private static <T extends View> void m9438a(Class<T> cls, T t) {
        m9439a((Object) t, t.getContext());
    }

    private static void m9439a(Object obj, Context context) {
        ((ColourIndicator) obj).f7821k = SpringSystem.b(FbInjector.get(context));
    }

    public ColourIndicator(Context context) {
        this(context, null);
    }

    public ColourIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColourIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7818h = false;
        this.f7819i = 2.0f;
        this.f7820j = new Path();
        m9438a(ColourIndicator.class, (View) this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColourIndicator);
        this.f7817g = obtainStyledAttributes.getDimension(0, 12.0f);
        obtainStyledAttributes.recycle();
        this.f7812b = BitmapFactory.decodeResource(getResources(), 2130843696);
        this.f7824n = getResources().getDimension(2131427843);
        this.f7811a = new Paint();
        this.f7811a.setAlpha(0);
        this.f7813c = new Paint();
        this.f7813c.setStyle(Style.STROKE);
        this.f7813c.setAntiAlias(true);
        this.f7813c.setStrokeCap(Cap.ROUND);
        this.f7822l = this.f7821k.a().a(SpringConfig.a(100.0d, 7.0d)).a(new RevealSpringListener(this));
    }

    @Inject
    private void m9437a(SpringSystem springSystem) {
        this.f7821k = springSystem;
    }

    public final void m9447a(int i, float f, float f2, float f3) {
        this.f7814d = MathUtil.b(((f - ((float) getPaddingRight())) - ((float) this.f7812b.getWidth())) - this.f7824n, 0.0f, (float) (getRight() - this.f7812b.getWidth()));
        this.f7815e = f2;
        if (this.f7818h) {
            this.f7823m = true;
        } else {
            this.f7822l.l().b(1.0d);
        }
        setColour(i);
        this.f7818h = true;
        this.f7819i = f3;
        this.f7813c.setStrokeWidth(this.f7819i);
        invalidate();
    }

    public final void m9446a() {
        this.f7818h = false;
        this.f7823m = false;
        this.f7822l.l().b(0.0d);
    }

    public void setColour(int i) {
        this.f7813c.setColor(i);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f7812b, this.f7814d, this.f7815e - ((float) (this.f7812b.getHeight() / 2)), this.f7811a);
        m9436a(canvas, this.f7814d + ((float) ((this.f7812b.getWidth() / 5) * 2)), this.f7815e, this.f7813c);
    }

    private void m9436a(Canvas canvas, float f, float f2, Paint paint) {
        this.f7820j.reset();
        this.f7820j.moveTo(f, f2);
        this.f7820j.lineTo(0.5f + f, f2);
        canvas.drawPath(this.f7820j, paint);
    }
}
