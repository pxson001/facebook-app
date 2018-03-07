package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButtonImpl.C04001;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.List;

@DefaultBehavior(Behavior.class)
/* compiled from: publish_offline_post_header_param_json_failed */
public class FloatingActionButton extends VisibilityAwareImageButton {
    private ColorStateList f7029a;
    private Mode f7030b;
    private int f7031c;
    public int f7032d;
    public final Rect f7033e;
    private final FloatingActionButtonImpl f7034f;

    /* compiled from: publish_offline_post_header_param_json_failed */
    public class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        private static final boolean f7024a = (VERSION.SDK_INT >= 11);
        public ValueAnimatorCompat f7025b;
        public float f7026c;
        private Rect f7027d;

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            view = (FloatingActionButton) view;
            if (view2 instanceof SnackbarLayout) {
                if (view.getVisibility() == 0) {
                    float f = 0.0f;
                    List c = coordinatorLayout.m10128c(view);
                    int size = c.size();
                    int i = 0;
                    while (i < size) {
                        float min;
                        View view3 = (View) c.get(i);
                        if ((view3 instanceof SnackbarLayout) && coordinatorLayout.m10126a(view, view3)) {
                            min = Math.min(f, ViewCompat.q(view3) - ((float) view3.getHeight()));
                        } else {
                            min = f;
                        }
                        i++;
                        f = min;
                    }
                    float f2 = f;
                    if (this.f7026c != f2) {
                        float q = ViewCompat.q(view);
                        if (this.f7025b != null && this.f7025b.m10241b()) {
                            this.f7025b.m10244e();
                        }
                        if (Math.abs(q - f2) > ((float) view.getHeight()) * 0.667f) {
                            if (this.f7025b == null) {
                                this.f7025b = ViewUtils.m10279a();
                                this.f7025b.m10240a(AnimationUtils.f6855b);
                                this.f7025b.m10239a(new AnimatorUpdateListener(this) {
                                    final /* synthetic */ Behavior f7023b;

                                    public final void mo847a(ValueAnimatorCompat valueAnimatorCompat) {
                                        ViewCompat.b(view, valueAnimatorCompat.m10243d());
                                    }
                                });
                            }
                            this.f7025b.m10236a(q, f2);
                            this.f7025b.m10235a();
                        } else {
                            ViewCompat.b(view, f2);
                        }
                        this.f7026c = f2;
                    }
                }
            } else if (view2 instanceof AppBarLayout) {
                m10132a(coordinatorLayout, (AppBarLayout) view2, view);
            }
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            view = (FloatingActionButton) view;
            List c = coordinatorLayout.m10128c(view);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = (View) c.get(i2);
                if ((view2 instanceof AppBarLayout) && m10132a(coordinatorLayout, (AppBarLayout) view2, view)) {
                    break;
                }
            }
            coordinatorLayout.m10122a(view, i);
            int i3 = 0;
            Rect rect = view.f7033e;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                int i4;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (view.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin) {
                    i4 = rect.right;
                } else if (view.getLeft() <= layoutParams.leftMargin) {
                    i4 = -rect.left;
                } else {
                    i4 = 0;
                }
                if (view.getBottom() >= coordinatorLayout.getBottom() - layoutParams.bottomMargin) {
                    i3 = rect.bottom;
                } else if (view.getTop() <= layoutParams.topMargin) {
                    i3 = -rect.top;
                }
                view.offsetTopAndBottom(i3);
                view.offsetLeftAndRight(i4);
            }
            return true;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return f7024a && (view2 instanceof SnackbarLayout);
        }

        private boolean m10132a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((LayoutParams) floatingActionButton.getLayoutParams()).f6984f != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.f7028a != 0) {
                return false;
            }
            if (this.f7027d == null) {
                this.f7027d = new Rect();
            }
            Rect rect = this.f7027d;
            ViewGroupUtils.m10268a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m10138b(null, false);
            } else {
                floatingActionButton.m10136a(null, false);
            }
            return true;
        }
    }

    public void setRippleColor(@ColorInt int i) {
        if (this.f7031c != i) {
            this.f7031c = i;
            this.f7034f.m10142c();
        }
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f7029a;
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f7029a != colorStateList) {
            this.f7029a = colorStateList;
            this.f7034f.m10140a();
        }
    }

    @Nullable
    public Mode getBackgroundTintMode() {
        return this.f7030b;
    }

    public void setBackgroundTintMode(@Nullable Mode mode) {
        if (this.f7030b != mode) {
            this.f7030b = mode;
            this.f7034f.m10141b();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    private void m10136a(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        FloatingActionButtonImpl floatingActionButtonImpl = this.f7034f;
        m10135a(onVisibilityChangedListener);
        floatingActionButtonImpl.m10146g();
    }

    private void m10138b(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        FloatingActionButtonImpl floatingActionButtonImpl = this.f7034f;
        m10135a(onVisibilityChangedListener);
        floatingActionButtonImpl.m10145f();
    }

    @Nullable
    private InternalVisibilityChangedListener m10135a(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new InternalVisibilityChangedListener(this) {
            final /* synthetic */ FloatingActionButton f7021b;
        };
    }

    protected void onMeasure(int i, int i2) {
        int dimensionPixelSize;
        switch (this.f7032d) {
            case 1:
                dimensionPixelSize = getResources().getDimensionPixelSize(2131427684);
                break;
            default:
                dimensionPixelSize = getResources().getDimensionPixelSize(2131427683);
                break;
        }
        int i3 = dimensionPixelSize;
        i3 = Math.min(m10134a(i3, i), m10134a(i3, i2));
        setMeasuredDimension((this.f7033e.left + i3) + this.f7033e.right, (i3 + this.f7033e.top) + this.f7033e.bottom);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -302120535);
        super.onAttachedToWindow();
        FloatingActionButtonImpl floatingActionButtonImpl = this.f7034f;
        if (null != null) {
            if (floatingActionButtonImpl.f7040e == null) {
                floatingActionButtonImpl.f7040e = new C04001(floatingActionButtonImpl);
            }
            floatingActionButtonImpl.f7039d.getViewTreeObserver().addOnPreDrawListener(floatingActionButtonImpl.f7040e);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1470609731, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1449873596);
        super.onDetachedFromWindow();
        FloatingActionButtonImpl floatingActionButtonImpl = this.f7034f;
        if (floatingActionButtonImpl.f7040e != null) {
            floatingActionButtonImpl.f7039d.getViewTreeObserver().removeOnPreDrawListener(floatingActionButtonImpl.f7040e);
            floatingActionButtonImpl.f7040e = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -786091124, a);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        FloatingActionButtonImpl floatingActionButtonImpl = this.f7034f;
        getDrawableState();
        floatingActionButtonImpl.m10143d();
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f7034f.m10144e();
    }

    private static int m10134a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }
}
