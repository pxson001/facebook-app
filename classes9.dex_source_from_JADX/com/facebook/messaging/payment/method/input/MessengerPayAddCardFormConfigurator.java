package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.messaging.dialog.ConfirmActionParams;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormConfigurator;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import javax.inject.Inject;

/* compiled from: initRecording() called twice without stopRecording() */
public class MessengerPayAddCardFormConfigurator extends SimpleCardFormConfigurator {
    private final Context f13010a;

    /* compiled from: initRecording() called twice without stopRecording() */
    /* synthetic */ class C14461 {
        static final /* synthetic */ int[] f13009a = new int[FbPaymentCardType.values().length];

        static {
            try {
                f13009a[FbPaymentCardType.VISA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13009a[FbPaymentCardType.MASTER_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13009a[FbPaymentCardType.AMEX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13009a[FbPaymentCardType.DISCOVER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13009a[FbPaymentCardType.JCB.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public MessengerPayAddCardFormConfigurator(Context context) {
        super(context);
        this.f13010a = context;
    }

    public final void m13316a(Context context) {
        MessengerMaterialThemeUtil.a(context, 2131625175);
    }

    public final String m13315a(CardFormParams cardFormParams) {
        return ((MessengerPayCardFormParams) cardFormParams).f13032e ? super.a(cardFormParams) : this.f13010a.getString(2131240283);
    }

    public final boolean m13317a(FbPaymentCardType fbPaymentCardType, CardFormParams cardFormParams) {
        if (((MessengerPayCardFormParams) cardFormParams).f13032e) {
            return super.a(fbPaymentCardType, cardFormParams);
        }
        switch (C14461.f13009a[fbPaymentCardType.ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public final ConfirmActionParams m13318b(CardFormParams cardFormParams) {
        if (((MessengerPayCardFormParams) cardFormParams).f13032e) {
            return super.b(cardFormParams);
        }
        Builder builder = new Builder(this.f13010a.getString(2131240289), this.f13010a.getString(2131240525));
        builder.d = this.f13010a.getString(2131240290);
        builder = builder;
        builder.c = this.f13010a.getString(2131240291);
        builder = builder;
        builder.f = true;
        return builder.a();
    }

    public final Intent m13319c(CardFormParams cardFormParams) {
        if (((MessengerPayCardFormParams) cardFormParams).f13032e) {
            return super.c(cardFormParams);
        }
        return new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/android/1528535330720775"));
    }
}
