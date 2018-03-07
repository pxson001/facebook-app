package difflib;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: event_composer_open */
public class DeltaComparator implements Serializable, Comparator<Delta> {
    public static final Comparator<Delta> f13597a = new DeltaComparator();

    public int compare(Object obj, Object obj2) {
        Delta delta = (Delta) obj2;
        int i = ((Delta) obj).f13592a.f13595b;
        int i2 = delta.f13592a.f13595b;
        if (i > i2) {
            return 1;
        }
        if (i < i2) {
            return -1;
        }
        return 0;
    }

    private DeltaComparator() {
    }
}
