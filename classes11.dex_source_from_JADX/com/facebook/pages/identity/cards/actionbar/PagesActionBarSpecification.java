package com.facebook.pages.identity.cards.actionbar;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageHeaderCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageHeaderCardSpecification;
import javax.inject.Inject;

/* compiled from: privacy_checkup_write_request_dropped */
public class PagesActionBarSpecification implements PageHeaderCardSpecification {
    private Product f3283a;

    private static PagesActionBarSpecification m4438b(InjectorLike injectorLike) {
        return new PagesActionBarSpecification(ProductMethodAutoProvider.b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4436a(context);
    }

    @Inject
    public PagesActionBarSpecification(Product product) {
        this.f3283a = product;
    }

    public final boolean mo77a() {
        return true;
    }

    public final boolean mo78a(PageHeaderData pageHeaderData) {
        if (this.f3283a != Product.PAA) {
            return pageHeaderData.c();
        }
        if (!pageHeaderData.a(Permission.CREATE_CONTENT) || StringUtil.a(pageHeaderData.e.D()) || StringUtil.a(pageHeaderData.i())) {
            return false;
        }
        return true;
    }

    public static PagesActionBarSpecification m4437a(InjectorLike injectorLike) {
        return m4438b(injectorLike);
    }

    public static PageHeaderCardView m4436a(Context context) {
        return new PagesActionBar(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.ACTION_BAR;
    }

    public final FetchType mo80c() {
        return FetchType.PRIMARY;
    }
}
