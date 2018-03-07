package com.facebook.localcontent.menus.admin.manager;

import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.PageMenuVisibilityEditInputData;
import com.facebook.localcontent.menus.admin.manager.MenuManagementPreviewActivity.MenuPreviewType;
import com.facebook.localcontent.menus.admin.manager.PageMenuTypeHandler.MenuType;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.AvailableMenusModel.AvailableMenuInfoModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel.MenuInfoModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: e79f1b50440204b9d6dd54622c8f02f3 */
public class PageStructuredMenuHandler implements PageMenuTypeHandler {
    private static final int f15112a = MenuType.STRUCTURED_MENU.ordinal();
    private final AbstractFbErrorReporter f15113b;
    private final MenuVisibilityMutationHelper f15114c;
    private final SecureContextHelper f15115d;

    @Inject
    public PageStructuredMenuHandler(AbstractFbErrorReporter abstractFbErrorReporter, MenuVisibilityMutationHelper menuVisibilityMutationHelper, SecureContextHelper secureContextHelper) {
        this.f15113b = abstractFbErrorReporter;
        this.f15114c = menuVisibilityMutationHelper;
        this.f15115d = secureContextHelper;
    }

    public final MenuType mo897a() {
        return MenuType.STRUCTURED_MENU;
    }

    public final boolean mo902a(@Nullable MenuInfoModel menuInfoModel) {
        return menuInfoModel != null && menuInfoModel.c();
    }

    public final boolean mo901a(@Nullable AvailableMenuInfoModel availableMenuInfoModel) {
        return availableMenuInfoModel != null && availableMenuInfoModel.a();
    }

    public final void mo898a(PageMenuManagementFragment pageMenuManagementFragment, ViewerContext viewerContext, String str, @Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        if (menuManagementInfoFieldsModel == null || menuManagementInfoFieldsModel.a() == null || menuManagementInfoFieldsModel.a().j() == null || !menuManagementInfoFieldsModel.a().j().a()) {
            this.f15113b.b(PageStructuredMenuHandler.class.getSimpleName(), "Trying to open structured menu but no menu is available");
        }
        Intent intent = new Intent(pageMenuManagementFragment.getContext(), MenuManagementPreviewActivity.class);
        intent.putExtra("com.facebook.katana.profile.id", str);
        intent.putExtra("extra_menu_type", MenuPreviewType.STRUCTURED_MENU);
        intent.putExtra("local_content_food_photos_header_enabled", false);
        this.f15115d.a(intent, f15112a, pageMenuManagementFragment);
    }

    public final boolean mo900a(int i) {
        return i == f15112a;
    }

    public final void mo899a(PageMenuManagementFragment pageMenuManagementFragment, String str, int i, int i2) {
        if (i == f15112a && i2 == -1) {
            this.f15114c.m17498a(pageMenuManagementFragment, str, PageMenuVisibilityEditInputData.MenuType.STRUCTURED);
        }
    }
}
