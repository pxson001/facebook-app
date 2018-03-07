package com.facebook.ui.browser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.browser.lite.BrowserLiteActivity;
import com.facebook.browser.lite.util.BrowserURLUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.browser.lite.BrowserLiteIntentHandler;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: topic_feeds_composer_show_topic_list */
public class BrowserUriIntentBuilder extends UriIntentBuilder {
    private static volatile BrowserUriIntentBuilder f1519e;
    public final Provider<TriState> f1520a;
    public final FbSharedPreferences f1521b;
    private final BrowserLiteIntentHandler f1522c;
    public final AnalyticsLogger f1523d;

    public static com.facebook.ui.browser.BrowserUriIntentBuilder m1586a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1519e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.browser.BrowserUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f1519e;	 Catch:{ all -> 0x003a }
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
        r0 = m1587b(r0);	 Catch:{ all -> 0x0035 }
        f1519e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1519e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.browser.BrowserUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.ui.browser.BrowserUriIntentBuilder");
    }

    private static BrowserUriIntentBuilder m1587b(InjectorLike injectorLike) {
        return new BrowserUriIntentBuilder(IdBasedProvider.a(injectorLike, 787), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), BrowserLiteIntentHandler.m1616b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BrowserUriIntentBuilder(Provider<TriState> provider, FbSharedPreferences fbSharedPreferences, BrowserLiteIntentHandler browserLiteIntentHandler, AnalyticsLogger analyticsLogger) {
        this.f1520a = provider;
        this.f1521b = fbSharedPreferences;
        this.f1522c = browserLiteIntentHandler;
        this.f1523d = analyticsLogger;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dO, "temporary_url_extra"), BrowserLiteActivity.class);
    }

    public final Intent m1588a(Context context, String str) {
        Intent a = super.a(context, str);
        if (!(a == null || a.getStringExtra("temporary_url_extra") == null)) {
            boolean z;
            Uri parse = Uri.parse(a.getStringExtra("temporary_url_extra"));
            if (!((TriState) this.f1520a.get()).asBoolean(false) || this.f1521b.a(BrowserPrefKey.a, false)) {
                z = false;
            } else {
                z = true;
            }
            if (z && BrowserURLUtil.a(parse)) {
                a.setData(parse);
                a.removeExtra("temporary_url_extra");
                a.putExtra("iab_click_source", "fblink");
                this.f1522c.m1624a(a, context);
            } else {
                a = new Intent("android.intent.action.VIEW", parse);
                a.putExtra("force_external_browser", true);
            }
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("iab_disabled_opening_webview_uri");
            honeyClientEvent.c = "webview";
            this.f1523d.a(honeyClientEvent.a("iab_disabled", ((TriState) this.f1520a.get()).asBoolean(false)).a("iab_user_disabled", this.f1521b.a(BrowserPrefKey.a, false)));
        }
        return a;
    }
}
