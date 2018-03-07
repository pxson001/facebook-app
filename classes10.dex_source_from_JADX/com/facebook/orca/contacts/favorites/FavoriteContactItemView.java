package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView.DraggableRowView;
import com.facebook.user.tiles.UserTileView;
import javax.inject.Inject;

/* compiled from: onDataItemChanged */
public class FavoriteContactItemView extends DraggableRowView {
    @Inject
    public UserTileViewParamsFactory f5974b;
    @Inject
    public Lazy<PhoneContactUiHelper> f5975c;
    public FavoriteContactRow f5976d;
    public TextView f5977e = ((TextView) getView(2131564424));
    public TextView f5978f = ((TextView) getView(2131564425));
    public View f5979g = getView(2131564858);
    public UserTileView f5980h = ((UserTileView) getView(2131564423));

    /* compiled from: onDataItemChanged */
    public class C08911 implements OnClickListener {
        final /* synthetic */ FavoriteContactItemView f5973a;

        public C08911(FavoriteContactItemView favoriteContactItemView) {
            this.f5973a = favoriteContactItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1141941262);
            FavoriteContactRow favoriteContactRow = this.f5973a.f5976d;
            if (favoriteContactRow.f5982b != null) {
                favoriteContactRow.f5982b.m5584a(favoriteContactRow.f5981a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 372399036, a);
        }
    }

    public static void m5636a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FavoriteContactItemView favoriteContactItemView = (FavoriteContactItemView) obj;
        UserTileViewParamsFactory a = UserTileViewParamsFactory.a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 8793);
        favoriteContactItemView.f5974b = a;
        favoriteContactItemView.f5975c = a2;
    }

    public FavoriteContactItemView(Context context) {
        super(context);
        Class cls = FavoriteContactItemView.class;
        m5636a(this, getContext());
        setContentView(2130905696);
        this.f5979g.setClickable(true);
    }

    public View getInnerRow() {
        return getChildAt(0);
    }
}
