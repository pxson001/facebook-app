package com.facebook.rtc.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.rtc.views.RtcVideoChatHeadView.Location;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: application/pkcs7-mime */
public class RtcFloatingSelfView extends RtcFloatingView {
    private static final Class<?> f20129b = RtcFloatingSelfView.class;
    @Inject
    @LoggedInUserKey
    public Provider<UserKey> f20130a;
    public TextureView f20131c;
    private UserTileView f20132d;
    private Path f20133h = null;
    public boolean f20134i;
    private float f20135j = 0.0f;

    /* compiled from: application/pkcs7-mime */
    public interface SelfViewFrameChecker {
        long mo821a();
    }

    private static <T extends View> void m19780a(Class<T> cls, T t) {
        m19781a((Object) t, t.getContext());
    }

    private static void m19781a(Object obj, Context context) {
        ((RtcFloatingSelfView) obj).f20130a = IdBasedProvider.a(FbInjector.get(context), 3597);
    }

    public void setUseClipPathForCircular(boolean z) {
        this.f20134i = z;
    }

    public TextureView getSelfTextureView() {
        return this.f20131c;
    }

    public RtcFloatingSelfView(Context context) {
        super(context);
    }

    public RtcFloatingSelfView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m19782a(Provider<UserKey> provider) {
        this.f20130a = provider;
    }

    public void setCaptureVideoPortraitRatio(float f) {
        this.f20135j = f;
        requestLayout();
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f20134i) {
            if (this.f20133h == null) {
                this.f20133h = new Path();
                Point point = this.f20107a;
                switch (this.f20108c) {
                    case CENTER:
                        this.f20133h.addCircle((float) (getWidth() / 2), (float) (getHeight() / 2), ((float) (m19752a(120) * 9)) / 20.0f, Direction.CCW);
                        break;
                    case BOTTOM_RIGHT:
                        this.f20133h.addCircle((float) (getWidth() - (point.x / 2)), (float) (getHeight() - (point.y / 2)), (float) Math.min(point.x, point.y / 2), Direction.CCW);
                        break;
                }
            }
            canvas.clipPath(this.f20133h);
        }
        super.dispatchDraw(canvas);
    }

    public final void mo829a() {
        if (this.f20134i) {
            this.f20131c.setAlpha(0.0f);
            return;
        }
        this.f20131c.setVisibility(4);
        this.f20132d.setVisibility(0);
    }

    public final void m19786b() {
        mo829a();
        this.f20131c.setAlpha(0.0f);
        this.f20131c.setVisibility(0);
    }

    public final void m19785a(boolean z) {
        m19758f();
        this.f20131c.setVisibility(0);
        this.f20131c.setAlpha(1.0f);
        if (z) {
            this.f20132d.setVisibility(4);
        }
    }

    View getVideoView() {
        return this.f20131c;
    }

    final void mo832e() {
        this.f20133h = null;
    }

    ImmutableList<View> getOtherViews() {
        return ImmutableList.of(this.f20132d);
    }

    final void mo831d() {
        m19780a(RtcFloatingSelfView.class, (View) this);
        LayoutInflater from = LayoutInflater.from(getContext());
        if (this.f20112g) {
            from.inflate(2130906916, this);
        } else {
            from.inflate(2130906915, this);
        }
        this.f20131c = (TextureView) m19755b(2131567156);
        this.f20131c.setOpaque(false);
        this.f20132d = (UserTileView) m19755b(2131567155);
        this.f20132d.setParams(UserTileViewParams.a((UserKey) this.f20130a.get()));
    }

    final void mo830a(LayoutParams layoutParams) {
        Point point = this.f20107a;
        int i = getContext().getResources().getConfiguration().orientation;
        int min = Math.min(point.x, point.y);
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (i == 1) {
            layoutParams.height = (int) (((float) min) * this.f20111f);
            layoutParams.width = min;
            if (this.f20112g && this.f20108c == Location.BOTTOM_RIGHT) {
                layoutParams.bottomMargin = (-(layoutParams.height - layoutParams.width)) / 2;
            }
            Integer.valueOf(layoutParams.width);
            Integer.valueOf(layoutParams.height);
            Float.valueOf(this.f20111f);
        } else {
            layoutParams.height = min;
            layoutParams.width = (int) (((float) min) * this.f20111f);
            if (this.f20112g && this.f20108c == Location.BOTTOM_RIGHT) {
                layoutParams.rightMargin = (-(layoutParams.width - layoutParams.height)) / 2;
            }
            Integer.valueOf(layoutParams.width);
            Integer.valueOf(layoutParams.height);
            Float.valueOf(this.f20111f);
        }
        if (!this.f20112g && this.f20135j > 0.0f) {
            Matrix matrix = new Matrix();
            if (i == 1) {
                if (this.f20111f < this.f20135j) {
                    matrix.setScale(1.0f, this.f20135j / this.f20111f);
                } else {
                    matrix.setScale(this.f20111f / this.f20135j, 1.0f);
                }
            } else if (this.f20111f < this.f20135j) {
                matrix.setScale(this.f20135j / this.f20111f, 1.0f);
            } else {
                matrix.setScale(1.0f, this.f20111f / this.f20135j);
            }
            this.f20131c.setTransform(matrix);
        }
    }
}
