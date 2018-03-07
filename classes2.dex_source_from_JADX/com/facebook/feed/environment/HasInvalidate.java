package com.facebook.feed.environment;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.widget.listview.FbListAdapter;

/* compiled from: percent_time_5+_dropped_with_ */
public interface HasInvalidate extends AnyEnvironment {

    /* compiled from: percent_time_5+_dropped_with_ */
    public class InvalidateRunnable implements Runnable {
        public FbListAdapter f10224a;

        public void run() {
            if (this.f10224a != null) {
                this.f10224a.notifyDataSetChanged();
            }
        }
    }

    void mo2437a(FeedProps... feedPropsArr);

    @Deprecated
    void mo2438a(Object... objArr);

    @Deprecated
    void hL_();
}
