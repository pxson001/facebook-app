package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.verification.UserInput;
import com.facebook.messaging.payment.model.verification.UserInputBuilder;
import com.facebook.messaging.payment.ui.PaymentHeaderSubheaderLayout;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: friend_maybe_count */
public class RiskLast4SSNFragment extends FbFragment {
    @Inject
    public PaymentsSoftInputUtil f14462a;
    private FbEditText f14463b;

    public static void m14861a(Object obj, Context context) {
        ((RiskLast4SSNFragment) obj).f14462a = PaymentsSoftInputUtil.m16054b(FbInjector.get(context));
    }

    public final void m14865c(Bundle bundle) {
        super.c(bundle);
        Class cls = RiskLast4SSNFragment.class;
        m14861a((Object) this, getContext());
        e(true);
    }

    public final View m14862a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2105414423);
        View inflate = layoutInflater.inflate(2130906906, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1366941910, a);
        return inflate;
    }

    public final void m14864a(View view, Bundle bundle) {
        PaymentHeaderSubheaderLayout paymentHeaderSubheaderLayout = (PaymentHeaderSubheaderLayout) FindViewUtil.b(view, 2131567114);
        paymentHeaderSubheaderLayout.setHeader(2131240464);
        paymentHeaderSubheaderLayout.setSubheader(2131240465);
        ((FbTextView) e(2131567122)).setText(PaymentMethodInputFormattingUtils.a(3) + " " + PaymentMethodInputFormattingUtils.a(2) + " ");
        this.f14463b = (FbEditText) FindViewUtil.b(view, 2131567123);
        this.f14462a.m16056a(ao(), this.f14463b);
    }

    public final void m14863a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(2131820586, menu);
        super.a(menu, menuInflater);
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131568685) {
            PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment = (PaymentRiskVerificationControllerFragment) this.G;
            String b = PaymentMethodInputFormattingUtils.b(this.f14463b.getText().toString());
            UserInputBuilder newBuilder = UserInput.newBuilder();
            newBuilder.f13486g = b;
            paymentRiskVerificationControllerFragment.m14835a(newBuilder.m14087h(), null);
        }
        return super.a_(menuItem);
    }
}
