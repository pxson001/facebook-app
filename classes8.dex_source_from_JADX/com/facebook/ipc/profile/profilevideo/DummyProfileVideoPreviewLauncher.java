package com.facebook.ipc.profile.profilevideo;

import android.app.Activity;
import android.net.Uri;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.inject.InjectorLike;
import com.facebook.share.model.ComposerAppAttribution;
import javax.annotation.Nullable;

/* compiled from: unitTypeToken */
public class DummyProfileVideoPreviewLauncher implements ProfileVideoPreviewLauncher {
    public static DummyProfileVideoPreviewLauncher m1391a(InjectorLike injectorLike) {
        return new DummyProfileVideoPreviewLauncher();
    }

    public final void mo53a(Activity activity, String str, Uri uri, int i, int i2, @Nullable ImageOverlayFieldsModel imageOverlayFieldsModel, @Nullable ComposerAppAttribution composerAppAttribution, long j) {
        throw new RuntimeException("Method not implemented!");
    }
}
