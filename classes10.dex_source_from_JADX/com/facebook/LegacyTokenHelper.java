package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: eventDashboardCelebrations */
final class LegacyTokenHelper {
    private static final String f13830a = LegacyTokenHelper.class.getSimpleName();
    private String f13831b;
    private SharedPreferences f13832c;

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    private LegacyTokenHelper(Context context, String str) {
        Validate.m25366a((Object) context, "context");
        if (Utility.m25345a(str)) {
            str = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        this.f13831b = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f13832c = context.getSharedPreferences(this.f13831b, 0);
    }

    public final Bundle m14129a() {
        Bundle bundle = new Bundle();
        for (String str : this.f13832c.getAll().keySet()) {
            try {
                m14125a(str, bundle);
            } catch (JSONException e) {
                Logger.m25274a(LoggingBehavior.CACHE, 5, f13830a, "Error reading cached value for key: '" + str + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public final void m14130b() {
        this.f13832c.edit().clear().apply();
    }

    public static String m14126b(Bundle bundle) {
        Validate.m25366a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static AccessTokenSource m14127c(Bundle bundle) {
        Validate.m25366a((Object) bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (AccessTokenSource) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static String m14128d(Bundle bundle) {
        Validate.m25366a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    static Date m14124a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j != Long.MIN_VALUE) {
            return new Date(j);
        }
        return null;
    }

    private void m14125a(String str, Bundle bundle) {
        int i = 0;
        JSONObject jSONObject = new JSONObject(this.f13832c.getString(str, "{}"));
        String string = jSONObject.getString("valueType");
        if (string.equals("bool")) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
        } else if (string.equals("bool[]")) {
            r1 = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[r1.length()];
            while (i < zArr.length) {
                zArr[i] = r1.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
        } else if (string.equals("byte")) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
        } else if (string.equals("byte[]")) {
            r1 = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[r1.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) r1.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
        } else if (string.equals("short")) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
        } else if (string.equals("short[]")) {
            r1 = jSONObject.getJSONArray("value");
            short[] sArr = new short[r1.length()];
            while (i < sArr.length) {
                sArr[i] = (short) r1.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
        } else if (string.equals("int")) {
            bundle.putInt(str, jSONObject.getInt("value"));
        } else if (string.equals("int[]")) {
            r1 = jSONObject.getJSONArray("value");
            int[] iArr = new int[r1.length()];
            while (i < iArr.length) {
                iArr[i] = r1.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
        } else if (string.equals("long")) {
            bundle.putLong(str, jSONObject.getLong("value"));
        } else if (string.equals("long[]")) {
            r1 = jSONObject.getJSONArray("value");
            long[] jArr = new long[r1.length()];
            while (i < jArr.length) {
                jArr[i] = r1.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
        } else if (string.equals("float")) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
        } else if (string.equals("float[]")) {
            r1 = jSONObject.getJSONArray("value");
            float[] fArr = new float[r1.length()];
            while (i < fArr.length) {
                fArr[i] = (float) r1.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
        } else if (string.equals("double")) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
        } else if (string.equals("double[]")) {
            r1 = jSONObject.getJSONArray("value");
            double[] dArr = new double[r1.length()];
            while (i < dArr.length) {
                dArr[i] = r1.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
        } else if (string.equals("char")) {
            string = jSONObject.getString("value");
            if (string != null && string.length() == 1) {
                bundle.putChar(str, string.charAt(0));
            }
        } else if (string.equals("char[]")) {
            r2 = jSONObject.getJSONArray("value");
            char[] cArr = new char[r2.length()];
            for (r1 = 0; r1 < cArr.length; r1++) {
                String string2 = r2.getString(r1);
                if (string2 != null && string2.length() == 1) {
                    cArr[r1] = string2.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
        } else if (string.equals("string")) {
            bundle.putString(str, jSONObject.getString("value"));
        } else if (string.equals("stringList")) {
            r2 = jSONObject.getJSONArray("value");
            int length = r2.length();
            ArrayList arrayList = new ArrayList(length);
            for (r1 = 0; r1 < length; r1++) {
                Object obj = r2.get(r1);
                if (obj == JSONObject.NULL) {
                    obj = null;
                } else {
                    String str2 = (String) obj;
                }
                arrayList.add(r1, obj);
            }
            bundle.putStringArrayList(str, arrayList);
        } else if (string.equals("enum")) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString("enumType")), jSONObject.getString("value")));
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }
}
