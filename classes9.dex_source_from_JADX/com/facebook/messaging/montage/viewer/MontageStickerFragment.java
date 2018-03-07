package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.support.v7.graphics.Palette.Swatch;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.stickers.ui.StickerUrls;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_cta */
public class MontageStickerFragment extends AbstractMontageItemFragment {
    private static final CallerContext ap = CallerContext.a(MontageStickerFragment.class, "sticker_status_thread_view", "sticker_status_thread_view".toString());
    @Inject
    MessageClassifier al;
    @Inject
    StickerCache am;
    @Inject
    StickerUrls an;
    @Inject
    @ForUiThread
    Executor ao;
    private DraweeView aq;
    public boolean ar;
    @Inject
    FbDraweeControllerBuilder f12610h;
    @Inject
    FetchStickerCoordinator f12611i;

    /* compiled from: is_cta */
    class C14121 implements FutureCallback<Sticker> {
        final /* synthetic */ MontageStickerFragment f12607a;

        C14121(MontageStickerFragment montageStickerFragment) {
            this.f12607a = montageStickerFragment;
        }

        public void onSuccess(Object obj) {
            MontageStickerFragment.m13059a(this.f12607a, (Sticker) obj);
        }

        public void onFailure(Throwable th) {
            this.f12607a.m13026a(th);
        }
    }

    /* compiled from: is_cta */
    class C14132 extends BaseControllerListener {
        final /* synthetic */ MontageStickerFragment f12608a;

        C14132(MontageStickerFragment montageStickerFragment) {
            this.f12608a = montageStickerFragment;
        }

        public final void m13054a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                this.f12608a.ar = true;
                animatable.start();
            } else {
                this.f12608a.ar = false;
            }
            this.f12608a.aA();
            MontageStickerFragment.aC(this.f12608a);
        }

        public final void m13055b(String str, Throwable th) {
            this.f12608a.m13026a(th);
        }
    }

    /* compiled from: is_cta */
    class C14143 implements PaletteAsyncListener {
        final /* synthetic */ MontageStickerFragment f12609a;

        C14143(MontageStickerFragment montageStickerFragment) {
            this.f12609a = montageStickerFragment;
        }

        public final void mo467a(Palette palette) {
            Swatch swatch;
            MontageStickerFragment montageStickerFragment = this.f12609a;
            Swatch c = palette.m3463c();
            if (c == null) {
                c = palette.m3462b();
            }
            if (c == null) {
                c = palette.m3464d();
            }
            if (c == null) {
                swatch = c;
                int i = 0;
                for (Swatch swatch2 : palette.m3461a()) {
                    int i2;
                    if (swatch2.f3729e > i) {
                        c = swatch2;
                        i2 = swatch2.f3729e;
                    } else {
                        i2 = i;
                        c = swatch;
                    }
                    swatch = c;
                    i = i2;
                }
            } else {
                swatch = c;
            }
            if (swatch != null) {
                montageStickerFragment.T.setBackgroundDrawable(new ColorDrawable(swatch.f3728d));
            }
        }
    }

    public static void m13060a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MontageStickerFragment) obj).m13058a(FbDraweeControllerBuilder.b(fbInjector), FetchStickerCoordinator.a(fbInjector), MessageClassifier.a(fbInjector), StickerCache.a(fbInjector), StickerUrls.b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    private void m13058a(FbDraweeControllerBuilder fbDraweeControllerBuilder, FetchStickerCoordinator fetchStickerCoordinator, MessageClassifier messageClassifier, StickerCache stickerCache, StickerUrls stickerUrls, Executor executor) {
        this.f12610h = fbDraweeControllerBuilder;
        this.f12611i = fetchStickerCoordinator;
        this.al = messageClassifier;
        this.am = stickerCache;
        this.an = stickerUrls;
        this.ao = executor;
    }

    public final void mo496c(@Nullable Bundle bundle) {
        super.mo496c(bundle);
        Class cls = MontageStickerFragment.class;
        m13060a((Object) this, getContext());
    }

    protected final void mo492a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.aq = (DraweeView) FindViewUtil.b(layoutInflater.inflate(2130905340, viewGroup, true), 2131563979);
        this.aq = (DraweeView) e(2131563979);
    }

    public final void mo497d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1406395843);
        super.mo497d(bundle);
        Message message = this.f12577g.f12555b;
        if (this.al.a(message) != MessageClassification.STICKER) {
            IllegalStateException illegalStateException = new IllegalStateException("Created a StatusStickerFragment for a non-sticker message.");
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1198259894, a);
            throw illegalStateException;
        }
        HandlerDetour.a(this.f12572b, this.aB);
        HandlerDetour.a(this.f12572b, this.aC, 2134122628);
        DraweeView draweeView = this.aq;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(jW_());
        genericDraweeHierarchyBuilder.d = 500;
        draweeView.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.c).u());
        Sticker d = this.am.d(message.k);
        if (d == null) {
            Futures.a(this.f12611i.a(message.k), new C14121(this), this.ao);
        } else {
            m13059a(this, d);
        }
        LogUtils.f(1093554505, a);
    }

    public static void m13059a(MontageStickerFragment montageStickerFragment, Sticker sticker) {
        Object[] b;
        if (StickerUtil.a(sticker)) {
            b = montageStickerFragment.an.b(sticker);
        } else {
            ImageRequest[] a = StickerUrls.a(sticker);
        }
        montageStickerFragment.aq.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) montageStickerFragment.f12610h.a(ap).b(montageStickerFragment.aq.getController())).a(b)).a(new C14132(montageStickerFragment))).s());
    }

    @Nullable
    private Bitmap m13057a(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (drawable2 instanceof ForwardingDrawable) {
            drawable2 = drawable2.getCurrent();
        }
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        if (drawable2 instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable2;
            int a = arrayDrawable.a();
            for (int i = 0; i < a; i++) {
                Bitmap a2 = m13057a(arrayDrawable.a(i));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    public static void aC(MontageStickerFragment montageStickerFragment) {
        Bitmap a = montageStickerFragment.m13057a(montageStickerFragment.aq.getTopLevelDrawable());
        if (a != null) {
            Palette.m3459a(a).m3451a(new C14143(montageStickerFragment));
        } else {
            montageStickerFragment.T.setBackgroundDrawable(new ColorDrawable(-1));
        }
    }

    protected final void aq() {
        m13023a(3000);
    }

    protected final void ar() {
    }
}
