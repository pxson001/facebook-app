package com.facebook.react.uimanager;

import android.view.Choreographer.FrameCallback;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: frame wait timed out */
public class UIViewOperationQueue {
    public final int[] f11848a = new int[4];
    public final NativeViewHierarchyManager f11849b;
    private final AnimationRegistry f11850c;
    public final Object f11851d = new Object();
    public final Object f11852e = new Object();
    private final DispatchUIFrameCallback f11853f;
    private final ReactApplicationContext f11854g;
    @GuardedBy("mDispatchRunnablesLock")
    public final ArrayList<Runnable> f11855h = new ArrayList();
    private ArrayList<UIOperation> f11856i = new ArrayList();
    @GuardedBy("mNonBatchedOperationsLock")
    public ArrayDeque<UIOperation> f11857j = new ArrayDeque();
    @Nullable
    public NotThreadSafeViewHierarchyUpdateDebugListener f11858k;

    /* compiled from: frame wait timed out */
    public interface UIOperation {
        void mo749a();
    }

    /* compiled from: frame wait timed out */
    public abstract class ViewOperation implements UIOperation {
        public int f11799b;
        final /* synthetic */ UIViewOperationQueue f11800c;

        public ViewOperation(UIViewOperationQueue uIViewOperationQueue, int i) {
            this.f11800c = uIViewOperationQueue;
            this.f11799b = i;
        }
    }

    /* compiled from: frame wait timed out */
    final class ChangeJSResponderOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11801a;
        private final int f11802d;
        private final boolean f11803e;
        private final boolean f11804f;

        public ChangeJSResponderOperation(UIViewOperationQueue uIViewOperationQueue, int i, int i2, boolean z, boolean z2) {
            this.f11801a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11802d = i2;
            this.f11804f = z;
            this.f11803e = z2;
        }

        public final void mo749a() {
            if (this.f11804f) {
                this.f11801a.f11849b.m13885b();
            } else {
                this.f11801a.f11849b.m13872a(this.f11799b, this.f11802d, this.f11803e);
            }
        }
    }

    /* compiled from: frame wait timed out */
    class ConfigureLayoutAnimationOperation implements UIOperation {
        final /* synthetic */ UIViewOperationQueue f11805a;
        private final ReadableMap f11806b;

        public ConfigureLayoutAnimationOperation(UIViewOperationQueue uIViewOperationQueue, ReadableMap readableMap) {
            this.f11805a = uIViewOperationQueue;
            this.f11806b = readableMap;
        }

        public final void mo749a() {
            this.f11805a.f11849b.m13881a(this.f11806b);
        }
    }

    /* compiled from: frame wait timed out */
    final class CreateViewOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11807a;
        private final ThemedReactContext f11808d;
        private final String f11809e;
        @Nullable
        private final ReactStylesDiffMap f11810f;

        public CreateViewOperation(UIViewOperationQueue uIViewOperationQueue, ThemedReactContext themedReactContext, int i, String str, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
            this.f11807a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11808d = themedReactContext;
            this.f11809e = str;
            this.f11810f = reactStylesDiffMap;
            Systrace.d(33554432, "createView", this.f11799b);
        }

        public final void mo749a() {
            Systrace.e(33554432, "createView", this.f11799b);
            this.f11807a.f11849b.m13882a(this.f11808d, this.f11799b, this.f11809e, this.f11810f);
        }
    }

    /* compiled from: frame wait timed out */
    final class DispatchCommandOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11811a;
        private final int f11812d;
        @Nullable
        private final ReadableArray f11813e;

        public DispatchCommandOperation(UIViewOperationQueue uIViewOperationQueue, int i, int i2, @Nullable ReadableArray readableArray) {
            this.f11811a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11812d = i2;
            this.f11813e = readableArray;
        }

        public final void mo749a() {
            this.f11811a.f11849b.m13871a(this.f11799b, this.f11812d, this.f11813e);
        }
    }

    /* compiled from: frame wait timed out */
    class DispatchUIFrameCallback extends GuardedChoreographerFrameCallback {
        final /* synthetic */ UIViewOperationQueue f11814a;

        public DispatchUIFrameCallback(UIViewOperationQueue uIViewOperationQueue, ReactContext reactContext) {
            this.f11814a = uIViewOperationQueue;
            super(reactContext);
        }

        public final void mo750a(long j) {
            Systrace.a(8192, "dispatchNonBatchedUIOperations");
            try {
                m14048b(j);
                synchronized (this.f11814a.f11851d) {
                    for (int i = 0; i < this.f11814a.f11855h.size(); i++) {
                        ((Runnable) this.f11814a.f11855h.get(i)).run();
                    }
                    this.f11814a.f11855h.clear();
                }
                ReactChoreographer.m13927a().m13933a(CallbackType.DISPATCH_UI, (FrameCallback) this);
            } finally {
                Systrace.a(8192);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m14048b(long r8) {
            /*
            r7 = this;
        L_0x0000:
            r0 = 16;
            r2 = java.lang.System.nanoTime();
            r2 = r2 - r8;
            r4 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r2 = r2 / r4;
            r0 = r0 - r2;
            r2 = 8;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x0022;
        L_0x0012:
            r0 = r7.f11814a;
            r1 = r0.f11852e;
            monitor-enter(r1);
            r0 = r7.f11814a;	 Catch:{ all -> 0x0032 }
            r0 = r0.f11857j;	 Catch:{ all -> 0x0032 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0023;
        L_0x0021:
            monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        L_0x0022:
            return;
        L_0x0023:
            r0 = r7.f11814a;	 Catch:{ all -> 0x0032 }
            r0 = r0.f11857j;	 Catch:{ all -> 0x0032 }
            r0 = r0.pollFirst();	 Catch:{ all -> 0x0032 }
            r0 = (com.facebook.react.uimanager.UIViewOperationQueue.UIOperation) r0;	 Catch:{ all -> 0x0032 }
            monitor-exit(r1);	 Catch:{ all -> 0x0032 }
            r0.mo749a();
            goto L_0x0000;
        L_0x0032:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.DispatchUIFrameCallback.b(long):void");
        }
    }

    /* compiled from: frame wait timed out */
    final class FindTargetForTouchOperation implements UIOperation {
        final /* synthetic */ UIViewOperationQueue f11815a;
        private final int f11816b;
        private final float f11817c;
        private final float f11818d;
        private final Callback f11819e;

        private FindTargetForTouchOperation(UIViewOperationQueue uIViewOperationQueue, int i, float f, float f2, Callback callback) {
            this.f11815a = uIViewOperationQueue;
            this.f11816b = i;
            this.f11817c = f;
            this.f11818d = f2;
            this.f11819e = callback;
        }

        public final void mo749a() {
            try {
                this.f11815a.f11849b.m13878a(this.f11816b, this.f11815a.f11848a);
                float f = (float) this.f11815a.f11848a[0];
                float f2 = (float) this.f11815a.f11848a[1];
                try {
                    this.f11815a.f11849b.m13878a(this.f11815a.f11849b.m13866a(this.f11816b, this.f11817c, this.f11818d), this.f11815a.f11848a);
                    f = PixelUtil.m13926c(((float) this.f11815a.f11848a[0]) - f);
                    f2 = PixelUtil.m13926c(((float) this.f11815a.f11848a[1]) - f2);
                    float c = PixelUtil.m13926c((float) this.f11815a.f11848a[2]);
                    float c2 = PixelUtil.m13926c((float) this.f11815a.f11848a[3]);
                    this.f11819e.mo642a(Integer.valueOf(r2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(c), Float.valueOf(c2));
                } catch (IllegalViewOperationException e) {
                    this.f11819e.mo642a(new Object[0]);
                }
            } catch (IllegalViewOperationException e2) {
                this.f11819e.mo642a(new Object[0]);
            }
        }
    }

    /* compiled from: frame wait timed out */
    final class ManageChildrenOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11820a;
        @Nullable
        private final int[] f11821d;
        @Nullable
        private final ViewAtIndex[] f11822e;
        @Nullable
        private final int[] f11823f;

        public ManageChildrenOperation(UIViewOperationQueue uIViewOperationQueue, int i, @Nullable int[] iArr, @Nullable ViewAtIndex[] viewAtIndexArr, @Nullable int[] iArr2) {
            this.f11820a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11821d = iArr;
            this.f11822e = viewAtIndexArr;
            this.f11823f = iArr2;
        }

        public final void mo749a() {
            this.f11820a.f11849b.m13879a(this.f11799b, this.f11821d, this.f11822e, this.f11823f);
        }
    }

    /* compiled from: frame wait timed out */
    final class MeasureInWindowOperation implements UIOperation {
        final /* synthetic */ UIViewOperationQueue f11824a;
        private final int f11825b;
        private final Callback f11826c;

        public MeasureInWindowOperation(UIViewOperationQueue uIViewOperationQueue, int i, Callback callback) {
            this.f11824a = uIViewOperationQueue;
            this.f11825b = i;
            this.f11826c = callback;
        }

        public final void mo749a() {
            try {
                this.f11824a.f11849b.m13886b(this.f11825b, this.f11824a.f11848a);
                float c = PixelUtil.m13926c((float) this.f11824a.f11848a[0]);
                float c2 = PixelUtil.m13926c((float) this.f11824a.f11848a[1]);
                float c3 = PixelUtil.m13926c((float) this.f11824a.f11848a[2]);
                float c4 = PixelUtil.m13926c((float) this.f11824a.f11848a[3]);
                this.f11826c.mo642a(Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4));
            } catch (NoSuchNativeViewException e) {
                this.f11826c.mo642a(new Object[0]);
            }
        }
    }

    /* compiled from: frame wait timed out */
    final class MeasureOperation implements UIOperation {
        final /* synthetic */ UIViewOperationQueue f11827a;
        private final int f11828b;
        private final Callback f11829c;

        public MeasureOperation(UIViewOperationQueue uIViewOperationQueue, int i, Callback callback) {
            this.f11827a = uIViewOperationQueue;
            this.f11828b = i;
            this.f11829c = callback;
        }

        public final void mo749a() {
            try {
                this.f11827a.f11849b.m13878a(this.f11828b, this.f11827a.f11848a);
                float c = PixelUtil.m13926c((float) this.f11827a.f11848a[0]);
                float c2 = PixelUtil.m13926c((float) this.f11827a.f11848a[1]);
                float c3 = PixelUtil.m13926c((float) this.f11827a.f11848a[2]);
                float c4 = PixelUtil.m13926c((float) this.f11827a.f11848a[3]);
                this.f11829c.mo642a(Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(c3), Float.valueOf(c4), Float.valueOf(c), Float.valueOf(c2));
            } catch (NoSuchNativeViewException e) {
                this.f11829c.mo642a(new Object[0]);
            }
        }
    }

    /* compiled from: frame wait timed out */
    final class RemoveRootViewOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11830a;

        public RemoveRootViewOperation(UIViewOperationQueue uIViewOperationQueue, int i) {
            this.f11830a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
        }

        public final void mo749a() {
            this.f11830a.f11849b.m13888c(this.f11799b);
        }
    }

    /* compiled from: frame wait timed out */
    final class SendAccessibilityEvent extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11831a;
        private final int f11832d;

        public SendAccessibilityEvent(UIViewOperationQueue uIViewOperationQueue, int i, int i2) {
            this.f11831a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11832d = i2;
        }

        public final void mo749a() {
            this.f11831a.f11849b.m13869a(this.f11799b, this.f11832d);
        }
    }

    /* compiled from: frame wait timed out */
    class SetLayoutAnimationEnabledOperation implements UIOperation {
        final /* synthetic */ UIViewOperationQueue f11833a;
        private final boolean f11834b;

        public SetLayoutAnimationEnabledOperation(UIViewOperationQueue uIViewOperationQueue, boolean z) {
            this.f11833a = uIViewOperationQueue;
            this.f11834b = z;
        }

        public final void mo749a() {
            this.f11833a.f11849b.f11745i = this.f11834b;
        }
    }

    /* compiled from: frame wait timed out */
    final class ShowPopupMenuOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11835a;
        private final ReadableArray f11836d;
        private final Callback f11837e;

        public ShowPopupMenuOperation(UIViewOperationQueue uIViewOperationQueue, int i, ReadableArray readableArray, Callback callback) {
            this.f11835a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11836d = readableArray;
            this.f11837e = callback;
        }

        public final void mo749a() {
            this.f11835a.f11849b.m13874a(this.f11799b, this.f11836d, this.f11837e);
        }
    }

    /* compiled from: frame wait timed out */
    final class UpdateLayoutOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11838a;
        private final int f11839d;
        private final int f11840e;
        private final int f11841f;
        private final int f11842g;
        private final int f11843h;

        public UpdateLayoutOperation(UIViewOperationQueue uIViewOperationQueue, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f11838a = uIViewOperationQueue;
            super(uIViewOperationQueue, i2);
            this.f11839d = i;
            this.f11840e = i3;
            this.f11841f = i4;
            this.f11842g = i5;
            this.f11843h = i6;
            Systrace.d(33554432, "updateLayout", this.f11799b);
        }

        public final void mo749a() {
            Systrace.e(33554432, "updateLayout", this.f11799b);
            this.f11838a.f11849b.m13870a(this.f11839d, this.f11799b, this.f11840e, this.f11841f, this.f11842g, this.f11843h);
        }
    }

    /* compiled from: frame wait timed out */
    final class UpdatePropertiesOperation extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11844a;
        private final ReactStylesDiffMap f11845d;

        public UpdatePropertiesOperation(UIViewOperationQueue uIViewOperationQueue, int i, ReactStylesDiffMap reactStylesDiffMap) {
            this.f11844a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11845d = reactStylesDiffMap;
        }

        public final void mo749a() {
            this.f11844a.f11849b.m13875a(this.f11799b, this.f11845d);
        }
    }

    /* compiled from: frame wait timed out */
    final class UpdateViewExtraData extends ViewOperation {
        final /* synthetic */ UIViewOperationQueue f11846a;
        private final Object f11847d;

        public UpdateViewExtraData(UIViewOperationQueue uIViewOperationQueue, int i, Object obj) {
            this.f11846a = uIViewOperationQueue;
            super(uIViewOperationQueue, i);
            this.f11847d = obj;
        }

        public final void mo749a() {
            this.f11846a.f11849b.m13877a(this.f11799b, this.f11847d);
        }
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager) {
        this.f11849b = nativeViewHierarchyManager;
        this.f11850c = nativeViewHierarchyManager.f11737a;
        this.f11853f = new DispatchUIFrameCallback(this, reactApplicationContext);
        this.f11854g = reactApplicationContext;
    }

    public final void m14083a(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.f11858k = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    public final boolean m14085a() {
        return this.f11856i.isEmpty();
    }

    public final void m14077a(int i, SizeMonitoringFrameLayout sizeMonitoringFrameLayout, ThemedReactContext themedReactContext) {
        if (UiThreadUtil.m13553a()) {
            this.f11849b.m13876a(i, sizeMonitoringFrameLayout, themedReactContext);
            return;
        }
        final Semaphore semaphore = new Semaphore(0);
        final int i2 = i;
        final SizeMonitoringFrameLayout sizeMonitoringFrameLayout2 = sizeMonitoringFrameLayout;
        final ThemedReactContext themedReactContext2 = themedReactContext;
        this.f11854g.m13522a(new Runnable(this) {
            final /* synthetic */ UIViewOperationQueue f11794e;

            public void run() {
                this.f11794e.f11849b.m13876a(i2, sizeMonitoringFrameLayout2, themedReactContext2);
                semaphore.release();
            }
        });
        try {
            SoftAssertions.m13551a(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS), "Timed out adding root view");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void m14082a(UIOperation uIOperation) {
        this.f11856i.add(uIOperation);
    }

    public final void m14068a(int i) {
        this.f11856i.add(new RemoveRootViewOperation(this, i));
    }

    public final void m14073a(int i, int i2, boolean z) {
        this.f11856i.add(new ChangeJSResponderOperation(this, i, i2, false, z));
    }

    public final void m14086b() {
        this.f11856i.add(new ChangeJSResponderOperation(this, 0, 0, true, false));
    }

    public final void m14072a(int i, int i2, ReadableArray readableArray) {
        this.f11856i.add(new DispatchCommandOperation(this, i, i2, readableArray));
    }

    public final void m14078a(int i, Object obj) {
        this.f11856i.add(new UpdateViewExtraData(this, i, obj));
    }

    public final void m14075a(int i, ReadableArray readableArray, Callback callback) {
        this.f11856i.add(new ShowPopupMenuOperation(this, i, readableArray, callback));
    }

    public final void m14081a(ThemedReactContext themedReactContext, int i, String str, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        synchronized (this.f11852e) {
            this.f11857j.addLast(new CreateViewOperation(this, themedReactContext, i, str, reactStylesDiffMap));
        }
    }

    public final void m14076a(int i, ReactStylesDiffMap reactStylesDiffMap) {
        this.f11856i.add(new UpdatePropertiesOperation(this, i, reactStylesDiffMap));
    }

    public final void m14071a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f11856i.add(new UpdateLayoutOperation(this, i, i2, i3, i4, i5, i6));
    }

    public final void m14079a(int i, @Nullable int[] iArr, @Nullable ViewAtIndex[] viewAtIndexArr, @Nullable int[] iArr2) {
        this.f11856i.add(new ManageChildrenOperation(this, i, iArr, viewAtIndexArr, iArr2));
    }

    public final void m14084a(boolean z) {
        this.f11856i.add(new SetLayoutAnimationEnabledOperation(this, z));
    }

    public final void m14080a(ReadableMap readableMap) {
        this.f11856i.add(new ConfigureLayoutAnimationOperation(this, readableMap));
    }

    public final void m14074a(int i, Callback callback) {
        this.f11856i.add(new MeasureOperation(this, i, callback));
    }

    public final void m14088b(int i, Callback callback) {
        this.f11856i.add(new MeasureInWindowOperation(this, i, callback));
    }

    public final void m14069a(int i, float f, float f2, Callback callback) {
        this.f11856i.add(new FindTargetForTouchOperation(i, f, f2, callback));
    }

    public final void m14070a(int i, int i2) {
        this.f11856i.add(new SendAccessibilityEvent(this, i, i2));
    }

    final void m14087b(final int i) {
        UIOperation[] uIOperationArr = null;
        final ArrayList arrayList = this.f11856i.isEmpty() ? null : this.f11856i;
        if (arrayList != null) {
            this.f11856i = new ArrayList();
        }
        synchronized (this.f11852e) {
            if (!this.f11857j.isEmpty()) {
                uIOperationArr = (UIOperation[]) this.f11857j.toArray(new UIOperation[this.f11857j.size()]);
                this.f11857j.clear();
            }
        }
        if (this.f11858k != null) {
            this.f11858k.mo729c();
        }
        synchronized (this.f11851d) {
            this.f11855h.add(new Runnable(this) {
                final /* synthetic */ UIViewOperationQueue f11798d;

                public void run() {
                    SystraceMessage.a(8192, "DispatchUI").a("BatchId", i).a();
                    try {
                        int i;
                        if (uIOperationArr != null) {
                            for (UIOperation a : uIOperationArr) {
                                a.mo749a();
                            }
                        }
                        if (arrayList != null) {
                            for (i = 0; i < arrayList.size(); i++) {
                                ((UIOperation) arrayList.get(i)).mo749a();
                            }
                        }
                        this.f11798d.f11849b.m13887c();
                        if (this.f11798d.f11858k != null) {
                            this.f11798d.f11858k.mo730d();
                        }
                        Systrace.a(8192);
                    } catch (Throwable th) {
                        Systrace.a(8192);
                    }
                }
            });
        }
    }

    final void m14089c() {
        ReactChoreographer.m13927a().m13933a(CallbackType.DISPATCH_UI, this.f11853f);
    }

    final void m14090d() {
        ReactChoreographer.m13927a().m13934b(CallbackType.DISPATCH_UI, this.f11853f);
    }
}
