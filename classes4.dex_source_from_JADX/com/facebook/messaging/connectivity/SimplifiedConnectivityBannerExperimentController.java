package com.facebook.messaging.connectivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.banner.BasicBannerNotificationView$Params$Builder;
import com.facebook.common.banner.BasicBannerNotificationView$Params$DisplayMode;
import com.facebook.common.banner.BasicBannerNotificationView.Params;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mTimedOutUploadSampleRate */
public class SimplifiedConnectivityBannerExperimentController {
    private static volatile SimplifiedConnectivityBannerExperimentController f8487f;
    public final QeAccessor f8488a;
    public final Context f8489b;
    public final Resources f8490c;
    public final BasicBannerNotificationView$Params$Builder f8491d = new BasicBannerNotificationView$Params$Builder();
    public final ConnectionStatusMonitor f8492e;

    public static com.facebook.messaging.connectivity.SimplifiedConnectivityBannerExperimentController m8747a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8487f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.connectivity.SimplifiedConnectivityBannerExperimentController.class;
        monitor-enter(r1);
        r0 = f8487f;	 Catch:{ all -> 0x003a }
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
        r0 = m8748b(r0);	 Catch:{ all -> 0x0035 }
        f8487f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8487f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.connectivity.SimplifiedConnectivityBannerExperimentController.a(com.facebook.inject.InjectorLike):com.facebook.messaging.connectivity.SimplifiedConnectivityBannerExperimentController");
    }

    private static SimplifiedConnectivityBannerExperimentController m8748b(InjectorLike injectorLike) {
        return new SimplifiedConnectivityBannerExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.a(injectorLike, 7747), IdBasedSingletonScopeProvider.a(injectorLike, 2587));
    }

    @Inject
    public SimplifiedConnectivityBannerExperimentController(QeAccessor qeAccessor, Resources resources, Context context, Provider<SimpleConnectionStatusMonitor> provider, Provider<MqttBackedConnectionStatusMonitor> provider2) {
        this.f8488a = qeAccessor;
        this.f8490c = resources;
        this.f8489b = context;
        if (qeAccessor.a(ExperimentsForMessagesConnectivityModule.f8510i, false)) {
            this.f8492e = (ConnectionStatusMonitor) provider.get();
        } else {
            this.f8492e = (ConnectionStatusMonitor) provider2.get();
        }
    }

    public final Params m8749a() {
        CharSequence a = this.f8488a.a(ExperimentsForMessagesConnectivityModule.f8509h, this.f8490c.getString(2131230763));
        Drawable a2 = m8746a(ExperimentsForMessagesConnectivityModule.f8505d, 2131362429);
        BasicBannerNotificationView$Params$Builder basicBannerNotificationView$Params$Builder = this.f8491d;
        basicBannerNotificationView$Params$Builder.f8493a = a;
        BasicBannerNotificationView$Params$Builder basicBannerNotificationView$Params$Builder2 = basicBannerNotificationView$Params$Builder;
        basicBannerNotificationView$Params$Builder2.f8495c = a2;
        basicBannerNotificationView$Params$Builder2 = basicBannerNotificationView$Params$Builder2;
        basicBannerNotificationView$Params$Builder2.f8500h = BasicBannerNotificationView$Params$DisplayMode.ALWAYS;
        basicBannerNotificationView$Params$Builder2 = basicBannerNotificationView$Params$Builder2;
        if (this.f8488a.a(ExperimentsForMessagesConnectivityModule.f8508g, false)) {
            basicBannerNotificationView$Params$Builder2.f8496d = true;
            basicBannerNotificationView$Params$Builder2.f8497e = this.f8490c.getString(2131231848);
        } else {
            basicBannerNotificationView$Params$Builder2.f8496d = false;
        }
        return basicBannerNotificationView$Params$Builder2.m8757a();
    }

    public final Params m8750b() {
        CharSequence a = this.f8488a.a(ExperimentsForMessagesConnectivityModule.f8502a, this.f8490c.getString(2131231843));
        Drawable a2 = m8746a(ExperimentsForMessagesConnectivityModule.f8504c, 2131362429);
        BasicBannerNotificationView$Params$Builder basicBannerNotificationView$Params$Builder = this.f8491d;
        basicBannerNotificationView$Params$Builder.f8493a = a;
        BasicBannerNotificationView$Params$Builder basicBannerNotificationView$Params$Builder2 = basicBannerNotificationView$Params$Builder;
        basicBannerNotificationView$Params$Builder2.f8495c = a2;
        basicBannerNotificationView$Params$Builder2 = basicBannerNotificationView$Params$Builder2;
        basicBannerNotificationView$Params$Builder2.f8500h = BasicBannerNotificationView$Params$DisplayMode.ALWAYS;
        basicBannerNotificationView$Params$Builder2 = basicBannerNotificationView$Params$Builder2;
        basicBannerNotificationView$Params$Builder2.f8496d = false;
        return basicBannerNotificationView$Params$Builder2.m8757a();
    }

    private Drawable m8746a(char c, int i) {
        String a = this.f8488a.a(c, "error");
        if ("error".equals(a)) {
            return new ColorDrawable(this.f8490c.getColor(2131362435));
        }
        if ("warning".equals(a)) {
            return new ColorDrawable(this.f8490c.getColor(2131362434));
        }
        return new ColorDrawable(this.f8490c.getColor(i));
    }
}
