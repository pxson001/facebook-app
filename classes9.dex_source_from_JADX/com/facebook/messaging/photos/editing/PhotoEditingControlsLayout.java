package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: discarded_changes */
public class PhotoEditingControlsLayout extends CustomLinearLayout {
    @Inject
    public GlyphColorizer f16109a;
    private ImageButton f16110b;
    private ImageButton f16111c;
    private ImageButton f16112d;
    private ImageButton f16113e;
    private List<ImageButton> f16114f;
    private Drawable f16115g;
    public Listener f16116h;

    /* compiled from: discarded_changes */
    public interface Listener {
        void mo664a();

        void mo665b();

        void mo666c();

        void mo667d();

        void mo668e();
    }

    /* compiled from: discarded_changes */
    class C18951 implements OnClickListener {
        final /* synthetic */ PhotoEditingControlsLayout f16104a;

        C18951(PhotoEditingControlsLayout photoEditingControlsLayout) {
            this.f16104a = photoEditingControlsLayout;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 688515982);
            if (this.f16104a.f16116h != null) {
                this.f16104a.f16116h.mo667d();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2054221878, a);
        }
    }

    /* compiled from: discarded_changes */
    class C18962 implements OnLongClickListener {
        final /* synthetic */ PhotoEditingControlsLayout f16105a;

        C18962(PhotoEditingControlsLayout photoEditingControlsLayout) {
            this.f16105a = photoEditingControlsLayout;
        }

        public boolean onLongClick(View view) {
            if (this.f16105a.f16116h == null) {
                return false;
            }
            this.f16105a.f16116h.mo668e();
            return true;
        }
    }

    /* compiled from: discarded_changes */
    class C18973 implements OnClickListener {
        final /* synthetic */ PhotoEditingControlsLayout f16106a;

        C18973(PhotoEditingControlsLayout photoEditingControlsLayout) {
            this.f16106a = photoEditingControlsLayout;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1980655936);
            if (this.f16106a.f16116h != null) {
                this.f16106a.f16116h.mo664a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 992577331, a);
        }
    }

    /* compiled from: discarded_changes */
    class C18984 implements OnClickListener {
        final /* synthetic */ PhotoEditingControlsLayout f16107a;

        C18984(PhotoEditingControlsLayout photoEditingControlsLayout) {
            this.f16107a = photoEditingControlsLayout;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1849753630);
            if (this.f16107a.f16116h != null) {
                this.f16107a.f16116h.mo665b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1937421475, a);
        }
    }

    /* compiled from: discarded_changes */
    class C18995 implements OnClickListener {
        final /* synthetic */ PhotoEditingControlsLayout f16108a;

        C18995(PhotoEditingControlsLayout photoEditingControlsLayout) {
            this.f16108a = photoEditingControlsLayout;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1630567584);
            if (this.f16108a.f16116h != null) {
                this.f16108a.f16116h.mo666c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1498331548, a);
        }
    }

    private static <T extends View> void m16269a(Class<T> cls, T t) {
        m16270a((Object) t, t.getContext());
    }

    private static void m16270a(Object obj, Context context) {
        ((PhotoEditingControlsLayout) obj).f16109a = GlyphColorizer.a(FbInjector.get(context));
    }

    private void m16268a(GlyphColorizer glyphColorizer) {
        this.f16109a = glyphColorizer;
    }

    public PhotoEditingControlsLayout(Context context) {
        super(context);
        m16271b();
    }

    public PhotoEditingControlsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16271b();
    }

    public PhotoEditingControlsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16271b();
    }

    private void m16271b() {
        m16269a(PhotoEditingControlsLayout.class, (View) this);
        setContentView(2130903804);
        this.f16110b = (ImageButton) a(2131560801);
        this.f16111c = (ImageButton) a(2131560800);
        this.f16112d = (ImageButton) a(2131560799);
        this.f16113e = (ImageButton) a(2131560798);
        this.f16113e.setOnClickListener(new C18951(this));
        this.f16113e.setOnLongClickListener(new C18962(this));
        this.f16115g = ((LayerDrawable) this.f16112d.getDrawable()).findDrawableByLayerId(2131568588);
        this.f16109a.a(this.f16115g, -1);
        this.f16114f = Lists.a(new ImageButton[]{this.f16110b, this.f16111c, this.f16112d});
        this.f16110b.setOnClickListener(new C18973(this));
        this.f16111c.setOnClickListener(new C18984(this));
        this.f16112d.setOnClickListener(new C18995(this));
    }

    public void setListener(Listener listener) {
        this.f16116h = listener;
    }

    public final void m16274a(PhotoEditingConfig photoEditingConfig) {
        setAddTextLayerButtonVisibility(photoEditingConfig.f16070a);
        setAddStickerLayerButtonVisibility(photoEditingConfig.f16071b);
        setAddDoodleLayerButtonVisibility(photoEditingConfig.f16072c);
    }

    public final void m16272a() {
        setAddTextLayerButtonVisibility(false);
        setAddStickerLayerButtonVisibility(false);
        setAddDoodleLayerButtonVisibility(false);
    }

    private void setAddTextLayerButtonVisibility(boolean z) {
        this.f16110b.setVisibility(z ? 0 : 8);
    }

    private void setAddStickerLayerButtonVisibility(boolean z) {
        this.f16111c.setVisibility(z ? 0 : 8);
    }

    private void setAddDoodleLayerButtonVisibility(boolean z) {
        this.f16112d.setVisibility(z ? 0 : 8);
    }

    public void setUndoodleButtonVisibility(boolean z) {
        this.f16113e.setVisibility(z ? 0 : 8);
    }

    public final void m16273a(float f) {
        for (View rotation : this.f16114f) {
            rotation.setRotation(f);
        }
    }

    public void setAddDoodleLayerButtonBrushTipColour(int i) {
        this.f16115g.setColorFilter(this.f16109a.a(i));
        this.f16115g.invalidateSelf();
    }
}
