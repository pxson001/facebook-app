package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: Requested position is  */
public class ProgressBarShadowNode extends LayoutShadowNode implements MeasureFunction {
    public String f11488g = "Normal";
    private final SparseIntArray f11489h = new SparseIntArray();
    private final SparseIntArray f11490i = new SparseIntArray();
    private final Set<Integer> f11491j = new HashSet();

    public ProgressBarShadowNode() {
        a(this);
    }

    @Nullable
    private String m11911O() {
        return this.f11488g;
    }

    public final void m11912a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
        int a = ReactProgressBarViewManager.m11915a(this.f11488g);
        if (!this.f11491j.contains(Integer.valueOf(a))) {
            ProgressBar a2 = ReactProgressBarViewManager.m11916a(E(), a);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(-2, 0);
            a2.measure(makeMeasureSpec, makeMeasureSpec);
            this.f11489h.put(a, a2.getMeasuredHeight());
            this.f11490i.put(a, a2.getMeasuredWidth());
            this.f11491j.add(Integer.valueOf(a));
        }
        measureOutput.b = (float) this.f11489h.get(a);
        measureOutput.a = (float) this.f11490i.get(a);
    }

    @ReactProp(name = "styleAttr")
    public void setStyle(@Nullable String str) {
        if (str == null) {
            str = "Normal";
        }
        this.f11488g = str;
    }
}
