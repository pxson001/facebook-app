package com.facebook.goodfriends.protocol;

import com.facebook.common.util.TriState;
import com.facebook.goodfriends.protocol.GoodFriendsMetaDataQueryModels.GoodFriendsMetadataQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mSerializedMediaItemInternal */
public final class GoodFriendsMetaDataQuery {

    /* compiled from: mSerializedMediaItemInternal */
    public class GoodFriendsMetadataQueryString extends TypedGraphQlQueryString<GoodFriendsMetadataQueryModel> {
        public GoodFriendsMetadataQueryString() {
            super(GoodFriendsMetadataQueryModel.class, false, "GoodFriendsMetadataQuery", "7d1ad3b8b9be18205c9f8584b12800fd", "viewer", "10154631574136729", RegularImmutableSet.a);
        }

        public final TriState m17533g() {
            return TriState.NO;
        }
    }
}
