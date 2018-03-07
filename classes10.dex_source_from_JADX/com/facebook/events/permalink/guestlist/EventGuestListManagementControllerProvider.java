package com.facebook.events.permalink.guestlist;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;

/* compiled from: bot_composer_structured_menu */
public class EventGuestListManagementControllerProvider extends AbstractAssistedProvider<EventGuestListManagementController> {
    public final EventGuestListManagementController m18741a(String str, EventGuestListType eventGuestListType, ImmutableList<EventGuestSingleListModel> immutableList, EventActionContext eventActionContext, ActionMechanism actionMechanism) {
        return new EventGuestListManagementController(TasksManager.b(this), GraphQLQueryExecutor.a(this), str, eventGuestListType, immutableList, eventActionContext, actionMechanism);
    }
}
