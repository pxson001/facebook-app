package com.facebook.messaging.payment.prefs.verification;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.verification.ScreenData;
import com.facebook.messaging.payment.model.verification.UserInput;
import com.facebook.messaging.payment.model.verification.UserInputBuilder;
import com.facebook.messaging.payment.ui.PaymentHeaderSubheaderLayout;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.cardform.formatting.CardFormattingTextWatcher;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;

/* compiled from: friend_suggestion_connectivity */
public class RiskCardFirstSixFragment extends FbFragment {
    public PaymentsSoftInputUtil f14445a;
    public CardFormattingTextWatcher f14446b;
    private FbEditText f14447c;

    public static void m14838a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RiskCardFirstSixFragment riskCardFirstSixFragment = (RiskCardFirstSixFragment) obj;
        PaymentsSoftInputUtil b = PaymentsSoftInputUtil.m16054b(fbInjector);
        CardFormattingTextWatcher a = CardFormattingTextWatcher.a(fbInjector);
        riskCardFirstSixFragment.f14445a = b;
        riskCardFirstSixFragment.f14446b = a;
    }

    public final void m14842c(Bundle bundle) {
        super.c(bundle);
        Class cls = RiskCardFirstSixFragment.class;
        m14838a((Object) this, getContext());
        e(true);
    }

    public final View m14839a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 679158512);
        View inflate = layoutInflater.inflate(2130906904, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1313501169, a);
        return inflate;
    }

    public final void m14841a(View view, Bundle bundle) {
        ScreenData screenData = (ScreenData) this.s.get("screen_data");
        PaymentHeaderSubheaderLayout paymentHeaderSubheaderLayout = (PaymentHeaderSubheaderLayout) FindViewUtil.b(view, 2131567114);
        paymentHeaderSubheaderLayout.setHeader(2131240457);
        paymentHeaderSubheaderLayout.setSubheader(getContext().getString(2131240458, new Object[]{screenData.m14076e(), screenData.m14077f()}));
        ((FbTextView) FindViewUtil.b(view, 2131567117)).setText(PaymentMethodInputFormattingUtils.a(2) + " " + PaymentMethodInputFormattingUtils.a(4) + " " + screenData.m14077f());
        this.f14447c = (FbEditText) FindViewUtil.b(view, 2131567116);
        this.f14446b.a = ' ';
        this.f14447c.addTextChangedListener(this.f14446b);
        Activity ao = ao();
        if (ao != null) {
            this.f14445a.m16056a(ao, this.f14447c);
        }
        LinearLayout linearLayout = (LinearLayout) FindViewUtil.b(view, 2131567115);
        FbTextView fbTextView = (FbTextView) FindViewUtil.b(view, 2131560676);
        if (screenData.m14082k()) {
            linearLayout.setBackgroundResource(2130842554);
            fbTextView.setVisibility(0);
            return;
        }
        linearLayout.setBackgroundResource(2130842552);
        fbTextView.setVisibility(8);
    }

    public final void m14840a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(2131820586, menu);
        super.a(menu, menuInflater);
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131568685) {
            PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment = (PaymentRiskVerificationControllerFragment) this.G;
            String b = PaymentMethodInputFormattingUtils.b(this.f14447c.getText().toString());
            UserInputBuilder newBuilder = UserInput.newBuilder();
            newBuilder.f13482c = b;
            paymentRiskVerificationControllerFragment.m14835a(newBuilder.m14087h(), null);
        }
        return super.a_(menuItem);
    }
}
