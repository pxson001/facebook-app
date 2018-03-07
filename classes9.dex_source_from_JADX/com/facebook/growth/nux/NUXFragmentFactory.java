package com.facebook.growth.nux;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.util.TriState;
import com.facebook.friending.jewel.FriendRequestsFragment;
import com.facebook.friending.newuserpromotion.NewUserFriendingFragment;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.growth.friendfinder.FriendFinderAddFriendsFragment;
import com.facebook.growth.friendfinder.FriendFinderIntroFragment;
import com.facebook.growth.friendfinder.FriendFinderPreferenceSetter;
import com.facebook.growth.nux.abtest.ExperimentsForGrowthModule;
import com.facebook.growth.nux.fragments.NUXNativeNameFragment;
import com.facebook.growth.nux.fragments.NUXProfilePhotoFragment;
import com.facebook.growth.nux.fragments.NUXProfilePhotoImportGoogleFragment;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_verification */
public class NUXFragmentFactory {
    public final Provider<TriState> f7404a;
    public final QeAccessor f7405b;
    private final FriendFinderPreferenceSetter f7406c;

    @Inject
    public NUXFragmentFactory(Provider<TriState> provider, QeAccessor qeAccessor, FriendFinderPreferenceSetter friendFinderPreferenceSetter) {
        this.f7404a = provider;
        this.f7405b = qeAccessor;
        this.f7406c = friendFinderPreferenceSetter;
    }

    public final Fragment m7729a(String str) {
        if (str.equals("contact_importer")) {
            if (this.f7406c.m7550c()) {
                return FriendFinderIntroFragment.m7514a(CIFlow.NEW_ACCOUNT_NUX, CIFlow.NEW_ACCOUNT_NUX.value);
            }
            return FriendFinderAddFriendsFragment.m7447a(CIFlow.NEW_ACCOUNT_NUX);
        } else if (str.equals("people_you_may_know")) {
            NewUserFriendingFragment newUserFriendingFragment;
            if (this.f7405b.a(ExperimentsForGrowthModule.f7436b, false)) {
                newUserFriendingFragment = new NewUserFriendingFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("FRIENDING_LOCATION", FriendingLocation.NUX);
                newUserFriendingFragment.g(bundle);
            } else {
                newUserFriendingFragment = new FriendRequestsFragment();
                newUserFriendingFragment.bu = FriendingLocation.NUX;
                newUserFriendingFragment.bv = false;
                newUserFriendingFragment.bx = false;
                newUserFriendingFragment.by = true;
            }
            return newUserFriendingFragment;
        } else if (str.equals("upload_profile_pic")) {
            if (((TriState) this.f7404a.get()).asBoolean(false)) {
                return new NUXProfilePhotoImportGoogleFragment();
            }
            return new NUXProfilePhotoFragment();
        } else if (str.equals("native_name")) {
            return new NUXNativeNameFragment();
        } else {
            throw new IllegalArgumentException("User Account NUX: step " + str + " is not supported");
        }
    }
}
