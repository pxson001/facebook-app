package com.facebook.photos.photoset.ui.contributors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.titlebar.FbTitleBar;

/* compiled from: closing_text */
public class AlbumPermalinkContributorsFragment extends FbFragment {
    public AlbumPermalinkContributorsAdapter f17816a;

    public final View m21779a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1931244183);
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(2130903234, null);
        FbTitleBar fbTitleBar = (FbTitleBar) ao().findViewById(2131558563);
        fbTitleBar.setTitle(b(2131234369));
        fbTitleBar.setButtonSpecs(null);
        GraphQLAlbum graphQLAlbum = (GraphQLAlbum) FlatBufferModelHelper.a(this.s, "arg_album");
        if (this.f17816a == null) {
            this.f17816a = new AlbumPermalinkContributorsAdapter();
        }
        this.f17816a.f17815a = graphQLAlbum.q();
        AdapterDetour.a(this.f17816a, -1249085485);
        ((ListView) linearLayout.findViewById(2131559550)).setAdapter(this.f17816a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 583854687, a);
        return linearLayout;
    }
}
