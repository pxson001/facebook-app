package com.facebook.pages.identity.cards.nux;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.AdminEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.reaction.protocol.methods.PageNuxExposuresMethod;
import com.facebook.pages.common.reaction.protocol.methods.model.PageNuxExposuresCallArguments;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_checkup_app_step_previous */
public class PageIdentityNuxCardView extends CustomLinearLayout implements PageSecondaryCardView {
    @Inject
    Lazy<UriIntentMapper> f3545a;
    @Inject
    Lazy<SecureContextHelper> f3546b;
    @Inject
    Lazy<PagesAnalytics> f3547c;
    @Inject
    Provider<SingleMethodRunner> f3548d;
    @Inject
    PageNuxExposuresMethod f3549e;
    public ImageView f3550f = ((ImageView) a(2131565504));
    public GlyphView f3551g = ((GlyphView) a(2131565505));
    public BetterTextView f3552h = ((BetterTextView) a(2131565506));
    public BetterTextView f3553i = ((BetterTextView) a(2131565507));
    public FbButton f3554j = ((FbButton) a(2131565508));

    /* compiled from: privacy_checkup_app_step_previous */
    public class C04821 implements OnClickListener {
        final /* synthetic */ PageIdentityNuxCardViewModel f3539a;
        final /* synthetic */ String f3540b;
        final /* synthetic */ PageIdentityNuxCardView f3541c;

        public C04821(PageIdentityNuxCardView pageIdentityNuxCardView, PageIdentityNuxCardViewModel pageIdentityNuxCardViewModel, String str) {
            this.f3541c = pageIdentityNuxCardView;
            this.f3539a = pageIdentityNuxCardViewModel;
            this.f3540b = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1696660947);
            PageIdentityNuxCardView.m4578a(this.f3541c, this.f3539a.mo92g(), this.f3540b);
            Intent a2 = ((UriIntentMapper) this.f3541c.f3545a.get()).a(this.f3541c.getContext(), this.f3539a.mo88c(this.f3540b));
            if (a2 != null) {
                ((SecureContextHelper) this.f3541c.f3546b.get()).a(a2, this.f3541c.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1691658480, a);
        }
    }

    /* compiled from: privacy_checkup_app_step_previous */
    public class C04832 implements OnClickListener {
        final /* synthetic */ PageIdentityNuxCardViewModel f3542a;
        final /* synthetic */ String f3543b;
        final /* synthetic */ PageIdentityNuxCardView f3544c;

        public C04832(PageIdentityNuxCardView pageIdentityNuxCardView, PageIdentityNuxCardViewModel pageIdentityNuxCardViewModel, String str) {
            this.f3544c = pageIdentityNuxCardView;
            this.f3542a = pageIdentityNuxCardViewModel;
            this.f3543b = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -523892739);
            PageIdentityNuxCardView.m4578a(this.f3544c, this.f3542a.mo93h(), this.f3543b);
            this.f3544c.m4581a(this.f3542a);
            PageIdentityNuxCardView.m4579a(this.f3544c, this.f3542a.mo94i(), this.f3543b);
            Logger.a(2, EntryType.UI_INPUT_END, -1572430647, a);
        }
    }

    public static void m4580a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PageIdentityNuxCardView) obj).m4577a(IdBasedSingletonScopeProvider.b(injectorLike, 2436), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedSingletonScopeProvider.b(injectorLike, 8930), IdBasedSingletonScopeProvider.a(injectorLike, 2289), PageNuxExposuresMethod.m3156a(injectorLike));
    }

    public PageIdentityNuxCardView(Context context) {
        super(context);
        Class cls = PageIdentityNuxCardView.class;
        m4580a(this, getContext());
        setContentView(2130906024);
    }

    @VisibleForTesting
    public final void m4581a(PageIdentityNuxCardViewModel pageIdentityNuxCardViewModel) {
        LinearLayout linearLayout = (LinearLayout) getParent();
        int indexOfChild = linearLayout.indexOfChild(this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130906025, linearLayout, false);
        ((FbTextView) inflate.findViewById(2131565509)).setText(pageIdentityNuxCardViewModel.mo91f(), BufferType.SPANNABLE);
        linearLayout.removeViewAt(indexOfChild);
        linearLayout.addView(inflate, indexOfChild);
    }

    public static void m4579a(PageIdentityNuxCardView pageIdentityNuxCardView, String str, String str2) {
        try {
            ((AbstractSingleMethodRunner) pageIdentityNuxCardView.f3548d.get()).a(pageIdentityNuxCardView.f3549e, new PageNuxExposuresCallArguments(str2, str), CallerContext.a(pageIdentityNuxCardView.getClass()));
        } catch (Throwable e) {
            BLog.b(PageIdentityNuxCardView.class, "Could not run PageNuxExposureMethod", e);
        }
    }

    private void m4577a(Lazy<UriIntentMapper> lazy, Lazy<SecureContextHelper> lazy2, Lazy<PagesAnalytics> lazy3, Provider<SingleMethodRunner> provider, PageNuxExposuresMethod pageNuxExposuresMethod) {
        this.f3545a = lazy;
        this.f3546b = lazy2;
        this.f3547c = lazy3;
        this.f3548d = provider;
        this.f3549e = pageNuxExposuresMethod;
    }

    public static void m4578a(PageIdentityNuxCardView pageIdentityNuxCardView, AdminEvent adminEvent, String str) {
        if (adminEvent != null) {
            ((PagesAnalytics) pageIdentityNuxCardView.f3547c.get()).a(adminEvent, Long.parseLong(str));
        }
    }
}
