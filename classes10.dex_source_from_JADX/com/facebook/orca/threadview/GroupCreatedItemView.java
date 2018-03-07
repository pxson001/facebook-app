package com.facebook.orca.threadview;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.threadview.rows.RowGroupCreatedItem;
import com.facebook.orca.threadview.MessageListAdapter.C10752;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: min_viewability_duration */
public class GroupCreatedItemView extends CustomViewGroup {
    public TextView f6941a;
    public ImageView f6942b;
    @Nullable
    public DefaultThreadViewTheme f6943c;
    @Nullable
    public C10752 f6944d;
    public Provider<Boolean> f6945e;
    public final OnClickListener f6946f = new C10441(this);
    public final OnClickListener f6947g = new C10452(this);
    private RowGroupCreatedItem f6948h;

    /* compiled from: min_viewability_duration */
    class C10441 implements OnClickListener {
        final /* synthetic */ GroupCreatedItemView f6939a;

        C10441(GroupCreatedItemView groupCreatedItemView) {
            this.f6939a = groupCreatedItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 71186239);
            if (this.f6939a.f6944d != null) {
                C10752 c10752 = this.f6939a.f6944d;
                if (c10752.f7166a.f7175A != null) {
                    c10752.f7166a.f7175A.mo306h();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 937040566, a);
        }
    }

    /* compiled from: min_viewability_duration */
    class C10452 implements OnClickListener {
        final /* synthetic */ GroupCreatedItemView f6940a;

        C10452(GroupCreatedItemView groupCreatedItemView) {
            this.f6940a = groupCreatedItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -576467914);
            if (this.f6940a.f6944d != null) {
                C10752 c10752 = this.f6940a.f6944d;
                if (c10752.f7166a.f7175A != null) {
                    c10752.f7166a.f7175A.mo307i();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1506726763, a);
        }
    }

    public static void m6563a(Object obj, Context context) {
        ((GroupCreatedItemView) obj).f6945e = IdBasedProvider.a(FbInjector.get(context), 4100);
    }

    public GroupCreatedItemView(Context context) {
        super(context);
        Class cls = GroupCreatedItemView.class;
        m6563a(this, getContext());
        setContentView(2130905698);
        this.f6941a = (TextView) getView(2131564435);
        this.f6942b = (ImageView) getView(2131564862);
    }

    public void setThreadViewTheme(DefaultThreadViewTheme defaultThreadViewTheme) {
        this.f6943c = defaultThreadViewTheme;
        if (this.f6948h != null) {
            m6562a(this.f6948h.f4730a);
        }
    }

    public final void m6564a(RowGroupCreatedItem rowGroupCreatedItem) {
        this.f6948h = rowGroupCreatedItem;
        m6562a(rowGroupCreatedItem.f4730a);
        this.f6942b.setVisibility(((Boolean) this.f6945e.get()).booleanValue() ? 0 : 8);
    }

    private void m6562a(Message message) {
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(new ImageSpan(getContext(), ContextUtils.b(getContext(), 2130773150, 0)), 33);
        styledStringBuilder.a(" ");
        styledStringBuilder.a();
        styledStringBuilder.a(" ");
        styledStringBuilder.a(message.f);
        if (((Boolean) this.f6945e.get()).booleanValue()) {
            styledStringBuilder.a(" ");
            styledStringBuilder.a(new ForegroundColorSpan(this.f6943c != null ? this.f6943c.e() : getResources().getColor(2131362241)), 33);
            styledStringBuilder.a(2131231796);
            styledStringBuilder.a();
            this.f6941a.setClickable(true);
        } else {
            this.f6941a.setClickable(false);
        }
        this.f6941a.setText(styledStringBuilder.b());
    }
}
