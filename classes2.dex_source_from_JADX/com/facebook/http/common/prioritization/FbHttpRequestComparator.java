package com.facebook.http.common.prioritization;

import com.facebook.http.common.PriorityRequestHolder;
import java.util.Comparator;

/* compiled from: read_exceptions */
public class FbHttpRequestComparator implements Comparator<PriorityRequestHolder> {
    private final UnblockableRequestChecker f7957a;

    public int compare(Object obj, Object obj2) {
        PriorityRequestHolder priorityRequestHolder = (PriorityRequestHolder) obj;
        PriorityRequestHolder priorityRequestHolder2 = (PriorityRequestHolder) obj2;
        if (priorityRequestHolder == priorityRequestHolder2) {
            return 0;
        }
        boolean a = this.f7957a.m12532a(priorityRequestHolder);
        if (a != this.f7957a.m12532a(priorityRequestHolder2)) {
            if (a) {
                return -1;
            }
            return 1;
        } else if (priorityRequestHolder.m17395a() != priorityRequestHolder2.m17395a()) {
            return priorityRequestHolder.m17395a().getNumericValue() - priorityRequestHolder2.m17395a().getNumericValue();
        } else {
            if (priorityRequestHolder.f11888c.f7698o != priorityRequestHolder2.f11888c.f7698o) {
                if (priorityRequestHolder.f11888c.f7698o <= priorityRequestHolder2.f11888c.f7698o) {
                    return 1;
                }
                return -1;
            } else if (priorityRequestHolder.f11888c.f7697n <= priorityRequestHolder2.f11888c.f7697n) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public FbHttpRequestComparator(UnblockableRequestChecker unblockableRequestChecker) {
        this.f7957a = unblockableRequestChecker;
    }
}
