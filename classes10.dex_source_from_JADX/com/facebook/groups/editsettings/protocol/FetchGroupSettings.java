package com.facebook.groups.editsettings.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unable to parse datamap from dataItem. uri= */
public final class FetchGroupSettings {

    /* compiled from: Unable to parse datamap from dataItem. uri= */
    public class FetchGroupSettingsString extends TypedGraphQlQueryString<FetchGroupSettingsModel> {
        public FetchGroupSettingsString() {
            super(FetchGroupSettingsModel.class, false, "FetchGroupSettings", "6eb1e6779c871512991330ec9c73cfb6", "group_address", "10154624410821729", RegularImmutableSet.a);
        }

        public final String m22697a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                case 614886837:
                    return "1";
                case 1708927385:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
