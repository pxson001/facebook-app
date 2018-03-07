package com.facebook.video.channelfeed;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.feedplugins.base.blingbar.ui.BlingBarUtil;
import com.facebook.feedplugins.graphqlstory.footer.ui.VideoPlaysBlingBarView;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: supportHttpCharsetHeader */
public class ChannelFeedVideoPlaysBlingBarView extends VideoPlaysBlingBarView {
    @Inject
    public NumberTruncationUtil f2546b;
    public FbTextView f2547c = ((FbTextView) c(2131562037));

    public static void m2480a(Object obj, Context context) {
        ((ChannelFeedVideoPlaysBlingBarView) obj).f2546b = NumberTruncationUtil.a(FbInjector.get(context));
    }

    public ChannelFeedVideoPlaysBlingBarView(Context context) {
        super(context);
        Class cls = ChannelFeedVideoPlaysBlingBarView.class;
        m2480a(this, getContext());
    }

    public void setLikes(int i) {
        BlingBarUtil.a((TextView) c(2131559915), i, 2131689540, this.f2546b);
    }

    public void setComments(int i) {
        BlingBarUtil.a((TextView) c(2131559916), i, 2131689541, this.f2546b);
    }

    public void setPlayCountText(int i) {
        boolean z = i > 0 || a();
        setIsExpanded(z);
        BlingBarUtil.a((TextView) c(2131562037), i, 2131689539, this.f2546b);
    }

    public void setShares(int i) {
        Optional d = d(2131559917);
        if (d != null && d.isPresent()) {
            BlingBarUtil.a((TextView) d.get(), i, 2131689542, this.f2546b);
        }
    }
}
