package com.facebook.groups.logging;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: f46d6cba7867c8a80abb5b46d231b644 */
public enum GroupsTabSequences {
    RANKED_BOOKMARKS_SECTION("MeTabRankedBookmarksSection"),
    EVENTS_SECTION("GroupsTabEventsSection"),
    GROUPS_SECTION("GroupsTabGroupsSection"),
    POG_SECTION("GroupsTabPOGSection");
    
    public static final GroupsTabTTISequences GROUPS_TAB_TTI_SEQUENCE = null;
    private String mName;

    /* compiled from: f46d6cba7867c8a80abb5b46d231b644 */
    public final class GroupsTabTTISequences extends AbstractSequenceDefinition {
        public GroupsTabTTISequences() {
            super(7864322, "GroupsTabTTISequences", true, ImmutableSet.of("com.facebook.groups.groupstab.ui.GroupsTabFragment"));
        }
    }

    static {
        GROUPS_TAB_TTI_SEQUENCE = new GroupsTabTTISequences();
    }

    private GroupsTabSequences(String str) {
        this.mName = str;
    }

    public final String getName() {
        return this.mName;
    }
}
