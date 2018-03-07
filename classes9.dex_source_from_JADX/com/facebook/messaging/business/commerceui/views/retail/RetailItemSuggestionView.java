package com.facebook.messaging.business.commerceui.views.retail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.attachments.views.PlatformGenericAttachmentItemView;
import com.facebook.messaging.business.commerce.model.retail.AgentItemSuggestion;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerceui.views.CommerceView;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParams;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParamsBuilder;
import com.facebook.messaging.payment.value.input.checkout.MCheckoutParams;
import com.facebook.messaging.payment.value.input.checkout.MCheckoutParamsBuilder;
import com.facebook.messaging.payment.value.input.checkout.MessengerPayCheckoutIntentHelper;
import com.facebook.messaging.xma.ui.XMALinearLayout;
import com.facebook.orca.threadview.MessageXMACallbackHelper.1;
import com.facebook.payments.checkout.CheckoutActivity;
import com.facebook.payments.checkout.CheckoutCommonParams;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.CheckoutStyle;
import com.facebook.payments.checkout.model.SimpleCheckoutItemPrice;
import com.facebook.payments.checkout.recyclerview.TermsAndPoliciesParams;
import com.facebook.payments.checkout.recyclerview.TermsAndPoliciesParams.Builder;
import com.facebook.payments.checkout.recyclerview.TermsAndPoliciesStyle;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.util.Currency;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null ViewerContextUser found sending payments via campaign flow. */
public class RetailItemSuggestionView extends XMALinearLayout implements CommerceView {
    @Inject
    public AnalyticsLogger f8576b;
    @Inject
    public PaymentCurrencyUtil f8577c;
    @Inject
    public AbstractFbErrorReporter f8578d;
    @Inject
    public MessengerPayCheckoutIntentHelper f8579e;
    private AgentItemSuggestion f8580f;
    private final PlatformGenericAttachmentItemView f8581g;
    private final BetterTextView f8582h;
    private final LinearLayout f8583i;
    private final BetterButton f8584j;
    private final BetterTextView f8585k;

    /* compiled from: null ViewerContextUser found sending payments via campaign flow. */
    class C09801 implements OnClickListener {
        final /* synthetic */ RetailItemSuggestionView f8575a;

        C09801(RetailItemSuggestionView retailItemSuggestionView) {
            this.f8575a = retailItemSuggestionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -306037801);
            RetailItemSuggestionView.m8812c(this.f8575a);
            Logger.a(2, EntryType.UI_INPUT_END, 378817414, a);
        }
    }

    private static <T extends View> void m8808a(Class<T> cls, T t) {
        m8809a((Object) t, t.getContext());
    }

    private static void m8809a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        RetailItemSuggestionView retailItemSuggestionView = (RetailItemSuggestionView) obj;
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        PaymentCurrencyUtil a2 = PaymentCurrencyUtil.m13192a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        MessengerPayCheckoutIntentHelper b = MessengerPayCheckoutIntentHelper.m15974b(injectorLike);
        retailItemSuggestionView.f8576b = a;
        retailItemSuggestionView.f8577c = a2;
        retailItemSuggestionView.f8578d = abstractFbErrorReporter;
        retailItemSuggestionView.f8579e = b;
    }

    public RetailItemSuggestionView(Context context) {
        this(context, null, 0);
    }

    public RetailItemSuggestionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public RetailItemSuggestionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8808a(RetailItemSuggestionView.class, (View) this);
        setContentView(2130905606);
        this.f8581g = (PlatformGenericAttachmentItemView) a(2131564576);
        this.f8583i = (LinearLayout) a(2131564577);
        this.f8582h = (BetterTextView) a(2131564580);
        this.f8584j = (BetterButton) a(2131564582);
        this.f8585k = (BetterTextView) a(2131564581);
        setOrientation(1);
        this.f8584j.setOnClickListener(new C09801(this));
    }

    public void setModel(CommerceBubbleModel commerceBubbleModel) {
        Preconditions.checkNotNull(commerceBubbleModel);
        Preconditions.checkState(commerceBubbleModel.b() == CommerceBubbleModelType.AGENT_ITEM_SUGGESTION);
        this.f8580f = (AgentItemSuggestion) commerceBubbleModel;
        m8811b();
    }

    private void m8811b() {
        Uri uri = null;
        if (this.f8580f.b == null) {
            this.f8581g.setDescriptionBackgroundColor(getResources().getColor(2131363772));
        } else {
            this.f8581g.setDescriptionBackgroundColor(getResources().getColor(2131361864));
        }
        this.f8581g.m8646a(this.f8580f.a, null, null);
        if (m8810a(this.f8580f.e, this.f8580f.f)) {
            this.f8583i.setVisibility(0);
            if (this.f8580f.c != null) {
                this.f8584j.setVisibility(8);
                this.f8585k.setVisibility(0);
            } else {
                this.f8584j.setVisibility(0);
                this.f8585k.setVisibility(8);
            }
            this.f8582h.setText(StringLocaleUtil.a(getContext().getString(2131240724), new Object[]{this.f8580f.e}));
            PlatformGenericAttachmentItemView platformGenericAttachmentItemView = this.f8581g;
            if (this.f8580f != null) {
                uri = this.f8580f.b;
            }
            platformGenericAttachmentItemView.f8358m = uri;
            return;
        }
        this.f8583i.setVisibility(8);
    }

    public final boolean mo231a() {
        return true;
    }

    public static void m8812c(RetailItemSuggestionView retailItemSuggestionView) {
        if (retailItemSuggestionView.m8810a(retailItemSuggestionView.f8580f.e, retailItemSuggestionView.f8580f.f)) {
            String str;
            Intent a;
            MoneyPennyItemParamsBuilder newBuilder = MoneyPennyItemParams.newBuilder();
            newBuilder.f15484a = Long.parseLong(retailItemSuggestionView.f8580f.a.a);
            MoneyPennyItemParamsBuilder moneyPennyItemParamsBuilder = newBuilder;
            if (retailItemSuggestionView.f8580f.a.d == null) {
                str = null;
            } else {
                str = retailItemSuggestionView.f8580f.a.d.toString();
            }
            moneyPennyItemParamsBuilder.f15485b = str;
            newBuilder = moneyPennyItemParamsBuilder;
            newBuilder.f15486c = retailItemSuggestionView.f8580f.a.b;
            newBuilder = newBuilder;
            newBuilder.f15487d = retailItemSuggestionView.f8580f.a.g;
            newBuilder = newBuilder;
            newBuilder.f15488e = retailItemSuggestionView.f8580f.a.h;
            newBuilder = newBuilder;
            newBuilder.f15489f = retailItemSuggestionView.f8580f.e;
            newBuilder = newBuilder;
            newBuilder.f15490g = retailItemSuggestionView.f8580f.f;
            MoneyPennyItemParams h = newBuilder.m15780h();
            MessengerPayCheckoutIntentHelper messengerPayCheckoutIntentHelper = retailItemSuggestionView.f8579e;
            Context context = retailItemSuggestionView.getContext();
            if (messengerPayCheckoutIntentHelper.f15784a.a(891, false)) {
                Builder newBuilder2 = TermsAndPoliciesParams.newBuilder();
                newBuilder2.f18565a = TermsAndPoliciesStyle.FACEBOOK;
                newBuilder2 = newBuilder2;
                newBuilder2.f18566b = Uri.parse("https://m.facebook.com/legal/m");
                TermsAndPoliciesParams e = newBuilder2.m18594e();
                CheckoutCommonParams.Builder newBuilder3 = CheckoutCommonParams.newBuilder();
                newBuilder3.f18454a = CheckoutStyle.M;
                newBuilder3 = newBuilder3;
                newBuilder3.f18455b = PaymentItemType.MESSENGER_COMMERCE;
                newBuilder3 = newBuilder3;
                newBuilder3.f18458e = e;
                CheckoutCommonParams.Builder builder = newBuilder3;
                builder.f18456c = new SimpleCheckoutItemPrice(new CurrencyAmount(h.f15483g, messengerPayCheckoutIntentHelper.f15785b.m13202a(h.f15482f, Currency.getInstance(h.f15483g))));
                builder = builder;
                builder.f18457d = PaymentsDecoratorParams.b();
                CheckoutCommonParams f = builder.m18461f();
                MCheckoutParamsBuilder mCheckoutParamsBuilder = new MCheckoutParamsBuilder();
                mCheckoutParamsBuilder.f15703a = f;
                MCheckoutParamsBuilder mCheckoutParamsBuilder2 = mCheckoutParamsBuilder;
                mCheckoutParamsBuilder2.f15704b = h;
                a = CheckoutActivity.m18455a(context, (CheckoutParams) new MCheckoutParams(mCheckoutParamsBuilder2));
            } else {
                a = EnterPaymentValueActivity.m15583a(context, h);
            }
            Intent intent = a;
            retailItemSuggestionView.f8576b.a(P2pPaymentsLogEvent.d("p2p_initiate_send", "mp_pay").o(retailItemSuggestionView.f8580f.a.a).a(retailItemSuggestionView.f8580f.e).a);
            retailItemSuggestionView.a(intent, 10001);
        }
    }

    private boolean m8810a(String str, String str2) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        try {
            if (this.f8577c.m13201a(str, str2).compareTo(BigDecimal.ZERO) > 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        } catch (IllegalArgumentException e2) {
            this.f8578d.a("PaymentCurrencyCodeError", "Error when getting currency from a currency code:" + str2);
            return false;
        }
    }

    public final void m8813a(@Nullable 1 1) {
        this.f8581g.setXMACallback(1);
    }
}
