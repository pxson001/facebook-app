package com.facebook.reaction.feed;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.feed.nodes.ReactionFeedStoryNode;
import com.facebook.reaction.feed.nodes.ReactionPagesFeedStoryNode;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: bg-color */
public class ReactionItemCollection implements ListItemCollection<Object> {
    public final List<ReactionItem> f18945a = new ArrayList();

    /* compiled from: bg-color */
    public class C20801 implements Comparator<ReactionItem> {
        final /* synthetic */ ReactionItemCollection f18944a;

        public C20801(ReactionItemCollection reactionItemCollection) {
            this.f18944a = reactionItemCollection;
        }

        public int compare(Object obj, Object obj2) {
            return ((ReactionItem) obj2).mo1117k().l() - ((ReactionItem) obj).mo1117k().l();
        }
    }

    public static ReactionItemCollection m22966a(InjectorLike injectorLike) {
        return new ReactionItemCollection();
    }

    public void m22971a(ReactionItem reactionItem) {
        this.f18945a.add(reactionItem);
    }

    public void m22969a(int i, ReactionItem reactionItem) {
        this.f18945a.add(i, reactionItem);
    }

    public final Object m22968a(int i) {
        Object b = m22973b(i);
        if ((b instanceof ReactionPagesFeedStoryNode) && ((ReactionPagesFeedStoryNode) b).f19133a) {
            return b;
        }
        GraphQLStory f = b.mo1116f();
        if (f != null) {
            return f;
        }
        Object obj;
        if (b != null) {
            ReactionUnitFragment k = b.mo1117k();
            Object obj2 = (k.m() == GraphQLReactionUnitStyle.VERTICAL_COMPONENTS || k.m() == GraphQLReactionUnitStyle.VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND || k.m() == GraphQLReactionUnitStyle.FLUSH_TO_BOTTOM) ? 1 : null;
            if (obj2 != null) {
                obj = 1;
                if (obj == null) {
                    return b.mo1117k();
                }
                return b;
            }
        }
        obj = null;
        if (obj == null) {
            return b;
        }
        return b.mo1117k();
    }

    public final ReactionItem m22973b(int i) {
        return (ReactionItem) this.f18945a.get(i);
    }

    public void m22972a(ReactionUnitFragment reactionUnitFragment) {
        ReactionItem c = m22975c(reactionUnitFragment.d());
        if (c instanceof ReactionCardNode) {
            ((ReactionCardNode) c).f18838a = reactionUnitFragment;
        }
    }

    @Nullable
    protected final ReactionItem m22975c(String str) {
        for (ReactionItem reactionItem : this.f18945a) {
            ReactionUnitFragment k = reactionItem.mo1117k();
            if (k != null && k.d() != null && k.d().equals(str)) {
                return reactionItem;
            }
        }
        return null;
    }

    public final boolean m22974b() {
        return this.f18945a.isEmpty();
    }

    public void m22977c(int i) {
        this.f18945a.remove(i);
    }

    public void m22976c() {
        this.f18945a.clear();
    }

    public void m22970a(GraphQLStory graphQLStory) {
        if (!Strings.isNullOrEmpty(graphQLStory.g())) {
            for (ReactionItem reactionItem : this.f18945a) {
                GraphQLStory f = reactionItem.mo1116f();
                if ((reactionItem instanceof ReactionFeedStoryNode) && f != null) {
                    ReactionFeedStoryNode reactionFeedStoryNode = (ReactionFeedStoryNode) reactionItem;
                    if (f.g() != null && f.g().equals(graphQLStory.g())) {
                        if (!Strings.isNullOrEmpty(graphQLStory.g()) && graphQLStory.g().equals(reactionFeedStoryNode.f19131a.g())) {
                            reactionFeedStoryNode.f19131a = graphQLStory;
                        }
                    }
                }
            }
        }
    }

    public final int m22967a() {
        return this.f18945a.size();
    }

    public final int m22978d(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < m22967a(); i++) {
            if (str.equals(m22973b(i).mo1117k().d())) {
                return i;
            }
        }
        return -1;
    }
}
