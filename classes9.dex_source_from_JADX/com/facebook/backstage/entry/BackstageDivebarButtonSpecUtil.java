package com.facebook.backstage.entry;

import android.content.res.Resources;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.graphql.BackstageBadgeCountGraphQLHelper;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: resized_size */
public class BackstageDivebarButtonSpecUtil {
    private final Resources f5156a;
    private final BackstageBadgeCountGraphQLHelper f5157b;
    private BackstageGatekeepers f5158c;

    private static BackstageDivebarButtonSpecUtil m4929b(InjectorLike injectorLike) {
        return new BackstageDivebarButtonSpecUtil(BackstageBadgeCountGraphQLHelper.m4964b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), BackstageGatekeepers.m4256b(injectorLike));
    }

    @Inject
    public BackstageDivebarButtonSpecUtil(BackstageBadgeCountGraphQLHelper backstageBadgeCountGraphQLHelper, Resources resources, BackstageGatekeepers backstageGatekeepers) {
        this.f5156a = resources;
        this.f5157b = backstageBadgeCountGraphQLHelper;
        this.f5158c = backstageGatekeepers;
    }
}
