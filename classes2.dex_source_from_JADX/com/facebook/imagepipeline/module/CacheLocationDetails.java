package com.facebook.imagepipeline.module;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.inject.InjectorLike;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: os_type */
public class CacheLocationDetails {
    private static volatile CacheLocationDetails f10681c;
    private final Map<CacheLocation, Supplier<File>> f10682a = new HashMap();
    private final Map<CacheLocation, String> f10683b = new HashMap();

    public static com.facebook.imagepipeline.module.CacheLocationDetails m15961a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10681c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.module.CacheLocationDetails.class;
        monitor-enter(r1);
        r0 = f10681c;	 Catch:{ all -> 0x003a }
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
        r0 = m15962b(r0);	 Catch:{ all -> 0x0035 }
        f10681c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10681c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.module.CacheLocationDetails.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.module.CacheLocationDetails");
    }

    private static CacheLocationDetails m15962b(InjectorLike injectorLike) {
        return new CacheLocationDetails((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public CacheLocationDetails(final Context context) {
        this.f10683b.put(CacheLocation.CACHE, "image");
        this.f10682a.put(CacheLocation.CACHE, new Supplier<File>(this) {
            final /* synthetic */ CacheLocationDetails f10685b;

            public final Object mo2058a() {
                return context.getCacheDir();
            }
        });
        this.f10683b.put(CacheLocation.FILES, "image_main");
        this.f10682a.put(CacheLocation.FILES, new Supplier<File>(this) {
            final /* synthetic */ CacheLocationDetails f10687b;

            public final Object mo2058a() {
                return context.getFilesDir();
            }
        });
    }

    public final Supplier<File> m15963a(CacheLocation cacheLocation) {
        return (Supplier) this.f10682a.get(cacheLocation);
    }

    public final String m15964b(CacheLocation cacheLocation) {
        return (String) this.f10683b.get(cacheLocation);
    }
}
