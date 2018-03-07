package com.facebook.places.create.home;

import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.places.future.SimpleExecutor;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: card_form_mutator_fragment */
public class HomeUpdateRunner {
    public final SimpleExecutor f18357a;
    public final Provider<SingleMethodRunner> f18358b;
    public final HomeUpdateMethod f18359c;

    /* compiled from: card_form_mutator_fragment */
    public class C20071 implements Callable<Boolean> {
        final /* synthetic */ HomeUpdateParams f18355a;
        final /* synthetic */ HomeUpdateRunner f18356b;

        public C20071(HomeUpdateRunner homeUpdateRunner, HomeUpdateParams homeUpdateParams) {
            this.f18356b = homeUpdateRunner;
            this.f18355a = homeUpdateParams;
        }

        public Object call() {
            try {
                return (Boolean) ((AbstractSingleMethodRunner) this.f18356b.f18358b.get()).a(this.f18356b.f18359c, this.f18355a);
            } catch (ApiException e) {
                ApiErrorResult b = e.b();
                if (((long) b.a()) == 2412) {
                    throw new HomeUpdateNameDeniedException();
                } else if (((long) b.a()) == 2413) {
                    throw new HomeUpdateCityDeniedException();
                } else {
                    throw e;
                }
            }
        }
    }

    /* compiled from: card_form_mutator_fragment */
    public class HomeUpdateCityDeniedException extends Exception {
    }

    /* compiled from: card_form_mutator_fragment */
    public class HomeUpdateNameDeniedException extends Exception {
    }

    @Inject
    public HomeUpdateRunner(SimpleExecutor simpleExecutor, Provider<SingleMethodRunner> provider, HomeUpdateMethod homeUpdateMethod) {
        this.f18357a = simpleExecutor;
        this.f18358b = provider;
        this.f18359c = homeUpdateMethod;
    }
}
