package com.facebook.privacy.checkup.protocol;

import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces$MediaMetadataWithoutFeedback;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.MediaCreatorPrivacyScopeModel;
import javax.annotation.Nullable;

/* compiled from: java.util.NavigableSet */
public interface C0739x5593ba48 extends PhotosMetadataGraphQLInterfaces$MediaMetadataWithoutFeedback {
    @Nullable
    CommonGraphQLInterfaces$DefaultImageFields bd_();

    @Nullable
    CommonGraphQLInterfaces$DefaultImageFields be_();

    @Nullable
    CommonGraphQL2Interfaces$DefaultVect2Fields mo3002c();

    @Nullable
    String mo3003d();

    long m26187j();

    @Nullable
    MediaCreatorPrivacyScopeModel m26188k();
}
