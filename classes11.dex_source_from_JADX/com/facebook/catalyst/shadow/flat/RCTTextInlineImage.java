package com.facebook.catalyst.shadow.flat;

import android.text.SpannableStringBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: loadMoreFrames failed */
class RCTTextInlineImage extends FlatTextShadowNode {
    private InlineImageSpanWithPipeline f5798h = new InlineImageSpanWithPipeline();

    RCTTextInlineImage() {
    }

    public final void m7158e(float f) {
        super.e(f);
        if (this.f5798h.f5761e != f) {
            aj().f5761e = f;
            mo172b(true);
        }
    }

    public final void m7159f(float f) {
        super.f(f);
        if (this.f5798h.f5762f != f) {
            aj().f5762f = f;
            mo172b(true);
        }
    }

    protected final void mo169c(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append("I");
    }

    protected final void mo167a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.f5798h.f5763g = true;
        spannableStringBuilder.setSpan(this.f5798h, i, i2, 17);
    }

    protected final void mo168a(StateBuilder stateBuilder) {
        stateBuilder.m7236a(this.f5798h);
    }

    @ReactProp(name = "src")
    public void setSource(@Nullable String str) {
        InlineImageSpanWithPipeline aj = aj();
        ImageRequest a = ImageRequestHelper.m7087a(E(), str);
        if (a == null) {
            aj.f5759c = null;
        } else {
            aj.f5759c = new PipelineRequestHelper(a);
        }
    }

    private InlineImageSpanWithPipeline aj() {
        if (this.f5798h.f5763g) {
            InlineImageSpanWithPipeline inlineImageSpanWithPipeline = this.f5798h;
            this.f5798h = new InlineImageSpanWithPipeline(inlineImageSpanWithPipeline.f5759c, inlineImageSpanWithPipeline.f5761e, inlineImageSpanWithPipeline.f5762f);
        }
        return this.f5798h;
    }
}
