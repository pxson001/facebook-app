package com.facebook.messaging.service.methods;

import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: cvvToken */
public class GetAuthenticatedAttachmentUrlMethod implements ApiMethod<OtherAttachmentData, Uri> {
    public final ApiRequest m16957a(Object obj) {
        OtherAttachmentData otherAttachmentData = (OtherAttachmentData) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        fqlMultiQueryHelper.a("url", StringFormatUtil.formatStrLocaleSafe("SELECT src FROM message_previewable_attachment_src WHERE message_id='%1$s' and  attachment_id='%2$s'", MessagingIdUtil.m17836b(otherAttachmentData.f7756e), otherAttachmentData.f7757f));
        a.add(new BasicNameValuePair("q", fqlMultiQueryHelper.a().toString()));
        return new ApiRequest("fetchThreadList", "GET", "fql", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m16958a(Object obj, ApiResponse apiResponse) {
        JsonNode f = new FqlResultHelper(apiResponse.c()).a("url").f("src");
        if (f == null) {
            throw new IllegalStateException("no src field returned in fql response");
        }
        Object B = f.B();
        if (!StringUtil.a(B)) {
            return Uri.parse(B);
        }
        throw new IllegalStateException("no value returned for src field in fql response");
    }
}
