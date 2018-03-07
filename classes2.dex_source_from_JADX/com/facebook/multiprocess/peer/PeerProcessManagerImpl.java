package com.facebook.multiprocess.peer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.auth.event.AuthEventBus;
import com.facebook.auth.event.AuthEventSubscriber;
import com.facebook.auth.event.AuthLoggedInEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multiprocess.peer.PeerProcessStatusListener.Direction;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Provider;

/* compiled from: time_last_photo_clipboard_prompt_posted */
public class PeerProcessManagerImpl implements PeerProcessManager {
    private final String f2878a;
    public final BaseFbBroadcastManager f2879b;
    private final Provider<Integer> f2880c;
    private final DefaultProcessUtil f2881d;
    public final AbstractFbErrorReporter f2882e;
    public final PeerInfo f2883f;
    private final HandlerThread f2884g;
    public Handler f2885h;
    private Messenger f2886i;
    private SelfRegistrableReceiverImpl f2887j;
    public final ConcurrentMap<Integer, PeerInfo> f2888k = Maps.m843e();
    private final ConcurrentMap<PeerProcessStatusListener, Boolean> f2889l = Maps.m843e();
    private final ConcurrentMap<Integer, PeerProcessMessageListener> f2890m = Maps.m843e();
    public final AuthEventBus f2891n;
    private final Provider<String> f2892o;
    public final boolean f2893p;
    public volatile AuthEventSubscriber<AuthLoggedInEvent> f2894q;
    public Intent f2895r;
    public final Runnable f2896s = new C01821(this);

    /* compiled from: time_last_photo_clipboard_prompt_posted */
    class C01821 implements Runnable {
        final /* synthetic */ PeerProcessManagerImpl f2897a;
        private int f2898b = 0;

        C01821(PeerProcessManagerImpl peerProcessManagerImpl) {
            this.f2897a = peerProcessManagerImpl;
        }

        public void run() {
            long j = 60000;
            Preconditions.checkNotNull(this.f2897a.f2895r);
            Preconditions.checkNotNull(this.f2897a.f2885h);
            this.f2897a.f2879b.mo406a(this.f2897a.f2895r);
            this.f2898b++;
            if (this.f2898b < 5) {
                long j2 = ((long) (1 << this.f2898b)) * 1000;
                if (j2 <= 60000) {
                    j = j2;
                }
                HandlerDetour.b(this.f2897a.f2885h, this.f2897a.f2896s, j, 712724212);
            }
        }
    }

    /* compiled from: time_last_photo_clipboard_prompt_posted */
    class MessageHandler extends Handler {
        final /* synthetic */ PeerProcessManagerImpl f2903a;

        public MessageHandler(PeerProcessManagerImpl peerProcessManagerImpl, Looper looper) {
            this.f2903a = peerProcessManagerImpl;
            super(looper);
        }

        public void handleMessage(Message message) {
            PeerInfo a;
            switch (message.what) {
                case 0:
                    a = PeerInfo.m4894a(message.getData());
                    if (!this.f2903a.f2888k.containsKey(Integer.valueOf(a.f2900b))) {
                        PeerProcessManagerImpl.m4877a(this.f2903a, a, Direction.Outgoing);
                        return;
                    }
                    return;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    a = PeerProcessManagerImpl.m4878b(this.f2903a, message);
                    if (a != null) {
                        PeerProcessManagerImpl.m4876a(this.f2903a, a);
                        return;
                    }
                    return;
                default:
                    PeerProcessManagerImpl.m4882c(this.f2903a, message);
                    return;
            }
        }
    }

    /* compiled from: time_last_photo_clipboard_prompt_posted */
    class C01832 implements ActionReceiver {
        final /* synthetic */ PeerProcessManagerImpl f2904a;

        C01832(PeerProcessManagerImpl peerProcessManagerImpl) {
            this.f2904a = peerProcessManagerImpl;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 126375856);
            this.f2904a.m4874a(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1509467816, a);
        }
    }

    /* compiled from: time_last_photo_clipboard_prompt_posted */
    class C01843 implements Runnable {
        final /* synthetic */ PeerProcessManagerImpl f2905a;

        C01843(PeerProcessManagerImpl peerProcessManagerImpl) {
            this.f2905a = peerProcessManagerImpl;
        }

        public void run() {
            if (!this.f2905a.f2893p) {
                PeerProcessManagerImpl.m4883e(this.f2905a);
            } else if (PeerProcessManagerImpl.m4881c(this.f2905a) == null) {
                PeerProcessManagerImpl peerProcessManagerImpl = this.f2905a;
                if (peerProcessManagerImpl.f2894q == null) {
                    peerProcessManagerImpl.f2894q = new 4(peerProcessManagerImpl);
                }
                peerProcessManagerImpl.f2891n.m4568a(peerProcessManagerImpl.f2894q);
                PeerProcessManagerImpl.m4881c(this.f2905a);
            }
        }
    }

    public PeerProcessManagerImpl(String str, FbBroadcastManager fbBroadcastManager, Provider<Integer> provider, ProcessUtil processUtil, FbErrorReporter fbErrorReporter, AuthEventBus authEventBus, HandlerThread handlerThread, Provider<String> provider2, boolean z) {
        this.f2878a = str;
        this.f2879b = fbBroadcastManager;
        this.f2880c = provider;
        this.f2881d = processUtil;
        this.f2882e = fbErrorReporter;
        this.f2891n = authEventBus;
        this.f2884g = handlerThread;
        this.f2892o = provider2;
        this.f2893p = z;
        this.f2883f = new PeerInfo(null, ((Integer) this.f2880c.get()).intValue(), this.f2881d.m2389a());
    }

    public void init() {
        this.f2886i = new Messenger(new MessageHandler(this, this.f2884g.getLooper()));
        this.f2885h = new Handler(this.f2884g.getLooper());
        this.f2883f.f2899a = this.f2886i;
        this.f2887j = this.f2879b.m2951a().mo506a(this.f2878a, new C01832(this)).mo505a(this.f2885h).mo503a();
        this.f2887j.m3296b();
        this.f2895r = new Intent(this.f2878a);
        this.f2895r.putExtra("peer_info", this.f2883f.m4895a());
        m4879b();
    }

    public void clearUserData() {
        if (this.f2893p) {
            mo684a(Message.obtain(null, 1));
            this.f2888k.clear();
            m4879b();
        }
    }

    private void m4879b() {
        HandlerDetour.a(this.f2885h, new C01843(this), 65254181);
    }

    public static String m4881c(PeerProcessManagerImpl peerProcessManagerImpl) {
        String str = (String) peerProcessManagerImpl.f2892o.get();
        if (str != null) {
            peerProcessManagerImpl.f2895r.putExtra("__KEY_LOGGED_USER_ID__", str);
            m4883e(peerProcessManagerImpl);
        }
        return str;
    }

    public static void m4883e(PeerProcessManagerImpl peerProcessManagerImpl) {
        peerProcessManagerImpl.f2879b.mo406a(peerProcessManagerImpl.f2895r);
        HandlerDetour.b(peerProcessManagerImpl.f2885h, peerProcessManagerImpl.f2896s, 1000, -737153025);
    }

    public final PeerInfo mo682a() {
        return this.f2883f;
    }

    public final void mo684a(final Message message) {
        if (!this.f2888k.isEmpty()) {
            message.arg1 = mo682a().f2900b;
            HandlerDetour.a(this.f2885h, new Runnable(this) {
                final /* synthetic */ PeerProcessManagerImpl f8547b;

                public void run() {
                    List<PeerInfo> a = Lists.m1296a();
                    for (PeerInfo peerInfo : this.f8547b.f2888k.values()) {
                        try {
                            peerInfo.f2899a.send(message);
                        } catch (Throwable e) {
                            if (e instanceof DeadObjectException) {
                                a.add(peerInfo);
                            } else {
                                this.f8547b.f2882e.m2343a(PeerProcessManager.class.getSimpleName(), "RemoteException occurred when sending the message to peer " + peerInfo.f2901c + "; message: " + message + "; data keys: " + Joiner.on(", ").join(message.getData().keySet()) + "; peer info: " + this.f8547b.f2883f, e);
                            }
                        }
                    }
                    for (PeerInfo peerInfo2 : a) {
                        PeerProcessManagerImpl.m4876a(this.f8547b, peerInfo2);
                    }
                }
            }, -390361240);
        }
    }

    public final void mo685a(final PeerInfo peerInfo, final Message message) {
        message.arg1 = mo682a().f2900b;
        HandlerDetour.a(this.f2885h, new Runnable(this) {
            final /* synthetic */ PeerProcessManagerImpl f3000c;

            public void run() {
                try {
                    peerInfo.f2899a.send(message);
                } catch (Throwable e) {
                    if (e instanceof DeadObjectException) {
                        PeerProcessManagerImpl.m4876a(this.f3000c, peerInfo);
                    } else {
                        this.f3000c.f2882e.m2343a(PeerProcessManager.class.getSimpleName(), "RemoteException occurred when sending the message to peer " + peerInfo.f2901c, e);
                    }
                }
            }
        }, 1670626840);
    }

    public final void mo686a(PeerProcessStatusListener peerProcessStatusListener) {
        Preconditions.checkNotNull(peerProcessStatusListener);
        this.f2889l.put(peerProcessStatusListener, Boolean.valueOf(true));
    }

    public final void mo683a(int i, PeerProcessMessageListener peerProcessMessageListener) {
        Preconditions.checkNotNull(peerProcessMessageListener);
        if (this.f2890m.containsKey(Integer.valueOf(i))) {
            throw new IllegalStateException("The listener for message type " + i + " has already registered");
        }
        this.f2890m.put(Integer.valueOf(i), peerProcessMessageListener);
    }

    private void m4874a(Intent intent) {
        if (this.f2878a.equals(intent.getAction())) {
            if (this.f2893p) {
                String str = (String) this.f2892o.get();
                if (str == null || !Objects.equal(str, intent.getStringExtra("__KEY_LOGGED_USER_ID__"))) {
                    return;
                }
            }
            Bundle bundleExtra = intent.getBundleExtra("peer_info");
            if (bundleExtra == null) {
                this.f2882e.m2340a(PeerProcessManager.class.getSimpleName(), "Peer info bundle should be in the broadcast intent with action " + this.f2878a);
                return;
            }
            try {
                PeerInfo a = PeerInfo.m4894a(bundleExtra);
                PeerInfo a2 = mo682a();
                if (a.f2900b != a2.f2900b && !this.f2888k.containsKey(Integer.valueOf(a.f2900b))) {
                    Preconditions.checkNotNull(a2.f2899a, "The mMessenger member should have been set in init()");
                    Message obtain = Message.obtain(null, 0);
                    obtain.setData(a2.m4895a());
                    try {
                        a.f2899a.send(obtain);
                        m4877a(this, a, Direction.Incoming);
                    } catch (RemoteException e) {
                    }
                }
            } catch (IllegalArgumentException e2) {
                this.f2882e.m2340a(PeerProcessManager.class.getSimpleName(), "Peer info bundle in the broadcast intent with action " + this.f2878a + " was malformed");
            }
        }
    }

    public static void m4876a(PeerProcessManagerImpl peerProcessManagerImpl, PeerInfo peerInfo) {
        if (peerProcessManagerImpl.f2888k.remove(Integer.valueOf(peerInfo.f2900b)) != null) {
            for (PeerProcessStatusListener a : peerProcessManagerImpl.f2889l.keySet()) {
                a.mo687a(peerInfo);
            }
        }
    }

    private boolean m4880b(final PeerInfo peerInfo) {
        try {
            Preconditions.checkNotNull(peerInfo);
            peerInfo.f2899a.getBinder().linkToDeath(new DeathRecipient(this) {
                final /* synthetic */ PeerProcessManagerImpl f3002b;

                public void binderDied() {
                    HandlerDetour.a(this.f3002b.f2885h, new 1(this), -2046101089);
                }
            }, 0);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public static void m4877a(PeerProcessManagerImpl peerProcessManagerImpl, PeerInfo peerInfo, Direction direction) {
        peerProcessManagerImpl.f2888k.put(Integer.valueOf(peerInfo.f2900b), peerInfo);
        for (PeerProcessStatusListener a : peerProcessManagerImpl.f2889l.keySet()) {
            a.mo689a(peerInfo, direction);
        }
        if (!peerProcessManagerImpl.m4880b(peerInfo)) {
            m4876a(peerProcessManagerImpl, peerInfo);
        }
    }

    public static PeerInfo m4878b(PeerProcessManagerImpl peerProcessManagerImpl, Message message) {
        int i = message.arg1;
        PeerInfo peerInfo = (PeerInfo) peerProcessManagerImpl.f2888k.get(Integer.valueOf(i));
        if (peerInfo == null) {
            peerProcessManagerImpl.f2882e.m2340a(PeerProcessManager.class.getSimpleName(), "Message from unknown process: " + i + ", probably the message's arg1 is not set to the pid of source process. Message details: " + message + ", peer infos: " + peerProcessManagerImpl.f2888k);
        }
        return peerInfo;
    }

    public static void m4882c(PeerProcessManagerImpl peerProcessManagerImpl, Message message) {
        synchronized (peerProcessManagerImpl.f2890m) {
            PeerProcessMessageListener peerProcessMessageListener = (PeerProcessMessageListener) peerProcessManagerImpl.f2890m.get(Integer.valueOf(message.what));
        }
        if (peerProcessMessageListener != null) {
            PeerInfo b = m4878b(peerProcessManagerImpl, message);
            if (b != null) {
                peerProcessMessageListener.mo688a(b, message);
            }
        }
    }
}
