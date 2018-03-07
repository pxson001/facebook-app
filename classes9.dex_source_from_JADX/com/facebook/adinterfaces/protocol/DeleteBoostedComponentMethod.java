package com.facebook.adinterfaces.protocol;

import android.content.Context;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDeleteMutation.BoostedComponentDeleteMutationString;
import com.facebook.adinterfaces.protocol.BoostedComponentDeleteMutationModels.BoostedComponentDeleteMutationModel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.BoostedComponentDeleteInputData;
import com.facebook.graphql.calls.BoostedComponentDeleteInputData.BoostedComponentApp;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: WhisperRatchet */
public class DeleteBoostedComponentMethod extends BoostedComponentMutationMethod<BoostedComponentDeleteMutationString, BoostedComponentDeleteMutationModel> {
    private static DeleteBoostedComponentMethod f22318e;
    private static final Object f22319f = new Object();
    private final AdInterfacesEventBus f22320b;
    public final BoostedComponentLogger f22321c;
    private AdInterfacesBoostedComponentDataModel f22322d;

    private static DeleteBoostedComponentMethod m24063b(InjectorLike injectorLike) {
        return new DeleteBoostedComponentMethod(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), BoostedComponentLogger.m22753a(injectorLike));
    }

    @Inject
    public DeleteBoostedComponentMethod(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, BoostedComponentLogger boostedComponentLogger) {
        super(graphQLQueryExecutor, tasksManager, adInterfacesEventBus);
        this.f22320b = adInterfacesEventBus;
        this.f22321c = boostedComponentLogger;
    }

    public final void m24065a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel, Context context) {
        this.f22322d = adInterfacesBoostedComponentDataModel;
        m24051a(adInterfacesBoostedComponentDataModel, context, 2131234030, false);
    }

    protected final void mo974a(@Nullable GraphQLResult<BoostedComponentDeleteMutationModel> graphQLResult) {
        this.f22321c.m22775e(this.f22322d);
        this.f22322d = null;
        this.f22320b.a(new InvalidateEvent(this.f22306a, null));
    }

    public static DeleteBoostedComponentMethod m24062a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DeleteBoostedComponentMethod b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22319f) {
                DeleteBoostedComponentMethod deleteBoostedComponentMethod;
                if (a2 != null) {
                    deleteBoostedComponentMethod = (DeleteBoostedComponentMethod) a2.a(f22319f);
                } else {
                    deleteBoostedComponentMethod = f22318e;
                }
                if (deleteBoostedComponentMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24063b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22319f, b3);
                        } else {
                            f22318e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = deleteBoostedComponentMethod;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final TypedGraphQLMutationString mo973a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        GraphQlQueryString boostedComponentDeleteMutationString = new BoostedComponentDeleteMutationString();
        String str = "input";
        BoostedComponentDeleteInputData boostedComponentDeleteInputData = new BoostedComponentDeleteInputData();
        boostedComponentDeleteInputData.a("boosted_component_app", BoostedComponentApp.valueOf(adInterfacesBoostedComponentDataModel.mo962b().getComponentAppEnum().toString()));
        boostedComponentDeleteInputData.a("page_id", adInterfacesBoostedComponentDataModel.f21747c);
        if (adInterfacesBoostedComponentDataModel.f21798c != null) {
            boostedComponentDeleteInputData.a("target_id", adInterfacesBoostedComponentDataModel.f21798c.f21778a);
        }
        if (adInterfacesBoostedComponentDataModel.f21799d != null) {
            boostedComponentDeleteInputData.a("object_id", adInterfacesBoostedComponentDataModel.f21799d);
        }
        boostedComponentDeleteInputData.a("flow_id", this.f22321c.f21686e);
        return (BoostedComponentDeleteMutationString) boostedComponentDeleteMutationString.a(str, boostedComponentDeleteInputData);
    }
}
