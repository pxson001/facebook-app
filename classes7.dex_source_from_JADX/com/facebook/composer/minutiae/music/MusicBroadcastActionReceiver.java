package com.facebook.composer.minutiae.music;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: to reserved bits must be zero after mapping coupling steps */
public class MusicBroadcastActionReceiver implements ActionReceiver {
    private static String[] f1584f = new String[]{"playbackcomplete", "endofplayback", "ACTION_PAUSED"};
    public MusicMetadataHelper f1585a;
    public AudioManager f1586b;
    public MusicBroadcastHolder f1587c;
    private Provider<TriState> f1588d;
    private RidgeOptInController f1589e;

    /* compiled from: to reserved bits must be zero after mapping coupling steps */
    class C01531 implements Runnable {
        final /* synthetic */ MusicBroadcastActionReceiver f1580a;

        C01531(MusicBroadcastActionReceiver musicBroadcastActionReceiver) {
            this.f1580a = musicBroadcastActionReceiver;
        }

        public void run() {
            if (!this.f1580a.f1586b.isMusicActive()) {
                this.f1580a.f1585a.m1648a();
            }
        }
    }

    public static void m1641a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MusicBroadcastActionReceiver) obj).m1640a(MusicMetadataHelper.m1645b(injectorLike), AudioManagerMethodAutoProvider.b(injectorLike), MusicBroadcastHolder.m1642a(injectorLike), IdBasedProvider.a(injectorLike, 652), RidgeOptInController.m1822b(injectorLike));
    }

    @Inject
    private void m1640a(MusicMetadataHelper musicMetadataHelper, AudioManager audioManager, MusicBroadcastHolder musicBroadcastHolder, Provider<TriState> provider, RidgeOptInController ridgeOptInController) {
        this.f1585a = musicMetadataHelper;
        this.f1586b = audioManager;
        this.f1587c = musicBroadcastHolder;
        this.f1588d = provider;
        this.f1589e = ridgeOptInController;
    }

    public void onReceive(Context context, final Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1901834072);
        if (intent.getExtras() == null) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1803595675, a);
            return;
        }
        Class cls = MusicBroadcastActionReceiver.class;
        m1641a(this, context);
        Handler handler = new Handler();
        if (!(((TriState) this.f1588d.get()).asBoolean(false) && this.f1589e.m1827c())) {
            this.f1589e.m1826a(false);
        }
        String action = intent.getAction();
        String[] strArr = f1584f;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (action == null || !action.endsWith(str)) {
                i++;
            } else {
                this.f1585a.m1648a();
                LogUtils.e(727571878, a);
                return;
            }
        }
        if (this.f1585a.m1650a(intent)) {
            final long j = this.f1587c.f1591a + 1;
            this.f1587c.m1644a(j);
            this.f1587c.f1592b = intent.getExtras();
            HandlerDetour.b(handler, new Runnable(this) {
                final /* synthetic */ MusicBroadcastActionReceiver f1583c;

                public void run() {
                    if (this.f1583c.f1587c.f1591a == j) {
                        if (this.f1583c.f1586b.isMusicActive()) {
                            this.f1583c.f1585a.m1649a(intent.getExtras());
                        } else {
                            this.f1583c.f1585a.m1648a();
                        }
                    }
                }
            }, 1000, -1458240396);
            LogUtils.e(1991561280, a);
            return;
        }
        HandlerDetour.b(handler, new C01531(this), 1000, 1895708589);
        LogUtils.e(552926393, a);
    }
}
