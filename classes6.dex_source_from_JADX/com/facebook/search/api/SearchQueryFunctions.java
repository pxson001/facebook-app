package com.facebook.search.api;

import android.os.Parcelable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: extra_profile_pic_caption */
public class SearchQueryFunctions {
    private static final Map<GraphQLGraphSearchResultsDisplayStyle, String> f15483a;

    /* compiled from: extra_profile_pic_caption */
    /* synthetic */ class C11011 {
        static final /* synthetic */ int[] f15482a = new int[ScopedEntityType.values().length];

        static {
            try {
                f15482a[ScopedEntityType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15482a[ScopedEntityType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15482a[ScopedEntityType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15482a[ScopedEntityType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15482a[ScopedEntityType.MARKETPLACE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        f15483a = hashMap;
        hashMap.put(GraphQLGraphSearchResultsDisplayStyle.BLENDED, "keywords_top(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.APPS, "keywords_apps(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.EVENTS, "keywords_events(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.GROUPS, "keywords_groups(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.PAGES, "keywords_pages(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.USERS, "keywords_users(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.PHOTOS, "keywords_photos(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.PLACES, "keywords_places(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.STORIES, "keywords_posts(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.BLENDED_ENTITIES, "keywords_entities(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, "keywords_blended_videos(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS, "keywords_blended_videos(%s)");
        f15483a.put(GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS, "video-publishers(%s)");
    }

    public static boolean m23115a(@Nullable String str) {
        return str != null && str.startsWith("keywords_topic_trending");
    }

    public static boolean m23117b(@Nullable String str) {
        return str != null && str.startsWith("keywords_topic_sport_match");
    }

    public static String m23128s(String str) {
        Object obj;
        if (str == null || !str.startsWith("keywords_photos")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return str;
        }
        Object[] objArr = new Object[]{"keywords_photos"};
        return StringFormatUtil.a("keywords_media(%s)", new Object[]{str.replaceFirst(StringFormatUtil.a("^%s\\(([^\\)]*)\\)$", objArr), "$1")});
    }

    public static boolean m23118c(@Nullable String str) {
        return str != null && str.startsWith("keywords_commerce");
    }

    public static boolean m23119d(@Nullable String str) {
        return str != null && str.startsWith("keywords_search");
    }

    public static boolean m23120e(@Nullable String str) {
        return str != null && str.startsWith("keywords_all_types");
    }

    public static String m23121j(String str) {
        return StringFormatUtil.a("stories-topic(%s)", new Object[]{str});
    }

    public static String m23122l(String str) {
        return StringFormatUtil.a("stories-live(stories-keyword(%s))", new Object[]{str});
    }

    public static String m23123m(String str) {
        return StringFormatUtil.a("keywords_global_share(%s)", new Object[]{str});
    }

    public static String m23124n(String str) {
        return StringFormatUtil.a("keywords_pulse_topic(%s)", new Object[]{str});
    }

    public static String m23125o(String str) {
        return StringFormatUtil.a("keywords_search(%s)", new Object[]{str});
    }

    public static String m23126p(String str) {
        return StringFormatUtil.a("keywords_commerce(%s)", new Object[]{str});
    }

    public static String m23112a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, String str) {
        if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.BLENDED) {
            return m23125o(str);
        }
        return m23116b(graphQLGraphSearchResultsDisplayStyle, str);
    }

    private static String m23116b(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, String str) {
        String str2 = (String) f15483a.get(graphQLGraphSearchResultsDisplayStyle);
        if (str2 == null) {
            throw new IllegalArgumentException("Unsupported displayStyle: " + graphQLGraphSearchResultsDisplayStyle);
        }
        return StringFormatUtil.a(str2, new Object[]{str});
    }

    public static String m23113a(ScopedEntityType scopedEntityType, String str, String str2, ImmutableMap<String, Parcelable> immutableMap) {
        String str3;
        switch (C11011.f15482a[scopedEntityType.ordinal()]) {
            case 1:
                GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier = (GraphSearchQueryCommerceModifier) immutableMap.get(ModifierKeys.GROUP_COMMERCE.name());
                if (graphSearchQueryCommerceModifier != null && graphSearchQueryCommerceModifier.f15475c) {
                    str3 = "stories-forsale(keywords_posts(%s), %s)";
                    break;
                }
                str3 = "stories-group(keywords_posts(%s), %s)";
                break;
            case 2:
                str3 = "stories-profile(keywords_posts(%s), %s)";
                break;
            case 3:
                str3 = "stories-page(keywords_posts(%s), %s)";
                break;
            case 4:
                str3 = "keywords_blended_videos(%s)";
                break;
            case 5:
                str3 = "";
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return StringFormatUtil.a(str3, new Object[]{str, str2});
    }

    public static String m23127r(String str) {
        return StringFormatUtil.a("local_search(%s)", new Object[]{str});
    }

    public static String m23114a(String str, String str2) {
        String replaceFirst;
        if (m23115a(str)) {
            replaceFirst = str.replaceFirst("keywords_topic_trending\\(([^\\)]*)\\)", "$1");
        } else if (m23117b(str)) {
            replaceFirst = str.replaceFirst("keywords_topic_sport_match\\(([^\\)]*)\\)", "$1");
        } else {
            replaceFirst = "";
        }
        if (StringUtil.a(replaceFirst)) {
            return m23122l(str2);
        }
        return StringFormatUtil.a("stories-live(stories-topic(%s))", new Object[]{r0});
    }
}
