package com.facebook.deeplinking.activity;

import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.graphql.DeepLinkingGraphQlQueryFragmentsModels.GetURLInfoModel;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.toaster.ToastThreadUtil;
import javax.annotation.Nullable;

/* compiled from: photo_large */
public class StoryDeepLinkLoadingActivity extends BaseDeepLinkLoadingActivity {
    protected final void mo268a(@Nullable Uri uri, @Nullable GraphQLResult<GetURLInfoModel> graphQLResult) {
        if (uri == null || graphQLResult == null || graphQLResult.e == null) {
            m6916a(uri);
            return;
        }
        GraphQLObjectType j = ((GetURLInfoModel) graphQLResult.e).m6928j();
        if (j == null || j.g() != 80218325) {
            ((ToastThreadUtil) this.f6610v.get()).a(getString(2131240004));
            m6916a(null);
            return;
        }
        CharSequence k = ((GetURLInfoModel) graphQLResult.e).m6929k();
        if (StringUtil.a(k)) {
            m6916a(uri);
            return;
        }
        this.f6606r.a(this.f6609u.m6910a(StringFormatUtil.formatStrLocaleSafe(FBLinks.aS, k, null)), this);
    }
}
