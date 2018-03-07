package com.facebook.platform.common.server;

import android.os.Bundle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: stream_audio_channels */
public class PlatformCommonClient {
    public final DefaultBlueServiceOperationFactory f4076a;

    public static PlatformCommonClient m5971b(InjectorLike injectorLike) {
        return new PlatformCommonClient(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public PlatformCommonClient(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f4076a = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<OperationResult> m5972a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform_delete_temp_files_params", str);
        return BlueServiceOperationFactoryDetour.a(this.f4076a, "platform_delete_temp_files", bundle, -1039831903).a();
    }

    public static PlatformCommonClient m5970a(InjectorLike injectorLike) {
        return m5971b(injectorLike);
    }
}
