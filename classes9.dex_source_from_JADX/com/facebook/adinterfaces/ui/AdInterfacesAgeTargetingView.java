package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.uicontrib.seekbar.OnRangeSeekBarChangeListener;
import com.facebook.uicontrib.seekbar.RangeSeekBar;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.scrollview.ScrollViewLocker;
import javax.inject.Inject;

/* compiled from: VIDEO_UPLOAD_COMPLETED */
public class AdInterfacesAgeTargetingView extends CustomLinearLayout {
    @Inject
    public ScrollViewLocker f22537a;
    private int f22538b;
    public int f22539c;
    public int f22540d;
    public FbTextView f22541e;
    private FbTextView f22542f;
    public RangeSeekBar f22543g;
    public OnAgeRangeChangeListener f22544h;

    /* compiled from: VIDEO_UPLOAD_COMPLETED */
    class C25801 implements OnRangeSeekBarChangeListener {
        final /* synthetic */ AdInterfacesAgeTargetingView f22536a;

        C25801(AdInterfacesAgeTargetingView adInterfacesAgeTargetingView) {
            this.f22536a = adInterfacesAgeTargetingView;
        }

        public final void m24394a(float f, float f2) {
            this.f22536a.f22541e.setText(Integer.toString((int) f));
            this.f22536a.m24404b();
        }

        public final void m24395b(float f, float f2) {
            int i = (this.f22536a.f22539c == ((int) f) && this.f22536a.f22540d == ((int) f2)) ? 0 : 1;
            this.f22536a.f22539c = (int) f;
            this.f22536a.f22540d = (int) f2;
            this.f22536a.f22543g.requestFocus();
            this.f22536a.f22543g.setContentDescription(this.f22536a.getResources().getString(2131233891, new Object[]{Integer.valueOf(this.f22536a.f22539c), Integer.valueOf(this.f22536a.f22540d)}));
            if (!(this.f22536a.f22544h == null || i == 0)) {
                this.f22536a.f22544h.mo989a();
            }
            this.f22536a.sendAccessibilityEvent(524288);
        }
    }

    /* compiled from: VIDEO_UPLOAD_COMPLETED */
    public interface OnAgeRangeChangeListener {
        void mo989a();
    }

    private static <T extends View> void m24401a(Class<T> cls, T t) {
        m24402a((Object) t, t.getContext());
    }

    private static void m24402a(Object obj, Context context) {
        ((AdInterfacesAgeTargetingView) obj).f22537a = ScrollViewLocker.a(FbInjector.get(context));
    }

    public AdInterfacesAgeTargetingView(Context context) {
        super(context);
        m24399a();
    }

    public AdInterfacesAgeTargetingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24399a();
    }

    public AdInterfacesAgeTargetingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24399a();
    }

    private void m24399a() {
        m24401a(AdInterfacesAgeTargetingView.class, (View) this);
        setContentView(2130903101);
        this.f22541e = (FbTextView) a(2131559252);
        this.f22542f = (FbTextView) a(2131559254);
        this.f22543g = (RangeSeekBar) a(2131559253);
        this.f22543g.setRangeSeekBarChangeListener(new C25801(this));
        ScrollViewLocker scrollViewLocker = this.f22537a;
        scrollViewLocker.a.add(this.f22543g);
    }

    private void m24400a(ScrollViewLocker scrollViewLocker) {
        this.f22537a = scrollViewLocker;
    }

    private void m24404b() {
        CharSequence num = Integer.toString((int) this.f22543g.f1696l);
        if (this.f22538b == ((int) this.f22543g.f1696l)) {
            num = num + "+";
        }
        this.f22542f.setText(num);
    }

    private void m24407c() {
        Paint paint = new Paint();
        paint.setTextSize(this.f22542f.getTextSize());
        paint.setTextScaleX(this.f22542f.getTextScaleX());
        this.f22542f.setMinimumWidth((int) paint.measureText(this.f22538b + "+"));
    }

    public final void m24411a(int i, int i2) {
        this.f22538b = i2;
        m24407c();
        this.f22543g.m1723e((float) i, (float) this.f22538b);
        m24404b();
    }

    public final void m24412b(int i, int i2) {
        this.f22539c = i;
        this.f22540d = i2;
        this.f22543g.m1724f((float) i, (float) i2);
    }

    public void setOnAgeRangeChangeListener(OnAgeRangeChangeListener onAgeRangeChangeListener) {
        this.f22544h = onAgeRangeChangeListener;
    }

    public int getAgeStart() {
        return this.f22539c;
    }

    public int getAgeEnd() {
        return this.f22540d;
    }
}
