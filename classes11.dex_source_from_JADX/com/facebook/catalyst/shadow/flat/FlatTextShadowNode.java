package com.facebook.catalyst.shadow.flat;

import android.text.SpannableStringBuilder;
import com.facebook.react.uimanager.ReactShadowNode;

/* compiled from: look_now_permalink_load_failure */
public abstract class FlatTextShadowNode extends FlatShadowNode {
    private int f5689h;
    private int f5690i;

    protected abstract void mo167a(SpannableStringBuilder spannableStringBuilder, int i, int i2);

    protected abstract void mo168a(StateBuilder stateBuilder);

    protected abstract void mo169c(SpannableStringBuilder spannableStringBuilder);

    FlatTextShadowNode() {
    }

    protected void mo172b(boolean z) {
        ReactShadowNode D = D();
        if (D instanceof FlatTextShadowNode) {
            ((FlatTextShadowNode) D).mo172b(z);
        }
    }

    public boolean mo173s() {
        return true;
    }

    final void m7015a(SpannableStringBuilder spannableStringBuilder) {
        this.f5689h = spannableStringBuilder.length();
        mo169c(spannableStringBuilder);
        this.f5690i = spannableStringBuilder.length();
    }

    boolean ai() {
        return false;
    }

    final void m7018b(SpannableStringBuilder spannableStringBuilder) {
        if (this.f5689h != this.f5690i || ai()) {
            mo167a(spannableStringBuilder, this.f5689h, this.f5690i);
        }
    }
}
