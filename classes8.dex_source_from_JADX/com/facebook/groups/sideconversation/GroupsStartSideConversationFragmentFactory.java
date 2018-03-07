package com.facebook.groups.sideconversation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.sideconversation.ui.GroupsStartSideConversationFragment;

/* compiled from: entity_cards.context_items_view_controller */
public class GroupsStartSideConversationFragmentFactory implements IFragmentFactory {
    public final Fragment m17165a(Intent intent) {
        GroupsStartSideConversationFragment groupsStartSideConversationFragment = new GroupsStartSideConversationFragment();
        groupsStartSideConversationFragment.g(intent.getExtras());
        return groupsStartSideConversationFragment;
    }
}
