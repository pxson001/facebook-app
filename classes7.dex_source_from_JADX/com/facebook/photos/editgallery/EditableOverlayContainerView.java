package com.facebook.photos.editgallery;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem.OverlayItemType;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.DoodleParams;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.StickerParams.Builder;
import com.facebook.photos.creativeediting.model.TextParams;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.photos.creativeediting.renderers.MovableItemContainerProvider;
import com.facebook.photos.creativeediting.ui.MovableContainerView;
import com.facebook.photos.creativeediting.ui.MovableItemAnimationController;
import com.facebook.photos.creativeediting.ui.MovableItemAnimationControllerProvider;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayDrawUtilities;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.stickers.model.Sticker;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: left_color */
public class EditableOverlayContainerView extends MovableContainerView {
    @Inject
    volatile Provider<FbErrorReporter> f10357f = UltralightRuntime.a;
    @Inject
    MovableItemAnimationControllerProvider f10358g;
    @Inject
    MovableItemContainerProvider f10359h;
    @Inject
    PhotoOverlayDrawUtilities f10360i;
    @Inject
    SpringSystem f10361j;
    private final SpringListener f10362k = new C08761(this);
    private final C08772 f10363l = new C08772(this);
    public MovableItemContainer f10364m;
    @Nullable
    public CallBack f10365n;
    private MovableItemAnimationController f10366o;
    private Spring f10367p;

    /* compiled from: left_color */
    class C08761 extends SimpleSpringListener {
        final /* synthetic */ EditableOverlayContainerView f10355a;

        C08761(EditableOverlayContainerView editableOverlayContainerView) {
            this.f10355a = editableOverlayContainerView;
        }

        public final void m12204a(Spring spring) {
            this.f10355a.f10364m.f9596o = (float) spring.d();
            this.f10355a.invalidate();
        }
    }

    /* compiled from: left_color */
    public class C08772 {
        final /* synthetic */ EditableOverlayContainerView f10356a;

        C08772(EditableOverlayContainerView editableOverlayContainerView) {
            this.f10356a = editableOverlayContainerView;
        }

        public final void m12205a(String str) {
            if (this.f10356a.f10365n != null) {
                this.f10356a.f10365n.mo591b(str);
            }
        }

        public final void m12206b(String str) {
            if (this.f10356a.f10365n != null) {
                this.f10356a.f10365n.mo589a(str);
            }
        }

        public final void m12207c(String str) {
            if (this.f10356a.f10365n != null) {
                this.f10356a.f10365n.mo592c(str);
            }
        }
    }

    /* compiled from: left_color */
    public interface CallBack {
        void mo587a();

        void mo588a(PhotoOverlayItem photoOverlayItem);

        void mo589a(String str);

        void mo590a(boolean z);

        void mo591b(String str);

        void mo592c(String str);
    }

    private static <T extends View> void m12216a(Class<T> cls, T t) {
        m12217a((Object) t, t.getContext());
    }

    private static void m12217a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EditableOverlayContainerView) obj).m12218a(IdBasedSingletonScopeProvider.a(fbInjector, 494), (MovableItemAnimationControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MovableItemAnimationControllerProvider.class), (MovableItemContainerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MovableItemContainerProvider.class), PhotoOverlayDrawUtilities.b(fbInjector), SpringSystem.b(fbInjector));
    }

    private void m12218a(Provider<FbErrorReporter> provider, MovableItemAnimationControllerProvider movableItemAnimationControllerProvider, MovableItemContainerProvider movableItemContainerProvider, PhotoOverlayDrawUtilities photoOverlayDrawUtilities, SpringSystem springSystem) {
        this.f10357f = provider;
        this.f10358g = movableItemAnimationControllerProvider;
        this.f10359h = movableItemContainerProvider;
        this.f10360i = photoOverlayDrawUtilities;
        this.f10361j = springSystem;
    }

    public EditableOverlayContainerView(Context context) {
        super(context);
        m12222o();
    }

    public EditableOverlayContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12222o();
    }

    public EditableOverlayContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12222o();
    }

    private void m12222o() {
        m12216a(EditableOverlayContainerView.class, (View) this);
        this.f10364m = this.f10359h.m11524a(this.f9655d);
        this.f10366o = this.f10358g.m11948a(this.f9653b, this.f10364m, this);
        this.f10364m.f9594m = this.f10363l;
        Spring a = this.f10361j.a().c(2.0d).a(SpringConfig.a(40.0d, 3.0d));
        a.c = false;
        this.f10367p = a.a(this.f10362k).l();
    }

    protected MovableItemAnimationController getAnimationController() {
        return this.f10366o;
    }

    protected MovableItemContainer getMovableItemContainer() {
        return this.f10364m;
    }

    protected final void mo501a() {
        if (this.f10365n != null) {
            this.f10365n.mo587a();
        }
    }

    protected final void mo503a(boolean z) {
        if (this.f10365n != null) {
            this.f10365n.mo590a(z);
        }
    }

    protected final void mo502a(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        if (this.f10365n != null) {
            this.f10365n.mo588a(photoOverlayItem);
        }
    }

    public void setCallBack(CallBack callBack) {
        this.f10365n = callBack;
    }

    public final void m12228a(Sticker sticker) {
        if (this.f9655d == null) {
            ((AbstractFbErrorReporter) this.f10357f.get()).b(EditableOverlayContainerView.class.getSimpleName(), "Null photo bounds when trying to add sticker");
            return;
        }
        Uri uri;
        if (sticker.d != null) {
            uri = sticker.d;
        } else {
            uri = sticker.c;
        }
        Rect a = this.f10360i.a(this.f9655d);
        float width = ((float) (a.left - this.f9655d.left)) / ((float) this.f9655d.width());
        float height = ((float) (a.top - this.f9655d.top)) / ((float) this.f9655d.height());
        float width2 = ((float) a.width()) / ((float) this.f9655d.width());
        float height2 = ((float) a.height()) / ((float) this.f9655d.height());
        Builder builder = new Builder(uri, sticker.a);
        builder.e = width;
        Builder builder2 = builder;
        builder2.f = height;
        builder2 = builder2;
        builder2.g = width2;
        builder2 = builder2;
        builder2.h = height2;
        PhotoOverlayItem a2 = builder2.a();
        this.f10364m.m11509a((UriAwarePhotoOverlayItem) a2, (Callback) this);
        this.f10364m.m11514b(a2);
        this.f10367p.a(0.0d);
        this.f10367p.b(1.0d);
        m11592i();
        invalidate();
    }

    private void m12215a(Uri uri, String str, int i, int i2, int i3, float f, float f2, float f3, @Nullable String str2) {
        Preconditions.checkNotNull(this.f9655d);
        Preconditions.checkNotNull(uri);
        Rect a = PhotoOverlayDrawUtilities.a(this.f9655d, i, i2);
        float width = ((float) a.width()) / ((float) this.f9655d.width());
        float height = ((float) a.height()) / ((float) this.f9655d.height());
        TextParams.Builder builder = new TextParams.Builder(str, uri);
        builder.c = f;
        builder = builder;
        builder.d = f2;
        builder = builder;
        builder.e = width;
        TextParams.Builder builder2 = builder;
        builder2.f = height;
        TextParams.Builder builder3 = builder2;
        builder3.h = i3;
        builder3 = builder3;
        builder3.g = f3;
        builder3 = builder3;
        builder3.i = str2;
        PhotoOverlayItem a2 = builder3.a();
        this.f10364m.m11509a((UriAwarePhotoOverlayItem) a2, (Callback) this);
        this.f10364m.m11514b(a2);
        this.f10367p.a(0.0d);
        this.f10367p.b(1.0d);
        m11592i();
    }

    public final void m12225a(Uri uri, String str, int i, int i2, int i3, TextParams textParams) {
        Preconditions.checkNotNull(this.f9655d);
        Preconditions.checkNotNull(uri);
        Rect a = PhotoOverlayDrawUtilities.a(this.f9655d, i, i2);
        float width = ((float) a.width()) / ((float) this.f9655d.width());
        float height = ((float) a.height()) / ((float) this.f9655d.height());
        float n = textParams.n() + ((textParams.e() - width) * 0.5f);
        float o = textParams.o() + ((textParams.f() - height) * 0.5f);
        TextParams.Builder builder = new TextParams.Builder(str, uri);
        builder.c = n;
        TextParams.Builder builder2 = builder;
        builder2.d = o;
        builder2 = builder2;
        builder2.e = width;
        TextParams.Builder builder3 = builder2;
        builder3.f = height;
        TextParams.Builder builder4 = builder3;
        builder4.h = i3;
        builder4 = builder4;
        builder4.g = textParams.c();
        builder4 = builder4;
        builder4.i = textParams.g();
        PhotoOverlayItem a2 = builder4.a();
        this.f10364m.m11509a((UriAwarePhotoOverlayItem) a2, (Callback) this);
        this.f10364m.m11514b(a2);
        this.f10367p.a(0.0d);
        this.f10367p.b(1.0d);
        m11592i();
    }

    public final void m12226a(Uri uri, String str, int i, int i2, int i3, @Nullable String str2) {
        Preconditions.checkNotNull(this.f9655d);
        Preconditions.checkNotNull(uri);
        Rect a = PhotoOverlayDrawUtilities.a(this.f9655d, i, i2);
        m12215a(uri, str, i, i2, i3, ((float) (a.left - this.f9655d.left)) / ((float) this.f9655d.width()), ((float) (a.top - this.f9655d.top)) / ((float) this.f9655d.height()), 0.0f, str2);
    }

    public final DoodleParams m12223a(Uri uri, int i, int i2, float f, @Nullable String str) {
        Preconditions.checkNotNull(this.f9655d);
        Preconditions.checkNotNull(uri);
        Rect a = PhotoOverlayDrawUtilities.a(this.f9655d, i, i2);
        float width = ((float) a.width()) / ((float) this.f9655d.width());
        float height = ((float) a.height()) / ((float) this.f9655d.height());
        float width2 = ((float) (a.left - this.f9655d.left)) / ((float) this.f9655d.width());
        float height2 = ((float) (a.top - this.f9655d.top)) / ((float) this.f9655d.height());
        DoodleParams.Builder builder = new DoodleParams.Builder(uri);
        builder.b = width2;
        DoodleParams.Builder builder2 = builder;
        builder2.c = height2;
        DoodleParams.Builder builder3 = builder2;
        builder3.d = width;
        builder3 = builder3;
        builder3.e = height;
        builder3 = builder3;
        builder3.f = f;
        builder3 = builder3;
        builder3.g = str;
        UriAwarePhotoOverlayItem a2 = builder3.a();
        this.f10364m.m11509a(a2, (Callback) this);
        return a2;
    }

    public void setActionButtonEnabled(boolean z) {
        this.f9653b.setEnabled(z);
    }

    @Nullable
    public final PhotoOverlayItem mo583k() {
        PhotoOverlayItem photoOverlayItem = this.f10364m.f9592k;
        if (photoOverlayItem != null) {
            this.f10364m.m11521g();
            this.f10364m.m11507a(photoOverlayItem);
        }
        return photoOverlayItem;
    }

    @Nullable
    public PhotoOverlayItem getSelectedItem() {
        return this.f10364m.f9592k;
    }

    public final void mo584l() {
        ImmutableList i = this.f10364m.m11522i();
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = i.get(i2);
            if (obj instanceof DoodleParams) {
                this.f10364m.m11507a((DoodleParams) obj);
                return;
            }
        }
    }

    public final void mo585m() {
        ImmutableList i = this.f10364m.m11522i();
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = i.get(i2);
            if (obj instanceof DoodleParams) {
                this.f10364m.m11507a((DoodleParams) obj);
            }
        }
    }

    public final boolean m12234n() {
        List<Object> b = this.f9652a.b(this.f10364m.m11522i());
        if (b == null) {
            return false;
        }
        for (Object obj : b) {
            if (obj instanceof DoodleParams) {
                return true;
            }
        }
        return false;
    }

    public ImmutableList<UriAwarePhotoOverlayItem> getOverlayParamsForOriginalPhoto() {
        List<UriAwarePhotoOverlayItem> c = m12221c(false);
        if (c == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (UriAwarePhotoOverlayItem c2 : c) {
            builder.c(c2);
        }
        return builder.b();
    }

    public ImmutableList<StickerParams> getFramesParamsForOriginalPhoto() {
        List c = m12221c(true);
        if (c == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (Object next : c) {
            if (next instanceof StickerParams) {
                builder.c((StickerParams) next);
            }
        }
        return builder.b();
    }

    private List<? extends PhotoOverlayItem> m12221c(boolean z) {
        ImmutableList i = this.f10364m.m11522i();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((UriAwarePhotoOverlayItem) i.get(i2)).j() == z) {
                builder.b(new UriAwarePhotoOverlayItem[]{(UriAwarePhotoOverlayItem) i.get(i2)});
            }
        }
        return this.f9652a.b(builder.b());
    }

    public final void m12229a(List<? extends PhotoOverlayItem> list) {
        if (list != null) {
            Preconditions.checkNotNull(this.f9655d);
            for (int i = 0; i < list.size(); i++) {
                this.f10364m.m11509a((UriAwarePhotoOverlayItem) this.f9652a.b((PhotoOverlayItem) list.get(i)), (Callback) this);
            }
            m11592i();
            invalidate();
        }
    }

    @Nullable
    public static OverlayItemType m12220c(PhotoOverlayItem photoOverlayItem) {
        if (photoOverlayItem == null) {
            return null;
        }
        if (photoOverlayItem instanceof TextParams) {
            return OverlayItemType.TEXT;
        }
        if (photoOverlayItem instanceof StickerParams) {
            return OverlayItemType.STICKER;
        }
        if (photoOverlayItem instanceof DoodleParams) {
            return OverlayItemType.DOODLE;
        }
        return null;
    }
}
