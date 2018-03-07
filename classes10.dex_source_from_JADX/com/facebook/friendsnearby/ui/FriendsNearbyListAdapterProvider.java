package com.facebook.friendsnearby.ui;

import android.content.Context;
import com.facebook.friendsnearby.ui.FriendsNearbyRowView.OnClickListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: Webview */
public class FriendsNearbyListAdapterProvider extends AbstractAssistedProvider<FriendsNearbyListAdapter> {
    public final FriendsNearbyListAdapter m21920a(OnClickListener onClickListener, FriendsNearbyFragment friendsNearbyFragment) {
        return new FriendsNearbyListAdapter(onClickListener, friendsNearbyFragment, (Context) getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
