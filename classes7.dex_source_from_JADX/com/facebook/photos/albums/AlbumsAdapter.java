package com.facebook.photos.albums;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.inject.Assisted;
import com.facebook.photos.albums.util.PandoraAlbumItemCountUtil;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: marginLeft */
public class AlbumsAdapter extends BaseAdapter implements Filterable {
    public GraphQLAlbumsConnection f9318a;
    public ImmutableList<GraphQLAlbum> f9319b;
    private String f9320c;
    public AlbumsAdapterMode f9321d;

    /* compiled from: marginLeft */
    class C07541 extends Filter {
        final /* synthetic */ AlbumsAdapter f9317a;

        C07541(AlbumsAdapter albumsAdapter) {
            this.f9317a = albumsAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            Builder builder = ImmutableList.builder();
            ImmutableList a = this.f9317a.f9318a.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLAlbum graphQLAlbum = (GraphQLAlbum) a.get(i);
                if (graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.SHARED) {
                    builder.c(graphQLAlbum);
                }
            }
            ImmutableList b = builder.b();
            filterResults.values = b;
            filterResults.count = b.size();
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.count == 0) {
                AdapterDetour.b(this.f9317a, -1402122713);
                return;
            }
            this.f9317a.f9319b = (ImmutableList) filterResults.values;
            AdapterDetour.a(this.f9317a, 678827413);
        }
    }

    /* compiled from: marginLeft */
    public enum AlbumsAdapterMode {
        ENABLE_OPTIONS,
        DEFAULT
    }

    @Inject
    public AlbumsAdapter(@Assisted AlbumsAdapterMode albumsAdapterMode) {
        this.f9321d = albumsAdapterMode;
    }

    public final void m11330a(GraphQLAlbumsConnection graphQLAlbumsConnection) {
        this.f9318a = graphQLAlbumsConnection;
        if (this.f9318a != null) {
            this.f9319b = this.f9318a.a();
        }
        AdapterDetour.a(this, 130998137);
    }

    public Filter getFilter() {
        return new C07541(this);
    }

    public int getCount() {
        return this.f9319b == null ? 0 : this.f9319b.size();
    }

    public Object getItem(int i) {
        return this.f9319b == null ? null : (GraphQLAlbum) this.f9319b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m11329a(i, view, viewGroup);
    }

    public final void m11331a(String str) {
        this.f9320c = str;
        AdapterDetour.a(this, 1126597056);
    }

    private View m11329a(int i, View view, ViewGroup viewGroup) {
        Object obj;
        Object obj2;
        boolean z;
        boolean z2;
        GraphQLAlbum graphQLAlbum = (GraphQLAlbum) getItem(i);
        if (view != null) {
            view = (AlbumView) view;
        } else {
            view = new AlbumView(viewGroup.getContext());
        }
        String str = this.f9320c;
        if (this.f9321d == AlbumsAdapterMode.ENABLE_OPTIONS) {
            Object obj3;
            if (graphQLAlbum != null && graphQLAlbum.p() && graphQLAlbum.n()) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if (obj3 != null) {
                obj = 1;
                obj2 = obj;
                z = false;
                view.f9314j = graphQLAlbum;
                if (graphQLAlbum.j() != null || graphQLAlbum.j().af() == null || Strings.isNullOrEmpty(graphQLAlbum.j().af().b())) {
                    view.setThumbnailPlaceholderResource(2130839460);
                    view.setThumbnailUri(null);
                } else {
                    view.setThumbnailPlaceholderDrawable(null);
                    view.setThumbnailUri(Uri.parse(graphQLAlbum.j().af().b()));
                }
                view.setActionButtonBackground(null);
                view.setThumbnailSize(ThumbnailSize.MEDIUM);
                view.setBackgroundResource(2130837987);
                view.setTitleText(graphQLAlbum.E().a());
                view.setSubtitleText(PandoraAlbumItemCountUtil.m11419a(graphQLAlbum, view.getContext()));
                view.setContentDescription(view.getTitleText() + ": " + view.getSubtitleText());
                view.setTag(graphQLAlbum.u());
                z2 = str == null && Objects.equal(str, graphQLAlbum.u());
                if (z2) {
                    view.setActionButtonResource(2130838048);
                    view.setActionButtonContentDescription(graphQLAlbum.E().a());
                    view.setActionButtonOnClickListener(null);
                } else if (obj2 != null) {
                    view.setActionButtonResource(2130840929);
                    view.setActionButtonOnClickListener(view.f9315k);
                }
                if (z2 || obj2 != null) {
                    z = true;
                }
                view.setShowAuxView(z);
                view.setOnClickListener(view.f9316l);
                return view;
            }
        }
        obj = null;
        obj2 = obj;
        z = false;
        view.f9314j = graphQLAlbum;
        if (graphQLAlbum.j() != null) {
        }
        view.setThumbnailPlaceholderResource(2130839460);
        view.setThumbnailUri(null);
        view.setActionButtonBackground(null);
        view.setThumbnailSize(ThumbnailSize.MEDIUM);
        view.setBackgroundResource(2130837987);
        view.setTitleText(graphQLAlbum.E().a());
        view.setSubtitleText(PandoraAlbumItemCountUtil.m11419a(graphQLAlbum, view.getContext()));
        view.setContentDescription(view.getTitleText() + ": " + view.getSubtitleText());
        view.setTag(graphQLAlbum.u());
        if (str == null) {
        }
        if (z2) {
            view.setActionButtonResource(2130838048);
            view.setActionButtonContentDescription(graphQLAlbum.E().a());
            view.setActionButtonOnClickListener(null);
        } else if (obj2 != null) {
            view.setActionButtonResource(2130840929);
            view.setActionButtonOnClickListener(view.f9315k);
        }
        z = true;
        view.setShowAuxView(z);
        view.setOnClickListener(view.f9316l);
        return view;
    }
}
