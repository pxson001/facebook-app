package com.facebook.crudolib.net;

import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: Too much memory being used by other bitmaps to create new bitmap. */
public class ChainableRequestMutatorBuilder {
    private final ArrayList<RequestMutator> f24024a = new ArrayList();

    /* compiled from: Too much memory being used by other bitmaps to create new bitmap. */
    class CompositeRequestMutator implements ChainableRequestMutator {
        private final RequestMutator f24022a;
        @Nullable
        private final CompositeRequestMutator f24023b;

        public CompositeRequestMutator(RequestMutator requestMutator, @Nullable CompositeRequestMutator compositeRequestMutator) {
            this.f24022a = requestMutator;
            this.f24023b = compositeRequestMutator;
        }

        public final RequestMutator mo1105a() {
            return this.f24022a;
        }

        @Nullable
        public final ChainableRequestMutator mo1106b() {
            return this.f24023b;
        }
    }

    public ChainableRequestMutatorBuilder(ChainableRequestMutator chainableRequestMutator) {
        for (ChainableRequestMutator chainableRequestMutator2 = chainableRequestMutator; chainableRequestMutator2 != null; chainableRequestMutator2 = chainableRequestMutator2.mo1106b()) {
            m25965a(chainableRequestMutator.mo1105a());
        }
    }

    public final ChainableRequestMutatorBuilder m25965a(RequestMutator requestMutator) {
        this.f24024a.add(requestMutator);
        return this;
    }

    public final ChainableRequestMutator m25964a() {
        CompositeRequestMutator compositeRequestMutator = null;
        int size = this.f24024a.size() - 1;
        while (size >= 0) {
            CompositeRequestMutator compositeRequestMutator2 = new CompositeRequestMutator((RequestMutator) this.f24024a.get(size), compositeRequestMutator);
            size--;
            compositeRequestMutator = compositeRequestMutator2;
        }
        return compositeRequestMutator;
    }
}
