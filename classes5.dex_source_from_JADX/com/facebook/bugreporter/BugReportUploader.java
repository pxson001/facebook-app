package com.facebook.bugreporter;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.net.conn.CONNECTIVITY_CHANGE */
public class BugReportUploader {
    private static final String f10518a = BugReportUploader.class.getSimpleName();
    private static volatile BugReportUploader f10519i;
    private final Context f10520b;
    private final AbstractSingleMethodRunner f10521c;
    private final BugReportUploadMethodDeprecated f10522d;
    private final BugReportUploadMethod f10523e;
    private final AbstractFbErrorReporter f10524f;
    private final GatekeeperStoreImpl f10525g;
    private final ViewerContextManager f10526h;

    public static com.facebook.bugreporter.BugReportUploader m18590a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10519i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.BugReportUploader.class;
        monitor-enter(r1);
        r0 = f10519i;	 Catch:{ all -> 0x003a }
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
        r0 = m18595b(r0);	 Catch:{ all -> 0x0035 }
        f10519i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10519i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.BugReportUploader.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.BugReportUploader");
    }

    private static BugReportUploader m18595b(InjectorLike injectorLike) {
        return new BugReportUploader((Context) injectorLike.getInstance(Context.class), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new BugReportUploadMethodDeprecated(Locales.a(injectorLike), XConfigReader.a(injectorLike)), new BugReportUploadMethod(IdBasedProvider.a(injectorLike, 4442), Locales.a(injectorLike), XConfigReader.a(injectorLike)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ViewerContextManagerProvider.b(injectorLike));
    }

    @Inject
    public BugReportUploader(Context context, AbstractSingleMethodRunner abstractSingleMethodRunner, BugReportUploadMethodDeprecated bugReportUploadMethodDeprecated, BugReportUploadMethod bugReportUploadMethod, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl, ViewerContextManager viewerContextManager) {
        this.f10520b = context;
        this.f10521c = abstractSingleMethodRunner;
        this.f10522d = bugReportUploadMethodDeprecated;
        this.f10523e = bugReportUploadMethod;
        this.f10524f = abstractFbErrorReporter;
        this.f10525g = gatekeeperStoreImpl;
        this.f10526h = viewerContextManager;
    }

    @Nullable
    private ViewerContext m18594b(BugReport bugReport) {
        if (this.f10526h.d().mUserId.equals(bugReport.f10425u)) {
            return null;
        }
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.a = bugReport.f10425u;
        newBuilder = newBuilder;
        newBuilder.b = bugReport.f10426v;
        return newBuilder.h();
    }

    public final String m18596a(BugReport bugReport) {
        boolean z;
        PushedViewerContext b;
        Throwable th;
        Throwable e;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("log", m18591a(bugReport.m18507c()));
        ImmutableList of = ImmutableList.of();
        if (bugReport.m18508d() != null) {
            of = ImmutableList.copyOf(bugReport.m18508d());
        }
        String g = bugReport.m18511g();
        String b2 = bugReport.m18506b();
        ImmutableMap e2 = bugReport.m18509e();
        ImmutableMap f = bugReport.m18510f();
        String objectNode2 = objectNode.toString();
        String h = bugReport.m18512h();
        String i = bugReport.m18513i();
        String j = bugReport.m18514j();
        String k = bugReport.m18515k();
        String l = bugReport.m18516l();
        String m = bugReport.m18517m();
        String n = bugReport.m18518n();
        String o = bugReport.m18519o();
        String p = bugReport.m18520p();
        BugReportSource q = bugReport.m18521q();
        ImmutableMap w = bugReport.m18525w();
        if (bugReport.m18523s() > 0) {
            z = true;
        } else {
            z = false;
        }
        BugReportUploadParams bugReportUploadParams = new BugReportUploadParams(g, b2, of, e2, f, objectNode2, h, i, j, k, l, m, n, o, p, q, w, z, bugReport.m18522r(), bugReport.m18524v());
        try {
            b = this.f10526h.b(m18594b(bugReport));
            th = null;
            try {
                if (this.f10525g.a(23, false)) {
                    b2 = (String) this.f10521c.a(this.f10523e, bugReportUploadParams, CallerContext.a(BugReportUploader.class));
                } else {
                    b2 = (String) this.f10521c.a(this.f10522d, bugReportUploadParams, CallerContext.a(BugReportUploader.class));
                }
                if (b != null) {
                    try {
                        b.close();
                        h = b2;
                    } catch (Exception e3) {
                        e = e3;
                        BLog.b(f10518a, "Unable to upload bug report.", e);
                        this.f10524f.a(f10518a, e);
                        h = b2;
                        if (h != null) {
                            m18593a(m18592a(this.f10520b.getString(2131235806), bugReportUploadParams.m18571b()), this.f10520b.getString(2131235801), 17301641, this.f10520b.getString(2131235805), new Intent(), 50001);
                        }
                        return h;
                    }
                }
                h = b2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                th2 = e;
                e = th3;
            }
        } catch (Exception e4) {
            e = e4;
            b2 = null;
            BLog.b(f10518a, "Unable to upload bug report.", e);
            this.f10524f.a(f10518a, e);
            h = b2;
            if (h != null) {
                m18593a(m18592a(this.f10520b.getString(2131235806), bugReportUploadParams.m18571b()), this.f10520b.getString(2131235801), 17301641, this.f10520b.getString(2131235805), new Intent(), 50001);
            }
            return h;
        }
        if (h != null) {
            m18593a(m18592a(this.f10520b.getString(2131235806), bugReportUploadParams.m18571b()), this.f10520b.getString(2131235801), 17301641, this.f10520b.getString(2131235805), new Intent(), 50001);
        }
        return h;
        throw e;
        if (b != null) {
            if (th2 != null) {
                try {
                    b.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th2, th4);
                }
            } else {
                b.close();
            }
        }
        throw e;
    }

    private static String m18591a(Uri uri) {
        if (uri == null) {
            return "";
        }
        try {
            return Files.a(new File(new URI(uri.toString())), Charset.defaultCharset());
        } catch (Throwable e) {
            BLog.a(f10518a, "Invalid file", e);
            return "";
        } catch (Throwable e2) {
            BLog.a(f10518a, "Failed to laod file", e2);
            return "";
        }
    }

    private static String m18592a(String str, String str2) {
        String a = StringLocaleUtil.a("%s - %s", new Object[]{str, str2});
        if (!BuildConstants.i) {
            return a;
        }
        return StringLocaleUtil.a("%s - beta", new Object[]{a});
    }

    private void m18593a(String str, String str2, int i, String str3, Intent intent, int i2) {
        Builder e = new Builder(this.f10520b).a(str).b(str2).a(new BigTextStyle().m144b(str2)).a(i).c(true).e(str3);
        e.d = PendingIntent.getActivity(this.f10520b, 0, intent, 268435456);
        ((NotificationManager) this.f10520b.getSystemService("notification")).notify(i2, e.c());
    }
}
