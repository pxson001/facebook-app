package com.facebook.entitycards.view;

import android.content.Context;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.presenter.ViewPresenter;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: home_%s_remove_camera_icon_tapped */
public class EntityCardContainerView extends CustomFrameLayout {
    public EntityCardContainerPresenter f11105a;
    public final CustomFrameLayout f11106b = ((CustomFrameLayout) c(2131561193));

    public /* bridge */ /* synthetic */ void setPresenter(ViewPresenter viewPresenter) {
        this.f11105a = (EntityCardContainerPresenter) viewPresenter;
    }

    public EntityCardContainerView(Context context) {
        super(context);
        setContentView(2130903982);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433154);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public ImmutableList<View> getCardViews() {
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f11106b.getChildCount(); i++) {
            builder.c(this.f11106b.getChildAt(i));
        }
        return builder.b();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1603672415);
        super.onDetachedFromWindow();
        if (this.f11105a != null) {
            this.f11105a.m13039a(this);
            this.f11105a = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2000393186, a);
    }
}
