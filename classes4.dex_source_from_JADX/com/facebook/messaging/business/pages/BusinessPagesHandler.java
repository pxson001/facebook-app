package com.facebook.messaging.business.pages;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.contacts.pictures.ContactPictureSizes.Size;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueries.BYMMQueryString;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueries.BusinessUserHasMessagedQueryString;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueries.SuggestedBotsQueryString;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.BYMMQueryModel;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.BusinessMessagingPageModel;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.BusinessUserHasMessagedQueryModel;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.SuggestedBotsQueryModel;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.fetch.GQLUserRequestHelper;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_privacy_saved */
public class BusinessPagesHandler {
    private final GraphQLQueryExecutor f13329a;
    private final DefaultAndroidThreadUtil f13330b;
    private final GQLUserConverter f13331c;
    private final GQLUserRequestHelper f13332d;
    private final ContactPictureSizes f13333e;

    public static BusinessPagesHandler m14253b(InjectorLike injectorLike) {
        return new BusinessPagesHandler(GraphQLQueryExecutor.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), GQLUserConverter.m14119a(injectorLike), GQLUserRequestHelper.m14157b(injectorLike), ContactPictureSizes.m14161a(injectorLike));
    }

    @Inject
    public BusinessPagesHandler(GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GQLUserConverter gQLUserConverter, GQLUserRequestHelper gQLUserRequestHelper, ContactPictureSizes contactPictureSizes) {
        this.f13329a = graphQLQueryExecutor;
        this.f13330b = defaultAndroidThreadUtil;
        this.f13331c = gQLUserConverter;
        this.f13332d = gQLUserRequestHelper;
        this.f13333e = contactPictureSizes;
    }

    public static BusinessPagesHandler m14250a(InjectorLike injectorLike) {
        return m14253b(injectorLike);
    }

    @Nullable
    public final ImmutableList<User> m14254a() {
        this.f13330b.b();
        GraphQlQueryString businessUserHasMessagedQueryString = new BusinessUserHasMessagedQueryString();
        businessUserHasMessagedQueryString.a("max_pages_to_fetch", Integer.valueOf(30));
        this.f13332d.m14160a(businessUserHasMessagedQueryString);
        BusinessUserHasMessagedQueryModel businessUserHasMessagedQueryModel = (BusinessUserHasMessagedQueryModel) ((GraphQLResult) FutureDetour.a(this.f13329a.a(GraphQLRequest.a(businessUserHasMessagedQueryString).a(GraphQLCachePolicy.a).a(600)), 935310229)).e;
        if (businessUserHasMessagedQueryModel == null || businessUserHasMessagedQueryModel.a() == null) {
            return null;
        }
        return m14251a(businessUserHasMessagedQueryModel.a().a());
    }

    @Nullable
    public final ImmutableList<User> m14255a(int i) {
        this.f13330b.b();
        GraphQlQueryString bYMMQueryString = new BYMMQueryString();
        bYMMQueryString.a("max_pages_to_fetch", Integer.valueOf(i));
        m14252a(bYMMQueryString);
        BYMMQueryModel bYMMQueryModel = (BYMMQueryModel) ((GraphQLResult) FutureDetour.a(this.f13329a.a(GraphQLRequest.a(bYMMQueryString).a(GraphQLCachePolicy.a).a(600)), 719028422)).e;
        if (bYMMQueryModel == null || bYMMQueryModel.a() == null) {
            return null;
        }
        return m14251a(bYMMQueryModel.a().a());
    }

    @Nullable
    public final ImmutableList<User> m14256b(int i) {
        this.f13330b.b();
        GraphQlQueryString suggestedBotsQueryString = new SuggestedBotsQueryString();
        suggestedBotsQueryString.a("max_pages_to_fetch", Integer.valueOf(i));
        m14252a(suggestedBotsQueryString);
        SuggestedBotsQueryModel suggestedBotsQueryModel = (SuggestedBotsQueryModel) ((GraphQLResult) FutureDetour.a(this.f13329a.a(GraphQLRequest.a(suggestedBotsQueryString).a(GraphQLCachePolicy.a).a(600)), -2127922808)).e;
        if (suggestedBotsQueryModel == null || suggestedBotsQueryModel.a() == null) {
            return null;
        }
        return m14251a(suggestedBotsQueryModel.a().a());
    }

    private void m14252a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.a("profile_pic_large_size", Integer.valueOf(this.f13333e.m14163a(Size.HUGE))).a("profile_pic_medium_size", Integer.valueOf(this.f13333e.m14163a(Size.BIG))).a("profile_pic_small_size", Integer.valueOf(this.f13333e.m14163a(Size.SMALL)));
    }

    @Nullable
    private ImmutableList<User> m14251a(ImmutableList<BusinessMessagingPageModel> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            BusinessMessagingPageModel businessMessagingPageModel = (BusinessMessagingPageModel) immutableList.get(i);
            PicSquare a = GQLUserConverter.m14126a(businessMessagingPageModel.o(), businessMessagingPageModel.n(), businessMessagingPageModel.m());
            UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, businessMessagingPageModel.j());
            a2.g = new Name(businessMessagingPageModel.l());
            a2 = a2;
            a2.p = a;
            UserBuilder userBuilder = a2;
            userBuilder.A = businessMessagingPageModel.k();
            UserBuilder userBuilder2 = userBuilder;
            userBuilder2.z = "page";
            builder.c(userBuilder2.aa());
        }
        return builder.b();
    }
}
