package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.widget.text.TextViewWithFallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unexpected Content-Length [ */
public class HScrollPageHeaderView extends ImageBlockLayout implements CanShowDefaultHeaderData {
    @Inject
    public GlyphColorizer f21403h;
    private FbDraweeView f21404i;
    private View f21405j;
    private View f21406k;

    private static <T extends View> void m24119a(Class<T> cls, T t) {
        m24120a((Object) t, t.getContext());
    }

    private static void m24120a(Object obj, Context context) {
        ((HScrollPageHeaderView) obj).f21403h = GlyphColorizer.a(FbInjector.get(context));
    }

    private void m24118a(GlyphColorizer glyphColorizer) {
        this.f21403h = glyphColorizer;
    }

    public HScrollPageHeaderView(Context context) {
        this(context, null, 2130904810);
    }

    public HScrollPageHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24117a(2130904810);
    }

    public HScrollPageHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m24117a(i);
    }

    private void m24117a(int i) {
        m24119a(HScrollPageHeaderView.class, (View) this);
        setContentView(i);
        setClipChildren(false);
        setClipToPadding(false);
        this.f21404i = (FbDraweeView) getView(2131562764);
        if (VERSION.SDK_INT >= 16) {
            this.f21404i.setImportantForAccessibility(2);
        }
        this.f21405j = getView(2131562765);
        this.f21406k = getView(2131562766);
    }

    public void setSubtitleWithLayout(Layout layout) {
        throw new UnsupportedOperationException("Not a text layout header t6009510");
    }

    public void setSubtitleIcon(int i) {
        ((TextViewWithFallback) this.f21406k).setCompoundDrawablesWithIntrinsicBounds(null, null, this.f21403h.a(i, -7235677), null);
    }

    public void setProfileImageOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f21404i.setOnClickListener(onClickListener);
    }

    public void setSingleLineTitle(boolean z) {
        TextView textView = (TextView) this.f21405j;
        textView.setSingleLine(true);
        textView.setEllipsize(TruncateAt.END);
    }
}
