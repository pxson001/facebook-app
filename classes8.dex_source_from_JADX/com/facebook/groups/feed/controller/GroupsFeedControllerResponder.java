package com.facebook.groups.feed.controller;

import android.view.View;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.annotation.Nullable;

/* compiled from: failed to get list of suggested friends */
public interface GroupsFeedControllerResponder {
    FeedEnvironment m15546a(BetterListView betterListView);

    MultiRowAdapter m15547a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment);

    void m15548a(View view);

    void m15549a(boolean z, boolean z2);

    boolean m15550a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner);

    void m15551b(boolean z);

    void m15552f();

    @Nullable
    FbBaseAdapter m15553l();

    @Nullable
    FbBaseAdapter m15554m();

    void nt_();

    void m15555r();
}
