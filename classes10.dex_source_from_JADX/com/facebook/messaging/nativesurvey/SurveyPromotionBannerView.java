package com.facebook.messaging.nativesurvey;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackConstants.RapidFeedbackTheme;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ViewStubHolder;
import javax.inject.Inject;

/* compiled from: rootID */
public class SurveyPromotionBannerView extends CustomLinearLayout {
    @Inject
    public RapidFeedbackController f3342a;
    @Inject
    public AbstractFbErrorReporter f3343b;
    public ViewGroup f3344c;
    private TextView f3345d;
    private TextView f3346e;
    public View f3347f;
    private View f3348g;
    private ViewStubHolder<ImageView> f3349h;

    private static <T extends View> void m3259a(Class<T> cls, T t) {
        m3260a((Object) t, t.getContext());
    }

    private static void m3260a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SurveyPromotionBannerView surveyPromotionBannerView = (SurveyPromotionBannerView) obj;
        RapidFeedbackController b = RapidFeedbackController.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        surveyPromotionBannerView.f3342a = b;
        surveyPromotionBannerView.f3343b = abstractFbErrorReporter;
    }

    public SurveyPromotionBannerView(Context context) {
        super(context);
        m3258a();
    }

    public SurveyPromotionBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3258a();
    }

    public SurveyPromotionBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3258a();
    }

    private void m3258a() {
        m3259a(SurveyPromotionBannerView.class, (View) this);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{2130772873});
        setContentView(2130904587);
        setBackgroundDrawable(new ColorDrawable(obtainStyledAttributes.getColor(0, 2131362531)));
        setOrientation(1);
        obtainStyledAttributes.recycle();
        this.f3344c = (ViewGroup) a(2131562520);
        this.f3347f = a(2131562526);
        this.f3345d = (TextView) a(2131559946);
        this.f3346e = (TextView) a(2131562528);
        this.f3348g = a(2131562527);
        this.f3349h = ViewStubHolder.a((ViewStubCompat) a(2131562524), 2130905371);
        m3262b();
    }

    private void m3262b() {
        this.f3345d.setText(getResources().getString(2131241318));
        this.f3346e.setText(getResources().getString(2131241319));
        this.f3348g.setVisibility(0);
        this.f3349h.f();
    }

    public void setupSurveyParams(OnClickListener onClickListener) {
        setupOnClickListeners(onClickListener);
    }

    private void setupOnClickListeners(final OnClickListener onClickListener) {
        this.f3344c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SurveyPromotionBannerView f3339b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1599740818);
                if (this.f3339b.f3342a.a("1409550936017447")) {
                    this.f3339b.f3342a.b("1409550936017447", this.f3339b.getContext(), RapidFeedbackTheme.MESSENGER);
                } else {
                    Toast makeText = Toast.makeText(this.f3339b.getContext(), 2131241320, 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                    this.f3339b.f3343b.a("SurveyPromotionBannerView_Uninitialized_Controller", "Trying to launch survey with an uninitialized controller");
                }
                onClickListener.onClick(this.f3339b.f3344c);
                LogUtils.a(744395147, a);
            }
        });
        this.f3347f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SurveyPromotionBannerView f3341b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 762107460);
                onClickListener.onClick(this.f3341b.f3347f);
                this.f3341b.f3342a.j();
                Logger.a(2, EntryType.UI_INPUT_END, -2109815298, a);
            }
        });
    }
}
