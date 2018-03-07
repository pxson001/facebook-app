package com.facebook.feed.firstlaunch;

import com.facebook.auth.event.AuthEventBus;
import com.facebook.auth.event.AuthLoggedInEvent;
import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: total_bytes */
public class FirstLaunchAuthSubscriber extends INeedInitForEventBusSubscription<AuthLoggedInEvent, FirstLaunchTracker> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        FirstLaunchTracker firstLaunchTracker = (FirstLaunchTracker) obj;
        if (firstLaunchTracker.f13832b.mo284a()) {
            firstLaunchTracker.f13832b.edit().mo1275a(FirstLaunchSharedPrefs.f13834a, firstLaunchTracker.f13831a.mo211a()).commit();
        } else {
            firstLaunchTracker.f13833c.m2350b("FeedFirstLaunchManager", "Shared preferences were not initialized onAuthFinished");
        }
    }

    @Inject
    public FirstLaunchAuthSubscriber(AuthEventBus authEventBus, Lazy<FirstLaunchTracker> lazy) {
        super(authEventBus, lazy);
    }

    public final Class<AuthLoggedInEvent> mo648a() {
        return AuthLoggedInEvent.class;
    }
}
