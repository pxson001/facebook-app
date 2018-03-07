package com.facebook.strictmode.setter;

import com.facebook.strictmode.setter.predefined.DetectAll;
import com.facebook.strictmode.setter.predefined.LaxAll;
import com.facebook.strictmode.setter.predefined.PenaltyDeathAll;
import com.facebook.strictmode.setter.predefined.PenaltyDropBoxAll;
import com.facebook.strictmode.setter.predefined.PenaltyLogAll;
import com.facebook.strictmode.setter.predefined.ResetAll;

/* compiled from: No composer configuration or saved session supplied to composer */
public class Policy {

    /* compiled from: No composer configuration or saved session supplied to composer */
    public enum All implements StrictModeSetter {
        Lax(new LaxAll()),
        Reset(new ResetAll()),
        DetectAll(new DetectAll()),
        PenaltyDeath(new PenaltyDeathAll()),
        PenaltyDropBox(new PenaltyDropBoxAll()),
        PenaltyLog(new PenaltyLogAll());
        
        private final StrictModeSetter mSetter;

        private All(StrictModeSetter strictModeSetter) {
            this.mSetter = strictModeSetter;
        }

        public final void set() {
            this.mSetter.set();
        }
    }
}
