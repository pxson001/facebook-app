package com.facebook.credentials;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.xconfig.core.XConfigReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: fb4a_iab_video_log */
public class AuthTokenDebugLogger extends BroadcastReceiver {
    private static int f7213c = -1;
    private AnalyticsLogger f7214a;
    private XConfigReader f7215b;

    public static native String getCurrentAuthToken(int i);

    public void onReceive(Context context, Intent intent) {
        JSONObject jSONObject;
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1221691547);
        f7213c++;
        this.f7214a = AnalyticsLoggerMethodAutoProvider.a(FbInjector.get(context));
        this.f7215b = XConfigReader.a(FbInjector.get(context));
        boolean a2 = this.f7215b.a(AuthTokenXConfig.g, true);
        int a3 = this.f7215b.a(AuthTokenXConfig.d, 5);
        int a4 = this.f7215b.a(AuthTokenXConfig.e, 300);
        int a5 = this.f7215b.a(AuthTokenXConfig.f, 3);
        if (a2) {
            Object currentAuthToken;
            HoneyClientEvent honeyClientEvent;
            Bundle extras;
            Map hashMap;
            Log.i("fb4a-AuthTokenDebugLogger", "Getting auth token from datastore");
            try {
                Class.forName("com.facebook.credentials.AuthTokenStore");
            } catch (Throwable e) {
                Log.i("fb4a-AuthTokenDebugLogger", "Running in prod - should this be happening?", e);
            }
            int intExtra = intent.getIntExtra("debugId", -1);
            int intExtra2 = intent.getIntExtra("keyId", -1);
            if (intExtra2 == -1 || intExtra == -1) {
                Log.w("fb4a-AuthTokenDebugLogger", "keyId or debugId not supplied");
            }
            int i = 0;
            if (intExtra > 1000000 && intExtra < 2000000) {
                i = 1241382912;
            }
            String str = "notoken";
            if ((i & intExtra2) != 0) {
                try {
                    currentAuthToken = getCurrentAuthToken(intExtra2);
                } catch (Throwable e2) {
                    Log.e("fb4a-AuthTokenDebugLogger", "More parameters are required", e2);
                }
                Log.d("fb4a-AuthTokenDebugLogger", StringFormatUtil.formatStrLocaleSafe("App secure credentials: %s(0x%X)", currentAuthToken, Integer.valueOf(intExtra2)));
                if (f7213c < a3 && f7213c < a4 && Math.random() >= 1.0d / ((double) a5)) {
                    LogUtils.a(intent, 2015377999, a);
                    return;
                } else if (f7213c < a4) {
                    LogUtils.a(intent, 818396524, a);
                    return;
                } else {
                    honeyClientEvent = new HoneyClientEvent("honey_auth_debug");
                    jSONObject = new JSONObject();
                    extras = intent.getExtras();
                    if (extras != null) {
                        for (String str2 : extras.keySet()) {
                            try {
                                jSONObject.put(str2, extras.get(str2));
                            } catch (JSONException e3) {
                                try {
                                    jSONObject.put(str2, "(error: " + e3.getMessage() + ")");
                                } catch (JSONException e4) {
                                }
                            }
                        }
                    }
                    hashMap = new HashMap();
                    hashMap.put("extras", jSONObject.toString());
                    hashMap.put("action", intent.getAction());
                    hashMap.put("data", intent.getDataString());
                    hashMap.put("scheme", intent.getScheme());
                    hashMap.put("flags", String.valueOf(intent.getFlags()));
                    hashMap.put("type", intent.getType());
                    honeyClientEvent.a(hashMap);
                    honeyClientEvent.g("AuthTokenDebugLogger");
                    this.f7214a.c(honeyClientEvent);
                    LogUtils.a(intent, 257684676, a);
                    return;
                }
            }
            String str22 = str;
            Log.d("fb4a-AuthTokenDebugLogger", StringFormatUtil.formatStrLocaleSafe("App secure credentials: %s(0x%X)", currentAuthToken, Integer.valueOf(intExtra2)));
            if (f7213c < a3) {
            }
            if (f7213c < a4) {
                honeyClientEvent = new HoneyClientEvent("honey_auth_debug");
                jSONObject = new JSONObject();
                extras = intent.getExtras();
                if (extras != null) {
                    for (String str222 : extras.keySet()) {
                        jSONObject.put(str222, extras.get(str222));
                    }
                }
                hashMap = new HashMap();
                hashMap.put("extras", jSONObject.toString());
                hashMap.put("action", intent.getAction());
                hashMap.put("data", intent.getDataString());
                hashMap.put("scheme", intent.getScheme());
                hashMap.put("flags", String.valueOf(intent.getFlags()));
                hashMap.put("type", intent.getType());
                honeyClientEvent.a(hashMap);
                honeyClientEvent.g("AuthTokenDebugLogger");
                this.f7214a.c(honeyClientEvent);
                LogUtils.a(intent, 257684676, a);
                return;
            }
            LogUtils.a(intent, 818396524, a);
            return;
        }
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -477658724, a);
    }
}
