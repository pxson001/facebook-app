package com.facebook.localcontent.menus.admin.manager;

import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.PageMenuVisibilityEditInputData;
import com.facebook.localcontent.menus.admin.manager.MenuManagementPreviewActivity.MenuPreviewType;
import com.facebook.localcontent.menus.admin.manager.PageMenuTypeHandler.MenuType;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.AvailableMenusModel.AvailableMenuInfoModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel.MenuInfoModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: e8eca9cfb6b4e357b62ccf98a42a7897 */
public class PagePhotoMenuHandler implements PageMenuTypeHandler {
    public static final int f15108a = MenuType.PHOTO_MENU.ordinal();
    private final MenuVisibilityMutationHelper f15109b;
    public final SecureContextHelper f15110c;
    public final UriIntentMapper f15111d;

    @Inject
    public PagePhotoMenuHandler(MenuVisibilityMutationHelper menuVisibilityMutationHelper, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f15109b = menuVisibilityMutationHelper;
        this.f15110c = secureContextHelper;
        this.f15111d = uriIntentMapper;
    }

    public final MenuType mo897a() {
        return MenuType.PHOTO_MENU;
    }

    public final boolean mo902a(@Nullable MenuInfoModel menuInfoModel) {
        return menuInfoModel != null && menuInfoModel.b();
    }

    public final boolean mo901a(@Nullable AvailableMenuInfoModel availableMenuInfoModel) {
        return true;
    }

    public final void mo898a(PageMenuManagementFragment pageMenuManagementFragment, ViewerContext viewerContext, String str, @Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        Object obj = 1;
        Object obj2 = (menuManagementInfoFieldsModel == null || menuManagementInfoFieldsModel.a() == null || !menuManagementInfoFieldsModel.a().b()) ? null : 1;
        if (menuManagementInfoFieldsModel == null || menuManagementInfoFieldsModel.a() == null || menuManagementInfoFieldsModel.a().j() == null || !menuManagementInfoFieldsModel.a().j().j()) {
            obj = null;
        }
        if (obj2 == null && r0 == null) {
            Intent a = this.f15111d.a(pageMenuManagementFragment.getContext(), StringFormatUtil.a(FBLinks.dr, new Object[]{str}));
            a.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
            this.f15110c.a(a, pageMenuManagementFragment.o());
            return;
        }
        a = new Intent(pageMenuManagementFragment.getContext(), MenuManagementPreviewActivity.class);
        a.putExtra("com.facebook.katana.profile.id", str);
        a.putExtra("extra_menu_type", MenuPreviewType.PHOTO_MENU);
        this.f15110c.a(a, f15108a, pageMenuManagementFragment);
    }

    public final boolean mo900a(int i) {
        return i == f15108a;
    }

    public final void mo899a(PageMenuManagementFragment pageMenuManagementFragment, String str, int i, int i2) {
        if (i == f15108a && i2 == -1) {
            this.f15109b.m17498a(pageMenuManagementFragment, str, PageMenuVisibilityEditInputData.MenuType.PHOTO);
        }
    }
}
