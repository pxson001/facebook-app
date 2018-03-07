package com.facebook.placetips.presence;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: savedThreadPhoto */
class PlaceTipsAppStateReceiver$1 implements FutureCallback<Boolean> {
    final /* synthetic */ Context f3898a;
    final /* synthetic */ Intent f3899b;
    final /* synthetic */ BroadcastReceiverLike f3900c;
    final /* synthetic */ PlaceTipsAppStateReceiver f3901d;

    PlaceTipsAppStateReceiver$1(PlaceTipsAppStateReceiver placeTipsAppStateReceiver, Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        this.f3901d = placeTipsAppStateReceiver;
        this.f3898a = context;
        this.f3899b = intent;
        this.f3900c = broadcastReceiverLike;
    }

    public void onSuccess(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            PlaceTipsAppStateReceiver.a(this.f3901d, this.f3898a, this.f3899b, this.f3900c);
        }
    }

    public void onFailure(Throwable th) {
        throw new Error(th);
    }
}
