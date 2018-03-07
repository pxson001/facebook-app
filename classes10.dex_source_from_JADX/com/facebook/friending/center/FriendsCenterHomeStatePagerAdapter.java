package com.facebook.friending.center;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import com.facebook.fbui.pagerindicator.BadgePagerAdapter;
import com.facebook.fbui.pagerindicator.BadgePagerProvider;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.center.tabs.friends.FriendsCenterFriendsFragment;
import com.facebook.friending.center.tabs.requests.FriendsCenterRequestsFragment;
import com.facebook.friending.center.tabs.search.FriendsCenterSearchFragment;
import com.facebook.friending.center.tabs.suggestions.FriendsCenterSuggestionsFragment;
import com.facebook.growth.friendfinder.FriendFinderFriendableContactsFragment;
import com.facebook.growth.friendfinder.FriendFinderIntroFragment;
import com.facebook.growth.friendfinder.invitablecontacts.InvitableContactsFragment;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;

/* compiled from: allowedWithLowBattery */
public class FriendsCenterHomeStatePagerAdapter extends FragmentStatePagerAdapter implements BadgePagerProvider {
    private final Context f19944a;
    private final FriendsCenterBadgePagerAdapter f19945b;
    private final ImmutableList<FriendsCenterTabType> f19946c;
    public final SparseArray<Fragment> f19947d = new SparseArray();
    private final boolean f19948e;

    /* compiled from: allowedWithLowBattery */
    /* synthetic */ class C28061 {
        static final /* synthetic */ int[] f19943a = new int[FriendsCenterTabType.values().length];

        static {
            try {
                f19943a[FriendsCenterTabType.CONTACTS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19943a[FriendsCenterTabType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19943a[FriendsCenterTabType.REQUESTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19943a[FriendsCenterTabType.SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19943a[FriendsCenterTabType.SUGGESTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19943a[FriendsCenterTabType.INVITES.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public FriendsCenterHomeStatePagerAdapter(@Assisted FragmentManager fragmentManager, @Assisted Context context, @Assisted FriendsCenterBadgePagerAdapter friendsCenterBadgePagerAdapter, @Assisted ImmutableList<FriendsCenterTabType> immutableList, @Assisted boolean z) {
        super(fragmentManager);
        this.f19944a = context;
        this.f19945b = friendsCenterBadgePagerAdapter;
        this.f19946c = immutableList;
        this.f19948e = z;
    }

    public final Fragment m20120a(int i) {
        Fragment a;
        CIFlow cIFlow;
        Bundle bundle;
        switch (C28061.f19943a[((FriendsCenterTabType) this.f19946c.get(i)).ordinal()]) {
            case 1:
                if (!this.f19948e) {
                    a = FriendFinderIntroFragment.a(CIFlow.FRIENDS_CENTER, CIFlow.FRIENDS_CENTER.value);
                    break;
                }
                cIFlow = CIFlow.FRIENDS_CENTER;
                FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment = new FriendFinderFriendableContactsFragment();
                bundle = new Bundle();
                bundle.putSerializable("ci_flow", cIFlow);
                bundle.putBoolean("go_to_profile_enabled", true);
                friendFinderFriendableContactsFragment.g(bundle);
                a = friendFinderFriendableContactsFragment;
                break;
            case 2:
                a = new FriendsCenterFriendsFragment();
                break;
            case 3:
                a = new FriendsCenterRequestsFragment();
                break;
            case 4:
                a = new FriendsCenterSearchFragment();
                break;
            case 5:
                a = new FriendsCenterSuggestionsFragment();
                break;
            case 6:
                cIFlow = CIFlow.FRIENDS_CENTER;
                InvitableContactsFragment invitableContactsFragment = new InvitableContactsFragment();
                bundle = new Bundle();
                bundle.putSerializable("ci_flow", cIFlow);
                invitableContactsFragment.g(bundle);
                a = invitableContactsFragment;
                break;
            default:
                throw new IllegalArgumentException("Native tab that doesn't provide a native fragment.");
        }
        this.f19947d.put(i, a);
        return a;
    }

    public final CharSequence J_(int i) {
        return this.f19944a.getResources().getString(((FriendsCenterTabType) this.f19946c.get(i)).titleResId);
    }

    public final int m20122b() {
        return this.f19946c.size();
    }

    public final BadgePagerAdapter m20121a() {
        return this.f19945b;
    }
}
