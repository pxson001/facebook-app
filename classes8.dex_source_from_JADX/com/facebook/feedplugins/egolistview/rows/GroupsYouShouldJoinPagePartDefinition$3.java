package com.facebook.feedplugins.egolistview.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: gravity_start_page_lookup */
public class GroupsYouShouldJoinPagePartDefinition$3 implements OnClickListener {
    final /* synthetic */ GroupsYouShouldJoinFeedUnitItem f12059a;
    final /* synthetic */ GroupsYouShouldJoinFeedUnit f12060b;
    final /* synthetic */ GroupsYouShouldJoinPagePartDefinition f12061c;

    public GroupsYouShouldJoinPagePartDefinition$3(GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition, GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem, GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit) {
        this.f12061c = groupsYouShouldJoinPagePartDefinition;
        this.f12059a = groupsYouShouldJoinFeedUnitItem;
        this.f12060b = groupsYouShouldJoinFeedUnit;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2111142291);
        this.f12061c.j.a(this.f12060b, FeedUnitItemProfileHelper.a(this.f12059a).b());
        Logger.a(2, EntryType.UI_INPUT_END, -1167661281, a);
    }
}
