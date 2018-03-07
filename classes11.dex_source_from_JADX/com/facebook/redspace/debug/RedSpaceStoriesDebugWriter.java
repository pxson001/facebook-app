package com.facebook.redspace.debug;

import android.content.Context;
import android.widget.ListAdapter;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.analytics.DebugInfoUtil;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStoreDebugHelper;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcherDebugHelper;
import com.facebook.ultralight.Inject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.ImmutableBiMap.Builder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@ContextScoped
/* compiled from: Place Question Context Row fetched invalid data */
public class RedSpaceStoriesDebugWriter {
    private static RedSpaceStoriesDebugWriter f11924d;
    private static final Object f11925e = new Object();
    private final ObjectWriter f11926a;
    @Inject
    public RedSpaceOptimisticBadgeStoreDebugHelper f11927b;
    @Inject
    public RedSpaceTabUnseenCountFetcherDebugHelper f11928c;

    private static RedSpaceStoriesDebugWriter m12368b(InjectorLike injectorLike) {
        RedSpaceStoriesDebugWriter redSpaceStoriesDebugWriter = new RedSpaceStoriesDebugWriter((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
        RedSpaceTabUnseenCountFetcherDebugHelper a = RedSpaceTabUnseenCountFetcherDebugHelper.a(injectorLike);
        redSpaceStoriesDebugWriter.f11927b = RedSpaceOptimisticBadgeStoreDebugHelper.a(injectorLike);
        redSpaceStoriesDebugWriter.f11928c = a;
        return redSpaceStoriesDebugWriter;
    }

    @Inject
    private RedSpaceStoriesDebugWriter(ObjectMapper objectMapper) {
        this.f11926a = objectMapper.g().a();
    }

    public final Map<String, String> m12369a(int i, int i2, ListAdapter listAdapter, RedSpaceOptimisticBadgeStore redSpaceOptimisticBadgeStore, RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher) {
        FeedUnit feedUnit;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        FeedUnit feedUnit2 = null;
        while (i >= 0 && i <= i2 && i < listAdapter.getCount()) {
            if (listAdapter.getItem(i) instanceof BoundedAdapter) {
                BoundedAdapter boundedAdapter = (BoundedAdapter) listAdapter.getItem(i);
                if (boundedAdapter.b().a() != 0 && (boundedAdapter.b().b() instanceof FeedUnit)) {
                    feedUnit = (FeedUnit) boundedAdapter.b().b();
                    if (!(feedUnit == null || feedUnit == feedUnit2)) {
                        if (feedUnit instanceof GraphQLStory) {
                            String a;
                            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                            if (StoryHierarchyHelper.b(graphQLStory) != null) {
                                a = StoryHierarchyHelper.b(graphQLStory).a();
                            } else if (graphQLStory.aH() != null) {
                                a = graphQLStory.aH().a();
                            } else {
                                a = null;
                            }
                            if (a != null) {
                                a = a.replaceAll("[\r\n]+", " ");
                            }
                            stringBuilder.append("\nStory message: ").append(a);
                            if (graphQLStory.S_() != null) {
                                stringBuilder2.append(m12367a(graphQLStory.S_())).append("\n");
                            }
                            stringBuilder.append("\nGraphQL response:\n");
                            try {
                                stringBuilder.append(this.f11926a.a(graphQLStory));
                            } catch (IOException e) {
                                stringBuilder.append("ID: ").append(graphQLStory.c()).append(", cache_id: ").append(graphQLStory.g());
                            }
                            stringBuilder.append("\n\n");
                        } else {
                            stringBuilder.append("\nGraphQL response:\n");
                            try {
                                stringBuilder.append(this.f11926a.a(feedUnit));
                            } catch (IOException e2) {
                                stringBuilder.append("Type: ").append(feedUnit.getType() != null ? feedUnit.getType() : feedUnit.getClass().getSimpleName()).append(", cache_id: ").append(feedUnit.g()).append(", fetch_time_ms: ").append(feedUnit.T_());
                            }
                            stringBuilder.append("\n\n");
                            if (feedUnit.S_() != null) {
                                stringBuilder2.append(m12367a(feedUnit.S_())).append("\n");
                            }
                        }
                        i++;
                        feedUnit2 = feedUnit;
                    }
                }
            }
            feedUnit = feedUnit2;
            i++;
            feedUnit2 = feedUnit;
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
        } else {
            stringBuilder2.append(StringFormatUtil.formatStrLocaleSafe("No zombies were found because debug info was not available"));
        }
        return new Builder().a("StoryDebugInfo", stringBuilder.toString()).a("StoryZombies", stringBuilder2.toString()).a("OptimisticBadgeStore", RedSpaceOptimisticBadgeStoreDebugHelper.a(redSpaceOptimisticBadgeStore)).a("BadgeFetcher", this.f11928c.a(redSpaceTabUnseenCountFetcher)).b();
    }

    public static RedSpaceStoriesDebugWriter m12366a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceStoriesDebugWriter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11925e) {
                RedSpaceStoriesDebugWriter redSpaceStoriesDebugWriter;
                if (a2 != null) {
                    redSpaceStoriesDebugWriter = (RedSpaceStoriesDebugWriter) a2.a(f11925e);
                } else {
                    redSpaceStoriesDebugWriter = f11924d;
                }
                if (redSpaceStoriesDebugWriter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12368b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11925e, b3);
                        } else {
                            f11924d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceStoriesDebugWriter;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static String m12367a(String str) {
        Object a = DebugInfoUtil.a(str, "serialized");
        if (a == null) {
            return StringFormatUtil.formatStrLocaleSafe("Failed to get value for key \"%s\": %s", "serialized", str);
        }
        try {
            return "https://our.intern.facebook.com/intern/feedtools/serialized_to_entstory.php?zombie_story=" + URLEncoder.encode(a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return StringFormatUtil.formatStrLocaleSafe("Failed to encode into UTF-8: %s", a);
        }
    }
}
