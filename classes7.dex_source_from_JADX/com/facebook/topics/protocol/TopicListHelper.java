package com.facebook.topics.protocol;

import com.facebook.graphql.model.GraphQLExploreFeed;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* compiled from: extra_meme_urls */
public class TopicListHelper {

    /* compiled from: extra_meme_urls */
    final class C11121 implements Comparator<GraphQLExploreFeed> {
        C11121() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((GraphQLExploreFeed) obj).n().compareTo(((GraphQLExploreFeed) obj2).n());
        }
    }

    public static TreeSet<GraphQLExploreFeed> m19024a(Collection<GraphQLExploreFeed> collection) {
        TreeSet<GraphQLExploreFeed> treeSet = new TreeSet(new C11121());
        for (GraphQLExploreFeed add : collection) {
            treeSet.add(add);
        }
        return treeSet;
    }

    public static boolean m19025a(@Nullable ImmutableList<GraphQLExploreFeed> immutableList, @Nullable ImmutableList<GraphQLExploreFeed> immutableList2) {
        if (immutableList == immutableList2) {
            return true;
        }
        if (immutableList == null || immutableList2 == null || immutableList.size() != immutableList2.size()) {
            return false;
        }
        for (int i = 0; i < immutableList.size(); i++) {
            if (!((GraphQLExploreFeed) immutableList.get(i)).n().equals(((GraphQLExploreFeed) immutableList2.get(i)).n())) {
                return false;
            }
        }
        return true;
    }
}
