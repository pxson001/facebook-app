package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.drawingview.DrawingView;
import com.facebook.drawingview.DrawingView.DrawingListener;
import com.facebook.drawingview.DrawingView.OnDrawingClearedListener;
import com.facebook.messaging.doodle.ColourIndicator;
import com.facebook.messaging.doodle.ColourPicker;
import com.facebook.messaging.doodle.ColourPicker.OnColourPickerInteractionListener;
import com.facebook.messaging.photos.editing.PhotoEditingController.C18946;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: dispose */
public class DoodleControlsLayout extends CustomFrameLayout {
    public final ColourIndicator f16023a;
    public final ColourPicker f16024b;
    public DrawingView f16025c;
    public C18946 f16026d;

    /* compiled from: dispose */
    class C18751 implements OnColourPickerInteractionListener {
        final /* synthetic */ DoodleControlsLayout f16020a;

        C18751(DoodleControlsLayout doodleControlsLayout) {
            this.f16020a = doodleControlsLayout;
        }

        public final void m16171a(int i, float f, float f2, float f3) {
            DoodleControlsLayout.m16175j(this.f16020a);
            this.f16020a.f16023a.a(i, f, f2, f3);
            this.f16020a.f16025c.setStrokeWidth(f3);
            this.f16020a.f16025c.setColour(i);
            this.f16020a.f16026d.m16243a(i);
        }

        public final void m16170a(int i) {
            DoodleControlsLayout.m16175j(this.f16020a);
            this.f16020a.f16023a.setColour(i);
            this.f16020a.f16023a.a();
            this.f16020a.f16025c.setColour(i);
        }
    }

    /* compiled from: dispose */
    class C18762 implements DrawingListener {
        final /* synthetic */ DoodleControlsLayout f16021a;

        C18762(DoodleControlsLayout doodleControlsLayout) {
            this.f16021a = doodleControlsLayout;
        }

        public final void m16172a() {
            if (this.f16021a.f16026d != null) {
                if (this.f16021a.f16025c.isEnabled()) {
                    C18946 c18946 = this.f16021a.f16026d;
                    c18946.f16079a.f16092m = true;
                    PhotoEditingController.m16250y(c18946.f16079a);
                }
                this.f16021a.f16026d.m16244a(false);
            }
            this.f16021a.f16024b.setVisibility(8);
            this.f16021a.f16023a.setVisibility(8);
        }

        public final void m16173b() {
            if (this.f16021a.f16026d != null) {
                if (this.f16021a.f16025c.isEnabled()) {
                    C18946 c18946 = this.f16021a.f16026d;
                    c18946.f16079a.f16092m = false;
                    PhotoEditingController.m16250y(c18946.f16079a);
                }
                this.f16021a.f16026d.m16244a(true);
            }
            this.f16021a.f16024b.setVisibility(0);
            this.f16021a.f16023a.setVisibility(0);
        }
    }

    /* compiled from: dispose */
    class C18773 implements OnDrawingClearedListener {
        final /* synthetic */ DoodleControlsLayout f16022a;

        C18773(DoodleControlsLayout doodleControlsLayout) {
            this.f16022a = doodleControlsLayout;
        }

        public final void m16174a() {
            if (this.f16022a.f16026d != null) {
                this.f16022a.f16026d.m16244a(false);
            }
        }
    }

    public DoodleControlsLayout(Context context) {
        super(context);
        setContentView(2130903929);
        setClipChildren(false);
        this.f16023a = (ColourIndicator) c(2131561074);
        this.f16024b = (ColourPicker) c(2131561075);
        this.f16024b.c = new C18751(this);
    }

    public final boolean m16176e() {
        return this.f16025c != null && this.f16025c.c();
    }

    public final void m16177h() {
        if (this.f16025c != null) {
            this.f16025c.setEnabled(false);
        }
        if (this.f16026d != null) {
            this.f16026d.m16244a(false);
        }
        this.f16024b.setVisibility(8);
        this.f16023a.setVisibility(8);
        this.f16026d.m16243a(-1);
    }

    public static void m16175j(DoodleControlsLayout doodleControlsLayout) {
        if (doodleControlsLayout.f16025c == null) {
            ViewGroup viewGroup = (ViewGroup) doodleControlsLayout.getParent();
            doodleControlsLayout.f16025c = new DrawingView(viewGroup.getContext());
            doodleControlsLayout.f16025c.d = new C18762(doodleControlsLayout);
            doodleControlsLayout.f16025c.n = new C18773(doodleControlsLayout);
            doodleControlsLayout.f16025c.setEnabled(false);
            viewGroup.addView(doodleControlsLayout.f16025c, viewGroup.indexOfChild(doodleControlsLayout));
        }
    }
}
