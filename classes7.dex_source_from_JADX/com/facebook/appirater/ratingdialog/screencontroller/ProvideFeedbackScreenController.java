package com.facebook.appirater.ratingdialog.screencontroller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appirater.ratingdialog.AppiraterRatingDialogFragment.Screen;
import com.facebook.fbui.dialog.AlertDialog;
import javax.inject.Inject;

/* compiled from: crowdsourcing_place_questions_data */
public class ProvideFeedbackScreenController extends AbstractAppiraterDialogScreenController {
    private final InputMethodManager f16499a;
    public EditText f16500b = null;

    /* compiled from: crowdsourcing_place_questions_data */
    class C13041 implements OnClickListener {
        final /* synthetic */ ProvideFeedbackScreenController f16497a;

        C13041(ProvideFeedbackScreenController provideFeedbackScreenController) {
            this.f16497a = provideFeedbackScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ProvideFeedbackScreenController.m20570d(this.f16497a);
            Fragment fragment = this.f16497a.f16496a;
            fragment.s.putString("rating_comment", this.f16497a.f16500b.getText().toString());
            fragment.m20560a(Screen.THANKS_FOR_FEEDBACK);
        }
    }

    /* compiled from: crowdsourcing_place_questions_data */
    class C13052 implements OnClickListener {
        final /* synthetic */ ProvideFeedbackScreenController f16498a;

        C13052(ProvideFeedbackScreenController provideFeedbackScreenController) {
            this.f16498a = provideFeedbackScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ProvideFeedbackScreenController.m20570d(this.f16498a);
            this.f16498a.f16496a.a();
        }
    }

    @Inject
    public ProvideFeedbackScreenController(InputMethodManager inputMethodManager) {
        this.f16499a = inputMethodManager;
    }

    public final View mo1284a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2130903286, null, false);
        TextView textView = (TextView) inflate.findViewById(2131559685);
        this.f16500b = (EditText) inflate.findViewById(2131559686);
        textView.setText(2131238495);
        this.f16500b.setHint(2131238496);
        return inflate;
    }

    public final void mo1286a(Context context, AlertDialog alertDialog) {
        alertDialog.a(-1, context.getString(2131238498), new C13041(this));
        alertDialog.a(-2, context.getString(2131238497), new C13052(this));
    }

    public final void mo1285a() {
        this.f16500b = null;
        super.mo1285a();
    }

    public static void m20570d(ProvideFeedbackScreenController provideFeedbackScreenController) {
        if (provideFeedbackScreenController.f16500b != null) {
            provideFeedbackScreenController.f16499a.hideSoftInputFromWindow(provideFeedbackScreenController.f16500b.getWindowToken(), 0);
        }
    }
}
