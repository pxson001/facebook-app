package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.event.InstantShoppingEvents.ProductSavedEvent;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.presenter.FooterWithButtonsBlockPresenter;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.instantshopping.utils.InstantShoppingSaveUtils;
import com.facebook.instantshopping.utils.InstantShoppingTextUtils;
import com.facebook.instantshopping.view.block.FooterBlockView;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.RichTextView.InnerRichTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: START_NEW_INDEPENDENT_FETCH */
public class FooterBlockViewImpl extends AbstractBlockView<FooterWithButtonsBlockPresenter> implements FooterBlockView {
    @Inject
    InstantShoppingActionUtils f23752a;
    @Inject
    RichDocumentEventBus f23753b;
    @Inject
    GraphQLCacheManager f23754c;
    @Inject
    public InstantShoppingSaveUtils f23755d;
    @Inject
    public InstantShoppingDocumentContext f23756e;
    @Inject
    InstantShoppingDocumentFetcher f23757f;
    @Inject
    QeAccessor f23758g;
    @Inject
    InstantShoppingAnalyticsLogger f23759h;
    @Inject
    InterstitialManager f23760i;
    @Inject
    public InstantShoppingTextUtils f23761j;
    public SaveNuxInterstitialController f23762k = ((SaveNuxInterstitialController) this.f23760i.a(SaveNuxInterstitialController.f23830b, SaveNuxInterstitialController.class));
    public final FrameLayout f23763l;
    public final FrameLayout f23764m;
    public final InnerRichTextView f23765n;
    public final InnerRichTextView f23766o;
    public FooterWithButtonsBlockPresenter f23767p;

    /* compiled from: START_NEW_INDEPENDENT_FETCH */
    public class C34081 implements OnClickListener {
        final /* synthetic */ InstantShoppingActionFragmentModel f23745a;
        final /* synthetic */ LoggingParams f23746b;
        final /* synthetic */ FooterBlockViewImpl f23747c;

        public C34081(FooterBlockViewImpl footerBlockViewImpl, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel, LoggingParams loggingParams) {
            this.f23747c = footerBlockViewImpl;
            this.f23745a = instantShoppingActionFragmentModel;
            this.f23746b = loggingParams;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 282667365);
            this.f23747c.f23752a.m24802a(this.f23747c.getContext(), this.f23745a, this.f23746b, null);
            Logger.a(2, EntryType.UI_INPUT_END, -1813580180, a);
        }
    }

    /* compiled from: START_NEW_INDEPENDENT_FETCH */
    public class C34102 implements OnClickListener {
        final /* synthetic */ InstantShoppingActionFragmentModel f23748a;
        final /* synthetic */ InstantShoppingActionFragmentModel f23749b;
        final /* synthetic */ LoggingParams f23750c;
        final /* synthetic */ FooterBlockViewImpl f23751d;

        public C34102(FooterBlockViewImpl footerBlockViewImpl, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel2, LoggingParams loggingParams) {
            this.f23751d = footerBlockViewImpl;
            this.f23748a = instantShoppingActionFragmentModel;
            this.f23749b = instantShoppingActionFragmentModel2;
            this.f23750c = loggingParams;
        }

        public void onClick(View view) {
            boolean z = true;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -474624615);
            final boolean z2 = this.f23751d.f23767p.f23676f;
            this.f23751d.f23767p.m25002a(!z2);
            this.f23751d.f23752a.m24802a(this.f23751d.getContext(), z2 ? this.f23748a : this.f23749b, this.f23750c, new HashMap<String, Object>() {
            });
            RichDocumentEventBus richDocumentEventBus = this.f23751d.f23753b;
            if (z2) {
                z = false;
            }
            richDocumentEventBus.a(new ProductSavedEvent(z));
            this.f23751d.f23754c.a(ImmutableSet.of(this.f23751d.f23757f.a(this.f23751d.f23756e.a)));
            LogUtils.a(-1419513474, a);
        }
    }

    public static void m25056a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FooterBlockViewImpl) obj).m25055a(InstantShoppingActionUtils.m24796a(injectorLike), RichDocumentEventBus.a(injectorLike), GraphQLCacheManager.a(injectorLike), InstantShoppingSaveUtils.a(injectorLike), InstantShoppingDocumentContext.a(injectorLike), InstantShoppingDocumentFetcher.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike), InterstitialManager.a(injectorLike), InstantShoppingTextUtils.b(injectorLike));
    }

    private void m25055a(InstantShoppingActionUtils instantShoppingActionUtils, RichDocumentEventBus richDocumentEventBus, GraphQLCacheManager graphQLCacheManager, InstantShoppingSaveUtils instantShoppingSaveUtils, InstantShoppingDocumentContext instantShoppingDocumentContext, InstantShoppingDocumentFetcher instantShoppingDocumentFetcher, QeAccessor qeAccessor, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, InterstitialManager interstitialManager, InstantShoppingTextUtils instantShoppingTextUtils) {
        this.f23752a = instantShoppingActionUtils;
        this.f23753b = richDocumentEventBus;
        this.f23754c = graphQLCacheManager;
        this.f23755d = instantShoppingSaveUtils;
        this.f23756e = instantShoppingDocumentContext;
        this.f23757f = instantShoppingDocumentFetcher;
        this.f23758g = qeAccessor;
        this.f23759h = instantShoppingAnalyticsLogger;
        this.f23760i = interstitialManager;
        this.f23761j = instantShoppingTextUtils;
    }

    public final void m25060a(AbstractBlockPresenter abstractBlockPresenter) {
        this.f23767p = (FooterWithButtonsBlockPresenter) abstractBlockPresenter;
    }

    public FooterBlockViewImpl(View view) {
        super(view);
        this.f23763l = (FrameLayout) view.findViewById(2131563249);
        this.f23764m = (FrameLayout) view.findViewById(2131563251);
        this.f23765n = ((RichTextView) view.findViewById(2131563250)).d;
        this.f23766o = ((RichTextView) view.findViewById(2131563252)).d;
        Class cls = FooterBlockViewImpl.class;
        m25056a(this, getContext());
    }

    public final void m25058a(Bundle bundle) {
        super.a(bundle);
        iY_().setVisibility(8);
        this.f23765n.a();
        this.f23766o.a();
    }

    public final void m25059a(RichText richText) {
        if (richText != null) {
            this.f23766o.setText(richText);
        } else {
            this.f23764m.setVisibility(8);
        }
    }

    public final void m25057a(int i) {
        this.f23766o.setTextColor(i);
    }

    public final void m25061b(int i) {
        this.f23764m.setBackgroundResource(i);
    }

    public final void m25062f() {
        Object obj;
        CharSequence a = this.f23758g.a(ExperimentsForInstantShoppingAbtestModule.p, null);
        if (this.f23762k == null || !Objects.equal(this.f23762k.m25116b(), "3903")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null && !StringUtil.a(a)) {
            Tooltip tooltip = new Tooltip(getContext(), 2);
            tooltip.b(a);
            tooltip.t = 5000;
            tooltip.f(this.f23764m);
            this.f23762k.f23831a.a();
            this.f23760i.a().a("3903");
        }
    }
}
