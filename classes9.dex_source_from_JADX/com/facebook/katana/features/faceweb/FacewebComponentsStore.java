package com.facebook.katana.features.faceweb;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.asserts.Assert;
import com.facebook.debug.log.BLog;
import com.facebook.webview.FacewebPalCall;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Maps;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = FacewebComponentsStoreDeserializer.class)
@JsonSerialize(using = FacewebComponentsStoreSerializer.class)
/* compiled from: p2p_pin_deleted */
public class FacewebComponentsStore implements Serializable {
    private static final Class<?> f7554a;
    public static final String f7555b;
    private static final long serialVersionUID = 6103150430480349539L;
    private Skeleton mSkeleton;
    @JsonProperty("components")
    String mSkeletonString;
    @JsonProperty("version")
    String mVersion;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FacewebComponentsStore_FacewebComponentsRuleDeserializer.class)
    /* compiled from: p2p_pin_deleted */
    public class FacewebComponentsRule implements Serializable {
        private static final long serialVersionUID = -1980626292213325598L;
        @JsonProperty("componentsId")
        public String mComponentsId;
        @JsonProperty("continueSearch")
        public boolean mContinueSearch;
        @JsonProperty("parameters")
        private Map<String, String> mParameters;
        @JsonProperty("path")
        private String mPathRegex;

        public final boolean m7839a(String str) {
            Uri parse = Uri.parse(str);
            if (this.mPathRegex != null) {
                if (parse.getPath() == null) {
                    return false;
                }
                if (!Pattern.matches(this.mPathRegex, parse.getPath())) {
                    return false;
                }
            }
            if (this.mParameters != null) {
                for (Entry entry : this.mParameters.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        BLog.b(FacewebComponentsStore.f7555b, "Null regex for param in rule %s", new Object[]{toString()});
                        return false;
                    }
                    if (!(value instanceof String)) {
                        BLog.b(FacewebComponentsStore.f7555b, "Non-string regex for param in rule %s", new Object[]{toString()});
                    }
                    String obj = value.toString();
                    CharSequence queryParameter = parse.getQueryParameter(str2);
                    if (queryParameter == null) {
                        return false;
                    }
                    if (!Pattern.matches(obj, queryParameter)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public String toString() {
            return "Rule<path=" + this.mPathRegex + ", components=" + this.mComponentsId + ", params=" + String.valueOf(this.mParameters) + ">";
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FacewebComponentsStore_FacewebSkeletonPalCallDeserializer.class)
    /* compiled from: p2p_pin_deleted */
    public class FacewebSkeletonPalCall implements FacewebPalCall, Serializable {
        private static final long serialVersionUID = 9191065373181002164L;
        @JsonProperty("method")
        public String mMethod = null;
        @JsonProperty("params")
        public Map<String, Object> mParams = Maps.c();

        private FacewebSkeletonPalCall() {
        }

        public String toString() {
            return StringFormatUtil.formatStrLocaleSafe("PalCall<method=%s, params=%s>", this.mMethod, this.mParams);
        }

        public final String mo92a() {
            return this.mMethod;
        }

        public final long mo91a(String str, String str2, long j) {
            String a = mo93a(str, str2);
            if (!TextUtils.isEmpty(a)) {
                try {
                    j = Long.parseLong(a);
                } catch (NumberFormatException e) {
                    if (BuildConstants.e()) {
                        throw new NumberFormatException("Failed to parse long from " + a);
                    }
                }
            }
            return j;
        }

        public final String mo93a(String str, String str2) {
            String str3 = null;
            if (this.mParams == null || str2 == null) {
                return null;
            }
            Object obj = this.mParams.get(str2);
            if (obj != null) {
                str3 = obj.toString();
            }
            if (str3 == null || str == null || str3.length() <= 1 || str3.charAt(0) != '@') {
                return str3;
            }
            str3 = Uri.parse(str).getQueryParameter(str3.substring(1));
            if (str3 == null) {
                return "";
            }
            return str3;
        }

        public final String mo94a(String str, String str2, String str3) {
            String str4 = null;
            if (m7840a(str2)) {
                str4 = mo93a(str, str2);
            }
            return str4 != null ? str4 : str3;
        }

        private boolean m7840a(String str) {
            return this.mParams.containsKey(str);
        }
    }

    /* compiled from: p2p_pin_deleted */
    class LiberalDeserializer extends ObjectInputStream {
        private static final Class<?> f7553a = LiberalDeserializer.class;

        public LiberalDeserializer(InputStream inputStream) {
            super(inputStream);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected java.lang.Class<?> resolveClass(java.io.ObjectStreamClass r7) {
            /*
            r6 = this;
            r0 = super.resolveClass(r7);	 Catch:{ ClassNotFoundException -> 0x0005 }
        L_0x0004:
            return r0;
        L_0x0005:
            r2 = move-exception;
            r0 = 0;
            r1 = com.facebook.common.build.BuildConstants.n();	 Catch:{ Throwable -> 0x009e }
            r3 = r7.getName();	 Catch:{ Throwable -> 0x009e }
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e }
            r4.<init>();	 Catch:{ Throwable -> 0x009e }
            r4 = r4.append(r1);	 Catch:{ Throwable -> 0x009e }
            r5 = ".features.faceweb.FacewebComponentsStore";
            r4 = r4.append(r5);	 Catch:{ Throwable -> 0x009e }
            r4 = r4.toString();	 Catch:{ Throwable -> 0x009e }
            r4 = r4.equals(r3);	 Catch:{ Throwable -> 0x009e }
            if (r4 == 0) goto L_0x0045;
        L_0x0028:
            r0 = com.facebook.katana.features.faceweb.FacewebComponentsStore.class;
        L_0x002a:
            r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e }
            r4 = "failed in retrieving ";
            r1.<init>(r4);	 Catch:{ Throwable -> 0x009e }
            r1 = r1.append(r3);	 Catch:{ Throwable -> 0x009e }
            r3 = "; replacing with ";
            r3 = r1.append(r3);	 Catch:{ Throwable -> 0x009e }
            if (r0 != 0) goto L_0x0099;
        L_0x003d:
            r1 = "(null)";
        L_0x003f:
            r3.append(r1);	 Catch:{ Throwable -> 0x009e }
            if (r0 != 0) goto L_0x0004;
        L_0x0044:
            throw r2;
        L_0x0045:
            r4 = new java.lang.StringBuilder;	 Catch:{  }
            r4.<init>();	 Catch:{  }
            r4 = r4.append(r1);	 Catch:{  }
            r5 = ".features.faceweb.FacewebComponentsStore$Skeleton";
            r4 = r4.append(r5);	 Catch:{  }
            r4 = r4.toString();	 Catch:{  }
            r4 = r4.equals(r3);	 Catch:{  }
            if (r4 == 0) goto L_0x0061;
        L_0x005e:
            r0 = com.facebook.katana.features.faceweb.FacewebComponentsStore.Skeleton.class;
            goto L_0x002a;
        L_0x0061:
            r4 = new java.lang.StringBuilder;	 Catch:{  }
            r4.<init>();	 Catch:{  }
            r4 = r4.append(r1);	 Catch:{  }
            r5 = ".features.faceweb.FacewebComponentsStore$FacewebSkeletonPalCall";
            r4 = r4.append(r5);	 Catch:{  }
            r4 = r4.toString();	 Catch:{  }
            r4 = r4.equals(r3);	 Catch:{  }
            if (r4 == 0) goto L_0x007d;
        L_0x007a:
            r0 = com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebSkeletonPalCall.class;
            goto L_0x002a;
        L_0x007d:
            r4 = new java.lang.StringBuilder;	 Catch:{  }
            r4.<init>();	 Catch:{  }
            r1 = r4.append(r1);	 Catch:{  }
            r4 = ".features.faceweb.FacewebComponentsStore$FacewebComponentsRule";
            r1 = r1.append(r4);	 Catch:{  }
            r1 = r1.toString();	 Catch:{  }
            r1 = r1.equals(r3);	 Catch:{  }
            if (r1 == 0) goto L_0x002a;
        L_0x0096:
            r0 = com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebComponentsRule.class;
            goto L_0x002a;
        L_0x0099:
            r1 = r0.getCanonicalName();	 Catch:{  }
            goto L_0x003f;
        L_0x009e:
            r0 = move-exception;
            r1 = f7553a;
            r1 = r1.getSimpleName();
            r3 = "exception in bandaid";
            com.facebook.debug.log.BLog.b(r1, r3, r0);
            goto L_0x0044;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.features.faceweb.FacewebComponentsStore.LiberalDeserializer.resolveClass(java.io.ObjectStreamClass):java.lang.Class<?>");
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FacewebComponentsStore_SkeletonDeserializer.class)
    /* compiled from: p2p_pin_deleted */
    public class Skeleton implements Serializable {
        private static final long serialVersionUID = 468570040805259928L;
        @JsonProperty("components")
        public Map<String, List<FacewebSkeletonPalCall>> mComponents;
        @JsonProperty("rules")
        public List<FacewebComponentsRule> mRules;

        protected Skeleton() {
        }
    }

    static {
        Class cls = FacewebComponentsStore.class;
        f7554a = cls;
        f7555b = cls.getSimpleName();
    }

    private Skeleton m7851c() {
        if (this.mSkeleton == null) {
            this.mSkeleton = (Skeleton) FbObjectMapper.i().a(this.mSkeletonString, Skeleton.class);
        }
        return this.mSkeleton;
    }

    public final List<FacewebSkeletonPalCall> m7854a(String str) {
        List<FacewebSkeletonPalCall> arrayList = new ArrayList();
        Skeleton c = m7851c();
        if (c == null) {
            return arrayList;
        }
        Assert.a(c.mRules);
        for (FacewebComponentsRule facewebComponentsRule : c.mRules) {
            if (facewebComponentsRule.m7839a(str)) {
                arrayList.addAll((List) c.mComponents.get(facewebComponentsRule.mComponentsId));
                if (!facewebComponentsRule.mContinueSearch) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public final String m7852a() {
        return this.mVersion;
    }

    public static FacewebComponentsStore m7848a(String str, JsonFactory jsonFactory) {
        return m7847a(jsonFactory.a(str));
    }

    private static FacewebComponentsStore m7847a(JsonParser jsonParser) {
        return (FacewebComponentsStore) jsonParser.a(FacewebComponentsStore.class);
    }

    public final String m7853a(ObjectMapper objectMapper) {
        return objectMapper.a(this);
    }

    public static FacewebComponentsStore m7849a(String str, ObjectMapper objectMapper) {
        if (str == null) {
            throw new IOException("Cannot deserialize FacewebComponentStore from a null String");
        }
        try {
            return (FacewebComponentsStore) objectMapper.a(str, FacewebComponentsStore.class);
        } catch (Exception e) {
            try {
                return (FacewebComponentsStore) new LiberalDeserializer(new GZIPInputStream(new ByteArrayInputStream(Base64.decode(str, 0)))).readObject();
            } catch (Throwable e2) {
                throw new IOException("Could not deserialize FacewebComponentStore, class not found", e2);
            } catch (Throwable e22) {
                throw new IOException("Could not deserialize FacewebComponentStore, bad base64 input", e22);
            }
        }
    }
}
