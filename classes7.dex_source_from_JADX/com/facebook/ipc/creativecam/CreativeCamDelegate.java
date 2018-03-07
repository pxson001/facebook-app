package com.facebook.ipc.creativecam;

import android.net.Uri;
import android.view.ViewStub;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: places_feed_place_question */
public interface CreativeCamDelegate {
    @Nullable
    ListenableFuture<ImmutableList<Frame>> m8037a();

    void m8038a(int i);

    void m8039a(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo);

    void m8040a(ViewStub viewStub);

    @Nullable
    CreativeCamPickerPreviewController m8041b();

    void m8042b(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo);

    @Nullable
    CreativeCamTopBarController m8043c();

    @Nullable
    ProfilePictureOverlaySwipeableFramesLogController m8044d();
}
