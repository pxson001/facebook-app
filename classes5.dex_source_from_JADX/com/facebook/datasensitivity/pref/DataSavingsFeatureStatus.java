package com.facebook.datasensitivity.pref;

import com.facebook.analytics.feature.FeatureCode;
import com.facebook.analytics.feature.FeatureStatus;
import javax.inject.Inject;

/* compiled from: _non_facebook_url_load_event */
public class DataSavingsFeatureStatus extends FeatureStatus {
    private final DataSensitivitySettingsPrefUtil f11768a;

    @Inject
    public DataSavingsFeatureStatus(DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f11768a = dataSensitivitySettingsPrefUtil;
    }

    public final FeatureCode m19800a() {
        return FeatureCode.DATASAVINGS;
    }

    public final String m19801b() {
        return "datasavings";
    }

    public final boolean m19802c() {
        return this.f11768a.a(false);
    }
}
