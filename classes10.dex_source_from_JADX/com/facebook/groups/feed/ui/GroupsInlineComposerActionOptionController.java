package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.photos.intent.GroupsPhotosIntentBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadViewOptionsHandler.setupContactLoader */
public class GroupsInlineComposerActionOptionController {
    public static SecureContextHelper f22232a;
    public static Provider<ComponentName> f22233b;
    private static AlbumCreatorIntentBuilder f22234c;
    private static Provider<ViewerContext> f22235d;
    public static GroupsPhotosIntentBuilder f22236e;
    private static AnalyticsLogger f22237f;

    public static GroupsInlineComposerActionOptionController m23349b(InjectorLike injectorLike) {
        return new GroupsInlineComposerActionOptionController((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 12), AlbumCreatorIntentBuilder.b(injectorLike), IdBasedProvider.a(injectorLike, 372), GroupsPhotosIntentBuilder.m24253b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static GroupsInlineComposerActionOptionController m23344a(InjectorLike injectorLike) {
        return m23349b(injectorLike);
    }

    @Inject
    public GroupsInlineComposerActionOptionController(SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider, AlbumCreatorIntentBuilder albumCreatorIntentBuilder, Provider<ViewerContext> provider2, GroupsPhotosIntentBuilder groupsPhotosIntentBuilder, AnalyticsLogger analyticsLogger) {
        f22232a = secureContextHelper;
        f22233b = provider;
        f22234c = albumCreatorIntentBuilder;
        f22235d = provider2;
        f22236e = groupsPhotosIntentBuilder;
        f22237f = analyticsLogger;
    }

    public static void m23348a(String str, String str2, GraphQLGroupVisibility graphQLGroupVisibility, String str3, Context context) {
        m23345a("groups_seeds_composer_create_event");
        f22232a.a(EventCreationNikumanActivity.m16519a(context, "group_inline_composer".toString(), Long.valueOf(Long.parseLong(((ViewerContext) f22235d.get()).mUserId)), ActionMechanism.GROUP_PERMALINK_ACTIONS, str, str2, graphQLGroupVisibility, str3), context);
    }

    public static void m23347a(String str, Context context) {
        m23345a("groups_seeds_composer_create_chat");
        Intent component = new Intent().setComponent((ComponentName) f22233b.get());
        component.putExtra("group_feed_id", str);
        component.putExtra("target_fragment", ContentFragmentType.GROUP_CREATE_SIDE_CONVERSATION_FRAGMENT.ordinal());
        f22232a.a(component, context);
    }

    public static void m23346a(String str, Activity activity) {
        m23345a("groups_seeds_composer_create_album");
        AlbumCreatorIntentBuilder albumCreatorIntentBuilder = f22234c;
        AlbumCreatorSourceType albumCreatorSourceType = AlbumCreatorSourceType.COMPOSER;
        Builder builder = new Builder();
        builder.a = Long.parseLong(str);
        builder = builder;
        builder.b = TargetType.GROUP;
        f22232a.a(albumCreatorIntentBuilder.a(albumCreatorSourceType, null, builder.a()), 1991, activity);
    }

    public static void m23345a(String str) {
        HoneyClientEventFast a = f22237f.a(str, false);
        if (a.a()) {
            a.a("group_inline_composer");
            a.b();
        }
    }
}
