package com.facebook.http.protocol;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@NotThreadSafe
/* compiled from: report_app_deletion */
public class ApiRequestBuilder {
    static final RequestIdempotency f7522a = RequestIdempotency.CONSERVATIVE;
    public String f7523A;
    public boolean f7524B;
    public FilePartDescriptor f7525C;
    public String f7526b;
    public String f7527c;
    public String f7528d;
    @Nullable
    public String f7529e;
    @Nullable
    public ImmutableList<Header> f7530f;
    public List<NameValuePair> f7531g;
    public ParamsCollectionMap f7532h;
    public boolean f7533i;
    public boolean f7534j;
    public ApiResponseType f7535k;
    public List<FormBodyPart> f7536l;
    public Object f7537m;
    public boolean f7538n;
    public boolean f7539o;
    public boolean f7540p;
    public boolean f7541q;
    public boolean f7542r;
    public boolean f7543s;
    public boolean f7544t;
    public boolean f7545u = true;
    public FallbackBehavior f7546v = FallbackBehavior.FALLBACK_NOT_REQUIRED;
    public PostEntityType f7547w = PostEntityType.AUTO;
    public RequestIdempotency f7548x = f7522a;
    public volatile FbRequestState f7549y;
    private RequestPriority f7550z;

    public final ApiRequestBuilder m12134a(Map<String, ?> map) {
        return m12135a(map, RegularImmutableBiMap.f695a);
    }

    public final ApiRequestBuilder m12132a(String str) {
        this.f7526b = str;
        return this;
    }

    public final ApiRequestBuilder m12130a(@Nullable ImmutableList<Header> immutableList) {
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Preconditions.checkArgument("X-".equalsIgnoreCase(((Header) immutableList.get(i)).getName().substring(0, 2)));
            }
        }
        this.f7530f = immutableList;
        return this;
    }

    public final ApiRequestBuilder m12137c(String str) {
        this.f7527c = str;
        return this;
    }

    public final FbRequestState m12139f() {
        return m12123D();
    }

    private FbRequestState m12123D() {
        if (this.f7549y == null) {
            synchronized (this) {
                if (this.f7549y == null) {
                    this.f7549y = DefaultRequestStateHolder.m12143a(this.f7526b != null ? this.f7526b : "unknown", this.f7550z);
                }
            }
        }
        return this.f7549y;
    }

    public final ApiRequestBuilder m12128a(RequestPriority requestPriority) {
        this.f7550z = requestPriority;
        if (this.f7549y != null) {
            this.f7549y.m11635a(this.f7550z);
        }
        return this;
    }

    public final ApiRequestBuilder m12138d(String str) {
        this.f7528d = str;
        return this;
    }

    public final ApiRequestBuilder m12133a(List<NameValuePair> list) {
        this.f7531g = list;
        return this;
    }

    public final ApiRequestBuilder m12135a(Map<String, ?> map, Map<String, ? extends Optional<?>> map2) {
        List arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            m12124a(arrayList, (String) entry.getKey(), entry.getValue());
        }
        for (Entry entry2 : map2.entrySet()) {
            Optional optional = (Optional) entry2.getValue();
            if (optional.isPresent()) {
                m12124a(arrayList, (String) entry2.getKey(), optional.get());
            }
        }
        this.f7531g = arrayList;
        return this;
    }

    private static void m12124a(List<NameValuePair> list, String str, Object obj) {
        list.add(new BasicNameValuePair(str, String.valueOf(obj)));
    }

    public final ApiRequestBuilder m12126a(ParamsCollectionMap paramsCollectionMap) {
        this.f7532h = paramsCollectionMap;
        return this;
    }

    public final ApiRequestBuilder m12129a(ApiResponseType apiResponseType) {
        this.f7535k = apiResponseType;
        return this;
    }

    public final ApiRequestBuilder m12136b(List<FormBodyPart> list) {
        this.f7536l = list;
        return this;
    }

    public final ApiRequestBuilder m12131a(File file, int i, int i2) {
        this.f7525C = new FilePartDescriptor(file, i, i2);
        return this;
    }

    public final ApiRequestBuilder m12127a(RequestIdempotency requestIdempotency) {
        this.f7548x = (RequestIdempotency) Preconditions.checkNotNull(requestIdempotency);
        return this;
    }

    public final ApiRequestBuilder m12140g(boolean z) {
        this.f7534j = z;
        return this;
    }

    public final ApiRequestBuilder m12141h(boolean z) {
        this.f7533i = z;
        return this;
    }

    public final ApiRequest m12125C() {
        m12123D();
        return new ApiRequest(this);
    }
}
