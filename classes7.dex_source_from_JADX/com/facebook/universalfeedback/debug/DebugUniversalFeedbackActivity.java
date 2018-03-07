package com.facebook.universalfeedback.debug;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.DeliveryType;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.ExperienceType;
import com.facebook.inject.FbInjector;
import com.facebook.universalfeedback.UniversalFeedbackContextBuilder;
import com.facebook.universalfeedback.UniversalFeedbackController;
import com.facebook.universalfeedback.UniversalFeedbackController.ResultListener;
import javax.inject.Inject;

/* compiled from: educatorType */
public class DebugUniversalFeedbackActivity extends FbFragmentActivity {
    private UniversalFeedbackController f15358p;

    /* compiled from: educatorType */
    class C11551 implements ResultListener {
        final /* synthetic */ DebugUniversalFeedbackActivity f15357a;

        C11551(DebugUniversalFeedbackActivity debugUniversalFeedbackActivity) {
            this.f15357a = debugUniversalFeedbackActivity;
        }

        public final void mo1188a() {
            Toast.makeText(this.f15357a, "Universal Feedback Completed!", 0).show();
            this.f15357a.finish();
        }

        public final void mo1189b() {
            Toast.makeText(this.f15357a, "Universal Feedback CANCELLED!", 0).show();
            this.f15357a.finish();
        }
    }

    private static <T extends Context> void m19355a(Class<T> cls, T t) {
        m19356a((Object) t, (Context) t);
    }

    public static void m19356a(Object obj, Context context) {
        ((DebugUniversalFeedbackActivity) obj).m19354a(UniversalFeedbackController.m19350b(FbInjector.get(context)));
    }

    protected final void m19358b(Bundle bundle) {
        super.b(bundle);
        m19357i();
        Class cls = DebugUniversalFeedbackActivity.class;
        m19356a((Object) this, (Context) this);
        if (bundle == null) {
            String string = getIntent().getExtras().getString("args_feedback_id");
            if (string != null && !string.equals("UNKNOWN")) {
                UniversalFeedbackContextBuilder universalFeedbackContextBuilder = new UniversalFeedbackContextBuilder(ExperienceType.NFX_FEEDBACK, DeliveryType.SYSTEM_TEST);
                universalFeedbackContextBuilder.f15343c = string;
                this.f15358p.m19351a(universalFeedbackContextBuilder, kO_());
            }
        }
    }

    @Inject
    private void m19354a(UniversalFeedbackController universalFeedbackController) {
        this.f15358p = universalFeedbackController;
        this.f15358p.f15356k = new C11551(this);
    }

    private View m19357i() {
        View linearLayout = new LinearLayout(this);
        setContentView(linearLayout, new LayoutParams(-1, -1));
        return linearLayout;
    }
}
