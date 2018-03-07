package com.facebook.push.mqtt.service;

import com.facebook.friendsnearby.mqtt.FriendsNearbyMqttTopicsSet;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.push.mqtt.IProvideSubscribeTopics_ForFbandroidAppMethodAutoProvider;
import com.facebook.messaging.media.upload.MediaGetFbidMqttTopicsSetProvider;
import com.facebook.notifications.mqtt.NotificationsMqttTopicsSet;
import com.facebook.omnistore.mqtt.OmnistoreMqttTopicsSetProvider;
import com.facebook.orca.push.mqtt.OrcaMqttTopicsSetProvider;
import com.facebook.presence.PresenceInvestigationTopic;
import com.facebook.quickpromotion.push.QuickPromotionMqttTopicsSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0358xd6020d06 implements MultiBindIndexedProvider<IProvideSubscribeTopics>, Provider<Set<IProvideSubscribeTopics>> {
    private final InjectorLike f7475a;

    public C0358xd6020d06(InjectorLike injectorLike) {
        this.f7475a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7475a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 8;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new FriendsNearbyMqttTopicsSet();
            case 1:
                return MediaGetFbidMqttTopicsSetProvider.m11184a(injector);
            case 2:
                return new NotificationsMqttTopicsSet();
            case 3:
                return OmnistoreMqttTopicsSetProvider.m11186x9744a27e(injector);
            case 4:
                return OrcaMqttTopicsSetProvider.m11187a(injector);
            case 5:
                return new PresenceInvestigationTopic();
            case 6:
                return IProvideSubscribeTopics_ForFbandroidAppMethodAutoProvider.m11195a(injector);
            case 7:
                return new QuickPromotionMqttTopicsSet();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
