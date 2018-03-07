package com.facebook.timeline.protiles.util;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.google.common.collect.ImmutableList;

/* compiled from: fb4a_displaying_faceweb_feedfilterpicker */
public class ProtilesLoggingUtil {
    public static int m12433a(ProtileModel protileModel) {
        int i = 0;
        if (protileModel.m12109b() == GraphQLProfileTileSectionType.FRIENDS) {
            ImmutableList immutableList = protileModel.f12107c;
            int size = immutableList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3;
                ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) immutableList.get(i2);
                if (protileItemFieldsModel.m12184k() == null || protileItemFieldsModel.m12184k().m12156m() != GraphQLFriendshipStatus.ARE_FRIENDS) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public static int m12434b(ProtileModel protileModel) {
        int i = 0;
        if (protileModel.m12109b() == GraphQLProfileTileSectionType.PHOTOS) {
            ImmutableList immutableList = protileModel.f12107c;
            int size = immutableList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3;
                if (((ProtileItemFieldsModel) immutableList.get(i2)).m12183j() != null) {
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }
}
