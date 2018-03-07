package com.facebook.http.common;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import com.facebook.common.util.TriState;
import com.facebook.http.annotations.AllowFbClientConnManagerWakeLocks;
import com.facebook.http.annotations.DefaultRedirect;
import com.facebook.http.annotations.DefaultRetryHandler;
import com.facebook.http.annotations.FallbackHttpClient;
import com.facebook.http.annotations.IsArtilleryTracingEnabled;
import com.facebook.http.annotations.IsPhpProfilingEnabled;
import com.facebook.http.annotations.IsTeakProfilingEnabled;
import com.facebook.http.annotations.IsWirehogProfilingEnabled;
import com.facebook.http.annotations.MaxRedirects;
import com.facebook.http.annotations.SslSocketFactory;
import com.facebook.http.config.DefaultNetworkConfig;
import com.facebook.http.config.NetworkConfig;
import com.facebook.http.enginehooks.DefaultOpenConnectionEventListenerProvider;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ssl.SSLSocketFactoryHelper;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

@InjectorModule
/* compiled from: removedprefilledtags */
public class FbHttpModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static DefaultOpenConnectionEventListenerProvider m12163a() {
        return new DefaultOpenConnectionEventListenerProvider();
    }

    @ProviderMethod
    @IsPhpProfilingEnabled
    public static Boolean m12164a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(InternalHttpPrefKeys.f2507b, false));
    }

    @IsTeakProfilingEnabled
    @ProviderMethod
    public static Boolean m12170b(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(InternalHttpPrefKeys.f2509d, false));
    }

    @ProviderMethod
    @IsArtilleryTracingEnabled
    public static Boolean m12172c(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(InternalHttpPrefKeys.f2511f, false));
    }

    @IsWirehogProfilingEnabled
    @ProviderMethod
    public static Boolean m12174d(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(InternalHttpPrefKeys.f2508c, false));
    }

    @ProviderMethod
    @MaxRedirects
    public static Integer m12171b() {
        return Integer.valueOf(3);
    }

    @ProviderMethod
    public static SchemeRegistry m12166a(SocketFactory socketFactory) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", socketFactory, 443));
        return schemeRegistry;
    }

    @ProviderMethod
    static HttpParams m12169a(DefaultSocketConfig defaultSocketConfig, String str, DefaultNetworkConfig defaultNetworkConfig) {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, defaultSocketConfig.m12345a());
        HttpConnectionParams.setSoTimeout(basicHttpParams, defaultSocketConfig.m12346b());
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        HttpHost httpHost = defaultNetworkConfig.f7810j;
        if (httpHost != null) {
            basicHttpParams.setParameter("http.route.default-proxy", httpHost);
        }
        return basicHttpParams;
    }

    @ProviderMethod
    @SslSocketFactory
    static SocketFactory m12168a(String str, NetworkConfig networkConfig, Context context, Provider<Boolean> provider, SSLSocketFactoryHelper sSLSocketFactoryHelper) {
        Context applicationContext = context.getApplicationContext();
        if (!networkConfig.f7807g) {
            return TrustNonFacebookSocketFactory.a();
        }
        if (((Boolean) provider.get()).booleanValue()) {
            return sSLSocketFactoryHelper.a(m12167a(applicationContext, str));
        }
        AndroidHttpClient newInstance = AndroidHttpClient.newInstance(str);
        SocketFactory socketFactory = newInstance.getConnectionManager().getSchemeRegistry().get("https").getSocketFactory();
        newInstance.close();
        return sSLSocketFactoryHelper.a(socketFactory);
    }

    private static SocketFactory m12167a(Context context, String str) {
        try {
            AndroidHttpClient androidHttpClient = (AndroidHttpClient) AndroidHttpClient.class.getMethod("newInstance", new Class[]{String.class, Context.class}).invoke(null, new Object[]{str, context});
            SocketFactory socketFactory = androidHttpClient.getConnectionManager().getSchemeRegistry().get("https").getSocketFactory();
            androidHttpClient.close();
            return socketFactory;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
    }

    @ProviderMethod
    static DefaultSocketConfig m12162a(TriState triState) {
        if (triState.asBoolean(false)) {
            return new ReducedTimeoutSocketConfig();
        }
        return new DefaultSocketConfig();
    }

    @ProviderMethod
    @FallbackHttpClient
    public static HttpClient m12165a(String str) {
        return AndroidHttpClient.newInstance(str);
    }

    @ProviderMethod
    @Singleton
    @DefaultRedirect
    static RedirectHandler m12173c() {
        return new DefaultRedirectHandler();
    }

    @ProviderMethod
    @DefaultRetryHandler
    static HttpRequestRetryHandler m12175d() {
        return new DefaultHttpRequestRetryHandler();
    }

    @ProviderMethod
    @AllowFbClientConnManagerWakeLocks
    public static Boolean m12176f() {
        return Boolean.valueOf(true);
    }
}
