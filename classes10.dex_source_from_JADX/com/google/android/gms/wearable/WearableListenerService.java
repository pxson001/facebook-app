package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.LargeAssetQueueStateChangeParcelable;
import com.google.android.gms.wearable.internal.LargeAssetSyncRequestPayload;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzay;
import com.google.android.gms.wearable.internal.zzbj;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener {
    public String f4985a;
    public Handler f4986b;
    private IBinder f4987c;
    public final Object f4988d = new Object();
    public boolean f4989e;

    final class zza extends com.google.android.gms.wearable.internal.zzba.zza {
        final /* synthetic */ WearableListenerService f13194a;
        private volatile int f13195b = -1;

        public zza(WearableListenerService wearableListenerService) {
            this.f13194a = wearableListenerService;
        }

        private void m13305a() {
            int callingUid = Binder.getCallingUid();
            if (callingUid != this.f13195b) {
                if (GooglePlayServicesUtil.a(this.f13194a, callingUid)) {
                    this.f13195b = callingUid;
                    return;
                }
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }

        private boolean m13306a(Runnable runnable, String str, Object obj) {
            return !(this.f13194a instanceof zzk) ? false : m13307b(runnable, str, obj);
        }

        private boolean m13307b(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, this.f13194a.f4985a, obj}));
            }
            m13305a();
            synchronized (this.f13194a.f4988d) {
                if (this.f13194a.f4989e) {
                    return false;
                }
                HandlerDetour.a(this.f13194a.f4986b, runnable, -977976342);
                return true;
            }
        }

        public final void mo562a(final DataHolder dataHolder) {
            try {
                if (!m13307b(new Runnable(this) {
                    final /* synthetic */ zza f13176b;

                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            this.f13176b.f13194a.mo134a(dataEventBuffer);
                        } finally {
                            dataEventBuffer.c();
                        }
                    }
                }, "onDataItemChanged", dataHolder)) {
                }
            } finally {
                dataHolder.h();
            }
        }

        public final void mo563a(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            m13306a(new Runnable(this) {
                final /* synthetic */ zza f13172b;

                public void run() {
                }
            }, "onEntityUpdate", (Object) amsEntityUpdateParcelable);
        }

        public final void mo564a(final AncsNotificationParcelable ancsNotificationParcelable) {
            m13306a(new Runnable(this) {
                final /* synthetic */ zza f13193b;

                public void run() {
                }
            }, "onNotificationReceived", (Object) ancsNotificationParcelable);
        }

        public final void mo565a(final CapabilityInfoParcelable capabilityInfoParcelable) {
            m13307b(new Runnable(this) {
                final /* synthetic */ zza f13191b;

                public void run() {
                    this.f13191b.f13194a.mo133a(capabilityInfoParcelable);
                }
            }, "onConnectedCapabilityChanged", capabilityInfoParcelable);
        }

        public final void mo566a(final ChannelEventParcelable channelEventParcelable) {
            m13307b(new Runnable(this) {
                final /* synthetic */ zza f13174b;

                public void run() {
                    channelEventParcelable.m13322a(this.f13174b.f13194a);
                }
            }, "onChannelEvent", channelEventParcelable);
        }

        public final void mo567a(final LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
            try {
                if (!m13306a(new Runnable(this) {
                    final /* synthetic */ zza f13178b;

                    public void run() {
                        largeAssetQueueStateChangeParcelable.m13330c();
                    }
                }, "onLargeAssetStateChanged", (Object) largeAssetQueueStateChangeParcelable)) {
                }
            } finally {
                largeAssetQueueStateChangeParcelable.m13330c();
            }
        }

        public final void mo568a(final LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, final zzay com_google_android_gms_wearable_internal_zzay) {
            m13306a(new Runnable(this) {
                final /* synthetic */ zza f13181c;

                public void run() {
                    Object com_google_android_gms_wearable_internal_zzbj = new zzbj(largeAssetSyncRequestPayload, com_google_android_gms_wearable_internal_zzay);
                    zzk.m13647a(com_google_android_gms_wearable_internal_zzbj);
                    try {
                        com_google_android_gms_wearable_internal_zzbj.m13563a();
                    } catch (Throwable e) {
                        Log.w("WearableLS", "Failed to respond to LargeAssetRequest", e);
                    }
                }
            }, "onLargeAssetSyncRequest", (Object) largeAssetSyncRequestPayload);
        }

        public final void mo569a(final MessageEventParcelable messageEventParcelable) {
            m13307b(new Runnable(this) {
                final /* synthetic */ zza f13183b;

                public void run() {
                    this.f13183b.f13194a.mo135a(messageEventParcelable);
                }
            }, "onMessageReceived", messageEventParcelable);
        }

        public final void mo570a(final NodeParcelable nodeParcelable) {
            m13307b(new Runnable(this) {
                final /* synthetic */ zza f13185b;

                public void run() {
                    this.f13185b.f13194a.mo136a(nodeParcelable);
                }
            }, "onPeerConnected", nodeParcelable);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo571a(com.google.android.gms.wearable.internal.zzax r7, java.lang.String r8, int r9) {
            /*
            r6 = this;
            r1 = 0;
            r0 = r6.f13194a;
            r0 = r0 instanceof com.google.android.gms.wearable.zzk;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return;
        L_0x0008:
            r0 = "WearableLS";
            r2 = 3;
            r0 = android.util.Log.isLoggable(r0, r2);
            if (r0 == 0) goto L_0x0029;
        L_0x0011:
            r0 = "WearableLS";
            r2 = "openFileDescriptor: %s (mode=%s)";
            r3 = 2;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r3[r4] = r8;
            r4 = 1;
            r5 = java.lang.Integer.valueOf(r9);
            r3[r4] = r5;
            r2 = java.lang.String.format(r2, r3);
            android.util.Log.d(r0, r2);
        L_0x0029:
            r6.m13305a();
            r0 = r6.f13194a;
            r2 = r0.f4988d;
            monitor-enter(r2);
            r0 = r6.f13194a;	 Catch:{ all -> 0x0039 }
            r0 = r0.f4989e;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0037:
            monitor-exit(r2);	 Catch:{ all -> 0x0039 }
            goto L_0x0007;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            monitor-exit(r2);	 Catch:{  }
            r0 = new java.io.File;	 Catch:{ RemoteException -> 0x00a3 }
            r0.<init>(r8);	 Catch:{ RemoteException -> 0x00a3 }
            r0 = r0.getParentFile();	 Catch:{ RemoteException -> 0x00a3 }
            r2 = r0.exists();	 Catch:{ RemoteException -> 0x00a3 }
            if (r2 != 0) goto L_0x0072;
        L_0x004c:
            r2 = r0.mkdirs();	 Catch:{ RemoteException -> 0x00a3 }
            if (r2 != 0) goto L_0x0072;
        L_0x0052:
            r2 = "WearableLS";
            r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x00a3 }
            r4 = "Unable to create directory: ";
            r3.<init>(r4);	 Catch:{ RemoteException -> 0x00a3 }
            r0 = r0.getAbsolutePath();	 Catch:{ RemoteException -> 0x00a3 }
            r0 = r3.append(r0);	 Catch:{ RemoteException -> 0x00a3 }
            r0 = r0.toString();	 Catch:{ RemoteException -> 0x00a3 }
            android.util.Log.w(r2, r0);	 Catch:{ RemoteException -> 0x00a3 }
            r0 = 0;
            r7.mo615a(r0);	 Catch:{ RemoteException -> 0x00a3 }
            com.google.android.gms.internal.zznt.a(r1);
            goto L_0x0007;
        L_0x0072:
            r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0085 }
            r2 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
            r2 = r2 | r9;
            r1 = android.os.ParcelFileDescriptor.open(r0, r2);	 Catch:{ FileNotFoundException -> 0x0085 }
            r7.mo615a(r1);	 Catch:{  }
            com.google.android.gms.internal.zznt.a(r1);
            goto L_0x0007;
        L_0x0085:
            r0 = move-exception;
            r2 = "WearableLS";
            r3 = new java.lang.StringBuilder;	 Catch:{  }
            r4 = "Failed to open file: ";
            r3.<init>(r4);	 Catch:{  }
            r3 = r3.append(r8);	 Catch:{  }
            r3 = r3.toString();	 Catch:{  }
            android.util.Log.w(r2, r3, r0);	 Catch:{  }
            r0 = 0;
            r7.mo615a(r0);	 Catch:{  }
            com.google.android.gms.internal.zznt.a(r1);
            goto L_0x0007;
        L_0x00a3:
            r0 = move-exception;
            r2 = "WearableLS";
            r3 = "Failed to set file descriptor";
            android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.zznt.a(r1);
            goto L_0x0007;
        L_0x00b0:
            r0 = move-exception;
            com.google.android.gms.internal.zznt.a(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.WearableListenerService.zza.a(com.google.android.gms.wearable.internal.zzax, java.lang.String, int):void");
        }

        public final void mo572a(final List<NodeParcelable> list) {
            m13307b(new Runnable(this) {
                final /* synthetic */ zza f13189b;

                public void run() {
                }
            }, "onConnectedNodes", list);
        }

        public final void mo573b(final NodeParcelable nodeParcelable) {
            m13307b(new Runnable(this) {
                final /* synthetic */ zza f13187b;

                public void run() {
                    this.f13187b.f13194a.mo137b(nodeParcelable);
                }
            }, "onPeerDisconnected", nodeParcelable);
        }
    }

    public void mo133a(CapabilityInfo capabilityInfo) {
    }

    public void mo134a(DataEventBuffer dataEventBuffer) {
    }

    public void mo135a(MessageEvent messageEvent) {
    }

    public void mo136a(Node node) {
    }

    public void mo137b(Node node) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.f4987c : null;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1963209525);
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.f4985a = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.f4986b = new Handler(handlerThread.getLooper());
        this.f4987c = new zza(this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1946592112, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 989356841);
        synchronized (this.f4988d) {
            try {
                this.f4989e = true;
                if (this.f4986b == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
                    Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1832989202, a);
                    throw illegalStateException;
                }
                this.f4986b.getLooper().quit();
            } finally {
                LogUtils.d(-470680739, a);
            }
        }
        super.onDestroy();
    }
}
