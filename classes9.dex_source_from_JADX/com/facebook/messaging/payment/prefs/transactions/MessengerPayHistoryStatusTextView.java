package com.facebook.messaging.payment.prefs.transactions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.debug.log.BLog;
import com.facebook.resources.ui.FbTextView;

/* compiled from: from_module */
public class MessengerPayHistoryStatusTextView extends FbTextView {
    private static final Class<?> f14378a = MessengerPayHistoryStatusTextView.class;
    private static final int[] f14379b = new int[]{2130773762};
    private static final int[] f14380c = new int[]{2130773763};
    private static final int[] f14381d = new int[]{2130773764};
    private MessengerPayHistoryStatusViewState f14382e;

    public MessengerPayHistoryStatusTextView(Context context) {
        super(context);
    }

    public MessengerPayHistoryStatusTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MessengerPayHistoryStatusTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMessengerPayHistoryStatusState(MessengerPayHistoryStatusViewState messengerPayHistoryStatusViewState) {
        if (this.f14382e != messengerPayHistoryStatusViewState) {
            this.f14382e = messengerPayHistoryStatusViewState;
            refreshDrawableState();
        }
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.f14382e == null) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        switch (this.f14382e) {
            case PENDING:
                View.mergeDrawableStates(onCreateDrawableState, f14379b);
                return onCreateDrawableState;
            case CANCELED:
                View.mergeDrawableStates(onCreateDrawableState, f14380c);
                return onCreateDrawableState;
            case COMPLETED:
                View.mergeDrawableStates(onCreateDrawableState, f14381d);
                return onCreateDrawableState;
            default:
                BLog.a(f14378a, "Unknown MessengerPayHistoryStatusViewState %s found", new Object[]{this.f14382e});
                return onCreateDrawableState;
        }
    }
}
