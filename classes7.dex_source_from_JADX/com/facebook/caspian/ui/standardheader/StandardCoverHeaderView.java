package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileGridView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.titlebar.FadingContentView;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: crop_flow_entries */
public class StandardCoverHeaderView extends CustomFrameLayout implements FadingContentView {
    @Inject
    public ScreenUtil f16543a;
    protected int f16544b;
    public int f16545c;
    protected StandardHeaderSizingType f16546d = StandardHeaderSizingType.STANDARD;
    protected CustomLinearLayout f16547e;
    public StandardHeaderTitlesContainer f16548f;
    public StandardCoverPhotoView f16549g;
    public LazyView<FacepileGridView> f16550h;
    public View f16551i;
    public StandardProfileImageFrame f16552j;
    public final ArrayList<View> f16553k = new ArrayList();
    private Paint f16554l;
    public float f16555m;
    public int f16556n;

    /* compiled from: crop_flow_entries */
    public enum StandardHeaderSizingType {
        STANDARD,
        NARROW,
        CUSTOM
    }

    public static void m20603a(Object obj, Context context) {
        ((StandardCoverHeaderView) obj).f16543a = ScreenUtil.a(FbInjector.get(context));
    }

    public StandardCoverHeaderView(Context context) {
        super(context);
        m20604b();
    }

    public StandardCoverHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20604b();
    }

    public StandardCoverHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20604b();
    }

    private void m20604b() {
        Class cls = StandardCoverHeaderView.class;
        m20603a((Object) this, getContext());
        setWillNotDraw(false);
        setContentView(2130907218);
        this.f16554l = new Paint(1);
        this.f16554l.setColor(-1);
        this.f16551i = c(2131564401);
        this.f16549g = (StandardCoverPhotoView) c(2131564398);
        this.f16552j = (StandardProfileImageFrame) c(2131567620);
        this.f16547e = (CustomLinearLayout) c(2131567614);
        this.f16548f = (StandardHeaderTitlesContainer) c(2131564400);
        this.f16550h = new LazyView((ViewStub) c(2131564397));
        this.f16544b = getResources().getConfiguration().orientation;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{2130772591, 2130772586});
        if (obtainStyledAttributes.getBoolean(0, true)) {
            this.f16553k.add(this.f16552j);
            this.f16553k.add(this.f16548f);
        }
        this.f16556n = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public final void m20607a(View view, int i) {
        this.f16547e.addView(view, i);
    }

    public void setCoverType(StandardCoverType standardCoverType) {
        switch (standardCoverType) {
            case IMAGE:
                this.f16549g.setVisibility(0);
                if (this.f16550h.b()) {
                    ((FacepileGridView) this.f16550h.a()).setVisibility(8);
                    return;
                }
                return;
            case FACEPILE:
                this.f16549g.setVisibility(8);
                ((FacepileGridView) this.f16550h.a()).setVisibility(0);
                return;
            case OTHER:
                this.f16549g.setVisibility(8);
                if (this.f16550h.b()) {
                    ((FacepileGridView) this.f16550h.a()).setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void m20609e() {
        this.f16552j.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f16548f.getLayoutParams();
        marginLayoutParams.bottomMargin = 0;
        MarginLayoutParamsCompat.a(marginLayoutParams, getResources().getDimensionPixelSize(2131427564));
        MarginLayoutParamsCompat.b(marginLayoutParams, getResources().getDimensionPixelSize(2131427564));
        marginLayoutParams.leftMargin = getResources().getDimensionPixelSize(2131427564);
    }

    @Nullable
    public ProfileVideoView getProfileVideoView() {
        LazyView lazyProfileVideoView = getLazyProfileVideoView();
        return lazyProfileVideoView.b() ? (ProfileVideoView) lazyProfileVideoView.a() : null;
    }

    public final void m20610f() {
        switch (this.f16546d) {
            case STANDARD:
                float f;
                int c = this.f16543a.c();
                if (this.f16544b == 1) {
                    f = 1.333f;
                } else {
                    f = 2.702f;
                }
                this.f16545c = Math.round(((float) c) / f);
                break;
            case NARROW:
                this.f16545c = StandardHeaderViewHelper.m20632b(this.f16543a.c(), this.f16544b);
                break;
            case CUSTOM:
                this.f16545c = m20605a(this.f16543a.c(), this.f16544b);
                break;
        }
        ((LayoutParams) this.f16551i.getLayoutParams()).height = this.f16545c;
        this.f16551i.requestLayout();
        this.f16555m = 1.0f - (((float) (getResources().getDimensionPixelSize(2131428150) + (this.f16556n / 2))) / ((float) this.f16545c));
    }

    protected int m20605a(int i, int i2) {
        return getResources().getDimensionPixelSize(2131427555);
    }

    public int getScreenWidth() {
        return this.f16543a.c();
    }

    public View getFadingView() {
        return this.f16551i;
    }

    public final void m20606a(float f) {
        float f2 = 1.0f;
        if (f >= 0.2f) {
            if (f < 0.2f || f >= this.f16555m) {
                f2 = 0.0f;
            } else {
                f2 = 1.0f - ((f - 0.2f) / (this.f16555m - 0.2f));
            }
        }
        float f3 = f2;
        int size = this.f16553k.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f16553k.get(i)).setAlpha(f3);
        }
    }

    protected final StandardProfileImageView getProfileImageView() {
        return this.f16552j.f16581b;
    }

    protected final ViewStub getProfileEditIconViewStub() {
        return this.f16552j.f16584e;
    }

    public final LazyView<FbDraweeView> getLazyProfileVideoIcon() {
        return this.f16552j.f16583d;
    }

    public final LazyView<ProfileVideoView> getLazyProfileVideoView() {
        return this.f16552j.f16582c;
    }

    public boolean m20608a() {
        return true;
    }

    public void draw(Canvas canvas) {
        if (getMeasuredHeight() > this.f16545c) {
            canvas.drawRect(0.0f, (float) this.f16545c, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.f16554l);
        }
        super.draw(canvas);
    }
}
