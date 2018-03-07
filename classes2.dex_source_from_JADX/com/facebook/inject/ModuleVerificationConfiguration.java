package com.facebook.inject;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: yyyy-MM-dd */
public class ModuleVerificationConfiguration {
    public final boolean f614a;
    public final boolean f615b;
    private final ModuleVerificationListener f616c;
    public final ModuleVerificationBinderFactory f617d;

    public ModuleVerificationConfiguration(boolean z, boolean z2, @Nullable ModuleVerificationListener moduleVerificationListener, @Nullable ModuleVerificationBinderFactory moduleVerificationBinderFactory) {
        this.f614a = z;
        this.f615b = z2;
        this.f616c = moduleVerificationListener;
        this.f617d = moduleVerificationBinderFactory;
    }

    public final boolean m1272b() {
        return this.f614a;
    }

    public final ModuleVerificationListener m1273d() {
        Preconditions.checkState(this.f614a, "Verification mode is disabled.");
        return this.f616c;
    }
}
