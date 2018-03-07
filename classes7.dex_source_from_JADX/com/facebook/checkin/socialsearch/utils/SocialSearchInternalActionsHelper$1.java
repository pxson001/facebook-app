package com.facebook.checkin.socialsearch.utils;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: uScale */
class SocialSearchInternalActionsHelper$1 implements OnMenuItemClickListener {
    final /* synthetic */ GraphQLStory f1151a;
    final /* synthetic */ Context f1152b;
    final /* synthetic */ SocialSearchInternalActionsHelper f1153c;

    SocialSearchInternalActionsHelper$1(SocialSearchInternalActionsHelper socialSearchInternalActionsHelper, GraphQLStory graphQLStory, Context context) {
        this.f1153c = socialSearchInternalActionsHelper;
        this.f1151a = graphQLStory;
        this.f1152b = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f1153c.a.a(this.f1152b, StringFormatUtil.a(FBLinks.ge, new Object[]{this.f1151a.c()}));
        return true;
    }
}
