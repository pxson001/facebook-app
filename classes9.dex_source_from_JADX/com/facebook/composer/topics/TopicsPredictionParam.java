package com.facebook.composer.topics;

import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.topics.protocol.TopicClassificationQueryModels.TopicClassificationQueryModel.PredictedFeedTopicsModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Tried to createItemFragment with ineligible message. */
public class TopicsPredictionParam {
    public final Map<String, TopicInfo> f23960a = new LinkedHashMap();

    /* compiled from: Tried to createItemFragment with ineligible message. */
    public class TopicInfo {
        public String f23957a;
        public Double f23958b;
        public String f23959c;

        public TopicInfo(String str) {
            this.f23957a = str;
        }

        public static TopicInfo m25902a(TopicInfo topicInfo, double d) {
            topicInfo.f23958b = Double.valueOf(d);
            return topicInfo;
        }
    }

    public TopicsPredictionParam(ImmutableList<GraphQLExploreFeed> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) immutableList.get(i);
            this.f23960a.put(graphQLExploreFeed.n(), TopicInfo.m25902a(new TopicInfo(graphQLExploreFeed.n()), 2.0d));
        }
    }

    public final void m25904a(List<PredictedFeedTopicsModel> list) {
        List<TopicInfo> arrayList = new ArrayList();
        for (TopicInfo topicInfo : this.f23960a.values()) {
            Object obj;
            if (topicInfo.f23958b == null || Double.compare(topicInfo.f23958b.doubleValue(), 0.0d) < 0 || Double.compare(topicInfo.f23958b.doubleValue(), 1.0d) > 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                arrayList.add(topicInfo);
            }
        }
        for (TopicInfo topicInfo2 : arrayList) {
            this.f23960a.remove(topicInfo2.f23957a);
        }
        for (PredictedFeedTopicsModel predictedFeedTopicsModel : list) {
            TopicInfo topicInfo3;
            String b = predictedFeedTopicsModel.k().b();
            if (this.f23960a.containsKey(b)) {
                topicInfo3 = (TopicInfo) this.f23960a.get(b);
            } else {
                topicInfo3 = new TopicInfo(b);
                this.f23960a.put(b, topicInfo3);
            }
            if (!m25903a(topicInfo3)) {
                TopicInfo.m25902a(topicInfo3, predictedFeedTopicsModel.a()).f23959c = predictedFeedTopicsModel.j();
            }
        }
    }

    public static boolean m25903a(TopicInfo topicInfo) {
        return topicInfo.f23958b != null && Double.compare(topicInfo.f23958b.doubleValue(), -1.0d) == 0;
    }
}
