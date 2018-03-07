package com.facebook.messaging.photos.editing;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.Assisted;
import com.facebook.messaging.photos.editing.ArtRenderer.Rotation;
import com.facebook.messaging.photos.editing.StickerPicker.State;
import com.facebook.messaging.photos.editing.TextLayer.Event;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: mDeletedMessagePlaceholders */
public class PhotoEditingController {
    private final ArtRenderer f16080a;
    public final SpringSystem f16081b;
    public final LayerGroupLayout f16082c;
    public final PhotoEditingControlsLayout f16083d;
    public final TextStylesLayout f16084e;
    private final ViewGroup f16085f;
    public final ImageWithTextView f16086g;
    public Scene f16087h;
    public SceneLayersPresenter f16088i;
    public StickerPicker f16089j;
    public DoodleControlsLayout f16090k;
    @Nullable
    public Listener f16091l;
    public boolean f16092m;
    public boolean f16093n = false;
    public boolean f16094o = false;
    public float f16095p;
    public boolean f16096q = false;
    public String f16097r;
    public String f16098s;
    public boolean f16099t;
    public boolean f16100u;
    public boolean f16101v;
    @ColorInt
    public int f16102w = 0;
    public final PhotoEditingConfig f16103x;

    /* compiled from: mDeletedMessagePlaceholders */
    public interface Listener {
        void mo442a();

        void mo443b();
    }

    /* compiled from: mDeletedMessagePlaceholders */
    class C18891 implements com.facebook.messaging.photos.editing.PhotoEditingControlsLayout.Listener {
        final /* synthetic */ PhotoEditingController f16074a;

        C18891(PhotoEditingController photoEditingController) {
            this.f16074a = photoEditingController;
        }

        public final void mo664a() {
            this.f16074a.m16259j();
        }

        public final void mo665b() {
            this.f16074a.m16260k();
        }

        public final void mo666c() {
            this.f16074a.m16261l();
        }

        public final void mo667d() {
            this.f16074a.m16262n();
        }

        public final void mo668e() {
            DoodleControlsLayout doodleControlsLayout = this.f16074a.f16090k;
            DoodleControlsLayout.m16175j(doodleControlsLayout);
            doodleControlsLayout.f16025c.a();
        }
    }

    /* compiled from: mDeletedMessagePlaceholders */
    class C18902 implements com.facebook.messaging.photos.editing.TextStylesLayout.Listener {
        final /* synthetic */ PhotoEditingController f16075a;

        C18902(PhotoEditingController photoEditingController) {
            this.f16075a = photoEditingController;
        }

        public final void mo669a(int i, int i2) {
            TextLayer textLayer = (TextLayer) this.f16075a.f16087h.f16192c;
            textLayer.f16273b = i;
            textLayer.m16178a(Event.TEXT_COLOR_CHANGE);
            textLayer = (TextLayer) this.f16075a.f16087h.f16192c;
            textLayer.f16274c = i2;
            textLayer.m16178a(Event.BACKGROUND_COLOR_CHANGE);
        }
    }

    /* compiled from: mDeletedMessagePlaceholders */
    public class C18913 {
        final /* synthetic */ PhotoEditingController f16076a;

        public C18913(PhotoEditingController photoEditingController) {
            this.f16076a = photoEditingController;
        }

        public final void m16240a(boolean z) {
            this.f16076a.f16093n = z;
            PhotoEditingController.m16250y(this.f16076a);
        }

        public final void m16241b(boolean z) {
            this.f16076a.f16094o = z;
            PhotoEditingController.m16250y(this.f16076a);
            if (!z) {
                this.f16076a.f16091l.mo443b();
            }
        }
    }

    /* compiled from: mDeletedMessagePlaceholders */
    public class C18924 {
        final /* synthetic */ PhotoEditingController f16077a;

        public C18924(PhotoEditingController photoEditingController) {
            this.f16077a = photoEditingController;
        }

        public final boolean m16242a(int i, int i2) {
            if (this.f16077a.f16086g.getVisibility() != 0) {
                return false;
            }
            Rect rect = new Rect();
            rect.set(this.f16077a.f16086g.getLeft() - this.f16077a.f16086g.getPaddingLeft(), this.f16077a.f16086g.getTop() - this.f16077a.f16086g.getPaddingTop(), this.f16077a.f16086g.getRight() + this.f16077a.f16086g.getPaddingRight(), this.f16077a.f16086g.getBottom() + this.f16077a.f16086g.getPaddingBottom());
            return rect.contains(i, i2);
        }
    }

    /* compiled from: mDeletedMessagePlaceholders */
    public class C18935 {
        public final /* synthetic */ PhotoEditingController f16078a;

        C18935(PhotoEditingController photoEditingController) {
            this.f16078a = photoEditingController;
        }
    }

    /* compiled from: mDeletedMessagePlaceholders */
    public class C18946 {
        public final /* synthetic */ PhotoEditingController f16079a;

        public C18946(PhotoEditingController photoEditingController) {
            this.f16079a = photoEditingController;
        }

        public final void m16244a(boolean z) {
            this.f16079a.f16083d.setUndoodleButtonVisibility(z);
        }

        public final void m16243a(int i) {
            this.f16079a.f16083d.setAddDoodleLayerButtonBrushTipColour(i);
        }
    }

    @Inject
    public PhotoEditingController(@Assisted PhotoEditingConfig photoEditingConfig, @Assisted ViewGroup viewGroup, @Assisted LayerGroupLayout layerGroupLayout, @Assisted PhotoEditingControlsLayout photoEditingControlsLayout, @Assisted TextStylesLayout textStylesLayout, @Assisted ImageWithTextView imageWithTextView, ArtRenderer artRenderer, SpringSystem springSystem) {
        this.f16103x = photoEditingConfig;
        this.f16085f = viewGroup;
        this.f16082c = layerGroupLayout;
        this.f16083d = photoEditingControlsLayout;
        this.f16084e = textStylesLayout;
        this.f16086g = imageWithTextView;
        this.f16080a = artRenderer;
        this.f16081b = springSystem;
        this.f16083d.m16274a(this.f16103x);
        this.f16083d.f16116h = new C18891(this);
        this.f16084e.f16294c = new C18902(this);
        this.f16087h = new Scene();
        this.f16088i = new SceneLayersPresenter(this.f16087h, this.f16082c, this.f16081b);
        this.f16088i.f16212f = new C18913(this);
        this.f16088i.f16213g = new C18924(this);
        this.f16088i.m16317a();
    }

    public final void m16253a() {
        if (this.f16089j != null) {
            if (this.f16089j.f16255c == State.STICKERLIST) {
                this.f16089j.setStateAndVisibilities(State.PACKLIST);
            } else if (this.f16089j.f16255c == State.PACKLIST) {
                this.f16089j.setStateAndVisibilities(State.HIDDEN);
            }
        }
    }

    public final boolean m16254b() {
        return this.f16082c.getChildCount() > 0 || m16248w();
    }

    private boolean m16248w() {
        return this.f16090k != null && this.f16090k.m16176e();
    }

    public final boolean m16255c() {
        return (this.f16089j == null || this.f16089j.f16255c == State.HIDDEN) ? false : true;
    }

    private void m16249x() {
        m16247a(false);
    }

    public static void m16250y(PhotoEditingController photoEditingController) {
        photoEditingController.m16247a(true);
    }

    private void m16247a(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.f16094o && this.f16096q) {
            i = 1;
        } else {
            i = 0;
        }
        TextStylesLayout textStylesLayout = this.f16084e;
        if (i != 0) {
            i = 0;
        } else {
            i = 8;
        }
        textStylesLayout.setVisibility(i);
        if (!(this.f16096q && !this.f16092m && (m16263o() || this.f16103x.m16227b()))) {
            i2 = 0;
        }
        PhotoEditingControlsLayout photoEditingControlsLayout = this.f16083d;
        if (i2 != 0) {
            i = 0;
        } else {
            i = 8;
        }
        photoEditingControlsLayout.setVisibility(i);
        if (this.f16093n) {
            ImageWithTextView imageWithTextView = this.f16086g;
            if (!this.f16096q) {
                i3 = 8;
            }
            imageWithTextView.setVisibility(i3);
            this.f16083d.m16272a();
        } else {
            this.f16086g.setVisibility(8);
        }
        if (z && this.f16091l != null) {
            this.f16091l.mo442a();
        }
    }

    public final void m16256d() {
        this.f16082c.setVisibility(0);
    }

    public final void m16257h() {
        this.f16096q = true;
        m16249x();
    }

    public final void m16258i() {
        this.f16096q = false;
        m16249x();
    }

    public final void m16259j() {
        if (this.f16090k != null) {
            this.f16090k.m16177h();
        }
        this.f16087h.m16295a(new TextLayer());
    }

    public final void m16260k() {
        if (this.f16090k != null) {
            this.f16090k.m16177h();
        }
        this.f16088i.m16319b();
        ViewGroup viewGroup = this.f16085f;
        if (this.f16089j == null) {
            this.f16089j = new StickerPicker(viewGroup.getContext(), viewGroup.getWidth(), viewGroup.getHeight());
            this.f16089j.setStateAndVisibilities(State.HIDDEN);
            viewGroup.addView(this.f16089j);
        }
        StickerPicker stickerPicker = this.f16089j;
        float f = this.f16095p;
        Object obj = 1;
        stickerPicker.f16261i.setRotation(f);
        stickerPicker.f16262j.setRotation(f);
        Object obj2 = f % 180.0f != 0.0f ? 1 : null;
        if ((stickerPicker.f16264l - f) % 180.0f == 0.0f) {
            obj = null;
        }
        if (obj != null) {
            LayoutParams layoutParams;
            if (obj2 != null) {
                layoutParams = stickerPicker.f16261i.getLayoutParams();
                layoutParams.width = stickerPicker.f16268p;
                layoutParams.height = stickerPicker.f16267o;
                layoutParams = stickerPicker.f16262j.getLayoutParams();
                layoutParams.width = stickerPicker.f16268p;
                layoutParams.height = stickerPicker.f16267o;
                stickerPicker.requestLayout();
            } else {
                layoutParams = stickerPicker.f16261i.getLayoutParams();
                layoutParams.width = stickerPicker.f16266n;
                layoutParams.height = stickerPicker.f16265m;
                layoutParams = stickerPicker.f16262j.getLayoutParams();
                layoutParams.width = stickerPicker.f16266n;
                layoutParams.height = stickerPicker.f16265m;
                stickerPicker.requestLayout();
            }
            stickerPicker.f16257e.a(obj2 != null ? stickerPicker.f16270r : stickerPicker.f16269q);
            stickerPicker.f16256d.a(obj2 != null ? stickerPicker.f16270r : stickerPicker.f16269q);
        }
        stickerPicker.f16264l = f;
        this.f16089j.f16263k = new C18935(this);
        this.f16089j.setStateAndVisibilities(State.PACKLIST);
    }

    public final void m16261l() {
        this.f16088i.m16319b();
        ViewGroup viewGroup = this.f16085f;
        if (this.f16090k == null) {
            this.f16090k = new DoodleControlsLayout(viewGroup.getContext());
            this.f16090k.f16026d = new C18946(this);
            viewGroup.addView(this.f16090k, viewGroup.indexOfChild(this.f16083d));
        }
        DoodleControlsLayout doodleControlsLayout = this.f16090k;
        DoodleControlsLayout.m16175j(doodleControlsLayout);
        if (doodleControlsLayout.f16025c.isEnabled()) {
            doodleControlsLayout.m16177h();
            return;
        }
        DoodleControlsLayout.m16175j(doodleControlsLayout);
        doodleControlsLayout.f16025c.setEnabled(true);
        if (doodleControlsLayout.f16026d != null && doodleControlsLayout.m16176e()) {
            doodleControlsLayout.f16026d.m16244a(true);
        }
        doodleControlsLayout.f16024b.setVisibility(0);
        doodleControlsLayout.f16023a.setVisibility(0);
        doodleControlsLayout.f16026d.m16243a(doodleControlsLayout.f16024b.d);
    }

    public final void m16262n() {
        DoodleControlsLayout doodleControlsLayout = this.f16090k;
        DoodleControlsLayout.m16175j(doodleControlsLayout);
        doodleControlsLayout.f16025c.b();
    }

    public final boolean m16263o() {
        return this.f16090k != null && this.f16090k.m16176e();
    }

    public final Bitmap m16264s() {
        return m16246a(null, null);
    }

    public final Bitmap m16252a(@Nullable View view) {
        return m16246a(null, view);
    }

    public final Bitmap m16251a(@Nullable Bitmap bitmap) {
        return m16246a(bitmap, null);
    }

    private Bitmap m16246a(@Nullable Bitmap bitmap, @Nullable View view) {
        if (this.f16090k != null && this.f16090k.m16176e()) {
            View view2 = this.f16090k.f16025c;
            this.f16085f.removeView(view2);
            if (this.f16082c.indexOfChild(view2) < 0) {
                this.f16082c.addView(this.f16090k.f16025c);
            }
        }
        if (bitmap == null) {
            return this.f16080a.m16169a(view, this.f16082c, this.f16102w, Rotation.NONE);
        }
        return this.f16080a.m16168a(bitmap, this.f16082c, this.f16102w, Rotation.NONE);
    }

    public final void m16265t() {
        m16245C();
        this.f16088i.m16319b();
        int childCount = this.f16082c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.f16087h.m16297c(this.f16087h.f16192c);
        }
        this.f16093n = false;
        this.f16092m = false;
        if (this.f16089j != null) {
            this.f16089j.setStateAndVisibilities(State.HIDDEN);
        }
        if (this.f16090k != null) {
            if (this.f16090k.f16025c.getParent() == this.f16082c) {
                this.f16082c.removeView(this.f16090k.f16025c);
                this.f16085f.addView(this.f16090k.f16025c, this.f16085f.indexOfChild(this.f16090k));
            }
            DoodleControlsLayout doodleControlsLayout = this.f16090k;
            if (doodleControlsLayout.f16025c != null) {
                doodleControlsLayout.f16025c.a();
            }
            doodleControlsLayout.m16177h();
        }
    }

    private void m16245C() {
        boolean z;
        boolean z2 = true;
        if (this.f16087h.f16193d > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f16099t = z;
        if (this.f16087h.f16194e <= 0) {
            z2 = false;
        }
        this.f16100u = z2;
        this.f16101v = m16248w();
        this.f16097r = this.f16087h.f16195f.toString();
        this.f16098s = this.f16087h.f16196g.toString();
    }
}
