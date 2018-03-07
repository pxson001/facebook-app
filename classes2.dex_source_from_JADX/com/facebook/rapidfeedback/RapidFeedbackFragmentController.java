package com.facebook.rapidfeedback;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.base.fragment.FbFragment;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: photo_clicked_hot */
public class RapidFeedbackFragmentController extends BaseController implements ActivityResultCallback {
    private final Lazy<RapidFeedbackController> f10079a;
    public Holder<FbFragment> f10080b;

    public static RapidFeedbackFragmentController m15166a(InjectorLike injectorLike) {
        return new RapidFeedbackFragmentController(IdBasedLazy.m1808a(injectorLike, 3253));
    }

    @Inject
    public RapidFeedbackFragmentController(Lazy<RapidFeedbackController> lazy) {
        this.f10079a = lazy;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (intent != null && intent.hasExtra("try_show_survey_on_result_integration_point_id")) {
            String stringExtra = intent.getStringExtra("try_show_survey_on_result_integration_point_id");
            Parcelable parcelableExtra = intent.getParcelableExtra("try_show_survey_on_result_extra_data");
            if (parcelableExtra instanceof Bundle) {
                ((RapidFeedbackController) this.f10079a.get()).m14993a((Bundle) parcelableExtra);
            }
            ((RapidFeedbackController) this.f10079a.get()).m14997a(stringExtra, ((FbFragment) this.f10080b.f10429a).ao());
        }
    }
}
