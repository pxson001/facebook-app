package com.facebook.events.permalink.composeractionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: business_extension_uri */
public class EventFeedComposer extends CustomFrameLayout {
    public FbDraweeView f18316a;
    private FbTextView f18317b;
    public GlyphView f18318c;
    private View f18319d;
    private EventDrawDividerUtil f18320e;

    public EventFeedComposer(Context context) {
        super(context);
        m18660a();
    }

    public EventFeedComposer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18660a();
    }

    public EventFeedComposer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18660a();
    }

    private void m18660a() {
        setContentView(2130904031);
        this.f18320e = new EventDrawDividerUtil(getResources());
        this.f18319d = c(2131561282);
        this.f18316a = (FbDraweeView) c(2131561283);
        this.f18317b = (FbTextView) c(2131561284);
        this.f18318c = (GlyphView) c(2131561285);
    }

    public View getComposerContainer() {
        return this.f18319d;
    }

    public FbDraweeView getComposerVoice() {
        return this.f18316a;
    }

    public FbTextView getComposerPrompt() {
        return this.f18317b;
    }

    public GlyphView getComposerPostPhoto() {
        return this.f18318c;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f18320e.a(canvas, (float) getPaddingTop());
        this.f18320e.b(canvas, (float) getPaddingBottom());
    }
}
