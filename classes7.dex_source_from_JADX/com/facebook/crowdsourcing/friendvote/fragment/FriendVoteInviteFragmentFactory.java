package com.facebook.crowdsourcing.friendvote.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.facebook.rti.mqtt.intent.ACTION_WAKEUP */
public class FriendVoteInviteFragmentFactory implements IFragmentFactory {
    public final Fragment m21313a(Intent intent) {
        FriendVoteInviteFragment friendVoteInviteFragment = new FriendVoteInviteFragment();
        friendVoteInviteFragment.g(intent.getExtras());
        return friendVoteInviteFragment;
    }
}
