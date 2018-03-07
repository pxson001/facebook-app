package com.facebook.contacts.util;

import android.os.Bundle;
import com.facebook.common.futures.FbFutures;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.FetchMultipleContactsByFbidParams;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.UserKey;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: own_page_album */
public class ContactFetchUtil {
    private final DefaultBlueServiceOperationFactory f8506a;

    /* compiled from: own_page_album */
    class C05572 implements Function<OperationResult, ImmutableList<Contact>> {
        final /* synthetic */ ContactFetchUtil f8504a;

        C05572(ContactFetchUtil contactFetchUtil) {
            this.f8504a = contactFetchUtil;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null) {
                return ((FetchContactsResult) operationResult.h()).f8447a;
            }
            return null;
        }
    }

    /* compiled from: own_page_album */
    class C05583 implements Function<OperationResult, Contact> {
        final /* synthetic */ ContactFetchUtil f8505a;

        C05583(ContactFetchUtil contactFetchUtil) {
            this.f8505a = contactFetchUtil;
        }

        public Object apply(Object obj) {
            FetchContactsResult fetchContactsResult = (FetchContactsResult) ((OperationResult) obj).h();
            return !fetchContactsResult.f8447a.isEmpty() ? (Contact) fetchContactsResult.f8447a.get(0) : null;
        }
    }

    public static ContactFetchUtil m12317b(InjectorLike injectorLike) {
        return new ContactFetchUtil(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public ContactFetchUtil(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f8506a = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<ImmutableList<Contact>> m12320a(ImmutableSet<UserKey> immutableSet, DataFreshnessParam dataFreshnessParam) {
        Preconditions.checkNotNull(immutableSet);
        return FbFutures.a(m12318b((ImmutableSet) immutableSet, dataFreshnessParam), new C05572(this));
    }

    public final ListenableFuture<Contact> m12319a(UserKey userKey, DataFreshnessParam dataFreshnessParam) {
        return FbFutures.a(m12321b(userKey, dataFreshnessParam), new C05583(this));
    }

    public final OperationFuture m12321b(UserKey userKey, DataFreshnessParam dataFreshnessParam) {
        return m12316a(ImmutableSet.of(userKey), dataFreshnessParam, false);
    }

    private OperationFuture m12318b(ImmutableSet<UserKey> immutableSet, DataFreshnessParam dataFreshnessParam) {
        return m12316a(immutableSet, dataFreshnessParam, true);
    }

    private OperationFuture m12316a(ImmutableSet<UserKey> immutableSet, DataFreshnessParam dataFreshnessParam, boolean z) {
        Preconditions.checkNotNull(immutableSet);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchMultipleContactsParams", new FetchMultipleContactsByFbidParams(immutableSet, dataFreshnessParam));
        if (z) {
            return BlueServiceOperationFactoryDetour.a(this.f8506a, "fetch_contacts", bundle, -367263381).c();
        }
        return BlueServiceOperationFactoryDetour.a(this.f8506a, "fetch_contacts", bundle, 1504284375).a();
    }
}
