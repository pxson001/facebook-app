package com.facebook.feedplugins.saved.nux;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.google.common.collect.ImmutableSet;

/* compiled from: messenger_sticker_tray_downloadable_packs */
public class CaretNuxTooltipDelegateProvider extends AbstractAssistedProvider<CaretNuxTooltipDelegate> {
    public final CaretNuxTooltipDelegate m20136a(String str, Long l, ImmutableSet<String> immutableSet, GraphQLStorySaveNuxType graphQLStorySaveNuxType) {
        return new CaretNuxTooltipDelegate(str, l, immutableSet, graphQLStorySaveNuxType, FbErrorReporterImpl.m2317a((InjectorLike) this), SaveAnalyticsLogger.m13117a(this), InterstitialManager.m8082a((InjectorLike) this));
    }
}
