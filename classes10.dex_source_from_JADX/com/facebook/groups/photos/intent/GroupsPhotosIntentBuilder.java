package com.facebook.groups.photos.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TOXICLE_PRIVATE_GOING_SELECTED_WITH_CHEVRON */
public class GroupsPhotosIntentBuilder {
    private static final CallerContext f23030a = CallerContext.a(GroupsPhotosIntentBuilder.class, "group_photos");
    private final Provider<ComponentName> f23031b;
    private Resources f23032c;

    public static GroupsPhotosIntentBuilder m24253b(InjectorLike injectorLike) {
        return new GroupsPhotosIntentBuilder(IdBasedProvider.a(injectorLike, 12), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupsPhotosIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider, Resources resources) {
        this.f23031b = provider;
        this.f23032c = resources;
    }

    public final Intent m24254a(String str, String str2, String str3) {
        Intent a = m24252a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_ALBUM_FRAGMENT.ordinal());
        a.putExtra("ALBUM_ID", str);
        Builder builder = new Builder();
        builder.o = str;
        FlatBufferModelHelper.a(a, "extra_album_selected", builder.a());
        a.putExtra("extra_caller_context", f23030a);
        if (!Strings.isNullOrEmpty(str2)) {
            if (Strings.isNullOrEmpty(str3)) {
                str3 = this.f23032c.getString(2131242203);
            }
            ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder();
            builder2.b = TargetType.GROUP;
            builder2 = builder2;
            builder2.a = Long.parseLong(str2);
            builder2 = builder2;
            builder2.c = str3;
            a.putExtra("extra_composer_target_data", builder2.a());
        }
        return a;
    }

    public final Intent m24255b(String str, String str2, String str3) {
        Intent a = m24252a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_ALBUM_FRAGMENT.ordinal());
        a.putExtra("extra_album_id", str);
        a.putExtra("group_feed_id", str2);
        a.putExtra("group_name", str3);
        return a;
    }

    private Intent m24252a() {
        return new Intent().setComponent((ComponentName) this.f23031b.get());
    }
}
