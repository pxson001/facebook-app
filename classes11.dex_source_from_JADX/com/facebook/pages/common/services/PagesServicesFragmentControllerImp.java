package com.facebook.pages.common.services;

import com.facebook.inject.InjectorLike;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import javax.inject.Inject;

/* compiled from: reviews_count */
public class PagesServicesFragmentControllerImp {
    public final AdminedPagesRamCache f2375a;

    public static PagesServicesFragmentControllerImp m3332b(InjectorLike injectorLike) {
        return new PagesServicesFragmentControllerImp(AdminedPagesRamCache.a(injectorLike));
    }

    @Inject
    public PagesServicesFragmentControllerImp(AdminedPagesRamCache adminedPagesRamCache) {
        this.f2375a = adminedPagesRamCache;
    }

    public final PagesServicesModel m3333a(PagesServicesModel pagesServicesModel, String str) {
        return (pagesServicesModel.f2417c == null || !pagesServicesModel.f2417c.equals(str)) ? new PagesServicesModel(pagesServicesModel.f2415a, pagesServicesModel.f2416b, str, pagesServicesModel.f2418d) : pagesServicesModel;
    }
}
