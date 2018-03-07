package com.facebook.groups.photos.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.groups.photos.fragment.GroupAlbumsFragment.C33181;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel.NodesModel;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel.NodesModel.AlbumCoverPhotoModel;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel.NodesModel.MediaModel.MediaNodesModel;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel.GroupAlbumsModel.NodesModel.MediaModel.MediaNodesModel.ImageModel;
import com.facebook.groups.photos.view.GroupAlbumRow;
import com.facebook.groups.photos.view.GroupCreateAlbumRow;
import com.facebook.groups.photos.view.GroupCreateAlbumRow.C33301;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TOXICLE_PUBLIC_INTERESTED */
public class GroupAlbumsAdapter extends FbBaseAdapter {
    public ImmutableList<NodesModel> f22992a = RegularImmutableList.a;
    private boolean f22993b;
    private C33181 f22994c;
    public GraphQLGroupPostStatus f22995d;

    /* compiled from: TOXICLE_PUBLIC_INTERESTED */
    enum ItemTypes {
        ALBUM_ROW,
        LOADING_BAR,
        CREATE_ALBUM_ROW
    }

    @Nullable
    public /* synthetic */ Object getItem(int i) {
        return m24212a(i);
    }

    @Inject
    public GroupAlbumsAdapter(@Assisted C33181 c33181) {
        this.f22994c = c33181;
    }

    public final void m24214a(boolean z) {
        if (z != this.f22993b) {
            this.f22993b = z;
            AdapterDetour.a(this, -991259619);
        }
    }

    public final View m24211a(int i, ViewGroup viewGroup) {
        switch (ItemTypes.values()[i]) {
            case LOADING_BAR:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904685, viewGroup, false);
            case ALBUM_ROW:
                return new GroupAlbumRow(viewGroup.getContext());
            case CREATE_ALBUM_ROW:
                return new GroupCreateAlbumRow(viewGroup.getContext());
            default:
                return new View(viewGroup.getContext());
        }
    }

    public int getItemViewType(int i) {
        if (i == 0 && m24210a()) {
            return ItemTypes.CREATE_ALBUM_ROW.ordinal();
        }
        if (m24210a()) {
            i--;
        }
        if (i < this.f22992a.size()) {
            return ItemTypes.ALBUM_ROW.ordinal();
        }
        return ItemTypes.LOADING_BAR.ordinal();
    }

    public final void m24213a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (ItemTypes.values()[i2]) {
            case LOADING_BAR:
                view.setVisibility(this.f22993b ? 0 : 8);
                return;
            case ALBUM_ROW:
                GroupAlbumRow groupAlbumRow = (GroupAlbumRow) view;
                NodesModel nodesModel = (NodesModel) obj;
                if (groupAlbumRow.f23098f != null) {
                    int i3;
                    int size = groupAlbumRow.f23098f.size();
                    for (i3 = 0; i3 < size; i3++) {
                        ((FbDraweeView) groupAlbumRow.f23098f.get(i3)).setVisibility(8);
                    }
                    groupAlbumRow.f23099g.setVisibility(8);
                    ImmutableList b = nodesModel.m24327d().m24302b();
                    if (b != null) {
                        if (b.size() >= 4) {
                            i3 = 0;
                            while (i3 < 4 && i3 < b.size()) {
                                ImageModel a = ((MediaNodesModel) b.get(i3)).m24296a();
                                if (!(a == null || a.m24290a() == null)) {
                                    Uri parse = Uri.parse(a.m24290a());
                                    FbDraweeView fbDraweeView = (FbDraweeView) groupAlbumRow.f23098f.get(i3);
                                    fbDraweeView.a(parse, GroupAlbumRow.f23093e);
                                    fbDraweeView.setVisibility(0);
                                }
                                i3++;
                            }
                        } else if (nodesModel.m24325b() != null) {
                            AlbumCoverPhotoModel.ImageModel a2 = nodesModel.m24325b().m24282a();
                            if (!(a2 == null || a2.m24277a() == null)) {
                                groupAlbumRow.f23099g.a(Uri.parse(a2.m24277a()), GroupAlbumRow.f23093e);
                                groupAlbumRow.f23099g.setVisibility(0);
                            }
                        }
                    }
                    ((TextView) groupAlbumRow.findViewById(2131559541)).setText(nodesModel.ns_().m24317a());
                    ((TextView) groupAlbumRow.findViewById(2131562621)).setText(groupAlbumRow.f23094a.getQuantityString(2131689815, nodesModel.m24327d().m24298a(), new Object[]{Integer.valueOf(nodesModel.m24327d().m24298a())}));
                }
                return;
            case CREATE_ALBUM_ROW:
                GroupCreateAlbumRow groupCreateAlbumRow = (GroupCreateAlbumRow) view;
                GraphQLGroupPostStatus graphQLGroupPostStatus = this.f22995d;
                C33181 c33181 = this.f22994c;
                if (graphQLGroupPostStatus == null || graphQLGroupPostStatus == GraphQLGroupPostStatus.CANNOT_POST) {
                    groupCreateAlbumRow.setVisibility(8);
                } else {
                    groupCreateAlbumRow.setVisibility(0);
                    groupCreateAlbumRow.setOnClickListener(new C33301(groupCreateAlbumRow, c33181));
                }
                return;
            default:
                return;
        }
    }

    public int getCount() {
        int size = this.f22992a.size();
        if (m24210a()) {
            size++;
        }
        if (this.f22993b) {
            return size + 1;
        }
        return size;
    }

    @Nullable
    public final NodesModel m24212a(int i) {
        if (i == 0 && m24210a()) {
            return null;
        }
        if (m24210a()) {
            i--;
        }
        if (i < this.f22992a.size()) {
            return (NodesModel) this.f22992a.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return ItemTypes.values().length;
    }

    private boolean m24210a() {
        return this.f22995d != GraphQLGroupPostStatus.CANNOT_POST;
    }
}
