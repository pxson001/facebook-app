package com.facebook.orca.threadview;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.orca.threadview.messagelist.MessageListViewTypeHelper;

/* compiled from: messenger_people_tab_invite_friends_upsell */
public class MessageListAdapterForRecyclerViewProvider extends AbstractAssistedProvider<MessageListAdapterForRecyclerView> {
    public final MessageListAdapterForRecyclerView m6911a(MessageListAdapter messageListAdapter) {
        return new MessageListAdapterForRecyclerView(MessageListViewTypeHelper.m8236b(this), messageListAdapter);
    }
}
