package com.facebook.composer.pagesintegration;

import com.facebook.common.util.TriState;
import com.facebook.composer.viewerpageadminutil.CheckViewerPageAdminUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import javax.inject.Inject;

/* compiled from: formData */
public class CheckViewerPageAdminPagesUtil implements CheckViewerPageAdminUtil {
    private AdminedPagesRamCache f6832a;

    public static CheckViewerPageAdminPagesUtil m8157b(InjectorLike injectorLike) {
        return new CheckViewerPageAdminPagesUtil(AdminedPagesRamCache.a(injectorLike));
    }

    @Inject
    public CheckViewerPageAdminPagesUtil(AdminedPagesRamCache adminedPagesRamCache) {
        this.f6832a = adminedPagesRamCache;
    }

    public final TriState m8158a() {
        if (this.f6832a.d() <= 0) {
            return TriState.UNSET;
        }
        boolean z = (this.f6832a.c() == 0 && this.f6832a.b() == 0) ? false : true;
        return TriState.valueOf(z);
    }

    public final boolean m8159a(String str) {
        return this.f6832a.b(str) != null && ProfilePermissions.b(((AdminedPagesPrefetchNode) this.f6832a.b(str)).a.g());
    }

    public static CheckViewerPageAdminPagesUtil m8156a(InjectorLike injectorLike) {
        return m8157b(injectorLike);
    }
}
