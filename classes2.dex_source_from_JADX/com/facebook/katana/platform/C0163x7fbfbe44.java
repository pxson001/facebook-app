package com.facebook.katana.platform;

import android.os.Bundle;
import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.inject.Lazy;
import com.facebook.katana.platform.PlatformMediaUploadActivityReceiver.1;
import com.facebook.katana.platform.handler.GetPendingAppCallForMediaUploadOperation.Params;
import com.facebook.photos.upload.event.BaseMediaUploadEvent;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: tos_array */
abstract class C0163x7fbfbe44<T extends BaseMediaUploadEvent> extends INeedInitForEventBusSubscription<T, PlatformMediaUploadActivityReceiver> {
    private Class<T> f2393a;
    private boolean f2394b;

    public final void mo649a(FbEvent fbEvent, Object obj) {
        PlatformMediaUploadActivityReceiver platformMediaUploadActivityReceiver = (PlatformMediaUploadActivityReceiver) obj;
        String str = ((BaseMediaUploadEvent) fbEvent).f2399a.p;
        boolean z = this.f2394b;
        Params params = new Params(str, true);
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_get_app_call_for_pending_upload_params", params);
        Futures.m2458a((ListenableFuture) BlueServiceOperationFactoryDetour.a(platformMediaUploadActivityReceiver.b, "platform_get_app_call_for_pending_upload", bundle, -418179622).mo3452a(), new 1(platformMediaUploadActivityReceiver, z), platformMediaUploadActivityReceiver.f);
    }

    protected C0163x7fbfbe44(Class<T> cls, FbEventBus fbEventBus, Lazy<PlatformMediaUploadActivityReceiver> lazy, boolean z) {
        super(fbEventBus, lazy);
        this.f2393a = cls;
        this.f2394b = z;
    }

    public final Class<T> mo648a() {
        return this.f2393a;
    }
}
