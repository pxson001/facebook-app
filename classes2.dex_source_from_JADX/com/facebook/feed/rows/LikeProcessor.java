package com.facebook.feed.rows;

import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.content.event.FbEventBus;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.events.LikeClicked;
import com.facebook.feed.util.MegaSoundEventsSubscriber;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_invite_priority */
public class LikeProcessor {
    private static volatile LikeProcessor f13888h;
    private final EventsStream f13889a;
    public final FeedEventBus f13890b;
    public final FeedStoryMutator f13891c;
    public final Lazy<FeedUnitCacheMutator> f13892d;
    public final Provider<GraphQLActorCache> f13893e;
    public final MegaSoundEventsSubscriber f13894f;
    private Subscription<LikeClicked, String> f13895g;

    /* compiled from: messenger_invite_priority */
    class C05721 implements Action<LikeClicked> {
        final /* synthetic */ LikeProcessor f13910a;

        C05721(LikeProcessor likeProcessor) {
            this.f13910a = likeProcessor;
        }

        public final void mo1977a(Object obj) {
            GraphQLStory graphQLStory;
            Object obj2;
            LikeClicked likeClicked = (LikeClicked) obj;
            LikeProcessor likeProcessor = this.f13910a;
            FeedProps feedProps = likeClicked.f13907a;
            String str = likeClicked.f13909c;
            String str2 = null;
            boolean z = true;
            if (feedProps != null) {
                graphQLStory = (GraphQLStory) feedProps.f13444a;
            } else {
                graphQLStory = null;
            }
            if (str == StoryRenderContext.NEWSFEED.analyticModule) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                if (str == StoryRenderContext.REDSPACE.analyticModule) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 == null) {
                    FeedProps a = likeProcessor.f13891c.m10594a(feedProps, ((GraphQLActorCacheImpl) likeProcessor.f13893e.get()).m14534a());
                    GraphQLStory graphQLStory2 = (GraphQLStory) a.f13444a;
                    FeedUnitCommon f = StoryProps.m27459f(a);
                    GraphQLFeedback l = graphQLStory2.mo2890l();
                    FbEventBus fbEventBus = likeProcessor.f13890b;
                    String g = graphQLStory.mo2507g();
                    String j = l.mo2933j();
                    if (f != null) {
                        str2 = f.mo2507g();
                    }
                    fbEventBus.mo651a(new LikeClickedEvent(g, j, str2, l.y_(), true, str));
                    return;
                }
            }
            if (graphQLStory == null || !graphQLStory.m22369z() || graphQLStory.m22316B()) {
                z = false;
            }
            ((FeedUnitCacheMutator) likeProcessor.f13892d.get()).a(feedProps);
            if (z) {
                MegaSoundEventsSubscriber.m20261b(likeProcessor.f13894f, "like_main");
            }
        }
    }

    public static com.facebook.feed.rows.LikeProcessor m20255a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13888h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.rows.LikeProcessor.class;
        monitor-enter(r1);
        r0 = f13888h;	 Catch:{ all -> 0x003a }
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
        r0 = m20256b(r0);	 Catch:{ all -> 0x0035 }
        f13888h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13888h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.LikeProcessor.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.LikeProcessor");
    }

    private static LikeProcessor m20256b(InjectorLike injectorLike) {
        return new LikeProcessor(EventsStream.m15220a(injectorLike), FeedEventBus.m4573a(injectorLike), FeedStoryMutator.m10586b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4804), IdBasedSingletonScopeProvider.m1809a(injectorLike, 262), MegaSoundEventsSubscriber.m20258a(injectorLike));
    }

    @Inject
    public LikeProcessor(EventsStream eventsStream, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, Lazy<FeedUnitCacheMutator> lazy, Provider<GraphQLActorCache> provider, MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f13889a = eventsStream;
        this.f13890b = feedEventBus;
        this.f13891c = feedStoryMutator;
        this.f13892d = lazy;
        this.f13893e = provider;
        this.f13894f = megaSoundEventsSubscriber;
    }

    public final void m20257a() {
        if (this.f13895g == null) {
            this.f13895g = this.f13889a.m15229a(LikeClicked.class, new C05721(this));
        }
    }
}
