package com.facebook.messaging.composershortcuts;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewStub;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.recyclerview.RecyclerViewScrollPosition;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messages AS m */
public class OverflowComposerShortcutItemViewHolder extends ViewHolder {
    public final FbDraweeView f10111l;
    public final FbTextView f10112m;
    public final FbTextView f10113n;
    public final FbTextView f10114o;
    public final ViewStub f10115p;
    public final OverflowComposerShortcutItemView f10116q;
    public final RecyclerView f10117r;
    public final PlatformContentAdapter f10118s;
    public String f10119t;

    @Inject
    public OverflowComposerShortcutItemViewHolder(PlatformContentAdapter platformContentAdapter, @Assisted View view) {
        super(view);
        this.f10116q = (OverflowComposerShortcutItemView) view;
        this.f10111l = (FbDraweeView) view.findViewById(2131559122);
        this.f10112m = (FbTextView) view.findViewById(2131558927);
        this.f10113n = (FbTextView) view.findViewById(2131559627);
        this.f10114o = (FbTextView) view.findViewById(2131565295);
        this.f10115p = (ViewStub) view.findViewById(2131565296);
        this.f10117r = (RecyclerView) view.findViewById(2131565297);
        this.f10118s = platformContentAdapter;
        this.f10117r.setAdapter(this.f10118s);
    }

    public final void m10596a(@Nullable RecyclerViewScrollPosition recyclerViewScrollPosition) {
        int i;
        int i2 = 0;
        LinearLayoutManager linearLayoutManager = this.f10116q.f10110b;
        if (recyclerViewScrollPosition != null) {
            i = recyclerViewScrollPosition.a;
        } else {
            i = 0;
        }
        if (recyclerViewScrollPosition != null) {
            i2 = recyclerViewScrollPosition.b;
        }
        linearLayoutManager.d(i, i2);
    }
}
