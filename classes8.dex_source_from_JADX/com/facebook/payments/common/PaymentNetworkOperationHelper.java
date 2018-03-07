package com.facebook.payments.common;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: target_user_rank */
public class PaymentNetworkOperationHelper {
    public static final Function<Object, Void> f1746a = Functions.constant(null);
    public static final Function<OperationResult, Parcelable> f1747b = new C01791();
    private static volatile PaymentNetworkOperationHelper f1748e;
    public final DefaultBlueServiceOperationFactory f1749c;
    public final ExecutorService f1750d;

    /* compiled from: target_user_rank */
    final class C01791 implements Function<OperationResult, Parcelable> {
        C01791() {
        }

        public final Object apply(Object obj) {
            return (Parcelable) ((OperationResult) obj).h();
        }
    }

    /* compiled from: target_user_rank */
    public class C01802 implements Function<OperationResult, T> {
        final /* synthetic */ Class f1744a;
        final /* synthetic */ PaymentNetworkOperationHelper f1745b;

        public C01802(PaymentNetworkOperationHelper paymentNetworkOperationHelper, Class cls) {
            this.f1745b = paymentNetworkOperationHelper;
            this.f1744a = cls;
        }

        public Object apply(Object obj) {
            return ((OperationResult) obj).a(this.f1744a);
        }
    }

    public static com.facebook.payments.common.PaymentNetworkOperationHelper m1921a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1748e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.payments.common.PaymentNetworkOperationHelper.class;
        monitor-enter(r1);
        r0 = f1748e;	 Catch:{ all -> 0x003a }
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
        r0 = m1922b(r0);	 Catch:{ all -> 0x0035 }
        f1748e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1748e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.payments.common.PaymentNetworkOperationHelper.a(com.facebook.inject.InjectorLike):com.facebook.payments.common.PaymentNetworkOperationHelper");
    }

    private static PaymentNetworkOperationHelper m1922b(InjectorLike injectorLike) {
        return new PaymentNetworkOperationHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PaymentNetworkOperationHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        this.f1749c = defaultBlueServiceOperationFactory;
        this.f1750d = executorService;
    }

    public final ListenableFuture<OperationResult> m1923a(String str, Parcelable parcelable, String str2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(str, parcelable);
        Bundle bundle2 = bundle;
        return BlueServiceOperationFactoryDetour.a(this.f1749c, str2, bundle2, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), 711302723).a();
    }
}
