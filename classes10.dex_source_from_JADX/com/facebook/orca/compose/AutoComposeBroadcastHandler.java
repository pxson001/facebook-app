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
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.compose.ComposeFragment.C07521;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: outgoingPings */
public class AutoComposeBroadcastHandler {
    private static final IntentFilter f5334a = new IntentFilter(MessagesBroadcastIntents.v);
    private final BroadcastReceiver f5335b = new AutoComposeBroadcastReceiver(this);
    private final BroadcastReceiver f5336c = new AutoComposeBroadcastReceiver(this);
    private final FbLocalBroadcastManager f5337d;
    private boolean f5338e;
    public C07521 f5339f;
    private ThreadKey f5340g;

    /* compiled from: outgoingPings */
    class AutoComposeBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ AutoComposeBroadcastHandler f5333a;

        public AutoComposeBroadcastReceiver(AutoComposeBroadcastHandler autoComposeBroadcastHandler) {
            this.f5333a = autoComposeBroadcastHandler;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1696143681);
            if (this.f5333a.f5339f != null) {
                this.f5333a.f5339f.m4752a(intent.getBooleanExtra("send", false), intent.getStringExtra("text"));
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -252849318, a);
        }
    }

    public static AutoComposeBroadcastHandler m4740a(InjectorLike injectorLike) {
        return new AutoComposeBroadcastHandler(FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AutoComposeBroadcastHandler(FbLocalBroadcastManager fbLocalBroadcastManager) {
        this.f5337d = fbLocalBroadcastManager;
    }

    public final void m4742a() {
        if (!this.f5338e) {
            this.f5338e = true;
            this.f5337d.a(this.f5335b, f5334a);
            m4741c();
        }
    }

    public final void m4744b() {
        if (this.f5338e) {
            this.f5338e = false;
            this.f5340g = null;
            this.f5337d.a(this.f5335b);
            this.f5337d.a(this.f5336c);
        }
    }

    public final void m4743a(@Nullable ThreadKey threadKey) {
        this.f5340g = threadKey;
        this.f5337d.a(this.f5336c);
        m4741c();
    }

    private void m4741c() {
        if (this.f5338e && this.f5340g != null) {
            FbLocalBroadcastManager fbLocalBroadcastManager = this.f5337d;
            BroadcastReceiver broadcastReceiver = this.f5336c;
            ThreadKey threadKey = this.f5340g;
            fbLocalBroadcastManager.a(broadcastReceiver, new IntentFilter(String.format(MessagesBroadcastIntents.w, new Object[]{threadKey})));
        }
    }
}
