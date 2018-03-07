package difflib;

import java.util.Arrays;
import java.util.List;

/* compiled from: event_creation */
public class Chunk<T> {
    private final Differentiator<T> f13594a;
    public final int f13595b;
    public List<T> f13596c;

    public Chunk(int i, List<T> list, Differentiator<T> differentiator) {
        this.f13595b = i;
        this.f13596c = list;
        this.f13594a = differentiator;
    }

    public Chunk(int i, T[] tArr, Differentiator<T> differentiator) {
        this.f13595b = i;
        this.f13596c = Arrays.asList(tArr);
        this.f13594a = differentiator;
    }

    public final int m13856a() {
        return this.f13595b;
    }

    public final List<T> m13857b() {
        return this.f13596c;
    }

    public final int m13858c() {
        return this.f13596c.size();
    }

    public int hashCode() {
        return (((((this.f13596c == null ? 0 : this.f13596c.hashCode()) + 31) * 31) + this.f13595b) * 31) + m13858c();
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
        Chunk chunk = (Chunk) obj;
        if (this.f13596c != null) {
            List list = this.f13596c;
            List list2 = chunk.f13596c;
            Differentiator differentiator = this.f13594a;
            Object obj2 = null;
            if (list.size() != list2.size()) {
                obj2 = 1;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (differentiator.mo308a(list.get(i), list2.get(i))) {
                        int i2 = 1;
                        break;
                    }
                }
            }
            if (obj2 != null) {
                return false;
            }
        } else if (chunk.f13596c != null) {
            return false;
        }
        if (this.f13595b != chunk.f13595b) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[position: " + this.f13595b + ", size: " + m13858c() + ", lines: " + this.f13596c + "]";
    }
}
