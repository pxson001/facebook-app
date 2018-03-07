package com.facebook.profilelist;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.model.FacebookProfile;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: repeatMode */
public class FriendsSupplier implements ProfilesSupplier {
    public static final Function<Contact, FacebookProfile> f4552a = new C05961();
    private static volatile FriendsSupplier f4553e;
    public final ContactIterators f4554b;
    private final ListeningExecutorService f4555c;
    public final AddressBookPeriodicRunner f4556d;

    /* compiled from: repeatMode */
    final class C05961 implements Function<Contact, FacebookProfile> {
        C05961() {
        }

        public final Object apply(Object obj) {
            Contact contact = (Contact) obj;
            return new FacebookProfile(Long.parseLong(contact.c()), contact.e().g(), contact.g(), 0);
        }
    }

    public static com.facebook.profilelist.FriendsSupplier m4417a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4553e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.profilelist.FriendsSupplier.class;
        monitor-enter(r1);
        r0 = f4553e;	 Catch:{ all -> 0x003a }
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
        r0 = m4418b(r0);	 Catch:{ all -> 0x0035 }
        f4553e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4553e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.profilelist.FriendsSupplier.a(com.facebook.inject.InjectorLike):com.facebook.profilelist.FriendsSupplier");
    }

    private static FriendsSupplier m4418b(InjectorLike injectorLike) {
        return new FriendsSupplier(AddressBookPeriodicRunner.a(injectorLike), ContactIterators.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsSupplier(AddressBookPeriodicRunner addressBookPeriodicRunner, ContactIterators contactIterators, ListeningExecutorService listeningExecutorService) {
        this.f4556d = addressBookPeriodicRunner;
        this.f4554b = contactIterators;
        this.f4555c = listeningExecutorService;
    }

    public final ListenableFuture<List<FacebookProfile>> mo213a(final Optional<String> optional) {
        return this.f4555c.a(new Callable<List<FacebookProfile>>(this) {
            final /* synthetic */ FriendsSupplier f4551b;

            public Object call() {
                ContactIterator a = this.f4551b.f4554b.a(ContactCursorsQuery.a().c(ContactProfileType.FACEBOOK_FRIENDS_TYPES).d(ContactLinkType.FRIENDS).a(SortKey.NAME).b((String) optional.orNull()));
                try {
                    ArrayList a2 = Lists.a(Iterators.a(a, FriendsSupplier.f4552a));
                    if (a2.isEmpty()) {
                        this.f4551b.f4556d.a();
                    }
                    a.close();
                    return a2;
                } catch (Throwable th) {
                    a.close();
                }
            }
        });
    }

    public final boolean mo214a() {
        return true;
    }
}
