package com.facebook.groups.feed.ui;

import android.content.Context;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.EmptyFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.groups.feed.menu.GroupsFeedStoryMenuHelperProvider;
import com.facebook.groups.feed.menu.GroupsPinnedStoryMenuHelperProvider;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: TimelineFilterHandler */
public class GroupsEnvironmentProvider extends AbstractAssistedProvider<GroupsEnvironment> {
    public final GroupsEnvironment m23223a(MenuType menuType, Context context, FeedListType feedListType, Runnable runnable, Delegate delegate, MutationControllerManager mutationControllerManager) {
        return new GroupsEnvironment(menuType, context, feedListType, runnable, delegate, mutationControllerManager, (GroupsFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(GroupsFeedStoryMenuHelperProvider.class), (GroupsPinnedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(GroupsPinnedStoryMenuHelperProvider.class), EmptyFeedStoryMenuHelper.b(this));
    }
}
