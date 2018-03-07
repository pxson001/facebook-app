package com.facebook.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.slideshow.ui.DragSortThumbnailListView;
import com.facebook.slideshow.ui.PlayableSlideshowView;

/* compiled from: PLAYBACK_FAILED */
public class SlideshowEditFragment extends FbFragment {
    public PlayableSlideshowView f12560a;
    public DragSortThumbnailListView f12561b;

    public final View m12965a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 202026814);
        View inflate = layoutInflater.inflate(2130907128, viewGroup, false);
        this.f12560a = (PlayableSlideshowView) FindViewUtil.b(inflate, 2131567485);
        this.f12561b = (DragSortThumbnailListView) FindViewUtil.b(inflate, 2131567486);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 353439284, a);
        return inflate;
    }

    public final void m12964H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1092532716);
        super.H();
        this.f12560a.m13006a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1051901145, a);
    }

    public final PlayableSlideshowView m12966b() {
        return this.f12560a;
    }

    public final DragSortThumbnailListView m12967e() {
        return this.f12561b;
    }
}
