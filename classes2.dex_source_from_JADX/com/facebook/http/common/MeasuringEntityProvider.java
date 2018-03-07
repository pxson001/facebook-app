package com.facebook.http.common;

import com.facebook.inject.AbstractAssistedProvider;
import org.apache.http.HttpEntity;

/* compiled from: mHidden= */
public class MeasuringEntityProvider extends AbstractAssistedProvider<MeasuringEntity> {
    public final MeasuringEntity m22191a(HttpEntity httpEntity) {
        return new MeasuringEntity((MeasuringInputStreamProvider) getOnDemandAssistedProviderForStaticDi(MeasuringInputStreamProvider.class), httpEntity);
    }
}
