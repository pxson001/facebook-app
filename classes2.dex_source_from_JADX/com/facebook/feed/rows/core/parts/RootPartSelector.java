package com.facebook.feed.rows.core.parts;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.MultiRowSubParts;
import java.util.ArrayList;
import java.util.List;

/* compiled from: last_new_asset_count_log_time */
public class RootPartSelector<E extends AnyEnvironment> {
    private final List<PropsInfo> f17943a = new ArrayList();
    private final List<Lazy> f17944b = new ArrayList();

    /* compiled from: last_new_asset_count_log_time */
    public class PropsInfo {
        public final Class<?> f17945a;
        public final PropsType f17946b;

        public PropsInfo(Class<?> cls, PropsType propsType) {
            this.f17945a = cls;
            this.f17946b = propsType;
        }
    }

    /* compiled from: last_new_asset_count_log_time */
    public enum PropsType {
        FEED_UNIT,
        FEED_UNIT_PROPS
    }

    private RootPartSelector() {
    }

    public static <E extends AnyEnvironment> RootPartSelector<E> m25170a() {
        return new RootPartSelector();
    }

    public final <P> RootPartSelector<E> m25171a(Class<P> cls, Lazy<? extends MultiRowPartWithIsNeeded<? super P, ? super E>> lazy) {
        this.f17943a.add(new PropsInfo(cls, PropsType.FEED_UNIT));
        this.f17944b.add(lazy);
        return this;
    }

    public final RootPartSelector<E> m25173b(Class<?> cls, Lazy<? extends MultiRowPartWithIsNeeded<?, ? super E>> lazy) {
        this.f17943a.add(new PropsInfo(cls, PropsType.FEED_UNIT_PROPS));
        this.f17944b.add(lazy);
        return this;
    }

    public final boolean m25172a(MultiRowSubParts<E> multiRowSubParts, Object obj) {
        Object c;
        if (obj instanceof Flattenable) {
            c = FeedProps.m19802c((Flattenable) obj);
        } else {
            c = null;
        }
        for (int i = 0; i < this.f17944b.size(); i++) {
            if (((PropsInfo) this.f17943a.get(i)).f17945a.isAssignableFrom(obj.getClass())) {
                MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) ((Lazy) this.f17944b.get(i)).get();
                if (((PropsInfo) this.f17943a.get(i)).f17946b == PropsType.FEED_UNIT_PROPS && r2 != null && multiRowSubParts.m19112a(multiRowPartWithIsNeeded, r2)) {
                    return true;
                }
                if (((PropsInfo) this.f17943a.get(i)).f17946b == PropsType.FEED_UNIT && multiRowSubParts.m19112a(multiRowPartWithIsNeeded, obj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
