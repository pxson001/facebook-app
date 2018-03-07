package com.facebook.widget.loadingindicator;

import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorState.Builder;

/* compiled from: recommended_product_opened */
public class LoadingIndicatorController implements LoadingIndicator {
    public LoadingIndicatorState f6102a;
    private LoadingIndicatorView f6103b;
    private RetryClickedListener f6104c;

    /* compiled from: recommended_product_opened */
    /* synthetic */ class C03661 {
        static final /* synthetic */ int[] f6101a = new int[State.values().length];

        static {
            try {
                f6101a[State.LOAD_FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6101a[State.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6101a[State.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public LoadingIndicatorController(LoadingIndicatorState loadingIndicatorState, RetryClickedListener retryClickedListener) {
        if (loadingIndicatorState == null) {
            loadingIndicatorState = new Builder().m8680a();
        }
        this.f6102a = loadingIndicatorState;
        this.f6104c = retryClickedListener;
    }

    public final void m8674a() {
        this.f6102a.f6109a = State.LOADING;
        m8673e();
    }

    public final void m8678b() {
        this.f6102a.f6109a = State.LOAD_FINISHED;
        m8673e();
    }

    public final void m8675a(LoadingIndicatorState loadingIndicatorState) {
        this.f6102a = loadingIndicatorState;
        m8673e();
    }

    public final void m8677a(String str, RetryClickedListener retryClickedListener) {
        this.f6102a.f6109a = State.ERROR;
        this.f6102a.f6110b = str;
        this.f6104c = retryClickedListener;
        m8673e();
    }

    public final void m8676a(LoadingIndicatorView loadingIndicatorView) {
        this.f6103b = loadingIndicatorView;
        m8673e();
    }

    public final void m8679c() {
        this.f6103b = null;
    }

    private void m8673e() {
        if (this.f6103b != null) {
            switch (C03661.f6101a[this.f6102a.f6109a.ordinal()]) {
                case 1:
                    this.f6103b.b();
                    return;
                case 2:
                    this.f6103b.a();
                    return;
                case 3:
                    this.f6103b.a(this.f6102a, this.f6104c);
                    return;
                default:
                    return;
            }
        }
    }
}
