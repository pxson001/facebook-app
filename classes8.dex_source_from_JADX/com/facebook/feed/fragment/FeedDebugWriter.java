package com.facebook.feed.fragment;

import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.analytics.DebugInfoUtil;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.widget.listview.BasicAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.ImmutableBiMap.Builder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: group_tag_suggestions_selected */
public class FeedDebugWriter {
    private final FeedUnitCache f11868a;
    private final ObjectMapper f11869b;

    @Inject
    public FeedDebugWriter(FeedUnitCache feedUnitCache, ObjectMapper objectMapper) {
        this.f11868a = feedUnitCache;
        this.f11869b = objectMapper;
    }

    public final Map<String, String> m13991a(int i, int i2, BasicAdapter basicAdapter, FeedType feedType) {
        ObjectWriter a = this.f11869b.g().a();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append(this.f11868a.toString()).append("\nFeed stories(").append(feedType).append("):\n");
        if (!(i == -1 || i2 == -1)) {
            int i3 = i > 0 ? i - 1 : 0;
            FeedUnit feedUnit = null;
            while (i3 < i2) {
                FeedUnit c;
                Object item = basicAdapter.getItem(i3);
                if (item instanceof BoundedAdapter) {
                    c = ((BoundedAdapter) item).c();
                    if (!(c == null || c == feedUnit)) {
                        if (c instanceof GraphQLStory) {
                            String a2;
                            GraphQLStory graphQLStory = (GraphQLStory) c;
                            if (StoryHierarchyHelper.b(graphQLStory) != null) {
                                a2 = StoryHierarchyHelper.b(graphQLStory).a();
                            } else if (graphQLStory.aH() != null) {
                                a2 = graphQLStory.aH().a();
                            } else {
                                a2 = null;
                            }
                            if (a2 != null) {
                                a2 = a2.replaceAll("[\r\n]+", " ");
                            }
                            stringBuilder.append("\nStory message: ").append(a2);
                            if (graphQLStory.S_() != null) {
                                stringBuilder2.append(m13990a(graphQLStory.S_())).append("\n");
                            }
                            stringBuilder.append("\nGraphQL response:\n");
                            try {
                                stringBuilder.append(a.a(graphQLStory));
                            } catch (IOException e) {
                                stringBuilder.append("ID: ").append(graphQLStory.c()).append(", cache_id: ").append(graphQLStory.g());
                            }
                            stringBuilder.append("\n\n");
                        } else {
                            stringBuilder.append("\nGraphQL response:\n");
                            try {
                                stringBuilder.append(a.a(c));
                            } catch (IOException e2) {
                                stringBuilder.append("Type: ").append(c.getType() != null ? c.getType() : c.getClass().getSimpleName()).append(", cache_id: ").append(c.g()).append(", fetch_time_ms: ").append(c.T_());
                            }
                            stringBuilder.append("\n\n");
                            if (c.S_() != null) {
                                stringBuilder2.append(m13990a(c.S_())).append("\n");
                            }
                        }
                        i3++;
                        feedUnit = c;
                    }
                }
                c = feedUnit;
                i3++;
                feedUnit = c;
            }
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
        } else {
            stringBuilder2.append(StringFormatUtil.formatStrLocaleSafe("No zombies were found because debug info was not available"));
        }
        return new Builder().a("StoryDebugInfo", stringBuilder.toString()).a("StoryZombies", stringBuilder2.toString()).b();
    }

    private static String m13990a(String str) {
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
