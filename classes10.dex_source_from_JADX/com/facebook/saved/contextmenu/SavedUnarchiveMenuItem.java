package com.facebook.saved.contextmenu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
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

@ContextScoped
/* compiled from: is_previous_selection */
public class SavedUnarchiveMenuItem implements SavedContextMenuItem<SavableItemWrapper> {
    private static SavedUnarchiveMenuItem f8988f;
    private static final Object f8989g = new Object();
    public final Resources f8990a;
    public final Toaster f8991b;
    public final SavedEventBus f8992c;
    private final UpdateSavedStateUtils f8993d;
    public final SavedDashboardItemMutator f8994e;

    private static SavedUnarchiveMenuItem m8994b(InjectorLike injectorLike) {
        return new SavedUnarchiveMenuItem(ResourcesMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike), SavedEventBus.m9122a(injectorLike), UpdateSavedStateUtils.a(injectorLike), SavedDashboardItemMutator.m9109a(injectorLike));
    }

    public final boolean mo411a(Object obj, Fragment fragment) {
        final SavableItemWrapper savableItemWrapper = (SavableItemWrapper) obj;
        this.f8993d.b(savableItemWrapper.mo424a(), CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.UNARCHIVE_BUTTON, new OperationResultFutureCallback(this) {
            final /* synthetic */ SavedUnarchiveMenuItem f8987b;

            protected final void m8991a(ServiceException serviceException) {
                this.f8987b.f8991b.b(new ToastBuilder(this.f8987b.f8990a.getString(2131238161)));
                if (savableItemWrapper.mo425b() instanceof SavedDashboardItem) {
                    this.f8987b.f8992c.a(new SavedItemMutatedEvent(this.f8987b.f8994e.m9110a((SavedDashboardItem) savableItemWrapper.mo425b(), GraphQLSavedState.ARCHIVED, false)));
                }
            }
        });
        if (savableItemWrapper.mo425b() instanceof SavedDashboardItem) {
            this.f8992c.a(new SavedItemMutatedEvent(this.f8994e.m9110a((SavedDashboardItem) savableItemWrapper.mo425b(), GraphQLSavedState.SAVED, true)));
        }
        return true;
    }

    public final boolean mo413b(Object obj) {
        SavableItemWrapper savableItemWrapper = (SavableItemWrapper) obj;
        return GraphQLSavedState.ARCHIVED.equals(savableItemWrapper.mo429f()) && !StringUtil.a(savableItemWrapper.mo424a());
    }

    @Inject
    public SavedUnarchiveMenuItem(Resources resources, Toaster toaster, SavedEventBus savedEventBus, UpdateSavedStateUtils updateSavedStateUtils, SavedDashboardItemMutator savedDashboardItemMutator) {
        this.f8990a = resources;
        this.f8991b = toaster;
        this.f8992c = savedEventBus;
        this.f8993d = updateSavedStateUtils;
        this.f8994e = savedDashboardItemMutator;
    }

    public final Class<SavableItemWrapper> mo409a() {
        return SavableItemWrapper.class;
    }

    public static SavedUnarchiveMenuItem m8993a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedUnarchiveMenuItem b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8989g) {
                SavedUnarchiveMenuItem savedUnarchiveMenuItem;
                if (a2 != null) {
                    savedUnarchiveMenuItem = (SavedUnarchiveMenuItem) a2.a(f8989g);
                } else {
                    savedUnarchiveMenuItem = f8988f;
                }
                if (savedUnarchiveMenuItem == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8994b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8989g, b3);
                        } else {
                            f8988f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedUnarchiveMenuItem;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nonnull
    public final CurationMechanism mo414c() {
        return CurationMechanism.UNARCHIVE_BUTTON;
    }

    public final String mo412b() {
        return this.f8990a.getString(2131238179);
    }

    @Nullable
    public final String mo410a(Object obj) {
        return null;
    }

    public final int mo415d() {
        return 2130843247;
    }
}
