package com.facebook.pages.identity.cards.socialcontext.admin;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageHeaderCardSpecification;

/* compiled from: play_duration_ms */
public class PageIdentityAdminSocialContextCardSpecification implements PageHeaderCardSpecification {
    public static PageIdentityAdminSocialContextCardSpecification m4723a(InjectorLike injectorLike) {
        return new PageIdentityAdminSocialContextCardSpecification();
    }

    public final boolean mo77a() {
        return true;
    }

    public final boolean mo78a(PageHeaderData pageHeaderData) {
        return true;
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityAdminSocialContextCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.ADMIN_SOCIAL_CONTEXT;
    }

    public final FetchType mo80c() {
        return FetchType.PRIMARY;
    }
}
