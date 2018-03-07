package com.facebook.http.protocol;

import com.facebook.common.util.TriState;
import com.facebook.feed.server.NewsFeedServiceImplementation.1;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Objects;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.Header;

/* compiled from: feature_enabled */
public class BatchOperation<PARAMS, RESULT> {
    public final ApiMethod<PARAMS, RESULT> f11917a;
    public final PARAMS f11918b;
    public final String f11919c;
    public final String f11920d;
    public final String f11921e;
    @Nullable
    private final 1 f11922f;
    public final String f11923g;
    private final TriState f11924h;

    /* compiled from: feature_enabled */
    public class Builder<PARAMS, RESULT> {
        public final ApiMethod<PARAMS, RESULT> f11925a;
        public final PARAMS f11926b;
        public String f11927c;
        public String f11928d;
        public String f11929e;
        @Nullable
        public 1 f11930f;
        public String f11931g;
        public TriState f11932h = TriState.UNSET;

        public Builder(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params) {
            this.f11925a = apiMethod;
            this.f11926b = params;
        }

        public final Builder<PARAMS, RESULT> m12547a(String str) {
            this.f11927c = str;
            return this;
        }

        public final Builder<PARAMS, RESULT> m12550b(String str) {
            this.f11928d = str;
            return this;
        }

        public final Builder<PARAMS, RESULT> m12548a(boolean z) {
            this.f11932h = z ? TriState.YES : TriState.NO;
            return this;
        }

        public final BatchOperation<PARAMS, RESULT> m12549a() {
            return new BatchOperation(this);
        }
    }

    /* compiled from: feature_enabled */
    public class ProcessedBatchResponse {
        public static final ProcessedBatchResponse f11953a = new ProcessedBatchResponse(-1, null, null, null);
        private final int f11954b;
        private final List<Header> f11955c;
        private final String f11956d;
        private final JsonParser f11957e;

        protected ProcessedBatchResponse(int i, @Nullable List<Header> list, @Nullable String str, @Nullable JsonParser jsonParser) {
            this.f11954b = i;
            this.f11955c = list;
            this.f11956d = str;
            this.f11957e = jsonParser;
        }

        public final int m12609a() {
            return this.f11954b;
        }

        public final JsonParser m12610b() {
            return this.f11957e;
        }
    }

    BatchOperation(Builder<PARAMS, RESULT> builder) {
        this.f11917a = builder.f11925a;
        this.f11918b = builder.f11926b;
        this.f11919c = builder.f11927c;
        this.f11920d = builder.f11928d;
        this.f11921e = builder.f11929e;
        this.f11922f = builder.f11930f;
        this.f11924h = builder.f11932h;
        this.f11923g = builder.f11931g;
    }

    public static <PARAMS, RESULT> Builder<PARAMS, RESULT> m12541a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params) {
        return new Builder(apiMethod, params);
    }

    public final ApiMethod<PARAMS, RESULT> m12542a() {
        return this.f11917a;
    }

    public final PARAMS m12543b() {
        return this.f11918b;
    }

    public final String m12544c() {
        return this.f11919c;
    }

    public final 1 m12545g() {
        return this.f11922f;
    }

    public final TriState m12546h() {
        return this.f11924h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BatchOperation)) {
            return false;
        }
        BatchOperation batchOperation = (BatchOperation) obj;
        if (Objects.equal(this.f11919c, batchOperation.f11919c) && Objects.equal(this.f11917a, batchOperation.f11917a) && Objects.equal(this.f11918b, batchOperation.f11918b) && Objects.equal(this.f11920d, batchOperation.f11920d) && Objects.equal(this.f11921e, batchOperation.f11921e) && Objects.equal(this.f11923g, batchOperation.f11923g) && this.f11924h == batchOperation.f11924h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f11919c, this.f11917a, this.f11918b, this.f11920d, this.f11921e, this.f11923g, this.f11924h});
    }
}
