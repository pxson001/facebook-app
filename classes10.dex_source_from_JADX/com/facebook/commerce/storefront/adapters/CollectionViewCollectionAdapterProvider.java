package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.ui.PageInfoViewProvider;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: createintent_currentversion */
public class CollectionViewCollectionAdapterProvider extends AbstractAssistedProvider<CollectionViewCollectionAdapter> {
    public final CollectionViewCollectionAdapter m16119a(Context context, long j, boolean z, MerchantInfoViewData merchantInfoViewData) {
        return new CollectionViewCollectionAdapter(CommerceNavigationUtil.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), AnalyticsLoggerMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (PageInfoViewProvider) getOnDemandAssistedProviderForStaticDi(PageInfoViewProvider.class), context, j, z, merchantInfoViewData);
    }
}
