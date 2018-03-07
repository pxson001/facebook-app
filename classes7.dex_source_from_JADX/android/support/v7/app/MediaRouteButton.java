package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Toast;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: custom_cta_mobile_contact_us_tapped_request */
public class MediaRouteButton extends View {
    private static final int[] f16204l = new int[]{16842912};
    private static final int[] f16205m = new int[]{16842911};
    private final MediaRouter f16206a;
    private final MediaRouterCallback f16207b;
    private MediaRouteSelector f16208c;
    private MediaRouteDialogFactory f16209d;
    private boolean f16210e;
    private Drawable f16211f;
    private boolean f16212g;
    private boolean f16213h;
    private boolean f16214i;
    private int f16215j;
    private int f16216k;

    /* compiled from: custom_cta_mobile_contact_us_tapped_request */
    final class MediaRouterCallback extends Callback {
        final /* synthetic */ MediaRouteButton f16203a;

        public MediaRouterCallback(MediaRouteButton mediaRouteButton) {
            this.f16203a = mediaRouteButton;
        }

        public final void mo1248a(MediaRouter mediaRouter, RouteInfo routeInfo) {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1247a(MediaRouter mediaRouter) {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1250b(MediaRouter mediaRouter) {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1246a(RouteInfo routeInfo) {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1245a() {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1249b() {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1251c() {
            MediaRouteButton.m20269b(this.f16203a);
        }

        public final void mo1252d() {
            MediaRouteButton.m20269b(this.f16203a);
        }
    }

    public MediaRouteButton(Context context) {
        this(context, null);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773715);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i) {
        super(MediaRouterThemeHelper.m20289a(context, false), attributeSet, i);
        this.f16208c = MediaRouteSelector.f16268a;
        this.f16209d = MediaRouteDialogFactory.f16246a;
        Context context2 = getContext();
        this.f16206a = MediaRouter.m20380a(context2);
        this.f16207b = new MediaRouterCallback(this);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.MediaRouteButton, i, 0);
        setRemoteIndicatorDrawable(obtainStyledAttributes.getDrawable(2));
        this.f16215j = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f16216k = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        setClickable(true);
        setLongClickable(true);
    }

    @NonNull
    public MediaRouteSelector getRouteSelector() {
        return this.f16208c;
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f16208c.equals(mediaRouteSelector)) {
            if (this.f16210e) {
                if (!this.f16208c.m20345b()) {
                    this.f16206a.m20391a(this.f16207b);
                }
                if (!mediaRouteSelector.m20345b()) {
                    this.f16206a.m20389a(mediaRouteSelector, this.f16207b);
                }
            }
            this.f16208c = mediaRouteSelector;
            m20269b(this);
        }
    }

    @NonNull
    public MediaRouteDialogFactory getDialogFactory() {
        return this.f16209d;
    }

    public void setDialogFactory(@NonNull MediaRouteDialogFactory mediaRouteDialogFactory) {
        if (mediaRouteDialogFactory == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.f16209d = mediaRouteDialogFactory;
    }

    private boolean m20268a() {
        if (!this.f16210e) {
            return false;
        }
        Activity activity;
        FragmentManager kO_;
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                activity = (Activity) context;
                break;
            }
        }
        activity = null;
        Activity activity2 = activity;
        if (activity2 instanceof FragmentActivity) {
            kO_ = ((FragmentActivity) activity2).kO_();
        } else {
            kO_ = null;
        }
        FragmentManager fragmentManager = kO_;
        if (fragmentManager == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        RouteInfo c = MediaRouter.m20387c();
        if (c.m20377g() || !c.m20373a(this.f16208c)) {
            if (fragmentManager.a("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            MediaRouteChooserDialogFragment mediaRouteChooserDialogFragment = new MediaRouteChooserDialogFragment();
            mediaRouteChooserDialogFragment.m20276a(this.f16208c);
            mediaRouteChooserDialogFragment.a(fragmentManager, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
        } else if (fragmentManager.a("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
            Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
            return false;
        } else {
            this.f16209d.m20287c().a(fragmentManager, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
        }
        return true;
    }

    void setCheatSheetEnabled(boolean z) {
        this.f16213h = z;
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        if (m20268a() || performClick) {
            return true;
        }
        return false;
    }

    public boolean performLongClick() {
        if (super.performLongClick()) {
            return true;
        }
        if (!this.f16213h) {
            return false;
        }
        CharSequence contentDescription = getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, contentDescription, 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, (i2 - iArr[0]) - (width / 2), height);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        performHapticFeedback(0);
        return true;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f16214i) {
            mergeDrawableStates(onCreateDrawableState, f16205m);
        } else if (this.f16212g) {
            mergeDrawableStates(onCreateDrawableState, f16204l);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f16211f != null) {
            this.f16211f.setState(getDrawableState());
            invalidate();
        }
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        if (this.f16211f != null) {
            this.f16211f.setCallback(null);
            unscheduleDrawable(this.f16211f);
        }
        this.f16211f = drawable;
        if (drawable != null) {
            boolean z;
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            if (getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
        refreshDrawableState();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f16211f;
    }

    public void jumpDrawablesToCurrentState() {
        if (getBackground() != null) {
            DrawableCompat.a(getBackground());
        }
        if (this.f16211f != null) {
            DrawableCompat.a(this.f16211f);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.f16211f != null) {
            boolean z;
            Drawable drawable = this.f16211f;
            if (getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1541331887);
        super.onAttachedToWindow();
        this.f16210e = true;
        if (!this.f16208c.m20345b()) {
            this.f16206a.m20389a(this.f16208c, this.f16207b);
        }
        m20269b(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1246838384, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1731529555);
        this.f16210e = false;
        if (!this.f16208c.m20345b()) {
            this.f16206a.m20391a(this.f16207b);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1278036196, a);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int max = Math.max(this.f16215j, this.f16211f != null ? this.f16211f.getIntrinsicWidth() : 0);
        int i4 = this.f16216k;
        if (this.f16211f != null) {
            i3 = this.f16211f.getIntrinsicHeight();
        }
        i4 = Math.max(i4, i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                i3 = Math.min(size, (max + getPaddingLeft()) + getPaddingRight());
                break;
            case 1073741824:
                i3 = size;
                break;
            default:
                i3 = (max + getPaddingLeft()) + getPaddingRight();
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                max = Math.min(size2, (getPaddingTop() + i4) + getPaddingBottom());
                break;
            case 1073741824:
                max = size2;
                break;
            default:
                max = (getPaddingTop() + i4) + getPaddingBottom();
                break;
        }
        setMeasuredDimension(i3, max);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16211f != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f16211f.getIntrinsicWidth();
            int intrinsicHeight = this.f16211f.getIntrinsicHeight();
            paddingLeft += ((width - paddingLeft) - intrinsicWidth) / 2;
            width = (((height - paddingTop) - intrinsicHeight) / 2) + paddingTop;
            this.f16211f.setBounds(paddingLeft, width, paddingLeft + intrinsicWidth, width + intrinsicHeight);
            this.f16211f.draw(canvas);
        }
    }

    public static void m20269b(MediaRouteButton mediaRouteButton) {
        int i = 0;
        if (mediaRouteButton.f16210e) {
            boolean z;
            RouteInfo c = MediaRouter.m20387c();
            boolean z2 = !c.m20377g() && c.m20373a(mediaRouteButton.f16208c);
            if (z2 && c.f16310g) {
                z = true;
            } else {
                z = false;
            }
            if (mediaRouteButton.f16212g != z2) {
                mediaRouteButton.f16212g = z2;
                i = 1;
            }
            if (mediaRouteButton.f16214i != z) {
                mediaRouteButton.f16214i = z;
                i = 1;
            }
            if (i != 0) {
                mediaRouteButton.refreshDrawableState();
            }
            mediaRouteButton.setEnabled(MediaRouter.m20383a(mediaRouteButton.f16208c, 1));
        }
    }
}
