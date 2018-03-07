package com.facebook.photos.albums;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.albums.PandoraAlbumsRowView.VideoAlbumPosition;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: main_ui */
public class PandoraAlbumsAdapter extends BaseAdapter {
    public final List<GraphQLAlbum> f9354a = new ArrayList();
    private GraphQLAlbumsConnection f9355b;
    private GraphQLAlbumsConnection f9356c;
    private String f9357d;
    private boolean f9358e;
    public GraphQLAlbum f9359f;
    private boolean f9360g = false;
    private boolean f9361h;
    private Integer f9362i;
    private boolean f9363j;

    public static PandoraAlbumsAdapter m11353a(InjectorLike injectorLike) {
        return new PandoraAlbumsAdapter();
    }

    public final void m11356a(String str, boolean z, boolean z2, boolean z3, @Nullable Integer num) {
        this.f9357d = str;
        this.f9360g = z;
        this.f9361h = z2;
        this.f9358e = z3;
        this.f9362i = num;
        this.f9363j = false;
    }

    public final void m11357b(GraphQLAlbumsConnection graphQLAlbumsConnection, boolean z) {
        List list = this.f9354a;
        List arrayList = new ArrayList();
        if (graphQLAlbumsConnection != null) {
            arrayList.addAll(graphQLAlbumsConnection.a());
        }
        list.addAll(arrayList);
        m11354a();
        this.f9363j = z;
        AdapterDetour.a(this, -1645011992);
    }

    public final void m11355a(GraphQLAlbumsConnection graphQLAlbumsConnection) {
        this.f9355b = graphQLAlbumsConnection;
        m11354a();
        AdapterDetour.a(this, -1596479293);
    }

    private void m11354a() {
        Builder builder = new Builder();
        if (this.f9355b != null) {
            builder.b(this.f9355b.a());
        }
        builder.b(this.f9354a);
        ImmutableList b = builder.b();
        if (b != null && !b.isEmpty()) {
            GraphQLAlbumsConnection.Builder builder2 = new GraphQLAlbumsConnection.Builder();
            builder2.d = builder.b();
            this.f9356c = builder2.a();
        }
    }

    public int getCount() {
        int i = 1;
        int i2 = this.f9359f != null ? 1 : 0;
        if (this.f9358e) {
            i2++;
        }
        if (this.f9356c == null || this.f9356c.a() == null) {
            return i2;
        }
        i2 += this.f9356c.a().size();
        i2 = (i2 % 2 == 0 ? 0 : 1) + (i2 / 2);
        if (!this.f9363j) {
            i = 0;
        }
        return i2 + i;
    }

    public Object getItem(int i) {
        if (i == -2) {
            return null;
        }
        if (i == -1) {
            return this.f9359f;
        }
        if (this.f9356c == null || this.f9356c.a() == null || this.f9356c.a().size() <= i) {
            return null;
        }
        return (GraphQLAlbum) this.f9356c.a().get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f9363j && i == getCount() - 1) {
            view = new ProgressBar(viewGroup.getContext());
            CustomViewUtils.b(view, new ColorDrawable(viewGroup.getResources().getColor(2131361920)));
            return view;
        }
        View pandoraAlbumsRowView;
        VideoAlbumPosition videoAlbumPosition = VideoAlbumPosition.NONE;
        int i2 = 0;
        if (this.f9358e && this.f9359f != null) {
            i2 = 2;
        } else if (this.f9358e || this.f9359f != null) {
            i2 = 1;
        }
        if (i == 0) {
            switch (i2) {
                case 1:
                    if (this.f9359f != null) {
                        videoAlbumPosition = VideoAlbumPosition.LEFT;
                        break;
                    }
                    break;
                case 2:
                    videoAlbumPosition = VideoAlbumPosition.RIGHT;
                    break;
                default:
                    videoAlbumPosition = VideoAlbumPosition.NONE;
                    break;
            }
        }
        int i3 = (i * 2) - i2;
        GraphQLAlbum graphQLAlbum = (GraphQLAlbum) getItem(i3);
        GraphQLAlbum graphQLAlbum2 = (GraphQLAlbum) getItem(((i * 2) - i2) + 1);
        if (view == null || (view instanceof ProgressBar)) {
            pandoraAlbumsRowView = new PandoraAlbumsRowView(viewGroup.getContext());
        } else if (!(view instanceof PandoraAlbumsRowView)) {
            return view;
        } else {
            pandoraAlbumsRowView = (PandoraAlbumsRowView) view;
        }
        if (this.f9362i != null) {
            CustomViewUtils.b(pandoraAlbumsRowView, new ColorDrawable(this.f9362i.intValue()));
        }
        pandoraAlbumsRowView.m11363a(i3, this.f9357d, this.f9360g, graphQLAlbum, graphQLAlbum2, this.f9361h, videoAlbumPosition);
        return pandoraAlbumsRowView;
    }
}
