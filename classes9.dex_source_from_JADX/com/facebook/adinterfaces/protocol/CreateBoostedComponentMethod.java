package com.facebook.adinterfaces.protocol;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorMessageEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.EventSpecModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.BoostedComponentCreateMutation.BoostedComponentCreateMutationString;
import com.facebook.adinterfaces.protocol.BoostedComponentCreateMutationModels.BoostedComponentCreateMutationModel;
import com.facebook.adinterfaces.util.PaymentsHelper;
import com.facebook.adinterfaces.util.targeting.AdInterfacesTargetingDelegate;
import com.facebook.adinterfaces.util.targeting.BoostedComponentCreationTargetingDelegate;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.BoostedComponentCreateInputData;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.AudienceCode;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.BoostedComponentApp;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.EventSpec;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

@ContextScoped
/* compiled from: White list failed! */
public class CreateBoostedComponentMethod extends BoostedComponentMutationMethod<BoostedComponentCreateMutationString, BoostedComponentCreateMutationModel> {
    private static CreateBoostedComponentMethod f22310f;
    private static final Object f22311g = new Object();
    public final AdInterfacesDataHelper f22312b;
    private final PaymentsHelper f22313c;
    public final BoostedComponentLogger f22314d;
    private AdInterfacesBoostedComponentDataModel f22315e;

    private static CreateBoostedComponentMethod m24055b(InjectorLike injectorLike) {
        return new CreateBoostedComponentMethod(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), PaymentsHelper.m25285a(injectorLike));
    }

    @Inject
    public CreateBoostedComponentMethod(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, BoostedComponentLogger boostedComponentLogger, AdInterfacesDataHelper adInterfacesDataHelper, PaymentsHelper paymentsHelper) {
        super(graphQLQueryExecutor, tasksManager, adInterfacesEventBus);
        this.f22312b = adInterfacesDataHelper;
        this.f22313c = paymentsHelper;
        this.f22314d = boostedComponentLogger;
    }

    public static CreateBoostedComponentMethod m24054a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CreateBoostedComponentMethod b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22311g) {
                CreateBoostedComponentMethod createBoostedComponentMethod;
                if (a2 != null) {
                    createBoostedComponentMethod = (CreateBoostedComponentMethod) a2.a(f22311g);
                } else {
                    createBoostedComponentMethod = f22310f;
                }
                if (createBoostedComponentMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24055b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22311g, b3);
                        } else {
                            f22310f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = createBoostedComponentMethod;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m24057a(AdInterfacesContext adInterfacesContext, AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel, Context context) {
        this.f22314d.m22781k(adInterfacesBoostedComponentDataModel);
        AdAccountModel a = AdInterfacesDataHelper.m22792a((BaseAdInterfacesData) adInterfacesBoostedComponentDataModel, adInterfacesBoostedComponentDataModel.m22853i());
        if (a.m23144r()) {
            this.f22315e = adInterfacesBoostedComponentDataModel;
            m24051a(adInterfacesBoostedComponentDataModel, context, 2131234026, false);
            return;
        }
        this.f22313c.m25297a(adInterfacesContext, (BaseAdInterfacesData) adInterfacesBoostedComponentDataModel, a, ((FragmentActivity) context).kO_(), context);
    }

    protected final void mo974a(GraphQLResult<BoostedComponentCreateMutationModel> graphQLResult) {
        this.f22314d.m22782l(this.f22315e);
        this.f22314d.m22769b(this.f22315e);
        this.f22315e = null;
        this.f22309d.a(new InvalidateEvent(this.f22306a, ComponentType.PROMOTION_DETAILS));
    }

    protected final TypedGraphQLMutationString mo973a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        BoostedComponentCreateMutationString a = BoostedComponentCreateMutation.m23963a();
        String str = "input";
        BoostedComponentCreateInputData boostedComponentCreateInputData = new BoostedComponentCreateInputData();
        AdInterfacesTargetingDelegate boostedComponentCreationTargetingDelegate = new BoostedComponentCreationTargetingDelegate(new TargetSpec());
        Audience audience = new Audience();
        if (adInterfacesBoostedComponentDataModel.f21800e != null) {
            audience.a(adInterfacesBoostedComponentDataModel.f21800e);
        } else if (adInterfacesBoostedComponentDataModel.f21754j.f21729i != null) {
            audience.a(adInterfacesBoostedComponentDataModel.f21754j.f21729i);
        } else {
            audience.a((TargetSpec) boostedComponentCreationTargetingDelegate.m25301a(adInterfacesBoostedComponentDataModel.f21754j));
        }
        if (adInterfacesBoostedComponentDataModel.f21801f != null) {
            audience.a(AudienceCode.valueOf(adInterfacesBoostedComponentDataModel.f21801f.name()));
        } else if (adInterfacesBoostedComponentDataModel.f21754j.f21728h != null) {
            audience.a(AudienceCode.valueOf(adInterfacesBoostedComponentDataModel.f21754j.f21728h.name()));
        } else {
            audience.a(AudienceCode.NCPP);
        }
        boostedComponentCreateInputData.a(audience);
        boostedComponentCreateInputData.c(adInterfacesBoostedComponentDataModel.m22853i());
        boostedComponentCreateInputData.a(BoostedComponentApp.valueOf(adInterfacesBoostedComponentDataModel.mo962b().getComponentAppEnum().name()));
        boostedComponentCreateInputData.a(adInterfacesBoostedComponentDataModel.f21747c);
        boostedComponentCreateInputData.b(Integer.valueOf(Integer.parseInt(adInterfacesBoostedComponentDataModel.f21750f.m23422k())));
        if (adInterfacesBoostedComponentDataModel.mo951C() != null) {
            boostedComponentCreateInputData.a(adInterfacesBoostedComponentDataModel.mo951C().m22866h());
        }
        if (adInterfacesBoostedComponentDataModel.f21798c != null) {
            EventSpecModel eventSpecModel = adInterfacesBoostedComponentDataModel.f21798c;
            EventSpec eventSpec = new EventSpec();
            eventSpec.a("event_boost_type", eventSpecModel.f21779b);
            GraphQlCallInput graphQlCallInput = eventSpec;
            graphQlCallInput.a("event_id", eventSpecModel.f21778a);
            boostedComponentCreateInputData.a("event_spec", graphQlCallInput);
        }
        if (adInterfacesBoostedComponentDataModel.f21799d != null) {
            boostedComponentCreateInputData.b(adInterfacesBoostedComponentDataModel.f21799d);
        }
        boostedComponentCreateInputData.a(Integer.valueOf((int) this.f22312b.m22826c(adInterfacesBoostedComponentDataModel.f21753i)));
        boostedComponentCreateInputData.a("placement", adInterfacesBoostedComponentDataModel.f21755k);
        boostedComponentCreateInputData.a("flow_id", this.f22314d.f21686e);
        return (BoostedComponentCreateMutationString) a.a(str, boostedComponentCreateInputData).a("validateOnly", Boolean.valueOf(false));
    }

    protected final void mo975a(Throwable th) {
        this.f22314d.m22767a(this.f22315e, th);
        if (th instanceof GraphQLException) {
            this.f22306a.b();
            this.f22309d.a(new ErrorMessageEvent(((GraphQLException) th).error.description.replaceAll("&#039;", "'")));
            return;
        }
        super.mo975a(th);
    }
}
