package com.facebook.groups.feed.ui;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ThreadViewMessagesFragment_QPBanner_NullIntent */
public class GroupsInlineComposerSproutUtil {
    public final Resources f22238a;
    public final GroupsComposerSproutLauncherProvider f22239b;

    public static GroupsInlineComposerSproutUtil m23350b(InjectorLike injectorLike) {
        return new GroupsInlineComposerSproutUtil(ResourcesMethodAutoProvider.a(injectorLike), (GroupsComposerSproutLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupsComposerSproutLauncherProvider.class));
    }

    @Inject
    public GroupsInlineComposerSproutUtil(Resources resources, GroupsComposerSproutLauncherProvider groupsComposerSproutLauncherProvider) {
        this.f22238a = resources;
        this.f22239b = groupsComposerSproutLauncherProvider;
    }
}
