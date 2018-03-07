package com.facebook.composer.lifeevent.fetchbirthday;

import com.facebook.auth.datastore.LoggedInUserAuthDataStoreIncremental;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.BirthDateFieldsModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.BirthdayQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: core_attribute_text_size */
public class UserBirthdayFetcher {
    public final GraphQLQueryExecutor f16707a;
    public final LoggedInUserSessionManager f16708b;
    public Provider<User> f16709c;

    /* compiled from: core_attribute_text_size */
    public class C13211 implements FutureCallback<GraphQLResult<BirthdayQueryModel>> {
        final /* synthetic */ UserBirthdayFetcher f16706a;

        public C13211(UserBirthdayFetcher userBirthdayFetcher) {
            this.f16706a = userBirthdayFetcher;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((BirthdayQueryModel) graphQLResult.e).a() != null) {
                BirthDateFieldsModel a = ((BirthdayQueryModel) graphQLResult.e).a();
                UserBuilder a2 = new UserBuilder().a((User) this.f16706a.f16709c.get());
                a2.a(a.k(), a.j(), a.a());
                this.f16706a.f16708b.a(a2.aa());
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    @Inject
    public UserBirthdayFetcher(GraphQLQueryExecutor graphQLQueryExecutor, LoggedInUserAuthDataStoreIncremental loggedInUserAuthDataStoreIncremental, Provider<User> provider) {
        this.f16707a = graphQLQueryExecutor;
        this.f16708b = loggedInUserAuthDataStoreIncremental;
        this.f16709c = provider;
    }
}
