package com.facebook.facecastdisplay;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.LiveVideoTopLevelCommentsSubscriptionString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoTopLevelCommentsSubscriptionModel;
import com.facebook.graphql.calls.LiveVideoCommentCreateSubscribeInputData;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: attr */
public class StreamingCommentsModel {
    public static final String f19008a = StreamingCommentsModel.class.getName();
    private final GraphQLSubscriptionConnector f19009b;
    private final DefaultAndroidThreadUtil f19010c;
    @Nullable
    private GraphQLSubscriptionHandle f19011d;
    @Nullable
    private String f19012e;
    private boolean f19013f;
    @Nullable
    private LiveEventsStore f19014g;

    /* compiled from: attr */
    class C16521 implements FutureCallback<LiveVideoTopLevelCommentsSubscriptionModel> {
        final /* synthetic */ StreamingCommentsModel f19007a;

        public void onFailure(Throwable th) {
            String str = StreamingCommentsModel.f19008a;
        }

        C16521(StreamingCommentsModel streamingCommentsModel) {
            this.f19007a = streamingCommentsModel;
        }

        public void onSuccess(@Nullable Object obj) {
            LiveVideoTopLevelCommentsSubscriptionModel liveVideoTopLevelCommentsSubscriptionModel = (LiveVideoTopLevelCommentsSubscriptionModel) obj;
            String str;
            if (liveVideoTopLevelCommentsSubscriptionModel == null) {
                str = StreamingCommentsModel.f19008a;
            } else if (liveVideoTopLevelCommentsSubscriptionModel.m3867a() != null) {
                StreamingCommentsModel.m22585a(this.f19007a, liveVideoTopLevelCommentsSubscriptionModel.m3867a());
            } else {
                str = StreamingCommentsModel.f19008a;
            }
        }
    }

    @Inject
    public StreamingCommentsModel(GraphQLSubscriptionConnector graphQLSubscriptionConnector, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f19009b = graphQLSubscriptionConnector;
        this.f19010c = defaultAndroidThreadUtil;
    }

    public final synchronized void m22590a(LiveEventsStore liveEventsStore) {
        this.f19010c.a();
        this.f19014g = liveEventsStore;
        if (this.f19012e != null) {
            m22587c();
        }
    }

    public final synchronized void m22591a(String str) {
        this.f19010c.a();
        this.f19012e = str;
        if (this.f19014g != null) {
            m22587c();
        }
    }

    private void m22587c() {
        if (!this.f19013f) {
            this.f19013f = true;
            m22586b(this.f19012e);
        }
    }

    public final synchronized void m22589a() {
        this.f19010c.a();
        if (this.f19013f) {
            if (this.f19011d != null) {
                this.f19009b.a(Collections.singleton(this.f19011d));
                this.f19011d = null;
            }
            this.f19013f = false;
        }
    }

    private void m22586b(String str) {
        FutureCallback d = m22588d();
        LiveVideoTopLevelCommentsSubscriptionString m = FetchLiveVideoEventsQuery.m3497m();
        m.a("input", new LiveVideoCommentCreateSubscribeInputData().a(str));
        try {
            this.f19011d = this.f19009b.a(m, d);
        } catch (GraphQLSubscriptionConnectorException e) {
        }
    }

    private FutureCallback<LiveVideoTopLevelCommentsSubscriptionModel> m22588d() {
        return new C16521(this);
    }

    public static synchronized void m22585a(StreamingCommentsModel streamingCommentsModel, FeedbackLiveVideoCommentCoreFragmentModel feedbackLiveVideoCommentCoreFragmentModel) {
        synchronized (streamingCommentsModel) {
            if (feedbackLiveVideoCommentCoreFragmentModel.m3531l() != null) {
                String a = feedbackLiveVideoCommentCoreFragmentModel.m3531l().a();
                if (!(streamingCommentsModel.f19014g == null || a == null)) {
                    List linkedList = new LinkedList();
                    linkedList.add(LiveCommentEventModel.m3147a(feedbackLiveVideoCommentCoreFragmentModel));
                    streamingCommentsModel.f19014g.m3267a(linkedList, false);
                }
            }
        }
    }
}
