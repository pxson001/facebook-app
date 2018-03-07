package com.facebook.uberbar.resolvers;

import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResult;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: topics_user_added */
public abstract class LocalUberbarResultResolver {
    public final ContactIterators f1457a;
    private final ListeningExecutorService f1458b;

    protected abstract Function<ContactIterator, List<SearchTypeaheadResult>> mo56a();

    protected abstract ImmutableList<ContactLinkType> mo57b();

    public LocalUberbarResultResolver(ContactIterators contactIterators, ListeningExecutorService listeningExecutorService) {
        this.f1457a = contactIterators;
        this.f1458b = listeningExecutorService;
    }

    public final ListenableFuture<List<SearchTypeaheadResult>> m1548a(final GraphSearchQuery graphSearchQuery) {
        return this.f1458b.a(new Callable<List<SearchTypeaheadResult>>(this) {
            final /* synthetic */ LocalUberbarResultResolver f1463b;

            public Object call() {
                ContactIterator a = this.f1463b.f1457a.a(ContactCursorsQuery.a().b(graphSearchQuery.e()).d(this.f1463b.mo57b()).a(SortKey.NAME));
                try {
                    List list = (List) this.f1463b.mo56a().apply(a);
                    return list;
                } finally {
                    a.close();
                }
            }
        });
    }
}
