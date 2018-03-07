package com.facebook.pages.common.resulthandlers;

import com.facebook.inject.Lazy;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: scontent-%s.xx.fbcdn.net */
public class ActivityResultHandlerResolver {
    Lazy<Set<ActivityResultHandler>> f2251a;
    private Map<Integer, ActivityResultHandler> f2252b = new HashMap();

    @Inject
    public ActivityResultHandlerResolver(Lazy<Set<ActivityResultHandler>> lazy) {
        this.f2251a = lazy;
        for (ActivityResultHandler activityResultHandler : (Set) this.f2251a.get()) {
            if (activityResultHandler.mo50c()) {
                ImmutableList<Integer> d = activityResultHandler.mo51d();
                if (d != null) {
                    for (Integer num : d) {
                        if (this.f2252b.containsKey(num)) {
                            throw new IllegalStateException("Duplicate result handler for requestCode=" + num);
                        }
                        this.f2252b.put(num, activityResultHandler);
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
    }

    public final ActivityResultHandler m3200a(int i) {
        return (ActivityResultHandler) this.f2252b.get(Integer.valueOf(i));
    }
}
