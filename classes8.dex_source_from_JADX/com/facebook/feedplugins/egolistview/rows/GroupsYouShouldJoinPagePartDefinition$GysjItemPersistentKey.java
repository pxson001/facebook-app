package com.facebook.feedplugins.egolistview.rows;

import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;

/* compiled from: gravity_start_page_lookup */
public class GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentKey implements ContextStateKey<String, GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState> {
    public static final String f12072a = GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentKey.class.getName();
    private final String f12073b;

    public GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentKey(GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem) {
        String str;
        if (groupsYouShouldJoinFeedUnitItem.j() == null || StringUtil.a(groupsYouShouldJoinFeedUnitItem.j().I())) {
            str = f12072a + groupsYouShouldJoinFeedUnitItem.hashCode();
        } else {
            str = f12072a + groupsYouShouldJoinFeedUnitItem.j().I();
        }
        this.f12073b = str;
    }

    public final Object m14101b() {
        return this.f12073b;
    }

    public final Object m14100a() {
        return new GroupsYouShouldJoinPagePartDefinition$GysjItemPersistentState();
    }
}
