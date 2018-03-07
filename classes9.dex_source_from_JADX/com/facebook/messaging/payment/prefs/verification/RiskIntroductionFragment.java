package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;

/* compiled from: friend_maybe_name */
public class RiskIntroductionFragment extends FbFragment {
    public SecureContextHelper f14458a;
    private BetterTextView f14459b;
    private BetterTextView f14460c;
    private BetterButton f14461d;

    /* compiled from: friend_maybe_name */
    class C16501 implements OnClickListener {
        final /* synthetic */ RiskIntroductionFragment f14456a;

        C16501(RiskIntroductionFragment riskIntroductionFragment) {
            this.f14456a = riskIntroductionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 247944961);
            this.f14456a.f14458a.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/369959656515129")), this.f14456a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1930715191, a);
        }
    }

    /* compiled from: friend_maybe_name */
    class C16512 implements OnClickListener {
        final /* synthetic */ RiskIntroductionFragment f14457a;

        C16512(RiskIntroductionFragment riskIntroductionFragment) {
            this.f14457a = riskIntroductionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -772230940);
            ((PaymentRiskVerificationControllerFragment) this.f14457a.G).m14835a(null, null);
            Logger.a(2, EntryType.UI_INPUT_END, 1044316620, a);
        }
    }

    public static void m14857a(Object obj, Context context) {
        ((RiskIntroductionFragment) obj).f14458a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public final void m14860c(Bundle bundle) {
        super.c(bundle);
        Class cls = RiskIntroductionFragment.class;
        m14857a((Object) this, getContext());
    }

    public final View m14858a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1467748407);
        View inflate = layoutInflater.inflate(2130906905, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1091761058, a);
        return inflate;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m14859a(android.view.View r5, android.os.Bundle r6) {
        /*
        r4 = this;
        r0 = 2131567118; // 0x7f0d220e float:1.8759797E38 double:1.053134085E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r5, r0);
        r0 = (com.facebook.widget.text.BetterTextView) r0;
        r4.f14459b = r0;
        r3 = r4.s;
        r0 = r3;
        r1 = "screen_data";
        r0 = r0.get(r1);
        r0 = (com.facebook.messaging.payment.model.verification.ScreenData) r0;
        r1 = r0.m14072a();
        r0 = -1;
        r2 = r1.hashCode();
        switch(r2) {
            case -1060382265: goto L_0x0064;
            case -685003834: goto L_0x0050;
            case -580071614: goto L_0x005a;
            default: goto L_0x0022;
        };
    L_0x0022:
        switch(r0) {
            case 0: goto L_0x006e;
            case 1: goto L_0x0076;
            case 2: goto L_0x007e;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = 2131567119; // 0x7f0d220f float:1.8759799E38 double:1.0531340853E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r5, r0);
        r0 = (com.facebook.widget.text.BetterTextView) r0;
        r4.f14460c = r0;
        r0 = r4.f14460c;
        r1 = new com.facebook.messaging.payment.prefs.verification.RiskIntroductionFragment$1;
        r1.<init>(r4);
        r0.setOnClickListener(r1);
        r0 = 2131567121; // 0x7f0d2211 float:1.8759803E38 double:1.0531340863E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r5, r0);
        r0 = (com.facebook.widget.text.BetterButton) r0;
        r4.f14461d = r0;
        r0 = r4.f14461d;
        r1 = new com.facebook.messaging.payment.prefs.verification.RiskIntroductionFragment$2;
        r1.<init>(r4);
        r0.setOnClickListener(r1);
        return;
    L_0x0050:
        r2 = "VERIFICATION_REASON_RISK";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0022;
    L_0x0058:
        r0 = 0;
        goto L_0x0022;
    L_0x005a:
        r2 = "VERIFICATION_REASON_COMPLIANCE_WEEKLY_300";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0022;
    L_0x0062:
        r0 = 1;
        goto L_0x0022;
    L_0x0064:
        r2 = "VERIFICATION_REASON_COMPLIANCE_LIFETIME_2000";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0022;
    L_0x006c:
        r0 = 2;
        goto L_0x0022;
    L_0x006e:
        r0 = r4.f14459b;
        r1 = 2131240447; // 0x7f0825ff float:1.809723E38 double:1.052972688E-314;
        r0.setText(r1);
    L_0x0076:
        r0 = r4.f14459b;
        r1 = 2131240448; // 0x7f082600 float:1.8097231E38 double:1.0529726884E-314;
        r0.setText(r1);
    L_0x007e:
        r0 = r4.f14459b;
        r1 = 2131240449; // 0x7f082601 float:1.8097233E38 double:1.052972689E-314;
        r0.setText(r1);
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.prefs.verification.RiskIntroductionFragment.a(android.view.View, android.os.Bundle):void");
    }
}
