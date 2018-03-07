package com.facebook.groups.editsettings.fragment;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentModels.GroupPurposeModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;

/* compiled from: Unexpected Operation Type */
public class GroupPossiblePurposeListAdapter extends Adapter<ViewHolder> {
    public ImmutableList<GroupPurposeModel> f21669a;
    public GroupPurposeModel f21670b;

    /* compiled from: Unexpected Operation Type */
    public class GroupPurposeViewHolder extends ViewHolder {
        public final GroupPurposeItemView f21668l;

        public GroupPurposeViewHolder(GroupPurposeItemView groupPurposeItemView) {
            super(groupPurposeItemView);
            this.f21668l = groupPurposeItemView;
        }
    }

    public GroupPossiblePurposeListAdapter(ImmutableList<GroupPurposeModel> immutableList, GroupPurposeModel groupPurposeModel) {
        this.f21669a = immutableList;
        this.f21670b = groupPurposeModel;
    }

    public final ViewHolder m22628a(ViewGroup viewGroup, int i) {
        return new GroupPurposeViewHolder(new GroupPurposeItemView(viewGroup.getContext()));
    }

    public final void m22629a(ViewHolder viewHolder, int i) {
        final GroupPurposeModel groupPurposeModel = (GroupPurposeModel) this.f21669a.get(i);
        if (groupPurposeModel != null) {
            GroupPurposeViewHolder groupPurposeViewHolder = (GroupPurposeViewHolder) viewHolder;
            Object obj = (this.f21670b == null || !groupPurposeModel.m22863j().equals(this.f21670b.m22863j())) ? null : 1;
            GroupPurposeItemView groupPurposeItemView = groupPurposeViewHolder.f21668l;
            OnClickListener c31031 = new OnClickListener(this) {
                final /* synthetic */ GroupPossiblePurposeListAdapter f21667b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -633546096);
                    this.f21667b.f21670b = groupPurposeModel;
                    this.f21667b.notifyDataSetChanged();
                    Logger.a(2, EntryType.UI_INPUT_END, 1900567816, a);
                }
            };
            if (groupPurposeModel.m22864k() != null) {
                groupPurposeItemView.f21672i.a(Uri.parse(groupPurposeModel.m22864k().b()), GroupPurposeItemView.f21671h);
            }
            groupPurposeItemView.f21673j.setText(groupPurposeModel.m22862b());
            groupPurposeItemView.f21674k.setVisibility(obj != null ? 0 : 8);
            groupPurposeItemView.setOnClickListener(c31031);
        }
    }

    public final int aZ_() {
        return this.f21669a.size();
    }
}
