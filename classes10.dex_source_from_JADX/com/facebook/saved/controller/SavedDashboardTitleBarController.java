package com.facebook.saved.controller;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.listenermanager.ListenerManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.common.data.SavedSectionResources;
import com.facebook.saved.common.data.SavedSectionResources.SavedSectionResource;
import com.facebook.saved.helper.SavedSectionHelper;
import com.facebook.saved.views.SavedDashboardFilterMenu;
import com.facebook.saved.views.SavedDashboardFilterPopoverWindow;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_email_enabled */
public class SavedDashboardTitleBarController {
    private static SavedDashboardTitleBarController f9047i;
    private static final Object f9048j = new Object();
    public HasTitleBar f9049a;
    public Optional<SavedDashboardSection> f9050b;
    public final ListenerManager<SavedSectionsListener> f9051c;
    public Resources f9052d;
    public SavedSectionHelper f9053e;
    public SavedSectionResources f9054f;
    public final SaveAnalyticsLogger f9055g;
    private final OnDismissListener f9056h = new C13761(this);

    /* compiled from: is_email_enabled */
    class C13761 implements OnDismissListener {
        final /* synthetic */ SavedDashboardTitleBarController f9043a;

        C13761(SavedDashboardTitleBarController savedDashboardTitleBarController) {
            this.f9043a = savedDashboardTitleBarController;
        }

        public final boolean m9065a(PopoverWindow popoverWindow) {
            if (this.f9043a.f9050b.isPresent()) {
                SaveAnalyticsLogger saveAnalyticsLogger = this.f9043a.f9055g;
                GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType = ((SavedDashboardSection) this.f9043a.f9050b.get()).a;
                GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType2 = graphQLSavedDashboardSectionType;
                saveAnalyticsLogger.b.b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_filter_canceled", "current_section_type", graphQLSavedDashboardSectionType2, "event_id", SafeUUIDGenerator.a().toString()));
            }
            return true;
        }
    }

    /* compiled from: is_email_enabled */
    public class C13772 extends OnToolbarButtonListener {
        final /* synthetic */ SavedDashboardTitleBarController f9044a;

        public C13772(SavedDashboardTitleBarController savedDashboardTitleBarController) {
            this.f9044a = savedDashboardTitleBarController;
        }

        public final void m9066a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            SavedDashboardTitleBarController.m9069a(this.f9044a, view);
        }
    }

    private static SavedDashboardTitleBarController m9071b(InjectorLike injectorLike) {
        return new SavedDashboardTitleBarController(ResourcesMethodAutoProvider.a(injectorLike), new ListenerManager(), SavedSectionHelper.m9180a(injectorLike), SavedSectionResources.a(injectorLike), SaveAnalyticsLogger.a(injectorLike));
    }

    @Inject
    public SavedDashboardTitleBarController(Resources resources, ListenerManager listenerManager, SavedSectionHelper savedSectionHelper, SavedSectionResources savedSectionResources, SaveAnalyticsLogger saveAnalyticsLogger) {
        this.f9052d = resources;
        this.f9053e = savedSectionHelper;
        this.f9054f = savedSectionResources;
        this.f9055g = saveAnalyticsLogger;
        this.f9051c = listenerManager;
    }

    public static SavedDashboardTitleBarController m9067a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedDashboardTitleBarController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9048j) {
                SavedDashboardTitleBarController savedDashboardTitleBarController;
                if (a2 != null) {
                    savedDashboardTitleBarController = (SavedDashboardTitleBarController) a2.a(f9048j);
                } else {
                    savedDashboardTitleBarController = f9047i;
                }
                if (savedDashboardTitleBarController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9071b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9048j, b3);
                        } else {
                            f9047i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedDashboardTitleBarController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static void m9069a(SavedDashboardTitleBarController savedDashboardTitleBarController, View view) {
        if (savedDashboardTitleBarController.f9050b.isPresent()) {
            SaveAnalyticsLogger saveAnalyticsLogger = savedDashboardTitleBarController.f9055g;
            GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType = ((SavedDashboardSection) savedDashboardTitleBarController.f9050b.get()).a;
            GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType2 = graphQLSavedDashboardSectionType;
            saveAnalyticsLogger.b.b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_filter_button_clicked", "current_section_type", graphQLSavedDashboardSectionType2, "event_id", SafeUUIDGenerator.a().toString()));
        }
        SavedDashboardFilterPopoverWindow savedDashboardFilterPopoverWindow = new SavedDashboardFilterPopoverWindow(view.getContext());
        if (savedDashboardFilterPopoverWindow.f9345a == null) {
            savedDashboardFilterPopoverWindow.f9345a = new SavedDashboardFilterMenu(savedDashboardFilterPopoverWindow.getContext());
            savedDashboardFilterPopoverWindow.f9345a.a(savedDashboardFilterPopoverWindow);
            savedDashboardFilterPopoverWindow.f9345a.a(savedDashboardFilterPopoverWindow);
        }
        savedDashboardTitleBarController.m9068a(savedDashboardFilterPopoverWindow.f9345a);
        savedDashboardFilterPopoverWindow.H = savedDashboardTitleBarController.f9056h;
        savedDashboardFilterPopoverWindow.f(view);
    }

    private void m9068a(PopoverMenu popoverMenu) {
        GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType = (GraphQLSavedDashboardSectionType) SavedSectionHelper.m9181a(this.f9050b).or(GraphQLSavedDashboardSectionType.ALL);
        ImmutableList a = this.f9054f.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            final SavedDashboardSection savedDashboardSection = (SavedDashboardSection) a.get(i);
            MenuItemImpl a2 = popoverMenu.a(savedDashboardSection.b);
            a2.setIcon(((SavedSectionResource) this.f9054f.a(savedDashboardSection.a).or(SavedSectionResources.a)).a);
            if (graphQLSavedDashboardSectionType == savedDashboardSection.a) {
                a2.setCheckable(true);
                a2.setChecked(true);
            }
            a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ SavedDashboardTitleBarController f9046b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    SavedDashboardTitleBarController savedDashboardTitleBarController = this.f9046b;
                    SavedDashboardSection savedDashboardSection = savedDashboardSection;
                    if (savedDashboardTitleBarController.f9050b.isPresent()) {
                        savedDashboardTitleBarController.f9055g.b(((SavedDashboardSection) savedDashboardTitleBarController.f9050b.get()).a, savedDashboardSection.a);
                    }
                    savedDashboardTitleBarController.f9050b = Optional.of(savedDashboardSection);
                    for (SavedDashboardNavigationController a : savedDashboardTitleBarController.f9051c.a) {
                        a.m9057a(savedDashboardSection);
                    }
                    SavedDashboardTitleBarController.m9070a(this.f9046b, Optional.of(savedDashboardSection));
                    return true;
                }
            });
        }
    }

    public static void m9070a(SavedDashboardTitleBarController savedDashboardTitleBarController, Optional optional) {
        int i;
        if (optional.isPresent()) {
            i = ((SavedSectionResource) savedDashboardTitleBarController.f9054f.a(((SavedDashboardSection) optional.get()).a).or(SavedSectionResources.a)).c;
        } else {
            i = SavedSectionResources.a.c;
        }
        savedDashboardTitleBarController.f9049a.y_(i);
    }
}
