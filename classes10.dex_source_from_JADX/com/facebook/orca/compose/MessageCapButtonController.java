package com.facebook.orca.compose;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Lazy;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainerLogic;
import com.facebook.orca.compose.abtest.ExperimentsForComposerExperimentsModule;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.text.BetterTextView;
import com.facebook.zero.MessageCapAccessor;
import com.facebook.zero.MessageCapLogger;
import com.facebook.zero.MessageCapOptinManager;
import com.facebook.zero.capping.CappingPrefKeys;
import com.facebook.zero.capping.MessageCapOptinListener;
import com.facebook.zero.capping.SimpleMessageCapListener;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: open_shortcut */
public class MessageCapButtonController {
    private final MessageCapAccessor f5525a;
    public final MessageCapOptinManager f5526b;
    private final TipSeenTracker f5527c;
    private final FbSharedPreferences f5528d;
    public final Lazy<MessageCapLogger> f5529e;
    public final DefaultAndroidThreadUtil f5530f;
    private final QeAccessor f5531g;
    public final SpringSystem f5532h;
    private final SimpleMessageCapListener f5533i;
    public final MessageCapOptinListener f5534j;
    @Nullable
    private BetterTextView f5535k;
    @Nullable
    private TextLineComposer f5536l;
    @Nullable
    private ComposerShortcutsContainerLogic f5537m;
    @Nullable
    private MessageCapTooltip f5538n;
    public boolean f5539o;
    private boolean f5540p;

    /* compiled from: open_shortcut */
    class C07791 extends SimpleMessageCapListener {
        final /* synthetic */ MessageCapButtonController f5513a;

        C07791(MessageCapButtonController messageCapButtonController) {
            this.f5513a = messageCapButtonController;
        }
    }

    /* compiled from: open_shortcut */
    class C07812 implements MessageCapOptinListener {
        final /* synthetic */ MessageCapButtonController f5515a;

        /* compiled from: open_shortcut */
        class C07801 implements Runnable {
            final /* synthetic */ C07812 f5514a;

            C07801(C07812 c07812) {
                this.f5514a = c07812;
            }

            public void run() {
                MessageCapButtonController.m5121g(this.f5514a.f5515a);
            }
        }

        C07812(MessageCapButtonController messageCapButtonController) {
            this.f5515a = messageCapButtonController;
        }

        public final void m5118a() {
            this.f5515a.f5530f.a(new C07801(this));
        }
    }

    /* compiled from: open_shortcut */
    class C07823 implements OnDismissListener {
        final /* synthetic */ MessageCapButtonController f5516a;

        C07823(MessageCapButtonController messageCapButtonController) {
            this.f5516a = messageCapButtonController;
        }

        public final boolean m5119a(PopoverWindow popoverWindow) {
            MessageCapButtonController.m5123i(this.f5516a);
            return false;
        }
    }

    /* compiled from: open_shortcut */
    class C07834 implements OnClickListener {
        final /* synthetic */ MessageCapButtonController f5517a;

        C07834(MessageCapButtonController messageCapButtonController) {
            this.f5517a = messageCapButtonController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("message_capping_composer_button_exit_saved_mode");
            honeyClientEvent.a("client_cap_value", 0);
            ((MessageCapLogger) this.f5517a.f5529e.get()).a(honeyClientEvent);
        }
    }

    /* compiled from: open_shortcut */
    class C07845 implements OnClickListener {
        final /* synthetic */ MessageCapButtonController f5518a;

        C07845(MessageCapButtonController messageCapButtonController) {
            this.f5518a = messageCapButtonController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("message_capping_composer_button_enter_saved_mode");
            honeyClientEvent.a("client_cap_value", 0);
            ((MessageCapLogger) this.f5518a.f5529e.get()).a(honeyClientEvent);
        }
    }

    /* compiled from: open_shortcut */
    class MessageCapTooltip extends Tooltip {
        final /* synthetic */ MessageCapButtonController f5521a;
        private final SpringConfig f5522l;
        private final float f5523m;
        private final float f5524n;

        public MessageCapTooltip(MessageCapButtonController messageCapButtonController, Context context) {
            this.f5521a = messageCapButtonController;
            super(context, 0, 2130905223);
            this.f5522l = SpringConfig.a(40.0d, 7.0d);
            this.f5523m = 0.001f;
            this.f5524n = 0.001f;
            this.t = -1;
            a(Position.ABOVE);
            b(context.getResources().getQuantityString(2131689517, 0, new Object[]{Integer.valueOf(0)}));
            Spring a = messageCapButtonController.f5532h.a().a(this.f5522l);
            a.l = 0.0010000000474974513d;
            a = a;
            a.k = 0.0010000000474974513d;
            a(a);
        }

        protected final void m5120a(View view, boolean z, LayoutParams layoutParams) {
            super.a(view, z, layoutParams);
            layoutParams.windowAnimations = 2131624762;
        }
    }

    @Inject
    public MessageCapButtonController(MessageCapAccessor messageCapAccessor, MessageCapOptinManager messageCapOptinManager, TipSeenTracker tipSeenTracker, FbSharedPreferences fbSharedPreferences, Lazy<MessageCapLogger> lazy, AndroidThreadUtil androidThreadUtil, QeAccessor qeAccessor, SpringSystem springSystem) {
        this.f5525a = messageCapAccessor;
        this.f5526b = messageCapOptinManager;
        this.f5527c = tipSeenTracker;
        this.f5528d = fbSharedPreferences;
        this.f5529e = lazy;
        this.f5530f = androidThreadUtil;
        this.f5531g = qeAccessor;
        this.f5532h = springSystem;
        this.f5527c.a(CappingPrefKeys.m);
        this.f5527c.b = 1;
        this.f5533i = new C07791(this);
        this.f5534j = new C07812(this);
        this.f5539o = false;
        this.f5540p = false;
    }

    public final void m5124a(View view, TextLineComposer textLineComposer, ComposerShortcutsContainerLogic composerShortcutsContainerLogic) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(textLineComposer);
        Preconditions.checkNotNull(composerShortcutsContainerLogic);
        this.f5535k = (BetterTextView) view;
        this.f5536l = textLineComposer;
        this.f5537m = composerShortcutsContainerLogic;
        m5121g(this);
    }

    public final void m5125c() {
        this.f5539o = true;
        m5122h();
    }

    public static void m5121g(MessageCapButtonController messageCapButtonController) {
        if (messageCapButtonController.f5535k != null && messageCapButtonController.f5537m != null && messageCapButtonController.f5536l != null) {
            boolean z = false;
            if (null != null && (null == null || null != null)) {
                z = true;
            }
            boolean z2 = z;
            if (z2) {
                boolean z3;
                BetterTextView betterTextView = messageCapButtonController.f5535k;
                if (null == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                betterTextView.setActivated(z3);
                messageCapButtonController.f5535k.setText(Integer.toString(0));
            }
            messageCapButtonController.f5537m.b("message_cap", z2);
            messageCapButtonController.f5537m.c("message_cap", z2);
            messageCapButtonController.f5536l.m5181a("message_cap", z2);
            messageCapButtonController.f5536l.m5186b("message_cap", z2);
            messageCapButtonController.f5540p = z2;
            if (z2) {
                messageCapButtonController.m5122h();
            }
        }
    }

    private void m5122h() {
        if (this.f5539o && this.f5540p && this.f5527c.c() && this.f5538n == null) {
            this.f5538n = new MessageCapTooltip(this, this.f5535k.getContext());
            this.f5538n.H = new C07823(this);
            this.f5538n.a(this.f5535k);
            this.f5527c.a();
        }
    }

    public static void m5123i(MessageCapButtonController messageCapButtonController) {
        if (messageCapButtonController.f5538n != null) {
            messageCapButtonController.f5538n.l();
            messageCapButtonController.f5538n = null;
        }
    }

    public final void m5126e() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("message_capping_composer_button_click");
        honeyClientEvent.a("client_cap_value", 0);
        ((MessageCapLogger) this.f5529e.get()).a(honeyClientEvent);
        Context context = this.f5535k.getContext();
        Resources resources = context.getResources();
        String quantityString;
        if (!this.f5531g.a(ExperimentsForComposerExperimentsModule.a, false)) {
            quantityString = resources.getQuantityString(2131689516, 0, new Object[]{Integer.valueOf(0)});
            quantityString = resources.getString(2131232887, new Object[]{quantityString});
            new FbAlertDialogBuilder(context).b(quantityString + "\n\n" + resources.getString(2131232888)).a(2131232890, null).a(true).b();
        } else if (null != null) {
            String quantityString2 = resources.getQuantityString(2131689516, 0, new Object[]{Integer.valueOf(0)});
            quantityString2 = resources.getString(2131232905, new Object[]{quantityString2});
            new FbAlertDialogBuilder(this.f5535k.getContext()).a(2131232904).b(quantityString2 + "\n\n" + resources.getString(2131232906)).a(2131232907, new C07834(this)).c(2131230727, null).a(true).b();
        } else {
            quantityString = this.f5528d.a(ZeroPrefKeys.j, resources.getString(2131232601));
            String string = resources.getString(2131232901, new Object[]{quantityString});
            final AlertDialog a = new FbAlertDialogBuilder(context).a(2131232900).b(string + "\n\n" + resources.getString(2131232902)).a(2131232903, new C07845(this)).c(2131230727, null).a(true).a();
            string = resources.getQuantityString(2131689516, 0, new Object[]{Integer.valueOf(0)});
            quantityString = resources.getString(2131232897, new Object[]{string, quantityString});
            new FbAlertDialogBuilder(this.f5535k.getContext()).a(2131232896).b(quantityString + "\n\n" + resources.getString(2131232898)).a(2131232899, new OnClickListener(this) {
                final /* synthetic */ MessageCapButtonController f5520b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    a.show();
                }
            }).c(2131230727, null).a(true).b();
        }
    }
}
