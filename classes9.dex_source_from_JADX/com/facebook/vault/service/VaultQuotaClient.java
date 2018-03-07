package com.facebook.vault.service;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fql.FqlHelper.Field;
import com.facebook.fql.FqlHelper.Query;
import com.facebook.fql.FqlQueryRunner;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: themeId */
public class VaultQuotaClient {
    public static final Field f1917a = new Field("vault_quota");
    public static final Field f1918b = new Field("uid");
    private static volatile VaultQuotaClient f1919e;
    public final FqlQueryRunner f1920c;
    public final ListeningExecutorService f1921d;

    /* compiled from: themeId */
    public class C01811 implements Callable<Quota> {
        final /* synthetic */ Query f1913a;
        final /* synthetic */ VaultQuotaClient f1914b;

        /* compiled from: themeId */
        class C01801 implements Function<JsonNode, Quota> {
            final /* synthetic */ C01811 f1912a;

            C01801(C01811 c01811) {
                this.f1912a = c01811;
            }

            public Object apply(Object obj) {
                JsonNode b = ((JsonNode) obj).a(0).b("vault_quota");
                return new Quota(b.b("total").D(), b.b("used").D());
            }
        }

        public C01811(VaultQuotaClient vaultQuotaClient, Query query) {
            this.f1914b = vaultQuotaClient;
            this.f1913a = query;
        }

        public Object call() {
            return (Quota) this.f1914b.f1920c.a(this.f1913a, new C01801(this), CallerContext.a(getClass()));
        }
    }

    @Immutable
    /* compiled from: themeId */
    public class Quota {
        public final long f1915a;
        public final long f1916b;

        public Quota(long j, long j2) {
            this.f1915a = j;
            this.f1916b = j2;
        }
    }

    public static com.facebook.vault.service.VaultQuotaClient m1977a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1919e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.service.VaultQuotaClient.class;
        monitor-enter(r1);
        r0 = f1919e;	 Catch:{ all -> 0x003a }
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
        r0 = m1978b(r0);	 Catch:{ all -> 0x0035 }
        f1919e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1919e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.service.VaultQuotaClient.a(com.facebook.inject.InjectorLike):com.facebook.vault.service.VaultQuotaClient");
    }

    private static VaultQuotaClient m1978b(InjectorLike injectorLike) {
        return new VaultQuotaClient(FqlQueryRunner.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VaultQuotaClient(FqlQueryRunner fqlQueryRunner, ListeningExecutorService listeningExecutorService) {
        this.f1920c = fqlQueryRunner;
        this.f1921d = listeningExecutorService;
    }
}
