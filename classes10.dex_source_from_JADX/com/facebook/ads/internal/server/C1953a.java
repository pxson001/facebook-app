package com.facebook.ads.internal.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.C1920b;
import com.facebook.ads.internal.dto.C1926c;
import com.facebook.ads.internal.dto.C1929e;
import com.facebook.ads.internal.dto.C1930f;
import com.facebook.ads.internal.server.C1956c.C1955a;
import com.facebook.ads.internal.thirdparty.http.C1950b;
import com.facebook.ads.internal.thirdparty.http.C1961a;
import com.facebook.ads.internal.thirdparty.http.C1970m;
import com.facebook.ads.internal.thirdparty.http.C1971n;
import com.facebook.ads.internal.util.C1978d;
import com.facebook.ads.internal.util.C1992p;
import com.facebook.ads.internal.util.C1994r;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

public class C1953a {
    private static final C1992p f14252g;
    private static final ThreadPoolExecutor f14253h;
    Map<String, String> f14254a;
    public final C1954b f14255b = C1954b.m14389a();
    public C1944a f14256c = this;
    public C1929e f14257d;
    public C1961a f14258e;
    public final String f14259f;

    public interface C1944a {
        void mo737a(C1920b c1920b);

        void mo738a(C1957d c1957d);
    }

    class C19512 extends C1950b {
        final /* synthetic */ C1953a f14250a;

        C19512(C1953a c1953a) {
            this.f14250a = c1953a;
        }

        private void m14378a(C1970m c1970m) {
            C1978d.m14450b(this.f14250a.f14257d);
            this.f14250a.f14258e = null;
            try {
                C1971n a = c1970m.m14434a();
                if (a != null) {
                    String e = a.m14437e();
                    C1956c a2 = this.f14250a.f14255b.m14392a(e);
                    if (a2.m14393a() == C1955a.ERROR) {
                        C1958e c1958e = (C1958e) a2;
                        String c = c1958e.m14395c();
                        C1953a.m14383a(this.f14250a, AdErrorType.adErrorTypeFromCode(c1958e.m14396d(), AdErrorType.ERROR_MESSAGE).getAdErrorWrapper(c == null ? e : c));
                        return;
                    }
                }
            } catch (JSONException e2) {
            }
            C1953a.m14383a(this.f14250a, new C1920b(AdErrorType.NETWORK_ERROR, c1970m.getMessage()));
        }

        public final void mo739a(C1971n c1971n) {
            if (c1971n != null) {
                String e = c1971n.m14437e();
                C1978d.m14450b(this.f14250a.f14257d);
                this.f14250a.f14258e = null;
                C1953a.m14384a(this.f14250a, e);
            }
        }

        public final void mo740a(Exception exception) {
            if (C1970m.class.equals(exception.getClass())) {
                m14378a((C1970m) exception);
            } else {
                C1953a.m14383a(this.f14250a, new C1920b(AdErrorType.NETWORK_ERROR, exception.getMessage()));
            }
        }
    }

    static {
        ThreadFactory c1992p = new C1992p();
        f14252g = c1992p;
        f14253h = (ThreadPoolExecutor) Executors.newCachedThreadPool(c1992p);
    }

    public C1953a() {
        String str = AdSettings.f13894e;
        if (null != null) {
            if (C1994r.m14486a(str)) {
                str = "https://ad6.liverail.com/";
            } else {
                str = String.format("https://ad6.%s.liverail.com/", new Object[]{str});
            }
            this.f14259f = str;
            return;
        }
        if (C1994r.m14486a(str)) {
            str = "https://graph.facebook.com/network_ads_common/";
        } else {
            str = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[]{str});
        }
        this.f14259f = str;
    }

    public static C1950b m14382a(C1953a c1953a) {
        return new C19512(c1953a);
    }

    public static void m14383a(C1953a c1953a, C1920b c1920b) {
        if (c1953a.f14256c != null) {
            c1953a.f14256c.mo737a(c1920b);
        }
        c1953a.m14387b();
    }

    public static void m14384a(C1953a c1953a, String str) {
        try {
            C1956c a = c1953a.f14255b.m14392a(str);
            C1926c b = a.m14394b();
            if (b != null) {
                C1978d.m14447a(b.m14334a().m14338c(), c1953a.f14257d);
            }
            switch (a.m14393a()) {
                case ADS:
                    C1957d c1957d = (C1957d) a;
                    if (b != null && b.m14334a().m14339d()) {
                        C1978d.m14448a(str, c1953a.f14257d);
                    }
                    c1953a.m14385a(c1957d);
                    return;
                case ERROR:
                    C1958e c1958e = (C1958e) a;
                    String c = c1958e.m14395c();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c1958e.m14396d(), AdErrorType.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    C1953a.m14383a(c1953a, adErrorTypeFromCode.getAdErrorWrapper(str));
                    return;
                default:
                    C1953a.m14383a(c1953a, AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(str));
                    return;
            }
        } catch (Exception e) {
            C1953a.m14383a(c1953a, AdErrorType.PARSER_FAILURE.getAdErrorWrapper(e.getMessage()));
        }
    }

    private void m14385a(C1957d c1957d) {
        if (this.f14256c != null) {
            this.f14256c.mo738a(c1957d);
        }
        m14387b();
    }

    private void m14387b() {
        if (this.f14258e != null) {
            this.f14258e.f14276e = 1;
            this.f14258e.m14416a(1);
            this.f14258e = null;
        }
    }

    public final void m14388a(final Context context, final C1929e c1929e) {
        Object obj;
        m14387b();
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            obj = 1;
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                obj = null;
            } else {
                int i = 1;
            }
        }
        if (obj == null) {
            C1953a.m14383a(this, new C1920b(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f14257d = c1929e;
        if (C1978d.m14449a(c1929e)) {
            String str = (String) C1978d.f14322c.get(C1978d.m14451d(c1929e));
            if (str != null) {
                C1953a.m14384a(this, str);
                return;
            } else {
                C1953a.m14383a(this, AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper(null));
                return;
            }
        }
        ExecutorDetour.a(f14253h, new Runnable(this) {
            final /* synthetic */ C1953a f14249c;

            public void run() {
                C1930f.m14343b(context);
                this.f14249c.f14254a = c1929e.m14341e();
                try {
                    this.f14249c.f14258e = new C1961a(context, c1929e.f14158e);
                    C1961a c1961a = this.f14249c.f14258e;
                    String str = this.f14249c.f14259f;
                    this.f14249c.f14258e;
                    c1961a.m14417a(str, C1961a.m14405a().m14438a(this.f14249c.f14254a), C1953a.m14382a(this.f14249c));
                } catch (Exception e) {
                    C1953a.m14383a(this.f14249c, AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(e.getMessage()));
                }
            }
        }, -1456475064);
    }
}
