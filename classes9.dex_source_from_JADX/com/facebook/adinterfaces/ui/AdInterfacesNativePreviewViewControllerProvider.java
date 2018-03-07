package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.HasAdCreative;
import com.facebook.adinterfaces.nativepreview.AdInterfacesNativePreviewRenderer;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController.AdInterfacesNativePreviewFetcher;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;

/* compiled from: V2_CAMERA_ROLL */
public class AdInterfacesNativePreviewViewControllerProvider extends AbstractAssistedProvider<AdInterfacesNativePreviewViewController> {
    public final <D extends BaseAdInterfacesData & HasAdCreative> AdInterfacesNativePreviewViewController<D> m24772a(AdInterfacesNativePreviewFetcher adInterfacesNativePreviewFetcher) {
        return new AdInterfacesNativePreviewViewController(AdInterfacesDataHelper.m22789a((InjectorLike) this), AdInterfacesErrorReporter.m22724a(this), TasksManager.b(this), AdInterfacesNativePreviewRenderer.m22904a(this), adInterfacesNativePreviewFetcher);
    }
}
