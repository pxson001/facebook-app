package com.facebook.messaging.composer.triggers;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.bots.model.BotCommand;
import com.facebook.messaging.bots.model.BotCommand.ImageCrop;
import com.facebook.messaging.composer.triggers.MentionsSearchController.C11491.C11481;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_inbox_item_attachment */
public class MentionsSearchResultsAdapter extends Adapter<MentionsSearchResultsViewHolder> {
    private final Resources f9909a;
    private final LayoutInflater f9910b;
    private List<BotCommand> f9911c;
    private List<User> f9912d;
    public C11481 f9913e;
    private final OnClickListener f9914f = new C11551(this);

    /* compiled from: messenger_inbox_item_attachment */
    class C11551 implements OnClickListener {
        final /* synthetic */ MentionsSearchResultsAdapter f9907a;

        C11551(MentionsSearchResultsAdapter mentionsSearchResultsAdapter) {
            this.f9907a = mentionsSearchResultsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -935556065);
            Object tag = view.getTag();
            if (tag instanceof BotCommand) {
                BotCommand botCommand = (BotCommand) tag;
                if (this.f9907a.f9913e != null) {
                    MentionsSearchController mentionsSearchController = this.f9907a.f9913e.f9867a.f9868a;
                    Editable o = MentionsSearchController.m10456o(mentionsSearchController);
                    o.replace(0, o.length(), botCommand.f8328a + ' ');
                    if (botCommand.f8331d) {
                        MentionsSearchController.m10447c(mentionsSearchController, false);
                    }
                }
            } else if (tag instanceof User) {
                User user = (User) tag;
                if (this.f9907a.f9913e != null) {
                    this.f9907a.f9913e.m10432a(user);
                }
            }
            LogUtils.a(-72680692, a);
        }
    }

    /* compiled from: messenger_inbox_item_attachment */
    enum RowType {
        BOT_COMMAND_HEADER(0),
        BOT_COMMAND(1),
        USER_HEADER(0),
        USER(1);
        
        public final int viewType;

        private RowType(int i) {
            this.viewType = i;
        }
    }

    public final void m10466a(ViewHolder viewHolder, int i) {
        View view = ((MentionsSearchResultsViewHolder) viewHolder).a;
        Object f = m10464f(i);
        MentionsSearchResultItemView mentionsSearchResultItemView;
        switch (m10463e(i)) {
            case BOT_COMMAND_HEADER:
                m10462a((FbTextView) view, ((BotCommand) f).f8329b);
                return;
            case BOT_COMMAND:
                mentionsSearchResultItemView = (MentionsSearchResultItemView) view;
                BotCommand botCommand = (BotCommand) f;
                mentionsSearchResultItemView.setTitle(botCommand.f8329b);
                mentionsSearchResultItemView.setSubtitle(botCommand.f8330c);
                mentionsSearchResultItemView.m10461a(botCommand.f8335h, botCommand.f8332e == ImageCrop.CIRCLE);
                mentionsSearchResultItemView.setTag(botCommand);
                mentionsSearchResultItemView.setContentDescription(botCommand.f8329b);
                return;
            case USER_HEADER:
                m10462a((FbTextView) view, this.f9909a.getString(2131241120));
                return;
            case USER:
                mentionsSearchResultItemView = (MentionsSearchResultItemView) view;
                User user = (User) f;
                mentionsSearchResultItemView.setTitle(user.j());
                mentionsSearchResultItemView.setSubtitle(null);
                mentionsSearchResultItemView.m10461a(user.x(), true);
                mentionsSearchResultItemView.setTag(user);
                mentionsSearchResultItemView.setContentDescription(user.j());
                return;
            default:
                return;
        }
    }

    @Inject
    public MentionsSearchResultsAdapter(Resources resources, LayoutInflater layoutInflater) {
        this.f9909a = resources;
        this.f9910b = layoutInflater;
        this.f9911c = RegularImmutableList.a;
        this.f9912d = RegularImmutableList.a;
    }

    public final void m10467a(@Nullable List<BotCommand> list, @Nullable List<User> list2) {
        if (list == null) {
            list = RegularImmutableList.a;
        }
        this.f9911c = list;
        if (list2 == null) {
            list2 = RegularImmutableList.a;
        }
        this.f9912d = list2;
        notifyDataSetChanged();
    }

    public final ViewHolder m10465a(ViewGroup viewGroup, int i) {
        View inflate;
        switch (i) {
            case 0:
                inflate = this.f9910b.inflate(2130905215, viewGroup, false);
                break;
            case 1:
                inflate = new MentionsSearchResultItemView(viewGroup.getContext());
                inflate.setOnClickListener(this.f9914f);
                break;
            default:
                throw new IllegalStateException("Unsupported view Mentions search result view type");
        }
        inflate.setLayoutParams(new LayoutParams(-1, -2));
        return new MentionsSearchResultsViewHolder(inflate);
    }

    public int getItemViewType(int i) {
        return m10463e(i).viewType;
    }

    private RowType m10463e(int i) {
        Object f = m10464f(i);
        if (i < this.f9911c.size()) {
            Object obj;
            if (((BotCommand) f).f8328a == null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return RowType.BOT_COMMAND_HEADER;
            }
            return RowType.BOT_COMMAND;
        } else if (i == this.f9911c.size()) {
            return RowType.USER_HEADER;
        } else {
            return RowType.USER;
        }
    }

    private Object m10464f(int i) {
        if (i < this.f9911c.size()) {
            return this.f9911c.get(i);
        }
        if (i == this.f9911c.size()) {
            return null;
        }
        return this.f9912d.get((i - this.f9911c.size()) - 1);
    }

    private static void m10462a(TextView textView, String str) {
        textView.setText(str);
        textView.setContentDescription(str);
    }

    public final int aZ_() {
        return (!this.f9912d.isEmpty() ? this.f9912d.size() + 1 : 0) + this.f9911c.size();
    }
}
