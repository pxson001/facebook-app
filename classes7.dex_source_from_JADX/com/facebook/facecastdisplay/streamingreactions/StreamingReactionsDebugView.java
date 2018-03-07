package com.facebook.facecastdisplay.streamingreactions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.SparseArrayUtil;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: starting_index */
public class StreamingReactionsDebugView extends CustomLinearLayout {
    @Inject
    public FeedbackReactionsController f3334a;
    private final List<ReactionCountTextView> f3335b;

    /* compiled from: starting_index */
    class ReactionCountTextView extends TextView {
        public final int f3332a;
        private int f3333b;

        public ReactionCountTextView(Context context, Drawable drawable, int i) {
            super(context);
            this.f3332a = i;
            setCompoundDrawables(drawable, null, null, null);
            setTextColor(getResources().getColor(17170443));
            setShadowLayer(10.0f, 0.0f, 0.0f, getResources().getColor(17170444));
        }

        public final void m4083a(int i) {
            if (this.f3333b == 0) {
                setText(String.valueOf(i));
            } else {
                setText(i + " " + (i - this.f3333b));
            }
            this.f3333b = i;
        }
    }

    private static <T extends View> void m4085a(Class<T> cls, T t) {
        m4086a((Object) t, t.getContext());
    }

    private static void m4086a(Object obj, Context context) {
        ((StreamingReactionsDebugView) obj).f3334a = FeedbackReactionsController.a(FbInjector.get(context));
    }

    public StreamingReactionsDebugView(Context context) {
        this(context, null);
    }

    public StreamingReactionsDebugView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StreamingReactionsDebugView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4085a(StreamingReactionsDebugView.class, (View) this);
        setOrientation(1);
        View textView = new TextView(context);
        textView.setText("Tap to close");
        textView.setTextColor(getResources().getColor(17170443));
        textView.setShadowLayer(10.0f, 0.0f, 0.0f, getResources().getColor(17170444));
        addView(textView, -2, -2);
        textView.setPadding(2, 2, 2, 2);
        this.f3335b = new ArrayList();
    }

    public void setCurrentReactions(SparseArray<Integer> sparseArray) {
        for (int i : SparseArrayUtil.a(sparseArray)) {
            int intValue = ((Integer) sparseArray.get(i, Integer.valueOf(0))).intValue();
            if (intValue != 0) {
                for (ReactionCountTextView reactionCountTextView : this.f3335b) {
                    if (reactionCountTextView.f3332a == i) {
                        break;
                    }
                }
                ReactionCountTextView reactionCountTextView2 = null;
                if (reactionCountTextView2 == null) {
                    Drawable g = this.f3334a.b(i).g();
                    int dimensionPixelSize = getResources().getDimensionPixelSize(2131428049);
                    g.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    reactionCountTextView2 = new ReactionCountTextView(getContext(), g, i);
                    addView(reactionCountTextView2, -2, -2);
                    reactionCountTextView2.setPadding(2, 2, 2, 2);
                    this.f3335b.add(reactionCountTextView2);
                }
                reactionCountTextView2.m4083a(intValue);
            }
        }
    }

    public final void m4087a() {
        for (ReactionCountTextView removeView : this.f3335b) {
            removeView(removeView);
        }
        this.f3335b.clear();
    }

    private void m4084a(FeedbackReactionsController feedbackReactionsController) {
        this.f3334a = feedbackReactionsController;
    }
}
