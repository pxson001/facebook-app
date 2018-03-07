package com.facebook.cookiesync;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.cookiesync.CookieSyncUserDataEncryptionGraphQL.FetchEncrytedCookieSyncUserDataString;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.client.methods.HttpGet;

/* compiled from: markStoredNotificationsAsSeen */
public class CookieSyncer implements INeedInit {
    public static final String f8312a = CookieSyncer.class.getSimpleName();
    private static final Map<String, String> f8313b = new Builder().b("ATLAS", "https://cx.atdmt.com").b("LIVERAIL", "https://sync.liverail.com").b();
    private final Context f8314c;
    public final GraphQLQueryExecutor f8315d;
    private final Provider<Boolean> f8316e;
    private final FbHttpRequestProcessor f8317f;
    public final ExecutorService f8318g;
    public CookieManager f8319h;
    public final FbSharedPreferences f8320i;

    public static CookieSyncer m8587b(InjectorLike injectorLike) {
        return new CookieSyncer((Context) injectorLike.getInstance(Context.class, ForAppContext.class), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 3947), FbHttpRequestProcessor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public CookieSyncer(@ForAppContext Context context, GraphQLQueryExecutor graphQLQueryExecutor, Provider<Boolean> provider, FbHttpRequestProcessor fbHttpRequestProcessor, ExecutorService executorService, FbSharedPreferences fbSharedPreferences) {
        this.f8314c = context;
        this.f8315d = graphQLQueryExecutor;
        this.f8316e = provider;
        this.f8317f = fbHttpRequestProcessor;
        this.f8318g = executorService;
        this.f8320i = fbSharedPreferences;
    }

    public void init() {
        if (((Boolean) this.f8316e.get()).booleanValue()) {
            m8588b(this);
            this.f8319h.getCookie(".facebook.com");
            boolean z = false;
            if (!this.f8320i.a(BrowserPrefKey.a, false)) {
                z = true;
            }
            if (z) {
                String str = "ATLAS";
                Futures.a(this.f8315d.a(GraphQLRequest.a((FetchEncrytedCookieSyncUserDataString) new FetchEncrytedCookieSyncUserDataString().a("project", str))), new 1(this, str), this.f8318g);
            }
        }
    }

    public static void m8588b(CookieSyncer cookieSyncer) {
        CookieSyncManager.createInstance(cookieSyncer.f8314c);
        cookieSyncer.f8319h = CookieManager.getInstance();
        cookieSyncer.f8319h.setAcceptCookie(true);
    }

    public static void m8586a(CookieSyncer cookieSyncer, String str, String str2) {
        String str3 = ((String) f8313b.get(str)) + "/?a=" + str2;
        try {
            cookieSyncer.f8317f.a(FbHttpRequest.newBuilder().a(f8312a.toString()).a(CallerContext.a(cookieSyncer.getClass())).a(new HttpGet(str3)).a(RequestPriority.NON_INTERACTIVE).a(new CookieSyncResponseHandler(cookieSyncer, str3)).a());
        } catch (Throwable e) {
            BLog.b(f8312a, e, "Unable to send %s cookie sync request.", new Object[]{str});
        }
    }
}
