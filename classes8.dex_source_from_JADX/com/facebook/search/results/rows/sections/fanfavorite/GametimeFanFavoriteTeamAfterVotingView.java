package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: ProfilePictureOverlayCategoryBrowser_%s */
public class GametimeFanFavoriteTeamAfterVotingView extends CustomLinearLayout {
    private static final CallerContext f24324a = CallerContext.a(GametimeFanFavoriteTeamAfterVotingView.class, "graph_search_results_page");
    private FbDraweeView f24325b;
    private BetterTextView f24326c;
    private BetterTextView f24327d;
    private BetterTextView f24328e;
    private BetterTextView f24329f;

    public GametimeFanFavoriteTeamAfterVotingView(Context context) {
        super(context);
        m27834a();
    }

    public GametimeFanFavoriteTeamAfterVotingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27834a();
    }

    public GametimeFanFavoriteTeamAfterVotingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27834a();
    }

    private void m27834a() {
        setContentView(2130904241);
        this.f24325b = (FbDraweeView) a(2131561730);
        this.f24326c = (BetterTextView) a(2131561731);
        this.f24327d = (BetterTextView) a(2131561732);
        this.f24328e = (BetterTextView) a(2131561734);
        this.f24329f = (BetterTextView) a(2131561733);
    }

    public void setLogo(Uri uri) {
        this.f24325b.a(uri, f24324a);
    }

    public void setMarket(String str) {
        this.f24326c.setText(str);
    }

    public void setName(String str) {
        this.f24327d.setText(str);
    }

    public void setVotePercentage(int i) {
        this.f24328e.setText(StringFormatUtil.formatStrLocaleSafe(getResources().getString(2131239029), Integer.valueOf(i)));
    }

    public void setVoteCount(int i) {
        this.f24329f.setText(getResources().getQuantityString(2131689714, i, new Object[]{Integer.valueOf(i)}));
    }
}
