package com.facebook.events.sync.adapter;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.service.FbService;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.sync.FacebookCalendarFactory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import java.util.concurrent.ExecutorService;

/* compiled from: failure loading. url= */
public class FacebookCalendarSyncAdapterService extends FbService {
    private FbInjector f7246a;
    private AbstractThreadedSyncAdapter f7247b = null;

    public final void m8463a() {
        super.a();
        this.f7246a = l();
    }

    public IBinder onBind(Intent intent) {
        return m8462b().getSyncAdapterBinder();
    }

    private AbstractThreadedSyncAdapter m8462b() {
        if (this.f7247b == null) {
            FbInjector fbInjector = this.f7246a;
            this.f7247b = new CalendarSyncAdapterImpl((Context) fbInjector.getInstance(Context.class), LoggedInUserSessionManager.a(fbInjector), new FacebookCalendarFactory((Context) fbInjector.getInstance(Context.class)), GraphQLQueryExecutor.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (ExecutorService) IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(fbInjector));
        }
        return this.f7247b;
    }
}
