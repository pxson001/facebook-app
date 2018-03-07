package com.facebook.feedplugins.profile.calltoaction;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SO-02E */
public class ProfileGenericCallToActionPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f23747a;
    final /* synthetic */ ProfileGenericCallToActionPartDefinition f23748b;

    public ProfileGenericCallToActionPartDefinition$1(ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink) {
        this.f23748b = profileGenericCallToActionPartDefinition;
        this.f23747a = graphQLStoryActionLink;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1761522204);
        Intent a2 = ((UriIntentMapper) this.f23748b.b.get()).a(view.getContext(), this.f23747a.aE());
        if (a2 != null) {
            ((SecureContextHelper) this.f23748b.c.get()).a(a2, view.getContext());
        }
        Logger.a(2, EntryType.UI_INPUT_END, -230079188, a);
    }
}
