package com.facebook.imagepipeline.request;

import com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer;

/* compiled from: TOPIC_JUNIOR_HIGH_SCHOOL */
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements Postprocessor {
    private RepeatedPostprocessorConsumer f13856a;

    public final synchronized void m23229a(RepeatedPostprocessorConsumer repeatedPostprocessorConsumer) {
        this.f13856a = repeatedPostprocessorConsumer;
    }

    private synchronized RepeatedPostprocessorConsumer m23228d() {
        return this.f13856a;
    }

    public final void m23230c() {
        RepeatedPostprocessorConsumer d = m23228d();
        if (d != null) {
            d.m23190a();
        }
    }
}
