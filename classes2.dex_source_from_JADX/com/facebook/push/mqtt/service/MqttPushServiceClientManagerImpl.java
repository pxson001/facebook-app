package com.facebook.push.mqtt.service;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.push.mqtt.MqttPushClientModule;
import com.facebook.push.mqtt.service.response.MqttResponseManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mListenerLock */
public class MqttPushServiceClientManagerImpl {
    private static final Class<?> f15516a = MqttPushServiceClientManagerImpl.class;
    private static MqttPushServiceClientManagerImpl f15517k;
    private static final Object f15518l = new Object();
    private final Context f15519b;
    private final DefaultAndroidThreadUtil f15520c;
    private final Clock f15521d;
    private final MqttResponseManager f15522e;
    private final PushServiceTargetingHelper f15523f;
    private final MonotonicClock f15524g;
    private final MqttPushServiceClientFlightRecorder f15525h;
    private final long f15526i;
    private final QeAccessor f15527j;

    private static MqttPushServiceClientManagerImpl m22139b(InjectorLike injectorLike) {
        return new MqttPushServiceClientManagerImpl((Context) injectorLike.getInstance(Context.class), DefaultAndroidThreadUtil.m1646b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), MqttResponseManager.m22141a(injectorLike), PushServiceTargetingHelper.m22145a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), MqttPushServiceClientFlightRecorder.m4462a(injectorLike), MqttPushClientModule.m22165b(), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public MqttPushServiceClientManagerImpl(Context context, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Clock clock, MqttResponseManager mqttResponseManager, PushServiceTargetingHelper pushServiceTargetingHelper, MonotonicClock monotonicClock, MqttPushServiceClientFlightRecorder mqttPushServiceClientFlightRecorder, Long l, QeAccessor qeAccessor) {
        this.f15519b = context;
        this.f15520c = defaultAndroidThreadUtil;
        this.f15521d = clock;
        this.f15522e = mqttResponseManager;
        this.f15524g = monotonicClock;
        this.f15525h = mqttPushServiceClientFlightRecorder;
        this.f15523f = pushServiceTargetingHelper;
        this.f15526i = l.longValue();
        this.f15527j = qeAccessor;
    }

    public static MqttPushServiceClientManagerImpl m22138a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MqttPushServiceClientManagerImpl b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f15518l) {
                MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl;
                if (a2 != null) {
                    mqttPushServiceClientManagerImpl = (MqttPushServiceClientManagerImpl) a2.mo818a(f15518l);
                } else {
                    mqttPushServiceClientManagerImpl = f15517k;
                }
                if (mqttPushServiceClientManagerImpl == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m22139b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f15518l, b3);
                        } else {
                            f15517k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = mqttPushServiceClientManagerImpl;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final MqttPushServiceClient m22140a() {
        MqttPushServiceClientImpl mqttPushServiceClientImpl = new MqttPushServiceClientImpl(this.f15519b, this.f15522e, this.f15521d, this.f15523f, this.f15520c, this.f15524g, this.f15525h, this.f15527j);
        try {
            if (!mqttPushServiceClientImpl.b(this.f15526i)) {
                BLog.a(f15516a, "Failed to bind to MqttPushService");
            }
            return mqttPushServiceClientImpl;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
