package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionSegmentedProgressBarComponentFragment.ProgressSegments;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionSegmentedProgressBarComponentFragmentModel.ProgressSegmentsModel;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: searchSessionKey */
public class SegmentedProgressBarComponentView extends CustomLinearLayout {
    private static final String f2236b = SegmentedProgressBarComponentView.class.getSimpleName();
    @Inject
    public AbstractFbErrorReporter f2237a;

    public static void m3186a(Object obj, Context context) {
        ((SegmentedProgressBarComponentView) obj).f2237a = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    public SegmentedProgressBarComponentView(Context context) {
        super(context);
        Class cls = SegmentedProgressBarComponentView.class;
        m3186a((Object) this, getContext());
        setOrientation(0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131427425));
        layoutParams.setMargins(getResources().getDimensionPixelSize(2131431415), 0, getResources().getDimensionPixelSize(2131431415), 0);
        setLayoutParams(layoutParams);
    }

    public final void m3187a(ImmutableList<? extends ProgressSegments> immutableList, OnClickListener onClickListener) {
        int i;
        boolean z;
        removeAllViews();
        int i2 = 0;
        for (i = 0; i < immutableList.size(); i++) {
            i2 += ((ProgressSegmentsModel) immutableList.get(i)).b();
        }
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        setOnClickListener(onClickListener);
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            ProgressSegmentsModel progressSegmentsModel = (ProgressSegmentsModel) immutableList.get(i);
            try {
                int parseColor = Color.parseColor("#" + progressSegmentsModel.a());
                View view = new View(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = ((float) progressSegmentsModel.b()) / ((float) i2);
                layoutParams.setMargins(0, getResources().getDimensionPixelSize(2131427379), 0, getResources().getDimensionPixelSize(2131427379));
                view.setLayoutParams(layoutParams);
                CustomViewUtils.b(view, new ColorDrawable(parseColor));
                addView(view);
            } catch (Throwable e) {
                this.f2237a.a(f2236b, "Failed to parse segmented progress bar style background color", e);
            }
        }
    }
}
