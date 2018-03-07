package com.facebook.feed.rows.sections.offline.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.feedback.ui.BlingBar;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
import com.google.common.base.Preconditions;

/* compiled from: UN_SEE_FIRST */
public class OfflineBlingBarView extends FrameLayout implements BlingBar {
    public OfflineBlingBarView(Context context) {
        super(context);
    }

    public DefaultBlingBarView getBaseView() {
        View childAt = getChildAt(0);
        Preconditions.checkState(childAt instanceof DefaultBlingBarView);
        return (DefaultBlingBarView) childAt;
    }

    public void setLikes(int i) {
        getBaseView().setLikes(i);
    }

    public void setShares(int i) {
        getBaseView().setShares(i);
    }

    public void setComments(int i) {
        getBaseView().setComments(i);
    }

    public void setIsExpanded(boolean z) {
        getBaseView().setIsExpanded(z);
    }

    public View getLikersCountView() {
        return getBaseView().getLikersCountView();
    }

    public View getContainerView() {
        return getBaseView().getContainerView();
    }

    public void setHeight(int i) {
        getBaseView().setHeight(i);
    }
}
