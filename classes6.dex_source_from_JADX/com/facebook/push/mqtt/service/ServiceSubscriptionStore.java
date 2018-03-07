package com.facebook.push.mqtt.service;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import java.io.File;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: size_dimension */
public class ServiceSubscriptionStore {
    private final File f4324a;

    private static ServiceSubscriptionStore m6413b(InjectorLike injectorLike) {
        return new ServiceSubscriptionStore((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ServiceSubscriptionStore(Context context) {
        this.f4324a = new File(new File(context.getFilesDir(), "mqtt-push-service"), "sticky-subscriptions");
    }
}
