package com.facebook.orca.threadview;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchEventRemindersMembersParams;
import com.facebook.messaging.service.model.FetchEventRemindersMembersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: message_event_guests_button_clicked */
public class ThreadEventReminderLoader extends AbstractListenableFutureFbLoader<ThreadSummary, ImmutableList<ThreadEventReminder>> {
    @BackgroundExecutorService
    private ExecutorService f7412a;
    private DefaultBlueServiceOperationFactory f7413b;

    /* compiled from: message_event_guests_button_clicked */
    class C11091 implements Function<OperationResult, ImmutableList<ThreadEventReminder>> {
        final /* synthetic */ ThreadEventReminderLoader f7411a;

        C11091(ThreadEventReminderLoader threadEventReminderLoader) {
            this.f7411a = threadEventReminderLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            FetchEventRemindersMembersResult fetchEventRemindersMembersResult = (FetchEventRemindersMembersResult) operationResult.k();
            if (fetchEventRemindersMembersResult == null) {
                return null;
            }
            return fetchEventRemindersMembersResult.a;
        }
    }

    protected final ListenableFuture m7057a(Object obj, LoaderResult loaderResult) {
        ThreadSummary threadSummary = (ThreadSummary) obj;
        Bundle bundle = new Bundle();
        bundle.putParcelable(FetchEventRemindersMembersParams.a, new FetchEventRemindersMembersParams(threadSummary.a, threadSummary.J));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f7413b, "fetch_event_reminders_members", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(ThreadEventReminderLoader.class), -1384924683).a(), new C11091(this), this.f7412a);
    }

    @Inject
    public ThreadEventReminderLoader(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        super(executorService);
        this.f7412a = executorService;
        this.f7413b = defaultBlueServiceOperationFactory;
    }

    protected final LoaderResult m7058b(Object obj) {
        return AbstractListenableFutureFbLoader.a;
    }
}
