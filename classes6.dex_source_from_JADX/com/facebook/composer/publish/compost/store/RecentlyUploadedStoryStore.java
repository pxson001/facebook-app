package com.facebook.composer.publish.compost.store;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.composer.publish.compost.story.RecentlyUploadedStory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_uri */
public class RecentlyUploadedStoryStore extends CompostStoryStore<RecentlyUploadedStory> {
    private static volatile RecentlyUploadedStoryStore f8051d;

    public static com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore m11608a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8051d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore.class;
        monitor-enter(r1);
        r0 = f8051d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11609b(r0);	 Catch:{ all -> 0x0035 }
        f8051d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8051d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore");
    }

    private static RecentlyUploadedStoryStore m11609b(InjectorLike injectorLike) {
        return new RecentlyUploadedStoryStore((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RecentlyUploadedStoryStore(Clock clock) {
        super(clock);
    }

    public final void m11610a(GraphQLStory graphQLStory) {
        m11611a(null, graphQLStory, StoryType.POST);
    }

    public final void m11611a(@Nullable GraphQLStory graphQLStory, @Nullable GraphQLStory graphQLStory2, StoryType storyType) {
        Builder a;
        if (graphQLStory2 == null) {
            Preconditions.checkArgument(graphQLStory != null, "passed in null objects for both pending and uploaded story objects");
            a = Builder.a(graphQLStory);
        } else {
            a = Builder.a(graphQLStory2);
            if (graphQLStory != null) {
                a.m = graphQLStory.M();
            }
        }
        a.x = this.f8039a.a() / 1000;
        RecentlyUploadedStory.Builder builder = new RecentlyUploadedStory.Builder(a.a());
        builder.f8056b = storyType;
        mo927a((CompostStory) new RecentlyUploadedStory(builder));
    }

    public final long mo929b() {
        return 1209600;
    }
}
