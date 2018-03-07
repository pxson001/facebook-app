package com.facebook.topics.protocol;

import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: extra_meme_picker_session_id */
public class TopicModelHelper {
    public static ImmutableList<TopicFeedFragmentModel> m19028a(ImmutableList<TopicFeedFragmentModel> immutableList, int i) {
        Builder builder = new Builder();
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) immutableList.get(i2);
            if (i2 == i) {
                boolean z;
                TopicFeedFragmentModel.Builder builder2 = new TopicFeedFragmentModel.Builder();
                builder2.f15000a = topicFeedFragmentModel.m18945b();
                builder2.f15001b = topicFeedFragmentModel.m18946c();
                builder2.f15002c = topicFeedFragmentModel.m18952m();
                builder2.f15003d = topicFeedFragmentModel.m18953n();
                builder2.f15004e = topicFeedFragmentModel.m18954o();
                builder2.f15005f = topicFeedFragmentModel.fb_();
                builder2.f15006g = topicFeedFragmentModel.fc_();
                builder2.f15007h = topicFeedFragmentModel.m18949j();
                builder2.f15008i = topicFeedFragmentModel.m18950k();
                builder2.f15009j = topicFeedFragmentModel.m18951l();
                TopicFeedFragmentModel.Builder builder3 = builder2;
                if (topicFeedFragmentModel.fc_()) {
                    z = false;
                } else {
                    z = true;
                }
                builder3.f15006g = z;
                builder.c(builder3.m18920a());
            } else {
                builder.c(topicFeedFragmentModel);
            }
        }
        return builder.b();
    }

    public static ImmutableList<TopicFeedFragmentModel> m19029a(ImmutableList<TopicFeedFragmentModel> immutableList, int i, int i2) {
        int i3 = 0;
        if (i < 0 || i >= immutableList.size() || i2 < 0 || i2 >= immutableList.size()) {
            return null;
        }
        if (i == i2) {
            return immutableList;
        }
        Builder builder = new Builder();
        int i4 = 0;
        while (i3 < immutableList.size()) {
            if (i3 == i) {
                i4 = 1;
            } else if (i3 != i2) {
                builder.c(immutableList.get(i3));
            } else if (i4 != 0) {
                builder.c(immutableList.get(i3));
                builder.c(immutableList.get(i));
            } else {
                builder.c(immutableList.get(i));
                builder.c(immutableList.get(i3));
            }
            i3++;
        }
        return builder.b();
    }

    public static TopicFeedListModel m19027a(TopicFeedListModel topicFeedListModel, Collection<String> collection) {
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        ImmutableList a = topicFeedListModel.m18960a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) a.get(i);
            if (collection.contains(topicFeedFragmentModel.fb_())) {
                builder.c(topicFeedFragmentModel);
            } else {
                builder2.c(topicFeedFragmentModel);
            }
        }
        builder.b(builder2.b());
        TopicFeedListModel.Builder builder3 = new TopicFeedListModel.Builder();
        builder3.f15023a = builder.b();
        return builder3.m18955a();
    }

    public static TopicFeedListModel m19026a(TopicFeedListModel topicFeedListModel) {
        Set hashSet = new HashSet();
        ImmutableList a = topicFeedListModel.m18960a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) a.get(i);
            if (topicFeedFragmentModel.fc_()) {
                hashSet.add(topicFeedFragmentModel.fb_());
            }
        }
        return m19027a(topicFeedListModel, (Collection) hashSet);
    }
}
