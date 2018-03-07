package com.facebook.location.foreground;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.location.ImmutableLocation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: Unknown error occurred */
public class ForegroundLocationController$4 implements Callable<ListenableFuture<OperationResult>> {
    final /* synthetic */ ImmutableLocation f10432a;
    final /* synthetic */ ForegroundLocationController f10433b;

    public ForegroundLocationController$4(ForegroundLocationController foregroundLocationController, ImmutableLocation immutableLocation) {
        this.f10433b = foregroundLocationController;
        this.f10432a = immutableLocation;
    }

    public Object call() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("location", this.f10432a);
        return BlueServiceOperationFactoryDetour.a(this.f10433b.l, "update_foreground_location", bundle, -401694402).a();
    }
}
