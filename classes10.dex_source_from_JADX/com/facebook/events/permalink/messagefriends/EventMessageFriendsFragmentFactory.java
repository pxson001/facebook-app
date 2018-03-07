package com.facebook.events.permalink.messagefriends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: bind */
public class EventMessageFriendsFragmentFactory implements IFragmentFactory {
    public final Fragment m18948a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventMessageFriendsFragment eventMessageFriendsFragment = new EventMessageFriendsFragment();
        eventMessageFriendsFragment.g(extras);
        return eventMessageFriendsFragment;
    }
}
