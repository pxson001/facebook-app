package com.facebook.localcontent.photos;

import android.content.res.Resources;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: document_body_elements */
public class PlacePhotoUploadHandler {
    public final Resources f15219a;
    public final Toaster f15220b;
    public final UploadManager f15221c;
    public final UploadOperationFactory f15222d;

    @Inject
    public PlacePhotoUploadHandler(Resources resources, Toaster toaster, UploadManager uploadManager, UploadOperationFactory uploadOperationFactory) {
        this.f15219a = resources;
        this.f15220b = toaster;
        this.f15221c = uploadManager;
        this.f15222d = uploadOperationFactory;
    }
}
