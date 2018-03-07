package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.internal.Validate;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: email_guest_ */
public class AppEventsLogger {
    public static final String f14520a = AppEventsLogger.class.getCanonicalName();
    public static Map<AccessTokenAppIdPair, SessionEventsState> f14521d = new ConcurrentHashMap();
    private static ScheduledThreadPoolExecutor f14522e;
    private static FlushBehavior f14523f = FlushBehavior.AUTO;
    private static boolean f14524g;
    public static Context f14525h;
    public static Object f14526i = new Object();
    private static String f14527j;
    public static boolean f14528k;
    private final String f14529b;
    private final AccessTokenAppIdPair f14530c;

    /* compiled from: email_guest_ */
    final class C20213 implements Runnable {
        C20213() {
        }

        public final void run() {
            if (AppEventsLogger.m14687a() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventsLogger.m14696c(FlushReason.TIMER);
            }
        }
    }

    /* compiled from: email_guest_ */
    final class C20224 implements Runnable {
        C20224() {
        }

        public final void run() {
            Set<String> hashSet = new HashSet();
            synchronized (AppEventsLogger.f14526i) {
                for (AccessTokenAppIdPair b : AppEventsLogger.f14521d.keySet()) {
                    hashSet.add(b.m14668b());
                }
            }
            for (String a : hashSet) {
                Utility.m25319a(a, true);
            }
        }
    }

    /* compiled from: email_guest_ */
    public final class C20235 implements Runnable {
        final /* synthetic */ Context f14499a;
        final /* synthetic */ AccessTokenAppIdPair f14500b;
        final /* synthetic */ AppEvent f14501c;

        public C20235(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
            this.f14499a = context;
            this.f14500b = accessTokenAppIdPair;
            this.f14501c = appEvent;
        }

        public final void run() {
            AppEventsLogger.m14692b(this.f14499a, this.f14500b).m14682a(this.f14501c);
            AppEventsLogger.m14698h();
        }
    }

    /* compiled from: email_guest_ */
    final class C20246 implements Runnable {
        final /* synthetic */ FlushReason f14502a;

        C20246(FlushReason flushReason) {
            this.f14502a = flushReason;
        }

        public final void run() {
            AppEventsLogger.m14696c(this.f14502a);
        }
    }

    /* compiled from: email_guest_ */
    final class C20257 implements Callback {
        final /* synthetic */ AccessTokenAppIdPair f14503a;
        final /* synthetic */ GraphRequest f14504b;
        final /* synthetic */ SessionEventsState f14505c;
        final /* synthetic */ FlushStatistics f14506d;

        C20257(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
            this.f14503a = accessTokenAppIdPair;
            this.f14504b = graphRequest;
            this.f14505c = sessionEventsState;
            this.f14506d = flushStatistics;
        }

        public final void mo693a(GraphResponse graphResponse) {
            AppEventsLogger.m14694b(this.f14503a, this.f14504b, graphResponse, this.f14505c, this.f14506d);
        }
    }

    /* compiled from: email_guest_ */
    public class AccessTokenAppIdPair implements Serializable {
        public final String accessTokenString;
        public final String applicationId;

        /* compiled from: email_guest_ */
        class SerializationProxyV1 implements Serializable {
            private final String accessTokenString;
            private final String appId;

            public SerializationProxyV1(String str, String str2) {
                this.accessTokenString = str;
                this.appId = str2;
            }

            private Object readResolve() {
                return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
            }
        }

        AccessTokenAppIdPair(AccessToken accessToken) {
            this(accessToken.f13711h, FacebookSdk.m14053i());
        }

        AccessTokenAppIdPair(String str, String str2) {
            if (Utility.m25345a(str)) {
                str = null;
            }
            this.accessTokenString = str;
            this.applicationId = str2;
        }

        final String m14668b() {
            return this.applicationId;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.accessTokenString == null ? 0 : this.accessTokenString.hashCode();
            if (this.applicationId != null) {
                i = this.applicationId.hashCode();
            }
            return hashCode ^ i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AccessTokenAppIdPair)) {
                return false;
            }
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            if (Utility.m25344a(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && Utility.m25344a(accessTokenAppIdPair.applicationId, this.applicationId)) {
                return true;
            }
            return false;
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.accessTokenString, this.applicationId);
        }
    }

    /* compiled from: email_guest_ */
    public class AppEvent implements Serializable {
        private static final HashSet<String> f14507a = new HashSet();
        public boolean isImplicit;
        private JSONObject jsonObject;
        public String name;

        /* compiled from: email_guest_ */
        class SerializationProxyV1 implements Serializable {
            private final boolean isImplicit;
            private final String jsonString;

            public SerializationProxyV1(String str, boolean z) {
                this.jsonString = str;
                this.isImplicit = z;
            }

            private Object readResolve() {
                return new AppEvent(this.jsonString, this.isImplicit);
            }
        }

        public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z) {
            try {
                m14669a(str2);
                this.name = str2;
                this.isImplicit = z;
                this.jsonObject = new JSONObject();
                this.jsonObject.put("_eventName", str2);
                this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000);
                this.jsonObject.put("_ui", str);
                if (d != null) {
                    this.jsonObject.put("_valueToSum", d.doubleValue());
                }
                if (this.isImplicit) {
                    this.jsonObject.put("_implicitlyLogged", "1");
                }
                if (bundle != null) {
                    for (String str3 : bundle.keySet()) {
                        m14669a(str3);
                        Object obj = bundle.get(str3);
                        if ((obj instanceof String) || (obj instanceof Number)) {
                            this.jsonObject.put(str3, obj.toString());
                        } else {
                            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, str3}));
                        }
                    }
                }
                if (!this.isImplicit) {
                    Logger.m25276a(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.jsonObject.toString());
                }
            } catch (JSONException e) {
                Logger.m25276a(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
                this.jsonObject = null;
            } catch (FacebookException e2) {
                Logger.m25276a(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", e2.toString());
                this.jsonObject = null;
            }
        }

        public AppEvent(String str, boolean z) {
            this.jsonObject = new JSONObject(str);
            this.isImplicit = z;
        }

        public final boolean m14670b() {
            return this.isImplicit;
        }

        public final JSONObject m14671c() {
            return this.jsonObject;
        }

        private static void m14669a(String str) {
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
            }
            synchronized (f14507a) {
                boolean contains = f14507a.contains(str);
            }
            if (!contains) {
                if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                    synchronized (f14507a) {
                        f14507a.add(str);
                    }
                    return;
                }
                throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
            }
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.jsonObject.toString(), this.isImplicit);
        }

        public String toString() {
            return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
        }
    }

    /* compiled from: email_guest_ */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    /* compiled from: email_guest_ */
    enum FlushReason {
        EXPLICIT,
        TIMER,
        SESSION_CHANGE,
        PERSISTED_EVENTS,
        EVENT_THRESHOLD,
        EAGER_FLUSHING_EVENT
    }

    /* compiled from: email_guest_ */
    enum FlushResult {
        SUCCESS,
        SERVER_ERROR,
        NO_CONNECTIVITY,
        UNKNOWN_ERROR
    }

    /* compiled from: email_guest_ */
    class FlushStatistics {
        public int f14508a = 0;
        public FlushResult f14509b = FlushResult.SUCCESS;
    }

    /* compiled from: email_guest_ */
    public class PersistedEvents {
        private static Object f14510a = new Object();
        private Context f14511b;
        public HashMap<AccessTokenAppIdPair, List<AppEvent>> f14512c = new HashMap();

        private PersistedEvents(Context context) {
            this.f14511b = context;
        }

        public static PersistedEvents m14672a(Context context) {
            PersistedEvents persistedEvents;
            synchronized (f14510a) {
                persistedEvents = new PersistedEvents(context);
                persistedEvents.m14677c();
            }
            return persistedEvents;
        }

        public static void m14673a(Context context, AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
            Map hashMap = new HashMap();
            hashMap.put(accessTokenAppIdPair, sessionEventsState);
            m14674a(context, hashMap);
        }

        private static void m14674a(Context context, Map<AccessTokenAppIdPair, SessionEventsState> map) {
            synchronized (f14510a) {
                PersistedEvents a = m14672a(context);
                for (Entry entry : map.entrySet()) {
                    List b = ((SessionEventsState) entry.getValue()).m14685b();
                    if (b.size() != 0) {
                        a.m14675a((AccessTokenAppIdPair) entry.getKey(), b);
                    }
                }
                a.m14676b();
            }
        }

        private void m14676b() {
            Closeable objectOutputStream;
            Exception e;
            Throwable th;
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(this.f14511b.openFileOutput("AppEventsLogger.persistedevents", 0)));
                try {
                    objectOutputStream.writeObject(this.f14512c);
                    Utility.m25336a(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.d(AppEventsLogger.f14520a, "Got unexpected exception: " + e.toString());
                        Utility.m25336a(objectOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.m25336a(objectOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                objectOutputStream = null;
                Log.d(AppEventsLogger.f14520a, "Got unexpected exception: " + e.toString());
                Utility.m25336a(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                Utility.m25336a(objectOutputStream);
                throw th;
            }
        }

        private void m14677c() {
            Closeable objectInputStream;
            Exception e;
            Throwable th;
            Closeable closeable = null;
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(this.f14511b.openFileInput("AppEventsLogger.persistedevents")));
                try {
                    HashMap hashMap = (HashMap) objectInputStream.readObject();
                    this.f14511b.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    this.f14512c = hashMap;
                    Utility.m25336a(objectInputStream);
                } catch (FileNotFoundException e2) {
                    closeable = objectInputStream;
                    Utility.m25336a(closeable);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.d(AppEventsLogger.f14520a, "Got unexpected exception: " + e.toString());
                        Utility.m25336a(objectInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.m25336a(objectInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                Utility.m25336a(closeable);
            } catch (Exception e5) {
                Exception exception = e5;
                objectInputStream = null;
                e = exception;
                Log.d(AppEventsLogger.f14520a, "Got unexpected exception: " + e.toString());
                Utility.m25336a(objectInputStream);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                objectInputStream = null;
                th = th4;
                Utility.m25336a(objectInputStream);
                throw th;
            }
        }

        private void m14675a(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
            if (!this.f14512c.containsKey(accessTokenAppIdPair)) {
                this.f14512c.put(accessTokenAppIdPair, new ArrayList());
            }
            ((List) this.f14512c.get(accessTokenAppIdPair)).addAll(list);
        }
    }

    /* compiled from: email_guest_ */
    class SessionEventsState {
        private List<AppEvent> f14513a = new ArrayList();
        private List<AppEvent> f14514b = new ArrayList();
        private int f14515c;
        private AttributionIdentifiers f14516d;
        private String f14517e;
        private String f14518f;
        private final int f14519g = 1000;

        public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str, String str2) {
            this.f14516d = attributionIdentifiers;
            this.f14517e = str;
            this.f14518f = str2;
        }

        public final synchronized void m14682a(AppEvent appEvent) {
            if (this.f14513a.size() + this.f14514b.size() >= 1000) {
                this.f14515c++;
            } else {
                this.f14513a.add(appEvent);
            }
        }

        public final synchronized int m14680a() {
            return this.f14513a.size();
        }

        public final synchronized void m14684a(boolean z) {
            if (z) {
                this.f14513a.addAll(this.f14514b);
            }
            this.f14514b.clear();
            this.f14515c = 0;
        }

        public final int m14681a(GraphRequest graphRequest, boolean z, boolean z2) {
            synchronized (this) {
                int i = this.f14515c;
                this.f14514b.addAll(this.f14513a);
                this.f14513a.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.f14514b) {
                    if (z || !appEvent.m14670b()) {
                        jSONArray.put(appEvent.m14671c());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                m14678a(graphRequest, i, jSONArray, z2);
                return jSONArray.length();
            }
        }

        public final synchronized List<AppEvent> m14685b() {
            List<AppEvent> list;
            list = this.f14513a;
            this.f14513a = new ArrayList();
            return list;
        }

        public final synchronized void m14683a(List<AppEvent> list) {
            this.f14513a.addAll(list);
        }

        private void m14678a(GraphRequest graphRequest, int i, JSONArray jSONArray, boolean z) {
            JSONObject a;
            try {
                a = AppEventsLoggerUtility.m25231a(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.f14516d, this.f14518f, z, AppEventsLogger.f14525h);
                if (this.f14515c > 0) {
                    a.put("num_skipped_events", i);
                }
            } catch (JSONException e) {
                a = new JSONObject();
            }
            graphRequest.m14105a(a);
            Bundle b = graphRequest.m14106b();
            if (b == null) {
                b = new Bundle();
            }
            Object jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                b.putByteArray("custom_events_file", m14679a((String) jSONArray2));
                graphRequest.m14104a(jSONArray2);
            }
            graphRequest.m14102a(b);
        }

        private static byte[] m14679a(String str) {
            byte[] bArr = null;
            try {
                bArr = str.getBytes("UTF-8");
            } catch (Exception e) {
                Utility.m25338a("Encoding exception: ", e);
            }
            return bArr;
        }
    }

    public static AppEventsLogger m14690a(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public static FlushBehavior m14687a() {
        FlushBehavior flushBehavior;
        synchronized (f14526i) {
            flushBehavior = f14523f;
        }
        return flushBehavior;
    }

    public final void m14701a(String str, Bundle bundle) {
        m14691a(str, null, bundle, false);
    }

    public final void m14702a(String str, Double d, Bundle bundle) {
        m14691a(str, d, bundle, true);
    }

    public AppEventsLogger(Context context, String str, AccessToken accessToken) {
        Validate.m25366a((Object) context, "context");
        this.f14529b = Utility.m25354c(context);
        if (accessToken == null) {
            accessToken = AccessToken.m14004a();
        }
        if (accessToken == null || !(str == null || str.equals(accessToken.m14013h()))) {
            if (str == null) {
                str = Utility.m25323a(context);
            }
            this.f14530c = new AccessTokenAppIdPair(null, str);
        } else {
            this.f14530c = new AccessTokenAppIdPair(accessToken);
        }
        synchronized (f14526i) {
            if (f14525h == null) {
                f14525h = context.getApplicationContext();
            }
        }
        m14697g();
    }

    private static void m14697g() {
        synchronized (f14526i) {
            if (f14522e != null) {
                return;
            }
            f14522e = new ScheduledThreadPoolExecutor(1);
            f14522e.scheduleAtFixedRate(new C20213(), 0, 15, TimeUnit.SECONDS);
            f14522e.scheduleAtFixedRate(new C20224(), 0, 86400, TimeUnit.SECONDS);
        }
    }

    private void m14691a(String str, Double d, Bundle bundle, boolean z) {
        AppEvent appEvent = new AppEvent(this.f14529b, str, d, bundle, z);
        ExecutorDetour.a(FacebookSdk.m14050d(), new C20235(f14525h, this.f14530c, appEvent), -1170390950);
        if (!appEvent.isImplicit && !f14528k) {
            if (appEvent.name == "fb_mobile_activate_app") {
                f14528k = true;
            } else {
                Logger.m25275a(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    public static void m14698h() {
        synchronized (f14526i) {
            if (m14687a() != FlushBehavior.EXPLICIT_ONLY && m14699i() > 100) {
                m14695b(FlushReason.EVENT_THRESHOLD);
            }
        }
    }

    private static int m14699i() {
        int i;
        synchronized (f14526i) {
            i = 0;
            for (SessionEventsState a : f14521d.values()) {
                i = a.m14680a() + i;
            }
        }
        return i;
    }

    public static SessionEventsState m14692b(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        AttributionIdentifiers attributionIdentifiers = null;
        if (((SessionEventsState) f14521d.get(accessTokenAppIdPair)) == null) {
            attributionIdentifiers = AttributionIdentifiers.m25235a(context);
        }
        synchronized (f14526i) {
            sessionEventsState = (SessionEventsState) f14521d.get(accessTokenAppIdPair);
            if (sessionEventsState == null) {
                sessionEventsState = new SessionEventsState(attributionIdentifiers, context.getPackageName(), m14693b(context));
                f14521d.put(accessTokenAppIdPair, sessionEventsState);
            }
        }
        return sessionEventsState;
    }

    private static SessionEventsState m14689a(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        synchronized (f14526i) {
            sessionEventsState = (SessionEventsState) f14521d.get(accessTokenAppIdPair);
        }
        return sessionEventsState;
    }

    private static void m14695b(FlushReason flushReason) {
        ExecutorDetour.a(FacebookSdk.m14050d(), new C20246(flushReason), 1990861994);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m14696c(com.facebook.appevents.AppEventsLogger.FlushReason r4) {
        /*
        r1 = f14526i;
        monitor-enter(r1);
        r0 = f14524g;	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0048 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = 1;
        f14524g = r0;	 Catch:{ all -> 0x0048 }
        r2 = new java.util.HashSet;	 Catch:{ all -> 0x0048 }
        r0 = f14521d;	 Catch:{ all -> 0x0048 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0048 }
        r2.<init>(r0);	 Catch:{ all -> 0x0048 }
        monitor-exit(r1);	 Catch:{ all -> 0x0048 }
        m14700j();
        r0 = 0;
        r0 = m14688a(r4, r2);	 Catch:{ Exception -> 0x004b }
    L_0x0020:
        r1 = f14526i;
        monitor-enter(r1);
        r2 = 0;
        f14524g = r2;	 Catch:{ all -> 0x0054 }
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0008;
    L_0x0029:
        r1 = new android.content.Intent;
        r2 = "com.facebook.sdk.APP_EVENTS_FLUSHED";
        r1.<init>(r2);
        r2 = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
        r3 = r0.f14508a;
        r1.putExtra(r2, r3);
        r2 = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
        r0 = r0.f14509b;
        r1.putExtra(r2, r0);
        r0 = f14525h;
        r0 = android.support.v4.content.LocalBroadcastManager.a(r0);
        r0.a(r1);
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r2 = f14520a;
        r3 = "Caught unexpected exception while flushing: ";
        com.facebook.internal.Utility.m25340a(r2, r3, r1);
        goto L_0x0020;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLogger.c(com.facebook.appevents.AppEventsLogger$FlushReason):void");
    }

    private static FlushStatistics m14688a(FlushReason flushReason, Set<AccessTokenAppIdPair> set) {
        FlushStatistics flushStatistics = new FlushStatistics();
        Context context = f14525h;
        Validate.m25364a();
        boolean z = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
        List<GraphRequest> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : set) {
            GraphRequest a;
            SessionEventsState a2 = m14689a(accessTokenAppIdPair);
            if (a2 != null) {
                a = m14686a(accessTokenAppIdPair, a2, z, flushStatistics);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.m25276a(LoggingBehavior.APP_EVENTS, f14520a, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.f14508a), flushReason.toString());
        for (GraphRequest a3 : arrayList) {
            a3.m14108f();
        }
        return flushStatistics;
    }

    private static GraphRequest m14686a(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState, boolean z, FlushStatistics flushStatistics) {
        FetchedAppSettings a = Utility.m25319a(accessTokenAppIdPair.applicationId, false);
        GraphRequest a2 = GraphRequest.m14071a(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle bundle = a2.f13807k;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("access_token", accessTokenAppIdPair.accessTokenString);
        a2.f13807k = bundle;
        if (a == null) {
            return null;
        }
        int a3 = sessionEventsState.m14681a(a2, a.f24041a, z);
        if (a3 == 0) {
            return null;
        }
        flushStatistics.f14508a = a3 + flushStatistics.f14508a;
        a2.m14103a(new C20257(accessTokenAppIdPair, a2, sessionEventsState, flushStatistics));
        return a2;
    }

    public static void m14694b(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        FacebookRequestError a = graphResponse.m14122a();
        String str = "Success";
        FlushResult flushResult2 = FlushResult.SUCCESS;
        String str2;
        if (a == null) {
            str2 = str;
            flushResult = flushResult2;
        } else if (a.m14040b() == -1) {
            Object obj = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str2 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{graphResponse.toString(), a.toString()});
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.m14047a(LoggingBehavior.APP_EVENTS)) {
            String jSONArray;
            try {
                jSONArray = new JSONArray((String) graphRequest.m14107e()).toString(2);
            } catch (JSONException e) {
                jSONArray = "<Can't encode events for debug logging>";
            }
            Logger.m25276a(LoggingBehavior.APP_EVENTS, f14520a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.m14101a().toString(), obj, jSONArray);
        }
        sessionEventsState.m14684a(a != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            PersistedEvents.m14673a(f14525h, accessTokenAppIdPair, sessionEventsState);
        }
        if (flushResult != FlushResult.SUCCESS && flushStatistics.f14509b != FlushResult.NO_CONNECTIVITY) {
            flushStatistics.f14509b = flushResult;
        }
    }

    private static int m14700j() {
        PersistedEvents a = PersistedEvents.m14672a(f14525h);
        int i = 0;
        for (AccessTokenAppIdPair accessTokenAppIdPair : a.f14512c.keySet()) {
            SessionEventsState b = m14692b(f14525h, accessTokenAppIdPair);
            List list = (List) a.f14512c.get(accessTokenAppIdPair);
            b.m14683a(list);
            i = list.size() + i;
        }
        return i;
    }

    private static String m14693b(Context context) {
        if (f14527j == null) {
            synchronized (f14526i) {
                if (f14527j == null) {
                    String string = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    f14527j = string;
                    if (string == null) {
                        f14527j = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", f14527j).apply();
                    }
                }
            }
        }
        return f14527j;
    }
}
