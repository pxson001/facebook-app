package com.facebook.notifications.jewel;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner;
import com.facebook.common.init.AppInitLock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.marketplace.badge.MarketplaceUnseenCountFetcher;
import com.facebook.marketplace.tab.abtest.ExperimentsForMarketplaceTabAbtestModule;
import com.facebook.notifications.util.JewelCountHelper;
import com.facebook.notifications.util.MarketplaceBadgeCountManager;
import com.facebook.notifications.util.RedSpaceBadgeCountManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tiles_count */
public class JewelCountInitiateFetchReceiver implements ActionReceiver {
    public JewelCountHelper f934a;
    public JewelCountFetcher f935b;
    private RadioBasedBackgroundTaskRunner f936c;
    private AppInitLock f937d;
    public Provider<String> f938e;
    public RedSpaceBadgeCountManager f939f;
    public MarketplaceBadgeCountManager f940g;
    public QeAccessor f941h;

    /* compiled from: tiles_count */
    class C01281 implements Runnable {
        final /* synthetic */ JewelCountInitiateFetchReceiver f933a;

        C01281(JewelCountInitiateFetchReceiver jewelCountInitiateFetchReceiver) {
            this.f933a = jewelCountInitiateFetchReceiver;
        }

        public void run() {
            if (this.f933a.f938e.get() == null) {
                this.f933a.f935b.c();
                return;
            }
            this.f933a.f934a.a();
            this.f933a.f935b.b();
            if (this.f933a.f941h.a(ExperimentsForRedSpaceExperimentsModule.h, false)) {
                this.f933a.f939f.c();
            }
            if (this.f933a.f941h.a(ExperimentsForMarketplaceTabAbtestModule.a, false)) {
                this.f933a.f940g.a();
            }
        }
    }

    public static void m1228a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((JewelCountInitiateFetchReceiver) obj).m1227a(JewelCountHelper.a(fbInjector), JewelCountFetcher.a(fbInjector), RadioBasedBackgroundTaskRunner.a(fbInjector), AppInitLock.a(fbInjector), IdBasedProvider.a(fbInjector, 4442), (RedSpaceBadgeCountManager) RedSpaceTabUnseenCountFetcher.a(fbInjector), (MarketplaceBadgeCountManager) MarketplaceUnseenCountFetcher.m372b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    @Inject
    private void m1227a(JewelCountHelper jewelCountHelper, JewelCountFetcher jewelCountFetcher, RadioBasedBackgroundTaskRunner radioBasedBackgroundTaskRunner, AppInitLock appInitLock, Provider<String> provider, RedSpaceBadgeCountManager redSpaceBadgeCountManager, MarketplaceBadgeCountManager marketplaceBadgeCountManager, QeAccessor qeAccessor) {
        this.f934a = jewelCountHelper;
        this.f935b = jewelCountFetcher;
        this.f936c = radioBasedBackgroundTaskRunner;
        this.f937d = appInitLock;
        this.f938e = provider;
        this.f939f = redSpaceBadgeCountManager;
        this.f940g = marketplaceBadgeCountManager;
        this.f941h = qeAccessor;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1314513423);
        if (JewelCountFetcher.a.equals(intent.getAction())) {
            Class cls = JewelCountInitiateFetchReceiver.class;
            m1228a(this, context);
            if (this.f937d.c()) {
                this.f936c.a(new C01281(this), 0);
            }
            LogUtils.e(1786424555, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1388155584, a);
    }
}
