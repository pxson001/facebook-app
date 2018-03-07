package com.facebook.multirow.api;

import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: key == null || value == null */
public abstract class BaseSinglePartDefinitionWithViewType<Props, State, Environment extends AnyEnvironment, V extends View> implements SinglePartDefinitionWithViewType<Props, State, Environment, V> {
    public State mo2541a(SubParts<Environment> subParts, Props props, Environment environment) {
        return null;
    }

    public void mo2543a(Props props, State state, Environment environment, V v) {
        Logger.a(8, EntryType.MARK_POP, 1243812281, Logger.a(8, EntryType.MARK_PUSH, -1961653374));
    }

    public void mo2544b(Props props, State state, Environment environment, V v) {
    }

    public final void mo2542a(Props props, State state, Environment environment) {
    }
}
