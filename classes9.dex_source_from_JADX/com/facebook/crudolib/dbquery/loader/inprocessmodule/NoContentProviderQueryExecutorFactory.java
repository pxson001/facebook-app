package com.facebook.crudolib.dbquery.loader.inprocessmodule;

import android.content.Context;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TransactionInvoiceQuery */
public class NoContentProviderQueryExecutorFactory {
    private static volatile NoContentProviderQueryExecutorFactory f24004c;
    public final Context f24005a;
    public final ExecutorService f24006b;

    public static com.facebook.crudolib.dbquery.loader.inprocessmodule.NoContentProviderQueryExecutorFactory m25950a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24004c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crudolib.dbquery.loader.inprocessmodule.NoContentProviderQueryExecutorFactory.class;
        monitor-enter(r1);
        r0 = f24004c;	 Catch:{ all -> 0x003a }
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
        r0 = m25951b(r0);	 Catch:{ all -> 0x0035 }
        f24004c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24004c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crudolib.dbquery.loader.inprocessmodule.NoContentProviderQueryExecutorFactory.a(com.facebook.inject.InjectorLike):com.facebook.crudolib.dbquery.loader.inprocessmodule.NoContentProviderQueryExecutorFactory");
    }

    private static NoContentProviderQueryExecutorFactory m25951b(InjectorLike injectorLike) {
        return new NoContentProviderQueryExecutorFactory((Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NoContentProviderQueryExecutorFactory(Context context, ExecutorService executorService) {
        this.f24005a = context;
        this.f24006b = executorService;
    }
}
