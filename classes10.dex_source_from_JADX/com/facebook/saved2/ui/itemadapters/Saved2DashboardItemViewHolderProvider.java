package com.facebook.saved2.ui.itemadapters;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.saved2.analytics.Saved2StartPerfLogger;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.events.VideoDownloadEventBus;

/* compiled from: inconceivable exception  */
public class Saved2DashboardItemViewHolderProvider extends AbstractAssistedProvider<Saved2DashboardItemViewHolder> {
    public final Saved2DashboardItemViewHolder m9868a(FragmentActivity fragmentActivity, View view, String str, PopoverTrackingState popoverTrackingState) {
        return new Saved2DashboardItemViewHolder(fragmentActivity, view, str, popoverTrackingState, IdBasedLazy.a(this, 10449), IdBasedLazy.a(this, 10442), Saved2StartPerfLogger.m9519a((InjectorLike) this), DownloadManager.a(this), VideoDownloadEventBus.a(this));
    }
}
