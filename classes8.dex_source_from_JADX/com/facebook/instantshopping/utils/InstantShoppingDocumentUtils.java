package com.facebook.instantshopping.utils;

import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingCatalogQueryModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingProductQueryModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.RichMediaDocumentQueryModel;

/* compiled from: unrecognized id =  */
public class InstantShoppingDocumentUtils<T extends GraphQLVisitableModel> {
    public static <T> InstantShoppingDocumentFragmentModel m1346a(T t) {
        if (t instanceof InstantShoppingCatalogQueryModel) {
            return ((InstantShoppingCatalogQueryModel) t).m910a();
        }
        if (t instanceof InstantShoppingProductQueryModel) {
            return ((InstantShoppingProductQueryModel) t).m1189a();
        }
        if (t instanceof RichMediaDocumentQueryModel) {
            return ((RichMediaDocumentQueryModel) t).m1227j();
        }
        return null;
    }
}
