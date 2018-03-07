package com.facebook.privacy.spinner;

import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.privacy.spinner.AudienceSpinner.AudienceExplanationDisplayMode;
import com.facebook.privacy.ui.PrivacyIcons;

/* compiled from: favorite_photos */
public class AudienceSpinnerAdapterProvider extends AbstractAssistedProvider<AudienceSpinnerAdapter> {
    public final AudienceSpinnerAdapter m22944a(AudienceSpinnerData audienceSpinnerData, AudienceExplanationDisplayMode audienceExplanationDisplayMode, String str) {
        return new AudienceSpinnerAdapter(LayoutInflaterMethodAutoProvider.b(this), PrivacyIcons.m22956a(this), ResourcesMethodAutoProvider.a(this), GlyphColorizer.a(this), audienceSpinnerData, audienceExplanationDisplayMode, str);
    }
}
