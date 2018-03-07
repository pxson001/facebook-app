package com.facebook.groups.docsandfiles.view;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: Unknown item type for TimelineActionBar.getEvent  */
public class DefaultGroupDocsAndFilesViewFactory {
    public Resources f21502a;

    public static DefaultGroupDocsAndFilesViewFactory m22522b(InjectorLike injectorLike) {
        return new DefaultGroupDocsAndFilesViewFactory(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultGroupDocsAndFilesViewFactory(Resources resources) {
        this.f21502a = resources;
    }
}
