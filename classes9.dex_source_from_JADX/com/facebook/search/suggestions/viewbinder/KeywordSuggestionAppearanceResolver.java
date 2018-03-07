package com.facebook.search.suggestions.viewbinder;

import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: view_inline_reply_dialog */
public class KeywordSuggestionAppearanceResolver {
    private static final int f350a = KeywordType.values().length;
    public static final Map<KeywordType, Integer> f351b;
    public static final int f352c = 2130841641;
    private static final Map<KeywordType, Integer> f353d;
    private static final int f354e = 2130843282;
    public static final Map<KeywordType, Integer> f355f;
    public static final Map<KeywordType, Integer> f356g;
    public static final int f357h = 2131625916;
    public static final int f358i = 2130841642;
    public static final int f359j = 2131625916;
    public static final Set<KeywordType> f360k;

    static {
        Map hashMap = new HashMap(f350a);
        f351b = hashMap;
        hashMap.put(KeywordType.keyword, Integer.valueOf(2130841641));
        f351b.put(KeywordType.trending, Integer.valueOf(2130841681));
        f351b.put(KeywordType.celebrity, Integer.valueOf(2130841641));
        f351b.put(KeywordType.echo, Integer.valueOf(2130841641));
        f351b.put(KeywordType.escape, Integer.valueOf(2130841641));
        f351b.put(KeywordType.recent, Integer.valueOf(2130841680));
        f351b.put(KeywordType.am_football, Integer.valueOf(2130841641));
        f351b.put(KeywordType.photos, Integer.valueOf(2130841679));
        f351b.put(KeywordType.videos, Integer.valueOf(2130841683));
        f351b.put(KeywordType.hashtag, Integer.valueOf(2130841640));
        f351b.put(KeywordType.local, Integer.valueOf(2130841642));
        f351b.put(KeywordType.company, Integer.valueOf(2130841641));
        f351b.put(KeywordType.movie, Integer.valueOf(2130841641));
        f351b.put(KeywordType.happening_now, Integer.valueOf(2130841641));
        f351b.put(KeywordType.link, Integer.valueOf(2130841641));
        f351b.put(KeywordType.special_intent_gener, Integer.valueOf(2130841641));
        f351b.put(KeywordType.local_category, Integer.valueOf(2130841642));
        hashMap = new HashMap(f350a);
        f353d = hashMap;
        hashMap.put(KeywordType.keyword, Integer.valueOf(2130843282));
        f353d.put(KeywordType.trending, Integer.valueOf(2130843298));
        f353d.put(KeywordType.celebrity, Integer.valueOf(2130843282));
        f353d.put(KeywordType.echo, Integer.valueOf(2130843282));
        f353d.put(KeywordType.escape, Integer.valueOf(2130843282));
        f353d.put(KeywordType.recent, Integer.valueOf(2130843288));
        f353d.put(KeywordType.am_football, Integer.valueOf(2130843282));
        f353d.put(KeywordType.photos, Integer.valueOf(2130843286));
        f353d.put(KeywordType.videos, Integer.valueOf(2130843299));
        f353d.put(KeywordType.hashtag, Integer.valueOf(2130843280));
        f353d.put(KeywordType.local, Integer.valueOf(2130843284));
        f353d.put(KeywordType.company, Integer.valueOf(2130843282));
        f353d.put(KeywordType.movie, Integer.valueOf(2130843282));
        f353d.put(KeywordType.happening_now, Integer.valueOf(2130843282));
        f353d.put(KeywordType.link, Integer.valueOf(2130843282));
        f353d.put(KeywordType.special_intent_gener, Integer.valueOf(2130843282));
        f353d.put(KeywordType.local_category, Integer.valueOf(2130843284));
        hashMap = new HashMap(f350a);
        f355f = hashMap;
        hashMap.put(KeywordType.keyword, Integer.valueOf(-12953448));
        f355f.put(KeywordType.trending, Integer.valueOf(-13266433));
        f355f.put(KeywordType.celebrity, Integer.valueOf(-13266433));
        f355f.put(KeywordType.echo, Integer.valueOf(-13266433));
        f355f.put(KeywordType.escape, Integer.valueOf(-13266433));
        f355f.put(KeywordType.recent, Integer.valueOf(-12953448));
        f355f.put(KeywordType.am_football, Integer.valueOf(-13266433));
        f355f.put(KeywordType.photos, Integer.valueOf(-15417946));
        f355f.put(KeywordType.videos, Integer.valueOf(-15417946));
        f355f.put(KeywordType.hashtag, Integer.valueOf(-13266433));
        f355f.put(KeywordType.local, Integer.valueOf(-778386));
        f355f.put(KeywordType.company, Integer.valueOf(-13266433));
        f355f.put(KeywordType.movie, Integer.valueOf(-13266433));
        f355f.put(KeywordType.happening_now, Integer.valueOf(-13266433));
        f355f.put(KeywordType.link, Integer.valueOf(-5624441));
        f355f.put(KeywordType.special_intent_gener, Integer.valueOf(-13266433));
        f355f.put(KeywordType.local_category, Integer.valueOf(-778386));
        hashMap = new HashMap(f350a);
        f356g = hashMap;
        hashMap.put(KeywordType.keyword, Integer.valueOf(2131625916));
        f356g.put(KeywordType.trending, Integer.valueOf(2131625917));
        f356g.put(KeywordType.celebrity, Integer.valueOf(2131625917));
        f356g.put(KeywordType.echo, Integer.valueOf(2131625917));
        f356g.put(KeywordType.escape, Integer.valueOf(2131625917));
        f356g.put(KeywordType.recent, Integer.valueOf(2131625916));
        f356g.put(KeywordType.am_football, Integer.valueOf(2131625917));
        f356g.put(KeywordType.photos, Integer.valueOf(2131625919));
        f356g.put(KeywordType.videos, Integer.valueOf(2131625919));
        f356g.put(KeywordType.hashtag, Integer.valueOf(2131625917));
        f356g.put(KeywordType.local, Integer.valueOf(2131625920));
        f356g.put(KeywordType.company, Integer.valueOf(2131625917));
        f356g.put(KeywordType.movie, Integer.valueOf(2131625917));
        f356g.put(KeywordType.happening_now, Integer.valueOf(2131625917));
        f356g.put(KeywordType.link, Integer.valueOf(2131625921));
        f356g.put(KeywordType.special_intent_gener, Integer.valueOf(2131625917));
        f356g.put(KeywordType.local_category, Integer.valueOf(2131625920));
        Set hashSet = new HashSet(2);
        f360k = hashSet;
        hashSet.add(KeywordType.local);
        f360k.add(KeywordType.local_category);
    }
}
