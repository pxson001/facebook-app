package com.facebook.aldrin.transition;

import android.content.Intent;
import com.facebook.aldrin.transition.fragment.AldrinTosDeclinedFragment;
import com.facebook.aldrin.transition.fragment.AldrinTosFragment;
import com.facebook.aldrin.transition.fragment.GeneralTosFragment;
import com.facebook.base.fragment.FragmentActionBuilder;

/* compiled from: last_attempt */
public enum TosTransitionState {
    VIEW_ALDRIN_TOS {
        public final Intent getIntent() {
            return new FragmentActionBuilder(AldrinTosFragment.class).a;
        }
    },
    AGREED_TO_ALDRIN_TOS {
        public final Intent getIntent() {
            return null;
        }
    },
    VIEW_BLOCK_INTERSTITIAL {
        public final Intent getIntent() {
            return new FragmentActionBuilder(AldrinTosDeclinedFragment.class).a;
        }
    },
    VIEW_GENERAL_TOS {
        public final Intent getIntent() {
            return new FragmentActionBuilder(GeneralTosFragment.class).a;
        }
    },
    AGREED_TO_GENERAL_TOS {
        public final Intent getIntent() {
            return null;
        }
    };

    public abstract Intent getIntent();
}
