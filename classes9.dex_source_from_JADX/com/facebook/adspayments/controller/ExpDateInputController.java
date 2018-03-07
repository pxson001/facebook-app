package com.facebook.adspayments.controller;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.validation.CardInputFieldController;
import com.facebook.adspayments.validation.ExpDateInputValidator;
import com.facebook.adspayments.validation.InputValidatorCallback;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.cardform.formatting.ExpDateFormattingTextWatcher;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Unable to build stun ping */
public class ExpDateInputController extends CardInputFieldController<ExpDateInputValidator> {
    private final ExpDateFormattingTextWatcher f23669c;
    public final ExecutorService f23670d;
    private FbEditText f23671e;
    private FbTextView f23672f;

    /* compiled from: Unable to build stun ping */
    class C28511 implements InputValidatorCallback {
        final /* synthetic */ ExpDateInputController f23666a;

        C28511(ExpDateInputController expDateInputController) {
            this.f23666a = expDateInputController;
        }

        public final void mo1086a() {
            this.f23666a.m25626a(false);
        }

        public final void mo1087b() {
            this.f23666a.m25626a(true);
        }
    }

    /* compiled from: Unable to build stun ping */
    class C28522 implements OnFocusChangeListener {
        final /* synthetic */ ExpDateInputController f23667a;

        C28522(ExpDateInputController expDateInputController) {
            this.f23667a = expDateInputController;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f23667a.m25626a(false);
            } else {
                this.f23667a.m25631i();
            }
        }
    }

    /* compiled from: Unable to build stun ping */
    class C28533 implements TextWatcher {
        final /* synthetic */ ExpDateInputController f23668a;

        C28533(ExpDateInputController expDateInputController) {
            this.f23668a = expDateInputController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (((ExpDateInputValidator) this.f23668a.f23637f).m25764a(editable.toString())) {
                this.f23668a.m25625a(this.f23668a.f23670d);
            } else {
                this.f23668a.m25626a(editable.length() >= 5);
            }
        }
    }

    public static ExpDateInputController m25662b(InjectorLike injectorLike) {
        return new ExpDateInputController(ExpDateFormattingTextWatcher.a(injectorLike), new ExpDateInputValidator((Clock) SystemClockMethodAutoProvider.a(injectorLike)), ResourcesMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), PaymentsQeAccessor.m25554a(injectorLike));
    }

    @Inject
    public ExpDateInputController(ExpDateFormattingTextWatcher expDateFormattingTextWatcher, ExpDateInputValidator expDateInputValidator, Resources resources, ExecutorService executorService, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        super(expDateInputValidator, resources, adsPaymentsExperimentsHelper, paymentsQeAccessor);
        this.f23669c = expDateFormattingTextWatcher;
        this.f23670d = executorService;
    }

    public final void mo1088a(View view) {
        this.f23671e = (FbEditText) view.findViewById(2131558759);
        this.f23672f = (FbTextView) view.findViewById(2131558760);
        ((ExpDateInputValidator) this.f23637f).f23725a = new C28511(this);
        this.f23671e.setOnFocusChangeListener(new C28522(this));
        this.f23671e.addTextChangedListener(this.f23669c);
        this.f23671e.addTextChangedListener(new C28533(this));
    }

    public final String mo1090b() {
        return "expiration_date";
    }

    public final EditText mo1091c() {
        return this.f23671e;
    }

    protected final TextView mo1092d() {
        return this.f23672f;
    }

    public final boolean mo1089a() {
        return ((ExpDateInputValidator) this.f23637f).m25764a(this.f23671e.getText().toString());
    }
}
