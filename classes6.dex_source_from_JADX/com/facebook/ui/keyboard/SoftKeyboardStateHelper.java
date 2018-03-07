package com.facebook.ui.keyboard;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.rapidfeedback.RapidFeedbackDialogFragment;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: search_quick_promotion */
public class SoftKeyboardStateHelper implements OnGlobalLayoutListener {
    public final List<SoftKeyboardStateListener> f5157a;
    private final View f5158b;
    private boolean f5159c;

    public SoftKeyboardStateHelper(View view) {
        this(view, false);
    }

    private SoftKeyboardStateHelper(View view, boolean z) {
        this.f5157a = Lists.b();
        this.f5158b = view;
        this.f5159c = z;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f5158b.getWindowVisibleDisplayFrame(rect);
        int height = this.f5158b.getRootView().getHeight() - rect.bottom;
        if (!this.f5159c && height > 100) {
            this.f5159c = true;
            for (RapidFeedbackDialogFragment rapidFeedbackDialogFragment : this.f5157a) {
                if (rapidFeedbackDialogFragment != null) {
                    rapidFeedbackDialogFragment.at.m23004b(height);
                }
            }
        } else if (this.f5159c && height > 100) {
            for (RapidFeedbackDialogFragment rapidFeedbackDialogFragment2 : this.f5157a) {
                if (rapidFeedbackDialogFragment2 != null) {
                    rapidFeedbackDialogFragment2.at.m23004b(height);
                }
            }
        } else if (this.f5159c && height < 100) {
            this.f5159c = false;
            for (RapidFeedbackDialogFragment rapidFeedbackDialogFragment22 : this.f5157a) {
                if (rapidFeedbackDialogFragment22 != null) {
                    rapidFeedbackDialogFragment22.at.m23003b();
                }
            }
        }
    }
}
