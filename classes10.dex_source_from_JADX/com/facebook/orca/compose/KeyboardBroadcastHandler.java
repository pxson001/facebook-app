package com.facebook.orca.compose;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.orca.compose.ComposeFragment.C07542;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: operation_type_to_restart */
public class KeyboardBroadcastHandler {
    private static final IntentFilter f5508a = new IntentFilter(MessagesBroadcastIntents.x);
    private final BroadcastReceiver f5509b = new KeyboardBroadcastReceiver(this);
    private final FbLocalBroadcastManager f5510c;
    private boolean f5511d;
    @Nullable
    public C07542 f5512e;

    /* compiled from: operation_type_to_restart */
    class KeyboardBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ KeyboardBroadcastHandler f5507a;

        public KeyboardBroadcastReceiver(KeyboardBroadcastHandler keyboardBroadcastHandler) {
            this.f5507a = keyboardBroadcastHandler;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1873095561);
            if (this.f5507a.f5512e != null) {
                Mode mode = null;
                String stringExtra = intent.getStringExtra("keyboard_mode");
                if ("g".equals(stringExtra)) {
                    mode = Mode.GIF;
                } else if ("s".equals(stringExtra)) {
                    mode = Mode.STICKER;
                }
                if (mode != null) {
                    this.f5507a.f5512e.m4755a(mode);
                }
            }
            LogUtils.a(intent, -1869919697, a);
        }
    }

    /* compiled from: operation_type_to_restart */
    public enum Mode {
        GIF,
        STICKER
    }

    public static KeyboardBroadcastHandler m5115a(InjectorLike injectorLike) {
        return new KeyboardBroadcastHandler(FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public KeyboardBroadcastHandler(FbLocalBroadcastManager fbLocalBroadcastManager) {
        this.f5510c = fbLocalBroadcastManager;
    }

    public final void m5116a() {
        if (!this.f5511d) {
            this.f5511d = true;
            this.f5510c.a(this.f5509b, f5508a);
        }
    }

    public final void m5117b() {
        if (this.f5511d) {
            this.f5511d = false;
            this.f5510c.a(this.f5509b);
        }
    }
}
