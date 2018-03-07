package com.facebook.crowdsourcing.feather.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.internal.ImmutableList;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionStackView;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionView;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionViewController;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionViewController.PlaceQuestionInteractionListener;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLPlaceQuestionOrientation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.zero.ZERO_HEADER_REFRESH_COMPLETED */
public class FeatherStackView extends PlaceQuestionStackView {
    private static final CrowdsourcingContext f17409e = new CrowdsourcingContext(CrowdEntryPoint.FEATHER_POST_COMPOSE, CrowdEndpoint.FEATHER);
    @Inject
    public FunnelLoggerImpl f17410a;
    @Inject
    public SuggestEditsAnalyticsLogger f17411b;
    @Inject
    public PlaceQuestionViewController f17412c;
    private ImmutableList<PlaceQuestionFieldsModel> f17413f;
    private String f17414g;

    private static <T extends View> void m21304a(Class<T> cls, T t) {
        m21305a((Object) t, t.getContext());
    }

    private static void m21305a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FeatherStackView featherStackView = (FeatherStackView) obj;
        FunnelLoggerImpl a = FunnelLoggerImpl.a(injectorLike);
        SuggestEditsAnalyticsLogger a2 = SuggestEditsAnalyticsLogger.a(injectorLike);
        PlaceQuestionViewController b = PlaceQuestionViewController.m21435b(injectorLike);
        featherStackView.f17410a = a;
        featherStackView.f17411b = a2;
        featherStackView.f17412c = b;
    }

    public FeatherStackView(Context context) {
        super(context);
        m21304a(FeatherStackView.class, (View) this);
    }

    public FeatherStackView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m21304a(FeatherStackView.class, (View) this);
    }

    protected FeatherStackView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21304a(FeatherStackView.class, (View) this);
    }

    public final void m21307a(String str, ImmutableList<PlaceQuestionFieldsModel> immutableList) {
        this.f17414g = str;
        this.f17413f = immutableList;
        m21299a();
    }

    protected final View mo1358a(int i) {
        if (i >= this.f17413f.size()) {
            return new FeatherThankYouView(getContext());
        }
        PlaceQuestionFieldsModel placeQuestionFieldsModel = (PlaceQuestionFieldsModel) this.f17413f.get(i);
        PlaceQuestionView placeQuestionView = new PlaceQuestionView(getContext());
        this.f17412c.m21437a(placeQuestionView, placeQuestionFieldsModel, placeQuestionFieldsModel.ep_() == GraphQLPlaceQuestionOrientation.VERTICAL ? 1 : 0, (PlaceQuestionInteractionListener) this);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LayoutParams(-1, -2));
        frameLayout.setPadding(0, getResources().getDimensionPixelSize(2131432728), 0, 0);
        CustomViewUtils.b(frameLayout, new ColorDrawable(-1));
        frameLayout.addView(placeQuestionView);
        return frameLayout;
    }

    protected int getNumQuestions() {
        return this.f17413f.size() + 1;
    }

    protected final void mo1359b(int i) {
        this.f17410a.b(FunnelRegistry.S, "next_card");
        if (i >= this.f17413f.size()) {
            this.f17410a.b(FunnelRegistry.S, "thank_you");
            this.f17411b.a(CrowdEntryPoint.FEATHER_SUGGEST_EDITS_UPSELL, Optional.of(this.f17414g));
            return;
        }
        this.f17411b.a(f17409e, this.f17414g, ((PlaceQuestionFieldsModel) this.f17413f.get(i)).m2462b());
    }
}
