package com.facebook.photos.albums.abtest;

import com.facebook.qe.api.QeAccessor;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@Immutable
/* compiled from: magic_stories_kit_swap_asset */
public class VideoAlbumConfig {
    public final boolean f9438a;

    @Inject
    public VideoAlbumConfig(QeAccessor qeAccessor) {
        this.f9438a = qeAccessor.a(ExperimentsForVideoAbTestModule.dN, false);
    }
}
