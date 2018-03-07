package com.facebook.timeline.contextual;

import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;

/* compiled from: group_mall_type */
public class TimelineIntroCardContextListItemPresenterProvider extends AbstractAssistedProvider<TimelineIntroCardContextListItemPresenter> {
    public final TimelineIntroCardContextListItemPresenter m10477a(TimelineContextListItemFieldsModel timelineContextListItemFieldsModel, Boolean bool) {
        return new TimelineIntroCardContextListItemPresenter(timelineContextListItemFieldsModel, bool, AllCapsTransformationMethod.b(this), ProfileControllerDelegate.m10751a((InjectorLike) this));
    }
}
