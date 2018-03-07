package com.facebook.photos.mediagallery.ui.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.datasource.DataSubscriber;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: skip_actor */
public abstract class MediaGalleryActionsGenerator {

    /* compiled from: skip_actor */
    public class C03271 implements OnClickListener {
        final /* synthetic */ SettableFuture f2616a;
        final /* synthetic */ MediaGalleryActionsGenerator f2617b;

        public C03271(MediaGalleryActionsGenerator mediaGalleryActionsGenerator, SettableFuture settableFuture) {
            this.f2617b = mediaGalleryActionsGenerator;
            this.f2616a = settableFuture;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FutureDetour.a(this.f2616a, null, 2034438327);
        }
    }

    /* compiled from: skip_actor */
    public class C03282 implements OnClickListener {
        final /* synthetic */ SettableFuture f2618a;
        final /* synthetic */ MediaGalleryActionsGenerator f2619b;

        public C03282(MediaGalleryActionsGenerator mediaGalleryActionsGenerator, SettableFuture settableFuture) {
            this.f2619b = mediaGalleryActionsGenerator;
            this.f2618a = settableFuture;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2618a.cancel(false);
        }
    }

    /* compiled from: skip_actor */
    public class C03293 implements OnClickListener {
        final /* synthetic */ SettableFuture f2620a;
        final /* synthetic */ MediaGalleryActionsGenerator f2621b;

        public C03293(MediaGalleryActionsGenerator mediaGalleryActionsGenerator, SettableFuture settableFuture) {
            this.f2621b = mediaGalleryActionsGenerator;
            this.f2620a = settableFuture;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FutureDetour.a(this.f2620a, null, -1097665162);
        }
    }

    /* compiled from: skip_actor */
    public class C03304 implements OnCancelListener {
        final /* synthetic */ SettableFuture f2622a;
        final /* synthetic */ MediaGalleryActionsGenerator f2623b;

        public C03304(MediaGalleryActionsGenerator mediaGalleryActionsGenerator, SettableFuture settableFuture) {
            this.f2623b = mediaGalleryActionsGenerator;
            this.f2622a = settableFuture;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f2622a.cancel(true);
        }
    }

    /* compiled from: skip_actor */
    public class C03315 implements OnClickListener {
        final /* synthetic */ SettableFuture f2624a;
        final /* synthetic */ MediaGalleryActionsGenerator f2625b;

        public C03315(MediaGalleryActionsGenerator mediaGalleryActionsGenerator, SettableFuture settableFuture) {
            this.f2625b = mediaGalleryActionsGenerator;
            this.f2624a = settableFuture;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2624a.cancel(true);
        }
    }

    protected abstract FrescoMediaGalleryActionsGenerator mo130a();

    public abstract void mo131a(MediaMetadata mediaMetadata, AbstractDisposableFutureCallback abstractDisposableFutureCallback, DataSubscriber dataSubscriber);

    public abstract void mo132b(MediaMetadata mediaMetadata, AbstractDisposableFutureCallback abstractDisposableFutureCallback, DataSubscriber dataSubscriber);
}
