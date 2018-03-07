package com.facebook.stickers.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerUtil;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: duration_video_call */
public class StickerDraweeView extends FbDraweeView {
    public static final Class<?> f17036j = StickerDraweeView.class;
    private static final ScaleType f17037k = ScaleType.c;
    @Inject
    DefaultAndroidThreadUtil f17038c;
    @Inject
    FetchStickerCoordinator f17039d;
    @Inject
    StickerCache f17040e;
    @Inject
    @ForUiThread
    Executor f17041f;
    @Inject
    StickerUrls f17042g;
    @Inject
    FbDraweeControllerBuilder f17043h;
    @Inject
    GatekeeperStoreImpl f17044i;
    public String f17045l;
    private FutureAndCallbackHolder<ImageRequest[]> f17046m;

    private static <T extends View> void m24744a(Class<T> cls, T t) {
        m24745a((Object) t, t.getContext());
    }

    private static void m24745a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerDraweeView) obj).m24742a(DefaultAndroidThreadUtil.b(injectorLike), FetchStickerCoordinator.m23913a(injectorLike), StickerCache.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), StickerUrls.m24769b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private void setPlaceHolderId(String str) {
        int i;
        if ("227878347358915".equals(str)) {
            i = 2130843472;
        } else if ("369239263222822".equals(str)) {
            i = 2130843473;
        } else if ("369239343222814".equals(str)) {
            i = 2130843472;
        } else if ("369239383222810".equals(str)) {
            i = 2130843471;
        } else {
            i = 2130842328;
        }
        ((GenericDraweeHierarchy) getHierarchy()).a(getResources().getDrawable(i), f17037k);
    }

    private void m24742a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, FetchStickerCoordinator fetchStickerCoordinator, StickerCache stickerCache, Executor executor, StickerUrls stickerUrls, FbDraweeControllerBuilder fbDraweeControllerBuilder, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f17038c = defaultAndroidThreadUtil;
        this.f17039d = fetchStickerCoordinator;
        this.f17040e = stickerCache;
        this.f17041f = executor;
        this.f17042g = stickerUrls;
        this.f17043h = fbDraweeControllerBuilder;
        this.f17044i = gatekeeperStoreImpl;
    }

    public StickerDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        m24752d();
    }

    public StickerDraweeView(Context context) {
        super(context);
        m24752d();
    }

    public StickerDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24752d();
    }

    private void m24752d() {
        m24744a(StickerDraweeView.class, (View) this);
    }

    public final void m24753a(final String str, int i, final CallerContext callerContext, @Nullable final ControllerListener controllerListener) {
        this.f17038c.a();
        this.f17045l = str;
        setPlaceHolderId(str);
        m24746a(str);
        if (this.f17046m != null) {
            this.f17046m.a(false);
        }
        ListenableFuture a = m24740a(str, i);
        AbstractDisposableFutureCallback a2 = AbstractDisposableFutureCallback.a(new FutureCallback<ImageRequest[]>(this) {
            final /* synthetic */ StickerDraweeView f17033d;

            public void onSuccess(@Nullable Object obj) {
                ImageRequest[] imageRequestArr = (ImageRequest[]) obj;
                if (str.equals(this.f17033d.f17045l)) {
                    this.f17033d.m24747a(imageRequestArr, str, callerContext, controllerListener);
                }
            }

            public void onFailure(Throwable th) {
                BLog.b(StickerDraweeView.f17036j, th, "Error loading sticker %s", new Object[]{str});
            }
        });
        Futures.a(a, a2, this.f17041f);
        this.f17046m = FutureAndCallbackHolder.a(a, a2);
    }

    public void setDrawableResourceId(int i) {
        this.f17038c.a();
        this.f17045l = null;
        setImageURI(null);
        ((GenericDraweeHierarchy) getHierarchy()).a(getResources().getDrawable(i).mutate(), f17037k);
    }

    private void m24746a(String str) {
        if (getVisibility() == 0) {
            int i;
            if ("227878347358915".equals(str)) {
                i = 2131428034;
            } else if ("369239263222822".equals(str)) {
                i = 2131428037;
            } else if ("369239343222814".equals(str)) {
                i = 2131428038;
            } else if ("369239383222810".equals(str)) {
                i = 2131428039;
            } else {
                i = 2131428035;
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(i);
            LayoutParamsUtil.a(this, dimensionPixelSize, dimensionPixelSize);
        }
    }

    private ListenableFuture<ImageRequest[]> m24740a(String str, int i) {
        Sticker d = this.f17040e.d(str);
        if (d != null) {
            return Futures.a(m24748a(d, i));
        }
        return m24750b(str, i);
    }

    private ImageRequest[] m24748a(Sticker sticker, int i) {
        Preconditions.checkNotNull(sticker);
        StickerUrls stickerUrls = this.f17042g;
        List arrayList = new ArrayList();
        if (StickerUtil.m7770a(sticker) && ((Boolean) stickerUrls.f17078a.get()).booleanValue()) {
            arrayList.addAll(StickerUrls.m24767a(sticker, false, i));
        } else {
            if (sticker.f4941d != null) {
                arrayList.add(ImageRequest.a(sticker.f4941d));
            }
            arrayList.add(ImageRequest.a(sticker.f4940c));
        }
        return (ImageRequest[]) arrayList.toArray(new ImageRequest[arrayList.size()]);
    }

    private ListenableFuture<ImageRequest[]> m24750b(String str, final int i) {
        return Futures.a(this.f17039d.m23918a(str), new Function<Sticker, ImageRequest[]>(this) {
            final /* synthetic */ StickerDraweeView f17035b;

            public Object apply(@Nullable Object obj) {
                Sticker sticker = (Sticker) obj;
                if (sticker == null) {
                    return null;
                }
                return this.f17035b.m24748a(sticker, i);
            }
        }, this.f17041f);
    }

    private void m24747a(@Nullable ImageRequest[] imageRequestArr, String str, CallerContext callerContext, ControllerListener controllerListener) {
        if (imageRequestArr != null) {
            setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f17043h.a(imageRequestArr)).d(m24739a(imageRequestArr, str))).b(getController())).a(callerContext).a(controllerListener)).s());
        }
    }

    private ImageRequest m24739a(@Nullable ImageRequest[] imageRequestArr, String str) {
        if (!this.f17044i.a(328, false)) {
            return null;
        }
        Sticker d = this.f17040e.d(str);
        if (d == null) {
            return null;
        }
        ImageRequest a;
        if (d.f4941d == null && d.f4943f == null && d.f4945h != null) {
            a = ImageRequest.a(d.f4945h);
        } else {
            a = null;
        }
        ImageRequest imageRequest = a;
        return (imageRequest == null || imageRequestArr == null) ? imageRequest : ImageRequestBuilder.a(imageRequestArr[0]).b(imageRequest.c).m();
    }
}
