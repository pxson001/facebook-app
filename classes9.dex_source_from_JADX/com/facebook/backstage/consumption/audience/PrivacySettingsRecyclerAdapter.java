package com.facebook.backstage.consumption.audience;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.data.AudienceControlData;
import com.facebook.backstage.data.BackstageUser;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: rpt_a */
public class PrivacySettingsRecyclerAdapter extends BaseAwesomizerAdapter<AudienceControlData> {
    private static final CallerContext f4679e = CallerContext.a(PrivacySettingsRecyclerAdapter.class);
    @Inject
    public BackstageAnalyticsLogger f4680d;
    public final C04681 f4681f = new C04681(this);
    public final Set<String> f4682g = new HashSet();
    public final Set<String> f4683h = new HashSet();
    public ImmutableList<AudienceControlData> f4684i;
    public Set<String> f4685j;

    /* compiled from: rpt_a */
    public class C04681 {
        public final /* synthetic */ PrivacySettingsRecyclerAdapter f4677a;

        C04681(PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter) {
            this.f4677a = privacySettingsRecyclerAdapter;
        }

        public final void m4572b() {
            int size = this.f4677a.f4684i.size();
            for (int i = 0; i < size; i++) {
                PrivacySettingsRecyclerAdapter.m4573a(this.f4677a, ((AudienceControlData) this.f4677a.f4684i.get(i)).f5103a, false);
            }
            this.f4677a.f4680d.m4264a(Event.AUDIENCE_DESELECT_ALL);
            this.f4677a.notifyDataSetChanged();
        }
    }

    @Inject
    public PrivacySettingsRecyclerAdapter(AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, BackstageAnalyticsLogger backstageAnalyticsLogger) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f4680d = backstageAnalyticsLogger;
    }

    public final void m4579a(ImmutableList<AudienceControlData> immutableList, Set<String> set) {
        this.f4684i = immutableList;
        this.f4685j = set;
        this.f4682g.clear();
        this.f4683h.clear();
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return 2;
        }
        return 1;
    }

    public final ViewHolder m4576a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130906401, viewGroup, false)) {
                final /* synthetic */ PrivacySettingsRecyclerAdapter f4678l;
            };
        }
        return i == 1 ? new PrivacySettingsActionPanel(LayoutInflater.from(viewGroup.getContext()).inflate(2130906400, viewGroup, false), this.f4681f) : m4580c(viewGroup);
    }

    protected final ViewHolderItem m4580c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130906402, viewGroup, false));
    }

    protected final String m4581g() {
        return "";
    }

    public final void m4577a(ViewHolder viewHolder, int i) {
        if (i == 1) {
            PrivacySettingsActionPanel privacySettingsActionPanel = (PrivacySettingsActionPanel) viewHolder;
            int h = m4582h();
            privacySettingsActionPanel.f4673n = h < this.f4684i.size();
            privacySettingsActionPanel.f4671l.setText(privacySettingsActionPanel.f4671l.getResources().getQuantityString(2131689748, h, new Object[]{Integer.valueOf(h)}));
            privacySettingsActionPanel.f4672m.setText(privacySettingsActionPanel.f4672m.getResources().getString(privacySettingsActionPanel.f4673n ? 2131239913 : 2131239914));
        } else if (viewHolder instanceof ViewHolderItem) {
            BackstageUser h2 = m4575h(i);
            PrivacySettingsItemView privacySettingsItemView = (PrivacySettingsItemView) ((ViewHolderItem) viewHolder).l;
            privacySettingsItemView.setAvatarNameViewText(h2.f5100a);
            privacySettingsItemView.a(h2.f5101b, f4679e);
            String str = h2.f5103a;
            boolean z = false;
            if (!this.f4683h.contains(str) && (this.f4685j.contains(str) || this.f4682g.contains(str))) {
                z = true;
            }
            privacySettingsItemView.setSelected(z);
        }
    }

    public final int m4582h() {
        return (this.f4685j.size() + this.f4682g.size()) - this.f4683h.size();
    }

    public final void m4578a(View view, int i) {
        PrivacySettingsItemView privacySettingsItemView = (PrivacySettingsItemView) view;
        privacySettingsItemView.setSelected(!privacySettingsItemView.isSelected());
        m4573a(this, m4575h(i).f5103a, privacySettingsItemView.isSelected());
        j_(1);
    }

    public static void m4573a(PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter, String str, boolean z) {
        if (z) {
            if (privacySettingsRecyclerAdapter.f4685j.contains(str)) {
                privacySettingsRecyclerAdapter.f4683h.remove(str);
            } else {
                privacySettingsRecyclerAdapter.f4682g.add(str);
            }
        } else if (privacySettingsRecyclerAdapter.f4685j.contains(str)) {
            privacySettingsRecyclerAdapter.f4683h.add(str);
        } else {
            privacySettingsRecyclerAdapter.f4682g.remove(str);
        }
    }

    public final int aZ_() {
        return this.f4684i == null ? 0 : this.f4684i.size() + 2;
    }

    private AudienceControlData m4575h(int i) {
        if (this.f4684i != null) {
            return (AudienceControlData) this.f4684i.get(i - 2);
        }
        return null;
    }

    public static int m4574e(int i, int i2) {
        return (i == 0 || i == 1) ? i2 : 1;
    }
}
