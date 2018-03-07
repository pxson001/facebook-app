package com.facebook.feed.rows.sections.inlinesurvey;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Unable to dispatch touch to JS as the catalyst instance has not been attached */
public class InlineSurveyFooterPartDefinition$1 implements OnClickListener {
    final /* synthetic */ InlineSurveyFooterPartDefinition$Props f21493a;
    final /* synthetic */ FeedEnvironment f21494b;
    final /* synthetic */ InlineSurveyFooterPartDefinition f21495c;

    /* compiled from: Unable to dispatch touch to JS as the catalyst instance has not been attached */
    class C18071 extends AbstractDisposableFutureCallback {
        final /* synthetic */ InlineSurveyFooterPartDefinition$1 f21492a;

        C18071(InlineSurveyFooterPartDefinition$1 inlineSurveyFooterPartDefinition$1) {
            this.f21492a = inlineSurveyFooterPartDefinition$1;
        }

        protected final void m24149a(Object obj) {
        }

        protected final void m24150a(Throwable th) {
            this.f21492a.f21495c.i.a(InlineSurveyFooterPartDefinition.a, "submission of inline feed survey response failed", th);
        }
    }

    public InlineSurveyFooterPartDefinition$1(InlineSurveyFooterPartDefinition inlineSurveyFooterPartDefinition, InlineSurveyFooterPartDefinition$Props inlineSurveyFooterPartDefinition$Props, FeedEnvironment feedEnvironment) {
        this.f21495c = inlineSurveyFooterPartDefinition;
        this.f21493a = inlineSurveyFooterPartDefinition$Props;
        this.f21494b = feedEnvironment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -757599566);
        this.f21493a.f21497b.f21503e = true;
        this.f21494b.a(new FeedProps[]{this.f21493a.f21496a});
        this.f21495c.g.a(((GraphQLStory) this.f21493a.f21496a.a).k(), this.f21493a.f21497b.f21504f + 1, this.f21493a.f21497b.f21505g + 1, (int) (this.f21495c.h.a() / 1000), new C18071(this));
        Logger.a(2, EntryType.UI_INPUT_END, -1278468597, a);
    }
}
