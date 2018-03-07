package com.facebook.groups.widget.groupeventrow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.events.model.Event;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: THREADLIST */
public class GroupEventSocialContextView extends FbTextView {
    @Inject
    public DefaultGroupEventRowViewManager f23256a;

    private static <T extends View> void m24591a(Class<T> cls, T t) {
        m24592a((Object) t, t.getContext());
    }

    private static void m24592a(Object obj, Context context) {
        ((GroupEventSocialContextView) obj).f23256a = DefaultGroupEventRowViewManager.m24559a(FbInjector.get(context));
    }

    public GroupEventSocialContextView(Context context) {
        super(context);
        m24590a();
    }

    public GroupEventSocialContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24590a();
    }

    public GroupEventSocialContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24590a();
    }

    private void m24590a() {
        m24591a(GroupEventSocialContextView.class, (View) this);
        setTextColor(this.f23256a.f23204a.getColor(17170444));
    }

    public final void m24594a(Event event) {
        GraphQLEventGuestStatus D = event.D();
        CharSequence a;
        if (D == GraphQLEventGuestStatus.INVITED) {
            setVisibility(0);
            if (!Strings.isNullOrEmpty(event.an())) {
                setText(getContext().getString(2131242104, new Object[]{r0}));
            } else if (Strings.isNullOrEmpty(event.t)) {
                a = m24589a(event, null);
                if (StringUtil.a(a)) {
                    setVisibility(8);
                } else {
                    setText(a);
                }
            } else {
                setText(m24593b(event));
            }
        } else if (D == GraphQLEventGuestStatus.NOT_GOING) {
            setVisibility(8);
        } else if (D == GraphQLEventGuestStatus.GOING) {
            setVisibility(0);
            setText(m24589a(event, getResources().getString(2131242107)));
        } else if (D == GraphQLEventGuestStatus.MAYBE) {
            setVisibility(0);
            setText(m24589a(event, getContext().getString(2131242105)));
        } else if (D == GraphQLEventGuestStatus.HOST) {
            setVisibility(0);
            setText(2131242103);
        } else if (event.D) {
            setVisibility(0);
            setText(2131242106);
        } else {
            a = m24589a(event, null);
            if (StringUtil.a(a)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            setText(a);
        }
    }

    private String m24589a(Event event, String str) {
        if (!Strings.isNullOrEmpty(event.an())) {
            return getContext().getString(2131242104, new Object[]{event.an()});
        } else if (event.ad > 0) {
            if (event.ad == 1) {
                return getContext().getString(2131242112, new Object[]{event.ac});
            }
            return getContext().getResources().getQuantityString(2131689814, event.ad - 1, new Object[]{event.ac, Integer.valueOf(event.ad - 1)});
        } else if (event.af > 0) {
            if (event.af == 1) {
                return getContext().getString(2131242111, new Object[]{event.ae});
            }
            return getContext().getResources().getQuantityString(2131689813, event.af - 1, new Object[]{event.ae, Integer.valueOf(event.af - 1)});
        } else if (Strings.isNullOrEmpty(event.t)) {
            return str == null ? "" : str;
        } else {
            return m24593b(event);
        }
    }

    private String m24593b(Event event) {
        return getContext().getString(2131242110, new Object[]{event.t});
    }
}
