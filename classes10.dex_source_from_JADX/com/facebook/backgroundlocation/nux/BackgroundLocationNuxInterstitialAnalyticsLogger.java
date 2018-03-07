package com.facebook.backgroundlocation.nux;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.ipc.model.NuxStep;
import com.facebook.location.FbLocationStatus;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: download_cleanup_event */
public class BackgroundLocationNuxInterstitialAnalyticsLogger {
    private final AnalyticsLogger f14756a;

    /* compiled from: download_cleanup_event */
    public enum IneligibleReason {
        NOT_ALLOWED_IN_APP,
        LOCATION_UNAVAILABLE,
        EMPTY_SERVER_DATA,
        WRONG_NUX_STEP
    }

    @Inject
    public BackgroundLocationNuxInterstitialAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f14756a = analyticsLogger;
    }

    public final void m15120a(InterstitialControllerState interstitialControllerState, IneligibleReason ineligibleReason, FbLocationStatus fbLocationStatus, @Nullable List<NuxStep> list) {
        AnalyticsLogger analyticsLogger = this.f14756a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("background_location_nux_interstitial_eligibility_state");
        honeyClientEvent.c = "background_location";
        analyticsLogger.a(honeyClientEvent.a("state", interstitialControllerState).a("reason", ineligibleReason).a("location_state", fbLocationStatus.a).a("nux_steps", m15119a(list)));
    }

    @Nullable
    private static ArrayNode m15119a(@Nullable List<NuxStep> list) {
        if (list == null) {
            return null;
        }
        ArrayNode b = JsonNodeFactory.a.b();
        for (NuxStep nuxStep : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("name", nuxStep.name);
            objectNode.a("isCurrent", nuxStep.isCurrent);
            b.a(objectNode);
        }
        return b;
    }
}
