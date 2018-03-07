package com.facebook.pages.common.editpage.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.editpage.EditPageNavigationUtil;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import javax.inject.Inject;

/* compiled from: should_fetch_page_message_shortlink */
public class ServicesSectionPresenter implements EditPageSectionPresenter {
    private final EditPageNavigationUtil f1610a;
    private final PagesExperimentUtils f1611b;

    @Inject
    public ServicesSectionPresenter(EditPageNavigationUtil editPageNavigationUtil, PagesExperimentUtils pagesExperimentUtils) {
        this.f1610a = editPageNavigationUtil;
        this.f1611b = pagesExperimentUtils;
    }

    public final boolean mo36a(EditPageData editPageData) {
        return editPageData.mo32b() && editPageData.mo33c() != null;
    }

    public final boolean mo37a(SectionsCanAddModel sectionsCanAddModel) {
        return this.f1611b.a() && sectionsCanAddModel.m2358c() == GraphQLPagePresenceTabType.SERVICES;
    }

    @DrawableRes
    public final int mo38b() {
        return 2130839957;
    }

    @StringRes
    public final int mo39c() {
        return 2131241681;
    }

    public final void mo35a(Activity activity, long j, SectionContext sectionContext) {
        if (sectionContext == SectionContext.ADD) {
            Intent intent = new Intent();
            intent.putExtra("extra_add_section_type", GraphQLPagePresenceTabType.SERVICES);
            activity.setResult(-1, intent);
            activity.finish();
        } else if (sectionContext == SectionContext.EDIT) {
            EditPageNavigationUtil.m2253a(activity, GraphQLPagePresenceTabType.SERVICES);
        }
    }
}
