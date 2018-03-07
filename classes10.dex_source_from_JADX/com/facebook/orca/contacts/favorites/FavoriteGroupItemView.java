package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView.DraggableRowView;
import com.facebook.widget.tiles.ThreadTileView;

/* compiled from: onConnectedNodes */
public class FavoriteGroupItemView extends DraggableRowView {
    public FavoriteGroupRow f5984b;
    public ThreadNameView f5985c = ((ThreadNameView) getView(2131562738));
    public ThreadNameView f5986d = ((ThreadNameView) getView(2131564422));
    public View f5987e = getView(2131564858);
    public ThreadTileView f5988f = ((ThreadTileView) getView(2131564421));
    public MessengerThreadNameViewDataFactory f5989g;
    public MessengerThreadTileViewDataFactory f5990h;

    /* compiled from: onConnectedNodes */
    public class C08921 implements OnClickListener {
        final /* synthetic */ FavoriteGroupItemView f5983a;

        public C08921(FavoriteGroupItemView favoriteGroupItemView) {
            this.f5983a = favoriteGroupItemView;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 639565643, Logger.a(2, EntryType.UI_INPUT_START, 218919190));
        }
    }

    public FavoriteGroupItemView(Context context) {
        super(context);
        setContentView(2130905696);
        this.f5987e.setClickable(true);
        FbInjector fbInjector = FbInjector.get(context);
        this.f5989g = MessengerThreadNameViewDataFactory.a(fbInjector);
        this.f5990h = MessengerThreadTileViewDataFactory.a(fbInjector);
    }

    public FavoriteGroupRow getGroupRow() {
        return this.f5984b;
    }

    public View getInnerRow() {
        return getChildAt(0);
    }
}
