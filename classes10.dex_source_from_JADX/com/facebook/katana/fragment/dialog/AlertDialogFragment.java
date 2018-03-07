package com.facebook.katana.fragment.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.fbui.dialog.AlertDialog.Builder;

/* compiled from: updateRecentlyUsedStickerDataItem */
public class AlertDialogFragment extends DialogFragment {

    /* compiled from: updateRecentlyUsedStickerDataItem */
    class C01481 implements OnClickListener {
        final /* synthetic */ AlertDialogFragment f934a;

        C01481(AlertDialogFragment alertDialogFragment) {
            this.f934a = alertDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public final Dialog m981c(Bundle bundle) {
        return new Builder(getContext()).b(this.s.getInt("message_res_id")).a(2131230756, new C01481(this)).a();
    }
}
