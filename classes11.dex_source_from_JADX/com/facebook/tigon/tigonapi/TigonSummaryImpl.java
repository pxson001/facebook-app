package com.facebook.tigon.tigonapi;

import com.facebook.tigon.tigonapi.TigonSummaryLayers.LayerInfo;
import javax.annotation.Nullable;

/* compiled from: no_charity_text */
public class TigonSummaryImpl {
    @Nullable
    private final TigonRequestStatsSummaryInfoImpl f5059a;
    @Nullable
    private final TigonSwitcherSummaryInfoImpl f5060b;
    @Nullable
    private final TigonHttpFlowStatsInfoImpl f5061c;
    @Nullable
    private final TigonFlowTimeDataInfoImpl f5062d;

    public TigonSummaryImpl(@Nullable TigonRequestStatsSummaryInfoImpl tigonRequestStatsSummaryInfoImpl, @Nullable TigonSwitcherSummaryInfoImpl tigonSwitcherSummaryInfoImpl, @Nullable TigonHttpFlowStatsInfoImpl tigonHttpFlowStatsInfoImpl, @Nullable TigonFlowTimeDataInfoImpl tigonFlowTimeDataInfoImpl) {
        this.f5059a = tigonRequestStatsSummaryInfoImpl;
        this.f5060b = tigonSwitcherSummaryInfoImpl;
        this.f5061c = tigonHttpFlowStatsInfoImpl;
        this.f5062d = tigonFlowTimeDataInfoImpl;
    }

    @Nullable
    public final <T> T m6345a(LayerInfo<T> layerInfo) {
        if (layerInfo == TigonSummaryLayers.f5063a) {
            return this.f5059a;
        }
        if (layerInfo == TigonSummaryLayers.f5064b) {
            return this.f5060b;
        }
        if (layerInfo == TigonSummaryLayers.f5065c) {
            return this.f5061c;
        }
        if (layerInfo == TigonSummaryLayers.f5066d) {
            return this.f5062d;
        }
        return null;
    }
}
