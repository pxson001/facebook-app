package com.facebook.messaging.model.messages;

import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.AdProperties;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.BotChoice;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.EventReminderProperties;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.JoinableEventType;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.NicknameChoice;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: uploaded_mediaset */
public class GenericAdminMessageInfoBuilder {
    public GraphQLExtensibleMessageAdminTextType f1973a;
    private int f1974b;
    @Nullable
    private String f1975c;
    @Nullable
    private String f1976d;
    @Nullable
    private String f1977e;
    private int f1978f;
    @Nullable
    private ImmutableList<String> f1979g;
    @Nullable
    private ImmutableList<String> f1980h;
    @Nullable
    private ImmutableList<NicknameChoice> f1981i;
    @Nullable
    private ImmutableList<BotChoice> f1982j;
    @Nullable
    private String f1983k;
    @Nullable
    private String f1984l;
    private boolean f1985m;
    @Nullable
    private String f1986n;
    @Nullable
    private AdProperties f1987o;
    @Nullable
    private String f1988p;
    private int f1989q;
    private boolean f1990r;
    @Nullable
    private EventReminderProperties f1991s;
    @Nullable
    private JoinableEventType f1992t;

    public final GenericAdminMessageInfoBuilder m3338a(int i) {
        this.f1973a = GenericAdminMessageInfo.f1952b.containsKey(Integer.valueOf(i)) ? (GraphQLExtensibleMessageAdminTextType) GenericAdminMessageInfo.f1952b.get(Integer.valueOf(i)) : GraphQLExtensibleMessageAdminTextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        return this;
    }

    GenericAdminMessageInfoBuilder() {
    }

    public final GenericAdminMessageInfoBuilder m3339a(GraphQLExtensibleMessageAdminTextType graphQLExtensibleMessageAdminTextType) {
        this.f1973a = graphQLExtensibleMessageAdminTextType;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3344a(Map<String, String> map) {
        for (String str : map.keySet()) {
            if (str.equals("theme_color")) {
                m3343a((String) map.get(str));
            } else if (str.equals("thread_icon")) {
                m3348b((String) map.get(str));
            } else if (str.equals("nickname")) {
                m3352c((String) map.get(str));
            } else if (str.equals("participant_id")) {
                m3355d((String) map.get(str));
            } else if (str.equals("ttl")) {
                m3350c(Integer.parseInt((String) map.get(str)));
            } else if (str.equals("color_choices")) {
                m3342a(m3333j((String) map.get(str)));
            } else if (str.equals("emoji_choices")) {
                m3347b(m3333j((String) map.get(str)));
            } else if (str.equals("nickname_choices")) {
                m3351c(m3334k((String) map.get(str)));
            } else if (str.equals("bot_choices")) {
                m3354d(m3335l((String) map.get(str)));
            } else if (str.equals("event")) {
                m3356e((String) map.get(str));
            } else if (str.equals("server_info_data")) {
                m3357f((String) map.get(str));
            } else if (str.equals("is_video_call")) {
                m3345a(Boolean.parseBoolean((String) map.get(str)));
            } else if (str.equals("ride_provider")) {
                m3358g(m3336m((String) map.get(str)));
            } else if (str.equals("game_type")) {
                m3359h((String) map.get(str));
            } else if (str.equals("score")) {
                try {
                    m3353d(Integer.parseInt((String) map.get(str)));
                } catch (NumberFormatException e) {
                }
            } else if (str.equals("new_high_score")) {
                m3349b("1".equals(map.get(str)));
            } else if (str.toLowerCase(Locale.US).equals("joinable_event")) {
                m3360i((String) map.get(str));
            }
        }
        m3341a(EventReminderProperties.m3306a((String) map.get("event_id"), (String) map.get("event_time"), (String) map.get("event_title"), (String) map.get("guest_id"), (String) map.get("guest_status"), (String) map.get("event_track_rsvp")));
        m3340a(AdProperties.m3305a((String) map.get("ad_preferences_url"), (String) map.get("ad_properties")));
        return this;
    }

    @Nullable
    private static ImmutableList<String> m3333j(String str) {
        try {
            return JSONUtil.a(new JSONArray(str));
        } catch (JSONException e) {
            return null;
        }
    }

    @Nullable
    private static ImmutableList<NicknameChoice> m3334k(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Builder builder = ImmutableList.builder();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                builder.c(new NicknameChoice(str2, JSONUtil.a(jSONObject.getJSONArray(str2))));
            }
            return builder.b();
        } catch (JSONException e) {
            return null;
        }
    }

    @Nullable
    private static ImmutableList<BotChoice> m3335l(String str) {
        try {
            Builder builder = ImmutableList.builder();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject((String) keys.next());
                builder.c(new BotChoice(jSONObject2.getLong("botID"), jSONObject2.getString("title"), jSONObject2.getString("description"), jSONObject2.getString("icon")));
            }
            return builder.b();
        } catch (JSONException e) {
            return null;
        }
    }

    @Nullable
    private static String m3336m(String str) {
        try {
            return new JSONObject(str).getString("name");
        } catch (JSONException e) {
            return null;
        }
    }

    public final GenericAdminMessageInfoBuilder m3346b(int i) {
        this.f1974b = i;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3343a(String str) {
        if (!StringUtil.c(str)) {
            this.f1974b = (int) Long.parseLong(str, 16);
        }
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3348b(String str) {
        this.f1975c = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3352c(String str) {
        this.f1976d = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3355d(String str) {
        this.f1977e = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3350c(int i) {
        this.f1978f = i;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3342a(@Nullable ImmutableList<String> immutableList) {
        this.f1979g = immutableList;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3347b(@Nullable ImmutableList<String> immutableList) {
        this.f1980h = immutableList;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3351c(@Nullable ImmutableList<NicknameChoice> immutableList) {
        this.f1981i = immutableList;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3354d(@Nullable ImmutableList<BotChoice> immutableList) {
        this.f1982j = immutableList;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3356e(@Nullable String str) {
        this.f1983k = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3357f(@Nullable String str) {
        this.f1984l = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3345a(boolean z) {
        this.f1985m = z;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3358g(@Nullable String str) {
        this.f1986n = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3340a(@Nullable AdProperties adProperties) {
        this.f1987o = adProperties;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3359h(@Nullable String str) {
        this.f1988p = str;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3353d(int i) {
        this.f1989q = i;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3349b(boolean z) {
        this.f1990r = z;
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3360i(@Nullable String str) {
        this.f1992t = JoinableEventType.fromValue(str);
        return this;
    }

    public final GenericAdminMessageInfoBuilder m3341a(@Nullable EventReminderProperties eventReminderProperties) {
        this.f1991s = eventReminderProperties;
        return this;
    }

    public final GenericAdminMessageInfo m3337a() {
        return new GenericAdminMessageInfo(this.f1973a, this.f1974b, this.f1975c, this.f1976d, this.f1977e, this.f1978f, this.f1979g, this.f1980h, this.f1981i, this.f1982j, this.f1983k, this.f1984l, this.f1985m, this.f1986n, this.f1987o, this.f1988p, this.f1989q, this.f1990r, this.f1991s, this.f1992t);
    }
}
