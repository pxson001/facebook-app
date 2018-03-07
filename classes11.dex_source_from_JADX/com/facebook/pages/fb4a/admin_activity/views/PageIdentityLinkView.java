package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: pysf_xout */
public abstract class PageIdentityLinkView extends CustomRelativeLayout {
    public BadgeTextView f2891a;
    public PageAnalyticsEvent f2892b;
    @Inject
    SecureContextHelper f2893c;
    @Inject
    PagesAnalytics f2894d;
    @Inject
    UriIntentMapper f2895e;
    @Inject
    GlyphColorizer f2896f;
    @Inject
    RTLUtil f2897g;

    public static void m3854a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityLinkView) obj).m3853a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), PagesAnalytics.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), GlyphColorizer.a(fbInjector), RTLUtil.a(fbInjector));
    }

    public abstract void mo75a(String str, long j, Optional<? extends WebViewLaunchedListener> optional);

    public PageIdentityLinkView(Context context) {
        super(context);
        m3852a(context, null);
    }

    public PageIdentityLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3852a(context, attributeSet);
    }

    private void m3853a(SecureContextHelper secureContextHelper, PagesAnalytics pagesAnalytics, UriIntentMapper uriIntentMapper, GlyphColorizer glyphColorizer, RTLUtil rTLUtil) {
        this.f2893c = secureContextHelper;
        this.f2894d = pagesAnalytics;
        this.f2895e = uriIntentMapper;
        this.f2896f = glyphColorizer;
        this.f2897g = rTLUtil;
    }

    public PageIdentityLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3852a(context, attributeSet);
    }

    private void m3852a(Context context, AttributeSet attributeSet) {
        Class cls = PageIdentityLinkView.class;
        m3854a((Object) this, getContext());
        setContentView(2130906022);
        this.f2891a = (BadgeTextView) a(2131565500);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageIdentityLinkView);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int i = obtainStyledAttributes.getInt(4, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.f2891a.setText(resourceId);
            if (i > 0) {
                Typeface defaultFromStyle = Typeface.defaultFromStyle(i);
                if (this.f2891a.getTypeface() != defaultFromStyle) {
                    this.f2891a.setTypeface(defaultFromStyle);
                }
            }
            if (resourceId2 > 0) {
                this.f2891a.setTextColor(getResources().getColor(resourceId2));
            }
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        i = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            Drawable drawable;
            Drawable drawable2;
            if (VERSION.SDK_INT >= 21) {
                drawable = getResources().getDrawable(resourceId, getContext().getTheme());
            } else {
                drawable = getResources().getDrawable(resourceId);
            }
            if (i != 0) {
                drawable.setColorFilter(this.f2896f.a(getResources().getColor(i)));
            }
            boolean a = RTLUtil.a(context);
            BadgeTextView badgeTextView = this.f2891a;
            if (a) {
                drawable2 = null;
            } else {
                drawable2 = drawable;
            }
            if (!a) {
                drawable = null;
            }
            badgeTextView.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, drawable, null);
        }
        CustomViewUtils.b((ImageView) findViewById(2131565501), this.f2897g.a(2130838066));
        obtainStyledAttributes.recycle();
    }

    public CharSequence getContentDescription() {
        return StringFormatUtil.formatStrLocaleSafe("%s %s", this.f2891a.getText(), this.f2891a.h);
    }

    protected final void m3855a(long j) {
        if (this.f2892b != null) {
            this.f2894d.b(this.f2892b, j);
        }
    }

    public void setIcon(int i) {
        this.f2891a.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setBadgeStyle(PagesLinkViewBadgeStyle pagesLinkViewBadgeStyle) {
        switch (pagesLinkViewBadgeStyle) {
            case PRIMARY:
                this.f2891a.a(getContext(), 2131625522);
                this.f2891a.setBadgeBackground(2130841266);
                return;
            case SECONDARY:
                this.f2891a.a(getContext(), 2131625523);
                this.f2891a.setBadgeBackground(null);
                return;
            default:
                return;
        }
    }

    public void setTitle(int i) {
        this.f2891a.setText(i);
    }

    public void setBadgeNumber(long j) {
        if (j <= 0) {
            this.f2891a.setBadgeText(null);
            return;
        }
        CharSequence text;
        BadgeTextView badgeTextView = this.f2891a;
        Long valueOf = Long.valueOf(j);
        if (valueOf.longValue() > 20) {
            text = getContext().getText(2131235086);
        } else {
            text = String.valueOf(valueOf);
        }
        badgeTextView.setBadgeText(text);
    }
}
