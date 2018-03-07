package com.facebook.photos.base.analytics;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.InjectorLike;

/* compiled from: insights_platform_ref */
public class WaterfallIdGenerator {
    public static WaterfallIdGenerator m20066a(InjectorLike injectorLike) {
        return new WaterfallIdGenerator();
    }

    public static String m20067a() {
        return SafeUUIDGenerator.a().toString();
    }
}
