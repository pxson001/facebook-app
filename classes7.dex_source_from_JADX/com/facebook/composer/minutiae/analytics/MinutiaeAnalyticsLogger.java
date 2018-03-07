package com.facebook.composer.minutiae.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.FlowableTaggableActivityModel;
import javax.inject.Inject;

/* compiled from: topTouchMove */
public class MinutiaeAnalyticsLogger {
    private final AnalyticsLogger f1461a;

    /* compiled from: topTouchMove */
    public enum Action {
        SEEN("seen"),
        SELECT("selected"),
        SKIP("skipped"),
        HIT_BACK("hit_back");
        
        public final String name;

        private Action(String str) {
            this.name = str;
        }
    }

    /* compiled from: topTouchMove */
    public enum Events {
        CONTEXTUAL_SUGGESTION_ACTION("minutiae_suggestion_action");
        
        public final String name;

        private Events(String str) {
            this.name = str;
        }
    }

    public static MinutiaeAnalyticsLogger m1546b(InjectorLike injectorLike) {
        return new MinutiaeAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MinutiaeAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1461a = analyticsLogger;
    }

    public final void m1547a(Action action, FlowableTaggableActivityModel flowableTaggableActivityModel, String str, String str2) {
        AnalyticsLogger analyticsLogger = this.f1461a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Events.CONTEXTUAL_SUGGESTION_ACTION.name);
        honeyClientEvent.c = "composer";
        analyticsLogger.c(honeyClientEvent.b("activity_id", flowableTaggableActivityModel.g().a()).a("place_id", Long.parseLong(str)).b("suggestion_mechanism", flowableTaggableActivityModel.ch_()).b("session_id", str2).a("action", action));
    }
}
