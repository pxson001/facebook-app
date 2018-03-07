package com.facebook.events.permalink.guestlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: bridgeMethodImpl('%s') */
public class EventGuestListFragmentFactory implements IFragmentFactory {
    public final Fragment m18720a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventGuestListFrameFragment eventGuestListFrameFragment = new EventGuestListFrameFragment();
        eventGuestListFrameFragment.g(extras);
        return eventGuestListFrameFragment;
    }
}
