package com.facebook.search.results.loader.modules;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

/* compiled from: SCROLL_VIEW */
public class ResultsOrderReinforcer<T> {
    @Nullable
    private final String f23248a;
    private boolean f23249b;
    private final Consumer<T> f23250c;
    private final Queue<T> f23251d = new ArrayDeque();

    /* compiled from: SCROLL_VIEW */
    public interface Consumer<T> {
        void mo1320a(T t);
    }

    public ResultsOrderReinforcer(@Nullable String str, Consumer<T> consumer) {
        this.f23248a = str;
        this.f23250c = consumer;
        this.f23249b = this.f23248a == null;
    }

    public final synchronized void m26953a(String str, T t) {
        if (this.f23249b) {
            this.f23250c.mo1320a(t);
        } else if (str.equals(this.f23248a)) {
            while (true) {
                this.f23250c.mo1320a(t);
                T poll = this.f23251d.poll();
                if (poll == null) {
                    poll = null;
                }
                if (poll == null) {
                    break;
                }
                t = poll;
            }
            this.f23249b = true;
        } else {
            this.f23251d.add(t);
        }
    }
}
