package com.facebook.feed.rows.sections.inlinesurvey;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Unable to create temporary file */
public class InlineSurveyQuestionPartDefinition$3 implements OnClickListener {
    final /* synthetic */ InlineSurveyQuestionPartDefinition$Props f21509a;
    final /* synthetic */ FeedEnvironment f21510b;
    final /* synthetic */ InlineSurveyQuestionPartDefinition f21511c;

    public InlineSurveyQuestionPartDefinition$3(InlineSurveyQuestionPartDefinition inlineSurveyQuestionPartDefinition, InlineSurveyQuestionPartDefinition$Props inlineSurveyQuestionPartDefinition$Props, FeedEnvironment feedEnvironment) {
        this.f21511c = inlineSurveyQuestionPartDefinition;
        this.f21509a = inlineSurveyQuestionPartDefinition$Props;
        this.f21510b = feedEnvironment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -576099931);
        PropertyHelper.a((GraphQLStory) this.f21509a.f21513b.a).s = true;
        this.f21510b.a(new FeedProps[]{this.f21509a.f21513b});
        Logger.a(2, EntryType.UI_INPUT_END, 566441370, a);
    }
}
