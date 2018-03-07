package difflib;

import difflib.Delta.TYPE;

/* compiled from: event_creation_expand_options_click */
public class ChangeDelta<T> extends Delta<T> {
    public ChangeDelta(Chunk<T> chunk, Chunk<T> chunk2) {
        super(chunk, chunk2);
    }

    public String toString() {
        return "[ChangeDelta, position: " + this.f13592a.f13595b + ", lines: " + this.f13592a.f13596c + " to " + this.f13593b.f13596c + "]";
    }

    public final TYPE mo683a() {
        return TYPE.CHANGE;
    }
}
