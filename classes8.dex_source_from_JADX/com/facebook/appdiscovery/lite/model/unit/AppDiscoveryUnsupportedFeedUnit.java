package com.facebook.appdiscovery.lite.model.unit;

import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppSectionQueryFragmentModel;
import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: is_external_sharing_enabled */
public class AppDiscoveryUnsupportedFeedUnit extends AppDiscoveryBaseFeedUnit {
    private String f10586a;

    public AppDiscoveryUnsupportedFeedUnit(AppSectionQueryFragmentModel appSectionQueryFragmentModel) {
        this.f10586a = StringFormatUtil.a("[Employees Only] Unsupported feed unit \nRenderStyle: %s\nPlease rage shake and file a report", new Object[]{appSectionQueryFragmentModel.k().name()});
    }
}
