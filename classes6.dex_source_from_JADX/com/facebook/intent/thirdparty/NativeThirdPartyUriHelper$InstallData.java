package com.facebook.intent.thirdparty;

import android.content.Context;
import android.os.Bundle;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: mCommunicationRank */
public class NativeThirdPartyUriHelper$InstallData {
    private static JSONObject f11222a = null;

    private static JSONObject m18108a(Context context) {
        if (f11222a == null) {
            try {
                f11222a = new JSONObject(Charsets.UTF_8.decode(ByteBuffer.wrap(Files.b(new File(context.getFilesDir(), "platform.installdata")))).toString());
            } catch (IOException e) {
            } catch (JSONException e2) {
            }
            if (f11222a == null) {
                f11222a = new JSONObject();
            }
        }
        return f11222a;
    }

    private static void m18110b(Context context) {
        if (f11222a != null) {
            try {
                Files.a(Charsets.UTF_8.encode(CharBuffer.wrap(f11222a.toString().toCharArray())).array(), new File(context.getFilesDir(), "platform.installdata"));
                return;
            } catch (IOException e) {
                return;
            }
        }
        new File("platform.installdata").delete();
    }

    public static void m18109a(String str, String str2, Context context) {
        JSONObject a = m18108a(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.platform.APPLINK_ARGS", str);
            jSONObject.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", System.currentTimeMillis());
            a.put(str2, jSONObject);
        } catch (JSONException e) {
        }
        m18110b(context);
    }

    private static void m18111b(String str, Context context) {
        m18108a(context).remove(str);
        m18110b(context);
    }

    public static Bundle m18107a(String str, Context context) {
        Bundle bundle;
        try {
            JSONObject jSONObject = (JSONObject) m18108a(context).get(str);
            Bundle bundle2 = new Bundle();
            bundle2.putString("com.facebook.platform.APPLINK_ARGS", jSONObject.getString("com.facebook.platform.APPLINK_ARGS"));
            bundle2.putLong("com.facebook.platform.APPLINK_TAP_TIME_UTC", jSONObject.getLong("com.facebook.platform.APPLINK_TAP_TIME_UTC"));
            bundle = bundle2;
        } catch (JSONException e) {
            bundle = null;
        }
        m18111b(str, context);
        return bundle;
    }
}
