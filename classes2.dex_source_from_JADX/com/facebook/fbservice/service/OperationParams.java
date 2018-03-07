package com.facebook.fbservice.service;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.BlueServiceChainedProgressCallback.ChainedProgressCallback;
import com.facebook.http.common.FbRequestState;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: file_null */
public class OperationParams {
    @Nullable
    public final String f23703a;
    public final String f23704b;
    public final Bundle f23705c;
    @Nullable
    public final FbRequestState f23706d;
    @Nullable
    public final CallerContext f23707e;
    @Nullable
    public final BlueServiceProgressCallback f23708f;

    public OperationParams(String str, Bundle bundle) {
        this(str, bundle, null, null, null, null);
    }

    public OperationParams(String str, Bundle bundle, @Nullable String str2, @Nullable FbRequestState fbRequestState, @Nullable CallerContext callerContext, @Nullable BlueServiceProgressCallback blueServiceProgressCallback) {
        this.f23704b = str;
        this.f23705c = bundle;
        this.f23706d = fbRequestState;
        this.f23707e = callerContext;
        this.f23708f = blueServiceProgressCallback;
        this.f23703a = str2;
    }

    public final String m32126a() {
        return this.f23704b;
    }

    public final Bundle m32127b() {
        return this.f23705c;
    }

    @Nullable
    public final BlueServiceProgressCallback m32128d() {
        return this.f23708f;
    }

    @Nullable
    public final String m32129e() {
        return this.f23703a;
    }

    @Nullable
    public final CallerContext m32130f() {
        return this.f23707e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OperationParams)) {
            return false;
        }
        OperationParams operationParams = (OperationParams) obj;
        if (operationParams.f23704b.equals(this.f23704b) && operationParams.f23705c.equals(this.f23705c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f23704b, this.f23705c);
    }

    public final OperationParams m32125a(ChainedProgressCallback chainedProgressCallback) {
        Builder a = m32124g().a(this);
        a.f = new BlueServiceChainedProgressCallback(this.f23708f, chainedProgressCallback);
        return a.g();
    }

    public static Builder m32124g() {
        return new Builder();
    }

    public OperationParams(Builder builder) {
        this(builder.b, builder.c, builder.a, builder.d, builder.e, builder.f);
    }
}
