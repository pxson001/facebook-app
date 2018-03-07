package com.facebook.common.errorreporting.memory;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.common.stringformat.StringFormatUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: uAlpha */
public class MemoryDumpUploadMethodParams {
    public final File f1170a;
    public final int f1171b;
    public final String f1172c;
    private final int f1173d;
    private final String f1174e;
    private final int f1175f;
    private final String f1176g;
    private final String f1177h;
    private final String f1178i;
    private final String f1179j;
    private final String f1180k;
    private final String f1181l;
    private final String f1182m;
    private final String f1183n;
    private final String f1184o;

    /* compiled from: uAlpha */
    public final class Builder {
        private final File f1155a;
        private int f1156b;
        private String f1157c;
        private int f1158d;
        private String f1159e = Build.BRAND;
        private int f1160f;
        private String f1161g = Build.MODEL;
        private String f1162h = VERSION.RELEASE;
        private String f1163i;
        private String f1164j;
        private String f1165k;
        private String f1166l;
        private String f1167m;
        private String f1168n;
        private String f1169o;

        public Builder(File file) {
            this.f1155a = file;
        }

        public final Builder m1243a(int i) {
            this.f1158d = i;
            return this;
        }

        public final Builder m1246b(int i) {
            this.f1156b = i;
            return this;
        }

        public final Builder m1244a(String str) {
            this.f1157c = str;
            return this;
        }

        public final Builder m1248c(int i) {
            this.f1160f = i;
            return this;
        }

        public final Builder m1247b(String str) {
            this.f1163i = str;
            return this;
        }

        public final Builder m1249c(String str) {
            this.f1164j = str;
            return this;
        }

        public final Builder m1250d(String str) {
            this.f1165k = str;
            return this;
        }

        public final Builder m1251e(String str) {
            this.f1166l = str;
            return this;
        }

        public final Builder m1252f(String str) {
            this.f1167m = str;
            return this;
        }

        public final Builder m1253g(String str) {
            this.f1168n = str;
            return this;
        }

        public final Builder m1254h(String str) {
            this.f1169o = str;
            return this;
        }

        public final MemoryDumpUploadMethodParams m1245a() {
            return new MemoryDumpUploadMethodParams(this.f1155a, this.f1157c, this.f1156b, this.f1158d, this.f1159e, this.f1160f, this.f1161g, this.f1162h, this.f1163i, this.f1164j, this.f1165k, this.f1166l, this.f1167m, this.f1168n, this.f1169o);
        }
    }

    private MemoryDumpUploadMethodParams(File file, String str, int i, int i2, String str2, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f1170a = file;
        this.f1171b = i;
        this.f1172c = str;
        this.f1173d = i2;
        this.f1174e = str2;
        this.f1175f = i3;
        this.f1176g = str3;
        this.f1177h = str4;
        this.f1178i = str5;
        this.f1179j = str6;
        this.f1180k = str7;
        this.f1181l = str8;
        this.f1182m = str9;
        this.f1183n = str10;
        this.f1184o = str11;
    }

    public final String m1255d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_version_code", this.f1173d);
            jSONObject.put("brand", this.f1174e);
            jSONObject.put("memclass", this.f1175f);
            jSONObject.put("model", this.f1176g);
            jSONObject.put("android_version", this.f1177h);
            jSONObject.put("app_version_name", this.f1178i);
            jSONObject.put("app", this.f1179j);
            jSONObject.put("process_name", this.f1180k);
            jSONObject.put("uid", this.f1181l);
            jSONObject.put("dump_cause", this.f1182m);
            jSONObject.put("background", this.f1183n);
            jSONObject.put("was_foreground", this.f1184o);
            return jSONObject.toString();
        } catch (JSONException e) {
            return StringFormatUtil.formatStrLocaleSafe("{ 'error' : '%s' }", e.getMessage());
        }
    }
}
