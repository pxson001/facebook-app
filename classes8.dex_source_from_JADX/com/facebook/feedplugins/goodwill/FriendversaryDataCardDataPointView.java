package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;

/* compiled from: graph_search_results_map_tapped */
public class FriendversaryDataCardDataPointView extends LinearLayout {
    private static final CallerContext f12267a = CallerContext.a(FriendversaryDataCardDataPointView.class);

    public FriendversaryDataCardDataPointView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130904613, this);
    }

    public final void m14235a(CharSequence charSequence, String str) {
        ((FbTextView) findViewById(2131562589)).setText(charSequence);
        ((FbDraweeView) findViewById(2131562588)).a(TextUtils.isEmpty(str) ? null : Uri.parse(str), f12267a);
    }
}
