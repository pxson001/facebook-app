package com.facebook.backstage.entry;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.consumption.BackstageFragment;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.common.activitylistener.BaseActivityListener;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.divebar.DivebarFragmentInitializer;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.util.DefaultNotificationStoryLauncher;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.ui.drawers.DrawerContentFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: resized_quality */
public class BackstageFragmentInitializer implements DivebarFragmentInitializer {
    private static final String f5165a = BackstageFragmentInitializer.class.getSimpleName();
    private static volatile BackstageFragmentInitializer f5166g;
    public final Lazy<DefaultNotificationStoryLauncher> f5167b;
    public final NotificationStoryHelper f5168c;
    private final BackstageGatekeepers f5169d;
    private OnClickListener f5170e;
    private BackstageFragment f5171f;

    public static com.facebook.backstage.entry.BackstageFragmentInitializer m4938a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5166g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.entry.BackstageFragmentInitializer.class;
        monitor-enter(r1);
        r0 = f5166g;	 Catch:{ all -> 0x003a }
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
        r0 = m4941b(r0);	 Catch:{ all -> 0x0035 }
        f5166g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5166g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.entry.BackstageFragmentInitializer.a(com.facebook.inject.InjectorLike):com.facebook.backstage.entry.BackstageFragmentInitializer");
    }

    private static BackstageFragmentInitializer m4941b(InjectorLike injectorLike) {
        return new BackstageFragmentInitializer(IdBasedSingletonScopeProvider.b(injectorLike, 2823), NotificationStoryHelper.a(injectorLike), BackstageGatekeepers.m4256b(injectorLike));
    }

    @Inject
    public BackstageFragmentInitializer(Lazy<DefaultNotificationStoryLauncher> lazy, NotificationStoryHelper notificationStoryHelper, BackstageGatekeepers backstageGatekeepers) {
        this.f5168c = notificationStoryHelper;
        this.f5167b = lazy;
        this.f5169d = backstageGatekeepers;
    }

    public final DrawerContentFragment mo189a() {
        BackstageFragment backstageFragment = new BackstageFragment();
        if (m4940a(backstageFragment, this.f5170e)) {
            this.f5170e = null;
        } else {
            this.f5171f = backstageFragment;
        }
        return backstageFragment;
    }

    public final boolean mo192b() {
        return this.f5169d.m4258b();
    }

    public final void mo190a(ListenableActivity listenableActivity, final DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
        this.f5170e = new OnClickListener(this) {
            final /* synthetic */ BackstageFragmentInitializer f5160b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 623601858);
                drawerBasedDivebarControllerImpl.g();
                Logger.a(2, EntryType.UI_INPUT_END, 546715383, a);
            }
        };
        if (m4940a(this.f5171f, this.f5170e)) {
            this.f5171f = null;
            this.f5170e = null;
        }
        m4939a(drawerBasedDivebarControllerImpl.n);
        final C05492 c05492 = new Object(this) {
            public final /* synthetic */ BackstageFragmentInitializer f5162b;
        };
        listenableActivity.a(new BaseActivityListener(this) {
            final /* synthetic */ BackstageFragmentInitializer f5164b;

            public final void m4931e(Activity activity) {
                super.e(activity);
                ((DefaultNotificationStoryLauncher) this.f5164b.f5167b.get()).b(c05492);
            }

            public final void m4930b(Activity activity) {
                super.b(activity);
                ((DefaultNotificationStoryLauncher) this.f5164b.f5167b.get()).a(c05492);
            }
        });
        ((DefaultNotificationStoryLauncher) this.f5167b.get()).a(c05492);
    }

    private static boolean m4940a(BackstageFragment backstageFragment, OnClickListener onClickListener) {
        if (backstageFragment == null || onClickListener == null) {
            return false;
        }
        backstageFragment.aH = onClickListener;
        return true;
    }

    public final void mo191a(boolean z) {
    }

    public final boolean mo193c() {
        return false;
    }

    public final boolean mo194d() {
        return false;
    }

    public static void m4939a(@Nullable Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            new StringBuilder("Updating fragment : ").append(intent.getStringExtra("NAVIGATION_RECORDING_KEY"));
            BackstageNavigatorApi.m4489a().m4492a(NavigationState.COLD_START, BackstageNavigatorApi.m4490b(intent.getExtras()));
        }
    }
}
