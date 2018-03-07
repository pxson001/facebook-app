package com.facebook.events.graphql;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.events.graphql.EventsGraphQLModels.EventCardFragmentModel.CoverPhotoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.CreatedForGroupModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventCategoryLabelModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventCreatorModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventHostsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.ParentGroupModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMaybesFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMembersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventWatchersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.SuggestedEventContextSentenceModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventViewerCapabilityModel;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: num_server_contacts */
public class EventsGraphQLInterfaces {

    /* compiled from: num_server_contacts */
    public interface EventBaseFragment {
        long mo968b();

        @Nullable
        DefaultImageFields mo969c();

        @Nullable
        EventPlaceModel mo970d();

        @Nullable
        String dL_();

        @Nullable
        String dM_();

        long dN_();

        boolean mo974g();
    }

    /* compiled from: num_server_contacts */
    public interface EventCardFragment extends EventBaseFragment {
        long mo968b();

        @Nullable
        DefaultImageFields mo969c();

        @Nullable
        EventPlaceModel mo970d();

        @Nullable
        String dL_();

        @Nullable
        String dM_();

        long dN_();

        boolean mo974g();

        boolean mo975j();

        @Nullable
        GraphQLConnectionStyle mo976k();

        @Nullable
        CoverPhotoModel mo977l();

        boolean mo978m();

        @Nullable
        String mo979n();

        @Nullable
        GraphQLEventGuestStatus mo980o();

        boolean mo981p();

        @Nullable
        GraphQLEventWatchStatus mo982q();
    }

    /* compiled from: num_server_contacts */
    public interface EventSocialContextFields {

        /* compiled from: num_server_contacts */
        public interface EventMembers {
            int mo1015a();
        }
    }

    /* compiled from: num_server_contacts */
    public interface EventCommonFragment extends EventCardFragment, EventSocialContextFields {
        @Nullable
        EventHostsModel mo983A();

        @Nullable
        GraphQLEventPrivacyType mo984B();

        @Nullable
        GraphQLBoostedPostStatus mo985C();

        @Nullable
        GraphQLEventType mo986D();

        @Nullable
        EventViewerCapabilityModel mo987E();

        @Nullable
        GraphQLEventVisibility mo988F();

        @Nullable
        FriendEventMaybesFirst5Model mo989G();

        @Nullable
        FriendEventMembersFirst5Model mo990H();

        @Nullable
        FriendEventWatchersFirst5Model mo991I();

        boolean mo992J();

        boolean mo993K();

        @Nullable
        ParentGroupModel mo994L();

        boolean mo995M();

        @Nullable
        SavableTimelineAppCollection mo996N();

        long mo997O();

        @Nullable
        SuggestedEventContextSentenceModel mo998P();

        @Nonnull
        ImmutableList<? extends UserInEventFragment> mo999Q();

        @Nullable
        GraphQLSavedState mo1000R();

        long mo968b();

        @Nullable
        DefaultImageFields mo969c();

        @Nullable
        EventPlaceModel mo970d();

        @Nullable
        String dL_();

        @Nullable
        String dM_();

        long dN_();

        boolean mo974g();

        boolean mo975j();

        @Nullable
        GraphQLConnectionStyle mo976k();

        @Nullable
        CoverPhotoModel mo977l();

        boolean mo978m();

        @Nullable
        String mo979n();

        @Nullable
        GraphQLEventGuestStatus mo980o();

        boolean mo981p();

        @Nullable
        GraphQLEventWatchStatus mo982q();

        @Nullable
        GraphQLEventActionStyle mo1001r();

        boolean mo1002s();

        boolean mo1003t();

        boolean mo1004u();

        @Nullable
        CreatedForGroupModel mo1005v();

        @Nullable
        EventCategoryLabelModel mo1006w();

        @Nullable
        String mo1007x();

        @Nullable
        EventCreatorModel mo1008y();

        @Nullable
        EventCommonTextWithEntitiesModel mo1009z();
    }

    /* compiled from: num_server_contacts */
    public interface UserInEventFragment {
        @Nullable
        String mo1010b();

        @Nullable
        String mo1011c();

        @Nullable
        DefaultImageFields mo1012d();

        @Nullable
        GraphQLFriendshipStatus dR_();

        @Nullable
        GraphQLObjectType mo1014g();
    }

    /* compiled from: num_server_contacts */
    public interface EventTicketTierPermalinkFragment {
    }
}
