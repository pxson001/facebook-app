package com.facebook.statemachine;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* compiled from: use_video */
public class StateMachine<STATE, EVENT> {
    public final Map<STATE, Map<EVENT, StateTransition<STATE>>> f769a;
    public final STATE f770b;
    public STATE f771c;
    public STATE f772d = null;
    public AbstractStateMachineListener f773e;

    public StateMachine(STATE state) {
        Preconditions.checkNotNull(state);
        this.f770b = state;
        this.f771c = state;
        this.f769a = new HashMap();
        this.f773e = null;
    }

    public final void m832a(EVENT event, STATE state, final STATE state2) {
        Preconditions.checkNotNull(state2);
        C00701 c00701 = new Object(this) {
            final /* synthetic */ StateMachine f768b;
        };
        Preconditions.checkNotNull(event);
        Preconditions.checkNotNull(state);
        Preconditions.checkNotNull(c00701);
        Map map = (Map) this.f769a.get(state);
        if (map == null) {
            map = new HashMap();
            this.f769a.put(state, map);
        }
        Preconditions.checkState(!map.containsKey(event));
        map.put(event, c00701);
    }
}
