package com.facebook.events.protocol;

import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventViewerCapabilityModel;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.graphql.model.GraphQLEventViewerCapability;
import com.facebook.graphql.model.GraphQLNode;
import java.util.EnumSet;

/* compiled from: audio_clips_show_composer */
public class EventViewerCapabilityModelHelper {
    public static EnumSet<EventViewerCapability> m19284a(EventCommonFragment eventCommonFragment) {
        EnumSet<EventViewerCapability> noneOf = EnumSet.noneOf(EventViewerCapability.class);
        EventViewerCapabilityModel E = eventCommonFragment.E();
        if (E != null) {
            if (E.o()) {
                noneOf.add(EventViewerCapability.ADMIN);
            }
            if (E.g()) {
                noneOf.add(EventViewerCapability.JOIN);
            }
            if (E.ee_()) {
                noneOf.add(EventViewerCapability.MAYBE);
            }
            if (E.a()) {
                noneOf.add(EventViewerCapability.DECLINE);
            }
            if (E.ed_()) {
                noneOf.add(EventViewerCapability.INVITE);
            }
            if (eventCommonFragment.u()) {
                noneOf.add(EventViewerCapability.POST);
            }
            if (E.c()) {
                noneOf.add(EventViewerCapability.EDIT);
            }
            if (E.k()) {
                noneOf.add(EventViewerCapability.REPORT);
            }
            if (E.b()) {
                noneOf.add(EventViewerCapability.DELETE);
            }
            if (E.l()) {
                noneOf.add(EventViewerCapability.SAVE);
            }
            if (E.n()) {
                noneOf.add(EventViewerCapability.SHARE);
            }
            if (E.m()) {
                noneOf.add(EventViewerCapability.SEND_MESSAGE_TO_GUESTS);
            }
            if (E.d()) {
                noneOf.add(EventViewerCapability.EDIT_HOST);
            }
            if (E.j()) {
                noneOf.add(EventViewerCapability.REMOVE_SELF);
            }
            if (E.p() == GraphQLEventSeenState.SEEN) {
                noneOf.add(EventViewerCapability.SEEN);
            }
            if (E.ef_()) {
                if (eventCommonFragment.C() == GraphQLBoostedPostStatus.INACTIVE) {
                    noneOf.add(EventViewerCapability.PROMOTE);
                } else {
                    noneOf.add(EventViewerCapability.EDIT_PROMOTION);
                }
            } else if (E.p() == GraphQLEventSeenState.UNSEEN) {
                noneOf.add(EventViewerCapability.UNSEEN);
            } else {
                noneOf.add(EventViewerCapability.UNKNOWN_SEEN_STATE);
            }
        }
        return noneOf;
    }

    public static EnumSet<EventViewerCapability> m19285a(GraphQLNode graphQLNode) {
        EnumSet<EventViewerCapability> noneOf = EnumSet.noneOf(EventViewerCapability.class);
        GraphQLEventViewerCapability cp = graphQLNode.cp();
        if (cp != null) {
            if (cp.u()) {
                noneOf.add(EventViewerCapability.ADMIN);
            }
            if (cp.n()) {
                noneOf.add(EventViewerCapability.JOIN);
            }
            if (cp.o()) {
                noneOf.add(EventViewerCapability.MAYBE);
            }
            if (cp.a()) {
                noneOf.add(EventViewerCapability.DECLINE);
            }
            if (cp.m()) {
                noneOf.add(EventViewerCapability.INVITE);
            }
            if (graphQLNode.aI()) {
                noneOf.add(EventViewerCapability.POST);
            }
            if (cp.k()) {
                noneOf.add(EventViewerCapability.EDIT);
            }
            if (cp.q()) {
                noneOf.add(EventViewerCapability.REPORT);
            }
            if (cp.j()) {
                noneOf.add(EventViewerCapability.DELETE);
            }
            if (cp.r()) {
                noneOf.add(EventViewerCapability.SAVE);
            }
            if (cp.t()) {
                noneOf.add(EventViewerCapability.SHARE);
            }
            if (cp.s()) {
                noneOf.add(EventViewerCapability.SEND_MESSAGE_TO_GUESTS);
            }
            if (cp.l()) {
                noneOf.add(EventViewerCapability.EDIT_HOST);
            }
            if (cp.p()) {
                noneOf.add(EventViewerCapability.REMOVE_SELF);
            }
            if (cp.x()) {
                if (graphQLNode.jD() == GraphQLBoostedPostStatus.INACTIVE) {
                    noneOf.add(EventViewerCapability.PROMOTE);
                } else {
                    noneOf.add(EventViewerCapability.EDIT_PROMOTION);
                }
            }
            if (cp.w() == GraphQLEventSeenState.SEEN) {
                noneOf.add(EventViewerCapability.SEEN);
            } else if (cp.w() == GraphQLEventSeenState.UNSEEN) {
                noneOf.add(EventViewerCapability.UNSEEN);
            } else {
                noneOf.add(EventViewerCapability.UNKNOWN_SEEN_STATE);
            }
        }
        return noneOf;
    }
}
