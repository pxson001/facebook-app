package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.MessageTable;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.MessagesResult;
import com.facebook.messaging.service.model.FetchMessageParams;
import com.facebook.messaging.service.model.FetchMessageResult;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: dataFreshnessParam */
public class FetchMessageMethod implements ApiMethod<FetchMessageParams, FetchMessageResult> {
    public final FetchThreadsFqlHelper f16880a;

    public static FetchMessageMethod m16893b(InjectorLike injectorLike) {
        return new FetchMessageMethod(FetchThreadsFqlHelper.m16938b(injectorLike));
    }

    public final ApiRequest m16894a(Object obj) {
        FetchMessageParams fetchMessageParams = (FetchMessageParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        String str = fetchMessageParams.f17063a;
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        this.f16880a.m16954b(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("message_id='%1s'", MessagingIdUtil.m17836b(str)), "timestamp DESC", 1, MessageTable.Normal);
        arrayList.add(new BasicNameValuePair("q", fqlMultiQueryHelper.a().toString()));
        return new ApiRequest("fetchMoreMessages", "GET", "fql", arrayList, ApiResponseType.JSON);
    }

    public final Object m16895a(Object obj, ApiResponse apiResponse) {
        MessagesResult b = this.f16880a.m16952b(new FqlResultHelper(apiResponse.c()), 1, ((FetchMessageParams) obj).f17064b);
        return new FetchMessageResult(DataFreshnessResult.FROM_SERVER, b.f16905a.isEmpty() ? null : (Message) b.f16905a.get(0), System.currentTimeMillis());
    }

    @Inject
    public FetchMessageMethod(FetchThreadsFqlHelper fetchThreadsFqlHelper) {
        this.f16880a = fetchThreadsFqlHelper;
    }

    public static FetchMessageMethod m16892a(InjectorLike injectorLike) {
        return m16893b(injectorLike);
    }
}
