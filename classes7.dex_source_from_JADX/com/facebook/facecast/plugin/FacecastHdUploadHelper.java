package com.facebook.facecast.plugin;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.facecast.abtest.FacecastEndScreenQEHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: borderRadius */
public class FacecastHdUploadHelper {
    public FbNetworkManager f18426a;
    public FacecastEndScreenQEHelper f18427b;

    public static FacecastHdUploadHelper m22083b(InjectorLike injectorLike) {
        return new FacecastHdUploadHelper(FbNetworkManager.a(injectorLike), FacecastEndScreenQEHelper.m3061b(injectorLike));
    }

    @Inject
    public FacecastHdUploadHelper(FbNetworkManager fbNetworkManager, FacecastEndScreenQEHelper facecastEndScreenQEHelper) {
        this.f18426a = fbNetworkManager;
        this.f18427b = facecastEndScreenQEHelper;
    }
}
