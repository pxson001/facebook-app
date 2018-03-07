package com.facebook.zero;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.locale.Locales;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.orca.compose.ComposerKeyboardManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.MessageCapUpgradeOverlayBuilder.C15351;
import com.facebook.zero.MessageCapUpgradeOverlayBuilder.C15372;
import com.facebook.zero.capping.MessageCapOptinListener;
import com.facebook.zero.capping.MessageCapUpgradeOverlayView;
import com.facebook.zero.capping.SimpleMessageCapListener;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.extra.APPLICATION_NAME */
public class MessageCapKeyboardGuardController {
    private final Lazy<MessageCapLogger> f20222a;
    private final MessageCapAccessor f20223b;
    public final MessageCapOptinManager f20224c;
    private final SoftInputDetector f20225d;
    public final MessageCapUpgradeOverlayBuilder f20226e;
    public final DefaultAndroidThreadUtil f20227f;
    private final OnGlobalLayoutListener f20228g = new C15251(this);
    @Nullable
    public View f20229h;
    @Nullable
    public MessageCapUpgradeOverlayView f20230i;
    @Nullable
    public PopupWindow f20231j;
    @Nullable
    public SimpleMessageCapListener f20232k;
    @Nullable
    public MessageCapOptinListener f20233l;
    @Nullable
    public ComposerKeyboardManager f20234m;
    private int f20235n;
    public boolean f20236o;

    /* compiled from: com.facebook.platform.extra.APPLICATION_NAME */
    class C15251 implements OnGlobalLayoutListener {
        final /* synthetic */ MessageCapKeyboardGuardController f20212a;

        C15251(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
            this.f20212a = messageCapKeyboardGuardController;
        }

        public void onGlobalLayout() {
            MessageCapKeyboardGuardController.m28839h(this.f20212a);
        }
    }

    /* compiled from: com.facebook.platform.extra.APPLICATION_NAME */
    public class C15262 extends SimpleMessageCapListener {
        final /* synthetic */ MessageCapKeyboardGuardController f20213a;

        public C15262(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
            this.f20213a = messageCapKeyboardGuardController;
        }
    }

    /* compiled from: com.facebook.platform.extra.APPLICATION_NAME */
    public class C15283 implements MessageCapOptinListener {
        final /* synthetic */ MessageCapKeyboardGuardController f20215a;

        /* compiled from: com.facebook.platform.extra.APPLICATION_NAME */
        class C15271 implements Runnable {
            final /* synthetic */ C15283 f20214a;

            public void run() {
                if (null == null) {
                    MessageCapKeyboardGuardController.m28840i(this.f20214a.f20215a);
                }
            }

            C15271(C15283 c15283) {
                this.f20214a = c15283;
            }
        }

        public C15283(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
            this.f20215a = messageCapKeyboardGuardController;
        }

        public final void mo1525a() {
            this.f20215a.f20227f.a(new C15271(this));
        }
    }

    /* compiled from: com.facebook.platform.extra.APPLICATION_NAME */
    public class C15294 {
        public final /* synthetic */ MessageCapKeyboardGuardController f20216a;

        public C15294(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
            this.f20216a = messageCapKeyboardGuardController;
        }
    }

    public static MessageCapKeyboardGuardController m28838b(InjectorLike injectorLike) {
        return new MessageCapKeyboardGuardController(IdBasedLazy.a(injectorLike, 11791), DefaultMessageCapAccessor.m28831a(injectorLike), MessageCapOptinManager.m28853a(injectorLike), SoftInputDetector.a(injectorLike), new MessageCapUpgradeOverlayBuilder((Context) injectorLike.getInstance(Context.class), Locales.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), MessageCapLogger.m28846b(injectorLike), DefaultMessageCapAccessor.m28831a(injectorLike), MessageCapOptinManager.m28853a(injectorLike), FunnelLoggerImpl.a(injectorLike)), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public MessageCapKeyboardGuardController(Lazy<MessageCapLogger> lazy, MessageCapAccessor messageCapAccessor, MessageCapOptinManager messageCapOptinManager, SoftInputDetector softInputDetector, MessageCapUpgradeOverlayBuilder messageCapUpgradeOverlayBuilder, AndroidThreadUtil androidThreadUtil) {
        this.f20222a = lazy;
        this.f20223b = messageCapAccessor;
        this.f20224c = messageCapOptinManager;
        this.f20225d = softInputDetector;
        this.f20226e = messageCapUpgradeOverlayBuilder;
        this.f20227f = androidThreadUtil;
    }

    public final void m28844c() {
        this.f20236o = true;
        if (this.f20229h != null) {
            this.f20229h.getViewTreeObserver().addOnGlobalLayoutListener(this.f20228g);
        }
        if (this.f20231j == null || !this.f20231j.isShowing()) {
            if (this.f20230i == null) {
                MessageCapUpgradeOverlayBuilder messageCapUpgradeOverlayBuilder = this.f20226e;
                C15294 c15294 = new C15294(this);
                MessageCapUpgradeOverlayView messageCapUpgradeOverlayView = (MessageCapUpgradeOverlayView) LayoutInflater.from(messageCapUpgradeOverlayBuilder.f20259a).inflate(2130905225, null);
                String a = messageCapUpgradeOverlayBuilder.f20261c.a(ZeroPrefKeys.j, messageCapUpgradeOverlayBuilder.f20259a.getResources().getString(2131232601));
                messageCapUpgradeOverlayView.a(messageCapUpgradeOverlayBuilder.f20260b.a(), 0, a, new C15351(messageCapUpgradeOverlayBuilder, a, c15294), new C15372(messageCapUpgradeOverlayBuilder, a));
                this.f20230i = messageCapUpgradeOverlayView;
            }
            if (this.f20231j == null) {
                this.f20231j = new PopupWindow(this.f20230i);
                this.f20231j.setAnimationStyle(2131624759);
                this.f20231j.setOutsideTouchable(false);
            } else {
                this.f20231j.setAnimationStyle(0);
            }
            m28839h(this);
        }
    }

    @SuppressLint({"NewApi"})
    public final void m28845d() {
        this.f20236o = false;
        if (this.f20229h != null) {
            if (VERSION.SDK_INT >= 16) {
                this.f20229h.getViewTreeObserver().removeOnGlobalLayoutListener(this.f20228g);
            } else {
                this.f20229h.getViewTreeObserver().removeGlobalOnLayoutListener(this.f20228g);
            }
        }
        m28840i(this);
    }

    public final void m28843a() {
        if (this.f20232k == null) {
            this.f20232k = new C15262(this);
        }
        if (this.f20233l == null) {
            this.f20233l = new C15283(this);
        }
        this.f20224c.m28855a(this.f20233l);
        m28844c();
    }

    public static void m28839h(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
        int i = 0;
        if (messageCapKeyboardGuardController.f20229h != null && messageCapKeyboardGuardController.f20229h.isShown() && messageCapKeyboardGuardController.f20236o && m28841k(messageCapKeyboardGuardController)[0] == 0) {
            i = 1;
        }
        if (i == 0) {
            m28840i(messageCapKeyboardGuardController);
        } else if (null != null && messageCapKeyboardGuardController.f20231j != null && messageCapKeyboardGuardController.f20230i != null && messageCapKeyboardGuardController.f20229h != null && null <= null && null == null) {
            int i2;
            final int width = messageCapKeyboardGuardController.f20229h.getWidth();
            final boolean z = messageCapKeyboardGuardController.f20225d.f;
            int height = messageCapKeyboardGuardController.f20229h.getHeight();
            if (z) {
                i2 = messageCapKeyboardGuardController.f20225d.e;
            } else {
                i2 = 0;
            }
            final int l = messageCapKeyboardGuardController.m28842l();
            final int i3 = (i2 + height) + l;
            messageCapKeyboardGuardController.f20229h.post(new Runnable(messageCapKeyboardGuardController) {
                final /* synthetic */ MessageCapKeyboardGuardController f20221e;

                public void run() {
                    boolean z = false;
                    int[] k = MessageCapKeyboardGuardController.m28841k(this.f20221e);
                    int i = k[0];
                    int i2 = k[1];
                    this.f20221e.f20231j.showAtLocation(this.f20221e.f20229h, 51, i, i2);
                    if (l == 0 && !z) {
                        z = true;
                    }
                    this.f20221e.f20230i.a(z, true);
                    this.f20221e.f20231j.update(i, i2, width, i3);
                }
            });
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("message_capping_keyboard_guard_impression");
            String str = "user_keyboard";
            String str2 = messageCapKeyboardGuardController.f20225d.f ? "system" : messageCapKeyboardGuardController.m28842l() > 0 ? "custom" : "none";
            honeyClientEvent.b(str, str2);
            l = messageCapKeyboardGuardController.f20235n + 1;
            messageCapKeyboardGuardController.f20235n = l;
            honeyClientEvent.a("impression_count", l);
            ((MessageCapLogger) messageCapKeyboardGuardController.f20222a.get()).m28847a(honeyClientEvent);
        }
    }

    public static void m28840i(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
        if (messageCapKeyboardGuardController.f20231j != null && messageCapKeyboardGuardController.f20231j.isShowing()) {
            messageCapKeyboardGuardController.f20231j.dismiss();
        }
    }

    public static int[] m28841k(MessageCapKeyboardGuardController messageCapKeyboardGuardController) {
        if (messageCapKeyboardGuardController.f20229h == null) {
            return new int[]{0, 0};
        }
        int[] iArr = new int[2];
        messageCapKeyboardGuardController.f20229h.getLocationInWindow(iArr);
        Integer.valueOf(iArr[0]);
        Integer.valueOf(iArr[1]);
        return iArr;
    }

    private int m28842l() {
        if (this.f20234m == null) {
            return 0;
        }
        int i;
        ComposerKeyboardManager composerKeyboardManager = this.f20234m;
        if (composerKeyboardManager.v == null) {
            i = 0;
        } else {
            i = composerKeyboardManager.v.getHeight();
        }
        return i;
    }
}
