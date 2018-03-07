package com.facebook.composer.minutiae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.ErrorCode;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.refreshableview.RefreshableViewState;

/* compiled from: tertiary_spec */
public class RidgeRefreshableListViewContainer extends RefreshableListViewContainer {
    private float f1898f = -1.0f;
    private LoadingPTRState f1899g = LoadingPTRState.NORMAL;

    /* compiled from: tertiary_spec */
    class C01951 implements Runnable {
        final /* synthetic */ RidgeRefreshableListViewContainer f1897a;

        C01951(RidgeRefreshableListViewContainer ridgeRefreshableListViewContainer) {
            this.f1897a = ridgeRefreshableListViewContainer;
        }

        public void run() {
            this.f1897a.i();
        }
    }

    /* compiled from: tertiary_spec */
    enum LoadingPTRState {
        NORMAL,
        PULLING_TO_REFRESH,
        IDLE_AFTER_REFRESH
    }

    public RidgeRefreshableListViewContainer(Context context) {
        super(context);
    }

    public RidgeRefreshableListViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RidgeRefreshableListViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -741381400);
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.f1898f = y;
                if (this.f1899g == LoadingPTRState.NORMAL) {
                    this.f1899g = LoadingPTRState.PULLING_TO_REFRESH;
                    break;
                }
                break;
            case 1:
            case 3:
                this.f1899g = LoadingPTRState.NORMAL;
                break;
            case 2:
                if (this.b != RefreshableViewState.FAILED || y <= this.f1898f) {
                    if (this.b == RefreshableViewState.LOADING && this.f1899g == LoadingPTRState.PULLING_TO_REFRESH && this.d > 1.5f * ((float) getHeaderHeight())) {
                        m1853m();
                        this.f1899g = LoadingPTRState.IDLE_AFTER_REFRESH;
                        break;
                    }
                }
                m1853m();
                break;
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1297339759, a);
        return onTouchEvent;
    }

    private void m1853m() {
        h();
        getHeaderView().b();
    }

    public RidgeRefreshableViewItem getHeaderView() {
        return (RidgeRefreshableViewItem) super.getHeaderView();
    }

    public final void m1857j() {
        f();
    }

    public final void m1854a(ErrorCode errorCode) {
        m1852b(getHeaderView().m1860a(errorCode));
    }

    public final void m1858k() {
        m1852b(getHeaderView().m1861e());
    }

    public final void m1859l() {
        f();
        e();
    }

    public final void m1855a(String str) {
        super.a(str);
        post(new C01951(this));
    }

    private void m1852b(String str) {
        h();
        e();
        a(str);
    }

    public final void m1856h() {
        if (this.b != RefreshableViewState.BUFFERING) {
            a(RefreshableViewState.BUFFERING);
        }
    }
}
