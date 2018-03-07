package com.facebook.messaging.debugoverlay;

import android.graphics.Color;
import com.facebook.debug.debugoverlay.DebugOverlayTag;
import com.facebook.debug.debugoverlay.DebugOverlayTagSetProvider;
import com.google.common.collect.ImmutableSet;

/* compiled from: maxTransactionsToFetch */
public class MessagesDebugOverlaySettingsTags implements DebugOverlayTagSetProvider {
    public static final DebugOverlayTag f10824a = new DebugOverlayTag("Threads Fetch Web", "FQL/GQL fetches related to threads/messages", Color.argb(255, 255, 165, 0));
    public static final DebugOverlayTag f10825b = new DebugOverlayTag("Threads Fetch DB", "Thread operations at DB level", -65281);
    public static final DebugOverlayTag f10826c = new DebugOverlayTag("Threads Fetch Cache", "Thread operations Cache level", -7829368);
    public static final DebugOverlayTag f10827d = new DebugOverlayTag("Threads Fetch Caller", "Thread operations' callers", -16777216);
    public static final DebugOverlayTag f10828e = new DebugOverlayTag("Delta", "Deltas from the sync protocol", Color.argb(255, 0, 200, 0));
    public static final DebugOverlayTag f10829f = new DebugOverlayTag("Sync Exception", "Uncaught exceptions from the sync protocol", -65536);
    public static final DebugOverlayTag f10830g = new DebugOverlayTag("Sync network", "Sync connection events (i.e. get_diffs)", -16776961);

    public final ImmutableSet<DebugOverlayTag> m11258a() {
        return ImmutableSet.of(f10824a, f10825b, f10826c, f10827d, f10828e, f10829f, new DebugOverlayTag[]{f10830g});
    }
}
