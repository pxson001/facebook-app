package com.facebook.feed.fragment;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.infer.annotation.NoAllocation;
import com.facebook.infer.annotation.PerformanceCritical;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.activity.FbMainTabActivity.C03578;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import javax.inject.Inject;

/* compiled from: significant_accuracy_improvement_ratio */
public class NewsFeedFragmentDsmController extends BaseController implements ResumePauseCallbacks, ScrollCallback {
    private View f4762a;
    private TextView f4763b;
    private ViewStub f4764c;
    private C03578 f4765d;
    public final DataSensitivitySettingsPrefUtil f4766e;
    public final FbUriIntentHandler f4767f;
    public Holder<FbFragment> f4768g;
    private Resources f4769h;

    public static NewsFeedFragmentDsmController m8592a(InjectorLike injectorLike) {
        return new NewsFeedFragmentDsmController(DataSensitivitySettingsPrefUtil.m8604a(injectorLike), FbUriIntentHandler.m8626a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public NewsFeedFragmentDsmController(DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil, FbUriIntentHandler fbUriIntentHandler, Resources resources) {
        this.f4766e = dataSensitivitySettingsPrefUtil;
        this.f4767f = fbUriIntentHandler;
        this.f4769h = resources;
    }

    public final void mo1264c() {
        m8593e();
    }

    public final void mo1265d() {
    }

    @NoAllocation
    @PerformanceCritical
    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            m8593e();
        }
    }

    public final void m8594a(ViewStub viewStub) {
        this.f4764c = viewStub;
    }

    public final void m8595a(C03578 c03578) {
        this.f4765d = c03578;
    }

    private void m8593e() {
        if (this.f4764c != null) {
            IndicatorState indicatorState;
            if (this.f4762a == null) {
                if (this.f4766e.m8608a(false)) {
                    this.f4762a = this.f4764c.inflate();
                    this.f4763b = (TextView) this.f4762a.findViewById(2131561076);
                    TextView textView = (TextView) this.f4762a.findViewById(2131561077);
                    this.f4763b.setCompoundDrawablesWithIntrinsicBounds(this.f4769h.getDrawable(2130838460), null, null, null);
                    this.f4763b.setText(2131233822);
                    textView.setText(2131233824);
                    textView.setOnClickListener(new 1(this));
                } else {
                    return;
                }
            }
            int visibility = this.f4762a.getVisibility();
            if (!this.f4766e.m8608a(false)) {
                indicatorState = IndicatorState.DSM_INDICATOR_DISABLED;
            } else if (this.f4766e.m8609b(false)) {
                indicatorState = IndicatorState.DSM_INDICATOR_ENABLED_ON_STATE;
            } else {
                indicatorState = IndicatorState.DSM_INDICATOR_ENABLED_OFF_STATE;
            }
            IndicatorState indicatorState2 = indicatorState;
            if (IndicatorState.DSM_INDICATOR_DISABLED != indicatorState2) {
                if (IndicatorState.DSM_INDICATOR_ENABLED_ON_STATE == indicatorState2) {
                    this.f4763b.setText(2131233822);
                } else {
                    this.f4763b.setText(2131233823);
                }
                this.f4762a.setVisibility(0);
            } else {
                this.f4762a.setVisibility(8);
            }
            if (this.f4765d != null && visibility != this.f4762a.getVisibility()) {
                this.f4765d.m12830a();
            }
        }
    }
}
