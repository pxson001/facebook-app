package com.facebook.places.create.network;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: caption_title_medium_style */
public class PlaceCreationRunner {
    public final SimpleExecutor f18388a;
    public final PlaceCreationMethod f18389b;
    public final AbstractSingleMethodRunner f18390c;
    public final PlaceCreationErrorParser f18391d;

    public static PlaceCreationRunner m22330b(InjectorLike injectorLike) {
        return new PlaceCreationRunner(SimpleExecutor.b(injectorLike), new PlaceCreationMethod(), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new PlaceCreationErrorParser(JsonFactoryMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public PlaceCreationRunner(SimpleExecutor simpleExecutor, PlaceCreationMethod placeCreationMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, PlaceCreationErrorParser placeCreationErrorParser) {
        this.f18388a = simpleExecutor;
        this.f18389b = placeCreationMethod;
        this.f18390c = abstractSingleMethodRunner;
        this.f18391d = placeCreationErrorParser;
    }

    public final void m22331a(final PlaceCreationParams placeCreationParams, FutureCallback<Long> futureCallback) {
        this.f18388a.a(new Callable<Long>(this) {
            final /* synthetic */ PlaceCreationRunner f18387b;

            public Object call() {
                try {
                    return (Long) this.f18387b.f18390c.a(this.f18387b.f18389b, placeCreationParams);
                } catch (ApiException e) {
                    this.f18387b.f18391d.m22314a(e.b());
                    throw e;
                }
            }
        }, futureCallback);
    }
}
