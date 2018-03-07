package com.facebook.pages.deeplinking.uri;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.DefaultUriIntentMapper;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.UserStatus;
import com.facebook.pages.deeplinking.DefaultUriIntentMapper_PagesManagerRedirectMethodAutoProvider;
import com.facebook.pages.deeplinking.PagesManagerDeeplinkingUtils;
import com.facebook.pages.deeplinking.PagesManagerDeeplinkingUtils.Config;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: mErrorCode */
public class ManagedPageUriIntentBuilder extends UriIntentBuilder {
    private static volatile ManagedPageUriIntentBuilder f8377c;
    private final PagesManagerDeeplinkingUtils f8378a;
    private final DefaultUriIntentMapper f8379b;

    public static com.facebook.pages.deeplinking.uri.ManagedPageUriIntentBuilder m8332a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8377c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.deeplinking.uri.ManagedPageUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f8377c;	 Catch:{ all -> 0x003a }
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
        r0 = m8333b(r0);	 Catch:{ all -> 0x0035 }
        f8377c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8377c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.deeplinking.uri.ManagedPageUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.pages.deeplinking.uri.ManagedPageUriIntentBuilder");
    }

    private static ManagedPageUriIntentBuilder m8333b(InjectorLike injectorLike) {
        return new ManagedPageUriIntentBuilder(PagesManagerDeeplinkingUtils.m8330a(injectorLike), DefaultUriIntentMapper_PagesManagerRedirectMethodAutoProvider.m8323a(injectorLike));
    }

    @Inject
    public ManagedPageUriIntentBuilder(PagesManagerDeeplinkingUtils pagesManagerDeeplinkingUtils, DefaultUriIntentMapper defaultUriIntentMapper) {
        this.f8378a = pagesManagerDeeplinkingUtils;
        this.f8379b = defaultUriIntentMapper;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("pagesmanager/{#%s}"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.NATIVE_PAGES_FRAGMENT.ordinal());
    }

    public final Intent m8334a(Context context, String str) {
        Intent a = super.a(context, str);
        if (a == null) {
            return null;
        }
        boolean z;
        PagesManagerDeeplinkingUtils pagesManagerDeeplinkingUtils = this.f8378a;
        Config config = PagesManagerDeeplinkingUtils.f8370a;
        if (!config.f8368a) {
            z = false;
        } else if (pagesManagerDeeplinkingUtils.f8372b.c("com.facebook.pages.app")) {
            String str2;
            PackageInfo c = pagesManagerDeeplinkingUtils.f8372b.c("com.facebook.pages.app", 0);
            if (c != null) {
                str2 = c.versionName;
            } else {
                str2 = null;
            }
            String str3 = str2;
            if (str3 == null || pagesManagerDeeplinkingUtils.f8376f.a(str3, "2.0") < 0) {
                r7 = pagesManagerDeeplinkingUtils.f8375e;
                r8 = new HoneyClientEvent("pma_installed_old");
                r8.c = "pma_deeplinking";
                r7.c(r8.b("pma_version", str3));
                z = false;
            } else {
                UserStatus a2 = pagesManagerDeeplinkingUtils.f8374d.a((String) pagesManagerDeeplinkingUtils.f8373c.get());
                boolean z2 = config.f8369b;
                boolean z3 = a2.a || TriState.YES.equals(a2.c);
                AnalyticsLogger analyticsLogger = pagesManagerDeeplinkingUtils.f8375e;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("pma_installed");
                honeyClientEvent.c = "pma_deeplinking";
                analyticsLogger.c(honeyClientEvent.a("logged_in", z3).a("same_logged_in_user", a2.a).a("logout_okay", z2));
                z = a2.a ? true : TriState.NO.equals(a2.c) ? config.f8369b : false;
            }
        } else {
            r7 = pagesManagerDeeplinkingUtils.f8375e;
            r8 = new HoneyClientEvent("pma_not_installed");
            r8.c = "pma_deeplinking";
            r7.c(r8);
            z = false;
        }
        if (z) {
            return this.f8379b.a(context, str).addFlags(268435456);
        }
        return a;
    }
}
