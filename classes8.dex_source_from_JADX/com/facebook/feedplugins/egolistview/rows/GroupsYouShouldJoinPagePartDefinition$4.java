package com.facebook.feedplugins.egolistview.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupLeaveInputData.Source;
import com.facebook.graphql.calls.GroupRequestToJoinInputData;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: gravity_start_page_lookup */
class GroupsYouShouldJoinPagePartDefinition$4 implements OnClickListener {
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState f12062a;
    final /* synthetic */ GroupsYouShouldJoinFeedUnitItem f12063b;
    final /* synthetic */ GroupsYouShouldJoinFeedUnit f12064c;
    final /* synthetic */ HasInvalidate f12065d;
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition f12066e;

    GroupsYouShouldJoinPagePartDefinition$4(GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition, GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState groupsYouShouldJoinPagePartDefinition$GysjItemPersistentState, GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem, GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit, HasInvalidate hasInvalidate) {
        this.f12066e = groupsYouShouldJoinPagePartDefinition;
        this.f12062a = groupsYouShouldJoinPagePartDefinition$GysjItemPersistentState;
        this.f12063b = groupsYouShouldJoinFeedUnitItem;
        this.f12064c = groupsYouShouldJoinFeedUnit;
        this.f12065d = hasInvalidate;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 845704988);
        boolean z = this.f12062a.f12074a;
        ListenableFuture a2 = z ? this.f12066e.f.m16963a(FeedUnitItemProfileHelper.a(this.f12063b).b(), Source.GYSJ, ReaddPolicy.ALLOW_READD) : this.f12066e.f.m16964a(FeedUnitItemProfileHelper.a(this.f12063b).b(), GroupRequestToJoinInputData.Source.GYSJ);
        if (!z) {
            GroupsYouShouldJoinPagePartDefinition.a(this.f12066e, this.f12064c, this.f12063b, "gysj_join");
        }
        Futures.a(a2, GroupsYouShouldJoinPagePartDefinition.a(this.f12066e, this.f12065d, this.f12064c, this.f12063b, z, this.f12062a), this.f12066e.g);
        LogUtils.a(884897628, a);
    }
}
