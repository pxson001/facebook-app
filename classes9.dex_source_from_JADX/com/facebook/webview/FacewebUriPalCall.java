package com.facebook.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

/* compiled from: shipping_price */
public class FacewebUriPalCall implements FacewebPalCall {
    public final UUID f3514a;
    public final Uri f3515b;
    private final String f3516c;

    /* compiled from: shipping_price */
    public class JsVariable implements Serializable {
        private String mVarName;

        public JsVariable(String str) {
            this.mVarName = str;
        }

        public String toString() {
            return this.mVarName;
        }
    }

    public static String m3319a(String str, String str2, UUID uuid, UUID uuid2, String str3, Map<String, Serializable> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("'%s://%s/", str, str2));
        if (uuid != null) {
            stringBuilder.append(uuid.toString()).append("/");
        }
        if (uuid2 != null) {
            stringBuilder.append(uuid2.toString()).append("/");
        }
        stringBuilder.append(str3).append("/'");
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            Object obj2;
            if (obj != null) {
                stringBuilder.append(" + '?' + ");
                obj2 = null;
            } else {
                stringBuilder.append(" + '&' + ");
                obj2 = obj;
            }
            String str4 = (String) entry.getKey();
            Serializable serializable = (Serializable) entry.getValue();
            stringBuilder.append("'").append(Uri.encode(str4)).append("=' + ");
            if (serializable instanceof JsVariable) {
                stringBuilder.append("encodeURIComponent(").append(serializable).append(")");
                obj = obj2;
            } else {
                stringBuilder.append("'").append(Uri.encode(serializable.toString())).append("'");
                obj = obj2;
            }
        }
        return stringBuilder.toString();
    }

    public FacewebUriPalCall(Uri uri) {
        this.f3515b = uri;
        List pathSegments = this.f3515b.getPathSegments();
        if (pathSegments.size() == 3) {
            this.f3514a = UUID.fromString((String) pathSegments.get(1));
        } else {
            this.f3514a = null;
        }
        this.f3516c = uri.getLastPathSegment();
    }

    public final String mo92a() {
        return this.f3516c;
    }

    public final long mo91a(String str, String str2, long j) {
        String a = mo93a(str, str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
                BLog.a("FacebookRpcCall", "failed to parse long: " + a);
            }
        }
        return j;
    }

    public final String mo93a(String str, String str2) {
        if (this.f3515b == null) {
            return null;
        }
        String queryParameter = this.f3515b.getQueryParameter(str2);
        if (queryParameter != null && str != null && queryParameter.length() > 1 && queryParameter.charAt(0) == '@') {
            String queryParameter2 = Uri.parse(str).getQueryParameter(queryParameter.substring(1));
            if (queryParameter2 != null) {
                return queryParameter2;
            }
        }
        return queryParameter;
    }

    public final String mo94a(String str, String str2, String str3) {
        String a = mo93a(str, str2);
        return a != null ? a : str3;
    }
}
