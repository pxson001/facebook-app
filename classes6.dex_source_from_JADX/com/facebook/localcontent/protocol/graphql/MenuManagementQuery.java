package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: kr. */
public final class MenuManagementQuery {

    /* compiled from: kr. */
    public class MenuManagementInfoString extends TypedGraphQlQueryString<MenuManagementInfoFieldsModel> {
        public MenuManagementInfoString() {
            super(MenuManagementInfoFieldsModel.class, false, "MenuManagementInfo", "4146dcc22fde9d9bf4370cc04dfe59af", "page", "10154405445381729", RegularImmutableSet.a);
        }

        public final String m18580a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
