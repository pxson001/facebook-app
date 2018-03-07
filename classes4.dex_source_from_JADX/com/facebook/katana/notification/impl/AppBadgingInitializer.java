package com.facebook.katana.notification.impl;

import android.os.Build;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.device.DeviceProperties;
import com.facebook.device.DeviceProperties.DeviceManufacturer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.launcherbadges.LauncherBadgesController;
import com.facebook.launcherbadges.LauncherBadgesManager;
import com.facebook.messaging.forcemessenger.ForceMessenger;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.notifications.notificationsfriending.abtest.ExperimentsForNotificationsFriendingAbTestModule;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.User;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: main_dex_store_regen */
public class AppBadgingInitializer implements INeedInit {
    private static volatile AppBadgingInitializer f8399p;
    private final AppBadgingListener f8400a = new AppBadgingListener(this);
    private final Provider<TriState> f8401b;
    private final Provider<TriState> f8402c;
    private final Provider<TriState> f8403d;
    private final Provider<TriState> f8404e;
    private final FbAppType f8405f;
    public final JewelCounters f8406g;
    public final LauncherBadgesManager f8407h;
    public final FbSharedPreferences f8408i;
    private final DeviceProperties f8409j;
    public final ForceMessenger f8410k;
    public final ExecutorService f8411l;
    private final Provider<User> f8412m;
    public final QeAccessor f8413n;
    public final NotificationsFriendingExperimentController f8414o;

    /* compiled from: main_dex_store_regen */
    public class AppBadgingListener extends OnJewelCountChangeListener {
        public final /* synthetic */ AppBadgingInitializer f8455a;

        /* compiled from: main_dex_store_regen */
        class C05241 implements Runnable {
            final /* synthetic */ AppBadgingListener f11061a;

            C05241(AppBadgingListener appBadgingListener) {
                this.f11061a = appBadgingListener;
            }

            public void run() {
                Editor edit = this.f11061a.f8455a.f8408i.edit();
                boolean a = this.f11061a.f8455a.f8408i.a(NotificationsPreferenceConstants.f7748y);
                if (AppBadgingInitializer.m8671a(this.f11061a.f8455a)) {
                    AppBadgingListener appBadgingListener = this.f11061a;
                    int a2 = appBadgingListener.f8455a.f8406g.a(Jewel.FRIEND_REQUESTS) + appBadgingListener.f8455a.f8406g.a(Jewel.NOTIFICATIONS);
                    if (!appBadgingListener.f8455a.f8410k.m8015a(TriState.UNSET, false)) {
                        a2 += appBadgingListener.f8455a.f8406g.a(Jewel.INBOX);
                    }
                    if (appBadgingListener.f8455a.f8413n.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
                        a2 += appBadgingListener.f8455a.f8406g.a(Jewel.VIDEO_HOME);
                    }
                    if (a2 < 0) {
                        a2 = 0;
                    }
                    int i = a2;
                    this.f11061a.f8455a.f8407h.m8678a(i);
                    edit.a(NotificationsPreferenceConstants.f7748y, i);
                    edit.commit();
                } else if (a) {
                    this.f11061a.f8455a.f8407h.m8678a(0);
                    edit.a(NotificationsPreferenceConstants.f7748y);
                    edit.commit();
                } else if (AppBadgingInitializer.m8674c(this.f11061a.f8455a)) {
                    this.f11061a.f8455a.f8407h.m8678a(0);
                }
            }
        }

        public AppBadgingListener(AppBadgingInitializer appBadgingInitializer) {
            this.f8455a = appBadgingInitializer;
        }

        public final void m8703a(Jewel jewel, int i) {
            int a = this.f8455a.f8406g.a(Jewel.NOTIFICATIONS);
            if (this.f8455a.f8414o.a.a(ExperimentsForNotificationsFriendingAbTestModule.l, true)) {
                a += this.f8455a.f8406g.a(Jewel.FRIEND_REQUESTS);
            }
            this.f8455a.f8406g.a(Jewel.NOTIFICATIONS_FRIENDING, a);
            m8702a();
        }

        public final void m8702a() {
            ExecutorDetour.a(this.f8455a.f8411l, new C05241(this), 894245254);
        }
    }

    public static com.facebook.katana.notification.impl.AppBadgingInitializer m8670a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8399p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.notification.impl.AppBadgingInitializer.class;
        monitor-enter(r1);
        r0 = f8399p;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8672b(r0);	 Catch:{ all -> 0x0035 }
        f8399p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8399p;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.notification.impl.AppBadgingInitializer.a(com.facebook.inject.InjectorLike):com.facebook.katana.notification.impl.AppBadgingInitializer");
    }

    private static AppBadgingInitializer m8672b(InjectorLike injectorLike) {
        return new AppBadgingInitializer(JewelCounters.a(injectorLike), IdBasedProvider.a(injectorLike, 698), IdBasedProvider.a(injectorLike, 699), IdBasedProvider.a(injectorLike, 701), IdBasedProvider.a(injectorLike, 700), (FbAppType) injectorLike.getInstance(FbAppType.class), LauncherBadgesManager.m8676a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DeviceProperties.m8693a(injectorLike), ForceMessenger.m8010a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), NotificationsFriendingExperimentController.a(injectorLike));
    }

    @Inject
    public AppBadgingInitializer(JewelCounters jewelCounters, Provider<TriState> provider, Provider<TriState> provider2, Provider<TriState> provider3, Provider<TriState> provider4, FbAppType fbAppType, LauncherBadgesController launcherBadgesController, FbSharedPreferences fbSharedPreferences, DeviceProperties deviceProperties, ForceMessenger forceMessenger, ExecutorService executorService, Provider<User> provider5, QeAccessor qeAccessor, NotificationsFriendingExperimentController notificationsFriendingExperimentController) {
        this.f8406g = (JewelCounters) Preconditions.checkNotNull(jewelCounters);
        this.f8401b = (Provider) Preconditions.checkNotNull(provider);
        this.f8402c = (Provider) Preconditions.checkNotNull(provider2);
        this.f8403d = (Provider) Preconditions.checkNotNull(provider3);
        this.f8404e = provider4;
        this.f8405f = fbAppType;
        this.f8407h = (LauncherBadgesManager) Preconditions.checkNotNull(launcherBadgesController);
        this.f8408i = fbSharedPreferences;
        this.f8409j = deviceProperties;
        this.f8410k = forceMessenger;
        this.f8411l = executorService;
        this.f8412m = provider5;
        this.f8413n = qeAccessor;
        this.f8414o = notificationsFriendingExperimentController;
    }

    public void init() {
        this.f8406g.a(this.f8400a);
        this.f8400a.m8702a();
    }

    public static boolean m8671a(AppBadgingInitializer appBadgingInitializer) {
        return ((TriState) appBadgingInitializer.f8401b.get()).asBoolean(false) && appBadgingInitializer.m8675d() && !appBadgingInitializer.m8673b();
    }

    private boolean m8673b() {
        return this.f8413n.a(ExperimentsForNotificationsAbtestModule.f7762a, false);
    }

    public static boolean m8674c(AppBadgingInitializer appBadgingInitializer) {
        if (!appBadgingInitializer.m8675d()) {
            return false;
        }
        if (appBadgingInitializer.m8673b()) {
            return true;
        }
        if (((TriState) appBadgingInitializer.f8401b.get()).isSet()) {
            return ((TriState) appBadgingInitializer.f8401b.get()).asBoolean(false);
        }
        return appBadgingInitializer.f8412m.get() == null;
    }

    private boolean m8675d() {
        if (this.f8405f.j != Product.FB4A) {
            return false;
        }
        DeviceManufacturer deviceManufacturer;
        String toUpperCase = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
        if (toUpperCase.contains(DeviceManufacturer.HTC.name())) {
            deviceManufacturer = DeviceManufacturer.HTC;
        } else if (toUpperCase.contains(DeviceManufacturer.SONY.name())) {
            deviceManufacturer = DeviceManufacturer.SONY;
        } else if (toUpperCase.contains(DeviceManufacturer.LG.name())) {
            deviceManufacturer = DeviceManufacturer.LG;
        } else {
            deviceManufacturer = DeviceManufacturer.UNKNOWN;
        }
        switch (deviceManufacturer) {
            case HTC:
                return ((TriState) this.f8402c.get()).asBoolean(false);
            case SONY:
                return ((TriState) this.f8403d.get()).asBoolean(false);
            case LG:
                return ((TriState) this.f8404e.get()).asBoolean(false);
            default:
                return true;
        }
    }
}
