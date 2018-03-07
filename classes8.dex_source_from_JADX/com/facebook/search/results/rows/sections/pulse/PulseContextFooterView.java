package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterDividerPainter;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: PROFILE_PHOTO_COMPLETE */
public class PulseContextFooterView extends CustomLinearLayout implements Footer {
    public static final ViewType f24805a = new C26151();
    @Inject
    public GlyphColorizer f24806b;
    @Inject
    public FooterDividerPainter f24807c;
    private final ImmutableMap<FooterButtonId, FeedbackCustomPressStateButton> f24808d;
    private final ViewGroup f24809e;
    private final OptionalButtonListener f24810f;

    /* compiled from: PROFILE_PHOTO_COMPLETE */
    final class C26151 extends ViewType {
        C26151() {
        }

        public final View m28196a(Context context) {
            return new PulseContextFooterView(context);
        }
    }

    /* compiled from: PROFILE_PHOTO_COMPLETE */
    public class DelegatingOnClickListener implements OnClickListener {
        private final FooterButtonId f24802a;
        private final ButtonClickedListener f24803b;

        public DelegatingOnClickListener(FooterButtonId footerButtonId, ButtonClickedListener buttonClickedListener) {
            this.f24802a = footerButtonId;
            this.f24803b = buttonClickedListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1171619000);
            this.f24803b.a(view, this.f24802a);
            Logger.a(2, EntryType.UI_INPUT_END, -1090299774, a);
        }
    }

    /* compiled from: PROFILE_PHOTO_COMPLETE */
    public class OptionalButtonListener implements ButtonClickedListener {
        @Nullable
        public ButtonClickedListener f24804a;

        public final void m28197a(View view, FooterButtonId footerButtonId) {
            if (this.f24804a != null) {
                this.f24804a.a(view, footerButtonId);
            }
        }
    }

    public static void m28200a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PulseContextFooterView pulseContextFooterView = (PulseContextFooterView) obj;
        GlyphColorizer a = GlyphColorizer.a(fbInjector);
        FooterDividerPainter b = FooterDividerPainter.b(fbInjector);
        pulseContextFooterView.f24806b = a;
        pulseContextFooterView.f24807c = b;
    }

    public PulseContextFooterView(Context context) {
        this(context, null);
    }

    private PulseContextFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = PulseContextFooterView.class;
        m28200a((Object) this, getContext());
        setContentView(2130906511);
        setOrientation(1);
        int c = ContextUtils.c(getContext(), 2130772570, -7235677);
        this.f24808d = ImmutableMap.of(FooterButtonId.VISIT_LINK, m28199a(m28198a(2130839952, c), 2131239030, 2131566447, FeedbackCustomPressStateButton.a), FooterButtonId.SHARE, m28199a(m28198a(2130843792, c), 2131239033, 2131566448, FeedbackCustomPressStateButton.a), FooterButtonId.SAVE, m28199a(m28198a(2130839719, c), 2131239031, 2131566449, FeedbackCustomPressStateButton.a));
        this.f24809e = (ViewGroup) a(2131566446);
        this.f24810f = new OptionalButtonListener();
        Iterator it = this.f24808d.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ((FeedbackCustomPressStateButton) entry.getValue()).setOnClickListener(new DelegatingOnClickListener((FooterButtonId) entry.getKey(), this.f24810f));
        }
    }

    private FeedbackCustomPressStateButton m28199a(Drawable drawable, int i, int i2, int i3) {
        FeedbackCustomPressStateButton feedbackCustomPressStateButton = (FeedbackCustomPressStateButton) a(i2);
        feedbackCustomPressStateButton.setText(i);
        feedbackCustomPressStateButton.setSoundEffectsEnabled(false);
        feedbackCustomPressStateButton.setImageDrawable(drawable);
        feedbackCustomPressStateButton.setWarmupBackgroundResId(i3);
        return feedbackCustomPressStateButton;
    }

    private Drawable m28198a(int i, int i2) {
        return this.f24806b.a(i, i2);
    }

    public void setDownstateType(DownstateType downstateType) {
        Iterator it = this.f24808d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).setDownstateType(downstateType);
        }
    }

    public void setButtonContainerBackground(Drawable drawable) {
        CustomViewUtils.b(this.f24809e, drawable);
    }

    public void setButtonContainerHeight(int i) {
        LayoutParams layoutParams = this.f24809e.getLayoutParams();
        layoutParams.height = i;
        this.f24809e.setLayoutParams(layoutParams);
    }

    public void setIsLiked(boolean z) {
    }

    public void setHasCachedComments(boolean z) {
    }

    public void setButtons(Set<FooterButtonId> set) {
        Iterator it = this.f24808d.keySet().iterator();
        while (it.hasNext()) {
            FooterButtonId footerButtonId = (FooterButtonId) it.next();
            ((FeedbackCustomPressStateButton) this.f24808d.get(footerButtonId)).setVisibility(set.contains(footerButtonId) ? 0 : 8);
        }
    }

    public void setSprings(EnumMap<FooterButtonId, TouchSpring> enumMap) {
        for (FooterButtonId footerButtonId : enumMap.keySet()) {
            ((FeedbackCustomPressStateButton) this.f24808d.get(footerButtonId)).setSpring((TouchSpring) enumMap.get(footerButtonId));
        }
    }

    public final void m28202a() {
        Iterator it = this.f24808d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).b();
        }
    }

    public void setOnButtonClickedListener(ButtonClickedListener buttonClickedListener) {
        this.f24810f.f24804a = buttonClickedListener;
    }

    public final View m28201a(FooterButtonId footerButtonId) {
        return (View) this.f24808d.get(footerButtonId);
    }

    public void setTopDividerStyle(DividerStyle dividerStyle) {
        this.f24807c.d = dividerStyle;
    }

    public void setBottomDividerStyle(DividerStyle dividerStyle) {
        this.f24807c.e = dividerStyle;
    }

    public void setButtonWeights(float[] fArr) {
        UnmodifiableIterator it = this.f24808d.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            LayoutParams layoutParams = ((FeedbackCustomPressStateButton) it.next()).getLayoutParams();
            if (layoutParams != null) {
                ((LinearLayout.LayoutParams) layoutParams).weight = fArr[i];
            }
            i++;
        }
    }

    public void setShowIcons(boolean z) {
        UnmodifiableIterator it = this.f24808d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).a(z);
        }
    }

    public void setEnabled(boolean z) {
        Iterator it = this.f24808d.values().iterator();
        while (it.hasNext()) {
            ((FeedbackCustomPressStateButton) it.next()).setEnabled(z);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f24807c.a(this, canvas);
    }
}
