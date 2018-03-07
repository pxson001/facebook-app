package com.facebook.uberbar.resolvers;

import android.net.Uri;
import com.facebook.common.executors.ListeningExecutorService_SearchRequestExecutorMethodAutoProvider;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.SearchTypeaheadResultBuilder;
import com.facebook.search.api.SearchTypeaheadResultsCreator;
import com.facebook.user.module.UserNameUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: topics_tagged */
public class PagesLocalUberbarResultResolver extends LocalUberbarResultResolver {
    private static final ImmutableList<ContactLinkType> f1465a = ImmutableList.of(ContactLinkType.PAGE);
    private static volatile PagesLocalUberbarResultResolver f1466d;
    public final SearchTypeaheadResultsCreator f1467b;
    public final UserNameUtil f1468c;

    /* compiled from: topics_tagged */
    class C01461 implements Function<ContactIterator, List<SearchTypeaheadResult>> {
        final /* synthetic */ PagesLocalUberbarResultResolver f1464a;

        C01461(PagesLocalUberbarResultResolver pagesLocalUberbarResultResolver) {
            this.f1464a = pagesLocalUberbarResultResolver;
        }

        public Object apply(Object obj) {
            ContactIterator contactIterator = (ContactIterator) obj;
            Builder builder = ImmutableList.builder();
            while (contactIterator.hasNext()) {
                Contact contact = (Contact) contactIterator.next();
                UserNameUtil userNameUtil = this.f1464a.f1468c;
                UserNameUtil.a(contact.e(), contact.f());
                SearchTypeaheadResultsCreator searchTypeaheadResultsCreator = this.f1464a.f1467b;
                String g = contact.g();
                String g2 = contact.e().g();
                long parseLong = Long.parseLong(contact.c());
                SearchTypeaheadResultBuilder newBuilder = SearchTypeaheadResult.newBuilder();
                newBuilder.a = "";
                newBuilder = newBuilder;
                newBuilder.b = null;
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
                newBuilder.l = Type.PAGE;
                newBuilder = newBuilder;
                newBuilder.m = parseLong;
                newBuilder = newBuilder;
                newBuilder.q = null;
                builder.c(newBuilder.a());
            }
            return builder.b();
        }
    }

    public static com.facebook.uberbar.resolvers.PagesLocalUberbarResultResolver m1554a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1466d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.uberbar.resolvers.PagesLocalUberbarResultResolver.class;
        monitor-enter(r1);
        r0 = f1466d;	 Catch:{ all -> 0x003a }
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
        r0 = m1555b(r0);	 Catch:{ all -> 0x0035 }
        f1466d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1466d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.uberbar.resolvers.PagesLocalUberbarResultResolver.a(com.facebook.inject.InjectorLike):com.facebook.uberbar.resolvers.PagesLocalUberbarResultResolver");
    }

    private static PagesLocalUberbarResultResolver m1555b(InjectorLike injectorLike) {
        return new PagesLocalUberbarResultResolver(ContactIterators.a(injectorLike), ListeningExecutorService_SearchRequestExecutorMethodAutoProvider.a(injectorLike), SearchTypeaheadResultsCreator.a(injectorLike), UserNameUtil.a(injectorLike));
    }

    @Inject
    public PagesLocalUberbarResultResolver(ContactIterators contactIterators, ListeningExecutorService listeningExecutorService, SearchTypeaheadResultsCreator searchTypeaheadResultsCreator, UserNameUtil userNameUtil) {
        super(contactIterators, listeningExecutorService);
        this.f1467b = searchTypeaheadResultsCreator;
        this.f1468c = userNameUtil;
    }

    protected final Function<ContactIterator, List<SearchTypeaheadResult>> mo56a() {
        return new C01461(this);
    }

    protected final ImmutableList<ContactLinkType> mo57b() {
        return f1465a;
    }
}
