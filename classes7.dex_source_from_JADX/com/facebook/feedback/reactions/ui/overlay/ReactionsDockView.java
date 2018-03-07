package com.facebook.feedback.reactions.ui.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: send_roothash_to_server */
public abstract class ReactionsDockView extends View {
    public float f3980A;
    public float f3981B;
    public final Drawable f3982C;
    public int f3983D = -1;
    public Drawable f3984E;
    public Drawable f3985F;
    public ReactionsDockOverlay f3986G;
    public DockPosition f3987H = DockPosition.ABOVE_FOOTER;
    public boolean f3988I;
    public int f3989J;
    @Inject
    public RTLUtil f3990a;
    @Inject
    public GlyphColorizer f3991b;
    @Inject
    public ScreenUtil f3992c;
    protected final Drawable f3993d;
    protected final Paint f3994e;
    protected final int f3995f;
    public final int f3996g;
    public final int f3997h;
    public final int f3998i;
    public final int f3999j;
    protected final int f4000k;
    public final int f4001l;
    protected final int f4002m;
    protected final int f4003n;
    protected final int f4004o;
    protected final String f4005p;
    public final Rect f4006q = new Rect();
    public int f4007r;
    public int f4008s;
    public int f4009t;
    public int f4010u;
    public int f4011v;
    public int f4012w;
    public int f4013x;
    public int f4014y;
    public float f4015z;

    /* compiled from: send_roothash_to_server */
    public class FaceConfig {
        final /* synthetic */ ReactionsDockView f3972a;
        public final int f3973b;
        public final FeedbackReaction f3974c;
        public final Drawable f3975d;
        public final String f3976e = this.f3974c.f;
        public final float f3977f;
        public boolean f3978g;

        public FaceConfig(ReactionsDockView reactionsDockView, int i, FeedbackReaction feedbackReaction) {
            this.f3972a = reactionsDockView;
            this.f3973b = i;
            this.f3974c = feedbackReaction;
            this.f3975d = feedbackReaction.g().mutate();
            this.f3977f = reactionsDockView.f3994e.measureText(this.f3976e);
            this.f3975d.setCallback(reactionsDockView);
        }

        public final FeedbackReaction m4629b() {
            return this.f3974c;
        }

        public final Drawable m4630c() {
            return this.f3975d;
        }

        public final String m4631d() {
            return this.f3976e;
        }

        public final boolean m4632f() {
            return this.f3978g;
        }

        public final void m4628a(boolean z) {
            if (this.f3978g != z) {
                this.f3972a.invalidate();
            }
            this.f3978g = z;
        }
    }

    /* compiled from: send_roothash_to_server */
    public class ReactionsExploreByTouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ ReactionsDockView f3979b;

        public ReactionsExploreByTouchHelper(ReactionsDockView reactionsDockView, View view) {
            this.f3979b = reactionsDockView;
            super(view);
        }

        protected final int m4633a(float f, float f2) {
            int[] iArr = new int[2];
            this.f3979b.getLocationOnScreen(iArr);
            this.f3979b.mo186a(((float) iArr[0]) + f, ((float) iArr[1]) + f2);
            ImmutableList faceConfigs = this.f3979b.getFaceConfigs();
            for (int i = 0; i < faceConfigs.size(); i++) {
                if (this.f3979b.getCurrentReaction() == ((FaceConfig) faceConfigs.get(i)).f3974c) {
                    return i;
                }
            }
            return faceConfigs.size();
        }

        protected final void m4636a(List<Integer> list) {
            ImmutableList faceConfigs = this.f3979b.getFaceConfigs();
            for (int i = 0; i < faceConfigs.size() + 1; i++) {
                list.add(Integer.valueOf(i));
            }
        }

        protected final void m4635a(int i, AccessibilityEvent accessibilityEvent) {
            ImmutableList faceConfigs = this.f3979b.getFaceConfigs();
            if (i == faceConfigs.size()) {
                accessibilityEvent.getText().add(this.f3979b.f4005p);
            } else {
                accessibilityEvent.getText().add(((FaceConfig) faceConfigs.get(i)).f3976e);
            }
        }

        protected final void m4634a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.b(RopeStyleReactionsDockView.class.getName());
            accessibilityNodeInfoCompat.d(this.f3979b, i);
            ImmutableList faceConfigs = this.f3979b.getFaceConfigs();
            if (i == faceConfigs.size()) {
                accessibilityNodeInfoCompat.d(this.f3979b.f4005p);
                accessibilityNodeInfoCompat.b(new Rect(0, 0, 1, 1));
            } else {
                accessibilityNodeInfoCompat.d(((FaceConfig) faceConfigs.get(i)).f3976e);
                accessibilityNodeInfoCompat.b(this.f3979b.mo185a(i));
            }
            accessibilityNodeInfoCompat.a(16);
            accessibilityNodeInfoCompat.f(true);
        }

        protected final boolean m4637b(int i, int i2) {
            return false;
        }
    }

    public static void m4638a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactionsDockView reactionsDockView = (ReactionsDockView) obj;
        RTLUtil a = RTLUtil.a(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        ScreenUtil a3 = ScreenUtil.a(fbInjector);
        reactionsDockView.f3990a = a;
        reactionsDockView.f3991b = a2;
        reactionsDockView.f3992c = a3;
    }

    protected abstract Rect mo185a(int i);

    public abstract void mo186a(float f, float f2);

    public abstract boolean mo187b(MotionEvent motionEvent);

    public abstract void mo188c();

    public abstract void mo189d();

    public abstract void mo190e();

    public abstract boolean mo191f();

    public abstract FeedbackReaction getCurrentReaction();

    protected abstract ImmutableList<? extends FaceConfig> getFaceConfigs();

    public abstract PointerPosition getPointerPosition();

    protected abstract void setupReactionsImpl(List<FeedbackReaction> list);

    public ReactionsDockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ReactionsDockView.class;
        m4638a((Object) this, getContext());
        Resources resources = getResources();
        this.f3982C = resources.getDrawable(2130842933);
        this.f3982C.getPadding(this.f4006q);
        this.f3984E = this.f3982C;
        this.f3993d = resources.getDrawable(2130842934);
        this.f3996g = resources.getDimensionPixelSize(2131430625);
        this.f3997h = resources.getDimensionPixelSize(2131430626);
        this.f3998i = resources.getDimensionPixelSize(2131430627);
        this.f3999j = resources.getDimensionPixelSize(2131430624);
        this.f3995f = resources.getDimensionPixelSize(2131430623);
        this.f4000k = resources.getDimensionPixelSize(2131427485);
        this.f4001l = resources.getDimensionPixelSize(2131430628);
        this.f4002m = resources.getDimensionPixelSize(2131430629);
        this.f4003n = resources.getDimensionPixelSize(2131430630);
        this.f4004o = resources.getDimensionPixelSize(2131430631);
        this.f4005p = resources.getString(2131235959);
        Paint paint = new Paint();
        paint.setTextAlign(Align.LEFT);
        paint.setTextSize((float) this.f4001l);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(2131361920));
        this.f3994e = paint;
    }

    protected Drawable getBackgroundDrawable() {
        return this.f3984E;
    }

    public void setupReactions(List<FeedbackReaction> list) {
        if (list != null) {
            if (this.f3990a.a()) {
                list = Lists.a(list);
            }
            int size = list.size();
            if (this.f3989J != size) {
                int c = this.f3992c.c();
                if (((((((this.f3997h * 2) + ((size - 1) * this.f3998i)) + ((size - 1) * this.f3996g)) + ((int) (((float) this.f3996g) * 2.25f))) + this.f4006q.left) + this.f4006q.right) + (this.f3999j * 2) >= c) {
                    c = ((c - this.f4006q.left) - this.f4006q.right) - (this.f3999j * 2);
                    this.f4007r = Math.min((int) ((((float) c) * 0.8596f) / ((float) size)), this.f3996g);
                    this.f4009t = Math.min((c - (this.f4007r * size)) / (size + 1), this.f3998i);
                    this.f4008s = Math.min(this.f4009t, this.f3997h);
                } else {
                    this.f4007r = this.f3996g;
                    this.f4008s = this.f3997h;
                    this.f4009t = this.f3998i;
                }
                this.f4015z = ((((float) (this.f4007r * size)) - (((float) this.f4007r) * 2.25f)) / ((float) (size - 1))) / ((float) this.f4007r);
                this.f3980A = (1.0f - this.f4015z) / (2.25f - this.f4015z);
                this.f3981B = ((2.0f * ((float) this.f4009t)) / ((float) this.f4007r)) + 2.25f;
                this.f4010u = (int) ((((float) this.f4007r) * 2.25f) * 1.5f);
                this.f4011v = ((((this.f4008s * 2) + (this.f4007r * size)) + ((size - 1) * this.f4009t)) + this.f4006q.left) + this.f4006q.right;
                this.f4012w = this.f4011v;
                this.f4014y = (((this.f4008s * 2) + ((int) (((float) this.f4007r) * this.f4015z))) + this.f4006q.top) + this.f4006q.bottom;
                this.f4013x = (((this.f4008s * 2) + this.f4007r) + this.f4006q.top) + this.f4006q.bottom;
                this.f3989J = size;
                requestLayout();
            }
            setupReactionsImpl(list);
        }
    }

    protected final boolean m4641a() {
        return this.f3987H == DockPosition.ABOVE_FOOTER;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1188834566);
        super.onAttachedToWindow();
        this.f3988I = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1345366758, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -498701610);
        super.onDetachedFromWindow();
        this.f3988I = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1383811717, a);
    }

    protected void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1342966200);
        super.onWindowVisibilityChanged(i);
        if (!(i == 0 || this.f3986G == null || VERSION.SDK_INT < 17)) {
            this.f3986G.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 687215436, a);
    }
}
