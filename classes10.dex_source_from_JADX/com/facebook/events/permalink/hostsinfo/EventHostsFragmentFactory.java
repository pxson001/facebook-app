package com.facebook.events.permalink.hostsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: blank fbid */
public class EventHostsFragmentFactory implements IFragmentFactory {
    public final Fragment m18899a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventHostsFragment eventHostsFragment = new EventHostsFragment();
        eventHostsFragment.g(extras);
        return eventHostsFragment;
    }
}
