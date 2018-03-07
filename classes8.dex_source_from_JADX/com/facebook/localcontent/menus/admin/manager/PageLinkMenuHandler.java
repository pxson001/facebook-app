package com.facebook.localcontent.menus.admin.manager;

import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.content.SecureContextHelper;
import com.facebook.localcontent.menus.admin.manager.MenuManagementPreviewActivity.MenuPreviewType;
import com.facebook.localcontent.menus.admin.manager.PageMenuTypeHandler.MenuType;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.AvailableMenusModel.AvailableMenuInfoModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.LinkMenuInfoModel.PageLinkMenusModel.NodesModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel.MenuInfoModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ec_adapter_updated */
public class PageLinkMenuHandler implements PageMenuTypeHandler {
    private static final int f15084a = MenuType.LINK_MENU.ordinal();
    private final SecureContextHelper f15085b;

    @Inject
    public PageLinkMenuHandler(SecureContextHelper secureContextHelper) {
        this.f15085b = secureContextHelper;
    }

    public final MenuType mo897a() {
        return MenuType.LINK_MENU;
    }

    public final boolean mo902a(@Nullable MenuInfoModel menuInfoModel) {
        return menuInfoModel != null && menuInfoModel.a();
    }

    public final boolean mo901a(@Nullable AvailableMenuInfoModel availableMenuInfoModel) {
        return true;
    }

    public final void mo898a(PageMenuManagementFragment pageMenuManagementFragment, ViewerContext viewerContext, String str, @Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        String str2;
        Intent intent = new Intent(pageMenuManagementFragment.getContext(), MenuManagementPreviewActivity.class);
        intent.putExtra("com.facebook.katana.profile.id", str);
        intent.putExtra("extra_menu_type", MenuPreviewType.LINK_MENU);
        if (menuManagementInfoFieldsModel == null || menuManagementInfoFieldsModel.j() == null || menuManagementInfoFieldsModel.j().a().isEmpty()) {
            str2 = null;
        } else {
            str2 = ((NodesModel) menuManagementInfoFieldsModel.j().a().get(0)).a();
        }
        intent.putExtra("extra_link_menu_url", str2);
        this.f15085b.a(intent, f15084a, pageMenuManagementFragment);
    }

    public final boolean mo900a(int i) {
        return i == f15084a;
    }

    public final void mo899a(PageMenuManagementFragment pageMenuManagementFragment, String str, int i, int i2) {
        if (i == f15084a && i2 == -1) {
            pageMenuManagementFragment.m17533e();
        }
    }
}
