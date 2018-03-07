package com.facebook.richdocument.view.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.server.IsRedirectToSandboxEnabled;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.config.InstantArticlesXConfig;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.WebViewBlockDataImpl;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import java.util.EnumSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: open_vertical_action_sheet_tap */
public class WebViewUtils {
    private static final EnumSet<GraphQLDocumentWebviewPresentationStyle> f7070a = EnumSet.of(GraphQLDocumentWebviewPresentationStyle.YOUTUBE, GraphQLDocumentWebviewPresentationStyle.VINE, GraphQLDocumentWebviewPresentationStyle.AD);
    private static WebViewUtils f7071i;
    private static final Object f7072j = new Object();
    private final List<String> f7073b;
    private final LoggedInUserSessionManager f7074c;
    @IsRedirectToSandboxEnabled
    private final Provider<Boolean> f7075d;
    private final ObjectMapper f7076e;
    public final GatekeeperStoreImpl f7077f;
    private final Product f7078g;
    private final AppVersionInfo f7079h;

    private static WebViewUtils m7376b(InjectorLike injectorLike) {
        return new WebViewUtils(LoggedInUserSessionManager.a(injectorLike), IdBasedProvider.a(injectorLike, 3936), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike));
    }

    public static WebViewUtils m7372a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WebViewUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7072j) {
                WebViewUtils webViewUtils;
                if (a2 != null) {
                    webViewUtils = (WebViewUtils) a2.a(f7072j);
                } else {
                    webViewUtils = f7071i;
                }
                if (webViewUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7376b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7072j, b3);
                        } else {
                            f7071i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = webViewUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public WebViewUtils(LoggedInUserAuthDataStore loggedInUserAuthDataStore, Provider<Boolean> provider, ObjectMapper objectMapper, GatekeeperStore gatekeeperStore, XConfigReader xConfigReader, Product product, AppVersionInfo appVersionInfo) {
        this.f7074c = loggedInUserAuthDataStore;
        this.f7075d = provider;
        this.f7076e = objectMapper;
        this.f7077f = gatekeeperStore;
        this.f7079h = appVersionInfo;
        this.f7078g = product;
        this.f7073b = StringUtil.a(xConfigReader.a(InstantArticlesXConfig.d, ""), ',');
    }

    public final void m7378a(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(true);
        if (VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        }
        settings.setUseWideViewPort(false);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
        }
        if (VERSION.SDK_INT >= 21 && this.f7077f.a(692, false)) {
            settings.setMixedContentMode(0);
        }
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(webView.getContext().getDir("appcache", 0).getPath());
        settings.setDatabasePath(webView.getContext().getDir("databases", 0).getPath());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + " " + m7373a(this.f7078g, this.f7079h));
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        m7375a(webView.getContext());
    }

    public static Bundle m7371a() {
        Bundle bundle = new Bundle();
        bundle.putString("Referer", "http://m.facebook.com");
        return bundle;
    }

    private void m7375a(Context context) {
        if (this.f7074c.b()) {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            String a = NetworkLogUrl.a(context, ((Boolean) this.f7075d.get()).booleanValue() ? "http://%s/" : "https://%s/");
            String str = this.f7074c.a().mSessionCookiesString;
            if (str != null) {
                ImmutableList a2 = SessionCookie.a(this.f7076e, str);
                if (a2 != null) {
                    int size = a2.size();
                    for (int i = 0; i < size; i++) {
                        instance.setCookie(a, ((SessionCookie) a2.get(i)).toString());
                    }
                }
            }
            CookieSyncManager.getInstance().sync();
        }
    }

    public final boolean m7381a(BlockData blockData) {
        if (!(blockData instanceof WebViewBlockDataImpl)) {
            return false;
        }
        WebViewBlockDataImpl webViewBlockDataImpl = (WebViewBlockDataImpl) blockData;
        return m7380a(webViewBlockDataImpl.f5803g, webViewBlockDataImpl.f5804h);
    }

    public final boolean m7380a(GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle, GraphQLDocumentElementMarginStyle graphQLDocumentElementMarginStyle) {
        if (!f7070a.contains(graphQLDocumentWebviewPresentationStyle)) {
            Object obj = (graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.HTML_INTERACTIVE || graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.SOCIAL_EMBED || graphQLDocumentWebviewPresentationStyle == GraphQLDocumentWebviewPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? 1 : null;
            if (obj == null || !(graphQLDocumentElementMarginStyle == GraphQLDocumentElementMarginStyle.FULL_BLEED || graphQLDocumentElementMarginStyle == GraphQLDocumentElementMarginStyle.AUTO)) {
                return false;
            }
        }
        return true;
    }

    public final boolean m7379a(Uri uri) {
        Object obj;
        List<String> list = this.f7073b;
        if (uri == null || uri.getHost() == null) {
            obj = null;
        } else {
            String host = uri.getHost();
            for (String endsWith : list) {
                if (host.endsWith(endsWith)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
        }
        return obj == null;
    }

    public static void m7377b(WebView webView) {
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.resumeTimers();
                webView.setTag(null);
                webView.clearHistory();
                webView.removeAllViews();
                webView.setOnTouchListener(null);
                webView.clearView();
                webView.onPause();
                webView.destroy();
                if (webView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                }
            } catch (Exception e) {
            }
        }
    }

    private static String m7373a(Product product, AppVersionInfo appVersionInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%s/%s;%s/%s;", "FBIA", m7374a(product.name()), "FBAV", m7374a(appVersionInfo.a())));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m7374a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return StringUtil.e(str).replace("/", "-").replace(";", "-");
    }
}
