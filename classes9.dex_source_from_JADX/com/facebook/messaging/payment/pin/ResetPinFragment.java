package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.pin.PaymentPinResetActivity.C15323;
import com.facebook.messaging.payment.pin.PaymentPinResetActivity.C15334;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.google.common.util.concurrent.Futures;

/* compiled from: hasMemoMultimedia */
public class ResetPinFragment extends FbFragment {
    public PaymentPinDialogFactory f13679a;
    public PaymentsSoftInputUtil f13680b;
    public FbEditText f13681c;
    private ImageView f13682d;
    private FbTextView f13683e;
    public C15323 f13684f;
    private String f13685g;
    private FbEditText f13686h;
    private ProgressBar f13687i;

    /* compiled from: hasMemoMultimedia */
    class C15401 implements OnEditorActionListener {
        final /* synthetic */ ResetPinFragment f13678a;

        C15401(ResetPinFragment resetPinFragment) {
            this.f13678a = resetPinFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 5) {
                Object obj;
                String obj2 = this.f13678a.f13681c.getText().toString();
                C15323 c15323 = this.f13678a.f13684f;
                PaymentPinResetActivity paymentPinResetActivity = c15323.f13636b;
                ResetPinFragment resetPinFragment = c15323.f13635a;
                if (paymentPinResetActivity.f13659I == null || paymentPinResetActivity.f13659I.isDone()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    resetPinFragment.aq();
                    paymentPinResetActivity.f13659I = paymentPinResetActivity.f13665w.m14283a();
                    Futures.a(paymentPinResetActivity.f13659I, new C15334(paymentPinResetActivity, resetPinFragment, obj2), paymentPinResetActivity.f13667y);
                }
            }
            return false;
        }
    }

    public static void m14242a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ResetPinFragment resetPinFragment = (ResetPinFragment) obj;
        PaymentPinDialogFactory b = PaymentPinDialogFactory.m14170b(fbInjector);
        PaymentsSoftInputUtil b2 = PaymentsSoftInputUtil.m16054b(fbInjector);
        resetPinFragment.f13679a = b;
        resetPinFragment.f13680b = b2;
    }

    public final View m14243a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1008695749);
        Class cls = ResetPinFragment.class;
        m14242a(this, getContext());
        View inflate = layoutInflater.inflate(2130906149, viewGroup, false);
        Bundle bundle2 = this.s;
        this.f13683e = (FbTextView) inflate.findViewById(2131565808);
        this.f13685g = bundle2.getString("savedHeaderText");
        this.f13683e.setText(this.f13685g);
        this.f13687i = (ProgressBar) inflate.findViewById(2131559418);
        this.f13686h = (FbEditText) inflate.findViewById(2131565810);
        this.f13686h.setFocusable(false);
        this.f13682d = (ImageView) inflate.findViewById(2131565812);
        this.f13682d.setVisibility(8);
        this.f13681c = (FbEditText) inflate.findViewById(2131565811);
        this.f13681c.setVisibility(0);
        this.f13681c.setOnEditorActionListener(new C15401(this));
        at();
        this.f13680b.m16056a(o(), this.f13681c);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1347207613, a);
        return inflate;
    }

    public final void m14244b() {
        this.f13681c.setText("");
        this.f13680b.m16056a(o(), this.f13681c);
    }

    public final void aq() {
        this.f13681c.setEnabled(false);
        this.f13681c.setFocusable(false);
        this.f13681c.setClickable(false);
        this.f13687i.setVisibility(0);
    }

    public final void ar() {
        this.f13687i.setVisibility(8);
        at();
    }

    private void at() {
        this.f13681c.setEnabled(true);
        this.f13681c.setFocusableInTouchMode(true);
        this.f13681c.setClickable(true);
    }
}
