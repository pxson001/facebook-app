package com.facebook.video.videohome.adapter.viewholders;

import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;

/* compiled from: sticker_info */
public class HeaderViewHolder extends VideoTopicItemBaseViewHolder<Integer> {
    private TextView f2770l;

    public final void mo81b(@StringRes Object obj) {
        this.f2770l.setText(this.a.getResources().getString(((Integer) obj).intValue()));
        this.a.setVisibility(0);
    }

    public HeaderViewHolder(View view) {
        super(view);
        this.f2770l = (TextView) FindViewUtil.b(view, 2131568425);
    }
}
