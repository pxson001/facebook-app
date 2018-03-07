package com.facebook.photos.editgallery;

import android.graphics.Rect;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.common.MediaEditFeatureController;

/* compiled from: link_click */
public interface EditFeatureController extends MediaEditFeatureController {

    /* compiled from: link_click */
    public enum UriRequestType {
        SHOW_ORIGINAL_URI,
        SHOW_EDITED_URI,
        NONE
    }

    void mo560a(Rect rect);

    void mo561a(State state);

    void mo562a(UsageParams usageParams);

    void mo563a(boolean z);

    UriRequestType mo573k();

    boolean mo574l();

    State mo575m();
}
