package com.facebook.pages.common.editpage.graphql;

import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.EditPageDataModel.CommerceStoreModel;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.EditPageDataModel.ServicesCardModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: show_dialog */
public class FetchEditPageQueryInterfaces {

    /* compiled from: show_dialog */
    public interface EditPageData {
        @Nullable
        CommerceStoreModel mo31a();

        boolean mo32b();

        @Nullable
        ServicesCardModel mo33c();
    }

    /* compiled from: show_dialog */
    public interface SectionsCanAddData {
        @Nonnull
        ImmutableList<? extends SectionsCanAdd> mo34g();
    }
}
