package com.facebook.http.common;

import com.facebook.inject.AbstractAssistedProvider;
import org.apache.http.HttpResponse;

/* compiled from: referrer */
public class MeasuringHttpResponseWrapperProvider extends AbstractAssistedProvider<MeasuringHttpResponseWrapper> {
    public final MeasuringHttpResponseWrapper m12371a(HttpResponse httpResponse) {
        return new MeasuringHttpResponseWrapper((MeasuringEntityProvider) getOnDemandAssistedProviderForStaticDi(MeasuringEntityProvider.class), httpResponse);
    }
}
