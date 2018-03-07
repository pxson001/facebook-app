package com.facebook.heisman;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.SequentialTailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.heisman.protocol.CategoryBrowserGraphQL.CategoryBrowserSearchQueryString;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLModels.CategoryBrowserSearchQueryModel;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: video_attachment */
public class CategoryBrowserSearchConnectionConfiguration extends Configuration {
    private static final CallerContext f598c = CallerContext.a(CategoryBrowserSearchConnectionConfiguration.class, "profile_picture_overlay");
    @Inject
    public volatile Provider<FbErrorReporter> f599a = UltralightRuntime.a;
    @Inject
    public volatile Provider<GraphQLStoryHelper> f600b = UltralightRuntime.a;
    private final String f601d;

    @Inject
    public CategoryBrowserSearchConnectionConfiguration(@Assisted String str) {
        this.f601d = str;
    }

    public final String mo20a() {
        return "ProfilePictureOverlayCategoryBrowserSearch";
    }

    public final GraphQLRequest mo19a(TailFetchLocation tailFetchLocation) {
        GraphQLRequest a = GraphQLRequest.a((CategoryBrowserSearchQueryString) new CategoryBrowserSearchQueryString().a("image_high_width", ((GraphQLStoryHelper) this.f600b.get()).x()).a("page_logo_size", Integer.valueOf(GraphQlQueryDefaults.c())).a("query", this.f601d)).a(RequestPriority.INTERACTIVE);
        a.f = f598c;
        return a;
    }

    public final RowIterator mo18a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList();
        CategoryBrowserSearchQueryModel categoryBrowserSearchQueryModel = (CategoryBrowserSearchQueryModel) BufferRowArrayList.a((CategoryBrowserSearchQueryModel) graphQLResult.e);
        if (categoryBrowserSearchQueryModel.a() == null) {
            ((AbstractFbErrorReporter) this.f599a.get()).b("category_browser_search_invalid_model", "Null pages in search query model");
            return new SequentialTailRowIterator(categoryBrowserSearchQueryModel, bufferRowArrayList, tailFetchLocation, null, false);
        }
        ImmutableList a = categoryBrowserSearchQueryModel.a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = (ProfileOverlayCategoryPageFieldsModel) a.get(i);
            if (ProfileOverlayCategoryPageFieldsValidator.m645a(profileOverlayCategoryPageFieldsModel)) {
                bufferRowArrayList.a(profileOverlayCategoryPageFieldsModel.u_(), profileOverlayCategoryPageFieldsModel.getClass(), null, 1);
            }
        }
        return new SequentialTailRowIterator(categoryBrowserSearchQueryModel, bufferRowArrayList, tailFetchLocation, null, false);
    }
}
