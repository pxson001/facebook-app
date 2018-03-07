package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: log_eligibility_waterfall */
public enum Maps$EntryFunction implements Function<Entry<?, ?>, Object> {
    KEY {
        @Nullable
        public final /* bridge */ /* synthetic */ Object apply(Object obj) {
            return ((Entry) obj).getKey();
        }
    },
    VALUE {
        @Nullable
        public final /* bridge */ /* synthetic */ Object apply(Object obj) {
            return ((Entry) obj).getValue();
        }
    };
}
