package com.facebook.pages.identity.cards.actionbar;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: privacy_checkup_write_request_flush_success */
public class PagesActionBarItemFactory {
    private PagesActionBarItemFactoryModel f3274a;
    private Product f3275b;
    private QeAccessor f3276c;
    private final PagesActionBarItemFactoryModelProvider f3277d;
    private Boolean f3278e;

    /* compiled from: privacy_checkup_write_request_flush_success */
    public enum PageActionType {
        LIKE,
        FOLLOW,
        MESSAGE,
        CHECKIN,
        SHARE,
        REPORT_PLACE,
        REPORT_GENERIC,
        SUGGEST_EDIT,
        SAVE,
        COPY_LINK,
        SHARE_MESSAGE_SHORTLINK,
        CREATE_SHORTCUT,
        MANAGE_ADS,
        REVIEW,
        GET_NOTIFICATION,
        CREATE_PAGE,
        PLACE_CLAIM,
        ADMIN_POST,
        ADMIN_PHOTO,
        ADMIN_SETTINGS,
        ADMIN_EDIT_PAGE,
        ADMIN_PROMOTE,
        ADMIN_ADD_TO_FAVORITES,
        ADMIN_REMOVE_FROM_FAVORITES,
        ADMIN_CREATE_EVENT
    }

    public static PagesActionBarItemFactory m4371b(InjectorLike injectorLike) {
        return new PagesActionBarItemFactory(ProductMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (PagesActionBarItemFactoryModelProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesActionBarItemFactoryModelProvider.class), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    public static PagesActionBarItemFactory m4369a(InjectorLike injectorLike) {
        return m4371b(injectorLike);
    }

    @Inject
    public PagesActionBarItemFactory(Product product, QeAccessor qeAccessor, PagesActionBarItemFactoryModelProvider pagesActionBarItemFactoryModelProvider, Boolean bool) {
        this.f3275b = product;
        this.f3276c = qeAccessor;
        this.f3277d = pagesActionBarItemFactoryModelProvider;
        this.f3278e = bool;
    }

    public final void m4396a(PageHeaderData pageHeaderData) {
        this.f3274a = PagesActionBarItemFactoryModelProvider.m4430a(pageHeaderData);
    }

    public final ImmutableList<PagesActionBarItem> m4395a() {
        if (this.f3275b == Product.PAA) {
            return ImmutableList.of(m4370b(), m4372c(), m4394y(), m4373d());
        }
        Object obj;
        boolean a = this.f3274a.m4404a();
        Object d = m4373d();
        PagesActionBarItem e = m4374e();
        boolean a2 = this.f3276c.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.k, false);
        PagesActionBarItem b = m4370b();
        PagesActionBarItem c = m4372c();
        if (a) {
            obj = d;
        } else {
            PagesActionBarItem pagesActionBarItem = e;
        }
        if (a) {
            PagesActionBarItem pagesActionBarItem2 = e;
        }
        return ImmutableList.of(b, c, obj, d, m4394y(), m4375f(), m4376g(), m4378i(), a2 ? m4381l() : m4377h(), m4380k(), m4390u(), a2 ? m4377h() : m4381l(), new PagesActionBarItem[]{m4382m(), m4383n(), m4384o(), m4385p(), m4386q(), m4387r(), m4388s(), m4389t(), m4391v(), m4392w(), m4393x(), m4379j()});
    }

    private PagesActionBarItem m4370b() {
        return new PagesActionBarItem(PageActionType.ADMIN_POST.ordinal(), 2131235422, 2130839809, 1, this.f3274a.m4409f());
    }

    private PagesActionBarItem m4372c() {
        return new PagesActionBarItem(PageActionType.ADMIN_PHOTO.ordinal(), 2131234840, 2130839749, 1, this.f3274a.m4410g());
    }

    private PagesActionBarItem m4373d() {
        return new PagesActionBarItem(PageActionType.ADMIN_PROMOTE.ordinal(), 2131235113, 2130839982, 1, this.f3274a.m4411h());
    }

    private PagesActionBarItem m4374e() {
        return new PagesActionBarItem(PageActionType.ADMIN_EDIT_PAGE.ordinal(), 2131235112, 2130840013, 1, this.f3274a.m4412i());
    }

    private PagesActionBarItem m4375f() {
        int i;
        boolean z;
        int ordinal = PageActionType.LIKE.ordinal();
        boolean k = this.f3274a.m4414k();
        if (this.f3274a.m4413j()) {
            i = 2131235369;
            z = true;
        } else {
            i = 2131235368;
            z = false;
        }
        return new PagesActionBarItem(ordinal, i, 2130839953, 1, k, true, z);
    }

    private PagesActionBarItem m4376g() {
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (this.f3274a.m4416m()) {
            i = 2130840402;
            if (this.f3274a.m4417n()) {
                i2 = 2131234906;
                i = 2130843308;
                i3 = 2130843306;
                z = true;
            } else {
                i2 = 2131234907;
                i3 = 2130839875;
                z = true;
            }
        } else {
            i = 2130839874;
            i2 = 2131234903;
            i3 = 0;
        }
        PagesActionBarItem pagesActionBarItem = new PagesActionBarItem(PageActionType.FOLLOW.ordinal(), i2, i, 1, this.f3274a.m4415l(), true, z);
        pagesActionBarItem.f3273i = i3;
        return pagesActionBarItem;
    }

    private PagesActionBarItem m4377h() {
        int i;
        boolean z;
        int ordinal = PageActionType.SAVE.ordinal();
        boolean o = this.f3274a.m4418o();
        if (this.f3274a.m4419p()) {
            i = 2131235378;
            z = true;
        } else {
            i = 2131235376;
            z = false;
        }
        return new PagesActionBarItem(ordinal, i, 2130839719, 1, o, true, z);
    }

    private PagesActionBarItem m4378i() {
        return new PagesActionBarItem(PageActionType.MESSAGE.ordinal(), 2131235385, 2130839805, 1, this.f3274a.m4420q());
    }

    private PagesActionBarItem m4379j() {
        return new PagesActionBarItem(PageActionType.SHARE_MESSAGE_SHORTLINK.ordinal(), 2131235403, 2130840097, 1, this.f3274a.m4421r());
    }

    private PagesActionBarItem m4380k() {
        return new PagesActionBarItem(PageActionType.CHECKIN.ordinal(), 2131235384, 2130840024, 1, this.f3274a.m4422s());
    }

    private static PagesActionBarItem m4381l() {
        return new PagesActionBarItem(PageActionType.SHARE.ordinal(), 2131235402, 2130840097, 1, true);
    }

    private PagesActionBarItem m4382m() {
        return new PagesActionBarItem(PageActionType.REVIEW.ordinal(), 2131235339, 2130840114, 1, this.f3274a.m4423t());
    }

    private PagesActionBarItem m4383n() {
        return new PagesActionBarItem(PageActionType.COPY_LINK.ordinal(), 2131235405, 2130839954, 1, this.f3274a.m4424u());
    }

    private PagesActionBarItem m4384o() {
        return new PagesActionBarItem(PageActionType.CREATE_SHORTCUT.ordinal(), 2131235114, 1, this.f3274a.m4405b());
    }

    private PagesActionBarItem m4385p() {
        return new PagesActionBarItem(PageActionType.MANAGE_ADS.ordinal(), 2131235119, 1, this.f3274a.m4406c());
    }

    private PagesActionBarItem m4386q() {
        return new PagesActionBarItem(PageActionType.PLACE_CLAIM.ordinal(), 2131235412, 1, this.f3274a.m4425v());
    }

    private PagesActionBarItem m4387r() {
        return new PagesActionBarItem(PageActionType.REPORT_PLACE.ordinal(), 2131235388, 1, this.f3274a.m4426w());
    }

    private PagesActionBarItem m4388s() {
        return new PagesActionBarItem(PageActionType.REPORT_GENERIC.ordinal(), 2131235388, 0, this.f3274a.m4427x());
    }

    private PagesActionBarItem m4389t() {
        return new PagesActionBarItem(PageActionType.SUGGEST_EDIT.ordinal(), 2131235400, 2130840013, 0, this.f3274a.m4428y());
    }

    private PagesActionBarItem m4390u() {
        return new PagesActionBarItem(PageActionType.GET_NOTIFICATION.ordinal(), 2131235408, 2130839867, 1, this.f3274a.m4408e());
    }

    private PagesActionBarItem m4391v() {
        return new PagesActionBarItem(PageActionType.CREATE_PAGE.ordinal(), 2131235411, 0, !this.f3278e.booleanValue());
    }

    private PagesActionBarItem m4392w() {
        return new PagesActionBarItem(PageActionType.ADMIN_SETTINGS.ordinal(), 2131235111, 2130839901, 1, this.f3274a.m4405b());
    }

    private PagesActionBarItem m4393x() {
        if (this.f3274a.m4429z()) {
            return new PagesActionBarItem(PageActionType.ADMIN_REMOVE_FROM_FAVORITES.ordinal(), 2131235116, 0, this.f3274a.m4407d());
        }
        return new PagesActionBarItem(PageActionType.ADMIN_ADD_TO_FAVORITES.ordinal(), 2131235115, 0, this.f3274a.m4407d());
    }

    private PagesActionBarItem m4394y() {
        boolean z = false;
        if (this.f3275b == Product.PAA) {
            return new PagesActionBarItem(PageActionType.ADMIN_CREATE_EVENT.ordinal(), 2131235110, 2130839846, 1, this.f3274a.m4403A());
        }
        int ordinal = PageActionType.ADMIN_CREATE_EVENT.ordinal();
        if (this.f3274a.m4403A() && this.f3276c.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.f, false)) {
            z = true;
        }
        return new PagesActionBarItem(ordinal, 2131235556, 2130839846, 1, z);
    }
}
