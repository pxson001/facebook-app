package com.facebook.friendsharing.gif.activity;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import javax.inject.Inject;

/* compiled from: SECTION_TITLE */
public class GifTypeaheadText extends CustomLinearLayout {
    @Inject
    public SpringSystem f23910a;
    public SearchEditText f23911b;
    public ImageView f23912c;
    public Spring f23913d;
    private final TextWatcher f23914e = new C20701(this);
    private final SpringListener f23915f = new C20712(this);

    /* compiled from: SECTION_TITLE */
    class C20701 extends BaseTextWatcher {
        final /* synthetic */ GifTypeaheadText f23907a;

        C20701(GifTypeaheadText gifTypeaheadText) {
            this.f23907a = gifTypeaheadText;
        }

        public void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() != 0) {
                this.f23907a.f23913d.b(1.0d);
                this.f23907a.f23912c.setVisibility(0);
            } else if (this.f23907a.f23912c.getVisibility() == 0) {
                this.f23907a.f23913d.b(0.0d);
            } else {
                this.f23907a.f23912c.setVisibility(8);
            }
        }
    }

    /* compiled from: SECTION_TITLE */
    class C20712 extends SimpleSpringListener {
        final /* synthetic */ GifTypeaheadText f23908a;

        C20712(GifTypeaheadText gifTypeaheadText) {
            this.f23908a = gifTypeaheadText;
        }

        public final void m26034b(Spring spring) {
            if (spring.g(0.0d)) {
                this.f23908a.f23912c.setVisibility(8);
            }
        }

        public final void m26033a(Spring spring) {
            float d = (float) spring.d();
            this.f23908a.f23912c.setAlpha(d);
            this.f23908a.f23912c.setScaleX(d);
            this.f23908a.f23912c.setScaleY(d);
        }
    }

    /* compiled from: SECTION_TITLE */
    class C20723 implements OnClickListener {
        final /* synthetic */ GifTypeaheadText f23909a;

        C20723(GifTypeaheadText gifTypeaheadText) {
            this.f23909a = gifTypeaheadText;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -382483208);
            this.f23909a.f23911b.a();
            Logger.a(2, EntryType.UI_INPUT_END, 413361224, a);
        }
    }

    private static <T extends View> void m26038a(Class<T> cls, T t) {
        m26039a((Object) t, t.getContext());
    }

    private static void m26039a(Object obj, Context context) {
        ((GifTypeaheadText) obj).f23910a = SpringSystem.b(FbInjector.get(context));
    }

    public GifTypeaheadText(Context context) {
        super(context);
        m26036a();
    }

    public GifTypeaheadText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26036a();
    }

    public GifTypeaheadText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26036a();
    }

    private void m26036a() {
        m26038a(GifTypeaheadText.class, (View) this);
        setContentView(2130904593);
        this.f23911b = (SearchEditText) a(2131562543);
        this.f23912c = (ImageView) a(2131562544);
        m26041b();
        m26043c();
    }

    private void m26041b() {
        if (VERSION.SDK_INT < 17) {
            this.f23911b.setGravity(19);
        } else {
            this.f23911b.setTextAlignment(5);
        }
    }

    private void m26043c() {
        this.f23913d = this.f23910a.a().a(SpringConfig.b(10.0d, 12.0d)).a(0.0d).b(0.0d).l();
        this.f23912c.setOnClickListener(new C20723(this));
    }

    private void m26037a(SpringSystem springSystem) {
        this.f23910a = springSystem;
    }

    public void setClearTextButtonListener(OnClickListener onClickListener) {
        this.f23912c.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1405100966);
        super.onAttachedToWindow();
        this.f23911b.addTextChangedListener(this.f23914e);
        this.f23913d.a(this.f23915f);
        if (!this.f23911b.getText().toString().isEmpty()) {
            this.f23912c.setVisibility(0);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -776910607, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1637274515);
        this.f23911b.removeTextChangedListener(this.f23914e);
        this.f23913d.m();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -894438475, a);
    }

    public SearchEditText getSearchEditText() {
        return this.f23911b;
    }
}
