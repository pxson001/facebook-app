package com.facebook.notifications.nux;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: negative_feedback_prompt */
public class NotificationsInlineFeedbackNuxInterstitialController implements InterstitialController {
    private static volatile NotificationsInlineFeedbackNuxInterstitialController f8424e;
    public InlineFeedbackLongTapNuxPopover f8425a;
    public Tooltip f8426b;
    public final Context f8427c;
    public final Lazy<NotificationsInlineActionsHelper> f8428d;

    /* compiled from: negative_feedback_prompt */
    public class C06801 implements OnDismissListener {
        final /* synthetic */ NotificationsInlineFeedbackNuxInterstitialController f8423a;

        public C06801(NotificationsInlineFeedbackNuxInterstitialController notificationsInlineFeedbackNuxInterstitialController) {
            this.f8423a = notificationsInlineFeedbackNuxInterstitialController;
        }

        public final boolean m10006a(PopoverWindow popoverWindow) {
            if (this.f8423a.f8425a != null) {
                this.f8423a.f8425a.l();
            }
            return false;
        }
    }

    public static com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController m10007a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8424e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f8424e;	 Catch:{ all -> 0x003a }
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
        r0 = m10008b(r0);	 Catch:{ all -> 0x0035 }
        f8424e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8424e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController");
    }

    private static NotificationsInlineFeedbackNuxInterstitialController m10008b(InjectorLike injectorLike) {
        return new NotificationsInlineFeedbackNuxInterstitialController((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 2832));
    }

    @Inject
    public NotificationsInlineFeedbackNuxInterstitialController(Context context, Lazy<NotificationsInlineActionsHelper> lazy) {
        this.f8427c = context;
        this.f8428d = lazy;
    }

    public final String m10012b() {
        return "3809";
    }

    public final InterstitialControllerState m10009a(InterstitialTrigger interstitialTrigger) {
        return ((NotificationsInlineActionsHelper) this.f8428d.get()).e() ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m10013c() {
        return ImmutableList.of(new InterstitialTrigger(Action.NOTIFICATIONS_TAB_FULLY_SHOWN));
    }

    public final void m10011a(Parcelable parcelable) {
    }

    public final void m10010a(long j) {
    }

    public final long hI_() {
        return 86400000;
    }
}
