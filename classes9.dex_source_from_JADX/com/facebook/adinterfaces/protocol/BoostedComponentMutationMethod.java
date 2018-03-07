package com.facebook.adinterfaces.protocol;

import android.content.Context;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;

/* compiled from: WorldWriteableFiles */
public abstract class BoostedComponentMutationMethod<M extends TypedGraphQLMutationString, T extends GraphQLVisitableModel> {
    protected DialogBasedProgressIndicator f22306a;
    private GraphQLQueryExecutor f22307b;
    private TasksManager f22308c;
    public AdInterfacesEventBus f22309d;

    /* compiled from: WorldWriteableFiles */
    class C25411 extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
        final /* synthetic */ BoostedComponentMutationMethod f22305a;

        C25411(BoostedComponentMutationMethod boostedComponentMutationMethod) {
            this.f22305a = boostedComponentMutationMethod;
        }

        protected final void m24047a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f22305a.f22306a != null) {
                this.f22305a.f22306a.b();
            }
            this.f22305a.mo974a(graphQLResult);
        }

        protected final void m24048a(Throwable th) {
            this.f22305a.mo975a(th);
        }
    }

    /* compiled from: WorldWriteableFiles */
    enum Tasks {
        MUTATION_TASK
    }

    protected abstract M mo973a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel);

    protected abstract void mo974a(@Nullable GraphQLResult<T> graphQLResult);

    public BoostedComponentMutationMethod(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus) {
        this.f22307b = graphQLQueryExecutor;
        this.f22308c = tasksManager;
        this.f22309d = adInterfacesEventBus;
    }

    public final void m24050a() {
        this.f22308c.c(Tasks.MUTATION_TASK);
    }

    public final void m24051a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel, Context context, int i, boolean z) {
        if (!z) {
            this.f22306a = new DialogBasedProgressIndicator(context, context.getString(i));
            this.f22306a.a();
        }
        this.f22308c.a(Tasks.MUTATION_TASK, this.f22307b.a(GraphQLRequest.a(mo973a(adInterfacesBoostedComponentDataModel))), new C25411(this));
    }

    protected void mo975a(Throwable th) {
        if (this.f22306a != null) {
            this.f22306a.b();
            this.f22309d.a(new ErrorDialogEvent());
        }
    }
}
