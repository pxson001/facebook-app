package com.facebook.widget.refreshableview;

import android.view.ViewGroup;

/* compiled from: reactions_dock_select_4 */
public interface RefreshableViewContainerLike {

    /* compiled from: reactions_dock_select_4 */
    public abstract class OnRefreshListener {
        public abstract void m8745b(boolean z);

        public void m8744a() {
        }
    }

    void mo439b(int i);

    ViewGroup mo440c();

    void mo441d();

    void mo442e();

    void mo443f();

    void setHeaderVisibility(int i);

    void setOnRefreshListener(OnRefreshListener onRefreshListener);
}
