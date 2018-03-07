package com.facebook.common.dextricksdi;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.common.dextricks.DexOptimization.Client;
import com.facebook.common.dextricks.DexOptimization.Service;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;

/* compiled from: justify */
class DexOptimizationKickoffThing$1 extends Handler {
    final /* synthetic */ DexOptimizationKickoffThing f5919a;

    DexOptimizationKickoffThing$1(DexOptimizationKickoffThing dexOptimizationKickoffThing, Looper looper) {
        this.f5919a = dexOptimizationKickoffThing;
        super(looper);
    }

    public void handleMessage(Message message) {
        Context context = this.f5919a.b;
        ServiceConnectionDetour.a(context, new Intent(context, Service.class), new Client(context, DexLibLoader.getMainDexStore().root.getAbsolutePath()), 73, -1074203087);
    }
}
