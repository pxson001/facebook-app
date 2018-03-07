package com.facebook.sync.prefs;

import android.graphics.Color;
import com.facebook.debug.debugoverlay.DebugOverlayTag;
import com.facebook.debug.debugoverlay.DebugOverlayTagSetProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;

/* compiled from: feedUnitProps */
public class SyncDebugOverlaySettingsTags implements DebugOverlayTagSetProvider {
    public static final DebugOverlayTag f14548a = new DebugOverlayTag("Delta", "Deltas from the sync protocol", Color.argb(255, 0, 200, 0));
    public static final DebugOverlayTag f14549b = new DebugOverlayTag("Sync Exception", "Uncaught exceptions from the sync protocol", -65536);
    public static final DebugOverlayTag f14550c = new DebugOverlayTag("Sync network", "Sync connection events (i.e. get_diffs)", -16776961);

    public static SyncDebugOverlaySettingsTags m18441a(InjectorLike injectorLike) {
        return new SyncDebugOverlaySettingsTags();
    }

    public final ImmutableSet<DebugOverlayTag> mo1148a() {
        return ImmutableSet.of(f14548a, f14549b, f14550c);
    }
}
