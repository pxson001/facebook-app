package com.facebook.composer.publish.optimistic;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.composer.publish.common.ErrorDetails;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_size */
public class ComposerActivityBroadcaster {
    private static volatile ComposerActivityBroadcaster f8059b;
    private final BaseFbBroadcastManager f8060a;

    /* compiled from: photo_size */
    public enum Result {
        SUCCESS,
        EXCEPTION,
        CANCELLED
    }

    public static com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster m11633a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8059b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.class;
        monitor-enter(r1);
        r0 = f8059b;	 Catch:{ all -> 0x003a }
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
        r0 = m11634b(r0);	 Catch:{ all -> 0x0035 }
        f8059b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8059b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster");
    }

    private static ComposerActivityBroadcaster m11634b(InjectorLike injectorLike) {
        return new ComposerActivityBroadcaster((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    @Inject
    public ComposerActivityBroadcaster(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f8060a = baseFbBroadcastManager;
    }

    public final void m11635a(PostParamsWrapper postParamsWrapper, GraphQLStory graphQLStory) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.STREAM_PUBLISH_START");
        intent.putExtra("extra_feed_story", graphQLStory);
        intent.putExtra("extra_request_id", postParamsWrapper.a());
        intent.putExtra("extra_target_id", postParamsWrapper.d());
        String str = "extra_has_explicit_place";
        boolean z = postParamsWrapper.k() != null && postParamsWrapper.k().isExplicitLocation;
        intent.putExtra(str, z);
        this.f8060a.a(intent);
    }

    public final void m11638a(String str, long j, int i) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.STREAM_PUBLISH_PROGRESS");
        intent.putExtra("extra_request_id", str);
        intent.putExtra("extra_target_id", j);
        intent.putExtra("extra_percent_progress", i);
        this.f8060a.a(intent);
    }

    public final void m11637a(String str, long j) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.STREAM_PUBLISH_RESTART");
        intent.putExtra("extra_request_id", str);
        intent.putExtra("extra_target_id", j);
        this.f8060a.a(intent);
    }

    public final void m11636a(Result result, String str, GraphQLStory graphQLStory, String str2, long j, ErrorDetails errorDetails) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.STREAM_PUBLISH_COMPLETE");
        intent.putExtra("extra_result", result.toString());
        intent.putExtra("extra_legacy_api_post_id", str);
        intent.putExtra("graphql_story", graphQLStory);
        intent.putExtra("extra_request_id", str2);
        intent.putExtra("extra_target_id", j);
        intent.putExtra("extra_error_details", errorDetails);
        this.f8060a.a(intent);
    }

    public final void m11639b(Result result, String str, GraphQLStory graphQLStory, String str2, long j, ErrorDetails errorDetails) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.STREAM_PUBLISH_MEDIA_PROCESSING_COMPLETE");
        intent.putExtra("extra_result", result.toString());
        intent.putExtra("extra_legacy_api_post_id", str);
        intent.putExtra("graphql_story", graphQLStory);
        intent.putExtra("extra_request_id", str2);
        intent.putExtra("extra_target_id", j);
        intent.putExtra("extra_error_details", errorDetails);
        this.f8060a.a(intent);
    }
}
