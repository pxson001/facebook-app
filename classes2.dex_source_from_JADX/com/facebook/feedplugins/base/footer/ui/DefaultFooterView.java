package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gk_android_mediaplayer_prepare */
public class DefaultFooterView extends CustomLinearLayout implements ReactionsAnchorFooter {
    public static final ViewType f22314a = new C09061();
    @Inject
    GlyphColorizer f22315b;
    @Inject
    FooterDividerPainter f22316c;
    private final ImmutableMap<FooterButtonId, FeedbackCustomPressStateButton> f22317d;
    private final ViewGroup f22318e;
    private final OptionalButtonListener f22319f;
    private final int f22320g;

    /* compiled from: gk_android_mediaplayer_prepare */
    final class C09061 extends ViewType {
        C09061() {
        }

        public final View mo1995a(Context context) {
            return new DefaultFooterView(context);
        }
    }

    /* compiled from: gk_android_mediaplayer_prepare */
    public class OptionalButtonListener implements ButtonClickedListener {
        @Nullable
        public ButtonClickedListener f22343a;

        public final void m30278a(@Nullable ButtonClickedListener buttonClickedListener) {
            this.f22343a = buttonClickedListener;
        }

        public final void mo3276a(View view, FooterButtonId footerButtonId) {
            if (this.f22343a != null) {
                this.f22343a.mo3276a(view, footerButtonId);
            }
        }
    }

    /* compiled from: gk_android_mediaplayer_prepare */
    public class DelegatingOnClickListener implements OnClickListener {
        private final FooterButtonId f22344a;
        private final ButtonClickedListener f22345b;

        public DelegatingOnClickListener(FooterButtonId footerButtonId, ButtonClickedListener buttonClickedListener) {
            this.f22344a = footerButtonId;
            this.f22345b = buttonClickedListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 497061073);
            this.f22345b.mo3276a(view, this.f22344a);
            Logger.a(2, EntryType.UI_INPUT_END, 995587543, a);
        }
    }

    private static <T extends View> void m30258a(Class<T> cls, T t) {
        m30259a((Object) t, t.getContext());
    }

    private static void m30259a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DefaultFooterView) obj).m30257a(GlyphColorizer.m11486a(injectorLike), FooterDividerPainter.m30246b(injectorLike));
    }

    private void m30257a(GlyphColorizer glyphColorizer, FooterDividerPainter footerDividerPainter) {
        this.f22315b = glyphColorizer;
        this.f22316c = footerDividerPainter;
    }

    public DefaultFooterView(Context context) {
        this(context, null);
    }

    public DefaultFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m30258a(DefaultFooterView.class, (View) this);
        setContentView(2130903875);
        setOrientation(1);
        this.f22320g = ContextUtils.m2503c(getContext(), 2130772570, -7235677);
        Builder builder = ImmutableMap.builder();
        builder.m609b(FooterButtonId.LIKE, (FeedbackCustomPressStateButton) m8506a(2131560943));
        builder.m609b(FooterButtonId.COMMENT, m30256a(m30255a(2130843788, this.f22320g), 2131233269, 2131560944, FeedbackCustomPressStateButton.f22330a));
        builder.m609b(FooterButtonId.SHARE, m30256a(m30255a(2130843792, this.f22320g), 2131233280, 2131560945, FeedbackCustomPressStateButton.f22330a));
        this.f22317d = builder.m610b();
        this.f22318e = (ViewGroup) m8506a(2131559200);
        this.f22319f = new OptionalButtonListener();
        Iterator it = this.f22317d.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ((FeedbackCustomPressStateButton) entry.getValue()).setOnClickListener(new DelegatingOnClickListener((FooterButtonId) entry.getKey(), this.f22319f));
        }
        TrackingNodes.m27141a((View) this, TrackingNode.FEEDBACK_SECTION);
        TrackingNodes.m27141a((View) this.f22317d.get(FooterButtonId.LIKE), TrackingNode.LIKE_LINK);
        TrackingNodes.m27141a((View) this.f22317d.get(FooterButtonId.COMMENT), TrackingNode.COMMENT_LINK);
        TrackingNodes.m27141a((View) this.f22317d.get(FooterButtonId.SHARE), TrackingNode.SHARE_LINK);
    }

    private FeedbackCustomPressStateButton m30256a(Drawable drawable, int i, int i2, int i3) {
        FeedbackCustomPressStateButton feedbackCustomPressStateButton = (FeedbackCustomPressStateButton) m8506a(i2);
        feedbackCustomPressStateButton.setText(i);
        feedbackCustomPressStateButton.setSoundEffectsEnabled(false);
        feedbackCustomPressStateButton.setImageDrawable(drawable);
        feedbackCustomPressStateButton.setWarmupBackgroundResId(i3);
        return feedbackCustomPressStateButton;
    }

    private Drawable m30255a(int i, int i2) {
        return this.f22315b.m11489a(i, i2);
    }

    public void setDownstateType(DownstateType downstateType) {
        Iterator it = this.f22317d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).setDownstateType(downstateType);
        }
    }

    public void setButtonContainerBackground(Drawable drawable) {
        CustomViewUtils.m30286b(this.f22318e, drawable);
    }

    public void setButtonContainerHeight(int i) {
        LayoutParams layoutParams = this.f22318e.getLayoutParams();
        layoutParams.height = i;
        this.f22318e.setLayoutParams(layoutParams);
    }

    public void setIsLiked(boolean z) {
        ((FooterLikeButton) this.f22317d.get(FooterButtonId.LIKE)).setIsLiked(z);
    }

    public void setHasCachedComments(boolean z) {
        if (z) {
            ((FeedbackCustomPressStateButton) this.f22317d.get(FooterButtonId.COMMENT)).setImageDrawable(m30255a(2130843789, this.f22320g));
        } else {
            ((FeedbackCustomPressStateButton) this.f22317d.get(FooterButtonId.COMMENT)).setImageDrawable(m30255a(2130843788, this.f22320g));
        }
    }

    public void setButtons(Set<FooterButtonId> set) {
        Iterator it = this.f22317d.keySet().iterator();
        while (it.hasNext()) {
            FooterButtonId footerButtonId = (FooterButtonId) it.next();
            ((FeedbackCustomPressStateButton) this.f22317d.get(footerButtonId)).setVisibility(set.contains(footerButtonId) ? 0 : 8);
        }
    }

    public void setSprings(EnumMap<FooterButtonId, TouchSpring> enumMap) {
        for (FooterButtonId footerButtonId : enumMap.keySet()) {
            ((FeedbackCustomPressStateButton) this.f22317d.get(footerButtonId)).setSpring((TouchSpring) enumMap.get(footerButtonId));
        }
    }

    public final void mo3251a() {
        Iterator it = this.f22317d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).mo3275b();
        }
    }

    public void setOnButtonClickedListener(ButtonClickedListener buttonClickedListener) {
        this.f22319f.f22343a = buttonClickedListener;
    }

    public final View mo3250a(FooterButtonId footerButtonId) {
        return (View) this.f22317d.get(footerButtonId);
    }

    public void setTopDividerStyle(DividerStyle dividerStyle) {
        this.f22316c.f22312d = dividerStyle;
    }

    public void setBottomDividerStyle(DividerStyle dividerStyle) {
        this.f22316c.f22313e = dividerStyle;
    }

    public void setFooterVisibility(int i) {
        setVisibility(i);
    }

    public void setFooterAlpha(float f) {
        ViewCompat.m10954c(this, f);
    }

    public void setButtonWeights(float[] fArr) {
        Iterator it = this.f22317d.values().iterator();
        Object obj = null;
        int i = 0;
        while (it.hasNext()) {
            Object obj2;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((FeedbackCustomPressStateButton) it.next()).getLayoutParams();
            if (layoutParams == null || layoutParams.weight == fArr[i]) {
                obj2 = obj;
            } else {
                layoutParams.weight = fArr[i];
                obj2 = 1;
            }
            i++;
            obj = obj2;
        }
        if (obj != null) {
            this.f22318e.requestLayout();
            this.f22318e.invalidate();
        }
    }

    public void setShowIcons(boolean z) {
        Iterator it = this.f22317d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).mo2813a(z);
        }
    }

    public void setEnabled(boolean z) {
        Iterator it = this.f22317d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).setEnabled(z);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f22316c.m30247a(this, canvas);
    }

    public View getReactionsDockAnchor() {
        return this;
    }
}
