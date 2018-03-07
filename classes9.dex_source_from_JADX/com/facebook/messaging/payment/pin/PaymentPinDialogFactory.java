package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

/* compiled from: has_closed_today_nux_banner */
public class PaymentPinDialogFactory {
    public final Context f13580a;
    public final SecureContextHelper f13581b;

    /* compiled from: has_closed_today_nux_banner */
    class C15131 implements OnClickListener {
        final /* synthetic */ PaymentPinDialogFactory f13578a;

        C15131(PaymentPinDialogFactory paymentPinDialogFactory) {
            this.f13578a = paymentPinDialogFactory;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: has_closed_today_nux_banner */
    class C15142 implements OnClickListener {
        final /* synthetic */ PaymentPinDialogFactory f13579a;

        C15142(PaymentPinDialogFactory paymentPinDialogFactory) {
            this.f13579a = paymentPinDialogFactory;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f13579a.f13581b.a(PaymentPinCreationActivity.m14149a(this.f13579a.f13580a), this.f13579a.f13580a);
        }
    }

    public static PaymentPinDialogFactory m14170b(InjectorLike injectorLike) {
        return new PaymentPinDialogFactory((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public PaymentPinDialogFactory(Context context, SecureContextHelper secureContextHelper) {
        this.f13580a = context;
        this.f13581b = secureContextHelper;
    }

    public final AlertDialog m14171a() {
        return new FbAlertDialogBuilder(this.f13580a).a(2131241044).b(2131241046).a(2131241045, new C15142(this)).b(2131230737, new C15131(this)).a();
    }
}
