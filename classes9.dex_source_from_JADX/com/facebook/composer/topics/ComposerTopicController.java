package com.facebook.composer.topics;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewStub;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.tip.Tip;
import com.facebook.composer.tip.TipControllerInterface;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.topics.TopicBarController.C29031;
import com.facebook.composer.topics.TopicBarController.TopicPillLayoutType;
import com.facebook.composer.topics.analytics.ComposerTopicLogger;
import com.facebook.composer.topics.analytics.ComposerTopicLoggerProvider;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPredictedTopics;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsTopics;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.topics.data.TopicClassificationFetcher;
import com.facebook.topics.protocol.TopicListHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.FlowLayout;
import com.facebook.widget.LazyView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UI Infra Adoption */
public class ComposerTopicController<DataProvider extends ProvidesAttachments & ProvidesIsImplicitLocationSupported & ProvidesPredictedTopics & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPageData & ProvidesShareParams & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae, Transaction extends ComposerTransaction & SetsTopics<Transaction>> implements ComposerEventHandler {
    private static final ImmutableList<ComposerEvent> f23851a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE, ComposerEvent.ON_DESTROY_VIEW, ComposerEvent.ON_STATUS_TEXT_CHANGED, ComposerEvent.ON_USER_CANCEL, ComposerEvent.ON_USER_POST);
    public static final ComposerEventOriginator f23852b = ComposerEventOriginator.a(ComposerTopicController.class);
    public final ComposerMutator<Transaction> f23853c;
    private final ComposerTopicsDetectorProvider f23854d;
    public final TipSeenTracker f23855e;
    public final DataProvider f23856f;
    public final Lazy<FbUriIntentHandler> f23857g;
    public final LazyView<TopicPillView> f23858h;
    private final QeAccessor f23859i;
    public final TopicFeedsTestUtil f23860j;
    public final Fragment f23861k;
    public final int f23862l;
    public final ComposerTopicLogger f23863m;
    private final Comparator<GraphQLExploreFeed> f23864n = new C28881(this);
    public final Set<GraphQLExploreFeed> f23865o = new TreeSet(this.f23864n);
    public final Set<GraphQLExploreFeed> f23866p = new TreeSet(this.f23864n);
    private ComposerTopicsDetector f23867q;
    public TopicBarController f23868r;
    private ImmutableList<GraphQLExploreFeed> f23869s;
    private boolean f23870t;

    /* compiled from: UI Infra Adoption */
    class C28881 implements Comparator<GraphQLExploreFeed> {
        final /* synthetic */ ComposerTopicController f23842a;

        C28881(ComposerTopicController composerTopicController) {
            this.f23842a = composerTopicController;
        }

        public int compare(Object obj, Object obj2) {
            return StringUtil.b(((GraphQLExploreFeed) obj).n(), ((GraphQLExploreFeed) obj2).n());
        }
    }

    /* compiled from: UI Infra Adoption */
    public class C28903 {
        final /* synthetic */ ComposerTopicController f23845a;

        C28903(ComposerTopicController composerTopicController) {
            this.f23845a = composerTopicController;
        }

        public final void m25847a(List<GraphQLExploreFeed> list) {
            TransactionImpl a = this.f23845a.f23853c.a(ComposerTopicController.f23852b);
            ImmutableList copyOf = ImmutableList.copyOf(list);
            ComposerTopicController composerTopicController = this.f23845a;
            int g = composerTopicController.f23860j.g();
            Builder builder = new Builder();
            int i = 0;
            while (i < list.size() && i < g) {
                GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) list.get(i);
                if (!composerTopicController.f23866p.contains(graphQLExploreFeed)) {
                    builder.c(graphQLExploreFeed);
                }
                i++;
            }
            ((TransactionImpl) a.a(copyOf, builder.b())).a();
        }
    }

    /* compiled from: UI Infra Adoption */
    public class C28924 implements TipControllerInterface {
        final /* synthetic */ ComposerTopicController f23847a;
        public Tooltip f23848b;
        private boolean f23849c = false;

        /* compiled from: UI Infra Adoption */
        class C28911 implements Runnable {
            final /* synthetic */ C28924 f23846a;

            C28911(C28924 c28924) {
                this.f23846a = c28924;
            }

            public void run() {
                this.f23846a.f23848b = new Tooltip(((TopicPillView) this.f23846a.f23847a.f23858h.a()).getContext(), 2);
                this.f23846a.f23847a.f23855e.a();
                this.f23846a.f23848b.a(2131234786);
                this.f23846a.f23848b.b(2131234787);
                this.f23846a.f23848b.t = -1;
                this.f23846a.f23848b.a(Position.BELOW);
                this.f23846a.f23848b.f(this.f23846a.f23847a.f23858h.a());
            }
        }

        C28924(ComposerTopicController composerTopicController) {
            this.f23847a = composerTopicController;
        }

        public final void m25848a() {
            this.f23849c = true;
            ((TopicPillView) this.f23847a.f23858h.a()).post(new C28911(this));
        }

        public final boolean m25849b() {
            return this.f23847a.f23855e.c() && this.f23847a.f23858h.a() != null && ComposerTopicController.m25856c(this.f23847a);
        }

        public final boolean m25850c() {
            if (this.f23848b == null) {
                return false;
            }
            this.f23848b = null;
            return true;
        }

        public final boolean m25851d() {
            return this.f23849c;
        }
    }

    /* compiled from: UI Infra Adoption */
    public /* synthetic */ class C28935 {
        public static final /* synthetic */ int[] f23850a = new int[ComposerEvent.values().length];

        static {
            try {
                f23850a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23850a[ComposerEvent.ON_USER_POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void m25854b(ComposerEvent composerEvent) {
        ImmutableList W;
        ImmutableList immutableList = RegularImmutableList.a;
        ImmutableList immutableList2 = RegularImmutableList.a;
        if (((ProvidesTopics) this.f23856f).af() != this.f23869s) {
            this.f23869s = ((ProvidesTopics) this.f23856f).af();
            m25857d();
            immutableList2 = ((ProvidesConfiguration) this.f23856f).o().getTopics();
            immutableList = ((ProvidesTopics) this.f23856f).af();
            W = ((ComposerDataProviderImpl) this.f23856f).W();
            Collection collection = this.f23866p;
            Collection a = TopicListHelper.a(immutableList2);
            Collection a2 = TopicListHelper.a(immutableList);
            a.addAll(W);
            a.removeAll(TopicListHelper.a(collection));
            a2.removeAll(a);
            immutableList2 = ImmutableList.copyOf(a2);
            this.f23865o.addAll(immutableList2);
            immutableList = ((ProvidesConfiguration) this.f23856f).o().getTopics();
            ImmutableList af = ((ProvidesTopics) this.f23856f).af();
            W = ((ComposerDataProviderImpl) this.f23856f).W();
            Collection collection2 = this.f23865o;
            a = TopicListHelper.a(immutableList);
            a.addAll(collection2);
            a.addAll(W);
            a.removeAll(TopicListHelper.a(af));
            W = ImmutableList.copyOf(a);
            this.f23866p.addAll(W);
        } else {
            if (this.f23870t != m25856c(this)) {
                this.f23870t = !this.f23870t;
                ((TransactionImpl) this.f23853c.a(f23852b).a(((ComposerDataProviderImpl) this.f23856f).W(), RegularImmutableList.a)).a();
                m25857d();
                m25858e();
            }
            W = immutableList2;
            immutableList2 = immutableList;
        }
        m25852a(composerEvent, immutableList2, W);
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public ComposerTopicController(@Assisted ViewStub viewStub, @Assisted DataProvider dataProvider, @Assisted Fragment fragment, @Assisted int i, @Assisted TipManager tipManager, @Assisted ComposerMutator<Transaction> composerMutator, QeAccessor qeAccessor, TipSeenTracker tipSeenTracker, TopicFeedsTestUtil topicFeedsTestUtil, ComposerTopicsDetectorProvider composerTopicsDetectorProvider, Lazy<FbUriIntentHandler> lazy, ComposerTopicLoggerProvider composerTopicLoggerProvider) {
        this.f23856f = dataProvider;
        this.f23854d = composerTopicsDetectorProvider;
        this.f23857g = lazy;
        this.f23853c = composerMutator;
        this.f23858h = new LazyView(viewStub);
        this.f23861k = fragment;
        this.f23862l = i;
        this.f23859i = qeAccessor;
        this.f23855e = tipSeenTracker;
        this.f23860j = topicFeedsTestUtil;
        this.f23870t = m25856c(this);
        this.f23863m = composerTopicLoggerProvider.m25913a(((ProvidesSessionId) this.f23856f).ab());
        m25857d();
        m25858e();
        m25853a(tipManager);
    }

    public final void m25860a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (!f23851a.contains(composerEvent)) {
            return;
        }
        if (composerEvent.equals(ComposerEvent.ON_DESTROY_VIEW) || composerEvent.equals(ComposerEvent.ON_USER_CANCEL)) {
            m25859g();
            return;
        }
        m25854b(composerEvent);
        if (this.f23860j.d() && !m25856c(this)) {
            switch (C28935.f23850a[composerEvent.ordinal()]) {
                case 1:
                    this.f23863m.m25909a(((ProvidesConfiguration) this.f23856f).o().getComposerType().toString(), ((ProvidesConfiguration) this.f23856f).o().getLaunchLoggingParams().getEntryPicker().getAnalyticsName(), ((ProvidesTargetData) this.f23856f).s().targetType.toString(), ((ProvidesConfiguration) this.f23856f).o().getTopics());
                    break;
                case 2:
                    this.f23863m.m25910a(((ProvidesConfiguration) this.f23856f).o().getComposerType().toString(), ((ProvidesConfiguration) this.f23856f).o().getLaunchLoggingParams().getEntryPicker().getAnalyticsName(), ((ProvidesTargetData) this.f23856f).s().targetType.toString(), ((ProvidesConfiguration) this.f23856f).o().getTopics(), ((ProvidesTopics) this.f23856f).af(), this.f23865o, this.f23866p, ((ComposerDataProviderImpl) this.f23856f).W());
                    break;
                default:
                    break;
            }
        }
    }

    private boolean m25855b() {
        if (((ProvidesConfiguration) this.f23856f).o().getInitialTargetData().targetType == TargetType.PAGE) {
            return false;
        }
        if (((ProvidesConfiguration) this.f23856f).o().isEdit() && !((ProvidesConfiguration) this.f23856f).o().getEditPostFeatureCapabilities().contains(GraphQLEditPostFeatureCapability.FEED_TOPICS)) {
            return false;
        }
        boolean c = m25856c(this);
        return (!c && this.f23860j.c()) || (c && this.f23859i.a(ExperimentsForFacecastAbtestModule.r, false));
    }

    public static boolean m25856c(ComposerTopicController composerTopicController) {
        return ((ComposerDataProviderImpl) composerTopicController.f23856f).e().facecastCameraIndex != -1;
    }

    private void m25857d() {
        if (m25855b()) {
            TopicPillLayoutType topicPillLayoutType;
            ((TopicPillView) this.f23858h.a()).setVisibility(0);
            final TopicPillView topicPillView = (TopicPillView) this.f23858h.a();
            if (this.f23868r == null) {
                this.f23868r = new TopicBarController(topicPillView);
                this.f23868r.f23934d = new Object(this) {
                    public final /* synthetic */ ComposerTopicController f23844b;
                };
            }
            TopicBarController topicBarController = this.f23868r;
            ImmutableList af = ((ProvidesTopics) this.f23856f).af();
            if (m25856c(this) || !(topicPillView.getParent() instanceof FlowLayout)) {
                topicPillLayoutType = TopicPillLayoutType.SINGLE_PILL_LAYOUT;
            } else {
                topicPillLayoutType = TopicPillLayoutType.MULTI_PILL_LAYOUT;
            }
            topicBarController.f23932b.clear();
            if (af != null) {
                topicBarController.f23932b.addAll(af);
            }
            topicBarController.m25892a();
            if (topicPillLayoutType == TopicPillLayoutType.SINGLE_PILL_LAYOUT) {
                topicBarController.f23931a.setTopics(topicBarController.f23932b);
                return;
            }
            topicBarController.f23931a.setTopics(null);
            FlowLayout flowLayout = (FlowLayout) topicBarController.f23931a.getParent();
            LayoutInflater from = LayoutInflater.from(flowLayout.getContext());
            for (GraphQLExploreFeed graphQLExploreFeed : topicBarController.f23932b) {
                from.inflate(2130903734, flowLayout, true);
                TopicPillView topicPillView2 = (TopicPillView) flowLayout.getChildAt(flowLayout.getChildCount() - 1);
                topicPillView2.setTopic(graphQLExploreFeed);
                topicPillView2.setOnImageClickListener(new C29031(topicBarController, flowLayout, topicPillView2, graphQLExploreFeed));
                topicPillView2.setImage(2130838319);
                topicBarController.f23933c.add(topicPillView2);
            }
        } else if (this.f23858h.b()) {
            this.f23868r.m25892a();
            this.f23858h.c();
        }
    }

    private void m25858e() {
        if (m25856c(this)) {
            m25859g();
        } else if (this.f23867q == null) {
            ComposerTopicsDetectorProvider composerTopicsDetectorProvider = this.f23854d;
            this.f23867q = new ComposerTopicsDetector(this.f23863m, this.f23856f, new ComposerTopicsVisualDebugger((FbSharedPreferences) FbSharedPreferencesImpl.a(composerTopicsDetectorProvider), Toaster.b(composerTopicsDetectorProvider)), new TopicClassificationFetcher(GraphQLQueryExecutor.a(composerTopicsDetectorProvider), TasksManager.b(composerTopicsDetectorProvider)), TopicFeedsTestUtil.b(composerTopicsDetectorProvider), (TopicsPhotoManagerProvider) composerTopicsDetectorProvider.getOnDemandAssistedProviderForStaticDi(TopicsPhotoManagerProvider.class));
            this.f23867q.f23922s = new C28903(this);
        }
    }

    private void m25852a(ComposerEvent composerEvent, ImmutableList<GraphQLExploreFeed> immutableList, ImmutableList<GraphQLExploreFeed> immutableList2) {
        if (this.f23867q != null) {
            Object obj = (!immutableList.isEmpty() || (!immutableList2.isEmpty() && this.f23860j.h())) ? 1 : null;
            if (obj != null) {
                m25859g();
            } else {
                this.f23867q.m25884a(composerEvent, immutableList2);
            }
        }
    }

    private void m25859g() {
        if (this.f23867q != null) {
            this.f23867q.m25883a();
            this.f23867q = null;
        }
    }

    private void m25853a(TipManager tipManager) {
        if (m25855b()) {
            this.f23855e.a(ComposerPrefKeys.v);
            tipManager.a(Tip.LIVE_TOPIC_COMPOSER_NUX, new C28924(this));
        }
    }
}
