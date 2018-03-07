package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.verification.ScreenData;
import com.facebook.messaging.payment.model.verification.UserInput;
import com.facebook.messaging.payment.model.verification.UserInputBuilder;
import com.facebook.messaging.payment.ui.PaymentHeaderSubheaderLayout;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.resources.ui.FbEditText;
import java.util.Calendar;
import javax.inject.Inject;

/* compiled from: friend_going_name */
public class RiskLegalNameBirthdayFragment extends FbFragment {
    @Inject
    public PaymentsSoftInputUtil f14466a;
    public PaymentHeaderSubheaderLayout f14467b;
    public LinearLayout f14468c;
    private FbEditText f14469d;
    private FbEditText f14470e;
    public DatePicker f14471f;
    public boolean f14472g;

    /* compiled from: friend_going_name */
    public class C16521 implements OnDateChangedListener {
        final /* synthetic */ RiskLegalNameBirthdayFragment f14464a;

        public C16521(RiskLegalNameBirthdayFragment riskLegalNameBirthdayFragment) {
            this.f14464a = riskLegalNameBirthdayFragment;
        }

        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        }
    }

    /* compiled from: friend_going_name */
    public class C16532 implements OnDateChangedListener {
        final /* synthetic */ RiskLegalNameBirthdayFragment f14465a;

        public C16532(RiskLegalNameBirthdayFragment riskLegalNameBirthdayFragment) {
            this.f14465a = riskLegalNameBirthdayFragment;
        }

        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        }
    }

    public static void m14866a(Object obj, Context context) {
        ((RiskLegalNameBirthdayFragment) obj).f14466a = PaymentsSoftInputUtil.m16054b(FbInjector.get(context));
    }

    public final void m14871c(Bundle bundle) {
        super.c(bundle);
        Class cls = RiskLegalNameBirthdayFragment.class;
        m14866a((Object) this, getContext());
        e(true);
    }

    public final View m14868a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1604838128);
        View inflate = layoutInflater.inflate(2130906907, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -196620535, a);
        return inflate;
    }

    public final void m14869a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(2131820586, menu);
        super.a(menu, menuInflater);
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568685) {
            return super.a_(menuItem);
        }
        if (this.f14472g) {
            PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment = (PaymentRiskVerificationControllerFragment) this.G;
            UserInputBuilder newBuilder = UserInput.newBuilder();
            newBuilder.f13480a = this.f14469d.getText().toString();
            newBuilder = newBuilder;
            newBuilder.f13481b = this.f14470e.getText().toString();
            newBuilder = newBuilder;
            newBuilder.f13483d = String.valueOf(this.f14471f.getYear());
            newBuilder = newBuilder;
            newBuilder.f13484e = String.valueOf(this.f14471f.getMonth() + 1);
            newBuilder = newBuilder;
            newBuilder.f13485f = String.valueOf(this.f14471f.getDayOfMonth());
            paymentRiskVerificationControllerFragment.m14835a(newBuilder.m14087h(), null);
            m14867b();
            return true;
        }
        ScreenData screenData = (ScreenData) this.s.get("screen_data");
        this.f14467b.setHeader(2131240462);
        this.f14467b.setSubheader(2131240463);
        if (screenData != null) {
            this.f14471f.init(screenData.m14079h(), screenData.m14080i() - 1, screenData.m14081j(), new C16521(this));
        } else {
            Calendar instance = Calendar.getInstance();
            instance.add(1, -18);
            this.f14471f.init(instance.get(1), instance.get(2), instance.get(5), new C16532(this));
        }
        this.f14468c.setVisibility(8);
        this.f14471f.setVisibility(0);
        this.f14472g = true;
        return true;
    }

    public final void m14870a(View view, Bundle bundle) {
        this.f14467b = (PaymentHeaderSubheaderLayout) e(2131567114);
        this.f14468c = (LinearLayout) e(2131567124);
        this.f14469d = (FbEditText) e(2131567125);
        this.f14470e = (FbEditText) e(2131567126);
        this.f14471f = (DatePicker) e(2131567127);
        m14867b();
    }

    private void m14867b() {
        ScreenData screenData = (ScreenData) this.s.get("screen_data");
        this.f14467b.setHeader(2131240460);
        this.f14467b.setSubheader(2131240461);
        if (screenData == null || StringUtil.a(screenData.m14073b())) {
            this.f14466a.m16056a(ao(), this.f14469d);
        } else {
            this.f14469d.setText(screenData.m14073b());
            this.f14470e.setText(screenData.m14074c());
        }
        this.f14468c.setVisibility(0);
        this.f14471f.setVisibility(8);
        this.f14472g = false;
    }
}
