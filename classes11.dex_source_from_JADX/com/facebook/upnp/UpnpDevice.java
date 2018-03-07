package com.facebook.upnp;

import android.support.annotation.Nullable;
import android.util.Xml;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.google.common.collect.ImmutableSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: nearby/ */
public class UpnpDevice {
    private static final Class<?> f5256h = UpnpDevice.class;
    private static final ImmutableSet<String> f5257i = ImmutableSet.of("CACHE-CONTROL", "DATE", "EXT", "LOCATION", "SERVER", "ST", new String[]{"USN", "BOOTID.UPNP.ORG", "CONFIGID.UPNP.ORG", "SEARCHPORT.UPNP.ORG"});
    private static final ImmutableSet<String> f5258j = ImmutableSet.of("CACHE-CONTROL", "DATE");
    private static final ImmutableSet<String> f5259k = ImmutableSet.of("CACHE-CONTROL", "LOCATION", "SERVER", "ST");
    private static final ImmutableSet<String> f5260l = ImmutableSet.of("friendlyName", "deviceType", "manufacturer", "modelName", "modelNumber");
    public String f5261a;
    public String f5262b;
    public String f5263c;
    public String f5264d;
    public String f5265e;
    public long f5266f = 1;
    public final Map<String, String> f5267g = new TreeMap();

    /* compiled from: nearby/ */
    class C06861 implements ResponseHandler<String> {
        final /* synthetic */ UpnpDevice f5255a;

        C06861(UpnpDevice upnpDevice) {
            this.f5255a = upnpDevice;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(readLine);
            }
        }
    }

    @Nullable
    public final String m6516a() {
        return (String) this.f5267g.get("USN");
    }

    public final String m6519b() {
        return this.f5263c;
    }

    protected final String m6520c() {
        if (this.f5264d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : this.f5267g.entrySet()) {
                if (!(f5258j.contains(entry.getKey()) || f5260l.contains(entry.getKey()))) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append(":");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append("\r\n");
                }
            }
            this.f5264d = m6515b(stringBuilder.toString());
        }
        return this.f5264d;
    }

    protected final String m6521d() {
        if (this.f5265e == null) {
            this.f5265e = m6515b(this.f5262b == null ? "" : this.f5262b);
        }
        return this.f5265e;
    }

    public final boolean m6518a(UpnpDevice upnpDevice) {
        if (m6516a() == null || upnpDevice.m6516a() == null || !m6516a().equals(upnpDevice.m6516a())) {
            return false;
        }
        for (Entry entry : upnpDevice.f5267g.entrySet()) {
            if (!this.f5267g.containsKey(entry.getKey())) {
                this.f5267g.put(entry.getKey(), entry.getValue());
                this.f5264d = null;
            } else if (!((String) entry.getValue()).equals(this.f5267g.get(entry.getKey()))) {
                entry.getKey();
                entry.getValue();
                this.f5267g.get(entry.getKey());
            }
        }
        this.f5266f++;
        return true;
    }

    public static UpnpDevice m6513a(List<String> list) {
        UpnpDevice upnpDevice = new UpnpDevice();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : list) {
            stringBuilder.append(str);
            stringBuilder.append("\r\n");
            int indexOf = str.indexOf(58);
            String trim = str.substring(0, indexOf).toUpperCase(Locale.US).trim();
            String str2 = str2.substring(indexOf + 1).trim();
            f5257i.contains(trim);
            if (trim.equals("SERVER")) {
                upnpDevice.f5261a = str2;
            }
            upnpDevice.f5267g.put(trim, str2);
        }
        upnpDevice.f5263c = stringBuilder.toString();
        return upnpDevice;
    }

    private static final Map<String, String> m6514a(String str) {
        Map<String, String> treeMap = new TreeMap();
        XmlPullParser newPullParser = Xml.newPullParser();
        Object obj = "";
        try {
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        obj = newPullParser.getName();
                        break;
                    case 3:
                        obj = "";
                        break;
                    case 4:
                        if (!f5260l.contains(obj)) {
                            break;
                        }
                        treeMap.put(obj, newPullParser.getText());
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            BLog.b(f5256h, e, "XML Error", new Object[0]);
        } catch (Throwable e2) {
            BLog.b(f5256h, e2, "XML Error", new Object[0]);
        }
        return treeMap;
    }

    public final boolean m6517a(FbHttpRequestProcessor fbHttpRequestProcessor) {
        String str = (String) this.f5267g.get("LOCATION");
        if (str == null) {
            return false;
        }
        try {
            this.f5262b = (String) fbHttpRequestProcessor.a(FbHttpRequest.newBuilder().a(new HttpGet(str)).a(CallerContext.a(getClass())).a("fetch_upnp_device_data").a(new C06861(this)).a());
            this.f5267g.putAll(m6514a(this.f5262b));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String m6515b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8")));
            for (int i = 0; i < digest.length; i++) {
                String toHexString = Integer.toHexString(digest[i] & 255);
                if ((digest[i] & 255) < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            BLog.b(f5256h, e, "No MD5 available!", new Object[0]);
            return "";
        }
    }
}
