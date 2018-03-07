package com.facebook.search.common.errors;

import android.util.Log;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: interstitials_push_fetch_start */
public class GraphSearchErrorReporter {
    private static final String f19632h = GraphSearchErrorReporter.class.getSimpleName();
    private static volatile GraphSearchErrorReporter f19633i;
    public final DefaultAndroidThreadUtil f19634a;
    private final AbstractFbErrorReporter f19635b;
    public final Toaster f19636c;
    private final SearchBugReportExtraDataProvider f19637d;
    private final Provider<TriState> f19638e;
    private final Provider<Boolean> f19639f;
    public Throwable f19640g;

    public static com.facebook.search.common.errors.GraphSearchErrorReporter m27358a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19633i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.common.errors.GraphSearchErrorReporter.class;
        monitor-enter(r1);
        r0 = f19633i;	 Catch:{ all -> 0x003a }
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
        r0 = m27361b(r0);	 Catch:{ all -> 0x0035 }
        f19633i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19633i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.common.errors.GraphSearchErrorReporter.a(com.facebook.inject.InjectorLike):com.facebook.search.common.errors.GraphSearchErrorReporter");
    }

    private static GraphSearchErrorReporter m27361b(InjectorLike injectorLike) {
        return new GraphSearchErrorReporter(DefaultAndroidThreadUtil.m1646b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), Toaster.m6454b(injectorLike), SearchBugReportExtraDataProvider.m27370a(injectorLike), IdBasedProvider.m1811a(injectorLike, 640), IdBasedProvider.m1811a(injectorLike, 4325));
    }

    @Inject
    public GraphSearchErrorReporter(AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter, Toaster toaster, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider, Provider<TriState> provider, Provider<Boolean> provider2) {
        this.f19634a = androidThreadUtil;
        this.f19635b = fbErrorReporter;
        this.f19636c = toaster;
        this.f19637d = searchBugReportExtraDataProvider;
        this.f19638e = provider;
        this.f19639f = provider2;
    }

    public final void m27364a(GraphSearchError graphSearchError, String str) {
        this.f19640g = new Throwable(str);
        String d = m27363d(graphSearchError, str);
        this.f19635b.m2340a(d, str);
        m27359a(d);
        m27362c(graphSearchError, str);
    }

    public final void m27367a(GraphSearchException graphSearchException) {
        this.f19640g = graphSearchException;
        m27366a(graphSearchException.mError, (Throwable) graphSearchException);
    }

    public final void m27366a(GraphSearchError graphSearchError, Throwable th) {
        this.f19640g = th;
        String d = m27363d(graphSearchError, th.toString());
        this.f19635b.m2346a(d, th);
        m27360a(d, th);
        m27362c(graphSearchError, th.getMessage());
    }

    public final void m27365a(GraphSearchError graphSearchError, String str, Throwable th) {
        this.f19640g = th;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(graphSearchError.name());
        stringBuilder.append(" - ");
        stringBuilder.append(str);
        stringBuilder.append(" - ");
        stringBuilder.append(th.toString());
        String stringBuilder2 = stringBuilder.toString();
        this.f19635b.m2343a(stringBuilder2, str, th);
        m27360a(stringBuilder2, th);
        m27362c(graphSearchError, th.getMessage());
    }

    public final void m27368b(GraphSearchError graphSearchError, String str) {
        this.f19640g = new Throwable(str);
        String d = m27363d(graphSearchError, str);
        this.f19635b.m2350b(d, str);
        m27359a(d);
        m27362c(graphSearchError, str);
    }

    private void m27362c(GraphSearchError graphSearchError, String str) {
        if (TriState.YES.equals(this.f19638e.get()) && ((Boolean) this.f19639f.get()).booleanValue()) {
            ToastBuilder toastBuilder = new ToastBuilder("[FB Only] " + graphSearchError.name() + " => " + str);
            if (this.f19634a.m1659c()) {
                this.f19636c.m6456b(toastBuilder);
            } else {
                this.f19634a.m1652a(new 1(this, toastBuilder));
            }
        }
    }

    private void m27359a(String str) {
        this.f19637d.m27373a(f19632h, SearchBugReportEvent.SOFT_ERROR, str);
    }

    public static String m27363d(GraphSearchError graphSearchError, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(graphSearchError.name());
        stringBuilder.append(" - ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private void m27360a(String str, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(Log.getStackTraceString(th));
        m27359a(stringBuilder.toString());
    }
}
