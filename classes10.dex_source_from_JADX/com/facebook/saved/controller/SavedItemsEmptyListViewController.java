package com.facebook.saved.controller;

import android.view.ViewStub;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.binders.SavedItemsEmptyListViewBinder;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.views.SavedDashboardEmptyView;
import com.facebook.saved.views.SavedDashboardEmptyView.OnEmptyViewReadyListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: is_adunit */
public class SavedItemsEmptyListViewController extends OnRefreshListener {
    public ScrollingViewProxy f9086a;
    public SavedDashboardEmptyView f9087b;
    public ViewStub f9088c;
    private SavedItemsEmptyListViewBinder f9089d;

    public static SavedItemsEmptyListViewController m9097a(InjectorLike injectorLike) {
        return new SavedItemsEmptyListViewController(SavedItemsEmptyListViewBinder.m8941a(injectorLike));
    }

    @Inject
    public SavedItemsEmptyListViewController(SavedItemsEmptyListViewBinder savedItemsEmptyListViewBinder) {
        this.f9089d = savedItemsEmptyListViewBinder;
    }

    public final boolean m9099a(OnEmptyViewReadyListener onEmptyViewReadyListener, Optional<SavedDashboardSection> optional) {
        if (this.f9087b == null) {
            this.f9087b = (SavedDashboardEmptyView) this.f9088c.inflate();
            this.f9086a.f(this.f9087b);
            this.f9087b.setOnEmptyViewReadyListener(onEmptyViewReadyListener);
            this.f9089d.m8943a(this.f9087b, optional);
            return false;
        }
        this.f9089d.m8943a(this.f9087b, optional);
        return true;
    }

    public final void m9100b(boolean z) {
        if (this.f9087b != null) {
            this.f9087b.m9495a();
        }
    }

    public final void m9098a() {
        if (this.f9087b != null) {
            this.f9087b.m9496b();
        }
    }
}
