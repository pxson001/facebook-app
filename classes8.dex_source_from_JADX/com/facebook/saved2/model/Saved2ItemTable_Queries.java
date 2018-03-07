package com.facebook.saved2.model;

import android.database.Cursor;
import com.facebook.crudolib.dao.AbstractDAOItem;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dbquery.QueryProvider;

/* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
public final class Saved2ItemTable_Queries {

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    public interface BaseQueryDAO extends com.facebook.crudolib.sqliteproc.BaseModel_Queries.BaseQueryDAO {
        String mo518A();

        int mo519B();

        String mo520C();

        String mo521D();

        boolean mo522E();

        boolean mo523F();

        boolean mo524G();

        int mo525H();

        double mo526I();

        double mo527J();

        String mo528K();

        String mo529L();

        int mo530M();

        int mo531N();

        int mo532O();

        String mo533P();

        long mo534Q();

        long mo535e();

        String mo536f();

        String mo537g();

        boolean mo538h();

        String mo539i();

        String mo540j();

        String mo541k();

        String mo542l();

        String mo543m();

        boolean mo544n();

        String mo545o();

        boolean mo546p();

        String mo547q();

        boolean mo548r();

        String mo549s();

        boolean mo550t();

        String mo551u();

        boolean mo552v();

        String mo553w();

        boolean mo554x();

        int mo555y();

        boolean mo556z();
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    class BaseQueryDAOImpl extends AbstractDAOItem implements BaseQueryDAO {
        public BaseQueryDAOImpl(Cursor cursor) {
            super(cursor);
        }

        public final long m8123d() {
            return this.a.getLong(0);
        }

        public final long mo535e() {
            return this.a.getLong(1);
        }

        public final String mo536f() {
            return this.a.getString(2);
        }

        public final String mo537g() {
            return this.a.getString(3);
        }

        public final boolean mo538h() {
            return !this.a.isNull(4);
        }

        public final String mo539i() {
            return this.a.getString(4);
        }

        public final String mo540j() {
            return this.a.getString(5);
        }

        public final String mo541k() {
            return this.a.getString(6);
        }

        public final String mo542l() {
            return this.a.getString(7);
        }

        public final String mo543m() {
            return this.a.getString(9);
        }

        public final boolean mo544n() {
            return !this.a.isNull(10);
        }

        public final String mo545o() {
            return this.a.getString(10);
        }

        public final boolean mo546p() {
            return !this.a.isNull(11);
        }

        public final String mo547q() {
            return this.a.getString(11);
        }

        public final boolean mo548r() {
            return !this.a.isNull(12);
        }

        public final String mo549s() {
            return this.a.getString(12);
        }

        public final boolean mo550t() {
            return this.a.getInt(14) != 0;
        }

        public final String mo551u() {
            return this.a.getString(15);
        }

        public final boolean mo552v() {
            return !this.a.isNull(16);
        }

        public final String mo553w() {
            return this.a.getString(16);
        }

        public final boolean mo554x() {
            return !this.a.isNull(17);
        }

        public final int mo555y() {
            return this.a.getInt(17);
        }

        public final boolean mo556z() {
            return !this.a.isNull(18);
        }

        public final String mo518A() {
            return this.a.getString(18);
        }

        public final int mo519B() {
            return this.a.getInt(19);
        }

        public final String mo520C() {
            return this.a.getString(20);
        }

        public final String mo521D() {
            return this.a.getString(21);
        }

        public final boolean mo522E() {
            return !this.a.isNull(22);
        }

        public final boolean mo523F() {
            return this.a.getInt(22) != 0;
        }

        public final boolean mo524G() {
            return this.a.getInt(23) != 0;
        }

        public final int mo525H() {
            return this.a.getInt(24);
        }

        public final double mo526I() {
            return this.a.getDouble(25);
        }

        public final double mo527J() {
            return this.a.getDouble(26);
        }

        public final String mo528K() {
            return this.a.getString(27);
        }

        public final String mo529L() {
            return this.a.getString(28);
        }

        public final int mo530M() {
            return this.a.getInt(29);
        }

        public final int mo531N() {
            return this.a.getInt(30);
        }

        public final int mo532O() {
            return this.a.getInt(31);
        }

        public final String mo533P() {
            return this.a.getString(32);
        }

        public final long mo534Q() {
            return this.a.getLong(35);
        }
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    public final class BaseQueryProvider implements QueryProvider<BaseQueryDAO> {
        private final int f7838a;
        private final int f7839b;

        public final /* synthetic */ DAOItem m8147a(Cursor cursor) {
            return m8146b(cursor);
        }

        public BaseQueryProvider(int i, int i2) {
            this.f7838a = i;
            this.f7839b = i2;
        }

        public final Object[] m8148a() {
            return new Object[]{Saved2ItemTable.class};
        }

        public final Object[] m8149b() {
            r0 = new Object[5];
            r0[1] = new String[]{"_id", "time_saved_ms", "graphql_cursor", "group_title", "picture_uri", "title", "subtitle", "type", "type_display_extras", "saved_state", "url", "permalink_id", "source_story_id", "fb_link_url", "is_playable", "playable_url", "target_id", "target_graphql_object_type", "global_share_id", "global_share_graphql_object_type", "instant_article_id", "instant_article_canonical_url", "can_viewer_share_event", "is_spherical", "spherical_preferred_fov", "spherical_fullscreen_aspect_ratio", "spherical_inline_aspect_ratio", "spherical_playable_url_sd_string", "spherical_playable_url_hd_string", "initial_view_heading_degrees", "initial_view_pitch_degrees", "initial_view_roll_degrees", "section_name_server", "is_deleted_client", "is_unarchived_client", "media_content_size", "is_download_client"};
            r0[2] = "is_deleted_client = ? AND is_unarchived_client = ?";
            r0[3] = new String[]{String.valueOf(this.f7838a), String.valueOf(this.f7839b)};
            r0[4] = null;
            return r0;
        }

        public static BaseQueryDAO m8146b(Cursor cursor) {
            return new BaseQueryDAOImpl(cursor);
        }
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    public interface QueryBySectionDAO extends BaseQueryDAO {
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    class QueryBySectionDAOImpl extends AbstractDAOItem implements QueryBySectionDAO {
        public QueryBySectionDAOImpl(Cursor cursor) {
            super(cursor);
        }

        public final long m8167d() {
            return this.a.getLong(0);
        }

        public final long mo535e() {
            return this.a.getLong(1);
        }

        public final String mo536f() {
            return this.a.getString(2);
        }

        public final String mo537g() {
            return this.a.getString(3);
        }

        public final boolean mo538h() {
            return !this.a.isNull(4);
        }

        public final String mo539i() {
            return this.a.getString(4);
        }

        public final String mo540j() {
            return this.a.getString(5);
        }

        public final String mo541k() {
            return this.a.getString(6);
        }

        public final String mo542l() {
            return this.a.getString(7);
        }

        public final String mo543m() {
            return this.a.getString(9);
        }

        public final boolean mo544n() {
            return !this.a.isNull(10);
        }

        public final String mo545o() {
            return this.a.getString(10);
        }

        public final boolean mo546p() {
            return !this.a.isNull(11);
        }

        public final String mo547q() {
            return this.a.getString(11);
        }

        public final boolean mo548r() {
            return !this.a.isNull(12);
        }

        public final String mo549s() {
            return this.a.getString(12);
        }

        public final boolean mo550t() {
            return this.a.getInt(14) != 0;
        }

        public final String mo551u() {
            return this.a.getString(15);
        }

        public final boolean mo552v() {
            return !this.a.isNull(16);
        }

        public final String mo553w() {
            return this.a.getString(16);
        }

        public final boolean mo554x() {
            return !this.a.isNull(17);
        }

        public final int mo555y() {
            return this.a.getInt(17);
        }

        public final boolean mo556z() {
            return !this.a.isNull(18);
        }

        public final String mo518A() {
            return this.a.getString(18);
        }

        public final int mo519B() {
            return this.a.getInt(19);
        }

        public final String mo520C() {
            return this.a.getString(20);
        }

        public final String mo521D() {
            return this.a.getString(21);
        }

        public final boolean mo522E() {
            return !this.a.isNull(22);
        }

        public final boolean mo523F() {
            return this.a.getInt(22) != 0;
        }

        public final boolean mo524G() {
            return this.a.getInt(23) != 0;
        }

        public final int mo525H() {
            return this.a.getInt(24);
        }

        public final double mo526I() {
            return this.a.getDouble(25);
        }

        public final double mo527J() {
            return this.a.getDouble(26);
        }

        public final String mo528K() {
            return this.a.getString(27);
        }

        public final String mo529L() {
            return this.a.getString(28);
        }

        public final int mo530M() {
            return this.a.getInt(29);
        }

        public final int mo531N() {
            return this.a.getInt(30);
        }

        public final int mo532O() {
            return this.a.getInt(31);
        }

        public final String mo533P() {
            return this.a.getString(32);
        }

        public final long mo534Q() {
            return this.a.getLong(35);
        }
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    public final class QueryBySectionProvider implements QueryProvider<QueryBySectionDAO> {
        private final int f7840a;
        private final int f7841b;
        private final String f7842c;

        public QueryBySectionProvider(int i, int i2, String str) {
            this.f7840a = i;
            this.f7841b = i2;
            this.f7842c = str;
        }

        public final Object[] m8191a() {
            return new Object[]{Saved2ItemTable.class};
        }

        public final Object[] m8192b() {
            r0 = new Object[5];
            r0[1] = new String[]{"_id", "time_saved_ms", "graphql_cursor", "group_title", "picture_uri", "title", "subtitle", "type", "type_display_extras", "saved_state", "url", "permalink_id", "source_story_id", "fb_link_url", "is_playable", "playable_url", "target_id", "target_graphql_object_type", "global_share_id", "global_share_graphql_object_type", "instant_article_id", "instant_article_canonical_url", "can_viewer_share_event", "is_spherical", "spherical_preferred_fov", "spherical_fullscreen_aspect_ratio", "spherical_inline_aspect_ratio", "spherical_playable_url_sd_string", "spherical_playable_url_hd_string", "initial_view_heading_degrees", "initial_view_pitch_degrees", "initial_view_roll_degrees", "section_name_server", "is_deleted_client", "is_unarchived_client", "media_content_size", "is_download_client"};
            r0[2] = "is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ?";
            r0[3] = new String[]{String.valueOf(this.f7840a), String.valueOf(this.f7841b), String.valueOf(this.f7842c)};
            r0[4] = null;
            return r0;
        }

        public final DAOItem m8190a(Cursor cursor) {
            return new QueryBySectionDAOImpl(cursor);
        }
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    public class TimeSortedQueryBySectionDAOImpl extends AbstractDAOItem implements QueryBySectionDAO {
        public TimeSortedQueryBySectionDAOImpl(Cursor cursor) {
            super(cursor);
        }

        public final long m8210d() {
            return this.a.getLong(0);
        }

        public final long mo535e() {
            return this.a.getLong(1);
        }

        public final String mo536f() {
            return this.a.getString(2);
        }

        public final String mo537g() {
            return this.a.getString(3);
        }

        public final boolean mo538h() {
            return !this.a.isNull(4);
        }

        public final String mo539i() {
            return this.a.getString(4);
        }

        public final String mo540j() {
            return this.a.getString(5);
        }

        public final String mo541k() {
            return this.a.getString(6);
        }

        public final String mo542l() {
            return this.a.getString(7);
        }

        public final String mo543m() {
            return this.a.getString(9);
        }

        public final boolean mo544n() {
            return !this.a.isNull(10);
        }

        public final String mo545o() {
            return this.a.getString(10);
        }

        public final boolean mo546p() {
            return !this.a.isNull(11);
        }

        public final String mo547q() {
            return this.a.getString(11);
        }

        public final boolean mo548r() {
            return !this.a.isNull(12);
        }

        public final String mo549s() {
            return this.a.getString(12);
        }

        public final boolean mo550t() {
            return this.a.getInt(14) != 0;
        }

        public final String mo551u() {
            return this.a.getString(15);
        }

        public final boolean mo552v() {
            return !this.a.isNull(16);
        }

        public final String mo553w() {
            return this.a.getString(16);
        }

        public final boolean mo554x() {
            return !this.a.isNull(17);
        }

        public final int mo555y() {
            return this.a.getInt(17);
        }

        public final boolean mo556z() {
            return !this.a.isNull(18);
        }

        public final String mo518A() {
            return this.a.getString(18);
        }

        public final int mo519B() {
            return this.a.getInt(19);
        }

        public final String mo520C() {
            return this.a.getString(20);
        }

        public final String mo521D() {
            return this.a.getString(21);
        }

        public final boolean mo522E() {
            return !this.a.isNull(22);
        }

        public final boolean mo523F() {
            return this.a.getInt(22) != 0;
        }

        public final boolean mo524G() {
            return this.a.getInt(23) != 0;
        }

        public final int mo525H() {
            return this.a.getInt(24);
        }

        public final double mo526I() {
            return this.a.getDouble(25);
        }

        public final double mo527J() {
            return this.a.getDouble(26);
        }

        public final String mo528K() {
            return this.a.getString(27);
        }

        public final String mo529L() {
            return this.a.getString(28);
        }

        public final int mo530M() {
            return this.a.getInt(29);
        }

        public final int mo531N() {
            return this.a.getInt(30);
        }

        public final int mo532O() {
            return this.a.getInt(31);
        }

        public final String mo533P() {
            return this.a.getString(32);
        }

        public final long mo534Q() {
            return this.a.getLong(35);
        }
    }

    /* compiled from: not supported in the iterator. Use remove() in SubscriptionHolder directly */
    public final class TimeSortedQueryBySectionProvider implements QueryProvider<TimeSortedQueryBySectionDAO> {
        private final int f7843a;
        private final int f7844b;
        private final String f7845c;

        public TimeSortedQueryBySectionProvider(int i, int i2, String str) {
            this.f7843a = i;
            this.f7844b = i2;
            this.f7845c = str;
        }

        public final Object[] m8234a() {
            return new Object[]{Saved2ItemTable.class};
        }

        public final Object[] m8235b() {
            r0 = new Object[5];
            r0[1] = new String[]{"_id", "time_saved_ms", "graphql_cursor", "group_title", "picture_uri", "title", "subtitle", "type", "type_display_extras", "saved_state", "url", "permalink_id", "source_story_id", "fb_link_url", "is_playable", "playable_url", "target_id", "target_graphql_object_type", "global_share_id", "global_share_graphql_object_type", "instant_article_id", "instant_article_canonical_url", "can_viewer_share_event", "is_spherical", "spherical_preferred_fov", "spherical_fullscreen_aspect_ratio", "spherical_inline_aspect_ratio", "spherical_playable_url_sd_string", "spherical_playable_url_hd_string", "initial_view_heading_degrees", "initial_view_pitch_degrees", "initial_view_roll_degrees", "section_name_server", "is_deleted_client", "is_unarchived_client", "media_content_size", "is_download_client"};
            r0[2] = "is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ?";
            r0[3] = new String[]{String.valueOf(this.f7843a), String.valueOf(this.f7844b), String.valueOf(this.f7845c)};
            r0[4] = "time_saved_ms DESC";
            return r0;
        }

        public final DAOItem m8233a(Cursor cursor) {
            return new TimeSortedQueryBySectionDAOImpl(cursor);
        }
    }
}
