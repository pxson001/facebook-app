package com.facebook.multirow.api;

import android.view.View;
import com.facebook.infer.annotation.NoAllocation;
import com.facebook.infer.annotation.PerformanceCritical;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: native_optin_interstitial */
public abstract class BaseSinglePartDefinition<Props, State, Environment extends AnyEnvironment, V extends View> implements SinglePartDefinition<Props, State, Environment, V> {
    public State mo2541a(SubParts<Environment> subParts, Props props, Environment environment) {
        return null;
    }

    @NoAllocation
    @PerformanceCritical
    public void mo2543a(Props props, State state, Environment environment, V v) {
        Logger.a(8, EntryType.MARK_POP, -951390410, Logger.a(8, EntryType.MARK_PUSH, 1834955019));
    }

    @NoAllocation
    @PerformanceCritical
    public void mo2544b(Props props, State state, Environment environment, V v) {
    }

    public void mo2542a(Props props, State state, Environment environment) {
    }
}
