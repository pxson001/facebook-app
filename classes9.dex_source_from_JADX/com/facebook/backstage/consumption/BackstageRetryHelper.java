package com.facebook.backstage.consumption;

import android.content.Context;
import android.content.Intent;
import com.facebook.backstage.data.UploadShot;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;
import javax.inject.Inject;

/* compiled from: saveMmsPhotoParams */
public class BackstageRetryHelper {
    public final Context f4581a;
    public final FbNetworkManager f4582b;
    public final SecureContextHelper f4583c;
    public final NetworkActionReceiver f4584d = new NetworkActionReceiver(this);
    public final BaseFbBroadcastManager f4585e;
    public SelfRegistrableReceiverImpl f4586f;

    /* compiled from: saveMmsPhotoParams */
    public class C04471 extends TimerTask {
        final /* synthetic */ UploadShot f4576a;
        final /* synthetic */ BackstageRetryHelper f4577b;

        public C04471(BackstageRetryHelper backstageRetryHelper, UploadShot uploadShot) {
            this.f4577b = backstageRetryHelper;
            this.f4576a = uploadShot;
        }

        public void run() {
            BackstageUploadService.m4523a(this.f4577b.f4583c, this.f4577b.f4581a, this.f4576a);
        }
    }

    /* compiled from: saveMmsPhotoParams */
    public class NetworkActionReceiver implements ActionReceiver {
        final /* synthetic */ BackstageRetryHelper f4578a;
        private final Set<UploadShot> f4579b = new HashSet();
        private final Object f4580c = new Object();

        public NetworkActionReceiver(BackstageRetryHelper backstageRetryHelper) {
            this.f4578a = backstageRetryHelper;
        }

        public final void m4520a(UploadShot uploadShot) {
            synchronized (this.f4580c) {
                if (this.f4578a.f4582b.d()) {
                    m4519a(uploadShot);
                } else {
                    this.f4579b.add(uploadShot);
                }
            }
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -619128535);
            synchronized (this.f4580c) {
                try {
                    if (this.f4578a.f4582b.d()) {
                        m4519a((UploadShot[]) this.f4579b.toArray(new UploadShot[this.f4579b.size()]));
                        this.f4579b.clear();
                    }
                } finally {
                    LogUtils.e(1941201441, a);
                }
            }
        }

        private void m4519a(UploadShot... uploadShotArr) {
            BackstageUploadService.m4523a(this.f4578a.f4583c, this.f4578a.f4581a, uploadShotArr);
        }
    }

    @Inject
    public BackstageRetryHelper(Context context, FbNetworkManager fbNetworkManager, SecureContextHelper secureContextHelper, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f4581a = context;
        this.f4582b = fbNetworkManager;
        this.f4583c = secureContextHelper;
        this.f4585e = baseFbBroadcastManager;
    }
}
