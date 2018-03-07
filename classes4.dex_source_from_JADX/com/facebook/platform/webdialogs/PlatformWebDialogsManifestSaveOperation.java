package com.facebook.platform.webdialogs;

import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifest.ManifestWrapper;
import javax.inject.Inject;

/* compiled from: from_prepare */
public class PlatformWebDialogsManifestSaveOperation extends AbstractPlatformOperation {
    private PlatformWebDialogsManifest f11345b;

    @Inject
    public PlatformWebDialogsManifestSaveOperation(PlatformWebDialogsManifest platformWebDialogsManifest) {
        super("platform_webdialogs_save_manifest");
        this.f11345b = platformWebDialogsManifest;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Object parcelable = operationParams.c.getParcelable("platform_webdialogs_save_parcel");
        PlatformWebDialogsManifest platformWebDialogsManifest = this.f11345b;
        platformWebDialogsManifest.f9051t.b("This method will perform disk I/O and should not be called on the UI thread");
        if (parcelable != null && (parcelable instanceof ManifestWrapper)) {
            if (platformWebDialogsManifest.f9047p.m9407a(PlatformWebDialogsPrefKeys.f11171i, "PlatformWebDialogsManifest", parcelable)) {
                platformWebDialogsManifest.f9050s.edit().a(PlatformWebDialogsPrefKeys.f11172j, platformWebDialogsManifest.f9035d).commit();
            }
            platformWebDialogsManifest.f9047p.m9413e();
        }
        return OperationResult.a;
    }
}
