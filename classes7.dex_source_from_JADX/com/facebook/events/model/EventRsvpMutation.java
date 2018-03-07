package com.facebook.events.model;

import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.model.Event.Builder;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: syncHook */
public class EventRsvpMutation {
    private final Event f2704a;
    public final Event f2705b;
    private final GraphQLConnectionStyle f2706c;

    private EventRsvpMutation(Event event, Event event2, GraphQLConnectionStyle graphQLConnectionStyle) {
        Preconditions.checkState(Objects.equal(event.f2666a, event2.f2666a));
        this.f2704a = event;
        this.f2705b = event2;
        this.f2706c = graphQLConnectionStyle;
    }

    public final String m3008a() {
        return this.f2704a.f2666a;
    }

    public final EventRsvpMutation m3009c() {
        return new EventRsvpMutation(this.f2705b, this.f2704a, this.f2706c);
    }

    public static EventRsvpMutation m3005a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        Builder builder = new Builder(event);
        builder.f2589B = graphQLEventGuestStatus;
        builder = builder;
        builder.f2594G = false;
        return new EventRsvpMutation(event, builder.m2983b(), GraphQLConnectionStyle.RSVP);
    }

    public static EventRsvpMutation m3006a(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        Builder builder = new Builder(event);
        builder.f2590C = graphQLEventWatchStatus;
        builder = builder;
        builder.f2589B = Event.m2984a(graphQLEventWatchStatus);
        builder = builder;
        builder.f2594G = false;
        return new EventRsvpMutation(event, builder.m2983b(), GraphQLConnectionStyle.INTERESTED);
    }

    public final EventCommonFragmentModel m3007a(EventCommonFragmentModel eventCommonFragmentModel) {
        EventCommonFragmentModel.Builder builder = new EventCommonFragmentModel.Builder();
        builder.a = eventCommonFragmentModel.r();
        builder.b = eventCommonFragmentModel.s();
        builder.c = eventCommonFragmentModel.t();
        builder.d = eventCommonFragmentModel.j();
        builder.e = eventCommonFragmentModel.u();
        builder.f = eventCommonFragmentModel.k();
        builder.g = eventCommonFragmentModel.S();
        builder.h = eventCommonFragmentModel.T();
        builder.i = eventCommonFragmentModel.U();
        builder.j = eventCommonFragmentModel.b();
        builder.k = eventCommonFragmentModel.V();
        builder.l = eventCommonFragmentModel.W();
        builder.m = eventCommonFragmentModel.x();
        builder.n = eventCommonFragmentModel.X();
        builder.o = eventCommonFragmentModel.Y();
        builder.p = eventCommonFragmentModel.Z();
        builder.q = eventCommonFragmentModel.B();
        builder.r = eventCommonFragmentModel.aa();
        builder.s = eventCommonFragmentModel.ab();
        builder.t = eventCommonFragmentModel.ac();
        builder.u = eventCommonFragmentModel.C();
        builder.v = eventCommonFragmentModel.D();
        builder.w = eventCommonFragmentModel.ad();
        builder.x = eventCommonFragmentModel.F();
        builder.y = eventCommonFragmentModel.ae();
        builder.z = eventCommonFragmentModel.af();
        builder.A = eventCommonFragmentModel.ag();
        builder.B = eventCommonFragmentModel.dL_();
        builder.C = eventCommonFragmentModel.g();
        builder.D = eventCommonFragmentModel.J();
        builder.E = eventCommonFragmentModel.m();
        builder.F = eventCommonFragmentModel.K();
        builder.G = eventCommonFragmentModel.dM_();
        builder.H = eventCommonFragmentModel.ah();
        builder.I = eventCommonFragmentModel.M();
        builder.J = eventCommonFragmentModel.ai();
        builder.K = eventCommonFragmentModel.O();
        builder.L = eventCommonFragmentModel.dN_();
        builder.M = eventCommonFragmentModel.aj();
        builder.N = eventCommonFragmentModel.n();
        builder.O = eventCommonFragmentModel.o();
        builder.P = eventCommonFragmentModel.p();
        builder.Q = eventCommonFragmentModel.Q();
        builder.R = eventCommonFragmentModel.R();
        builder.S = eventCommonFragmentModel.q();
        EventCommonFragmentModel.Builder builder2 = builder;
        builder2.P = this.f2705b.f2646G;
        builder2 = builder2;
        builder2.O = this.f2705b.m2991D();
        builder2 = builder2;
        builder2.S = this.f2705b.f2642C;
        return builder2.a();
    }
}
