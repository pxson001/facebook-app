package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: Should not be attempting to update an empty line */
public class FeedDiscoveryDefaultBlingBarView extends BaseFeedDiscoveryBlingBarView {
    public static final ViewType f23323b = new C20181();

    /* compiled from: Should not be attempting to update an empty line */
    final class C20181 extends ViewType {
        C20181() {
        }

        public final View m25685a(Context context) {
            return new FeedDiscoveryDefaultBlingBarView(context);
        }
    }

    public FeedDiscoveryDefaultBlingBarView(Context context) {
        this(context, null);
    }

    private FeedDiscoveryDefaultBlingBarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FeedDiscoveryDefaultBlingBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return 2130904291;
    }
}
