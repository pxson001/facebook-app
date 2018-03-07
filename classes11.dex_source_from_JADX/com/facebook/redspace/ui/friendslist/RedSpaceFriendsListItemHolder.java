package com.facebook.redspace.ui.friendslist;

import android.view.View;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;

/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_DROPPED */
public interface RedSpaceFriendsListItemHolder {
    RedSpaceFeedProfileFragmentModel getProfile();

    View getProfilePictureView();

    RedSpaceFriendsSection getSection();
}
