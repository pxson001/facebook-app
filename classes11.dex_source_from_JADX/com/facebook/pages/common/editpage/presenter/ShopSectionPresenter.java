package com.facebook.pages.common.editpage.presenter;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.pages.common.editpage.EditPageNavigationUtil;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import javax.inject.Inject;

/* compiled from: should_fetch_fundraiser_information */
public class ShopSectionPresenter implements EditPageSectionPresenter {
    private final EditPageNavigationUtil f1612a;

    @Inject
    public ShopSectionPresenter(EditPageNavigationUtil editPageNavigationUtil) {
        this.f1612a = editPageNavigationUtil;
    }

    public final boolean mo36a(EditPageData editPageData) {
        if (editPageData.mo31a() == null || editPageData.mo31a().m2277a() == null || !editPageData.mo31a().m2277a().m2271a()) {
            return false;
        }
        return true;
    }

    public final boolean mo37a(SectionsCanAddModel sectionsCanAddModel) {
        return sectionsCanAddModel.m2358c() == GraphQLPagePresenceTabType.SHOP;
    }

    @DrawableRes
    public final int mo38b() {
        return 2130840099;
    }

    @StringRes
    public final int mo39c() {
        return 2131241680;
    }

    public final void mo35a(Activity activity, long j, SectionContext sectionContext) {
        EditPageNavigationUtil editPageNavigationUtil;
        if (sectionContext == SectionContext.ADD) {
            editPageNavigationUtil = this.f1612a;
            activity.finish();
            editPageNavigationUtil.f1569b.a(editPageNavigationUtil.f1570c.a(editPageNavigationUtil.f1568a, StringFormatUtil.formatStrLocaleSafe(FBLinks.eB, String.valueOf(j))), editPageNavigationUtil.f1568a);
        } else if (sectionContext == SectionContext.EDIT) {
            editPageNavigationUtil = this.f1612a;
            editPageNavigationUtil.f1569b.a(editPageNavigationUtil.f1570c.a(editPageNavigationUtil.f1568a, StringFormatUtil.formatStrLocaleSafe(FBLinks.eC, String.valueOf(j))), editPageNavigationUtil.f1568a);
        }
    }
}
