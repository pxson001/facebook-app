package com.facebook.catalyst.shadow.flat;

import android.text.Layout;
import android.text.Spanned;
import javax.annotation.Nullable;

/* compiled from: lead_state */
public final class TextNodeRegion extends NodeRegion {
    @Nullable
    public Layout f5827i;

    TextNodeRegion(float f, float f2, float f3, float f4, int i, boolean z, @Nullable Layout layout) {
        super(f, f2, f3, f4, i, z);
        this.f5827i = layout;
    }

    public final void m7241a(Layout layout) {
        this.f5827i = layout;
    }

    final int mo178b(float f, float f2) {
        if (this.f5827i != null) {
            int round = Math.round(f2 - this.f5774d);
            if (round >= this.f5827i.getLineTop(0) && round < this.f5827i.getLineBottom(this.f5827i.getLineCount() - 1)) {
                float round2 = (float) Math.round(f - this.f5773c);
                round = this.f5827i.getLineForVertical(round);
                if (this.f5827i.getLineLeft(round) <= round2 && round2 <= this.f5827i.getLineRight(round)) {
                    int offsetForHorizontal = this.f5827i.getOffsetForHorizontal(round, round2);
                    RCTRawText[] rCTRawTextArr = (RCTRawText[]) ((Spanned) this.f5827i.getText()).getSpans(offsetForHorizontal, offsetForHorizontal, RCTRawText.class);
                    if (rCTRawTextArr.length != 0) {
                        return rCTRawTextArr[0].g;
                    }
                }
            }
        }
        return super.mo178b(f, f2);
    }
}
