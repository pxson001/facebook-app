package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: mIsLoggedOutPush */
public interface FramePackProvider {
    @Nullable
    ListenableFuture<ImmutableList<FramePack>> mo508a();
}
