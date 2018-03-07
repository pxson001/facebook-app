package com.facebook.rapidfeedback.debug;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.View;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: fail */
public class RapidFeedbackPreferencesLauncher extends Preference {
    public final Context f15406a;
    public final SecureContextHelper f15407b;

    /* compiled from: fail */
    class C10931 implements OnPreferenceClickListener {
        final /* synthetic */ RapidFeedbackPreferencesLauncher f15405a;

        C10931(RapidFeedbackPreferencesLauncher rapidFeedbackPreferencesLauncher) {
            this.f15405a = rapidFeedbackPreferencesLauncher;
        }

        public boolean onPreferenceClick(Preference preference) {
            RapidFeedbackPreferencesLauncher rapidFeedbackPreferencesLauncher = this.f15405a;
            rapidFeedbackPreferencesLauncher.f15407b.a(new Intent(rapidFeedbackPreferencesLauncher.f15406a, RapidFeedbackPreferencesActivity.class), rapidFeedbackPreferencesLauncher.f15406a);
            return true;
        }
    }

    public static RapidFeedbackPreferencesLauncher m23026a(InjectorLike injectorLike) {
        return new RapidFeedbackPreferencesLauncher((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public RapidFeedbackPreferencesLauncher(Context context, SecureContextHelper secureContextHelper) {
        super(context);
        this.f15406a = context;
        this.f15407b = secureContextHelper;
        setTitle("Rapid Feedback Settings");
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        setOnPreferenceClickListener(new C10931(this));
    }
}
