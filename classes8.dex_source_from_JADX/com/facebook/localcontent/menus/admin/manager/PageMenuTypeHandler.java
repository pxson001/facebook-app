package com.facebook.localcontent.menus.admin.manager;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.AvailableMenusModel.AvailableMenuInfoModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel.MenuInfoModel;
import javax.annotation.Nullable;

/* compiled from: ec_card_configuration_wait_time */
public interface PageMenuTypeHandler {

    /* compiled from: ec_card_configuration_wait_time */
    public enum MenuType {
        PHOTO_MENU,
        STRUCTURED_MENU,
        LINK_MENU,
        NONE
    }

    MenuType mo897a();

    void mo898a(PageMenuManagementFragment pageMenuManagementFragment, ViewerContext viewerContext, String str, @Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel);

    void mo899a(PageMenuManagementFragment pageMenuManagementFragment, String str, int i, int i2);

    boolean mo900a(int i);

    boolean mo901a(@Nullable AvailableMenuInfoModel availableMenuInfoModel);

    boolean mo902a(@Nullable MenuInfoModel menuInfoModel);
}
