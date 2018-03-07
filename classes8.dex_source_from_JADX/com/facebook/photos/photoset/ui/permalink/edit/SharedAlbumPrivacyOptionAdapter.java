package com.facebook.photos.photoset.ui.permalink.edit;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.photoset.ui.permalink.edit.EditSharedAlbumPrivacyFragment.C19221;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.google.common.collect.ImmutableList;

/* compiled from: client_location_time */
public class SharedAlbumPrivacyOptionAdapter extends BaseAdapter {
    Context f17888a;
    ImmutableList<GraphQLPrivacyOption> f17889b;
    public C19221 f17890c;
    public OnClickListener f17891d;
    public GraphQLPrivacyOption f17892e;
    private PrivacyMapping f17893f;

    /* compiled from: client_location_time */
    public class C19231 implements OnClickListener {
        final /* synthetic */ SharedAlbumPrivacyOptionAdapter f17887a;

        public C19231(SharedAlbumPrivacyOptionAdapter sharedAlbumPrivacyOptionAdapter) {
            this.f17887a = sharedAlbumPrivacyOptionAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 892867952);
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) view.getTag();
            if (graphQLPrivacyOption != null) {
                C19221 c19221 = this.f17887a.f17890c;
                boolean equals = graphQLPrivacyOption.equals(this.f17887a.f17892e);
                Intent intent = new Intent();
                if (!equals) {
                    FlatBufferModelHelper.a(intent, "privacy_option", graphQLPrivacyOption);
                }
                c19221.f17877a.ao().setResult(-1, intent);
                c19221.f17877a.ao().finish();
                this.f17887a.f17892e = graphQLPrivacyOption;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1675094332, a);
        }
    }

    public SharedAlbumPrivacyOptionAdapter(Context context, ImmutableList<GraphQLPrivacyOption> immutableList, PrivacyMapping privacyMapping) {
        this.f17888a = context;
        this.f17889b = immutableList;
        this.f17893f = privacyMapping;
    }

    public int getCount() {
        return this.f17889b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public Object getItem(int i) {
        return this.f17889b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        PrivacyOptionWithIconFields privacyOptionWithIconFields = (GraphQLPrivacyOption) getItem(i);
        String b = this.f17893f.m21853b(privacyOptionWithIconFields);
        if (view != null) {
            view = (SharedAlbumPrivacyRowView) view;
        } else {
            view = new SharedAlbumPrivacyRowView(this.f17888a);
        }
        view.m21854a(privacyOptionWithIconFields, privacyOptionWithIconFields.equals(this.f17892e), b);
        view.setOnClickListener(this.f17891d);
        view.setTag(privacyOptionWithIconFields);
        return view;
    }
}
