package com.facebook.backgroundlocation.reporting.graphql;

import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLModels.FetchBackgroundLocationReportingSettingsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: is_voicemail */
public final class BackgroundLocationReportingGraphQL {

    /* compiled from: is_voicemail */
    public class FetchBackgroundLocationReportingSettingsString extends TypedGraphQlQueryString<FetchBackgroundLocationReportingSettingsModel> {
        public FetchBackgroundLocationReportingSettingsString() {
            super(FetchBackgroundLocationReportingSettingsModel.class, false, "FetchBackgroundLocationReportingSettings", "ff7aa03673acb04c81ded20491b7e949", "viewer", "10154339187331729", RegularImmutableSet.a);
        }
    }

    public static final FetchBackgroundLocationReportingSettingsString m10199a() {
        return new FetchBackgroundLocationReportingSettingsString();
    }
}
