package com.facebook.adinterfaces.protocol;

import android.content.Context;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentCreativeModel;
import com.facebook.adinterfaces.protocol.BoostedComponentEditMutation.BoostedComponentEditMutationString;
import com.facebook.adinterfaces.protocol.BoostedComponentEditMutationModels.BoostedComponentEditMutationModel;
import com.facebook.adinterfaces.util.targeting.AdInterfacesTargetingDelegate;
import com.facebook.adinterfaces.util.targeting.BoostedComponentEditTargetingDelegate;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.BoostedComponentEditInputData;
import com.facebook.graphql.calls.BoostedComponentEditInputData.Audience;
import com.facebook.graphql.calls.BoostedComponentEditInputData.Audience.AudienceCode;
import com.facebook.graphql.calls.BoostedComponentEditInputData.Audience.TargetSpec;
import com.facebook.graphql.calls.BoostedComponentEditInputData.BoostedComponentApp;
import com.facebook.graphql.calls.BoostedComponentEditInputData.Status;
import com.facebook.graphql.enums.GraphQLCallToActionType;
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
/* compiled from: WhisperMessageKeys */
public class EditBoostedComponentMethod extends BoostedComponentMutationMethod<BoostedComponentEditMutationString, BoostedComponentEditMutationModel> {
    private static EditBoostedComponentMethod f22323g;
    private static final Object f22324h = new Object();
    private final AdInterfacesEventBus f22325b;
    public final AdInterfacesDataHelper f22326c;
    public final BoostedComponentLogger f22327d;
    private Context f22328e;
    private boolean f22329f = false;

    private static EditBoostedComponentMethod m24068b(InjectorLike injectorLike) {
        return new EditBoostedComponentMethod(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), BoostedComponentLogger.m22753a(injectorLike));
    }

    @Inject
    public EditBoostedComponentMethod(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper, BoostedComponentLogger boostedComponentLogger) {
        super(graphQLQueryExecutor, tasksManager, adInterfacesEventBus);
        this.f22325b = adInterfacesEventBus;
        this.f22326c = adInterfacesDataHelper;
        this.f22327d = boostedComponentLogger;
    }

    protected final void mo974a(@Nullable GraphQLResult<BoostedComponentEditMutationModel> graphQLResult) {
        if (this.f22329f) {
            FbFragmentActivity fbFragmentActivity = (FbFragmentActivity) this.f22328e;
            fbFragmentActivity.setResult(-1);
            fbFragmentActivity.finish();
            return;
        }
        this.f22325b.a(new InvalidateEvent(this.f22306a, ComponentType.PROMOTION_DETAILS));
    }

    public static EditBoostedComponentMethod m24067a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EditBoostedComponentMethod b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22324h) {
                EditBoostedComponentMethod editBoostedComponentMethod;
                if (a2 != null) {
                    editBoostedComponentMethod = (EditBoostedComponentMethod) a2.a(f22324h);
                } else {
                    editBoostedComponentMethod = f22323g;
                }
                if (editBoostedComponentMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24068b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22324h, b3);
                        } else {
                            f22323g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = editBoostedComponentMethod;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m24070a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel, Context context) {
        this.f22328e = context;
        m24051a(adInterfacesBoostedComponentDataModel, context, 2131234032, false);
    }

    public final void m24072b(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel, Context context) {
        this.f22328e = context;
        m24051a(adInterfacesBoostedComponentDataModel, context, 2131234032, false);
        this.f22329f = true;
    }

    protected final TypedGraphQLMutationString mo973a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        BoostedComponentEditInputData boostedComponentEditInputData;
        GraphQlQueryString boostedComponentEditMutationString = new BoostedComponentEditMutationString();
        String str = "input";
        BoostedComponentEditInputData boostedComponentEditInputData2 = new BoostedComponentEditInputData();
        boostedComponentEditInputData2.a("flow_id", this.f22327d.f21686e);
        boostedComponentEditInputData2.a("page_id", adInterfacesBoostedComponentDataModel.f21747c);
        boostedComponentEditInputData2.a("boosted_component_app", BoostedComponentApp.valueOf(adInterfacesBoostedComponentDataModel.mo962b().getComponentAppEnum().name()));
        if (adInterfacesBoostedComponentDataModel.f21798c != null) {
            boostedComponentEditInputData2.a("target_id", adInterfacesBoostedComponentDataModel.f21798c.f21778a);
        }
        if (adInterfacesBoostedComponentDataModel.f21799d != null) {
            boostedComponentEditInputData2.a("object_id", adInterfacesBoostedComponentDataModel.f21799d);
        }
        if (adInterfacesBoostedComponentDataModel.f21748d.toString().equals(adInterfacesBoostedComponentDataModel.f21797b.m23344k().toString())) {
            if (adInterfacesBoostedComponentDataModel.f21750f != null && AdInterfacesDataHelper.m22801a(adInterfacesBoostedComponentDataModel)) {
                boostedComponentEditInputData2.a("budget", Integer.valueOf(Integer.parseInt(adInterfacesBoostedComponentDataModel.f21750f.m23422k())));
            }
            if (adInterfacesBoostedComponentDataModel.f21753i != -1 && this.f22326c.m22825b(adInterfacesBoostedComponentDataModel)) {
                boostedComponentEditInputData2.a("stop_time", Integer.valueOf((int) this.f22326c.m22826c(adInterfacesBoostedComponentDataModel.f21753i)));
            }
            if (adInterfacesBoostedComponentDataModel.mo951C() != null) {
                Object obj = null;
                CreativeAdModel C = adInterfacesBoostedComponentDataModel.mo951C();
                BoostedComponentCreativeModel o = adInterfacesBoostedComponentDataModel.f21797b.m23348o();
                if (!(o.m23270k() == null || C.f21774g != GraphQLCallToActionType.LIKE_PAGE || (C.f21770c.equals(o.m23269j()) && C.f21773f.equals(o.m23270k().m23240a()) && C.f21772e.equals(o.m23271l())))) {
                    obj = 1;
                }
                if (obj != null) {
                    boostedComponentEditInputData2.a("creative", AdInterfacesDataHelper.m22807e(adInterfacesBoostedComponentDataModel));
                }
            }
            if (adInterfacesBoostedComponentDataModel.f21754j != null && AdInterfacesDataHelper.m22804c(adInterfacesBoostedComponentDataModel)) {
                AdInterfacesTargetingDelegate boostedComponentEditTargetingDelegate = new BoostedComponentEditTargetingDelegate(new TargetSpec());
                Audience audience = new Audience();
                if (adInterfacesBoostedComponentDataModel.f21800e != null) {
                    audience.a(adInterfacesBoostedComponentDataModel.f21800e);
                } else if (adInterfacesBoostedComponentDataModel.f21754j.f21729i != null) {
                    audience.a(adInterfacesBoostedComponentDataModel.f21754j.f21729i);
                } else {
                    audience.a("target_spec", (TargetSpec) boostedComponentEditTargetingDelegate.m25301a(adInterfacesBoostedComponentDataModel.f21754j));
                }
                if (adInterfacesBoostedComponentDataModel.f21801f != null) {
                    audience.a(AudienceCode.valueOf(adInterfacesBoostedComponentDataModel.f21801f.name()));
                } else {
                    audience.a(AudienceCode.valueOf(adInterfacesBoostedComponentDataModel.f21754j.f21728h.name()));
                }
                boostedComponentEditInputData2.a("audience", audience);
            }
            boostedComponentEditInputData = boostedComponentEditInputData2;
        } else {
            boostedComponentEditInputData2.a("status", Status.valueOf(adInterfacesBoostedComponentDataModel.f21748d.name()));
            boostedComponentEditInputData = boostedComponentEditInputData2;
        }
        return (BoostedComponentEditMutationString) boostedComponentEditMutationString.a(str, boostedComponentEditInputData);
    }
}
