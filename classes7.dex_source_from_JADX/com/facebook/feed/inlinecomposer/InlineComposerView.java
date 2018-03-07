package com.facebook.feed.inlinecomposer;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.fbui.widget.text.ImageWithTextView;

@Deprecated
/* compiled from: android_pma_ban_actions */
public class InlineComposerView extends SegmentedLinearLayout {
    public static final CallerContext f19222a = CallerContext.a(InlineComposerView.class, "inline_composer");
    public final ImageWithTextView f19223b = ((ImageWithTextView) a(2131561933));
    public final GlyphWithTextView f19224c = ((GlyphWithTextView) a(2131561934));
    public final ImageWithTextView f19225d = ((ImageWithTextView) a(2131561935));
    public final ImageWithTextView[] f19226e = new ImageWithTextView[]{this.f19223b, this.f19224c, this.f19225d};
    public final FbDraweeView f19227f = ((FbDraweeView) a(2131561926));
    public final TextView f19228g = ((TextView) a(2131561928));

    public InlineComposerView(Context context) {
        super(context, null);
        setContentView(2130904307);
        setOrientation(1);
        for (ImageWithTextView imageScale : this.f19226e) {
            imageScale.setImageScale(0.8f);
        }
        setShowSegmentedDividers(2);
        setSegmentedDividerThickness(getResources().getDimensionPixelSize(2131427379));
    }

    public void setCheckInButtonVisibility(int i) {
        this.f19225d.setVisibility(i);
    }
}
