package com.facebook.events.permalink.invitefriends;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: birthday_click_suggested_photo_button */
public class EventPermalinkInviteFriendsView extends CustomRelativeLayout implements OnClickListener {
    @Inject
    @IsWorkBuild
    public Boolean f18589a;
    private Event f18590b;
    private ActionItemInvite f18591c;

    private static <T extends View> void m18917a(Class<T> cls, T t) {
        m18918a((Object) t, t.getContext());
    }

    private static void m18918a(Object obj, Context context) {
        ((EventPermalinkInviteFriendsView) obj).f18589a = Boolean_IsWorkBuildMethodAutoProvider.a(FbInjector.get(context));
    }

    public EventPermalinkInviteFriendsView(Context context) {
        super(context);
        m18915a();
    }

    public EventPermalinkInviteFriendsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18915a();
    }

    public EventPermalinkInviteFriendsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18915a();
    }

    private void m18915a() {
        m18917a(EventPermalinkInviteFriendsView.class, (View) this);
        setContentView(2130904077);
        if (this.f18589a.booleanValue()) {
            ((FbTextView) a(2131561362)).setText(2131236965);
        }
        setOnClickListener(this);
    }

    public final void m18919a(Event event, ActionItemInvite actionItemInvite) {
        this.f18590b = event;
        this.f18591c = actionItemInvite;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1400542420);
        if (this.f18591c != null) {
            this.f18591c.m18367a(this.f18590b, ActionMechanism.PERMALINK_ACTION_BAR.toString());
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1249279625, a);
    }

    private void m18916a(Boolean bool) {
        this.f18589a = bool;
    }
}
