package com.facebook.negativefeedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;

/* compiled from: non_self_add_intro_upsell_click */
public class NegativeFeedbackGuidedActionItemView extends CustomLinearLayout {
    private static final int[] f8076g = new int[]{2130773662};
    private static final int[] f8077h = new int[]{2130773663};
    private static final int[] f8078i = new int[]{2130773664};
    private NegativeFeedbackGuidedActionItemViewType f8079a;
    public GlyphView f8080b;
    public ContentView f8081c;
    public ProgressBar f8082d;
    public LazyView<FbTextView> f8083e;
    private boolean f8084f;

    public NegativeFeedbackGuidedActionItemView(Context context) {
        this(context, null);
    }

    private NegativeFeedbackGuidedActionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8079a = NegativeFeedbackGuidedActionItemViewType.INITIAL;
        this.f8084f = false;
        setContentView(2130905416);
        this.f8081c = (ContentView) a(2131564178);
        this.f8080b = (GlyphView) a(2131564181);
        this.f8082d = (ProgressBar) a(2131564180);
        this.f8083e = new LazyView((ViewStub) a(2131564179));
        setBackgroundDrawable(getContext().getResources().getDrawable(2130841631));
    }

    public final void m9759a(NegativeFeedbackGuidedActionItem negativeFeedbackGuidedActionItem) {
        this.f8080b.setImageResource(negativeFeedbackGuidedActionItem.m9758f());
        this.f8079a = negativeFeedbackGuidedActionItem.f8074c;
        this.f8084f = NegativeFeedbackGuidedActionsView.f8087c.containsKey(negativeFeedbackGuidedActionItem.m9757c());
        if (this.f8079a == NegativeFeedbackGuidedActionItemViewType.INITIATED) {
            setProgressBarVisibility(true);
        } else {
            setProgressBarVisibility(false);
        }
        if (this.f8079a == NegativeFeedbackGuidedActionItemViewType.ASK_TO_CONFIRM || (this.f8079a == NegativeFeedbackGuidedActionItemViewType.INITIATED && this.f8084f)) {
            this.f8081c.setTitleText(2131237752);
            this.f8081c.setSubtitleText(negativeFeedbackGuidedActionItem.m9756b());
            ((FbTextView) this.f8083e.a()).setVisibility(0);
            ((FbTextView) this.f8083e.a()).setText(getContext().getResources().getString(((Integer) NegativeFeedbackGuidedActionsView.f8087c.get(negativeFeedbackGuidedActionItem.m9757c())).intValue()));
            ((FbTextView) this.f8083e.a()).setTextColor(getResources().getColor(2131361917));
            this.f8081c.setTitleTextAppearance(2131626047);
            this.f8081c.setSubtitleTextAppearance(2131626048);
            this.f8080b.setGlyphColor(getResources().getColor(2131361917));
        } else {
            this.f8081c.setTitleText(negativeFeedbackGuidedActionItem.m9755a());
            this.f8081c.setSubtitleText(negativeFeedbackGuidedActionItem.m9756b());
        }
        this.f8081c.setThumbnailSize((int) getContext().getResources().getDimension(2131431890));
        if (this.f8079a != NegativeFeedbackGuidedActionItemViewType.INITIATED) {
            refreshDrawableState();
        }
    }

    private void setProgressBarVisibility(boolean z) {
        if (z) {
            this.f8082d.setVisibility(0);
            this.f8080b.setVisibility(8);
            return;
        }
        this.f8082d.setVisibility(8);
        this.f8080b.setVisibility(0);
    }

    public NegativeFeedbackGuidedActionItemViewType getViewType() {
        return this.f8079a;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        switch (this.f8079a) {
            case INITIAL:
                View.mergeDrawableStates(onCreateDrawableState, f8076g);
                break;
            case ASK_TO_CONFIRM:
                View.mergeDrawableStates(onCreateDrawableState, f8077h);
                break;
            case COMPLETED:
                View.mergeDrawableStates(onCreateDrawableState, f8078i);
                break;
            case INITIATED:
                if (!this.f8084f) {
                    View.mergeDrawableStates(onCreateDrawableState, f8076g);
                    break;
                }
                View.mergeDrawableStates(onCreateDrawableState, f8077h);
                break;
        }
        return onCreateDrawableState;
    }
}
