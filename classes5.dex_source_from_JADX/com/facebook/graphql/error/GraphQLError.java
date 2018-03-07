package com.facebook.graphql.error;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiErrorResult.ErrorDomain;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import org.json.JSONException;
import org.json.JSONObject;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GraphQLErrorDeserializer.class)
@JsonSerialize(using = GraphQLErrorSerializer.class)
/* compiled from: limited */
public class GraphQLError extends ApiErrorResult {
    public static final Creator<GraphQLError> CREATOR = new C02461();
    @JsonProperty("code")
    public final int code;
    @JsonProperty("debug_info")
    public final String debugInfo;
    @JsonProperty("description")
    public final String description;
    @JsonProperty("is_silent")
    public final boolean isSilent;
    @JsonProperty("is_transient")
    public final boolean isTransient;
    @JsonProperty("query_path")
    public final String queryPath;
    @JsonProperty("requires_reauth")
    public final boolean requiresReauth;
    @JsonProperty("summary")
    public final String summary;

    /* compiled from: limited */
    final class C02461 implements Creator<GraphQLError> {
        C02461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLError(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLError[i];
        }
    }

    /* compiled from: limited */
    public class Builder {
        private Optional<Integer> f3185a = Absent.INSTANCE;
        private Optional<String> f3186b = Absent.INSTANCE;
        private Optional<String> f3187c = Absent.INSTANCE;
        private Optional<Boolean> f3188d = Absent.INSTANCE;
        private Optional<Boolean> f3189e = Absent.INSTANCE;
        private Optional<Boolean> f3190f = Absent.INSTANCE;
        private Optional<String> f3191g = Absent.INSTANCE;
        private Optional<String> f3192h = Absent.INSTANCE;

        public final Builder m6226a(int i) {
            this.f3185a = Optional.of(Integer.valueOf(i));
            return this;
        }

        public final Builder m6227a(String str) {
            this.f3186b = Optional.fromNullable(str);
            return this;
        }

        public final Builder m6230b(String str) {
            this.f3187c = Optional.fromNullable(str);
            return this;
        }

        public final Builder m6228a(boolean z) {
            this.f3188d = Optional.of(Boolean.valueOf(z));
            return this;
        }

        public final Builder m6231b(boolean z) {
            this.f3189e = Optional.of(Boolean.valueOf(z));
            return this;
        }

        public final Builder m6233c(boolean z) {
            this.f3190f = Optional.of(Boolean.valueOf(z));
            return this;
        }

        public final Builder m6232c(String str) {
            this.f3191g = Optional.fromNullable(str);
            return this;
        }

        public final GraphQLError m6229a() {
            return new GraphQLError(((Integer) this.f3185a.get()).intValue(), (String) this.f3186b.orNull(), (String) this.f3187c.orNull(), ((Boolean) this.f3188d.get()).booleanValue(), ((Boolean) this.f3189e.get()).booleanValue(), ((Boolean) this.f3190f.get()).booleanValue(), (String) this.f3191g.orNull(), (String) this.f3192h.orNull());
        }
    }

    protected GraphQLError() {
        this(-1, null, null, false, false, false, null, null);
    }

    private GraphQLError(int i, String str, String str2, boolean z, boolean z2, boolean z3, String str3, String str4) {
        super(i, 0, str2, str3, null, null, ErrorDomain.GRAPHQL_KERROR_DOMAIN, null, z2);
        this.code = i;
        this.summary = str;
        this.description = str2;
        this.isSilent = z;
        this.isTransient = z2;
        this.requiresReauth = z3;
        this.debugInfo = str3;
        this.queryPath = str4;
    }

    protected GraphQLError(Parcel parcel) {
        super(parcel);
        this.code = parcel.readInt();
        this.summary = parcel.readString();
        this.description = parcel.readString();
        this.isSilent = m6236a(parcel.readInt());
        this.isTransient = m6236a(parcel.readInt());
        this.requiresReauth = m6236a(parcel.readInt());
        this.debugInfo = parcel.readString();
        this.queryPath = parcel.readString();
    }

    public final int m6237a() {
        return this.code != -1 ? this.code : super.a();
    }

    public final String m6238c() {
        return this.description != null ? this.description : super.c();
    }

    public final String m6239d() {
        return this.debugInfo != null ? this.debugInfo : super.d();
    }

    public final ErrorDomain m6240h() {
        return ErrorDomain.GRAPHQL_KERROR_DOMAIN;
    }

    public String toString() {
        return Objects.toStringHelper(GraphQLError.class).add("code", this.code).add("summary", this.summary).add("description", this.description).add("is_silent", this.isSilent).add("requires_reauth", this.requiresReauth).add("debug_info", this.debugInfo).add("query_path", this.queryPath).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.code);
        parcel.writeString(this.summary);
        parcel.writeString(this.description);
        parcel.writeInt(m6234a(this.isSilent));
        parcel.writeInt(m6234a(this.isTransient));
        parcel.writeInt(m6234a(this.requiresReauth));
        parcel.writeString(this.debugInfo);
        parcel.writeString(this.queryPath);
    }

    private static int m6234a(boolean z) {
        return z ? 1 : 0;
    }

    private static boolean m6236a(int i) {
        return i == 1;
    }

    public static GraphQLError m6235a(JSONObject jSONObject) {
        boolean z = true;
        GraphQLError graphQLError = null;
        if (jSONObject != null) {
            try {
                Builder c = new Builder().m6226a(jSONObject.getInt("code")).m6227a(jSONObject.has("summary") ? jSONObject.getString("summary") : null).m6230b(jSONObject.has("description") ? jSONObject.getString("description") : null).m6232c(jSONObject.has("debug_info") ? jSONObject.getString("debug_info") : null);
                boolean z2 = jSONObject.has("is_silent") && jSONObject.getBoolean("is_silent");
                c = c.m6228a(z2);
                z2 = jSONObject.has("is_transient") && jSONObject.getBoolean("is_transient");
                Builder b = c.m6231b(z2);
                if (!(jSONObject.has("requires_reauth") && jSONObject.getBoolean("requires_reauth"))) {
                    z = false;
                }
                graphQLError = b.m6233c(z).m6230b(jSONObject.has("query_path") ? jSONObject.getString("query_path") : null).m6229a();
            } catch (JSONException e) {
            }
        }
        return graphQLError;
    }
}
