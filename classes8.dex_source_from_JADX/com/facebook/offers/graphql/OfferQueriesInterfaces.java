package com.facebook.offers.graphql;

import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel.MessageModel;
import com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel.PhotoModel;
import com.facebook.offers.graphql.OfferQueriesModels.ImageDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferOwnerModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferStoryFieldsModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferViewDataModel;
import javax.annotation.Nullable;

/* compiled from: current_location_tapped */
public class OfferQueriesInterfaces {

    /* compiled from: current_location_tapped */
    public interface CouponData {
        @Nullable
        GraphQLCouponClaimLocation mo985b();

        long mo986c();

        int mo987d();

        @Nullable
        String mo988g();

        boolean mo989j();

        boolean jL_();

        boolean jM_();

        boolean jN_();

        @Nullable
        MessageModel mo993k();

        @Nullable
        String mo994l();

        @Nullable
        OfferOwnerModel mo995m();

        @Nullable
        PhotoModel mo996n();

        @Nullable
        String mo997o();

        @Nullable
        String mo998p();

        @Nullable
        String mo999q();

        @Nullable
        String mo1000r();
    }

    /* compiled from: current_location_tapped */
    public interface OfferClaimData {
        @Nullable
        OfferStoryFieldsModel mo1001A();

        @Nullable
        OfferStoryFieldsModel mo1002B();

        @Nullable
        String mo1003g();

        @Nullable
        String mo1004s();

        long mo1005t();

        @Nullable
        ImageDataModel mo1006u();

        boolean mo1007v();

        boolean mo1008w();

        @Nullable
        OfferDataModel mo1009x();

        @Nullable
        String mo1010y();

        @Nullable
        OfferViewDataModel mo1011z();
    }
}
