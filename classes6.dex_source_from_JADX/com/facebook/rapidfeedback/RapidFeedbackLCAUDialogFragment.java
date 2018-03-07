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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rapidfeedback.abtest.ExperimentsForRapidFeedbackAbtestModule;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionExtra;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyQuestionItem;
import com.facebook.structuredsurvey.items.SurveyRadioItem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fake photo publish break */
public class RapidFeedbackLCAUDialogFragment extends FbDialogFragment {
    public static final String am = RapidFeedbackLCAUDialogFragment.class.getSimpleName();
    @Inject
    public QeAccessor an;
    @Inject
    public RapidFeedbackGatekeepers ao;
    @Inject
    public ScreenUtil ap;
    public View aq;
    public TextView ar;
    public TextView as;
    private TextView at;
    private CustomLinearLayout au;
    public RapidFeedbackController av;
    public List<SurveyItem> aw;

    public static void m22989a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RapidFeedbackLCAUDialogFragment rapidFeedbackLCAUDialogFragment = (RapidFeedbackLCAUDialogFragment) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        RapidFeedbackGatekeepers b = RapidFeedbackGatekeepers.m22986b(fbInjector);
        ScreenUtil a = ScreenUtil.a(fbInjector);
        rapidFeedbackLCAUDialogFragment.an = qeAccessor;
        rapidFeedbackLCAUDialogFragment.ao = b;
        rapidFeedbackLCAUDialogFragment.ap = a;
    }

    public final void m22990a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 641069115);
        super.a(bundle);
        Class cls = RapidFeedbackLCAUDialogFragment.class;
        m22989a((Object) this, getContext());
        d(true);
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2042277818, a);
    }

    public final Dialog m22991c(Bundle bundle) {
        Builder builder = new Builder(getContext());
        if (this.av != null) {
            if (!(this.aq == null || this.aq.getParent() == null)) {
                ((ViewGroup) this.aq.getParent()).removeView(this.aq);
            }
            if (this.ao.m22987a()) {
                builder.a(this.aq, 0, 0, 0, 0);
            } else {
                builder.b(this.aq);
            }
        }
        AlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(false);
        d_(false);
        return a;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 684064764);
        if (this.f != null && this.M) {
            this.f.setDismissMessage(null);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1046799958, a);
    }

    public final void m22992d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -981040811);
        super.d(bundle);
        if (this.av == null) {
            a();
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 629759836, a);
            return;
        }
        LogUtils.f(1494811412, a);
    }

    private void aq() {
        if (this.av != null) {
            if (this.ao.m22987a()) {
                this.aq = LayoutInflater.from(getContext()).inflate(2130906573, new FrameLayout(getContext()), true);
            } else {
                this.aq = LayoutInflater.from(getContext()).inflate(2130906572, new LinearLayout(getContext()), false);
            }
            this.aw = ((StructuredSurveyController) this.av.d.get()).n();
            if (this.aw == null || this.aw.isEmpty()) {
                a();
                return;
            }
            this.ar = (TextView) FindViewUtil.b(this.aq, 2131566542);
            this.ar.setText(((StructuredSurveyController) this.av.d.get()).B);
            this.as = (TextView) FindViewUtil.b(this.aq, 2131566543);
            this.as.setText(((SurveyQuestionItem) this.aw.get(0)).f17175d);
            at();
            av();
            this.av.a("screen_width", String.valueOf(this.ap.c()));
            this.av.a("screen_height", String.valueOf(this.ap.d()));
            this.av.a(ImpressionType.IMPRESSION);
        }
    }

    private void at() {
        this.au = (CustomLinearLayout) FindViewUtil.b(this.aq, 2131566544);
        this.au.addView(au());
        for (SurveyItem surveyItem : this.aw) {
            if (surveyItem.f17165a != ItemType.QUESTION) {
                final SurveyRadioItem surveyRadioItem = (SurveyRadioItem) surveyItem;
                View textView = new TextView(getContext());
                textView.setText(surveyRadioItem.mo1294a().f17112c);
                textView.setTextSize((float) SizeUtil.c(jW_(), 2131427404));
                textView.setTextColor(jW_().getColor(2131361917));
                textView.setBackgroundResource(2130842865);
                textView.setPadding(0, jW_().getDimensionPixelSize(2131427416), 0, jW_().getDimensionPixelSize(2131427416));
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ RapidFeedbackLCAUDialogFragment f15363b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1854152363);
                        RapidFeedbackLCAUDialogFragment rapidFeedbackLCAUDialogFragment = this.f15363b;
                        surveyRadioItem.m24932a(Boolean.valueOf(true));
                        rapidFeedbackLCAUDialogFragment.av.g();
                        this.f15363b.a();
                        RapidFeedbackThanksDialogFragment rapidFeedbackThanksDialogFragment = new RapidFeedbackThanksDialogFragment();
                        rapidFeedbackThanksDialogFragment.as = this.f15363b.av;
                        rapidFeedbackThanksDialogFragment.a(this.f15363b.D, RapidFeedbackThanksDialogFragment.am);
                        this.f15363b.av.a(ImpressionType.START);
                        Logger.a(2, EntryType.UI_INPUT_END, 430572149, a);
                    }
                });
                this.au.addView(textView);
                this.au.addView(au());
            }
        }
    }

    private View au() {
        View view = new View(getContext());
        view.setLayoutParams(new LayoutParams(-1, jW_().getDimensionPixelSize(2131430734)));
        view.setBackgroundResource(2131361986);
        return view;
    }

    private void av() {
        this.at = (TextView) FindViewUtil.b(this.aq, 2131566545);
        this.at.setText(jW_().getString(2131236112));
        m22988a(this.at, ImpressionExtra.CLICK_CLOSS_BUTTON);
        if (this.ao.m22987a()) {
            View view = (ImageView) FindViewUtil.b(this.aq, 2131566546);
            m22988a(view, ImpressionExtra.CLICK_CROSS_OUT);
            if (!this.an.a(ExperimentsForRapidFeedbackAbtestModule.f15369b, true)) {
                view.setVisibility(8);
            }
            if (!this.an.a(ExperimentsForRapidFeedbackAbtestModule.f15368a, true)) {
                int dimension = (int) jW_().getDimension(2131430731);
                this.au.setPadding(dimension, dimension, dimension, dimension);
                this.at.setVisibility(8);
            }
        }
    }

    private void m22988a(View view, final ImpressionExtra impressionExtra) {
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RapidFeedbackLCAUDialogFragment f15365b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 558549945);
                this.f15365b.a();
                this.f15365b.av.a(impressionExtra);
                this.f15365b.av.j();
                Logger.a(2, EntryType.UI_INPUT_END, 1083672355, a);
            }
        });
    }
}
