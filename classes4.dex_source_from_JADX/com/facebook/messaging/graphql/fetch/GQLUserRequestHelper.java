package com.facebook.messaging.graphql.fetch;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.contacts.pictures.ContactPictureSizes.Size;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.UserInfo;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: education_experiences */
public class GQLUserRequestHelper {
    private final GatekeeperStoreImpl f13275a;
    private final ViewerContextManager f13276b;
    private final ContactPictureSizes f13277c;
    private final Provider<Boolean> f13278d;

    public static GQLUserRequestHelper m14157b(InjectorLike injectorLike) {
        return new GQLUserRequestHelper(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), ContactPictureSizes.m14161a(injectorLike), IdBasedProvider.a(injectorLike, 4204));
    }

    @Inject
    public GQLUserRequestHelper(GatekeeperStore gatekeeperStore, ViewerContextManager viewerContextManager, ContactPictureSizes contactPictureSizes, Provider<Boolean> provider) {
        this.f13275a = gatekeeperStore;
        this.f13276b = viewerContextManager;
        this.f13277c = contactPictureSizes;
        this.f13278d = provider;
    }

    public static GQLUserRequestHelper m14155a(InjectorLike injectorLike) {
        return m14157b(injectorLike);
    }

    public final GraphQLRequest m14159a(List<String> list, @Nullable CallerContext callerContext) {
        GraphQlQueryString a = UserInfo.a();
        a.a("user_fbids", list);
        a.a("exclude_email_addresses", Boolean.valueOf(m14156a()));
        a.a("include_customer_data", (Boolean) this.f13278d.get());
        m14160a(a);
        GraphQLRequest a2 = GraphQLRequest.a(a);
        a2.s = this.f13276b.d();
        a2.f = callerContext;
        return a2;
    }

    public final GraphQLRequest m14158a(GraphQLRefParam graphQLRefParam, @Nullable CallerContext callerContext) {
        GraphQlQueryString a = UserInfo.a();
        m14160a(a);
        a.a("include_full_user_info", Boolean.TRUE.toString());
        a.a("user_fbids", graphQLRefParam);
        a.a("exclude_email_addresses", Boolean.valueOf(m14156a()));
        a.a("include_customer_data", (Boolean) this.f13278d.get());
        GraphQLRequest a2 = GraphQLRequest.a(a);
        a2.s = this.f13276b.d();
        a2.f = callerContext;
        return a2;
    }

    public final void m14160a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.a("profile_pic_large_size", Integer.valueOf(this.f13277c.m14163a(Size.HUGE))).a("profile_pic_medium_size", Integer.valueOf(this.f13277c.m14163a(Size.BIG))).a("profile_pic_small_size", Integer.valueOf(this.f13277c.m14163a(Size.SMALL)));
    }

    private boolean m14156a() {
        return this.f13275a.a(861, false);
    }
}
