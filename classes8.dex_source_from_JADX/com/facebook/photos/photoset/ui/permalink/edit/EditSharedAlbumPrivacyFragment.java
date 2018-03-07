package com.facebook.photos.photoset.ui.permalink.edit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.photoset.ui.permalink.edit.SharedAlbumPrivacyOptionAdapter.C19231;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: client_ttl_seconds */
public class EditSharedAlbumPrivacyFragment extends FbFragment {
    @Inject
    public PrivacyMapping f17878a;
    private BetterListView f17879b;
    private SharedAlbumPrivacyOptionAdapter f17880c;
    private ImmutableList<GraphQLPrivacyOption> f17881d;
    private GraphQLPrivacyOption f17882e;

    /* compiled from: client_ttl_seconds */
    public class C19221 {
        public final /* synthetic */ EditSharedAlbumPrivacyFragment f17877a;

        C19221(EditSharedAlbumPrivacyFragment editSharedAlbumPrivacyFragment) {
            this.f17877a = editSharedAlbumPrivacyFragment;
        }
    }

    public static void m21847a(Object obj, Context context) {
        ((EditSharedAlbumPrivacyFragment) obj).f17878a = PrivacyMapping.m21850a(FbInjector.get(context));
    }

    public final void m21849c(Bundle bundle) {
        super.c(bundle);
        Class cls = EditSharedAlbumPrivacyFragment.class;
        m21847a(this, getContext());
        List<PrivacyOptionWithIconFields> b = FlatBufferModelHelper.b(this.s, "input_album");
        if (b == null) {
            throw new IllegalStateException("Should supply INPUT_ALBUM for editing privacy");
        }
        Collection a = Lists.a();
        for (PrivacyOptionWithIconFields privacyOptionWithIconFields : b) {
            if (this.f17878a.m21852a(privacyOptionWithIconFields)) {
                a.add(privacyOptionWithIconFields);
            }
        }
        this.f17881d = ImmutableList.copyOf(a);
        this.f17882e = (GraphQLPrivacyOption) FlatBufferModelHelper.a(this.s, "selected_album_privacy");
    }

    public final View m21848a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -361035102);
        View inflate = layoutInflater.inflate(2130903953, null);
        this.f17879b = (BetterListView) inflate.findViewById(2131559373);
        this.f17880c = new SharedAlbumPrivacyOptionAdapter(getContext(), this.f17881d, this.f17878a);
        this.f17880c.f17892e = this.f17882e;
        SharedAlbumPrivacyOptionAdapter sharedAlbumPrivacyOptionAdapter = this.f17880c;
        sharedAlbumPrivacyOptionAdapter.f17890c = new C19221(this);
        sharedAlbumPrivacyOptionAdapter.f17891d = new C19231(sharedAlbumPrivacyOptionAdapter);
        this.f17879b.setAdapter(this.f17880c);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -917311888, a);
        return inflate;
    }
}
