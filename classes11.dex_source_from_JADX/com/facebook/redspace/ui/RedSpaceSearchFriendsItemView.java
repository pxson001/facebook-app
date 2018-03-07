package com.facebook.redspace.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: PRIVACY_REVIEW_CORE_EVENT */
public class RedSpaceSearchFriendsItemView extends ContentViewWithButton {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DefaultTimeFormatUtil> f12376h = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<Resources> f12377i = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GlyphColorizer> f12378j = UltralightRuntime.b;
    public RedSpaceFeedProfileFragmentModel f12379k;
    public RedSpaceFriendsSection f12380l;

    private static <T extends View> void m12795a(Class<T> cls, T t) {
        m12796a((Object) t, t.getContext());
    }

    private static void m12796a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceSearchFriendsItemView) obj).m12794a(IdBasedSingletonScopeProvider.b(fbInjector, 610), IdBasedSingletonScopeProvider.b(fbInjector, 30), IdBasedSingletonScopeProvider.b(fbInjector, 1275));
    }

    public RedSpaceSearchFriendsItemView(Context context) {
        super(context);
        m12798g();
    }

    public RedSpaceSearchFriendsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12798g();
    }

    public RedSpaceSearchFriendsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12798g();
    }

    private void m12798g() {
        setContentView(2130906772);
        m12795a(RedSpaceSearchFriendsItemView.class, (View) this);
    }

    public final void m12800a(RedSpaceFriendsSection redSpaceFriendsSection, boolean z, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        this.f12380l = redSpaceFriendsSection;
        this.f12379k = redSpaceFeedProfileFragmentModel;
        m12799h();
        m12797a(z);
        setThumbnailUri(redSpaceFeedProfileFragmentModel.l() == null ? null : redSpaceFeedProfileFragmentModel.l().b());
    }

    private void m12794a(com.facebook.inject.Lazy<DefaultTimeFormatUtil> lazy, com.facebook.inject.Lazy<Resources> lazy2, com.facebook.inject.Lazy<GlyphColorizer> lazy3) {
        this.f12376h = lazy;
        this.f12377i = lazy2;
        this.f12378j = lazy3;
    }

    public RedSpaceFeedProfileFragmentModel getProfile() {
        return this.f12379k;
    }

    public RedSpaceFriendsSection getSection() {
        return this.f12380l;
    }

    private void m12797a(boolean z) {
        boolean z2;
        int paddingTop = this.a.getPaddingTop();
        Button button = (Button) this.a;
        if (this.f12380l.isTop() && !z) {
            setActionButtonText(2131235765);
            setActionButtonTextAppearance(2131625579);
            setActionButtonBackground(null);
            button.setPadding(0, paddingTop, 0, paddingTop);
            button.setGravity(8388613);
        } else if (this.f12380l.isTop() && z) {
            setActionButtonText(getRecentlyUpdatedText());
            setActionButtonTextAppearance(2131625578);
            setActionButtonBackground(null);
            button.setPadding(0, paddingTop, 0, paddingTop);
            button.setGravity(8388613);
        } else {
            setActionButtonText(2131235763);
            setActionButtonTheme(Theme.BLUE);
            button.setGravity(17);
        }
        if (this.f12380l.isTop() || !z) {
            z2 = true;
        } else {
            z2 = false;
        }
        setEnableActionButton(z2);
    }

    private void m12799h() {
        setTitleText(this.f12379k.n().s_());
    }

    public void setActionButtonOnClickListener(final OnClickListener onClickListener) {
        if (onClickListener != null) {
            super.setActionButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RedSpaceSearchFriendsItemView f12375b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -704866694);
                    onClickListener.onClick(this.f12375b);
                    Logger.a(2, EntryType.UI_INPUT_END, 70175272, a);
                }
            });
        } else {
            super.setActionButtonOnClickListener(null);
        }
    }

    private CharSequence getRecentlyUpdatedText() {
        Drawable a = ((GlyphColorizer) this.f12378j.get()).a(((Resources) this.f12377i.get()).getDrawable(2130839774), ((Resources) this.f12377i.get()).getColor(2131361919));
        int dimensionPixelSize = ((Resources) this.f12377i.get()).getDimensionPixelSize(2131427401);
        a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(' ');
        spannableStringBuilder.append(' ');
        spannableStringBuilder.append(((Resources) this.f12377i.get()).getString(2131235764));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(((Resources) this.f12377i.get()).getString(2131230753));
        spannableStringBuilder.setSpan(new ImageSpan(a, 0), 0, 1, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.b(getContext(), 2131361974)), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
