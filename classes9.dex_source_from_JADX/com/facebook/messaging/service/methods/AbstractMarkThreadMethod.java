package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadResult;
import com.facebook.messaging.service.model.MarkThreadResult.Builder;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: decline_payment_request */
public abstract class AbstractMarkThreadMethod implements ApiMethod<MarkThreadFields, MarkThreadResult> {
    private final Provider<Boolean> f16861a;
    private final Mark f16862b;

    public final ApiRequest m16846a(Object obj) {
        String str;
        MarkThreadFields markThreadFields = (MarkThreadFields) obj;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        List a = Lists.a();
        objectNode.a("name", this.f16862b.getApiName());
        objectNode.a("state", markThreadFields.f17205b);
        if (markThreadFields.f17208e != -1) {
            objectNode.a("watermark_timestamp", String.valueOf(markThreadFields.f17208e));
        } else if (!((Boolean) this.f16861a.get()).booleanValue() || markThreadFields.f17207d == -1) {
            objectNode.a("action_id", String.valueOf(markThreadFields.f17206c));
        } else {
            objectNode.a("sync_seq_id", String.valueOf(markThreadFields.f17207d));
        }
        a.add(new BasicNameValuePair("tag", objectNode.toString()));
        a.add(new BasicNameValuePair("format", "json"));
        if (markThreadFields.f17204a.a == Type.ONE_TO_ONE) {
            str = "ct_" + Long.toString(markThreadFields.f17204a.d);
        } else {
            str = MessagingIdUtil.m17835b(markThreadFields.f17204a.b);
        }
        return new ApiRequest("markThread", "POST", str, a, ApiResponseType.STRING);
    }

    public final Object m16847a(Object obj, ApiResponse apiResponse) {
        MarkThreadFields markThreadFields = (MarkThreadFields) obj;
        apiResponse.i();
        Builder builder = new Builder();
        builder.f17210a = markThreadFields.f17204a;
        return new MarkThreadResult(builder);
    }

    public AbstractMarkThreadMethod(Provider<Boolean> provider, Mark mark) {
        this.f16861a = provider;
        this.f16862b = mark;
    }
}
