package com.facebook.adinterfaces.protocol;

import android.content.Context;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationEvent;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.BoostedComponentCreateMutation.BoostedComponentCreateMutationString;
import com.facebook.adinterfaces.protocol.BoostedComponentCreateMutationModels.BoostedComponentCreateMutationModel;
import com.facebook.adinterfaces.util.targeting.AdInterfacesTargetingDelegate;
import com.facebook.adinterfaces.util.targeting.BoostedComponentCreationTargetingDelegate;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.BoostedComponentCreateInputData;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.AudienceCode;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.BoostedComponentApp;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.ValidateOnly;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: VaultUpdateService */
public class ValidateCreateBoostedComponentMethod extends BoostedComponentMutationMethod<BoostedComponentCreateMutationString, BoostedComponentCreateMutationModel> {
    private static ValidateCreateBoostedComponentMethod f22424e;
    private static final Object f22425f = new Object();
    public final AdInterfacesDataHelper f22426b;
    private final AdInterfacesEventBus f22427c;
    private final AdInterfacesErrorReporter f22428d;

    /* compiled from: VaultUpdateService */
    public /* synthetic */ class C25551 {
        public static final /* synthetic */ int[] f22423a = new int[ObjectiveType.values().length];

        static {
            try {
                f22423a[ObjectiveType.PAGE_LIKE_EDIT_CREATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22423a[ObjectiveType.PROMOTE_WEBSITE_EDIT_CREATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22423a[ObjectiveType.PROMOTE_CTA_EDIT_CREATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22423a[ObjectiveType.LOCAL_AWARENESS_EDIT_CREATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static ValidateCreateBoostedComponentMethod m24296b(InjectorLike injectorLike) {
        return new ValidateCreateBoostedComponentMethod(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public ValidateCreateBoostedComponentMethod(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        super(graphQLQueryExecutor, tasksManager, adInterfacesEventBus);
        this.f22426b = adInterfacesDataHelper;
        this.f22427c = adInterfacesEventBus;
        this.f22428d = adInterfacesErrorReporter;
    }

    public static ValidateCreateBoostedComponentMethod m24295a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ValidateCreateBoostedComponentMethod b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22425f) {
                ValidateCreateBoostedComponentMethod validateCreateBoostedComponentMethod;
                if (a2 != null) {
                    validateCreateBoostedComponentMethod = (ValidateCreateBoostedComponentMethod) a2.a(f22425f);
                } else {
                    validateCreateBoostedComponentMethod = f22424e;
                }
                if (validateCreateBoostedComponentMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24296b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22425f, b3);
                        } else {
                            f22424e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = validateCreateBoostedComponentMethod;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final TypedGraphQLMutationString mo973a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        BoostedComponentApp boostedComponentApp;
        BoostedComponentCreateMutationString a = BoostedComponentCreateMutation.m23963a();
        String str = "input";
        BoostedComponentCreateInputData boostedComponentCreateInputData = new BoostedComponentCreateInputData();
        AdInterfacesTargetingDelegate boostedComponentCreationTargetingDelegate = new BoostedComponentCreationTargetingDelegate(new TargetSpec());
        Audience audience = new Audience();
        audience.a((TargetSpec) boostedComponentCreationTargetingDelegate.m25301a(adInterfacesBoostedComponentDataModel.f21754j));
        if (adInterfacesBoostedComponentDataModel.f21800e != null) {
            audience.a(adInterfacesBoostedComponentDataModel.f21800e);
        } else if (adInterfacesBoostedComponentDataModel.f21754j.f21729i != null) {
            audience.a(adInterfacesBoostedComponentDataModel.f21754j.f21729i);
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
        ObjectiveType b = adInterfacesBoostedComponentDataModel.mo962b();
        if (b.getComponentAppEnum() == null) {
            switch (C25551.f22423a[b.ordinal()]) {
                case 1:
                    boostedComponentApp = BoostedComponentApp.BOOSTED_PAGELIKE_MOBILE;
                    break;
                case 2:
                    boostedComponentApp = BoostedComponentApp.BOOSTED_WEBSITE_MOBILE;
                    break;
                case 3:
                    boostedComponentApp = BoostedComponentApp.BOOSTED_CCTA_MOBILE;
                    break;
                case 4:
                    boostedComponentApp = BoostedComponentApp.BOOSTED_LOCAL_AWARENESS_MOBILE;
                    break;
                default:
                    boostedComponentApp = null;
                    break;
            }
        }
        boostedComponentApp = BoostedComponentApp.valueOf(b.getComponentAppEnum().name());
        boostedComponentCreateInputData.a(boostedComponentApp);
        boostedComponentCreateInputData.a(adInterfacesBoostedComponentDataModel.f21747c);
        if (adInterfacesBoostedComponentDataModel.f21750f != null) {
            boostedComponentCreateInputData.b(Integer.valueOf(Integer.parseInt(adInterfacesBoostedComponentDataModel.f21750f.m23422k())));
        }
        if (adInterfacesBoostedComponentDataModel.f21799d != null) {
            boostedComponentCreateInputData.b(adInterfacesBoostedComponentDataModel.f21799d);
        }
        if (adInterfacesBoostedComponentDataModel.mo951C() != null) {
            boostedComponentCreateInputData.a(adInterfacesBoostedComponentDataModel.mo951C().m22866h());
        }
        if (adInterfacesBoostedComponentDataModel.f21753i >= 0) {
            boostedComponentCreateInputData.a(Integer.valueOf((int) this.f22426b.m22826c(adInterfacesBoostedComponentDataModel.f21753i)));
        }
        boostedComponentCreateInputData.a("validate_only", ValidateOnly.TRUE);
        return (BoostedComponentCreateMutationString) a.a(str, boostedComponentCreateInputData).a("validateOnly", Boolean.valueOf(true));
    }

    protected final void mo975a(Throwable th) {
        this.f22428d.m22727a(getClass(), "Failed to validate boosted component", th);
    }

    protected final void mo974a(GraphQLResult<BoostedComponentCreateMutationModel> graphQLResult) {
        ImmutableList a = ((BoostedComponentCreateMutationModel) graphQLResult.e).m23969a();
        if (a != null) {
            this.f22427c.a(new ServerValidationEvent(a));
        }
    }
}
