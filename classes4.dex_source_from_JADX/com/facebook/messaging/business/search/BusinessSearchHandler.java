package com.facebook.messaging.business.search;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.fetch.GQLUserRequestHelper;
import com.facebook.messaging.graphql.threads.ThreadQueries.BusinessNameSearchQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueries.BusinessPageSearchQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.BusinessNameSearchQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.BusinessPageQueryFragmentModel;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: eligible_for_audience_alignment_only_me_education */
public class BusinessSearchHandler {
    private final DefaultAndroidThreadUtil f13256a;
    private final BusinessSearchGatekeeperUtil f13257b;
    private final DataCache f13258c;
    private final GatekeeperStoreImpl f13259d;
    private final GraphQLQueryExecutor f13260e;
    private final GQLUserConverter f13261f;
    private final GQLUserRequestHelper f13262g;
    private final UserCache f13263h;

    public static BusinessSearchHandler m14116b(InjectorLike injectorLike) {
        return new BusinessSearchHandler(DefaultAndroidThreadUtil.b(injectorLike), BusinessSearchGatekeeperUtil.m13108b(injectorLike), DataCache.m10341a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GQLUserConverter.m14119a(injectorLike), GQLUserRequestHelper.m14157b(injectorLike), UserCache.m10371a(injectorLike));
    }

    public static BusinessSearchHandler m14112a(InjectorLike injectorLike) {
        return m14116b(injectorLike);
    }

    @Inject
    public BusinessSearchHandler(DefaultAndroidThreadUtil defaultAndroidThreadUtil, BusinessSearchGatekeeperUtil businessSearchGatekeeperUtil, DataCache dataCache, GatekeeperStoreImpl gatekeeperStoreImpl, GraphQLQueryExecutor graphQLQueryExecutor, GQLUserConverter gQLUserConverter, GQLUserRequestHelper gQLUserRequestHelper, UserCache userCache) {
        this.f13256a = defaultAndroidThreadUtil;
        this.f13257b = businessSearchGatekeeperUtil;
        this.f13258c = dataCache;
        this.f13259d = gatekeeperStoreImpl;
        this.f13260e = graphQLQueryExecutor;
        this.f13261f = gQLUserConverter;
        this.f13262g = gQLUserRequestHelper;
        this.f13263h = userCache;
    }

    public final ImmutableList<User> m14118a(String str, int i) {
        this.f13256a.b();
        GraphQlQueryString businessNameSearchQueryString = new BusinessNameSearchQueryString();
        businessNameSearchQueryString.a("results_limit", Integer.valueOf(i)).a("name_search_string", str);
        businessNameSearchQueryString.a("include_full_user_info", Boolean.TRUE.toString());
        this.f13262g.m14160a(businessNameSearchQueryString);
        BusinessNameSearchQueryModel businessNameSearchQueryModel = (BusinessNameSearchQueryModel) ((GraphQLResult) FutureDetour.a(this.f13260e.a(GraphQLRequest.a(businessNameSearchQueryString).a(GraphQLCachePolicy.a).a(600)), -1179126462)).e;
        if (businessNameSearchQueryModel.a() == null) {
            return RegularImmutableList.a;
        }
        return m14115a(businessNameSearchQueryModel.a().a());
    }

    private User m14114a(String str) {
        this.f13256a.b();
        GraphQlQueryString businessPageSearchQueryString = new BusinessPageSearchQueryString();
        businessPageSearchQueryString.a("include_full_user_info", Boolean.TRUE.toString());
        this.f13262g.m14160a(businessPageSearchQueryString);
        businessPageSearchQueryString.a("business_page_id", str);
        BusinessPageQueryFragmentModel businessPageQueryFragmentModel = (BusinessPageQueryFragmentModel) ((GraphQLResult) FutureDetour.a(this.f13260e.a(GraphQLRequest.a(businessPageSearchQueryString).a(GraphQLCachePolicy.a).a(600)), -1036914438)).e;
        return businessPageQueryFragmentModel == null ? null : m14113a(businessPageQueryFragmentModel);
    }

    @Nullable
    public final User m14117a() {
        if (!this.f13257b.m13110b()) {
            return null;
        }
        User a = this.f13263h.m10373a(UserKey.b("881263441913087"));
        if (a == null) {
            return m14114a("881263441913087");
        }
        return a;
    }

    private ImmutableList<User> m14115a(@Nullable ImmutableList<BusinessPageQueryFragmentModel> immutableList) {
        Builder builder = ImmutableList.builder();
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(m14113a((BusinessPageQueryFragmentModel) immutableList.get(i)));
            }
        }
        return builder.b();
    }

    private User m14113a(BusinessPageQueryFragmentModel businessPageQueryFragmentModel) {
        CommercePageType commercePageType;
        Preconditions.checkNotNull(businessPageQueryFragmentModel);
        PicSquare a = GQLUserConverter.m14126a(businessPageQueryFragmentModel.o(), businessPageQueryFragmentModel.n(), businessPageQueryFragmentModel.m());
        UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, businessPageQueryFragmentModel.k());
        a2.g = new Name(businessPageQueryFragmentModel.l());
        a2 = a2;
        a2.l = businessPageQueryFragmentModel.p();
        a2 = a2;
        a2.p = a;
        UserBuilder userBuilder = a2;
        userBuilder.B = true;
        userBuilder = userBuilder;
        userBuilder.A = true;
        userBuilder = userBuilder;
        userBuilder.z = "page";
        userBuilder = userBuilder;
        if (businessPageQueryFragmentModel.j() != null) {
            switch (1.a[businessPageQueryFragmentModel.j().ordinal()]) {
                case 1:
                    commercePageType = CommercePageType.COMMERCE_PAGE_TYPE_AGENT;
                    break;
                case 2:
                    commercePageType = CommercePageType.COMMERCE_PAGE_TYPE_BANK;
                    break;
                case 3:
                    commercePageType = CommercePageType.COMMERCE_PAGE_TYPE_BUSINESS;
                    break;
                case 4:
                    commercePageType = CommercePageType.COMMERCE_PAGE_TYPE_RIDE_SHARE;
                    break;
            }
        }
        commercePageType = null;
        userBuilder.C = commercePageType;
        return userBuilder.aa();
    }
}
