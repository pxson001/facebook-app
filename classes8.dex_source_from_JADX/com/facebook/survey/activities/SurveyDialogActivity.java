package com.facebook.survey.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.survey.util.SurveyUtil;

/* compiled from: me/group_threads */
public class SurveyDialogActivity extends FbFragmentActivity {

    /* compiled from: me/group_threads */
    class C09342 implements OnClickListener {
        final /* synthetic */ SurveyDialogActivity f9042a;

        C09342(SurveyDialogActivity surveyDialogActivity) {
            this.f9042a = surveyDialogActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f9042a.finish();
        }
    }

    protected final void m10792b(Bundle bundle) {
        super.b(bundle);
        final SurveyUtil b = SurveyUtil.m10800b(hz_());
        final long longExtra = getIntent().getLongExtra("survey_id", -1);
        new Builder(this).a("Take Survey").c("Close", new C09342(this)).a("Take survey", new OnClickListener(this) {
            final /* synthetic */ SurveyDialogActivity f9041c;

            public void onClick(DialogInterface dialogInterface, int i) {
                b.m10801a(longExtra, this.f9041c);
                b.f9045b.edit().putBoolean((PrefKey) SurveyUtil.f9043c.a(String.valueOf(longExtra)), true).commit();
            }
        }).b("Take this survey!").a().show();
    }
}
