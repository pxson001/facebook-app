package com.facebook.composer.topics;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.topics.ComposerTopicController.C28892;
import com.facebook.composer.topics.TopicPillView.OnImageClickListener;
import com.facebook.composer.topics.analytics.ComposerTopicLogger;
import com.facebook.graphql.calls.TopicProjectInputTopicProject;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.FlowLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Tried to track message without threadkey */
public class TopicBarController {
    public final TopicPillView f23931a;
    public final List<GraphQLExploreFeed> f23932b = new ArrayList();
    public final List<TopicPillView> f23933c = new ArrayList();
    public C28892 f23934d;

    /* compiled from: Tried to track message without threadkey */
    public class C29031 implements OnImageClickListener {
        final /* synthetic */ FlowLayout f23926a;
        final /* synthetic */ TopicPillView f23927b;
        final /* synthetic */ GraphQLExploreFeed f23928c;
        final /* synthetic */ TopicBarController f23929d;

        public C29031(TopicBarController topicBarController, FlowLayout flowLayout, TopicPillView topicPillView, GraphQLExploreFeed graphQLExploreFeed) {
            this.f23929d = topicBarController;
            this.f23926a = flowLayout;
            this.f23927b = topicPillView;
            this.f23928c = graphQLExploreFeed;
        }

        public final void mo1102a() {
            this.f23926a.removeView(this.f23927b);
            if (this.f23929d.f23934d != null) {
                C28892 c28892 = this.f23929d.f23934d;
                GraphQLExploreFeed graphQLExploreFeed = this.f23928c;
                ComposerTopicLogger composerTopicLogger = c28892.f23844b.f23863m;
                ImmutableList af = ((ProvidesTopics) c28892.f23844b.f23856f).af();
                int i = 0;
                while (i < af.size()) {
                    if (((GraphQLExploreFeed) af.get(i)).n().equals(graphQLExploreFeed.n())) {
                        break;
                    }
                    i++;
                }
                i = -1;
                composerTopicLogger.m25907a(graphQLExploreFeed, i, false, false);
                TransactionImpl a = c28892.f23844b.f23853c.a(ComposerTopicController.f23852b);
                ImmutableList W = ((ComposerDataProviderImpl) c28892.f23844b.f23856f).W();
                ImmutableList af2 = ((ProvidesTopics) c28892.f23844b.f23856f).af();
                Builder builder = new Builder();
                int size = af2.size();
                for (i = 0; i < size; i++) {
                    GraphQLExploreFeed graphQLExploreFeed2 = (GraphQLExploreFeed) af2.get(i);
                    if (!graphQLExploreFeed2.n().equals(graphQLExploreFeed.n())) {
                        builder.c(graphQLExploreFeed2);
                    }
                }
                ((TransactionImpl) a.a(W, builder.b())).a();
            }
        }
    }

    /* compiled from: Tried to track message without threadkey */
    public class C29042 implements OnClickListener {
        final /* synthetic */ TopicBarController f23930a;

        public C29042(TopicBarController topicBarController) {
            this.f23930a = topicBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 716787581);
            if (this.f23930a.f23934d != null) {
                C28892 c28892 = this.f23930a.f23934d;
                Serializable serializable = ComposerTopicController.m25856c(c28892.f23844b) ? TopicProjectInputTopicProject.VIDEO_HOME : TopicProjectInputTopicProject.TOPIC_FEEDS;
                FbUriIntentHandler fbUriIntentHandler = (FbUriIntentHandler) c28892.f23844b.f23857g.get();
                Context context = c28892.f23843a.getContext();
                String str = FBLinks.gf;
                ImmutableList af = ((ProvidesTopics) c28892.f23844b.f23856f).af();
                String ab = ((ProvidesSessionId) c28892.f23844b.f23856f).ab();
                Bundle bundle = new Bundle();
                bundle.putBoolean("title_bar_search_button_visible", false);
                bundle.putSerializable("topics", af);
                bundle.putSerializable("topic_project", serializable);
                bundle.putString("composer_session_id", ab);
                fbUriIntentHandler.a(context, str, bundle, null, c28892.f23844b.f23862l, c28892.f23844b.f23861k);
                if (!ComposerTopicController.m25856c(c28892.f23844b)) {
                    c28892.f23844b.f23863m.m25908a(((ProvidesTopics) c28892.f23844b.f23856f).af());
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1529953981, a);
        }
    }

    /* compiled from: Tried to track message without threadkey */
    public enum TopicPillLayoutType {
        SINGLE_PILL_LAYOUT,
        MULTI_PILL_LAYOUT
    }

    public TopicBarController(TopicPillView topicPillView) {
        this.f23931a = topicPillView;
        this.f23931a.setImage(2130837664);
        this.f23931a.setOnClickListener(new C29042(this));
    }

    public final void m25892a() {
        for (FbTextView visibility : this.f23933c) {
            visibility.setVisibility(8);
        }
        this.f23933c.clear();
    }
}
