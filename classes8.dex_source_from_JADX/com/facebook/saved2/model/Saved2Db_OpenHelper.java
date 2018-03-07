package com.facebook.saved2.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;

/* compiled from: notice_button_color */
public class Saved2Db_OpenHelper extends SQLiteOpenHelper {
    public Saved2Db_OpenHelper(Context context) {
        super(context, "saved2.db", null, 14);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        SQLiteDetour.a(-187777596);
        sQLiteDatabase.execSQL("CREATE TABLE item (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,section_name TEXT NOT NULL ,node_id TEXT ,time_saved_ms INTEGER NOT NULL ,graphql_cursor TEXT ,group_title TEXT NOT NULL ,picture_uri TEXT ,title TEXT ,subtitle TEXT ,type TEXT ,type_display_extras TEXT ,saved_state TEXT ,url TEXT ,permalink_id TEXT ,source_story_id TEXT ,fb_link_url TEXT ,is_playable INTEGER ,playable_url TEXT ,target_id TEXT ,target_graphql_object_type INTEGER ,global_share_id TEXT ,global_share_graphql_object_type INTEGER ,instant_article_id TEXT ,instant_article_canonical_url TEXT ,can_viewer_share_event INTEGER ,is_spherical INTEGER ,spherical_preferred_fov INTEGER ,spherical_fullscreen_aspect_ratio REAL ,spherical_inline_aspect_ratio REAL ,spherical_playable_url_sd_string TEXT ,spherical_playable_url_hd_string TEXT ,initial_view_heading_degrees INTEGER ,initial_view_pitch_degrees INTEGER ,initial_view_roll_degrees INTEGER ,section_name_server TEXT NOT NULL ,is_deleted_client INTEGER DEFAULT 0 NOT NULL ,is_unarchived_client INTEGER DEFAULT 0 NOT NULL ,media_content_size INTEGER DEFAULT 0 NOT NULL ,is_download_client INTEGER DEFAULT 0 NOT NULL )");
        SQLiteDetour.a(1317362561);
        for (String str : Saved2ItemTable_Setup.f7846a) {
            SQLiteDetour.a(-2109718137);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1577490508);
        }
        SQLiteDetour.a(50144265);
        sQLiteDatabase.execSQL("CREATE TABLE unread_count (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,section_name TEXT NOT NULL ,unread_count INTEGER NOT NULL )");
        SQLiteDetour.a(-1463651174);
        int length = Saved2UnreadCountsTable_Setup.f7849a.length;
        while (i < length) {
            String str2 = Saved2UnreadCountsTable_Setup.f7849a[i];
            SQLiteDetour.a(-143595761);
            sQLiteDatabase.execSQL(str2);
            SQLiteDetour.a(261376276);
            i++;
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SQLiteDetour.a(109179346);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS item");
        SQLiteDetour.a(-724981242);
        SQLiteDetour.a(1337683396);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS unread_count");
        SQLiteDetour.a(-977879407);
        onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }
}
