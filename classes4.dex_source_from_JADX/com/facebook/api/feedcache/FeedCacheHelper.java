package com.facebook.api.feedcache;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInit;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_get_media_fbid_finished */
public class FeedCacheHelper implements INeedInit {
    private static volatile FeedCacheHelper f7985c;
    private final LocaleChangeController f7986a;
    public final DefaultBlueServiceOperationFactory f7987b;

    /* compiled from: messenger_get_media_fbid_finished */
    class C03911 implements LocaleChangeListener {
        final /* synthetic */ FeedCacheHelper f8000a;

        C03911(FeedCacheHelper feedCacheHelper) {
            this.f8000a = feedCacheHelper;
        }

        public final ListenableFuture m8320a(Locale locale) {
            return BlueServiceOperationFactoryDetour.a(this.f8000a.f7987b, "feed_clear_cache", new Bundle(), ErrorPropagation.BY_ERROR_CODE, CallerContext.a(this.f8000a.getClass()), 567926017).a();
        }
    }

    public static com.facebook.api.feedcache.FeedCacheHelper m8312a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7985c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.FeedCacheHelper.class;
        monitor-enter(r1);
        r0 = f7985c;	 Catch:{ all -> 0x003a }
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
        r0 = m8313b(r0);	 Catch:{ all -> 0x0035 }
        f7985c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7985c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.FeedCacheHelper.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.FeedCacheHelper");
    }

    private static FeedCacheHelper m8313b(InjectorLike injectorLike) {
        return new FeedCacheHelper(DefaultBlueServiceOperationFactory.b(injectorLike), LocaleChangeController.a(injectorLike));
    }

    @Inject
    public FeedCacheHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, LocaleChangeController localeChangeController) {
        this.f7987b = defaultBlueServiceOperationFactory;
        this.f7986a = localeChangeController;
    }

    public void init() {
        this.f7986a.a(new C03911(this));
    }
}
