package com.facebook.http.protocol;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.common.DefaultNetworkPriority;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.apache.http.Header;
import org.apache.http.NameValuePair;

@Immutable
/* compiled from: report_inline_privacy_survey_action */
public class ApiRequest {
    private final boolean f7495A;
    public final String f7496a;
    public final String f7497b;
    public final String f7498c;
    @Nullable
    private final String f7499d;
    @Nullable
    public final ImmutableList<Header> f7500e;
    private final String f7501f;
    @Nullable
    private final ImmutableList<NameValuePair> f7502g;
    @Nullable
    public final ParamsCollectionMap f7503h;
    private final boolean f7504i;
    private final boolean f7505j;
    public final ApiResponseType f7506k;
    private final List<FormBodyPart> f7507l;
    private final Object f7508m;
    private final boolean f7509n;
    private final boolean f7510o;
    private final boolean f7511p;
    public final boolean f7512q;
    private final boolean f7513r;
    private final boolean f7514s;
    public boolean f7515t;
    public final boolean f7516u;
    public final PostEntityType f7517v;
    public final FallbackBehavior f7518w;
    public final RequestIdempotency f7519x;
    private final FbRequestState f7520y;
    public final FilePartDescriptor f7521z;

    /* compiled from: report_inline_privacy_survey_action */
    public enum PostEntityType {
        AUTO,
        MULTI_PART_ENTITY,
        SINGLE_STRING_ENTITY,
        FILE_PART_ENTITY
    }

    @Deprecated
    public ApiRequest(String str, String str2, String str3, List<NameValuePair> list, ApiResponseType apiResponseType) {
        this(str, str2, str3, null, list, apiResponseType);
    }

    @Deprecated
    public ApiRequest(String str, String str2, String str3, @Nullable RequestPriority requestPriority, List<NameValuePair> list, ApiResponseType apiResponseType) {
        this.f7496a = str;
        this.f7497b = str2;
        this.f7498c = str3;
        this.f7499d = null;
        this.f7500e = null;
        this.f7520y = DefaultRequestStateHolder.m12143a(str, requestPriority);
        this.f7502g = ImmutableList.copyOf((Collection) list);
        this.f7503h = null;
        this.f7504i = false;
        this.f7505j = false;
        this.f7506k = apiResponseType;
        this.f7507l = RegularImmutableList.f535a;
        this.f7508m = null;
        this.f7509n = false;
        this.f7510o = false;
        this.f7511p = false;
        this.f7512q = false;
        this.f7513r = false;
        this.f7514s = false;
        this.f7518w = FallbackBehavior.FALLBACK_NOT_REQUIRED;
        this.f7515t = false;
        this.f7516u = true;
        this.f7517v = PostEntityType.AUTO;
        this.f7519x = ApiRequestBuilder.f7522a;
        this.f7521z = null;
        this.f7501f = null;
        this.f7495A = false;
    }

    public ApiRequest(ApiRequestBuilder apiRequestBuilder) {
        boolean z;
        ImmutableList copyOf;
        boolean z2 = false;
        Preconditions.checkNotNull(apiRequestBuilder.f7526b);
        Preconditions.checkNotNull(apiRequestBuilder.f7527c);
        Preconditions.checkNotNull(apiRequestBuilder.f7528d);
        if (apiRequestBuilder.f7531g == null && apiRequestBuilder.f7532h == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Either setParameters or setPoolableParameters must be used");
        if (apiRequestBuilder.f7531g == null || apiRequestBuilder.f7532h == null) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Conflict detected: both setParameters and setPoolableParameters used");
        this.f7496a = apiRequestBuilder.f7526b;
        this.f7497b = apiRequestBuilder.f7527c;
        this.f7498c = apiRequestBuilder.f7528d;
        this.f7499d = apiRequestBuilder.f7529e;
        this.f7500e = apiRequestBuilder.f7530f;
        this.f7520y = apiRequestBuilder.m12139f();
        if (apiRequestBuilder.f7531g != null) {
            copyOf = ImmutableList.copyOf((Collection) apiRequestBuilder.f7531g);
        } else {
            copyOf = null;
        }
        this.f7502g = copyOf;
        this.f7503h = apiRequestBuilder.f7532h;
        this.f7504i = apiRequestBuilder.f7533i;
        this.f7505j = apiRequestBuilder.f7534j;
        this.f7506k = apiRequestBuilder.f7535k;
        this.f7507l = apiRequestBuilder.f7536l;
        this.f7508m = apiRequestBuilder.f7537m;
        this.f7509n = apiRequestBuilder.f7538n;
        this.f7510o = apiRequestBuilder.f7539o;
        this.f7512q = apiRequestBuilder.f7541q;
        this.f7513r = apiRequestBuilder.f7542r;
        this.f7514s = apiRequestBuilder.f7543s;
        this.f7518w = apiRequestBuilder.f7546v;
        this.f7515t = apiRequestBuilder.f7544t;
        this.f7516u = apiRequestBuilder.f7545u;
        this.f7517v = apiRequestBuilder.f7547w;
        this.f7519x = (RequestIdempotency) Preconditions.checkNotNull(apiRequestBuilder.f7548x);
        this.f7521z = apiRequestBuilder.f7525C;
        this.f7511p = apiRequestBuilder.f7540p;
        if (this.f7511p) {
            this.f7501f = (String) Preconditions.checkNotNull(apiRequestBuilder.f7523A);
        } else {
            this.f7501f = null;
        }
        this.f7495A = apiRequestBuilder.f7524B;
    }

    public static ApiRequestBuilder newBuilder() {
        return new ApiRequestBuilder();
    }

    public final String m12102a() {
        return this.f7496a;
    }

    @Nullable
    public final String m12103b() {
        return this.f7499d;
    }

    public final String m12104d() {
        return this.f7497b;
    }

    public final String m12105f() {
        return this.f7498c;
    }

    public final FbRequestState m12106g() {
        this.f7520y.m11637b(DefaultNetworkPriority.m12223a());
        return this.f7520y;
    }

    public final ImmutableList<NameValuePair> m12107h() {
        return this.f7502g != null ? this.f7502g : RegularImmutableList.f535a;
    }

    @Nonnull
    public final ParamsCollectionMap m12108j() {
        if (this.f7503h != null) {
            return this.f7503h;
        }
        throw new IllegalStateException("Must call hasPoolableParameters first");
    }

    public final boolean m12109k() {
        return this.f7504i;
    }

    public final boolean m12110l() {
        return this.f7505j;
    }

    public final List<FormBodyPart> m12111m() {
        if (this.f7507l == null || this.f7507l.isEmpty()) {
            return null;
        }
        return this.f7507l;
    }

    public final ApiResponseType m12112n() {
        return this.f7506k;
    }

    public final boolean m12113o() {
        return this.f7509n;
    }

    public final boolean m12114p() {
        return this.f7510o;
    }

    public final boolean m12115q() {
        return this.f7511p;
    }

    public final boolean m12116r() {
        return this.f7512q;
    }

    public final boolean m12117s() {
        return this.f7513r;
    }

    public final boolean m12118t() {
        return this.f7514s;
    }

    public final FallbackBehavior m12119u() {
        return this.f7518w;
    }

    public final PostEntityType m12120v() {
        return this.f7517v;
    }

    public final RequestIdempotency m12121w() {
        return this.f7519x;
    }

    public final String m12122z() {
        return this.f7501f;
    }

    public final boolean m12101A() {
        return this.f7495A;
    }
}
