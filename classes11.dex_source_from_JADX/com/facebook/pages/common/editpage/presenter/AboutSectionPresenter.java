package com.facebook.pages.common.editpage.presenter;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.pages.common.editpage.EditPageNavigationUtil;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import javax.inject.Inject;

/* compiled from: should_fetch_tab_data */
public class AboutSectionPresenter implements EditPageSectionPresenter {
    private final EditPageNavigationUtil f1603a;

    @Inject
    public AboutSectionPresenter(EditPageNavigationUtil editPageNavigationUtil) {
        this.f1603a = editPageNavigationUtil;
    }

    public final boolean mo36a(EditPageData editPageData) {
        return true;
    }

    public final boolean mo37a(SectionsCanAddModel sectionsCanAddModel) {
        return false;
    }

    @DrawableRes
    public final int mo38b() {
        return 2130839684;
    }

    @StringRes
    public final int mo39c() {
        return 2131241679;
    }

    public final void mo35a(Activity activity, long j, SectionContext sectionContext) {
        if (sectionContext == SectionContext.EDIT) {
            EditPageNavigationUtil editPageNavigationUtil = this.f1603a;
            editPageNavigationUtil.f1569b.a(editPageNavigationUtil.f1570c.a(editPageNavigationUtil.f1568a, StringFormatUtil.formatStrLocaleSafe(URL.c, String.valueOf(j))), editPageNavigationUtil.f1568a);
        } else if (sectionContext == SectionContext.ADD) {
            throw new UnsupportedOperationException("Cannot ADD the 'About' section.");
        }
    }
}
