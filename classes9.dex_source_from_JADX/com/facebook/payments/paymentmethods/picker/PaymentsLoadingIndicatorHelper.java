package com.facebook.payments.paymentmethods.picker;

import android.view.View;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorState.Builder;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;

/* compiled from: bookmark_type */
public class PaymentsLoadingIndicatorHelper {
    private final LoadingIndicatorView f18767a;
    private final View f18768b;

    public PaymentsLoadingIndicatorHelper(LoadingIndicatorView loadingIndicatorView, View view) {
        this.f18767a = loadingIndicatorView;
        this.f18768b = view;
    }

    public final void m18776a() {
        this.f18767a.a();
        this.f18768b.setVisibility(4);
        this.f18768b.setAlpha(0.2f);
    }

    public final void m18778b() {
        this.f18767a.b();
        this.f18768b.setVisibility(0);
        this.f18768b.setAlpha(1.0f);
    }

    public final void m18777a(RetryClickedListener retryClickedListener) {
        Builder newBuilder = LoadingIndicatorState.newBuilder();
        newBuilder.a = State.ERROR;
        newBuilder = newBuilder;
        newBuilder.b = this.f18768b.getContext().getString(2131230758);
        this.f18767a.a(newBuilder.a(), retryClickedListener);
    }
}
