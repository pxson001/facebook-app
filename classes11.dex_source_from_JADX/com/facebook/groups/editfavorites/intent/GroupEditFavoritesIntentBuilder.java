package com.facebook.groups.editfavorites.intent;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: active_collection_id */
public class GroupEditFavoritesIntentBuilder {
    @FragmentChromeActivity
    private final Provider<ComponentName> f10124a;

    public static GroupEditFavoritesIntentBuilder m10473b(InjectorLike injectorLike) {
        return new GroupEditFavoritesIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public GroupEditFavoritesIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f10124a = provider;
    }

    public final Intent m10474a() {
        Intent intent = new Intent();
        intent.setComponent((ComponentName) this.f10124a.get());
        intent.putExtra("target_fragment", ContentFragmentType.GROUP_EDIT_FAVORITES_FRAGMENT.ordinal());
        return intent;
    }
}
