package com.facebook.tigon.tigonapi.observer;

import android.annotation.SuppressLint;
import com.facebook.common.objectpool.ObjectPool;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.tigon.tigonapi.TigonXplatService;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;

@DoNotStrip
/* compiled from: no_attachment */
public class TigonObservable {
    private final Executor f5071a;
    @SuppressLint({"ConstructorMayLeakThis"})
    public final ObjectPool<TigonObservableRunnable> f5072b;
    @DoNotStrip
    private final HybridData mHybridData;

    /* compiled from: no_attachment */
    @interface ObserverStep {
    }

    /* compiled from: no_attachment */
    public class TigonObservableRunnable implements Runnable {
        final /* synthetic */ TigonObservable f5068a;
        @ObserverStep
        public int f5069b;
        public TigonObserverData f5070c;

        private void m6354a() {
            TigonObservable tigonObservable;
            TigonObserverData tigonObserverData;
            switch (this.f5069b) {
                case 0:
                    tigonObservable = this.f5068a;
                    tigonObserverData = this.f5070c;
                    return;
                case 1:
                    tigonObservable = this.f5068a;
                    tigonObserverData = this.f5070c;
                    return;
                case 2:
                    tigonObservable = this.f5068a;
                    tigonObserverData = this.f5070c;
                    return;
                case 3:
                    tigonObservable = this.f5068a;
                    tigonObserverData = this.f5070c;
                    return;
                case 4:
                    tigonObservable = this.f5068a;
                    tigonObserverData = this.f5070c;
                    return;
                case 5:
                    tigonObservable = this.f5068a;
                    tigonObserverData = this.f5070c;
                    return;
                default:
                    throw new AssertionError("Unknown ObserverStep");
            }
        }

        public void run() {
            m6354a();
            this.f5068a.f5072b.a(this);
        }
    }

    private native HybridData initHybrid(TigonXplatService tigonXplatService);

    static /* synthetic */ void m6357a(TigonObservable tigonObservable, TigonRequestAdded tigonRequestAdded) {
    }

    static /* synthetic */ void m6358a(TigonObservable tigonObservable, TigonRequestErrored tigonRequestErrored) {
    }

    static /* synthetic */ void m6359a(TigonObservable tigonObservable, TigonRequestResponse tigonRequestResponse) {
    }

    static /* synthetic */ void m6360a(TigonObservable tigonObservable, TigonRequestStarted tigonRequestStarted) {
    }

    static /* synthetic */ void m6361a(TigonObservable tigonObservable, TigonRequestSucceeded tigonRequestSucceeded) {
    }

    static /* synthetic */ void m6362b(TigonObservable tigonObservable, TigonRequestErrored tigonRequestErrored) {
    }

    static {
        SoLoader.a("tigonliger");
    }

    private void m6356a(@ObserverStep int i, TigonObserverData tigonObserverData) {
        TigonObservableRunnable tigonObservableRunnable = (TigonObservableRunnable) this.f5072b.a();
        tigonObservableRunnable.f5069b = i;
        tigonObservableRunnable.f5070c = tigonObserverData;
        ExecutorDetour.a(this.f5071a, tigonObservableRunnable, -722386959);
    }

    @DoNotStrip
    private void onAdded(TigonObserverData tigonObserverData) {
        m6356a(0, tigonObserverData);
    }

    @DoNotStrip
    private void onStarted(TigonObserverData tigonObserverData) {
        m6356a(1, tigonObserverData);
    }

    @DoNotStrip
    private void onResponse(TigonObserverData tigonObserverData) {
        m6356a(2, tigonObserverData);
    }

    @DoNotStrip
    private void onEOM(TigonObserverData tigonObserverData) {
        m6356a(3, tigonObserverData);
    }

    @DoNotStrip
    private void onError(TigonObserverData tigonObserverData) {
        m6356a(4, tigonObserverData);
    }

    @DoNotStrip
    private void onWillRetry(TigonObserverData tigonObserverData) {
        m6356a(5, tigonObserverData);
    }
}
