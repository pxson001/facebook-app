package com.facebook.localcontent.menus.admin.manager;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.graphql.calls.PageMenuVisibilityEditInputData;
import com.facebook.localcontent.menus.admin.manager.PageMenuTypeHandler.MenuType;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.AvailableMenusModel.AvailableMenuInfoModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel.MenuInfoModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: e962fb0e83ccef99024fca2e2dc6258a */
public class PageNoMenuHandler implements PageMenuTypeHandler {
    private final MenuVisibilityMutationHelper f15107a;

    @Inject
    public PageNoMenuHandler(MenuVisibilityMutationHelper menuVisibilityMutationHelper) {
        this.f15107a = menuVisibilityMutationHelper;
    }

    public final MenuType mo897a() {
        return MenuType.NONE;
    }

    public final boolean mo902a(@Nullable MenuInfoModel menuInfoModel) {
        if (menuInfoModel == null) {
            return true;
        }
        if (menuInfoModel.b() || menuInfoModel.a() || menuInfoModel.c()) {
            return false;
        }
        return true;
    }

    public final boolean mo901a(@Nullable AvailableMenuInfoModel availableMenuInfoModel) {
        return true;
    }

    public final void mo898a(PageMenuManagementFragment pageMenuManagementFragment, ViewerContext viewerContext, String str, @Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        this.f15107a.m17498a(pageMenuManagementFragment, str, PageMenuVisibilityEditInputData.MenuType.NONE);
    }

    public final boolean mo900a(int i) {
        return false;
    }

    public final void mo899a(PageMenuManagementFragment pageMenuManagementFragment, String str, int i, int i2) {
    }
}
