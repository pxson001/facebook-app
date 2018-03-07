package com.facebook.friendsharing.souvenirs.util;

import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsInterfaces.SouvenirsDetailsFields;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel.MediaElementsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel.SouvenirMediaModel.EdgesModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.SouvenirsConversionHelper;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.model.GraphQLPhoto;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: RCTView */
public class SouvenirsElementHelper {
    @Nullable
    public static SouvenirsMediaFieldsModel m26461a(@Nullable SouvenirsMediaElementFieldsModel souvenirsMediaElementFieldsModel) {
        int i = 0;
        if (souvenirsMediaElementFieldsModel == null) {
            return null;
        }
        if ((souvenirsMediaElementFieldsModel.m26330d() == GraphQLSouvenirMediaFieldType.PHOTO || souvenirsMediaElementFieldsModel.m26330d() == GraphQLSouvenirMediaFieldType.VIDEO) && ((EdgesModel) souvenirsMediaElementFieldsModel.m26329c().m26322a().get(0)).m26317a() == null) {
            return null;
        }
        while (i < souvenirsMediaElementFieldsModel.m26329c().m26322a().size()) {
            SouvenirsMediaFieldsModel a = ((EdgesModel) souvenirsMediaElementFieldsModel.m26329c().m26322a().get(i)).m26317a();
            if (a != null) {
                return a;
            }
            i++;
        }
        return null;
    }

    public static ImmutableList<GraphQLPhoto> m26462a(@Nullable SouvenirsDetailsFields souvenirsDetailsFields, boolean z) {
        if (souvenirsDetailsFields == null) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        ImmutableList a = souvenirsDetailsFields.m26305c().m26298a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            SouvenirsMediaElementFieldsModel a2 = ((MediaElementsModel.EdgesModel) a.get(i)).m26292a();
            if (!(a2.m26329c() == null || a2.m26329c().m26322a() == null || a2.m26329c().m26322a().isEmpty() || a2.m26330d() == GraphQLSouvenirMediaFieldType.VIDEO)) {
                int i2;
                if (a2.m26330d() == GraphQLSouvenirMediaFieldType.PHOTO || !z) {
                    i2 = 1;
                } else {
                    i2 = a2.m26329c().m26322a().size();
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    SouvenirsMediaFieldsModel a3 = ((EdgesModel) a2.m26329c().m26322a().get(i3)).m26317a();
                    if (a3 != null) {
                        GraphQLPhoto a4 = SouvenirsConversionHelper.m26431a(a3);
                        if (a4 != null) {
                            builder.c(a4);
                        }
                    }
                }
            }
        }
        return builder.b();
    }

    public static int m26463b(SouvenirsDetailsFieldsModel souvenirsDetailsFieldsModel, boolean z) {
        ImmutableList a = souvenirsDetailsFieldsModel.m26305c().m26298a();
        int size = a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            SouvenirsMediaElementFieldsModel a2 = ((MediaElementsModel.EdgesModel) a.get(i2)).m26292a();
            if (!(a2.m26329c() == null || a2.m26329c().m26322a() == null || a2.m26329c().m26322a().isEmpty())) {
                if (a2.m26330d() == GraphQLSouvenirMediaFieldType.BURST) {
                    int i3 = i;
                    for (i = 0; i < a2.m26329c().m26322a().size(); i++) {
                        SouvenirsMediaFieldsModel a3 = ((EdgesModel) a2.m26329c().m26322a().get(i)).m26317a();
                        if (!(a3 == null || a3.m26383b() == null || a3.m26383b().g() != 77090322)) {
                            i3++;
                            if (!z) {
                                break;
                            }
                        }
                    }
                    i = i3;
                } else if (((EdgesModel) a2.m26329c().m26322a().get(0)).m26317a() != null) {
                    i++;
                }
            }
        }
        return i;
    }
}
