package com.facebook.slideshow;

import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.slideshow.ui.DragSortThumbnailListViewController;
import com.facebook.slideshow.ui.DragSortThumbnailListViewControllerProvider;
import com.facebook.slideshow.ui.PlayableSlideshowViewController;
import com.facebook.slideshow.ui.PlayableSlideshowViewControllerProvider;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: PLAYLIST_INFO_AND_VIDEOS */
public class SlideshowEditController {
    private final SlideshowEditFragment f12557a;
    private final PlayableSlideshowViewController f12558b;
    private final DragSortThumbnailListViewController f12559c;

    @Inject
    public SlideshowEditController(@Assisted SlideshowEditFragment slideshowEditFragment, @Assisted ImmutableList<MediaItem> immutableList, @Assisted String str, PlayableSlideshowViewControllerProvider playableSlideshowViewControllerProvider, DragSortThumbnailListViewControllerProvider dragSortThumbnailListViewControllerProvider) {
        this.f12557a = slideshowEditFragment;
        this.f12558b = playableSlideshowViewControllerProvider.m13014a(this.f12557a.f12560a, str);
        this.f12559c = dragSortThumbnailListViewControllerProvider.m12993a(this.f12557a.f12561b, str);
        m12963a(immutableList);
    }

    public final void m12963a(ImmutableList<MediaItem> immutableList) {
        this.f12558b.m13012a(immutableList, true);
        this.f12559c.m12992a((ImmutableList) immutableList);
    }

    public final List<MediaItem> m12962a() {
        return this.f12559c.f12571a;
    }
}
