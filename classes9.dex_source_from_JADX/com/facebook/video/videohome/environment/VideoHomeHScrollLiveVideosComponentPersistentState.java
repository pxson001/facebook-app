package com.facebook.video.videohome.environment;

import android.os.SystemClock;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: start_state */
public class VideoHomeHScrollLiveVideosComponentPersistentState {
    public Set<String> f2856a = new HashSet();
    public long f2857b;
    public long f2858c;
    public int f2859d;
    public int f2860e;
    public boolean f2861f;
    @Nullable
    public ImmutableList<ReactionUnitComponentFields> f2862g;
    @Nullable
    public SessionStatusListener f2863h;
    @Nullable
    public HScrollRecyclerView f2864i;

    public final boolean m2769f() {
        long j = this.f2857b;
        boolean z = j > 0 && SystemClock.uptimeMillis() - j > 1000 * this.f2858c;
        return z;
    }
}
