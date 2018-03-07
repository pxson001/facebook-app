package com.facebook.multirow.api;

import android.view.View;
import com.facebook.infer.annotation.NoAllocation;
import com.facebook.infer.annotation.PerformanceCritical;

/* compiled from: native_note/{%s} */
public interface SinglePartDefinition<Props, State, Environment extends AnyEnvironment, V extends View> {
    State mo2541a(SubParts<Environment> subParts, Props props, Environment environment);

    void mo2542a(Props props, State state, Environment environment);

    @NoAllocation
    @PerformanceCritical
    void mo2543a(Props props, State state, Environment environment, V v);

    @NoAllocation
    @PerformanceCritical
    void mo2544b(Props props, State state, Environment environment, V v);
}
