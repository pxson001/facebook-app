package com.facebook.katana.server.handler;

import android.content.Context;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.server.protocol.FetchFacewebComponentsMethod;
import com.facebook.katana.webview.AsyncFacewebComponentsStoreSerialization;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: transferIds and states differ in length. */
public class FacewebComponentsStoreHandler implements BlueServiceHandler {
    private final Provider<SingleMethodRunner> f1162a;
    private final FetchFacewebComponentsMethod f1163b;
    private final AsyncFacewebComponentsStoreSerialization f1164c;

    public static FacewebComponentsStoreHandler m1188b(InjectorLike injectorLike) {
        return new FacewebComponentsStoreHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new FetchFacewebComponentsMethod(JsonFactoryMethodAutoProvider.a(injectorLike)), new AsyncFacewebComponentsStoreSerialization((Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public FacewebComponentsStoreHandler(Provider<SingleMethodRunner> provider, FetchFacewebComponentsMethod fetchFacewebComponentsMethod, AsyncFacewebComponentsStoreSerialization asyncFacewebComponentsStoreSerialization) {
        this.f1162a = provider;
        this.f1163b = fetchFacewebComponentsMethod;
        this.f1164c = asyncFacewebComponentsStoreSerialization;
    }

    public final OperationResult m1189a(OperationParams operationParams) {
        if (!operationParams.a().equals("fetchFwComponents")) {
            return null;
        }
        FacewebComponentsStore facewebComponentsStore;
        try {
            facewebComponentsStore = (FacewebComponentsStore) ((AbstractSingleMethodRunner) this.f1162a.get()).a(this.f1163b, null);
        } catch (Exception e) {
            facewebComponentsStore = null;
        }
        this.f1164c.m1280a(facewebComponentsStore);
        return OperationResult.a();
    }
}
