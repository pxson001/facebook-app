package com.facebook.backstage.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

/* compiled from: removed_tids */
public class ScalingToggleableEditText extends ToggleableEditText {
    public ScaleGestureDetector f5506c;
    public float f5507d;
    public boolean f5508e;

    /* compiled from: removed_tids */
    class C05831 implements OnTouchListener {
        final /* synthetic */ ScalingToggleableEditText f5500a;

        C05831(ScalingToggleableEditText scalingToggleableEditText) {
            this.f5500a = scalingToggleableEditText;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f5500a.f5508e = false;
            }
            if (!this.f5500a.f5508e && motionEvent.getAction() == 1) {
                this.f5500a.f5504b.onTouch(view, motionEvent);
            }
            this.f5500a.f5506c.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* compiled from: removed_tids */
    class TextScaleGestureDetector extends SimpleOnScaleGestureListener {
        final /* synthetic */ ScalingToggleableEditText f5501a;
        private float f5502b;

        public TextScaleGestureDetector(ScalingToggleableEditText scalingToggleableEditText) {
            this.f5501a = scalingToggleableEditText;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ViewParent parent = this.f5501a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.f5501a.f5508e = true;
            this.f5502b = scaleGestureDetector.getCurrentSpan();
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan();
            if (Math.abs(currentSpan - this.f5502b) > 0.001f) {
                this.f5501a.setTextSize(Math.min(100.0f, Math.max(4.0f, (((currentSpan - this.f5502b) / ((float) this.f5501a.getWidth())) * this.f5501a.f5507d) + this.f5501a.f5507d)));
            }
            this.f5502b = currentSpan;
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            ViewParent parent = this.f5501a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public ScalingToggleableEditText(Context context) {
        this(context, null);
    }

    public ScalingToggleableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalingToggleableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5506c = new ScaleGestureDetector(getContext(), new TextScaleGestureDetector(this));
        setOnTouchListener(new C05831(this));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m5742d();
    }

    private void m5742d() {
        int height = getHeight();
        int lineBounds = getLineBounds(getLineCount() - 1, new Rect());
        float textSize = getTextSize() / getResources().getDisplayMetrics().scaledDensity;
        if (textSize < 4.0f) {
            this.f5507d = 4.0f;
            setTextSize(this.f5507d);
        } else if (lineBounds <= height || textSize <= 4.0f) {
            this.f5507d = textSize;
        } else {
            this.f5507d = textSize - 2.0f;
            setTextSize(this.f5507d);
        }
    }
}
