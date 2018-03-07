package com.facebook.abtest.qe.db;

import android.content.Context;
import android.net.Uri;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: update_contacts_coefficient */
public class QuickExperimentContract {
    private static volatile QuickExperimentContract f1810e;
    public final String f1811a;
    public final Uri f1812b = Uri.parse("content://" + this.f1811a);
    public final ExperimentsTable f1813c = new ExperimentsTable(this.f1812b);
    public final ExperimentsMetaInfoTable f1814d = new ExperimentsMetaInfoTable(this.f1812b);

    /* compiled from: update_contacts_coefficient */
    public class ExperimentsTable {
        public final Uri f1815a;

        public ExperimentsTable(Uri uri) {
            this.f1815a = Uri.withAppendedPath(uri, "quick_experiment");
        }
    }

    /* compiled from: update_contacts_coefficient */
    public class ExperimentsMetaInfoTable {
        public final Uri f1816a;

        public ExperimentsMetaInfoTable(Uri uri) {
            this.f1816a = Uri.withAppendedPath(uri, "metainfo");
        }
    }

    public static com.facebook.abtest.qe.db.QuickExperimentContract m3642a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1810e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.db.QuickExperimentContract.class;
        monitor-enter(r1);
        r0 = f1810e;	 Catch:{ all -> 0x003a }
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
        r0 = m3643b(r0);	 Catch:{ all -> 0x0035 }
        f1810e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1810e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.db.QuickExperimentContract.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.db.QuickExperimentContract");
    }

    private static QuickExperimentContract m3643b(InjectorLike injectorLike) {
        return new QuickExperimentContract((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public QuickExperimentContract(Context context) {
        this.f1811a = context.getPackageName() + ".experiments";
    }
}
