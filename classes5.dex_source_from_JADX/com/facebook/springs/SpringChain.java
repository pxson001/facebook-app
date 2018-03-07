package com.facebook.springs;

import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: consumerPackageName */
public class SpringChain implements SpringListener {
    public final SpringSystem f5265a;
    public final CopyOnWriteArrayList<SpringListener> f5266b = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList<Spring> f5267c = new CopyOnWriteArrayList();
    public int f5268d = -1;
    private final SpringConfig f5269e;
    public final SpringConfig f5270f;

    /* compiled from: consumerPackageName */
    public class SpringChainConfig {
        public static final SpringChainConfig f5262c = new SpringChainConfig(SpringConfig.a(40.0d, 6.0d), SpringConfig.a(70.0d, 10.0d));
        public final SpringConfig f5263a;
        public final SpringConfig f5264b;

        public SpringChainConfig(SpringConfig springConfig, SpringConfig springConfig2) {
            this.f5263a = springConfig;
            this.f5264b = springConfig2;
        }
    }

    @Inject
    public SpringChain(SpringSystem springSystem, @Nullable @Assisted SpringChainConfig springChainConfig) {
        this.f5265a = springSystem;
        if (springChainConfig == null) {
            springChainConfig = SpringChainConfig.f5262c;
        }
        this.f5269e = springChainConfig.f5263a;
        this.f5270f = springChainConfig.f5264b;
    }

    public final SpringChain m10178a(int i) {
        this.f5268d = i;
        if (((Spring) this.f5267c.get(this.f5268d)) == null) {
            return null;
        }
        ImmutableList copyOf = ImmutableList.copyOf(this.f5265a.a.values());
        int size = copyOf.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Spring) copyOf.get(i2)).a(this.f5270f);
        }
        m10180b().a(this.f5269e);
        return this;
    }

    public final Spring m10180b() {
        return (Spring) this.f5267c.get(this.f5268d);
    }

    public final void m10179a(Spring spring) {
        int i;
        int i2 = -1;
        int indexOf = this.f5267c.indexOf(spring);
        SpringListener springListener = (SpringListener) this.f5266b.get(indexOf);
        if (indexOf == this.f5268d) {
            i = indexOf + 1;
            i2 = indexOf - 1;
        } else if (indexOf < this.f5268d) {
            i = -1;
            i2 = indexOf - 1;
        } else {
            i = indexOf > this.f5268d ? indexOf + 1 : -1;
        }
        if (i >= 0 && i < this.f5267c.size()) {
            ((Spring) this.f5267c.get(i)).b(spring.d());
        }
        if (i2 >= 0 && i2 < this.f5267c.size()) {
            ((Spring) this.f5267c.get(i2)).b(spring.d());
        }
        springListener.a(spring);
    }

    public final void m10181b(Spring spring) {
        ((SpringListener) this.f5266b.get(this.f5267c.indexOf(spring))).b(spring);
    }

    public final void m10182c(Spring spring) {
        ((SpringListener) this.f5266b.get(this.f5267c.indexOf(spring))).c(spring);
    }

    public final void m10183d(Spring spring) {
        ((SpringListener) this.f5266b.get(this.f5267c.indexOf(spring))).d(spring);
    }
}
