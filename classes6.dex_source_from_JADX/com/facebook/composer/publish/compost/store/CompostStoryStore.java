package com.facebook.composer.publish.compost.store;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.time.Clock;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: photo_warning_dialog_cancel_tapped */
public abstract class CompostStoryStore<T extends CompostStory> implements IHaveUserData {
    public final Clock f8039a;
    protected final Object f8040b = new Object();
    protected final List<T> f8041c = new ArrayList();
    @Nullable
    public OnUpdateListener<T> f8042d;

    /* compiled from: photo_warning_dialog_cancel_tapped */
    class C04891 implements Comparator<T> {
        final /* synthetic */ CompostStoryStore f8050a;

        C04891(CompostStoryStore compostStoryStore) {
            this.f8050a = compostStoryStore;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((CompostStory) obj2).mo931c() - ((CompostStory) obj).mo931c());
        }
    }

    public abstract long mo929b();

    public CompostStoryStore(Clock clock) {
        this.f8039a = clock;
        this.f8042d = null;
    }

    public ListenableFuture<Boolean> mo927a(T t) {
        boolean z;
        synchronized (this.f8040b) {
            int d = m11593d(t.mo934f());
            if (d == -1) {
                this.f8041c.add(t);
                z = true;
            } else {
                this.f8041c.set(d, t);
                z = false;
            }
        }
        if (z && this.f8042d != null) {
            this.f8042d.m21229a(t);
        }
        return Futures.a(Boolean.valueOf(true));
    }

    public ListenableFuture<Boolean> mo928a(String str) {
        synchronized (this.f8040b) {
            int d = m11593d(str);
            if (d != -1) {
                this.f8041c.remove(d);
            }
        }
        return Futures.a(Boolean.valueOf(true));
    }

    public ListenableFuture<ImmutableList<T>> mo926a() {
        Builder builder = ImmutableList.builder();
        synchronized (this.f8040b) {
            mo1128d();
            builder.b(this.f8041c);
        }
        return Futures.a(builder.b());
    }

    @Nullable
    public T mo1127c(String str) {
        if (str == null) {
            return null;
        }
        for (CompostStory compostStory : this.f8041c) {
            if (str.equals(compostStory.mo934f())) {
                return compostStory;
            }
        }
        return null;
    }

    private void mo1128d() {
        Collections.sort(this.f8041c, new C04891(this));
        for (int i = 0; i < this.f8041c.size(); i++) {
            if ((this.f8039a.a() - ((CompostStory) this.f8041c.get(i)).mo931c()) / 1000 > mo929b()) {
                this.f8041c.subList(i, this.f8041c.size()).clear();
                return;
            }
        }
    }

    public final int m11593d(String str) {
        for (int i = 0; i < this.f8041c.size(); i++) {
            if (str.equals(((CompostStory) this.f8041c.get(i)).mo934f())) {
                return i;
            }
        }
        return -1;
    }

    public void clearUserData() {
        m11587e();
    }

    private void m11587e() {
        synchronized (this.f8040b) {
            this.f8041c.clear();
        }
    }
}
