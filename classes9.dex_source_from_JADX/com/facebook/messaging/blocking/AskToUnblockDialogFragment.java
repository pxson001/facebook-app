package com.facebook.messaging.blocking;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: onSuccess with empty result or result.fbid */
public class AskToUnblockDialogFragment extends FbDialogFragment {
    @Inject
    public BlockingUtils am;
    @Inject
    public ErrorDialogs an;
    public User ao;
    public final OperationResultFutureCallback ap = new C09271(this);

    /* compiled from: onSuccess with empty result or result.fbid */
    class C09271 extends OperationResultFutureCallback {
        final /* synthetic */ AskToUnblockDialogFragment f8246a;

        C09271(AskToUnblockDialogFragment askToUnblockDialogFragment) {
            this.f8246a = askToUnblockDialogFragment;
        }

        protected final void m8492a(ServiceException serviceException) {
            this.f8246a.an.a(this.f8246a.an.a(serviceException));
        }
    }

    /* compiled from: onSuccess with empty result or result.fbid */
    class C09282 implements OnClickListener {
        final /* synthetic */ AskToUnblockDialogFragment f8247a;

        C09282(AskToUnblockDialogFragment askToUnblockDialogFragment) {
            this.f8247a = askToUnblockDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8247a.a();
        }
    }

    /* compiled from: onSuccess with empty result or result.fbid */
    class C09293 implements OnClickListener {
        final /* synthetic */ AskToUnblockDialogFragment f8248a;

        C09293(AskToUnblockDialogFragment askToUnblockDialogFragment) {
            this.f8248a = askToUnblockDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8248a.am.m8521c(this.f8248a.ao.a, this.f8248a.ap);
        }
    }

    public static void m8494a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AskToUnblockDialogFragment askToUnblockDialogFragment = (AskToUnblockDialogFragment) obj;
        BlockingUtils b = BlockingUtils.m8514b(fbInjector);
        ErrorDialogs a = ErrorDialogs.a(fbInjector);
        askToUnblockDialogFragment.am = b;
        askToUnblockDialogFragment.an = a;
    }

    public final Dialog m8495c(Bundle bundle) {
        Class cls = AskToUnblockDialogFragment.class;
        m8494a(this, getContext());
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ao = (User) bundle2.getParcelable("blockee");
        }
        Preconditions.checkNotNull(this.ao);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(2131240237).b(jW_().getString(2131240238, new Object[]{BlockingUtils.m8508a(this.ao)})).a(2131240240, new C09293(this)).b(2131240239, new C09282(this)).a(false);
        return fbAlertDialogBuilder.a();
    }
}
