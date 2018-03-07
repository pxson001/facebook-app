package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.CancelPaymentTransactionParams;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.Listener;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friend_suggestions */
public class PaymentRiskVerificationActivity extends FbFragmentActivity implements ActionBarOwner {
    @Inject
    public AppCompatActivityOverrider f14423p;
    @Inject
    public PaymentProtocolUtil f14424q;
    @Inject
    @ViewerContextUser
    public Provider<User> f14425r;
    private ActionBarBasedFbTitleBar f14426s;
    public PaymentRiskVerificationControllerFragment f14427t;
    public String f14428u;
    public String f14429v;
    private final Listener f14430w = new C16411(this);

    /* compiled from: friend_suggestions */
    class C16411 implements Listener {
        final /* synthetic */ PaymentRiskVerificationActivity f14422a;

        C16411(PaymentRiskVerificationActivity paymentRiskVerificationActivity) {
            this.f14422a = paymentRiskVerificationActivity;
        }

        public final void m14817a() {
        }

        public final void m14818b() {
            PaymentProtocolUtil paymentProtocolUtil = this.f14422a.f14424q;
            String str = this.f14422a.f14428u;
            Bundle bundle = new Bundle();
            bundle.putParcelable(CancelPaymentTransactionParams.f14732a, new CancelPaymentTransactionParams(str));
            BlueServiceOperationFactoryDetour.a(paymentProtocolUtil.f14533a, "cancel_payment_transaction", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(paymentProtocolUtil.getClass()), 471852372).a(true).a();
            this.f14422a.finish();
        }

        public final void m14819c() {
        }
    }

    public static void m14820a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PaymentRiskVerificationActivity paymentRiskVerificationActivity = (PaymentRiskVerificationActivity) obj;
        AppCompatActivityOverrider b = AppCompatActivityOverrider.b(injectorLike);
        PaymentProtocolUtil a = PaymentProtocolUtil.m14937a(injectorLike);
        Provider a2 = IdBasedProvider.a(injectorLike, 3596);
        paymentRiskVerificationActivity.f14423p = b;
        paymentRiskVerificationActivity.f14424q = a;
        paymentRiskVerificationActivity.f14425r = a2;
    }

    protected final void m14823a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentRiskVerificationActivity.class;
        m14820a(this, this);
        a(this.f14423p);
    }

    public final void m14824a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PaymentsConfirmDialogFragment) {
            ((PaymentsConfirmDialogFragment) fragment).am = this.f14430w;
        }
    }

    protected final void m14825b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130904413);
        this.f14426s = new ActionBarBasedFbTitleBar(this, this.f14423p.g());
        this.f14428u = getIntent().getStringExtra("transaction_id");
        this.f14429v = getIntent().getStringExtra("recipient_id");
        this.f14427t = (PaymentRiskVerificationControllerFragment) kO_().a("payment_risk_verification_controller_fragment_tag");
        if (this.f14427t == null) {
            String str = this.f14428u;
            String str2 = this.f14429v;
            PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment = new PaymentRiskVerificationControllerFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("transaction_id", str);
            bundle2.putString("recipient_id", str2);
            paymentRiskVerificationControllerFragment.g(bundle2);
            this.f14427t = paymentRiskVerificationControllerFragment;
            kO_().a().a(2131560203, this.f14427t, "payment_risk_verification_controller_fragment_tag").b();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        this.f14426s.a(menu);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m14821j();
        return true;
    }

    public void onBackPressed() {
        m14821j();
    }

    public final ActionBar m14822a() {
        return this.f14423p.g();
    }

    private void m14821j() {
        if (this.f14427t == null || this.f14427t.aq == null || this.f14427t.aq.isTerminal || this.f14425r.get() == null || ((User) this.f14425r.get()).a.equals(this.f14429v)) {
            finish();
        } else {
            PaymentsConfirmDialogFragment.a(getString(2131240477), getString(2131240478), getString(2131240479), getString(2131240480), true).a(kO_(), "risk_flow_exit_confirm_dialog_fragment_tag");
        }
    }
}
