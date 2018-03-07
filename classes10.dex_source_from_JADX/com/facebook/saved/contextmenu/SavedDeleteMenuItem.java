package com.facebook.saved.contextmenu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.saved.contextmenu.interfaces.SavableItemWrapper;
import com.facebook.saved.contextmenu.interfaces.SavedContextMenuItem;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.data.SavedDashboardItemMutator;
import com.facebook.saved.event.SavedEventBus;
import com.facebook.saved.event.SavedEvents.SavedItemMutatedEvent;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: is_successful */
public class SavedDeleteMenuItem implements SavedContextMenuItem<SavableItemWrapper> {
    private static SavedDeleteMenuItem f8973g;
    private static final Object f8974h = new Object();
    public final Resources f8975a;
    public final Toaster f8976b;
    public final SavedEventBus f8977c;
    private final UpdateSavedStateUtils f8978d;
    public final SavedDashboardItemMutator f8979e;
    private Provider<TriState> f8980f;

    private static SavedDeleteMenuItem m8969b(InjectorLike injectorLike) {
        return new SavedDeleteMenuItem(IdBasedProvider.a(injectorLike, 766), ResourcesMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike), SavedEventBus.m9122a(injectorLike), UpdateSavedStateUtils.a(injectorLike), SavedDashboardItemMutator.m9109a(injectorLike));
    }

    public final boolean mo411a(Object obj, Fragment fragment) {
        final SavableItemWrapper savableItemWrapper = (SavableItemWrapper) obj;
        final GraphQLSavedState f = savableItemWrapper.mo429f();
        C13691 c13691 = new OperationResultFutureCallback(this) {
            final /* synthetic */ SavedDeleteMenuItem f8972c;

            protected final void m8966a(ServiceException serviceException) {
                this.f8972c.f8976b.b(new ToastBuilder(this.f8972c.f8975a.getString(2131238162)));
                if (savableItemWrapper.mo425b() instanceof SavedDashboardItem) {
                    this.f8972c.f8977c.a(new SavedItemMutatedEvent(this.f8972c.f8979e.m9110a((SavedDashboardItem) savableItemWrapper.mo425b(), f, false)));
                }
            }
        };
        if (GraphQLSavedState.ARCHIVED.equals(f)) {
            this.f8978d.d(savableItemWrapper.mo424a(), CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.DELETE_BUTTON, c13691);
        } else {
            this.f8978d.c(savableItemWrapper.mo424a(), CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.DELETE_BUTTON, c13691);
        }
        if (savableItemWrapper.mo425b() instanceof SavedDashboardItem) {
            this.f8977c.a(new SavedItemMutatedEvent(this.f8979e.m9110a((SavedDashboardItem) savableItemWrapper.mo425b(), GraphQLSavedState.NOT_SAVED, true)));
        }
        return true;
    }

    public final boolean mo413b(Object obj) {
        SavableItemWrapper savableItemWrapper = (SavableItemWrapper) obj;
        if (StringUtil.a(savableItemWrapper.mo424a())) {
            return false;
        }
        GraphQLSavedState f = savableItemWrapper.mo429f();
        if (((TriState) this.f8980f.get()).asBoolean(false) && GraphQLSavedState.SAVED.equals(f)) {
            return true;
        }
        return GraphQLSavedState.ARCHIVED.equals(f);
    }

    @Inject
    public SavedDeleteMenuItem(Provider<TriState> provider, Resources resources, Toaster toaster, SavedEventBus savedEventBus, UpdateSavedStateUtils updateSavedStateUtils, SavedDashboardItemMutator savedDashboardItemMutator) {
        this.f8980f = provider;
        this.f8975a = resources;
        this.f8976b = toaster;
        this.f8977c = savedEventBus;
        this.f8978d = updateSavedStateUtils;
        this.f8979e = savedDashboardItemMutator;
    }

    public final Class<SavableItemWrapper> mo409a() {
        return SavableItemWrapper.class;
    }

    public static SavedDeleteMenuItem m8968a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedDeleteMenuItem b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8974h) {
                SavedDeleteMenuItem savedDeleteMenuItem;
                if (a2 != null) {
                    savedDeleteMenuItem = (SavedDeleteMenuItem) a2.a(f8974h);
                } else {
                    savedDeleteMenuItem = f8973g;
                }
                if (savedDeleteMenuItem == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8969b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8974h, b3);
                        } else {
                            f8973g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedDeleteMenuItem;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final String mo412b() {
        return this.f8975a.getString(2131238190);
    }

    @Nonnull
    public final CurationMechanism mo414c() {
        return CurationMechanism.DELETE_BUTTON;
    }

    @Nullable
    public final String mo410a(Object obj) {
        return null;
    }

    public final int mo415d() {
        return 2130843244;
    }
}
