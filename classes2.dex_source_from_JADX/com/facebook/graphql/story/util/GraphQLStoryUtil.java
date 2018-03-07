package com.facebook.graphql.story.util;

import android.text.TextUtils;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedback.reactions.socialcontext.SocialContextHelper;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLGraphSearchSnippet;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces$ShouldDisplaySubStoryGalleryGraphQL.AllSubstories.Nodes;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces.HasFeedbackTargetOfTypeGraphQL;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels$ShouldDisplaySubStoryGalleryGraphQLModel.AllSubstoriesModel.NodesModel.AttachmentsModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_push_notification_ack */
public class GraphQLStoryUtil {
    private static final String f5601a = GraphQLStoryUtil.class.getSimpleName();
    private static volatile GraphQLStoryUtil f5602i;
    public final MessengerAppUtils f5603b;
    private final Provider<ViewerContext> f5604c;
    private final SocialContextHelper f5605d;
    public Provider<String> f5606e;
    private AbstractFbErrorReporter f5607f;
    public QeAccessor f5608g;
    public Boolean f5609h;

    public static com.facebook.graphql.story.util.GraphQLStoryUtil m9565a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5602i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.story.util.GraphQLStoryUtil.class;
        monitor-enter(r1);
        r0 = f5602i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9571b(r0);	 Catch:{ all -> 0x0035 }
        f5602i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5602i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.story.util.GraphQLStoryUtil.a(com.facebook.inject.InjectorLike):com.facebook.graphql.story.util.GraphQLStoryUtil");
    }

    private static GraphQLStoryUtil m9571b(InjectorLike injectorLike) {
        return new GraphQLStoryUtil(MessengerAppUtils.m8662a(injectorLike), IdBasedProvider.m1811a(injectorLike, 372), IdBasedProvider.m1811a(injectorLike, 4442), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), SocialContextHelper.m9606b(injectorLike));
    }

    @Inject
    public GraphQLStoryUtil(MessengerAppUtils messengerAppUtils, Provider<ViewerContext> provider, Provider<String> provider2, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, SocialContextHelper socialContextHelper) {
        this.f5603b = messengerAppUtils;
        this.f5604c = provider;
        this.f5606e = provider2;
        this.f5607f = fbErrorReporter;
        this.f5608g = qeAccessor;
        this.f5605d = socialContextHelper;
    }

    public static FeedProps<GraphQLStory> m9564a(FeedProps<GraphQLStory> feedProps, Function<GraphQLStory, Boolean> function) {
        Preconditions.checkNotNull(feedProps.f13444a);
        Preconditions.checkNotNull(function);
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        ImmutableList d = feedProps.m19808d();
        int size = d.size();
        int i = 0;
        Flattenable flattenable = graphQLStory;
        while (i < size) {
            Flattenable flattenable2 = (Flattenable) d.get(i);
            if (!(flattenable2 instanceof GraphQLStory) || Boolean.FALSE.equals(function.apply((GraphQLStory) flattenable2))) {
                break;
            }
            i++;
            Object obj = (GraphQLStory) flattenable2;
        }
        return flattenable == feedProps.f13444a ? feedProps : FeedProps.m19801a(flattenable, d.subList(d.indexOf(flattenable) + 1, d.size()));
    }

    public static boolean m9572b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (!(graphQLStory == null || graphQLStory.mo2890l() == null)) {
            Object obj;
            FeedProps feedProps2 = feedProps.f13445b;
            while (feedProps2 != null && (feedProps2.f13444a instanceof GraphQLStory)) {
                if (((GraphQLStory) feedProps2.f13444a).mo2890l() != null) {
                    obj = 1;
                    break;
                }
                feedProps2 = feedProps2.f13445b;
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static FeedProps<GraphQLStory> m9583o(FeedProps<GraphQLStory> feedProps) {
        return StorySharingHelper.m30305b((GraphQLStory) feedProps.f13444a) ? feedProps : null;
    }

    public static String m9586q(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Iterator it = feedProps.m19808d().iterator();
        GraphQLStory graphQLStory2 = graphQLStory;
        while (graphQLStory2.aO() == null && it.hasNext()) {
            Flattenable flattenable = (Flattenable) it.next();
            if (!(flattenable instanceof GraphQLStory)) {
                break;
            }
            graphQLStory2 = (GraphQLStory) flattenable;
        }
        if (graphQLStory2.aO() != null) {
            return graphQLStory2.aO();
        }
        graphQLStory = graphQLStory2.m22326L();
        if (graphQLStory == null || graphQLStory.aO() == null) {
            return null;
        }
        return graphQLStory.aO();
    }

    public static GraphQLSponsoredData m9588r(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        ImmutableList d = feedProps.m19808d();
        int size = d.size();
        int i = 0;
        GraphQLStory graphQLStory2 = graphQLStory;
        while (i < size) {
            Flattenable flattenable = (Flattenable) d.get(i);
            if (!(flattenable instanceof GraphQLStory) || ((GraphQLStory) flattenable).ay() == null) {
                break;
            }
            i++;
            graphQLStory2 = (GraphQLStory) flattenable;
        }
        return graphQLStory2.ay();
    }

    public final boolean m9594c(FeedProps<GraphQLStory> feedProps) {
        return m9572b((FeedProps) feedProps) && m9577f((GraphQLStory) feedProps.f13444a);
    }

    public final boolean m9603n(FeedProps<GraphQLStory> feedProps) {
        return m9572b((FeedProps) feedProps) && ((GraphQLStory) feedProps.f13444a).mo2890l().m23247n();
    }

    public static String m9566a(GraphQLStory graphQLStory) {
        if (!(graphQLStory.m22327M() == null || graphQLStory.m22327M().isEmpty() || !StoryAttachmentHelper.m28030b(graphQLStory))) {
            if (m9569a(StoryUtilModelConverter.m28876a((GraphQLStoryAttachment) graphQLStory.m22327M().get(0)), -1304042141)) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
                GraphQLNode z = o.m23987z();
                if (z == null || z.m23365J() == null || z.m23365J().isEmpty()) {
                    return o.m23966C();
                }
                return (String) z.m23365J().get(0);
            }
        }
        return null;
    }

    public static boolean m9570a(C0843x6e0cef4c c0843x6e0cef4c) {
        if (!c0843x6e0cef4c.mo3154c() || c0843x6e0cef4c.mo3152a().size() != 1 || c0843x6e0cef4c.mo3153b() == null || c0843x6e0cef4c.mo3153b().a().size() <= 1) {
            return false;
        }
        ImmutableList b = ((Nodes) c0843x6e0cef4c.mo3153b().a().get(0)).b();
        if (b.isEmpty()) {
            return false;
        }
        ImmutableList b2 = ((AttachmentsModel) b.get(0)).b();
        ImmutableList a = c0843x6e0cef4c.mo3153b().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Nodes nodes = (Nodes) a.get(i);
            if (nodes.b().size() != 1 || !Objects.equal(b2, ((AttachmentsModel) nodes.b().get(0)).b()) || !m9569a((HasFeedbackTargetOfTypeGraphQL) nodes.b().get(0), -1703624614, -1304042141, 2479791)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m9569a(HasFeedbackTargetOfTypeGraphQL hasFeedbackTargetOfTypeGraphQL, int... iArr) {
        if (hasFeedbackTargetOfTypeGraphQL.a() == null || hasFeedbackTargetOfTypeGraphQL.a().b() == null) {
            return false;
        }
        int g = hasFeedbackTargetOfTypeGraphQL.a().b().m22301g();
        for (int i : iArr) {
            if (g == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean m9573b(GraphQLStory graphQLStory) {
        return graphQLStory.mo2507g() == null;
    }

    public static boolean m9576d(@Nullable GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return false;
        }
        GraphQLStoryActionLink a = StoryActionLinkHelper.m28072a(graphQLStory, -2052107768);
        if (a == null || a.ah() == null || a.ah().ar() == GraphQLSubscribeStatus.CANNOT_SUBSCRIBE) {
            return false;
        }
        return true;
    }

    public static boolean m9567a(FeedProps<GraphQLStory> feedProps) {
        return feedProps != null && StoryProps.m27466p(feedProps);
    }

    public static boolean m9577f(GraphQLStory graphQLStory) {
        return graphQLStory != null && (graphQLStory.m22369z() || StorySharingHelper.m30305b(graphQLStory) || graphQLStory.m22315A());
    }

    public static boolean m9575d(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory == null) {
            return false;
        }
        if (PropertyHelper.m21288b(graphQLStory) != null) {
            return true;
        }
        graphQLStory = StoryProps.m27456c(feedProps);
        return (graphQLStory == null || graphQLStory.m22326L() == null || PropertyHelper.m21288b(graphQLStory) == null) ? false : true;
    }

    @Nullable
    public final ImmutableList<GraphQLComment> m9595e(FeedProps<GraphQLStory> feedProps) {
        ImmutableList s = m9589s((FeedProps) feedProps);
        if (s == null || s.isEmpty()) {
            return null;
        }
        boolean a = this.f5608g.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMultipleRowsStoriesAbtestModule.f6718h, false);
        Builder builder = ImmutableList.builder();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            GraphQLComment graphQLComment = (GraphQLComment) s.get(i);
            if (graphQLComment != null) {
                if (GraphQLCommentHelper.m29313i(graphQLComment)) {
                    builder.m1069c(graphQLComment);
                } else {
                    Object obj;
                    if (GraphQLCommentHelper.m29311f(graphQLComment) != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null || GraphQLCommentHelper.m29312g(graphQLComment)) {
                        this.f5608g.mo590a(Liveness.Cached, ExperimentsForMultipleRowsStoriesAbtestModule.f6718h);
                        if (a) {
                            builder.m1069c(graphQLComment);
                        }
                    }
                }
            }
        }
        return builder.m1068b();
    }

    @Nullable
    private ImmutableList<GraphQLComment> m9589s(FeedProps<GraphQLStory> feedProps) {
        if (((GraphQLStory) feedProps.f13444a) == null) {
            return null;
        }
        GraphQLStory c = StoryProps.m27456c(feedProps);
        if (c == null || !StoryProps.m27464m(StoryProps.m27455b(feedProps))) {
            c = (GraphQLStory) feedProps.f13444a;
        }
        GraphQLStory graphQLStory = c;
        if (graphQLStory.aa() == null) {
            return null;
        }
        return graphQLStory.aa().m24203m();
    }

    public final boolean m9596f(FeedProps<GraphQLStory> feedProps) {
        if (((GraphQLStory) feedProps.f13444a) == null) {
            return false;
        }
        ImmutableList e = m9595e(feedProps);
        return (e == null || e.isEmpty()) ? false : true;
    }

    public final ImmutableList<GraphQLActor> m9597g(FeedProps<GraphQLStory> feedProps) {
        if (!m9596f((FeedProps) feedProps)) {
            return RegularImmutableList.f535a;
        }
        ImmutableList s = m9589s((FeedProps) feedProps);
        if (s == null || s.isEmpty()) {
            return RegularImmutableList.f535a;
        }
        Builder builder = ImmutableList.builder();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            GraphQLComment graphQLComment = (GraphQLComment) s.get(i);
            if (graphQLComment.m27185r() != null) {
                builder.m1069c(graphQLComment.m27185r());
            }
        }
        return builder.m1068b();
    }

    public final boolean m9599h(@Nullable FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            return false;
        }
        if (!StoryHierarchyHelper.m27437d((GraphQLStory) feedProps.f13444a)) {
            return false;
        }
        if (StoryAttachmentHelper.m28029a((GraphQLStory) feedProps.f13444a) || ((GraphQLStory) feedProps.f13444a).m22326L() != null) {
            return this.f5608g.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6712b, false);
        }
        return false;
    }

    public final int m9600i(@Nullable FeedProps<GraphQLStory> feedProps) {
        int i = 0;
        if (feedProps == null) {
            return 0;
        }
        FeedProps b = StoryProps.m27455b(feedProps);
        if (b == null) {
            return 0;
        }
        boolean m = m9599h(b) ? StoryProps.m27464m(b) : m9578j((FeedProps) feedProps) || StoryProps.m27464m(b);
        int i2 = m9600i(b);
        if (!m) {
            i = 1;
        }
        return i + i2;
    }

    public static boolean m9578j(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLStory c = StoryProps.m27456c(feedProps);
        if (c == null || !StoryHierarchyHelper.m27437d(c)) {
            return false;
        }
        List j = StoryHierarchyHelper.m27434a(c).m22608j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) == graphQLStory) {
                return true;
            }
        }
        for (int i2 = 0; i2 < j.size(); i2++) {
            if (TextUtils.equals(((GraphQLStory) j.get(i2)).m22350c(), graphQLStory.m22350c())) {
                return true;
            }
        }
        return false;
    }

    public final ImmutableList<String> m9598h(GraphQLStory graphQLStory) {
        Builder builder = ImmutableList.builder();
        if (!StringUtil.m3589a(graphQLStory.mo2507g())) {
            builder.m1069c(graphQLStory.mo2507g());
        }
        if (graphQLStory.m22326L() != null) {
            builder.m1065b(m9598h(graphQLStory.m22326L()));
        }
        if (!StoryHierarchyHelper.m27434a(graphQLStory).m22608j().isEmpty()) {
            ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                builder.m1065b(m9598h((GraphQLStory) j.get(i)));
            }
        }
        return builder.m1068b();
    }

    public static boolean m9579j(GraphQLStory graphQLStory) {
        GraphQLGraphSearchResultDecoration i = PropertyHelper.m21307i(graphQLStory);
        if (i == null) {
            return false;
        }
        ImmutableList l = i.l();
        if (l == null || l.isEmpty()) {
            return false;
        }
        l = ((GraphQLGraphSearchSnippet) l.get(0)).a();
        return (l == null || l.isEmpty()) ? false : true;
    }

    public final boolean m9593a(GraphQLStory graphQLStory, ImmutableList<?> immutableList) {
        return m9591v(graphQLStory) && !m9574b((ImmutableList) immutableList);
    }

    private boolean m9591v(GraphQLStory graphQLStory) {
        if (graphQLStory.mo2890l() != null) {
            GraphQLFeedback l = graphQLStory.mo2890l();
            Object obj = (l.m23211E() == null || l.m23211E().m22671a() == 0) ? null : 1;
            if (obj != null || graphQLStory.mo2890l().m23247n()) {
                return true;
            }
        }
        return false;
    }

    private boolean m9574b(ImmutableList<?> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj = immutableList.get(i);
            if ((obj instanceof GraphQLStory) && m9591v((GraphQLStory) obj)) {
                return true;
            }
        }
        return false;
    }

    public final Optional<GraphQLTextWithEntities> m9592a(GraphQLFeedback graphQLFeedback) {
        Object obj = null;
        if (graphQLFeedback != null) {
            String b = this.f5605d.m9607b(graphQLFeedback);
            if (!Strings.isNullOrEmpty(b)) {
                GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
                builder.f15877i = b;
                obj = builder.m22613a();
            }
        }
        return Optional.fromNullable(obj);
    }

    public final boolean m9601k(FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedUnit c = AttachmentProps.m28714c(feedProps);
        GraphQLStory a = AttachmentProps.m28712a((FeedProps) feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        String m = graphQLStoryAttachment.m23974m();
        if (a == null || c == null) {
            Object obj;
            FeedProps g = AttachmentProps.m28717g(feedProps);
            String str = "%s parent:%s, url:%s mediaUrl:%s title:%s subtitle:%s dedupkey:%s";
            Object[] objArr = new Object[7];
            objArr[0] = f5601a;
            if (g != null) {
                obj = g.f13444a;
            } else {
                obj = null;
            }
            objArr[1] = obj;
            objArr[2] = Strings.nullToEmpty(graphQLStoryAttachment.m23966C());
            objArr[3] = GraphQLStoryAttachmentUtil.m28064o(graphQLStoryAttachment);
            objArr[4] = graphQLStoryAttachment.m23964A();
            objArr[5] = GraphQLStoryAttachmentUtil.m28068s(graphQLStoryAttachment);
            objArr[6] = graphQLStoryAttachment.m23974m();
            SoftErrorBuilder a2 = SoftError.a(StringFormatUtil.a(str, objArr), "NPE of attachment story");
            a2.f = true;
            this.f5607f.mo336a(a2.g());
            return false;
        } else if (GraphQLStoryAttachmentUtil.m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.QUOTED_SHARE)) {
            return true;
        } else {
            Queue linkedList = new LinkedList();
            linkedList.add(a);
            while (!linkedList.isEmpty()) {
                FeedUnit feedUnit = (GraphQLStory) linkedList.remove();
                if (m9568a(feedUnit, c)) {
                    return true;
                }
                Object obj2;
                ImmutableList M = feedUnit.m22327M();
                if (M == null || m == null) {
                    obj2 = null;
                } else {
                    int size = M.size();
                    for (int i = 0; i < size; i++) {
                        if (m.equals(((GraphQLStoryAttachment) M.get(i)).m23974m())) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    return false;
                }
                if (feedUnit.m22326L() != null) {
                    linkedList.add(feedUnit.m22326L());
                }
                linkedList.addAll(StoryHierarchyHelper.m27434a(feedUnit).m22608j());
            }
            throw new RuntimeException("Something must be wrong with the attachmentProps: " + feedProps);
        }
    }

    public static boolean m9580l(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory c = StoryProps.m27456c(feedProps);
        return c != null && StoryHierarchyHelper.m27437d(c);
    }

    public static GraphQLStory m9581m(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.aG() == null) {
            return graphQLStory;
        }
        GraphQLStory.Builder a = GraphQLStory.Builder.a(graphQLStory);
        a.ax = null;
        return a.a();
    }

    public final int m9602m(@Nullable FeedProps<? extends FeedUnit> feedProps) {
        if (feedProps == null) {
            return -1;
        }
        if (((FeedUnit) feedProps.f13444a) instanceof GraphQLStory) {
            return m9600i(feedProps);
        }
        return 0;
    }

    public static boolean m9582n(GraphQLStory graphQLStory) {
        if (StoryAttachmentHelper.m28037j(graphQLStory)) {
            return true;
        }
        GraphQLStory L = graphQLStory.m22326L();
        if (L == null || !StoryAttachmentHelper.m28037j(L)) {
            return false;
        }
        return true;
    }

    public final boolean m9604o(GraphQLStory graphQLStory) {
        return m9585p(graphQLStory) != null;
    }

    @Nullable
    public static GraphQLStoryAttachment m9585p(GraphQLStory graphQLStory) {
        if (!StoryAttachmentHelper.m28029a(graphQLStory)) {
            return null;
        }
        ImmutableList M = graphQLStory.m22327M();
        int i = 0;
        while (i < M.size()) {
            if (GraphQLStoryAttachmentUtil.m28055d((GraphQLStoryAttachment) M.get(i)) && ((GraphQLStoryAttachment) M.get(i)).m23979r() != null && ((GraphQLStoryAttachment) M.get(i)).m23979r().al()) {
                return (GraphQLStoryAttachment) M.get(i);
            }
            i++;
        }
        return null;
    }

    public static boolean m9568a(FeedUnit feedUnit, FeedUnit feedUnit2) {
        if (feedUnit == feedUnit2) {
            return true;
        }
        if (feedUnit == null || feedUnit2 == null) {
            return false;
        }
        if ((feedUnit instanceof GraphQLStory) && (feedUnit2 instanceof GraphQLStory)) {
            return TextUtils.equals(((GraphQLStory) feedUnit).m22350c(), ((GraphQLStory) feedUnit2).m22350c());
        }
        return TextUtils.equals(feedUnit.mo2507g(), feedUnit2.mo2507g());
    }

    public static boolean m9587q(GraphQLStory graphQLStory) {
        return (graphQLStory == null || graphQLStory.aJ() == null || graphQLStory.aJ().m23000j() == null || graphQLStory.aJ().m23000j().m22301g() != 69076575) ? false : true;
    }

    public static boolean m9590s(GraphQLStory graphQLStory) {
        return ActionLinkHelper.m22938a(graphQLStory.m22319E(), -1160597742) != null;
    }

    public final boolean m9605u(GraphQLStory graphQLStory) {
        if (!StorySharingHelper.m30305b(graphQLStory)) {
            return false;
        }
        GraphQLFeedback l = graphQLStory.mo2890l();
        if (this.f5609h == null) {
            this.f5609h = Boolean.valueOf(this.f5603b.m8664a());
        }
        if (!this.f5609h.booleanValue() || ((l != null && l.m23221O() != null) || ((ViewerContext) this.f5604c.get()).mIsPageContext)) {
            return false;
        }
        return true;
    }

    public static FeedProps<GraphQLStory> m9584p(FeedProps<GraphQLStory> feedProps) {
        Flattenable flattenable;
        FeedProps<GraphQLStory> o = m9583o((FeedProps) feedProps);
        if (o == null) {
            flattenable = null;
        } else {
            flattenable = ((GraphQLStory) o.f13444a).m22326L();
        }
        return flattenable != null ? o.m19803a(flattenable) : o;
    }
}
