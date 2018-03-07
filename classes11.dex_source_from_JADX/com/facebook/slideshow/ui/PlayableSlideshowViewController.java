package com.facebook.slideshow.ui;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.slideshow.ui.DragSortThumbnailListViewController.ItemListListener;
import com.facebook.slideshow.ui.PlayableSlideshowView.SlideshowViewConfiguration;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: PHOTO_CHECKUP_BULK_EDIT_REJECTED */
public class PlayableSlideshowViewController implements ItemListListener {
    private static final CallerContext f12602a = CallerContext.a(PlayableSlideshowView.class, "slideshow_in_composer");
    private final FbDraweeControllerBuilder f12603b;
    private final SlideshowViewConfiguration f12604c = new SlideshowViewConfiguration(0, 2000, 200, false);
    private PlayableSlideshowView f12605d;
    private String f12606e;

    @Inject
    public PlayableSlideshowViewController(@Assisted PlayableSlideshowView playableSlideshowView, @Assisted String str, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f12605d = playableSlideshowView;
        this.f12606e = str;
        this.f12603b = fbDraweeControllerBuilder;
        this.f12603b.a(f12602a);
    }

    public final void m13012a(ImmutableList<MediaItem> immutableList, boolean z) {
        if (!immutableList.isEmpty()) {
            Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(this.f12603b.b(((MediaItem) immutableList.get(i)).f()).s());
            }
            this.f12605d.m13007a(this.f12606e, builder.b(), this.f12604c);
            if (z) {
                this.f12605d.m13008b();
            }
        }
    }

    public final void mo360a(ImmutableList<MediaItem> immutableList) {
        m13012a(immutableList, false);
    }

    public final void mo359a() {
        this.f12605d.m13006a();
    }

    public final void mo361b() {
        this.f12605d.m13006a();
    }
}
