package com.facebook.reaction.externalshare;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.service.FbService;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: billing_address */
public class ReactionExternalShareService extends FbService {
    public SecureContextHelper f18939a;
    public SelfRegistrableReceiverImpl f18940b;

    /* compiled from: billing_address */
    public class ReactionCloseServiceActionReceiver implements ActionReceiver {
        final /* synthetic */ ReactionExternalShareService f18937a;

        public ReactionCloseServiceActionReceiver(ReactionExternalShareService reactionExternalShareService) {
            this.f18937a = reactionExternalShareService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -26842161);
            this.f18937a.stopSelf();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1635548082, a);
        }
    }

    /* compiled from: billing_address */
    public class ReactionShowOverlayAfterDelayActionReceiver implements ActionReceiver {
        final /* synthetic */ ReactionExternalShareService f18938a;

        public ReactionShowOverlayAfterDelayActionReceiver(ReactionExternalShareService reactionExternalShareService) {
            this.f18938a = reactionExternalShareService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1027502774);
            this.f18938a.m22958a(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1447084184, a);
        }
    }

    private static <T extends Context> void m22956a(Class<T> cls, T t) {
        m22957a((Object) t, (Context) t);
    }

    public static void m22957a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactionExternalShareService reactionExternalShareService = (ReactionExternalShareService) obj;
        BaseFbBroadcastManager baseFbBroadcastManager = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector);
        reactionExternalShareService.f18939a = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        reactionExternalShareService.f18940b = baseFbBroadcastManager.a().a("com.facebook.intent.action.REACTION_CLOSE_EXTERNAL_SHARE_SERVICE", new ReactionCloseServiceActionReceiver(reactionExternalShareService)).a("com.facebook.intent.action.REACTION_SHOW_DIALOG", new ReactionShowOverlayAfterDelayActionReceiver(reactionExternalShareService)).a();
        reactionExternalShareService.f18940b.b();
    }

    public static Intent m22955a(Context context, Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setClass(context, ReactionExternalShareService.class);
        return intent2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void m22961a() {
        super.a();
        Class cls = ReactionExternalShareService.class;
        m22957a((Object) this, (Context) this);
    }

    public final void m22962k() {
        super.k();
        if (this.f18940b != null) {
            this.f18940b.c();
            this.f18940b = null;
        }
    }

    public final int m22960a(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        if (intent.getBooleanExtra("response_pending", false)) {
            return 1;
        }
        if (m22958a(intent)) {
            return 1;
        }
        return 2;
    }

    private boolean m22958a(Intent intent) {
        Intent a = ReactionExternalShareActivity.m22951a((Context) this, intent);
        if (a == null) {
            stopSelf();
            return false;
        }
        this.f18939a.a(a, this);
        return true;
    }
}
