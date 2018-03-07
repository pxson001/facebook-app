package com.facebook.push.mqtt.persistence;

import com.facebook.graphql.mqtt.GraphQLMQTTPersistenceRequirement;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$MqttPersistenceRequirement implements MultiBindIndexedProvider<MqttPersistenceRequirement>, Provider<Set<MqttPersistenceRequirement>> {
    private final InjectorLike f10833a;

    private STATICDI_MULTIBIND_PROVIDER$MqttPersistenceRequirement(InjectorLike injectorLike) {
        this.f10833a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10833a.getScopeAwareInjector(), this);
    }

    public static Set<MqttPersistenceRequirement> m11295a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$MqttPersistenceRequirement(injectorLike));
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return GraphQLMQTTPersistenceRequirement.m11296a(injector);
            case 1:
                return new AlwaysPersistentGkMqttPersistenceRequirement(IdBasedProvider.a(injector, 4291));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
