package com.facebook.intent.feed;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.JSONUtil;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.facebook.graphql.model.GraphQLTopic;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.ipc.feed.ViewPermalinkParams;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.quotes.QuoteExtractor;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: java.lang.ref.SoftReference */
public class DefaultFeedIntentBuilder implements IFeedIntentBuilder {
    private static volatile DefaultFeedIntentBuilder f18687l;
    public final Context f18688a;
    private final ViewPermalinkIntentFactory f18689b;
    private final AbstractFbErrorReporter f18690c;
    private final FbUriIntentHandler f18691d;
    private final UriIntentMapper f18692e;
    private final ComposerConfigurationFactory f18693f;
    private final SearchResultsIntentBuilder f18694g;
    public final Provider<ComponentName> f18695h;
    private final NewsfeedAnalyticsLogger f18696i;
    private final GatekeeperStoreImpl f18697j;
    private final GeneralGroupsReactFragmentIntentBuilder f18698k;

    public static com.facebook.intent.feed.DefaultFeedIntentBuilder m26214a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18687l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.intent.feed.DefaultFeedIntentBuilder.class;
        monitor-enter(r1);
        r0 = f18687l;	 Catch:{ all -> 0x003a }
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
        r0 = m26216b(r0);	 Catch:{ all -> 0x0035 }
        f18687l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18687l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.intent.feed.DefaultFeedIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.intent.feed.DefaultFeedIntentBuilder");
    }

    private static DefaultFeedIntentBuilder m26216b(InjectorLike injectorLike) {
        return new DefaultFeedIntentBuilder((Context) injectorLike.getInstance(Context.class, ForAppContext.class), ViewPermalinkIntentFactory.m7896a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FbUriIntentHandler.m8626a(injectorLike), Fb4aUriIntentMapper.m8640a(injectorLike), ComposerConfigurationFactory.m26271b(injectorLike), SearchResultsIntentBuilder.m26283a(injectorLike), NewsfeedAnalyticsLogger.m26299b(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), GeneralGroupsReactFragmentIntentBuilder.m26314a(injectorLike), IdBasedProvider.m1811a(injectorLike, 12));
    }

    @Inject
    public DefaultFeedIntentBuilder(@ForAppContext Context context, ViewPermalinkIntentFactory viewPermalinkIntentFactory, FbErrorReporter fbErrorReporter, FbUriIntentHandler fbUriIntentHandler, UriIntentMapper uriIntentMapper, ComposerConfigurationFactory composerConfigurationFactory, SearchResultsIntentBuilder searchResultsIntentBuilder, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, GatekeeperStore gatekeeperStore, GeneralGroupsReactFragmentIntentBuilder generalGroupsReactFragmentIntentBuilder, @FragmentChromeActivity Provider<ComponentName> provider) {
        this.f18688a = context;
        this.f18690c = fbErrorReporter;
        this.f18689b = viewPermalinkIntentFactory;
        this.f18691d = fbUriIntentHandler;
        this.f18692e = uriIntentMapper;
        this.f18693f = composerConfigurationFactory;
        this.f18694g = searchResultsIntentBuilder;
        this.f18696i = newsfeedAnalyticsLogger;
        this.f18697j = gatekeeperStore;
        this.f18695h = provider;
        this.f18698k = generalGroupsReactFragmentIntentBuilder;
    }

    public final Intent mo3007a(GraphQLStory graphQLStory) {
        return this.f18689b.m7901a(new ViewPermalinkParams(graphQLStory));
    }

    public final Builder mo3013a(FeedProps<GraphQLStory> feedProps, ComposerSourceType composerSourceType) {
        SharePreview sharePreview = null;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.m19804a();
        GraphQLEntity av = graphQLStory.av();
        GraphQLStory graphQLStory2 = graphQLStory;
        while (graphQLStory2.m22326L() != null) {
            graphQLStory2 = graphQLStory2.m22326L();
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        String str = sharePreview;
        for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory2.m22367x()) {
            if (str == null) {
                str = QuoteExtractor.a(graphQLStoryAttachment);
            }
            builder.m1069c(GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment).a());
        }
        graphQLStory2 = GraphQLStory.Builder.a(graphQLStory2).f(builder.m1068b()).a();
        try {
            sharePreview = SharePreview.a(graphQLStory);
        } catch (Throwable th) {
            this.f18690c.m2343a("Share", "Share Preview error " + m26215a(graphQLStory, av), th);
        }
        FeedProps<GraphQLStory> b = StoryProps.m27455b(feedProps);
        if (b != null) {
            feedProps = b;
        }
        FeedbackLoggingParams.Builder newBuilder = FeedbackLoggingParams.newBuilder();
        newBuilder.m30317a(TrackableFeedProps.m27451a(feedProps));
        this.f18696i.m26301a((FeedUnit) feedProps.m19804a(), newBuilder);
        Builder disablePhotos = ComposerConfigurationFactory.m26260a(composerSourceType, graphQLStory2, ComposerShareParams.Builder.a(av).c(str).a(sharePreview).b(JSONUtil.m13457b(newBuilder.m30319a().m30313e()).toString()).b()).setDisablePhotos(true);
        if (composerSourceType == ComposerSourceType.ON_THIS_DAY_FEED) {
            ComposerConfigurationFactory.m26268a(graphQLStory, disablePhotos);
        }
        return disablePhotos;
    }

    public final Builder mo3014a(String str, ComposerSourceType composerSourceType) {
        GraphQLEntity.Builder builder = new GraphQLEntity.Builder();
        builder.f15802m = str;
        builder = builder;
        builder.f15792S = new GraphQLObjectType(77090322);
        return ComposerConfigurationFactory.m26260a(composerSourceType, null, ComposerShareParams.Builder.a(builder.m22529a()).b());
    }

    public final Builder mo3021b(GraphQLStory graphQLStory) {
        ImmutableList a;
        if (graphQLStory.ai() == null) {
            this.f18690c.m2340a("edit_post_missing_legacy_api_id", "story: " + graphQLStory);
        }
        ComposerConfigurationFactory composerConfigurationFactory = this.f18693f;
        ComposerSourceType composerSourceType = ComposerSourceType.FEED;
        String ai = graphQLStory.ai();
        String c = graphQLStory.m22350c();
        String g = graphQLStory.mo2507g();
        boolean S = graphQLStory.m22333S();
        if (graphQLStory.m22340Z() != null) {
            a = graphQLStory.m22340Z().m24195a();
        } else {
            a = RegularImmutableList.f535a;
        }
        Builder a2 = composerConfigurationFactory.m26279a(composerSourceType, ai, c, g, S, a);
        this.f18693f.m26280a(graphQLStory, a2, true);
        return a2;
    }

    private static String m26215a(GraphQLStory graphQLStory, GraphQLEntity graphQLEntity) {
        return "Story id: " + (graphQLStory != null ? graphQLStory.m22350c() : "") + ", shareable id " + (graphQLEntity != null ? graphQLEntity.mo2906d() : "");
    }

    public final Intent mo3004a() {
        Intent component = new Intent().setComponent(new ComponentName(this.f18688a, "com.facebook.growth.friendfinder.FriendFinderStartActivity"));
        component.putExtra("ci_flow", CIFlow.NEWS_FEED_FIND_FRIENDS);
        return component;
    }

    public final Intent mo3005a(long j, String str, FullscreenGallerySource fullscreenGallerySource) {
        Intent component = new Intent().setComponent(new ComponentName(this.f18688a, "com.facebook.photos.mediagallery.ui.MediaGalleryActivity"));
        component.putExtra("photo_fbid", j);
        component.putExtra("photoset_token", str);
        component.putExtra("fullscreen_gallery_source", fullscreenGallerySource.name());
        return component;
    }

    public final Intent m26236c(String str) {
        GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
        builder.aI = str;
        GraphQLVideo a = builder.m26992a();
        Intent component = new Intent().setComponent(new ComponentName(this.f18688a, "com.facebook.video.activity.FullScreenVideoPlayerActivity"));
        FlatBufferModelHelper.a(component, "video_graphql_object", a);
        return component;
    }

    public final boolean mo3016a(Context context, String str) {
        return this.f18691d.m8632a(context, str);
    }

    public final boolean mo3015a(Context context, NativeUri nativeUri) {
        return this.f18691d.m8631a(context, nativeUri);
    }

    public final boolean mo3017a(Context context, String str, Bundle bundle, @Nullable Map<String, Object> map) {
        return this.f18691d.m8634a(context, str, bundle, (Map) map);
    }

    public final Intent mo3019b(Context context, String str) {
        return this.f18692e.mo1267a(context, str);
    }

    public final Intent mo3011a(String str) {
        return m26213a(str, ProfileListParamType.LIKERS_FOR_FEEDBACK_ID);
    }

    public final Intent mo3020b(String str) {
        Intent c = m26217c();
        c.putExtra("target_fragment", FragmentConstants$ContentFragmentType.PROFILE_LIST_FRAGMENT.ordinal());
        c.putExtra("graphql_poll_option_id", str);
        c.putExtra("profile_list_type", ProfileListParamType.VOTERS_FOR_POLL_OPTION_ID.ordinal());
        return c;
    }

    public final Intent mo3006a(GraphQLFeedback graphQLFeedback, String str) {
        Intent c = m26217c();
        c.putExtra("target_fragment", FragmentConstants$ContentFragmentType.REACTORS_LIST_FRAGMENT.ordinal());
        c.putExtra("graphql_feedback_id", graphQLFeedback.z_());
        c.putExtra("module_name", str);
        HashMap hashMap = new HashMap();
        GraphQLTopReactionsConnection a = GraphQLFeedbackHelper.m30217a(graphQLFeedback);
        if (!(a == null || a.m24899a() == null)) {
            ImmutableList a2 = a.m24899a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) a2.get(i);
                hashMap.put(Integer.valueOf(graphQLTopReactionsEdge.m27550a().m27561m()), Integer.valueOf(graphQLTopReactionsEdge.m27553j()));
            }
        }
        HashMap hashMap2 = hashMap;
        Preconditions.checkNotNull(hashMap2);
        c.putExtra("reaction_type_count_map", hashMap2);
        c.putExtra("reaction_can_viewer_ban_user", true);
        return c;
    }

    public final Intent mo3008a(GraphQLStory graphQLStory, FeedListName feedListName) {
        String z_ = graphQLStory.mo2890l().z_();
        Intent intent = null;
        if (feedListName == FeedListName.GROUPS) {
            intent = this.f18698k.m26317a(StringFormatUtil.formatStrLocaleSafe("/groups_seen_by?feedback=%s&story=%s", z_, graphQLStory.m22350c()), "FBGroupStorySeenByRoute", true);
        }
        if (intent == null) {
            return m26213a(z_, ProfileListParamType.SEEN_BY_FOR_FEEDBACK_ID);
        }
        return intent;
    }

    private Intent m26213a(String str, ProfileListParamType profileListParamType) {
        Intent c = m26217c();
        c.putExtra("target_fragment", FragmentConstants$ContentFragmentType.PROFILE_LIST_FRAGMENT.ordinal());
        c.putExtra("graphql_feedback_id", str);
        c.putExtra("profile_list_type", profileListParamType.ordinal());
        return c;
    }

    public final Intent mo3009a(GraphQLStory graphQLStory, String str) {
        if (this.f18697j.m2189a(771, false)) {
            Preconditions.checkNotNull(graphQLStory);
            Preconditions.checkState(!Strings.isNullOrEmpty(graphQLStory.m22350c()));
            Intent component = new Intent().setComponent((ComponentName) this.f18695h.get());
            component.putExtra("target_fragment", FragmentConstants$ContentFragmentType.FACEWEB_FRAGMENT.ordinal());
            component.putExtra("mobile_page", "/edits/?stoken=" + graphQLStory.m22350c());
            return component;
        }
        Intent c = m26217c();
        c.putExtra("target_fragment", FragmentConstants$ContentFragmentType.EDIT_HISTORY_FRAGMENT.ordinal());
        c.putExtra("module_name", str);
        c.putExtra("story_id", graphQLStory.m22350c());
        return c;
    }

    private Intent m26217c() {
        return new Intent().setComponent((ComponentName) this.f18695h.get());
    }

    public final Intent mo3018b() {
        Intent c = m26217c();
        c.putExtra("target_fragment", FragmentConstants$ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal());
        return c;
    }

    public final Intent mo3010a(GraphQLTopic graphQLTopic) {
        return this.f18694g.m26288a(SearchTypeaheadSession.a, graphQLTopic.m23565k(), graphQLTopic.m23566l(), SearchResultsSource.n);
    }

    public final Intent mo3012a(String str, @Nullable GraphQLComment graphQLComment, String str2, String str3, boolean z, FeedbackLoggingParams feedbackLoggingParams) {
        Intent c = m26217c();
        c.putExtra("target_fragment", FragmentConstants$ContentFragmentType.COMMENT_PERMALINK_FRAGMENT.ordinal());
        c.putExtra("comment_id", str);
        FlatBufferModelHelper.a(c, "comment", graphQLComment);
        c.putExtra("relevant_comment_id", str2);
        c.putExtra("feedback_id", str3);
        c.putExtra("include_comments_disabled_fields", z);
        c.putExtra("feedback_logging_params", feedbackLoggingParams);
        return c;
    }
}
