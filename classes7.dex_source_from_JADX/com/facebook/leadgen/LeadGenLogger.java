package com.facebook.leadgen;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: place_info_blurb_breadcrumbs */
public class LeadGenLogger {
    private static final String f6297a = LeadGenLogger.class.getSimpleName();
    private static volatile LeadGenLogger f6298g;
    private AnalyticsLogger f6299b;
    private JsonNode f6300c;
    private boolean f6301d;
    private int f6302e;
    private AbstractFbErrorReporter f6303f;

    public static com.facebook.leadgen.LeadGenLogger m8134a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6298g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.leadgen.LeadGenLogger.class;
        monitor-enter(r1);
        r0 = f6298g;	 Catch:{ all -> 0x003a }
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
        r0 = m8137b(r0);	 Catch:{ all -> 0x0035 }
        f6298g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6298g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.leadgen.LeadGenLogger.a(com.facebook.inject.InjectorLike):com.facebook.leadgen.LeadGenLogger");
    }

    private static LeadGenLogger m8137b(InjectorLike injectorLike) {
        return new LeadGenLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public LeadGenLogger(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f6299b = analyticsLogger;
        this.f6303f = abstractFbErrorReporter;
    }

    public final void m8139a(JsonNode jsonNode, boolean z, int i) {
        this.f6300c = jsonNode;
        this.f6301d = z;
        this.f6302e = i;
    }

    public final void m8140a(String str) {
        HoneyClientEvent b = m8136b(str, -1);
        if (b == null) {
            this.f6303f.a(f6297a, "Honey Client Event is null as there are no Tracking codes in source: " + str);
        } else {
            this.f6299b.a(b);
        }
    }

    public final void m8141a(String str, int i) {
        HoneyClientEvent b = m8136b(str, i);
        if (b == null) {
            this.f6303f.a(f6297a, "Honey Client Event is null as there are no Tracking codes in source: " + str);
        } else {
            this.f6299b.a(b);
        }
    }

    public final void m8138a(long j, int i) {
        m8135a("cta_lead_gen_confirmation_vpv", j, i, true);
    }

    public final void m8143b(long j, int i) {
        m8135a("cta_lead_gen_page_vpv", j, i, false);
    }

    private void m8135a(String str, long j, int i, boolean z) {
        HoneyClientEvent b = m8136b(str, i);
        if (b == null) {
            this.f6303f.a(f6297a, "Honey Client Event is null as there are no Tracking codes in source: " + str);
            return;
        }
        b.a("time_duration", j);
        b.a("has_user_submitted", z);
        this.f6299b.a(b);
    }

    public final void m8142a(String str, String str2, int i) {
        HoneyClientEvent b = m8136b(str, i);
        if (b == null) {
            this.f6303f.a(f6297a, "Honey Client Event is null as there are no Tracking codes in source: " + str);
            return;
        }
        b.b("field_key", str2);
        this.f6299b.a(b);
    }

    private HoneyClientEvent m8136b(String str, int i) {
        if (this.f6300c == null || this.f6300c.e() == 0) {
            return null;
        }
        HoneyClientEvent b = new HoneyClientEvent("lead_gen").a("tracking", this.f6300c).b(this.f6301d);
        b.c = "native_newsfeed";
        b = b;
        if (str != null) {
            b.b(str, "1");
        } else {
            b.b("cta_click", "1");
        }
        if (i != -1) {
            b.a("page_index", i);
        }
        if (this.f6302e == -1) {
            return b;
        }
        b.a("item_index", this.f6302e);
        return b;
    }
}
