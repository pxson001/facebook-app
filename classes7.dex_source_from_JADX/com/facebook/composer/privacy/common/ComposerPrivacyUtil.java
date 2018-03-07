package com.facebook.composer.privacy.common;

import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.privacy.model.SelectablePrivacyData;
import javax.annotation.Nullable;

/* compiled from: tapped_save_place */
public class ComposerPrivacyUtil {
    @Nullable
    public static GraphQLPrivacyOption m1948b(ComposerPrivacyData composerPrivacyData) {
        SelectablePrivacyData selectablePrivacyData = composerPrivacyData.f2001b;
        return selectablePrivacyData == null ? null : selectablePrivacyData.d;
    }
}
