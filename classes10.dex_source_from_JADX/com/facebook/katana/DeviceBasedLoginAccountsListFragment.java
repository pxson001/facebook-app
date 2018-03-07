package com.facebook.katana;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.devicebasedlogin.prefs.DBLPrefKeys;
import com.facebook.devicebasedlogin.settings.DBLAccountsListAdapter;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.katana.dbl.DeviceBasedLoginListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.registration.activity.AccountRegistrationActivity;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: SELECTED_FRIENDS_TOKENS_IDS */
public class DeviceBasedLoginAccountsListFragment extends FbFragment implements IAuthNotRequired, DeviceBasedLoginWaitListener, IFbResourcesNotRequired {
    private static final Class<?> f24163e = DeviceBasedLoginAccountsListFragment.class;
    @Inject
    public DBLAccountsListAdapter f24164a;
    private TextView al;
    private TextView am;
    private FbTextView an;
    private LinearLayout ao;
    public SpringSystem ap;
    private String aq;
    public final Handler ar = new Handler();
    public int as = -1;
    public View at;
    public Tooltip au;
    public boolean av = false;
    @Inject
    public FbSharedPreferences f24165b;
    @Inject
    public SecureContextHelper f24166c;
    @Inject
    public DeviceBasedLoginActivityHelper f24167d;
    public DeviceBasedLoginListener f24168f;
    private ProgressBar f24169g;
    public ViewGroup f24170h;
    private GlyphView f24171i;

    /* compiled from: SELECTED_FRIENDS_TOKENS_IDS */
    public class C34702 implements OnClickListener {
        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24141a;

        public C34702(DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment) {
            this.f24141a = deviceBasedLoginAccountsListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1788866731);
            if (this.f24141a.f24168f != null && this.f24141a.as == -1) {
                this.f24141a.f24168f.d();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1366402478, a);
        }
    }

    /* compiled from: SELECTED_FRIENDS_TOKENS_IDS */
    public class C34713 implements OnClickListener {
        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24142a;

        public C34713(DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment) {
            this.f24142a = deviceBasedLoginAccountsListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -433218336);
            if (this.f24142a.f24168f != null) {
                this.f24142a.f24168f.a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1833127168, a);
        }
    }

    /* compiled from: SELECTED_FRIENDS_TOKENS_IDS */
    public class C34724 implements OnClickListener {
        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24143a;

        public C34724(DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment) {
            this.f24143a = deviceBasedLoginAccountsListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -964880569);
            this.f24143a.f24166c.a(AccountRegistrationActivity.a(this.f24143a.getContext(), getClass().getSimpleName()), this.f24143a.getContext());
            this.f24143a.o().finish();
            Logger.a(2, EntryType.UI_INPUT_END, -2083792272, a);
        }
    }

    /* compiled from: SELECTED_FRIENDS_TOKENS_IDS */
    public class C34745 extends DataSetObserver {
        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24149a;

        public C34745(DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment) {
            this.f24149a = deviceBasedLoginAccountsListFragment;
        }

        public void onChanged() {
            final int[] iArr = new int[2];
            for (int childCount = this.f24149a.f24170h.getChildCount(); childCount > this.f24149a.f24164a.getCount(); childCount--) {
                this.f24149a.f24170h.removeViewAt(childCount - 1);
            }
            for (int i = 0; i < this.f24149a.f24164a.getCount(); i++) {
                View childAt = this.f24149a.f24170h.getChildAt(i);
                View view = this.f24149a.f24164a.getView(i, childAt, this.f24149a.f24170h);
                if (view != childAt) {
                    this.f24149a.f24170h.addView(view, i);
                }
                final DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) this.f24149a.f24164a.getItem(i);
                if (!this.f24149a.av) {
                    DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment = this.f24149a;
                    boolean z = false;
                    if ("password_account".equals(dBLFacebookCredentials.mNonce)) {
                        PrefKey a = DBLPrefKeys.a(dBLFacebookCredentials.mUserId);
                        if (!deviceBasedLoginAccountsListFragment.f24165b.a(a)) {
                            deviceBasedLoginAccountsListFragment.f24165b.edit().putBoolean(a, true).commit();
                            z = true;
                        }
                    }
                    if (z) {
                        this.f24149a.at = view;
                    }
                }
                final Spring a2 = this.f24149a.ap.a();
                a2.a(SpringConfig.a(40.0d, 12.0d));
                a2.a(new C34756(this.f24149a, view));
                view.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ C34745 f24148e;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment = this.f24148e.f24149a;
                        if (deviceBasedLoginAccountsListFragment.au != null && deviceBasedLoginAccountsListFragment.av) {
                            deviceBasedLoginAccountsListFragment.au.l();
                            deviceBasedLoginAccountsListFragment.av = false;
                            deviceBasedLoginAccountsListFragment.au = null;
                        }
                        switch (motionEvent.getAction()) {
                            case 0:
                                a2.b(1.0d);
                                if (this.f24148e.f24149a.as == -1) {
                                    view.getLocationOnScreen(iArr);
                                    this.f24148e.f24149a.as = i;
                                    break;
                                }
                                break;
                            case 1:
                                a2.b(0.0d);
                                if (this.f24148e.f24149a.as == i) {
                                    this.f24148e.f24149a.m25465a(dBLFacebookCredentials, view, i, iArr, dBLFacebookCredentials.mIsPinSet.booleanValue());
                                    break;
                                }
                                break;
                            case 3:
                                a2.b(0.0d);
                                if (this.f24148e.f24149a.as == i) {
                                    this.f24148e.f24149a.as = -1;
                                    break;
                                }
                                break;
                        }
                        return true;
                    }
                });
            }
        }
    }

    /* compiled from: SELECTED_FRIENDS_TOKENS_IDS */
    public class C34756 extends SimpleSpringListener {
        final /* synthetic */ View f24150a;
        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24151b;

        public C34756(DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment, View view) {
            this.f24151b = deviceBasedLoginAccountsListFragment;
            this.f24150a = view;
        }

        public final void m25464a(Spring spring) {
            float b = 1.0f - (((float) spring.b()) * 0.5f);
            this.f24150a.setScaleX(b);
            this.f24150a.setScaleY(b);
        }
    }

    public static void m25468a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment = (DeviceBasedLoginAccountsListFragment) obj;
        DBLAccountsListAdapter b = DBLAccountsListAdapter.b(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        DeviceBasedLoginActivityHelper b2 = DeviceBasedLoginActivityHelper.b(fbInjector);
        deviceBasedLoginAccountsListFragment.f24164a = b;
        deviceBasedLoginAccountsListFragment.f24165b = fbSharedPreferences;
        deviceBasedLoginAccountsListFragment.f24166c = secureContextHelper;
        deviceBasedLoginAccountsListFragment.f24167d = b2;
    }

    public final void m25475c(Bundle bundle) {
        super.c(bundle);
        Class cls = DeviceBasedLoginAccountsListFragment.class;
        m25468a((Object) this, getContext());
        if (this.s != null) {
            this.aq = this.s.getString("previous_login_state");
        }
    }

    public final View m25470a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1728792015);
        View inflate = layoutInflater.inflate(2130903846, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2041423360, a);
        return inflate;
    }

    public final void m25472a(View view, Bundle bundle) {
        int i = (int) (jW_().getDisplayMetrics().density * 10.0f);
        ((HorizontalScrollView) view.findViewById(2131560905)).setPadding(i, 0, i, 0);
        this.f24170h = (ViewGroup) e(2131560906);
        this.f24169g = (ProgressBar) e(2131559418);
        this.ao = (LinearLayout) e(2131560903);
        this.f24164a.registerDataSetObserver(new C34745(this));
        this.f24171i = (GlyphView) e(2131560907);
        this.al = (TextView) e(2131560908);
        this.am = (TextView) e(2131560909);
        this.an = (FbTextView) e(2131560904);
        if (this.f24167d.c.a(7, false)) {
            this.an.setVisibility(0);
        } else {
            this.an.setVisibility(8);
        }
        this.al.setText(b(2131236240));
        this.am.setText(b(2131232485));
        this.f24171i.setOnClickListener(new C34702(this));
        this.al.setOnClickListener(new C34713(this));
        this.am.setOnClickListener(new C34724(this));
        this.ap = SpringSystem.b();
    }

    public final void m25476d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1608121219);
        super.d(bundle);
        this.f24164a.d = 2130903847;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 498682789, a);
    }

    public final void m25469G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1384362114);
        super.G();
        if (!(this.f24164a.a() || this.f24168f == null)) {
            this.f24168f.b();
        }
        if (this.aq != null && this.aq.equals("login_state_passcode_entry")) {
            final DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) this.s.getParcelable("dbl_account_details");
            this.aq = null;
            final View view = this.T;
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24140c;

                        public void onGlobalLayout() {
                            if (view != null) {
                                CustomViewUtils.a(view, this);
                            }
                            for (int i = 0; i < this.f24140c.f24164a.getCount(); i++) {
                                DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) this.f24140c.f24164a.getItem(i);
                                this.f24140c.f24170h.getChildAt(i).setVisibility(4);
                                if (dBLFacebookCredentials != null && dBLFacebookCredentials.mUserId.equals(dBLFacebookCredentials.mUserId)) {
                                    View childAt = this.f24140c.f24170h.getChildAt(i);
                                    childAt.setVisibility(0);
                                    int[] iArr = new int[2];
                                    childAt.getLocationOnScreen(iArr);
                                    DeviceBasedLoginAccountsListFragment.m25466a(this.f24140c, childAt, i, iArr);
                                }
                            }
                        }
                    });
                }
            }
        } else if (!(this.at == null || this.av)) {
            HandlerDetour.b(this.ar, new Runnable(this) {
                final /* synthetic */ DeviceBasedLoginAccountsListFragment f24136a;

                {
                    this.f24136a = r1;
                }

                public void run() {
                    int start;
                    this.f24136a.au = new Tooltip(this.f24136a.ao(), 2);
                    this.f24136a.au.t = -1;
                    this.f24136a.au.c(this.f24136a.at);
                    DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment = this.f24136a;
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(StringFormatUtil.formatStrLocaleSafe(deviceBasedLoginAccountsListFragment.b(2131236285), "[[settings_icon]]"));
                    Matcher matcher = Pattern.compile(Pattern.quote("[[settings_icon]]")).matcher(spannableStringBuilder);
                    if (matcher.find()) {
                        start = matcher.start();
                    } else {
                        start = -1;
                    }
                    int i = start;
                    Preconditions.checkArgument(i != -1);
                    spannableStringBuilder.setSpan(new ImageSpan(deviceBasedLoginAccountsListFragment.getContext(), 2130843707, 1), i, i + 17, 33);
                    deviceBasedLoginAccountsListFragment.au.b(new SpannableString(spannableStringBuilder));
                    deviceBasedLoginAccountsListFragment.au.a(new OnTooltipClickListener(deviceBasedLoginAccountsListFragment) {
                        final /* synthetic */ DeviceBasedLoginAccountsListFragment f24137a;

                        {
                            this.f24137a = r1;
                        }

                        public final void m25463a() {
                            if (this.f24137a.f24168f != null && this.f24137a.as == -1) {
                                this.f24137a.f24168f.d();
                            }
                        }
                    });
                    this.f24136a.au.d();
                    this.f24136a.av = true;
                }
            }, 1000, 448505756);
        }
        LogUtils.f(898789100, a);
    }

    public final void m25471a() {
        this.f24169g.setVisibility(0);
        this.f24170h.setVisibility(8);
        this.f24171i.setVisibility(8);
        this.al.setVisibility(8);
        this.am.setVisibility(8);
        this.ao.setVisibility(8);
    }

    public final void m25473b() {
        this.as = -1;
    }

    public final void m25474c() {
        this.as = -1;
        this.f24169g.setVisibility(8);
        this.f24170h.setVisibility(0);
        this.f24171i.setVisibility(0);
        this.al.setVisibility(0);
        this.am.setVisibility(0);
        this.ao.setVisibility(0);
    }

    private void m25465a(final DBLFacebookCredentials dBLFacebookCredentials, View view, int i, int[] iArr, boolean z) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ao().getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        Animation translateAnimation = new TranslateAnimation(0.0f, (float) (-i2), 0.0f, 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.reset();
        translateAnimation.setFillAfter(true);
        Animation translateAnimation2 = new TranslateAnimation(0.0f, (float) i2, 0.0f, 0.0f);
        translateAnimation2.setDuration(500);
        translateAnimation2.reset();
        translateAnimation2.setFillAfter(true);
        for (i2 = 0; i2 < i; i2++) {
            this.f24170h.getChildAt(i2).startAnimation(translateAnimation);
        }
        for (i2 = i + 1; i2 < this.f24164a.getCount(); i2++) {
            this.f24170h.getChildAt(i2).startAnimation(translateAnimation2);
        }
        i2 = (displayMetrics.widthPixels / 2) - (view.getMeasuredWidth() / 2);
        if (this.f24164a.getCount() == 1) {
            i2 = iArr[0];
        }
        int top = this.ao.getTop() + this.ao.getHeight();
        if (z) {
            int i3 = (int) ((getContext().getResources().getDisplayMetrics().density * 394.0f) + 0.5f);
            Animator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (((displayMetrics.heightPixels - i3) / 2) - F().findViewById(2131560905).getTop())});
            Animator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) (i2 - iArr[0])});
            Animator ofFloat3 = ObjectAnimator.ofFloat(view.findViewById(2131560890), "alpha", new float[]{0.0f});
            Animator ofFloat4 = ObjectAnimator.ofFloat(this.ao, "translationY", new float[]{(float) (-top)});
            Animator ofFloat5 = ObjectAnimator.ofFloat(this.f24171i, "translationY", new float[]{(float) this.f24171i.getTop()});
            Animator ofFloat6 = ObjectAnimator.ofFloat(this.al, "translationY", new float[]{(float) this.al.getTop()});
            Animator ofFloat7 = ObjectAnimator.ofFloat(this.am, "translationY", new float[]{(float) this.am.getTop()});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat2).before(ofFloat);
            animatorSet.play(ofFloat).with(ofFloat3);
            animatorSet.play(ofFloat).with(ofFloat4);
            animatorSet.play(ofFloat).with(ofFloat5);
            animatorSet.play(ofFloat).with(ofFloat6);
            animatorSet.play(ofFloat).with(ofFloat7);
            animatorSet.addListener(new AnimatorListener(this) {
                final /* synthetic */ DeviceBasedLoginAccountsListFragment f24153b;

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (this.f24153b.f24168f != null) {
                        this.f24153b.f24168f.a(dBLFacebookCredentials);
                    }
                }

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }
            });
            animatorSet.setDuration(500);
            animatorSet.start();
        } else if (this.f24168f != null) {
            this.f24168f.a(dBLFacebookCredentials);
        }
    }

    public static void m25466a(DeviceBasedLoginAccountsListFragment deviceBasedLoginAccountsListFragment, View view, int i, int[] iArr) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        deviceBasedLoginAccountsListFragment.ao().getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) (-i2), 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.reset();
        translateAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0, (float) i2, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation2.setDuration(500);
        translateAnimation2.reset();
        translateAnimation.setFillAfter(true);
        final int i3 = i;
        translateAnimation2.setAnimationListener(new AnimationListener(deviceBasedLoginAccountsListFragment) {
            final /* synthetic */ DeviceBasedLoginAccountsListFragment f24155b;

            public void onAnimationStart(Animation animation) {
                for (int i = 0; i < this.f24155b.f24164a.getCount(); i++) {
                    if (i != i3) {
                        this.f24155b.f24170h.getChildAt(i).setVisibility(0);
                    }
                }
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        int top = deviceBasedLoginAccountsListFragment.ao.getTop() + deviceBasedLoginAccountsListFragment.ao.getHeight();
        int measuredWidth = (i2 - view.getMeasuredWidth()) / 2;
        Animation translateAnimation3 = new TranslateAnimation(0, (float) (measuredWidth - iArr[0]), 0, (float) (measuredWidth - iArr[0]), 0, (float) (-(deviceBasedLoginAccountsListFragment.F().findViewById(2131560905).getTop() - ((displayMetrics.heightPixels - ((int) ((deviceBasedLoginAccountsListFragment.getContext().getResources().getDisplayMetrics().density * 394.0f) + 0.5f))) / 2))), 1, 0.0f);
        translateAnimation3.setDuration(500);
        translateAnimation3.reset();
        translateAnimation3.setFillAfter(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.reset();
        view.findViewById(2131560890).startAnimation(alphaAnimation);
        alphaAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 2, 1.0f, 1, 0.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.reset();
        alphaAnimation.setFillAfter(true);
        Animation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, (float) (-top), 1, 0.0f);
        translateAnimation4.setDuration(500);
        translateAnimation4.reset();
        translateAnimation4.setFillAfter(true);
        final int i4 = i;
        final TranslateAnimation translateAnimation5 = translateAnimation;
        final TranslateAnimation translateAnimation6 = translateAnimation2;
        final int i5 = measuredWidth;
        final int[] iArr2 = iArr;
        final View view2 = view;
        translateAnimation4.setAnimationListener(new AnimationListener(deviceBasedLoginAccountsListFragment) {
            final /* synthetic */ DeviceBasedLoginAccountsListFragment f24162g;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                int i;
                for (i = 0; i < i4; i++) {
                    this.f24162g.f24170h.getChildAt(i).startAnimation(translateAnimation5);
                }
                for (i = i4 + 1; i < this.f24162g.f24164a.getCount(); i++) {
                    this.f24162g.f24170h.getChildAt(i).startAnimation(translateAnimation6);
                }
                Animation translateAnimation = new TranslateAnimation(0, (float) (i5 - iArr2[0]), 1, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(500);
                translateAnimation.reset();
                translateAnimation.setFillAfter(true);
                view2.startAnimation(translateAnimation);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation3);
        deviceBasedLoginAccountsListFragment.ao.startAnimation(translateAnimation4);
        deviceBasedLoginAccountsListFragment.f24171i.startAnimation(alphaAnimation);
        deviceBasedLoginAccountsListFragment.al.startAnimation(alphaAnimation);
        deviceBasedLoginAccountsListFragment.am.startAnimation(alphaAnimation);
    }
}
