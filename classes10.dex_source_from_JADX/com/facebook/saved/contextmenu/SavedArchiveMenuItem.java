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
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_ui_showing */
public class SavedArchiveMenuItem implements SavedContextMenuItem<SavableItemWrapper> {
    private static SavedArchiveMenuItem f8957f;
    private static final Object f8958g = new Object();
    public final Resources f8959a;
    public final Toaster f8960b;
    public final SavedEventBus f8961c;
    private final UpdateSavedStateUtils f8962d;
    public final SavedDashboardItemMutator f8963e;

    private static SavedArchiveMenuItem m8954b(InjectorLike injectorLike) {
        return new SavedArchiveMenuItem(ResourcesMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike), SavedEventBus.m9122a(injectorLike), UpdateSavedStateUtils.a(injectorLike), SavedDashboardItemMutator.m9109a(injectorLike));
    }

    public final boolean mo411a(Object obj, Fragment fragment) {
        final SavableItemWrapper savableItemWrapper = (SavableItemWrapper) obj;
        this.f8962d.a(savableItemWrapper.mo424a(), CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.ARCHIVE_BUTTON, new OperationResultFutureCallback(this) {
            final /* synthetic */ SavedArchiveMenuItem f8956b;

            protected final void m8944a(ServiceException serviceException) {
                this.f8956b.f8960b.b(new ToastBuilder(this.f8956b.f8959a.getString(2131238160)));
                if (savableItemWrapper.mo425b() instanceof SavedDashboardItem) {
                    this.f8956b.f8961c.a(new SavedItemMutatedEvent(this.f8956b.f8963e.m9110a((SavedDashboardItem) savableItemWrapper.mo425b(), GraphQLSavedState.SAVED, false)));
                }
            }
        });
        if (savableItemWrapper.mo425b() instanceof SavedDashboardItem) {
            this.f8961c.a(new SavedItemMutatedEvent(this.f8963e.m9110a((SavedDashboardItem) savableItemWrapper.mo425b(), GraphQLSavedState.ARCHIVED, true)));
        }
        return true;
    }

    public final boolean mo413b(Object obj) {
        SavableItemWrapper savableItemWrapper = (SavableItemWrapper) obj;
        return !StringUtil.a(savableItemWrapper.mo424a()) && GraphQLSavedState.SAVED.equals(savableItemWrapper.mo429f());
    }

    @Inject
    public SavedArchiveMenuItem(Resources resources, Toaster toaster, SavedEventBus savedEventBus, UpdateSavedStateUtils updateSavedStateUtils, SavedDashboardItemMutator savedDashboardItemMutator) {
        this.f8959a = resources;
        this.f8960b = toaster;
        this.f8961c = savedEventBus;
        this.f8962d = updateSavedStateUtils;
        this.f8963e = savedDashboardItemMutator;
    }

    public final Class<SavableItemWrapper> mo409a() {
        return SavableItemWrapper.class;
    }

    public static SavedArchiveMenuItem m8953a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedArchiveMenuItem b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8958g) {
                SavedArchiveMenuItem savedArchiveMenuItem;
                if (a2 != null) {
                    savedArchiveMenuItem = (SavedArchiveMenuItem) a2.a(f8958g);
                } else {
                    savedArchiveMenuItem = f8957f;
                }
                if (savedArchiveMenuItem == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8954b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8958g, b3);
                        } else {
                            f8957f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedArchiveMenuItem;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final String mo412b() {
        return this.f8959a.getString(2131238178);
    }

    @Nonnull
    public final CurationMechanism mo414c() {
        return CurationMechanism.ARCHIVE_BUTTON;
    }

    public final String mo410a(Object obj) {
        return null;
    }

    public final int mo415d() {
        return 2130843243;
    }
}
