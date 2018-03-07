package com.facebook.zero.connectiontest;

import android.annotation.SuppressLint;
import com.facebook.common.iolite.Closeables;
import com.facebook.common.util.Hex;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: exception with filtering commerce pages */
public class ConnectionTestUtil {
    public static final byte[] f13040a = new byte[]{(byte) 16, (byte) 35, (byte) 0, (byte) 6, (byte) 77, (byte) 81, (byte) 73, (byte) 115, (byte) 100, (byte) 112, (byte) 3, (byte) 2, (byte) 0, (byte) 3, (byte) 0, (byte) 21, (byte) 70, (byte) 66, (byte) 77, (byte) 81, (byte) 84, (byte) 84, (byte) 95, (byte) 104, (byte) 101, (byte) 97, (byte) 108, (byte) 116, (byte) 104, (byte) 95, (byte) 99, (byte) 104, (byte) 101, (byte) 99, (byte) 107, (byte) 101, (byte) 114};
    public static final byte[] f13041b = new byte[]{Byte.MIN_VALUE, (byte) 70, (byte) 1, (byte) 3, (byte) 1, (byte) 0, (byte) 45, (byte) 0, (byte) 0, (byte) 0, (byte) 16, (byte) 1, (byte) 0, Byte.MIN_VALUE, (byte) 3, (byte) 0, Byte.MIN_VALUE, (byte) 7, (byte) 0, (byte) -64, (byte) 6, (byte) 0, (byte) 64, (byte) 2, (byte) 0, Byte.MIN_VALUE, (byte) 4, (byte) 0, Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 4, (byte) 0, (byte) -2, (byte) -1, (byte) 0, (byte) 0, (byte) 10, (byte) 0, (byte) -2, (byte) -2, (byte) 0, (byte) 0, (byte) 9, (byte) 0, (byte) 0, (byte) 100, (byte) 0, (byte) 0, (byte) 98, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 6, (byte) 31, (byte) 23, (byte) 12, (byte) -90, (byte) 47, (byte) 0, (byte) 120, (byte) -4, (byte) 70, (byte) 85, (byte) 46, (byte) -79, (byte) -125, (byte) 57, (byte) -15, (byte) -22};
    public static final byte[] f13042c = new byte[]{(byte) 22, (byte) 3, (byte) 1, (byte) 0, (byte) 74, (byte) 2, (byte) 0, (byte) 0, (byte) 70, (byte) 3, (byte) 1, (byte) 66, (byte) -123, (byte) 69, (byte) -89, (byte) 39, (byte) -87, (byte) 93, (byte) -96, (byte) -77, (byte) -59, (byte) -25, (byte) 83, (byte) -38, (byte) 72, (byte) 43, (byte) 63, (byte) -58, (byte) 90, (byte) -54, (byte) -119, (byte) -63, (byte) 88, (byte) 82, (byte) -95, (byte) 120, (byte) 60, (byte) 91, (byte) 23, (byte) 70, (byte) 0, (byte) -123, (byte) 63, (byte) 32, (byte) 14, (byte) -45, (byte) 6, (byte) 114, (byte) 91, (byte) 91, (byte) 27, (byte) 95, (byte) 21, (byte) -84, (byte) 19, (byte) -7, (byte) -120, (byte) 83, (byte) -99, (byte) -101, (byte) -24, (byte) 61, (byte) 123, (byte) 12, (byte) 48, (byte) 50, (byte) 110, (byte) 56, (byte) 77, (byte) -94, (byte) 117, (byte) 87, (byte) 65, (byte) 108, (byte) 52, (byte) 92, (byte) 0, (byte) 4, (byte) 0};
    private static final String f13043d = ConnectionTestUtil.class.getSimpleName();
    private static final HostnameVerifier f13044e = new C18191();
    private static SSLSocketFactory f13045f = null;

    /* compiled from: exception with filtering commerce pages */
    final class C18191 implements HostnameVerifier {
        C18191() {
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: exception with filtering commerce pages */
    final class C18202 implements X509TrustManager {
        C18202() {
        }

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    private static Socket m13117e(String str, int i, int i2) {
        Socket socket = new Socket();
        socket.setReceiveBufferSize(32);
        socket.setSendBufferSize(32);
        socket.setKeepAlive(false);
        socket.setSoLinger(false, -1);
        socket.setSoTimeout(i2);
        socket.connect(new InetSocketAddress(str, i), i2);
        return socket;
    }

    public static void m13110a(String str, int i, int i2) {
        Closeable outputStream;
        Throwable th;
        Socket e;
        try {
            e = m13117e(str, i, i2);
            try {
                outputStream = e.getOutputStream();
                try {
                    Closeable inputStream = e.getInputStream();
                    Closeables.a(outputStream, false);
                    Closeables.a(inputStream, false);
                    m13112a(e, false);
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.a(outputStream, true);
                    Closeables.a(null, true);
                    m13112a(e, true);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                Closeables.a(outputStream, true);
                Closeables.a(null, true);
                m13112a(e, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            e = null;
            Closeables.a(outputStream, true);
            Closeables.a(null, true);
            m13112a(e, true);
            throw th;
        }
    }

    public static void m13114b(String str, int i, int i2) {
        Throwable th;
        Socket createSocket;
        Closeable closeable;
        try {
            Socket e = m13117e(str, i, i2);
            try {
                createSocket = m13113b().createSocket(e, str, i, true);
            } catch (Throwable th2) {
                th = th2;
                createSocket = e;
                closeable = null;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(createSocket, true);
                throw th;
            }
            try {
                closeable = createSocket.getOutputStream();
                try {
                    Closeable inputStream = createSocket.getInputStream();
                    Closeables.a(closeable, false);
                    Closeables.a(inputStream, false);
                    m13112a(createSocket, false);
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.a(closeable, true);
                    Closeables.a(null, true);
                    m13112a(createSocket, true);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(createSocket, true);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            createSocket = null;
            Closeables.a(closeable, true);
            Closeables.a(null, true);
            m13112a(createSocket, true);
            throw th;
        }
    }

    public static void m13115c(String str, int i, int i2) {
        Socket createSocket;
        Throwable th;
        Socket socket;
        Closeable closeable;
        try {
            Socket e = m13117e(str, i, i2);
            try {
                createSocket = m13113b().createSocket(e, str, i, true);
            } catch (Throwable th2) {
                th = th2;
                socket = e;
                closeable = null;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(socket, true);
                throw th;
            }
            try {
                OutputStream outputStream = createSocket.getOutputStream();
                try {
                    closeable = new DataOutputStream(outputStream);
                } catch (Throwable th3) {
                    th = th3;
                    Object obj = outputStream;
                    socket = createSocket;
                    Closeables.a(closeable, true);
                    Closeables.a(null, true);
                    m13112a(socket, true);
                    throw th;
                }
                try {
                    closeable.write(f13040a);
                    closeable.flush();
                    Closeable inputStream = createSocket.getInputStream();
                    if (inputStream.read(new byte[4]) < 0) {
                        throw new IOException("No MQTT response");
                    }
                    Closeables.a(closeable, false);
                    Closeables.a(inputStream, false);
                    m13112a(createSocket, false);
                } catch (Throwable th4) {
                    th = th4;
                    socket = createSocket;
                    Closeables.a(closeable, true);
                    Closeables.a(null, true);
                    m13112a(socket, true);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
                socket = createSocket;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(socket, true);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable = null;
            socket = null;
            Closeables.a(closeable, true);
            Closeables.a(null, true);
            m13112a(socket, true);
            throw th;
        }
    }

    public static void m13116d(String str, int i, int i2) {
        Throwable th;
        Closeable closeable;
        Socket socket;
        try {
            OutputStream outputStream;
            Socket e = m13117e(str, i, i2);
            try {
                outputStream = e.getOutputStream();
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                socket = e;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(socket, true);
                throw th;
            }
            try {
                closeable = new DataOutputStream(outputStream);
            } catch (Throwable th3) {
                th = th3;
                Object obj = outputStream;
                socket = e;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(socket, true);
                throw th;
            }
            try {
                closeable.write(f13041b);
                closeable.flush();
                Closeable inputStream = e.getInputStream();
                byte[] bArr = new byte[f13042c.length];
                int i3 = 0;
                while (i3 < bArr.length) {
                    int read = inputStream.read(bArr, i3, bArr.length - i3);
                    Integer.valueOf(read);
                    if (read < 0) {
                        throw new IOException("EOF while reading turn response, read=" + i3);
                    }
                    while (read > 0) {
                        if (f13042c[i3] != bArr[i3]) {
                            throw new IOException("IP " + str + " did not get expected TURN response, response=" + Hex.a(bArr, false));
                        }
                        i3++;
                        read--;
                    }
                }
                Closeables.a(closeable, false);
                Closeables.a(inputStream, false);
                m13112a(e, false);
            } catch (Throwable th4) {
                th = th4;
                socket = e;
                Closeables.a(closeable, true);
                Closeables.a(null, true);
                m13112a(socket, true);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            socket = null;
            Closeables.a(closeable, true);
            Closeables.a(null, true);
            m13112a(socket, true);
            throw th;
        }
    }

    private static void m13111a(HttpURLConnection httpURLConnection, int i) {
        httpURLConnection.setRequestProperty("Connection", "Close");
        httpURLConnection.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Expires", "0");
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
    }

    private static String m13108a() {
        return "CONNECT zrtest.example.org:443 HTTP/1.1\n" + "Host: en.m.wikipedia.org\r\n\r\n";
    }

    public static int m13105a(String str, int i, int i2, List<HttpResponseProcessor> list) {
        SocketChannel open = SocketChannel.open();
        open.socket().setSoTimeout(i2);
        try {
            open.connect(new InetSocketAddress(str, i));
            open.write(ByteBuffer.wrap(m13108a().getBytes(Charset.forName("UTF-8"))));
            ByteBuffer allocate = ByteBuffer.allocate(8192);
            while (open.read(allocate) >= 0) {
                if (!allocate.hasRemaining()) {
                    break;
                }
            }
            allocate.flip();
            String str2 = new String(allocate.array(), Charset.forName("UTF-8"));
            allocate.clear();
            int parseInt = Integer.parseInt(str2.split("\r\n", 2)[0].split(" ", 3)[1]);
            Integer.valueOf(parseInt);
            if (list != null) {
                for (HttpResponseProcessor a : list) {
                    a.mo560a(parseInt, str2);
                }
            }
            open.close();
            return parseInt;
        } catch (Throwable th) {
            open.close();
        }
    }

    public static int m13107a(String str, int i, String str2, Map<String, String> map, int i2, List<HttpResponseProcessor> list) {
        HttpURLConnection httpURLConnection = null;
        if (str2 == null) {
            try {
                str2 = "/health_check";
            } catch (Throwable th) {
                Throwable th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://" + str + ":" + i + str2).openConnection();
        try {
            m13111a(httpURLConnection2, i2);
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpURLConnection2.setRequestProperty(str3, (String) map.get(str3));
                }
            }
            int responseCode = httpURLConnection2.getResponseCode();
            httpURLConnection2.getResponseMessage();
            Integer.valueOf(responseCode);
            if (list != null) {
                for (HttpResponseProcessor a : list) {
                    a.mo561a(responseCode, httpURLConnection2);
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return responseCode;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            httpURLConnection = httpURLConnection2;
            th2 = th4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    public static int m13106a(String str, int i, String str2, Map<String, String> map, int i2) {
        HttpsURLConnection httpsURLConnection = null;
        if (str2 == null) {
            try {
                str2 = "/health_check";
            } catch (Throwable th) {
                Throwable th2 = th;
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                throw th2;
            }
        }
        HttpURLConnection httpURLConnection = (HttpsURLConnection) new URL("https://" + str + ":" + i + str2).openConnection();
        try {
            m13111a(httpURLConnection, i2);
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str3, (String) map.get(str3));
                }
            }
            httpURLConnection.setHostnameVerifier(f13044e);
            httpURLConnection.setSSLSocketFactory(m13113b());
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.getResponseMessage();
            Integer.valueOf(responseCode);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return responseCode;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            httpsURLConnection = httpURLConnection;
            th2 = th4;
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th2;
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static synchronized SSLSocketFactory m13113b() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (ConnectionTestUtil.class) {
            if (f13045f != null) {
                sSLSocketFactory = f13045f;
            } else {
                C18202 c18202 = new C18202();
                SSLContext instance = SSLContext.getInstance("SSL");
                instance.init(null, new TrustManager[]{c18202}, new SecureRandom());
                sSLSocketFactory = instance.getSocketFactory();
                f13045f = sSLSocketFactory;
            }
        }
        return sSLSocketFactory;
    }

    public static String m13109a(HttpURLConnection httpURLConnection) {
        Map headerFields = httpURLConnection.getHeaderFields();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : headerFields.keySet()) {
            stringBuilder.append(str).append(": ").append(headerFields.get(str)).append(" ");
        }
        return stringBuilder.toString();
    }

    private static void m13112a(@Nullable Socket socket, boolean z) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                if (!z) {
                    throw e;
                }
            }
        }
    }
}
