package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.enums.GraphQLShipmentTrackingEventType;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsInterfaces.PlatformCallToAction;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceOrderCancellationBubbleModel.CancelledItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceOrderReceiptBubbleModel.RetailItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommercePromotionsModel.PromotionItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: videos_status_fetch */
public class CommerceThreadFragmentsInterfaces {

    /* compiled from: videos_status_fetch */
    public interface CommerceBaseOrderReceipt {
        @Nullable
        String aC_();

        @Nullable
        String aD_();

        @Nullable
        CommerceLocationModel aE_();

        @Nullable
        String aH_();

        @Nullable
        String ar_();

        @Nullable
        String as_();

        @Nullable
        LogoImage at_();

        @Nullable
        GraphQLMessengerCommerceBubbleType mo57b();

        @Nullable
        String mo58c();
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceShipmentBubble {
        @Nullable
        String mo60A();

        @Nullable
        RetailCarrierModel mo61B();

        @Nullable
        RetailShipmentItemsModel mo62C();

        @Nullable
        String mo63D();

        @Nullable
        String mo64E();

        @Nullable
        ShipmentTrackingEventsModel mo65F();

        @Nullable
        String mo66G();

        @Nullable
        GraphQLMessengerCommerceBubbleType mo67b();

        @Nullable
        String mo68c();

        @Nullable
        String mo69v();

        @Nullable
        CommerceLocationModel mo70w();

        @Nullable
        CommerceLocationModel mo71x();

        @Nullable
        String mo72y();

        @Nullable
        String mo73z();
    }

    /* compiled from: videos_status_fetch */
    public interface BusinessMessage {
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceBaseShipmentTracking {
        @Nullable
        GraphQLMessengerCommerceBubbleType mo77b();

        @Nullable
        String mo78c();

        @Nullable
        CommerceLocationModel mo79l();

        @Nullable
        GraphQLShipmentTrackingEventType mo80m();

        @Nullable
        String mo81n();

        @Nullable
        String mo82o();
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceOrderCancellationBubble {
        @Nullable
        String mo83c();

        @Nullable
        CancelledItemsModel mo84p();

        @Nullable
        CommerceBaseOrderReceipt mo85q();
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceOrderReceiptBubble extends CommerceBaseOrderReceipt {
        @Nullable
        String aC_();

        @Nullable
        String aD_();

        @Nullable
        CommerceLocationModel aE_();

        @Nullable
        String aH_();

        @Nullable
        String ar_();

        @Nullable
        String as_();

        @Nullable
        LogoImage at_();

        @Nullable
        String mo58c();

        @Nullable
        RetailItemsModel mo86r();
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceRetailItem {
        @Nonnull
        ImmutableList<? extends PlatformCallToAction> aB_();

        @Nullable
        String aF_();

        @Nullable
        String aG_();

        @Nullable
        String ax_();

        @Nullable
        String ay_();

        @Nullable
        String az_();

        @Nullable
        String mo96c();

        @Nullable
        String mo97d();

        @Nullable
        String mo98g();

        @Nullable
        String mo99j();

        @Nullable
        GraphQLMessengerRetailItemStatus mo100k();
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceProductSubscriptionBubble {

        /* compiled from: videos_status_fetch */
        public interface PartnerLogo {
            int mo87a();

            @Nullable
            String mo88b();

            int mo89c();
        }

        @Nullable
        String mo101c();

        @Nullable
        PartnerLogo mo102s();

        @Nullable
        SubscribedItemModel mo103t();
    }

    /* compiled from: videos_status_fetch */
    public interface CommercePromotions {
        @Nonnull
        ImmutableList<? extends PlatformCallToAction> aB_();

        @Nullable
        LogoImage at_();

        @Nullable
        String mo106c();

        @Nullable
        String mo107g();

        @Nullable
        PromotionItemsModel mo108u();
    }

    /* compiled from: videos_status_fetch */
    public interface CommerceShipmentTrackingBubble extends CommerceBaseShipmentTracking {
        @Nullable
        CommerceShipmentBubble mo109H();
    }

    /* compiled from: videos_status_fetch */
    public interface LogoImage {
        int mo110a();

        @Nullable
        String mo111b();

        int mo112c();
    }
}
