package com.facebook.backstage.consumption.reply;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ride_id */
public class EmojiMenuView extends CustomFrameLayout {
    @Inject
    BackstageAnalyticsLogger f4937a;
    private final OnClickListener f4938b;
    public OnEmojiClickListener f4939c;

    /* compiled from: ride_id */
    class C05151 implements OnClickListener {
        final /* synthetic */ EmojiMenuView f4932a;

        C05151(EmojiMenuView emojiMenuView) {
            this.f4932a = emojiMenuView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -452387750);
            this.f4932a.f4939c.mo183a(((TextView) view).getText());
            this.f4932a.f4937a.m4264a(Event.EMOJI_REPLY_SELECTED);
            this.f4932a.m4784a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1220384672, a);
        }
    }

    /* compiled from: ride_id */
    class C05173 implements OnFinishListener {
        final /* synthetic */ EmojiMenuView f4936a;

        C05173(EmojiMenuView emojiMenuView) {
            this.f4936a = emojiMenuView;
        }

        public final void mo142a() {
            this.f4936a.setVisibility(8);
        }
    }

    /* compiled from: ride_id */
    public interface OnEmojiClickListener {
        void mo183a(CharSequence charSequence);
    }

    public EmojiMenuView(Context context) {
        this(context, null);
    }

    public EmojiMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiMenuView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4938b = new C05151(this);
    }

    public void setOnEmojiClickListener(OnEmojiClickListener onEmojiClickListener) {
        this.f4939c = onEmojiClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new UnsupportedOperationException("Please use setOnEmojiClickListener instead.");
    }

    public void setAvailableEmojis(ImmutableList<Editable> immutableList) {
        for (int i = 0; i < immutableList.size(); i++) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            View textView = new TextView(getContext());
            textView.setText((CharSequence) immutableList.get(i));
            textView.setTextSize(0, getResources().getDimension(2131433280));
            textView.setOnClickListener(this.f4938b);
            addView(textView, layoutParams);
        }
    }

    public final void m4790a(final int i, final int i2) {
        this.f4937a.m4264a(Event.EMOJI_REPLY_MENU_OPEN);
        setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ EmojiMenuView f4935c;

            public void onGlobalLayout() {
                EmojiMenuView.m4787b(this.f4935c, i, i2);
                this.f4935c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public static void m4787b(EmojiMenuView emojiMenuView, int i, int i2) {
        int width = emojiMenuView.getWidth() / 2;
        int height = emojiMenuView.getHeight() / 2;
        emojiMenuView.setX((float) (i - width));
        emojiMenuView.setY((float) (i2 - height));
        View view = (View) Preconditions.checkNotNull(emojiMenuView.getChildAt(0));
        int width2 = (int) (((float) (emojiMenuView.getWidth() - (view.getWidth() * 2))) * 0.5f);
        width -= view.getWidth() / 2;
        height -= view.getHeight() / 2;
        int childCount = emojiMenuView.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = emojiMenuView.getChildAt(i3);
            if (!ViewAnimator.m5752a(childAt).m5758c()) {
                float c = m4788c(i3, childCount);
                childAt.setAlpha(1.0f);
                ViewAnimator.m5752a(childAt).m5761e().m5756b((float) width, ((float) width) + (((float) width2) * ((float) Math.cos((double) c)))).m5757c((float) height, (((float) Math.sin((double) c)) * ((float) width2)) + ((float) height)).m5759d();
                i3++;
            } else {
                return;
            }
        }
    }

    public final void m4789a() {
        this.f4937a.m4264a(Event.EMOJI_REPLY_MENU_DISMISSED);
        m4784a(null);
    }

    private void m4784a(@Nullable View view) {
        View view2 = (View) Preconditions.checkNotNull(getChildAt(0));
        int width = (getWidth() / 2) - (view2.getWidth() / 2);
        int height = (getHeight() / 2) - (view2.getHeight() / 2);
        int width2 = (int) (((float) getWidth()) * 0.4f);
        int childCount = getChildCount();
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if (!ViewAnimator.m5752a(childAt).m5758c()) {
                float c = m4788c(i, childCount);
                float cos = ((float) width) + (((float) width2) * ((float) Math.cos((double) c)));
                c = (((float) Math.sin((double) c)) * ((float) width2)) + ((float) height);
                ViewAnimator.m5752a(childAt).f5528e = new C05173(this);
                if (view == null) {
                    ViewAnimator.m5752a(childAt).m5756b(cos, (float) width).m5757c(c, (float) height).m5760d(1.0f, 0.0f).m5759d();
                } else if (childAt != view) {
                    ViewAnimator.m5752a(childAt).m5760d(1.0f, 0.0f).m5759d();
                } else {
                    ViewAnimator.m5752a(childAt).m5756b(cos, (float) width).m5757c(c, (float) height).m5759d();
                }
                i++;
            } else {
                return;
            }
        }
    }

    private static float m4788c(int i, int i2) {
        return (float) (((((double) (((float) i) * 2.0f)) * 3.141592653589793d) / ((double) i2)) - 1.5707963267948966d);
    }

    public final boolean m4791b() {
        return getVisibility() == 0;
    }
}
