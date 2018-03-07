package com.facebook.identitygrowth.profilequestion.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.InferenceWithExplanationFragmentModel;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: mIsMessengerUser */
public class ProfileQuestionInferenceOptionItem extends ProfileQuestionOptionItem {
    public ProfileQuestionInferenceOptionItem(Context context) {
        this(context, null);
    }

    private ProfileQuestionInferenceOptionItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772583);
    }

    public ProfileQuestionInferenceOptionItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setThumbnailSize(ThumbnailSize.MEDIUM);
    }

    @Nonnull
    public String getOptionType() {
        return "page";
    }

    public void setInferenceData(@Nullable InferenceWithExplanationFragmentModel inferenceWithExplanationFragmentModel) {
        if (inferenceWithExplanationFragmentModel == null || inferenceWithExplanationFragmentModel.m17981b() == null || inferenceWithExplanationFragmentModel.m17982c() == null || StringUtil.a(inferenceWithExplanationFragmentModel.m17981b().m17971c())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!(inferenceWithExplanationFragmentModel.m17979a() == null || StringUtil.a(inferenceWithExplanationFragmentModel.m17979a().a()))) {
            setSubtitleText(inferenceWithExplanationFragmentModel.m17979a().a());
        }
        if (!(inferenceWithExplanationFragmentModel.m17981b().m17972d() == null || StringUtil.a(inferenceWithExplanationFragmentModel.m17981b().m17972d().m17954a()))) {
            setThumbnailUri(Uri.parse(inferenceWithExplanationFragmentModel.m17981b().m17972d().m17954a()));
        }
        setTitle(inferenceWithExplanationFragmentModel);
        String b = inferenceWithExplanationFragmentModel.m17981b().m17970b();
        this.f11050h = b;
        if (b == null) {
            setVisibility(8);
        }
    }

    protected void setTitle(@Nonnull InferenceWithExplanationFragmentModel inferenceWithExplanationFragmentModel) {
        setTitleText(inferenceWithExplanationFragmentModel.m17981b().m17971c());
    }
}
