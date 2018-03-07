package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.tiles.ThreadTileView;

/* compiled from: onLoadFailedFullThreadList */
public class AddFavoriteGroupItemView extends CustomViewGroup {
    public final ThreadNameView f5914a;
    public final ThreadNameView f5915b;
    public final View f5916c;
    public final ThreadTileView f5917d;
    public final MessengerThreadNameViewDataFactory f5918e;
    public final MessengerThreadTileViewDataFactory f5919f;
    public AddFavoriteGroupRow f5920g;

    /* compiled from: onLoadFailedFullThreadList */
    public class C08731 implements OnClickListener {
        final /* synthetic */ AddFavoriteGroupItemView f5913a;

        public C08731(AddFavoriteGroupItemView addFavoriteGroupItemView) {
            this.f5913a = addFavoriteGroupItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1031402845);
            AddFavoriteGroupRow addFavoriteGroupRow = this.f5913a.f5920g;
            if (addFavoriteGroupRow.f5922b != null) {
                addFavoriteGroupRow.f5922b.m5578a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2573437, a);
        }
    }

    public AddFavoriteGroupItemView(Context context) {
        this(context, null, 0);
    }

    private AddFavoriteGroupItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905556);
        this.f5914a = (ThreadNameView) getView(2131562738);
        this.f5915b = (ThreadNameView) getView(2131564422);
        this.f5917d = (ThreadTileView) getView(2131564421);
        this.f5916c = getView(2131564420);
        FbInjector fbInjector = FbInjector.get(context);
        this.f5918e = MessengerThreadNameViewDataFactory.a(fbInjector);
        this.f5919f = MessengerThreadTileViewDataFactory.a(fbInjector);
    }

    public AddFavoriteGroupRow getContactRow() {
        return this.f5920g;
    }
}
