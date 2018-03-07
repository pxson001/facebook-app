package com.facebook.push.mqtt.external;

import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.contacts.protocol.push.mqtt.ContactsMqttPushHandler;
import com.facebook.friendsnearby.mqtt.FriendsNearbyMqttPushHandler;
import com.facebook.graphql.mqtt.GraphQLMQTTSubscriptionConnector;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.push.mqtt.FbandroidMqttPushHandler;
import com.facebook.notifications.mqtt.NotificationsMqttPushHandler;
import com.facebook.omnistore.mqtt.OmnistoreMqttPushHandler;
import com.facebook.orca.push.mqtt.OrcaMqttPushHandler;
import com.facebook.presence.PresenceAccuracyExpHandler;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.push.fbpushdata.FbPushDataOverMqttHandler;
import com.facebook.quickpromotion.push.QuickPromotionRefreshMqttPushHandler;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$MqttPushHandler implements MultiBindIndexedProvider<MqttPushHandler>, Provider<Set<MqttPushHandler>> {
    private final InjectorLike f23428a;

    private STATICDI_MULTIBIND_PROVIDER$MqttPushHandler(InjectorLike injectorLike) {
        this.f23428a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f23428a.getScopeAwareInjector(), this);
    }

    public static Set<MqttPushHandler> m31698a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$MqttPushHandler(injectorLike));
    }

    public final int size() {
        return 11;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ContactsMqttPushHandler.a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new FriendsNearbyMqttPushHandler(FbObjectMapperMethodAutoProvider.m6609a(injector), LocalFbBroadcastManager.m2946a((InjectorLike) injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return GraphQLMQTTSubscriptionConnector.m9389a((InjectorLike) injector);
            case 3:
                return FbandroidMqttPushHandler.a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return NotificationsMqttPushHandler.b(injector);
            case 5:
                return OmnistoreMqttPushHandler.getInstance__com_facebook_omnistore_mqtt_OmnistoreMqttPushHandler__INJECTED_BY_TemplateInjector(injector);
            case 6:
                return OrcaMqttPushHandler.a(injector);
            case 7:
                return PresenceAccuracyExpHandler.a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return FbPushDataOverMqttHandler.a(injector);
            case 9:
                return QuickPromotionRefreshMqttPushHandler.a(injector);
            case 10:
                return SkywalkerSubscriptionConnector.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
