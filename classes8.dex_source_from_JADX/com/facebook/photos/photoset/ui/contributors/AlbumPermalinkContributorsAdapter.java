package com.facebook.photos.photoset.ui.contributors;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.photos.photoset.ui.contributors.AlbumPermalinkContributorView.C19091;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: cmd */
public class AlbumPermalinkContributorsAdapter extends BaseAdapter {
    public ImmutableList<GraphQLActor> f17815a;

    /* compiled from: cmd */
    enum ContributorsList {
        CONTRIBUTOR
    }

    public int getCount() {
        return this.f17815a.size();
    }

    public int getViewTypeCount() {
        return ContributorsList.values().length;
    }

    public Object getItem(int i) {
        if (this.f17815a == null || i >= this.f17815a.size()) {
            return null;
        }
        return this.f17815a.get(i);
    }

    public long getItemId(int i) {
        if (this.f17815a == null || i >= this.f17815a.size() || this.f17815a.get(i) == null || ((GraphQLActor) this.f17815a.get(i)).H() == null) {
            return -1;
        }
        return Long.parseLong(((GraphQLActor) this.f17815a.get(i)).H());
    }

    public int getItemViewType(int i) {
        return ContributorsList.CONTRIBUTOR.ordinal();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new AlbumPermalinkContributorView(viewGroup.getContext());
        } else {
            AlbumPermalinkContributorView albumPermalinkContributorView = (AlbumPermalinkContributorView) view;
        }
        GraphQLActor graphQLActor = (GraphQLActor) this.f17815a.get(i);
        Preconditions.checkState(graphQLActor != null);
        view.f17813b = graphQLActor;
        if (!(graphQLActor.ai() == null || graphQLActor.ai().b() == null)) {
            ((FbDraweeView) view.findViewById(2131560796)).a(ImageUtil.a(graphQLActor.ai()), AlbumPermalinkContributorView.f17812a);
        }
        FbTextView fbTextView = (FbTextView) view.findViewById(2131560797);
        if (graphQLActor.aa() != null) {
            fbTextView.setText(graphQLActor.aa());
        } else {
            fbTextView.setVisibility(8);
        }
        view.setOnClickListener(new C19091(view));
        return view;
    }
}
