package com.facebook.livephotos.exoplayer.upstream;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.livephotos.exoplayer.upstream.HttpDataSource.HttpDataSourceException;
import com.facebook.livephotos.exoplayer.upstream.HttpDataSource.InvalidContentTypeException;
import com.facebook.livephotos.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.Predicate;
import com.facebook.livephotos.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: overall_upload_start */
public class DefaultHttpDataSource implements HttpDataSource {
    private static final Pattern f7647b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> f7648c = new AtomicReference();
    private final boolean f7649d;
    private final int f7650e;
    private final int f7651f;
    private final String f7652g;
    private final Predicate<String> f7653h;
    private final HashMap<String, String> f7654i = new HashMap();
    private final TransferListener f7655j;
    private DataSpec f7656k;
    private HttpURLConnection f7657l;
    private InputStream f7658m;
    private boolean f7659n;
    private long f7660o;
    private long f7661p;
    private long f7662q;
    private long f7663r;

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener transferListener, int i, int i2, boolean z) {
        this.f7652g = Assertions.m9294a(str);
        this.f7653h = predicate;
        this.f7655j = transferListener;
        this.f7650e = i;
        this.f7651f = i2;
        this.f7649d = z;
    }

    public final long mo441a(DataSpec dataSpec) {
        long j = 0;
        this.f7656k = dataSpec;
        this.f7663r = 0;
        this.f7662q = 0;
        try {
            this.f7657l = m9272b(dataSpec);
            try {
                int responseCode = this.f7657l.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = this.f7657l.getHeaderFields();
                    m9274d();
                    throw new InvalidResponseCodeException(responseCode, headerFields, dataSpec);
                }
                String contentType = this.f7657l.getContentType();
                if (this.f7653h == null || this.f7653h.m9284a(contentType)) {
                    if (responseCode == 200 && dataSpec.f7637d != 0) {
                        j = dataSpec.f7637d;
                    }
                    this.f7660o = j;
                    if ((dataSpec.f7640g & 1) == 0) {
                        j = m9267a(this.f7657l);
                        j = dataSpec.f7638e != -1 ? dataSpec.f7638e : j != -1 ? j - this.f7660o : -1;
                        this.f7661p = j;
                    } else {
                        this.f7661p = dataSpec.f7638e;
                    }
                    try {
                        this.f7658m = this.f7657l.getInputStream();
                        this.f7659n = true;
                        return this.f7661p;
                    } catch (IOException e) {
                        m9274d();
                        throw new HttpDataSourceException(e, dataSpec);
                    }
                }
                m9274d();
                throw new InvalidContentTypeException(contentType, dataSpec);
            } catch (IOException e2) {
                m9274d();
                throw new HttpDataSourceException("Unable to connect to " + dataSpec.f7634a.toString(), e2, dataSpec);
            }
        } catch (IOException e22) {
            throw new HttpDataSourceException("Unable to connect to " + dataSpec.f7634a.toString(), e22, dataSpec);
        }
    }

    public final int mo440a(byte[] bArr, int i, int i2) {
        try {
            m9273c();
            return m9270b(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSourceException(e, this.f7656k);
        }
    }

    public final void mo442a() {
        try {
            if (this.f7658m != null) {
                Util.m9363a(this.f7657l, m9271b());
                try {
                    this.f7658m.close();
                } catch (IOException e) {
                    throw new HttpDataSourceException(e, this.f7656k);
                }
            }
            this.f7658m = null;
            m9274d();
            if (this.f7659n) {
                this.f7659n = false;
                if (this.f7655j == null) {
                }
            }
        } catch (Throwable th) {
            this.f7658m = null;
            m9274d();
            if (this.f7659n) {
                this.f7659n = false;
            }
        }
    }

    private long m9271b() {
        return this.f7661p == -1 ? this.f7661p : this.f7661p - this.f7663r;
    }

    private HttpURLConnection m9272b(DataSpec dataSpec) {
        URL url = new URL(dataSpec.f7634a.toString());
        byte[] bArr = dataSpec.f7635b;
        long j = dataSpec.f7637d;
        long j2 = dataSpec.f7638e;
        boolean z = (dataSpec.f7640g & 1) != 0;
        if (!this.f7649d) {
            return m9268a(url, bArr, j, j2, z, true);
        }
        HttpURLConnection a;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                a = m9268a(url, bArr, j, j2, z, false);
                int responseCode = a.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    bArr = null;
                    String headerField = a.getHeaderField("Location");
                    a.disconnect();
                    url = m9269a(url, headerField);
                    i = i2;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
        }
        return a;
    }

    private HttpURLConnection m9268a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f7650e);
        httpURLConnection.setReadTimeout(this.f7651f);
        synchronized (this.f7654i) {
            for (Entry entry : this.f7654i.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f7652g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL m9269a(URL url, String str) {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static long m9267a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = f7647b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    private void m9273c() {
        if (this.f7662q != this.f7660o) {
            Object obj = (byte[]) f7648c.getAndSet(null);
            if (obj == null) {
                obj = new byte[4096];
            }
            while (this.f7662q != this.f7660o) {
                int read = this.f7658m.read(obj, 0, (int) Math.min(this.f7660o - this.f7662q, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read == -1) {
                    throw new EOFException();
                } else {
                    this.f7662q += (long) read;
                }
            }
            f7648c.set(obj);
        }
    }

    private int m9270b(byte[] bArr, int i, int i2) {
        if (this.f7661p != -1) {
            i2 = (int) Math.min((long) i2, this.f7661p - this.f7663r);
        }
        if (i2 == 0) {
            return -1;
        }
        int read = this.f7658m.read(bArr, i, i2);
        if (read != -1) {
            this.f7663r += (long) read;
            return read;
        } else if (this.f7661p == -1 || this.f7661p == this.f7663r) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private void m9274d() {
        if (this.f7657l != null) {
            try {
                this.f7657l.disconnect();
            } catch (Throwable e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f7657l = null;
        }
    }
}
