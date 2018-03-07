package com.facebook.widget.tiles;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN */
public interface ThreadTileViewData {
    int mo1507a();

    ImageRequest mo1508a(int i, int i2, int i3);

    ImageRequest mo1509b(int i, int i2, int i3);

    TileBadge mo1510b();

    boolean mo1511c();

    ImmutableList<UserKey> mo1512d();

    @Nullable
    Bitmap mo1513e();

    String mo1514f();
}
