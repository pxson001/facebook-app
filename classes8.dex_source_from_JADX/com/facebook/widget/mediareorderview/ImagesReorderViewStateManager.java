package com.facebook.widget.mediareorderview;

import com.google.common.base.Preconditions;

/* compiled from: location_opt_in_google_play_location_not_possible */
public class ImagesReorderViewStateManager {
    private State f9893a = State.INVISIBLE;

    /* compiled from: location_opt_in_google_play_location_not_possible */
    public enum State {
        INVISIBLE,
        SHRINK,
        REORDER,
        EXPAND
    }

    public final void m11605a(State state) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f9893a) {
            case INVISIBLE:
                if (state != State.SHRINK) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                break;
            case SHRINK:
                if (state == State.REORDER || state == State.EXPAND) {
                    z2 = true;
                }
                Preconditions.checkArgument(z2);
                break;
            case REORDER:
                if (state != State.EXPAND) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                break;
            case EXPAND:
                if (state != State.INVISIBLE) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                break;
        }
        this.f9893a = state;
    }

    public final boolean m11606b(State state) {
        return this.f9893a == state;
    }

    public final boolean m11607c(State state) {
        return this.f9893a != state;
    }
}
