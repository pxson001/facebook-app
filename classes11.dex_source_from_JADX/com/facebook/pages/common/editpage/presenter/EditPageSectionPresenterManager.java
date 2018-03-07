package com.facebook.pages.common.editpage.presenter;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.editpage.EditPageNavigationUtil;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: should_fetch_rating */
public class EditPageSectionPresenterManager {
    private static EditPageSectionPresenterManager f1604b;
    private static final Object f1605c = new Object();
    public final ImmutableMap<GraphQLPagePresenceTabType, EditPageSectionPresenter> f1606a;

    private static EditPageSectionPresenterManager m2404b(InjectorLike injectorLike) {
        return new EditPageSectionPresenterManager(new AboutSectionPresenter(EditPageNavigationUtil.m2255b(injectorLike)), new ShopSectionPresenter(EditPageNavigationUtil.m2255b(injectorLike)), new ServicesSectionPresenter(EditPageNavigationUtil.m2255b(injectorLike), PagesExperimentUtils.a(injectorLike)));
    }

    @Inject
    public EditPageSectionPresenterManager(AboutSectionPresenter aboutSectionPresenter, ShopSectionPresenter shopSectionPresenter, ServicesSectionPresenter servicesSectionPresenter) {
        this.f1606a = ImmutableMap.of(GraphQLPagePresenceTabType.ABOUT, aboutSectionPresenter, GraphQLPagePresenceTabType.SHOP, shopSectionPresenter, GraphQLPagePresenceTabType.SERVICES, servicesSectionPresenter);
    }

    public static EditPageSectionPresenterManager m2403a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EditPageSectionPresenterManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1605c) {
                EditPageSectionPresenterManager editPageSectionPresenterManager;
                if (a2 != null) {
                    editPageSectionPresenterManager = (EditPageSectionPresenterManager) a2.a(f1605c);
                } else {
                    editPageSectionPresenterManager = f1604b;
                }
                if (editPageSectionPresenterManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2404b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1605c, b3);
                        } else {
                            f1604b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = editPageSectionPresenterManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final int m2405a(SectionsCanAddData sectionsCanAddData) {
        int i = 0;
        if (sectionsCanAddData != null) {
            ImmutableList g = sectionsCanAddData.mo34g();
            int size = g.size();
            int i2 = 0;
            while (i2 < size) {
                int i3;
                if (m2406a((SectionsCanAddModel) g.get(i2)) != null) {
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public final EditPageSectionPresenter m2406a(SectionsCanAddModel sectionsCanAddModel) {
        if (!this.f1606a.containsKey(sectionsCanAddModel.m2358c())) {
            return null;
        }
        EditPageSectionPresenter editPageSectionPresenter = (EditPageSectionPresenter) this.f1606a.get(sectionsCanAddModel.m2358c());
        return editPageSectionPresenter.mo37a(sectionsCanAddModel) ? editPageSectionPresenter : null;
    }
}
