package com.facebook.groups.docsandfiles.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileModel;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileState;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItemProvider;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment;
import com.facebook.inject.Assisted;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: User triggered soft error from Intern settings */
public class GroupDocsAndFilesAdapter extends Adapter<ViewHolder> {
    public List<FileModel> f21327a = new ArrayList();
    public boolean f21328b;
    private String f21329c;
    public GroupDocsAndFilesFragment f21330d;
    public final Map<String, FileModel> f21331e = new LinkedHashMap();
    private GroupDocOrFileListViewItemProvider f21332f;

    /* compiled from: User triggered soft error from Intern settings */
    class GroupDocOrFileViewHolder extends ViewHolder {
        public GroupDocOrFileListViewItem f21326l;

        public GroupDocOrFileViewHolder(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            super(groupDocOrFileListViewItem);
            this.f21326l = groupDocOrFileListViewItem;
        }
    }

    /* compiled from: User triggered soft error from Intern settings */
    enum ItemTypes {
        FILE_OR_DOC_ROW,
        LOADING_BAR
    }

    /* compiled from: User triggered soft error from Intern settings */
    class LoadingViewHolder extends ViewHolder {
        public LoadingViewHolder(View view) {
            super(view);
        }
    }

    @Inject
    public GroupDocsAndFilesAdapter(@Assisted String str, GroupDocOrFileListViewItemProvider groupDocOrFileListViewItemProvider) {
        this.f21329c = str;
        this.f21332f = groupDocOrFileListViewItemProvider;
    }

    public final ViewHolder m22311a(ViewGroup viewGroup, int i) {
        if (i == ItemTypes.FILE_OR_DOC_ROW.ordinal()) {
            return new GroupDocOrFileViewHolder(this.f21332f.m22349a(viewGroup.getContext(), this.f21330d));
        }
        return new LoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130904660, viewGroup, false));
    }

    public final void m22313a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof GroupDocOrFileViewHolder) {
            ((GroupDocOrFileViewHolder) viewHolder).f21326l.m22348a((FileModel) this.f21327a.get(i), this.f21329c, i);
        }
    }

    public final int aZ_() {
        return (this.f21328b ? 1 : 0) + this.f21327a.size();
    }

    public int getItemViewType(int i) {
        if (i < this.f21327a.size()) {
            return ItemTypes.FILE_OR_DOC_ROW.ordinal();
        }
        return ItemTypes.LOADING_BAR.ordinal();
    }

    public final void m22314a(String str, FileState fileState) {
        FileModel fileModel = (FileModel) this.f21331e.get(str);
        if (fileModel != null) {
            fileModel.f21392b = fileState;
            notifyDataSetChanged();
        }
    }

    public final void m22312a(int i, FileState fileState) {
        FileModel fileModel = (FileModel) this.f21327a.get(i);
        if (fileModel != null) {
            fileModel.f21392b = fileState;
            j_(i);
        }
    }

    public final void m22315a(String str, boolean z) {
        FileModel fileModel = (FileModel) this.f21331e.remove(str);
        if (fileModel != null && z) {
            this.f21327a.remove(fileModel);
            notifyDataSetChanged();
        }
    }
}
