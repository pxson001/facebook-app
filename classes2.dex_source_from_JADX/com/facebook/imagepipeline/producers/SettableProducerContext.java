package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: mediaset/pb.%s */
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ImageRequest imageRequest, String str, ProducerListener producerListener, Object obj, RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        super(imageRequest, str, producerListener, obj, requestLevel, z, z2, priority);
    }
}
