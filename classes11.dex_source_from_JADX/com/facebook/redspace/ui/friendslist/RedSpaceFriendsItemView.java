package com.facebook.redspace.ui.friendslist;

import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;

/* compiled from: PRIVACY_CHECKUP_REVIEW_STEP_PREVIOUS */
public interface RedSpaceFriendsItemView {
    void mo353a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, boolean z);

    void setOnProfileClickListener(OnClickListener onClickListener);

    void setOnProfileLongClickListener(OnLongClickListener onLongClickListener);
}
