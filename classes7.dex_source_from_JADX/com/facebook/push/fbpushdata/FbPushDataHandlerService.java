package com.facebook.push.fbpushdata;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.push.registration.ServiceType;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: hero_video_uri */
public class FbPushDataHandlerService extends FbIntentService {
    private static final Class<?> f11273a = FbPushDataHandlerService.class;
    private static final PrefKey f11274b;
    private static final PrefKey f11275c;
    private Set<FbPushDataHandler> f11276d;
    private ObjectMapper f11277e;
    private ReliabilityAnalyticsLogger f11278f;
    private FbPushDataDuplicateManager f11279g;
    private Clock f11280h;
    private FbSharedPreferences f11281i;
    private PushDataFlightRecorder f11282j;
    private MqttPushServiceWrapper f11283k;
    private PushServiceSelector f11284l;
    private AbstractFbErrorReporter f11285m;

    private static <T extends Context> void m13180a(Class<T> cls, T t) {
        m13181a((Object) t, (Context) t);
    }

    private static void m13181a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FbPushDataHandlerService) obj).m13182a(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$FbPushDataHandler(injectorLike)), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), ReliabilityAnalyticsLogger.a(injectorLike), FbPushDataDuplicateManager.m13174a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PushDataFlightRecorder.m13187a(injectorLike), MqttPushServiceWrapper.a(injectorLike), PushServiceSelector.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("mqtt/");
        f11274b = prefKey;
        f11275c = (PrefKey) prefKey.a("push_channel");
    }

    public FbPushDataHandlerService() {
        super("PushDataHandlerService");
        setIntentRedelivery(true);
    }

    @Inject
    private void m13182a(Set<FbPushDataHandler> set, ObjectMapper objectMapper, ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, FbPushDataDuplicateManager fbPushDataDuplicateManager, Clock clock, FbSharedPreferences fbSharedPreferences, PushDataFlightRecorder pushDataFlightRecorder, MqttPushServiceWrapper mqttPushServiceWrapper, PushServiceSelector pushServiceSelector, FbErrorReporter fbErrorReporter) {
        this.f11276d = set;
        this.f11277e = objectMapper;
        this.f11278f = reliabilityAnalyticsLogger;
        this.f11279g = fbPushDataDuplicateManager;
        this.f11280h = clock;
        this.f11281i = fbSharedPreferences;
        this.f11282j = pushDataFlightRecorder;
        this.f11283k = mqttPushServiceWrapper;
        this.f11284l = pushServiceSelector;
        this.f11285m = fbErrorReporter;
    }

    public static void m13179a(Context context, String str, PushSource pushSource) {
        Intent intent = new Intent(context.getApplicationContext(), FbPushDataHandlerService.class);
        intent.putExtra("push_content", str);
        intent.putExtra("push_source", pushSource.name());
        WakefulBroadcastReceiver.a(context, intent);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -2107484827);
        TracerDetour.a("%s.onCreate", FbPushDataHandlerService.class.getSimpleName(), -1749794484);
        try {
            super.onCreate();
            AppInitLockHelper.a(this);
            m13180a(FbPushDataHandlerService.class, (Context) this);
        } finally {
            TracerDetour.a(1879098159);
            LogUtils.d(193098898, a);
        }
    }

    protected final void m13185a(Intent intent) {
        try {
            m13184b(intent);
        } finally {
            if (intent != null) {
                WakefulBroadcastReceiver.a(intent);
            }
        }
    }

    private void m13184b(Intent intent) {
        String str;
        if (intent != null) {
            JsonNode a;
            String stringExtra = intent.getStringExtra("push_content");
            PushSource valueOf = PushSource.valueOf(intent.getStringExtra("push_source"));
            this.f11282j.m13189a(valueOf.toString(), stringExtra);
            try {
                a = this.f11277e.a(stringExtra);
            } catch (IOException e) {
                this.f11278f.a(valueOf.toString(), "", "invalid_json", null, "", "");
                a = null;
            }
            if (a != null && a != NullNode.a) {
                JsonNode b;
                String s;
                int w;
                JsonNode b2 = a.b("params");
                if (b2 != null) {
                    b = b2.b("PushNotifID");
                    if (b != null) {
                        stringExtra = b.s();
                    } else {
                        stringExtra = null;
                    }
                    b2 = b2.b("push_extra");
                    if (b2 != null) {
                        s = b2.s();
                        str = stringExtra;
                    } else {
                        s = null;
                        str = stringExtra;
                    }
                } else {
                    s = null;
                    str = null;
                }
                b = a.b("type");
                String str2 = "";
                if (b != null) {
                    str2 = b.s();
                }
                if (this.f11281i.a(f11275c, false) && a.d("message")) {
                    ((ObjectNode) a).a("message", m13178a(valueOf, a.b("message").toString(), str2));
                }
                b = a.b("time");
                if (b != null) {
                    w = b.w();
                } else {
                    w = 0;
                }
                if (str != null) {
                    if (this.f11279g.m13177b(str)) {
                        this.f11278f.a(valueOf.toString(), str, w, s);
                        return;
                    }
                    this.f11279g.m13176a(str);
                }
                this.f11278f.a(valueOf.toString(), str, str2, w, s);
                PushSource b3 = m13183b();
                if (valueOf != b3) {
                    this.f11278f.b(valueOf.toString(), b3.toString(), str, w, s);
                }
                if (!"silent_notif".equals(str2)) {
                    PushProperty pushProperty = new PushProperty(valueOf, str, this.f11280h.a());
                    for (FbPushDataHandler fbPushDataHandler : this.f11276d) {
                        try {
                            fbPushDataHandler.mo617a(a, pushProperty);
                        } catch (Throwable e2) {
                            this.f11285m.a("FbPushDataHandler.onNotification exception", fbPushDataHandler.getClass().getCanonicalName() + " " + valueOf.toString(), e2);
                            this.f11278f.a(fbPushDataHandler.getClass().getCanonicalName(), valueOf.toString(), str, e2);
                        }
                    }
                }
            }
        }
    }

    private PushSource m13183b() {
        Set a = this.f11284l.a();
        if (a.contains(ServiceType.FBNS_LITE)) {
            return PushSource.FBNS_LITE;
        }
        if (a.contains(ServiceType.FBNS)) {
            return PushSource.MQTT_PUSH;
        }
        if (a.contains(ServiceType.ADM)) {
            return PushSource.ADM;
        }
        if (a.contains(ServiceType.NNA)) {
            return PushSource.NNA;
        }
        return PushSource.C2DM;
    }

    private static String m13178a(PushSource pushSource, String str, String str2) {
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = str.split(":");
        if (PushSource.FBNS_LITE == pushSource) {
            c = '⚡';
        } else if (PushSource.MQTT_PUSH == pushSource) {
            c = '❄';
        } else {
            c = '☀';
        }
        if (("orca_message".equals(str2) || "msg".equals(str2)) && split.length == 2) {
            stringBuilder.append(split[0] + ":" + c + split[1]);
        } else {
            stringBuilder.append(c + str);
        }
        return stringBuilder.toString().replaceFirst("\"", "").replaceAll("\"$", "");
    }
}
