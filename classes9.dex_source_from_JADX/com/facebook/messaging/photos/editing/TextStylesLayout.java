package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: disableCache */
public class TextStylesLayout extends CustomLinearLayout {
    @Inject
    GlyphColorizer f16292a;
    @Inject
    SoftInputDetector f16293b;
    public Listener f16294c;
    private ImageView f16295d;
    private ImageView f16296e;
    private ImageView f16297f;

    /* compiled from: disableCache */
    public interface Listener {
        void mo669a(int i, int i2);
    }

    /* compiled from: disableCache */
    class StyleClickListener implements OnClickListener {
        final /* synthetic */ TextStylesLayout f16289a;
        private int f16290b;
        private int f16291c;

        public StyleClickListener(TextStylesLayout textStylesLayout, int i, int i2) {
            this.f16289a = textStylesLayout;
            this.f16290b = i;
            this.f16291c = i2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1126344922);
            if (this.f16289a.f16294c != null) {
                this.f16289a.f16294c.mo669a(this.f16290b, this.f16291c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1433213876, a);
        }
    }

    private static <T extends View> void m16356a(Class<T> cls, T t) {
        m16357a((Object) t, t.getContext());
    }

    private static void m16357a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TextStylesLayout) obj).m16355a(GlyphColorizer.a(fbInjector), SoftInputDetector.a(fbInjector));
    }

    private void m16355a(GlyphColorizer glyphColorizer, SoftInputDetector softInputDetector) {
        this.f16292a = glyphColorizer;
        this.f16293b = softInputDetector;
    }

    public TextStylesLayout(Context context) {
        super(context);
        m16354a();
    }

    public TextStylesLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16354a();
    }

    public TextStylesLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16354a();
    }

    private void m16354a() {
        m16356a(TextStylesLayout.class, (View) this);
        setContentView(2130907379);
        Drawable a = this.f16292a.a(2130837607, -1);
        Drawable a2 = this.f16292a.a(2130837607, -16777216);
        this.f16295d = (ImageView) a(2131567836);
        this.f16295d.setOnClickListener(new StyleClickListener(this, -1, 0));
        this.f16295d.setImageDrawable(a);
        this.f16296e = (ImageView) a(2131567837);
        this.f16296e.setOnClickListener(new StyleClickListener(this, -1, -16777216));
        this.f16296e.setImageDrawable(a);
        this.f16297f = (ImageView) a(2131567838);
        this.f16297f.setOnClickListener(new StyleClickListener(this, -16777216, -1));
        this.f16297f.setImageDrawable(a2);
    }

    public void setListener(Listener listener) {
        this.f16294c = listener;
    }

    public void onMeasure(int i, int i2) {
        setPadding(0, 0, 0, this.f16293b.e);
        super.onMeasure(i, i2);
    }
}
