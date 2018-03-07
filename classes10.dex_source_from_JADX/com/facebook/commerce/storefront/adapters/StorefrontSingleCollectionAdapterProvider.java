package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.commerce.core.ui.ProductItemViewBinder;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.ui.StorefrontProductItemViewModelCreator;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: createPendingIntentForJoinConferenceCall cannot fetch threadSummary */
public class StorefrontSingleCollectionAdapterProvider extends AbstractAssistedProvider<StorefrontSingleCollectionAdapter> {
    public final StorefrontSingleCollectionAdapter m16143a(Context context, boolean z) {
        return new StorefrontSingleCollectionAdapter(CommerceNavigationUtil.a(this), new StorefrontProductItemViewModelCreator(), ProductItemViewBinder.a(this), AnalyticsLoggerMethodAutoProvider.a(this), context, z);
    }
}
