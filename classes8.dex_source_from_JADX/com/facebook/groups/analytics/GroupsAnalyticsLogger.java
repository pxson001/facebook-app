package com.facebook.groups.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.xanalytics.XAnalyticsProvider;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: view_page_likers */
public class GroupsAnalyticsLogger {
    private static volatile GroupsAnalyticsLogger f453d;
    private final AnalyticsLogger f454a;
    private final Lazy<XAnalyticsProvider> f455b;
    public final Provider<TriState> f456c;

    public static com.facebook.groups.analytics.GroupsAnalyticsLogger m422a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f453d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.analytics.GroupsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f453d;	 Catch:{ all -> 0x003a }
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
        r0 = m425b(r0);	 Catch:{ all -> 0x0035 }
        f453d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f453d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.analytics.GroupsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.groups.analytics.GroupsAnalyticsLogger");
    }

    private static GroupsAnalyticsLogger m425b(InjectorLike injectorLike) {
        return new GroupsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3746), IdBasedProvider.a(injectorLike, 684));
    }

    @Inject
    public GroupsAnalyticsLogger(AnalyticsLogger analyticsLogger, Lazy<XAnalyticsProvider> lazy, Provider<TriState> provider) {
        this.f454a = analyticsLogger;
        this.f455b = lazy;
        this.f456c = provider;
    }

    private void m423a(HoneyClientEvent honeyClientEvent) {
        if (((TriState) this.f456c.get()).equals(TriState.YES) && honeyClientEvent != null) {
            String str;
            String str2 = "fbacore_" + honeyClientEvent.d;
            String u = honeyClientEvent.u();
            if (u == null) {
                str = "";
            } else {
                str = u;
            }
            ((DefaultXAnalyticsProvider) this.f455b.get()).c.a(str2, str);
        }
    }

    public final void m427a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("group_side_conversation_started");
        honeyClientEvent.c = "group_mall_side_conversation";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.b("group_id", str);
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m428a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("group_side_conversation_displayed");
        honeyClientEvent.c = str2;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.b("group_id", str);
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m426a() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("creation_create_requested");
        honeyClientEvent.c = "group_creation";
        honeyClientEvent = honeyClientEvent;
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m431b() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("creation_cancelled");
        honeyClientEvent.c = "group_creation";
        honeyClientEvent = honeyClientEvent;
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m434c() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("creation_entered");
        honeyClientEvent.c = "group_creation";
        honeyClientEvent = honeyClientEvent;
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m436d() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("creation_create_succeeded");
        honeyClientEvent.c = "group_creation";
        honeyClientEvent = honeyClientEvent;
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m437e() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("creation_create_failed");
        honeyClientEvent.c = "group_creation";
        honeyClientEvent = honeyClientEvent;
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m432b(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "me_tab";
        honeyClientEvent = honeyClientEvent;
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }

    public final void m429a(String str, String str2, String str3) {
        HoneyClientEvent b = new HoneyClientEvent("gysc_click").b("suggestion_type", str).b("suggestion_id", str2).b("ref", str3);
        b.c = "me_tab";
        b = b;
        this.f454a.a(b);
        m423a(b);
    }

    public final void m433b(String str, String str2, String str3) {
        m424a(str, str2, str3, new HoneyClientEvent("gysccta_click"));
    }

    public final void m435c(String str, String str2, String str3) {
        m424a(str, str2, str3, new HoneyClientEvent("gysccta_imp"));
    }

    public final void m430a(String str, String str2, String str3, String str4, String str5) {
        if (str != null && str2 != null) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            arrayNode.h(str);
            arrayNode.h(str2);
            HoneyClientEvent b = new HoneyClientEvent("gysc_create").a("tracking", arrayNode).b("suggestion_type", str3).b("suggestion_id", str4).b("ref", str5);
            b.c = "native_newsfeed";
            b = b;
            this.f454a.a(b);
            m423a(b);
        }
    }

    private void m424a(String str, String str2, String str3, HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.b("suggestion_type", str).b("suggestion_id", str2).b("ref", str3).c = "group_creation";
        this.f454a.a(honeyClientEvent);
        m423a(honeyClientEvent);
    }
}
