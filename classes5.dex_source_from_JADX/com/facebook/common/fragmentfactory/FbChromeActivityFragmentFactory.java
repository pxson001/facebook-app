package com.facebook.common.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: albums */
public class FbChromeActivityFragmentFactory {
    private static volatile FbChromeActivityFragmentFactory f11089b;
    FragmentFactoryMap f11090a;

    public static com.facebook.common.fragmentfactory.FbChromeActivityFragmentFactory m19080a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11089b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.fragmentfactory.FbChromeActivityFragmentFactory.class;
        monitor-enter(r1);
        r0 = f11089b;	 Catch:{ all -> 0x003a }
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
        r0 = m19081b(r0);	 Catch:{ all -> 0x0035 }
        f11089b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11089b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.fragmentfactory.FbChromeActivityFragmentFactory.a(com.facebook.inject.InjectorLike):com.facebook.common.fragmentfactory.FbChromeActivityFragmentFactory");
    }

    private static FbChromeActivityFragmentFactory m19081b(InjectorLike injectorLike) {
        return new FbChromeActivityFragmentFactory((FragmentFactoryMap) FragmentFactoryMapImpl.a(injectorLike));
    }

    @Inject
    public FbChromeActivityFragmentFactory(FragmentFactoryMap fragmentFactoryMap) {
        this.f11090a = fragmentFactoryMap;
    }

    public final Fragment m19085a(Intent intent) {
        Fragment a = m19084d(intent).a(intent);
        Preconditions.checkNotNull(a, "Factory could not generate fragment for intent: %s", new Object[]{intent.toString()});
        return a;
    }

    @Nullable
    private IFragmentFactory m19082b(Intent intent) {
        int c = m19083c(intent);
        intent.putExtra("target_fragment", c);
        try {
            return this.f11090a.a(c);
        } catch (NullPointerException e) {
            return null;
        }
    }

    private static int m19083c(Intent intent) {
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intExtra >= 0) {
            return intExtra;
        }
        if (intent.getExtras() == null) {
            return ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal();
        }
        return ContentFragmentType.FACEWEB_FRAGMENT.ordinal();
    }

    private final IFragmentFactory m19084d(Intent intent) {
        return (IFragmentFactory) Preconditions.checkNotNull(m19082b(intent), "Undefined content fragment factory identifier %s", new Object[]{Integer.valueOf(m19083c(intent))});
    }
}
