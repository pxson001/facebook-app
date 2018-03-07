package com.facebook.groups.editfavorites.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEvent;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEvent.EventType;
import com.facebook.groups.editfavorites.fragment.GroupsEditFavoritesFragment.C11792;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: action_type_id */
public class GroupFavoriteRowView extends CustomFrameLayout {
    public static final CallerContext f10129b = CallerContext.a(GroupFavoriteRowView.class, "group_edit_favorites");
    @Inject
    public Resources f10130a;
    public ImageView f10131c = ((ImageView) c(2131562655));
    public GlyphView f10132d = ((GlyphView) c(2131562658));
    public BetterTextView f10133e = ((BetterTextView) c(2131562657));
    public FbDraweeView f10134f = ((FbDraweeView) c(2131562656));
    public C11792 f10135g;

    /* compiled from: action_type_id */
    public class C11831 implements OnClickListener {
        final /* synthetic */ GroupPogGridData f10127a;
        final /* synthetic */ GroupFavoriteRowView f10128b;

        public C11831(GroupFavoriteRowView groupFavoriteRowView, GroupPogGridData groupPogGridData) {
            this.f10128b = groupFavoriteRowView;
            this.f10127a = groupPogGridData;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -886552469);
            if (this.f10128b.f10135g != null) {
                boolean z;
                C11792 c11792 = this.f10128b.f10135g;
                String str = this.f10127a.f10223a;
                if (this.f10127a.f10229g) {
                    z = false;
                } else {
                    z = true;
                }
                c11792.f10111a.f10118c.mo283a(str, z, this.f10127a.f10230h);
                c11792.f10111a.f10120e.a(new GroupFavoriteStatusEvent(EventType.STATUS_CHANGE));
                c11792.f10111a.al = true;
            }
            LogUtils.a(2004044402, a);
        }
    }

    public static void m10480a(Object obj, Context context) {
        ((GroupFavoriteRowView) obj).f10130a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public GroupFavoriteRowView(Context context) {
        super(context);
        Class cls = GroupFavoriteRowView.class;
        m10480a(this, getContext());
        setContentView(2130904650);
        setClickable(false);
    }
}
