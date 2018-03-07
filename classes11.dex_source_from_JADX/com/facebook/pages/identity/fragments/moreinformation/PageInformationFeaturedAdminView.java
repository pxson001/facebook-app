package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.FeaturedAdminInfoFragmentModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: pages_browser_landing_page_load_error */
public class PageInformationFeaturedAdminView extends CustomFrameLayout {
    private static final CallerContext f3991m = CallerContext.a(PageInformationFeaturedAdminView.class);
    @Inject
    public UriIntentMapper f3992a;
    @Inject
    public SecureContextHelper f3993b;
    @Inject
    public BasicDateTimeFormat f3994c;
    @Inject
    public Lazy<FbErrorReporter> f3995d;
    private final FbTextView f3996e;
    private final FbTextView f3997f;
    private final FbDraweeView f3998g;
    public final FbTextView f3999h;
    public final FbTextView f4000i;
    private final FbTextView f4001j;
    private final FbTextView f4002k;
    private OnClickListener f4003l;

    public static void m4919a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageInformationFeaturedAdminView pageInformationFeaturedAdminView = (PageInformationFeaturedAdminView) obj;
        UriIntentMapper uriIntentMapper = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        BasicDateTimeFormat a = BasicDateTimeFormat.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        pageInformationFeaturedAdminView.f3992a = uriIntentMapper;
        pageInformationFeaturedAdminView.f3993b = secureContextHelper;
        pageInformationFeaturedAdminView.f3994c = a;
        pageInformationFeaturedAdminView.f3995d = b;
    }

    public PageInformationFeaturedAdminView(Context context) {
        this(context, null);
    }

    private PageInformationFeaturedAdminView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PageInformationFeaturedAdminView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageInformationFeaturedAdminView.class;
        m4919a(this, getContext());
        setContentView(2130906048);
        this.f3996e = (FbTextView) c(2131565575);
        this.f3997f = (FbTextView) c(2131565576);
        this.f3998g = (FbDraweeView) c(2131565574);
        this.f3999h = (FbTextView) c(2131565577);
        this.f4000i = (FbTextView) c(2131565578);
        this.f4001j = (FbTextView) c(2131565579);
        this.f4002k = (FbTextView) c(2131565580);
    }

    public final void m4925a(FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel) {
        if (featuredAdminInfoFragmentModel != null) {
            m4920b(featuredAdminInfoFragmentModel);
            this.f3997f.setText(featuredAdminInfoFragmentModel.l());
            m4922c(featuredAdminInfoFragmentModel);
            if (!StringUtil.a(featuredAdminInfoFragmentModel.k())) {
                this.f3999h.setText(featuredAdminInfoFragmentModel.k());
                this.f3999h.setVisibility(0);
            }
            if (featuredAdminInfoFragmentModel.j() > 0) {
                String string = getResources().getString(2131235555);
                BasicDateTimeFormat basicDateTimeFormat = this.f3994c;
                if (basicDateTimeFormat.l == null) {
                    SimpleDateFormat simpleDateFormat = (SimpleDateFormat) basicDateTimeFormat.b().clone();
                    BasicDateTimeFormat.a(simpleDateFormat, "MMMM yyyy", (Locale) basicDateTimeFormat.a.get());
                    basicDateTimeFormat.l = simpleDateFormat;
                }
                String format = basicDateTimeFormat.l.format(Long.valueOf(featuredAdminInfoFragmentModel.j() * 1000));
                this.f4000i.setText(StringFormatUtil.a(string, new Object[]{format}));
                this.f4000i.setVisibility(0);
            }
            m4923f(featuredAdminInfoFragmentModel);
            m4924g(featuredAdminInfoFragmentModel);
        }
    }

    private OnClickListener m4918a(final String str) {
        if (this.f4003l == null) {
            this.f4003l = new OnClickListener(this) {
                final /* synthetic */ PageInformationFeaturedAdminView f3990b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1091136156);
                    this.f3990b.f3993b.a(this.f3990b.f3992a.a(this.f3990b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str)), this.f3990b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, -1989873086, a);
                }
            };
        }
        return this.f4003l;
    }

    private void m4920b(FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel) {
        if (featuredAdminInfoFragmentModel.o() == null) {
            m4921b("FBFeaturedAdminInfoFragmentModel.getUser() shouldn't be null");
        } else if (!StringUtil.a(featuredAdminInfoFragmentModel.o().l())) {
            this.f3996e.setText(featuredAdminInfoFragmentModel.o().l());
            this.f3996e.setOnClickListener(m4918a(featuredAdminInfoFragmentModel.o().k()));
        }
    }

    private void m4922c(FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel) {
        if (featuredAdminInfoFragmentModel.o() == null) {
            m4921b("FBFeaturedAdminInfoFragmentModel.getUser() shouldn't be null");
        } else if (featuredAdminInfoFragmentModel.o().j() != null && !StringUtil.a(featuredAdminInfoFragmentModel.o().j().a())) {
            this.f3998g.a(Uri.parse(featuredAdminInfoFragmentModel.o().j().a()), f3991m);
            this.f3998g.setOnClickListener(m4918a(featuredAdminInfoFragmentModel.o().k()));
        }
    }

    private void m4921b(String str) {
        ((AbstractFbErrorReporter) this.f3995d.get()).b(getClass().getSimpleName(), str);
    }

    private void m4923f(FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel) {
        if (featuredAdminInfoFragmentModel.m() > 0) {
            this.f4001j.setText(getResources().getQuantityString(2131689626, featuredAdminInfoFragmentModel.m(), new Object[]{Integer.valueOf(featuredAdminInfoFragmentModel.m())}));
            this.f4001j.setVisibility(0);
        }
    }

    private void m4924g(FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel) {
        if (featuredAdminInfoFragmentModel.n() > 0) {
            this.f4002k.setText(getResources().getQuantityString(2131689627, featuredAdminInfoFragmentModel.n(), new Object[]{Integer.valueOf(featuredAdminInfoFragmentModel.n())}));
            this.f4002k.setVisibility(0);
        }
    }
}
