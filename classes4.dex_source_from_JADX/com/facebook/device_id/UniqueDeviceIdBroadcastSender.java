package com.facebook.device_id;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.build.SignatureType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.DeviceIdChangedCallback.ChangeType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.phoneid.PhoneIdRequester;
import com.facebook.phoneid.PhoneIdStore;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: trace_request */
public class UniqueDeviceIdBroadcastSender extends AbstractAuthComponent {
    public static final Class<?> f791a = UniqueDeviceIdBroadcastSender.class;
    public final UniqueIdForDeviceHolderImpl f792b;
    public final Clock f793c;
    private final Context f794d;
    private final FbAlarmManagerImpl f795e;
    private final Provider<DeviceIdReceiver> f796f;
    public final Set<DeviceIdChangedCallback> f797g;
    private final Boolean f798h;
    private final XConfigReader f799i;
    private final Lazy<ObjectMapper> f800j;
    public final FbSharedPreferences f801k;
    private final Lazy<PhoneIdRequester> f802l;
    private final Lazy<PhoneIdStore> f803m;
    private final SignatureType f804n;

    /* compiled from: trace_request */
    public class C00821 {
        final /* synthetic */ UniqueDeviceIdBroadcastSender f1527a;

        C00821(UniqueDeviceIdBroadcastSender uniqueDeviceIdBroadcastSender) {
            this.f1527a = uniqueDeviceIdBroadcastSender;
        }

        public final void m1745a(UniqueDeviceId uniqueDeviceId) {
            UniqueDeviceId b = this.f1527a.f792b.b();
            if (b.b > uniqueDeviceId.b) {
                BLog.a(UniqueDeviceIdBroadcastSender.f791a, "device id Changed from: " + b + "to: " + uniqueDeviceId);
                this.f1527a.f792b.a(uniqueDeviceId);
                for (DeviceIdChangedCallback a : this.f1527a.f797g) {
                    a.a(b, uniqueDeviceId, ChangeType.FB_SYNC, null);
                }
            }
        }
    }

    /* compiled from: trace_request */
    public class LocalBroadcastReceiver extends DynamicSecureBroadcastReceiver {
        private static final Class<?> f1528a = LocalBroadcastReceiver.class;

        public LocalBroadcastReceiver() {
            super("com.facebook.GET_UNIQUE_ID", new 1());
        }
    }

    public static UniqueDeviceIdBroadcastSender m1129b(InjectorLike injectorLike) {
        return new UniqueDeviceIdBroadcastSender(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 1071), STATICDI_MULTIBIND_PROVIDER$DeviceIdChangedCallback.m1201a(injectorLike), Boolean_ShareDeviceIdMethodAutoProvider.m1202a(injectorLike), XConfigReader.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 572), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2955), IdBasedSingletonScopeProvider.b(injectorLike, 1069), SignatureTypeMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public UniqueDeviceIdBroadcastSender(UniqueIdForDeviceHolder uniqueIdForDeviceHolder, Clock clock, Context context, FbAlarmManager fbAlarmManager, Provider<DeviceIdReceiver> provider, Set<DeviceIdChangedCallback> set, Boolean bool, XConfigReader xConfigReader, Lazy<ObjectMapper> lazy, FbSharedPreferences fbSharedPreferences, Lazy<PhoneIdRequester> lazy2, Lazy<PhoneIdStore> lazy3, SignatureType signatureType) {
        this.f792b = uniqueIdForDeviceHolder;
        this.f793c = clock;
        this.f794d = context;
        this.f795e = fbAlarmManager;
        this.f796f = provider;
        this.f797g = set;
        this.f798h = bool;
        this.f799i = xConfigReader;
        this.f800j = lazy;
        this.f801k = fbSharedPreferences;
        this.f802l = lazy2;
        this.f803m = lazy3;
        this.f804n = signatureType;
    }

    public final void m1131a(@Nullable AuthenticationResult authenticationResult) {
        m1130l(this);
        Intent intent = new Intent(this.f794d, LocalBroadcastReceiver.class);
        intent.setAction("com.facebook.GET_UNIQUE_ID");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f794d, -1, intent, 0);
        long a = this.f793c.a() + 86400000;
        Random random = new Random(this.f793c.a());
        a += (((long) (random.nextInt(60) - 30)) * 60000) + (((long) (random.nextInt(12) - 6)) * 3600000);
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f795e;
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(1, a, broadcast);
        } else {
            fbAlarmManagerImpl.a.setExact(1, a, broadcast);
        }
    }

    public static void m1130l(UniqueDeviceIdBroadcastSender uniqueDeviceIdBroadcastSender) {
        if (uniqueDeviceIdBroadcastSender.f798h.booleanValue()) {
            Intent intent = new Intent();
            intent.setAction("com.facebook.GET_UNIQUE_ID");
            DeviceIdReceiver deviceIdReceiver = (DeviceIdReceiver) uniqueDeviceIdBroadcastSender.f796f.get();
            deviceIdReceiver.f1526c = new C00821(uniqueDeviceIdBroadcastSender);
            uniqueDeviceIdBroadcastSender.f794d.sendOrderedBroadcast(intent, uniqueDeviceIdBroadcastSender.f804n.getReceiverPermission(), deviceIdReceiver, null, 1, null, null);
        }
    }

    public final void m1132i() {
        int a = this.f799i.a(DeviceIdXConfig.f865g, 604800);
        long a2 = this.f801k.a(DeviceIdPrefKeys.c, 0);
        if (((DefaultPhoneIdStore) this.f803m.get()).m1206a() && this.f793c.a() - a2 > ((long) a) * 1000) {
            ((PhoneIdRequester) this.f802l.get()).m1220a();
            this.f801k.edit().a(DeviceIdPrefKeys.c, this.f793c.a()).commit();
        }
    }
}
