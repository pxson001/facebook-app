package com.facebook.messaging.media.mediatray;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.messaging.media.service.LocalMediaLoadResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: security_checkup_source */
public class LocalMediaTrayLoader extends AbstractListenableFutureFbLoader<MediaTrayLoader$Params, MediaTrayLoader$Result> implements MediaTrayLoader {
    private static final CallerContext f3030a = CallerContext.a(LocalMediaTrayLoader.class);
    private final DefaultBlueServiceOperationFactory f3031b;
    private final Provider<Boolean> f3032c;

    protected final ListenableFuture m2994a(Object obj, LoaderResult loaderResult) {
        final MediaTrayLoader$Params mediaTrayLoader$Params = (MediaTrayLoader$Params) obj;
        Bundle bundle = new Bundle();
        bundle.putBoolean("loadVideos", ((Boolean) this.f3032c.get()).booleanValue());
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f3031b, "load_local_media", bundle, ErrorPropagation.BY_EXCEPTION, f3030a, -1233179950).a(), new Function<OperationResult, MediaTrayLoader$Result>(this) {
            final /* synthetic */ LocalMediaTrayLoader f3029b;

            public Object apply(Object obj) {
                LocalMediaLoadResult localMediaLoadResult = (LocalMediaLoadResult) ((OperationResult) obj).h();
                Builder builder = ImmutableList.builder();
                ImmutableList immutableList = localMediaLoadResult.a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    MediaResource mediaResource = (MediaResource) immutableList.get(i);
                    if (mediaTrayLoader$Params.f3129a || mediaResource.d != Type.VIDEO) {
                        MediaResourceBuilder a = MediaResource.a().a(mediaResource);
                        a.c = Source.MEDIA_PICKER;
                        builder.c(new MediaTrayLoader$Item(mediaResource, a.C()));
                    }
                }
                return new MediaTrayLoader$Result(builder.b());
            }
        });
    }

    @Inject
    public LocalMediaTrayLoader(BlueServiceOperationFactory blueServiceOperationFactory, Provider<Boolean> provider, Executor executor) {
        super(executor);
        this.f3031b = blueServiceOperationFactory;
        this.f3032c = provider;
    }

    protected final LoaderResult m2995b(Object obj) {
        return AbstractListenableFutureFbLoader.a;
    }
}
