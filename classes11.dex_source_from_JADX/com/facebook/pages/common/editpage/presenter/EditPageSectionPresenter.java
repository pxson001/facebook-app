package com.facebook.pages.common.editpage.presenter;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;

/* compiled from: should_hide_shared_albums */
public interface EditPageSectionPresenter {

    /* compiled from: should_hide_shared_albums */
    public enum SectionContext {
        EDIT,
        ADD
    }

    void mo35a(Activity activity, long j, SectionContext sectionContext);

    boolean mo36a(EditPageData editPageData);

    boolean mo37a(SectionsCanAddModel sectionsCanAddModel);

    @DrawableRes
    int mo38b();

    @StringRes
    @Deprecated
    int mo39c();
}
