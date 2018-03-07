package difflib;

import difflib.Delta.TYPE;

/* compiled from: event_composer_create_failure */
public class InsertDelta<T> extends Delta<T> {
    public InsertDelta(Chunk<T> chunk, Chunk<T> chunk2) {
        super(chunk, chunk2);
    }

    public final TYPE mo683a() {
        return TYPE.INSERT;
    }

    public String toString() {
        return "[InsertDelta, position: " + this.f13592a.f13595b + ", lines: " + this.f13593b.f13596c + "]";
    }
}
