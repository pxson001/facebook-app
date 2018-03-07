package com.facebook.photos.tagging.ui;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.tagging.FaceBox.FaceBoxTarget;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.SizeAnimation;
import com.facebook.photos.galleryutil.SizeAnimation.Dimension;
import com.facebook.photos.galleryutil.SizeAnimation.Type;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.tagging.shared.BubbleLayout;
import com.facebook.photos.tagging.shared.BubbleLayout.ArrowDirection;
import com.facebook.photos.tagging.shared.layout.InsetContainerBounds;
import com.facebook.photos.tagging.shared.layout.InsetContainerUtils;
import com.facebook.photos.tagging.shared.layout.LayoutableTagView;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intro_bio_view_type */
public class TagView extends CustomFrameLayout implements LayoutableTagView {
    @Inject
    public InsetContainerUtils f10930a;
    @Inject
    public Lazy<ViewAnimatorFactory> f10931b;
    private float f10932c;
    private float f10933d;
    public Tag f10934e;
    private boolean f10935f;
    private BubbleLayout f10936g;
    public TextView f10937h;
    public ImageView f10938i;
    public TagViewListener f10939j;
    public SizeAnimation f10940k;
    public SizeAnimation f10941l;
    public VisibilityAnimator f10942m;
    public boolean f10943n;
    private OnGlobalLayoutListener f10944o;
    private ArrowDirection f10945p;
    public int f10946q;
    public boolean f10947r;
    private InsetContainerBounds f10948s = new InsetContainerBounds();
    private boolean f10949t;
    public int f10950u;
    public int f10951v;
    public int f10952w;
    @Nullable
    private VisibilityAnimator f10953x;

    /* compiled from: intro_bio_view_type */
    class C09441 implements OnClickListener {
        final /* synthetic */ TagView f10925a;

        C09441(TagView tagView) {
            this.f10925a = tagView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 146095842);
            this.f10925a.setVisibility(8);
            if (this.f10925a.f10939j != null) {
                this.f10925a.f10939j.mo615a(this.f10925a.f10934e);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 847231161, a);
        }
    }

    /* compiled from: intro_bio_view_type */
    class C09472 implements Runnable {
        final /* synthetic */ TagView f10928a;

        /* compiled from: intro_bio_view_type */
        class C09451 implements AnimationListener {
            final /* synthetic */ C09472 f10926a;

            C09451(C09472 c09472) {
                this.f10926a = c09472;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f10926a.f10928a.f10942m.a(false);
                this.f10926a.f10928a.f10938i.setEnabled(true);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        }

        /* compiled from: intro_bio_view_type */
        class C09462 implements AnimationListener {
            final /* synthetic */ C09472 f10927a;

            C09462(C09472 c09472) {
                this.f10927a = c09472;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f10927a.f10928a.f10942m.b(false);
                this.f10927a.f10928a.f10938i.setEnabled(false);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        }

        C09472(TagView tagView) {
            this.f10928a = tagView;
        }

        public void run() {
            if (!this.f10928a.f10947r) {
                LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f10928a.getWidth(), this.f10928a.getHeight());
                layoutParams.gravity = 1;
                this.f10928a.setLayoutParams(layoutParams);
            }
            this.f10928a.f10938i.setLayoutParams(new LinearLayout.LayoutParams(this.f10928a.f10951v, this.f10928a.f10950u));
            if (this.f10928a.f10947r) {
                this.f10928a.f10943n = true;
                this.f10928a.f10938i.setVisibility(0);
            } else {
                this.f10928a.f10942m.b(false);
                this.f10928a.f10938i.setEnabled(false);
            }
            this.f10928a.f10946q = (this.f10928a.getWidth() + this.f10928a.f10951v) - this.f10928a.f10952w;
            this.f10928a.f10940k = new SizeAnimation(this.f10928a, Dimension.WIDTH, Type.EXPAND, this.f10928a.getWidth(), this.f10928a.f10946q);
            this.f10928a.f10940k.setDuration(150);
            this.f10928a.f10940k.setAnimationListener(new C09451(this));
            this.f10928a.f10941l = new SizeAnimation(this.f10928a, Dimension.WIDTH, Type.COLLAPSE, this.f10928a.getWidth(), this.f10928a.f10946q);
            this.f10928a.f10941l.setDuration(150);
            this.f10928a.f10941l.setAnimationListener(new C09462(this));
        }
    }

    /* compiled from: intro_bio_view_type */
    /* synthetic */ class C09483 {
        static final /* synthetic */ int[] f10929a = new int[ArrowDirection.values().length];

        static {
            try {
                f10929a[ArrowDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10929a[ArrowDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10929a[ArrowDirection.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10929a[ArrowDirection.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10929a[ArrowDirection.UPLEFT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10929a[ArrowDirection.UPRIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10929a[ArrowDirection.DOWNLEFT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f10929a[ArrowDirection.DOWNRIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: intro_bio_view_type */
    public enum DisplayText {
        FIRST_NAME,
        FULL_NAME
    }

    /* compiled from: intro_bio_view_type */
    public interface TagViewListener {
        void mo615a(Tag tag);
    }

    public static void m12949a(Object obj, Context context) {
        TagView tagView = (TagView) obj;
        InsetContainerUtils insetContainerUtils = new InsetContainerUtils();
        Lazy b = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 11485);
        tagView.f10930a = insetContainerUtils;
        tagView.f10931b = b;
    }

    public TagView(Context context, Tag tag, boolean z) {
        super(context, null);
        m12948a(tag, z, DisplayText.FULL_NAME, false, false);
    }

    public TagView(Context context, Tag tag, boolean z, DisplayText displayText, boolean z2, boolean z3) {
        super(context, null);
        m12948a(tag, z, displayText, z2, z3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12948a(com.facebook.photos.base.tagging.Tag r10, boolean r11, com.facebook.photos.tagging.ui.TagView.DisplayText r12, boolean r13, boolean r14) {
        /*
        r9 = this;
        r0 = com.facebook.photos.tagging.ui.TagView.class;
        r6 = r9.getContext();
        m12949a(r9, r6);
        r0 = 2130906195; // 0x7f030c53 float:1.7419286E38 double:1.0528075455E-314;
        r9.setContentView(r0);
        r0 = r9.getResources();
        r1 = 2131430312; // 0x7f0b0ba8 float:1.8482321E38 double:1.0530664937E-314;
        r0 = r0.getDimension(r1);
        r9.f10932c = r0;
        r0 = r9.getResources();
        r1 = 2131430309; // 0x7f0b0ba5 float:1.8482315E38 double:1.053066492E-314;
        r0 = r0.getDimension(r1);
        r9.f10933d = r0;
        r0 = r9.f10932c;
        r0 = (int) r0;
        r1 = r9.f10932c;
        r2 = r9.f10933d;
        r1 = r1 - r2;
        r1 = (int) r1;
        r2 = r9.f10932c;
        r2 = (int) r2;
        r3 = r9.f10932c;
        r3 = (int) r3;
        r9.setPadding(r0, r1, r2, r3);
        r9.f10934e = r10;
        r9.f10935f = r11;
        r0 = com.facebook.photos.tagging.shared.BubbleLayout.ArrowDirection.UP;
        r9.f10945p = r0;
        r0 = 2131565900; // 0x7f0d1d4c float:1.8757327E38 double:1.053133483E-314;
        r0 = r9.c(r0);
        r0 = (com.facebook.photos.tagging.shared.BubbleLayout) r0;
        r9.f10936g = r0;
        r0 = 2131565901; // 0x7f0d1d4d float:1.8757329E38 double:1.0531334835E-314;
        r0 = r9.c(r0);
        r0 = (android.widget.TextView) r0;
        r9.f10937h = r0;
        r0 = r9.f10937h;
        r6 = com.facebook.photos.tagging.ui.TagView.DisplayText.FIRST_NAME;
        if (r12 != r6) goto L_0x006c;
    L_0x005f:
        r8 = r10.b;
        r6 = r8;
        r6 = r6.a();
        r7 = com.google.common.base.Strings.isNullOrEmpty(r6);
        if (r7 == 0) goto L_0x0073;
    L_0x006c:
        r8 = r10.b;
        r6 = r8;
        r6 = r6.i();
    L_0x0073:
        r1 = r6;
        r0.setText(r1);
        r0 = 2131565902; // 0x7f0d1d4e float:1.875733E38 double:1.053133484E-314;
        r0 = r9.c(r0);
        r0 = (android.widget.ImageView) r0;
        r9.f10938i = r0;
        r9.f10949t = r13;
        r0 = r9.f10949t;
        if (r0 == 0) goto L_0x008c;
    L_0x0088:
        r0 = 0;
        r9.m12951b(r0);
    L_0x008c:
        r9.f10947r = r14;
        r0 = r9.getResources();
        r1 = 2131430315; // 0x7f0b0bab float:1.8482327E38 double:1.053066495E-314;
        r0 = r0.getDimensionPixelSize(r1);
        r9.f10951v = r0;
        r0 = r9.getResources();
        r1 = 2131430316; // 0x7f0b0bac float:1.848233E38 double:1.0530664956E-314;
        r0 = r0.getDimensionPixelSize(r1);
        r9.f10950u = r0;
        r0 = r9.getResources();
        r1 = 2131430314; // 0x7f0b0baa float:1.8482325E38 double:1.0530664947E-314;
        r0 = r0.getDimension(r1);
        r0 = java.lang.Math.round(r0);
        r9.f10952w = r0;
        r0 = r9.m12955a();
        if (r0 == 0) goto L_0x00dd;
    L_0x00bf:
        r0 = r9.f10938i;
        r1 = new com.facebook.photos.tagging.ui.TagView$1;
        r1.<init>(r9);
        r0.setOnClickListener(r1);
        r0 = new com.facebook.photos.galleryutil.VisibilityAnimator;
        r1 = r9.f10938i;
        r2 = 100;
        r4 = 1;
        r5 = r9.f10931b;
        r5 = r5.get();
        r5 = (com.facebook.ui.animations.ViewHelperViewAnimatorFactory) r5;
        r0.<init>(r1, r2, r4, r5);
        r9.f10942m = r0;
    L_0x00dd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.tagging.ui.TagView.a(com.facebook.photos.base.tagging.Tag, boolean, com.facebook.photos.tagging.ui.TagView$DisplayText, boolean, boolean):void");
    }

    public final boolean m12955a() {
        return !this.f10949t && (this.f10935f || (this.f10934e != null && this.f10934e.k().booleanValue()));
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1287290073);
        super.onDetachedFromWindow();
        if (this.f10944o != null) {
            GlobalOnLayoutHelper.b(this, this.f10944o);
            this.f10944o = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2018783391, a);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -288942144);
        super.onAttachedToWindow();
        if (m12955a()) {
            this.f10944o = GlobalOnLayoutHelper.b(this, new C09472(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 316351281, a);
    }

    private VisibilityAnimator getVisibilityAnimator() {
        if (this.f10953x == null) {
            this.f10953x = new VisibilityAnimator(this, 200, (ViewHelperViewAnimatorFactory) this.f10931b.get());
        }
        return this.f10953x;
    }

    public final void m12954a(boolean z) {
        if (z) {
            startAnimation(this.f10940k);
        } else {
            getLayoutParams().width = this.f10946q;
            this.f10942m.a(false);
            this.f10938i.setEnabled(true);
            requestLayout();
        }
        this.f10943n = true;
    }

    private void m12951b(boolean z) {
        if (z) {
            startAnimation(this.f10941l);
        } else {
            this.f10938i.setVisibility(8);
        }
        this.f10943n = false;
    }

    public final void m12956e() {
        m12951b(true);
    }

    public ArrowDirection getArrowDirection() {
        return this.f10945p;
    }

    public int getArrowLength() {
        return (int) this.f10933d;
    }

    public final void m12953a(ArrowDirection arrowDirection, InsetContainerBounds insetContainerBounds) {
        this.f10936g.a(arrowDirection, insetContainerBounds);
        Rect rect = insetContainerBounds.b;
        rect.left -= this.f10952w;
        rect = insetContainerBounds.b;
        rect.right += this.f10952w;
        if (this.f10934e.k().booleanValue() && !this.f10943n) {
            rect = insetContainerBounds.b;
            rect.right += this.f10951v;
        }
        insetContainerBounds.a.set(insetContainerBounds.b);
        m12950b(arrowDirection, insetContainerBounds);
    }

    public final void m12952a(int i) {
        if (this.f10936g.getWidth() > 0) {
            this.f10936g.setArrowPosition(0.5f + (((float) i) / ((float) this.f10936g.getWidth())));
        }
    }

    private void m12950b(ArrowDirection arrowDirection, InsetContainerBounds insetContainerBounds) {
        insetContainerBounds.b.inset((int) (-this.f10932c), (int) (-this.f10932c));
        int i = (int) (-this.f10933d);
        Rect rect = insetContainerBounds.b;
        if (arrowDirection == ArrowDirection.UP || arrowDirection == ArrowDirection.UPLEFT || arrowDirection == ArrowDirection.UPRIGHT) {
            rect.top -= i;
        }
        if (arrowDirection == ArrowDirection.DOWN || arrowDirection == ArrowDirection.DOWNLEFT || arrowDirection == ArrowDirection.DOWNRIGHT) {
            rect.bottom += i;
        }
        if (arrowDirection == ArrowDirection.LEFT || arrowDirection == ArrowDirection.UPLEFT || arrowDirection == ArrowDirection.DOWNLEFT) {
            rect.left -= i;
        }
        if (arrowDirection == ArrowDirection.RIGHT || arrowDirection == ArrowDirection.UPRIGHT || arrowDirection == ArrowDirection.DOWNRIGHT) {
            rect.right += i;
        }
    }

    public void setArrowDirection(ArrowDirection arrowDirection) {
        this.f10945p = arrowDirection;
        this.f10936g.setArrowDirection(this.f10945p);
        Tag tag = this.f10934e;
        FaceBoxTarget a = m12947a(arrowDirection);
        if (tag.g.containsKey(a)) {
            tag.a.e().set((PointF) tag.g.get(a));
        }
        InsetContainerBounds insetContainerBounds = this.f10948s;
        insetContainerBounds.a.setEmpty();
        insetContainerBounds.b.setEmpty();
        m12950b(arrowDirection, this.f10948s);
        setPadding(this.f10948s.a(), this.f10948s.b(), this.f10948s.c(), this.f10948s.d());
    }

    private static FaceBoxTarget m12947a(ArrowDirection arrowDirection) {
        switch (C09483.f10929a[arrowDirection.ordinal()]) {
            case 1:
                return FaceBoxTarget.BOTTOM;
            case 2:
                return FaceBoxTarget.TOP;
            case 3:
                return FaceBoxTarget.RIGHT;
            case 4:
                return FaceBoxTarget.LEFT;
            case 5:
                return FaceBoxTarget.BOTTOMRIGHT;
            case 6:
                return FaceBoxTarget.BOTTOMLEFT;
            case 7:
                return FaceBoxTarget.TOPRIGHT;
            case 8:
                return FaceBoxTarget.TOPLEFT;
            default:
                throw new RuntimeException("Not all directions implemented");
        }
    }
}
