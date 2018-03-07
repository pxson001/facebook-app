package com.facebook.appdiscovery.lite.protocol.loader;

import com.facebook.appdiscovery.lite.model.factory.AppDetailsFeedUnitFactory;
import com.facebook.appdiscovery.lite.model.factory.AppDiscoveryUnsupportedUnitFactory;
import com.facebook.appdiscovery.lite.model.factory.LiteRelatedAppsFeedUnitFactory;
import com.facebook.graphql.enums.GraphQLMoreAppsUnitRenderStyle;
import javax.inject.Inject;

/* compiled from: sendCampaignPaymentMessageParams */
public class LiteResultsGraphQLConverter {
    public final AppDetailsFeedUnitFactory f4124a;
    public final LiteRelatedAppsFeedUnitFactory f4125b;
    public final AppDiscoveryUnsupportedUnitFactory f4126c;

    /* compiled from: sendCampaignPaymentMessageParams */
    public /* synthetic */ class C03791 {
        public static final /* synthetic */ int[] f4123a = new int[GraphQLMoreAppsUnitRenderStyle.values().length];

        static {
            try {
                f4123a[GraphQLMoreAppsUnitRenderStyle.LARGE_UNIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4123a[GraphQLMoreAppsUnitRenderStyle.SMALL_UNIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4123a[GraphQLMoreAppsUnitRenderStyle.LARGE_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4123a[GraphQLMoreAppsUnitRenderStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public LiteResultsGraphQLConverter(AppDetailsFeedUnitFactory appDetailsFeedUnitFactory, LiteRelatedAppsFeedUnitFactory liteRelatedAppsFeedUnitFactory, AppDiscoveryUnsupportedUnitFactory appDiscoveryUnsupportedUnitFactory) {
        this.f4124a = appDetailsFeedUnitFactory;
        this.f4125b = liteRelatedAppsFeedUnitFactory;
        this.f4126c = appDiscoveryUnsupportedUnitFactory;
    }
}
