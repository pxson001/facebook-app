package com.facebook.zero;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.locale.Locales;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.zero.MessageCapKeyboardGuardController.C15294;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.action.request.LOGIN_DIALOG */
public class MessageCapUpgradeOverlayBuilder {
    public final Context f20259a;
    public final Locales f20260b;
    public final FbSharedPreferences f20261c;
    public final MessageCapLogger f20262d;
    private final MessageCapAccessor f20263e;
    public final MessageCapOptinManager f20264f;
    public final FunnelLoggerImpl f20265g;

    /* compiled from: com.facebook.platform.action.request.LOGIN_DIALOG */
    public class C15351 implements OnClickListener {
        final /* synthetic */ String f20253a;
        final /* synthetic */ C15294 f20254b;
        final /* synthetic */ MessageCapUpgradeOverlayBuilder f20255c;

        /* compiled from: com.facebook.platform.action.request.LOGIN_DIALOG */
        class C15341 implements DialogInterface.OnClickListener {
            final /* synthetic */ C15351 f20252a;

            C15341(C15351 c15351) {
                this.f20252a = c15351;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f20252a.f20255c.f20262d.m28848a("message_capping_keyboard_guard_dismissal");
                this.f20252a.f20255c.f20265g.b(FunnelRegistry.H, "upgrade_accept");
                if (this.f20252a.f20254b != null) {
                    MessageCapKeyboardGuardController.m28840i(this.f20252a.f20254b.f20216a);
                }
            }
        }

        public C15351(MessageCapUpgradeOverlayBuilder messageCapUpgradeOverlayBuilder, String str, C15294 c15294) {
            this.f20255c = messageCapUpgradeOverlayBuilder;
            this.f20253a = str;
            this.f20254b = c15294;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1098985603);
            Context context = view.getContext();
            this.f20255c.f20262d.m28848a("message_capping_keyboard_guard_click");
            this.f20255c.f20265g.b(FunnelRegistry.H, "upgrade_click");
            new MessageCapReachedDialogBuilder(context, 0, this.f20253a, new C15341(this)).m28857f().b();
            Logger.a(2, EntryType.UI_INPUT_END, -956055950, a);
        }
    }

    /* compiled from: com.facebook.platform.action.request.LOGIN_DIALOG */
    public class C15372 implements OnClickListener {
        final /* synthetic */ String f20257a;
        final /* synthetic */ MessageCapUpgradeOverlayBuilder f20258b;

        /* compiled from: com.facebook.platform.action.request.LOGIN_DIALOG */
        class C15361 implements DialogInterface.OnClickListener {
            final /* synthetic */ C15372 f20256a;

            C15361(C15372 c15372) {
                this.f20256a = c15372;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f20256a.f20258b.f20262d.m28848a("message_capping_settings_optout");
                this.f20256a.f20258b.f20265g.b(FunnelRegistry.H, "opt_out");
                MessageCapOptinManager messageCapOptinManager = this.f20256a.f20258b.f20264f;
                messageCapOptinManager.f20243b.a(messageCapOptinManager.f20247f);
                messageCapOptinManager.f20243b.a("1", "dialtone", "optout");
            }
        }

        public C15372(MessageCapUpgradeOverlayBuilder messageCapUpgradeOverlayBuilder, String str) {
            this.f20258b = messageCapUpgradeOverlayBuilder;
            this.f20257a = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1347663973);
            new FbAlertDialogBuilder(view.getContext()).a(2131232891).b(view.getResources().getString(2131232892, new Object[]{this.f20257a}) + "\n\n" + view.getResources().getString(2131232893)).a(2131232886, new C15361(this)).c(2131230727, null).a(true).a().show();
            Logger.a(2, EntryType.UI_INPUT_END, -620089419, a);
        }
    }

    @Inject
    public MessageCapUpgradeOverlayBuilder(Context context, Locales locales, FbSharedPreferences fbSharedPreferences, MessageCapLogger messageCapLogger, MessageCapAccessor messageCapAccessor, MessageCapOptinManager messageCapOptinManager, FunnelLoggerImpl funnelLoggerImpl) {
        this.f20259a = context;
        this.f20260b = locales;
        this.f20261c = fbSharedPreferences;
        this.f20262d = messageCapLogger;
        this.f20263e = messageCapAccessor;
        this.f20264f = messageCapOptinManager;
        this.f20265g = funnelLoggerImpl;
    }
}
