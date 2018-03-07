package com.facebook.video.channelfeed;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: syncPhoto */
public class VideoChannelItemCollection implements ListItemCollection<FeedProps<? extends FeedUnit>> {
    private static final OnCollectionChangeListener f2655c = new C02431();
    public final List<FeedProps<? extends FeedUnit>> f2656a = new ArrayList();
    private final GraphQLStoryUtil f2657b;
    public OnCollectionChangeListener f2658d = f2655c;

    /* compiled from: syncPhoto */
    public interface OnCollectionChangeListener {
        void mo76a(FeedUnit feedUnit);
    }

    /* compiled from: syncPhoto */
    final class C02431 implements OnCollectionChangeListener {
        C02431() {
        }

        public final void mo76a(FeedUnit feedUnit) {
        }
    }

    public static VideoChannelItemCollection m2554a(InjectorLike injectorLike) {
        return new VideoChannelItemCollection(GraphQLStoryUtil.a(injectorLike));
    }

    public final /* synthetic */ Object m2561a(int i) {
        return m2564b(i);
    }

    @Inject
    public VideoChannelItemCollection(GraphQLStoryUtil graphQLStoryUtil) {
        this.f2657b = graphQLStoryUtil;
    }

    public final int m2559a() {
        return this.f2656a.size();
    }

    public final FeedProps<? extends FeedUnit> m2564b(int i) {
        return (FeedProps) this.f2656a.get(i);
    }

    public final void m2566b(FeedProps<? extends FeedUnit> feedProps) {
        this.f2658d.mo76a((FeedUnit) feedProps.a);
        this.f2656a.add(feedProps);
    }

    public final void m2562a(int i, FeedProps<? extends FeedUnit> feedProps) {
        this.f2658d.mo76a((FeedUnit) feedProps.a);
        this.f2656a.add(i, feedProps);
    }

    public final boolean m2563a(GraphQLStory graphQLStory) {
        if (graphQLStory.g() == null) {
            return false;
        }
        boolean z;
        List i = StoryAttachmentHelper.i(graphQLStory);
        if (i == null || i.size() == 0) {
            z = false;
        } else {
            z = MultiShareNoLinkUtil.a(StoryAttachmentHelper.o(graphQLStory));
        }
        if (z) {
            return m2556b(graphQLStory);
        }
        for (int i2 = 0; i2 < this.f2656a.size(); i2++) {
            FeedProps feedProps = (FeedProps) this.f2656a.get(i2);
            FeedUnit feedUnit = (FeedUnit) feedProps.a;
            if (feedUnit instanceof GraphQLStory) {
                GraphQLStory graphQLStory2 = (GraphQLStory) feedUnit;
                if (!(graphQLStory2.g() == null || !graphQLStory2.g().equals(graphQLStory.g()) || graphQLStory2.T_() == graphQLStory.T_())) {
                    this.f2656a.set(i2, feedProps.b(graphQLStory));
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    private static FeedProps<GraphQLStory> m2557c(FeedProps<? extends FeedUnit> feedProps) {
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        if (feedUnit instanceof GraphQLStory) {
            return feedProps;
        }
        return feedUnit instanceof MultiShareChannelStoryUnit ? FeedProps.c(((MultiShareChannelStoryUnit) feedUnit).f2635a) : null;
    }

    @Nullable
    public final FeedProps<GraphQLStory> m2560a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < this.f2656a.size(); i++) {
            FeedProps<GraphQLStory> feedProps = (FeedProps) this.f2656a.get(i);
            FeedUnit feedUnit = (FeedUnit) feedProps.a;
            if (feedUnit instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                if (graphQLStory.g() != null && graphQLStory.g().equals(str)) {
                    return feedProps;
                }
            } else if (feedUnit instanceof MultiShareChannelStoryUnit) {
                GraphQLStory L = ((MultiShareChannelStoryUnit) feedUnit).f2635a.L();
                if (L.g() != null && L.g().equals(str)) {
                    return FeedProps.c(L);
                }
            } else {
                continue;
            }
        }
        return null;
    }

    @Nullable
    public final FeedProps<GraphQLStory> m2565b(String str) {
        int d = m2558d(str);
        if (d < 0) {
            return null;
        }
        while (d < this.f2656a.size() - 1) {
            int i = d + 1;
            FeedProps feedProps = (FeedProps) this.f2656a.get(i);
            if (m2555a((FeedUnit) feedProps.a)) {
                return m2557c(feedProps);
            }
            d = i;
        }
        return null;
    }

    @Nullable
    public final FeedProps<GraphQLStory> m2567c(String str) {
        int d = m2558d(str);
        if (d < 0) {
            return null;
        }
        while (d > 0) {
            int i = d - 1;
            FeedProps feedProps = (FeedProps) this.f2656a.get(i);
            if (m2555a((FeedUnit) feedProps.a)) {
                return m2557c(feedProps);
            }
            d = i;
        }
        return null;
    }

    private int m2558d(String str) {
        Preconditions.checkNotNull(str);
        for (int i = 0; i < this.f2656a.size(); i++) {
            GraphQLStory graphQLStory;
            FeedProps feedProps = (FeedProps) this.f2656a.get(i);
            FeedUnit feedUnit = (FeedUnit) feedProps.a;
            if (feedUnit instanceof GraphQLStory) {
                graphQLStory = (GraphQLStory) StoryProps.j(feedProps).a;
            } else if (feedUnit instanceof MultiShareChannelStoryUnit) {
                graphQLStory = ((MultiShareChannelStoryUnit) feedUnit).f2635a;
            } else {
                continue;
            }
            if (graphQLStory != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                if (!(o == null || o.r() == null || !str.equals(o.r().b()))) {
                    return i;
                }
            }
            continue;
        }
        return -1;
    }

    private boolean m2556b(GraphQLStory graphQLStory) {
        GraphQLStory L;
        for (int i = 0; i < this.f2656a.size(); i++) {
            FeedUnit feedUnit = (FeedUnit) ((FeedProps) this.f2656a.get(i)).a;
            if (feedUnit instanceof MultiShareChannelStoryUnit) {
                L = ((MultiShareChannelStoryUnit) feedUnit).f2635a.L();
                break;
            }
        }
        L = null;
        GraphQLStory graphQLStory2 = L;
        if (graphQLStory2 == null || graphQLStory2.g() == null || !graphQLStory2.g().equals(graphQLStory.g()) || graphQLStory2.T_() == graphQLStory.T_()) {
            return false;
        }
        int i2 = 0;
        for (FeedProps feedProps : MultiShareNoLinkUtil.c(graphQLStory)) {
            FeedUnit feedUnit2 = (FeedUnit) ((FeedProps) this.f2656a.get(i2)).a;
            Preconditions.checkArgument(feedUnit2 instanceof MultiShareChannelStoryUnit);
            this.f2656a.set(i2, FeedProps.c(new MultiShareChannelStoryUnit((GraphQLStory) feedProps.a, ((MultiShareChannelStoryUnit) feedUnit2).f2636b)));
            i2++;
        }
        return true;
    }

    private static boolean m2555a(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory) && !(feedUnit instanceof MultiShareChannelStoryUnit)) {
            return false;
        }
        if ((feedUnit instanceof HideableUnit) && ((HideableUnit) feedUnit).o() == StoryVisibility.HIDDEN) {
            return false;
        }
        return true;
    }
}
