package com.facebook.search.suggestions.nullstate;

import com.facebook.inject.InjectorLike;
import com.facebook.qrcode.promo.QRCodePromoConfig;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.suggestions.model.QRCodePromoUnit;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: local/anonymous */
public class QrCodePromoNullStateSupplier extends NullStateSupplier {
    private static volatile QrCodePromoNullStateSupplier f9219b;
    private final boolean f9220a;

    public static com.facebook.search.suggestions.nullstate.QrCodePromoNullStateSupplier m9565a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9219b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.QrCodePromoNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9219b;	 Catch:{ all -> 0x003a }
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
        r0 = m9566b(r0);	 Catch:{ all -> 0x0035 }
        f9219b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9219b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.QrCodePromoNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.QrCodePromoNullStateSupplier");
    }

    private static QrCodePromoNullStateSupplier m9566b(InjectorLike injectorLike) {
        return new QrCodePromoNullStateSupplier(QRCodePromoConfig.m9570b(injectorLike));
    }

    @Inject
    public QrCodePromoNullStateSupplier(QRCodePromoConfig qRCodePromoConfig) {
        this.f9220a = qRCodePromoConfig.m9572a();
    }

    public Object get() {
        return ImmutableList.of(new QRCodePromoUnit());
    }

    public final boolean m9567a() {
        return this.f9220a;
    }

    public final NullStateStatus m9569c() {
        return NullStateStatus.READY;
    }

    public final void m9568b() {
    }
}
