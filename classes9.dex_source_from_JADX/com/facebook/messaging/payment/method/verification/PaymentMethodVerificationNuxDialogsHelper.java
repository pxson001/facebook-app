package com.facebook.messaging.payment.method.verification;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.pin.PaymentPinDialogFactory;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: image_metadata */
public class PaymentMethodVerificationNuxDialogsHelper {
    public final Context f13168a;
    public final PaymentPinDialogFactory f13169b;
    public final DefaultQuickPromotionActionHandler f13170c;

    public static PaymentMethodVerificationNuxDialogsHelper m13457b(InjectorLike injectorLike) {
        return new PaymentMethodVerificationNuxDialogsHelper((Context) injectorLike.getInstance(Context.class), PaymentPinDialogFactory.m14170b(injectorLike), DefaultQuickPromotionActionHandler.a(injectorLike));
    }

    @Inject
    public PaymentMethodVerificationNuxDialogsHelper(Context context, PaymentPinDialogFactory paymentPinDialogFactory, DefaultQuickPromotionActionHandler defaultQuickPromotionActionHandler) {
        this.f13168a = context;
        this.f13169b = paymentPinDialogFactory;
        this.f13170c = defaultQuickPromotionActionHandler;
    }

    public final void m13458a(boolean z, boolean z2) {
        m13456a(z, z2, 2131240275, 2131240276);
    }

    public final void m13460b(boolean z, boolean z2) {
        m13456a(z, z2, 2131240277, 2131240278);
    }

    public final void m13459a(final boolean z, boolean z2, @Nullable final VerificationFollowUpAction verificationFollowUpAction) {
        Object obj;
        if (verificationFollowUpAction == null || StringUtil.c(verificationFollowUpAction.f13262a) || !"chain".equals(verificationFollowUpAction.f13262a) || StringUtil.c(verificationFollowUpAction.f13263b) || StringUtil.c(verificationFollowUpAction.f13265d)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            AlertDialog a = new FbAlertDialogBuilder(this.f13168a).a(2131240279).b(verificationFollowUpAction.f13263b).a(verificationFollowUpAction.f13265d, new OnClickListener(this) {
                final /* synthetic */ PaymentMethodVerificationNuxDialogsHelper f13165b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (!StringUtil.a(verificationFollowUpAction.f13264c)) {
                        this.f13165b.f13170c.a(Uri.parse(verificationFollowUpAction.f13264c));
                    }
                }
            }).b(2131230727, new OnClickListener(this) {
                final /* synthetic */ PaymentMethodVerificationNuxDialogsHelper f13163b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (z) {
                        this.f13163b.f13169b.m14171a().show();
                    }
                }
            }).a();
            a.setOnCancelListener(new OnCancelListener(this) {
                final /* synthetic */ PaymentMethodVerificationNuxDialogsHelper f13167b;

                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    if (z) {
                        this.f13167b.f13169b.m14171a().show();
                    }
                }
            });
            a.show();
            return;
        }
        m13456a(z, z2, 2131240279, 2131240280);
    }

    private void m13456a(final boolean z, boolean z2, int i, int i2) {
        if (z2) {
            AlertDialog a = new FbAlertDialogBuilder(this.f13168a).a(i).b(i2).c(2131230726, new OnClickListener(this) {
                final /* synthetic */ PaymentMethodVerificationNuxDialogsHelper f13159b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (z) {
                        this.f13159b.f13169b.m14171a().show();
                    }
                }
            }).a();
            a.setOnCancelListener(new OnCancelListener(this) {
                final /* synthetic */ PaymentMethodVerificationNuxDialogsHelper f13161b;

                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    if (z) {
                        this.f13161b.f13169b.m14171a().show();
                    }
                }
            });
            a.show();
        } else if (z) {
            this.f13169b.m14171a().show();
        }
    }
}
