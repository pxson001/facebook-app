package com.facebook.instantshopping;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.ParcelFormatException;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.fps.BaseFrameRateLoggerCallback;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentPresentationStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingHeaderElementType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.action.InstantShoppingActionUtils.C33853;
import com.facebook.instantshopping.action.InstantShoppingActionUtils.GetRequestAsyncTask;
import com.facebook.instantshopping.event.InstantShoppingEventSubscribers.CartClearedEventSubscriber;
import com.facebook.instantshopping.event.InstantShoppingEventSubscribers.ExecuteActionEventSubscriber;
import com.facebook.instantshopping.event.InstantShoppingEventSubscribers.InstantShoppingReloadDocumentEventSubscriber;
import com.facebook.instantshopping.event.InstantShoppingEventSubscribers.ItemAddedToCartEventSubscriber;
import com.facebook.instantshopping.event.InstantShoppingEventSubscribers.ItemRemovedFromCartEventSubscriber;
import com.facebook.instantshopping.event.InstantShoppingEventSubscribers.ProductSavedEventSubscriber;
import com.facebook.instantshopping.event.InstantShoppingEvents.ExecuteActionEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.InstantShoppingReloadDocumentEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.ProductSavedEvent;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher;
import com.facebook.instantshopping.fetcher.InstantShoppingFontResourceWrapper;
import com.facebook.instantshopping.links.InstantShoppingLinkHandler;
import com.facebook.instantshopping.logging.C3390x9972f56a;
import com.facebook.instantshopping.logging.CatalogLoadSequenceLogger;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.InstantShoppingDidScrollLogger;
import com.facebook.instantshopping.logging.InstantShoppingDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger.ElementDwellTime;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.InstantShoppingPerfInfoLogger;
import com.facebook.instantshopping.logging.InstantShoppingSequences;
import com.facebook.instantshopping.logging.InstantShoppingSessionIDGenerator;
import com.facebook.instantshopping.model.block.HasTextMetrics;
import com.facebook.instantshopping.model.block.InstantShoppingBlocks;
import com.facebook.instantshopping.model.block.InstantShoppingBlocksUtil;
import com.facebook.instantshopping.model.data.HasGridWidth;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingHeaderElementFragment.HeaderElements;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.DocumentBodyElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.FooterElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.HeaderElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingFontObjectFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingHeaderElementFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.instantshopping.presenter.CheckoutHeaderBlockPresenter;
import com.facebook.instantshopping.presenter.HeaderBlockPresenter;
import com.facebook.instantshopping.presenter.LogoHeaderBlockPresenter;
import com.facebook.instantshopping.presenter.SaveHeaderBlockPresenter;
import com.facebook.instantshopping.utils.GridUtils;
import com.facebook.instantshopping.utils.InstantShoppingCart;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.instantshopping.utils.InstantShoppingDocumentUtils;
import com.facebook.instantshopping.utils.InstantShoppingFetchParams;
import com.facebook.instantshopping.utils.InstantShoppingSaveUtils;
import com.facebook.instantshopping.view.block.impl.CheckoutHeaderBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.HeaderLogoBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.SaveHeaderBlockViewImpl;
import com.facebook.instantshopping.view.widget.InstantShoppingGridLayoutManager;
import com.facebook.instantshopping.view.widget.InstantShoppingPageArrow;
import com.facebook.instantshopping.view.widget.InstantShoppingPageNavBar;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.RichDocumentDelegateImpl;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import com.facebook.richdocument.fetcher.RichDocumentFetcher;
import com.facebook.richdocument.fonts.RichDocumentFontManager;
import com.facebook.richdocument.fonts.RichDocumentFonts;
import com.facebook.richdocument.logging.RichDocumentScrollDepthLogger;
import com.facebook.richdocument.logging.RichDocumentSessionTracker;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.text.BetterTextView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Stored user does not match other user in thread. */
public class InstantShoppingDocumentDelegateImpl<T> extends RichDocumentDelegateImpl<GraphQLRequest<T>, GraphQLResult<T>> implements InstantShoppingDocumentDelegate {
    private static final String aa = InstantShoppingDocumentDelegateImpl.class.getSimpleName();
    @Inject
    public RichDocumentFonts f23405A;
    @Inject
    FrameRateLoggerProvider f23406B;
    @Inject
    public InstantShoppingAnalyticsLogger f23407C;
    @Inject
    InstantShoppingDidScrollLogger f23408D;
    @Inject
    Lazy<FbErrorReporter> f23409E;
    @Inject
    InstantShoppingDocumentFetcher f23410F;
    @Inject
    CatalogLoadSequenceLogger f23411G;
    @Inject
    AutoQESpecForInstantShoppingAbtestModule f23412H;
    @Inject
    InstantShoppingActionUtils f23413I;
    @Inject
    InstantShoppingSaveUtils f23414J;
    @Inject
    InstantShoppingCart f23415K;
    @Inject
    InstantShoppingDocumentContext f23416L;
    @Inject
    public InstantShoppingLinkHandler f23417M;
    @Inject
    public InstantShoppingDwellTimeLogger f23418N;
    @Inject
    public InstantShoppingElementDwellTimeLogger f23419O;
    @Inject
    public RichDocumentScrollDepthLogger f23420P;
    @Inject
    InstantShoppingLoggingUtils f23421Q;
    @Inject
    TipSeenTracker f23422R;
    @Inject
    InstantShoppingPerfInfoLogger f23423S;
    @Inject
    InstantShoppingSessionIDGenerator f23424T;
    @Inject
    InstantShoppingSurveyController f23425U;
    @Inject
    QeAccessor f23426V;
    @Inject
    FbSharedPreferences f23427W;
    @Inject
    public FunnelLoggerImpl f23428X;
    @Inject
    public RichDocumentSessionTracker f23429Y;
    @Inject
    Lazy<RichDocumentInfo> f23430Z;
    private final InstantShoppingReloadDocumentEventSubscriber aA = new C33722(this);
    private final ProductSavedEventSubscriber aB = new C33753(this);
    private final ItemRemovedFromCartEventSubscriber aC = new C33764(this);
    private final CartClearedEventSubscriber aD = new C33775(this);
    private final ExecuteActionEventSubscriber aE = new C33786(this);
    public final List<HeaderBlockPresenter> ab = new ArrayList();
    private TextView ac;
    public LinearLayout ad;
    private LinearLayout ae;
    public InstantShoppingItemDecorator af = null;
    private String ag;
    private CheckoutHeaderBlockViewImpl ah;
    public InstantShoppingFooter ai;
    private InstantShoppingBlocks aj;
    public String ak;
    public String al;
    private String am;
    private String an;
    private JsonNode ao;
    private String ap;
    private String aq;
    public PopoverWindow ar;
    private LoadingIndicatorView as;
    private ImmutableList<GraphQLInstantShoppingDocumentPresentationStyle> at;
    private boolean au;
    private boolean av = false;
    public boolean aw = false;
    public Map<String, Object> ax;
    public C3390x9972f56a ay;
    private final ItemAddedToCartEventSubscriber az = new C33711(this);
    @Inject
    RichDocumentEventBus f23431w;
    @Inject
    InstantShoppingPageArrow f23432x;
    @Inject
    InstantShoppingPageNavBar f23433y;
    @Inject
    public RichDocumentFontManager f23434z;

    /* compiled from: Stored user does not match other user in thread. */
    /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] f23392a = new int[GraphQLInstantShoppingDocumentElementType.values().length];
        static final /* synthetic */ int[] f23393b = new int[GraphQLInstantShoppingHeaderElementType.values().length];

        static {
            try {
                f23393b[GraphQLInstantShoppingHeaderElementType.CHECKOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23393b[GraphQLInstantShoppingHeaderElementType.SAVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23392a[GraphQLInstantShoppingDocumentElementType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23392a[GraphQLInstantShoppingDocumentElementType.RICH_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33711 extends ItemAddedToCartEventSubscriber {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23394a;

        C33711(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23394a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24705b(FbEvent fbEvent) {
            InstantShoppingCart instantShoppingCart = this.f23394a.f23415K;
            String str = this.f23394a.al;
            instantShoppingCart.a.put(str, Integer.valueOf((instantShoppingCart.a.containsKey(str) ? ((Integer) instantShoppingCart.a.get(str)).intValue() : 0) + 1));
            InstantShoppingDocumentDelegateImpl.m24723K(this.f23394a);
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33722 extends InstantShoppingReloadDocumentEventSubscriber {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23395a;

        C33722(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23395a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24707b(FbEvent fbEvent) {
            InstantShoppingDocumentDelegateImpl.m24739e(this.f23395a, ((InstantShoppingReloadDocumentEvent) fbEvent).f23517a.getExtras());
            RichDocumentDelegateImpl.D(this.f23395a);
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33753 extends ProductSavedEventSubscriber {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23398a;

        /* compiled from: Stored user does not match other user in thread. */
        class C33731 implements OnDismissListener {
            final /* synthetic */ C33753 f23396a;

            C33731(C33753 c33753) {
                this.f23396a = c33753;
            }

            public final boolean m24708a(PopoverWindow popoverWindow) {
                this.f23396a.f23398a.f23422R.a();
                return true;
            }
        }

        /* compiled from: Stored user does not match other user in thread. */
        class C33742 implements OnClickListener {
            final /* synthetic */ C33753 f23397a;

            C33742(C33753 c33753) {
                this.f23397a = c33753;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 745811429);
                this.f23397a.f23398a.ar.l();
                Logger.a(2, EntryType.UI_INPUT_END, 315567601, a);
            }
        }

        C33753(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23398a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24710b(FbEvent fbEvent) {
            ProductSavedEvent productSavedEvent = (ProductSavedEvent) fbEvent;
            String M = InstantShoppingDocumentDelegateImpl.m24724M(this.f23398a);
            if (productSavedEvent.f23519a && !this.f23398a.f23414J.b(M)) {
                if (!this.f23398a.f23426V.a(ExperimentsForInstantShoppingAbtestModule.q, false)) {
                    Toast.makeText(this.f23398a.getContext(), this.f23398a.getContext().getResources().getString(2131239251), 0).show();
                } else if (this.f23398a.f23422R.c()) {
                    if (this.f23398a.ar != null && this.f23398a.ar.r) {
                        this.f23398a.ar.l();
                    }
                    View inflate = LayoutInflater.from(this.f23398a.getContext().getApplicationContext()).inflate(2130904957, null);
                    this.f23398a.ar = new PopoverWindow(this.f23398a.getContext().getApplicationContext());
                    this.f23398a.ar.d(inflate);
                    this.f23398a.ar.d(true);
                    this.f23398a.ar.f(FindViewUtil.b(this.f23398a.x, 2131562995));
                    this.f23398a.ar.a(Position.CENTER);
                    this.f23398a.ar.H = new C33731(this);
                    ((TextView) inflate.findViewById(2131563262)).setOnClickListener(new C33742(this));
                }
            }
            this.f23398a.f23414J.a.put(M, Boolean.valueOf(productSavedEvent.f23519a));
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33764 extends ItemRemovedFromCartEventSubscriber {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23399a;

        C33764(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23399a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24712b(FbEvent fbEvent) {
            InstantShoppingCart instantShoppingCart = this.f23399a.f23415K;
            String str = this.f23399a.al;
            instantShoppingCart.a.put(str, Integer.valueOf(Math.max((instantShoppingCart.a.containsKey(str) ? ((Integer) instantShoppingCart.a.get(str)).intValue() : 0) - 1, 0)));
            InstantShoppingDocumentDelegateImpl.m24723K(this.f23399a);
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33775 extends CartClearedEventSubscriber {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23400a;

        C33775(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23400a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24714b(FbEvent fbEvent) {
            InstantShoppingCart instantShoppingCart = this.f23400a.f23415K;
            instantShoppingCart.a.put(this.f23400a.al, Integer.valueOf(0));
            InstantShoppingDocumentDelegateImpl.m24723K(this.f23400a);
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33786 extends ExecuteActionEventSubscriber {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23401a;

        C33786(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23401a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24716b(FbEvent fbEvent) {
            ExecuteActionEvent executeActionEvent = (ExecuteActionEvent) fbEvent;
            if (executeActionEvent.f23515a != null) {
                this.f23401a.f23413I.m24802a(this.f23401a.getContext(), executeActionEvent.f23515a, null, null);
            } else {
                this.f23401a.f23413I.m24803a(this.f23401a.getContext(), executeActionEvent.f23516b, null, null);
            }
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33797 implements OnClickListener {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23402a;

        C33797(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23402a = instantShoppingDocumentDelegateImpl;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 411827329);
            this.f23402a.A.b();
            this.f23402a.ay = C3390x9972f56a.DOCUMENT_BACK_BUTTON_PRESSED;
            this.f23402a.f23421Q.m24883a("back_button_click");
            Logger.a(2, EntryType.UI_INPUT_END, -247157500, a);
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    public class C33808 extends SpanSizeLookup {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23403b;

        public C33808(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23403b = instantShoppingDocumentDelegateImpl;
        }

        public final int m24717a(int i) {
            BlockData e = ((RichDocumentAdapter) this.f23403b.z.o).e(i);
            if (e instanceof HasGridWidth) {
                return GridUtils.a(((HasGridWidth) e).mo1000B());
            }
            return 4;
        }
    }

    /* compiled from: Stored user does not match other user in thread. */
    class C33819 extends BaseFrameRateLoggerCallback {
        final /* synthetic */ InstantShoppingDocumentDelegateImpl f23404a;

        C33819(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
            this.f23404a = instantShoppingDocumentDelegateImpl;
        }

        public final void m24718a(HoneyClientEventFast honeyClientEventFast) {
            honeyClientEventFast.a("instant_shopping_catalog_id", this.f23404a.f23416L.a);
            honeyClientEventFast.a("tracking", this.f23404a.f23407C.f23530f);
        }
    }

    public static void m24730a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InstantShoppingDocumentDelegateImpl) obj).m24727a(RichDocumentEventBus.a(injectorLike), InstantShoppingPageArrow.m25172a(injectorLike), InstantShoppingPageNavBar.m25177a(injectorLike), RichDocumentFontManager.a(injectorLike), RichDocumentFonts.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), InstantShoppingAnalyticsLogger.m24853a(injectorLike), InstantShoppingDidScrollLogger.m24860a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), InstantShoppingDocumentFetcher.a(injectorLike), CatalogLoadSequenceLogger.m24851a(injectorLike), AutoQESpecForInstantShoppingAbtestModule.a(injectorLike), InstantShoppingActionUtils.m24796a(injectorLike), InstantShoppingSaveUtils.a(injectorLike), InstantShoppingCart.a(injectorLike), InstantShoppingDocumentContext.a(injectorLike), InstantShoppingLinkHandler.a(injectorLike), InstantShoppingDwellTimeLogger.m24863a(injectorLike), InstantShoppingElementDwellTimeLogger.m24873a(injectorLike), RichDocumentScrollDepthLogger.a(injectorLike), InstantShoppingLoggingUtils.m24879a(injectorLike), TipSeenTracker.a(injectorLike), InstantShoppingPerfInfoLogger.m24887a(injectorLike), InstantShoppingSessionIDGenerator.m24889a(injectorLike), InstantShoppingSurveyController.m24787a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FunnelLoggerImpl.a(injectorLike), RichDocumentSessionTracker.a(injectorLike), IdBasedLazy.a(injectorLike, 10295));
    }

    private void m24727a(RichDocumentEventBus richDocumentEventBus, InstantShoppingPageArrow instantShoppingPageArrow, InstantShoppingPageNavBar instantShoppingPageNavBar, RichDocumentFontManager richDocumentFontManager, RichDocumentFonts richDocumentFonts, FrameRateLoggerProvider frameRateLoggerProvider, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, InstantShoppingDidScrollLogger instantShoppingDidScrollLogger, Lazy<FbErrorReporter> lazy, InstantShoppingDocumentFetcher instantShoppingDocumentFetcher, CatalogLoadSequenceLogger catalogLoadSequenceLogger, AutoQESpecForInstantShoppingAbtestModule autoQESpecForInstantShoppingAbtestModule, InstantShoppingActionUtils instantShoppingActionUtils, InstantShoppingSaveUtils instantShoppingSaveUtils, InstantShoppingCart instantShoppingCart, InstantShoppingDocumentContext instantShoppingDocumentContext, InstantShoppingLinkHandler instantShoppingLinkHandler, InstantShoppingDwellTimeLogger instantShoppingDwellTimeLogger, InstantShoppingElementDwellTimeLogger instantShoppingElementDwellTimeLogger, RichDocumentScrollDepthLogger richDocumentScrollDepthLogger, InstantShoppingLoggingUtils instantShoppingLoggingUtils, TipSeenTracker tipSeenTracker, InstantShoppingPerfInfoLogger instantShoppingPerfInfoLogger, InstantShoppingSessionIDGenerator instantShoppingSessionIDGenerator, InstantShoppingSurveyController instantShoppingSurveyController, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences, FunnelLogger funnelLogger, RichDocumentSessionTracker richDocumentSessionTracker, Lazy<RichDocumentInfo> lazy2) {
        this.f23431w = richDocumentEventBus;
        this.f23432x = instantShoppingPageArrow;
        this.f23433y = instantShoppingPageNavBar;
        this.f23434z = richDocumentFontManager;
        this.f23405A = richDocumentFonts;
        this.f23406B = frameRateLoggerProvider;
        this.f23407C = instantShoppingAnalyticsLogger;
        this.f23408D = instantShoppingDidScrollLogger;
        this.f23409E = lazy;
        this.f23410F = instantShoppingDocumentFetcher;
        this.f23411G = catalogLoadSequenceLogger;
        this.f23412H = autoQESpecForInstantShoppingAbtestModule;
        this.f23413I = instantShoppingActionUtils;
        this.f23414J = instantShoppingSaveUtils;
        this.f23415K = instantShoppingCart;
        this.f23416L = instantShoppingDocumentContext;
        this.f23417M = instantShoppingLinkHandler;
        this.f23418N = instantShoppingDwellTimeLogger;
        this.f23419O = instantShoppingElementDwellTimeLogger;
        this.f23420P = richDocumentScrollDepthLogger;
        this.f23421Q = instantShoppingLoggingUtils;
        this.f23422R = tipSeenTracker;
        this.f23423S = instantShoppingPerfInfoLogger;
        this.f23424T = instantShoppingSessionIDGenerator;
        this.f23425U = instantShoppingSurveyController;
        this.f23426V = qeAccessor;
        this.f23427W = fbSharedPreferences;
        this.f23428X = funnelLogger;
        this.f23429Y = richDocumentSessionTracker;
        this.f23430Z = lazy2;
    }

    private void m24733b(InstantShoppingBlocks instantShoppingBlocks) {
        String a = instantShoppingBlocks.f23585e.a();
        if (a != null) {
            int parseColor = Color.parseColor(m24737c(a));
            this.af.f23457b = parseColor;
            this.ad.setBackgroundColor(parseColor);
        }
    }

    protected final RichDocumentBlocksImpl m24749a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        Object obj2 = graphQLResult.e;
        InstantShoppingDocumentFragmentModel a = InstantShoppingDocumentUtils.a(obj2);
        if (a == null || a.k() == null) {
            return null;
        }
        ImmutableBiMap b = ImmutableBiMap.b("instant_shopping_num_blocks_fetched", String.valueOf(a.k().a().size()));
        this.f23411G.m24849b("instant_shopping_graphql_first_fetch", b);
        this.f23411G.m24847a("instant_shopping_first_parse", b);
        DocumentBodyElementsModel b2 = a.b();
        int i = -1;
        if (a.a() != null) {
            i = a.a().startsWith("#") ? Color.parseColor(a.a()) : Color.parseColor("#" + a.a());
        }
        Collection a2 = InstantShoppingBlocksUtil.m24894a(b2, i);
        InstantShoppingBlocks instantShoppingBlocks = new InstantShoppingBlocks(null);
        instantShoppingBlocks.a(a2);
        this.aj = instantShoppingBlocks;
        this.at = a.o();
        this.aj.f23582b = a.q();
        InstantShoppingBlocks instantShoppingBlocks2 = this.aj;
        instantShoppingBlocks2.f23585e = InstantShoppingDocumentUtils.a(obj2);
        instantShoppingBlocks2.f23584d = InstantShoppingDocumentUtils.a(obj2).l();
        instantShoppingBlocks2.f23583c = InstantShoppingDocumentUtils.a(obj2).m();
        instantShoppingBlocks2.f23586f = InstantShoppingDocumentUtils.a(obj2).j();
        this.f23411G.m24848b("instant_shopping_first_parse");
        this.f23431w.a(new RichDocumentBlocksAppendedEvent(this.aj, graphQLResult.freshness));
        m24726a(a);
        m24738c(a.p());
        m24723K(this);
        m24722J();
        return this.aj;
    }

    public final View m24753b(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.af = new InstantShoppingItemDecorator(getContext());
        Class cls = InstantShoppingDocumentDelegateImpl.class;
        m24730a((Object) this, getContext());
        this.ak = Long.toString(this.f23424T.f23577a.a());
        View b = super.b(layoutInflater, viewGroup, bundle);
        this.ad = (LinearLayout) b.findViewById(2131563246);
        this.as = (LoadingIndicatorView) b.findViewById(2131560407);
        return b;
    }

    public final void m24750a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f23423S.f23566e = this.y.getLong("click_time", 0);
    }

    protected final void m24768y() {
        super.y();
        this.f23431w.a(this.az);
        this.f23431w.a(this.aC);
        this.f23431w.a(this.aD);
        this.f23431w.a(this.aE);
        this.f23431w.a(this.aB);
        this.f23431w.a(this.aA);
        this.ao = m24742h(this.y);
        this.f23416L.c = this.ao;
        m24725N();
        this.f23422R.a(InstantShoppingPrefKeys.f23462d);
        this.f23411G.m24848b("instant_shopping_catalog_activity");
        m24739e(this, this.y);
        this.f23428X.a(FunnelRegistry.y);
        this.f23428X.a(FunnelRegistry.y, m24724M(this));
        if (StringUtil.c(this.aq) && StringUtil.c(this.al)) {
            this.ay = C3390x9972f56a.DOCUMENT_CLOSED_ON_PRELAUNCH;
            n();
        }
    }

    public final LinearLayoutManager m24747a(BetterRecyclerView betterRecyclerView) {
        InstantShoppingGridLayoutManager instantShoppingGridLayoutManager = new InstantShoppingGridLayoutManager(getContext(), betterRecyclerView, 4);
        instantShoppingGridLayoutManager.h = new C33808(this);
        return instantShoppingGridLayoutManager;
    }

    protected final int m24762q() {
        return 2130904980;
    }

    protected final void m24767x() {
        super.x();
        ((RichDocumentInfo) this.f23430Z.get()).h = this.aj.c();
        this.as.b();
    }

    protected final void m24766w() {
        super.w();
        this.as.a();
    }

    protected final View m24748a(View view) {
        return view.findViewById(2131560407);
    }

    @Nullable
    protected final ItemDecoration m24763r() {
        return this.af;
    }

    private void m24729a(ImmutableList<FooterElementsModel> immutableList, InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel) {
        this.ai = new InstantShoppingFooter(this.x, instantShoppingDocumentFragmentModel.n());
        this.ai.m24779a(immutableList, instantShoppingDocumentFragmentModel);
    }

    protected final void m24755b(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        InstantShoppingBlocks instantShoppingBlocks = (InstantShoppingBlocks) richDocumentBlocksImpl;
        ImmutableList immutableList = instantShoppingBlocks.f23586f;
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(new InstantShoppingFontResourceWrapper((InstantShoppingFontObjectFragmentModel) immutableList.get(i)));
        }
        Set hashSet = new HashSet();
        for (int i2 = 0; i2 < instantShoppingBlocks.c(); i2++) {
            BlockData a = instantShoppingBlocks.a(i2);
            if (!(!(a instanceof HasTextMetrics) || ((HasTextMetrics) a).nu_() == null || StringUtil.a(((HasTextMetrics) a).nu_().a()))) {
                hashSet.add(((HasTextMetrics) a).nu_().a());
            }
        }
        Set set = hashSet;
        this.f23405A.a = RichDocumentFontManager.a(set, this.f23434z.a(builder.b(), set, false));
        m24733b(instantShoppingBlocks);
        this.ag = instantShoppingBlocks.f23585e.q();
        m24734b(instantShoppingBlocks.f23583c, instantShoppingBlocks.f23585e);
        m24729a(instantShoppingBlocks.f23584d, instantShoppingBlocks.f23585e);
        this.z.o.notifyDataSetChanged();
        this.f23432x.m25174a(this.x);
        this.af.f23456a.clear();
        InstantShoppingDidScrollLogger instantShoppingDidScrollLogger = this.f23408D;
        instantShoppingDidScrollLogger.f23535b.a(instantShoppingDidScrollLogger);
    }

    private void m24734b(ImmutableList<HeaderElementsModel> immutableList, InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel) {
        DocumentBodyElementsModel k = instantShoppingDocumentFragmentModel.k();
        if (k != null) {
            NodeModel a;
            ImmutableList a2 = k.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                ShoppingDocumentElementsEdgeModel shoppingDocumentElementsEdgeModel = (ShoppingDocumentElementsEdgeModel) a2.get(i);
                if (shoppingDocumentElementsEdgeModel.a() != null && shoppingDocumentElementsEdgeModel.a().c() == GraphQLInstantShoppingDocumentElementType.HEADER) {
                    a = shoppingDocumentElementsEdgeModel.a();
                    break;
                }
            }
            a = null;
            String b = (a == null || a.d() == null) ? "#00000000" : a.d().b();
            m24731a(b);
            this.f23433y.m25184a(this.x, m24724M(this), m24746D(), this.A, this.at, m24732a(m24737c(b), m24737c(instantShoppingDocumentFragmentModel.a())));
            OnClickListener c33797 = new C33797(this);
            this.f23433y.m25183a(c33797);
            boolean contains = this.at.contains(GraphQLInstantShoppingDocumentPresentationStyle.AUDIO_CONTROL_FLOATING);
            if (InstantShoppingBlocksUtil.f23588a && contains) {
                contains = true;
            } else {
                contains = false;
            }
            this.au = contains;
            if (this.au) {
                this.f23433y.m25185b();
            } else {
                this.f23427W.edit().putBoolean((PrefKey) InstantShoppingPrefKeys.f23464f.a(m24724M(this)), true).commit();
            }
            if (StringUtil.a(this.ag)) {
                this.ac.setVisibility(8);
            } else {
                this.ac.setText(this.ag);
            }
            if (!m24736b((ImmutableList) immutableList)) {
                if (a != null && !a.A().isEmpty()) {
                    m24728a(a.A());
                } else if (StringUtil.a(this.ag)) {
                    m24721G();
                    m24720F();
                    this.f23433y.m25183a(c33797);
                    if (this.au) {
                        this.f23433y.m25185b();
                    }
                    this.f23433y.m25187c();
                }
            }
        }
    }

    private void m24731a(String str) {
        String c = m24737c(str);
        Object obj = null;
        if (c != null && ((float) Color.alpha(Color.parseColor(c))) < 255.0f) {
            obj = 1;
        }
        if (obj != null) {
            this.ae = (LinearLayout) this.x.findViewById(2131563318);
            m24720F();
        } else {
            this.ae = (LinearLayout) this.x.findViewById(2131559592);
            m24721G();
        }
        this.ac = (BetterTextView) this.ae.findViewById(2131563311);
        if (c != null) {
            this.ae.setBackground(new ColorDrawable(Color.parseColor(c)));
        }
    }

    private void m24728a(ImmutableList<? extends HeaderElements> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            InstantShoppingHeaderElementFragmentModel.HeaderElementsModel headerElementsModel = (InstantShoppingHeaderElementFragmentModel.HeaderElementsModel) immutableList.get(i);
            switch (AnonymousClass11.f23392a[headerElementsModel.c().ordinal()]) {
                case 1:
                    HeaderBlockPresenter logoHeaderBlockPresenter = new LogoHeaderBlockPresenter(new HeaderLogoBlockViewImpl(this.ae), headerElementsModel);
                    InstantShoppingBlocksUtil.m24895b();
                    logoHeaderBlockPresenter.mo1024b();
                    this.ac.setVisibility(8);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
            if (!(headerElementsModel.d() == null || headerElementsModel.d().g() == null || headerElementsModel.d().g().iP_() == null)) {
                this.ac.setTextColor(Color.parseColor(m24737c(headerElementsModel.d().g().iP_())));
            }
            this.ag = headerElementsModel.iK_() != null ? headerElementsModel.iK_().d() : this.ag;
            this.ac.setText(this.ag);
        }
    }

    private boolean m24736b(ImmutableList<HeaderElementsModel> immutableList) {
        if (immutableList == null || immutableList.size() == 0) {
            return false;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            HeaderElementsModel headerElementsModel = (HeaderElementsModel) immutableList.get(i);
            HeaderBlockPresenter checkoutHeaderBlockPresenter;
            HeaderBlockPresenter headerBlockPresenter;
            switch (AnonymousClass11.f23393b[headerElementsModel.b().ordinal()]) {
                case 1:
                    this.ah = new CheckoutHeaderBlockViewImpl(this.ae);
                    checkoutHeaderBlockPresenter = new CheckoutHeaderBlockPresenter(this.ah, headerElementsModel);
                    InstantShoppingBlocksUtil.m24895b();
                    checkoutHeaderBlockPresenter.mo1024b();
                    m24719E();
                    headerBlockPresenter = checkoutHeaderBlockPresenter;
                    break;
                case 2:
                    checkoutHeaderBlockPresenter = new SaveHeaderBlockPresenter(new SaveHeaderBlockViewImpl(this.ae), headerElementsModel);
                    InstantShoppingBlocksUtil.m24895b();
                    checkoutHeaderBlockPresenter.mo1024b();
                    m24719E();
                    headerBlockPresenter = checkoutHeaderBlockPresenter;
                    break;
                default:
                    obj = null;
                    break;
            }
            this.ab.add(obj);
        }
        return true;
    }

    private void m24720F() {
        View findViewById = this.x.findViewById(2131559592);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.setMargins(0, 0, 0, 0);
        findViewById.setLayoutParams(layoutParams);
    }

    private void m24721G() {
        View findViewById = this.x.findViewById(2131563318);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.setMargins(0, 0, 0, 0);
        findViewById.setLayoutParams(layoutParams);
    }

    private static boolean m24732a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        boolean z = str == null || Color.alpha(Color.parseColor(str)) < 50;
        if (!z) {
            str2 = str;
        }
        if (str2 == null) {
            return true;
        }
        int parseColor = Color.parseColor(str2);
        if (((int) ((((double) ((float) Color.blue(parseColor))) * 0.0721d) + ((((double) ((float) Color.green(parseColor))) * 0.7154d) + (0.2125d * ((double) ((float) Color.red(parseColor))))))) <= 127) {
            return false;
        }
        return true;
    }

    @Nullable
    private static String m24737c(String str) {
        if (str == null) {
            return null;
        }
        return !str.startsWith("#") ? "#" + str : str;
    }

    protected final void m24760k() {
        super.k();
        ((RichDocumentEventBus) this.a.get()).a(new ScrollValueChangedEvent(this.z, 0, 0));
        FrameRateLogger a = this.f23406B.a(Boolean.valueOf(false), "instant_shoppin_scroller", Optional.of("instant_shopping".toString()));
        a.n = new C33819(this);
        a(this.z, a);
    }

    public final AbstractSequenceDefinition m24745C() {
        return InstantShoppingSequences.f23575a;
    }

    protected final RichDocumentFetcher<GraphQLRequest<T>, GraphQLResult<T>> m24764u() {
        return this.f23410F;
    }

    protected final RichDocumentFetchParams<GraphQLRequest<T>> m24765v() {
        InstantShoppingFetchParams instantShoppingFetchParams = new InstantShoppingFetchParams(getContext(), this.al);
        instantShoppingFetchParams.d = this.aq;
        instantShoppingFetchParams.a = this.am;
        instantShoppingFetchParams.b = this.an;
        instantShoppingFetchParams.f = this.ap;
        if (!StringUtil.c(this.aq)) {
            this.f23411G.m24848b("instant_shopping_catalog_activity");
        }
        return instantShoppingFetchParams;
    }

    public final Map<String, Object> m24756c() {
        Object f = m24740f(this.y) != null ? m24740f(this.y) : m24743i(this.y);
        String g = m24741g(this.y);
        String str = this.ak;
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("instant_shopping_catalog_id", f);
        if (g != null) {
            hashMap.put("instant_shopping_catalog_view", g);
        }
        hashMap.put("instant_shopping_catalog_session_id", str);
        return hashMap;
    }

    private void m24719E() {
        View findViewById = this.x.findViewById(2131563311);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
    }

    protected final void m24751a(Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) this.f23409E.get();
        SoftErrorBuilder a = SoftError.a(aa + ".onFetchError", "Error attempting to more blocks. catalog id(" + this.al + ")");
        a.c = th;
        abstractFbErrorReporter.a(a.g());
        this.f23411G.m24850c("instant_shopping_graphql_first_fetch");
    }

    private void m24726a(InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel) {
        int a = this.f23412H.b().a.a("prefetch_document_links_on_open", 0);
        if (a != 0 && instantShoppingDocumentFragmentModel != null && instantShoppingDocumentFragmentModel.k() != null) {
            ImmutableList a2 = instantShoppingDocumentFragmentModel.k().a();
            int i = 0;
            while (i < a2.size() && i < a) {
                NodeModel j = ((ShoppingDocumentElementsEdgeModel) a2.get(i)).j();
                if ((j.c() == GraphQLInstantShoppingDocumentElementType.PHOTO || j.c() == GraphQLInstantShoppingDocumentElementType.BUTTON) && j.C() != null) {
                    this.f23417M.a(getContext(), j.C());
                }
                i++;
            }
        }
    }

    private void m24738c(ImmutableList<String> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            InstantShoppingActionUtils instantShoppingActionUtils = this.f23413I;
            instantShoppingActionUtils.f23490d.a(new GetRequestAsyncTask(instantShoppingActionUtils, str, new C33853(instantShoppingActionUtils, str)), new Void[0]);
        }
    }

    private void m24722J() {
        String M = m24724M(this);
        if (this.f23414J.b(M)) {
            boolean a = this.f23414J.a(M);
            for (HeaderBlockPresenter headerBlockPresenter : this.ab) {
                if (headerBlockPresenter instanceof SaveHeaderBlockPresenter) {
                    ((SaveHeaderBlockViewImpl) ((SaveHeaderBlockPresenter) headerBlockPresenter).d).m25113a(a);
                }
            }
            if (this.ai != null) {
                InstantShoppingFooter instantShoppingFooter = this.ai;
                if (instantShoppingFooter.f23449d != null) {
                    instantShoppingFooter.f23449d.m25002a(a);
                }
            }
        }
    }

    public static void m24723K(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
        int c = instantShoppingDocumentDelegateImpl.f23415K.c(instantShoppingDocumentDelegateImpl.al);
        for (HeaderBlockPresenter headerBlockPresenter : instantShoppingDocumentDelegateImpl.ab) {
            if (headerBlockPresenter instanceof CheckoutHeaderBlockPresenter) {
                ((CheckoutHeaderBlockViewImpl) ((CheckoutHeaderBlockPresenter) headerBlockPresenter).d).m25041a(c);
            }
        }
    }

    public final void m24759f() {
        super.f();
        this.f23421Q.m24883a("canvas_pause");
        this.f23418N.m24865a();
        this.f23423S.f23571j = this.f23420P.b();
        InstantShoppingPerfInfoLogger instantShoppingPerfInfoLogger = this.f23423S;
        InstantShoppingDwellTimeLogger instantShoppingDwellTimeLogger = this.f23418N;
        instantShoppingPerfInfoLogger.f23572k = instantShoppingDwellTimeLogger.f23541c + instantShoppingDwellTimeLogger.f23543e;
        instantShoppingPerfInfoLogger = this.f23423S;
        if (!(instantShoppingPerfInfoLogger.f23567f || StringUtil.a(instantShoppingPerfInfoLogger.f23573l.a) || instantShoppingPerfInfoLogger.f23568g == 0 || instantShoppingPerfInfoLogger.f23569h == 0)) {
            long longValue;
            Map hashMap = new HashMap();
            hashMap.put("TTI", Long.valueOf(instantShoppingPerfInfoLogger.f23568g));
            String str = "catalog_download_time";
            InstantShoppingDocumentFetcher instantShoppingDocumentFetcher = instantShoppingPerfInfoLogger.f23562a;
            String str2 = instantShoppingPerfInfoLogger.f23573l.a;
            if (instantShoppingDocumentFetcher.c.containsKey(str2)) {
                longValue = ((Long) instantShoppingDocumentFetcher.c.get(str2)).longValue();
            } else {
                longValue = 0;
            }
            hashMap.put(str, Long.valueOf(longValue));
            hashMap.put("catalog_render_time", Long.valueOf(instantShoppingPerfInfoLogger.f23569h));
            hashMap.put("catalog_content_cached", Boolean.valueOf(instantShoppingPerfInfoLogger.f23570i));
            hashMap.put("dwell_time", Long.valueOf(instantShoppingPerfInfoLogger.f23572k));
            hashMap.put("depth_percent", Float.valueOf(instantShoppingPerfInfoLogger.f23571j));
            instantShoppingPerfInfoLogger.f23563b.m24859a("instant_shopping_perf_event", hashMap);
            instantShoppingPerfInfoLogger.f23567f = true;
        }
        this.f23407C.m24858a("instant_shopping_document_pause");
        this.f23419O.m24875a();
    }

    public final void m24758e() {
        super.e();
        this.f23421Q.m24883a("canvas_resume");
        if (m24744k(this.y) == null) {
            this.f23407C.f23529e = null;
        }
        m24723K(this);
        m24725N();
        this.f23407C.m24858a("instant_shopping_document_resume");
        InstantShoppingDwellTimeLogger instantShoppingDwellTimeLogger = this.f23418N;
        instantShoppingDwellTimeLogger.f23544f = false;
        instantShoppingDwellTimeLogger.f23540b = SystemClock.uptimeMillis();
        if (instantShoppingDwellTimeLogger.f23542d > 0) {
            instantShoppingDwellTimeLogger.f23543e += instantShoppingDwellTimeLogger.f23540b - instantShoppingDwellTimeLogger.f23542d;
        }
        instantShoppingDwellTimeLogger.f23542d = -1;
        for (Entry value : this.f23419O.f23553a.entrySet()) {
            ElementDwellTime elementDwellTime = (ElementDwellTime) value.getValue();
            if (elementDwellTime.f23547c) {
                elementDwellTime.m24872d();
            }
        }
    }

    public final void m24757d() {
        super.d();
        InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger = this.f23407C;
        Map c = m24756c();
        JsonNode jsonNode = this.ao;
        for (String str : c.keySet()) {
            instantShoppingAnalyticsLogger.f23528d.put(str, c.get(str));
        }
        if (jsonNode != null) {
            instantShoppingAnalyticsLogger.f23530f = jsonNode;
        }
        this.am = m24744k(this.y);
        if (this.am != null) {
            Map hashMap = new HashMap();
            hashMap.put("instant_shopping_product_id", this.am);
            hashMap.put("instant_shopping_product_view", this.an);
            this.f23407C.f23529e = hashMap;
        }
        this.ax = new HashMap();
        this.f23407C.m24858a("instant_shopping_document_open");
        InstantShoppingSurveyController instantShoppingSurveyController = this.f23425U;
        String str2 = this.al;
        String str3 = this.am;
        if (str2 != null && str3 == null) {
            instantShoppingSurveyController.f23468c = true;
        } else if (str3 != null) {
            instantShoppingSurveyController.f23469d = true;
        }
    }

    public final void m24761n() {
        if (!this.av) {
            this.av = true;
            if (this.A.a() && this.ay == null) {
                this.ay = C3390x9972f56a.DOCUMENT_SWIPED_BACK;
            }
            if (this.ay == null) {
                this.ay = C3390x9972f56a.UNKNOWN;
            }
            this.f23418N.m24866c();
            Map map = this.ax;
            InstantShoppingDwellTimeLogger instantShoppingDwellTimeLogger = this.f23418N;
            Map hashMap = new HashMap();
            hashMap.put("canvas_dwell_time", Long.valueOf(instantShoppingDwellTimeLogger.f23541c));
            hashMap.put("links_dwell_time", Long.valueOf(instantShoppingDwellTimeLogger.f23543e));
            instantShoppingDwellTimeLogger.f23541c = 0;
            instantShoppingDwellTimeLogger.f23542d = 0;
            instantShoppingDwellTimeLogger.f23543e = 0;
            instantShoppingDwellTimeLogger.f23540b = 0;
            InstantShoppingLoggingUtils.m24881a(map, hashMap);
            InstantShoppingLoggingUtils.m24880a(this.ax, "depth_percent", Float.valueOf(this.f23420P.b()));
            InstantShoppingLoggingUtils.m24880a(this.ax, "canvas_depth", Integer.valueOf(this.f23429Y.c(getContext())));
            InstantShoppingLoggingUtils.m24880a(this.ax, "document_closed", this.ay.toString());
            InstantShoppingLoggingUtils.m24880a(this.ax, "element_dwell_time", this.f23419O.m24878c());
            map = this.ax;
            if (!this.aw) {
                this.aw = true;
                this.f23407C.m24859a("instant_shopping_document_close", map);
            }
            this.f23429Y.b(getContext());
            super.n();
            this.f23428X.b(FunnelRegistry.y);
            if (this.au) {
                m24735b("instant_shopping_audio_button_on_exit", String.valueOf(this.f23427W.a((PrefKey) InstantShoppingPrefKeys.f23464f.a(this.f23416L.a), false)));
            }
            this.f23418N.m24866c();
            this.f23425U.m24789a(this.al, this.am, getContext());
        }
    }

    public final boolean m24752a() {
        this.ay = C3390x9972f56a.ANDROID_BACK_BUTTON_PRESSED;
        return super.a();
    }

    public final void m24754b(Bundle bundle) {
        super.b(bundle);
        bundle.putString("instant_shopping_catalog_session_id", this.ak);
    }

    private void m24735b(String str, final String str2) {
        this.f23407C.m24859a(str, new HashMap<String, Object>() {
        });
    }

    public static void m24739e(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl, Bundle bundle) {
        instantShoppingDocumentDelegateImpl.aq = m24743i(bundle);
        instantShoppingDocumentDelegateImpl.al = m24740f(bundle);
        instantShoppingDocumentDelegateImpl.ap = m24741g(bundle);
        instantShoppingDocumentDelegateImpl.am = m24744k(bundle);
        instantShoppingDocumentDelegateImpl.an = bundle.getString("extra_instant_shopping_product_view");
    }

    public static String m24724M(InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl) {
        if (StringUtil.a(instantShoppingDocumentDelegateImpl.aq)) {
            return StringUtil.a(instantShoppingDocumentDelegateImpl.am) ? instantShoppingDocumentDelegateImpl.al : instantShoppingDocumentDelegateImpl.am;
        } else {
            return instantShoppingDocumentDelegateImpl.aq;
        }
    }

    private void m24725N() {
        this.f23416L.a = m24724M(this);
        this.f23416L.b = this.al;
    }

    private static String m24740f(Bundle bundle) {
        return bundle.getString("extra_instant_shopping_catalog_id");
    }

    private static String m24741g(Bundle bundle) {
        return bundle.getString("extra_instant_shopping_catalog_view");
    }

    private static JsonNode m24742h(Bundle bundle) {
        String string = bundle.getString("tracking_codes");
        if (string == null) {
            return null;
        }
        try {
            return FbObjectMapper.i().a(string);
        } catch (JsonProcessingException e) {
            throw new ParcelFormatException("Failed to process event " + e.toString());
        } catch (IOException e2) {
            throw new ParcelFormatException("Failed to process event " + e2.toString());
        }
    }

    private static String m24743i(Bundle bundle) {
        return bundle.getString("extra_native_document_id");
    }

    private static String m24744k(Bundle bundle) {
        return bundle.getString("extra_instant_shopping_product_id");
    }

    public final int m24746D() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        return audioManager != null ? (audioManager.getStreamVolume(3) * 100) / 15 : -1;
    }
}
