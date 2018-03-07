package com.facebook.entitycards.contextitems.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.entitycards.contextitems.surface.ContextItemSurfaces;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inModule */
public class ContextItemsAnalyticsLogger {
    private static volatile ContextItemsAnalyticsLogger f10905c;
    private final AnalyticsLogger f10906a;
    private final Lazy<NavigationLogger> f10907b;

    /* compiled from: inModule */
    public enum ContextItemEvents {
        IMPRESSION("ec_context_item_impression"),
        TAP("ec_tap");
        
        public final String name;

        private ContextItemEvents(String str) {
            this.name = str;
        }
    }

    public static com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger m12848a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10905c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f10905c;	 Catch:{ all -> 0x003a }
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
        r0 = m12850b(r0);	 Catch:{ all -> 0x0035 }
        f10905c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10905c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger");
    }

    private static ContextItemsAnalyticsLogger m12850b(InjectorLike injectorLike) {
        return new ContextItemsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137));
    }

    @Inject
    public ContextItemsAnalyticsLogger(AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy) {
        this.f10906a = analyticsLogger;
        this.f10907b = lazy;
    }

    public final void m12851a(ContextItemSurfaces contextItemSurfaces, String str, String str2, int i, Optional<String> optional) {
        m12849a(ContextItemEvents.TAP, contextItemSurfaces, str, str2, i, optional);
    }

    public final void m12853b(ContextItemSurfaces contextItemSurfaces, String str, String str2, int i, Optional<String> optional) {
        m12849a(ContextItemEvents.IMPRESSION, contextItemSurfaces, str, str2, i, optional);
    }

    public final void m12852a(String str, int i) {
        m12849a(ContextItemEvents.IMPRESSION, ContextItemSurfaces.PAGE_HEADER, "expand", str, i, Absent.INSTANCE);
    }

    public final void m12854b(String str, int i) {
        m12849a(ContextItemEvents.TAP, ContextItemSurfaces.PAGE_HEADER, "expand", str, i, Absent.INSTANCE);
    }

    private void m12849a(ContextItemEvents contextItemEvents, ContextItemSurfaces contextItemSurfaces, String str, String str2, int i, Optional<String> optional) {
        ((NavigationLogger) this.f10907b.get()).a("timeline_context_item");
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(contextItemEvents.name);
        honeyClientEvent.c = "entity_cards.context_items_view_controller";
        HoneyClientEvent a = honeyClientEvent.b("context_item_surface", contextItemSurfaces.name).b("target_type", str).b("fbid", str2).a("position", i);
        if (optional.isPresent()) {
            a.b("logging_param", (String) optional.get());
        }
        this.f10906a.a(a);
    }
}
