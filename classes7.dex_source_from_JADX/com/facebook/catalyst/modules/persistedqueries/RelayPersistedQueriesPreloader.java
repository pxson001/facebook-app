package com.facebook.catalyst.modules.persistedqueries;

import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: unknown msg  */
public class RelayPersistedQueriesPreloader {
    @Nullable
    private static RelayPersistedQueriesPreloader f1093a;
    @GuardedBy("mLock")
    private final Set<String> f1094b = new HashSet();
    @GuardedBy("mLock")
    private final Map<String, Map<String, Integer>> f1095c = new HashMap();
    @GuardedBy("mLock")
    private final Set<EntryResult> f1096d = new HashSet();
    private final Object f1097e = new Object();
    private final PersistedQueryRequestCallback f1098f = new PersistedQueryRequestCallback(this);
    @Nullable
    private RCTDeviceEventEmitter f1099g;

    /* compiled from: unknown msg  */
    class EntryResult {
        private final String f1089a;
        @Nullable
        private final JSONObject f1090b;
        @Nullable
        private final String f1091c;

        public EntryResult(String str, @Nullable JSONObject jSONObject, @Nullable String str2) {
            this.f1089a = str;
            this.f1090b = jSONObject;
            this.f1091c = str2;
        }

        public final String m1054a() {
            return this.f1089a;
        }

        @Nullable
        public final JSONObject m1055b() {
            return this.f1090b;
        }

        @Nullable
        public final String m1056c() {
            return this.f1091c;
        }
    }

    /* compiled from: unknown msg  */
    public class PersistedQueryRequestCallback {
        final /* synthetic */ RelayPersistedQueriesPreloader f1092a;

        public PersistedQueryRequestCallback(RelayPersistedQueriesPreloader relayPersistedQueriesPreloader) {
            this.f1092a = relayPersistedQueriesPreloader;
        }

        public final void m1057a(String str, String str2) {
            RelayPersistedQueriesPreloader.m1060a(this.f1092a, str, str2);
            RelayPersistedQueriesPreloader.m1063b(this.f1092a);
        }

        public final void m1058a(String str, Throwable th) {
            RelayPersistedQueriesPreloader.m1064b(this.f1092a, str, th.getLocalizedMessage());
            RelayPersistedQueriesPreloader.m1063b(this.f1092a);
        }
    }

    private RelayPersistedQueriesPreloader() {
    }

    public static synchronized RelayPersistedQueriesPreloader m1059a() {
        RelayPersistedQueriesPreloader relayPersistedQueriesPreloader;
        synchronized (RelayPersistedQueriesPreloader.class) {
            if (f1093a == null) {
                f1093a = new RelayPersistedQueriesPreloader();
            }
            relayPersistedQueriesPreloader = f1093a;
        }
        return relayPersistedQueriesPreloader;
    }

    public final void m1067a(Context context, String str, String str2, Map<String, Object> map, RelayPersistedQueryRequestSender relayPersistedQueryRequestSender, boolean z) {
        int i = 3;
        JSONObject jSONObject = null;
        if (z) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("param", "after");
                jSONObject.put("import", "boundaryCursor");
                jSONObject.put("max_runs", 3);
            } catch (Throwable e) {
                FLog.a("React", "Error getting prefetch queries for " + str2, e);
                return;
            }
        }
        Map a = PersistedQueriesHelper.m1048a(context, str, str2, map, jSONObject);
        if (a == null) {
            FLog.a("React", "Entry " + str2 + " not found in " + str);
            return;
        }
        synchronized (this.f1097e) {
            Map hashMap = new HashMap();
            if (!z) {
                i = 0;
            }
            int i2 = i + 1;
            for (Entry entry : a.entrySet()) {
                hashMap.put(entry.getKey(), Integer.valueOf(i2));
                relayPersistedQueryRequestSender.m4209a(str2, (String) entry.getValue(), this.f1098f);
            }
            this.f1095c.put(str2, hashMap);
        }
    }

    public final void m1068a(RCTDeviceEventEmitter rCTDeviceEventEmitter, String str) {
        this.f1099g = rCTDeviceEventEmitter;
        synchronized (this.f1097e) {
            if (this.f1095c.containsKey(str)) {
                this.f1094b.add(str);
                m1063b(this);
                return;
            }
            m1066d(str, "Entry was not prefetched");
        }
    }

    public static void m1060a(RelayPersistedQueriesPreloader relayPersistedQueriesPreloader, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("successful_results")) {
                synchronized (relayPersistedQueriesPreloader.f1097e) {
                    relayPersistedQueriesPreloader.f1096d.add(new EntryResult(str, jSONObject, null));
                }
            } else if (jSONObject.optInt("error_results", 0) != 0 || jSONObject.optInt("skipped_results", 0) != 0) {
                m1064b(relayPersistedQueriesPreloader, str, "Some results have errors or have been skipped");
            }
        } catch (JSONException e) {
            m1064b(relayPersistedQueriesPreloader, str, e.getMessage());
        }
    }

    public static void m1064b(RelayPersistedQueriesPreloader relayPersistedQueriesPreloader, String str, String str2) {
        synchronized (relayPersistedQueriesPreloader.f1097e) {
            relayPersistedQueriesPreloader.f1096d.add(new EntryResult(str, null, str2));
        }
    }

    public static void m1063b(RelayPersistedQueriesPreloader relayPersistedQueriesPreloader) {
        synchronized (relayPersistedQueriesPreloader.f1097e) {
            Iterator it = relayPersistedQueriesPreloader.f1096d.iterator();
            while (it.hasNext()) {
                EntryResult entryResult = (EntryResult) it.next();
                if (relayPersistedQueriesPreloader.f1094b.contains(entryResult.m1054a())) {
                    it.remove();
                    String a = entryResult.m1054a();
                    if (!relayPersistedQueriesPreloader.f1095c.containsKey(a)) {
                        relayPersistedQueriesPreloader.m1065c(a, "Got response for entry that was not requested " + a);
                    } else if (entryResult.m1056c() != null) {
                        relayPersistedQueriesPreloader.m1065c(a, entryResult.m1056c());
                    } else {
                        try {
                            JSONObject jSONObject = (JSONObject) Assertions.b(entryResult.m1055b());
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                relayPersistedQueriesPreloader.m1062a(a, str, jSONObject.getJSONObject(str).toString());
                                Map map = (Map) Assertions.b(relayPersistedQueriesPreloader.f1095c.get(a));
                                if (map.containsKey(str)) {
                                    int intValue = ((Integer) map.get(str)).intValue() - 1;
                                    if (intValue == 0) {
                                        map.remove(str);
                                    } else {
                                        map.put(str, Integer.valueOf(intValue));
                                    }
                                    relayPersistedQueriesPreloader.f1095c.put(a, map);
                                } else {
                                    relayPersistedQueriesPreloader.m1065c(a, "Got response for query that was not requested " + str);
                                }
                            }
                            if (((Map) Assertions.b(relayPersistedQueriesPreloader.f1095c.get(a))).isEmpty()) {
                                relayPersistedQueriesPreloader.m1061a(a);
                                relayPersistedQueriesPreloader.f1095c.remove(a);
                                relayPersistedQueriesPreloader.f1094b.remove(a);
                            }
                        } catch (Exception e) {
                            relayPersistedQueriesPreloader.m1065c(a, e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private void m1065c(String str, String str2) {
        synchronized (this.f1097e) {
            m1066d(str, str2);
            this.f1095c.remove(str);
            this.f1094b.remove(str);
        }
    }

    private void m1061a(String str) {
        ((RCTDeviceEventEmitter) Assertions.b(this.f1099g)).emit("onCompletedPersistedRelayQuery", str);
    }

    private void m1066d(String str, String str2) {
        FLog.a("React", "Failed to prefetch " + str + ", cause: " + str2);
        WritableArray a = Arguments.m13384a();
        a.pushString(str);
        a.pushString(str2);
        ((RCTDeviceEventEmitter) Assertions.b(this.f1099g)).emit("onErrorPersistedRelayQuery", a);
    }

    private void m1062a(String str, String str2, String str3) {
        WritableArray a = Arguments.m13384a();
        a.pushString(str);
        a.pushString(str2);
        a.pushString(str3);
        ((RCTDeviceEventEmitter) Assertions.b(this.f1099g)).emit("onNextPersistedRelayQuery", a);
    }
}
