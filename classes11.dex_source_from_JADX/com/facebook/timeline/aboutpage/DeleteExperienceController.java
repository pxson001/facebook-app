package com.facebook.timeline.aboutpage;

import android.content.Context;
import android.widget.Toast;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.DeleteExperienceEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.DeleteExperienceEventSubscriber;
import com.facebook.timeline.aboutpage.summary.CollectionsSummaryFragment;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: NEWS_FEED */
public class DeleteExperienceController {
    public final AbstractSingleMethodRunner f13026a;
    public final Context f13027b;
    public final ProfileExperienceDeleteMethod f13028c = new ProfileExperienceDeleteMethod();
    public final ListeningExecutorService f13029d;
    public final ListeningExecutorService f13030e;

    /* compiled from: NEWS_FEED */
    public class C15441 extends DeleteExperienceEventSubscriber {
        final /* synthetic */ CollectionsSummaryFragment f13024a;
        final /* synthetic */ DeleteExperienceController f13025b;

        /* compiled from: NEWS_FEED */
        class C15432 implements FutureCallback<Void> {
            final /* synthetic */ C15441 f13023a;

            C15432(C15441 c15441) {
                this.f13023a = c15441;
            }

            public void onSuccess(@Nullable Object obj) {
                this.f13023a.f13024a.m13819e();
            }

            public void onFailure(Throwable th) {
                Toast.makeText(this.f13023a.f13025b.f13027b, 2131230758, 1).show();
            }
        }

        public C15441(DeleteExperienceController deleteExperienceController, CollectionsSummaryFragment collectionsSummaryFragment) {
            this.f13025b = deleteExperienceController;
            this.f13024a = collectionsSummaryFragment;
        }

        public final void m13796b(FbEvent fbEvent) {
            final DeleteExperienceEvent deleteExperienceEvent = (DeleteExperienceEvent) fbEvent;
            Futures.a(this.f13025b.f13029d.a(new Callable<Void>(this) {
                final /* synthetic */ C15441 f13022b;

                public Object call() {
                    this.f13022b.f13025b.f13026a.a(this.f13022b.f13025b.f13028c, new ProfileExperienceDeleteParams(deleteExperienceEvent.f13147a));
                    return null;
                }
            }), new C15432(this), this.f13025b.f13030e);
        }
    }

    public static DeleteExperienceController m13797b(InjectorLike injectorLike) {
        return new DeleteExperienceController((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DeleteExperienceController(AbstractSingleMethodRunner abstractSingleMethodRunner, Context context, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2) {
        this.f13026a = abstractSingleMethodRunner;
        this.f13027b = context;
        this.f13029d = listeningExecutorService;
        this.f13030e = listeningExecutorService2;
    }
}
