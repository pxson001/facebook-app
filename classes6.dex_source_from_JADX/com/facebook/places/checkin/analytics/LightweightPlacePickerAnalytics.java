package com.facebook.places.checkin.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: friend_remove */
public class LightweightPlacePickerAnalytics {
    private static volatile LightweightPlacePickerAnalytics f14588b;
    private final AnalyticsLogger f14589a;

    public static com.facebook.places.checkin.analytics.LightweightPlacePickerAnalytics m22175a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14588b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.checkin.analytics.LightweightPlacePickerAnalytics.class;
        monitor-enter(r1);
        r0 = f14588b;	 Catch:{ all -> 0x003a }
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
        r0 = m22177b(r0);	 Catch:{ all -> 0x0035 }
        f14588b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14588b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.analytics.LightweightPlacePickerAnalytics.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.analytics.LightweightPlacePickerAnalytics");
    }

    private static LightweightPlacePickerAnalytics m22177b(InjectorLike injectorLike) {
        return new LightweightPlacePickerAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LightweightPlacePickerAnalytics(AnalyticsLogger analyticsLogger) {
        this.f14589a = analyticsLogger;
    }

    public final void m22179a(String str, String str2, String str3, String str4, List<? extends CheckinPlace> list) {
        this.f14589a.a(m22176b(str, str2, str3, str4, list));
    }

    public final void m22178a(String str, String str2, String str3, int i, List<? extends CheckinPlace> list) {
        HoneyClientEvent b = m22176b("lightweight_place_picker_place_picked", str, str2, str3, list);
        b.a("selected_row", i);
        this.f14589a.a(b);
    }

    private static HoneyClientEvent m22176b(String str, String str2, String str3, String str4, List<? extends CheckinPlace> list) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = str2;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = "place_picker";
        honeyClientEvent = honeyClientEvent.b("query", "").b("search_type", SearchType.LIGHTWEIGHT_PLACE_PICKER.toLegacyString()).b("place_picker_session_id", str3).b("results_list_id", str4);
        String str5 = "results_fetched";
        ArrayNode b = JsonNodeFactory.a.b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b.h(((CheckinPlaceModel) it.next()).cf_());
        }
        return honeyClientEvent.a(str5, b);
    }
}
