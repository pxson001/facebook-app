package com.facebook.notifications.settings.bottomsheet;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.action.NotificationsActionExecutor$1;
import com.facebook.notifications.logging.NotificationSettingsLogger;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionFragmentModel.OptionDisplayModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.base.Strings;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: minutiae_verb_picker_rendering_time */
public class NotificationBottomSheetAdapter extends Adapter<ViewHolder> {
    public final NotificationsActionExecutor f8759a;
    public final ArrayList<NotificationBottomSheetItem> f8760b;
    public final Context f8761c;
    public final GlyphColorizer f8762d;
    public final NotificationsActionExecutor$1 f8763e;
    public final String f8764f;
    public final NotificationSettingsLogger f8765g;
    public final NotificationsEdgeFields f8766h;
    public boolean f8767i = false;
    public String f8768j;
    public String f8769k;

    /* compiled from: minutiae_verb_picker_rendering_time */
    public class OptionRowViewHolder extends ViewHolder {
        public final /* synthetic */ NotificationBottomSheetAdapter f8755l;
        public CheckedContentView f8756m;

        /* compiled from: minutiae_verb_picker_rendering_time */
        public class C07061 implements OnClickListener {
            final /* synthetic */ NotificationBottomSheetItem f8753a;
            final /* synthetic */ OptionRowViewHolder f8754b;

            public C07061(OptionRowViewHolder optionRowViewHolder, NotificationBottomSheetItem notificationBottomSheetItem) {
                this.f8754b = optionRowViewHolder;
                this.f8753a = notificationBottomSheetItem;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -281493961);
                if (this.f8754b.f8755l.f8763e != null) {
                    this.f8754b.f8755l.f8763e.f8122a.dismiss();
                }
                if (this.f8754b.f8755l.f8766h == null) {
                    this.f8754b.f8755l.f8759a.a(this.f8754b.f8755l.f8761c, this.f8753a.f8771b, Surface.BOTTOM_SHEET, this.f8754b.f8755l.f8764f);
                } else if (this.f8753a.f8771b.mo461c().equals(this.f8754b.f8755l.f8768j)) {
                    this.f8754b.f8755l.f8765g.a(Surface.BOTTOM_SHEET, this.f8753a.f8771b.mo461c());
                    Logger.a(2, EntryType.UI_INPUT_END, 1381395093, a);
                    return;
                } else {
                    this.f8754b.f8755l.f8759a.a(this.f8754b.f8755l.f8761c, this.f8753a.f8771b, Surface.BOTTOM_SHEET, this.f8754b.f8755l.f8766h, this.f8754b.f8755l.f8768j, this.f8754b.f8755l.f8769k);
                }
                LogUtils.a(-1824479970, a);
            }
        }

        public OptionRowViewHolder(NotificationBottomSheetAdapter notificationBottomSheetAdapter, CheckedContentView checkedContentView) {
            this.f8755l = notificationBottomSheetAdapter;
            super(checkedContentView);
            this.f8756m = checkedContentView;
        }
    }

    /* compiled from: minutiae_verb_picker_rendering_time */
    public class TitleViewHolder extends ViewHolder {
        public TextWithEntitiesView f8757l;
        public TextWithEntitiesView f8758m;

        public TitleViewHolder(View view) {
            super(view);
            this.f8757l = (TextWithEntitiesView) view.findViewById(2131558927);
            this.f8758m = (TextWithEntitiesView) view.findViewById(2131558926);
        }
    }

    @Inject
    public NotificationBottomSheetAdapter(@Assisted NotifOptionSetFragment notifOptionSetFragment, @Assisted Context context, @Nullable @Assisted NotificationsEdgeFields notificationsEdgeFields, @Nullable @Assisted String str, @Assisted NotificationsActionExecutor$1 notificationsActionExecutor$1, NotificationsActionExecutor notificationsActionExecutor, GlyphColorizer glyphColorizer, NotificationSettingsLogger notificationSettingsLogger) {
        this.f8759a = notificationsActionExecutor;
        this.f8760b = new ArrayList();
        this.f8761c = context;
        this.f8766h = notificationsEdgeFields;
        this.f8764f = str;
        this.f8762d = glyphColorizer;
        this.f8765g = notificationSettingsLogger;
        this.f8763e = notificationsActionExecutor$1;
        m10719a(notifOptionSetFragment);
    }

    private void m10719a(NotifOptionSetFragment notifOptionSetFragment) {
        if (notifOptionSetFragment.mo467c() != null && notifOptionSetFragment.mo468d() != null) {
            this.f8768j = notifOptionSetFragment.mo468d().m10510b();
            if (!(notifOptionSetFragment.mo468d() == null || notifOptionSetFragment.mo468d().m10513g() == null || Strings.isNullOrEmpty(notifOptionSetFragment.mo468d().m10513g().a()))) {
                NotificationBottomSheetItem notificationBottomSheetItem = new NotificationBottomSheetItem(notifOptionSetFragment.mo468d().m10513g().a());
                if (notifOptionSetFragment.mo468d().m10512d() != null) {
                    notificationBottomSheetItem.f8772c = notifOptionSetFragment.mo468d().m10512d().a();
                }
                this.f8760b.add(notificationBottomSheetItem);
                this.f8767i = true;
            }
            for (int i = 0; i < notifOptionSetFragment.mo467c().mo464a().size(); i++) {
                Nodes nodes = (Nodes) notifOptionSetFragment.mo467c().mo464a().get(i);
                if (nodes.mo462d() != null) {
                    OptionDisplayModel d = nodes.mo462d();
                    if (d.m10463j() != null) {
                        NotificationBottomSheetItem notificationBottomSheetItem2 = new NotificationBottomSheetItem(d.m10463j().a());
                        if (d.m10462g() != null) {
                            notificationBottomSheetItem2.f8772c = d.m10462g().a();
                        }
                        notificationBottomSheetItem2.f8771b = nodes;
                        if (this.f8768j != null && this.f8768j.equals(nodes.mo461c())) {
                            notificationBottomSheetItem2.f8770a = true;
                            this.f8769k = nodes.gx_();
                        }
                        this.f8760b.add(notificationBottomSheetItem2);
                    }
                }
            }
        }
    }

    public final int aZ_() {
        return this.f8760b.size();
    }

    public int getItemViewType(int i) {
        if (this.f8767i && i == 0) {
            return 0;
        }
        return 1;
    }

    public final ViewHolder m10721a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f8761c);
        if (i == 0) {
            return new TitleViewHolder(from.inflate(2130905477, viewGroup, false));
        }
        if (i == 1) {
            return new OptionRowViewHolder(this, (CheckedContentView) from.inflate(2130905476, viewGroup, false));
        }
        throw new IllegalArgumentException("Invalid view type for binding view holder.");
    }

    public final void m10722a(ViewHolder viewHolder, int i) {
        NotificationBottomSheetItem e;
        if (viewHolder instanceof TitleViewHolder) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) viewHolder;
            e = m10720e(i);
            titleViewHolder.f8757l.setText(e.f8773d);
            titleViewHolder.f8758m.setText(e.f8772c);
        } else if (viewHolder instanceof OptionRowViewHolder) {
            OptionRowViewHolder optionRowViewHolder = (OptionRowViewHolder) viewHolder;
            e = m10720e(i);
            optionRowViewHolder.f8756m.setTitleText(e.f8773d);
            optionRowViewHolder.f8756m.setSubtitleText(e.f8772c);
            if (e.f8770a) {
                optionRowViewHolder.f8756m.setCheckMarkDrawable(optionRowViewHolder.f8755l.f8762d.a(2130839774, -10972929));
            } else {
                optionRowViewHolder.f8756m.setCheckMarkDrawable(null);
            }
            optionRowViewHolder.f8756m.setOnClickListener(new C07061(optionRowViewHolder, e));
        }
    }

    private NotificationBottomSheetItem m10720e(int i) {
        return (NotificationBottomSheetItem) this.f8760b.get(i);
    }
}
