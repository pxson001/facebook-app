package com.facebook.quickpromotion.data;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: refresh-goodfriends-feed */
public class QuickPromotionUsersLoader implements FbLoader<List<String>, ImmutableList<User>, Throwable> {
    @GuardedBy("ui thread")
    public FutureAndCallbackHolder<ImmutableList<User>> f4618a;
    private final UserIterators f4619b;
    private final ListeningExecutorService f4620c;
    private final Executor f4621d;
    private final DefaultAndroidThreadUtil f4622e;
    @GuardedBy("ui thread")
    public Callback<List<String>, ImmutableList<User>, Throwable> f4623f;

    /* compiled from: refresh-goodfriends-feed */
    class C06092 extends AbstractDisposableFutureCallback<ImmutableList<User>> {
        final /* synthetic */ QuickPromotionUsersLoader f4617a;

        C06092(QuickPromotionUsersLoader quickPromotionUsersLoader) {
            this.f4617a = quickPromotionUsersLoader;
        }

        protected final void m4479a(Object obj) {
            this.f4617a.f4623f.a(null, (ImmutableList) obj);
        }

        protected final void m4480a(Throwable th) {
            this.f4617a.f4623f.c(null, th);
        }
    }

    public static QuickPromotionUsersLoader m4482b(InjectorLike injectorLike) {
        return new QuickPromotionUsersLoader(UserIterators.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public QuickPromotionUsersLoader(UserIterators userIterators, ListeningExecutorService listeningExecutorService, Executor executor, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f4619b = userIterators;
        this.f4620c = listeningExecutorService;
        this.f4621d = executor;
        this.f4622e = defaultAndroidThreadUtil;
    }

    public final void m4483a(Callback<List<String>, ImmutableList<User>, Throwable> callback) {
        this.f4623f = callback;
    }

    public final void m4485a(final List<String> list) {
        ListenableFuture a = this.f4620c.a(new Callable<ImmutableList<User>>(this) {
            final /* synthetic */ QuickPromotionUsersLoader f4616b;

            public Object call() {
                return QuickPromotionUsersLoader.m4481a(this.f4616b, list);
            }
        });
        C06092 c06092 = new C06092(this);
        Futures.a(a, c06092, this.f4621d);
        this.f4618a = FutureAndCallbackHolder.a(a, c06092);
    }

    public static ImmutableList m4481a(QuickPromotionUsersLoader quickPromotionUsersLoader, Collection collection) {
        quickPromotionUsersLoader.f4622e.b();
        Builder builder = ImmutableList.builder();
        UserIterator a = quickPromotionUsersLoader.f4619b.a(ContactCursorsQuery.b(collection));
        try {
            builder.b(a);
            return builder.b();
        } finally {
            a.close();
        }
    }
}
