package com.facebook.events.graphql;

import com.facebook.common.util.TriState;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllDeclinesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllMaybesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllMembersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventDefaultTicketHolderInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailDeclinesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailInviteesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailMaybesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailMembersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventFriendDeclinesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventFriendInviteesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventFriendMaybesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventFriendMembersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventFriendWatchersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventGuestCountsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableContactsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntriesSearchQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntriesTokenQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventOtherDeclinesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventOtherInviteesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventOtherMaybesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventOtherMembersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventOtherWatchersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSMSDeclinesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSMSInviteesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSMSMaybesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSMSMembersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificSuggestedInviteCandidatesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificUninvitableFriendsAndInviteeLimitModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderStatusSubscriptionModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrdersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventsSuggestedInviteCandidatesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventsUninvitableFriendsAndInviteeLimitModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchAllUpcomingEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPagedUpcomingBirthdaysQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPastEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSuggestionsForForCutTypeModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUserSuggestionsModel;
import com.facebook.events.graphql.EventsGraphQLModels.GroupEventFriendInviteCandidatesQueryModel;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: num_topresults_to_show */
public final class EventsGraphQL {

    /* compiled from: num_topresults_to_show */
    public class EventAllDeclinesQueryString extends TypedGraphQlQueryString<EventAllDeclinesQueryModel> {
        public EventAllDeclinesQueryString() {
            super(EventAllDeclinesQueryModel.class, false, "EventAllDeclinesQuery", "b765609a43a20416d488efcbb36e8191", "event", "10154429038291729", RegularImmutableSet.a);
        }

        public final TriState m12799g() {
            return TriState.YES;
        }

        public final String m12798a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventAllMaybesQueryString extends TypedGraphQlQueryString<EventAllMaybesQueryModel> {
        public EventAllMaybesQueryString() {
            super(EventAllMaybesQueryModel.class, false, "EventAllMaybesQuery", "a52780400aec1184ac06137abc230a45", "event", "10154457792166729", RegularImmutableSet.a);
        }

        public final TriState m12801g() {
            return TriState.YES;
        }

        public final String m12800a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventAllMembersQueryString extends TypedGraphQlQueryString<EventAllMembersQueryModel> {
        public EventAllMembersQueryString() {
            super(EventAllMembersQueryModel.class, false, "EventAllMembersQuery", "5fdbc99eaf063f208a029bea2ab3bee0", "event", "10154457486396729", RegularImmutableSet.a);
        }

        public final TriState m12803g() {
            return TriState.YES;
        }

        public final String m12802a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventDefaultTicketHolderInfoString extends TypedGraphQlQueryString<EventDefaultTicketHolderInfoModel> {
        public EventDefaultTicketHolderInfoString() {
            super(EventDefaultTicketHolderInfoModel.class, false, "EventDefaultTicketHolderInfo", "09be4dd2c8491cfc82a0d1281fce6ecd", "viewer", "10154564068426729", RegularImmutableSet.a);
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventEmailDeclinesQueryString extends TypedGraphQlQueryString<EventEmailDeclinesQueryModel> {
        public EventEmailDeclinesQueryString() {
            super(EventEmailDeclinesQueryModel.class, false, "EventEmailDeclinesQuery", "78f3143a43c971a94f488629bb2aba44", "event", "10154624242606729", RegularImmutableSet.a);
        }

        public final String m12804a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventEmailInviteesQueryString extends TypedGraphQlQueryString<EventEmailInviteesQueryModel> {
        public EventEmailInviteesQueryString() {
            super(EventEmailInviteesQueryModel.class, false, "EventEmailInviteesQuery", "4e16e4e7266919581685eae2fc17d00c", "event", "10154624242626729", RegularImmutableSet.a);
        }

        public final String m12805a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventEmailMaybesQueryString extends TypedGraphQlQueryString<EventEmailMaybesQueryModel> {
        public EventEmailMaybesQueryString() {
            super(EventEmailMaybesQueryModel.class, false, "EventEmailMaybesQuery", "0798e571a9fa4dcebe29862b3fb6107e", "event", "10154624242616729", RegularImmutableSet.a);
        }

        public final String m12806a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventEmailMembersQueryString extends TypedGraphQlQueryString<EventEmailMembersQueryModel> {
        public EventEmailMembersQueryString() {
            super(EventEmailMembersQueryModel.class, false, "EventEmailMembersQuery", "37f1dae60f08dae7525d476eeb1c67ec", "event", "10154624242586729", RegularImmutableSet.a);
        }

        public final String m12807a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventFriendDeclinesQueryString extends TypedGraphQlQueryString<EventFriendDeclinesQueryModel> {
        public EventFriendDeclinesQueryString() {
            super(EventFriendDeclinesQueryModel.class, false, "EventFriendDeclinesQuery", "9a6e5f7272daa382e9faffd291cc66ea", "event", "10154429038096729", RegularImmutableSet.a);
        }

        public final TriState m12809g() {
            return TriState.YES;
        }

        public final String m12808a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventFriendInviteesQueryString extends TypedGraphQlQueryString<EventFriendInviteesQueryModel> {
        public EventFriendInviteesQueryString() {
            super(EventFriendInviteesQueryModel.class, false, "EventFriendInviteesQuery", "064276ef4fe12c365ba4ba60a1435103", "event", "10154429038116729", RegularImmutableSet.a);
        }

        public final TriState m12811g() {
            return TriState.YES;
        }

        public final String m12810a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventFriendMaybesQueryString extends TypedGraphQlQueryString<EventFriendMaybesQueryModel> {
        public EventFriendMaybesQueryString() {
            super(EventFriendMaybesQueryModel.class, false, "EventFriendMaybesQuery", "f6fb3fb3da5d3a74f03af5825a8c73f7", "event", "10154429038141729", RegularImmutableSet.a);
        }

        public final TriState m12813g() {
            return TriState.YES;
        }

        public final String m12812a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventFriendMembersQueryString extends TypedGraphQlQueryString<EventFriendMembersQueryModel> {
        public EventFriendMembersQueryString() {
            super(EventFriendMembersQueryModel.class, false, "EventFriendMembersQuery", "e4d9dee8c8ca9d15b323e4a19103dad1", "event", "10154429038106729", RegularImmutableSet.a);
        }

        public final TriState m12815g() {
            return TriState.YES;
        }

        public final String m12814a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventFriendWatchersQueryString extends TypedGraphQlQueryString<EventFriendWatchersQueryModel> {
        public EventFriendWatchersQueryString() {
            super(EventFriendWatchersQueryModel.class, false, "EventFriendWatchersQuery", "35ecea434b8528d41b76043d9d3a8561", "event", "10154429038101729", RegularImmutableSet.a);
        }

        public final TriState m12817g() {
            return TriState.YES;
        }

        public final String m12816a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventInvitableContactsQueryString extends TypedGraphQlQueryString<EventInvitableContactsQueryModel> {
        public EventInvitableContactsQueryString() {
            super(EventInvitableContactsQueryModel.class, false, "EventInvitableContactsQuery", "b3d2ba72a389017fe1d9972ee28ca96b", "event", "10154494530396729", RegularImmutableSet.a);
        }

        public final String m12818a(String str) {
            switch (str.hashCode()) {
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventInvitableEntriesSearchQueryString extends TypedGraphQlQueryString<EventInvitableEntriesSearchQueryModel> {
        public EventInvitableEntriesSearchQueryString() {
            super(EventInvitableEntriesSearchQueryModel.class, false, "EventInvitableEntriesSearchQuery", "87796638b745670134f8cd3197ac3943", "event", "10154500607546729", RegularImmutableSet.a);
        }

        public final String m12819a(String str) {
            switch (str.hashCode()) {
                case -705314112:
                    return "2";
                case 278118624:
                    return "0";
                case 461177713:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventInvitableEntriesTokenQueryString extends TypedGraphQlQueryString<EventInvitableEntriesTokenQueryModel> {
        public EventInvitableEntriesTokenQueryString() {
            super(EventInvitableEntriesTokenQueryModel.class, false, "EventInvitableEntriesTokenQuery", "741460243fb29db5ca3a5b0ea80ab350", "event", "10154556052341729", RegularImmutableSet.a);
        }

        public final String m12820a(String str) {
            switch (str.hashCode()) {
                case -868186726:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventOtherDeclinesQueryString extends TypedGraphQlQueryString<EventOtherDeclinesQueryModel> {
        public EventOtherDeclinesQueryString() {
            super(EventOtherDeclinesQueryModel.class, false, "EventOtherDeclinesQuery", "51a2148abb006ef12e1540706169514e", "event", "10154429038296729", RegularImmutableSet.a);
        }

        public final TriState m12822g() {
            return TriState.YES;
        }

        public final String m12821a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventOtherInviteesQueryString extends TypedGraphQlQueryString<EventOtherInviteesQueryModel> {
        public EventOtherInviteesQueryString() {
            super(EventOtherInviteesQueryModel.class, false, "EventOtherInviteesQuery", "e52637ab9ecc4f51e2eb1875098c74fd", "event", "10154429038306729", RegularImmutableSet.a);
        }

        public final TriState m12824g() {
            return TriState.YES;
        }

        public final String m12823a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventOtherMaybesQueryString extends TypedGraphQlQueryString<EventOtherMaybesQueryModel> {
        public EventOtherMaybesQueryString() {
            super(EventOtherMaybesQueryModel.class, false, "EventOtherMaybesQuery", "389f6a3a022a77411d92aff65ce45d85", "event", "10154429038326729", RegularImmutableSet.a);
        }

        public final TriState m12826g() {
            return TriState.YES;
        }

        public final String m12825a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventOtherMembersQueryString extends TypedGraphQlQueryString<EventOtherMembersQueryModel> {
        public EventOtherMembersQueryString() {
            super(EventOtherMembersQueryModel.class, false, "EventOtherMembersQuery", "93f8ae9f3d12d48ca7f57695388f1a10", "event", "10154429038111729", RegularImmutableSet.a);
        }

        public final TriState m12828g() {
            return TriState.YES;
        }

        public final String m12827a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventOtherWatchersQueryString extends TypedGraphQlQueryString<EventOtherWatchersQueryModel> {
        public EventOtherWatchersQueryString() {
            super(EventOtherWatchersQueryModel.class, false, "EventOtherWatchersQuery", "e0c9df1fc4f8887f8f4648ec9031d017", "event", "10154429038311729", RegularImmutableSet.a);
        }

        public final TriState m12830g() {
            return TriState.YES;
        }

        public final String m12829a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventSMSDeclinesQueryString extends TypedGraphQlQueryString<EventSMSDeclinesQueryModel> {
        public EventSMSDeclinesQueryString() {
            super(EventSMSDeclinesQueryModel.class, false, "EventSMSDeclinesQuery", "b47ebbf46bf23ef1c7adddb0dab522ce", "event", "10154629465561729", RegularImmutableSet.a);
        }

        public final String m12831a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventSMSInviteesQueryString extends TypedGraphQlQueryString<EventSMSInviteesQueryModel> {
        public EventSMSInviteesQueryString() {
            super(EventSMSInviteesQueryModel.class, false, "EventSMSInviteesQuery", "4e87ab89194a65bb273df7a46a649782", "event", "10154686240976729", RegularImmutableSet.a);
        }

        public final String m12832a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventSMSMaybesQueryString extends TypedGraphQlQueryString<EventSMSMaybesQueryModel> {
        public EventSMSMaybesQueryString() {
            super(EventSMSMaybesQueryModel.class, false, "EventSMSMaybesQuery", "6b38ca01057deb9974fc79d1a461df14", "event", "10154629465551729", RegularImmutableSet.a);
        }

        public final String m12833a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventSMSMembersQueryString extends TypedGraphQlQueryString<EventSMSMembersQueryModel> {
        public EventSMSMembersQueryString() {
            super(EventSMSMembersQueryModel.class, false, "EventSMSMembersQuery", "a5cbf7a53829335009cb2f7b27897432", "event", "10154629465516729", RegularImmutableSet.a);
        }

        public final String m12834a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventSpecificSuggestedInviteCandidatesQueryString extends TypedGraphQlQueryString<EventSpecificSuggestedInviteCandidatesQueryModel> {
        public EventSpecificSuggestedInviteCandidatesQueryString() {
            super(EventSpecificSuggestedInviteCandidatesQueryModel.class, false, "EventSpecificSuggestedInviteCandidatesQuery", "03b05cdb2eef2e26d78cd0b08d29a054", "event", "10154405445201729", RegularImmutableSet.a);
        }

        public final TriState m12836g() {
            return TriState.YES;
        }

        public final String m12835a(String str) {
            switch (str.hashCode()) {
                case -705314112:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventSpecificUninvitableFriendsAndInviteeLimitString extends TypedGraphQlQueryString<EventSpecificUninvitableFriendsAndInviteeLimitModel> {
        public EventSpecificUninvitableFriendsAndInviteeLimitString() {
            super(EventSpecificUninvitableFriendsAndInviteeLimitModel.class, false, "EventSpecificUninvitableFriendsAndInviteeLimit", "9d8bb82f257568af835bb227fd3612d7", "event", "10154661258001729", RegularImmutableSet.a);
        }

        public final TriState m12838g() {
            return TriState.YES;
        }

        public final String m12837a(String str) {
            switch (str.hashCode()) {
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventTicketOrderQueryString extends TypedGraphQlQueryString<EventTicketOrderModel> {
        public EventTicketOrderQueryString() {
            super(EventTicketOrderModel.class, false, "EventTicketOrderQuery", "b6b91ff86c424881d2bc3b8f4c5411b4", "node", "10154601177571729", RegularImmutableSet.a);
        }

        public final String m12839a(String str) {
            switch (str.hashCode()) {
                case 1234304940:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventTicketOrderStatusSubscriptionString extends TypedGraphQLSubscriptionString<EventTicketOrderStatusSubscriptionModel> {
        public EventTicketOrderStatusSubscriptionString() {
            super(EventTicketOrderStatusSubscriptionModel.class, false, "EventTicketOrderStatusSubscription", "ec787a50f403c70c83755e1ef68ceaad", "event_ticket_order_purchase_status_change", "0", "10154651329791729", RegularImmutableSet.a);
        }

        public final String m12840a(String str) {
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

    /* compiled from: num_topresults_to_show */
    public class EventTicketOrdersQueryString extends TypedGraphQlQueryString<EventTicketOrdersQueryModel> {
        public EventTicketOrdersQueryString() {
            super(EventTicketOrdersQueryModel.class, false, "EventTicketOrdersQuery", "bdbcceb44bf292644c4206ce975b7704", "event", "10154650990351729", RegularImmutableSet.a);
        }

        public final String m12841a(String str) {
            switch (str.hashCode()) {
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventTicketingInfoString extends TypedGraphQlQueryString<EventTicketTierFragmentModel> {
        public EventTicketingInfoString() {
            super(EventTicketTierFragmentModel.class, false, "EventTicketingInfo", "0879941f51a451e6c2cb83306458029d", "event", "10154651289991729", RegularImmutableSet.a);
        }

        public final String m12842a(String str) {
            switch (str.hashCode()) {
                case -2098866353:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m12843a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        obj2 = null;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventsSuggestedInviteCandidatesQueryString extends TypedGraphQlQueryString<EventsSuggestedInviteCandidatesQueryModel> {
        public EventsSuggestedInviteCandidatesQueryString() {
            super(EventsSuggestedInviteCandidatesQueryModel.class, false, "EventsSuggestedInviteCandidatesQuery", "71c38fdaec84e7962863268e8cad5809", "viewer", "10153088762816729", RegularImmutableSet.a);
        }

        public final TriState m12845g() {
            return TriState.YES;
        }

        public final String m12844a(String str) {
            switch (str.hashCode()) {
                case -705314112:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class EventsUninvitableFriendsAndInviteeLimitString extends TypedGraphQlQueryString<EventsUninvitableFriendsAndInviteeLimitModel> {
        public EventsUninvitableFriendsAndInviteeLimitString() {
            super(EventsUninvitableFriendsAndInviteeLimitModel.class, false, "EventsUninvitableFriendsAndInviteeLimit", "00ca11ceaef27ca373a8d9188dcb8c25", "viewer", "10154661257991729", RegularImmutableSet.a);
        }

        public final TriState m12846g() {
            return TriState.YES;
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchAllUpcomingEventsQueryString extends TypedGraphQlQueryString<FetchAllUpcomingEventsQueryModel> {
        public FetchAllUpcomingEventsQueryString() {
            super(FetchAllUpcomingEventsQueryModel.class, false, "FetchAllUpcomingEventsQuery", "cac2071bb189e44ddd27dafef5330bac", "me", "10154686241061729", RegularImmutableSet.a);
        }

        public final TriState m12849g() {
            return TriState.YES;
        }

        public final String m12847a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "2";
                case -705314112:
                    return "1";
                case 16907033:
                    return "0";
                case 25209764:
                    return "11";
                case 689802720:
                    return "9";
                case 810737919:
                    return "3";
                case 1262925297:
                    return "4";
                case 1282232523:
                    return "6";
                case 1598177384:
                    return "10";
                case 1639748947:
                    return "7";
                case 1831224761:
                    return "8";
                case 1939875509:
                    return "5";
                default:
                    return str;
            }
        }

        protected final boolean m12848a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchEventCommonQueryString extends TypedGraphQlQueryString<EventCommonFragmentModel> {
        public FetchEventCommonQueryString() {
            super(EventCommonFragmentModel.class, false, "FetchEventCommonQuery", "435b1d150c9083b41ad62e979868e680", "event", "10154686241026729", RegularImmutableSet.a);
        }

        public final TriState m12852g() {
            return TriState.YES;
        }

        public final String m12850a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 25209764:
                    return "10";
                case 278118624:
                    return "0";
                case 689802720:
                    return "8";
                case 810737919:
                    return "2";
                case 1262925297:
                    return "3";
                case 1282232523:
                    return "5";
                case 1598177384:
                    return "9";
                case 1639748947:
                    return "6";
                case 1831224761:
                    return "7";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m12851a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchEventCountsQueryString extends TypedGraphQlQueryString<FetchEventCountsQueryModel> {
        public FetchEventCountsQueryString() {
            super(FetchEventCountsQueryModel.class, false, "FetchEventCountsQuery", "d6e6a756aead695dc1a187e3bf9c354d", "me", "10154341705226729", RegularImmutableSet.a);
        }

        public final TriState m12853g() {
            return TriState.YES;
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchEventGuestListQueryString extends TypedGraphQlQueryString<EventGuestCountsModel> {
        public FetchEventGuestListQueryString() {
            super(EventGuestCountsModel.class, false, "FetchEventGuestListQuery", "1fa173df2f28aa00badbb2da09b22b42", "event", "10154405445041729", RegularImmutableSet.a);
        }

        public final TriState m12855g() {
            return TriState.YES;
        }

        public final String m12854a(String str) {
            switch (str.hashCode()) {
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchEventPermalinkQueryString extends TypedGraphQlQueryString<FetchEventPermalinkFragmentModel> {
        public FetchEventPermalinkQueryString() {
            super(FetchEventPermalinkFragmentModel.class, false, "FetchEventPermalinkQuery", "15dcc535c505e9f15b7cbdaf17d2bcb2", "event", "10154686241086729", RegularImmutableSet.a);
        }

        public final TriState m12858g() {
            return TriState.YES;
        }

        public final String m12856a(String str) {
            switch (str.hashCode()) {
                case -2098866353:
                    return "9";
                case -1363693170:
                    return "13";
                case -1101600581:
                    return "1";
                case -424905717:
                    return "2";
                case 25209764:
                    return "12";
                case 278118624:
                    return "0";
                case 689802720:
                    return "10";
                case 810737919:
                    return "3";
                case 1262925297:
                    return "4";
                case 1282232523:
                    return "6";
                case 1598177384:
                    return "11";
                case 1639748947:
                    return "7";
                case 1831224761:
                    return "8";
                case 1939875509:
                    return "5";
                default:
                    return str;
            }
        }

        protected final boolean m12857a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchEventPromptsString extends TypedGraphQlQueryString<FetchEventPromptsModel> {
        public FetchEventPromptsString() {
            super(FetchEventPromptsModel.class, false, "FetchEventPrompts", "ec17a71b8f1ef281c1378529258c83fe", "viewer", "10154545882566729", RegularImmutableSet.a);
        }

        public final String m12859a(String str) {
            switch (str.hashCode()) {
                case -1585537950:
                    return "5";
                case -1123986632:
                    return "0";
                case -868462805:
                    return "4";
                case -805063587:
                    return "3";
                case -461865705:
                    return "1";
                case -150549552:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchPagedUpcomingBirthdaysQueryString extends TypedGraphQlQueryString<FetchPagedUpcomingBirthdaysQueryModel> {
        public FetchPagedUpcomingBirthdaysQueryString() {
            super(FetchPagedUpcomingBirthdaysQueryModel.class, false, "FetchPagedUpcomingBirthdaysQuery", "e251fd3ac26a3fdfb94f601894577cce", "me", "10154600438051729", RegularImmutableSet.a);
        }

        public final TriState m12861g() {
            return TriState.YES;
        }

        public final String m12860a(String str) {
            switch (str.hashCode()) {
                case -1529153437:
                    return "0";
                case -1101600581:
                    return "4";
                case -705314112:
                    return "3";
                case -529471464:
                    return "1";
                case -77796550:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchPastEventsQueryString extends TypedGraphQlQueryString<FetchPastEventsQueryModel> {
        public FetchPastEventsQueryString() {
            super(FetchPastEventsQueryModel.class, false, "FetchPastEventsQuery", "0716fcd5c076b4cfb7271b3babe9db48", "me", "10154686240951729", RegularImmutableSet.a);
        }

        public final TriState m12864g() {
            return TriState.YES;
        }

        public final String m12862a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 25209764:
                    return "12";
                case 449822380:
                    return "0";
                case 689802720:
                    return "10";
                case 810737919:
                    return "4";
                case 1262925297:
                    return "5";
                case 1282232523:
                    return "7";
                case 1598177384:
                    return "11";
                case 1639748947:
                    return "8";
                case 1831224761:
                    return "9";
                case 1939875509:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m12863a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchSubscribedEventsString extends TypedGraphQlQueryString<FetchSubscribedEventsModel> {
        public FetchSubscribedEventsString() {
            super(FetchSubscribedEventsModel.class, false, "FetchSubscribedEvents", "de3c80e2754c411064b8dc8c84eb9360", "viewer", "10154686241246729", RegularImmutableSet.a);
        }

        public final TriState m12867g() {
            return TriState.YES;
        }

        public final String m12865a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "2";
                case -77796550:
                    return "0";
                case 25209764:
                    return "11";
                case 94851343:
                    return "1";
                case 689802720:
                    return "9";
                case 810737919:
                    return "3";
                case 1262925297:
                    return "4";
                case 1282232523:
                    return "6";
                case 1598177384:
                    return "10";
                case 1639748947:
                    return "7";
                case 1831224761:
                    return "8";
                case 1939875509:
                    return "5";
                default:
                    return str;
            }
        }

        protected final boolean m12866a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchSuggestionsForForCutTypeString extends TypedGraphQlQueryString<FetchSuggestionsForForCutTypeModel> {
        public FetchSuggestionsForForCutTypeString() {
            super(FetchSuggestionsForForCutTypeModel.class, false, "FetchSuggestionsForForCutType", "b0691bd66d762bf1de6495f874c02ed5", "me", "10154686241261729", RegularImmutableSet.a);
        }

        public final TriState m12870g() {
            return TriState.YES;
        }

        public final String m12868a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -940005328:
                    return "12";
                case -77796550:
                    return "11";
                case 25209764:
                    return "10";
                case 615571223:
                    return "0";
                case 689802720:
                    return "8";
                case 810737919:
                    return "2";
                case 1262925297:
                    return "3";
                case 1282232523:
                    return "5";
                case 1598177384:
                    return "9";
                case 1639748947:
                    return "6";
                case 1831224761:
                    return "7";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m12869a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchUpcomingEventsQueryString extends TypedGraphQlQueryString<FetchUpcomingEventsQueryModel> {
        public FetchUpcomingEventsQueryString() {
            super(FetchUpcomingEventsQueryModel.class, false, "FetchUpcomingEventsQuery", "9b203340914588add49f9a775bf65959", "me", "10154686240966729", RegularImmutableSet.a);
        }

        public final TriState m12873g() {
            return TriState.YES;
        }

        public final String m12871a(String str) {
            switch (str.hashCode()) {
                case -1274492040:
                    return "1";
                case -1101600581:
                    return "4";
                case -705314112:
                    return "3";
                case 16907033:
                    return "2";
                case 25209764:
                    return "13";
                case 449822380:
                    return "0";
                case 689802720:
                    return "11";
                case 810737919:
                    return "5";
                case 1262925297:
                    return "6";
                case 1282232523:
                    return "8";
                case 1598177384:
                    return "12";
                case 1639748947:
                    return "9";
                case 1831224761:
                    return "10";
                case 1939875509:
                    return "7";
                default:
                    return str;
            }
        }

        protected final boolean m12872a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class FetchUserSuggestionsString extends TypedGraphQlQueryString<FetchUserSuggestionsModel> {
        public FetchUserSuggestionsString() {
            super(FetchUserSuggestionsModel.class, false, "FetchUserSuggestions", "d4903b76ab0d52fb05b4c2893c63116a", "me", "10154686241271729", RegularImmutableSet.a);
        }

        public final TriState m12876g() {
            return TriState.YES;
        }

        public final String m12874a(String str) {
            switch (str.hashCode()) {
                case -1192877631:
                    return "0";
                case -1101600581:
                    return "1";
                case -940005328:
                    return "12";
                case -77796550:
                    return "11";
                case 25209764:
                    return "10";
                case 689802720:
                    return "8";
                case 810737919:
                    return "2";
                case 1262925297:
                    return "3";
                case 1282232523:
                    return "5";
                case 1598177384:
                    return "9";
                case 1639748947:
                    return "6";
                case 1831224761:
                    return "7";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m12875a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: num_topresults_to_show */
    public class GroupEventFriendInviteCandidatesQueryString extends TypedGraphQlQueryString<GroupEventFriendInviteCandidatesQueryModel> {
        public GroupEventFriendInviteCandidatesQueryString() {
            super(GroupEventFriendInviteCandidatesQueryModel.class, false, "GroupEventFriendInviteCandidatesQuery", "5a1bca5899c76874604b2c8e4e711482", "group", "10154405445191729", RegularImmutableSet.a);
        }

        public final TriState m12878g() {
            return TriState.YES;
        }

        public final String m12877a(String str) {
            switch (str.hashCode()) {
                case -1538382094:
                    return "2";
                case 16907033:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchEventCountsQueryString m12880a() {
        return new FetchEventCountsQueryString();
    }

    public static final FetchEventPermalinkQueryString m12881b() {
        return new FetchEventPermalinkQueryString();
    }

    public static final FetchEventCommonQueryString m12882d() {
        return new FetchEventCommonQueryString();
    }

    public static final FetchUpcomingEventsQueryString m12883f() {
        return new FetchUpcomingEventsQueryString();
    }

    public static final FetchPastEventsQueryString m12884g() {
        return new FetchPastEventsQueryString();
    }

    public static final FetchEventPromptsString m12885i() {
        return new FetchEventPromptsString();
    }

    public static final EventSpecificSuggestedInviteCandidatesQueryString m12886o() {
        return new EventSpecificSuggestedInviteCandidatesQueryString();
    }

    public static final EventSpecificUninvitableFriendsAndInviteeLimitString m12887p() {
        return new EventSpecificUninvitableFriendsAndInviteeLimitString();
    }

    public static final EventTicketOrderStatusSubscriptionString m12879T() {
        return new EventTicketOrderStatusSubscriptionString();
    }
}
