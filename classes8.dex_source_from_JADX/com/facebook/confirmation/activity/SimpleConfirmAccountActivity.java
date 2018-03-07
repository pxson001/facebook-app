package com.facebook.confirmation.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.confirmation.controller.ConfirmationFragmentController;
import com.facebook.confirmation.logging.ConfirmationAnalyticsLogger;
import com.facebook.confirmation.logging.ConfirmationLoggingEventType;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: invalidated_story_reasons */
public class SimpleConfirmAccountActivity extends FbFragmentActivity implements HasTitleBar {
    private boolean f10702A = false;
    public boolean f10703B = false;
    private String f10704C = "";
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager f10705p;
    @Inject
    public ConfirmationAnalyticsLogger f10706q;
    @Inject
    public FbAndroidAuthActivityUtil f10707r;
    @Inject
    public Toaster f10708s;
    private final ActionReceiver f10709t = new C11401(this);
    private SelfRegistrableReceiverImpl f10710u;
    private FbTitleBar f10711v;
    private ConfirmationFragmentController f10712w;
    private View f10713x;
    public Contactpoint f10714y;
    public boolean f10715z = false;

    /* compiled from: invalidated_story_reasons */
    class C11401 implements ActionReceiver {
        final /* synthetic */ SimpleConfirmAccountActivity f10698a;

        C11401(SimpleConfirmAccountActivity simpleConfirmAccountActivity) {
            this.f10698a = simpleConfirmAccountActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -836482199);
            Contactpoint contactpoint = (Contactpoint) intent.getParcelableExtra("extra_background_confirmed_contactpoint");
            if (this.f10698a.f10714y != null && this.f10698a.f10714y.m17345a() && contactpoint != null && contactpoint.m17345a() && this.f10698a.f10714y.equals(contactpoint)) {
                if (this.f10698a.f10703B) {
                    this.f10698a.f10708s.a(new ToastBuilder(2131239778));
                } else {
                    Toaster toaster = this.f10698a.f10708s;
                    ToastBuilder toastBuilder = new ToastBuilder(2131239777);
                    toastBuilder.b = 17;
                    toaster.a(toastBuilder);
                }
                ConfirmationAnalyticsLogger confirmationAnalyticsLogger = this.f10698a.f10706q;
                Contactpoint contactpoint2 = this.f10698a.f10714y;
                HoneyClientEventFast a2 = confirmationAnalyticsLogger.a.a(ConfirmationLoggingEventType.FLOW_EXIT_SINCE_BACKGROUND_CONF.getAnalyticsName(), true);
                if (a2.a()) {
                    a2.a("confirmation");
                    a2.a("current_contactpoint", contactpoint2.normalized);
                    a2.b();
                }
                this.f10698a.finish();
                LogUtils.e(75531349, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 639408386, a);
        }
    }

    /* compiled from: invalidated_story_reasons */
    class C11412 extends OnToolbarButtonListener {
        final /* synthetic */ SimpleConfirmAccountActivity f10699a;

        C11412(SimpleConfirmAccountActivity simpleConfirmAccountActivity) {
            this.f10699a = simpleConfirmAccountActivity;
        }

        public final void m12627a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f10699a.f10715z) {
                this.f10699a.finish();
            } else {
                SimpleConfirmAccountActivity.m12636k(this.f10699a);
            }
        }
    }

    /* compiled from: invalidated_story_reasons */
    class C11423 implements OnClickListener {
        final /* synthetic */ SimpleConfirmAccountActivity f10700a;

        C11423(SimpleConfirmAccountActivity simpleConfirmAccountActivity) {
            this.f10700a = simpleConfirmAccountActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10700a.f10707r.a(this.f10700a);
            this.f10700a.finish();
        }
    }

    /* compiled from: invalidated_story_reasons */
    class C11434 implements OnClickListener {
        final /* synthetic */ SimpleConfirmAccountActivity f10701a;

        C11434(SimpleConfirmAccountActivity simpleConfirmAccountActivity) {
            this.f10701a = simpleConfirmAccountActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    private static <T extends Context> void m12629a(Class<T> cls, T t) {
        m12630a((Object) t, (Context) t);
    }

    public static void m12630a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SimpleConfirmAccountActivity simpleConfirmAccountActivity = (SimpleConfirmAccountActivity) obj;
        BaseFbBroadcastManager baseFbBroadcastManager = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector);
        ConfirmationAnalyticsLogger b = ConfirmationAnalyticsLogger.b(fbInjector);
        FbAndroidAuthActivityUtil b2 = FbAndroidAuthActivityUtil.b(fbInjector);
        Toaster b3 = Toaster.b(fbInjector);
        simpleConfirmAccountActivity.f10705p = baseFbBroadcastManager;
        simpleConfirmAccountActivity.f10706q = b;
        simpleConfirmAccountActivity.f10707r = b2;
        simpleConfirmAccountActivity.f10708s = b3;
    }

    protected final void m12639b(Bundle bundle) {
        super.b(bundle);
        Class cls = SimpleConfirmAccountActivity.class;
        m12630a((Object) this, (Context) this);
        setContentView(2130903748);
        Intent intent = getIntent();
        this.f10714y = (Contactpoint) intent.getParcelableExtra("extra_contactpoint");
        this.f10715z = intent.getBooleanExtra("extra_cancel_allowed", false);
        this.f10702A = intent.getBooleanExtra("extra_is_cliff_interstitial", false);
        this.f10703B = intent.getBooleanExtra("extra_for_phone_number_confirmation", false);
        this.f10704C = intent.getStringExtra("extra_phone_number_acquisition_quick_promotion_id");
        this.f10712w = (ConfirmationFragmentController) kO_().a(2131560680);
        this.f10712w.m12649a(this.f10714y);
        this.f10712w.m12651a(this.f10702A);
        this.f10712w.m12652b(this.f10703B);
        this.f10712w.m12650a(this.f10704C);
        this.f10712w.aq();
        m12634i();
        m12635j();
    }

    public void onBackPressed() {
        if (!this.f10712w.b()) {
            this.f10712w.e();
        } else if (this.f10715z) {
            finish();
        }
    }

    public final void a_(String str) {
        this.f10711v.setTitle(str);
    }

    public final void y_(int i) {
        this.f10711v.setTitle(i);
    }

    public void setCustomTitle(View view) {
        this.f10711v.setCustomTitleView(view);
        this.f10713x = view;
    }

    public final View lh_() {
        return this.f10713x;
    }

    public final void m12638a(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m12640b(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m12637a(OnToolbarButtonListener onToolbarButtonListener) {
    }

    public final void kg_() {
    }

    public final void m12641c(boolean z) {
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 403313989);
        if (this.f10710u != null) {
            this.f10710u.c();
            this.f10710u = null;
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -751078955, a);
    }

    private void m12634i() {
        this.f10710u = this.f10705p.a().a("action_background_contactpoint_confirmed", this.f10709t).a();
        this.f10710u.b();
    }

    private void m12635j() {
        String string;
        FbTitleBarUtil.b(this);
        this.f10711v = (FbTitleBar) findViewById(2131558563);
        if (this.f10715z) {
            string = getResources().getString(2131230727);
        } else {
            string = getResources().getString(2131239751);
        }
        C11412 c11412 = new C11412(this);
        Builder a = TitleBarButtonSpec.a();
        a.g = string;
        a = a;
        a.j = string;
        this.f10711v.setButtonSpecs(ImmutableList.of(a.a()));
        this.f10711v.setOnToolbarButtonListener(c11412);
    }

    public static void m12636k(SimpleConfirmAccountActivity simpleConfirmAccountActivity) {
        OnClickListener c11423 = new C11423(simpleConfirmAccountActivity);
        new AlertDialog.Builder(simpleConfirmAccountActivity).a(2131230723).b(2131230724).a(2131230729, c11423).b(2131230727, new C11434(simpleConfirmAccountActivity)).b();
    }
}
