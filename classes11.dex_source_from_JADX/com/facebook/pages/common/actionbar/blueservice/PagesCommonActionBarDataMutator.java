package com.facebook.pages.common.actionbar.blueservice;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.feedcache.memory.ToggleSaveParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor;
import com.facebook.pages.common.constants.ReportFlags;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

@ContextScoped
/* compiled from: store_locator_card_focused */
public class PagesCommonActionBarDataMutator {
    private static PagesCommonActionBarDataMutator f1344c;
    private static final Object f1345d = new Object();
    private final DefaultBlueServiceOperationFactory f1346a;
    private final OfflineObliviousOperationsExecutor f1347b;

    private static PagesCommonActionBarDataMutator m1994b(InjectorLike injectorLike) {
        return new PagesCommonActionBarDataMutator(DefaultBlueServiceOperationFactory.b(injectorLike), OfflineObliviousOperationsExecutor.a(injectorLike));
    }

    @Inject
    public PagesCommonActionBarDataMutator(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor) {
        this.f1346a = defaultBlueServiceOperationFactory;
        this.f1347b = offlineObliviousOperationsExecutor;
    }

    private ListenableFuture<OperationResult> m1992a(Parcelable parcelable, String str, String str2) {
        Bundle bundle = new Bundle();
        if (parcelable != null) {
            bundle.putParcelable(str, parcelable);
        }
        return this.f1347b.a(BlueServiceOperationFactoryDetour.a(this.f1346a, str2, bundle, -952283163));
    }

    public static PagesCommonActionBarDataMutator m1991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesCommonActionBarDataMutator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1345d) {
                PagesCommonActionBarDataMutator pagesCommonActionBarDataMutator;
                if (a2 != null) {
                    pagesCommonActionBarDataMutator = (PagesCommonActionBarDataMutator) a2.a(f1345d);
                } else {
                    pagesCommonActionBarDataMutator = f1344c;
                }
                if (pagesCommonActionBarDataMutator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1994b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1345d, b3);
                        } else {
                            f1344c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesCommonActionBarDataMutator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ListenableFuture<OperationResult> m1995a(ReportFlags reportFlags, long j) {
        return m1992a(new ReportPlaceParams(String.valueOf(j), reportFlags.mArgVal, CrowdEntryPoint.TIMELINE_ACTION_MENU_REPORT_PAGE, CrowdEndpoint.TIMELINE_REPORT_DIALOG), "reportPlaceParams", "report_place");
    }

    public final ListenableFuture<OperationResult> m1996a(String str, String str2) {
        return m1993a(str, str2, true);
    }

    public final ListenableFuture<OperationResult> m1997b(String str, String str2) {
        return m1993a(str, str2, false);
    }

    private ListenableFuture<OperationResult> m1993a(String str, String str2, boolean z) {
        return m1992a((Parcelable) new ToggleSaveParams(ToggleSaveParams.a(str, str2, CurationSurface.NATIVE_PAGE_PROFILE, CurationMechanism.ACTIONBAR_BUTTON, z, new GraphQLObjectType(2479791))), "togglePlaceSaveParams", "toggle_place_save_from_page");
    }
}
