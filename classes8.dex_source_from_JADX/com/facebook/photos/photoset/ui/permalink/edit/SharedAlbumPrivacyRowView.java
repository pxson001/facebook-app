package com.facebook.photos.photoset.ui.permalink.edit;

import android.content.Context;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.privacy.ui.PrivacyOptionRowView;

/* compiled from: click_tag_button */
public class SharedAlbumPrivacyRowView extends PrivacyOptionRowView {
    public SharedAlbumPrivacyRowView(Context context) {
        super(context, null);
    }

    public final void m21854a(GraphQLPrivacyOption graphQLPrivacyOption, boolean z, String str) {
        super.a(graphQLPrivacyOption, z);
        this.b.setText(str);
    }
}
