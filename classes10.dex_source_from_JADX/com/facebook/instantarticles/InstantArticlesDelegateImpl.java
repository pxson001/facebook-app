package com.facebook.instantarticles;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.facebook.browser.lite.products.messagingbusiness.banner.AbstractBusinessSubscriptionBannerUtil.SubscriptionBannerListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.instantarticles.fetcher.InstantArticlesFetchParams;
import com.facebook.instantarticles.fetcher.InstantArticlesFetcher;
import com.facebook.instantarticles.logging.InstantArticlesSequences;
import com.facebook.instantarticles.model.data.RichDocumentMasterAdapter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.subscription.instantarticle.graphql.BusinessSubscriptionIAQueries.BusinessSubscriptionMessengerContentSubscribedQueryString;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionBannerPresenter;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionBannerPresenter.1;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionBannerPresenterProvider;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionLoader;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionLoader.IASubscriptionTask;
import com.facebook.messaging.business.subscription.instantarticle.view.BusinessIASubscribeBannerView;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentMediaTransitionEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentPrefetchRequestEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.ScrollValueChangedEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaTransitionEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentPrefetchRequest;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import com.facebook.richdocument.fetcher.BaseRichDocumentFetcher;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import com.facebook.richdocument.fetcher.RichDocumentImagePrefetcher;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentMaster;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.widget.ImageButtonWithTouchSpring;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: view_mediaset */
public class InstantArticlesDelegateImpl extends BaseInstantArticlesDelegateImpl<GraphQLRequest<RichDocumentMaster>, GraphQLResult<RichDocumentMaster>> implements InstantArticlesDelegate {
    private static final String f460T = InstantArticlesDelegateImpl.class.getSimpleName();
    @Inject
    InstantArticlesFetcher f461K;
    @Inject
    RichDocumentImagePrefetcher f462L;
    @Inject
    RichDocumentLayoutDirection f463M;
    @Inject
    GatekeeperStoreImpl f464N;
    @Inject
    BusinessIASubscriptionBannerPresenterProvider f465O;
    @Inject
    public RichDocumentAnalyticsLogger f466P;
    @Inject
    public Lazy<RichDocumentEventBus> f467Q;
    @Inject
    public HamDimensions f468R;
    @Inject
    Lazy<RichDocumentInfo> f469S;
    @Nullable
    private BusinessIASubscribeBannerView f470U;
    public BusinessIASubscriptionBannerPresenter f471V;
    public final ScrollValueChangedEventSubscriber f472W = new C00721(this);
    private final RichDocumentPrefetchRequestEventSubscriber f473X = new C00732(this);

    /* compiled from: view_mediaset */
    class C00721 extends ScrollValueChangedEventSubscriber {
        final /* synthetic */ InstantArticlesDelegateImpl f443a;

        C00721(InstantArticlesDelegateImpl instantArticlesDelegateImpl) {
            this.f443a = instantArticlesDelegateImpl;
        }

        public final void m556b(FbEvent fbEvent) {
            this.f443a.f471V.a(((ScrollValueChangedEvent) fbEvent).b);
        }
    }

    /* compiled from: view_mediaset */
    class C00732 extends RichDocumentPrefetchRequestEventSubscriber {
        final /* synthetic */ InstantArticlesDelegateImpl f444a;

        C00732(InstantArticlesDelegateImpl instantArticlesDelegateImpl) {
            this.f444a = instantArticlesDelegateImpl;
        }

        public final void m557b(FbEvent fbEvent) {
            this.f444a.f461K.a(this.f444a.getContext(), ((RichDocumentPrefetchRequest) fbEvent).a);
        }
    }

    /* compiled from: view_mediaset */
    class C00754 implements SubscriptionBannerListener {
        final /* synthetic */ InstantArticlesDelegateImpl f447a;

        C00754(InstantArticlesDelegateImpl instantArticlesDelegateImpl) {
            this.f447a = instantArticlesDelegateImpl;
        }

        public final void m558a() {
            ((RichDocumentEventBus) this.f447a.f467Q.get()).a(this.f447a.f472W);
        }

        public final void m559b() {
            ((RichDocumentEventBus) this.f447a.f467Q.get()).b(this.f447a.f472W);
        }
    }

    /* compiled from: view_mediaset */
    public class AutoScrollToTopButtonController {
        public final ImageButtonWithTouchSpring f453a;
        private final RichDocumentEventBus f454b;
        private final ScrollValueChangedEventSubscriber f455c = new C00761(this);
        private final RichDocumentMediaTransitionEventSubscriber f456d = new C00772(this);
        public boolean f457e;
        public int f458f;
        public int f459g;

        /* compiled from: view_mediaset */
        class C00761 extends ScrollValueChangedEventSubscriber {
            final /* synthetic */ AutoScrollToTopButtonController f448a;

            C00761(AutoScrollToTopButtonController autoScrollToTopButtonController) {
                this.f448a = autoScrollToTopButtonController;
            }

            public final void m560b(FbEvent fbEvent) {
                ScrollValueChangedEvent scrollValueChangedEvent = (ScrollValueChangedEvent) fbEvent;
                AutoScrollToTopButtonController autoScrollToTopButtonController = this.f448a;
                autoScrollToTopButtonController.f459g += scrollValueChangedEvent.b;
                if (Math.abs(this.f448a.f459g) > this.f448a.f458f) {
                    AutoScrollToTopButtonController.m562a(this.f448a);
                }
            }
        }

        /* compiled from: view_mediaset */
        class C00772 extends RichDocumentMediaTransitionEventSubscriber {
            final /* synthetic */ AutoScrollToTopButtonController f449a;

            C00772(AutoScrollToTopButtonController autoScrollToTopButtonController) {
                this.f449a = autoScrollToTopButtonController;
            }

            public final void m561b(FbEvent fbEvent) {
                RichDocumentMediaTransitionEvent richDocumentMediaTransitionEvent = (RichDocumentMediaTransitionEvent) fbEvent;
                MediaTransitionState mediaTransitionState = richDocumentMediaTransitionEvent.b;
                if (!this.f449a.f457e) {
                    this.f449a.f457e = true;
                    if (mediaTransitionState.equals(MediaTransitionState.b) || mediaTransitionState.equals(MediaTransitionState.c) || mediaTransitionState.equals(MediaTransitionState.d)) {
                        AutoScrollToTopButtonController.m563a(this.f449a, 1, null);
                    } else {
                        AutoScrollToTopButtonController.m563a(this.f449a, 0, null);
                    }
                }
                if (richDocumentMediaTransitionEvent.d) {
                    this.f449a.f457e = false;
                }
            }
        }

        /* compiled from: view_mediaset */
        class C00783 extends AnimatorListenerAdapter {
            final /* synthetic */ AutoScrollToTopButtonController f450a;

            C00783(AutoScrollToTopButtonController autoScrollToTopButtonController) {
                this.f450a = autoScrollToTopButtonController;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.f450a.f453a != null && this.f450a.f453a.getParent() != null && (this.f450a.f453a.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f450a.f453a.getParent()).removeView(this.f450a.f453a);
                }
            }
        }

        public AutoScrollToTopButtonController(ImageButtonWithTouchSpring imageButtonWithTouchSpring, RichDocumentEventBus richDocumentEventBus) {
            this.f453a = imageButtonWithTouchSpring;
            this.f454b = richDocumentEventBus;
            this.f458f = this.f453a.getResources().getDisplayMetrics().heightPixels / 2;
            this.f454b.a(this.f455c);
            this.f454b.a(this.f456d);
        }

        public static void m562a(AutoScrollToTopButtonController autoScrollToTopButtonController) {
            autoScrollToTopButtonController.f454b.b(autoScrollToTopButtonController.f455c);
            autoScrollToTopButtonController.f454b.b(autoScrollToTopButtonController.f456d);
            m563a(autoScrollToTopButtonController, 1, new C00783(autoScrollToTopButtonController));
        }

        public static void m563a(AutoScrollToTopButtonController autoScrollToTopButtonController, int i, AnimatorListener animatorListener) {
            final ViewPropertyAnimator duration = autoScrollToTopButtonController.f453a.animate().alpha(i == 0 ? 1.0f : 0.0f).setDuration(500);
            if (animatorListener != null) {
                duration.setListener(animatorListener);
            } else {
                duration.setListener(new AnimatorListenerAdapter(autoScrollToTopButtonController) {
                    final /* synthetic */ AutoScrollToTopButtonController f452b;

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        duration.setListener(null);
                    }
                });
            }
            duration.start();
        }
    }

    public static void m566a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InstantArticlesDelegateImpl) obj).m564a(InstantArticlesFetcher.a(fbInjector), RichDocumentImagePrefetcher.a(fbInjector), RichDocumentLayoutDirection.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), (BusinessIASubscriptionBannerPresenterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BusinessIASubscriptionBannerPresenterProvider.class), RichDocumentAnalyticsLogger.a(fbInjector), IdBasedLazy.a(fbInjector, 10298), HamDimensions.a(fbInjector), IdBasedLazy.a(fbInjector, 10295));
    }

    private void m564a(InstantArticlesFetcher instantArticlesFetcher, RichDocumentImagePrefetcher richDocumentImagePrefetcher, RichDocumentLayoutDirection richDocumentLayoutDirection, GatekeeperStore gatekeeperStore, BusinessIASubscriptionBannerPresenterProvider businessIASubscriptionBannerPresenterProvider, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, Lazy<RichDocumentEventBus> lazy, HamDimensions hamDimensions, Lazy<RichDocumentInfo> lazy2) {
        this.f461K = instantArticlesFetcher;
        this.f462L = richDocumentImagePrefetcher;
        this.f463M = richDocumentLayoutDirection;
        this.f464N = gatekeeperStore;
        this.f465O = businessIASubscriptionBannerPresenterProvider;
        this.f466P = richDocumentAnalyticsLogger;
        this.f467Q = lazy;
        this.f468R = hamDimensions;
        this.f469S = lazy2;
    }

    protected final RichDocumentBlocksImpl m570a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        RichDocumentMaster richDocumentMaster = (RichDocumentMaster) graphQLResult.e;
        ((SequenceLogger) this.f442z.get()).e(InstantArticlesSequences.f482a);
        if (richDocumentMaster == null || richDocumentMaster.g() == null) {
            return null;
        }
        boolean z;
        String string = this.y.getString("extra_instant_articles_click_url");
        ((RichDocumentInfo) this.f469S.get()).g = richDocumentMaster.g().l();
        RichDocumentBlocksImpl a = new RichDocumentMasterAdapter(getContext(), string).m610a(richDocumentMaster);
        this.f463M.a = richDocumentMaster.g().q();
        if (this.f464N.a(239, false)) {
            m565a(richDocumentMaster);
        }
        RichDocumentEventBus richDocumentEventBus = (RichDocumentEventBus) this.f467Q.get();
        DataFreshnessResult dataFreshnessResult = graphQLResult.freshness;
        Set f = graphQLResult.f();
        if (f == null) {
            z = false;
        } else {
            z = f.contains("FROM_MEMORY_CACHE");
        }
        richDocumentEventBus.a(new RichDocumentBlocksAppendedEvent(a, dataFreshnessResult, z));
        return a;
    }

    public final View mo18b(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Class cls = InstantArticlesDelegateImpl.class;
        m566a((Object) this, getContext());
        View b = super.mo18b(layoutInflater, viewGroup, bundle);
        ((RichDocumentEventBus) this.f467Q.get()).a(this.f473X);
        this.f470U = (BusinessIASubscribeBannerView) b.findViewById(2131562987);
        return b;
    }

    public final void m571a(View view, @javax.annotation.Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.z != null && this.f464N.a(679, false)) {
            this.z.setDescendantFocusability(131072);
        }
    }

    protected final BaseRichDocumentFetcher m577u() {
        return this.f461K;
    }

    protected final void mo19b(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        super.mo19b(richDocumentBlocksImpl);
        CharSequence string = this.y.getString("extra_instant_articles_featured_element_id");
        if (!StringUtil.a(string)) {
            RichDocumentAdapter richDocumentAdapter = (RichDocumentAdapter) this.z.o;
            int i = 0;
            while (i < richDocumentAdapter.aZ_()) {
                Object l = richDocumentAdapter.e(i).l();
                if (StringUtil.a(l) || !l.equals(string)) {
                    i++;
                } else {
                    this.z.a(i);
                    if (1 != 0) {
                        ImageButtonWithTouchSpring imageButtonWithTouchSpring = new ImageButtonWithTouchSpring(getContext());
                        int b = this.f468R.b(2131558651);
                        imageButtonWithTouchSpring.setBackground(getContext().getResources().getDrawable(2130840806));
                        imageButtonWithTouchSpring.setImageResource(2130843065);
                        imageButtonWithTouchSpring.setScaleType(ScaleType.CENTER_INSIDE);
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(b * 2, b);
                        layoutParams.setMargins(0, (m540D() ? getContext().getResources().getDimensionPixelSize(2131431841) : getContext().getResources().getDimensionPixelSize(2131431840)) + this.f468R.b(2131558655), 0, 0);
                        layoutParams.gravity = 1;
                        ((FrameLayout) this.x.findViewById(2131562982)).addView(imageButtonWithTouchSpring, layoutParams);
                        final AutoScrollToTopButtonController autoScrollToTopButtonController = new AutoScrollToTopButtonController(imageButtonWithTouchSpring, (RichDocumentEventBus) this.f467Q.get());
                        imageButtonWithTouchSpring.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ InstantArticlesDelegateImpl f446b;

                            public void onClick(View view) {
                                int a = Logger.a(2, EntryType.UI_INPUT_START, -1710854147);
                                ((RichDocumentLayoutManager) this.f446b.z.getLayoutManager()).t = false;
                                this.f446b.z.b(0);
                                AutoScrollToTopButtonController.m562a(autoScrollToTopButtonController);
                                Logger.a(2, EntryType.UI_INPUT_END, -543576006, a);
                            }
                        });
                    }
                    return;
                }
            }
        }
    }

    protected final void m572a(Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f417A;
        SoftErrorBuilder a = SoftError.a(f460T + ".onFetchError", "Error attempting to fetch blocks. article id(" + m567d(this.y) + ")");
        a.c = th;
        abstractFbErrorReporter.a(a.g());
    }

    public final AbstractSequenceDefinition m568C() {
        return InstantArticlesSequences.f482a;
    }

    public final void mo20n() {
        super.mo20n();
        this.f462L.a(m567d(this.y));
    }

    private static String m567d(Bundle bundle) {
        RichDocumentMaster richDocumentMaster = (RichDocumentMaster) bundle.getParcelable("ia_gql_query_result");
        if (richDocumentMaster != null) {
            return richDocumentMaster.c();
        }
        return bundle.getString("extra_instant_articles_id");
    }

    private void m565a(RichDocumentMaster richDocumentMaster) {
        if (this.f470U != null) {
            Object obj;
            this.f471V = this.f465O.a(this.f470U);
            this.f471V.e = new C00754(this);
            BusinessIASubscriptionBannerPresenter businessIASubscriptionBannerPresenter = this.f471V;
            if (richDocumentMaster == null || richDocumentMaster.g() == null || richDocumentMaster.g().k() == null || richDocumentMaster.d() == null || Strings.isNullOrEmpty(richDocumentMaster.d().b()) || Strings.isNullOrEmpty(richDocumentMaster.d().a())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                BusinessIASubscriptionLoader businessIASubscriptionLoader = businessIASubscriptionBannerPresenter.l;
                String d = richDocumentMaster.g().k().d();
                1 1 = new 1(businessIASubscriptionBannerPresenter, richDocumentMaster);
                GraphQlQueryString businessSubscriptionMessengerContentSubscribedQueryString = new BusinessSubscriptionMessengerContentSubscribedQueryString();
                businessSubscriptionMessengerContentSubscribedQueryString.a("pageId", d);
                TasksManager tasksManager = businessIASubscriptionLoader.c;
                IASubscriptionTask iASubscriptionTask = IASubscriptionTask.IS_CONTENT_SUBSCRIBED;
                GraphQLQueryExecutor graphQLQueryExecutor = businessIASubscriptionLoader.b;
                GraphQLRequest a = GraphQLRequest.a(businessSubscriptionMessengerContentSubscribedQueryString).a(GraphQLCachePolicy.c);
                a.f = CallerContext.a(businessIASubscriptionLoader.getClass());
                tasksManager.a(iASubscriptionTask, graphQLQueryExecutor.a(a), new BusinessIASubscriptionLoader.1(businessIASubscriptionLoader, 1));
            }
            RichDocumentTouch.a(this.f470U, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
        }
    }

    protected final String mo17E() {
        return m567d(this.y);
    }

    public final Map<String, Object> m575c() {
        String d = m567d(this.y);
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("instant_article_id", d);
        return hashMap;
    }

    protected final RichDocumentFetchParams m578v() {
        InstantArticlesFetchParams instantArticlesFetchParams = new InstantArticlesFetchParams(getContext(), m567d(this.y));
        if (this.y.getBoolean("fetch_from_server", false)) {
            instantArticlesFetchParams.i = 1;
        } else {
            instantArticlesFetchParams.i = 86400;
        }
        return instantArticlesFetchParams;
    }
}
