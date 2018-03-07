package com.facebook.rapidfeedback;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.structuredsurvey.items.SurveyEditTextItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyQuestionItem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import java.util.List;
import javax.inject.Inject;

/* compiled from: failure_local */
public class RapidFeedbackThanksDialogFragment extends FbDialogFragment {
    public static final String am = RapidFeedbackThanksDialogFragment.class.getSimpleName();
    @Inject
    public RapidFeedbackGatekeepers an;
    public View ao;
    public TextView ap;
    public TextView aq;
    public TextView ar;
    public RapidFeedbackController as;
    public List<SurveyItem> at;

    /* compiled from: failure_local */
    public class C10881 implements OnClickListener {
        final /* synthetic */ RapidFeedbackThanksDialogFragment f15366a;

        public C10881(RapidFeedbackThanksDialogFragment rapidFeedbackThanksDialogFragment) {
            this.f15366a = rapidFeedbackThanksDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1153217718);
            this.f15366a.a();
            this.f15366a.as.h();
            this.f15366a.as.a(ImpressionType.COMPLETE);
            this.f15366a.as.j();
            Logger.a(2, EntryType.UI_INPUT_END, 1057922683, a);
        }
    }

    /* compiled from: failure_local */
    public class C10892 implements OnClickListener {
        final /* synthetic */ RapidFeedbackThanksDialogFragment f15367a;

        public C10892(RapidFeedbackThanksDialogFragment rapidFeedbackThanksDialogFragment) {
            this.f15367a = rapidFeedbackThanksDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1813244035);
            RapidFeedbackThanksDialogFragment rapidFeedbackThanksDialogFragment = this.f15367a;
            rapidFeedbackThanksDialogFragment.a();
            RapidFeedbackFreeformFragment rapidFeedbackFreeformFragment = new RapidFeedbackFreeformFragment();
            rapidFeedbackFreeformFragment.ar = rapidFeedbackThanksDialogFragment.as;
            for (SurveyItem surveyItem : rapidFeedbackThanksDialogFragment.at) {
                if (surveyItem.f17165a == ItemType.EDITTEXT) {
                    rapidFeedbackFreeformFragment.au = (SurveyEditTextItem) surveyItem;
                } else if (surveyItem.f17165a == ItemType.QUESTION) {
                    rapidFeedbackFreeformFragment.av = (SurveyQuestionItem) surveyItem;
                }
            }
            rapidFeedbackFreeformFragment.a(rapidFeedbackThanksDialogFragment.D, RapidFeedbackFreeformFragment.am);
            Logger.a(2, EntryType.UI_INPUT_END, 1239224256, a);
        }
    }

    public static void m22993a(Object obj, Context context) {
        ((RapidFeedbackThanksDialogFragment) obj).an = RapidFeedbackGatekeepers.m22986b(FbInjector.get(context));
    }

    public final void m22994a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 480884307);
        super.a(bundle);
        Class cls = RapidFeedbackThanksDialogFragment.class;
        m22993a(this, getContext());
        d(true);
        if (this.an.m22987a()) {
            this.ao = LayoutInflater.from(getContext()).inflate(2130906577, new FrameLayout(getContext()), true);
        } else {
            this.ao = LayoutInflater.from(getContext()).inflate(2130906576, new LinearLayout(getContext()), false);
        }
        if (this.as != null) {
            this.at = ((StructuredSurveyController) this.as.d.get()).o();
            this.ap = (TextView) FindViewUtil.b(this.ao, 2131566555);
            this.ap.setText(((StructuredSurveyController) this.as.d.get()).C);
            this.ar = (TextView) FindViewUtil.b(this.ao, 2131566557);
            if (this.at != null) {
                this.ar.setVisibility(0);
                this.ar.setText(jW_().getString(2131236113));
                this.ar.setOnClickListener(new C10892(this));
            } else {
                this.ar.setVisibility(8);
            }
            OnClickListener c10881 = new C10881(this);
            this.aq = (TextView) FindViewUtil.b(this.ao, 2131566558);
            this.aq.setText(jW_().getString(2131230733));
            this.aq.setOnClickListener(c10881);
            if (this.an.m22987a()) {
                ((ImageView) FindViewUtil.b(this.ao, 2131566546)).setOnClickListener(c10881);
            }
        }
        LogUtils.f(159328709, a);
    }

    public final void m22996d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1553916346);
        super.d(bundle);
        if (this.as == null) {
            a();
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2088003785, a);
            return;
        }
        LogUtils.f(1331665446, a);
    }

    public final Dialog m22995c(Bundle bundle) {
        Builder builder = new Builder(getContext());
        if (this.as != null) {
            if (!(this.ao == null || this.ao.getParent() == null)) {
                ((ViewGroup) this.ao.getParent()).removeView(this.ao);
            }
            builder.a(this.ao, 0, 0, 0, 0);
        }
        AlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(false);
        d_(false);
        return a;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 974628474);
        if (this.f != null && this.M) {
            this.f.setDismissMessage(null);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -696533794, a);
    }
}
