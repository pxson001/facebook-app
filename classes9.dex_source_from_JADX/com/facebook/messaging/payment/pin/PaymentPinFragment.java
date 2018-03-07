package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

/* compiled from: has_caption */
public class PaymentPinFragment extends FbFragment {
    private static final Class<?> f13587a = PaymentPinFragment.class;
    public PinInputListener al;
    private String am;
    private FbTextView an;
    private ProgressBar ao;
    public PaymentPinDialogFactory f13588b;
    public DrawPinDotsTextWatcherProvider f13589c;
    public PaymentsSoftInputUtil f13590d;
    public ObjectMapper f13591e;
    private FbTextView f13592f;
    public FbEditText f13593g;
    public ImageView f13594h;
    private FbTextView f13595i;

    /* compiled from: has_caption */
    class C15151 implements OnClickListener {
        final /* synthetic */ PaymentPinFragment f13582a;

        C15151(PaymentPinFragment paymentPinFragment) {
            this.f13582a = paymentPinFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2037914475);
            this.f13582a.al.mo529a();
            Logger.a(2, EntryType.UI_INPUT_END, 714356716, a);
        }
    }

    /* compiled from: has_caption */
    class C15162 implements TextWatcher {
        final /* synthetic */ PaymentPinFragment f13583a;

        C15162(PaymentPinFragment paymentPinFragment) {
            this.f13583a = paymentPinFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i == 3) {
                this.f13583a.m14180b();
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: has_caption */
    class C15173 implements OnEditorActionListener {
        final /* synthetic */ PaymentPinFragment f13584a;

        C15173(PaymentPinFragment paymentPinFragment) {
            this.f13584a = paymentPinFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 5) {
                this.f13584a.m14180b();
            }
            return false;
        }
    }

    /* compiled from: has_caption */
    class C15184 implements OnClickListener {
        final /* synthetic */ PaymentPinFragment f13585a;

        C15184(PaymentPinFragment paymentPinFragment) {
            this.f13585a = paymentPinFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1255294193);
            this.f13585a.f13590d.m16056a(this.f13585a.o(), this.f13585a.f13593g);
            Logger.a(2, EntryType.UI_INPUT_END, -369998432, a);
        }
    }

    /* compiled from: has_caption */
    class C15195 implements AnimationListener {
        final /* synthetic */ PaymentPinFragment f13586a;

        C15195(PaymentPinFragment paymentPinFragment) {
            this.f13586a = paymentPinFragment;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            PaymentPinFragment paymentPinFragment = this.f13586a;
            paymentPinFragment.f13593g.setText("");
            paymentPinFragment.f13590d.m16056a(paymentPinFragment.o(), paymentPinFragment.f13593g);
            paymentPinFragment.f13594h.setImageDrawable((LayerDrawable) paymentPinFragment.jW_().getDrawable(2130842547));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: has_caption */
    final class C15206 implements DialogInterface.OnClickListener {
        C15206() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static void m14174a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PaymentPinFragment paymentPinFragment = (PaymentPinFragment) obj;
        PaymentPinDialogFactory b = PaymentPinDialogFactory.m14170b(fbInjector);
        DrawPinDotsTextWatcherProvider drawPinDotsTextWatcherProvider = (DrawPinDotsTextWatcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(DrawPinDotsTextWatcherProvider.class);
        PaymentsSoftInputUtil b2 = PaymentsSoftInputUtil.m16054b(fbInjector);
        ObjectMapper objectMapper = (ObjectMapper) FbObjectMapperMethodAutoProvider.a(fbInjector);
        paymentPinFragment.f13588b = b;
        paymentPinFragment.f13589c = drawPinDotsTextWatcherProvider;
        paymentPinFragment.f13590d = b2;
        paymentPinFragment.f13591e = objectMapper;
    }

    protected final void m14181b(ServiceException serviceException) {
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            PaymentConnectivityDialogFactory.a(getContext(), serviceException);
            return;
        }
        ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
        if (apiErrorResult.a() != 10073) {
            m14178c(getContext(), ApiErrorResult.a(apiErrorResult.c())).show();
        } else {
            m14175a(apiErrorResult.d());
        }
    }

    public static PaymentPinFragment m14173a(String str, int i, boolean z) {
        Preconditions.checkNotNull(str);
        Bundle bundle = new Bundle();
        bundle.putString("savedHeaderText", str);
        bundle.putInt("savedTag", i);
        bundle.putBoolean("forgetLink", z);
        PaymentPinFragment paymentPinFragment = new PaymentPinFragment();
        paymentPinFragment.g(bundle);
        return paymentPinFragment;
    }

    public final View m14179a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1702984573);
        Class cls = PaymentPinFragment.class;
        m14174a(this, getContext());
        View inflate = layoutInflater.inflate(2130906149, viewGroup, false);
        Bundle bundle2 = this.s;
        this.f13595i = (FbTextView) inflate.findViewById(2131565808);
        this.am = bundle2.getString("savedHeaderText");
        this.f13595i.setText(this.am);
        this.f13592f = (FbTextView) inflate.findViewById(2131565807);
        this.an = (FbTextView) inflate.findViewById(2131565809);
        if (bundle2.getBoolean("forgetLink", false)) {
            this.an.setVisibility(0);
            this.an.setOnClickListener(new C15151(this));
        }
        this.ao = (ProgressBar) inflate.findViewById(2131559418);
        this.f13594h = (ImageView) inflate.findViewById(2131565812);
        this.f13593g = (FbEditText) inflate.findViewById(2131565810);
        this.f13593g.addTextChangedListener(new DrawPinDotsTextWatcher(this.f13594h, ResourcesMethodAutoProvider.a(this.f13589c)));
        this.f13593g.addTextChangedListener(new C15162(this));
        this.f13593g.setOnEditorActionListener(new C15173(this));
        this.f13594h.setOnClickListener(new C15184(this));
        av();
        this.f13593g.requestFocus();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1851701120, a);
        return inflate;
    }

    public final void m14180b() {
        String obj = this.f13593g.getText().toString();
        if (this.f13593g.length() == 4 && this.al != null) {
            this.al.mo530a(obj);
        }
    }

    public static boolean m14176a(ServiceException serviceException) {
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            return false;
        }
        return ((ApiErrorResult) serviceException.result.h()).a() == 10075;
    }

    public final void aq() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f13594h.getContext(), 2130968655);
        loadAnimation.setAnimationListener(new C15195(this));
        this.f13594h.startAnimation(loadAnimation);
    }

    public final void ar() {
        this.f13593g.setEnabled(false);
        this.f13593g.setFocusable(false);
        this.f13593g.setClickable(false);
        this.ao.setVisibility(0);
    }

    public final void as() {
        this.ao.setVisibility(8);
        av();
    }

    public static AlertDialog m14178c(Context context, String str) {
        AlertDialog a = new FbAlertDialogBuilder(context).b(str).c(2131230726, new C15206()).a();
        a.requestWindowFeature(1);
        return a;
    }

    private void m14175a(String str) {
        switch (m14172a(str, "remain_attempts_count", 6)) {
            case 1:
                m14177b(jW_().getString(2131241041));
                return;
            case 2:
                m14177b(jW_().getString(2131241040));
                return;
            case 3:
                m14177b(jW_().getString(2131241039));
                return;
            default:
                this.f13592f.setVisibility(8);
                return;
        }
    }

    private int m14172a(String str, String str2, int i) {
        try {
            i = this.f13591e.a(str).b(str2).C();
        } catch (Throwable e) {
            BLog.b(f13587a, "Exception when parsing message", e);
        }
        return i;
    }

    private void m14177b(String str) {
        this.f13592f.setVisibility(0);
        this.f13592f.setText(str);
    }

    private void av() {
        this.f13593g.setEnabled(true);
        this.f13593g.setFocusableInTouchMode(true);
        this.f13593g.setClickable(true);
    }

    public final int m14182e() {
        return this.s.getInt("savedTag");
    }
}
