package com.facebook.messaging.media.mediatray;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.Assisted;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.user.tiles.UserTileView;
import javax.inject.Inject;

/* compiled from: search_result_user_selection */
public class PhotoRemindersNuxViewHolder extends ViewHolder {
    public final PhotoRemindersNuxExperimentAccessor f3164l;
    public final ThreadRecipientUtil f3165m;
    public final GlyphButton f3166n;
    public final TextView f3167o;
    public final TextView f3168p;
    public final UserTileView f3169q;
    public final UserTileView f3170r;
    public final UserTileView f3171s;
    public final UserTileView f3172t;

    @Inject
    public PhotoRemindersNuxViewHolder(PhotoRemindersNuxExperimentAccessor photoRemindersNuxExperimentAccessor, ThreadRecipientUtil threadRecipientUtil, @Assisted View view) {
        super(view);
        this.f3164l = photoRemindersNuxExperimentAccessor;
        this.f3165m = threadRecipientUtil;
        this.f3166n = (GlyphButton) view.findViewById(2131565928);
        this.f3167o = (TextView) view.findViewById(2131559627);
        this.f3168p = (TextView) view.findViewById(2131565927);
        this.f3169q = (UserTileView) view.findViewById(2131565925);
        this.f3170r = (UserTileView) view.findViewById(2131565924);
        this.f3171s = (UserTileView) view.findViewById(2131565923);
        this.f3172t = (UserTileView) view.findViewById(2131565926);
    }
}
