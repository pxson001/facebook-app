package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.device.ScreenUtil;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.graphql.EventsGraphQLInterfaces.UserInEventFragment;
import com.facebook.events.model.Event;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileGridView;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: bodyProps */
public class EventGuestTileRowView extends FacepileGridView {
    @Inject
    EventsConnectionExperimentController f18497b;
    @Inject
    ScreenUtil f18498c;
    @Inject
    @LoggedInUser
    Provider<User> f18499d;
    private final List<Face> f18500e;
    private Event f18501f;
    private boolean f18502g;

    private static <T extends View> void m18827a(Class<T> cls, T t) {
        m18828a((Object) t, t.getContext());
    }

    private static void m18828a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventGuestTileRowView) obj).m18826a(EventsConnectionExperimentController.a(fbInjector), ScreenUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 3595));
    }

    private void m18826a(EventsConnectionExperimentController eventsConnectionExperimentController, ScreenUtil screenUtil, Provider<User> provider) {
        this.f18497b = eventsConnectionExperimentController;
        this.f18498c = screenUtil;
        this.f18499d = provider;
    }

    public EventGuestTileRowView(Context context) {
        this(context, null);
    }

    public EventGuestTileRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EventGuestTileRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18500e = Lists.a();
        m18827a(EventGuestTileRowView.class, (View) this);
    }

    public final void m18833a(Event event, ImmutableList<UserInEventFragment> immutableList, ImmutableList<UserInEventFragment> immutableList2) {
        boolean z;
        int i = 0;
        if (!Event.a(event) || 1 == 0) {
            z = false;
        } else {
            z = true;
        }
        this.f18502g = z;
        this.f18500e.clear();
        this.f18501f = event;
        int min = Math.min(getMaxFacesOnScreen(), (immutableList.size() + 1) + immutableList2.size());
        if (min == 0) {
            setFaces(null);
            return;
        }
        int i2;
        this.f18500e.add(getViewerFace());
        int size = immutableList.size();
        for (i2 = 0; i2 < size; i2++) {
            UserInEventFragment userInEventFragment = (UserInEventFragment) immutableList.get(i2);
            if (this.f18500e.size() >= min) {
                break;
            }
            Face a = m18824a(userInEventFragment);
            if (a != null) {
                this.f18500e.add(a);
            }
        }
        size = immutableList2.size();
        for (i2 = 0; i2 < size; i2++) {
            userInEventFragment = (UserInEventFragment) immutableList2.get(i2);
            if (this.f18500e.size() >= min) {
                break;
            }
            if (this.f18502g) {
                a = m18831c(userInEventFragment);
                if (a != null) {
                    this.f18500e.add(a);
                }
            } else {
                a = m18830b(userInEventFragment);
                if (a != null) {
                    this.f18500e.add(a);
                }
            }
        }
        List list = this.f18500e;
        if (!m18834a()) {
            i = 1;
        }
        super.setFaces(list.subList(i, this.f18500e.size()));
        requestLayout();
    }

    public final boolean m18834a() {
        if (this.f18502g) {
            if (this.f18501f.C == GraphQLEventWatchStatus.GOING || this.f18501f.C == GraphQLEventWatchStatus.WATCHED) {
                return true;
            }
            return false;
        } else if (this.f18501f.D() == GraphQLEventGuestStatus.GOING || this.f18501f.D() == GraphQLEventGuestStatus.MAYBE) {
            return true;
        } else {
            return false;
        }
    }

    public final void m18832a(Event event) {
        int i = 0;
        if (!this.f18502g || event == null || event.C != this.f18501f.C) {
            if (event == null || event.D() != this.f18501f.D()) {
                this.f18501f = event;
                if (!this.f18500e.isEmpty()) {
                    this.f18500e.set(0, getViewerFace());
                    List list = this.f18500e;
                    if (!m18834a()) {
                        i = 1;
                    }
                    super.setFaces(list.subList(i, this.f18500e.size()));
                    requestLayout();
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int min = Math.min(this.f18500e.size() - (m18834a() ? 0 : 1), m18823a(m18829b(i)));
        if (min > 0) {
            setNumCols(min);
        }
        super.onMeasure(i, i2);
    }

    private Drawable getMaybeBadge() {
        Drawable mutate = getResources().getDrawable(2130840757).mutate();
        mutate.setLevel(getResources().getInteger(2131492921));
        return mutate;
    }

    private Drawable getGoingBadge() {
        Drawable mutate = getResources().getDrawable(2130840757).mutate();
        mutate.setLevel(getResources().getInteger(2131492920));
        return mutate;
    }

    private int getMaxFacesOnScreen() {
        return m18823a(Math.max(this.f18498c.c(), this.f18498c.d()));
    }

    private int m18829b(int i) {
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                return MeasureSpec.getSize(i);
            case 0:
                return this.f18498c.c();
            default:
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
        }
    }

    private Face getViewerFace() {
        User user = (User) this.f18499d.get();
        if (user == null) {
            return null;
        }
        if (this.f18502g && Event.a(this.f18501f)) {
            GraphQLEventWatchStatus graphQLEventWatchStatus = this.f18501f.C;
            if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                return m18825a(user.x(), 255, getGoingBadge());
            }
            if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
                return m18825a(user.x(), 255, null);
            }
        }
        GraphQLEventGuestStatus D = this.f18501f.D();
        if (D == GraphQLEventGuestStatus.GOING) {
            return m18825a(user.x(), 255, getGoingBadge());
        }
        if (D == GraphQLEventGuestStatus.MAYBE) {
            return m18825a(user.x(), 127, getMaybeBadge());
        }
        return null;
    }

    private Face m18824a(UserInEventFragment userInEventFragment) {
        DefaultImageFields d = userInEventFragment.d();
        if (d == null) {
            return null;
        }
        return m18825a(d.b(), 255, getGoingBadge());
    }

    private Face m18830b(UserInEventFragment userInEventFragment) {
        DefaultImageFields d = userInEventFragment.d();
        if (d == null) {
            return null;
        }
        return m18825a(d.b(), 127, getMaybeBadge());
    }

    private static Face m18831c(UserInEventFragment userInEventFragment) {
        DefaultImageFields d = userInEventFragment.d();
        if (d == null) {
            return null;
        }
        return m18825a(d.b(), 255, null);
    }

    private static Face m18825a(String str, int i, Drawable drawable) {
        if (str == null) {
            return null;
        }
        return new Face(Uri.parse(str), drawable, 1, 1, i);
    }

    private int m18823a(int i) {
        int i2 = this.l;
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        if (paddingLeft <= 0 || paddingLeft < i2) {
            return 0;
        }
        return ((paddingLeft - i2) / (i2 + this.f)) + 1;
    }
}
