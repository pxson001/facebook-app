package com.facebook.reaction.feed.persistentstate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: attachment_icon */
public class ReactionHScrollStateUtil {
    public static void m23193a(LinearLayoutManager linearLayoutManager, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState, RecyclerView recyclerView) {
        int l = linearLayoutManager.l();
        View c = linearLayoutManager.c(l);
        if (c != null) {
            int left = c.getLeft() - recyclerView.getPaddingLeft();
            reactionHScrollComponentPersistentState.f19173c = l;
            reactionHScrollComponentPersistentState.f19172b = left;
        }
    }

    public static void m23192a(LinearLayoutManager linearLayoutManager, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState) {
        linearLayoutManager.d(reactionHScrollComponentPersistentState.f19173c, reactionHScrollComponentPersistentState.f19172b);
    }
}
