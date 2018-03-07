package android_src.mmsv2;

import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.debug.log.BLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: setThreadImage */
public class MmsHttpClient {
    private static final Pattern f3774c = Pattern.compile("##(\\S+)##");
    public final Context f3775a;
    public final TelephonyManager f3776b;

    MmsHttpClient(Context context) {
        this.f3775a = context;
        this.f3776b = (TelephonyManager) context.getSystemService("phone");
    }

    public final byte[] m3536a(String str, byte[] bArr, String str2, boolean z, String str3, int i, Bundle bundle, String str4, String str5) {
        int length;
        Throwable th;
        Throwable th2;
        StringBuilder append = new StringBuilder("HTTP: ").append(str2).append(" ").append(Utils.m3582a(str)).append(z ? ", proxy=" + str3 + ":" + i : "").append(", PDU size=");
        if (bArr != null) {
            length = bArr.length;
        } else {
            length = 0;
        }
        append.append(length);
        m3528a(str2);
        HttpURLConnection httpURLConnection = null;
        String responseMessage;
        try {
            Proxy proxy = Proxy.NO_PROXY;
            if (z) {
                proxy = new Proxy(Type.HTTP, new InetSocketAddress(str3, i));
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection(proxy);
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setConnectTimeout(bundle.getInt("httpSocketTimeout", 60000));
                httpURLConnection2.setRequestProperty("Accept", "*/*, application/vnd.wap.mms-message, application/vnd.wap.sic");
                httpURLConnection2.setRequestProperty("Accept-Language", m3527a(Locale.getDefault()));
                new StringBuilder("HTTP: User-Agent=").append(str4);
                httpURLConnection2.setRequestProperty("User-Agent", str4);
                String string = bundle.getString("mUaProfTagName", "x-wap-profile");
                if (str5 != null) {
                    new StringBuilder("HTTP: UaProfUrl=").append(str5);
                    httpURLConnection2.setRequestProperty(string, str5);
                }
                m3529a(httpURLConnection2, bundle);
                if ("POST".equals(str2)) {
                    if (bArr == null || bArr.length <= 0) {
                        BLog.b("MmsLib", "HTTP: empty pdu");
                        throw new MmsHttpException(0, "Sending empty PDU");
                    }
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    if (bundle.getBoolean("supportHttpCharsetHeader", false)) {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/vnd.wap.mms-message; charset=utf-8");
                    } else {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/vnd.wap.mms-message");
                    }
                    if (BLog.b(2)) {
                        m3530a(httpURLConnection2.getRequestProperties());
                    }
                    httpURLConnection2.setFixedLengthStreamingMode(bArr.length);
                    OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } else if ("GET".equals(str2)) {
                    if (BLog.b(2)) {
                        m3530a(httpURLConnection2.getRequestProperties());
                    }
                    httpURLConnection2.setRequestMethod("GET");
                }
                int responseCode = httpURLConnection2.getResponseCode();
                responseMessage = httpURLConnection2.getResponseMessage();
                new StringBuilder("HTTP: ").append(responseCode).append(" ").append(responseMessage);
                if (BLog.b(2)) {
                    m3530a(httpURLConnection2.getHeaderFields());
                }
                if (responseCode / 100 != 2) {
                    throw new MmsHttpException(responseCode, responseMessage);
                }
                InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bufferedInputStream.close();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                StringBuilder stringBuilder = new StringBuilder("HTTP: response size=");
                if (toByteArray != null) {
                    responseCode = toByteArray.length;
                } else {
                    responseCode = 0;
                }
                stringBuilder.append(responseCode);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return toByteArray;
            } catch (Throwable e) {
                th = e;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                try {
                    responseMessage = Utils.m3582a(str);
                    BLog.b("MmsLib", "HTTP: invalid URL " + responseMessage, th2);
                    throw new MmsHttpException(0, "Invalid URL " + responseMessage, th2);
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable e2) {
                th = e2;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                responseMessage = Utils.m3582a(str);
                BLog.b("MmsLib", "HTTP: invalid URL protocol " + responseMessage, th2);
                throw new MmsHttpException(0, "Invalid URL protocol " + responseMessage, th2);
            } catch (Throwable e22) {
                th = e22;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                BLog.b("MmsLib", "HTTP: IO failure", th2);
                throw new MmsHttpException(0, th2);
            } catch (Throwable e222) {
                th = e222;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (MalformedURLException e3) {
            th2 = e3;
            responseMessage = Utils.m3582a(str);
            BLog.b("MmsLib", "HTTP: invalid URL " + responseMessage, th2);
            throw new MmsHttpException(0, "Invalid URL " + responseMessage, th2);
        } catch (ProtocolException e4) {
            th2 = e4;
            responseMessage = Utils.m3582a(str);
            BLog.b("MmsLib", "HTTP: invalid URL protocol " + responseMessage, th2);
            throw new MmsHttpException(0, "Invalid URL protocol " + responseMessage, th2);
        } catch (IOException e5) {
            th2 = e5;
            BLog.b("MmsLib", "HTTP: IO failure", th2);
            throw new MmsHttpException(0, th2);
        }
    }

    private static void m3530a(Map<String, List<String>> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                List<String> list = (List) entry.getValue();
                if (list != null) {
                    for (String append : list) {
                        stringBuilder.append(str).append('=').append(append).append('\n');
                    }
                }
            }
            new StringBuilder("HTTP: headers\n").append(stringBuilder.toString());
        }
    }

    private static void m3528a(String str) {
        if (!"GET".equals(str) && !"POST".equals(str)) {
            throw new MmsHttpException(0, "Invalid method " + str);
        }
    }

    private static String m3527a(Locale locale) {
        StringBuilder stringBuilder = new StringBuilder();
        String b = m3532b(locale.getLanguage());
        if (b != null) {
            stringBuilder.append(b);
            b = locale.getCountry();
            if (b != null) {
                stringBuilder.append("-");
                stringBuilder.append(b);
            }
        }
        if (!Locale.US.equals(locale)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("en-US");
        }
        return stringBuilder.toString();
    }

    public static String m3532b(String str) {
        if (str == null) {
            return null;
        }
        if ("iw".equals(str)) {
            return "he";
        }
        if ("in".equals(str)) {
            return "id";
        }
        if ("ji".equals(str)) {
            return "yi";
        }
        return str;
    }

    private String m3526a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f3774c.matcher(str);
        int i = 0;
        StringBuilder stringBuilder = null;
        while (matcher.find()) {
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            int start = matcher.start();
            if (start > i) {
                stringBuilder.append(str.substring(i, start));
            }
            String b = m3533b(matcher.group(1), bundle);
            if (b != null) {
                stringBuilder.append(b);
            }
            i = matcher.end();
        }
        if (stringBuilder != null && i < str.length()) {
            stringBuilder.append(str.substring(i));
        }
        return stringBuilder != null ? stringBuilder.toString() : str;
    }

    private void m3529a(HttpURLConnection httpURLConnection, Bundle bundle) {
        Object string = bundle.getString("httpParams");
        if (!TextUtils.isEmpty(string)) {
            for (String split : string.split("\\|")) {
                String[] split2 = split.split(":", 2);
                if (split2.length == 2) {
                    Object trim = split2[0].trim();
                    Object a = m3526a(split2[1].trim(), bundle);
                    if (!(TextUtils.isEmpty(trim) || TextUtils.isEmpty(a))) {
                        httpURLConnection.setRequestProperty(trim, a);
                    }
                }
            }
        }
    }

    private String m3533b(String str, Bundle bundle) {
        if ("LINE1".equals(str)) {
            return m3525a();
        }
        if ("LINE1NOCOUNTRYCODE".equals(str)) {
            String country;
            Context context = this.f3775a;
            String a = m3525a();
            Object obj = null;
            if (Utils.m3587b()) {
                SubscriptionInfo activeSubscriptionInfo = SubscriptionManager.from(this.f3775a).getActiveSubscriptionInfo(SmsManager.getDefaultSmsSubscriptionId());
                if (activeSubscriptionInfo != null) {
                    obj = activeSubscriptionInfo.getCountryIso();
                }
            } else {
                obj = this.f3776b.getSimCountryIso();
            }
            if (TextUtils.isEmpty(obj)) {
                country = Locale.getDefault().getCountry();
            } else {
                country = obj.toUpperCase();
            }
            return PhoneNumberHelper.m3575a(context, a, country);
        } else if ("NAI".equals(str)) {
            return m3535c(bundle.getString("naiSuffix", CarrierConfigValuesLoader.f3742c));
        } else {
            return null;
        }
    }

    private String m3525a() {
        if (!Utils.m3587b()) {
            return this.f3776b.getLine1Number();
        }
        SubscriptionInfo activeSubscriptionInfo = SubscriptionManager.from(this.f3775a).getActiveSubscriptionInfo(SmsManager.getDefaultSmsSubscriptionId());
        if (activeSubscriptionInfo != null) {
            return activeSubscriptionInfo.getNumber();
        }
        return null;
    }

    private String m3535c(String str) {
        String b;
        if (Utils.m3587b()) {
            b = m3531b(m3524a(Utils.m3585b(-1)));
        } else {
            b = m3534c();
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        byte[] encode;
        if (!TextUtils.isEmpty(str)) {
            b = b + str;
        }
        try {
            encode = Base64.encode(b.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException e) {
            encode = Base64.encode(b.getBytes(), 2);
        }
        try {
            return new String(encode, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            return new String(encode);
        }
    }

    private static int m3524a(int i) {
        try {
            Method method = SubscriptionManager.class.getMethod("getSlotId", new Class[]{Integer.TYPE});
            if (method != null) {
                return ((Integer) method.invoke(null, new Object[]{Integer.valueOf(i)})).intValue();
            }
        } catch (Exception e) {
            BLog.a("MmsLib", "SubscriptionManager.getSlotId failed " + e);
        }
        return -1;
    }

    private String m3531b(int i) {
        try {
            Method method = this.f3776b.getClass().getMethod("getNai", new Class[]{Integer.TYPE});
            if (method != null) {
                return (String) method.invoke(this.f3776b, new Object[]{Integer.valueOf(i)});
            }
        } catch (Exception e) {
            BLog.a("MmsLib", "TelephonyManager.getNai failed " + e);
        }
        return null;
    }

    private static String m3534c() {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            if (cls != null) {
                Method method = cls.getMethod("get", new Class[]{String.class});
                if (method != null) {
                    return (String) method.invoke(null, new Object[]{"persist.radio.cdma.nai"});
                }
            }
        } catch (Exception e) {
            BLog.a("MmsLib", "SystemProperties.get failed " + e);
        }
        return null;
    }
}
