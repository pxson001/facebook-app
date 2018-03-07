package com.facebook.conditionalworker;

import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.BatteryState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: install_track/ */
public class RequiredStates {
    public final States f10308a;

    /* compiled from: install_track/ */
    public class Builder {
        private final States f10306a = new States();
        private final Set<Class<?>> f10307b = new HashSet();

        public final Builder m10803a(@Nonnull AppState appState) {
            return m10802a((Enum) appState);
        }

        public final Builder m10806a(@Nonnull NetworkState networkState) {
            return m10802a((Enum) networkState);
        }

        public final Builder m10805a(@Nonnull LoginState loginState) {
            return m10802a((Enum) loginState);
        }

        public final Builder m10804a(@Nonnull BatteryState batteryState) {
            return m10802a((Enum) batteryState);
        }

        public final RequiredStates m10807a() {
            return new RequiredStates(this.f10306a);
        }

        private Builder m10802a(@Nonnull Enum<?> enumR) {
            Class cls = enumR.getClass();
            if (this.f10307b.contains(cls)) {
                throw new IllegalArgumentException(cls.getSimpleName() + "has been set up. More than one value is not allowed from the same state type");
            }
            this.f10307b.add(cls);
            this.f10306a.m10783a(enumR);
            return this;
        }
    }

    public RequiredStates(States states) {
        this.f10308a = states;
    }

    public String toString() {
        return this.f10308a.toString();
    }
}
