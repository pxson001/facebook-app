package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: Share live video failed */
public class FeedDiscoveryPillsBlingBarView extends BaseFeedDiscoveryBlingBarView {
    public static final ViewType f23324b = new C20191();

    /* compiled from: Share live video failed */
    final class C20191 extends ViewType {
        C20191() {
        }

        public final View m25686a(Context context) {
            return new FeedDiscoveryPillsBlingBarView(context);
        }
    }

    public FeedDiscoveryPillsBlingBarView(Context context) {
        this(context, null);
    }

    private FeedDiscoveryPillsBlingBarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FeedDiscoveryPillsBlingBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return 2130904289;
    }
}
