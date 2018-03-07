package com.facebook.stickers.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.debug.log.BLog;
import com.facebook.stickers.data.StickersDbSchemaPart.AssetsTable.Columns;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: qes */
public class StickersAssetsFileVisitor implements FileTreeVisitor {
    private static final Class<?> f3934a = StickersAssetsFileVisitor.class;
    private final Deque<String> f3935b = new ArrayDeque(2);
    private SQLiteStatement f3936c;
    private boolean f3937d;
    private final Map<String, Long> f3938e = Maps.c();

    public final void mo260a(File file) {
        if (this.f3935b.size() >= 2) {
            BLog.a(f3934a, "unexpected directory %s", new Object[]{file.getPath()});
        }
        if (this.f3937d) {
            this.f3937d = false;
        } else {
            this.f3935b.push(file.getName());
        }
    }

    public final void mo261b(File file) {
        if (this.f3935b.size() != 2) {
            BLog.a(f3934a, "unexpected file %s", new Object[]{file.getPath()});
            return;
        }
        List a = Lists.a(Splitter.on('.').split(file.getName()));
        if (a.size() == 2 && StickerAssetType.isDbString((String) a.get(0))) {
            String str = ((String) this.f3935b.getFirst()) + ((String) a.get(0));
            if (this.f3938e.containsKey(str)) {
                if (((Long) this.f3938e.get(str)).longValue() > file.lastModified()) {
                    BLog.a(f3934a, "A more recent file was found for sticker id %s asset type %s, using that file.", new Object[]{this.f3935b.getFirst(), a.get(0)});
                    return;
                }
                BLog.a(f3934a, "Replacing less recent file for sticker id %s asset type %s.", new Object[]{this.f3935b.getFirst(), a.get(0)});
            }
            this.f3936c.clearBindings();
            this.f3936c.bindString(1, (String) this.f3935b.getLast());
            this.f3936c.bindString(2, (String) this.f3935b.getFirst());
            this.f3936c.bindString(3, (String) a.get(0));
            this.f3936c.bindString(4, "image/" + ((String) a.get(1)));
            this.f3936c.bindString(5, file.getPath());
            SQLiteStatement sQLiteStatement = this.f3936c;
            SQLiteDetour.a(288004993);
            sQLiteStatement.execute();
            SQLiteDetour.a(14156912);
            BLog.a(f3934a, "Inserted %s asset for sticker id %s into db.", new Object[]{a.get(0), this.f3935b.getFirst()});
            this.f3938e.put(str, Long.valueOf(file.lastModified()));
            return;
        }
        BLog.a(f3934a, "unexpected file name %s", new Object[]{file.getPath()});
    }

    public final void mo262c(File file) {
        if (!this.f3935b.isEmpty()) {
            this.f3935b.pop();
        }
    }

    public final void m4392a(SQLiteDatabase sQLiteDatabase) {
        this.f3936c = sQLiteDatabase.compileStatement("INSERT OR REPLACE INTO sticker_asserts (" + Columns.f3821c.d + ", " + Columns.f3819a.d + ", " + Columns.f3820b.d + ", " + Columns.f3826h.d + ", " + Columns.f3825g.d + ") VALUES (?, ?, ?, ?, ?)");
        this.f3937d = true;
    }

    public final void m4391a() {
        if (this.f3936c != null) {
            this.f3936c.close();
            this.f3936c = null;
        }
        this.f3938e.clear();
    }
}
