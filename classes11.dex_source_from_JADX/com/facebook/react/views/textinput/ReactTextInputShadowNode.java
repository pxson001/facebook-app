package com.facebook.react.views.textinput;

import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.csslayout.Spacing;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: RECENTLY_JOINED_SECTION_HEADER */
public class ReactTextInputShadowNode extends ReactTextShadowNode implements MeasureFunction {
    @Nullable
    private EditText f11613j;
    @Nullable
    private float[] f11614k;
    public int f11615l = -1;

    public ReactTextInputShadowNode() {
        super(false);
        a(this);
    }

    public final void m12093a(ThemedReactContext themedReactContext) {
        super.a(themedReactContext);
        this.f11613j = new EditText(E());
        this.f11613j.setLayoutParams(new LayoutParams(-2, -2));
        d(0, (float) this.f11613j.getPaddingLeft());
        d(1, (float) this.f11613j.getPaddingTop());
        d(2, (float) this.f11613j.getPaddingRight());
        d(3, (float) this.f11613j.getPaddingBottom());
        this.f11614k = m12090a(k_());
    }

    public final void m12092a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
        EditText editText = (EditText) Assertions.b(this.f11613j);
        editText.setTextSize(0, this.f11529h == -1 ? (float) ((int) Math.ceil((double) PixelUtil.b(14.0f))) : (float) this.f11529h);
        this.f11614k = m12090a(k_());
        editText.setPadding((int) Math.ceil((double) k_().a(0)), (int) Math.ceil((double) k_().a(1)), (int) Math.ceil((double) k_().a(2)), (int) Math.ceil((double) k_().a(3)));
        if (this.f11528g != -1) {
            editText.setLines(this.f11528g);
        }
        editText.measure(m12089a(f, cSSMeasureMode), m12089a(f2, cSSMeasureMode2));
        measureOutput.a = (float) editText.getMeasuredWidth();
        measureOutput.b = (float) editText.getMeasuredHeight();
    }

    private static int m12089a(float f, CSSMeasureMode cSSMeasureMode) {
        if (cSSMeasureMode == CSSMeasureMode.EXACTLY) {
            return MeasureSpec.makeMeasureSpec((int) f, 1073741824);
        }
        if (cSSMeasureMode == CSSMeasureMode.AT_MOST) {
            return MeasureSpec.makeMeasureSpec((int) f, Integer.MIN_VALUE);
        }
        return MeasureSpec.makeMeasureSpec(0, 0);
    }

    public final void mo324A() {
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i) {
        this.f11615l = i;
    }

    public final void mo325a(UIViewOperationQueue uIViewOperationQueue) {
        super.mo325a(uIViewOperationQueue);
        if (this.f11614k != null) {
            uIViewOperationQueue.a(this.g, this.f11614k);
            this.f11614k = null;
        }
        if (this.f11615l != -1) {
            uIViewOperationQueue.a(this.g, new ReactTextUpdate(ReactTextShadowNode.m12001a((ReactTextShadowNode) this), this.f11615l, this.f11530i));
        }
    }

    public final void m12095b(int i, float f) {
        super.b(i, f);
        this.f11614k = m12090a(k_());
        m12010x();
    }

    private static float[] m12090a(Spacing spacing) {
        return new float[]{spacing.a(0), spacing.a(1), spacing.a(2), spacing.a(3)};
    }
}
