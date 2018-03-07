package com.google.android.gms.common.api;

import java.util.Set;

public interface GoogleApiClient$ServerAuthCodeCallbacks {

    public class CheckResult {
        private boolean f6457a;
        private Set<Scope> f6458b;

        public final boolean m12135a() {
            return this.f6457a;
        }

        public final Set<Scope> m12136b() {
            return this.f6458b;
        }
    }

    CheckResult m12137a();

    boolean m12138b();
}
