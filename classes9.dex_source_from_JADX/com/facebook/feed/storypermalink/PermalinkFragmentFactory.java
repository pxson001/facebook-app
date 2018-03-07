package com.facebook.feed.storypermalink;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.common.fragmentfactory.IReusableFragmentFactory;
import com.facebook.feed.permalink.PermalinkParams;
import com.facebook.feed.permalink.PermalinkParams.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import javax.annotation.Nullable;

/* compiled from: TW */
public class PermalinkFragmentFactory implements IReusableFragmentFactory {

    /* compiled from: TW */
    /* synthetic */ class C29421 {
        static final /* synthetic */ int[] f24513a = new int[StoryPermalinkParamsType.values().length];

        static {
            try {
                f24513a[StoryPermalinkParamsType.PLATFORM_KEY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24513a[StoryPermalinkParamsType.STORY_FBID_KEY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24513a[StoryPermalinkParamsType.FEED_STORY_JSON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f24513a[StoryPermalinkParamsType.NOTIF_STORY_JSON.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f24513a[StoryPermalinkParamsType.AD_PREVIEW_STORY_JSON.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f24513a[StoryPermalinkParamsType.AD_PREVIEW_PYML_JSON.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f24513a[StoryPermalinkParamsType.NOTIF_STORY_ID_KEY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f24513a[StoryPermalinkParamsType.FEED_STORY_ID_KEY.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @Nullable
    public final Fragment m26428a(Intent intent) {
        PermalinkParams a;
        StoryPermalinkParamsType valueOf = StoryPermalinkParamsType.valueOf(intent.getStringExtra("extra_permalink_param_type"));
        Builder builder = new Builder();
        builder.a = valueOf;
        builder = builder;
        builder.o = intent.getBooleanExtra("use_photo_mode", false);
        Builder builder2 = builder;
        builder2.q = (FeedbackLoggingParams) intent.getParcelableExtra("feedback_logging_params");
        builder = builder2;
        builder.r = intent.getBooleanExtra("RESHARE_BUTTON_EXPERIMENT_CLICKED", false);
        builder2 = builder;
        NotificationLogObject notificationLogObject = (NotificationLogObject) intent.getParcelableExtra("NOTIF_LOG");
        if (notificationLogObject != null) {
            builder2.k = notificationLogObject;
        }
        builder2.i = intent.getBooleanExtra("include_comments_disabled_fields", false);
        builder2.n = intent.getBooleanExtra("show_keyboard_on_first_load", false);
        String stringExtra = intent.getStringExtra("default_comment_ordering");
        if (stringExtra != null) {
            builder2.h = CommentOrderType.getOrder(stringExtra);
            stringExtra = intent.getStringExtra("story_fbid");
            if (stringExtra != null) {
                builder2.g = stringExtra;
            }
        }
        switch (C29421.f24513a[valueOf.ordinal()]) {
            case 1:
                builder2.b = intent.getStringExtra("extra_platform_id");
                break;
            case 2:
                builder2.b = intent.getStringExtra("story_fbid");
                break;
            case 3:
            case 4:
            case 5:
                builder2.d = intent.getStringExtra("permalink_story");
                break;
            case 6:
                builder2.d = intent.getStringExtra("permalink_story");
                a = builder2.a();
                PYMLPermalinkFragment pYMLPermalinkFragment = new PYMLPermalinkFragment();
                pYMLPermalinkFragment.g(a.q());
                return pYMLPermalinkFragment;
            default:
                builder2.b = intent.getStringExtra("story_id");
                builder2.c = intent.getStringExtra("story_cache_id");
                builder2.e = intent.getStringExtra("relevant_comment_id");
                builder2.l = (GraphQLComment) FlatBufferModelHelper.a(intent, "relevant_comment");
                builder2.f = intent.getStringExtra("comment_id");
                builder2.m = (GraphQLComment) FlatBufferModelHelper.a(intent, "comment");
                builder2.p = intent.getIntExtra("relevant_reaction_key", -1);
                stringExtra = intent.getStringExtra("notification_source");
                if (stringExtra != null) {
                    builder2.j = NotificationSource.valueOf(stringExtra);
                    break;
                }
                break;
        }
        a = builder2.a();
        StoryPermalinkFragment storyPermalinkFragment = new StoryPermalinkFragment();
        storyPermalinkFragment.g(a.q());
        return storyPermalinkFragment;
    }
}
