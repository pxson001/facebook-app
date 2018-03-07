package com.facebook.events.graphql;

import com.facebook.events.graphql.EventsMutationsModels.CancelEventMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.ChangeSubscriptionMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventAdminRemoveGuestMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventAdminRsvpMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventInviteMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventPromptXOutMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventPurchaseTicketMutationAsyncModel;
import com.facebook.events.graphql.EventsMutationsModels.EventPurchaseTicketMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpSubscriptionModel;
import com.facebook.events.graphql.EventsMutationsModels.EventSoftCancelMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventUnifiedInviteMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventUserBlockMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.RemoveSubscribedEventMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.RemoveSuggestedEventMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: num_next_related_stories */
public final class EventsMutations {

    /* compiled from: num_next_related_stories */
    public class CancelEventMutationString extends TypedGraphQLMutationString<CancelEventMutationModel> {
        public CancelEventMutationString() {
            super(CancelEventMutationModel.class, false, "CancelEventMutation", "ee1b41c6b0b39abfd50bcc858ec71d4d", "event_cancel", "0", "10154204802906729", RegularImmutableSet.a);
        }

        public final String m15187a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class ChangeSubscriptionMutationString extends TypedGraphQLMutationString<ChangeSubscriptionMutationModel> {
        public ChangeSubscriptionMutationString() {
            super(ChangeSubscriptionMutationModel.class, false, "ChangeSubscriptionMutation", "b4e209818e4f2428925507b427f3c75f", "profile_set_events_calendar_subscription_status", "0", "10154228418606729", RegularImmutableSet.a);
        }

        public final String m15188a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventAdminRemoveGuestMutationString extends TypedGraphQLMutationString<EventAdminRemoveGuestMutationModel> {
        public EventAdminRemoveGuestMutationString() {
            super(EventAdminRemoveGuestMutationModel.class, false, "EventAdminRemoveGuestMutation", "cf0faa3659481551a5d809edd56bb875", "event_admin_remove_guest", "0", "10154343223966729", RegularImmutableSet.a);
        }

        public final String m15189a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventAdminRsvpMutationString extends TypedGraphQLMutationString<EventAdminRsvpMutationModel> {
        public EventAdminRsvpMutationString() {
            super(EventAdminRsvpMutationModel.class, false, "EventAdminRsvpMutation", "84adfc3673187fbcc344c3c3b70b17e7", "event_admin_rsvp", "0", "10154343224061729", RegularImmutableSet.a);
        }

        public final String m15190a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventInviteMutationString extends TypedGraphQLMutationString<EventInviteMutationModel> {
        public EventInviteMutationString() {
            super(EventInviteMutationModel.class, false, "EventInviteMutation", "d48636a37c4bb0ea53bfc9dd2066e9cf", "event_invite", "0", "10154204802911729", RegularImmutableSet.a);
        }

        public final String m15191a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventPromptXOutMutationString extends TypedGraphQLMutationString<EventPromptXOutMutationModel> {
        public EventPromptXOutMutationString() {
            super(EventPromptXOutMutationModel.class, false, "EventPromptXOutMutation", "a495ee78d57f96d4d8343420e1f4565a", "event_promotion_xout", "0", "10154427200836729", RegularImmutableSet.a);
        }

        public final String m15192a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventPurchaseTicketMutationAsyncString extends TypedGraphQLMutationString<EventPurchaseTicketMutationAsyncModel> {
        public EventPurchaseTicketMutationAsyncString() {
            super(EventPurchaseTicketMutationAsyncModel.class, false, "EventPurchaseTicketMutationAsync", "06ef23bebe932dadce67da62ff9e0204", "event_purchase_tickets_async", "0", "10154651329776729", RegularImmutableSet.a);
        }

        public final String m15193a(String str) {
            switch (str.hashCode()) {
                case -2098866353:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventPurchaseTicketMutationString extends TypedGraphQLMutationString<EventPurchaseTicketMutationModel> {
        public EventPurchaseTicketMutationString() {
            super(EventPurchaseTicketMutationModel.class, false, "EventPurchaseTicketMutation", "7bd9027ded1d89877e7963baf8e36983", "event_purchase_tickets", "0", "10154646160881729", RegularImmutableSet.a);
        }

        public final String m15194a(String str) {
            switch (str.hashCode()) {
                case -2098866353:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventRsvpMutationString extends TypedGraphQLMutationString<EventRsvpMutationModel> {
        public EventRsvpMutationString() {
            super(EventRsvpMutationModel.class, false, "EventRsvpMutation", "a23768d50be03861dcbc5db9ec934ea2", "event_rsvp", "0", "10154343224006729", RegularImmutableSet.a);
        }

        public final String m15195a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventRsvpSubscriptionString extends TypedGraphQLSubscriptionString<EventRsvpSubscriptionModel> {
        public EventRsvpSubscriptionString() {
            super(EventRsvpSubscriptionModel.class, false, "EventRsvpSubscription", "daa012b88c0eb58de9ea4140ceb1e50d", "event_rsvp_subscribe", "0", "10154343224026729", RegularImmutableSet.a);
        }

        public final String m15196a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventSoftCancelMutationString extends TypedGraphQLMutationString<EventSoftCancelMutationModel> {
        public EventSoftCancelMutationString() {
            super(EventSoftCancelMutationModel.class, false, "EventSoftCancelMutation", "c20592128ccccb48aebbf4ac74f07428", "event_soft_cancel", "0", "10154510174141729", RegularImmutableSet.a);
        }

        public final String m15197a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventUnifiedInviteMutationString extends TypedGraphQLMutationString<EventUnifiedInviteMutationModel> {
        public EventUnifiedInviteMutationString() {
            super(EventUnifiedInviteMutationModel.class, false, "EventUnifiedInviteMutation", "8fa9956731f4fd9c8e6adead6c2538ba", "event_unified_invite", "0", "10154504669366729", RegularImmutableSet.a);
        }

        public final String m15198a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class EventUserBlockMutationString extends TypedGraphQLMutationString<EventUserBlockMutationModel> {
        public EventUserBlockMutationString() {
            super(EventUserBlockMutationModel.class, false, "EventUserBlockMutation", "cc0f04d43b96f28e79fdaac57e1fd321", "event_user_block", "0", "10154204802871729", RegularImmutableSet.a);
        }

        public final String m15199a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class RemoveSubscribedEventMutationString extends TypedGraphQLMutationString<RemoveSubscribedEventMutationModel> {
        public RemoveSubscribedEventMutationString() {
            super(RemoveSubscribedEventMutationModel.class, false, "RemoveSubscribedEventMutation", "576fdafaaccc42d8cc70d876fc14da67", "subscribed_event_take_negative_action", "0", "10154204802886729", RegularImmutableSet.a);
        }

        public final String m15200a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class RemoveSuggestedEventMutationString extends TypedGraphQLMutationString<RemoveSuggestedEventMutationModel> {
        public RemoveSuggestedEventMutationString() {
            super(RemoveSuggestedEventMutationModel.class, false, "RemoveSuggestedEventMutation", "e94872c575928bd1c08728c46a96aec8", "event_suggestion_take_negative_action", "0", "10154204802756729", RegularImmutableSet.a);
        }

        public final String m15201a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_next_related_stories */
    public class WatchEventMutationString extends TypedGraphQLMutationString<WatchEventMutationModel> {
        public WatchEventMutationString() {
            super(WatchEventMutationModel.class, false, "WatchEventMutation", "b4f503996d848758697efb288eeaa4d8", "event_update_extended_viewer_watch_status", "0", "10154343224021729", RegularImmutableSet.a);
        }

        public final String m15202a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final ChangeSubscriptionMutationString m15203c() {
        return new ChangeSubscriptionMutationString();
    }

    public static final WatchEventMutationString m15204d() {
        return new WatchEventMutationString();
    }

    public static final EventRsvpMutationString m15205e() {
        return new EventRsvpMutationString();
    }

    public static final EventRsvpSubscriptionString m15206p() {
        return new EventRsvpSubscriptionString();
    }
}
