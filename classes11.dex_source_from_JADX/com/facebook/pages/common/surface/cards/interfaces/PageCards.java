package com.facebook.pages.common.surface.cards.interfaces;

import android.view.ViewParent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.widget.OnDispatchDrawListener;

/* compiled from: space_owner_id */
public interface PageCards {

    /* compiled from: space_owner_id */
    public interface PageCardView {
    }

    /* compiled from: space_owner_id */
    public interface PageHeaderCardView extends PageCardView {
        void mo29a(PageHeaderData pageHeaderData);

        void setParentFragment(FbFragment fbFragment);
    }

    /* compiled from: space_owner_id */
    public interface PageSecondaryCardView extends PageCardView {
        void m3357a(OnDispatchDrawListener onDispatchDrawListener);

        void getLocationOnScreen(int[] iArr);

        ViewParent getParent();
    }
}
