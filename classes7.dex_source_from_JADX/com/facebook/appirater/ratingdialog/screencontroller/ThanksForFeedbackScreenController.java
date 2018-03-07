package com.facebook.appirater.ratingdialog.screencontroller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.fbui.dialog.AlertDialog;

/* compiled from: crowdsourcing_friend_vote_invite */
public class ThanksForFeedbackScreenController extends MessageScreenController {

    /* compiled from: crowdsourcing_friend_vote_invite */
    class C13101 implements OnClickListener {
        final /* synthetic */ ThanksForFeedbackScreenController f16515a;

        C13101(ThanksForFeedbackScreenController thanksForFeedbackScreenController) {
            this.f16515a = thanksForFeedbackScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16515a.f16496a.a();
        }
    }

    protected final void mo1287a(ImageView imageView, TextView textView) {
        imageView.setVisibility(8);
        textView.setText(2131238499);
    }

    public final void mo1286a(Context context, AlertDialog alertDialog) {
        alertDialog.a(-1, context.getString(2131238500), new C13101(this));
    }
}
