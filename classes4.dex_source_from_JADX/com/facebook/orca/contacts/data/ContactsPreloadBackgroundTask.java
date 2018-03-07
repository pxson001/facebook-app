package com.facebook.orca.contacts.data;

import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.Result;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fa_spx_frms */
public class ContactsPreloadBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12395a = ContactsPreloadBackgroundTask.class;
    private final ContactsLoaderFactory f12396b;
    private final Clock f12397c;
    private final Provider<Boolean> f12398d;
    private long f12399e;

    @Inject
    public ContactsPreloadBackgroundTask(ContactsLoaderFactory contactsLoaderFactory, Clock clock, Provider<Boolean> provider) {
        super("ContactsPreload");
        this.f12396b = contactsLoaderFactory;
        this.f12397c = clock;
        this.f12398d = provider;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final boolean mo595i() {
        if (((Boolean) this.f12398d.get()).booleanValue()) {
            return this.f12397c.a() >= this.f12399e + 300000;
        } else {
            return false;
        }
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        this.f12399e = this.f12397c.a();
        final SimpleBackgroundResultFutureCallback simpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(f12395a);
        ContactsLoader a = this.f12396b.m13107a();
        a.mo903a(new Callback<Void, Result, Throwable>(this) {
            final /* synthetic */ ContactsPreloadBackgroundTask f13358b;

            public final void mo951c(Object obj, Object obj2) {
                simpleBackgroundResultFutureCallback.onFailure((Throwable) obj2);
            }

            public final void mo950b(@Nullable Object obj, Object obj2) {
                simpleBackgroundResultFutureCallback.mo305a(OperationResult.a);
            }
        });
        a.m14002c();
        return simpleBackgroundResultFutureCallback;
    }

    public final long mo593f() {
        if (((Boolean) this.f12398d.get()).booleanValue()) {
            return Math.max(this.f12397c.a(), this.f12399e + 300000);
        }
        return -1;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.USER_IN_APP);
    }
}
