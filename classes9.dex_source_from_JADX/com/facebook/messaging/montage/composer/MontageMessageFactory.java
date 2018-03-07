package com.facebook.messaging.montage.composer;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.quickcam.MediaOperations;
import com.facebook.messaging.quickcam.MediaOperations.SaveVideo;
import com.facebook.messaging.quickcam.PhotoParams.Builder;
import com.facebook.messaging.send.client.OfflineThreadingIdGenerator;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: is_network_metered */
public class MontageMessageFactory {
    private final ListeningExecutorService f12548a;
    private final MediaOperations f12549b;
    private final OfflineThreadingIdGenerator f12550c;
    private final OutgoingMessageFactory f12551d;

    /* compiled from: is_network_metered */
    class C13981 implements AsyncFunction<MediaResource, Message> {
        final /* synthetic */ MontageMessageFactory f12547a;

        C13981(MontageMessageFactory montageMessageFactory) {
            this.f12547a = montageMessageFactory;
        }

        public final ListenableFuture m13010a(Object obj) {
            return this.f12547a.m13015a((MediaResource) obj);
        }
    }

    public static MontageMessageFactory m13012b(InjectorLike injectorLike) {
        return new MontageMessageFactory(MediaOperations.m16472b(injectorLike), OfflineThreadingIdGenerator.m16673a(injectorLike), OutgoingMessageFactory.m16678a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MontageMessageFactory(MediaOperations mediaOperations, OfflineThreadingIdGenerator offlineThreadingIdGenerator, OutgoingMessageFactory outgoingMessageFactory, ListeningExecutorService listeningExecutorService) {
        this.f12549b = mediaOperations;
        this.f12550c = offlineThreadingIdGenerator;
        this.f12551d = outgoingMessageFactory;
        this.f12548a = listeningExecutorService;
    }

    public final ListenableFuture<Message> m13014a(Uri uri) {
        return m13011a(Futures.a(Futures.a(uri), new SaveVideo(this.f12549b, Source.MEDIA_PICKER), this.f12548a));
    }

    public final ListenableFuture<Message> m13013a(Bitmap bitmap) {
        return m13011a(Futures.a(Futures.a(bitmap), this.f12549b.m16475b(new Builder().m16481a(Source.UNSPECIFIED).m16482a()), this.f12548a));
    }

    private ListenableFuture<Message> m13011a(ListenableFuture<MediaResource> listenableFuture) {
        return Futures.b(listenableFuture, new C13981(this));
    }

    public final ListenableFuture<Message> m13015a(MediaResource mediaResource) {
        String l = Long.toString(this.f12550c.m16675a());
        ThreadKey a = ThreadKey.a();
        MediaResourceBuilder a2 = MediaResource.a().a(mediaResource);
        a2.k = l;
        a2 = a2;
        a2.l = a;
        return Futures.a(this.f12551d.m16686a(a, a2.C(), l));
    }
}
