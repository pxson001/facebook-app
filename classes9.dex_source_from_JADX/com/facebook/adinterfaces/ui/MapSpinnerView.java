package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.R;

/* compiled from: Unknown queryType seen  */
public class MapSpinnerView extends View {
    private Paint f23152a;
    private RectF f23153b;
    private int f23154c;
    private int f23155d;
    private int f23156e;
    private int f23157f;
    private LinearGradient f23158g;
    private Animation f23159h;
    private State f23160i;

    /* compiled from: Unknown queryType seen  */
    interface StateProcessor {
        void process(MapSpinnerView mapSpinnerView);
    }

    /* compiled from: Unknown queryType seen  */
    public enum State implements StateProcessor {
        LOADING(128) {
            public final void process(MapSpinnerView mapSpinnerView) {
                mapSpinnerView.postInvalidate();
                mapSpinnerView.getBackground().mutate().setAlpha(this.mBackgroundAlpha);
                MapSpinnerView.m25136b(mapSpinnerView);
            }
        },
        IDLE(255) {
            public final void process(MapSpinnerView mapSpinnerView) {
                mapSpinnerView.postInvalidate();
                mapSpinnerView.getBackground().mutate().setAlpha(this.mBackgroundAlpha);
                mapSpinnerView.clearAnimation();
            }
        };
        
        int mBackgroundAlpha;

        public State(int i) {
            this.mBackgroundAlpha = i;
        }
    }

    public MapSpinnerView(Context context) {
        super(context);
        m25132a(context, null);
    }

    public MapSpinnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25132a(context, attributeSet);
    }

    private final void m25132a(Context context, AttributeSet attributeSet) {
        if (VERSION.SDK_INT >= 11) {
            setLayerType(2, null);
        }
        setBackgroundResource(2130837587);
        this.f23157f = getResources().getColor(2131361864);
        this.f23155d = (int) Math.ceil((double) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()));
        this.f23156e = (int) Math.ceil((double) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        m25135b(context, attributeSet);
        this.f23159h = AnimationUtils.loadAnimation(getContext(), 2130968663);
        this.f23152a = new Paint();
        this.f23152a.setStyle(Style.STROKE);
        this.f23152a.setAntiAlias(true);
        this.f23152a.setStrokeWidth((float) this.f23156e);
        this.f23152a.setColor(this.f23157f);
        this.f23154c = (int) Math.ceil(((double) this.f23156e) / 2.0d);
        this.f23153b = new RectF((float) this.f23154c, (float) this.f23154c, (float) this.f23155d, (float) this.f23155d);
        m25131a();
    }

    private void m25135b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MapSpinnerView);
            this.f23157f = obtainStyledAttributes.getColor(0, this.f23157f);
            this.f23156e = (int) obtainStyledAttributes.getDimension(1, (float) this.f23156e);
            this.f23155d = (int) obtainStyledAttributes.getDimension(2, (float) this.f23155d);
            obtainStyledAttributes.recycle();
        }
    }

    private void m25131a() {
        this.f23158g = new LinearGradient(((float) this.f23155d) / 3.0f, ((float) this.f23155d) / 3.0f, ((float) this.f23155d) / 1.4f, ((float) this.f23155d) / 1.4f, this.f23157f, 0, TileMode.CLAMP);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23160i != State.IDLE) {
            m25133a(canvas);
            canvas.drawArc(this.f23153b, 180.0f, 126.000015f, false, this.f23152a);
        }
    }

    private static float getSweepAngle() {
        return 126.000015f;
    }

    private void m25133a(Canvas canvas) {
        this.f23152a.setShader(this.f23158g);
        canvas.drawArc(this.f23153b, 90.0f, 180.0f, false, this.f23152a);
        this.f23152a.setShader(null);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f23155d + (this.f23156e / 2), this.f23155d + (this.f23156e / 2));
    }

    public static void m25136b(MapSpinnerView mapSpinnerView) {
        mapSpinnerView.startAnimation(mapSpinnerView.f23159h);
    }

    public void setState(State state) {
        if (state != this.f23160i) {
            this.f23160i = state;
            this.f23160i.process(this);
        }
    }
}
