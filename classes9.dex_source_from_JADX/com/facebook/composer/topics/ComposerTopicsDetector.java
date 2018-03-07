package com.facebook.composer.topics;

import android.os.Handler;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.topics.ComposerTopicController.C28903;
import com.facebook.composer.topics.TopicsPredictionParam.TopicInfo;
import com.facebook.composer.topics.analytics.ComposerTopicLogger;
import com.facebook.debug.log.BLog;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.graphql.calls.FeedTopicsClassificationInputQueryParams;
import com.facebook.graphql.calls.FeedTopicsClassificationInputQueryParams.Topics;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.topics.data.TopicClassificationFetcher;
import com.facebook.topics.protocol.TopicClassificationQueryModels.TopicClassificationQueryModel;
import com.facebook.topics.protocol.TopicClassificationQueryModels.TopicClassificationQueryModel.PredictedFeedTopicsModel;
import com.facebook.topics.protocol.TopicClassificationQueryModels.TopicClassificationQueryModel.PredictedFeedTopicsModel.FeedTopicModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Type */
public class ComposerTopicsDetector<DataProvider extends ProvidesAttachments & ProvidesIsImplicitLocationSupported & ProvidesSessionId & ProvidesTextWithEntities & ProvidesConfiguration & ProvidesLocationInfo & ProvidesPageData & ProvidesShareParams & ProvidesTaggedUsers & ProvidesMinutiae> {
    public static final Class<?> f23904a = ComposerTopicsDetector.class;
    public final ComposerTopicLogger f23905b;
    public final ComposerTopicsVisualDebugger f23906c;
    public final DataProvider f23907d;
    private final TopicClassificationFetcher f23908e;
    public final TopicFeedsTestUtil f23909f;
    public final TopicsPredictionParam f23910g;
    public TopicsPhotoManager f23911h;
    public String f23912i;
    public String f23913j;
    public String f23914k;
    private List<String> f23915l;
    private List<String> f23916m;
    public MinutiaeObject f23917n;
    public String f23918o;
    private Handler f23919p = new Handler();
    public Runnable f23920q;
    public boolean f23921r;
    public C28903 f23922s;
    public int f23923t;

    /* compiled from: Type */
    public class C28981 {
        public final /* synthetic */ ComposerTopicsDetector f23898a;

        C28981(ComposerTopicsDetector composerTopicsDetector) {
            this.f23898a = composerTopicsDetector;
        }
    }

    /* compiled from: Type */
    public class C28992 implements Function<Long, String> {
        final /* synthetic */ ComposerTopicsDetector f23899a;

        public C28992(ComposerTopicsDetector composerTopicsDetector) {
            this.f23899a = composerTopicsDetector;
        }

        public Object apply(Object obj) {
            return String.valueOf((Long) obj);
        }
    }

    /* compiled from: Type */
    public class C29003 implements Function<ComposerTaggedUser, String> {
        final /* synthetic */ ComposerTopicsDetector f23900a;

        public C29003(ComposerTopicsDetector composerTopicsDetector) {
            this.f23900a = composerTopicsDetector;
        }

        public Object apply(Object obj) {
            return String.valueOf(((ComposerTaggedUser) obj).a());
        }
    }

    /* compiled from: Type */
    class C29014 implements Runnable {
        final /* synthetic */ ComposerTopicsDetector f23901a;

        C29014(ComposerTopicsDetector composerTopicsDetector) {
            this.f23901a = composerTopicsDetector;
        }

        public void run() {
            if (!this.f23901a.f23921r) {
                Object obj;
                ComposerTopicsDetector composerTopicsDetector = this.f23901a;
                if (StringUtil.a(composerTopicsDetector.f23912i, ((ProvidesTextWithEntities) composerTopicsDetector.f23907d).ae().a())) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null || ComposerTopicsDetector.m25877i(this.f23901a) || this.f23901a.f23923t > 0) {
                    ComposerTopicsDetector.m25880n(this.f23901a);
                    if (this.f23901a.f23923t > 0 && this.f23901a.f23911h.m25901a()) {
                        composerTopicsDetector = this.f23901a;
                        composerTopicsDetector.f23923t--;
                        ComposerTopicsDetector.m25875b(this.f23901a, this.f23901a.f23909f.m());
                        return;
                    }
                    return;
                }
            }
            ComposerTopicsDetector.m25881o(this.f23901a);
        }
    }

    @Inject
    public ComposerTopicsDetector(@Assisted ComposerTopicLogger composerTopicLogger, @Assisted DataProvider dataProvider, ComposerTopicsVisualDebugger composerTopicsVisualDebugger, TopicClassificationFetcher topicClassificationFetcher, TopicFeedsTestUtil topicFeedsTestUtil, TopicsPhotoManagerProvider topicsPhotoManagerProvider) {
        this.f23907d = dataProvider;
        this.f23909f = topicFeedsTestUtil;
        this.f23905b = composerTopicLogger;
        this.f23906c = composerTopicsVisualDebugger;
        this.f23908e = topicClassificationFetcher;
        this.f23910g = new TopicsPredictionParam(((ProvidesConfiguration) dataProvider).o().getTopics());
        if (m25882r()) {
            this.f23911h = new TopicsPhotoManager((ProvidesSessionId) this.f23907d, IdBasedLazy.a(topicsPhotoManagerProvider, 9495), IdBasedSingletonScopeProvider.b(topicsPhotoManagerProvider, 3832), MediaUploadCancelHandler.b(topicsPhotoManagerProvider), UploadOperationHelper.b(topicsPhotoManagerProvider), IdBasedProvider.a(topicsPhotoManagerProvider, 9491));
            this.f23911h.f23954j = new C28981(this);
        }
    }

    public final void m25884a(ComposerEvent composerEvent, ImmutableList<GraphQLExploreFeed> immutableList) {
        if (composerEvent == ComposerEvent.ON_USER_POST || composerEvent == ComposerEvent.ON_DESTROY_VIEW) {
            m25883a();
        } else if (composerEvent == ComposerEvent.ON_FIRST_DRAW) {
            m25879m();
        } else if (composerEvent == ComposerEvent.ON_STATUS_TEXT_CHANGED || composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            int i = 0;
            if (m25882r()) {
                i = this.f23911h.m25900a(this.f23907d.m());
            }
            TopicsPredictionParam topicsPredictionParam = this.f23910g;
            int size = immutableList.size();
            int i2 = 0;
            Object obj = null;
            while (i2 < size) {
                TopicInfo topicInfo;
                Object obj2;
                GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) immutableList.get(i2);
                String n = graphQLExploreFeed.n();
                if (topicsPredictionParam.f23960a.containsKey(n)) {
                    topicInfo = (TopicInfo) topicsPredictionParam.f23960a.get(n);
                } else {
                    TopicInfo topicInfo2 = new TopicInfo(graphQLExploreFeed.n());
                    topicsPredictionParam.f23960a.put(n, topicInfo2);
                    topicInfo = topicInfo2;
                }
                if (TopicsPredictionParam.m25903a(topicInfo)) {
                    obj2 = obj;
                } else {
                    TopicInfo.m25902a(topicInfo, -1.0d);
                    obj2 = 1;
                }
                i2++;
                obj = obj2;
            }
            Object obj3 = obj;
            if (m25877i(this) || obj3 != null) {
                m25880n(this);
                return;
            }
            if (composerEvent != ComposerEvent.ON_STATUS_TEXT_CHANGED) {
                if ((i & 1) != 0) {
                    return;
                }
                if ((i & 4) <= 0 && (i & 2) <= 0) {
                    return;
                }
            }
            long e = this.f23909f.e();
            if (this.f23920q == null) {
                m25875b(this, e);
            }
        }
    }

    public final void m25883a() {
        m25881o(this);
        if (this.f23911h != null) {
            this.f23911h.f23949e.c();
        }
        if (this.f23922s != null) {
            this.f23922s = null;
        }
    }

    private boolean m25876f() {
        if (((ProvidesTaggedUsers) this.f23907d).h() == null || ((ProvidesTaggedUsers) this.f23907d).h().isEmpty()) {
            return false;
        }
        if (this.f23916m == null || ((ProvidesTaggedUsers) this.f23907d).h().size() != this.f23916m.size()) {
            return true;
        }
        ImmutableList h = ((ProvidesTaggedUsers) this.f23907d).h();
        int size = h.size();
        for (int i = 0; i < size; i++) {
            if (!this.f23916m.contains(String.valueOf(((ComposerTaggedUser) h.get(i)).a()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m25877i(ComposerTopicsDetector composerTopicsDetector) {
        Object obj = ((ProvidesShareParams) composerTopicsDetector.f23907d).q() == null ? null : !StringUtil.a(composerTopicsDetector.f23913j, ((ProvidesShareParams) composerTopicsDetector.f23907d).q().linkForShare) ? 1 : null;
        if (obj == null) {
            obj = (((ProvidesLocationInfo) composerTopicsDetector.f23907d).g() == null || ((ProvidesLocationInfo) composerTopicsDetector.f23907d).g().j() == -1) ? null : !StringUtil.a(composerTopicsDetector.f23914k, String.valueOf(((ProvidesLocationInfo) composerTopicsDetector.f23907d).g().j())) ? 1 : null;
            if (obj == null && !composerTopicsDetector.m25876f()) {
                obj = ((ProvidesMinutiae) composerTopicsDetector.f23907d).l() == null ? null : (composerTopicsDetector.f23917n == null || !((ProvidesMinutiae) composerTopicsDetector.f23907d).l().b(composerTopicsDetector.f23917n)) ? 1 : null;
                if (obj == null) {
                    obj = ((ProvidesConfiguration) composerTopicsDetector.f23907d).o().getAttachedStory() == null ? null : !StringUtil.a(composerTopicsDetector.f23918o, ((ProvidesConfiguration) composerTopicsDetector.f23907d).o().getAttachedStory().aO()) ? 1 : null;
                    if (obj == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<String> m25878l() {
        List<String> arrayList = new ArrayList();
        if (this.f23913j != null) {
            arrayList.add(this.f23913j);
        }
        if (this.f23918o != null) {
            arrayList.add(this.f23918o);
        }
        return arrayList;
    }

    public static void m25875b(ComposerTopicsDetector composerTopicsDetector, long j) {
        m25881o(composerTopicsDetector);
        composerTopicsDetector.f23920q = new C29014(composerTopicsDetector);
        HandlerDetour.b(composerTopicsDetector.f23919p, composerTopicsDetector.f23920q, j, -1541655622);
    }

    private void m25879m() {
        String valueOf;
        String str = null;
        this.f23912i = ((ProvidesTextWithEntities) this.f23907d).ae().a();
        this.f23913j = ((ProvidesShareParams) this.f23907d).q() != null ? ((ProvidesShareParams) this.f23907d).q().linkForShare : null;
        if (((ProvidesLocationInfo) this.f23907d).g() != null) {
            valueOf = String.valueOf(((ProvidesLocationInfo) this.f23907d).g().j());
        } else {
            valueOf = null;
        }
        this.f23914k = valueOf;
        this.f23915l = Lists.a(MentionsUtils.a(((ProvidesTextWithEntities) this.f23907d).ae()), new C28992(this));
        this.f23916m = Lists.a(((ProvidesTaggedUsers) this.f23907d).h(), new C29003(this));
        this.f23917n = ((ProvidesMinutiae) this.f23907d).l();
        if (((ProvidesConfiguration) this.f23907d).o().getAttachedStory() != null) {
            str = ((ProvidesConfiguration) this.f23907d).o().getAttachedStory().aO();
        }
        this.f23918o = str;
    }

    public static void m25880n(ComposerTopicsDetector composerTopicsDetector) {
        final String uuid = SafeUUIDGenerator.a().toString();
        String a = ((ProvidesTextWithEntities) composerTopicsDetector.f23907d).ae().a();
        composerTopicsDetector.f23905b.m25911a(((ProvidesIsImplicitLocationSupported) composerTopicsDetector.f23907d).G(), composerTopicsDetector.f23907d.m().size(), a, uuid);
        composerTopicsDetector.f23906c.m25887a(a);
        composerTopicsDetector.f23921r = true;
        m25881o(composerTopicsDetector);
        composerTopicsDetector.m25879m();
        FeedTopicsClassificationInputQueryParams feedTopicsClassificationInputQueryParams = new FeedTopicsClassificationInputQueryParams();
        feedTopicsClassificationInputQueryParams.a("message", composerTopicsDetector.f23912i);
        GraphQlCallInput graphQlCallInput = feedTopicsClassificationInputQueryParams;
        graphQlCallInput.a("session_id", ((ProvidesSessionId) composerTopicsDetector.f23907d).ab());
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.a("mention_ids", composerTopicsDetector.f23915l);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("tagged_profile_ids", composerTopicsDetector.f23916m);
        graphQlCallInput2 = graphQlCallInput2;
        TopicsPredictionParam topicsPredictionParam = composerTopicsDetector.f23910g;
        Builder builder = new Builder();
        for (TopicInfo topicInfo : topicsPredictionParam.f23960a.values()) {
            Topics topics = new Topics();
            topics.a("feed_id", topicInfo.f23957a);
            GraphQlCallInput graphQlCallInput3 = topics;
            if (topicInfo.f23958b != null) {
                graphQlCallInput3.a("confidence", topicInfo.f23958b);
            }
            if (topicInfo.f23959c != null) {
                graphQlCallInput3.a("context", topicInfo.f23959c);
            }
            builder.c(graphQlCallInput3);
        }
        graphQlCallInput2.a("topics", builder.b());
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("urls", composerTopicsDetector.m25878l());
        graphQlCallInput = graphQlCallInput2;
        long j = ((ProvidesConfiguration) composerTopicsDetector.f23907d).o().getInitialTargetData().targetId;
        if (j > 0) {
            graphQlCallInput.a("target_ent_id", String.valueOf(j));
        }
        if (composerTopicsDetector.f23914k != null) {
            graphQlCallInput.a("place_tag_id", composerTopicsDetector.f23914k);
        }
        if (composerTopicsDetector.m25882r() && composerTopicsDetector.f23911h.m25901a()) {
            graphQlCallInput.a("photo_ids", composerTopicsDetector.f23911h.f23955k);
            graphQlCallInput.a("captions", composerTopicsDetector.f23911h.f23956l);
        }
        if (composerTopicsDetector.f23917n != null) {
            MinutiaeTag d = composerTopicsDetector.f23917n.d();
            if (d.ogActionTypeId != null) {
                graphQlCallInput.a("minutiae_action_id", d.ogActionTypeId);
            }
            if (d.ogObjectId != null) {
                graphQlCallInput.a("minutiae_object_id", d.ogObjectId);
            }
            if (d.ogPhrase != null) {
                graphQlCallInput.a("minutiae_object_string", d.ogPhrase);
            }
        }
        composerTopicsDetector.f23908e.a(graphQlCallInput, new AbstractDisposableFutureCallback<GraphQLResult<TopicClassificationQueryModel>>(composerTopicsDetector) {
            final /* synthetic */ ComposerTopicsDetector f23903b;

            protected final void m25873a(Object obj) {
                List a = ((TopicClassificationQueryModel) ((GraphQLResult) obj).e).a();
                this.f23903b.f23910g.m25904a(a);
                Collection arrayList = new ArrayList();
                for (int i = 0; i < a.size(); i++) {
                    GraphQLExploreFeed graphQLExploreFeed;
                    FeedTopicModel k = ((PredictedFeedTopicsModel) a.get(i)).k();
                    if (k == null) {
                        graphQLExploreFeed = null;
                    } else {
                        GraphQLExploreFeed.Builder builder = new GraphQLExploreFeed.Builder();
                        builder.i = k.b();
                        builder.l = k.c();
                        graphQLExploreFeed = builder.a();
                    }
                    arrayList.add(graphQLExploreFeed);
                }
                if (this.f23903b.f23922s != null) {
                    this.f23903b.f23922s.m25847a(arrayList);
                }
                this.f23903b.f23905b.m25912a(true, ImmutableList.copyOf(arrayList), uuid);
                this.f23903b.f23906c.m25889a(a);
            }

            protected final void m25874a(Throwable th) {
                this.f23903b.f23905b.m25912a(false, RegularImmutableList.a, uuid);
                this.f23903b.f23906c.m25888a(th);
                BLog.b(ComposerTopicsDetector.f23904a, "Failed to predict topics", th);
            }
        });
        composerTopicsDetector.f23921r = false;
    }

    public static void m25881o(ComposerTopicsDetector composerTopicsDetector) {
        if (composerTopicsDetector.f23920q != null) {
            HandlerDetour.a(composerTopicsDetector.f23919p, composerTopicsDetector.f23920q);
            composerTopicsDetector.f23920q = null;
        }
    }

    private boolean m25882r() {
        return this.f23909f.f();
    }
}
