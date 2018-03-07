package com.facebook.timeline.aboutpage.protocol;

import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: MarketplaceNotificationsUpdate */
public class CollectionsGraphQLImageHelper {
    private static volatile CollectionsGraphQLImageHelper f13235e;
    private final Display f13236a;
    private final Resources f13237b;
    private final StandardCollectionSizes f13238c;
    private final GraphQLImageHelper f13239d;

    public static com.facebook.timeline.aboutpage.protocol.CollectionsGraphQLImageHelper m14198a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13235e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.protocol.CollectionsGraphQLImageHelper.class;
        monitor-enter(r1);
        r0 = f13235e;	 Catch:{ all -> 0x003a }
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
        r0 = m14199b(r0);	 Catch:{ all -> 0x0035 }
        f13235e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13235e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.protocol.CollectionsGraphQLImageHelper.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.protocol.CollectionsGraphQLImageHelper");
    }

    private static CollectionsGraphQLImageHelper m14199b(InjectorLike injectorLike) {
        return new CollectionsGraphQLImageHelper(WindowManagerMethodAutoProvider.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), StandardCollectionSizes.m13827a(injectorLike), GraphQLImageHelper.a(injectorLike));
    }

    @Inject
    public CollectionsGraphQLImageHelper(WindowManager windowManager, Resources resources, StandardCollectionSizes standardCollectionSizes, GraphQLImageHelper graphQLImageHelper) {
        this.f13236a = windowManager.getDefaultDisplay();
        this.f13237b = resources;
        this.f13238c = standardCollectionSizes;
        this.f13239d = graphQLImageHelper;
    }

    public final int m14200a() {
        return GraphQLImageHelper.a(this.f13236a.getWidth() / this.f13238c.f13056a).intValue();
    }

    public final int m14201b() {
        return GraphQLImageHelper.a(this.f13237b.getDimensionPixelSize(2131429886)).intValue();
    }

    public final int m14202c() {
        return this.f13237b.getDimensionPixelSize(2131429887);
    }
}
