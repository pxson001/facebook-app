package com.facebook.ads.internal.thirdparty.http;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.ads.internal.C1931e;
import com.facebook.ads.internal.dto.C1930f;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1984h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class C1961a {
    private static int[] f14270g = new int[20];
    private static final String f14271h = C1961a.class.getSimpleName();
    protected final C1959f f14272a;
    public final C1963e f14273b;
    protected String f14274c;
    protected C1964g f14275d;
    public int f14276e;
    protected int f14277f;
    private int f14278i;
    public Map<String, String> f14279j;
    private boolean f14280k;

    class C19601 extends C1959f {
        C19601() {
        }
    }

    static {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        if (VERSION.SDK_INT > 8 && CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    public C1961a() {
        this("");
    }

    public C1961a(Context context) {
        this(context, null);
    }

    public C1961a(Context context, C1931e c1931e) {
        this();
        String str = C1984h.m14469a(context, c1931e) + " [FBAN/AudienceNetworkForAndroid;" + "FBSN/Android" + ";FBSV/" + C1930f.f14163a + ";FBAB/" + C1930f.f14166d + ";FBAV/" + C1930f.f14168f + ";FBBV/" + C1930f.f14169g + ";FBLC/" + Locale.getDefault().toString() + "]";
        this.f14279j.put("user-agent", str);
        if (C1983g.m14462a()) {
            C1983g.m14465b();
        }
    }

    private C1961a(C1963e c1963e, String str) {
        this(c1963e, str, new C19601());
    }

    private C1961a(C1963e c1963e, String str, C1959f c1959f) {
        this.f14274c = "";
        this.f14275d = new C1964g();
        this.f14276e = 2000;
        this.f14277f = 8000;
        this.f14278i = 3;
        this.f14279j = new TreeMap();
        this.f14274c = str;
        this.f14272a = c1959f;
        this.f14273b = c1963e;
    }

    private C1961a(String str) {
        this(new C1963e(), str);
    }

    private int m14403a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f14272a.m14397a(httpURLConnection);
            if (outputStream != null) {
                this.f14272a.m14399a(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    private C1971n m14404a(String str, C1968j c1968j, String str2, byte[] bArr) {
        HttpURLConnection a;
        C1971n b;
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        C1971n c1971n = null;
        C1971n c1971n2 = null;
        try {
            this.f14280k = false;
            a = m14406a(str);
            try {
                m14408a(a, c1968j, str2);
                m14407a(a);
                if (this.f14275d.m14425a()) {
                    this.f14275d.m14424a(a, bArr);
                }
                a.connect();
                this.f14280k = true;
                if (a.getDoOutput() && bArr != null) {
                    m14403a(a, bArr);
                }
                b = a.getDoInput() ? m14411b(a) : new C1971n(a, null);
                if (this.f14275d.m14425a()) {
                    this.f14275d.m14422a(b);
                }
                if (a == null) {
                    return b;
                }
                a.disconnect();
                return b;
            } catch (Exception e) {
                httpURLConnection = a;
                exception = e;
                try {
                    b = m14413c(httpURLConnection);
                    if (b != null) {
                        try {
                            if (b.m14435a() > 0) {
                                if (this.f14275d.m14425a()) {
                                    this.f14275d.m14422a(b);
                                }
                                if (httpURLConnection != null) {
                                    return b;
                                }
                                httpURLConnection.disconnect();
                                return b;
                            }
                        } catch (Throwable th2) {
                            a = httpURLConnection;
                            C1971n c1971n3 = b;
                            th = th2;
                            c1971n = c1971n3;
                            if (this.f14275d.m14425a()) {
                                this.f14275d.m14422a(c1971n);
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            throw th;
                        }
                    }
                    throw new C1970m(exception, b);
                } catch (Exception e2) {
                    exception.printStackTrace();
                    if (null != null) {
                        if (c1971n2.m14435a() > 0) {
                            if (this.f14275d.m14425a()) {
                                this.f14275d.m14422a(null);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                    }
                    throw new C1970m(exception, c1971n2);
                } catch (Throwable th3) {
                    th = th3;
                    a = httpURLConnection;
                    if (this.f14275d.m14425a()) {
                        this.f14275d.m14422a(c1971n);
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (this.f14275d.m14425a()) {
                    this.f14275d.m14422a(c1971n);
                }
                if (a != null) {
                    a.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            exception = e3;
            httpURLConnection = null;
            b = m14413c(httpURLConnection);
            if (b != null) {
                if (b.m14435a() > 0) {
                    if (this.f14275d.m14425a()) {
                        this.f14275d.m14422a(b);
                    }
                    if (httpURLConnection != null) {
                        return b;
                    }
                    httpURLConnection.disconnect();
                    return b;
                }
            }
            throw new C1970m(exception, b);
        } catch (Throwable th5) {
            th = th5;
            a = null;
            if (this.f14275d.m14425a()) {
                this.f14275d.m14422a(c1971n);
            }
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    public static C1972o m14405a() {
        return new C1972o();
    }

    private HttpURLConnection m14406a(String str) {
        String str2 = this.f14274c + str;
        try {
            URL url = new URL(str2);
            return this.f14272a.m14398a(str2);
        } catch (Throwable e) {
            throw new IllegalArgumentException(str2 + " is not a valid URL", e);
        }
    }

    private void m14407a(HttpURLConnection httpURLConnection) {
        for (String str : this.f14279j.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f14279j.get(str));
        }
    }

    private void m14408a(HttpURLConnection httpURLConnection, C1968j c1968j, String str) {
        httpURLConnection.setConnectTimeout(this.f14276e);
        httpURLConnection.setReadTimeout(this.f14277f);
        C1959f c1959f = this.f14272a;
        httpURLConnection.setRequestMethod(c1968j.m14433c());
        httpURLConnection.setDoOutput(c1968j.m14432b());
        httpURLConnection.setDoInput(c1968j.m14431a());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    private boolean m14409a(long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        C1964g c1964g = this.f14275d;
        if (null != null) {
            this.f14275d.m14423a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f14276e + ", RT = " + this.f14277f);
        }
        return this.f14280k ? currentTimeMillis >= ((long) this.f14277f) : currentTimeMillis >= ((long) this.f14276e);
    }

    private C1971n m14410b(C1966l c1966l) {
        C1971n c1971n = null;
        try {
            c1971n = m14404a(c1966l.m14427a(), c1966l.m14428b(), c1966l.m14429c(), c1966l.m14430d());
        } catch (C1970m e) {
            this.f14272a.m14400a(e);
        } catch (Exception e2) {
            this.f14272a.m14400a(new C1970m(e2, c1971n));
        }
        return c1971n;
    }

    private C1971n m14411b(HttpURLConnection httpURLConnection) {
        Throwable th;
        byte[] bArr = null;
        InputStream b;
        try {
            b = this.f14272a.m14402b(httpURLConnection);
            if (b != null) {
                try {
                    bArr = this.f14272a.m14401a(b);
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C1971n c1971n = new C1971n(httpURLConnection, bArr);
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                }
            }
            return c1971n;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    private static int m14412c(int i) {
        return f14270g[i + 2] * 1000;
    }

    private C1971n m14413c(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        Throwable th;
        byte[] bArr = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    bArr = this.f14272a.m14401a(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C1971n c1971n = new C1971n(httpURLConnection, bArr);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception e2) {
                }
            }
            return c1971n;
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            if (errorStream != null) {
                errorStream.close();
            }
            throw th;
        }
    }

    public final C1971n m14414a(C1966l c1966l) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (i < this.f14278i) {
            try {
                m14419b(C1961a.m14412c(i));
                if (this.f14275d.m14425a()) {
                    this.f14275d.m14423a((i + 1) + "of" + this.f14278i + ", trying " + c1966l.m14427a());
                }
                currentTimeMillis = System.currentTimeMillis();
                C1971n a = m14404a(c1966l.m14427a(), c1966l.m14428b(), c1966l.m14429c(), c1966l.m14430d());
                if (a != null) {
                    return a;
                }
                i++;
            } catch (C1970m e) {
                if (m14409a(currentTimeMillis) && i < this.f14278i - 1) {
                    continue;
                } else if (!this.f14272a.m14400a(e) || i >= this.f14278i - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.f14276e);
                    } catch (InterruptedException e2) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    public final C1971n m14415a(String str, C1972o c1972o) {
        return m14410b(new C1967i(str, c1972o));
    }

    public final void m14416a(int i) {
        if (i <= 0 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f14278i = i;
    }

    public final void m14417a(String str, C1972o c1972o, C1950b c1950b) {
        C1966l c1969k = new C1969k(str, c1972o);
        C1963e c1963e = this.f14273b;
        new C1965h(this, c1950b).mo741a(c1969k);
    }

    public final C1971n m14418b(String str, C1972o c1972o) {
        return m14410b(new C1969k(str, c1972o));
    }

    public final void m14419b(int i) {
        this.f14276e = i;
    }
}
