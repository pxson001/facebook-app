package com.facebook.photos.dialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.util.CachedDrawableProvider;
import com.facebook.photos.dialog.clipping.ClipAnimationListener;
import com.facebook.photos.dialog.clipping.ClippingImageView;
import com.facebook.photos.dialog.util.PhotosBackPressController;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil.FragmentPerfMarkerConfig;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ufi/reactions/v2/face_models/sad */
public class PhotoAnimationDialogFragment extends FbDialogFragment implements AnalyticsFragment {
    private static final Object aA = new Object();
    private static long aB = 0;
    public static final String am = (PhotoAnimationDialogFragment.class.getSimpleName() + "_PHOTOS_FEED");
    public static final String an = (PhotoAnimationDialogFragment.class.getSimpleName() + "_MEDIA_GALLERY");
    public static final String ao = (PhotoAnimationDialogFragment.class.getSimpleName() + "_PHOTOS_PRIVACY_FEED");
    public static final String ap = (PhotoAnimationDialogFragment.class.getSimpleName() + "_SOUVENIRS");
    public static final String aq = (PhotoAnimationDialogFragment.class.getSimpleName() + "_SPHERICAL_PHOTOS");
    public static final String az = PhotoAnimationDialogFragment.class.getSimpleName();
    public Throwable aC;
    public FrameLayout aD;
    public View aE;
    public ClippingImageView aF;
    public DismissibleFrameLayout aG;
    public FrameLayout aH;
    @Nullable
    private PhotoAnimationDialogLaunchParams aI;
    @Nullable
    private AnimationParamProvider aJ;
    @Nullable
    public PhotoAnimationContentFragment aK;
    @Nullable
    private OnDismissListener aL;
    private Direction aM;
    private int aN;
    private int aO;
    private boolean aP;
    private String aQ;
    public VisibilityAnimator aR;
    private Optional<ObjectAnimator> aS = Absent.INSTANCE;
    private final ClipAnimationListener aT = new ShowAnimationListener(this);
    private final ClipAnimationListener aU = new DismissAnimationListener(this);
    public State aV = State.INIT;
    public boolean aW;
    public ValueAnimator aX;
    @Inject
    ViewHelperViewAnimatorFactory ar;
    @Inject
    CachedDrawableProvider as;
    @Inject
    PhotosDialogPerfUtil at;
    @Inject
    public Lazy<NavigationLogger> au;
    @Inject
    ConsumptionPhotoEventBus av;
    @Inject
    Lazy<FbErrorReporter> aw;
    @Inject
    ViewHelperViewAnimatorFactory ax;
    @Inject
    PhotosBackPressController ay;

    public static void m61a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoAnimationDialogFragment) obj).m60a(ViewHelperViewAnimatorFactory.a(fbInjector), CachedDrawableProvider.b(fbInjector), PhotosDialogPerfUtil.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137), ConsumptionPhotoEventBus.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), ViewHelperViewAnimatorFactory.a(fbInjector), PhotosBackPressController.a(fbInjector));
    }

    private void m60a(ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory, CachedDrawableProvider cachedDrawableProvider, PhotosDialogPerfUtil photosDialogPerfUtil, Lazy<NavigationLogger> lazy, ConsumptionPhotoEventBus consumptionPhotoEventBus, Lazy<FbErrorReporter> lazy2, ViewAnimatorFactory viewAnimatorFactory, PhotosBackPressController photosBackPressController) {
        this.ar = viewHelperViewAnimatorFactory;
        this.as = cachedDrawableProvider;
        this.at = photosDialogPerfUtil;
        this.au = lazy;
        this.av = consumptionPhotoEventBus;
        this.aw = lazy2;
        this.ax = viewAnimatorFactory;
        this.ay = photosBackPressController;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m62a(android.content.Context r10, com.facebook.photos.dialog.PhotoAnimationContentFragment r11, @javax.annotation.Nullable com.facebook.photos.dialog.PhotoAnimationDialogLaunchParams r12, @javax.annotation.Nullable com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider r13, @javax.annotation.Nullable android.content.DialogInterface.OnDismissListener r14) {
        /*
        r2 = 0;
        r1 = aA;
        monitor-enter(r1);
        r0 = com.facebook.common.time.AwakeTimeSinceBootClock.get();	 Catch:{ all -> 0x0039 }
        r4 = r0.now();	 Catch:{ all -> 0x0039 }
        r6 = aB;	 Catch:{ all -> 0x0039 }
        r6 = r4 - r6;
        r8 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x0019;
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r0 = r2;
    L_0x0018:
        return r0;
    L_0x0019:
        aB = r4;	 Catch:{ all -> 0x0039 }
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r3 = r11.as();
        r0 = com.facebook.base.fragment.FragmentManagerHost.class;
        r0 = com.facebook.common.util.ContextUtils.a(r10, r0);
        r0 = (com.facebook.base.fragment.FragmentManagerHost) r0;
        r1 = "MediaGallery needs FragmentManager to be supported on it's launch-site";
        com.google.common.base.Preconditions.checkNotNull(r0, r1);
        r1 = r0.kO_();
        r1 = r1.a(r3);
        if (r1 == 0) goto L_0x003c;
    L_0x0037:
        r0 = r2;
        goto L_0x0018;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x003c:
        r1 = r0.kO_();
        r1 = r1.c();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        r0 = r2;
        goto L_0x0018;
    L_0x0048:
        r1 = android.app.Activity.class;
        r1 = com.facebook.common.util.ContextUtils.a(r10, r1);
        r1 = (android.app.Activity) r1;
        if (r1 == 0) goto L_0x005a;
    L_0x0052:
        r1 = r1.isFinishing();
        if (r1 == 0) goto L_0x005a;
    L_0x0058:
        r0 = r2;
        goto L_0x0018;
    L_0x005a:
        r2 = new com.facebook.photos.dialog.PhotoAnimationDialogFragment;
        r2.<init>();
        r2.m58a(r11, r12, r13, r14);
        r4 = new android.os.Bundle;
        r4.<init>();
        r1 = "EXTRA_LAUNCH_TIMESTAMP";
        r5 = com.facebook.common.time.AwakeTimeSinceBootClock.get();
        r6 = r5.now();
        r4.putLong(r1, r6);
        r1 = "EXTRA_DEFAULT_DISMISS_DIRECTION";
        r5 = r12.e;
        r5 = r5.name();
        r4.putString(r1, r5);
        r1 = "EXTRA_SWIPE_DISMISS_DIRECTION_FLAGS";
        r5 = r12.f;
        r4.putInt(r1, r5);
        r1 = "EXTRA_BACKGROUND_COLOR";
        r5 = r12.g;
        r4.putInt(r1, r5);
        r1 = "EXTRA_ENABLE_SWIPE_TO_DISMISS";
        r5 = r12.h;
        r4.putBoolean(r1, r5);
        r5 = "EXTRA_ANALYTICS_TAG";
        r1 = r11 instanceof com.facebook.analytics.tagging.AnalyticsFragment;
        if (r1 == 0) goto L_0x00b7;
    L_0x009a:
        r11 = (com.facebook.analytics.tagging.AnalyticsFragment) r11;
        r1 = r11.am_();
    L_0x00a0:
        r4.putString(r5, r1);
        r2.g(r4);
        r1 = r0.kO_();
        r2.a(r1, r3);
        r0 = r0.kO_();
        r0.b();
        r0 = 1;
        goto L_0x0018;
    L_0x00b7:
        r1 = "unknown";
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.dialog.PhotoAnimationDialogFragment.a(android.content.Context, com.facebook.photos.dialog.PhotoAnimationContentFragment, com.facebook.photos.dialog.PhotoAnimationDialogLaunchParams, com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider, android.content.DialogInterface$OnDismissListener):boolean");
    }

    public final void mo1a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1451544287);
        super.mo1a(bundle);
        Class cls = PhotoAnimationDialogFragment.class;
        m61a((Object) this, getContext());
        if (bundle == null) {
            if (this.aK != null) {
                FullscreenGallerySource fullscreenGallerySource;
                String uuid;
                PhotosDialogPerfUtil photosDialogPerfUtil = this.at;
                if (this.aI == null) {
                    fullscreenGallerySource = null;
                } else {
                    fullscreenGallerySource = this.aI.d;
                }
                FragmentPerfMarkerConfig at = this.aK.at();
                if (this.aI == null || this.aI.a == null) {
                    uuid = SafeUUIDGenerator.a().toString();
                } else {
                    uuid = this.aI.a;
                }
                photosDialogPerfUtil.a(fullscreenGallerySource, at, uuid, this.s.getLong("EXTRA_LAUNCH_TIMESTAMP"));
            } else {
                ((AbstractFbErrorReporter) this.aw.get()).a(az, "content fragment is null, gallery source is " + (this.aI == null ? "null" : this.aI.d.referrer));
            }
        }
        if (bundle == null) {
            bundle = this.s;
        }
        this.aM = Direction.valueOf(bundle.getString("EXTRA_DEFAULT_DISMISS_DIRECTION"));
        this.aN = bundle.getInt("EXTRA_SWIPE_DISMISS_DIRECTION_FLAGS");
        this.aQ = bundle.getString("EXTRA_ANALYTICS_TAG");
        this.aP = bundle.getBoolean("EXTRA_ENABLE_SWIPE_TO_DISMISS");
        this.aO = bundle.getInt("EXTRA_BACKGROUND_COLOR");
        ((NavigationLogger) this.au.get()).a("tap_photo");
        LogUtils.f(2111536927, a);
    }

    public final View m70a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1224330858);
        View inflate = layoutInflater.inflate(2130905167, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 531215415, a);
        return inflate;
    }

    public final void mo2a(View view, Bundle bundle) {
        super.mo2a(view, bundle);
        this.aD = (FrameLayout) view.findViewById(2131563679);
        this.aF = (ClippingImageView) view.findViewById(2131563680);
        this.aH = (FrameLayout) view.findViewById(2131563682);
        this.aR = new VisibilityAnimator(this.aH, 200, false, this.ax);
        this.aG = (DismissibleFrameLayout) view.findViewById(2131563681);
        this.aG.l = false;
        DismissableFrameListener dismissableFrameListener = new DismissableFrameListener(this);
        this.aG.e = dismissableFrameListener;
        this.aG.g = dismissableFrameListener;
        this.aG.f = dismissableFrameListener;
        this.aG.h = dismissableFrameListener;
        if (this.aP) {
            this.aG.setDirectionFlags(this.aN);
        }
        this.aE = view.findViewById(2131560476);
        CustomViewUtils.b(this.aE, new ColorDrawable(this.aO));
        if (bundle != null) {
            this.aE.setAlpha(1.0f);
            this.aK = (PhotoAnimationContentFragment) s().a(2131563682);
            if (this.aK == null) {
                ((AbstractFbErrorReporter) this.aw.get()).b(az, "onCreate(): Content fragment when savedInstanceState is non-null");
                return;
            }
            return;
        }
        this.aK.a(av());
        aE();
    }

    public final void m74d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -891379611);
        Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        if (activity == null || !activity.isFinishing()) {
            super.d(bundle);
            LogUtils.f(-429028372, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -790754697, a);
    }

    public final void m75e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("EXTRA_DEFAULT_DISMISS_DIRECTION", this.aM.name());
        bundle.putInt("EXTRA_SWIPE_DISMISS_DIRECTION_FLAGS", this.aN);
        bundle.putString("EXTRA_ANALYTICS_TAG", this.aQ);
        bundle.putInt("EXTRA_BACKGROUND_COLOR", this.aO);
    }

    public final void m76h(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1305546087);
        super.h(bundle);
        if (bundle != null) {
            ay();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -633993688, a);
    }

    public final void m69H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 381511261);
        super.H();
        this.aG.l = false;
        this.aG.e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 586597763, a);
    }

    public final void m68G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1904063670);
        super.G();
        PhotoAnimationContentFragment photoAnimationContentFragment = (PhotoAnimationContentFragment) s().a(2131563682);
        if (this.aV == State.NORMAL) {
            if (photoAnimationContentFragment == null) {
                a();
            } else {
                photoAnimationContentFragment.a(av());
                if (this.aH.getVisibility() == 0) {
                    boolean z;
                    DismissibleFrameLayout dismissibleFrameLayout = this.aG;
                    if (this.aP) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dismissibleFrameLayout.l = z;
                }
            }
        }
        LogUtils.f(1410215546, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 328184538);
        if (this.aV == State.ANIMATE_IN) {
            ax();
        }
        if (this.aS.isPresent()) {
            ((ObjectAnimator) this.aS.get()).removeListener(this.aU);
        }
        this.aF.c.a();
        this.aF.setDrawable(null);
        az(this);
        if (this.aK != null) {
            this.aK.a(null);
        }
        this.aK = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1483234138, a);
    }

    public final String am_() {
        return this.aQ;
    }

    public final Dialog mo3c(Bundle bundle) {
        return new HelperDialog(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.aL != null) {
            this.aL.onDismiss(dialogInterface);
        }
    }

    private void m58a(PhotoAnimationContentFragment photoAnimationContentFragment, PhotoAnimationDialogLaunchParams photoAnimationDialogLaunchParams, @Nullable AnimationParamProvider animationParamProvider, @Nullable OnDismissListener onDismissListener) {
        this.aK = photoAnimationContentFragment;
        this.aI = photoAnimationDialogLaunchParams;
        this.aJ = animationParamProvider;
        this.aL = onDismissListener;
    }

    public static void m66h(PhotoAnimationDialogFragment photoAnimationDialogFragment, boolean z) {
        Preconditions.checkState(State.isSwiping(photoAnimationDialogFragment.aV));
        photoAnimationDialogFragment.aC = new Throwable();
        if (photoAnimationDialogFragment.aV == State.SWIPING_FRAME) {
            if (z) {
                photoAnimationDialogFragment.aH.setBackgroundDrawable(null);
                photoAnimationDialogFragment.aE.setAlpha(1.0f);
            }
            photoAnimationDialogFragment.aV = State.NORMAL;
            return;
        }
        photoAnimationDialogFragment.aF.setVisibility(8);
        photoAnimationDialogFragment.aG.removeView(photoAnimationDialogFragment.aF);
        photoAnimationDialogFragment.aD.addView(photoAnimationDialogFragment.aF, 1);
        if (z) {
            photoAnimationDialogFragment.aG.g();
            photoAnimationDialogFragment.aG.a(false);
        }
        photoAnimationDialogFragment.aR.a(false);
        photoAnimationDialogFragment.aV = State.NORMAL;
    }

    public static void m67i(PhotoAnimationDialogFragment photoAnimationDialogFragment, boolean z) {
        Preconditions.checkState(photoAnimationDialogFragment.aV == State.INIT);
        if (photoAnimationDialogFragment.aI == null || photoAnimationDialogFragment.aI.b == null || photoAnimationDialogFragment.aJ == null || z) {
            photoAnimationDialogFragment.at();
            photoAnimationDialogFragment.aK.a(photoAnimationDialogFragment.av, true, aD(photoAnimationDialogFragment));
            return;
        }
        AnimationParams a = photoAnimationDialogFragment.aJ.a(photoAnimationDialogFragment.aI.b);
        if (a == null || a.a == null) {
            photoAnimationDialogFragment.at();
            photoAnimationDialogFragment.aK.a(photoAnimationDialogFragment.av, true, aD(photoAnimationDialogFragment));
            return;
        }
        Drawable a2 = photoAnimationDialogFragment.as.a(a.a);
        if (a2 == null) {
            photoAnimationDialogFragment.at();
            photoAnimationDialogFragment.aK.a(photoAnimationDialogFragment.av, true, aD(photoAnimationDialogFragment));
            return;
        }
        DrawingRule a3 = photoAnimationDialogFragment.aK.a(a2, photoAnimationDialogFragment.aF());
        if (a3 == null) {
            photoAnimationDialogFragment.at();
            photoAnimationDialogFragment.aK.a(photoAnimationDialogFragment.av, true, aD(photoAnimationDialogFragment));
            return;
        }
        photoAnimationDialogFragment.aV = State.ANIMATE_IN;
        photoAnimationDialogFragment.aF.setVisibility(0);
        photoAnimationDialogFragment.aF.c.a(a2, a.b, a3, photoAnimationDialogFragment.aT);
        photoAnimationDialogFragment.aE.setLayerType(2, null);
        ViewHelperViewAnimator a4 = photoAnimationDialogFragment.ar.a(photoAnimationDialogFragment.aE);
        a4.a(100);
        a4.e(0.0f);
        a4.f(1.0f);
    }

    private void at() {
        this.aM = Direction.DOWN;
        this.aG.setDirectionFlags(this.aM.flag());
        au();
        if (!this.aK.ar() || this.aW) {
            ay();
        }
        this.aV = State.ANIMATE_IN;
        this.aG.l = false;
        int i = jW_().getDisplayMetrics().heightPixels;
        this.aX = ObjectAnimator.ofFloat(this.aH, "translationY", new float[]{(float) i, 0.0f});
        this.aX.setDuration(250);
        this.aX.addListener(new 1(this));
        this.aX.start();
        this.aE.setLayerType(2, null);
        ViewHelperViewAnimator a = this.ar.a(this.aE);
        a.a(250);
        a.e(0.0f);
        a.f(1.0f);
    }

    public static boolean m63a(@Nullable PhotoAnimationDialogFragment photoAnimationDialogFragment, @Nullable Drawable[] drawableArr, DrawingRule[] drawingRuleArr) {
        String str;
        if (photoAnimationDialogFragment.aK == null) {
            str = null;
        } else {
            str = photoAnimationDialogFragment.aK.e();
        }
        String str2 = str;
        if (str2 == null || photoAnimationDialogFragment.aJ == null) {
            return false;
        }
        AnimationParams a = photoAnimationDialogFragment.aJ.a(str2);
        if (a == null || a.a == null) {
            return false;
        }
        Drawable a2 = photoAnimationDialogFragment.as.a(a.a);
        if (a2 == null) {
            return false;
        }
        if (drawableArr != null) {
            drawableArr[0] = a2;
        }
        if (drawingRuleArr != null) {
            drawingRuleArr[0] = a.b;
        }
        return true;
    }

    private void m57a(float f) {
        Preconditions.checkState(this.aV != State.ANIMATE_OUT);
        this.aV = State.ANIMATE_OUT;
        this.aG.l = false;
        Drawable[] drawableArr = new Drawable[1];
        DrawingRule[] drawingRuleArr = new DrawingRule[1];
        if (m63a(this, drawableArr, drawingRuleArr)) {
            Object obj;
            DrawingRule c;
            this.aH.setVisibility(8);
            this.aF.setVisibility(0);
            if (this.aF.c.d != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                c = this.aF.c.c();
            } else {
                c = this.aK.a(drawableArr[0], aF());
            }
            if (c == null) {
                m64b(f);
                return;
            }
            this.aF.c.a(drawableArr[0], c, drawingRuleArr[0], this.aU);
            ViewHelperViewAnimator a = this.ar.a(this.aE);
            a.a(100);
            a.e(f);
            a.f(0.0f);
            return;
        }
        m64b(f);
    }

    private void m64b(float f) {
        ObjectAnimator ofFloat;
        int width;
        switch (5.a[this.aM.ordinal()]) {
            case 1:
                width = this.aH.getWidth();
                ofFloat = ObjectAnimator.ofFloat(this.aH, "translationX", new float[]{0.0f, (float) (-width)});
                break;
            case 2:
                width = this.aH.getWidth();
                ofFloat = ObjectAnimator.ofFloat(this.aH, "translationX", new float[]{0.0f, (float) width});
                break;
            case 3:
                width = this.aH.getHeight();
                ofFloat = ObjectAnimator.ofFloat(this.aH, "translationY", new float[]{0.0f, (float) (-width)});
                break;
            default:
                width = this.aH.getHeight();
                ofFloat = ObjectAnimator.ofFloat(this.aH, "translationY", new float[]{0.0f, (float) width});
                break;
        }
        this.aS = Optional.of(ofFloat);
        ((ObjectAnimator) this.aS.get()).setDuration(250);
        ((ObjectAnimator) this.aS.get()).addListener(this.aU);
        ((ObjectAnimator) this.aS.get()).start();
        ViewHelperViewAnimator a = this.ar.a(this.aE);
        a.a(250);
        a.e(f);
        a.f(0.0f);
    }

    private void au() {
        if (!this.aK.mx_()) {
            PhotosDialogPerfUtil photosDialogPerfUtil = this.at;
            String simpleName = this.aK.getClass().getSimpleName();
            if (photosDialogPerfUtil.h) {
                photosDialogPerfUtil.b.o(simpleName);
                photosDialogPerfUtil.c.b("Fragment");
            }
            s().a().b(2131563682, this.aK).c();
            s().b();
            photosDialogPerfUtil = this.at;
            simpleName = this.aK.getClass().getSimpleName();
            if (photosDialogPerfUtil.h) {
                photosDialogPerfUtil.b.p(simpleName);
                photosDialogPerfUtil.c.d("Fragment");
            }
        }
    }

    private 2 av() {
        return new 2(this);
    }

    private void ax() {
        if (this.aK != null) {
            this.aK.a(this.av, false, aD(this));
            this.aK.aq();
            this.aK.a(null);
            this.aK = null;
        }
        this.aF.c.a();
        az(this);
    }

    private void ay() {
        boolean z = false;
        this.aV = State.NORMAL;
        this.aH.setVisibility(0);
        DismissibleFrameLayout dismissibleFrameLayout = this.aG;
        if (this.aP) {
            z = true;
        }
        dismissibleFrameLayout.l = z;
    }

    public static void az(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        if (photoAnimationDialogFragment.aX != null) {
            photoAnimationDialogFragment.aX.removeAllListeners();
            photoAnimationDialogFragment.aX.removeAllUpdateListeners();
            photoAnimationDialogFragment.aX.cancel();
            photoAnimationDialogFragment.aX = null;
        }
    }

    public static void aA(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        photoAnimationDialogFragment.at.d();
        photoAnimationDialogFragment.au();
        photoAnimationDialogFragment.aV = State.ANIMATE_WAIT;
        if (!photoAnimationDialogFragment.aK.ar() || photoAnimationDialogFragment.aW) {
            aB(photoAnimationDialogFragment);
        }
    }

    public static void aB(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        photoAnimationDialogFragment.ay();
        photoAnimationDialogFragment.aF.setVisibility(8);
        photoAnimationDialogFragment.C();
    }

    public static void aC(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        if (photoAnimationDialogFragment.aV == State.ANIMATE_OUT || State.isSwiping(photoAnimationDialogFragment.aV)) {
            ((AbstractFbErrorReporter) photoAnimationDialogFragment.aw.get()).a(az, "maybeDismiss: unexpected state " + photoAnimationDialogFragment.aV);
            if (photoAnimationDialogFragment.aK != null) {
                photoAnimationDialogFragment.aK.a(photoAnimationDialogFragment.av, false, aD(photoAnimationDialogFragment));
            }
            photoAnimationDialogFragment.b();
            return;
        }
        if (photoAnimationDialogFragment.aV == State.ANIMATE_IN) {
            photoAnimationDialogFragment.ax();
        }
        photoAnimationDialogFragment.m57a(1.0f);
    }

    public static int aD(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        return photoAnimationDialogFragment.aI == null ? -1 : photoAnimationDialogFragment.aI.c;
    }

    private void aE() {
        if (this.aK.a(new 3(this))) {
            au();
        } else {
            this.aF.getViewTreeObserver().addOnGlobalLayoutListener(new 4(this));
        }
    }

    private Rect aF() {
        int[] iArr = new int[2];
        this.aF.getLocationOnScreen(iArr);
        return new Rect(0, iArr[1] - this.aG.getScrollY(), this.aF.getMeasuredWidth(), (iArr[1] + this.aF.getMeasuredHeight()) - this.aG.getScrollY());
    }
}
