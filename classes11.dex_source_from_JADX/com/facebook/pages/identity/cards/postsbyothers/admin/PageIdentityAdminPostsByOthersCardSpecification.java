package com.facebook.pages.identity.cards.postsbyothers.admin;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageHeaderCardSpecification;

/* compiled from: previous */
public class PageIdentityAdminPostsByOthersCardSpecification implements PageHeaderCardSpecification {
    public static PageIdentityAdminPostsByOthersCardSpecification m4667a(InjectorLike injectorLike) {
        return new PageIdentityAdminPostsByOthersCardSpecification();
    }

    public final boolean mo77a() {
        return true;
    }

    public final boolean mo78a(PageHeaderData pageHeaderData) {
        return pageHeaderData.c() && pageHeaderData.e.y() && pageHeaderData.e.k() != null && pageHeaderData.e.k().a();
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityAdminPostsByOthersCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.ADMIN_POST_BY_OTHERS;
    }

    public final FetchType mo80c() {
        return FetchType.PRIMARY;
    }
}
