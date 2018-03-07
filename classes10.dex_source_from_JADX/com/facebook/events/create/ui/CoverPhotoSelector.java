package com.facebook.events.create.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.events.create.EventCompositionModel;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Objects;
import javax.inject.Inject;

/* compiled from: contact_multipicker_item */
public class CoverPhotoSelector extends CustomFrameLayout implements OnClickListener {
    private static int f16300o;
    private static int f16301p;
    private EventCompositionModel f16302a;
    private boolean f16303b;
    public boolean f16304c;
    public boolean f16305d;
    public boolean f16306e;
    private Activity f16307f;
    public CoverPhotoRemovedListener f16308g;
    public boolean f16309h;
    public boolean f16310i;
    private InterstitialManager f16311j;
    private TipSeenTracker f16312k;
    private Tooltip f16313l;
    public CoverPhotoActivitiesLauncher f16314m;
    private boolean f16315n;

    /* compiled from: contact_multipicker_item */
    public interface CoverPhotoRemovedListener {
        void mo779a();
    }

    /* compiled from: contact_multipicker_item */
    class C22731 implements OnMenuItemClickListener {
        final /* synthetic */ CoverPhotoSelector f16294a;

        C22731(CoverPhotoSelector coverPhotoSelector) {
            this.f16294a = coverPhotoSelector;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f16294a.f16308g != null) {
                this.f16294a.f16308g.mo779a();
            }
            return true;
        }
    }

    /* compiled from: contact_multipicker_item */
    class C22742 implements OnMenuItemClickListener {
        final /* synthetic */ CoverPhotoSelector f16295a;

        C22742(CoverPhotoSelector coverPhotoSelector) {
            this.f16295a = coverPhotoSelector;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f16295a.f16304c = true;
            this.f16295a.f16314m.m16773b();
            return true;
        }
    }

    /* compiled from: contact_multipicker_item */
    class C22753 implements OnMenuItemClickListener {
        final /* synthetic */ CoverPhotoSelector f16296a;

        C22753(CoverPhotoSelector coverPhotoSelector) {
            this.f16296a = coverPhotoSelector;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f16296a.f16305d = true;
            CoverPhotoActivitiesLauncher coverPhotoActivitiesLauncher = this.f16296a.f16314m;
            Intent b = coverPhotoActivitiesLauncher.f16291b.b(coverPhotoActivitiesLauncher.f16290a.getBaseContext(), FBLinks.dS);
            b.putExtra("extra_photo_title_text", coverPhotoActivitiesLauncher.f16290a.getBaseContext().getResources().getString(2131236914));
            coverPhotoActivitiesLauncher.f16292c.a(b, 9913, coverPhotoActivitiesLauncher.f16290a);
            return true;
        }
    }

    /* compiled from: contact_multipicker_item */
    class C22764 implements OnMenuItemClickListener {
        final /* synthetic */ CoverPhotoSelector f16297a;

        C22764(CoverPhotoSelector coverPhotoSelector) {
            this.f16297a = coverPhotoSelector;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f16297a.f16306e = true;
            this.f16297a.f16314m.m16774c();
            return true;
        }
    }

    private static <T extends View> void m16778a(Class<T> cls, T t) {
        m16779a((Object) t, t.getContext());
    }

    private static void m16779a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CoverPhotoSelector) obj).m16776a(ActivityMethodAutoProvider.b(fbInjector), InterstitialManager.a(fbInjector), TipSeenTracker.b(fbInjector), CoverPhotoActivitiesLauncher.m16772b(fbInjector));
    }

    public CoverPhotoSelector(Context context) {
        super(context);
        m16777a(context);
    }

    public CoverPhotoSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16777a(context);
    }

    public CoverPhotoSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16777a(context);
    }

    @Inject
    private void m16776a(Activity activity, InterstitialManager interstitialManager, TipSeenTracker tipSeenTracker, CoverPhotoActivitiesLauncher coverPhotoActivitiesLauncher) {
        this.f16307f = activity;
        this.f16311j = interstitialManager;
        this.f16312k = tipSeenTracker;
        this.f16314m = coverPhotoActivitiesLauncher;
    }

    public void setEventCompositionModel(EventCompositionModel eventCompositionModel) {
        this.f16302a = eventCompositionModel;
        this.f16314m.f16293d = this.f16302a;
    }

    private static void m16777a(Context context) {
        Resources resources = context.getResources();
        f16300o = resources.getDimensionPixelSize(2131431093);
        f16301p = (int) ((((double) resources.getDisplayMetrics().widthPixels) / 1.78d) + ((double) f16300o));
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 996114469);
        super.onFinishInflate();
        m16778a(CoverPhotoSelector.class, (View) this);
        setFocusable(false);
        setOnClickListener(this);
        setContentDescription(getResources().getString(2131236912));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1795010090, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1044432493);
        super.onAttachedToWindow();
        this.f16312k.b = 2;
        this.f16312k.a(EventsPrefKeys.f19009c);
        if (this.f16312k.c() && m16785g() && !this.f16315n && this.f16310i) {
            this.f16313l = new Tooltip(this.f16307f, 2);
            this.f16313l.b(getResources().getString(2131236911));
            this.f16313l.a(Position.BELOW);
            this.f16313l.t = -1;
            this.f16313l.f(this);
            this.f16315n = true;
            this.f16312k.a();
            this.f16311j.a().a("3819");
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -775877372, a);
    }

    private boolean m16785g() {
        CoverPhotoSelectorThemeInterstitialController coverPhotoSelectorThemeInterstitialController = (CoverPhotoSelectorThemeInterstitialController) this.f16311j.a(CoverPhotoSelectorThemeInterstitialController.a, CoverPhotoSelectorThemeInterstitialController.class);
        return coverPhotoSelectorThemeInterstitialController != null && Objects.equal(coverPhotoSelectorThemeInterstitialController.b(), "3819");
    }

    public void setCoverPhotoRemovedListener(CoverPhotoRemovedListener coverPhotoRemovedListener) {
        this.f16308g = coverPhotoRemovedListener;
    }

    public final void m16790a(boolean z) {
        this.f16309h = z;
    }

    public void setShowAdvancedCoverPhotoOptions(boolean z) {
        this.f16310i = z;
    }

    public final void m16792a(boolean z, boolean z2) {
        if (!z2) {
            if (z) {
                this.f16309h = true;
                ((LayoutParams) getLayoutParams()).topMargin = f16301p;
                return;
            }
            this.f16309h = false;
            ((LayoutParams) getLayoutParams()).topMargin = f16300o;
        }
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -777257622);
        this.f16303b = true;
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        if (this.f16310i) {
            c.a(getContext().getString(2131236917)).setOnMenuItemClickListener(m16789k());
        }
        c.a(getContext().getString(2131236913)).setOnMenuItemClickListener(m16787i());
        c.a(getContext().getString(2131236916)).setOnMenuItemClickListener(m16788j());
        if (this.f16309h) {
            c.a(getContext().getString(2131236915)).setOnMenuItemClickListener(m16786h());
        }
        figPopoverMenuWindow.a(this);
        Logger.a(2, EntryType.UI_INPUT_END, -1592588547, a);
    }

    private OnMenuItemClickListener m16786h() {
        return new C22731(this);
    }

    private OnMenuItemClickListener m16787i() {
        return new C22742(this);
    }

    private OnMenuItemClickListener m16788j() {
        return new C22753(this);
    }

    private OnMenuItemClickListener m16789k() {
        return new C22764(this);
    }

    public final boolean m16793a() {
        return this.f16303b;
    }

    public final boolean m16794b() {
        return this.f16304c;
    }

    public final boolean m16795e() {
        return this.f16305d;
    }

    public final boolean m16796f() {
        return this.f16306e;
    }

    private ObjectAnimator m16781b(boolean z) {
        float f = z ? (float) f16301p : (float) f16300o;
        float f2 = z ? (float) f16300o : (float) f16301p;
        return ObjectAnimator.ofFloat(this, "y", new float[]{f, f2});
    }

    public final void m16791a(final boolean z, int i) {
        m16781b(z).start();
        ObjectAnimator b = m16781b(z);
        b.setDuration((long) i);
        b.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ CoverPhotoSelector f16299b;

            public void onAnimationStart(Animator animator) {
                if (z) {
                    this.f16299b.f16309h = false;
                } else {
                    this.f16299b.f16309h = true;
                }
            }
        });
        b.start();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Parcelable bundle = new Bundle();
        bundle.putParcelable("coverPhotoSelectorSuperState", onSaveInstanceState);
        bundle.putBoolean("showRemoveButton", this.f16309h);
        bundle.putBoolean("hasClickedOnCoverPhotoSelector", this.f16303b);
        bundle.putBoolean("hasClickedOnCoverPhotoUpload", this.f16304c);
        bundle.putBoolean("hasClickedOnCoverPhotoFbAlbum", this.f16305d);
        bundle.putBoolean("hasClickedOnCoverPhotoThemes", this.f16306e);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("coverPhotoSelectorSuperState"));
        this.f16309h = bundle.getBoolean("showRemoveButton");
        this.f16303b = bundle.getBoolean("hasClickedOnCoverPhotoSelector");
        this.f16304c = bundle.getBoolean("hasClickedOnCoverPhotoUpload");
        this.f16305d = bundle.getBoolean("hasClickedOnCoverPhotoFbAlbum");
        this.f16306e = bundle.getBoolean("hasClickedOnCoverPhotoThemes");
    }
}
