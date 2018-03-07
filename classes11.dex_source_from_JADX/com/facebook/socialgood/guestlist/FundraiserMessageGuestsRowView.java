package com.facebook.socialgood.guestlist;

import android.content.Context;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.fbui.widget.contentview.CheckedContentView.Position;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;

/* compiled from: OutOfMemory creating the bitmap for the cover */
public class FundraiserMessageGuestsRowView extends CheckedContentView {
    public FundraiserMessageGuestsRowView(Context context) {
        super(context);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434505);
        setThumbnailSize(ThumbnailSize.SMALL);
        setMaxLinesFromThumbnailSize(false);
        e(1, 1);
        setPadding(dimensionPixelSize, dimensionPixelSize, 0, dimensionPixelSize);
        setCheckMarkPosition(Position.START);
    }
}
