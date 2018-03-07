package com.facebook.pages.common.childlocations;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationConnectionFieldsModel.NodesModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationConnectionFieldsModel.NodesModel.AddressModel;

/* compiled from: step_image_url */
public class PageChildLocationsRowViewController {
    public String f1381a = "";
    public String f1382b = "";
    public Uri f1383c = null;

    public final void m2017a(NodesModel nodesModel) {
        String str;
        this.f1381a = nodesModel.m();
        AddressModel j = nodesModel.j();
        if (j == null) {
            str = "";
        } else if (!StringUtil.a(j.j())) {
            str = j.j();
        } else if (StringUtil.a(j.a())) {
            str = "";
        } else {
            str = j.a();
        }
        this.f1382b = str;
        if (nodesModel.n() != null && nodesModel.n().b() != null) {
            this.f1383c = Uri.parse(nodesModel.n().b());
        }
    }
}
