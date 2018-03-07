package com.facebook.messaging.contactsyoumayknow;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.contacts.graphql.ContactBuilder;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.handlers.AddContactGraphQLHelper;
import com.facebook.contacts.handlers.AddContactHandler;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsModels.AddCYMKSuggestionModel;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsModels.HideCYMKSuggestionModel;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: syncRefetchLoggedInUser */
public class ContactsYouMayKnowMutationHandler {
    private static final Class<?> f2127a = ContactsYouMayKnowMutationHandler.class;
    public final GraphQLQueryExecutor f2128b;
    public final GraphQLCacheManager f2129c;
    public final Executor f2130d;
    private final AddContactHandler f2131e;
    private final AddContactGraphQLHelper f2132f;

    /* compiled from: syncRefetchLoggedInUser */
    public class C03561 implements FutureCallback<GraphQLResult<AddCYMKSuggestionModel>> {
        final /* synthetic */ SettableFuture f2124a;
        final /* synthetic */ ContactsYouMayKnowMutationHandler f2125b;

        public C03561(ContactsYouMayKnowMutationHandler contactsYouMayKnowMutationHandler, SettableFuture settableFuture) {
            this.f2125b = contactsYouMayKnowMutationHandler;
            this.f2124a = settableFuture;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FutureDetour.a(this.f2124a, null, -1321896263);
            this.f2125b.f2129c.a(ContactsYouMayKnowFetcher.m1915b());
            ContactsYouMayKnowMutationHandler.m1936a(this.f2125b, ((AddCYMKSuggestionModel) graphQLResult.e).m1951a());
        }

        public void onFailure(Throwable th) {
            this.f2124a.a(ServiceException.a(th));
        }
    }

    /* compiled from: syncRefetchLoggedInUser */
    public class C03573 implements FutureCallback<GraphQLResult<HideCYMKSuggestionModel>> {
        final /* synthetic */ ContactsYouMayKnowMutationHandler f2126a;

        public C03573(ContactsYouMayKnowMutationHandler contactsYouMayKnowMutationHandler) {
            this.f2126a = contactsYouMayKnowMutationHandler;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f2126a.f2129c.a(ContactsYouMayKnowFetcher.m1915b());
        }

        public void onFailure(Throwable th) {
        }
    }

    public static ContactsYouMayKnowMutationHandler m1937b(InjectorLike injectorLike) {
        return new ContactsYouMayKnowMutationHandler(GraphQLQueryExecutor.a(injectorLike), GraphQLCacheManager.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), AddContactHandler.a(injectorLike), AddContactGraphQLHelper.b(injectorLike));
    }

    @Inject
    public ContactsYouMayKnowMutationHandler(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, Executor executor, AddContactHandler addContactHandler, AddContactGraphQLHelper addContactGraphQLHelper) {
        this.f2128b = graphQLQueryExecutor;
        this.f2129c = graphQLCacheManager;
        this.f2130d = executor;
        this.f2131e = addContactHandler;
        this.f2132f = addContactGraphQLHelper;
    }

    public static void m1936a(ContactsYouMayKnowMutationHandler contactsYouMayKnowMutationHandler, ContactModel contactModel) {
        try {
            contactsYouMayKnowMutationHandler.f2131e.a(new ContactBuilder(contactsYouMayKnowMutationHandler.f2132f.a(contactModel)).e(true).P());
        } catch (IOException e) {
        }
    }
}
