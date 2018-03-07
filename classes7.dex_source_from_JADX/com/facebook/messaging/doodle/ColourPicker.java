package com.facebook.messaging.doodle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.R;
import com.facebook.common.util.MathUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: onLoadingStart */
public class ColourPicker extends View {
    private static final int[] f7826a = new int[]{Color.rgb(0, 0, 0), Color.rgb(128, 128, 128), Color.rgb(255, 255, 255), Color.HSVToColor(new float[]{0.0f, 1.0f, 1.0f}), Color.rgb(116, 68, 21), Color.HSVToColor(new float[]{30.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{60.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{90.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{120.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{150.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{180.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{210.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{240.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{270.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{300.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{330.0f, 1.0f, 1.0f}), Color.HSVToColor(new float[]{360.0f, 1.0f, 1.0f})};
    private Paint f7827b;
    public OnColourPickerInteractionListener f7828c;
    public int f7829d;
    private float f7830e;
    private float f7831f;
    private ColourUtil f7832g;
    private RectF f7833h;
    private boolean f7834i;

    /* compiled from: onLoadingStart */
    class ColourUtil {
        final /* synthetic */ ColourPicker f7825a;

        public ColourUtil(ColourPicker colourPicker) {
            this.f7825a = colourPicker;
        }

        public static int m9448a(int i, int i2, float f) {
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            return Color.rgb(red + ((int) (((float) (Color.red(i2) - red)) * f)), green + ((int) (((float) (Color.green(i2) - green)) * f)), blue + ((int) (((float) (Color.blue(i2) - blue)) * f)));
        }
    }

    /* compiled from: onLoadingStart */
    public interface OnColourPickerInteractionListener {
        void mo544a(int i);

        void mo545a(int i, float f, float f2, float f3);
    }

    public ColourPicker(Context context) {
        this(context, null);
    }

    public ColourPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColourPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColourPicker);
        this.f7829d = obtainStyledAttributes.getColor(0, getResources().getColor(2131362241));
        this.f7830e = obtainStyledAttributes.getDimension(2, 3.0f);
        this.f7831f = obtainStyledAttributes.getDimension(3, 15.0f);
        this.f7834i = obtainStyledAttributes.getBoolean(4, false);
        this.f7832g = new ColourUtil(this);
        obtainStyledAttributes.recycle();
        this.f7833h = new RectF();
        this.f7827b = new Paint();
        this.f7827b.setAntiAlias(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7827b.setShader(null);
        if (z) {
            this.f7833h = new RectF((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7827b.getShader() == null) {
            this.f7827b.setShader(new LinearGradient(this.f7833h.left, this.f7833h.top, this.f7833h.width(), this.f7833h.height(), f7826a, null, TileMode.CLAMP));
        }
        if (this.f7834i) {
            canvas.drawRect(this.f7833h, this.f7827b);
        } else {
            canvas.drawRoundRect(this.f7833h, this.f7833h.width() / 2.0f, this.f7833h.width() / 2.0f, this.f7827b);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 810743570);
        if (this.f7828c == null) {
            Logger.a(2, EntryType.UI_INPUT_END, 1312584589, a);
            return false;
        }
        float b = MathUtil.b(motionEvent.getY(), 0.0f, (float) getHeight());
        float b2 = MathUtil.b(motionEvent.getRawX(), 0.0f, (float) (getLeft() + getPaddingLeft()));
        float b3 = MathUtil.b(motionEvent.getY(), (float) getPaddingTop(), (float) (getHeight() - getPaddingBottom()));
        if (motionEvent.getAction() == 0) {
            this.f7829d = m9451a(b);
            this.f7828c.mo545a(this.f7829d, b2, b3, this.f7830e);
        } else if (motionEvent.getAction() == 2) {
            this.f7829d = m9451a(b);
            b = (float) getRight();
            b = MathUtil.b((b - motionEvent.getRawX()) / b, 0.0f, 1.0f);
            this.f7828c.mo545a(this.f7829d, b2, b3, (b * (this.f7831f - this.f7830e)) + this.f7830e);
        } else if (motionEvent.getAction() == 1) {
            this.f7829d = m9451a(b);
            this.f7828c.mo544a(this.f7829d);
        }
        LogUtils.a(470272431, a);
        return true;
    }

    private int m9451a(float f) {
        float b = MathUtil.b(f - this.f7833h.top, 0.0f, this.f7833h.height());
        int height = ((int) this.f7833h.height()) / (f7826a.length - 1);
        int i = (int) (b / ((float) height));
        return ColourUtil.m9448a(f7826a[Math.min(i, f7826a.length - 1)], f7826a[Math.max(0, Math.min(i + 1, f7826a.length - 1))], (b % ((float) height)) / ((float) height));
    }

    public int getCurrentColour() {
        return this.f7829d;
    }

    public void setOnColourPickerInteractionListener(OnColourPickerInteractionListener onColourPickerInteractionListener) {
        this.f7828c = onColourPickerInteractionListener;
    }
}
