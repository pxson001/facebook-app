package com.facebook.catalyst.shadow.flat;

import android.text.SpannableStringBuilder;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.csslayout.Spacing;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextUpdate;
import javax.annotation.Nullable;

/* compiled from: lnb */
public class RCTTextInput extends RCTVirtualText implements AndroidView, MeasureFunction {
    @Nullable
    private String f5799h;
    public int f5800i = -1;
    private boolean f5801j = false;
    private int f5802k = -1;
    @Nullable
    private EditText f5803l;

    public RCTTextInput() {
        ae();
        a(this);
    }

    protected final void mo172b(boolean z) {
        super.mo172b(z);
        x();
    }

    public final void m7168a(ThemedReactContext themedReactContext) {
        super.a(themedReactContext);
        this.f5803l = new EditText(themedReactContext);
        this.f5803l.setLayoutParams(new LayoutParams(-2, -2));
        d(0, (float) this.f5803l.getPaddingLeft());
        d(1, (float) this.f5803l.getPaddingTop());
        d(2, (float) this.f5803l.getPaddingRight());
        d(3, (float) this.f5803l.getPaddingBottom());
    }

    public final void m7167a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
        EditText editText = (EditText) Assertions.b(this.f5803l);
        int ak = ak();
        measureOutput.a = f;
        editText.setTextSize(0, ak == -1 ? (float) ((int) Math.ceil((double) PixelUtil.b(14.0f))) : (float) ak);
        Spacing k_ = k_();
        editText.setPadding((int) Math.ceil((double) k_.a(0)), (int) Math.ceil((double) k_.a(1)), (int) Math.ceil((double) k_.a(2)), (int) Math.ceil((double) k_.a(3)));
        if (this.f5802k != -1) {
            editText.setLines(this.f5802k);
        }
        editText.measure(0, 0);
        measureOutput.b = (float) editText.getMeasuredHeight();
    }

    public final boolean mo173s() {
        return false;
    }

    public final boolean m7175t() {
        return true;
    }

    public void setBackgroundColor(int i) {
    }

    public final void m7169a(UIViewOperationQueue uIViewOperationQueue) {
        super.a(uIViewOperationQueue);
        if (this.f5800i != -1) {
            uIViewOperationQueue.a(this.g, new ReactTextUpdate(am(), this.f5800i, false));
        }
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i) {
        this.f5800i = i;
    }

    @ReactProp(c = Integer.MAX_VALUE, name = "numberOfLines")
    public void setNumberOfLines(int i) {
        this.f5802k = i;
        mo172b(true);
    }

    @ReactProp(name = "text")
    public void setText(@Nullable String str) {
        this.f5799h = str;
        mo172b(true);
    }

    public final void m7170b(int i, float f) {
        if (k_().a(i, f)) {
            this.f5801j = true;
            f();
        }
    }

    public final boolean oa_() {
        return this.f5801j;
    }

    public final void mo162c() {
        this.f5801j = false;
    }

    final boolean ai() {
        return true;
    }

    protected final void mo169c(SpannableStringBuilder spannableStringBuilder) {
        if (this.f5799h != null) {
            spannableStringBuilder.append(this.f5799h);
        }
        super.mo169c(spannableStringBuilder);
    }

    public final boolean nZ_() {
        return false;
    }
}
