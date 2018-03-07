package com.facebook.redspace.ui.friendslist;

import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.ui.clickwithpositionlistener.HasOnClickAndOnTouchListener;

/* compiled from: PRIVACY_CHECKUP_INTRO_STEP_NEXT */
public interface RedSpaceFriendsOverflowView extends HasOnClickAndOnTouchListener {
    void mo357a(OverflowFriendsModel overflowFriendsModel, RedSpaceFriendsSection redSpaceFriendsSection);

    RedSpaceFriendsSection getSection();
}
