package com.facebook.goodfriends.analytics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_source */
public class GoodFriendsAnalyticsLogger {
    private static volatile GoodFriendsAnalyticsLogger f13397b;
    private final AnalyticsLogger f13398a;

    /* compiled from: fetch_source */
    public enum Event {
        ENTRY("goodfriends_enter", "good_friends_feed"),
        EXIT("goodfriends_exit", "good_friends_feed"),
        PICKER_OPEN("goodfriends_picker_open", "good_friends_feed"),
        PICKER_CLOSE("goodfrineds_picker_close", "good_friends_feed"),
        PICKER_SELECT("goodfriends_picker_select", "good_friends_feed"),
        PICKER_DESELECT("goodfriends_picker_deselect", "good_friends_feed"),
        PICKER_SEARCH("goodfriends_picker_search", "good_friends_feed"),
        AWESOMIZER_CLOSE("feed_awesomizer_card_close", "good_friends_feed"),
        NUX_SHOWN("goodfriends_nux", "good_friends_feed"),
        PLACEHOLDER_SHOWN("goodfriends_placeholder_shown", "good_friends_feed"),
        PLACEHOLDER_CTA("goodfriends_placeholder_cta", "good_friends_feed");
        
        private String mModule;
        private String mName;

        private Event(String str, String str2) {
            this.mName = str;
            this.mModule = str2;
        }

        final String getName() {
            return this.mName;
        }

        final String getModule() {
            return this.mModule;
        }
    }

    public static com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger m15022a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13397b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f13397b;	 Catch:{ all -> 0x003a }
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
        r0 = m15024b(r0);	 Catch:{ all -> 0x0035 }
        f13397b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13397b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger");
    }

    private static GoodFriendsAnalyticsLogger m15024b(InjectorLike injectorLike) {
        return new GoodFriendsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GoodFriendsAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f13398a = analyticsLogger;
    }

    public final void m15026a(Event event) {
        m15023a(event, null);
    }

    private void m15023a(Event event, @Nullable Bundle bundle) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.getName());
        honeyClientEvent.c = event.getModule();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                honeyClientEvent.a(str, bundle.get(str));
            }
        }
        this.f13398a.a(honeyClientEvent);
    }

    public final void m15027a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("placeholder_type", str);
        m15023a(Event.PLACEHOLDER_SHOWN, bundle);
    }

    public final void m15025a(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("profiles_total_count", i2);
        bundle.putInt("profiles_selected_count", i);
        m15023a(Event.AWESOMIZER_CLOSE, bundle);
    }
}
