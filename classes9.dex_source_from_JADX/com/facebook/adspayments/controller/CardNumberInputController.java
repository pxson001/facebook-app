package com.facebook.adspayments.controller;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.adspayments.PaymentUiUtil;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.adspayments.validation.CardInputFieldController;
import com.facebook.adspayments.validation.CardNumberInputValidator;
import com.facebook.adspayments.validation.InputValidatorCallback;
import com.facebook.adspayments.validation.InputValidatorCallbackHandler;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.cardio.cardiobase.DefaultPaymentsCardIO;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.cardform.formatting.CardFormattingTextWatcher;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Unable to call newBuilder method */
public class CardNumberInputController extends CardInputFieldController<CardNumberInputValidator> {
    private static final ImmutableMap<FbPaymentCardType, Integer> f23658g = ImmutableMap.of(FbPaymentCardType.AMEX, Integer.valueOf(2130842968), FbPaymentCardType.DISCOVER, Integer.valueOf(2130842969), FbPaymentCardType.MASTER_CARD, Integer.valueOf(2130842971), FbPaymentCardType.VISA, Integer.valueOf(2130842974), FbPaymentCardType.JCB, Integer.valueOf(2130842970));
    private final CardFormattingTextWatcher f23659c;
    public final DefaultPaymentsCardIO f23660d;
    public final PaymentsLogger f23661e;
    public final ExecutorService f23662f;
    public FbEditText f23663h;
    public ImageView f23664i;
    private FbTextView f23665j;

    /* compiled from: Unable to call newBuilder method */
    class C28471 implements InputValidatorCallback {
        final /* synthetic */ CardNumberInputController f23654a;

        C28471(CardNumberInputController cardNumberInputController) {
            this.f23654a = cardNumberInputController;
        }

        public final void mo1086a() {
            this.f23654a.m25626a(false);
        }

        public final void mo1087b() {
            this.f23654a.m25626a(true);
        }
    }

    /* compiled from: Unable to call newBuilder method */
    class C28482 implements OnFocusChangeListener {
        final /* synthetic */ CardNumberInputController f23655a;

        C28482(CardNumberInputController cardNumberInputController) {
            this.f23655a = cardNumberInputController;
        }

        public void onFocusChange(View view, boolean z) {
            boolean z2 = false;
            boolean z3;
            if (z) {
                this.f23655a.m25626a(false);
                z3 = false;
            } else {
                CardNumberInputValidator cardNumberInputValidator = (CardNumberInputValidator) this.f23655a.f23637f;
                boolean d = CardNumberInputValidator.m25761d(this.f23655a.f23663h.getText().toString());
                cardNumberInputValidator.m25760a(d);
                z3 = d;
            }
            View view2 = this.f23655a.f23664i;
            if (z || r0) {
                z2 = true;
            }
            PaymentUiUtil.m25553a(view2, z2);
        }
    }

    /* compiled from: Unable to call newBuilder method */
    class C28493 implements TextWatcher {
        final /* synthetic */ CardNumberInputController f23656a;

        C28493(CardNumberInputController cardNumberInputController) {
            this.f23656a = cardNumberInputController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            ((CardNumberInputValidator) this.f23656a.f23637f).m25760a(CardNumberInputValidator.f23728a.contains(PaymentMethodInputFormattingUtils.a(obj)));
            Object obj2 = null;
            if (!StringUtil.a(obj)) {
                String b = PaymentMethodInputFormattingUtils.b(obj);
                if (b.length() >= PaymentMethodInputFormattingUtils.a(b).getCardLength()) {
                    obj2 = 1;
                }
            }
            if (obj2 != null) {
                InputValidatorCallbackHandler inputValidatorCallbackHandler = this.f23656a.f23637f;
                if (!CardNumberInputValidator.m25761d(obj)) {
                    this.f23656a.m25626a(true);
                }
                this.f23656a.m25625a(this.f23656a.f23662f);
            } else if (obj.length() == 0) {
                this.f23656a.m25626a(false);
            }
            this.f23656a.m25655a(PaymentMethodInputFormattingUtils.a(obj));
        }
    }

    /* compiled from: Unable to call newBuilder method */
    class C28504 implements OnClickListener {
        final /* synthetic */ CardNumberInputController f23657a;

        C28504(CardNumberInputController cardNumberInputController) {
            this.f23657a = cardNumberInputController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1847214408);
            this.f23657a.f23661e.m3880a("payments_card_scanner_used", this.f23657a.f23643l);
            DefaultPaymentsCardIO defaultPaymentsCardIO = this.f23657a.f23660d;
            this.f23657a.f23664i.getContext();
            defaultPaymentsCardIO.b();
            Logger.a(2, EntryType.UI_INPUT_END, -1244482136, a);
        }
    }

    public static CardNumberInputController m25652b(InjectorLike injectorLike) {
        return new CardNumberInputController(CardFormattingTextWatcher.a(injectorLike), new CardNumberInputValidator(), DefaultPaymentsCardIO.a(injectorLike), PaymentsLogger.m3873a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), PaymentsQeAccessor.m25554a(injectorLike));
    }

    @Inject
    public CardNumberInputController(CardFormattingTextWatcher cardFormattingTextWatcher, CardNumberInputValidator cardNumberInputValidator, DefaultPaymentsCardIO defaultPaymentsCardIO, PaymentsLogger paymentsLogger, Resources resources, ExecutorService executorService, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        super(cardNumberInputValidator, resources, adsPaymentsExperimentsHelper, paymentsQeAccessor);
        this.f23659c = cardFormattingTextWatcher;
        this.f23660d = defaultPaymentsCardIO;
        this.f23661e = paymentsLogger;
        this.f23662f = executorService;
    }

    public final boolean mo1089a() {
        return CardNumberInputValidator.m25761d(this.f23663h.getText().toString());
    }

    public final String mo1090b() {
        return "card_number";
    }

    protected final void mo1088a(View view) {
        this.f23663h = (FbEditText) view.findViewById(2131565786);
        this.f23664i = (ImageView) view.findViewById(2131565787);
        this.f23664i.setImageResource(2130842973);
        m25653b(FbPaymentCardType.UNKNOWN);
        this.f23665j = (FbTextView) view.findViewById(2131565788);
        ((CardNumberInputValidator) this.f23637f).f23725a = new C28471(this);
        this.f23663h.setOnFocusChangeListener(new C28482(this));
        this.f23663h.addTextChangedListener(this.f23659c);
        this.f23663h.addTextChangedListener(new C28493(this));
    }

    public final void m25655a(FbPaymentCardType fbPaymentCardType) {
        this.f23664i.setImageResource(f23658g.containsKey(fbPaymentCardType) ? ((Integer) f23658g.get(fbPaymentCardType)).intValue() : 2130842973);
        m25653b(fbPaymentCardType);
    }

    private void m25653b(FbPaymentCardType fbPaymentCardType) {
        if (fbPaymentCardType == FbPaymentCardType.UNKNOWN) {
            DefaultPaymentsCardIO defaultPaymentsCardIO = this.f23660d;
            if (null != null) {
                this.f23664i.setImageResource(2130837974);
                this.f23664i.setOnClickListener(new C28504(this));
                return;
            }
        }
        this.f23664i.setOnClickListener(null);
    }

    public final EditText mo1091c() {
        return this.f23663h;
    }

    protected final TextView mo1092d() {
        return this.f23665j;
    }
}
