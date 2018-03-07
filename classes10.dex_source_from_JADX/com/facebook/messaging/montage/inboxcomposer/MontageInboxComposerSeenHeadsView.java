package com.facebook.messaging.montage.inboxcomposer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.seenheads.ThreadItemSeenHeadsDrawableController;
import com.facebook.messaging.seenheads.ThreadItemSeenHeadsDrawableController.OverflowType;
import com.facebook.messaging.seenheads.ThreadItemSeenHeadsDrawableController.StackingDirection;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileDrawableController;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: sample_content_reply_fragment */
public class MontageInboxComposerSeenHeadsView extends CustomFrameLayout {
    @Inject
    public Lazy<ThreadItemSeenHeadsDrawableController> f3311a;
    private Drawable f3312b;
    private boolean f3313c;

    private static <T extends View> void m3221a(Class<T> cls, T t) {
        m3222a((Object) t, t.getContext());
    }

    private static void m3222a(Object obj, Context context) {
        ((MontageInboxComposerSeenHeadsView) obj).f3311a = IdBasedLazy.a(FbInjector.get(context), 8337);
    }

    public MontageInboxComposerSeenHeadsView(Context context) {
        super(context);
        m3219a();
    }

    public MontageInboxComposerSeenHeadsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3219a();
    }

    public MontageInboxComposerSeenHeadsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3219a();
    }

    private void m3219a() {
        m3221a(MontageInboxComposerSeenHeadsView.class, (View) this);
        setWillNotDraw(false);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 713817662);
        super.onAttachedToWindow();
        ((ThreadItemSeenHeadsDrawableController) this.f3311a.get()).b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -321492583, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 67716163);
        ((ThreadItemSeenHeadsDrawableController) this.f3311a.get()).c();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1008740834, a);
    }

    public final void m3223a(ImmutableList<UserKey> immutableList) {
        if (immutableList.isEmpty()) {
            this.f3312b = null;
        } else {
            ThreadItemSeenHeadsDrawableController initializedSeenHeadsController = getInitializedSeenHeadsController();
            initializedSeenHeadsController.a(immutableList.subList(0, Math.min(3, immutableList.size())));
            this.f3312b = initializedSeenHeadsController.a;
        }
        requestLayout();
    }

    private ThreadItemSeenHeadsDrawableController getInitializedSeenHeadsController() {
        ThreadItemSeenHeadsDrawableController threadItemSeenHeadsDrawableController = (ThreadItemSeenHeadsDrawableController) this.f3311a.get();
        if (!this.f3313c) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(2131433681);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(2131433680);
            threadItemSeenHeadsDrawableController.h = resources.getDimensionPixelSize(2131433682);
            for (UserTileDrawableController a : threadItemSeenHeadsDrawableController.g) {
                a.a(threadItemSeenHeadsDrawableController.h);
            }
            threadItemSeenHeadsDrawableController.a(0, 0, 0, 0);
            threadItemSeenHeadsDrawableController.k = 3;
            threadItemSeenHeadsDrawableController.l = OverflowType.END;
            threadItemSeenHeadsDrawableController.m = StackingDirection.START;
            threadItemSeenHeadsDrawableController.j = dimensionPixelSize2;
            threadItemSeenHeadsDrawableController.b(dimensionPixelSize);
            this.f3313c = true;
        }
        return threadItemSeenHeadsDrawableController;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3312b != null) {
            this.f3312b.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f3312b.draw(canvas);
        }
    }

    protected void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int i3 = 0;
        if (this.f3312b != null) {
            intrinsicWidth = this.f3312b.getIntrinsicWidth();
            i3 = this.f3312b.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(intrinsicWidth, i), View.resolveSize(i3, i2));
    }

    private void m3220a(Lazy<ThreadItemSeenHeadsDrawableController> lazy) {
        this.f3311a = lazy;
    }
}
