package com.facebook.rtc.assetdownloader;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.zero.rewrite.FbZeroUrlRewriter;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.client.methods.HttpGet;

/* compiled from: local_file_ratio */
public class AssetDownloader {
    private static final Class<?> f9198h = AssetDownloader.class;
    private final Lazy<ExecutorService> f9199a;
    private final Context f9200b;
    private final ZeroUrlRewriter f9201c;
    public final FbSharedPreferences f9202d;
    private final FbHttpRequestProcessor f9203e;
    public final Lazy<ConnectionStatusMonitor> f9204f;
    public final Lazy<FbNetworkManager> f9205g;

    public static AssetDownloader m9542b(InjectorLike injectorLike) {
        return new AssetDownloader((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 3832), (ZeroUrlRewriter) FbZeroUrlRewriter.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2585), IdBasedSingletonScopeProvider.b(injectorLike, 585));
    }

    @Inject
    public AssetDownloader(Context context, Lazy<ExecutorService> lazy, ZeroUrlRewriter zeroUrlRewriter, FbSharedPreferences fbSharedPreferences, FbHttpRequestProcessor fbHttpRequestProcessor, Lazy<ConnectionStatusMonitor> lazy2, Lazy<FbNetworkManager> lazy3) {
        this.f9200b = context;
        this.f9199a = lazy;
        this.f9201c = zeroUrlRewriter;
        this.f9202d = fbSharedPreferences;
        this.f9203e = fbHttpRequestProcessor;
        this.f9204f = lazy2;
        this.f9205g = lazy3;
    }

    public final void m9546a(String str, DownloadListener downloadListener, CallerContext callerContext) {
        if (str != null) {
            Object obj;
            if (((ConnectionStatusMonitor) this.f9204f.get()).mo686b() && ((FbNetworkManager) this.f9205g.get()).d()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                IOException iOException = new IOException("Unable to download file. Not connected.");
                downloadListener.mo736a();
                return;
            }
            ExecutorDetour.a((ExecutorService) this.f9199a.get(), new 1(this, str, downloadListener, callerContext), -369038362);
        }
    }

    @Nullable
    public final File m9545a(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(this.f9200b.getCacheDir(), "fb_voicemail_asset_" + Integer.toString(str.hashCode()));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final boolean m9547b(String str) {
        if (str == null) {
            return false;
        }
        return new File(this.f9200b.getCacheDir(), "fb_voicemail_asset_" + Integer.toString(str.hashCode())).delete();
    }

    public static void m9543b(AssetDownloader assetDownloader, String str, DownloadListener downloadListener, CallerContext callerContext) {
        if (str != null) {
            File a = assetDownloader.m9545a(str);
            if (a == null) {
                try {
                    a = assetDownloader.m9540a(str, callerContext);
                } catch (Exception e) {
                    if (a != null) {
                        a.delete();
                    }
                    downloadListener.mo736a();
                    return;
                }
            }
            downloadListener.mo737a(str, a);
        }
    }

    private File m9540a(String str, CallerContext callerContext) {
        URL url = new URL(this.f9201c.a(str));
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.b = new HttpGet(url.toURI());
        newBuilder = newBuilder;
        newBuilder.c = "voicemail_download";
        newBuilder = newBuilder;
        newBuilder.d = callerContext;
        newBuilder = newBuilder;
        newBuilder.g = new 2(this, str);
        return (File) this.f9203e.a(newBuilder.a());
    }

    public static File m9544c(AssetDownloader assetDownloader, String str) {
        if (str == null) {
            return null;
        }
        return new File(assetDownloader.f9200b.getCacheDir(), "fb_voicemail_asset_" + Integer.toString(str.hashCode()));
    }

    public static PrefKey m9541b(long j) {
        return (PrefKey) SharedPrefKeys.c.a("rtc_voicemail_prompt_url_" + Long.toString(j));
    }
}
