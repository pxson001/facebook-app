package com.facebook.messaging.montage;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentUris;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.ui.StickerUrls;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: iso-8859-2 */
public class MontageThumbnailController {
    private final CallerContext f12403a = CallerContext.a(MontageThumbnailController.class, "messenger_montage_inbox_composer");
    public final FbDraweeView f12404b;
    private final AttachmentDataFactory f12405c;
    private final Provider<FbDraweeControllerBuilder> f12406d;
    public final FetchStickerCoordinator f12407e;
    private final MessageClassifier f12408f;
    public final MontageMessagesHelper f12409g;
    private final Resources f12410h;
    public final StickerCache f12411i;
    private final StickerUrls f12412j;
    public final Provider<UserKey> f12413k;
    public final Executor f12414l;
    public Listener f12415m;
    public int f12416n;
    public boolean f12417o;
    public boolean f12418p;

    /* compiled from: iso-8859-2 */
    public class C13691 implements FutureCallback<Sticker> {
        final /* synthetic */ MontageThumbnailController f12400a;

        public C13691(MontageThumbnailController montageThumbnailController) {
            this.f12400a = montageThumbnailController;
        }

        public void onSuccess(Object obj) {
            MontageThumbnailController.m12889a(this.f12400a, (Sticker) obj);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: iso-8859-2 */
    class C13702 extends BaseControllerListener {
        final /* synthetic */ MontageThumbnailController f12401a;

        C13702(MontageThumbnailController montageThumbnailController) {
            this.f12401a = montageThumbnailController;
        }

        public final void m12881a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (this.f12401a.f12415m != null) {
                this.f12401a.f12415m.mo471d();
            }
        }
    }

    /* compiled from: iso-8859-2 */
    public interface Listener {
        void mo468a();

        void mo469b();

        void mo470c();

        void mo471d();

        void mo472e();

        void mo473f();
    }

    @Inject
    public MontageThumbnailController(@Assisted FbDraweeView fbDraweeView, AttachmentDataFactory attachmentDataFactory, Provider<FbDraweeControllerBuilder> provider, FetchStickerCoordinator fetchStickerCoordinator, MessageClassifier messageClassifier, MontageMessagesHelper montageMessagesHelper, Resources resources, StickerCache stickerCache, StickerUrls stickerUrls, Provider<UserKey> provider2, Executor executor) {
        this.f12404b = fbDraweeView;
        this.f12405c = attachmentDataFactory;
        this.f12406d = provider;
        this.f12407e = fetchStickerCoordinator;
        this.f12408f = messageClassifier;
        this.f12409g = montageMessagesHelper;
        this.f12410h = resources;
        this.f12411i = stickerCache;
        this.f12412j = stickerUrls;
        this.f12413k = provider2;
        this.f12414l = executor;
        m12892b();
    }

    private void m12892b() {
        GenericDraweeHierarchy u = this.f12404b.a() ? (GenericDraweeHierarchy) this.f12404b.getHierarchy() : new GenericDraweeHierarchyBuilder(this.f12410h).u();
        if (u.e.b == 0) {
            u.a(500);
        }
        if (u.c == null) {
            u.a(RoundingParams.e());
        }
        if (!u.e()) {
            u.b(new ColorDrawable(this.f12410h.getColor(2131362343)));
        }
        this.f12404b.setHierarchy(u);
    }

    public final void m12895a(Message message) {
        switch (this.f12408f.a(message)) {
            case PHOTOS:
                m12893b(message);
                return;
            case VIDEO_CLIP:
                m12894c(message);
                return;
            case STICKER:
                ((GenericDraweeHierarchy) this.f12404b.getHierarchy()).a(ScaleType.f);
                if (this.f12415m != null) {
                    this.f12415m.mo470c();
                }
                Sticker d = this.f12411i.d(message.k);
                if (d == null) {
                    Futures.a(this.f12407e.a(message.k), new C13691(this), this.f12414l);
                } else {
                    m12889a(this, d);
                }
                return;
            case NORMAL:
                if (this.f12415m != null) {
                    this.f12415m.mo472e();
                }
                this.f12404b.setVisibility(8);
                break;
        }
        if (this.f12415m != null) {
            this.f12415m.mo473f();
        }
        this.f12404b.setVisibility(8);
    }

    private void m12893b(Message message) {
        ((GenericDraweeHierarchy) this.f12404b.getHierarchy()).a(ScaleType.g);
        ImmutableList f = this.f12405c.f(message);
        Preconditions.checkArgument(!f.isEmpty());
        this.f12404b.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12406d.get()).a(this.f12403a).a(m12890a((ImageAttachmentData) f.get(0)))).s());
        if (this.f12415m != null) {
            this.f12415m.mo468a();
        }
        this.f12404b.setVisibility(0);
    }

    private void m12894c(Message message) {
        VideoAttachmentData j = this.f12405c.j(message);
        ((GenericDraweeHierarchy) this.f12404b.getHierarchy()).a(ScaleType.g);
        this.f12404b.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12406d.get()).a(this.f12403a).c(m12888a(j.f7770g).m())).s());
        if (this.f12415m != null) {
            this.f12415m.mo469b();
        }
        this.f12404b.setVisibility(0);
    }

    public static void m12889a(MontageThumbnailController montageThumbnailController, Sticker sticker) {
        montageThumbnailController.f12404b.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) montageThumbnailController.f12406d.get()).a(montageThumbnailController.f12403a).b(montageThumbnailController.f12404b.getController())).a(montageThumbnailController.m12891a(StickerUrls.a(sticker)))).a(new C13702(montageThumbnailController))).s());
        montageThumbnailController.f12404b.setVisibility(0);
    }

    private ImageRequest[] m12891a(ImageRequest[] imageRequestArr) {
        if (imageRequestArr == null || this.f12416n <= 0) {
            return imageRequestArr;
        }
        ImageRequest[] imageRequestArr2 = new ImageRequest[imageRequestArr.length];
        for (int i = 0; i < imageRequestArr.length; i++) {
            ImageRequestBuilder a = ImageRequestBuilder.a(imageRequestArr[i]);
            a.d = new ResizeOptions(this.f12416n, this.f12416n);
            imageRequestArr2[i] = a.m();
        }
        return imageRequestArr2;
    }

    private ImageRequest[] m12890a(ImageAttachmentData imageAttachmentData) {
        List arrayList = new ArrayList();
        MediaResource mediaResource = imageAttachmentData.f7731f;
        if (mediaResource != null) {
            arrayList.add(m12888a(mediaResource.c).m());
            if (mediaResource.h != null) {
                arrayList.add(m12888a(mediaResource.h.c).m());
            }
        }
        ImageAttachmentUris imageAttachmentUris = imageAttachmentData.f7727b;
        if (!(imageAttachmentUris == null || imageAttachmentUris.f7742a == null)) {
            arrayList.add(m12888a(imageAttachmentUris.f7742a).m());
        }
        imageAttachmentUris = imageAttachmentData.f7726a;
        if (imageAttachmentUris.f7746e != null) {
            String valueOf = String.valueOf(this.f12410h.getDimensionPixelSize(2131433684));
            Builder buildUpon = imageAttachmentUris.f7746e.buildUpon();
            buildUpon.appendQueryParameter("preview", "1");
            buildUpon.appendQueryParameter("max_height", valueOf);
            buildUpon.appendQueryParameter("max_width", valueOf);
            arrayList.add(m12888a(buildUpon.build()).m());
        } else {
            arrayList.add(m12888a(imageAttachmentUris.f7742a).m());
        }
        return (ImageRequest[]) arrayList.toArray(new ImageRequest[arrayList.size()]);
    }

    private ImageRequestBuilder m12888a(Uri uri) {
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.g = true;
        a.e = newBuilder.h();
        a = a;
        if (this.f12416n <= 0) {
            return a;
        }
        a.d = new ResizeOptions(this.f12416n, this.f12416n);
        return a;
    }
}
