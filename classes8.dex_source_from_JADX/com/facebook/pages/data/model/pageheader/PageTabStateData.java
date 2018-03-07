package com.facebook.pages.data.model.pageheader;

import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;

/* compiled from: confirmation_attempt */
public class PageTabStateData {
    public boolean f17311a = false;

    public final void m21335a(FetchPageHeaderQueryModel fetchPageHeaderQueryModel) {
        boolean z = (fetchPageHeaderQueryModel == null || fetchPageHeaderQueryModel.ae() == null || fetchPageHeaderQueryModel.ae().m21139a() == null || fetchPageHeaderQueryModel.ae().m21139a().m21133a() <= 0) ? false : true;
        this.f17311a = z;
    }
}
