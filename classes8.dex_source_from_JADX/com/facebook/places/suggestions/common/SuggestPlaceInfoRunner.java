package com.facebook.places.suggestions.common;

import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: search_theme */
public class SuggestPlaceInfoRunner {
    private SimpleExecutor f3779a;
    public SuggestPlaceInfoMethod f3780b;
    public AbstractSingleMethodRunner f3781c;

    public static SuggestPlaceInfoRunner m3646b(InjectorLike injectorLike) {
        return new SuggestPlaceInfoRunner(SimpleExecutor.b(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new SuggestPlaceInfoMethod());
    }

    @Inject
    public SuggestPlaceInfoRunner(SimpleExecutor simpleExecutor, AbstractSingleMethodRunner abstractSingleMethodRunner, SuggestPlaceInfoMethod suggestPlaceInfoMethod) {
        this.f3779a = simpleExecutor;
        this.f3781c = abstractSingleMethodRunner;
        this.f3780b = suggestPlaceInfoMethod;
    }

    public final void m3648a(final SuggestPlaceInfoParams suggestPlaceInfoParams, FutureCallback<Void> futureCallback) {
        this.f3779a.a(new Callable<Void>(this) {
            final /* synthetic */ SuggestPlaceInfoRunner f3778b;

            public Object call() {
                if (((Boolean) this.f3778b.f3781c.a(this.f3778b.f3780b, suggestPlaceInfoParams)).booleanValue()) {
                    return null;
                }
                throw new RuntimeException("This should not happen, but handling it anyway");
            }
        }, futureCallback);
    }

    public final void m3647a() {
        this.f3779a.c();
    }
}
