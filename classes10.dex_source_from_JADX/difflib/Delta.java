package difflib;

/* compiled from: event_dashboard */
public abstract class Delta<T> {
    public Chunk<T> f13592a;
    public Chunk<T> f13593b;

    /* compiled from: event_dashboard */
    public enum TYPE {
        CHANGE,
        DELETE,
        INSERT
    }

    public abstract TYPE mo683a();

    public Delta(Chunk<T> chunk, Chunk<T> chunk2) {
        this.f13592a = chunk;
        this.f13593b = chunk2;
    }

    public final Chunk<T> m13853b() {
        return this.f13592a;
    }

    public final Chunk<T> m13854c() {
        return this.f13593b;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f13592a == null ? 0 : this.f13592a.hashCode()) + 31) * 31;
        if (this.f13593b != null) {
            i = this.f13593b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Delta delta = (Delta) obj;
        if (this.f13592a == null) {
            if (delta.f13592a != null) {
                return false;
            }
        } else if (!this.f13592a.equals(delta.f13592a)) {
            return false;
        }
        if (this.f13593b == null) {
            if (delta.f13593b != null) {
                return false;
            }
            return true;
        } else if (this.f13593b.equals(delta.f13593b)) {
            return true;
        } else {
            return false;
        }
    }
}
