package com.facebook.search.logging;

import android.os.Bundle;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TextView */
public class SeeMoreAnalyticHelper extends SearchAnalyticHelper {
    private static final Class<?> f21977a = SeeMoreAnalyticHelper.class;
    private final AnalyticsLogger f21978b;
    private final Clock f21979c;
    private final GraphSearchErrorReporter f21980d;
    public SearchTypeaheadSession f21981e = SearchTypeaheadSession.a;
    public String f21982f;
    public long f21983g;
    public int f21984h = 0;

    @Inject
    public SeeMoreAnalyticHelper(AnalyticsLogger analyticsLogger, Clock clock, GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f21978b = analyticsLogger;
        this.f21979c = clock;
        this.f21980d = graphSearchErrorReporter;
    }

    public final void m25521a(SearchTypeaheadSession searchTypeaheadSession) {
        this.f21981e = searchTypeaheadSession;
        m25518c();
    }

    private void m25518c() {
        this.f21982f = SafeUUIDGenerator.a().toString();
        this.f21983g = this.f21979c.a();
        this.f21984h = 0;
    }

    private void m25519d() {
        if (this.f21979c.a() - this.f21983g > 3600000) {
            m25518c();
        }
    }

    public final void m25520a(Bundle bundle) {
        this.f21981e = new SearchTypeaheadSession(bundle.getString("typeahead_session_id"), bundle.getString("candidate_results_id"));
        this.f21982f = bundle.getString("see_more_session_id");
        if (this.f21982f == null) {
            m25518c();
            return;
        }
        this.f21983g = bundle.getLong("see_more_session_start_time_ms");
        this.f21984h = bundle.getInt("see_more_results_clicked");
        m25519d();
    }

    public final void m25526a(@Nullable Boolean bool, FilterType filterType, String str) {
        if (this.f21982f != null) {
            this.f21978b.c(m25517a("see_more_impression").b("filter_type", filterType.toString()).b("query", str).a("is_empty", bool));
        }
    }

    public final void m25522a(FilterType filterType, String str, ImmutableList<NeedleFilter> immutableList) {
        if (this.f21982f != null) {
            HoneyClientEvent b = m25517a("see_more_impression").b("filter_type", filterType.toString()).b("query", str).b("advanced_filters", immutableList.toString());
            this.f21978b.a(b);
            b.d();
        }
    }

    public final void m25524a(ImmutableList<SeeMoreResultPageUnit> immutableList, SeeMoreResultPageUnit seeMoreResultPageUnit, FilterType filterType, String str) {
        Preconditions.checkNotNull(this.f21982f);
        ArrayNode a = m25446a(immutableList);
        HoneyClientEvent a2 = m25517a("click").b("action", "entity_selected").b("filter_type", filterType.toString()).b("result_type", seeMoreResultPageUnit.m25743n().toLowerCase(Locale.US)).b("object_id", seeMoreResultPageUnit.m25742m()).b("query", str).a("selected_position", SearchAnalyticHelper.m25444a((TypeaheadUnit) seeMoreResultPageUnit, (ImmutableList) immutableList)).a("end_session_candidate_results", a);
        a.toString();
        this.f21978b.c(a2);
        this.f21984h++;
    }

    public final void m25525a(ImmutableList<SeeMoreResultPageUnit> immutableList, String str) {
        ArrayNode a = m25446a(immutableList);
        HoneyClientEvent a2 = m25517a("click").b("action", "end_back_button").b("query", str).a("end_session_candidate_results", a);
        a.toString();
        this.f21978b.c(a2);
    }

    protected final void mo1203a(ObjectNode objectNode, TypeaheadUnit typeaheadUnit) {
        EntityTypeaheadUnit entityTypeaheadUnit = ((SeeMoreResultPageUnit) typeaheadUnit).f22265a;
        if (entityTypeaheadUnit != null) {
            SearchAnalyticHelper.m25445a(objectNode, entityTypeaheadUnit);
            return;
        }
        this.f21980d.a(GraphSearchError.LOGGING_UNIMPLEMENTED_RESULT_ROW_TYPE, String.format(Locale.US, "Candidate result logging not implemented for TypeaheadUnit of type %s. Entity associated with this unit is null.", new Object[]{typeaheadUnit.getClass().toString()}));
    }

    private HoneyClientEvent m25517a(String str) {
        m25519d();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "pps";
        return honeyClientEvent.b("session_id", this.f21982f).a("back_presses", this.f21984h).b("typeahead_sid", this.f21981e.b).b("candidate_result_sid", this.f21981e.c);
    }
}
