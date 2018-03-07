package com.facebook.pages.identity.cards.contextitems;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.contextitems.card.PageIdentityContextItemsHeaderCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageHeaderCardSpecification;

/* compiled from: privacy_checkup_manager_fetch_data_failed */
public class PageIdentityContextItemsHeaderCardSpecification implements PageHeaderCardSpecification {
    public static PageIdentityContextItemsHeaderCardSpecification m4497a(InjectorLike injectorLike) {
        return new PageIdentityContextItemsHeaderCardSpecification();
    }

    public final boolean mo77a() {
        return true;
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityContextItemsHeaderCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.CONTEXT_ITEMS_HEADER;
    }

    public final FetchType mo80c() {
        return FetchType.PRIMARY;
    }

    public final boolean mo78a(PageHeaderData pageHeaderData) {
        ContextItemsConnectionWithPageInfoFragmentModel t = pageHeaderData.e.t();
        return (t == null || t.a() == null || t.a().isEmpty()) ? false : true;
    }
}
