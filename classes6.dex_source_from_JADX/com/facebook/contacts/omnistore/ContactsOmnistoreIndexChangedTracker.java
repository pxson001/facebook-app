package com.facebook.contacts.omnistore;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: parent_op */
public class ContactsOmnistoreIndexChangedTracker {
    private static final Class<?> f8354a = ContactsOmnistoreIndexChangedTracker.class;
    private final DefaultBlueServiceOperationFactory f8355b;
    private final Lazy<DbContactsPropertyUtil> f8356c;
    private final Lazy<FbErrorReporter> f8357d;
    private final Executor f8358e;

    private static ContactsOmnistoreIndexChangedTracker m12150b(InjectorLike injectorLike) {
        return new ContactsOmnistoreIndexChangedTracker(DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedLazy.a(injectorLike, 940), IdBasedSingletonScopeProvider.b(injectorLike, 494), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsOmnistoreIndexChangedTracker(BlueServiceOperationFactory blueServiceOperationFactory, Lazy<DbContactsPropertyUtil> lazy, Lazy<FbErrorReporter> lazy2, Executor executor) {
        this.f8355b = blueServiceOperationFactory;
        this.f8356c = lazy;
        this.f8357d = lazy2;
        this.f8358e = executor;
    }
}
