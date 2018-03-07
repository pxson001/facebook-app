package com.facebook.appirater.ratingdialog.screencontroller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.util.DeviceUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: crowdsourcing_place_question_value */
public class RateOnPlayStoreScreenController extends MessageScreenController {
    public final GooglePlayIntentHelper f16503a;
    public final SecureContextHelper f16504b;
    public final PackageManager f16505c;

    /* compiled from: crowdsourcing_place_question_value */
    class C13061 implements OnClickListener {
        final /* synthetic */ RateOnPlayStoreScreenController f16501a;

        C13061(RateOnPlayStoreScreenController rateOnPlayStoreScreenController) {
            this.f16501a = rateOnPlayStoreScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16501a.f16496a.a();
            AbstractAppiraterDialogScreenController abstractAppiraterDialogScreenController = this.f16501a;
            Context context = abstractAppiraterDialogScreenController.f16496a.getContext();
            String packageName = context.getPackageName();
            boolean b = abstractAppiraterDialogScreenController.f16503a.b();
            if (!DeviceUtil.a(abstractAppiraterDialogScreenController.f16505c, "com.amazon.venezia") || b) {
                abstractAppiraterDialogScreenController.f16503a.a(context, packageName);
                return;
            }
            Uri parse = Uri.parse("amzn://apps/android?p=" + packageName);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            abstractAppiraterDialogScreenController.f16504b.b(intent, context);
        }
    }

    /* compiled from: crowdsourcing_place_question_value */
    class C13072 implements OnClickListener {
        final /* synthetic */ RateOnPlayStoreScreenController f16502a;

        C13072(RateOnPlayStoreScreenController rateOnPlayStoreScreenController) {
            this.f16502a = rateOnPlayStoreScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16502a.f16496a.a();
        }
    }

    public static RateOnPlayStoreScreenController m20574b(InjectorLike injectorLike) {
        return new RateOnPlayStoreScreenController(GooglePlayIntentHelper.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RateOnPlayStoreScreenController(GooglePlayIntentHelper googlePlayIntentHelper, SecureContextHelper secureContextHelper, PackageManager packageManager) {
        this.f16503a = googlePlayIntentHelper;
        this.f16504b = secureContextHelper;
        this.f16505c = packageManager;
    }

    protected final void mo1287a(ImageView imageView, TextView textView) {
        imageView.setVisibility(0);
        textView.setText(2131238501);
    }

    public final void mo1286a(Context context, AlertDialog alertDialog) {
        alertDialog.a(-1, context.getString(2131238503), new C13061(this));
        alertDialog.a(-2, context.getString(2131238502), new C13072(this));
    }
}
