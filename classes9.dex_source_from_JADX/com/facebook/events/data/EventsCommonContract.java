package com.facebook.events.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.events.model.Event;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: The bitmap dimensions must be positive */
public class EventsCommonContract {
    public final String f24300a;
    public final Uri f24301b;
    public final Uri f24302c;
    public final Uri f24303d;
    public final Uri f24304e;
    public final Uri f24305f;
    public final Uri f24306g;
    public final Uri f24307h;

    /* compiled from: The bitmap dimensions must be positive */
    public final class EventsCommonTable {
        public static final String f24299a = Columns.f24254H.d();

        /* compiled from: The bitmap dimensions must be positive */
        public class Columns {
            public static final SqlColumn f24247A = new SqlColumn("viewer_guest_status", "TEXT");
            public static final SqlColumn f24248B = new SqlColumn("viewer_watch_status", "TEXT");
            public static final SqlColumn f24249C = new SqlColumn("saved", "INTEGER");
            public static final SqlColumn f24250D = new SqlColumn("saved_collection_id", "TEXT");
            public static final SqlColumn f24251E = new SqlColumn("saved_privacy", "TEXT");
            public static final SqlColumn f24252F = new SqlColumn("has_pending_invite", "INTEGER");
            public static final SqlColumn f24253G = new SqlColumn("is_host", "INTEGER");
            public static final SqlColumn f24254H = new SqlColumn("start_time_millis", "INTEGER");
            public static final SqlColumn f24255I = new SqlColumn("end_time_millis", "INTEGER");
            public static final SqlColumn f24256J = new SqlColumn("time_zone", "TEXT");
            public static final SqlColumn f24257K = new SqlColumn("is_all_day", "INTEGER");
            public static final SqlColumn f24258L = new SqlColumn("location_full_address", "TEXT");
            public static final SqlColumn f24259M = new SqlColumn("location_latitude", "REAL");
            public static final SqlColumn f24260N = new SqlColumn("location_longitude", "REAL");
            public static final SqlColumn f24261O = new SqlColumn("location_id", "INTEGER");
            public static final SqlColumn f24262P = new SqlColumn("location_name", "TEXT");
            public static final SqlColumn f24263Q = new SqlColumn("location_time_zone", "TEXT");
            public static final SqlColumn f24264R = new SqlColumn("location_object_type", "TEXT");
            public static final SqlColumn f24265S = new SqlColumn("uri", "TEXT");
            public static final SqlColumn f24266T = new SqlColumn("cover_photo_id", "TEXT");
            public static final SqlColumn f24267U = new SqlColumn("cover_photo_portrait_uri", "TEXT");
            public static final SqlColumn f24268V = new SqlColumn("cover_photo_landscape_uri", "TEXT");
            public static final SqlColumn f24269W = new SqlColumn("profile_photo_uri", "TEXT");
            public static final SqlColumn f24270X = new SqlColumn("capabilities", "INTEGER");
            public static final SqlColumn f24271Y = new SqlColumn("cohost_name", "TEXT");
            public static final SqlColumn f24272Z = new SqlColumn("cohost_count", "INTEGER");
            public static final SqlColumn f24273a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
            public static final SqlColumn aa = new SqlColumn("cohost_ids", "TEXT");
            public static final SqlColumn ab = new SqlColumn("friend_going_name", "TEXT");
            public static final SqlColumn ac = new SqlColumn("friend_going_count", "INTEGER");
            public static final SqlColumn ad = new SqlColumn("friend_maybe_name", "TEXT");
            public static final SqlColumn ae = new SqlColumn("friend_maybe_count", "INTEGER");
            public static final SqlColumn af = new SqlColumn("friend_watcher_name", "TEXT");
            public static final SqlColumn ag = new SqlColumn("friend_watcher_count", "INTEGER");
            public static final SqlColumn ah = new SqlColumn("inviter_name", "TEXT");
            public static final SqlColumn ai = new SqlColumn("inviter_friendship_status", "TEXT");
            public static final SqlColumn aj = new SqlColumn("inviter_id", "TEXT");
            public static final SqlColumn f24274b = new SqlColumn("facebook_id", "TEXT");
            public static final SqlColumn f24275c = new SqlColumn("name", "TEXT");
            public static final SqlColumn f24276d = new SqlColumn("description_text", "TEXT");
            public static final SqlColumn f24277e = new SqlColumn("description_entities", "TEXT");
            public static final SqlColumn f24278f = new SqlColumn("event_kind", "TEXT");
            public static final SqlColumn f24279g = new SqlColumn("event_type", "TEXT");
            public static final SqlColumn f24280h = new SqlColumn("privacy_kind", "TEXT");
            public static final SqlColumn f24281i = new SqlColumn("privacy_type", "TEXT");
            public static final SqlColumn f24282j = new SqlColumn("connection_style", "TEXT");
            public static final SqlColumn f24283k = new SqlColumn("event_action_style", "TEXT");
            public static final SqlColumn f24284l = new SqlColumn("can_guests_invite_friends", "INTEGER");
            public static final SqlColumn f24285m = new SqlColumn("can_post_be_moderated", "INTEGER");
            public static final SqlColumn f24286n = new SqlColumn("admin_post_approval_required", "INTEGER");
            public static final SqlColumn f24287o = new SqlColumn("is_privacy_locked", "INTEGER");
            public static final SqlColumn f24288p = new SqlColumn("created_for_group_id", "TEXT");
            public static final SqlColumn f24289q = new SqlColumn("created_for_group_name", "TEXT");
            public static final SqlColumn f24290r = new SqlColumn("parent_group_id", "TEXT");
            public static final SqlColumn f24291s = new SqlColumn("parent_group_name", "TEXT");
            public static final SqlColumn f24292t = new SqlColumn("creator_id", "TEXT");
            public static final SqlColumn f24293u = new SqlColumn("page_actor_id", "TEXT");
            public static final SqlColumn f24294v = new SqlColumn("page_actor_profile_picture_uri", "TEXT");
            public static final SqlColumn f24295w = new SqlColumn("is_cancelled", "INTEGER");
            public static final SqlColumn f24296x = new SqlColumn("is_draft", "INTEGER");
            public static final SqlColumn f24297y = new SqlColumn("publish_time_millis", "INTEGER");
            public static final SqlColumn f24298z = new SqlColumn("can_change_rsvp_status", "INTEGER");
        }
    }

    public static EventsCommonContract m26200b(InjectorLike injectorLike) {
        return new EventsCommonContract((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public EventsCommonContract(Context context) {
        this.f24300a = context.getPackageName() + ".provider.EventsProvider";
        Uri parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe("content://%s/", this.f24300a));
        this.f24301b = parse.buildUpon().appendPath("events").build();
        this.f24302c = parse.buildUpon().appendPath("events").appendPath("facebook_id").build();
        this.f24303d = parse.buildUpon().appendPath("upcoming").build();
        this.f24304e = parse.buildUpon().appendPath("past").build();
        this.f24305f = parse.buildUpon().appendPath("invited").build();
        this.f24306g = parse.buildUpon().appendPath("hosting").build();
        this.f24307h = parse.buildUpon().appendPath("custom").build();
    }

    public static EventsCommonContract m26198a(InjectorLike injectorLike) {
        return m26200b(injectorLike);
    }

    public static Expression m26197a(String str) {
        return Columns.f24273a.a(str);
    }

    public static Expression m26199b(String str) {
        return Columns.f24274b.a(str);
    }

    public final Uri m26203c(String str) {
        return Uri.withAppendedPath(this.f24302c, str);
    }

    public final Uri m26202a(Event event) {
        return Uri.withAppendedPath(this.f24302c, event.a);
    }

    public final Uri m26201a(Cursor cursor) {
        return Uri.withAppendedPath(this.f24301b, String.valueOf(cursor.getInt(Columns.f24273a.a(cursor))));
    }
}
