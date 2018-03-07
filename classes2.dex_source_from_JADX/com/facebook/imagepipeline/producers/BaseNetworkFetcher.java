package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: orientation_change */
public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState> {
    public abstract FETCH_STATE mo2059a(Consumer<EncodedImage> consumer, ProducerContext producerContext);

    public abstract void mo2061a(FETCH_STATE fetch_state, Callback callback);

    public boolean mo2062a(FETCH_STATE fetch_state) {
        return true;
    }

    public void mo2060a(FETCH_STATE fetch_state, int i) {
    }

    @Nullable
    public Map<String, String> mo2063b(FETCH_STATE fetch_state, int i) {
        return null;
    }
}
