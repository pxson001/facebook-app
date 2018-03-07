package com.facebook.groups.feed.controller;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feedcontrollers.FeedDeletePostController;
import com.facebook.feedcontrollers.FeedEditPostController;
import com.facebook.feedcontrollers.FeedLikeController;
import com.facebook.feedcontrollers.FeedSetNotifyMeController;
import com.facebook.feedcontrollers.FeedStoryVisibilityController;
import com.facebook.feedcontrollers.FeedUnitMutationController;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import javax.inject.Inject;

/* compiled from: fail_cookies_not_found */
public class GroupsListViewController {
    public final MultipleRowsStoriesRecycleCallback f13959a;
    public final FeedDeletePostController f13960b;
    public final FeedEditPostController f13961c;
    public final FeedLikeController f13962d;
    public final FeedSetNotifyMeController f13963e;
    public final FeedStoryVisibilityController f13964f;
    public final FeedUnitMutationController f13965g;
    public View f13966h;
    public GroupsFeedControllerResponder f13967i;
    public ConnectionController<GraphQLFeedUnitEdge, Boolean> f13968j;
    public SwipeRefreshLayout f13969k;
    public ListViewProxy f13970l;
    public MultiRowAdapter f13971m;

    /* compiled from: fail_cookies_not_found */
    public class C14821 implements OnRefreshListener {
        final /* synthetic */ GroupsListViewController f13956a;

        public C14821(GroupsListViewController groupsListViewController) {
            this.f13956a = groupsListViewController;
        }

        public final void m15578a() {
            this.f13956a.f13968j.a(10, Boolean.TRUE);
        }
    }

    /* compiled from: fail_cookies_not_found */
    public class C14832 implements OnScrollListener {
        final /* synthetic */ GroupsListViewController f13957a;

        public C14832(GroupsListViewController groupsListViewController) {
            this.f13957a = groupsListViewController;
        }

        public final void m15580a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            GroupsListViewController groupsListViewController = this.f13957a;
            Object obj = null;
            ConnectionState d = groupsListViewController.f13968j.d();
            if (d.d() != 0 && d.c().d && i2 > 0 && i3 > 0 && (i + i2) + 5 > i3) {
                obj = 1;
            }
            if (obj != null) {
                groupsListViewController.f13968j.b(10, Boolean.FALSE);
            }
        }

        public final void m15579a(ScrollingViewProxy scrollingViewProxy, int i) {
        }
    }

    /* compiled from: fail_cookies_not_found */
    public class C14843 implements ListItemCollection<FeedEdge> {
        final /* synthetic */ GroupsListViewController f13958a;

        public C14843(GroupsListViewController groupsListViewController) {
            this.f13958a = groupsListViewController;
        }

        public final int m15581a() {
            return this.f13958a.f13968j.d().d();
        }

        public final Object m15582a(int i) {
            return (GraphQLFeedUnitEdge) this.f13958a.f13968j.d().a(i);
        }
    }

    public static GroupsListViewController m15583a(InjectorLike injectorLike) {
        return new GroupsListViewController(MultipleRowsStoriesRecycleCallback.a(injectorLike), FeedDeletePostController.m14026b(injectorLike), FeedEditPostController.m14030b(injectorLike), FeedLikeController.m14040b(injectorLike), FeedSetNotifyMeController.m14047b(injectorLike), FeedStoryVisibilityController.m14054b(injectorLike), FeedUnitMutationController.m14059b(injectorLike));
    }

    @Inject
    public GroupsListViewController(MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedDeletePostController feedDeletePostController, FeedEditPostController feedEditPostController, FeedLikeController feedLikeController, FeedSetNotifyMeController feedSetNotifyMeController, FeedStoryVisibilityController feedStoryVisibilityController, FeedUnitMutationController feedUnitMutationController) {
        this.f13959a = multipleRowsStoriesRecycleCallback;
        this.f13960b = feedDeletePostController;
        this.f13961c = feedEditPostController;
        this.f13962d = feedLikeController;
        this.f13963e = feedSetNotifyMeController;
        this.f13964f = feedStoryVisibilityController;
        this.f13965g = feedUnitMutationController;
    }
}
