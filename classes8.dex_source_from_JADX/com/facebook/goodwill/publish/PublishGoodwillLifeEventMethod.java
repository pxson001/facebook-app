package com.facebook.goodwill.publish;

import android.text.TextUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: write_post_to_page_tap */
public class PublishGoodwillLifeEventMethod implements ApiMethod<GoodwillPublishLifeEventParam, String> {
    public final ApiRequest m178a(Object obj) {
        GoodwillPublishLifeEventParam goodwillPublishLifeEventParam = (GoodwillPublishLifeEventParam) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("privacy", goodwillPublishLifeEventParam.f150b));
        if (goodwillPublishLifeEventParam.f151c != null) {
            String str = "photo_ids";
            List<GoodwillPublishPhoto> list = goodwillPublishLifeEventParam.f151c;
            StringBuilder stringBuilder = new StringBuilder("[");
            int i = 0;
            for (GoodwillPublishPhoto goodwillPublishPhoto : list) {
                int i2;
                if (TextUtils.isEmpty(goodwillPublishPhoto.f158a)) {
                    i2 = i;
                } else {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(goodwillPublishPhoto.f158a);
                    i2 = i + 1;
                }
                i = i2;
            }
            stringBuilder.append("]");
            arrayList.add(new BasicNameValuePair(str, stringBuilder.toString()));
        }
        arrayList.add(new BasicNameValuePair("description", goodwillPublishLifeEventParam.f152d));
        arrayList.add(new BasicNameValuePair("source", goodwillPublishLifeEventParam.f153e));
        return new ApiRequest("goodwillLifeEventsPost", "POST", StringFormatUtil.a("%s/life_events", new Object[]{goodwillPublishLifeEventParam.f149a}), RequestPriority.INTERACTIVE, arrayList, ApiResponseType.JSON);
    }

    public final Object m179a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        if (apiResponse.c().b("id") != null) {
            return apiResponse.c().b("id").B();
        }
        return null;
    }
}
