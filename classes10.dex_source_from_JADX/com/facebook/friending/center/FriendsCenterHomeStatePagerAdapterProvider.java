package com.facebook.friending.center;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.collect.ImmutableList;

/* compiled from: allowedOverMetered */
public class FriendsCenterHomeStatePagerAdapterProvider extends AbstractAssistedProvider<FriendsCenterHomeStatePagerAdapter> {
    public static FriendsCenterHomeStatePagerAdapter m20123a(FragmentManager fragmentManager, Context context, FriendsCenterBadgePagerAdapter friendsCenterBadgePagerAdapter, ImmutableList<FriendsCenterTabType> immutableList, boolean z) {
        return new FriendsCenterHomeStatePagerAdapter(fragmentManager, context, friendsCenterBadgePagerAdapter, immutableList, z);
    }
}
