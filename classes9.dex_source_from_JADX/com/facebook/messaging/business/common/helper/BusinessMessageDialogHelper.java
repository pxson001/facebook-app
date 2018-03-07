package com.facebook.messaging.business.common.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: new AudioRecord illegal argument */
public class BusinessMessageDialogHelper {
    public final Context f8754a;

    /* compiled from: new AudioRecord illegal argument */
    class C09991 implements OnClickListener {
        final /* synthetic */ BusinessMessageDialogHelper f8752a;

        C09991(BusinessMessageDialogHelper businessMessageDialogHelper) {
            this.f8752a = businessMessageDialogHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: new AudioRecord illegal argument */
    public class C10002 implements OnClickListener {
        final /* synthetic */ BusinessMessageDialogHelper f8753a;

        public C10002(BusinessMessageDialogHelper businessMessageDialogHelper) {
            this.f8753a = businessMessageDialogHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static BusinessMessageDialogHelper m9018b(InjectorLike injectorLike) {
        return new BusinessMessageDialogHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BusinessMessageDialogHelper(Context context) {
        this.f8754a = context;
    }

    public final void m9019a() {
        m9020a(this.f8754a.getResources().getString(2131230758));
    }

    public final void m9020a(@Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            m9019a();
        } else {
            new FbAlertDialogBuilder(this.f8754a).b(str).a(this.f8754a.getResources().getString(2131236790), new C09991(this)).a(true).b();
        }
    }
}
