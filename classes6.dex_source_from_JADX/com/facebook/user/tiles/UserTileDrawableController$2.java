package com.facebook.user.tiles;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: contributor_pic_height */
class UserTileDrawableController$2 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    final /* synthetic */ ImageRequest f18472a;
    final /* synthetic */ boolean f18473b;
    final /* synthetic */ UserTileDrawableController f18474c;

    UserTileDrawableController$2(UserTileDrawableController userTileDrawableController, ImageRequest imageRequest, boolean z) {
        this.f18474c = userTileDrawableController;
        this.f18472a = imageRequest;
        this.f18473b = z;
    }

    public final void m27087e(DataSource<CloseableReference<CloseableImage>> dataSource) {
        UserTileDrawableController.a(this.f18474c, dataSource, this.f18472a);
    }

    public final void m27088f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        UserTileDrawableController.c(this.f18474c, this.f18473b);
    }
}
