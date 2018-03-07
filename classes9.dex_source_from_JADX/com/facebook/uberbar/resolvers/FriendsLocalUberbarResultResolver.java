package com.facebook.uberbar.resolvers;

import android.net.Uri;
import com.facebook.common.executors.ListeningExecutorService_SearchRequestExecutorMethodAutoProvider;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.ContactPhone;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.SearchTypeaheadResultBuilder;
import com.facebook.search.api.SearchTypeaheadResultsCreator;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: topics_user_removed */
public class FriendsLocalUberbarResultResolver extends LocalUberbarResultResolver {
    private static final ImmutableList<ContactLinkType> f1459a = ImmutableList.of(ContactLinkType.FRIEND);
    private static volatile FriendsLocalUberbarResultResolver f1460c;
    public final SearchTypeaheadResultsCreator f1461b;

    /* compiled from: topics_user_removed */
    class C01441 implements Function<ContactIterator, List<SearchTypeaheadResult>> {
        final /* synthetic */ FriendsLocalUberbarResultResolver f1456a;

        C01441(FriendsLocalUberbarResultResolver friendsLocalUberbarResultResolver) {
            this.f1456a = friendsLocalUberbarResultResolver;
        }

        public Object apply(Object obj) {
            ContactIterator contactIterator = (ContactIterator) obj;
            Builder builder = ImmutableList.builder();
            while (contactIterator.hasNext()) {
                Contact contact = (Contact) contactIterator.next();
                List a = Lists.a();
                ImmutableList o = contact.o();
                int size = o.size();
                for (int i = 0; i < size; i++) {
                    a.add(((ContactPhone) o.get(i)).c());
                }
                SearchTypeaheadResultsCreator searchTypeaheadResultsCreator = this.f1456a.f1461b;
                String g = contact.g();
                String g2 = contact.e().g();
                long parseLong = Long.parseLong(contact.c());
                SearchTypeaheadResultBuilder newBuilder = SearchTypeaheadResult.newBuilder();
                newBuilder.a = "";
                newBuilder = newBuilder;
                newBuilder.b = GraphQLFriendshipStatus.ARE_FRIENDS;
                newBuilder = newBuilder;
                newBuilder.d = null;
                newBuilder = newBuilder;
                newBuilder.e = null;
                newBuilder = newBuilder;
                newBuilder.f = Uri.parse(g);
                newBuilder = newBuilder;
                newBuilder.g = "";
                newBuilder = newBuilder;
                newBuilder.k = g2;
                newBuilder = newBuilder;
                newBuilder.l = Type.USER;
                newBuilder = newBuilder;
                newBuilder.m = parseLong;
                newBuilder = newBuilder;
                newBuilder.q = a;
                builder.c(newBuilder.a());
            }
            return builder.b();
        }
    }

    public static com.facebook.uberbar.resolvers.FriendsLocalUberbarResultResolver m1550a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1460c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.uberbar.resolvers.FriendsLocalUberbarResultResolver.class;
        monitor-enter(r1);
        r0 = f1460c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1551b(r0);	 Catch:{ all -> 0x0035 }
        f1460c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1460c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.uberbar.resolvers.FriendsLocalUberbarResultResolver.a(com.facebook.inject.InjectorLike):com.facebook.uberbar.resolvers.FriendsLocalUberbarResultResolver");
    }

    private static FriendsLocalUberbarResultResolver m1551b(InjectorLike injectorLike) {
        return new FriendsLocalUberbarResultResolver(ContactIterators.a(injectorLike), ListeningExecutorService_SearchRequestExecutorMethodAutoProvider.a(injectorLike), SearchTypeaheadResultsCreator.a(injectorLike));
    }

    @Inject
    public FriendsLocalUberbarResultResolver(ContactIterators contactIterators, ListeningExecutorService listeningExecutorService, SearchTypeaheadResultsCreator searchTypeaheadResultsCreator) {
        super(contactIterators, listeningExecutorService);
        this.f1461b = searchTypeaheadResultsCreator;
    }

    protected final Function<ContactIterator, List<SearchTypeaheadResult>> mo56a() {
        return new C01441(this);
    }

    protected final ImmutableList<ContactLinkType> mo57b() {
        return f1459a;
    }
}
