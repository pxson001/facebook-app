package com.facebook.intent.thirdparty;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: gravity_suggestifier_id */
public class NativeThirdPartyUriHelper {
    public static final Class<?> f21816a = NativeThirdPartyUriHelper.class;
    private static NavigationLogger f21817b = null;

    public static boolean m29571a(@Nullable String str) {
        return str != null && str.startsWith("fbrpc://facebook/nativethirdparty");
    }

    public static boolean m29569a(Uri uri) {
        return uri != null && m29571a(uri.toString());
    }

    @Nullable
    public static Intent m29560a(Context context, NativeUri nativeUri) {
        Object obj = null;
        Uri parse = Uri.parse(nativeUri.a);
        if (!m29569a(parse)) {
            return null;
        }
        boolean a = m29570a(parse, "direct_deeplink");
        boolean a2 = m29570a(parse, "direct_install");
        TapBehavior fromString = TapBehavior.fromString(parse.getQueryParameter("tap_behavior"));
        AppSites e = m29581e(parse);
        Object obj2 = (a || fromString.shouldAllowOpenInNativeAppIfInstalled()) ? 1 : null;
        Parcelable a3 = m29558a(context, parse, e, nativeUri.d);
        if (a3 == null || obj2 == null) {
            if (a2 || fromString.shouldGoToMarketIfAppNotInstalled()) {
                obj = 1;
            }
            Intent a4 = m29557a(context, parse, e);
            if (a4 == null || r1 == null) {
                Intent b = m29572b(context, parse, e);
                if (b != null && m29570a(parse, "embed_app_intent")) {
                    if (a3 != null) {
                        b.putExtra("extra_app_intent", a3);
                    } else if (a4 != null) {
                        b.putExtra("extra_install_intent", a4);
                    }
                }
                return b;
            } else if (a2 || !fromString.shouldShowInterstitialForInstall()) {
                return a4;
            } else {
                return m29582f(context, parse);
            }
        } else if (a || !fromString.shouldShowInterstitialForOpen()) {
            return a3;
        } else {
            return m29582f(context, parse);
        }
    }

    public static Intent m29554a(Context context, Uri uri) {
        Builder f = NativeUri.f();
        f.a = uri.toString();
        return m29560a(context, f.a());
    }

    private static boolean m29570a(Uri uri, String str) {
        Object queryParameter = uri.getQueryParameter(str);
        return !TextUtils.isEmpty(queryParameter) && Boolean.parseBoolean(queryParameter);
    }

    private static Intent m29582f(Context context, Uri uri) {
        ChooserActivityIntent chooserActivityIntent = new ChooserActivityIntent(context, ThirdPartyUriActivity.class);
        chooserActivityIntent.setData(uri);
        return chooserActivityIntent;
    }

    public static AppSites m29581e(Uri uri) {
        String queryParameter = uri.getQueryParameter("appsite_data");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                return (AppSites) FbObjectMapper.m6612i().m6657a(queryParameter, AppSites.class);
            } catch (Throwable e) {
                BLog.b(f21816a, "Error parsing appsites", e);
            }
        }
        return null;
    }

    public static Intent m29578d(Context context, Uri uri) {
        if (!"fbrpc".equals(uri.getScheme()) || !"facebook".equals(uri.getHost()) || !"/nativethirdparty".equals(uri.getPath())) {
            return null;
        }
        AppSites appSites;
        String queryParameter = uri.getQueryParameter("appsite_data");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                appSites = (AppSites) FbObjectMapper.m6612i().m6657a(queryParameter, AppSites.class);
            } catch (Throwable e) {
                BLog.b(f21816a, "Error parsing appsites", e);
            }
            return m29575c(context, uri, appSites);
        }
        appSites = null;
        return m29575c(context, uri, appSites);
    }

    public static boolean m29567a(Context context, @Nullable String str) {
        boolean z = false;
        for (String packageInfo : m29574b(m29573b(str))) {
            try {
                context.getPackageManager().getPackageInfo(packageInfo, 1);
                z = true;
            } catch (NameNotFoundException e) {
            }
        }
        return z;
    }

    public static Collection<String> m29574b(Uri uri) {
        AppSites appSites = null;
        if (uri == null) {
            return null;
        }
        CharSequence queryParameter;
        HashSet hashSet = new HashSet();
        String queryParameter2 = uri.getQueryParameter("appsite_data");
        if (!TextUtils.isEmpty(queryParameter2)) {
            try {
                appSites = (AppSites) FbObjectMapper.m6612i().m6657a(queryParameter2, AppSites.class);
            } catch (Throwable e) {
                BLog.b(f21816a, "Error parsing appsites", e);
            }
        }
        if (!(appSites == null || appSites.appSites == null || appSites.appSites.isEmpty())) {
            for (AppSiteData appSiteData : appSites.appSites) {
                if (!TextUtils.isEmpty(appSiteData.packageName)) {
                    hashSet.add(appSiteData.packageName);
                }
            }
        }
        if (hashSet.isEmpty()) {
            Uri b = m29573b(uri.getQueryParameter("market_uri"));
            if (b != null) {
                queryParameter = b.getQueryParameter("id");
                if (!TextUtils.isEmpty(queryParameter)) {
                    hashSet.add(queryParameter);
                }
            }
        }
        if (hashSet.isEmpty()) {
            queryParameter = uri.getQueryParameter("package_name");
            if (!TextUtils.isEmpty(queryParameter)) {
                hashSet.add(queryParameter);
            }
        }
        return hashSet;
    }

    public static MobileStoreObjectInvalidationBehavior m29576c(Uri uri) {
        if (uri == null) {
            return null;
        }
        return MobileStoreObjectInvalidationBehavior.fromString(uri.getQueryParameter("invalidation_behavior"));
    }

    public static Intent m29556a(Context context, Uri uri, Uri uri2, Uri uri3, PackageManager packageManager) {
        int i = 0;
        Intent intent = new Intent("android.intent.action.VIEW", uri3);
        if (uri3 == null || packageManager.resolveActivity(intent, 0) == null) {
            if (uri2 != null) {
                i = 1;
                uri3 = uri2;
            } else {
                uri3 = uri;
            }
        }
        if (i != 0) {
            return m29554a(context, uri3);
        }
        return new Intent("android.intent.action.VIEW").setData(uri3);
    }

    public static void m29565a(Context context, Intent intent) {
        m29566a(context, intent, null);
    }

    public static void m29566a(Context context, Intent intent, @Nullable Map<String, Object> map) {
        if (intent instanceof FbrpcIntent) {
            FbrpcIntent fbrpcIntent = (FbrpcIntent) intent;
            HoneyClientEvent a = m29564a(fbrpcIntent, (Map) map);
            if (a != null) {
                a.m5090b("target", intent.hasExtra("access_token") ? "app" : "market");
                Uri data = intent.getData();
                if (data != null) {
                    a.m5090b("dest_uri", data.toString());
                }
                Uri uri = fbrpcIntent.a;
                if (uri != null) {
                    a.m5085a("fbrpc", m29585h(uri));
                    Object queryParameter = uri.getQueryParameter("has_app_link");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        a.m5090b("has_app_link", queryParameter);
                    }
                }
                if (f21817b == null) {
                    f21817b = NavigationLogger.m5475a(FbInjector.get(context));
                }
                a.f3099c = m29577c(a.f3099c);
                if (a.f3099c == null) {
                    a.f3099c = NavigationLogger.m5480a(context);
                }
                f21817b.m5505a(context, a);
            }
        } else if (intent instanceof ChooserActivityIntent) {
            LoggingParams loggingParams;
            String str = "extra_logging_params";
            if (map == null) {
                loggingParams = null;
            } else {
                boolean equals = Boolean.TRUE.equals(map.get("sponsored"));
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                for (Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof JsonNode) {
                        bundle.putString((String) entry.getKey(), value.toString());
                    } else {
                        bundle2.putString((String) entry.getKey(), entry.getValue().toString());
                    }
                }
                loggingParams = new LoggingParams(equals, bundle, bundle2);
            }
            intent.putExtra(str, loggingParams);
        }
    }

    private static String m29577c(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("nf") || str.equals("feed")) {
            return "native_newsfeed".toString();
        }
        if (str.equals("bookmark")) {
            return "sidebar_menu".toString();
        }
        return str;
    }

    private static HoneyClientEvent m29564a(FbrpcIntent fbrpcIntent, Map<String, Object> map) {
        long longExtra = fbrpcIntent.getLongExtra("app_id", 0);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("open_application");
        if (longExtra != 0) {
            honeyClientEvent.m5097j(Long.toString(longExtra));
            honeyClientEvent.m5084a("app_id", longExtra);
        }
        String stringExtra = fbrpcIntent.getStringExtra("unit_type");
        if (stringExtra != null) {
            honeyClientEvent.m5090b("unit_type", stringExtra);
        }
        stringExtra = fbrpcIntent.getStringExtra("application_link_type");
        if (stringExtra != null) {
            honeyClientEvent.m5090b("application_link_type", stringExtra);
        }
        stringExtra = fbrpcIntent.getStringExtra("is_app_link");
        if (stringExtra != null) {
            honeyClientEvent.m5090b("is_app_link", stringExtra);
        }
        stringExtra = fbrpcIntent.getStringExtra("ref");
        if (stringExtra != null) {
            honeyClientEvent.f3099c = stringExtra;
        }
        if (fbrpcIntent.getBooleanExtra("extra_direct_installs_enabled", false)) {
            honeyClientEvent.m5087a("direct_install_intent", true);
        }
        if (map != null) {
            if (Boolean.TRUE.equals(map.get("sponsored"))) {
                honeyClientEvent.mo699b(true);
            } else {
                honeyClientEvent.mo699b(false);
            }
            if (Boolean.TRUE.equals(map.get("cta_click"))) {
                honeyClientEvent.m5087a("cta_click", true);
            }
            for (Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (!"temporary_parameters".equals(entry.getKey())) {
                    if (value instanceof JsonNode) {
                        honeyClientEvent.m5085a((String) entry.getKey(), (JsonNode) value);
                    } else {
                        honeyClientEvent.m5090b((String) entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        }
        return honeyClientEvent;
    }

    public static Intent m29557a(Context context, Uri uri, AppSites appSites) {
        String str;
        Uri uri2;
        PackageManager packageManager = context.getPackageManager();
        Uri b = m29573b(uri.getQueryParameter("market_uri"));
        String queryParameter = uri.getQueryParameter("ref");
        String queryParameter2 = uri.getQueryParameter("app_name");
        if (b == null) {
            if (!(appSites == null || appSites.appSites == null)) {
                for (AppSiteData appSiteData : appSites.appSites) {
                    Uri b2 = m29573b(appSiteData.marketUri);
                    if (b2 != null) {
                        queryParameter2 = appSiteData.appName;
                        str = appSiteData.isAppLink;
                        String str2 = queryParameter2;
                        uri2 = b2;
                        Object obj = str2;
                        break;
                    }
                    b = b2;
                }
            }
            String str3 = queryParameter2;
            uri2 = b;
            str = null;
            if (uri2 == null) {
                return null;
            }
        }
        obj = queryParameter2;
        uri2 = b;
        str = null;
        String queryParameter3 = uri2.getQueryParameter("id");
        Intent fbrpcIntent = new FbrpcIntent("android.intent.action.VIEW", uri2);
        fbrpcIntent.a = uri;
        if (str != null) {
            fbrpcIntent.putExtra("is_app_link", str);
        }
        fbrpcIntent.addFlags(268435456);
        if (!TextUtils.isEmpty(obj)) {
            fbrpcIntent.putExtra("extra_app_name", obj);
        }
        if (packageManager.resolveActivity(fbrpcIntent, 65536) == null) {
            return null;
        }
        AppLinkData f = m29583f(uri);
        try {
            ObjectMapper i = FbObjectMapper.m6612i();
            Object e = i.m6668e();
            JsonNode e2 = i.m6668e();
            e.m5137a("version", "2");
            e2.m5137a("method", "applink");
            e.m5143c("bridge_args", e2);
            if (f.f != null) {
                e.m5143c("method_args", f.f);
            } else {
                e.m5143c("method_args", i.m6668e());
            }
            InstallData.a(i.m6659a(e), queryParameter3, context);
        } catch (Throwable e3) {
            BLog.b(f21816a, "Error persisting install data", e3);
        }
        fbrpcIntent.putExtra("application_link_type", "app_store");
        fbrpcIntent.putExtra("ref", queryParameter);
        fbrpcIntent.putExtra("unit_type", "single_app_install");
        fbrpcIntent.putExtra("package_name", queryParameter3);
        return m29562a(uri.getQueryParameter("app_id"), fbrpcIntent);
    }

    public static Intent m29572b(Context context, Uri uri, AppSites appSites) {
        Intent e = m29580e(context, uri);
        if (e != null) {
            return e;
        }
        if (!(appSites == null || appSites.appSites == null)) {
            for (AppSiteData appSiteData : appSites.appSites) {
                Uri b = m29573b(appSiteData.fallbackUrl);
                if (b != null) {
                    e = m29555a(context, b, uri);
                    if (e != null) {
                        return e;
                    }
                }
            }
        }
        return null;
    }

    public static Intent m29580e(Context context, Uri uri) {
        Intent a = m29555a(context, m29573b(uri.getQueryParameter("target_url")), uri);
        if (a != null) {
            return a;
        }
        Intent a2;
        int i = 0;
        do {
            Uri b = m29573b(uri.getQueryParameter("fallback_url" + i));
            i++;
            if (b == null) {
                return null;
            }
            a2 = m29555a(context, b, uri);
        } while (a2 == null);
        return a2;
    }

    public static Uri m29579d(Uri uri) {
        return m29573b(uri.getQueryParameter("target_url"));
    }

    private static Intent m29555a(Context context, Uri uri, Uri uri2) {
        if (uri == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent fbrpcIntent = new FbrpcIntent("android.intent.action.VIEW", uri);
        fbrpcIntent.a = uri2;
        if (packageManager.resolveActivity(fbrpcIntent, 65536) == null) {
            return null;
        }
        fbrpcIntent.putExtra("application_link_type", "web");
        fbrpcIntent.putExtra("ref", uri2.getQueryParameter("ref"));
        m29562a(uri2.getQueryParameter("app_id"), fbrpcIntent);
        return fbrpcIntent;
    }

    private static Intent m29559a(Context context, Uri uri, AppSites appSites, AppLinkData appLinkData) {
        Intent fbrpcIntent;
        ResolveInfo resolveActivity;
        String str = appLinkData.c;
        String str2 = appLinkData.e;
        if (!(appSites == null || appSites.appSites == null || appSites.appSites.isEmpty())) {
            for (AppSiteData appSiteData : appSites.appSites) {
                if (!TextUtils.isEmpty(appSiteData.packageName)) {
                    if (!TextUtils.isEmpty(appSiteData.appSite)) {
                        fbrpcIntent = new FbrpcIntent("com.facebook.application." + (str != null ? str : ""), m29573b(str2));
                        fbrpcIntent.setComponent(new ComponentName(appSiteData.packageName, appSiteData.appSite));
                    } else if (TextUtils.isEmpty(appSiteData.appSiteUrl)) {
                        fbrpcIntent = new FbrpcIntent("android.intent.action.VIEW", m29573b(str2));
                    } else {
                        Uri i;
                        String str3;
                        Uri parse = Uri.parse(appSiteData.appSiteUrl);
                        if ("telprompt".equals(parse.getScheme())) {
                            i = m29586i(parse);
                            str3 = "android.intent.action.DIAL";
                        } else if ("tel".equals(parse.getScheme())) {
                            String str4 = context.getPackageManager().checkPermission("android.permission.CALL_PHONE", context.getPackageName()) == 0 ? "android.intent.action.CALL" : "android.intent.action.DIAL";
                            Uri i2 = m29586i(parse);
                            str3 = str4;
                            i = i2;
                        } else {
                            String str5 = "android.intent.action.VIEW";
                            if (str2 != null) {
                                i = parse.buildUpon().appendQueryParameter("target_url", str2).build();
                                str3 = str5;
                            } else {
                                i = parse;
                                str3 = str5;
                            }
                        }
                        fbrpcIntent = new FbrpcIntent(str3, i);
                    }
                    fbrpcIntent.addFlags(268435456);
                    if (!TextUtils.isEmpty(appSiteData.appName)) {
                        fbrpcIntent.putExtra("extra_app_name", appSiteData.appName);
                    }
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(fbrpcIntent, 65536);
                    if (!(queryIntentActivities == null || queryIntentActivities.isEmpty())) {
                        fbrpcIntent.putExtra("is_app_link", appSiteData.isAppLink);
                        if ("android.intent.action.DIAL".equals(fbrpcIntent.getAction()) || "android.intent.action.CALL".equals(fbrpcIntent.getAction())) {
                            return fbrpcIntent;
                        }
                        if (fbrpcIntent.getComponent() == null) {
                            for (ResolveInfo resolveActivity2 : queryIntentActivities) {
                                if (resolveActivity2.activityInfo.packageName.equals(appSiteData.packageName)) {
                                    fbrpcIntent.setComponent(new ComponentName(resolveActivity2.activityInfo.packageName, resolveActivity2.activityInfo.name));
                                    break;
                                }
                            }
                        }
                        if (fbrpcIntent.getComponent() != null) {
                            fbrpcIntent.a = uri;
                            if (appSiteData.keyHashes == null || appSiteData.keyHashes.isEmpty()) {
                                return fbrpcIntent;
                            }
                            try {
                                if (m29568a(context.getPackageManager().getPackageInfo(appSiteData.packageName, 64), appSiteData.keyHashes)) {
                                    return fbrpcIntent;
                                }
                            } catch (NameNotFoundException e) {
                                new StringBuilder("Could not find package for ").append(appSiteData.packageName);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        PackageManager packageManager = context.getPackageManager();
        String queryParameter = uri.getQueryParameter("package_name");
        Object queryParameter2 = uri.getQueryParameter("class_name");
        List g = m29584g(uri);
        if (!TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2)) {
            try {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(queryParameter);
                if (launchIntentForPackage != null) {
                    fbrpcIntent = new FbrpcIntent(launchIntentForPackage);
                    fbrpcIntent.a = uri;
                    if (g == null || g.isEmpty() || m29568a(packageManager.getPackageInfo(queryParameter, 64), g)) {
                        return fbrpcIntent;
                    }
                }
            } catch (Exception e2) {
                new StringBuilder("No launch intent found, or could not verify signatures for ").append(queryParameter);
            }
        }
        if (g.size() == 0) {
            BLog.b(f21816a, "Native application url did not specify Android key hash.");
            return null;
        } else if (TextUtils.isEmpty(queryParameter) != TextUtils.isEmpty(queryParameter2)) {
            BLog.b(f21816a, "Native application url specified a class_name, but no package_name. Neither or bothmust be specified in the legacy case.");
            return null;
        } else {
            StringBuilder stringBuilder = new StringBuilder("com.facebook.application.");
            if (str == null) {
                str = "";
            }
            fbrpcIntent = new FbrpcIntent(stringBuilder.append(str).toString(), m29573b(str2));
            fbrpcIntent.a = uri;
            fbrpcIntent.addFlags(268435456);
            if (!TextUtils.isEmpty(queryParameter)) {
                fbrpcIntent.setComponent(new ComponentName(queryParameter, queryParameter2));
            }
            queryParameter2 = uri.getQueryParameter("app_name");
            if (!TextUtils.isEmpty(queryParameter2)) {
                fbrpcIntent.putExtra("extra_app_name", queryParameter2);
            }
            resolveActivity2 = packageManager.resolveActivity(fbrpcIntent, 65536);
            if (resolveActivity2 == null) {
                return null;
            }
            if (TextUtils.isEmpty(queryParameter)) {
                PackageItemInfo packageItemInfo = resolveActivity2.activityInfo;
                if (packageItemInfo == null) {
                    BLog.b(f21816a, "Native application url referenced ResolveInfo that has null activityInfo.");
                    return null;
                }
                queryParameter = packageItemInfo.packageName;
                if (queryParameter == null) {
                    BLog.b(f21816a, "Native application url referenced ActivityInfo that has null packageName.");
                    return null;
                }
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(queryParameter, 64);
            } catch (NameNotFoundException e3) {
            }
            if (packageInfo == null) {
                BLog.b(f21816a, "Could not getPackageInfo for package: '" + queryParameter + "'.");
                return null;
            } else if (m29568a(packageInfo, g)) {
                return fbrpcIntent;
            } else {
                BLog.b(f21816a, "Could not verify signature for package: '" + queryParameter + "'.");
                return null;
            }
        }
    }

    private static AppLinkData m29583f(Uri uri) {
        JsonNode a;
        AppLinkData appLinkData;
        String queryParameter;
        JsonNode jsonNode = null;
        String queryParameter2 = uri.getQueryParameter("extra_applink_key");
        if (queryParameter2 == null) {
            queryParameter2 = "applink_data";
        }
        Object queryParameter3 = uri.getQueryParameter(queryParameter2);
        if (!TextUtils.isEmpty(queryParameter3)) {
            try {
                a = FbObjectMapper.m6612i().m6637a(queryParameter3.getBytes());
            } catch (Throwable e) {
                BLog.b(f21816a, "Error parsing applink", e);
            }
            appLinkData = new AppLinkData();
            appLinkData.f = a;
            if (a == null && a.mo730d("target_url")) {
                appLinkData.e = a.mo709b("target_url").mo719B();
            } else {
                appLinkData.e = uri.getQueryParameter("target_url");
            }
            queryParameter = uri.getQueryParameter("referer_data_key");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = "referer_data";
            }
            if (a != null) {
                jsonNode = a.mo709b(queryParameter);
            }
            if (jsonNode == null && jsonNode.mo730d("fb_app_id")) {
                appLinkData.c = jsonNode.mo709b("fb_app_id").mo719B();
            } else {
                appLinkData.c = uri.getQueryParameter("app_id");
            }
            if (jsonNode == null && jsonNode.mo730d("fb_access_token")) {
                appLinkData.a = jsonNode.mo709b("fb_access_token").mo719B();
            } else {
                appLinkData.a = uri.getQueryParameter("access_token");
            }
            if (jsonNode == null && jsonNode.mo730d("fb_expires_in")) {
                appLinkData.b = jsonNode.mo709b("fb_expires_in").mo719B();
            } else {
                appLinkData.b = uri.getQueryParameter("expires_in");
            }
            if (jsonNode == null && jsonNode.mo730d("fb_ref")) {
                appLinkData.d = jsonNode.mo709b("fb_ref").mo719B();
            } else {
                appLinkData.d = uri.getQueryParameter("ref");
            }
            return appLinkData;
        }
        a = null;
        appLinkData = new AppLinkData();
        appLinkData.f = a;
        if (a == null) {
        }
        appLinkData.e = uri.getQueryParameter("target_url");
        queryParameter = uri.getQueryParameter("referer_data_key");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = "referer_data";
        }
        if (a != null) {
            jsonNode = a.mo709b(queryParameter);
        }
        if (jsonNode == null) {
        }
        appLinkData.c = uri.getQueryParameter("app_id");
        if (jsonNode == null) {
        }
        appLinkData.a = uri.getQueryParameter("access_token");
        if (jsonNode == null) {
        }
        appLinkData.b = uri.getQueryParameter("expires_in");
        if (jsonNode == null) {
        }
        appLinkData.d = uri.getQueryParameter("ref");
        return appLinkData;
    }

    public static Intent m29575c(Context context, Uri uri, AppSites appSites) {
        return m29558a(context, uri, appSites, null);
    }

    private static Intent m29558a(Context context, Uri uri, AppSites appSites, @Nullable NativeAppDetails nativeAppDetails) {
        AppLinkData f = m29583f(uri);
        String queryParameter = uri.getQueryParameter("extra_applink_key");
        if (queryParameter == null) {
            queryParameter = "applink_data";
        }
        String str = f.c;
        Intent a = m29559a(context, uri, appSites, f);
        if (a == null) {
            return null;
        }
        a.putExtra("access_token", f.a);
        a.putExtra("expires_in", f.b);
        a.putExtra("application_link_type", "native");
        a.putExtra("unit_type", "app_launch");
        a.putExtra("ref", f.d);
        if (f.f != null) {
            try {
                a.putExtra(queryParameter, m29563a(f.f));
            } catch (Throwable e) {
                BLog.b(f21816a, "Error writing applink data as json", e);
            }
        }
        if (nativeAppDetails != null && nativeAppDetails.a()) {
            m29561a(a);
        }
        return m29562a(str, a);
    }

    private static Bundle m29563a(JsonNode jsonNode) {
        Bundle bundle = new Bundle();
        Iterator H = jsonNode.mo705H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            String str = (String) entry.getKey();
            JsonNode jsonNode2 = (JsonNode) entry.getValue();
            if (jsonNode2.m5193f()) {
                bundle.putString(str, jsonNode2.mo719B());
            } else if (jsonNode2.m5197i()) {
                bundle.putBundle(str, m29563a(jsonNode2));
            } else if (!jsonNode2.m5196h()) {
                BLog.a(f21816a, "Unsupported value type in bundle for key %s with value %s", new Object[]{str, jsonNode2.toString()});
            } else if (jsonNode2.mo712e() == 0) {
                bundle.putStringArray(str, new String[0]);
            } else if (jsonNode2.mo708a(0).m5193f()) {
                String[] strArr = new String[jsonNode2.mo712e()];
                for (r2 = 0; r2 < jsonNode2.mo712e(); r2++) {
                    strArr[r2] = jsonNode2.mo708a(r2).mo719B();
                }
                bundle.putStringArray(str, strArr);
            } else {
                Parcelable[] parcelableArr = new Bundle[jsonNode2.mo712e()];
                for (r2 = 0; r2 < jsonNode2.mo712e(); r2++) {
                    parcelableArr[r2] = m29563a(jsonNode2.mo708a(r2));
                }
                bundle.putParcelableArray(str, parcelableArr);
            }
        }
        return bundle;
    }

    private static boolean m29568a(PackageInfo packageInfo, List<String> list) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return false;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            for (Signature signature : signatureArr) {
                instance.reset();
                instance.update(signature.toByteArray());
                String encodeToString = Base64.encodeToString(instance.digest(), 3);
                for (int i = 0; i < list.size(); i++) {
                    if (encodeToString.equals(list.get(i))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            BLog.b("Facebook-IntentUriHandler", "Failed to instantiate SHA-1 algorithm.");
            return false;
        }
    }

    private static List<String> m29584g(Uri uri) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            Object queryParameter = uri.getQueryParameter("key_hash" + i);
            if (queryParameter == null) {
                return arrayList;
            }
            int indexOf = queryParameter.indexOf(61);
            if (indexOf >= 0) {
                queryParameter = queryParameter.substring(0, indexOf);
            }
            arrayList.add(queryParameter);
            i++;
        }
    }

    private static Intent m29561a(Intent intent) {
        intent.putExtra("extra_direct_installs_enabled", true);
        return intent;
    }

    private static Intent m29562a(String str, Intent intent) {
        if (str == null) {
            return intent;
        }
        try {
            intent.putExtra("app_id", Long.parseLong(str));
            return intent;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static ObjectNode m29585h(Uri uri) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            int i = 0;
            while (i < encodedQuery.length()) {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 == -1 || indexOf2 > indexOf) {
                    indexOf2 = indexOf;
                }
                int i2 = indexOf2 + 1;
                if (i < indexOf2) {
                    String decode = Uri.decode(encodedQuery.substring(i, indexOf2));
                    String str = "";
                    if (i2 < indexOf) {
                        str = Uri.decode(encodedQuery.substring(i2, indexOf));
                    }
                    objectNode.m5137a(decode, str);
                }
                i = indexOf + 1;
            }
        }
        return objectNode;
    }

    public static Uri m29573b(String str) {
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    private static Uri m29586i(Uri uri) {
        if (uri.getHost() != null) {
            return Uri.parse("tel:" + uri.getHost());
        }
        if (uri.getSchemeSpecificPart() != null) {
            return Uri.parse("tel:" + uri.getSchemeSpecificPart());
        }
        return null;
    }
}
