package com.facebook.feedplugins.egolistview.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: gravity_start_page_lookup */
class GroupsYouShouldJoinPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition$Props f12057a;
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition f12058b;

    GroupsYouShouldJoinPagePartDefinition$2(GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition, GroupsYouShouldJoinPagePartDefinition$Props groupsYouShouldJoinPagePartDefinition$Props) {
        this.f12058b = groupsYouShouldJoinPagePartDefinition;
        this.f12057a = groupsYouShouldJoinPagePartDefinition$Props;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 573595825);
        GroupsYouShouldJoinPagePartDefinition.a(this.f12058b, this.f12057a.f12075a, this.f12057a.f12076b, "gysj_profile");
        this.f12058b.c.a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(this.f12057a.f12076b)), null);
        Logger.a(2, EntryType.UI_INPUT_END, -428101429, a);
    }
}
