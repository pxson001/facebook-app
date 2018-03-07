package com.facebook.zero.connectiontest;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: exception while filtering */
public class ConnectionTester {
    private static final String f13047a = ConnectionTester.class.getSimpleName();
    private final ConnectionTestType f13048b;
    public final String f13049c;
    private final int f13050d;
    private final String f13051e;
    private final Map<String, String> f13052f = new HashMap();
    private final int f13053g;
    private final int f13054h;
    private long f13055i;
    public long f13056j;
    public Throwable f13057k;

    /* compiled from: exception while filtering */
    public enum ConnectionTestType {
        TCP_OPEN("tcp"),
        TCP_OPEN_80("tcp80"),
        TCP_OPEN_443("tcp443"),
        SSL("ssl"),
        VOIP_TURN("turn"),
        MQTT_SSL("mqtt_ssl"),
        HTTP("http"),
        HTTP_80("http80"),
        HTTP_AKAMAI("http_akamai"),
        HTTP_OPERA("http_opera"),
        HTTPS("https"),
        HTTPS_443("https443"),
        PROXY_CONNECT("proxy_connect");
        
        public final String name;

        private ConnectionTestType(String str) {
            this.name = str;
        }

        public static ConnectionTestType valueOrDefault(String str) {
            for (ConnectionTestType connectionTestType : values()) {
                if (TextUtils.equals(str, connectionTestType.name)) {
                    return connectionTestType;
                }
            }
            return HTTPS_443;
        }

        public static ConnectionTestType valueOfName(String str) {
            for (ConnectionTestType connectionTestType : values()) {
                if (TextUtils.equals(str, connectionTestType.name)) {
                    return connectionTestType;
                }
            }
            throw new IllegalArgumentException(str + " isn't a valid ConnectionTestType");
        }
    }

    public ConnectionTester(ConnectionTestType connectionTestType, String str, int i, String str2, Collection<Pair<String, String>> collection, int i2, int i3) {
        this.f13048b = connectionTestType;
        this.f13049c = str;
        this.f13050d = i;
        this.f13051e = str2;
        if (collection != null) {
            for (Pair pair : collection) {
                this.f13052f.put(pair.first, pair.second);
            }
        }
        this.f13053g = i2;
        this.f13054h = i3;
    }

    private void m13119e() {
        this.f13055i = SystemClock.elapsedRealtime();
    }

    private void m13120f() {
        this.f13056j = SystemClock.elapsedRealtime() - this.f13055i;
    }

    private void m13121g() {
        this.f13057k = null;
        m13120f();
    }

    private void m13118a(Throwable th) {
        this.f13057k = th;
        m13120f();
    }

    public final void m13124d() {
        try {
            m13119e();
            m13122h();
            m13121g();
        } catch (Throwable e) {
            m13118a(e);
        }
    }

    private void m13122h() {
        int i = 80;
        int i2 = 443;
        String str;
        List i3;
        String str2;
        switch (this.f13048b) {
            case TCP_OPEN:
            case TCP_OPEN_80:
                ConnectionTestUtil.m13110a(this.f13049c, this.f13050d > 0 ? this.f13050d : 80, this.f13053g);
                return;
            case TCP_OPEN_443:
                str = this.f13049c;
                if (this.f13050d > 0) {
                    i2 = this.f13050d;
                }
                ConnectionTestUtil.m13110a(str, i2, this.f13053g);
                return;
            case SSL:
                str = this.f13049c;
                if (this.f13050d > 0) {
                    i2 = this.f13050d;
                }
                ConnectionTestUtil.m13114b(str, i2, this.f13053g);
                return;
            case MQTT_SSL:
                ConnectionTestUtil.m13115c(this.f13049c, this.f13050d > 0 ? this.f13050d : 8883, this.f13053g);
                return;
            case VOIP_TURN:
                str = this.f13049c;
                if (this.f13050d > 0) {
                    i2 = this.f13050d;
                }
                ConnectionTestUtil.m13116d(str, i2, this.f13053g);
                return;
            case HTTP:
            case HTTP_80:
            case HTTP_AKAMAI:
                i3 = m13123i();
                if (this.f13048b == ConnectionTestType.HTTP_AKAMAI) {
                    i3.add(new ServerHeaderVerifier("akamai"));
                }
                str2 = this.f13049c;
                if (this.f13050d > 0) {
                    i = this.f13050d;
                }
                ConnectionTestUtil.m13107a(str2, i, this.f13051e, this.f13052f, this.f13053g, i3);
                return;
            case PROXY_CONNECT:
                List i4 = m13123i();
                i4.add(new ServerHeaderVerifier("X-FB"));
                ConnectionTestUtil.m13105a(this.f13049c, this.f13050d > 0 ? this.f13050d : 8080, this.f13053g, i4);
                return;
            case HTTP_OPERA:
                str2 = "IorgCarrierToolkitOperaEchoTest" + new Random().nextInt(100);
                this.f13052f.put("x-iorg-test-keyword", str2);
                i3 = m13123i();
                i3.add(new HttpResponseContentVerifier(str2));
                str2 = this.f13049c;
                if (this.f13050d > 0) {
                    i = this.f13050d;
                }
                ConnectionTestUtil.m13107a(str2, i, "/echo", this.f13052f, this.f13053g, i3);
                return;
            case HTTPS:
            case HTTPS_443:
                str = this.f13049c;
                if (this.f13050d > 0) {
                    i2 = this.f13050d;
                }
                String str3 = this.f13051e;
                Map map = this.f13052f;
                int i5 = this.f13053g;
                m13123i();
                ConnectionTestUtil.m13106a(str, i2, str3, map, i5);
                return;
            default:
                return;
        }
    }

    private List<HttpResponseProcessor> m13123i() {
        List arrayList = new ArrayList();
        if (this.f13054h > 0) {
            arrayList.add(new HttpResponseCodeVerifier(this.f13054h));
        }
        return arrayList;
    }
}
