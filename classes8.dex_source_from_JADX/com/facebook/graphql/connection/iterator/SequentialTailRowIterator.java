package com.facebook.graphql.connection.iterator;

import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.cursor.database.GraphCursorDatabase.BufferRowMapper;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: webview_breakdown */
public class SequentialTailRowIterator extends TailRowIterator {

    /* compiled from: webview_breakdown */
    class RowMapper implements BufferRowMapper {
        private final BufferRowMapper f267a;
        private final TailFetchLocation f268b;

        public RowMapper(BufferRowMapper bufferRowMapper, TailFetchLocation tailFetchLocation) {
            this.f267a = bufferRowMapper;
            this.f268b = tailFetchLocation;
        }

        public final int m252a() {
            return this.f267a.a();
        }

        public final int m253a(int i) {
            return this.f267a.a(i);
        }

        public final Class<? extends MutableFlattenable> m254b(int i) {
            return this.f267a.b(i);
        }

        public final String m255c(int i) {
            return SortKeyHelper.b(this.f268b.f260a, i);
        }

        public final Collection<String> m256d(int i) {
            return this.f267a.d(i);
        }

        public final int m257e(int i) {
            return this.f267a.e(i);
        }
    }

    public SequentialTailRowIterator(MutableFlattenable mutableFlattenable, BufferRowArrayList bufferRowArrayList, TailFetchLocation tailFetchLocation, String str, boolean z) {
        this(mutableFlattenable, bufferRowArrayList, TailFetchLocation.m239a(tailFetchLocation, str, z));
    }

    private SequentialTailRowIterator(MutableFlattenable mutableFlattenable, BufferRowArrayList bufferRowArrayList, TailFetchLocation tailFetchLocation) {
        boolean z = false;
        RowMapper rowMapper = new RowMapper(bufferRowArrayList, tailFetchLocation);
        ImmutableList of = ImmutableList.of(TailFetchLocation.m240a(tailFetchLocation, bufferRowArrayList.a()));
        if (!bufferRowArrayList.b()) {
            z = true;
        }
        super(mutableFlattenable, rowMapper, of, z, tailFetchLocation);
    }
}
