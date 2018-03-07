package com.facebook.katana.urimap;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.common.uri.UriTemplateMap.InvalidUriException;
import com.facebook.common.uri.UriTemplateMap.UriMatch;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.deeplinking.activity.ActivityWithDeepLinking;
import com.facebook.deeplinking.activity.DeepLinkingAliasActivity;
import com.facebook.deeplinking.handler.DeepLinkHandler;
import com.facebook.deeplinking.handler.STATICDI_MULTIBIND_PROVIDER$DeepLinkHandler;
import com.facebook.deeplinking.logging.DeepLinkLoggingUtils;
import com.facebook.directinstall.DirectInstallIntentHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.UserStatus;
import com.facebook.katana.constants.Constants$URL;
import com.facebook.katana.orca.DisableMessengerUriIntentBuilder;
import com.facebook.katana.orca.MessengerMSiteUriIntentBuilder;
import com.facebook.katana.orca.MessengerRedirectUriIntentBuilder;
import com.facebook.katana.urimap.FacewebUriRedirector.Builder;
import com.facebook.katana.urimap.api.UriHandler;
import com.facebook.katana.urimap.fetchable.FacewebUriMap;
import com.facebook.katana.urimap.fetchable.FacewebUriMap.FacewebUriHandler;
import com.facebook.messaging.forcemessenger.ForceMessenger;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.webview.WebViewUriRedirector;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: signal_dbm */
public class Fb4aUriIntentMapper implements UriIntentMapper {
    private static volatile Fb4aUriIntentMapper f4786B;
    @VisibleForTesting
    public static final FacewebUriRedirector f4787a = new FacewebUriRedirector(new Builder().m8652a("/privacy/review/", "(\\d+)/?", ".*", FBLinks.m4311a("id_backed_privacy_checkup/checkup_id=<p$1>")).m8652a("/commerce/products/", "(.*)", ".*", FBLinks.ex).m8652a("/messages/thread/", "(\\d+)/?", null, FBLinks.m4311a("messaging/<p$1>")).m8652a("/pages/", "[^/]+/([^/]+)/?", "", FBLinks.m4311a("page/<p$1>")).m8652a("/pages/", "[^/]+/([^/]+)", ".*sk=info.*", FBLinks.m4311a("page/<p$1>/info")).m8652a("/events", null, null, FBLinks.by).m8652a("/events/upcoming", null, null, FBLinks.by).m8652a("/events/", "(\\d+)/?", ".*", FBLinks.m4311a("event/<p$1>")).m8652a("/groups/members/search", "/?", ".*group_id=([^/&]+).*", FBLinks.m4311a("group/members/search/<q$1>")).m8652a("/groups/", "([^/]+)/?", "(^.*(view=group).*$)|(?!.*view=)", FBLinks.m4311a("group/<p$1>")).m8652a("/groups/", "(\\d+)?", "(^.*(view=requests).*$)|(?!.*view=)", FBLinks.m4311a("groups/requests/<p$1>")).m8652a("/onthisday", "/?", "(.*)", FBLinks.m4311a("onthisday?<q$1>")).m8652a("/groups/", "(\\d+)?", "(^.*(view=pending).*$)|(?!.*view=)", FBLinks.m4311a("groups/pendingposts/<p$1>")).m8652a("/groups/", "(\\d+)?", "(^.*(view=photos).*$)|(?!.*view=)", FBLinks.m4311a("groups/photos/<p$1>")).m8652a("/groups/", "(\\d+)?", "(^.*(view=events).*$)|(?!.*view=)", FBLinks.m4311a("groups/events/<p$1>")).m8652a("/groups/", "(\\d+)?", "(^.*(view=members).*$)|(?!.*view=)", FBLinks.m4311a("groups/members/<p$1>")).m8652a("/groups/", "(\\d+)?", "(^.*(view=files).*$)|(?!.*view=)", FBLinks.m4311a("groups/files/<p$1>")).m8652a("/group/settings", "/?", "group_id=(\\d+).*", FBLinks.m4311a("groups/settings/<q$1>")).m8652a("/story.php", null, "story_fbid=(\\d+)&id=(\\d+)&post_id=([\\d_]+).*", FBLinks.m4311a("native_post/<q$3>?fallback_url= ")).m8652a("/events/birthdays", null, ".*extra_data\\[start_date\\]=(((19|20)\\d\\d)/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])).*", FBLinks.m4311a("upcoming_birthdays?start_date=<q$1>")).m8652a("/friendship/", null, null, FBLinks.eZ).m8652a("/donate/", "(\\d+)/?", "(invite|(.+?[?&]invite))(([&=].*)|$)", FBLinks.m4311a("donate/?fundraiser_campaign_id=<p$1>&action_type=invite")).m8652a("/donate/", "(\\d+)/?", "((?!donate_ref=).)*", FBLinks.m4311a("donate/?fundraiser_campaign_id=<p$1>&post_id=0")).m8652a("/donate/", "(\\d+)/(\\d+)/?", "((?!donate_ref=).)*", FBLinks.m4311a("donate/?fundraiser_campaign_id=<p$1>&post_id=<p$2>")).m8652a("/ads/experience/confirmation/", null, "experience_id=(\\d+).*", FBLinks.m4311a("ads_experience/?id=<q$1>")));
    private final Fb4aComponentHelperFactory f4788A;
    private final Lazy<ForceMessenger> f4789b;
    private final MonotonicClock f4790c;
    private final JsonFactory f4791d;
    private final FbObjectMapper f4792e;
    private final Lazy<AnalyticsLogger> f4793f;
    private final Lazy<AppLinksUtil> f4794g;
    private final Provider<Boolean> f4795h;
    private final Lazy<StaticUriIntentMapper> f4796i;
    private final Lazy<MessengerRedirectUriIntentBuilder> f4797j;
    private final Lazy<MessengerMSiteUriIntentBuilder> f4798k;
    private final Lazy<DisableMessengerUriIntentBuilder> f4799l;
    private final Lazy<FacewebUriIntentBuilder> f4800m;
    private final Lazy<GooglePlayIntentHelper> f4801n;
    private final Lazy<DirectInstallIntentHelper> f4802o;
    private final Lazy<InternalIntentSigner> f4803p;
    private final Provider<TriState> f4804q;
    public final Lazy<DeepLinkLoggingUtils> f4805r;
    private final Lazy<Set<DeepLinkHandler>> f4806s;
    private final boolean f4807t;
    private final MessengerAppUtils f4808u;
    private final InteractionTTILogger f4809v;
    private final UriMapPerfLogger f4810w;
    private final Lazy<WebViewUriRedirector> f4811x;
    private final Lazy<LegacyFacebookUriRedirector> f4812y;
    private final Provider<Boolean> f4813z;

    public static com.facebook.katana.urimap.Fb4aUriIntentMapper m8640a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4786B;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.Fb4aUriIntentMapper.class;
        monitor-enter(r1);
        r0 = f4786B;	 Catch:{ all -> 0x003a }
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
        r0 = m8644b(r0);	 Catch:{ all -> 0x0035 }
        f4786B = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4786B;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.Fb4aUriIntentMapper.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.Fb4aUriIntentMapper");
    }

    private static Fb4aUriIntentMapper m8644b(InjectorLike injectorLike) {
        return new Fb4aUriIntentMapper(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2619), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedLazy.m1808a(injectorLike, 7366), IdBasedProvider.m1811a(injectorLike, 4157), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7378), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7342), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7339), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7341), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7371), IdBasedLazy.m1808a(injectorLike, 579), IdBasedLazy.m1808a(injectorLike, 5490), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2400), IdBasedProvider.m1811a(injectorLike, 663), IdBasedLazy.m1808a(injectorLike, 5470), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike), InteractionTTILogger.m4228a(injectorLike), UriMapPerfLogger.m8654a(injectorLike), MessengerAppUtils.m8662a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11747), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7374), STATICDI_MULTIBIND_PROVIDER$DeepLinkHandler.m8683a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4036), Fb4aComponentHelperFactory.m8684a(injectorLike));
    }

    @Inject
    public Fb4aUriIntentMapper(Lazy<ForceMessenger> lazy, MonotonicClock monotonicClock, JsonFactory jsonFactory, FbObjectMapper fbObjectMapper, Lazy<AnalyticsLogger> lazy2, Lazy<AppLinksUtil> lazy3, Provider<Boolean> provider, Lazy<StaticUriIntentMapper> lazy4, Lazy<MessengerRedirectUriIntentBuilder> lazy5, Lazy<DisableMessengerUriIntentBuilder> lazy6, Lazy<MessengerMSiteUriIntentBuilder> lazy7, Lazy<FacewebUriIntentBuilder> lazy8, Lazy<GooglePlayIntentHelper> lazy9, Lazy<DirectInstallIntentHelper> lazy10, Lazy<InternalIntentSigner> lazy11, Provider<TriState> provider2, Lazy<DeepLinkLoggingUtils> lazy12, Boolean bool, InteractionTTILogger interactionTTILogger, UriMapPerfLogger uriMapPerfLogger, MessengerAppUtils messengerAppUtils, Lazy<WebViewUriRedirector> lazy13, Lazy<LegacyFacebookUriRedirector> lazy14, Lazy<Set<DeepLinkHandler>> lazy15, Provider<Boolean> provider3, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        this.f4789b = lazy;
        this.f4790c = monotonicClock;
        this.f4791d = jsonFactory;
        this.f4792e = fbObjectMapper;
        this.f4793f = lazy2;
        this.f4794g = lazy3;
        this.f4795h = provider;
        this.f4796i = lazy4;
        this.f4797j = lazy5;
        this.f4799l = lazy6;
        this.f4798k = lazy7;
        this.f4800m = lazy8;
        this.f4801n = lazy9;
        this.f4802o = lazy10;
        this.f4803p = lazy11;
        this.f4804q = provider2;
        this.f4805r = lazy12;
        this.f4807t = bool.booleanValue();
        this.f4809v = interactionTTILogger;
        this.f4810w = uriMapPerfLogger;
        this.f4808u = messengerAppUtils;
        this.f4811x = lazy13;
        this.f4812y = lazy14;
        this.f4806s = lazy15;
        this.f4813z = provider3;
        this.f4788A = fb4aComponentHelperFactory;
    }

    private static UriMatch<UriHandler> m8639a(Context context, String str, Provider<Boolean> provider) {
        if (((Boolean) provider.get()).booleanValue()) {
            UriTemplateMap uriTemplateMap = (UriTemplateMap) FacewebUriMap.b(context).a(null);
            if (uriTemplateMap != null) {
                return uriTemplateMap.m4858a(str);
            }
        }
        return null;
    }

    public static String m8641a(Uri uri) {
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(uri.toString()));
    }

    public final Intent mo1267a(Context context, String str) {
        Intent c;
        Throwable e;
        boolean z;
        boolean z2 = true;
        TracerDetour.a("Fb4aUriIntentMapper.getIntentForUri: %s", str != null ? str : "null", 861204505);
        if (context == null) {
            try {
                BLog.b("Fb4aUriIntentMapper", "Passing null context to getIntentForUri()");
                return null;
            } finally {
                TracerDetour.a(583620568);
            }
        } else if (str == null) {
            BLog.b("Fb4aUriIntentMapper", "Passing null uri to getIntentForUri()");
            TracerDetour.a(1902843138);
            return null;
        } else {
            String a;
            UriMapPerfLogger uriMapPerfLogger;
            UriMapPerfLogger uriMapPerfLogger2;
            try {
                this.f4809v.m4268k(str);
                if (this.f4807t && str.startsWith("fb://")) {
                    a = FBLinks.m4311a(str.substring(5));
                } else {
                    a = str;
                }
                try {
                    if (a.startsWith("facebook:/")) {
                        a = ((LegacyFacebookUriRedirector) this.f4812y.get()).a(a);
                        if (a == null) {
                            this.f4810w.m8660a(a, true);
                            this.f4809v.m4269l(a);
                            TracerDetour.a(1635818239);
                            return null;
                        }
                    }
                    this.f4810w.m8659a(context, a);
                    this.f4810w.m8657a(5701654, a);
                    c = m8645c(context, a);
                } catch (InvalidUriException e2) {
                    e = e2;
                    c = null;
                    try {
                        BLog.b("Fb4aUriIntentMapper", "The uri passed to getIntentForUri() was malformed", e);
                        uriMapPerfLogger = this.f4810w;
                        if (c != null) {
                            z2 = false;
                        }
                        uriMapPerfLogger.m8660a(a, z2);
                        this.f4809v.m4269l(a);
                        TracerDetour.a(-1498881227);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        uriMapPerfLogger2 = this.f4810w;
                        if (c == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        uriMapPerfLogger2.m8660a(a, z);
                        this.f4809v.m4269l(a);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    c = null;
                    uriMapPerfLogger2 = this.f4810w;
                    if (c == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    uriMapPerfLogger2.m8660a(a, z);
                    this.f4809v.m4269l(a);
                    throw e;
                }
                try {
                    this.f4810w.m8658a(5701654, c == null);
                    if (c != null) {
                        uriMapPerfLogger = this.f4810w;
                        if (c != null) {
                            z2 = false;
                        }
                        uriMapPerfLogger.m8660a(a, z2);
                        this.f4809v.m4269l(a);
                        TracerDetour.a(-1652830535);
                        return c;
                    }
                    String str2;
                    Intent a2;
                    String dataString;
                    boolean z3;
                    Uri parse = Uri.parse(a);
                    boolean z4 = parse.isHierarchical() && Boolean.parseBoolean(parse.getQueryParameter("force_faceweb"));
                    this.f4810w.m8657a(5701642, a);
                    if (z4) {
                        str2 = null;
                    } else {
                        str2 = f4787a.m8653a(parse);
                    }
                    if (str2 == null) {
                        a2 = ((WebViewUriRedirector) this.f4811x.get()).a(context, parse.toString());
                        dataString = a2 == null ? a : a2.getDataString();
                    } else {
                        dataString = str2;
                    }
                    this.f4810w.m8658a(5701642, a.equals(dataString));
                    if (a.startsWith(DisableMessengerUriIntentBuilder.a) || a.startsWith(MessengerRedirectUriIntentBuilder.a) || a.startsWith(MessengerMSiteUriIntentBuilder.a)) {
                        this.f4810w.m8657a(5701641, dataString);
                        if (((ForceMessenger) this.f4789b.get()).d()) {
                            c = m8647d(context, dataString);
                        }
                        if (c == null) {
                            c = m8646c(dataString);
                        }
                        UriMapPerfLogger uriMapPerfLogger3 = this.f4810w;
                        if (c == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        uriMapPerfLogger3.m8658a(5701641, z3);
                    }
                    if (c == null && ((TriState) this.f4804q.get()).asBoolean(false) && !z4 && (context instanceof ActivityWithDeepLinking)) {
                        Uri parse2 = dataString != null ? Uri.parse(dataString) : parse;
                        this.f4810w.m8657a(5701638, dataString);
                        a2 = new Intent("android.intent.action.VIEW");
                        a2.setData(parse2);
                        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(a2, 0)) {
                            if (StringUtil.m3590a(DeepLinkingAliasActivity.class.getName(), resolveInfo.activityInfo.name)) {
                                z3 = true;
                                break;
                            }
                        }
                        z3 = false;
                        if (z3) {
                            for (DeepLinkHandler a3 : (Set) this.f4806s.get()) {
                                c = a3.a(context, parse2);
                                if (c != null) {
                                    ((DeepLinkLoggingUtils) this.f4805r.get()).a(parse2, c.getData());
                                    break;
                                }
                            }
                        }
                        this.f4810w.m8658a(5701638, c == null);
                    }
                    if (c == null && a != null && NativeThirdPartyUriHelper.m29571a(a)) {
                        this.f4810w.m8657a(5701645, a);
                        c = NativeThirdPartyUriHelper.m29554a(context, Uri.parse(a));
                        uriMapPerfLogger2 = this.f4810w;
                        if (c == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        uriMapPerfLogger2.m8658a(5701645, z3);
                    }
                    if (c == null && Constants$URL.m24646d(dataString)) {
                        this.f4810w.m8657a(5701644, dataString);
                        if (FacebookUriUtil.m20916a(parse)) {
                            c = new Intent("android.intent.action.VIEW").setData(Uri.parse(dataString));
                        } else {
                            c = m8636a(context, Uri.parse(dataString));
                        }
                        uriMapPerfLogger2 = this.f4810w;
                        if (c == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        uriMapPerfLogger2.m8658a(5701644, z3);
                    }
                    if (c == null) {
                        c = m8642b(context, dataString);
                    }
                    if (c == null) {
                        this.f4810w.m8657a(5701637, dataString);
                        c = m8638a(context, a, dataString);
                        this.f4810w.m8658a(5701637, c == null);
                    }
                    if (c == null && !a.equals(dataString)) {
                        this.f4810w.m8657a(5701647, a);
                        if (Constants$URL.m24646d(a)) {
                            c = m8636a(context, parse);
                        } else {
                            c = ((FacewebUriIntentBuilder) this.f4800m.get()).a(context, a);
                        }
                        uriMapPerfLogger2 = this.f4810w;
                        if (c == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        uriMapPerfLogger2.m8658a(5701647, z3);
                    }
                    if (c != null) {
                        c.putExtra("extra_launch_uri", a);
                        if (a.contains("trust/afro/?")) {
                            c.putExtra("faceweb_nfx", true);
                        } else {
                            str2 = parse.getHost();
                            if ("help".equals(str2)) {
                                z3 = true;
                            } else {
                                if ("faceweb".equals(str2)) {
                                    str2 = parse.getQueryParameter("href");
                                } else {
                                    str2 = parse.getPath();
                                }
                                str2 = str2 + '/';
                                z3 = str2.startsWith("/business/help/") || str2.startsWith("/help/");
                            }
                            if (z3) {
                                c.putExtra("faceweb_help_center", true);
                            }
                        }
                    }
                    if (c == null && a != null) {
                        this.f4810w.m8657a(5701636, a);
                        c = ((GooglePlayIntentHelper) this.f4801n.get()).m22735a(a);
                        if (!(c == null || c.getData() == null || !"market".equals(c.getData().getScheme()))) {
                            c.setFlags(524288);
                        }
                        this.f4810w.m8658a(5701636, c == null);
                    }
                    if (c == null && a != null) {
                        this.f4810w.m8657a(5701651, a);
                        c = m8643b(a);
                        uriMapPerfLogger2 = this.f4810w;
                        if (c == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        uriMapPerfLogger2.m8658a(5701651, z3);
                    }
                    if (c == null && a != null) {
                        this.f4810w.m8657a(5701635, a);
                        c = m8637a(context, a, parse);
                        uriMapPerfLogger2 = this.f4810w;
                        if (c == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        uriMapPerfLogger2.m8658a(5701635, z3);
                    }
                    if (c != null) {
                        ((InternalIntentSigner) this.f4803p.get()).mo1178a(c);
                    }
                    uriMapPerfLogger = this.f4810w;
                    if (c != null) {
                        z2 = false;
                    }
                    uriMapPerfLogger.m8660a(a, z2);
                    this.f4809v.m4269l(a);
                    TracerDetour.a(-272227635);
                    return c;
                } catch (InvalidUriException e3) {
                    e = e3;
                    BLog.b("Fb4aUriIntentMapper", "The uri passed to getIntentForUri() was malformed", e);
                    uriMapPerfLogger = this.f4810w;
                    if (c != null) {
                        z2 = false;
                    }
                    uriMapPerfLogger.m8660a(a, z2);
                    this.f4809v.m4269l(a);
                    TracerDetour.a(-1498881227);
                    return null;
                }
            } catch (InvalidUriException e4) {
                e = e4;
                c = null;
                a = str;
                BLog.b("Fb4aUriIntentMapper", "The uri passed to getIntentForUri() was malformed", e);
                uriMapPerfLogger = this.f4810w;
                if (c != null) {
                    z2 = false;
                }
                uriMapPerfLogger.m8660a(a, z2);
                this.f4809v.m4269l(a);
                TracerDetour.a(-1498881227);
                return null;
            } catch (Throwable th3) {
                e = th3;
                c = null;
                a = str;
                uriMapPerfLogger2 = this.f4810w;
                if (c == null) {
                    z = false;
                } else {
                    z = true;
                }
                uriMapPerfLogger2.m8660a(a, z);
                this.f4809v.m4269l(a);
                throw e;
            }
        }
    }

    public final Intent mo1266a(Context context, NativeUri nativeUri) {
        Intent intent;
        Throwable th;
        UriMapPerfLogger uriMapPerfLogger;
        boolean z = true;
        String a = nativeUri.a();
        Intent intent2 = null;
        try {
            UriMapPerfLogger uriMapPerfLogger2;
            this.f4810w.m8659a(context, a);
            if (a == null || !NativeThirdPartyUriHelper.m29571a(a)) {
                intent = null;
            } else {
                this.f4810w.m8657a(5701650, a);
                intent2 = ((DirectInstallIntentHelper) this.f4802o.get()).a(context, nativeUri);
                this.f4810w.m8658a(5701650, intent2 == null);
                if (intent2 != null) {
                    this.f4810w.m8660a(a, intent2 == null);
                    return intent2;
                }
                this.f4810w.m8657a(5701645, a);
                intent = NativeThirdPartyUriHelper.m29560a(context, nativeUri);
                try {
                    this.f4810w.m8658a(5701645, intent == null);
                    if (intent != null) {
                        uriMapPerfLogger2 = this.f4810w;
                        if (intent != null) {
                            z = false;
                        }
                        uriMapPerfLogger2.m8660a(a, z);
                        return intent;
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    intent2 = intent;
                    th = th3;
                    uriMapPerfLogger = this.f4810w;
                    if (intent2 != null) {
                        z = false;
                    }
                    uriMapPerfLogger.m8660a(a, z);
                    throw th;
                }
            }
            uriMapPerfLogger2 = this.f4810w;
            if (intent != null) {
                z = false;
            }
            uriMapPerfLogger2.m8660a(a, z);
            return mo1267a(context, nativeUri.a());
        } catch (Throwable th4) {
            th = th4;
            uriMapPerfLogger = this.f4810w;
            if (intent2 != null) {
                z = false;
            }
            uriMapPerfLogger.m8660a(a, z);
            throw th;
        }
    }

    private Intent m8636a(Context context, Uri uri) {
        Intent a = ((FacewebUriIntentBuilder) this.f4800m.get()).a(context, m8641a(uri));
        if (a != null) {
            a.putExtra("application_link_type", "web");
        }
        return a;
    }

    private Intent m8638a(Context context, String str, String str2) {
        UriMatch a = m8639a(context, str, this.f4813z);
        if (a == null && str2 != null) {
            a = m8639a(context, str2, this.f4813z);
        }
        if (a == null) {
            return null;
        }
        FacewebUriHandler facewebUriHandler = (FacewebUriHandler) a.a;
        Bundle bundle = a.b;
        String str3 = facewebUriHandler.a;
        String str4 = str3;
        for (String str32 : bundle.keySet()) {
            str4 = str4.replaceAll("<" + str32 + ">", Uri.encode(StringUtil.m3583a(bundle, str32)));
        }
        Intent component = new Intent().setComponent((ComponentName) facewebUriHandler.b.get());
        component.putExtra("mobile_page", str4);
        component.putExtra("target_fragment", FragmentConstants$ContentFragmentType.FACEWEB_FRAGMENT.ordinal());
        if (Uri.parse(str4).getQueryParameterNames().contains("titlebar_with_modal_done")) {
            component.putExtra("titlebar_with_modal_done", true);
        }
        return component;
    }

    @Nullable
    private static Intent m8643b(String str) {
        Uri parse = Uri.parse(Uri.decode(str));
        if (parse == null || !parse.getScheme().equals("smsto")) {
            return null;
        }
        String[] split = parse.getQuery().split("=");
        if (split.length != 2 || !split[0].equals("sms_body")) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.putExtra("sms_body", split[1]);
        return intent;
    }

    private Intent m8637a(Context context, String str, Uri uri) {
        if (!str.contains(FBLinks.f2153b) || StringUtil.m3589a(uri.getQueryParameter("al_applink_data"))) {
            return null;
        }
        try {
            Intent intent;
            JsonNode jsonNode = (JsonNode) this.f4792e.mo906a(this.f4791d.m7165a(uri.getQueryParameter("al_applink_data")));
            if (jsonNode.mo730d("target_url")) {
                Uri parse = Uri.parse(jsonNode.mo713f("target_url").mo719B());
                this.f4794g.get();
                CharSequence a = AppLinksUtil.a(parse);
                if (!StringUtil.m3589a(a)) {
                    this.f4794g.get();
                    Intent a2 = AppLinksUtil.a(this, context, a);
                    if (a2 != null) {
                        this.f4794g.get();
                        ((AnalyticsLogger) this.f4793f.get()).mo526a(AppLinksUtil.a(jsonNode, parse.toString()));
                    }
                    intent = a2;
                    return intent;
                }
            }
            intent = null;
            return intent;
        } catch (JsonParseException e) {
            BLog.a("Fb4aUriIntentMapper", "The appLinks data passed into the uri was malformed", e);
            return null;
        } catch (Throwable e2) {
            BLog.b("Fb4aUriIntentMapper", "IOError when parsing json", e2);
            return null;
        }
    }

    private Intent m8642b(Context context, String str) {
        Intent a = ((StaticUriIntentMapper) this.f4796i.get()).a(context, str, this.f4810w);
        if (str != null && str.startsWith(FBLinks.f2153b)) {
            HoneyClientEventFast a2;
            if (a != null) {
                a2 = ((DeepLinkLoggingUtils) this.f4805r.get()).a.mo535a("fb_proto_map_success", false);
                if (a2.m17388a()) {
                    if (a.hasExtra("target_fragment")) {
                        a2.m17381a("target_fragment", a.getIntExtra("target_fragment", -1));
                    }
                    if (a.getComponent() != null) {
                        a2.m17385a("mapped_activity", a.getComponent().getClassName());
                    }
                    a2.m17385a("mapped_uri", str);
                    a2.m17390b();
                }
            } else {
                a2 = ((DeepLinkLoggingUtils) this.f4805r.get()).a.mo535a("fb_proto_map_failure", true);
                if (a2.m17388a()) {
                    a2.m17385a("mapped_uri", str);
                    a2.m17390b();
                }
            }
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent m8645c(android.content.Context r10, java.lang.String r11) {
        /*
        r9 = this;
        r0 = r9.f4788A;
        r3 = 0;
        r8 = 0;
        r2 = ":";
        r4 = r11.indexOf(r2);
        if (r4 >= 0) goto L_0x001b;
    L_0x000c:
        r2 = r3;
    L_0x000d:
        r0 = r2;
        r1 = 3;
        r1 = com.facebook.debug.log.BLog.b(r1);
        if (r1 == 0) goto L_0x001a;
    L_0x0015:
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0.getExtras();
    L_0x001a:
        return r0;
    L_0x001b:
        r5 = r11.substring(r8, r4);
        r2 = 1;
    L_0x0020:
        r6 = 3;
        if (r2 > r6) goto L_0x0030;
    L_0x0023:
        r6 = r4 + r2;
        r6 = r11.charAt(r6);
        r7 = 47;
        if (r6 != r7) goto L_0x0030;
    L_0x002d:
        r2 = r2 + 1;
        goto L_0x0020;
    L_0x0030:
        r4 = r4 + r2;
        r2 = "/";
        r2 = r11.endsWith(r2);
        if (r2 == 0) goto L_0x0056;
    L_0x0039:
        r2 = r11.length();
        r2 = r2 + -1;
    L_0x003f:
        r6 = r2 - r4;
        r6 = new char[r6];
        r11.getChars(r4, r2, r6, r8);
        r2 = com.facebook.common.build.BuildConstants.a;
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x0054;
    L_0x004e:
        r2 = com.facebook.crudo.uri.urigenerated.CrudoUriMap.a(r10, r6, r0);
        if (r2 != 0) goto L_0x000d;
    L_0x0054:
        r2 = r3;
        goto L_0x000d;
    L_0x0056:
        r2 = r11.length();
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.Fb4aUriIntentMapper.c(android.content.Context, java.lang.String):android.content.Intent");
    }

    @Nullable
    private Intent m8647d(Context context, String str) {
        if (((ForceMessenger) this.f4789b.get()).a()) {
            return ((DisableMessengerUriIntentBuilder) this.f4799l.get()).a(context, str);
        }
        Intent a = ((MessengerRedirectUriIntentBuilder) this.f4797j.get()).a(context, str);
        if (a != null) {
            ForceMessenger forceMessenger = (ForceMessenger) this.f4789b.get();
            UserStatus a2 = forceMessenger.b.m8681a((String) forceMessenger.d.get());
            HoneyClientEventFast a3 = forceMessenger.a.mo535a("diode_promotion", true);
            if (a3.m17388a()) {
                a3.m17386a("logged_in", a2.f4844a);
                a3.m17385a("other_logged_in", a2.f4846c.toString());
                a3.m17390b();
            }
            a.putExtra("modify_backstack_override", false);
            a.putExtra("prefer_chat_if_possible", !((Boolean) this.f4795h.get()).booleanValue());
            a.putExtra("extra_monotonic_start_timestamp_ms", this.f4790c.now());
            a.putExtra("is_diode", true);
            if (!((ForceMessenger) this.f4789b.get()).a(TriState.valueOf(this.f4808u.m8664a()), true)) {
                return null;
            }
        }
        return a;
    }

    private Intent m8646c(String str) {
        return ((MessengerMSiteUriIntentBuilder) this.f4798k.get()).a(str);
    }
}
