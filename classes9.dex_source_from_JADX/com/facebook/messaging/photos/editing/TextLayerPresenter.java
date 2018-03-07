package com.facebook.messaging.photos.editing;

import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.messaging.photos.editing.LayerEditText.OnBackPressedListener;
import com.facebook.messaging.photos.editing.SceneLayersPresenter.C19065;
import com.facebook.messaging.photos.editing.TextLayer.Event;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;

/* compiled from: dialtone_switcher_enter_full_fb_dialog_canceled */
public class TextLayerPresenter extends LayerPresenter {
    private static final SpringConfig f16280a = new SpringConfig(150.0d, 15.0d);
    public final TextLayer f16281b;
    public final LayerEditText f16282c;
    private final Spring f16283d;
    private final TextWatcher f16284e = new C19161(this);
    private final FrameLayout f16285f;
    public C19065 f16286g;
    private int f16287h;
    private boolean f16288i;

    /* compiled from: dialtone_switcher_enter_full_fb_dialog_canceled */
    class C19161 implements TextWatcher {
        final /* synthetic */ TextLayerPresenter f16275a;

        C19161(TextLayerPresenter textLayerPresenter) {
            this.f16275a = textLayerPresenter;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Layer layer = this.f16275a.f16281b;
            layer.f16272a = charSequence;
            layer.m16178a(Event.TEXT_CHANGE);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_dialog_canceled */
    class C19172 implements OnEditorActionListener {
        final /* synthetic */ TextLayerPresenter f16276a;

        C19172(TextLayerPresenter textLayerPresenter) {
            this.f16276a = textLayerPresenter;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                this.f16276a.m16343c(false);
            }
            return false;
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_dialog_canceled */
    class C19183 implements OnBackPressedListener {
        final /* synthetic */ TextLayerPresenter f16277a;

        C19183(TextLayerPresenter textLayerPresenter) {
            this.f16277a = textLayerPresenter;
        }

        public final void mo677a() {
            this.f16277a.m16343c(false);
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_dialog_canceled */
    public class EditStateSpringListener extends SimpleSpringListener {
        final /* synthetic */ TextLayerPresenter f16279a;

        public EditStateSpringListener(TextLayerPresenter textLayerPresenter) {
            this.f16279a = textLayerPresenter;
        }

        public final void m16339a(Spring spring) {
            this.f16279a.m16197o();
            this.f16279a.m16198p();
            this.f16279a.m16199q();
        }
    }

    public TextLayerPresenter(TextLayer textLayer, LayerEditText layerEditText, SpringSystem springSystem) {
        super(textLayer, layerEditText, springSystem);
        this.f16281b = textLayer;
        this.f16282c = layerEditText;
        this.f16282c.setImeOptions(6);
        this.f16283d = springSystem.a().a(f16280a).a(new EditStateSpringListener(this));
        this.f16285f = new FrameLayout(this.f16282c.getContext());
        this.f16285f.setLayoutParams(new LayoutParams(-1, -1));
        this.f16285f.setBackgroundDrawable(new ColorDrawable(this.f16285f.getResources().getColor(2131362344)));
    }

    public final void mo675c() {
        super.mo675c();
        this.f16282c.setOnEditorActionListener(new C19172(this));
        this.f16282c.f16033a = new C19183(this);
        this.f16282c.addTextChangedListener(this.f16284e);
    }

    public final void mo678d() {
        super.mo678d();
        this.f16282c.setOnEditorActionListener(null);
        this.f16282c.f16033a = null;
        this.f16282c.setOnFocusChangeListener(null);
        this.f16282c.removeTextChangedListener(this.f16284e);
    }

    public final void mo679e() {
        m16343c(true);
    }

    public final void mo680f() {
        m16343c(true);
    }

    public final void mo681g() {
        super.mo681g();
        m16343c(false);
    }

    public final void m16343c(boolean z) {
        if (this.f16288i != z) {
            boolean z2;
            if (this.f16286g != null) {
                C19065 c19065 = this.f16286g;
                if (!(c19065.f16201a.f16212f == null || c19065.f16201a.f16220n)) {
                    c19065.f16201a.f16212f.m16241b(z);
                }
            }
            this.f16288i = z;
            ViewGroup viewGroup = (ViewGroup) this.f16282c.getParent();
            this.f16283d.b(z ? 1.0d : 0.0d);
            this.f16282c.setTextIsSelectable(z);
            this.f16282c.setFocusable(z);
            this.f16282c.setFocusableInTouchMode(z);
            this.f16282c.setEnabled(z);
            this.f16282c.setClickable(z);
            this.f16282c.setLongClickable(z);
            if (z) {
                this.f16282c.requestFocus();
                this.f16282c.setSelection(this.f16282c.getText().length());
                ((InputMethodManager) this.f16282c.getContext().getSystemService("input_method")).showSoftInput(this.f16282c, 0);
                viewGroup.addView(this.f16285f);
                this.f16287h = viewGroup.indexOfChild(this.f16282c);
                this.f16282c.bringToFront();
                viewGroup.invalidate();
                viewGroup.requestLayout();
            } else {
                viewGroup.removeView(this.f16282c);
                viewGroup.addView(this.f16282c, this.f16287h);
                viewGroup.removeView(this.f16285f);
            }
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f16043g != z2) {
                this.f16043g = z2;
            }
        }
    }

    protected final void mo674a(Object obj) {
        super.mo674a(obj);
        if (obj instanceof Event) {
            switch ((Event) obj) {
                case TEXT_CHANGE:
                    if (!this.f16281b.f16272a.toString().equals(this.f16282c.getText().toString())) {
                        this.f16282c.setText(this.f16281b.f16272a);
                        return;
                    }
                    return;
                case TEXT_COLOR_CHANGE:
                    this.f16282c.setTextColor(this.f16281b.f16273b);
                    return;
                case BACKGROUND_COLOR_CHANGE:
                    this.f16282c.setBackgroundDrawable(new ColorDrawable(this.f16281b.f16274c));
                    return;
                default:
                    return;
            }
        }
    }

    private float m16340t() {
        return (float) this.f16283d.d();
    }

    protected final float mo682j() {
        return super.mo682j() * (1.0f - m16340t());
    }

    protected final float mo683k() {
        View view = (View) this.f16282c.getParent();
        if (view == null) {
            return super.mo683k();
        }
        return MathUtil.m16201a(super.mo683k(), (float) ((-view.getHeight()) / 5), m16340t());
    }

    protected final float mo684l() {
        float f;
        float l = super.mo684l();
        if (l < 0.0f) {
            f = (float) (((int) ((l - 180.0f) / 360.0f)) * 360);
        } else {
            f = (float) (((int) ((l + 180.0f) / 360.0f)) * 360);
        }
        return MathUtil.m16201a(l, f, m16340t());
    }

    protected final float mo685m() {
        return MathUtil.m16201a(super.mo685m(), 1.0f, m16340t());
    }

    protected final float mo686n() {
        return MathUtil.m16201a(super.mo686n(), 1.0f, m16340t());
    }
}
