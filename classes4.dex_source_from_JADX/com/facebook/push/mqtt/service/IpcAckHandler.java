package com.facebook.push.mqtt.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: graphUserTOTPKeysPost */
public class IpcAckHandler extends Handler {
    public final SettableFuture<?> f11002a;

    IpcAckHandler() {
        this(Looper.myLooper());
    }

    public IpcAckHandler(Looper looper) {
        super(looper);
        this.f11002a = SettableFuture.f();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                FutureDetour.a(this.f11002a, null, -566225587);
                return;
            default:
                throw new RuntimeException("Unrecognized ipc message: " + message);
        }
    }
}
