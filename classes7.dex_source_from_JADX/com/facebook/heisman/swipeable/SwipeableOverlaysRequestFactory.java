package com.facebook.heisman.swipeable;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.heisman.protocol.PageProfilePictureOverlaysGraphQL.PageProfilePictureOverlaysQueryString;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: places_query_location_page */
public class SwipeableOverlaysRequestFactory {
    private static final CallerContext f6145b = CallerContext.a(SwipeableOverlaysRequestFactory.class, "timeline");
    private static volatile SwipeableOverlaysRequestFactory f6146c;
    @Inject
    public volatile Provider<PageProfilePictureOverlaysQueryBuilder> f6147a = UltralightRuntime.a;

    public static com.facebook.heisman.swipeable.SwipeableOverlaysRequestFactory m8034a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f6146c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.swipeable.SwipeableOverlaysRequestFactory.class;
        monitor-enter(r1);
        r0 = f6146c;	 Catch:{ all -> 0x003a }
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
        r0 = m8035b(r0);	 Catch:{ all -> 0x0035 }
        f6146c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6146c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.swipeable.SwipeableOverlaysRequestFactory.a(com.facebook.inject.InjectorLike):com.facebook.heisman.swipeable.SwipeableOverlaysRequestFactory");
    }

    private static SwipeableOverlaysRequestFactory m8035b(InjectorLike injectorLike) {
        SwipeableOverlaysRequestFactory swipeableOverlaysRequestFactory = new SwipeableOverlaysRequestFactory();
        swipeableOverlaysRequestFactory.f6147a = IdBasedSingletonScopeProvider.a(injectorLike, 7171);
        return swipeableOverlaysRequestFactory;
    }

    public final GraphQLRequest<ImageOverlayWithSwipeableOverlaysModel> m8036a(String str) {
        GraphQLRequest a = GraphQLRequest.a((PageProfilePictureOverlaysQueryString) new PageProfilePictureOverlaysQueryString().a("image_overlay_id", str).a("image_high_width", ((PageProfilePictureOverlaysQueryBuilder) this.f6147a.get()).f6139a.x())).a(RequestPriority.INTERACTIVE);
        a.f = f6145b;
        return a.a(GraphQLCachePolicy.a).a(3600);
    }
}
