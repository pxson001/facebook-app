package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* compiled from: graphLiveVideoDelete */
public class ReactContext extends ContextWrapper {
    private final CopyOnWriteArraySet<LifecycleEventListener> f11535a = new CopyOnWriteArraySet();
    private final CopyOnWriteArraySet<ActivityEventListener> f11536b = new CopyOnWriteArraySet();
    @Nullable
    private CatalystInstance f11537c;
    @Nullable
    private LayoutInflater f11538d;
    @Nullable
    private MessageQueueThread f11539e;
    @Nullable
    private MessageQueueThread f11540f;
    @Nullable
    private MessageQueueThread f11541g;
    @Nullable
    private NativeModuleCallExceptionHandler f11542h;
    @Nullable
    private WeakReference<Activity> f11543i;

    public ReactContext(Context context) {
        super(context);
    }

    public final void m13519a(CatalystInstance catalystInstance) {
        if (catalystInstance == null) {
            throw new IllegalArgumentException("CatalystInstance cannot be null.");
        } else if (this.f11537c != null) {
            throw new IllegalStateException("ReactContext has been already initialized");
        } else {
            this.f11537c = catalystInstance;
            ReactQueueConfiguration e = catalystInstance.mo658e();
            this.f11539e = e.mo707a();
            this.f11540f = e.mo708b();
            this.f11541g = e.mo709c();
        }
    }

    public final void m13521a(@Nullable NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.f11542h = nativeModuleCallExceptionHandler;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f11538d == null) {
            this.f11538d = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f11538d;
    }

    public final <T extends JavaScriptModule> T m13515a(Class<T> cls) {
        if (this.f11537c != null) {
            return this.f11537c.mo648a((Class) cls);
        }
        throw new RuntimeException("Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should be protected by ReactContext#hasActiveCatalystInstance().");
    }

    public final <T extends JavaScriptModule> T m13514a(ExecutorToken executorToken, Class<T> cls) {
        if (this.f11537c != null) {
            return this.f11537c.mo647a(executorToken, cls);
        }
        throw new RuntimeException("Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should be protected by ReactContext#hasActiveCatalystInstance().");
    }

    public final <T extends NativeModule> T m13525b(Class<T> cls) {
        if (this.f11537c != null) {
            return this.f11537c.mo652b((Class) cls);
        }
        throw new RuntimeException("Trying to call native module before CatalystInstance has been set!");
    }

    public final CatalystInstance m13513a() {
        return (CatalystInstance) Assertions.b(this.f11537c);
    }

    public final boolean m13528b() {
        return (this.f11537c == null || this.f11537c.mo655c()) ? false : true;
    }

    public void mo745a(LifecycleEventListener lifecycleEventListener) {
        this.f11535a.add(lifecycleEventListener);
    }

    public void mo746b(LifecycleEventListener lifecycleEventListener) {
        this.f11535a.remove(lifecycleEventListener);
    }

    public final void m13518a(ActivityEventListener activityEventListener) {
        this.f11536b.add(activityEventListener);
    }

    public final void m13517a(@Nullable Activity activity) {
        UiThreadUtil.m13554b();
        this.f11543i = new WeakReference(activity);
        Iterator it = this.f11535a.iterator();
        while (it.hasNext()) {
            ((LifecycleEventListener) it.next()).hf_();
        }
    }

    public final void m13529c() {
        UiThreadUtil.m13554b();
        Iterator it = this.f11535a.iterator();
        while (it.hasNext()) {
            ((LifecycleEventListener) it.next()).hg_();
        }
        this.f11543i = null;
    }

    public final void m13531d() {
        UiThreadUtil.m13554b();
        Iterator it = this.f11535a.iterator();
        while (it.hasNext()) {
            ((LifecycleEventListener) it.next()).hh_();
        }
    }

    public final void m13532e() {
        UiThreadUtil.m13554b();
        if (this.f11537c != null) {
            this.f11537c.mo653b();
        }
    }

    public final void m13516a(int i, int i2, Intent intent) {
        Iterator it = this.f11536b.iterator();
        while (it.hasNext()) {
            ((ActivityEventListener) it.next()).m13382a(i, i2, intent);
        }
    }

    public final boolean m13533f() {
        return ((MessageQueueThread) Assertions.b(this.f11539e)).isOnThread();
    }

    public final void m13522a(Runnable runnable) {
        ((MessageQueueThread) Assertions.b(this.f11539e)).runOnQueue(runnable);
    }

    public final void m13534g() {
        ((MessageQueueThread) Assertions.b(this.f11540f)).assertIsOnThread();
    }

    public final boolean m13535h() {
        return ((MessageQueueThread) Assertions.b(this.f11540f)).isOnThread();
    }

    public final void m13527b(Runnable runnable) {
        ((MessageQueueThread) Assertions.b(this.f11540f)).runOnQueue(runnable);
    }

    public final void m13530c(Runnable runnable) {
        ((MessageQueueThread) Assertions.b(this.f11541g)).runOnQueue(runnable);
    }

    public final void m13523a(RuntimeException runtimeException) {
        if (this.f11537c == null || this.f11537c.mo655c() || this.f11542h == null) {
            throw runtimeException;
        }
        this.f11542h.a(runtimeException);
    }

    public final boolean m13536i() {
        return (this.f11543i == null || this.f11543i.get() == null) ? false : true;
    }

    public final boolean m13524a(Intent intent, int i, Bundle bundle) {
        Activity j = m13537j();
        Assertions.b(j);
        j.startActivityForResult(intent, i, bundle);
        return true;
    }

    @Nullable
    final Activity m13537j() {
        if (this.f11543i == null) {
            return null;
        }
        return (Activity) this.f11543i.get();
    }
}
