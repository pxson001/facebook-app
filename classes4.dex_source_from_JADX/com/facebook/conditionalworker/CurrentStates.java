package com.facebook.conditionalworker;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.BatteryState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import javax.annotation.Nonnull;

/* compiled from: is_best_device */
class CurrentStates {
    private final States f10305a;

    /* compiled from: is_best_device */
    public final class Factory {
        private final AppStateManager f10106a;
        public final NetworkStateManager f10107b;
        public final LoggedInUserSessionManager f10108c;
        public final SystemBatteryStateManager f10109d;

        public Factory(@Nonnull AppStateManager appStateManager, @Nonnull NetworkStateManager networkStateManager, @Nonnull LoggedInUserSessionManager loggedInUserSessionManager, @Nonnull SystemBatteryStateManager systemBatteryStateManager) {
            this.f10106a = appStateManager;
            this.f10107b = networkStateManager;
            this.f10108c = loggedInUserSessionManager;
            this.f10109d = systemBatteryStateManager;
        }

        public final CurrentStates m10569a() {
            LoginState loginState;
            BatteryState batteryState;
            States states = new States();
            states.m10783a(m10570b());
            Enum a = this.f10107b.m8504a();
            if (a != null) {
                states.m10783a(NetworkState.CONNECTED);
                states.m10783a(a);
            }
            if (!this.f10108c.b() || this.f10108c.d()) {
                loginState = null;
            } else {
                loginState = LoginState.LOGGED_IN;
            }
            if (loginState != null) {
                states.m10783a(LoginState.LOGGED_IN);
            }
            if (this.f10109d.a(15)) {
                batteryState = null;
            } else {
                batteryState = BatteryState.NOT_LOW;
            }
            if (batteryState != null) {
                states.m10783a(BatteryState.NOT_LOW);
            }
            return new CurrentStates(states);
        }

        public final AppState m10570b() {
            if (this.f10106a.l()) {
                return AppState.FOREGROUND;
            }
            return AppState.BACKGROUND;
        }
    }

    public CurrentStates(States states) {
        this.f10305a = states;
    }

    public final boolean m10801a(RequiredStates requiredStates) {
        return this.f10305a.f10281a.containsAll(requiredStates.f10308a.f10281a);
    }

    public String toString() {
        return this.f10305a.toString();
    }
}
