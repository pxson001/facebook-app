package com.facebook.photos.editgallery.utils;

import com.facebook.bitmaps.NativeImageProcessor;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.ui.toaster.Toaster;

/* compiled from: last_frame_pack_nuxed_start_time */
public class CropImageUtilsProvider extends AbstractAssistedProvider<CropImageUtils> {
    public final CropImageUtils m12373a(String str) {
        return new CropImageUtils(str, ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), CreativeEditingFileManager.a(this), ImagePipelineMethodAutoProvider.a(this), IdBasedLazy.a(this, 3561), NativeImageProcessor.b(this), Toaster.b(this));
    }
}
