package com.facebook.instantshopping.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQL.InstantShoppingCatalogQueryString;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQL.InstantShoppingProductQueryString;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQL.RichMediaDocumentQueryString;
import com.facebook.richdocument.fetcher.FetchDefaults;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

/* compiled from: unread_count  */
public class InstantShoppingFetchParams<T extends GraphQLVisitableModel> implements RichDocumentFetchParams<GraphQLRequest<T>> {
    public String f1113a;
    public String f1114b;
    public final String f1115c;
    public String f1116d;
    public String f1117e;
    public String f1118f;
    public boolean f1119g;
    public boolean f1120h;
    public final int f1121i;
    public final int f1122j;
    public int f1123k;
    public GraphQLCachePolicy f1124l;

    public InstantShoppingFetchParams(Context context, String str) {
        this.f1123k = 1000;
        this.f1124l = FetchDefaults.f5222c;
        this.f1115c = str;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f1121i = displayMetrics.widthPixels;
        this.f1122j = displayMetrics.heightPixels;
    }

    public InstantShoppingFetchParams(Context context) {
        this.f1123k = 1000;
        this.f1124l = FetchDefaults.f5222c;
        this.f1115c = null;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f1121i = displayMetrics.widthPixels;
        this.f1122j = displayMetrics.heightPixels;
    }

    public final Object mo21a() {
        GraphQlQueryString graphQlQueryString;
        boolean z = this.f1120h;
        if (Strings.isNullOrEmpty(this.f1116d)) {
            Object obj;
            if (Strings.isNullOrEmpty(this.f1113a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                graphQlQueryString = (TypedGraphQlQueryString) new InstantShoppingProductQueryString().a("shoppingCatalogID", this.f1115c).a("maxElements", Integer.valueOf(this.f1123k)).a("product_id", this.f1113a).a("product_view", this.f1114b);
            } else {
                graphQlQueryString = (TypedGraphQlQueryString) new InstantShoppingCatalogQueryString().a("shoppingCatalogID", this.f1115c).a("view", this.f1118f).a("maxElements", Integer.valueOf(this.f1123k));
            }
        } else {
            graphQlQueryString = (TypedGraphQlQueryString) new RichMediaDocumentQueryString().a("documentID", this.f1116d).a("maxElements", Integer.valueOf(this.f1123k));
        }
        if (z) {
            graphQlQueryString.a("final_image_width", Integer.valueOf(this.f1121i)).a("final_image_width", Integer.valueOf(this.f1122j));
        }
        GraphQLRequest a = GraphQLRequest.a(graphQlQueryString);
        a.a(300);
        a.a(this.f1124l);
        a.e = ImmutableSet.of(this.f1117e);
        return a;
    }
}
