package com.facebook.messaging.cache;

import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: method/messaging.setthreadname */
public class DeliveredReadReceiptManager {
    private static final Class<?> f9486a = DeliveredReadReceiptManager.class;
    private final DefaultBlueServiceOperationFactory f9487b;
    private final DataCache f9488c;
    private final DefaultThreadKeyFactory f9489d;
    private final DbClock f9490e;

    private static DeliveredReadReceiptManager m10076b(InjectorLike injectorLike) {
        return new DeliveredReadReceiptManager(DefaultBlueServiceOperationFactory.b(injectorLike), DataCache.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), DbClock.a(injectorLike));
    }

    @Inject
    public DeliveredReadReceiptManager(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, DataCache dataCache, DefaultThreadKeyFactory defaultThreadKeyFactory, DbClock dbClock) {
        this.f9487b = defaultBlueServiceOperationFactory;
        this.f9488c = dataCache;
        this.f9489d = defaultThreadKeyFactory;
        this.f9490e = dbClock;
    }
}
