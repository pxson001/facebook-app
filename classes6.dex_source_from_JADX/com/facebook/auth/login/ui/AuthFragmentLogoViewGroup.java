package com.facebook.auth.login.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FragmentActionBuilder;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.common.ui.util.DynamicLayoutUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: profile_experience_picker */
public abstract class AuthFragmentLogoViewGroup<T extends AuthFragmentControlBase> extends AuthFragmentViewGroup<T> {
    private final View mBottomGroup = getView(2131561799);
    @Inject
    public DynamicLayoutUtil mDynamicLayoutUtil;
    private final int mEnterTransitionAnimation;
    private final int mExitTransitionAnimation;
    public final ImageButton mHelpButton = ((ImageButton) getView(2131564883));
    public final boolean mHideLogoOnSmallDisplays;
    private final LayoutDelegateBase mLayoutDelegate;
    public final int mLogo1ResId = getResourceArgument("orca:authparam:logo1", 0);
    public final ImageView mLogo1View = ((ImageView) getView(2131564876));
    public final int mLogo2ResId = getResourceArgument("orca:authparam:logo2", 0);
    public final ImageView mLogo2View = ((ImageView) getView(2131564877));
    public final View mLogoGroup = getView(2131564875);
    private final View mMainGroup = getView(2131561786);
    private final int mPopEnterTransitionAnimation;
    private final int mPopExitTransitionAnimation;
    public final View mRootGroup = getView(2131561772);
    public final View mSplashGroup = getView(2131561802);
    public int mSplashLogo1ResId = getResourceArgument("orca:authparam:spash_logo1", 0);
    public final ImageView mSplashLogo1View = ((ImageView) getView(2131564873));
    public int mSplashLogo2ResId = getResourceArgument("orca:authparam:spash_logo2", 0);
    public final ImageView mSplashLogo2View = ((ImageView) getView(2131564874));

    /* compiled from: profile_experience_picker */
    interface LayoutDelegateBase {
        void mo906a();

        void mo907b();
    }

    /* compiled from: profile_experience_picker */
    class LegacyLayoutDelegate implements LayoutDelegateBase {
        final /* synthetic */ AuthFragmentLogoViewGroup f7369a;

        public LegacyLayoutDelegate(AuthFragmentLogoViewGroup authFragmentLogoViewGroup) {
            this.f7369a = authFragmentLogoViewGroup;
        }

        public final void mo906a() {
        }

        public final void mo907b() {
        }
    }

    /* compiled from: profile_experience_picker */
    public class ModernLayoutDelegate implements LayoutDelegateBase {
        public final /* synthetic */ AuthFragmentLogoViewGroup f7375a;

        /* compiled from: profile_experience_picker */
        class C04321 implements OnClickListener {
            final /* synthetic */ ModernLayoutDelegate f7370a;

            C04321(ModernLayoutDelegate modernLayoutDelegate) {
                this.f7370a = modernLayoutDelegate;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -873111666);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f7370a.f7375a.getArguments().getString("orca:authparam:help_url")));
                Logger.a(2, EntryType.UI_INPUT_END, -2082074541, a);
            }
        }

        /* compiled from: profile_experience_picker */
        class C04332 implements Runnable {
            final /* synthetic */ ModernLayoutDelegate f7371a;

            C04332(ModernLayoutDelegate modernLayoutDelegate) {
                this.f7371a = modernLayoutDelegate;
            }

            public void run() {
                Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(125);
                this.f7371a.f7375a.mRootGroup.setVisibility(0);
                this.f7371a.f7375a.mRootGroup.startAnimation(alphaAnimation);
            }
        }

        public ModernLayoutDelegate(AuthFragmentLogoViewGroup authFragmentLogoViewGroup) {
            this.f7375a = authFragmentLogoViewGroup;
        }

        public final void mo906a() {
            m10481c();
            if (this.f7375a.getArguments().getString("orca:authparam:help_url") != null) {
                this.f7375a.mHelpButton.setVisibility(0);
            }
            this.f7375a.mHelpButton.setOnClickListener(new C04321(this));
            SplashTransition splashTransition = (SplashTransition) this.f7375a.getArguments().getSerializable("orca:authparam:splash_transition");
            if (!this.f7375a.control.m10473b()) {
                splashTransition = SplashTransition.NONE;
            }
            switch (splashTransition) {
                case NONE:
                    this.f7375a.mLogo1View.setImageResource(this.f7375a.mLogo1ResId);
                    this.f7375a.mLogo2View.setImageResource(this.f7375a.mLogo2ResId);
                    this.f7375a.mSplashGroup.setVisibility(8);
                    this.f7375a.mRootGroup.setVisibility(0);
                    this.f7375a.mLogoGroup.setVisibility(0);
                    return;
                case LOGO_SLIDE:
                    m10482e();
                    return;
                default:
                    return;
            }
        }

        public final void mo907b() {
            m10481c();
        }

        private void m10481c() {
            LinearLayout linearLayout = (LinearLayout) this.f7375a.mLogoGroup;
            LinearLayout linearLayout2 = (LinearLayout) this.f7375a.mSplashGroup;
            DisplayMetrics displayMetrics = this.f7375a.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                linearLayout.setOrientation(1);
                linearLayout2.setOrientation(1);
                return;
            }
            linearLayout.setOrientation(0);
            linearLayout2.setOrientation(0);
        }

        private void m10482e() {
            final Runnable c04332 = new C04332(this);
            Bitmap[] a = m10480a(this.f7375a.mSplashLogo1ResId, this.f7375a.mLogo1ResId);
            Bitmap[] a2 = m10480a(this.f7375a.mSplashLogo2ResId, this.f7375a.mLogo2ResId);
            Runnable c04353 = new Runnable(this) {
                final /* synthetic */ ModernLayoutDelegate f7374b;

                /* compiled from: profile_experience_picker */
                class C04341 extends BaseAnimationListener {
                    final /* synthetic */ C04353 f7372a;

                    C04341(C04353 c04353) {
                        this.f7372a = c04353;
                    }

                    public void onAnimationEnd(Animation animation) {
                        this.f7372a.f7374b.f7375a.mSplashGroup.setVisibility(8);
                        this.f7372a.f7374b.f7375a.mLogoGroup.setVisibility(0);
                    }
                }

                public void run() {
                    Animation a = ModernLayoutDelegate.m10478a(this.f7374b.f7375a.mSplashLogo1View, this.f7374b.f7375a.mLogo1View);
                    Animation a2 = ModernLayoutDelegate.m10478a(this.f7374b.f7375a.mSplashLogo2View, this.f7374b.f7375a.mLogo2View);
                    a.setDuration(500);
                    a2.setDuration(500);
                    a.setAnimationListener(new C04341(this));
                    this.f7374b.f7375a.mSplashLogo1View.startAnimation(a);
                    this.f7374b.f7375a.mSplashLogo2View.startAnimation(a2);
                    this.f7374b.f7375a.postDelayed(c04332, 375);
                }
            };
            this.f7375a.mSplashLogo1View.setImageBitmap(a[0]);
            this.f7375a.mSplashLogo2View.setImageBitmap(a2[0]);
            this.f7375a.mLogo1View.setImageBitmap(a[1]);
            this.f7375a.mLogo2View.setImageBitmap(a2[1]);
            this.f7375a.postDelayed(c04353, 200);
        }

        private Bitmap[] m10480a(int i, int i2) {
            Bitmap[] bitmapArr = new Bitmap[]{null, null};
            if (i != 0) {
                bitmapArr[0] = FbBitmapFactory.a(this.f7375a.getResources(), i);
            }
            if (i2 == i) {
                bitmapArr[1] = bitmapArr[0];
            } else if (i2 != 0) {
                bitmapArr[1] = FbBitmapFactory.a(this.f7375a.getResources(), i2);
            }
            return bitmapArr;
        }

        private static AnimationSet m10478a(View view, View view2) {
            int[] iArr = new int[]{0, 0, 0, 0};
            view.getLocationInWindow(iArr);
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
            int[] iArr2 = new int[]{0, 0, 0, 0};
            view2.getLocationInWindow(iArr2);
            iArr2[2] = view2.getWidth();
            iArr2[3] = view2.getHeight();
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new ScaleAnimation(1.0f, ((float) iArr2[2]) / ((float) iArr[2]), 1.0f, ((float) iArr2[3]) / ((float) iArr[3])));
            animationSet.addAnimation(new TranslateAnimation(0.0f, (float) (iArr2[0] - iArr[0]), 0.0f, (float) (iArr2[1] - iArr[1])));
            return animationSet;
        }
    }

    /* compiled from: profile_experience_picker */
    public enum SplashTransition {
        NONE,
        LOGO_SLIDE
    }

    protected abstract int getDefaultLayoutResource();

    void $ul_injectMe(DynamicLayoutUtil dynamicLayoutUtil) {
        this.mDynamicLayoutUtil = dynamicLayoutUtil;
    }

    public static Bundle createParameterBundle(int i, int i2, int i3) {
        return createParameterBundle(i, i2, i3, 0, 0, SplashTransition.NONE, null);
    }

    public static Bundle createParameterBundle(int i, int i2, int i3, boolean z) {
        return createParameterBundle(i, i2, i3, 0, 0, SplashTransition.NONE, 0, 0, 0, 0, z, null);
    }

    public static Bundle createParameterBundle(int i, int i2, int i3, String str) {
        return createParameterBundle(i, i2, i3, 0, 0, SplashTransition.NONE, str);
    }

    public static Bundle createParameterBundle(int i, int i2, int i3, int i4, int i5, SplashTransition splashTransition, String str) {
        return createParameterBundle(i, i2, i3, i4, i5, splashTransition, 0, 0, 0, 0, false, str);
    }

    public static Bundle createParameterBundle(int i, int i2, int i3, int i4, int i5, SplashTransition splashTransition, int i6, int i7, int i8, int i9, boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("orca:authparam:layout_resource", i);
        bundle.putInt("orca:authparam:logo1", i2);
        bundle.putInt("orca:authparam:logo2", i3);
        bundle.putInt("orca:authparam:spash_logo1", i4);
        bundle.putInt("orca:authparam:spash_logo2", i5);
        bundle.putSerializable("orca:authparam:splash_transition", splashTransition);
        bundle.putInt("com.facebook.fragment.ENTER_ANIM", i6);
        bundle.putInt("com.facebook.fragment.EXIT_ANIM", i7);
        bundle.putInt("com.facebook.fragment.POP_ENTER_ANIM", i8);
        bundle.putInt("com.facebook.fragment.POP_EXIT_ANIM", i9);
        bundle.putString("orca:authparam:help_url", str);
        bundle.putBoolean("orca:authparam:hide_logo", z);
        return bundle;
    }

    public AuthFragmentLogoViewGroup(Context context, T t) {
        super(context, t);
        FbInjector.a(AuthFragmentLogoViewGroup.class, this);
        setContentView(getResourceArgument("orca:authparam:layout_resource", getDefaultLayoutResource()));
        if (this.mSplashLogo1ResId == 0) {
            this.mSplashLogo1ResId = this.mLogo1ResId;
        }
        if (this.mSplashLogo2ResId == 0) {
            this.mSplashLogo2ResId = this.mLogo2ResId;
        }
        this.mEnterTransitionAnimation = getResourceArgument("com.facebook.fragment.ENTER_ANIM", 0);
        this.mExitTransitionAnimation = getResourceArgument("com.facebook.fragment.EXIT_ANIM", 0);
        this.mPopEnterTransitionAnimation = getResourceArgument("com.facebook.fragment.POP_ENTER_ANIM", 0);
        this.mPopExitTransitionAnimation = getResourceArgument("com.facebook.fragment.POP_EXIT_ANIM", 0);
        if (getArguments() != null) {
            this.mHideLogoOnSmallDisplays = getArguments().getBoolean("orca:authparam:hide_logo", false);
        } else {
            this.mHideLogoOnSmallDisplays = false;
        }
        if (this.mHideLogoOnSmallDisplays) {
            this.mDynamicLayoutUtil.a(getRootView(), getResources().getInteger(2131492868), ImmutableList.of(Integer.valueOf(2131564875)));
            this.mDynamicLayoutUtil.a(getRootView(), getResources().getInteger(2131492869), ImmutableList.of(Integer.valueOf(2131558927)), ImmutableList.of(Integer.valueOf(2131427709)), ImmutableList.of(Integer.valueOf(2131427708)));
        }
        if (isLegacyLayout()) {
            this.mLayoutDelegate = new LegacyLayoutDelegate(this);
        } else {
            this.mLayoutDelegate = new ModernLayoutDelegate(this);
        }
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1800606462);
        super.onAttachedToWindow();
        this.mLayoutDelegate.mo906a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -595472302, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mLayoutDelegate.mo907b();
    }

    public void setCustomAnimations(FragmentActionBuilder fragmentActionBuilder) {
        fragmentActionBuilder.a(this.mEnterTransitionAnimation, this.mExitTransitionAnimation, this.mPopEnterTransitionAnimation, this.mPopExitTransitionAnimation);
    }

    private boolean isLegacyLayout() {
        View[] viewArr = new View[]{this.mSplashGroup, this.mSplashLogo1View, this.mSplashLogo2View, this.mRootGroup, this.mMainGroup, this.mBottomGroup, this.mLogoGroup, this.mHelpButton};
        for (int i = 0; i < 8; i++) {
            if (viewArr[i] == null) {
                return true;
            }
        }
        return false;
    }
}
