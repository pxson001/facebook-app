package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomViewGroup;
import javax.inject.Inject;

/* compiled from: onMeasure */
public class AddFavoriteContactItemView extends CustomViewGroup {
    @Inject
    public UserTileViewParamsFactory f5904a;
    @Inject
    public Lazy<PhoneContactUiHelper> f5905b;
    public final TextView f5906c;
    public final TextView f5907d;
    public final View f5908e;
    public final UserTileView f5909f;
    public AddFavoriteContactRow f5910g;

    /* compiled from: onMeasure */
    public class C08721 implements OnClickListener {
        final /* synthetic */ AddFavoriteContactItemView f5903a;

        public C08721(AddFavoriteContactItemView addFavoriteContactItemView) {
            this.f5903a = addFavoriteContactItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -297455092);
            AddFavoriteContactRow addFavoriteContactRow = this.f5903a.f5910g;
            if (addFavoriteContactRow.f5912b != null) {
                addFavoriteContactRow.f5912b.m5577a(addFavoriteContactRow.f5911a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 678514502, a);
        }
    }

    public static void m5565a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AddFavoriteContactItemView addFavoriteContactItemView = (AddFavoriteContactItemView) obj;
        UserTileViewParamsFactory a = UserTileViewParamsFactory.a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 8793);
        addFavoriteContactItemView.f5904a = a;
        addFavoriteContactItemView.f5905b = a2;
    }

    public AddFavoriteContactItemView(Context context) {
        this(context, null, 0);
    }

    private AddFavoriteContactItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = AddFavoriteContactItemView.class;
        m5565a(this, getContext());
        setContentView(2130905557);
        this.f5906c = (TextView) getView(2131564424);
        this.f5907d = (TextView) getView(2131564425);
        this.f5909f = (UserTileView) getView(2131564423);
        this.f5908e = getView(2131564420);
    }
}
