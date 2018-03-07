package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.BlockUserParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: dbl/ */
public class BlockUserMethod implements ApiMethod<BlockUserParams, Void> {
    public final ApiRequest m16862a(Object obj) {
        BlockUserParams blockUserParams = (BlockUserParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("uid", String.valueOf(blockUserParams.f17015a)));
        return new ApiRequest("blockUser", "POST", StringFormatUtil.formatStrLocaleSafe("%d/blocked", Long.valueOf(blockUserParams.f17016b)), RequestPriority.INTERACTIVE, arrayList, ApiResponseType.JSON);
    }

    public final Object m16863a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
