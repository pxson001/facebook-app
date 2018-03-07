package com.facebook.heisman;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.SequentialTailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.heisman.protocol.CategoryBrowserGraphQL.CategoryBrowserQueryString;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLModels.CategoryBrowserQueryModel;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLModels.ProfileOverlayCategoryWithPageLimitFieldsModel;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Provider;

/* compiled from: video_failed */
public class CategoryBrowserConnectionConfiguration extends Configuration {
    private static final CallerContext f567b = CallerContext.a(CategoryBrowserConnectionConfiguration.class, "timeline");
    @Inject
    public volatile Provider<GraphQLStoryHelper> f568a = UltralightRuntime.a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f569c = UltralightRuntime.b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: video_failed */
    public @interface ViewType {
    }

    public final String mo20a() {
        return "ProfilePictureOverlayCategoryBrowser";
    }

    public final GraphQLRequest mo19a(TailFetchLocation tailFetchLocation) {
        GraphQLRequest a = GraphQLRequest.a((CategoryBrowserQueryString) new CategoryBrowserQueryString().a("image_high_width", ((GraphQLStoryHelper) this.f568a.get()).x()).a("page_logo_size", Integer.valueOf(GraphQlQueryDefaults.c()))).a(RequestPriority.INTERACTIVE);
        a.f = f567b;
        return a;
    }

    public final RowIterator mo18a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList();
        CategoryBrowserQueryModel categoryBrowserQueryModel = (CategoryBrowserQueryModel) BufferRowArrayList.a((CategoryBrowserQueryModel) graphQLResult.d());
        if (categoryBrowserQueryModel.a() == null || categoryBrowserQueryModel.a().a().isEmpty()) {
            ((AbstractFbErrorReporter) this.f569c.get()).b("category_browser_malformed_data", "Missing list of categories");
            return new SequentialTailRowIterator(categoryBrowserQueryModel, bufferRowArrayList, tailFetchLocation, null, false);
        }
        ImmutableList a = categoryBrowserQueryModel.a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ProfileOverlayCategoryWithPageLimitFieldsModel profileOverlayCategoryWithPageLimitFieldsModel = (ProfileOverlayCategoryWithPageLimitFieldsModel) a.get(i);
            if (profileOverlayCategoryWithPageLimitFieldsModel.j() == null) {
                ((AbstractFbErrorReporter) this.f569c.get()).b("category_browser_malformed_data", StringFormatUtil.a("null pages connection for category %s", new Object[]{profileOverlayCategoryWithPageLimitFieldsModel.b()}));
            } else {
                bufferRowArrayList.a(profileOverlayCategoryWithPageLimitFieldsModel.u_(), profileOverlayCategoryWithPageLimitFieldsModel.getClass(), null, 0);
                ImmutableList a2 = profileOverlayCategoryWithPageLimitFieldsModel.j().a();
                int size2 = a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = (ProfileOverlayCategoryPageFieldsModel) a2.get(i2);
                    bufferRowArrayList.a(profileOverlayCategoryPageFieldsModel.u_(), profileOverlayCategoryPageFieldsModel.getClass(), null, 1);
                }
                if (profileOverlayCategoryWithPageLimitFieldsModel.j().j() != null && profileOverlayCategoryWithPageLimitFieldsModel.j().j().a()) {
                    bufferRowArrayList.a(profileOverlayCategoryWithPageLimitFieldsModel.u_(), profileOverlayCategoryWithPageLimitFieldsModel.getClass(), null, 2);
                }
            }
        }
        return new SequentialTailRowIterator(categoryBrowserQueryModel, bufferRowArrayList, tailFetchLocation, null, false);
    }
}
