package com.facebook.feed.permalink;

import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.controller.mutation.BaseMutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: album_create_failed */
public class PermalinkController {
    public static final String f19559a = PermalinkController.class.getSimpleName();
    public final AbstractFbErrorReporter f19560b;
    public final FeedEventBus f19561c;
    public final FeedStoryMutator f19562d;
    public final FeedbackLoader f19563e;
    public final GraphQLNotificationsContentProviderHelper f19564f;
    public final NotificationsUtils f19565g;
    private final ObjectMapper f19566h;
    public final TasksManager f19567i;
    public final StoryMutationHelper f19568j;

    /* compiled from: album_create_failed */
    public class C16932 extends BaseMutationCallback<FeedUnit> {
        final /* synthetic */ PermalinkController f19557a;

        public C16932(PermalinkController permalinkController) {
            this.f19557a = permalinkController;
        }

        public final void mo1462a(Object obj) {
            this.f19557a.f19561c.a(new FeedUnitMutatedEvent((FeedUnit) obj));
        }

        public final void mo1463a(Object obj, ServiceException serviceException) {
            this.f19557a.f19561c.a(new FeedUnitMutatedEvent((FeedUnit) obj));
        }
    }

    /* compiled from: album_create_failed */
    /* synthetic */ class C16943 {
        static final /* synthetic */ int[] f19558a = new int[StoryPermalinkParamsType.values().length];

        static {
            try {
                f19558a[StoryPermalinkParamsType.NOTIF_STORY_ID_KEY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19558a[StoryPermalinkParamsType.NOTIF_STORY_JSON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19558a[StoryPermalinkParamsType.PLATFORM_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19558a[StoryPermalinkParamsType.STORY_FBID_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static PermalinkController m22876b(InjectorLike injectorLike) {
        return new PermalinkController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike), FeedbackLoader.a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), NotificationsUtils.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), StoryMutationHelper.b(injectorLike));
    }

    public static PermalinkController m22875a(InjectorLike injectorLike) {
        return m22876b(injectorLike);
    }

    @Inject
    public PermalinkController(AbstractFbErrorReporter abstractFbErrorReporter, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, FeedbackLoader feedbackLoader, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NotificationsUtils notificationsUtils, ObjectMapper objectMapper, TasksManager tasksManager, StoryMutationHelper storyMutationHelper) {
        this.f19560b = abstractFbErrorReporter;
        this.f19561c = feedEventBus;
        this.f19562d = feedStoryMutator;
        this.f19563e = feedbackLoader;
        this.f19564f = graphQLNotificationsContentProviderHelper;
        this.f19565g = notificationsUtils;
        this.f19566h = objectMapper;
        this.f19567i = tasksManager;
        this.f19568j = storyMutationHelper;
    }

    public final void m22878a(PermalinkParams permalinkParams, final FutureCallback<GraphQLStory> futureCallback) {
        if (permalinkParams.f19615a.isJsonType()) {
            m22877b(permalinkParams, futureCallback);
            return;
        }
        FetchType fetchType;
        switch (C16943.f19558a[permalinkParams.f19615a.ordinal()]) {
            case 1:
            case 2:
                fetchType = FetchType.NOTIFICATION_FEEDBACK_DETAILS;
                break;
            case 3:
                fetchType = FetchType.PLATFORM_FEEDBACK_DETAILS;
                break;
            case 4:
                fetchType = FetchType.GRAPHQL_VIDEO_CREATION_STORY;
                break;
            default:
                fetchType = FetchType.GRAPHQL_FEEDBACK_DETAILS;
                break;
        }
        this.f19567i.a("fetch_story_" + permalinkParams.f19616b, this.f19563e.a(permalinkParams.f19616b, permalinkParams.f19619e, fetchType, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, permalinkParams.f19622h, permalinkParams.f19623i), new AbstractDisposableFutureCallback<GraphQLResult<GraphQLStory>>(this) {
            final /* synthetic */ PermalinkController f19556b;

            protected final void m22871a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    m22872a(new NullPointerException("Fetched story was non-existent"));
                    return;
                }
                futureCallback.onSuccess(this.f19556b.f19562d.a((GraphQLStory) graphQLResult.e));
            }

            protected final void m22872a(Throwable th) {
                this.f19556b.f19560b.a(PermalinkController.f19559a, th);
                futureCallback.onFailure(th);
            }
        });
    }

    private void m22877b(PermalinkParams permalinkParams, FutureCallback<GraphQLStory> futureCallback) {
        try {
            GraphQLStory graphQLStory = (GraphQLStory) this.f19566h.a(permalinkParams.m22902d(), GraphQLStory.class);
            PropertyHelper.a(graphQLStory, null);
            futureCallback.onSuccess(graphQLStory);
        } catch (Throwable e) {
            futureCallback.onFailure(e);
        }
    }
}
