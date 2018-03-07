package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;

/* compiled from: TOPIC_JUST_FOR_FUN */
class WebpTranscodeProducer$1 extends StatefulProducerRunnable<EncodedImage> {
    final /* synthetic */ EncodedImage f13850b;
    final /* synthetic */ WebpTranscodeProducer f13851c;

    WebpTranscodeProducer$1(WebpTranscodeProducer webpTranscodeProducer, BaseConsumer baseConsumer, ProducerListener producerListener, String str, String str2, EncodedImage encodedImage) {
        this.f13851c = webpTranscodeProducer;
        this.f13850b = encodedImage;
        super(baseConsumer, producerListener, str, str2);
    }

    protected final void m23223a(Object obj) {
        EncodedImage encodedImage = (EncodedImage) obj;
        EncodedImage.d(this.f13850b);
        super.a(encodedImage);
    }

    protected final void m23225b(Object obj) {
        EncodedImage.d((EncodedImage) obj);
    }

    protected final Object m23226c() {
        PooledByteBufferOutputStream a = this.f13851c.b.a();
        try {
            WebpTranscodeProducer.b(this.f13850b, a);
            CloseableReference a2 = CloseableReference.a(a.a());
            try {
                Object encodedImage = new EncodedImage(a2);
                encodedImage.b(this.f13850b);
                return encodedImage;
            } finally {
                CloseableReference.c(a2);
            }
        } finally {
            a.close();
        }
    }

    protected final void m23222a(Exception exception) {
        EncodedImage.d(this.f13850b);
        super.a(exception);
    }

    protected final void m23224b() {
        EncodedImage.d(this.f13850b);
        super.b();
    }
}
