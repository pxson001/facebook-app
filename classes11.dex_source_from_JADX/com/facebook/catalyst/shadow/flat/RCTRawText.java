package com.facebook.catalyst.shadow.flat;

import android.text.SpannableStringBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: loading_started */
final class RCTRawText extends FlatTextShadowNode {
    @Nullable
    private String f5786h;

    RCTRawText() {
    }

    protected final void mo169c(SpannableStringBuilder spannableStringBuilder) {
        if (this.f5786h != null) {
            spannableStringBuilder.append(this.f5786h);
        }
    }

    protected final void mo167a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        spannableStringBuilder.setSpan(this, i, i2, 17);
    }

    protected final void mo168a(StateBuilder stateBuilder) {
    }

    @ReactProp(name = "text")
    public final void setText(@Nullable String str) {
        this.f5786h = str;
        mo172b(true);
    }
}
