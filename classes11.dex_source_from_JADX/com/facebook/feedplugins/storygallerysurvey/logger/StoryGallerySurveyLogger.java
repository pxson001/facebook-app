package com.facebook.feedplugins.storygallerysurvey.logger;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feedplugins.storygallerysurvey.constants.StoryGallerySurveyConstants.ActionType;
import com.facebook.feedplugins.storygallerysurvey.service.StoryGallerySurveyActionsParams;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: birthday_selfie_cam_optimized_output_not_found */
public class StoryGallerySurveyLogger {
    public static final String f9526a = StoryGallerySurveyLogger.class.getName();
    public final AnalyticsLogger f9527b;
    private final DefaultBlueServiceOperationFactory f9528c;
    public final AbstractFbErrorReporter f9529d;
    private final TasksManager f9530e;

    public static StoryGallerySurveyLogger m10068b(InjectorLike injectorLike) {
        return new StoryGallerySurveyLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public StoryGallerySurveyLogger(AnalyticsLogger analyticsLogger, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager) {
        this.f9527b = analyticsLogger;
        this.f9528c = defaultBlueServiceOperationFactory;
        this.f9529d = abstractFbErrorReporter;
        this.f9530e = tasksManager;
    }

    public final void m10070a(ActionType actionType, GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit) {
        String toEventName = actionType.toEventName();
        if (toEventName.isEmpty()) {
            this.f9529d.a(f9526a, "Invalid user action type " + actionType.toEventName());
            return;
        }
        this.f9527b.c(new HoneyClientEvent(toEventName).b("tracking", graphQLStoryGallerySurveyFeedUnit.v()));
    }

    public final void m10069a(final ActionType actionType) {
        Parcelable storyGallerySurveyActionsParams = new StoryGallerySurveyActionsParams(actionType.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("story_gallery_survey_actions_params_key", storyGallerySurveyActionsParams);
        this.f9530e.a(null, BlueServiceOperationFactoryDetour.a(this.f9528c, "story_gallery_survey_actions_type", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(StoryGallerySurveyLogger.class), -2061220838).a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ StoryGallerySurveyLogger f9525b;

            protected final void m10066a(ServiceException serviceException) {
                this.f9525b.f9529d.a(StoryGallerySurveyLogger.f9526a, "Story gallery survey post action " + actionType.toString() + " failed.");
            }
        });
    }
}
