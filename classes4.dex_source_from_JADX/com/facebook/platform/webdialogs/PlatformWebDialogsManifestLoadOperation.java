package com.facebook.platform.webdialogs;

import android.util.Pair;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifest.ManifestWrapper;
import javax.inject.Inject;

/* compiled from: from_reset */
public class PlatformWebDialogsManifestLoadOperation extends AbstractPlatformOperation {
    private PlatformWebDialogsManifest f11344b;

    @Inject
    public PlatformWebDialogsManifestLoadOperation(PlatformWebDialogsManifest platformWebDialogsManifest) {
        super("platform_webdialogs_load_manifest");
        this.f11344b = platformWebDialogsManifest;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        PlatformWebDialogsManifest platformWebDialogsManifest = this.f11344b;
        platformWebDialogsManifest.f9051t.b("This method will perform disk I/O and should not be called on the UI thread");
        ManifestWrapper manifestWrapper = null;
        Pair a = platformWebDialogsManifest.f9047p.m9403a(PlatformWebDialogsPrefKeys.f11171i, "PlatformWebDialogsManifest", ManifestWrapper.class);
        if (a != null) {
            manifestWrapper = (ManifestWrapper) a.second;
            if (((Boolean) a.first).booleanValue() && manifestWrapper != null && manifestWrapper.m11786a() == null) {
                platformWebDialogsManifest.f9047p.m9405a();
                platformWebDialogsManifest.f9049r.a("PlatformWebDialogsManifest", "Deserialized manifest had NULL actionManifests.");
            }
        }
        ManifestWrapper manifestWrapper2 = manifestWrapper;
        if (manifestWrapper2 != null) {
            return OperationResult.a(manifestWrapper2);
        }
        return OperationResult.a;
    }
}
