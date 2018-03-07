package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOTE */
public class GraphQLProductItemSerializer extends JsonSerializer<GraphQLProductItem> {
    public final void m21092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProductItem graphQLProductItem = (GraphQLProductItem) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLProductItem.m21074j() != null) {
            jsonGenerator.a("checkout_url", graphQLProductItem.m21074j());
        }
        if (graphQLProductItem.m21075k() != null) {
            jsonGenerator.a("commerce_checkout_style", graphQLProductItem.m21075k().toString());
        }
        jsonGenerator.a("commerce_featured_item", graphQLProductItem.m21076l());
        jsonGenerator.a("commerce_inventory", graphQLProductItem.m21077m());
        if (graphQLProductItem.m21078n() != null) {
            jsonGenerator.a("commerce_product_visibility", graphQLProductItem.m21078n().toString());
        }
        jsonGenerator.a("creation_time", graphQLProductItem.m21079o());
        if (graphQLProductItem.m21080p() != null) {
            jsonGenerator.a("current_price");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLProductItem.m21080p(), true);
        }
        if (graphQLProductItem.m21081q() != null) {
            jsonGenerator.a("description", graphQLProductItem.m21081q());
        }
        if (graphQLProductItem.m21082r() != null) {
            jsonGenerator.a("experimental_freeform_price", graphQLProductItem.m21082r());
        }
        if (graphQLProductItem.m21083s() != null) {
            jsonGenerator.a("external_url", graphQLProductItem.m21083s());
        }
        if (graphQLProductItem.m21084t() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21084t(), true);
        }
        if (graphQLProductItem.m21085u() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLProductItem.m21085u(), true);
        }
        if (graphQLProductItem.m21086v() != null) {
            jsonGenerator.a("front_view_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21086v(), true);
        }
        if (graphQLProductItem.m21087w() != null) {
            jsonGenerator.a("id", graphQLProductItem.m21087w());
        }
        if (graphQLProductItem.m21088x() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21088x(), true);
        }
        if (graphQLProductItem.m21089y() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21089y(), true);
        }
        jsonGenerator.a("images");
        if (graphQLProductItem.m21090z() != null) {
            jsonGenerator.d();
            for (GraphQLImage graphQLImage : graphQLProductItem.m21090z()) {
                if (graphQLImage != null) {
                    GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProductItem.m21044A() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLProductItem.m21044A(), true);
        }
        jsonGenerator.a("is_on_sale", graphQLProductItem.m21045B());
        if (graphQLProductItem.m21046C() != null) {
            jsonGenerator.a("item_availability", graphQLProductItem.m21046C().toString());
        }
        jsonGenerator.a("item_details");
        if (graphQLProductItem.m21047D() != null) {
            jsonGenerator.d();
            for (String str : graphQLProductItem.m21047D()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProductItem.m21048E() != null) {
            jsonGenerator.a("item_price");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLProductItem.m21048E(), true);
        }
        if (graphQLProductItem.m21049F() != null) {
            jsonGenerator.a("merchant_logo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21049F(), true);
        }
        if (graphQLProductItem.m21050G() != null) {
            jsonGenerator.a("name", graphQLProductItem.m21050G());
        }
        if (graphQLProductItem.m21051H() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLProductItem.m21051H(), true);
        }
        if (graphQLProductItem.m21052I() != null) {
            jsonGenerator.a("parent_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLProductItem.m21052I(), true);
        }
        jsonGenerator.a("platform_images");
        if (graphQLProductItem.m21053J() != null) {
            jsonGenerator.d();
            for (GraphQLImage graphQLImage2 : graphQLProductItem.m21053J()) {
                if (graphQLImage2 != null) {
                    GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImage2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProductItem.m21054K() != null) {
            jsonGenerator.a("productCatalogImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21054K(), true);
        }
        if (graphQLProductItem.m21055L() != null) {
            jsonGenerator.a("productImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21055L(), true);
        }
        if (graphQLProductItem.m21056M() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21056M(), true);
        }
        if (graphQLProductItem.m21057N() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21057N(), true);
        }
        if (graphQLProductItem.m21058O() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21058O(), true);
        }
        if (graphQLProductItem.m21059P() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21059P(), true);
        }
        if (graphQLProductItem.m21060Q() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21060Q(), true);
        }
        if (graphQLProductItem.m21061R() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLProductItem.m21061R(), true);
        }
        if (graphQLProductItem.m21062S() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21062S(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLProductItem.m21063T());
        if (graphQLProductItem.m21064U() != null) {
            jsonGenerator.a("reference_url", graphQLProductItem.m21064U());
        }
        if (graphQLProductItem.m21065V() != null) {
            jsonGenerator.a("sale_price");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLProductItem.m21065V(), true);
        }
        if (graphQLProductItem.m21066W() != null) {
            jsonGenerator.a("seller");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLProductItem.m21066W(), true);
        }
        if (graphQLProductItem.m21067X() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLProductItem.m21067X(), true);
        }
        if (graphQLProductItem.m21068Y() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProductItem.m21068Y(), true);
        }
        if (graphQLProductItem.m21069Z() != null) {
            jsonGenerator.a("url", graphQLProductItem.m21069Z());
        }
        jsonGenerator.a("variant_values");
        if (graphQLProductItem.aa() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLProductItem.aa()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProductItem.ab() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLProductItem.ab().toString());
        }
        jsonGenerator.a("product_latitude", graphQLProductItem.ac());
        jsonGenerator.a("product_longitude", graphQLProductItem.ad());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLProductItem.class, new GraphQLProductItemSerializer());
    }
}
