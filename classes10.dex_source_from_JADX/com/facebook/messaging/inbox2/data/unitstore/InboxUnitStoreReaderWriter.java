package com.facebook.messaging.inbox2.data.unitstore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.messaging.inbox2.data.unitstore.UnitStoreSchemaPart.UnitsTable.Columns;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: sent_invites */
public class InboxUnitStoreReaderWriter {
    private final UnitStoreDatabaseSupplier f2833a;

    /* compiled from: sent_invites */
    public class UnitWithPosition {
        final NodesModel f2830a;
        final int f2831b;
        final boolean f2832c;

        UnitWithPosition(NodesModel nodesModel, int i, boolean z) {
            this.f2830a = nodesModel;
            this.f2831b = i;
            this.f2832c = z;
        }
    }

    @Inject
    public InboxUnitStoreReaderWriter(UnitStoreDatabaseSupplier unitStoreDatabaseSupplier) {
        this.f2833a = unitStoreDatabaseSupplier;
    }

    public final ImmutableList<NodesModel> m2777a() {
        Cursor query = this.f2833a.a().query("units", new String[]{Columns.f2837b.a()}, null, null, null, null, Columns.f2838c.a());
        try {
            Builder builder = ImmutableList.builder();
            while (query.moveToNext()) {
                builder.c((NodesModel) MutableFlatBuffer.a(ByteBuffer.wrap(query.getBlob(0)), NodesModel.class, null));
            }
            ImmutableList<NodesModel> b = builder.b();
            return b;
        } finally {
            query.close();
        }
    }

    public final ImmutableList<NodesModel> m2781b() {
        SQLiteDatabase a = this.f2833a.a();
        Expression a2 = SqlExpression.a(Columns.f2840e.a(), "1");
        Cursor query = a.query("units", new String[]{Columns.f2837b.a()}, a2.a(), a2.b(), null, null, Columns.f2838c.a());
        try {
            Builder builder = ImmutableList.builder();
            while (query.moveToNext()) {
                builder.c((NodesModel) MutableFlatBuffer.a(ByteBuffer.wrap(query.getBlob(0)), NodesModel.class, null));
            }
            ImmutableList<NodesModel> b = builder.b();
            return b;
        } finally {
            query.close();
        }
    }

    public final ImmutableMap<String, UnitWithPosition> m2778a(Set<String> set) {
        SQLiteDatabase a = this.f2833a.a();
        Expression a2 = SqlExpression.a(Columns.f2836a.a(), set);
        Cursor query = a.query("units", new String[]{Columns.f2836a.a(), Columns.f2837b.a(), Columns.f2838c.a(), Columns.f2840e.a()}, a2.a(), a2.b(), null, null, Columns.f2838c.a());
        try {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            while (query.moveToNext()) {
                builder.b(query.getString(0), new UnitWithPosition((NodesModel) MutableFlatBuffer.a(ByteBuffer.wrap(query.getBlob(1)), NodesModel.class, null), query.getInt(2), query.getInt(3) != 0));
            }
            ImmutableMap<String, UnitWithPosition> b = builder.b();
            return b;
        } finally {
            query.close();
        }
    }

    public final Map<String, Long> m2783c() {
        Cursor query = this.f2833a.a().query("units", new String[]{Columns.f2836a.a(), Columns.f2839d.a()}, null, null, null, null, null);
        try {
            Map<String, Long> hashMap = new HashMap();
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    public final void m2779a(NodesModel nodesModel, int i, boolean z) {
        SQLiteDatabase a = this.f2833a.a();
        ContentValues contentValues = new ContentValues();
        byte[] b = FlatBufferBuilder.b(nodesModel);
        contentValues.put(Columns.f2836a.d, nodesModel.j());
        contentValues.put(Columns.f2838c.d, Integer.valueOf(i));
        contentValues.put(Columns.f2840e.d, Boolean.valueOf(z));
        contentValues.put(Columns.f2837b.d, b);
        contentValues.put(Columns.f2839d.d, Long.valueOf(nodesModel.t()));
        SQLiteDetour.a(1599758019);
        a.replaceOrThrow("units", null, contentValues);
        SQLiteDetour.a(-1878705105);
    }

    public final void m2780a(String str, int i, boolean z) {
        Expression a = SqlExpression.a(Columns.f2836a.d, str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f2838c.d, Integer.valueOf(i));
        contentValues.put(Columns.f2840e.d, Boolean.valueOf(z));
        this.f2833a.a().update("units", contentValues, a.a(), a.b());
    }

    public final void m2784d() {
        this.f2833a.a().delete("units", "", null);
    }

    public final void m2782b(String str) {
        Expression a = SqlExpression.a(Columns.f2836a.d, str);
        this.f2833a.a().delete("units", a.a(), a.b());
    }
}
