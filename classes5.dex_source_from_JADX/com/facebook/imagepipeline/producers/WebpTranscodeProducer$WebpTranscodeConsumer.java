package com.facebook.imagepipeline.producers;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import com.facebook.imagepipeline.nativecode.WebpTranscoderImpl;
import javax.annotation.Nullable;

/* compiled from: TOPIC_JUST_FOR_FUN */
class WebpTranscodeProducer$WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
    final /* synthetic */ WebpTranscodeProducer f13853a;
    private final BaseProducerContext f13854b;
    private TriState f13855c = TriState.UNSET;

    protected final void m23227a(@Nullable Object obj, boolean z) {
        EncodedImage encodedImage = (EncodedImage) obj;
        if (this.f13855c == TriState.UNSET && encodedImage != null) {
            TriState valueOf;
            Preconditions.a(encodedImage);
            ImageFormat b = ImageFormatChecker.b(encodedImage.b());
            switch (WebpTranscodeProducer$2.f13852a[b.ordinal()]) {
                case 1:
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                case 3:
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    WebpTranscoderImpl webpTranscoderImpl = WebpTranscoderFactory.f13744b;
                    if (webpTranscoderImpl != null) {
                        valueOf = TriState.valueOf(!webpTranscoderImpl.a(b));
                        break;
                    } else {
                        valueOf = TriState.NO;
                        break;
                    }
                case 5:
                    valueOf = TriState.UNSET;
                    break;
                default:
                    valueOf = TriState.NO;
                    break;
            }
            this.f13855c = valueOf;
        }
        if (this.f13855c == TriState.NO) {
            this.a.b(encodedImage, z);
        } else if (!z) {
        } else {
            if (this.f13855c != TriState.YES || encodedImage == null) {
                this.a.b(encodedImage, z);
            } else {
                WebpTranscodeProducer.a(this.f13853a, encodedImage, this.a, this.f13854b);
            }
        }
    }

    public WebpTranscodeProducer$WebpTranscodeConsumer(WebpTranscodeProducer webpTranscodeProducer, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.f13853a = webpTranscodeProducer;
        super(consumer);
        this.f13854b = producerContext;
    }
}
