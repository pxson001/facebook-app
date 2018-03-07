package com.facebook.growth.promotion;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.friending.jewel.FriendRequestsFragment;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: p2p_request_fail */
public class FriendingPossibilitiesActivity extends FbFragmentActivity {
    public final void m7805b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906554);
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).setTitle(2131236378);
        FriendRequestsFragment friendRequestsFragment = new FriendRequestsFragment();
        friendRequestsFragment.bu = FriendingLocation.QUICK_PROMOTION;
        friendRequestsFragment.bv = false;
        friendRequestsFragment.bx = false;
        friendRequestsFragment.by = true;
        kO_().a().a(2131566509, friendRequestsFragment).b();
    }
}
