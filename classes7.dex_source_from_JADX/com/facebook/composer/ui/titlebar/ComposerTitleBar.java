package com.facebook.composer.ui.titlebar;

import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.ref.WeakReference;
import java.util.List;

@Deprecated
/* compiled from: tapped_invite_more_friends */
public class ComposerTitleBar {
    public final WeakReference<ComposerBaseTitleBar> f2095a;
    public State f2096b;

    /* compiled from: tapped_invite_more_friends */
    public class State {
        public final String f2087a;
        public final TitleBarButtonSpec f2088b;
        public final OnToolbarButtonListener f2089c;
        public final HarrisonPlusIconType f2090d;

        public State(StateBuilder stateBuilder) {
            Preconditions.checkNotNull(stateBuilder);
            this.f2087a = (String) Preconditions.checkNotNull(stateBuilder.f2091a);
            this.f2088b = stateBuilder.f2092b;
            this.f2089c = stateBuilder.f2093c;
            this.f2090d = (HarrisonPlusIconType) Preconditions.checkNotNull(stateBuilder.f2094d);
        }

        public final StateBuilder m2065a() {
            return new StateBuilder(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            if (Objects.equal(this.f2087a, state.f2087a) && Objects.equal(this.f2088b, state.f2088b) && this.f2089c == state.f2089c && Objects.equal(this.f2090d, state.f2090d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f2087a, this.f2088b, this.f2089c, this.f2090d});
        }
    }

    /* compiled from: tapped_invite_more_friends */
    public class StateBuilder {
        public String f2091a = "";
        public TitleBarButtonSpec f2092b;
        public OnToolbarButtonListener f2093c;
        public HarrisonPlusIconType f2094d = HarrisonPlusIconType.m2080c();

        public StateBuilder(State state) {
            Preconditions.checkNotNull(state);
            this.f2091a = state.f2087a;
            this.f2092b = state.f2088b;
            this.f2093c = state.f2089c;
            this.f2094d = state.f2090d;
        }

        public final StateBuilder m2067a(boolean z) {
            if (this.f2092b != null) {
                this.f2092b.t = z;
            }
            return this;
        }

        public final State m2066a() {
            return new State(this);
        }
    }

    public ComposerTitleBar(ComposerBaseTitleBar composerBaseTitleBar, State state) {
        Preconditions.checkNotNull(state);
        this.f2095a = new WeakReference(Preconditions.checkNotNull(composerBaseTitleBar));
        m2069a(state);
    }

    public final void m2069a(State state) {
        List of;
        this.f2096b = state;
        Preconditions.checkNotNull(this.f2096b, "No state!");
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) Preconditions.checkNotNull(this.f2095a.get());
        composerBaseTitleBar.setTitle(this.f2096b.f2087a);
        composerBaseTitleBar.setShowDividers(true);
        composerBaseTitleBar.mo94a(this.f2096b.f2090d);
        TitleBarButtonSpec titleBarButtonSpec = this.f2096b.f2088b;
        if (titleBarButtonSpec != null) {
            of = ImmutableList.of(titleBarButtonSpec);
        } else {
            of = RegularImmutableList.a;
        }
        composerBaseTitleBar.setButtonSpecs(of);
        composerBaseTitleBar.setOnToolbarButtonListener(this.f2096b.f2089c);
    }

    public final State m2068a() {
        return this.f2096b;
    }
}
