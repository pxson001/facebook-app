package com.facebook.events.dashboard.subscriptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.facebook.platform.AppCallResultBroadcast */
public class EventsSubscriptionsFragmentFactory implements IFragmentFactory {
    public final Fragment m17504a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventsSubscriptionsFragment eventsSubscriptionsFragment = new EventsSubscriptionsFragment();
        eventsSubscriptionsFragment.g(extras);
        return eventsSubscriptionsFragment;
    }
}
