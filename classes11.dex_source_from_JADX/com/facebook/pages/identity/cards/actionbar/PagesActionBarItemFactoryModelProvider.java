package com.facebook.pages.identity.cards.actionbar;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.pages.data.model.pageheader.PageHeaderData;

/* compiled from: privacy_checkup_write_request_flush */
public class PagesActionBarItemFactoryModelProvider extends AbstractAssistedProvider<PagesActionBarItemFactoryModel> {
    public static PagesActionBarItemFactoryModel m4430a(PageHeaderData pageHeaderData) {
        return new PagesActionBarItemFactoryModel(pageHeaderData);
    }
}
