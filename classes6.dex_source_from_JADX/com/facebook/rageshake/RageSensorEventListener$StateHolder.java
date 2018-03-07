package com.facebook.rageshake;

/* compiled from: showTagExpansionOption */
class RageSensorEventListener$StateHolder {
    State f4380a = State.Insignificant;
    int f4381b = 0;
    int f4382c = 0;

    /* compiled from: showTagExpansionOption */
    enum State {
        Insignificant,
        AboveThreshold,
        BelowThreshold
    }

    RageSensorEventListener$StateHolder() {
    }

    final void m6456a() {
        this.f4382c = 0;
        this.f4381b = 0;
    }

    final boolean m6458b() {
        return this.f4381b >= 2 && this.f4382c >= 2;
    }

    final void m6457a(boolean z, boolean z2) {
        switch (this.f4380a) {
            case Insignificant:
                if (z) {
                    this.f4380a = State.AboveThreshold;
                    this.f4381b++;
                    return;
                } else if (z2) {
                    this.f4380a = State.BelowThreshold;
                    this.f4382c++;
                    return;
                } else {
                    return;
                }
            case AboveThreshold:
                if (z2) {
                    this.f4380a = State.BelowThreshold;
                    this.f4382c++;
                    return;
                } else if (!z) {
                    this.f4380a = State.Insignificant;
                    return;
                } else {
                    return;
                }
            case BelowThreshold:
                if (z) {
                    this.f4380a = State.AboveThreshold;
                    this.f4381b++;
                    return;
                } else if (!z2) {
                    this.f4380a = State.Insignificant;
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
