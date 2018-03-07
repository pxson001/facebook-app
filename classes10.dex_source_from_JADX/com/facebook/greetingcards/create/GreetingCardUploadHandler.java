package com.facebook.greetingcards.create;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.protocol.PublishPostMethod;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.CardPhoto.Type;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {events_creation_prefill_extras} */
public class GreetingCardUploadHandler implements BlueServiceHandler {
    private final Provider<SingleMethodRunner> f108a;
    private final PublishPostMethod f109b;
    private final DirectPhotoUploader f110c;
    private final DefaultPhotoFlowLogger f111d;
    private final ImmediateRetryPolicy f112e;

    public final OperationResult m125a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("upload_card".equals(str)) {
            return m124b(operationParams);
        }
        throw new IllegalArgumentException("unknown operation type: " + str);
    }

    @Inject
    public GreetingCardUploadHandler(Provider<SingleMethodRunner> provider, PublishPostMethod publishPostMethod, DirectPhotoUploader directPhotoUploader, PhotoFlowLogger photoFlowLogger, ImmediateRetryPolicy immediateRetryPolicy) {
        this.f108a = provider;
        this.f109b = publishPostMethod;
        this.f110c = directPhotoUploader;
        this.f111d = photoFlowLogger;
        this.f112e = immediateRetryPolicy;
    }

    private OperationResult m124b(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        GreetingCard greetingCard = (GreetingCard) bundle.getParcelable("greeting_card");
        PublishPostParams publishPostParams = (PublishPostParams) bundle.getParcelable("post_params");
        List a = Lists.a();
        Builder b = new Builder().b(greetingCard.a.c).b(greetingCard.c.c);
        int size = greetingCard.b.size();
        for (int i = 0; i < size; i++) {
            b.b(((Slide) greetingCard.b.get(i)).c);
        }
        ImmutableList b2 = b.b();
        int size2 = b2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            CardPhoto cardPhoto = (CardPhoto) b2.get(i2);
            if (cardPhoto.b == Type.LOCAL) {
                a.add(cardPhoto.d);
            }
        }
        if (!a.isEmpty()) {
            greetingCard = GreetingCard.a(greetingCard, m122a(a, publishPostParams));
        }
        m123a(greetingCard, publishPostParams);
        return OperationResult.a;
    }

    private Map<Uri, String> m122a(List<MediaItem> list, PublishPostParams publishPostParams) {
        Collection a = Sets.a();
        for (MediaItem mediaItem : list) {
            UploadPhotoParams.Builder builder = new UploadPhotoParams.Builder(new UploadPhotoSource(mediaItem.e(), mediaItem.e));
            builder.j = new PhotoUploadPrivacy(publishPostParams.privacy);
            a.add(builder.a());
        }
        this.f111d.a(publishPostParams.composerSessionId);
        final Map c = Maps.c();
        this.f110c.a(a, new DirectUploadListener(this) {
            final /* synthetic */ GreetingCardUploadHandler f107b;

            public final void m121a(UploadPhotoParams uploadPhotoParams, UploadRecord uploadRecord) {
                c.put(Uri.parse("file://" + uploadPhotoParams.d()), String.valueOf(uploadRecord.fbid));
            }
        }, new MediaUploadCancelHandler(), this.f111d, this.f111d.j("2.0"), null, this.f112e);
        return c;
    }

    private void m123a(GreetingCard greetingCard, PublishPostParams publishPostParams) {
        PublishPostParams.Builder builder = new PublishPostParams.Builder(publishPostParams);
        builder.V = greetingCard;
        ((AbstractSingleMethodRunner) this.f108a.get()).a(this.f109b, builder.a(), CallerContext.a(getClass()));
    }
}
