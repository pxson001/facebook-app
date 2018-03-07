package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.MessagesBroadcaster.ThreadUpdateCause;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: message requests */
public class ThreadViewFragmentActionHandler {
    private SelfRegistrableReceiverImpl f7531a;
    public ThreadKey f7532b = null;
    public boolean f7533c;
    private boolean f7534d;
    public Listener f7535e;
    private MessengerSoundUtil f7536f;
    private FbTracer f7537g;

    /* compiled from: message requests */
    public interface Listener {
        void mo317a();

        void mo318a(ThreadKey threadKey);

        void mo319a(FailedMessageWithNoRetry failedMessageWithNoRetry);

        void mo320a(String str);

        void mo321a(String str, boolean z);

        void mo322a(boolean z);

        void mo323b();
    }

    /* compiled from: message requests */
    class C11361 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7524a;

        C11361(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7524a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 457936498);
            this.f7524a.m7271e(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1053800283, a);
        }
    }

    /* compiled from: message requests */
    class C11372 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7525a;

        C11372(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7525a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1574842296);
            this.f7525a.m7275g(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 128492493, a);
        }
    }

    /* compiled from: message requests */
    class C11383 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7526a;

        C11383(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7526a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1189419378);
            this.f7526a.m7269d(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1864636212, a);
        }
    }

    /* compiled from: message requests */
    class C11394 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7527a;

        C11394(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7527a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 523152084);
            this.f7527a.m7267c(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -740337638, a);
        }
    }

    /* compiled from: message requests */
    class C11405 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7528a;

        C11405(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7528a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -777353465);
            this.f7528a.m7264b(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1455673983, a);
        }
    }

    /* compiled from: message requests */
    class C11416 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7529a;

        C11416(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7529a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1518725039);
            this.f7529a.m7273f(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 803529152, a);
        }
    }

    /* compiled from: message requests */
    class C11427 implements ActionReceiver {
        final /* synthetic */ ThreadViewFragmentActionHandler f7530a;

        C11427(ThreadViewFragmentActionHandler threadViewFragmentActionHandler) {
            this.f7530a = threadViewFragmentActionHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1813865779);
            this.f7530a.m7260a(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 597334525, a);
        }
    }

    private static ThreadViewFragmentActionHandler m7263b(InjectorLike injectorLike) {
        return new ThreadViewFragmentActionHandler(MessengerSoundUtil.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbTracer.a(injectorLike));
    }

    public static ThreadViewFragmentActionHandler m7259a(InjectorLike injectorLike) {
        return m7263b(injectorLike);
    }

    @Inject
    public ThreadViewFragmentActionHandler(MessengerSoundUtil messengerSoundUtil, BaseFbBroadcastManager baseFbBroadcastManager, FbTracer fbTracer) {
        this.f7536f = messengerSoundUtil;
        this.f7531a = baseFbBroadcastManager.a().a(MessagesBroadcastIntents.b, new C11427(this)).a(MessagesBroadcastIntents.d, new C11416(this)).a(MessagesBroadcastIntents.k, new C11405(this)).a(MessagesBroadcastIntents.l, new C11394(this)).a(MessagesBroadcastIntents.m, new C11383(this)).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C11372(this)).a(MessagesBroadcastIntents.g, new C11361(this)).a();
        this.f7537g = fbTracer;
    }

    public final void m7279a(Listener listener) {
        this.f7535e = listener;
    }

    public final void m7277a() {
        if (!this.f7534d) {
            this.f7534d = true;
            this.f7531a.b();
        }
    }

    public final void m7281b() {
        if (this.f7534d) {
            this.f7534d = false;
            this.f7531a.c();
        }
    }

    private void m7260a(Intent intent) {
        String str = null;
        if ((this.f7533c || ThreadKey.d(this.f7532b)) && m7262a(ImmutableList.copyOf(intent.getParcelableArrayListExtra("multiple_thread_keys")))) {
            ThreadUpdateCause threadUpdateCause;
            Bundle bundleExtra = intent.getBundleExtra("broadcast_extras");
            if (bundleExtra != null) {
                threadUpdateCause = (ThreadUpdateCause) bundleExtra.getSerializable("broadcast_cause");
                str = bundleExtra.getString("sound_trigger_identifier");
            } else {
                threadUpdateCause = null;
            }
            BLog.b(3);
            boolean z = threadUpdateCause == ThreadUpdateCause.READ_RECEIPT || threadUpdateCause == ThreadUpdateCause.DELIVERY_RECEIPT || threadUpdateCause == ThreadUpdateCause.MESSAGE_SENT_DELTA;
            if (this.f7535e != null) {
                Listener listener = this.f7535e;
                intent.getLongExtra("action_id", -1);
                listener.mo322a(z);
            }
            if (threadUpdateCause == ThreadUpdateCause.READ_RECEIPT && str != null) {
                if (this.f7532b.a == Type.GROUP) {
                    this.f7536f.e(str);
                } else {
                    this.f7536f.d(str);
                }
            }
            if (threadUpdateCause == ThreadUpdateCause.DELIVERY_RECEIPT) {
                FbTraceNode fbTraceNode = (FbTraceNode) bundleExtra.getParcelable("fbtrace_node");
                FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.a(fbTraceNode);
                a.put("op", "delivery_receipt_rendered");
                this.f7537g.a(fbTraceNode, FbTraceEvent.REQUEST_RECEIVE, a);
            }
        }
    }

    private void m7264b(Intent intent) {
        if (this.f7533c && m7266b((ThreadKey) intent.getParcelableExtra("thread_key")) && this.f7535e != null) {
            this.f7535e.mo320a(intent.getStringExtra("offline_threading_id"));
        }
    }

    private void m7267c(Intent intent) {
        if (this.f7533c && m7266b((ThreadKey) intent.getParcelableExtra("thread_key")) && this.f7535e != null) {
            this.f7535e.mo321a(intent.getStringExtra("offline_threading_id"), intent.getBooleanExtra("is_sent_payment_message", false));
        }
    }

    private void m7269d(Intent intent) {
        if (!this.f7533c) {
            return;
        }
        if ((this.f7532b == null || m7266b((ThreadKey) intent.getParcelableExtra("thread_key"))) && this.f7535e != null) {
            this.f7535e.mo319a(new FailedMessageWithNoRetry(intent.getStringExtra("message_id"), (ThreadKey) intent.getParcelableExtra("thread_key"), intent.getStringExtra("offline_threading_id"), intent.getStringExtra("error_message"), intent.getIntExtra("error_number", 0), intent.getBooleanExtra("is_sent_payment_message", false)));
        }
    }

    private void m7271e(Intent intent) {
        if (this.f7533c && this.f7535e != null && ((ThreadKey) intent.getParcelableExtra("outdated_thread_key")).equals(this.f7532b)) {
            this.f7535e.mo318a((ThreadKey) intent.getParcelableExtra("updated_thread_key"));
        }
    }

    private void m7273f(Intent intent) {
        if (this.f7533c && m7262a(ImmutableList.copyOf(intent.getParcelableArrayListExtra("multiple_thread_keys"))) && this.f7535e != null) {
            this.f7535e.mo323b();
        }
    }

    private void m7275g(Intent intent) {
        if (PushStateEvent.fromValue(intent.getIntExtra("event", PushStateEvent.UNKNOWN.toValue())) == PushStateEvent.CHANNEL_CONNECTED && this.f7535e != null) {
            this.f7535e.mo317a();
        }
    }

    private boolean m7266b(ThreadKey threadKey) {
        return Objects.equal(this.f7532b, threadKey);
    }

    private boolean m7262a(ImmutableList<ThreadKey> immutableList) {
        return this.f7532b != null && immutableList.contains(this.f7532b);
    }

    public final void m7278a(ThreadKey threadKey) {
        this.f7532b = threadKey;
    }

    public final void m7280a(boolean z) {
        this.f7533c = z;
    }
}
