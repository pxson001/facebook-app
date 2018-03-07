package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.text.TextViewWithFallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Undo curation flow failed */
public class HeaderView extends ImageBlockLayout implements CanShowDefaultHeaderData, CanShowHeaderOptionsMenu {
    public static final ViewType f21407h = new C18001();
    @Inject
    public GlyphColorizer f21408i;
    private final FbDraweeView f21409j;
    private final ContentTextView f21410k;
    private final TextViewWithFallback f21411l;
    public final ImageView f21412m;

    /* compiled from: Undo curation flow failed */
    final class C18001 extends ViewType {
        C18001() {
        }

        public final View m24121a(Context context) {
            return new HeaderView(context);
        }
    }

    public static void m24122a(Object obj, Context context) {
        ((HeaderView) obj).f21408i = GlyphColorizer.a(FbInjector.get(context));
    }

    public HeaderView(Context context) {
        this(context, null, 2130904759);
    }

    private HeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Class cls = HeaderView.class;
        m24122a((Object) this, getContext());
        setContentView(i);
        this.f21409j = (FbDraweeView) getView(2131562764);
        if (VERSION.SDK_INT >= 16) {
            this.f21409j.setImportantForAccessibility(2);
        }
        this.f21410k = (ContentTextView) getView(2131562765);
        this.f21411l = (TextViewWithFallback) getView(2131562766);
        this.f21411l.setMovementMethod(LinkMovementMethod.getInstance());
        this.f21412m = (ImageView) getView(2131560877);
    }

    public final void m24125a(CharSequence charSequence, CanShowHeaderTitle$Sponsored canShowHeaderTitle$Sponsored) {
        this.f21410k.setText(charSequence);
        if (charSequence instanceof Spannable) {
            this.f21410k.setSpannable((Spannable) charSequence);
        }
        this.f21410k.setTag(2131558541, Boolean.valueOf(canShowHeaderTitle$Sponsored == CanShowHeaderTitle$Sponsored.SPONSORED));
    }

    public final void m24123a(@Nullable Uri uri, CallerContext callerContext) {
        this.f21409j.a(uri, callerContext);
    }

    public final void m24126a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this.f21411l.setVisibility(charSequence != null ? 0 : 8);
        this.f21411l.setText(charSequence);
        this.f21411l.a = charSequence2;
    }

    public void setSubtitleWithLayout(Layout layout) {
        throw new UnsupportedOperationException("Not a text layout header t6009510");
    }

    public void setSubtitleIcon(int i) {
        this.f21411l.setCompoundDrawablesWithIntrinsicBounds(null, null, this.f21408i.a(i, -7235677), null);
    }

    public void setMenuButtonActive(boolean z) {
        this.f21412m.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f21412m.getVisibility() == 0;
    }

    public void setProfileImageOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f21409j.setOnClickListener(onClickListener);
    }

    public final void m24124a(Tooltip tooltip) {
        tooltip.f(this.f21412m);
    }
}
