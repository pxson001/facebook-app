package com.facebook.redspace.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.ActorModel.RedspaceModel.RecentStoryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitFragmentModel;
import com.facebook.redspace.ui.RedSpaceHomeComposerView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;

/* compiled from: RATING_ONLY */
public class RedSpaceHomeComposerAdapter extends FbBaseAdapter {
    private final OnClickListener f11727a;
    public ImmutableList<RedSpaceVisitFragmentModel> f11728b;
    public int f11729c;
    public RecentStoryModel f11730d;

    public RedSpaceHomeComposerAdapter(OnClickListener onClickListener) {
        this.f11727a = onClickListener;
    }

    public final View m12157a(int i, ViewGroup viewGroup) {
        RedSpaceHomeComposerView redSpaceHomeComposerView = (RedSpaceHomeComposerView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906776, viewGroup, false);
        redSpaceHomeComposerView.setOnClickListener(this.f11727a);
        return redSpaceHomeComposerView;
    }

    public final void m12158a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        RedSpaceHomeComposerView redSpaceHomeComposerView = (RedSpaceHomeComposerView) view;
        if (this.f11730d != null) {
            redSpaceHomeComposerView.m12762a(this.f11730d);
        }
        if (this.f11728b != null) {
            redSpaceHomeComposerView.m12763a(this.f11728b, this.f11729c);
            this.f11729c = 0;
        }
    }

    public int getCount() {
        return 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }
}
