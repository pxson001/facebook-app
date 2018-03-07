package com.facebook.composer.topics.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: Tried to cancel a search session but no session is ongoing */
public class ComposerTopicLogger {
    private final String f23961a;
    private final AnalyticsLogger f23962b;
    private long f23963c;
    private final MonotonicClock f23964d;

    @Inject
    public ComposerTopicLogger(@Assisted String str, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f23961a = str;
        this.f23962b = analyticsLogger;
        this.f23964d = monotonicClock;
    }

    public final void m25909a(String str, String str2, String str3, ImmutableList<GraphQLExploreFeed> immutableList) {
        this.f23962b.a(m25905a("topic_feeds_composer_start").b("composer_type", str).b("entry_point_ref", str2).b("target_type", str3).b("topics_bootstrapped", m25906a((Collection) immutableList)));
    }

    public final void m25908a(ImmutableList<GraphQLExploreFeed> immutableList) {
        HoneyClientEvent a = m25905a("topic_feeds_composer_show_topic_list");
        a.b("topics", m25906a((Collection) immutableList));
        this.f23962b.a(a);
    }

    public final void m25907a(GraphQLExploreFeed graphQLExploreFeed, int i, boolean z, boolean z2) {
        HoneyClientEvent a = m25905a("topic_feeds_composer_manual_topic_change");
        a.a("add", z).a("via_list", z2).b("feed", graphQLExploreFeed.n()).a("index", i);
        this.f23962b.a(a);
    }

    public final void m25911a(boolean z, int i, String str, String str2) {
        HoneyClientEvent a = m25905a("topic_feeds_composer_predict_start");
        a.a("has_location", z).a("att_count", i).a("length", str.codePointCount(0, str.length())).b("classify_session_id", str2);
        this.f23962b.a(a);
        this.f23963c = this.f23964d.now();
    }

    public final void m25912a(boolean z, ImmutableList<GraphQLExploreFeed> immutableList, String str) {
        double now = this.f23963c > 0 ? (double) (this.f23964d.now() - this.f23963c) : 0.0d;
        HoneyClientEvent a = m25905a("topic_feeds_composer_predict_finish");
        a.a("perf_logger_status", z).a("predictionCount", immutableList.size()).a("value", now).b("predicted_topics", m25906a((Collection) immutableList)).b("classify_session_id", str);
        this.f23962b.a(a);
    }

    public final void m25910a(String str, String str2, String str3, ImmutableList<GraphQLExploreFeed> immutableList, ImmutableList<GraphQLExploreFeed> immutableList2, Collection<GraphQLExploreFeed> collection, Collection<GraphQLExploreFeed> collection2, ImmutableList<GraphQLExploreFeed> immutableList3) {
        this.f23962b.a(m25905a("topic_feeds_composer_send_post").b("composer_type", str).b("entry_point_ref", str2).b("target_type", str3).b("topics_tagged", m25906a((Collection) immutableList2)).b("topics_user_added", m25906a((Collection) collection)).b("topics_user_removed", m25906a((Collection) collection2)).b("topics_predicted", m25906a((Collection) immutableList3)).b("topics_bootstrapped", m25906a((Collection) immutableList)));
    }

    private static String m25906a(Collection<GraphQLExploreFeed> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (GraphQLExploreFeed graphQLExploreFeed : collection) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(graphQLExploreFeed.n());
        }
        return stringBuilder.toString();
    }

    private HoneyClientEvent m25905a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "composer";
        return honeyClientEvent.b("composer_session_id", this.f23961a);
    }
}
