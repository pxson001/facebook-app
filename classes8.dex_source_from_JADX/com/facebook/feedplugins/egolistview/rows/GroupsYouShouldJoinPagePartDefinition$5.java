package com.facebook.feedplugins.egolistview.rows;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: gravity_start_page_lookup */
public class GroupsYouShouldJoinPagePartDefinition$5 implements FutureCallback<Void> {
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState f12067a;
    final /* synthetic */ boolean f12068b;
    final /* synthetic */ GroupsYouShouldJoinFeedUnit f12069c;
    final /* synthetic */ HasInvalidate f12070d;
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition f12071e;

    public GroupsYouShouldJoinPagePartDefinition$5(GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition, GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState groupsYouShouldJoinPagePartDefinition$GysjItemPersistentState, boolean z, GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit, HasInvalidate hasInvalidate) {
        this.f12071e = groupsYouShouldJoinPagePartDefinition;
        this.f12067a = groupsYouShouldJoinPagePartDefinition$GysjItemPersistentState;
        this.f12068b = z;
        this.f12069c = groupsYouShouldJoinFeedUnit;
        this.f12070d = hasInvalidate;
    }

    public void onSuccess(Object obj) {
        boolean z;
        GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState groupsYouShouldJoinPagePartDefinition$GysjItemPersistentState = this.f12067a;
        if (this.f12068b) {
            z = false;
        } else {
            z = true;
        }
        groupsYouShouldJoinPagePartDefinition$GysjItemPersistentState.f12074a = z;
        FetchTimeMsHelper.a(this.f12069c, this.f12069c.T_() + 1);
        this.f12070d.a(new Object[]{this.f12069c});
    }

    public void onFailure(Throwable th) {
        this.f12071e.h.m14586a(th);
    }
}
