package com.facebook.messaging.service.methods;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadDeliveryReceipts;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadTable;
import com.facebook.messaging.service.model.FetchDeliveryReceiptsParams;
import com.facebook.messaging.service.model.FetchDeliveryReceiptsResult;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: date DESC LIMIT  */
public class FetchDeliveryReceiptsMethod implements ApiMethod<FetchDeliveryReceiptsParams, FetchDeliveryReceiptsResult> {
    private static final Class<?> f16877a = FetchDeliveryReceiptsMethod.class;
    private final DeliveryReceiptsDeserializer f16878b;

    public final ApiRequest m16884a(Object obj) {
        FetchDeliveryReceiptsParams fetchDeliveryReceiptsParams = (FetchDeliveryReceiptsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("q", m16883b(fetchDeliveryReceiptsParams)));
        return new ApiRequest("fetchDeliveryReceipts", "GET", "fql", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    private static String m16883b(FetchDeliveryReceiptsParams fetchDeliveryReceiptsParams) {
        ImmutableList immutableList = fetchDeliveryReceiptsParams.f17045a;
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadKey threadKey = (ThreadKey) immutableList.get(i);
            if (threadKey.a == Type.GROUP) {
                builder2.c(Long.valueOf(threadKey.b));
            } else {
                builder.c(Long.valueOf(threadKey.d));
            }
        }
        String str = "delivery_receipts";
        String str2 = "thread_fbid, single_recipient, delivery_receipts";
        StringBuilder stringBuilder = new StringBuilder();
        ImmutableList b = builder.b();
        ImmutableList b2 = builder2.b();
        if (!b.isEmpty()) {
            stringBuilder.append("single_recipient in (").append(Joiner.on(",").join(b)).append(")");
        }
        if (!b2.isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" OR ");
            }
            stringBuilder.append("thread_fbid in (").append(Joiner.on(",").join(b2)).append(")");
        }
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        fqlMultiQueryHelper.a(str, StringFormatUtil.formatStrLocaleSafe("SELECT %1$s FROM %2$s WHERE %3$s", str2, ThreadTable.Normal.name, stringBuilder));
        fqlMultiQueryHelper.a();
        return fqlMultiQueryHelper.a().toString();
    }

    @Inject
    public FetchDeliveryReceiptsMethod(DeliveryReceiptsDeserializer deliveryReceiptsDeserializer) {
        this.f16878b = deliveryReceiptsDeserializer;
    }

    public final Object m16885a(Object obj, ApiResponse apiResponse) {
        JsonNode a = new FqlResultHelper(apiResponse.c()).a("delivery_receipts");
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a.e(); i++) {
            ThreadKey a2;
            JsonNode a3 = a.a(i);
            DeliveryReceiptsDeserializer deliveryReceiptsDeserializer = this.f16878b;
            String b = JSONUtil.b(a3.b("thread_fbid"));
            String b2 = JSONUtil.b(a3.b("single_recipient"));
            if (b2 != null) {
                a2 = ThreadKey.a(Long.parseLong(b2), Long.parseLong(((ViewerContext) deliveryReceiptsDeserializer.f16876a.get()).mUserId));
            } else {
                a2 = ThreadKey.a(Long.parseLong(b));
            }
            JsonNode b3 = a3.b("delivery_receipts");
            ImmutableMap.Builder builder2 = ImmutableMap.builder();
            if (b3 != null) {
                Iterator H = b3.H();
                while (H.hasNext()) {
                    Entry entry = (Entry) H.next();
                    builder2.b(new UserKey(User.Type.FACEBOOK, (String) entry.getKey()), Long.valueOf(JSONUtil.c(((JsonNode) entry.getValue()).b("time"))));
                }
            }
            builder.c(new ThreadDeliveryReceipts(a2, builder2.b()));
        }
        return new FetchDeliveryReceiptsResult(builder.b());
    }
}
