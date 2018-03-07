package difflib;

import difflib.Delta.TYPE;

/* compiled from: event_cover_photo_click */
public class DeleteDelta<T> extends Delta<T> {
    public DeleteDelta(Chunk<T> chunk, Chunk<T> chunk2) {
        super(chunk, chunk2);
    }

    public final TYPE mo683a() {
        return TYPE.DELETE;
    }

    public String toString() {
        return "[DeleteDelta, position: " + this.f13592a.f13595b + ", lines: " + this.f13592a.f13596c + "]";
    }
}
