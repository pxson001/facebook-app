package com.facebook.friendsharing.souvenirs.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.friendsharing.souvenirs.models.SouvenirsFetchResult;
import com.facebook.friendsharing.souvenirs.models.SouvenirsRequests;
import com.facebook.friendsharing.souvenirs.models.SouvenirsRequests.TransformFunction;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirs.FetchSouvenirsString;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel.MediaElementsModel.EdgesModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel.SouvenirMediaModel;
import com.facebook.friendsharing.souvenirs.ui.SouvenirVideoAutoplayController;
import com.facebook.friendsharing.souvenirs.ui.SouvenirVideoAutoplayController.VideoAutoPlayView;
import com.facebook.friendsharing.souvenirs.ui.SouvenirsBurstView;
import com.facebook.friendsharing.souvenirs.util.SouvenirsElementHelper;
import com.facebook.friendsharing.souvenirs.verve.SouvenirTemplateGenerator;
import com.facebook.friendsharing.souvenirs.verve.SouvenirVerveVideoView;
import com.facebook.friendsharing.souvenirs.verve.SouvenirsLocalTemplateHelper;
import com.facebook.friendsharing.souvenirs.verve.SouvenirsLocalTemplateHelper.C21101;
import com.facebook.friendsharing.souvenirs.verve.SouvenirsVerveViewSupplierProvider;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.VerveMediaInfoSupplier;
import com.facebook.greetingcards.verve.model.VMAction;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMMediaType;
import com.facebook.greetingcards.verve.render.FlatVerveRecyclerView;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ShareComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.ui.OfflineSnackbarView;
import com.facebook.photos.analytics.PhotosAnalyticsEntities.Actions;
import com.facebook.photos.consumptiongallery.ConsumptionUfiController;
import com.facebook.photos.consumptiongallery.ConsumptionUfiController.2;
import com.facebook.photos.consumptiongallery.ConsumptionUfiController.3;
import com.facebook.photos.consumptiongallery.Feedback;
import com.facebook.photos.consumptiongallery.Feedback.ObjectType;
import com.facebook.photos.consumptiongallery.snowflake.SnowflakeFooter;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.FeedbackParams.Builder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.popover.BasePopoverDelegate;
import com.facebook.widget.popover.PopoverFragment;
import com.facebook.widget.popover.PopoverFragment.DefaultPopoverDelegate;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: RelayPersistedQueryPreloader */
public class SouvenirsFragment extends PopoverFragment {
    private static final Rect aP = new Rect();
    public static final String ay = SouvenirsLocalTemplateHelper.class.getSimpleName();
    private final PhotoDeleteSubscriber aA = new PhotoDeleteSubscriber(this);
    private final UfiControllerListener aB = new UfiControllerListener(this);
    public TimerTask aC;
    public FlatVerveRecyclerView aD;
    public ProgressBar aE;
    private BasePopoverDelegate aF;
    private SnowflakeFooter aG;
    public Handler aH;
    public Timer aI;
    private int aJ = -1;
    public String aK;
    @Nullable
    public FeedProps<GraphQLStory> aL;
    public int aM = 0;
    public List<SouvenirsBurstView> aN;
    private volatile Iterator<SouvenirsBurstView> aO;
    private SouvenirsBurstView aQ;
    public int aR = 0;
    @Inject
    SouvenirsLocalTemplateHelper am;
    @Inject
    TasksManager an;
    @Inject
    SouvenirsRequests ao;
    @Inject
    SouvenirsVerveViewSupplierProvider ap;
    @Inject
    SouvenirTemplateGenerator aq;
    @Inject
    Lazy<ConsumptionPhotoEventBus> ar;
    @Inject
    NetworkMonitor as;
    @Inject
    ClickableToastBuilder at;
    @Inject
    ConsumptionUfiController au;
    @Inject
    public Lazy<IFeedIntentBuilder> av;
    @Inject
    public Lazy<ShareComposerLauncher> aw;
    @Inject
    public SouvenirVideoAutoplayController ax;
    public final Runnable az = new C20811(this);

    /* compiled from: RelayPersistedQueryPreloader */
    class C20811 implements Runnable {
        final /* synthetic */ SouvenirsFragment f24034a;

        C20811(SouvenirsFragment souvenirsFragment) {
            this.f24034a = souvenirsFragment;
        }

        public void run() {
            SouvenirsFragment.aE(this.f24034a);
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    class C20822 extends ItemDecoration {
        final /* synthetic */ SouvenirsFragment f24035a;

        C20822(SouvenirsFragment souvenirsFragment) {
            this.f24035a = souvenirsFragment;
        }

        public final void m26124a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.set(0, 0, 0, this.f24035a.aM);
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    class C20833 implements Callable<ListenableFuture<List<Object>>> {
        final /* synthetic */ SouvenirsFragment f24036a;

        C20833(SouvenirsFragment souvenirsFragment) {
            this.f24036a = souvenirsFragment;
        }

        public Object call() {
            r0 = new ListenableFuture[2];
            SouvenirsLocalTemplateHelper souvenirsLocalTemplateHelper = this.f24036a.am;
            r0[0] = souvenirsLocalTemplateHelper.f24243c.a(new C21101(souvenirsLocalTemplateHelper));
            SouvenirsRequests souvenirsRequests = this.f24036a.ao;
            String str = this.f24036a.aK;
            GraphQlQueryString fetchSouvenirsString = new FetchSouvenirsString();
            ((SizeAwareImageUtil) souvenirsRequests.f24083b.get()).a(fetchSouvenirsString);
            fetchSouvenirsString.a("souvenir_id", str);
            fetchSouvenirsString.a("profile_picture_size", Integer.valueOf(400));
            r0[1] = Futures.b(((GraphQLQueryExecutor) souvenirsRequests.f24082a.get()).a(GraphQLRequest.a(fetchSouvenirsString).a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.d)), new TransformFunction(souvenirsRequests));
            return Futures.b(r0);
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    class C20854 extends AbstractDisposableFutureCallback<List<Object>> {
        final /* synthetic */ SouvenirsFragment f24038a;

        /* compiled from: RelayPersistedQueryPreloader */
        class C20841 implements VerveActionListener {
            final /* synthetic */ C20854 f24037a;

            C20841(C20854 c20854) {
                this.f24037a = c20854;
            }

            public final void mo1595a(VMAction vMAction, View view) {
                if (vMAction != null) {
                    SouvenirsFragment souvenirsFragment;
                    if (view instanceof SouvenirsBurstView) {
                        SouvenirsBurstView souvenirsBurstView = (SouvenirsBurstView) view;
                        souvenirsFragment = this.f24037a.f24038a;
                        if ("hidden".equals(vMAction.type)) {
                            souvenirsFragment.aN.remove(souvenirsBurstView);
                        } else if ("visible".equals(vMAction.type)) {
                            souvenirsFragment.aN.add(souvenirsBurstView);
                            if (souvenirsFragment.aC == null) {
                                souvenirsFragment.aC = new C20865(souvenirsFragment);
                                souvenirsFragment.aI.scheduleAtFixedRate(souvenirsFragment.aC, 0, 1400);
                            }
                            souvenirsBurstView.m26449a();
                        }
                        SouvenirsFragment.aE(souvenirsFragment);
                    } else if (view instanceof SouvenirVerveVideoView) {
                        VideoAutoPlayView videoAutoPlayView = (SouvenirVerveVideoView) view;
                        souvenirsFragment = this.f24037a.f24038a;
                        SouvenirVideoAutoplayController souvenirVideoAutoplayController;
                        if ("hidden".equals(vMAction.type)) {
                            souvenirVideoAutoplayController = souvenirsFragment.ax;
                            souvenirVideoAutoplayController.f24189c.remove(videoAutoPlayView);
                            if (souvenirVideoAutoplayController.f24191e == videoAutoPlayView) {
                                SouvenirVideoAutoplayController.m26442c(videoAutoPlayView);
                                souvenirVideoAutoplayController.f24191e = null;
                            }
                            SouvenirVideoAutoplayController.m26443c(souvenirVideoAutoplayController);
                            videoAutoPlayView.g();
                        } else if ("visible".equals(vMAction.type)) {
                            souvenirVideoAutoplayController = souvenirsFragment.ax;
                            videoAutoPlayView.mo1602a();
                            souvenirVideoAutoplayController.f24189c.addLast(videoAutoPlayView);
                            SouvenirVideoAutoplayController.m26443c(souvenirVideoAutoplayController);
                        }
                    }
                }
            }
        }

        C20854(SouvenirsFragment souvenirsFragment) {
            this.f24038a = souvenirsFragment;
        }

        protected final void m26127a(Object obj) {
            List list = (List) obj;
            this.f24038a.aE.setVisibility(8);
            if (list == null || list.isEmpty() || !(list.get(0) instanceof VMDeck) || !(list.get(1) instanceof SouvenirsFetchResult)) {
                this.f24038a.a();
                return;
            }
            SouvenirsFetchResult souvenirsFetchResult = (SouvenirsFetchResult) list.get(1);
            this.f24038a.aR = SouvenirsElementHelper.m26463b(souvenirsFetchResult.f24076a, true);
            if (this.f24038a.aR <= 0) {
                this.f24038a.a();
                return;
            }
            this.f24038a.aD.a(this.f24038a.aq.m26470a((VMDeck) list.get(0), souvenirsFetchResult), this.f24038a.ap.m26496a(souvenirsFetchResult.f24076a, this.f24038a.aL), new C20841(this), new SouvenirsVerveMediaInfoSupplier(this.f24038a, souvenirsFetchResult.f24076a));
        }

        protected final void m26128a(Throwable th) {
            SouvenirsFragment.m26139a(this.f24038a.getContext(), this.f24038a.at, this.f24038a.as);
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    public class C20865 extends TimerTask {
        final /* synthetic */ SouvenirsFragment f24039a;

        public C20865(SouvenirsFragment souvenirsFragment) {
            this.f24039a = souvenirsFragment;
        }

        public void run() {
            HandlerDetour.a(this.f24039a.aH, this.f24039a.az, -1057094084);
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    class C20876 extends DefaultPopoverDelegate {
        final /* synthetic */ SouvenirsFragment f24040b;

        C20876(SouvenirsFragment souvenirsFragment) {
            this.f24040b = souvenirsFragment;
            super(souvenirsFragment);
        }

        public final boolean m26129a(float f, float f2, Direction direction) {
            return direction == Direction.LEFT || direction == Direction.RIGHT;
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    public class C20887 {
        public final /* synthetic */ SouvenirsFragment f24041a;

        public C20887(SouvenirsFragment souvenirsFragment) {
            this.f24041a = souvenirsFragment;
        }

        public final void m26131a(Feedback feedback, boolean z) {
            ConsumptionUfiController consumptionUfiController = this.f24041a.au;
            if (feedback.j != z) {
                String j;
                String str;
                GraphQLFeedback graphQLFeedback = feedback.a;
                if (graphQLFeedback != null) {
                    j = graphQLFeedback.j();
                    consumptionUfiController.i.m2218a(graphQLFeedback, new FeedbackLoggingParams(null, null, null), false, new 2(consumptionUfiController));
                } else {
                    j = Long.toString(feedback.e);
                    boolean z2 = z;
                    consumptionUfiController.j.a(j, z2, null, new FeedbackLoggingParams(null, null, null), new 3(consumptionUfiController, feedback, z));
                }
                AnalyticsLogger analyticsLogger = consumptionUfiController.c;
                if (z) {
                    str = Actions.a;
                } else {
                    str = Actions.c;
                }
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
                honeyClientEvent.e = j;
                HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
                honeyClientEvent2.d = "fbobj";
                analyticsLogger.c(honeyClientEvent2);
            }
        }

        public final void m26130a() {
            if (this.f24041a.aL != null) {
                ConsumptionUfiController consumptionUfiController = this.f24041a.au;
                GraphQLFeedback l = ((GraphQLStory) this.f24041a.aL.a).l();
                Builder builder = new Builder();
                builder.a = l;
                builder = builder;
                builder.d = l.z_();
                builder = builder;
                FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
                builder2.c = "native_newsfeed";
                builder.g = builder2.a();
                FeedbackParams a = builder.a();
                Preconditions.checkNotNull(l);
                consumptionUfiController.k = (GraphQLSubscriptionHolder) consumptionUfiController.g.get();
                GraphQLFeedback graphQLFeedback = l;
                consumptionUfiController.k.a(consumptionUfiController.h, l.j(), new GraphQLResult(graphQLFeedback, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, ImmutableSet.of(l.j())));
                consumptionUfiController.e.a(consumptionUfiController.a, a);
            }
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    class PhotoDeleteSubscriber extends DeletePhotoEventSubscriber {
        final /* synthetic */ SouvenirsFragment f24042a;

        public PhotoDeleteSubscriber(SouvenirsFragment souvenirsFragment) {
            this.f24042a = souvenirsFragment;
        }

        public final void m26132b(FbEvent fbEvent) {
            SouvenirsFragment souvenirsFragment = this.f24042a;
            int i = souvenirsFragment.aR - 1;
            souvenirsFragment.aR = i;
            if (i <= 0) {
                this.f24042a.a();
            } else {
                SouvenirsFragment.aF(this.f24042a);
            }
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    class SouvenirsVerveMediaInfoSupplier implements VerveMediaInfoSupplier {
        final /* synthetic */ SouvenirsFragment f24043a;
        private final Set<String> f24044b = new HashSet();

        public SouvenirsVerveMediaInfoSupplier(SouvenirsFragment souvenirsFragment, SouvenirsDetailsFieldsModel souvenirsDetailsFieldsModel) {
            this.f24043a = souvenirsFragment;
            ImmutableList a = souvenirsDetailsFieldsModel.m26305c().m26298a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                SouvenirsMediaElementFieldsModel a2 = ((EdgesModel) a.get(i)).m26292a();
                if (a2.m26330d() == GraphQLSouvenirMediaFieldType.VIDEO) {
                    this.f24044b.add(((SouvenirMediaModel.EdgesModel) a2.m26329c().m26322a().get(0)).m26317a().m26393p());
                }
            }
        }

        public final VMMediaType mo1596a(String str) {
            if (this.f24044b.contains(str)) {
                return VMMediaType.VIDEO;
            }
            return VMMediaType.IMAGE;
        }
    }

    /* compiled from: RelayPersistedQueryPreloader */
    public class UfiControllerListener {
        final /* synthetic */ SouvenirsFragment f24045a;

        public final void m26135a(Feedback feedback) {
            boolean z;
            if (feedback.b == ObjectType.STORY) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            SouvenirsFragment.m26136a(this.f24045a, feedback);
        }

        public UfiControllerListener(SouvenirsFragment souvenirsFragment) {
            this.f24045a = souvenirsFragment;
        }
    }

    public static void m26138a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SouvenirsFragment) obj).m26137a(SouvenirsLocalTemplateHelper.m26475a(fbInjector), TasksManager.b(fbInjector), SouvenirsRequests.m26211a(fbInjector), (SouvenirsVerveViewSupplierProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SouvenirsVerveViewSupplierProvider.class), SouvenirTemplateGenerator.m26465a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2971), NetworkMonitor.a(fbInjector), ClickableToastBuilder.b(fbInjector), ConsumptionUfiController.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2347), IdBasedSingletonScopeProvider.b(fbInjector, 7300), SouvenirVideoAutoplayController.m26441b(fbInjector));
    }

    public final View m26143a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Feedback feedback;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -998202227);
        View a2 = super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130907183, (ViewGroup) a2.findViewById(2131560065));
        this.aM = jW_().getDimensionPixelSize(2131432484);
        this.aD = (FlatVerveRecyclerView) inflate.findViewById(2131567554);
        this.aD.a(new C20822(this));
        this.aE = (ProgressBar) inflate.findViewById(2131567555);
        this.aG = (SnowflakeFooter) FindViewUtil.b(inflate, 2131567508);
        this.aG.setListener(new C20887(this));
        this.aG.a();
        this.aG.setTagButtonEnabled(false);
        this.aG.setMenuButtonEnabled(false);
        if (this.aL == null || ((GraphQLStory) this.aL.a).l() == null) {
            feedback = null;
        } else {
            feedback = new Feedback(((GraphQLStory) this.aL.a).l());
        }
        m26136a(this, feedback);
        this.au.f = this.aB;
        LogUtils.f(-1673593734, a);
        return a2;
    }

    public final void m26144a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 229061444);
        super.a(bundle);
        a(2, 2131626159);
        Class cls = SouvenirsFragment.class;
        m26138a((Object) this, getContext());
        e(true);
        this.aK = this.s.getString("param_souvenir_id");
        this.aL = (FeedProps) this.s.getParcelable("param_feed_cache_id");
        this.aN = new CopyOnWriteArrayList();
        this.aH = new Handler(Looper.getMainLooper());
        this.aI = new Timer();
        aD();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 42418938, a);
    }

    public final void m26140G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 745076545);
        super.G();
        ((ConsumptionPhotoEventBus) this.ar.get()).a(this.aA);
        SouvenirVideoAutoplayController.m26443c(this.ax);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1966046845, a);
    }

    public final void m26141H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1669775467);
        super.H();
        ((ConsumptionPhotoEventBus) this.ar.get()).b(this.aA);
        SouvenirVideoAutoplayController souvenirVideoAutoplayController = this.ax;
        if (souvenirVideoAutoplayController.f24191e != null) {
            SouvenirVideoAutoplayController.m26442c(souvenirVideoAutoplayController.f24191e);
            souvenirVideoAutoplayController.f24191e = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1645060441, a);
    }

    public final boolean O_() {
        if (this.au.c()) {
            return true;
        }
        if (!this.au.b()) {
            return super.O_();
        }
        this.au.d();
        return true;
    }

    public final void m26142I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1556663710);
        if (this.au.b()) {
            this.au.d();
        }
        ConsumptionUfiController consumptionUfiController = this.au;
        consumptionUfiController.f = null;
        if (consumptionUfiController.k != null) {
            consumptionUfiController.k.a();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1321945556, a);
    }

    protected final int ax() {
        return Direction.LEFT.flag() | Direction.RIGHT.flag();
    }

    protected final int ay() {
        return Direction.LEFT.flag() | Direction.RIGHT.flag();
    }

    protected final Direction az() {
        return Direction.LEFT;
    }

    protected final Direction aA() {
        return Direction.RIGHT;
    }

    private void aD() {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(this.aK));
        this.an.a("fetchSouvenir_" + this.aK, new C20833(this), new C20854(this));
    }

    public static boolean m26139a(Context context, ClickableToastBuilder clickableToastBuilder, NetworkMonitor networkMonitor) {
        if (networkMonitor.a()) {
            return false;
        }
        clickableToastBuilder.a(new OfflineSnackbarView((Context) ContextUtils.a(context, Activity.class)), 3000).a();
        return true;
    }

    public static void aE(SouvenirsFragment souvenirsFragment) {
        if (!souvenirsFragment.aN.isEmpty()) {
            SouvenirsBurstView souvenirsBurstView;
            if (souvenirsFragment.aQ != null) {
                Object obj;
                souvenirsBurstView = souvenirsFragment.aQ;
                if (souvenirsBurstView.f24199e < souvenirsBurstView.f24200f) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null && souvenirsFragment.aQ.getGlobalVisibleRect(aP)) {
                    souvenirsFragment.aQ.m26449a();
                    return;
                }
            }
            if (souvenirsFragment.aO == null || !souvenirsFragment.aO.hasNext()) {
                souvenirsFragment.aO = souvenirsFragment.aN.iterator();
            }
            while (souvenirsFragment.aO.hasNext()) {
                souvenirsBurstView = (SouvenirsBurstView) souvenirsFragment.aO.next();
                if (souvenirsBurstView.getGlobalVisibleRect(aP)) {
                    souvenirsFragment.aQ = souvenirsBurstView;
                    souvenirsBurstView = souvenirsFragment.aQ;
                    souvenirsBurstView.f24199e = 0;
                    if (souvenirsBurstView.f24198d != null) {
                        souvenirsBurstView.f24198d.g(souvenirsBurstView.f24199e);
                    }
                    souvenirsFragment.aQ.m26449a();
                    return;
                }
            }
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1857218619);
        this.aJ = an().getRequestedOrientation();
        an().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1500450933, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -636326829);
        an().setRequestedOrientation(this.aJ);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 990152595, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -177766291);
        super.mY_();
        this.aN.clear();
        if (this.aI != null) {
            this.aI.cancel();
            this.aI.purge();
        }
        if (this.aH != null) {
            this.aH.removeCallbacksAndMessages(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2088179116, a);
    }

    protected final BasePopoverDelegate at() {
        if (this.aF == null) {
            this.aF = new C20876(this);
        }
        return this.aF;
    }

    public static void aF(SouvenirsFragment souvenirsFragment) {
        souvenirsFragment.aE.setVisibility(0);
        souvenirsFragment.aD();
    }

    private void m26137a(SouvenirsLocalTemplateHelper souvenirsLocalTemplateHelper, TasksManager tasksManager, SouvenirsRequests souvenirsRequests, SouvenirsVerveViewSupplierProvider souvenirsVerveViewSupplierProvider, SouvenirTemplateGenerator souvenirTemplateGenerator, Lazy<ConsumptionPhotoEventBus> lazy, NetworkMonitor networkMonitor, ClickableToastBuilder clickableToastBuilder, ConsumptionUfiController consumptionUfiController, Lazy<IFeedIntentBuilder> lazy2, Lazy<ShareComposerLauncher> lazy3, SouvenirVideoAutoplayController souvenirVideoAutoplayController) {
        this.am = souvenirsLocalTemplateHelper;
        this.an = tasksManager;
        this.ao = souvenirsRequests;
        this.ap = souvenirsVerveViewSupplierProvider;
        this.aq = souvenirTemplateGenerator;
        this.ar = lazy;
        this.as = networkMonitor;
        this.at = clickableToastBuilder;
        this.au = consumptionUfiController;
        this.av = lazy2;
        this.aw = lazy3;
        this.ax = souvenirVideoAutoplayController;
    }

    public static void m26136a(@Nullable SouvenirsFragment souvenirsFragment, Feedback feedback) {
        GraphQLStory graphQLStory;
        if (souvenirsFragment.aL == null) {
            graphQLStory = null;
        } else {
            graphQLStory = (GraphQLStory) souvenirsFragment.aL.a;
        }
        SnowflakeFooter snowflakeFooter = souvenirsFragment.aG;
        boolean z = (souvenirsFragment.aL == null || GraphQLStoryUtil.o(souvenirsFragment.aL) == null) ? false : true;
        snowflakeFooter.setShareButtonEnabled(z);
        souvenirsFragment.aG.a(feedback, graphQLStory);
    }
}
