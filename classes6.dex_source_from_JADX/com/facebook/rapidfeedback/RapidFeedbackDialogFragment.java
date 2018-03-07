package com.facebook.rapidfeedback;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.R;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.background.RapidFeedbackModalBackgroundView;
import com.facebook.rapidfeedback.ui.RapidFeedbackPageView;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionExtra;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.structuredsurvey.SurveyListAdapter;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.views.SurveyEditTextListItemView;
import com.facebook.structuredsurvey.views.SurveyListView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import com.facebook.ui.keyboard.SoftKeyboardStateHelper;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: fake target publish break */
public class RapidFeedbackDialogFragment extends FbDialogFragment {
    public static final String am = RapidFeedbackDialogFragment.class.getSimpleName();
    public int aA;
    public SurveyListAdapter aB;
    private final LayoutParams aC = new LayoutParams(-1, -1);
    public final OnClickListener aD = new C10731(this);
    private final OnClickListener aE = new C10742(this);
    private final Runnable aF = new C10753(this);
    private SoftKeyboardStateHelper aG;
    public AdvancedDragDetector aH;
    private boolean aI;
    public int aJ;
    private final OnGlobalLayoutListener aK = new C10764(this);
    public boolean aL;
    public Rect an;
    public OnCompleteListener ao;
    public int ap;
    public int aq;
    public DialogState ar;
    public RapidFeedbackPageView as;
    public RapidFeedbackModalBackgroundView at;
    public RapidFeedbackController au;
    public SurveyListView av;
    private LinearLayout aw;
    private BetterButton ax;
    private BetterButton ay;
    public int az;

    /* compiled from: fake target publish break */
    /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] f15344a = new int[Direction.values().length];

        static {
            try {
                f15344a[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15344a[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15344a[Direction.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: fake target publish break */
    class C10731 implements OnClickListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15345a;

        C10731(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15345a = rapidFeedbackDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -147459712);
            RapidFeedbackDialogFragment rapidFeedbackDialogFragment = this.f15345a;
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(200);
            alphaAnimation.setAnimationListener(new AnimationListener(rapidFeedbackDialogFragment) {
                final /* synthetic */ RapidFeedbackDialogFragment f15343a;

                /* compiled from: fake target publish break */
                class C10721 implements Runnable {
                    final /* synthetic */ AnonymousClass11 f15342a;

                    C10721(AnonymousClass11 anonymousClass11) {
                        this.f15342a = anonymousClass11;
                    }

                    public void run() {
                        RapidFeedbackDialogFragment rapidFeedbackDialogFragment = this.f15342a.f15343a;
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rapidFeedbackDialogFragment.as.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        layoutParams.topMargin = 0;
                        rapidFeedbackDialogFragment.as.setLayoutParams(layoutParams);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) rapidFeedbackDialogFragment.av.getLayoutParams();
                        layoutParams2.height = -1;
                        rapidFeedbackDialogFragment.av.setLayoutParams(layoutParams2);
                        rapidFeedbackDialogFragment.au.a(ImpressionType.IMPRESSION);
                        rapidFeedbackDialogFragment.ar = DialogState.EXPANDED;
                        RapidFeedbackDialogFragment.aB(rapidFeedbackDialogFragment);
                    }
                }

                {
                    this.f15343a = r1;
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    this.f15343a.as.setVisibility(4);
                    this.f15343a.at.m23002a(new C10721(this));
                }
            });
            rapidFeedbackDialogFragment.as.startAnimation(alphaAnimation);
            this.f15345a.au.a(ImpressionType.INVITATION_OPENED);
            Logger.a(2, EntryType.UI_INPUT_END, -615918469, a);
        }
    }

    /* compiled from: fake target publish break */
    class C10742 implements OnClickListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15346a;

        C10742(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15346a = rapidFeedbackDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1288189951);
            RapidFeedbackDialogFragment.aA(this.f15346a);
            Logger.a(2, EntryType.UI_INPUT_END, -304510271, a);
        }
    }

    /* compiled from: fake target publish break */
    class C10753 implements Runnable {
        final /* synthetic */ RapidFeedbackDialogFragment f15347a;

        C10753(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15347a = rapidFeedbackDialogFragment;
        }

        public void run() {
            RapidFeedbackDialogFragment.aA(this.f15347a);
        }
    }

    /* compiled from: fake target publish break */
    class C10764 implements OnGlobalLayoutListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15348a;

        C10764(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15348a = rapidFeedbackDialogFragment;
        }

        public void onGlobalLayout() {
            int height = (this.f15348a.av.getHeight() + this.f15348a.as.getPaddingTop()) + this.f15348a.as.getPaddingBottom();
            if (height != this.f15348a.aJ) {
                this.f15348a.aJ = height;
                RapidFeedbackDialogFragment.aD(this.f15348a);
            }
        }
    }

    /* compiled from: fake target publish break */
    public class C10775 implements Runnable {
        final /* synthetic */ RapidFeedbackDialogFragment f15349a;

        public C10775(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15349a = rapidFeedbackDialogFragment;
        }

        public void run() {
            boolean z = false;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = 0;
            layoutParams.gravity = 48;
            if (this.f15349a.ar == DialogState.INTRO_COLLAPSED) {
                RapidFeedbackDialogFragment.m22974g(this.f15349a, this.f15349a.as.getMeasuredHeight());
                layoutParams.topMargin = this.f15349a.aq - (this.f15349a.ap / 2);
            } else {
                this.f15349a.ap = Math.max(this.f15349a.ap, Math.round(this.f15349a.getContext().getResources().getDisplayMetrics().density * ((float) 150)));
                RapidFeedbackDialogFragment.m22974g(this.f15349a, this.f15349a.ap);
                this.f15349a.au.a(ImpressionType.IMPRESSION);
                layoutParams.topMargin = 0;
            }
            this.f15349a.as.setLayoutParams(layoutParams);
            RapidFeedbackDialogFragment rapidFeedbackDialogFragment = this.f15349a;
            int i = this.f15349a.az;
            if (this.f15349a.ar != DialogState.EXPANDED) {
                z = true;
            }
            rapidFeedbackDialogFragment.at.m22999a(i);
            rapidFeedbackDialogFragment.at.m23001a(rapidFeedbackDialogFragment.jW_().getDisplayMetrics().widthPixels, rapidFeedbackDialogFragment.getContext().getResources().getDisplayMetrics().heightPixels - rapidFeedbackDialogFragment.jW_().getDimensionPixelSize(2131430732), rapidFeedbackDialogFragment.aq, rapidFeedbackDialogFragment.ap, z);
            if (this.f15349a.ar == DialogState.INTRO_COLLAPSED) {
                RapidFeedbackDialogFragment.ax(this.f15349a);
            }
        }
    }

    /* compiled from: fake target publish break */
    class C10786 implements AnimationListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15350a;

        C10786(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15350a = rapidFeedbackDialogFragment;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f15350a.au.a(ImpressionType.INVITATION_IMPRESSION);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: fake target publish break */
    class C10797 implements OnClickListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15351a;

        C10797(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15351a = rapidFeedbackDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -786008978);
            this.f15351a.au.a(ImpressionExtra.DISMISS_SURVEY);
            RapidFeedbackDialogFragment.at(this.f15351a);
            this.f15351a.au.h();
            this.f15351a.au.j();
            this.f15351a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 444522986, a);
        }
    }

    /* compiled from: fake target publish break */
    class C10808 implements AnimationListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15352a;

        C10808(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15352a = rapidFeedbackDialogFragment;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f15352a.au.e() == 0) {
                this.f15352a.au.a(ImpressionType.START);
            }
            RapidFeedbackDialogFragment.aB(this.f15352a);
        }
    }

    /* compiled from: fake target publish break */
    class C10819 implements Runnable {
        final /* synthetic */ RapidFeedbackDialogFragment f15353a;

        C10819(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
            this.f15353a = rapidFeedbackDialogFragment;
        }

        public void run() {
            RapidFeedbackDialogFragment rapidFeedbackDialogFragment = this.f15353a;
            int childCount = rapidFeedbackDialogFragment.av.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = rapidFeedbackDialogFragment.av.getChildAt(i);
                if (childAt instanceof SurveyEditTextListItemView) {
                    ((SurveyEditTextListItemView) childAt).m24954a(true);
                    return;
                }
            }
        }
    }

    /* compiled from: fake target publish break */
    public enum DialogState {
        INTRO_COLLAPSED,
        EXPANDED,
        OUTRO_COLLAPSED
    }

    /* compiled from: fake target publish break */
    public interface OnCompleteListener {
    }

    /* compiled from: fake target publish break */
    public class RapidFeedbackDialog extends FbDialog implements DragListener {
        final /* synthetic */ RapidFeedbackDialogFragment f15354b;
        public AdvancedDragDetector f15355c;

        public RapidFeedbackDialog(RapidFeedbackDialogFragment rapidFeedbackDialogFragment, AdvancedDragDetector advancedDragDetector) {
            this.f15354b = rapidFeedbackDialogFragment;
            super(rapidFeedbackDialogFragment, rapidFeedbackDialogFragment.getContext(), rapidFeedbackDialogFragment.d());
            this.f15355c = advancedDragDetector;
            if (this.f15355c != null) {
                this.f15355c.r = this;
                this.f15355c.a(new Direction[]{Direction.DOWN, Direction.LEFT, Direction.RIGHT});
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            RapidFeedbackDialogFragment rapidFeedbackDialogFragment = this.f15354b;
            Object obj = null;
            if (rapidFeedbackDialogFragment.ar != DialogState.EXPANDED && ((float) rapidFeedbackDialogFragment.at.getUpperBound()) > motionEvent.getRawY()) {
                obj = 1;
            }
            if (obj != null) {
                this.f15354b.an().dispatchTouchEvent(motionEvent);
                return false;
            }
            this.f15355c.b(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }

        public final boolean m22971a(float f, float f2, Direction direction) {
            return true;
        }

        public final void m22973b(float f, float f2, Direction direction) {
        }

        public final void m22969a() {
        }

        public final void m22970a(Direction direction, int i) {
            if (this.f15354b.ar == DialogState.INTRO_COLLAPSED) {
                this.f15354b.au.a(ImpressionExtra.DISMISS_TOAST);
                this.f15354b.au.j();
                this.f15354b.m22980a(direction, false);
            }
        }

        public final void m22972b() {
        }
    }

    public final void m22979a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1116382510);
        super.a(bundle);
        d(true);
        Bundle bundle2 = this.s;
        this.aA = bundle2.getInt("survey_theme_arg");
        a(2, this.aA);
        this.aI = bundle2.getBoolean("skip_intro_toast_arg", false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2128121234, a);
    }

    public static void at(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
        View currentFocus = rapidFeedbackDialogFragment.f.getCurrentFocus();
        if (currentFocus != null && (currentFocus instanceof BetterEditTextView)) {
            ((InputMethodManager) rapidFeedbackDialogFragment.getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public final Dialog m22981c(Bundle bundle) {
        RapidFeedbackDialog rapidFeedbackDialog = new RapidFeedbackDialog(this, this.aH);
        DialogWindowUtils.a(rapidFeedbackDialog);
        rapidFeedbackDialog.getWindow().setLayout(this.aC.width, this.aC.height);
        rapidFeedbackDialog.getWindow().setSoftInputMode(16);
        d_(false);
        return rapidFeedbackDialog;
    }

    public final void a_(Context context) {
        super.a_(context);
        if (context instanceof OnCompleteListener) {
            this.ao = (OnCompleteListener) context;
        }
    }

    public final View m22978a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 288054415);
        View inflate = layoutInflater.inflate(2130906574, viewGroup);
        this.aG = new SoftKeyboardStateHelper(inflate);
        this.aG.f5157a.add(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -403748573, a);
        return inflate;
    }

    public final void m22982d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1366179954);
        super.d(bundle);
        if (this.aL) {
            this.as = (RapidFeedbackPageView) e(2131566549);
            this.av = (SurveyListView) FindViewUtil.b(this.as, 2131566553);
            this.aw = (LinearLayout) FindViewUtil.b(this.as, 2131566550);
            this.at = (RapidFeedbackModalBackgroundView) e(2131566548);
            this.ax = (BetterButton) FindViewUtil.b(this.as, 2131566551);
            this.ay = (BetterButton) FindViewUtil.b(this.as, 2131566552);
            this.av.getViewTreeObserver().addOnGlobalLayoutListener(this.aK);
            this.az = an().obtainStyledAttributes(this.aA, R.styleable.RapidFeedback).getResourceId(0, 0);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) jW_().getDrawable(this.az);
            this.an = new Rect();
            ninePatchDrawable.getPadding(this.an);
            int dimension = (int) jW_().getDimension(2131430731);
            this.as.setPadding(this.an.left + dimension, this.an.top + dimension, this.an.right + dimension, dimension + this.an.bottom);
            if (bundle == null) {
                if (this.aI) {
                    this.ar = DialogState.EXPANDED;
                    this.aB = this.au.c();
                } else {
                    this.ar = DialogState.INTRO_COLLAPSED;
                    this.aB = ((StructuredSurveyController) this.au.d.get()).b();
                    this.aB.f17122b = this.aD;
                }
            }
            as();
            LogUtils.f(1088156677, a);
            return;
        }
        a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1033050757, a);
    }

    public final void m22977H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 121202047);
        if (this.ar == DialogState.OUTRO_COLLAPSED) {
            if (this.au != null) {
                this.au.j();
            }
            a();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2077264242, a);
    }

    private void as() {
        ay();
        if (this.ar == DialogState.EXPANDED && this.au.d()) {
            this.aB.f17123c = this.aF;
        }
        this.av.setAdapter(this.aB);
        this.as.post(new C10775(this));
    }

    public static void ax(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) ((rapidFeedbackDialogFragment.getContext().getResources().getDisplayMetrics().heightPixels - rapidFeedbackDialogFragment.aq) + (rapidFeedbackDialogFragment.ap / 2)), 0.0f);
        translateAnimation.setDuration(250);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new C10786(rapidFeedbackDialogFragment));
        rapidFeedbackDialogFragment.T.startAnimation(translateAnimation);
    }

    private void ay() {
        this.ax.setText(jW_().getString(2131236112));
        this.ax.setOnClickListener(new C10797(this));
        this.ay.setText(jW_().getString(2131236111));
        this.ay.setOnClickListener(this.aE);
        m22975h(this.ar != DialogState.INTRO_COLLAPSED);
    }

    private void m22975h(boolean z) {
        if (z) {
            this.aw.setVisibility(0);
            if (this.au.d()) {
                this.ay.setVisibility(8);
            } else {
                this.ay.setVisibility(0);
            }
            if (((StructuredSurveyController) this.au.d.get()).q.m24806c() && this.au.e() != 0) {
                this.ax.setVisibility(8);
                return;
            }
            return;
        }
        this.aw.setVisibility(8);
    }

    public static void m22974g(RapidFeedbackDialogFragment rapidFeedbackDialogFragment, int i) {
        rapidFeedbackDialogFragment.ap = i;
        rapidFeedbackDialogFragment.aq = ((rapidFeedbackDialogFragment.getContext().getResources().getDisplayMetrics().heightPixels - Math.round(rapidFeedbackDialogFragment.getContext().getResources().getDisplayMetrics().density * 20.0f)) - rapidFeedbackDialogFragment.an.bottom) - (i / 2);
    }

    private void m22976i(boolean z) {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        if (z) {
            alphaAnimation.setStartOffset(300);
        }
        alphaAnimation.setDuration(400);
        this.as.setVisibility(0);
        this.as.startAnimation(alphaAnimation);
    }

    public static void aA(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setAnimationListener(new C10808(rapidFeedbackDialogFragment));
        rapidFeedbackDialogFragment.as.startAnimation(alphaAnimation);
    }

    public static void aB(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
        at(rapidFeedbackDialogFragment);
        rapidFeedbackDialogFragment.as.setVisibility(4);
        rapidFeedbackDialogFragment.au.g();
        rapidFeedbackDialogFragment.av.setAdapter(null);
        rapidFeedbackDialogFragment.aB = rapidFeedbackDialogFragment.au.c();
        if (rapidFeedbackDialogFragment.aB == null) {
            rapidFeedbackDialogFragment.aE();
            return;
        }
        Object obj;
        if (rapidFeedbackDialogFragment.au.d()) {
            rapidFeedbackDialogFragment.aB.f17123c = rapidFeedbackDialogFragment.aF;
        }
        rapidFeedbackDialogFragment.m22975h(true);
        rapidFeedbackDialogFragment.av.setAdapter(rapidFeedbackDialogFragment.aB);
        rapidFeedbackDialogFragment.m22976i(false);
        SurveyListAdapter surveyListAdapter = rapidFeedbackDialogFragment.aB;
        int count = surveyListAdapter.getCount();
        int i = 0;
        while (i < count) {
            if (((SurveyItem) surveyListAdapter.getItem(i)).f17165a != ItemType.QUESTION || i + 1 >= count) {
                i++;
            } else {
                if (((SurveyItem) surveyListAdapter.getItem(i + 1)).f17165a == ItemType.EDITTEXT) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    rapidFeedbackDialogFragment.av.post(new C10819(rapidFeedbackDialogFragment));
                }
            }
        }
        obj = null;
        if (obj != null) {
            rapidFeedbackDialogFragment.av.post(new C10819(rapidFeedbackDialogFragment));
        }
    }

    public static void aD(RapidFeedbackDialogFragment rapidFeedbackDialogFragment) {
        if (rapidFeedbackDialogFragment.ar == DialogState.OUTRO_COLLAPSED) {
            rapidFeedbackDialogFragment.aF();
        }
    }

    private void aE() {
        this.au.h();
        this.au.a(ImpressionType.COMPLETE);
        this.ar = DialogState.OUTRO_COLLAPSED;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.av.getLayoutParams();
        layoutParams.height = -2;
        this.av.setLayoutParams(layoutParams);
        m22975h(false);
        this.aB = ((StructuredSurveyController) this.au.d.get()).c();
        this.av.setAdapter(this.aB);
        this.au.j();
    }

    private void aF() {
        m22974g(this, this.aJ);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.as.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = this.aq - (this.ap / 2);
        this.as.setLayoutParams(layoutParams);
        this.at.m23000a(this.ap, this.aq);
        this.at.m22998a();
        m22976i(true);
        m22980a(Direction.DOWN, true);
    }

    public final void m22980a(Direction direction, boolean z) {
        Animation translateAnimation;
        switch (AnonymousClass12.f15344a[direction.ordinal()]) {
            case 1:
                translateAnimation = new TranslateAnimation(0.0f, (float) (-getContext().getResources().getDisplayMetrics().widthPixels), 0.0f, 0.0f);
                break;
            case 2:
                translateAnimation = new TranslateAnimation(0.0f, (float) getContext().getResources().getDisplayMetrics().widthPixels, 0.0f, 0.0f);
                break;
            case 3:
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ((this.ap / 2) + (getContext().getResources().getDisplayMetrics().heightPixels - this.aq)));
                break;
            default:
                return;
        }
        translateAnimation.setDuration(250);
        if (z) {
            translateAnimation.setStartOffset(3000);
        }
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ RapidFeedbackDialogFragment f15341a;

            {
                this.f15341a = r1;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f15341a.a();
                if (this.f15341a.ao != null) {
                    OnCompleteListener onCompleteListener = this.f15341a.ao;
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.T.startAnimation(translateAnimation);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1959634329);
        if (this.f != null && this.M) {
            this.f.setDismissMessage(null);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2049223044, a);
    }
}
