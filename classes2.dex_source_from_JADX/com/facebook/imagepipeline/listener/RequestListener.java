package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: only_me_sharer_nux_state */
public interface RequestListener extends ProducerListener {
    void mo2103a(ImageRequest imageRequest, Object obj, String str, boolean z);

    void mo2104a(ImageRequest imageRequest, String str, Throwable th, boolean z);

    void mo2105a(ImageRequest imageRequest, String str, boolean z);

    void mo2111b(String str);
}
