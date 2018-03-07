package difflib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: event_composer_cancel */
public class Patch<T> {
    private List<Delta<T>> f13601a = new LinkedList();

    public final void m13864a(Delta<T> delta) {
        this.f13601a.add(delta);
    }

    public final List<Delta<T>> m13863a() {
        Collections.sort(this.f13601a, DeltaComparator.f13597a);
        return this.f13601a;
    }
}
