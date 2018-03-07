package com.facebook.fbservice.handlers;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;

/* compiled from: pending_shares NOT NULL */
public class ApiMethodServiceHandler<PARAMS, RESULT> implements BlueServiceHandler {
    public static final ParamGetter<Void> f6719a = new C06881();
    public static final ResultConverter<Void> f6720b = new C06892();
    public static final ResultConverter<String> f6721c = new C06903();
    public static final ResultConverter<Parcelable> f6722d = new C06914();
    private final AbstractSingleMethodRunner f6723e;
    private final ApiMethod<PARAMS, RESULT> f6724f;
    private final ParamGetter<? extends PARAMS> f6725g;
    private final ResultConverter<? super RESULT> f6726h;

    /* compiled from: pending_shares NOT NULL */
    public interface ParamGetter<PARAMS> {
        PARAMS mo270a(Bundle bundle);
    }

    /* compiled from: pending_shares NOT NULL */
    final class C06881 implements ParamGetter<Void> {
        C06881() {
        }

        public final Object mo270a(Bundle bundle) {
            return null;
        }
    }

    /* compiled from: pending_shares NOT NULL */
    public interface ResultConverter<RESULT> {
        OperationResult mo271a(RESULT result);
    }

    /* compiled from: pending_shares NOT NULL */
    final class C06892 implements ResultConverter<Void> {
        C06892() {
        }

        public final OperationResult mo271a(Object obj) {
            return OperationResult.a;
        }
    }

    /* compiled from: pending_shares NOT NULL */
    final class C06903 implements ResultConverter<String> {
        C06903() {
        }

        public final OperationResult mo271a(Object obj) {
            return OperationResult.a((String) obj);
        }
    }

    /* compiled from: pending_shares NOT NULL */
    final class C06914 implements ResultConverter<Parcelable> {
        C06914() {
        }

        public final OperationResult mo271a(Object obj) {
            return OperationResult.a((Parcelable) obj);
        }
    }

    /* compiled from: pending_shares NOT NULL */
    public class BaseParamGetter<P> implements ParamGetter<P> {
        private final String f6718a;

        public BaseParamGetter(String str) {
            this.f6718a = str;
        }

        public final P mo270a(Bundle bundle) {
            return bundle.get(this.f6718a);
        }
    }

    public final OperationResult m7020a(OperationParams operationParams) {
        return this.f6726h.mo271a(this.f6723e.a(this.f6724f, this.f6725g.mo270a(operationParams.c)));
    }

    public ApiMethodServiceHandler(SingleMethodRunner singleMethodRunner, ApiMethod<PARAMS, RESULT> apiMethod, ParamGetter<? extends PARAMS> paramGetter, ResultConverter<? super RESULT> resultConverter) {
        this.f6723e = singleMethodRunner;
        this.f6724f = apiMethod;
        this.f6725g = paramGetter;
        this.f6726h = resultConverter;
    }
}
