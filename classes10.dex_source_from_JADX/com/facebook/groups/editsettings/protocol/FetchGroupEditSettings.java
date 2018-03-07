package com.facebook.groups.editsettings.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettingsModels.FBGroupEditSettingsMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unable to retrieve assets */
public final class FetchGroupEditSettings {

    /* compiled from: Unable to retrieve assets */
    public class FBGroupEditSettingsMutationString extends TypedGraphQLMutationString<FBGroupEditSettingsMutationModel> {
        public FBGroupEditSettingsMutationString() {
            super(FBGroupEditSettingsMutationModel.class, false, "FBGroupEditSettingsMutation", "d7a7064926009f5692c56fa008cf6ba8", "group_edit", "0", "10154204803436729", RegularImmutableSet.a);
        }

        public final String m22644a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FBGroupEditSettingsMutationString m22645a() {
        return new FBGroupEditSettingsMutationString();
    }
}
