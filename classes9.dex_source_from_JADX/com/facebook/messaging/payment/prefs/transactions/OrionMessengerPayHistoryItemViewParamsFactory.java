package com.facebook.messaging.payment.prefs.transactions;

import android.content.res.Resources;
import android.graphics.Typeface;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionType;
import com.facebook.messaging.payment.model.PaymentUser;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: from-data */
public class OrionMessengerPayHistoryItemViewParamsFactory {
    private static final Class<?> f14393a = OrionMessengerPayHistoryItemViewParamsFactory.class;
    private final Resources f14394b;
    private final MessagingDateUtil f14395c;
    private final PaymentTransactionUtil f14396d;

    @Inject
    public OrionMessengerPayHistoryItemViewParamsFactory(Resources resources, MessagingDateUtil messagingDateUtil, PaymentTransactionUtil paymentTransactionUtil) {
        this.f14394b = resources;
        this.f14395c = messagingDateUtil;
        this.f14396d = paymentTransactionUtil;
    }

    public final MessengerPayHistoryItemViewParams m14779a(Object obj) {
        Preconditions.checkArgument(obj instanceof PaymentTransaction);
        PaymentTransaction paymentTransaction = (PaymentTransaction) obj;
        boolean z = !this.f14396d.m15527c(paymentTransaction);
        MessengerPayHistoryItemViewCommonParamsBuilder newBuilder = MessengerPayHistoryItemViewCommonParams.newBuilder();
        newBuilder.f14343a = PaymentTransactionType.ORION;
        newBuilder = newBuilder;
        newBuilder.f14347e = Boolean.valueOf(z);
        newBuilder = newBuilder;
        newBuilder.f14344b = m14776a(paymentTransaction, z).mo527c();
        newBuilder = newBuilder;
        newBuilder.f14345c = paymentTransaction.f13237j;
        newBuilder = newBuilder;
        newBuilder.f14346d = m14777a(paymentTransaction);
        newBuilder = newBuilder;
        UserMessengerPayHistoryItemViewParamsBuilder newBuilder2 = UserMessengerPayHistoryItemViewParams.newBuilder();
        newBuilder2.f14420a = m14776a(paymentTransaction, z);
        UserMessengerPayHistoryItemViewParamsBuilder userMessengerPayHistoryItemViewParamsBuilder = newBuilder2;
        userMessengerPayHistoryItemViewParamsBuilder.f14421b = newBuilder.m14754f();
        return userMessengerPayHistoryItemViewParamsBuilder.m14816c();
    }

    private MessengerPayHistoryStatusViewParams m14777a(PaymentTransaction paymentTransaction) {
        switch (paymentTransaction.f13234g) {
            case R_PENDING:
            case R_PENDING_VERIFICATION:
            case R_PENDING_VERIFICATION_PROCESSING:
            case R_PENDING_MANUAL_REVIEW:
            case R_PENDING_NUX:
            case R_PENDING_PROCESSING:
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
                return m14778a(paymentTransaction, false, MessengerPayHistoryStatusViewState.PENDING);
            case R_COMPLETED:
                return m14778a(paymentTransaction, false, MessengerPayHistoryStatusViewState.COMPLETED);
            case R_CANCELED:
            case R_CANCELED_SENDER_RISK:
            case R_CANCELED_RECIPIENT_RISK:
            case R_CANCELED_DECLINED:
            case R_CANCELED_EXPIRED:
            case R_CANCELED_SAME_CARD:
            case R_CANCELED_CUSTOMER_SERVICE:
            case R_CANCELED_CHARGEBACK:
            case R_CANCELED_SYSTEM_FAIL:
                return m14778a(paymentTransaction, false, MessengerPayHistoryStatusViewState.CANCELED);
            case S_SENT:
            case S_COMPLETED:
                return m14778a(paymentTransaction, true, MessengerPayHistoryStatusViewState.COMPLETED);
            case S_CANCELED:
            case S_CANCELED_SENDER_RISK:
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
            case S_CANCELED_SAME_CARD:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_CANCELED_SYSTEM_FAIL:
                return m14778a(paymentTransaction, true, MessengerPayHistoryStatusViewState.CANCELED);
            case S_PENDING:
            case S_PENDING_MANUAL_REVIEW:
            case S_PENDING_VERIFICATION:
            case S_PENDING_VERIFICATION_PROCESSING:
                return m14778a(paymentTransaction, true, MessengerPayHistoryStatusViewState.PENDING);
            default:
                MessengerPayHistoryStatusViewParamsBuilder newBuilder = MessengerPayHistoryStatusViewParams.newBuilder();
                newBuilder.f14387b = MessengerPayHistoryStatusViewState.PENDING;
                newBuilder = newBuilder;
                newBuilder.f14386a = Typeface.DEFAULT_BOLD;
                newBuilder = newBuilder;
                newBuilder.f14388c = "";
                return newBuilder.m14774d();
        }
    }

    private MessengerPayHistoryStatusViewParams m14778a(PaymentTransaction paymentTransaction, boolean z, MessengerPayHistoryStatusViewState messengerPayHistoryStatusViewState) {
        MessengerPayHistoryStatusViewParamsBuilder newBuilder = MessengerPayHistoryStatusViewParams.newBuilder();
        switch (messengerPayHistoryStatusViewState) {
            case PENDING:
                newBuilder.f14386a = Typeface.DEFAULT_BOLD;
                newBuilder.f14388c = this.f14394b.getString(2131240349);
                break;
            case CANCELED:
                newBuilder.f14386a = Typeface.DEFAULT_BOLD;
                newBuilder.f14388c = this.f14394b.getString(2131240350);
                break;
            case COMPLETED:
                newBuilder.f14386a = Typeface.DEFAULT;
                long parseLong = Long.parseLong(paymentTransaction.f13233f) * 1000;
                int i = z ? 2131240323 : 2131240324;
                if (parseLong <= 0) {
                    newBuilder.f14388c = "";
                    break;
                }
                newBuilder.f14388c = this.f14394b.getString(i, new Object[]{this.f14395c.a(parseLong)});
                break;
            default:
                newBuilder.f14386a = Typeface.DEFAULT;
                newBuilder.f14388c = "";
                break;
        }
        newBuilder.f14387b = messengerPayHistoryStatusViewState;
        return newBuilder.m14774d();
    }

    private static PaymentUser m14776a(PaymentTransaction paymentTransaction, boolean z) {
        if (z) {
            return paymentTransaction.f13232e;
        }
        return paymentTransaction.f13231d;
    }
}
