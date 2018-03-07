package com.facebook.widget.loadingindicator;

import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;

/* compiled from: params */
public class LoadingIndicatorAdapter extends FbBaseAdapter implements LoadingIndicator {
    private final int f10390a;
    private String f10391b;
    private LoadingIndicatorState f10392c;
    private State f10393d;
    private RetryClickedListener f10394e;
    private LoadingIndicatorView f10395f;

    /* compiled from: params */
    /* synthetic */ class C06321 {
        static final /* synthetic */ int[] f14733a = new int[State.values().length];

        static {
            try {
                f14733a[State.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14733a[State.LOAD_FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14733a[State.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public LoadingIndicatorAdapter() {
        this(2130905109);
    }

    public LoadingIndicatorAdapter(@LayoutRes int i) {
        this.f10390a = i;
    }

    public View mo1985a(int i, ViewGroup viewGroup) {
        this.f10395f = (LoadingIndicatorView) LayoutInflater.from(viewGroup.getContext()).inflate(this.f10390a, viewGroup, false);
        return this.f10395f;
    }

    public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        m15481d();
    }

    public int getCount() {
        return 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final void m15483a() {
        m15480c();
        this.f10393d = State.LOADING;
        m15481d();
    }

    public final void m15487b() {
        m15480c();
        this.f10393d = State.LOAD_FINISHED;
        m15481d();
    }

    public final void m15486a(String str, RetryClickedListener retryClickedListener) {
        m15480c();
        this.f10393d = State.ERROR;
        this.f10391b = str;
        this.f10394e = retryClickedListener;
        m15481d();
    }

    private void m15480c() {
        this.f10391b = null;
        this.f10394e = null;
        this.f10392c = null;
    }

    private void m15481d() {
        if (this.f10395f != null) {
            m15485a(this.f10393d, this.f10395f);
        }
    }

    @CallSuper
    protected void m15485a(@Nullable State state, LoadingIndicatorView loadingIndicatorView) {
        if (state != null) {
            switch (C06321.f14733a[state.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    loadingIndicatorView.m20998a();
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    loadingIndicatorView.m21004b();
                    return;
                case 3:
                    if (this.f10392c != null) {
                        loadingIndicatorView.m21001a(this.f10392c, this.f10394e);
                        return;
                    } else {
                        loadingIndicatorView.m21002a(this.f10391b, this.f10394e);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
