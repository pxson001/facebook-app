package com.facebook.feed.util.story;

import com.facebook.adinterfaces.external.AdInterfacesExternalGatekeepers;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.feed.util.story.C0870xa5832e5a.ActorsModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldRenderOrganicHScrollGraphQLModel.AllSubstoriesModel.NodesModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.IsPopularObjectsStoryGraphQLModel.AttachmentsModel;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLStoryHeaderStyle;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLBoostedComponent;
import com.facebook.graphql.model.GraphQLBoostedComponentMessage;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLStoryHeader;
import com.facebook.graphql.model.GraphQLStoryInsights;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.StorySponsoredHelper;
import com.facebook.graphql.story.util.C0843x6e0cef4c;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_info_rtt_max */
public class FeedStoryUtil {
    private static volatile FeedStoryUtil f12501g;
    private final ImmutableList<GraphQLStoryAttachmentStyle> f12502a = ImmutableList.of(GraphQLStoryAttachmentStyle.LIFE_EVENT, GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM);
    private final QeAccessor f12503b;
    private final GraphQLStoryUtil f12504c;
    public final OptimisticStoryStateCache f12505d;
    private final InlineCommentComposerCache f12506e;
    private final AdInterfacesExternalGatekeepers f12507f;

    public static com.facebook.feed.util.story.FeedStoryUtil m18578a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12501g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.util.story.FeedStoryUtil.class;
        monitor-enter(r1);
        r0 = f12501g;	 Catch:{ all -> 0x003a }
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
        r0 = m18582b(r0);	 Catch:{ all -> 0x0035 }
        f12501g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12501g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtil.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.story.FeedStoryUtil");
    }

    private static FeedStoryUtil m18582b(InjectorLike injectorLike) {
        return new FeedStoryUtil(GraphQLStoryUtil.m9565a(injectorLike), AdInterfacesExternalGatekeepers.m18593a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike), InlineCommentComposerCache.m14459a(injectorLike));
    }

    @Inject
    public FeedStoryUtil(GraphQLStoryUtil graphQLStoryUtil, AdInterfacesExternalGatekeepers adInterfacesExternalGatekeepers, QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, InlineCommentComposerCache inlineCommentComposerCache) {
        this.f12504c = graphQLStoryUtil;
        this.f12507f = adInterfacesExternalGatekeepers;
        this.f12503b = qeAccessor;
        this.f12505d = optimisticStoryStateCache;
        this.f12506e = inlineCommentComposerCache;
    }

    public static boolean m18579a(C0870xa5832e5a c0870xa5832e5a) {
        if (c0870xa5832e5a.mo3152a() == null || c0870xa5832e5a.mo3152a().isEmpty()) {
            return false;
        }
        ActorsModel actorsModel = (ActorsModel) c0870xa5832e5a.mo3152a().get(0);
        if (actorsModel == null || actorsModel.m29622b() == null) {
            return false;
        }
        if (c0870xa5832e5a.iB_() != null) {
            return true;
        }
        if (c0870xa5832e5a.iA_() != null) {
            return true;
        }
        if (c0870xa5832e5a.m29611g() != null) {
            return false;
        }
        if (c0870xa5832e5a.iC_() != null && c0870xa5832e5a.iC_().a() != null && !c0870xa5832e5a.iC_().a().isEmpty() && !GraphQLStoryUtil.m9570a((C0843x6e0cef4c) c0870xa5832e5a)) {
            return false;
        }
        int i;
        if (c0870xa5832e5a.mo3206d() == null || c0870xa5832e5a.mo3206d().isEmpty()) {
            i = 0;
        } else {
            AttachmentsModel attachmentsModel = (AttachmentsModel) c0870xa5832e5a.mo3206d().get(0);
            i = (attachmentsModel == null || attachmentsModel.a().isEmpty() || attachmentsModel.a().get(0) != GraphQLStoryAttachmentStyle.POPULAR_OBJECTS) ? 0 : 1;
        }
        return i == 0;
    }

    public static boolean m18585e(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        Object obj = null;
        if (graphQLStory != null) {
            GraphQLStoryHeader aA = graphQLStory.aA();
            if (aA != null) {
                Object obj2;
                ImmutableList m = aA.m24867m();
                GraphQLStoryHeaderStyle graphQLStoryHeaderStyle = GraphQLStoryHeaderStyle.FACEBOOK_VOICE;
                if (m == null) {
                    obj2 = null;
                } else {
                    int size = m.size();
                    for (int i = 0; i < size; i++) {
                        if (((GraphQLStoryHeaderStyle) m.get(i)) == graphQLStoryHeaderStyle) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    obj = 1;
                }
            }
        }
        return (obj == null || graphQLStory.aD() != 0 || StoryProps.m27464m(feedProps)) ? false : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m18588a(com.facebook.feed.rows.core.props.FeedProps<com.facebook.graphql.model.GraphQLStory> r10, com.facebook.feed.rows.core.props.FeedProps<com.facebook.graphql.model.GraphQLStory> r11, @javax.annotation.Nullable com.facebook.feed.ui.api.FeedMenuHelper r12, boolean r13) {
        /*
        r9 = this;
        r3 = r10.f13444a;
        r0 = r3;
        r0 = (com.facebook.graphql.model.GraphQLStory) r0;
        if (r12 == 0) goto L_0x007d;
    L_0x0007:
        r1 = r12.m18406a(r0);
        r1 = r1.mo3188a(r11);
        if (r1 == 0) goto L_0x007d;
    L_0x0011:
        r6 = r10.f13444a;
        r3 = r6;
        r3 = (com.facebook.graphql.model.GraphQLStory) r3;
        r6 = r11.f13444a;
        r4 = r6;
        r4 = (com.facebook.graphql.model.GraphQLStory) r4;
        r5 = com.facebook.feed.rows.core.props.StoryProps.m27456c(r10);
        if (r5 != 0) goto L_0x003b;
    L_0x0021:
        r5 = com.facebook.graphql.model.StoryHierarchyHelper.m27437d(r3);
        if (r5 != 0) goto L_0x003b;
    L_0x0027:
        r6 = 0;
        r7 = com.facebook.feed.rows.core.props.StoryProps.m27454a(r10);
        if (r7 == 0) goto L_0x0038;
    L_0x002e:
        r7 = r7.jK_();
        r8 = -1889837793; // 0xffffffff8f5b5d1f float:-1.0815468E-29 double:NaN;
        if (r7 != r8) goto L_0x0038;
    L_0x0037:
        r6 = 1;
    L_0x0038:
        r5 = r6;
        if (r5 == 0) goto L_0x005b;
    L_0x003b:
        r5 = com.facebook.graphql.story.util.GraphQLStoryUtil.m9580l(r11);
        if (r5 != 0) goto L_0x005b;
    L_0x0041:
        r4 = com.facebook.graphql.story.util.StoryUtilModelConverter.m28877a(r4);
        r4 = com.facebook.graphql.story.util.GraphQLStoryUtil.m9570a(r4);
        if (r4 != 0) goto L_0x005b;
    L_0x004b:
        r4 = com.facebook.feed.util.story.FeedStoryUtilModelConverter.m29448b(r3);
        r4 = m18580a(r4);
        if (r4 != 0) goto L_0x005b;
    L_0x0055:
        r3 = m18586e(r3);
        if (r3 == 0) goto L_0x007f;
    L_0x005b:
        r3 = 1;
    L_0x005c:
        r1 = r3;
        if (r1 == 0) goto L_0x007d;
    L_0x005f:
        if (r13 != 0) goto L_0x0067;
    L_0x0061:
        r1 = m18581a(r0);
        if (r1 != 0) goto L_0x007d;
    L_0x0067:
        r1 = r12.mo2465a();
        r2 = com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation.PERMALINK;
        if (r1 == r2) goto L_0x007b;
    L_0x006f:
        r1 = m18585e(r10);
        if (r1 == 0) goto L_0x007b;
    L_0x0075:
        r0 = m18586e(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x007b:
        r0 = 1;
    L_0x007c:
        return r0;
    L_0x007d:
        r0 = 0;
        goto L_0x007c;
    L_0x007f:
        r3 = 0;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.story.FeedStoryUtil.a(com.facebook.feed.rows.core.props.FeedProps, com.facebook.feed.rows.core.props.FeedProps, com.facebook.feed.menu.base.BaseFeedStoryMenuHelper, boolean):boolean");
    }

    public final boolean m18589b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory == null || graphQLStory.mo2890l() == null || !GraphQLHelper.m22479a(graphQLStory.mo2890l())) {
            return false;
        }
        if (!m18587a((FeedProps) feedProps)) {
            return true;
        }
        ImmutableList immutableList;
        boolean z;
        Collection<GraphQLActor> g = this.f12504c.m9597g(feedProps);
        if (graphQLStory == null || graphQLStory.mo2890l() == null || graphQLStory.mo2890l().m23212F() == null || graphQLStory.mo2890l().m23212F().m27546j() == null || graphQLStory.mo2890l().m23212F().m27546j().a() == null || !GraphQLHelper.m22479a(graphQLStory.mo2890l())) {
            immutableList = RegularImmutableList.f535a;
        } else {
            immutableList = graphQLStory.mo2890l().m23212F().m27546j().a();
        }
        ImmutableList<GraphQLActor> immutableList2 = immutableList;
        if (immutableList2 == null || immutableList2.isEmpty()) {
            z = false;
        } else if (g == null || g.isEmpty()) {
            z = true;
        } else {
            for (GraphQLActor graphQLActor : immutableList2) {
                Object obj;
                for (GraphQLActor graphQLActor2 : g) {
                    if (graphQLActor.m23765H() != null && graphQLActor.m23765H().equals(graphQLActor2.m23765H())) {
                        obj = null;
                        continue;
                        break;
                    }
                }
                int i = 1;
                continue;
                if (obj != null) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean m18587a(FeedProps<GraphQLStory> feedProps) {
        if (this.f12504c.m9596f((FeedProps) feedProps) && !GraphQLStoryUtil.m9575d((FeedProps) feedProps)) {
            GraphQLStory c = StoryProps.m27456c(feedProps);
            if (c == null) {
                c = (GraphQLStory) feedProps.f13444a;
            }
            if ((this.f12505d.m9728a(c) != GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? 1 : null) == null) {
                return true;
            }
        }
        return false;
    }

    public final boolean m18590c(FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null || !((GraphQLStory) feedProps.f13444a).m22315A() || StoryProps.m27456c(feedProps) != null) {
            return false;
        }
        Boolean valueOf;
        InlineCommentComposerCache inlineCommentComposerCache = this.f12506e;
        FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
        if (InlineCommentComposerCache.m14460b(feedUnit)) {
            valueOf = Boolean.valueOf(false);
        } else {
            valueOf = (Boolean) inlineCommentComposerCache.f9465a.get(InlineCommentComposerCache.m14461c(feedUnit));
            valueOf = Boolean.valueOf(valueOf == null ? false : valueOf.booleanValue());
        }
        return valueOf.booleanValue();
    }

    public final boolean m18592d(FeedProps<GraphQLStoryAttachment> feedProps) {
        if (feedProps == null) {
            return false;
        }
        FeedProps e = AttachmentProps.m28715e(feedProps);
        if (e == null || this.f12504c.m9602m(e) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean m18580a(C0868x33f7101d c0868x33f7101d) {
        boolean z = true;
        if (c0868x33f7101d != null && c0868x33f7101d.m29454a() != null && c0868x33f7101d.m29454a().m29459a() > 1 && c0868x33f7101d.m29454a().m29463b() != null) {
            if (!c0868x33f7101d.m29458b().contains(GraphQLSubstoriesGroupingReason.COMPACTNESS) || c0868x33f7101d.m29458b().contains(GraphQLSubstoriesGroupingReason.POST_CHANNEL)) {
                z = false;
            }
            if (z) {
                ImmutableList b = c0868x33f7101d.m29454a().m29463b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    NodesModel nodesModel = (NodesModel) b.get(i);
                    if (nodesModel.a() == null || nodesModel.a().size() == 0) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static boolean m18581a(GraphQLStory graphQLStory) {
        return (graphQLStory.aG() == null && graphQLStory.m22337W() == null && !GraphQLStoryUtil.m9579j(graphQLStory)) ? false : true;
    }

    public static boolean m18583b(GraphQLStory graphQLStory) {
        if (StoryHierarchyHelper.m27435b(graphQLStory) == null) {
            return false;
        }
        ImmutableList M = graphQLStory.m22327M();
        if (M == null) {
            return false;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            if (GraphQLStoryAttachmentUtil.m28050a((GraphQLStoryAttachment) M.get(i), GraphQLStoryAttachmentStyle.LIFE_EVENT, GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM)) {
                return false;
            }
        }
        return true;
    }

    public final boolean m18591c(GraphQLStory graphQLStory) {
        if (!this.f12507f.f12509a.m2189a(996, false)) {
            return false;
        }
        GraphQLStoryInsights ag = graphQLStory.ag();
        if ((ag == null || ag.m24401q() <= 0) && StorySponsoredHelper.m29214a(graphQLStory) == GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE && m18584d(graphQLStory) == null) {
            return false;
        }
        return true;
    }

    public static GraphQLTextWithEntities m18584d(GraphQLStory graphQLStory) {
        GraphQLBoostedComponent an = graphQLStory.an();
        if (an == null) {
            return null;
        }
        GraphQLBoostedComponentMessage n = an.m24670n();
        if (n != null) {
            return n.n();
        }
        return null;
    }

    public static boolean m18586e(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.aD() <= 0 || StoryHierarchyHelper.m27434a(graphQLStory).m22608j().isEmpty()) {
            return false;
        }
        if (!graphQLStory.aC().contains(GraphQLSubstoriesGroupingReason.COMPACTNESS)) {
            return false;
        }
        ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            GraphQLStory graphQLStory2 = (GraphQLStory) j.get(i);
            if (graphQLStory2 == null || graphQLStory2.m22327M() == null || graphQLStory2.m22327M().size() == 0 || StoryAttachmentHelper.m28042o(graphQLStory2) == null || !StoryAttachmentHelper.m28042o(graphQLStory2).m23984w().contains(GraphQLStoryAttachmentStyle.EVENT)) {
                return false;
            }
        }
        return true;
    }
}
