package com.facebook.feed.viewstate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: name */
public class UnseenStoryManager {
    private static UnseenStoryManager f13052e;
    private static final Object f13053f = new Object();
    @VisibleForTesting
    public final Map<String, List<UnseenBackgroundDrawable>> f13054a = new HashMap();
    public final Set<String> f13055b = new HashSet();
    public final Handler f13056c = new Handler(Looper.getMainLooper());
    private boolean f13057d;

    private static UnseenStoryManager m19200a() {
        return new UnseenStoryManager();
    }

    public final void m19205a(boolean z) {
        this.f13057d = z;
    }

    public final void m19204a(FeedProps<GraphQLStory> feedProps, Drawable drawable) {
        if (this.f13057d && feedProps != null) {
            boolean z;
            Drawable drawable2;
            boolean z2 = drawable instanceof UnseenBackgroundDrawable;
            if (!(drawable instanceof LayerDrawable) || z2) {
                z = z2;
                drawable2 = drawable;
            } else {
                drawable = ((LayerDrawable) drawable).getDrawable(0);
                z = drawable instanceof UnseenBackgroundDrawable;
                drawable2 = drawable;
            }
            if (z) {
                UnseenBackgroundDrawable unseenBackgroundDrawable = (UnseenBackgroundDrawable) drawable2;
                String d = m19202d(feedProps);
                List list = (List) this.f13054a.get(d);
                if (list == null) {
                    list = new ArrayList();
                    this.f13054a.put(d, list);
                }
                list.add(unseenBackgroundDrawable);
            }
        }
    }

    public static UnseenStoryManager m19201a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnseenStoryManager a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13053f) {
                UnseenStoryManager unseenStoryManager;
                if (a3 != null) {
                    unseenStoryManager = (UnseenStoryManager) a3.mo818a(f13053f);
                } else {
                    unseenStoryManager = f13052e;
                }
                if (unseenStoryManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19200a();
                        if (a3 != null) {
                            a3.mo822a(f13053f, a2);
                        } else {
                            f13052e = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = unseenStoryManager;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }

    public final GraphQLStorySeenState m19203a(@Nullable FeedProps<? extends FeedUnit> feedProps) {
        FeedUnit feedUnit;
        if (feedProps == null) {
            feedUnit = null;
        } else {
            feedUnit = (FeedUnit) feedProps.f13444a;
        }
        if (!this.f13057d || !(feedUnit instanceof GraphQLStory)) {
            return GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (this.f13055b.contains(graphQLStory.mo2507g())) {
            return GraphQLStorySeenState.SEEN_AND_READ;
        }
        FeedProps b = StoryProps.m27455b(feedProps);
        return b != null ? m19203a(b) : graphQLStory.au();
    }

    public static String m19202d(@Nullable FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            return "";
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        ImmutableList d = feedProps.m19808d();
        int size = d.size();
        int i = 0;
        GraphQLStory graphQLStory2 = graphQLStory;
        while (i < size) {
            Flattenable flattenable = (Flattenable) d.get(i);
            if (!(flattenable instanceof GraphQLStory)) {
                break;
            }
            i++;
            graphQLStory2 = (GraphQLStory) flattenable;
        }
        return graphQLStory2.mo2507g();
    }
}
