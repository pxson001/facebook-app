package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.C1945h.C19417;
import com.facebook.ads.internal.util.C1980f;
import com.facebook.ads.internal.util.C1984h;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class C1909j extends InterstitialAdapter {
    private final String f14029a = UUID.randomUUID().toString();
    private Context f14030b;
    private boolean f14031c;
    private int f14032d;
    private int f14033e;
    private boolean f14034f;
    private C1897d f14035g;
    public C19417 f14036h;
    private boolean f14037i = false;
    private C1912l f14038j;
    private WebView f14039k;

    class C19081 extends WebChromeClient {
        final /* synthetic */ C1909j f14028a;

        C19081(C1909j c1909j) {
            this.f14028a = c1909j;
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i == 100 && this.f14028a.f14036h != null) {
                this.f14028a.f14036h.m14356a(this.f14028a);
            }
        }
    }

    private void m14250a(C1912l c1912l) {
        if (c1912l != null) {
            this.f14039k = new WebView(this.f14030b.getApplicationContext());
            this.f14039k.setWebChromeClient(new C19081(this));
            this.f14039k.loadDataWithBaseURL(C1984h.m14467a(), c1912l.f14042a, "text/html", "utf-8", null);
        }
    }

    public final void mo710a(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map) {
        this.f14030b = context;
        this.f14036h = interstitialAdapterListener;
        this.f14038j = C1912l.m14296a((JSONObject) map.get("data"));
        if (C1980f.m14454a(context, this.f14038j)) {
            AdError adError = AdError.f13883b;
            interstitialAdapterListener.m14357b(this);
            return;
        }
        this.f14035g = new C1897d(context, this.f14029a, this, this.f14036h);
        BroadcastReceiver broadcastReceiver = this.f14035g;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + broadcastReceiver.f13987a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + broadcastReceiver.f13987a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + broadcastReceiver.f13987a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + broadcastReceiver.f13987a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + broadcastReceiver.f13987a);
        LocalBroadcastManager.a(broadcastReceiver.f13988b).a(broadcastReceiver, intentFilter);
        this.f14037i = true;
        Map map2 = this.f14038j.f14048g;
        if (map2.containsKey("is_tablet")) {
            this.f14031c = Boolean.parseBoolean((String) map2.get("is_tablet"));
        }
        if (map2.containsKey("ad_height")) {
            this.f14032d = Integer.parseInt((String) map2.get("ad_height"));
        }
        if (map2.containsKey("ad_width")) {
            this.f14033e = Integer.parseInt((String) map2.get("ad_width"));
        }
        if (map2.containsKey("native_close")) {
            this.f14034f = Boolean.valueOf((String) map2.get("native_close")).booleanValue();
        }
        if (map2.containsKey("preloadMarkup") && Boolean.parseBoolean((String) map2.get("preloadMarkup"))) {
            m14250a(this.f14038j);
        } else if (this.f14036h != null) {
            this.f14036h.m14356a(this);
        }
    }

    public final void mo708b() {
        if (this.f14035g != null) {
            this.f14035g.m14234b();
        }
        if (this.f14039k != null) {
            C1984h.m14471a(this.f14039k);
            this.f14039k.destroy();
            this.f14039k = null;
        }
    }
}
