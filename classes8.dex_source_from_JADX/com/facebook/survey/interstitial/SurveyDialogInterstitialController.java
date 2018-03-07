package com.facebook.survey.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.survey.activities.SurveyDialogActivity;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: me/blacklisted_gysj_groups */
public class SurveyDialogInterstitialController implements InterstitialIntentController {
    public final Optional<Intent> m10795a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    public final String m10798b() {
        return "1803";
    }

    public final void m10797a(Parcelable parcelable) {
    }

    public final void m10796a(long j) {
    }

    public final InterstitialControllerState m10794a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m10799c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SESSION_COLD_START), new InterstitialTrigger(Action.APP_FOREGROUND));
    }

    public final Intent m10793a(Context context) {
        Intent intent = new Intent(context, SurveyDialogActivity.class);
        intent.putExtra("survey_id", 120180274851115L);
        return intent;
    }

    public final long hI_() {
        return 86400000;
    }
}
