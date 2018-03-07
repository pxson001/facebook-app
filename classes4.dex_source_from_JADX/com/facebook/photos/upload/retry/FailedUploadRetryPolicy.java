package com.facebook.photos.upload.retry;

import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.abtest.AutoRetryPolicyController;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.manager.UploadManager.RequestType;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationCounters;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: node uri is missing */
public class FailedUploadRetryPolicy {
    private static volatile FailedUploadRetryPolicy f7055e;
    private final Clock f7056a;
    private final Provider<TriState> f7057b;
    private final BatteryPolicy f7058c;
    public final AutoRetryPolicyController f7059d;

    public static com.facebook.photos.upload.retry.FailedUploadRetryPolicy m7343a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7055e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.retry.FailedUploadRetryPolicy.class;
        monitor-enter(r1);
        r0 = f7055e;	 Catch:{ all -> 0x003a }
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
        r0 = m7344b(r0);	 Catch:{ all -> 0x0035 }
        f7055e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7055e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.retry.FailedUploadRetryPolicy.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.retry.FailedUploadRetryPolicy");
    }

    private static FailedUploadRetryPolicy m7344b(InjectorLike injectorLike) {
        return new FailedUploadRetryPolicy((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 729), new BatteryPolicy(AutoRetryPolicyController.m7358b(injectorLike), SystemBatteryStateManager.a(injectorLike)), AutoRetryPolicyController.m7358b(injectorLike));
    }

    @Inject
    public FailedUploadRetryPolicy(Clock clock, Provider<TriState> provider, BatteryPolicy batteryPolicy, AutoRetryPolicyController autoRetryPolicyController) {
        this.f7056a = clock;
        this.f7057b = provider;
        this.f7058c = batteryPolicy;
        this.f7059d = autoRetryPolicyController;
    }

    public final void m7345a(UploadManager uploadManager) {
        this.f7058c.m7352a();
        uploadManager.m7321a(this.f7056a.a() + this.f7058c.m7354c());
    }

    public final void m7346a(RetryScheduler retryScheduler, LinkedList<UploadOperation> linkedList, String str) {
        this.f7058c.m7352a();
        long a = this.f7056a.a();
        UploadOperation a2;
        if (m7347a()) {
            a2 = m7342a(linkedList, a);
            if (a2 != null) {
                long c;
                if (!this.f7058c.m7353b()) {
                    c = this.f7058c.m7354c() + a;
                } else if (retryScheduler.m7341i()) {
                    retryScheduler.m7323a(a2, RequestType.AutoRetry, str);
                    return;
                } else {
                    long c2 = this.f7058c.m7354c();
                    c = a2.n() + c2;
                    if (c <= a) {
                        c = a + c2;
                    }
                }
                retryScheduler.m7321a(c);
            }
        } else if (this.f7058c.m7353b() && retryScheduler.m7341i()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                a2 = (UploadOperation) it.next();
                if (a2.i() && m7349b(a2, a)) {
                    retryScheduler.m7323a(a2, RequestType.AutoRetry, str);
                    return;
                }
            }
        }
    }

    public final void m7348b(RetryScheduler retryScheduler, LinkedList<UploadOperation> linkedList, String str) {
        if (m7347a()) {
            long a = this.f7056a.a();
            UploadOperation a2 = m7342a(linkedList, a);
            if (a2 != null) {
                this.f7058c.m7352a();
                long c = this.f7058c.m7354c();
                if (this.f7058c.m7353b()) {
                    long n = a2.n() + c;
                    if (n > a || !retryScheduler.m7341i()) {
                        if (n <= a) {
                            n = a + c;
                        }
                        retryScheduler.m7321a(n);
                        return;
                    }
                    retryScheduler.m7323a(a2, RequestType.AutoRetry, str);
                    return;
                }
                retryScheduler.m7321a(a + c);
            }
        }
    }

    @Nullable
    private UploadOperation m7342a(LinkedList<UploadOperation> linkedList, long j) {
        UploadOperation uploadOperation = null;
        long j2 = Long.MAX_VALUE;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            UploadOperation uploadOperation2;
            long j3;
            UploadOperation uploadOperation3 = (UploadOperation) it.next();
            if (m7349b(uploadOperation3, j)) {
                long f = uploadOperation3.D.f();
                if (f < j2) {
                    long j4 = f;
                    uploadOperation2 = uploadOperation3;
                    j3 = j4;
                    j2 = j3;
                    uploadOperation = uploadOperation2;
                }
            }
            uploadOperation2 = uploadOperation;
            j3 = j2;
            j2 = j3;
            uploadOperation = uploadOperation2;
        }
        return uploadOperation;
    }

    public final boolean m7347a() {
        return ((TriState) this.f7057b.get()).asBoolean(true);
    }

    public final boolean m7349b(UploadOperation uploadOperation, long j) {
        UploadOperationCounters uploadOperationCounters = uploadOperation.D;
        return uploadOperation.h() && uploadOperationCounters.j && uploadOperationCounters.g < this.f7059d.m7359a() && uploadOperationCounters.i < this.f7059d.m7361c() && uploadOperation.D.b + this.f7059d.m7360b() > j;
    }
}
