package com.facebook.photos.editgallery;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Optional;

/* compiled from: leadgen_id */
public class FilterEditControllerProvider extends AbstractAssistedProvider<FilterEditController> {
    public final FilterEditController m12258a(ViewStub viewStub, CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, EditableOverlayContainerView editableOverlayContainerView, EditGallerySwipeableLayoutController editGallerySwipeableLayoutController, Optional<CreativeEditingLogger> optional, Uri uri, View view) {
        return new FilterEditController(viewStub, creativeEditingSwipeableLayout, editableOverlayContainerView, editGallerySwipeableLayoutController, optional, uri, view, (Context) getInstance(Context.class), (FilterPickerScrollAdapterProvider) getOnDemandAssistedProviderForStaticDi(FilterPickerScrollAdapterProvider.class), IdBasedProvider.a(this, 9303), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
