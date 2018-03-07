package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: ProfilePictureOverlayCategoryBrowserInitialLoad */
public class GametimeFanFavoriteTeamBeforeVotingView extends CustomLinearLayout {
    private static final CallerContext f24332a = CallerContext.a(GametimeFanFavoriteTeamBeforeVotingView.class, "graph_search_results_page");
    private FbDraweeView f24333b;
    private BetterTextView f24334c;
    private BetterTextView f24335d;
    private Paint f24336e;

    public GametimeFanFavoriteTeamBeforeVotingView(Context context) {
        super(context);
        m27838a();
    }

    public GametimeFanFavoriteTeamBeforeVotingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27838a();
    }

    public GametimeFanFavoriteTeamBeforeVotingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27838a();
    }

    private void m27838a() {
        setContentView(2130904242);
        this.f24333b = (FbDraweeView) a(2131561730);
        this.f24334c = (BetterTextView) a(2131561731);
        this.f24335d = (BetterTextView) a(2131561732);
        this.f24336e = new Paint();
        setWillNotDraw(false);
    }

    public void setTeamLogo(Uri uri) {
        this.f24333b.a(uri, f24332a);
    }

    public void setTeamName(String str) {
        this.f24335d.setText(str);
    }

    public void setTeamMarket(String str) {
        this.f24334c.setText(str);
    }

    protected void onDraw(Canvas canvas) {
        this.f24336e.setStyle(Style.STROKE);
        this.f24336e.setStrokeWidth(2.0f);
        this.f24336e.setColor(getResources().getColor(2131361939));
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f24336e);
        super.onDraw(canvas);
    }
}
