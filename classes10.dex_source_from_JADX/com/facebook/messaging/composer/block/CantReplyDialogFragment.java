package com.facebook.messaging.composer.block;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.inject.Inject;

/* compiled from: thread-key- */
public class CantReplyDialogFragment extends FbDialogFragment {
    @Inject
    public SecureContextHelper am;

    /* compiled from: thread-key- */
    class C02741 implements OnClickListener {
        final /* synthetic */ CantReplyDialogFragment f1711a;

        C02741(CantReplyDialogFragment cantReplyDialogFragment) {
            this.f1711a = cantReplyDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1711a.a();
        }
    }

    /* compiled from: thread-key- */
    class C02752 implements OnClickListener {
        final /* synthetic */ CantReplyDialogFragment f1712a;

        C02752(CantReplyDialogFragment cantReplyDialogFragment) {
            this.f1712a = cantReplyDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Uri parse = Uri.parse("https://www.facebook.com/help/314046672118572");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            this.f1712a.am.b(intent, this.f1712a.getContext());
            this.f1712a.b();
        }
    }

    public static void m1695a(Object obj, Context context) {
        ((CantReplyDialogFragment) obj).am = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public final void m1696a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 131656624);
        super.a(bundle);
        Class cls = CantReplyDialogFragment.class;
        m1695a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -383303236, a);
    }

    public final Dialog m1697c(Bundle bundle) {
        return new FbAlertDialogBuilder(getContext()).b(2131241188).c(2131241190, new C02752(this)).a(17039370, new C02741(this)).a();
    }
}
