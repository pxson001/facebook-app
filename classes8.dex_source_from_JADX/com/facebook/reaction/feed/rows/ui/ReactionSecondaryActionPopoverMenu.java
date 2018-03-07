package com.facebook.reaction.feed.rows.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.Assisted;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIcon;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIconProvider;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: android_local_set_search_module */
public class ReactionSecondaryActionPopoverMenu<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends PopoverMenuWindow {
    private final PopoverMenuItemWithUriIconProvider f19492l;
    public final ReactionActionHandler f19493m;

    @Inject
    public ReactionSecondaryActionPopoverMenu(@Assisted E e, @Assisted List<ReactionStoryAttachmentActionFragment> list, @Assisted String str, @Assisted String str2, @Assisted String str3, PopoverMenuItemWithUriIconProvider popoverMenuItemWithUriIconProvider, ReactionActionHandler reactionActionHandler) {
        super(((HasContext) e).getContext());
        this.f19492l = popoverMenuItemWithUriIconProvider;
        this.f19493m = reactionActionHandler;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CharSequence charSequence;
            final ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) it.next();
            PopoverMenuItemWithUriIcon a = this.f19492l.m11632a(c(), reactionStoryAttachmentActionFragmentModel.fU_() == null ? null : reactionStoryAttachmentActionFragmentModel.fU_().a());
            a.m11631a(reactionStoryAttachmentActionFragmentModel.d() == null ? null : reactionStoryAttachmentActionFragmentModel.d().b());
            if (reactionStoryAttachmentActionFragmentModel.g() == null) {
                charSequence = null;
            } else {
                charSequence = reactionStoryAttachmentActionFragmentModel.g().a();
            }
            a.a(charSequence);
            final E e2 = e;
            final String str4 = str;
            final String str5 = str3;
            final String str6 = str2;
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ ReactionSecondaryActionPopoverMenu f19491f;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    e2.mo695a(str4, str6, this.f19491f.f19493m.m22678a(reactionStoryAttachmentActionFragmentModel, ((HasContext) e2).getContext(), null, ((HasReactionSession) e2).mo704p().f18658a, ((HasReactionSession) e2).mo704p().f18660c, str4, str5, str6));
                    return true;
                }
            });
            c().a(a);
        }
        a(true);
    }
}
