package com.facebook.groups.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: TimelineContextualInfoAdapter.unknown_viewtype */
public class GroupsFeedForSalePostsBar extends CustomFrameLayout implements Bindable<FetchGroupInformationModel> {
    @Inject
    public SecureContextHelper f22120a;
    @Inject
    public GroupsFeedIntentBuilder f22121b;
    public FetchGroupInformationModel f22122c;

    /* compiled from: TimelineContextualInfoAdapter.unknown_viewtype */
    public class C31841 implements OnClickListener {
        final /* synthetic */ GroupsFeedForSalePostsBar f22119a;

        public C31841(GroupsFeedForSalePostsBar groupsFeedForSalePostsBar) {
            this.f22119a = groupsFeedForSalePostsBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1152868549);
            if (this.f22119a.f22122c != null) {
                this.f22119a.f22120a.a(this.f22119a.f22121b.m23299c(this.f22119a.f22122c), this.f22119a.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -805516596, a);
        }
    }

    public static void m23226a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        GroupsFeedForSalePostsBar groupsFeedForSalePostsBar = (GroupsFeedForSalePostsBar) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        GroupsFeedIntentBuilder a = GroupsFeedIntentBuilder.m23295a(injectorLike);
        groupsFeedForSalePostsBar.f22120a = secureContextHelper;
        groupsFeedForSalePostsBar.f22121b = a;
    }

    public final void mo758a(Object obj) {
        this.f22122c = (FetchGroupInformationModel) obj;
    }

    public GroupsFeedForSalePostsBar(Context context) {
        this(context, null);
    }

    private GroupsFeedForSalePostsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2131626078);
        Class cls = GroupsFeedForSalePostsBar.class;
        m23226a(this, getContext());
        View.inflate(context, 2130904710, this);
        ((FbButton) c(2131562761)).setOnClickListener(new C31841(this));
    }
}
