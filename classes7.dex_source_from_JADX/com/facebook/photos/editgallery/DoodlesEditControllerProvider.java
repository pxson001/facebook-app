package com.facebook.photos.editgallery;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.google.common.base.Optional;

/* compiled from: legalapproved/ */
public class DoodlesEditControllerProvider extends AbstractAssistedProvider<DoodlesEditController> {
    public final DoodlesEditController m12107a(FrameLayout frameLayout, View view, EditableOverlayContainerView editableOverlayContainerView, String str, Optional<CreativeEditingLogger> optional, RotatingPhotoViewController rotatingPhotoViewController) {
        return new DoodlesEditController(frameLayout, view, editableOverlayContainerView, str, optional, rotatingPhotoViewController, (Context) getInstance(Context.class), CreativeEditingFileManager.a(this));
    }
}
