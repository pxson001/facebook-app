package com.facebook.goodwill.publish;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.protocol.PublishPostMethod;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: xma_id */
public class PublishFriendversaryCollageMethod implements ApiMethod<PublishFriendversaryCollageParams, String> {
    private final FbObjectMapper f180a;
    private final PublishPostMethod f181b;

    @AutoGenJsonSerializer
    @AutoGenJsonDeserializer
    /* compiled from: xma_id */
    public class ThrowbackCardPojo {
        @JsonProperty("campaign_id")
        final long campaign_id;
        @JsonProperty("media_ids")
        final List<String> media_ids;
        @JsonProperty("source")
        final String source;

        public ThrowbackCardPojo(String str, String str2, List<String> list) {
            this.campaign_id = Long.parseLong(str2);
            this.source = str;
            this.media_ids = list;
        }
    }

    public final ApiRequest m172a(Object obj) {
        PublishFriendversaryCollageParams publishFriendversaryCollageParams = (PublishFriendversaryCollageParams) obj;
        if (!(publishFriendversaryCollageParams.f185c == null || publishFriendversaryCollageParams.f185c.isEmpty())) {
            List arrayList = new ArrayList();
            for (GoodwillPublishPhoto goodwillPublishPhoto : publishFriendversaryCollageParams.f185c) {
                arrayList.add(goodwillPublishPhoto.f158a);
            }
            ThrowbackCardPojo throwbackCardPojo = new ThrowbackCardPojo(publishFriendversaryCollageParams.f184b, publishFriendversaryCollageParams.f183a, arrayList);
            Builder builder = new Builder(publishFriendversaryCollageParams.f186d);
            builder.a = this.f180a.a(throwbackCardPojo);
            Builder builder2 = builder;
            builder2.aa = publishFriendversaryCollageParams.f186d.redSpaceValue;
            publishFriendversaryCollageParams.f186d = builder2.a();
        }
        return this.f181b.a(publishFriendversaryCollageParams.f186d);
    }

    public final Object m173a(Object obj, ApiResponse apiResponse) {
        PublishPostParams publishPostParams = ((PublishFriendversaryCollageParams) obj).f186d;
        return PublishPostMethod.a(apiResponse);
    }

    @Inject
    public PublishFriendversaryCollageMethod(PublishPostMethod publishPostMethod, FbObjectMapper fbObjectMapper) {
        this.f180a = fbObjectMapper;
        this.f181b = publishPostMethod;
    }
}
