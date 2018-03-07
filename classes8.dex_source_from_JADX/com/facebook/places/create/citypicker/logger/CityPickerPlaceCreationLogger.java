package com.facebook.places.create.citypicker.logger;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.CrowdsourcingSession;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.FieldType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: security_code_input_controller_fragment_tag */
public class CityPickerPlaceCreationLogger implements CityPickerLogger {
    private final AnalyticsLogger f3608a;
    private final CrowdsourcingSession f3609b;
    private final CrowdsourcingContext f3610c;

    @Inject
    public CityPickerPlaceCreationLogger(AnalyticsLogger analyticsLogger, CrowdsourcingSession crowdsourcingSession, @Assisted CrowdsourcingContext crowdsourcingContext) {
        this.f3608a = analyticsLogger;
        this.f3609b = crowdsourcingSession;
        this.f3610c = crowdsourcingContext;
    }

    public final void mo192a(FieldType fieldType, long j) {
        this.f3608a.a(m3544a(this.f3610c, "suggestion_tapped").b("field_type_name", fieldType.name).a("event_obj_id", j));
    }

    public final void mo191a(long j) {
        this.f3608a.a(m3544a(this.f3610c, "current_location_tapped").a("event_obj_id", j));
    }

    public final void mo193a(FieldType fieldType, long j, String str) {
        this.f3608a.a(m3544a(this.f3610c, "search_result_tapped").b("field_type_name", fieldType.name).a("event_obj_id", j).b("query", str));
    }

    private HoneyClientEvent m3544a(CrowdsourcingContext crowdsourcingContext, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("place_creation_session");
        honeyClientEvent.c = "crowdsourcing_create";
        return honeyClientEvent.b("event", str).b("entry_point", crowdsourcingContext.a.getFullName()).b("endpoint", crowdsourcingContext.b.getFullName()).a("session_id", this.f3609b.a());
    }
}
