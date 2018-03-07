package com.facebook.goodwill.publish;

import android.text.TextUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: wrap_content */
public class PublishGoodwillVideoMethod implements ApiMethod<PublishGoodwillVideoParams, Boolean> {
    public final ApiRequest m180a(Object obj) {
        PublishGoodwillVideoParams publishGoodwillVideoParams = (PublishGoodwillVideoParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("campaign_id", publishGoodwillVideoParams.f189c));
        arrayList.add(new BasicNameValuePair("campaign_type", publishGoodwillVideoParams.f188b));
        arrayList.add(new BasicNameValuePair("privacy", publishGoodwillVideoParams.f190d));
        arrayList.add(new BasicNameValuePair("message", publishGoodwillVideoParams.f191e));
        arrayList.add(new BasicNameValuePair("source", publishGoodwillVideoParams.f193g));
        arrayList.add(new BasicNameValuePair("direct_source", publishGoodwillVideoParams.f194h));
        if (CollectionUtil.b(publishGoodwillVideoParams.f195i)) {
            arrayList.add(new BasicNameValuePair("tagged_ids", "[" + Joiner.on(',').skipNulls().join(publishGoodwillVideoParams.f195i) + "]"));
        }
        if (CollectionUtil.b(publishGoodwillVideoParams.f196j)) {
            String str;
            String str2 = "photo_ids";
            StringBuilder stringBuilder = new StringBuilder("[");
            List<GoodwillPublishPhoto> list = publishGoodwillVideoParams.f196j;
            StringBuilder stringBuilder2 = new StringBuilder();
            if (list == null || list.isEmpty()) {
                str = "";
            } else {
                for (GoodwillPublishPhoto goodwillPublishPhoto : list) {
                    stringBuilder2.append(goodwillPublishPhoto.f158a);
                    stringBuilder2.append(',');
                }
                str = stringBuilder2.toString();
            }
            arrayList.add(new BasicNameValuePair(str2, stringBuilder.append(str).append("]").toString()));
        }
        if (!TextUtils.isEmpty(publishGoodwillVideoParams.f197k)) {
            arrayList.add(new BasicNameValuePair("payload", publishGoodwillVideoParams.f197k));
        }
        String a = StringFormatUtil.a("%s/goodwill_videos", new Object[]{publishGoodwillVideoParams.f187a});
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.d = a;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.c = "POST";
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.b = "goodwillVideosPost";
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.g = arrayList;
        return apiRequestBuilder2.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m181a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
