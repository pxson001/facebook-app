package com.facebook.groups.feed.ui;

import android.content.Context;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.EmptyFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.groups.feed.menu.GroupsFeedStoryMenuHelperProvider;
import com.facebook.groups.feed.menu.GroupsPinnedStoryMenuHelperProvider;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: TimelineFirstOnDraw */
public class GroupsEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final BaseFeedStoryMenuHelper f22112m;
    private final FeedListType f22113n;
    private final MutationControllerManager f22114o;

    /* compiled from: TimelineFirstOnDraw */
    public enum MenuType {
        NORMAL,
        PENDING,
        PINNED
    }

    @Inject
    public GroupsEnvironment(@Assisted MenuType menuType, @Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted Delegate delegate, @Assisted MutationControllerManager mutationControllerManager, GroupsFeedStoryMenuHelperProvider groupsFeedStoryMenuHelperProvider, GroupsPinnedStoryMenuHelperProvider groupsPinnedStoryMenuHelperProvider, EmptyFeedStoryMenuHelper emptyFeedStoryMenuHelper) {
        super(context, runnable, delegate);
        this.f22113n = feedListType;
        if (menuType == MenuType.NORMAL) {
            this.f22112m = groupsFeedStoryMenuHelperProvider.a(this);
        } else if (menuType == MenuType.PENDING) {
            this.f22112m = emptyFeedStoryMenuHelper;
        } else {
            this.f22112m = groupsPinnedStoryMenuHelperProvider.a(this);
        }
        this.f22114o = mutationControllerManager;
    }

    public final BaseFeedStoryMenuHelper m23222e() {
        return this.f22112m;
    }

    public final FeedListType m23221c() {
        return this.f22113n;
    }
}
