package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.animation.ObjectAnimator;
import com.facebook.feedplugins.graphqlstory.footer.FeedDiscoveryBlingBarPartDefinition$4;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import java.util.List;

/* compiled from: Show debug overlay */
public interface FeedDiscoveryBlingBar {
    void mo1575a();

    void mo1576b();

    void mo1577e();

    void mo1578f();

    void mo1579g();

    void mo1580h();

    void setAnimationController(FeedDiscoveryBlingBarAnimationController feedDiscoveryBlingBarAnimationController);

    void setAnimationEventListener(FeedDiscoveryBlingBarPartDefinition$4 feedDiscoveryBlingBarPartDefinition$4);

    void setAnimatorTargetToBlingBar(ObjectAnimator objectAnimator);

    void setAnimatorTargetToRealTimeActivity(ObjectAnimator objectAnimator);

    void setFacepileStrings(List<String> list);

    void setText(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields);
}
