package com.facebook.adinterfaces;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.WrappedViewException;

/* compiled from: aa7c511a8b23f322c766e94141363255 */
public class FBStepperWithLabel extends LinearLayoutCompat implements OnClickListener {
    private FbTextView f21546a;
    private GlyphView f21547b;
    private GlyphView f21548c;
    private StepperCallback f21549d;
    private int f21550e = 0;
    public int f21551f = Integer.MIN_VALUE;
    public int f21552g = Integer.MAX_VALUE;
    private int f21553h;
    private int f21554i;

    /* compiled from: aa7c511a8b23f322c766e94141363255 */
    public interface StepperCallback {
        String mo944a(int i);
    }

    /* compiled from: aa7c511a8b23f322c766e94141363255 */
    class C24951 implements StepperCallback {
        final /* synthetic */ FBStepperWithLabel f21545a;

        C24951(FBStepperWithLabel fBStepperWithLabel) {
            this.f21545a = fBStepperWithLabel;
        }

        public final String mo944a(int i) {
            return Integer.toString(i);
        }
    }

    public FBStepperWithLabel(Context context) {
        super(context, null);
        m22527a(null, null);
    }

    public FBStepperWithLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22527a(context, attributeSet);
    }

    public FBStepperWithLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m22527a(context, attributeSet);
    }

    protected void setContentView(int i) {
        try {
            LayoutInflater.from(getContext()).inflate(i, this);
        } catch (Throwable e) {
            WrappedViewException.a(this, i, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, i, e2);
        }
    }

    private <T extends View> T m22524a(int i) {
        return FindViewUtil.b(this, i);
    }

    private void m22527a(Context context, AttributeSet attributeSet) {
        setContentView(2130907232);
        setOrientation(0);
        this.f21546a = (FbTextView) FindViewUtil.b(this, 2131567646);
        this.f21547b = (GlyphView) FindViewUtil.b(this, 2131567648);
        this.f21548c = (GlyphView) FindViewUtil.b(this, 2131567647);
        m22530b(context, attributeSet);
        m22529b(this.f21550e, this.f21551f, this.f21552g);
        this.f21547b.setOnClickListener(this);
        this.f21548c.setOnClickListener(this);
        this.f21546a.setText(getStepperCallback().mo944a(this.f21550e));
        if (this.f21553h != 0) {
            this.f21547b.setContentDescription(getResources().getString(this.f21553h));
        }
        if (this.f21554i != 0) {
            this.f21548c.setContentDescription(getResources().getString(this.f21554i));
        }
    }

    private void m22530b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.StepperWithLabel, 0, 0);
            this.f21550e = obtainStyledAttributes.getInteger(2, 0);
            this.f21551f = obtainStyledAttributes.getInteger(0, Integer.MIN_VALUE);
            this.f21552g = obtainStyledAttributes.getInteger(1, Integer.MAX_VALUE);
            m22526a(obtainStyledAttributes.getResourceId(3, 0), obtainStyledAttributes.getResourceId(4, 0), obtainStyledAttributes.getColorStateList(5));
            int color = obtainStyledAttributes.getColor(6, 0);
            if (color != 0) {
                this.f21546a.setTextColor(color);
            }
            this.f21553h = obtainStyledAttributes.getResourceId(10, 0);
            this.f21554i = obtainStyledAttributes.getResourceId(9, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private void m22526a(int i, int i2, ColorStateList colorStateList) {
        if (i != 0) {
            this.f21547b.setImageResource(i);
        }
        if (i2 != 0) {
            this.f21548c.setImageResource(i2);
        }
        if (colorStateList != null) {
            this.f21547b.setGlyphColor(colorStateList);
            this.f21548c.setGlyphColor(colorStateList);
        }
    }

    public void setIncrementImageResource(int i) {
        this.f21547b.setImageResource(i);
    }

    public void setDecrementImageResource(int i) {
        this.f21548c.setImageResource(i);
    }

    public void setStepperControlColorStateList(ColorStateList colorStateList) {
        this.f21547b.setGlyphColor(colorStateList);
        this.f21548c.setGlyphColor(colorStateList);
    }

    public void setLabelTextColor(int i) {
        this.f21546a.setTextColor(i);
    }

    public int getStepMax() {
        return this.f21552g;
    }

    public int getStepMin() {
        return this.f21551f;
    }

    public void setStep(int i) {
        m22525a(i, this.f21551f, this.f21552g);
    }

    public int getStep() {
        return this.f21550e;
    }

    private void m22525a(int i, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        m22529b(i, i2, i3);
        this.f21550e = i;
        this.f21551f = i2;
        this.f21552g = i3;
        this.f21546a.setText(getStepperCallback().mo944a(this.f21550e));
        GlyphView glyphView = this.f21547b;
        if (this.f21550e < this.f21552g) {
            z = true;
        } else {
            z = false;
        }
        glyphView.setEnabled(z);
        GlyphView glyphView2 = this.f21548c;
        if (this.f21550e <= this.f21551f) {
            z2 = false;
        }
        glyphView2.setEnabled(z2);
    }

    public void setStepperCallback(StepperCallback stepperCallback) {
        this.f21549d = stepperCallback;
        this.f21546a.setText(getStepperCallback().mo944a(this.f21550e));
    }

    private void m22529b(int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("step %d is our of bounds [%d,%d]", Integer.valueOf(i), Integer.valueOf(this.f21551f), Integer.valueOf(this.f21552g)));
        }
    }

    private StepperCallback getStepperCallback() {
        if (this.f21549d == null) {
            this.f21549d = getDefaultStepperCallback();
        }
        return this.f21549d;
    }

    private StepperCallback getDefaultStepperCallback() {
        return new C24951(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1023529511);
        if (view.getId() == 2131567648) {
            m22523a();
            Logger.a(2, EntryType.UI_INPUT_END, 983391639, a);
            return;
        }
        m22528b();
        LogUtils.a(1456971030, a);
    }

    private int m22523a() {
        if (this.f21550e == this.f21552g) {
            getStepperCallback();
            return this.f21550e;
        }
        this.f21548c.setEnabled(this.f21550e >= this.f21551f);
        if (this.f21550e == this.f21552g - 1) {
            this.f21547b.setEnabled(false);
        }
        this.f21550e++;
        this.f21546a.setText(getStepperCallback().mo944a(this.f21550e));
        return this.f21550e;
    }

    private int m22528b() {
        if (this.f21550e == this.f21551f) {
            getStepperCallback();
            return this.f21550e;
        }
        this.f21547b.setEnabled(this.f21550e <= this.f21552g);
        if (this.f21550e == this.f21551f + 1) {
            this.f21548c.setEnabled(false);
        }
        this.f21550e--;
        this.f21546a.setText(getStepperCallback().mo944a(this.f21550e));
        return this.f21550e;
    }
}
