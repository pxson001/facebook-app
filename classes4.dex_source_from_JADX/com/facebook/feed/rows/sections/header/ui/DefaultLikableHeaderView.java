package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.widget.text.TextViewWithFallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nativesignup?provider_name=%s&provider_page_fbid=%s */
public class DefaultLikableHeaderView extends ImageBlockLayout implements CanShowDefaultHeaderData {
    @Inject
    public GlyphColorizer f7275h;
    public FbDraweeView f7276i;
    public View f7277j;
    public View f7278k;

    public static void m7598a(Object obj, Context context) {
        ((DefaultLikableHeaderView) obj).f7275h = GlyphColorizer.a(FbInjector.get(context));
    }

    public DefaultLikableHeaderView(Context context) {
        this(context, null);
    }

    private DefaultLikableHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = DefaultLikableHeaderView.class;
        m7598a(this, getContext());
        setContentView(2130905040);
        setClipChildren(false);
        setClipToPadding(false);
        this.f7276i = (FbDraweeView) getView(2131562764);
        if (VERSION.SDK_INT >= 16) {
            this.f7276i.setImportantForAccessibility(2);
        }
        this.f7277j = getView(2131562765);
        this.f7278k = getView(2131562766);
    }

    public void setSubtitleWithLayout(Layout layout) {
        throw new UnsupportedOperationException("Not a text layout header t6009510");
    }

    public void setSubtitleIcon(int i) {
        ((TextViewWithFallback) this.f7278k).setCompoundDrawablesWithIntrinsicBounds(null, null, this.f7275h.a(i, -7235677), null);
    }

    public void setProfileImageOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f7276i.setOnClickListener(onClickListener);
    }
}
