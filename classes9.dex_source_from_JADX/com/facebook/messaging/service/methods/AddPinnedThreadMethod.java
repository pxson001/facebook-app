package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.AddPinnedThreadParams;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: dcbfcbc9b2190e511275ed3654c977c7 */
public class AddPinnedThreadMethod implements ApiMethod<AddPinnedThreadParams, Void> {
    public final ApiRequest m16856a(Object obj) {
        String str;
        AddPinnedThreadParams addPinnedThreadParams = (AddPinnedThreadParams) obj;
        List a = Lists.a();
        String str2 = "t_%s/pin";
        if (addPinnedThreadParams.f17013a == null) {
            str = addPinnedThreadParams.f17014b;
        } else {
            str = "t_" + addPinnedThreadParams.f17013a.i();
        }
        return new ApiRequest("addPinnedThread", "POST", StringFormatUtil.formatStrLocaleSafe(str2, str), a, ApiResponseType.STRING);
    }

    public final Object m16857a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
