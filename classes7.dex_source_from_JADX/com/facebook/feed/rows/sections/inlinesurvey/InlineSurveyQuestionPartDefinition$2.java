package com.facebook.feed.rows.sections.inlinesurvey;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: Unable to create temporary file */
public class InlineSurveyQuestionPartDefinition$2 implements OnClickListener {
    final /* synthetic */ InlineSurveyQuestionPartDefinition$Props f21506a;
    final /* synthetic */ FeedEnvironment f21507b;
    final /* synthetic */ InlineSurveyQuestionPartDefinition f21508c;

    public InlineSurveyQuestionPartDefinition$2(InlineSurveyQuestionPartDefinition inlineSurveyQuestionPartDefinition, InlineSurveyQuestionPartDefinition$Props inlineSurveyQuestionPartDefinition$Props, FeedEnvironment feedEnvironment) {
        this.f21508c = inlineSurveyQuestionPartDefinition;
        this.f21506a = inlineSurveyQuestionPartDefinition$Props;
        this.f21507b = feedEnvironment;
    }

    public void onClick(View view) {
        int i;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 69716606);
        if (this.f21506a.f21512a) {
            if (this.f21506a.f21516e.f21504f == -1) {
                i = 1;
            } else {
                i = 0;
            }
            this.f21506a.f21516e.f21501c = true;
            this.f21506a.f21516e.f21504f = view.getId();
            if (this.f21506a.f21516e.f21499a) {
                this.f21506a.f21516e.f21500b = true;
            } else {
                this.f21506a.f21516e.m24154g();
            }
        } else {
            if (this.f21506a.f21516e.f21505g == -1) {
                i = 1;
            } else {
                i = 0;
            }
            this.f21506a.f21516e.f21505g = view.getId();
            this.f21506a.f21516e.m24154g();
        }
        if (i != 0) {
            this.f21507b.a(new FeedProps[]{this.f21506a.f21513b});
        }
        LogUtils.a(1843478698, a);
    }
}
