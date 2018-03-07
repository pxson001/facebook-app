package com.facebook.identitygrowth.profilequestion.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.InferenceWithExplanationFragmentModel;

/* compiled from: mIgnoreSurveyId */
public class ProfileQuestionSingleInferenceOptionItem extends ProfileQuestionInferenceOptionItem {
    public ProfileQuestionSingleInferenceOptionItem(Context context) {
        this(context, null);
    }

    private ProfileQuestionSingleInferenceOptionItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772583);
    }

    private ProfileQuestionSingleInferenceOptionItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setCheckMarkDrawable(null);
    }

    protected void setTitle(InferenceWithExplanationFragmentModel inferenceWithExplanationFragmentModel) {
        setTitleText(inferenceWithExplanationFragmentModel.m17982c().a());
    }
}
