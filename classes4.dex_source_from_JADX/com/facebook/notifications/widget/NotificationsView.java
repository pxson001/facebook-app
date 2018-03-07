package com.facebook.notifications.widget;

import android.view.View.OnClickListener;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike;

/* compiled from: exception= */
public interface NotificationsView {
    void mo916a();

    void mo917a(OnClickListener onClickListener, RetryClickedListener retryClickedListener);

    void mo918a(boolean z);

    void mo919b(boolean z);

    void mo920c(boolean z);

    BetterListView getListView();

    RefreshableViewContainerLike getRefreshableContainerLike();

    ScrollingViewProxy getScrollingViewProxy();

    FbSwipeRefreshLayout getSwipeRefreshLayout();
}
