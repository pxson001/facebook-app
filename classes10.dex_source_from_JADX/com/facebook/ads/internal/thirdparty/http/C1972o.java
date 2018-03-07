package com.facebook.ads.internal.thirdparty.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C1972o implements Map<String, String> {
    private Map<String, String> f14298a = new HashMap();

    public final C1972o m14438a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    public final String m14439a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f14298a.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str);
            String str2 = (String) this.f14298a.get(str2);
            if (str2 != null) {
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public final byte[] m14440b() {
        byte[] bArr = null;
        try {
            bArr = m14439a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public void clear() {
        this.f14298a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f14298a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f14298a.containsValue(obj);
    }

    public Set<Entry<String, String>> entrySet() {
        return this.f14298a.entrySet();
    }

    public Object get(Object obj) {
        return (String) this.f14298a.get(obj);
    }

    public boolean isEmpty() {
        return this.f14298a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f14298a.keySet();
    }

    public Object put(Object obj, Object obj2) {
        return (String) this.f14298a.put((String) obj, (String) obj2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f14298a.putAll(map);
    }

    public Object remove(Object obj) {
        return (String) this.f14298a.remove(obj);
    }

    public int size() {
        return this.f14298a.size();
    }

    public Collection<String> values() {
        return this.f14298a.values();
    }
}
