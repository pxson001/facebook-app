package com.facebook.appirater.ratingdialog.screencontroller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.appirater.InternalStarRatingController;
import com.facebook.appirater.api.FetchISRConfigResult;
import com.facebook.appirater.ratingdialog.AppiraterRatingDialogFragment.Screen;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.ratingbar.BetterRatingBar;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;
import javax.inject.Inject;

/* compiled from: crowdsourcing_place_question_submit_answer */
public class StarRatingScreenController extends AbstractAppiraterDialogScreenController implements RatingChangedListener {
    public static final String f16508a = (StarRatingScreenController.class.getSimpleName() + ".");
    public final InternalStarRatingController f16509b;
    public final AbstractFbErrorReporter f16510c;
    private TextView f16511d = null;
    public BetterRatingBar f16512e = null;
    private TextView f16513f = null;
    private boolean f16514g = false;

    /* compiled from: crowdsourcing_place_question_submit_answer */
    class C13081 implements OnClickListener {
        final /* synthetic */ StarRatingScreenController f16506a;

        C13081(StarRatingScreenController starRatingScreenController) {
            this.f16506a = starRatingScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            int i2 = this.f16506a.f16512e.f;
            if (i2 <= 0) {
                this.f16506a.f16510c.a(StarRatingScreenController.f16508a + "onPositiveButtonClicked", "Submit should only be clickable after a rating has been selected.");
                return;
            }
            AbstractAppiraterDialogScreenController abstractAppiraterDialogScreenController = this.f16506a;
            abstractAppiraterDialogScreenController.f16496a.s.putInt("rating", i2);
            FetchISRConfigResult d = abstractAppiraterDialogScreenController.f16509b.d();
            if (d == null || !d.m20544a()) {
                abstractAppiraterDialogScreenController.f16496a.m20560a(Screen.THANKS_FOR_FEEDBACK);
            } else if (i2 <= d.maxStarsForFeedback) {
                abstractAppiraterDialogScreenController.f16496a.m20560a(Screen.PROVIDE_FEEDBACK);
            } else if (i2 >= d.minStarsForStore) {
                abstractAppiraterDialogScreenController.f16496a.m20560a(Screen.RATE_ON_PLAY_STORE);
            } else {
                abstractAppiraterDialogScreenController.f16496a.m20560a(Screen.THANKS_FOR_FEEDBACK);
            }
        }
    }

    /* compiled from: crowdsourcing_place_question_submit_answer */
    class C13092 implements OnClickListener {
        final /* synthetic */ StarRatingScreenController f16507a;

        C13092(StarRatingScreenController starRatingScreenController) {
            this.f16507a = starRatingScreenController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16507a.f16496a.a();
        }
    }

    public static StarRatingScreenController m20577b(InjectorLike injectorLike) {
        return new StarRatingScreenController(InternalStarRatingController.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public StarRatingScreenController(InternalStarRatingController internalStarRatingController, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f16509b = internalStarRatingController;
        this.f16510c = abstractFbErrorReporter;
    }

    public final View mo1284a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2130903288, null, false);
        this.f16511d = (TextView) inflate.findViewById(2131559689);
        this.f16512e = (BetterRatingBar) inflate.findViewById(2131559691);
        this.f16513f = (TextView) inflate.findViewById(2131559690);
        m20578c(this.f16512e.f);
        this.f16512e.a(this);
        this.f16511d.setText(this.f16496a.jW_().getString(2131238494, new Object[]{this.f16496a.jW_().getString(2131230720)}));
        return inflate;
    }

    public final void mo1286a(Context context, AlertDialog alertDialog) {
        alertDialog.setTitle(2131238493);
        alertDialog.a(-1, context.getString(2131238491), new C13081(this));
        alertDialog.a(-2, context.getString(2131238492), new C13092(this));
    }

    public final void mo1285a() {
        this.f16511d = null;
        this.f16512e = null;
        super.mo1285a();
    }

    private void m20578c(int i) {
        if (this.f16513f != null) {
            switch (i) {
                case 1:
                    this.f16513f.setText(2131238504);
                    return;
                case 2:
                    this.f16513f.setText(2131238505);
                    return;
                case 3:
                    this.f16513f.setText(2131238506);
                    return;
                case 4:
                    this.f16513f.setText(2131238507);
                    return;
                case 5:
                    this.f16513f.setText(2131238508);
                    return;
                default:
                    this.f16513f.setText("____");
                    return;
            }
        }
    }

    public final void m20582a(int i, int i2) {
        m20578c(i2);
        if (!this.f16514g) {
            this.f16514g = true;
        }
    }

    public final void m20581a(int i) {
    }
}
