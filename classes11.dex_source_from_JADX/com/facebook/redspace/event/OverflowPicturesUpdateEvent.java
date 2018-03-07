package com.facebook.redspace.event;

import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.NodesModel;
import com.google.common.collect.ImmutableList;

/* compiled from: PenaltyDeath */
public class OverflowPicturesUpdateEvent implements RedSpaceEvent {
    public RedSpaceFriendsSection f11933a;
    public ImmutableList<NodesModel> f11934b;

    public OverflowPicturesUpdateEvent(RedSpaceFriendsSection redSpaceFriendsSection, ImmutableList<NodesModel> immutableList) {
        this.f11933a = redSpaceFriendsSection;
        this.f11934b = immutableList;
    }
}
