package com.facebook.uberbar.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.SearchTypeaheadResultBuilder;
import com.facebook.uberbar.ui.UberbarResultsFragment.C06754;
import com.facebook.uberbar.ui.UberbarResultsFragment.C06765;
import com.facebook.uberbar.ui.UberbarResultsFragment.C06786;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import javax.inject.Provider;

/* compiled from: nearby_places_is_initial_load */
public class UberbarResultView extends CustomRelativeLayout {
    private static final CallerContext f5122a = CallerContext.a(UberbarResultView.class);
    public TextView f5123b = ((TextView) a(2131568161));
    public TextView f5124c = ((TextView) a(2131568162));
    public FbDraweeView f5125d = ((FbDraweeView) a(2131568159));
    public ImageView f5126e = ((ImageView) a(2131568160));
    public Resources f5127f;
    public OnClickListener f5128g;
    public OnClickListener f5129h;
    public OnClickListener f5130i;
    public Provider<Boolean> f5131j;
    public FriendingEventBus f5132k;
    public SearchTypeaheadResult f5133l;
    public int f5134m;
    public String f5135n;
    public String f5136o;
    public String f5137p;
    public String f5138q;
    public String f5139r;
    public C06765 f5140s;
    public C06754 f5141t;
    public C06786 f5142u;

    /* compiled from: nearby_places_is_initial_load */
    public class C06681 implements OnClickListener {
        final /* synthetic */ UberbarResultView f5116a;

        public C06681(UberbarResultView uberbarResultView) {
            this.f5116a = uberbarResultView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -197270503);
            if (this.f5116a.f5141t != null) {
                C06754 c06754 = this.f5116a.f5141t;
                SearchTypeaheadResult searchTypeaheadResult = this.f5116a.f5133l;
                int i = this.f5116a.f5134m;
                c06754.f5146a.as.a(searchTypeaheadResult, c06754.f5146a.aw, c06754.f5146a.an.f5101d, i);
                c06754.f5146a.au.a(searchTypeaheadResult.m, searchTypeaheadResult.k, FriendingLocation.SEARCH, searchTypeaheadResult.c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1695430243, a);
        }
    }

    /* compiled from: nearby_places_is_initial_load */
    public class C06692 implements OnClickListener {
        final /* synthetic */ UberbarResultView f5117a;

        public C06692(UberbarResultView uberbarResultView) {
            this.f5117a = uberbarResultView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -273593547);
            if (this.f5117a.f5140s != null) {
                C06765 c06765 = this.f5117a.f5140s;
                SearchTypeaheadResult searchTypeaheadResult = this.f5117a.f5133l;
                int i = this.f5117a.f5134m;
                String b = searchTypeaheadResult.b();
                if (b != null) {
                    c06765.f5147a.as.b(searchTypeaheadResult, c06765.f5147a.aw, c06765.f5147a.an.f5101d, i);
                    UberbarResultsFragment.m6401b(c06765.f5147a, c06765.f5147a.getContext(), "tel:" + b, null);
                } else {
                    c06765.f5147a.ar.a("NullPointerException", "Ubersearch: Tried calling a person with no phone numbers");
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -855515691, a);
        }
    }

    /* compiled from: nearby_places_is_initial_load */
    public class C06703 implements OnClickListener {
        final /* synthetic */ UberbarResultView f5118a;

        public C06703(UberbarResultView uberbarResultView) {
            this.f5118a = uberbarResultView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -494271532);
            if (this.f5118a.f5142u != null) {
                this.f5118a.f5142u.m6400a(this.f5118a.f5133l, this.f5118a.f5134m);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1864382327, a);
        }
    }

    /* compiled from: nearby_places_is_initial_load */
    public /* synthetic */ class C06714 {
        public static final /* synthetic */ int[] f5119a = new int[GraphQLFriendshipStatus.values().length];
        public static final /* synthetic */ int[] f5120b = new int[Type.values().length];

        static {
            try {
                f5120b[Type.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5120b[Type.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5120b[Type.APP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5120b[Type.GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5120b[Type.EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5119a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5119a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5119a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5119a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: nearby_places_is_initial_load */
    public class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ UberbarResultView f5121a;

        public FriendshipStatusChangedEventSubscriber(UberbarResultView uberbarResultView) {
            this.f5121a = uberbarResultView;
        }

        public final void m6393b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && this.f5121a.f5133l != null && friendshipStatusChangedEvent.a == this.f5121a.f5133l.m) {
                SearchTypeaheadResult searchTypeaheadResult = this.f5121a.f5133l;
                SearchTypeaheadResultBuilder searchTypeaheadResultBuilder = new SearchTypeaheadResultBuilder();
                searchTypeaheadResultBuilder.a = searchTypeaheadResult.a;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.c = searchTypeaheadResult.b;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.b = searchTypeaheadResult.c;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.d = searchTypeaheadResult.d;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.e = searchTypeaheadResult.e;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f = searchTypeaheadResult.f;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.g = searchTypeaheadResult.g;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.h = searchTypeaheadResult.h;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.i = searchTypeaheadResult.i;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.j = searchTypeaheadResult.j;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.k = searchTypeaheadResult.k;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.l = searchTypeaheadResult.l;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.m = searchTypeaheadResult.m;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.q = searchTypeaheadResult.q;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.n = searchTypeaheadResult.n;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.o = searchTypeaheadResult.o;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.r = searchTypeaheadResult.r;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.s = searchTypeaheadResult.s;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.t = searchTypeaheadResult.t;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder.a(Boolean.valueOf(searchTypeaheadResult.p));
                searchTypeaheadResultBuilder.u = searchTypeaheadResult.u;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.v = searchTypeaheadResult.v;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.w = searchTypeaheadResult.w;
                SearchTypeaheadResultBuilder searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder2.b = friendshipStatusChangedEvent.b;
                this.f5121a.m6395a(searchTypeaheadResultBuilder2.a());
            }
        }
    }

    public static void m6394a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        UberbarResultView uberbarResultView = (UberbarResultView) obj;
        Provider a = IdBasedProvider.a(fbInjector, 4356);
        FriendingEventBus a2 = FriendingEventBus.a(fbInjector);
        uberbarResultView.f5131j = a;
        uberbarResultView.f5132k = a2;
    }

    public UberbarResultView(Context context) {
        super(context, null, 0);
        Class cls = UberbarResultView.class;
        m6394a(this, getContext());
        setContentView(2130907589);
        this.f5127f = context.getResources();
        this.f5135n = context.getString(2131236538);
        this.f5136o = context.getString(2131236539);
        this.f5137p = context.getString(2131233212);
        this.f5138q = context.getString(2131236540);
        this.f5139r = context.getString(2131236541);
        this.f5128g = new C06681(this);
        this.f5129h = new C06692(this);
        this.f5130i = new C06703(this);
        a(new FriendshipStatusChangedEventSubscriber(this));
    }

    public final UberbarResultView m6395a(SearchTypeaheadResult searchTypeaheadResult) {
        String string;
        this.f5133l = searchTypeaheadResult;
        this.f5123b.setText(searchTypeaheadResult.k);
        Joiner skipNulls = Joiner.on(this.f5127f.getString(2131236534)).skipNulls();
        switch (C06714.f5120b[searchTypeaheadResult.l.ordinal()]) {
            case 1:
                switch (C06714.f5119a[searchTypeaheadResult.c.ordinal()]) {
                    case 4:
                        string = this.f5127f.getString(2131233219);
                        break;
                    default:
                        string = searchTypeaheadResult.g;
                        break;
                }
                string = skipNulls.join(Strings.emptyToNull(string), Strings.emptyToNull(searchTypeaheadResult.a), new Object[0]);
                break;
            case 2:
                string = skipNulls.join(Strings.emptyToNull(this.f5127f.getString(2131236537)), Strings.emptyToNull(searchTypeaheadResult.g), new Object[0]);
                break;
            case 3:
                string = skipNulls.join(Strings.emptyToNull(searchTypeaheadResult.a), Strings.emptyToNull(searchTypeaheadResult.g), new Object[0]);
                break;
            case 4:
                string = skipNulls.join(Strings.emptyToNull(this.f5127f.getString(2131236536)), Strings.emptyToNull(searchTypeaheadResult.g), new Object[0]);
                break;
            case 5:
                string = skipNulls.join(Strings.emptyToNull(this.f5127f.getString(2131236535)), Strings.emptyToNull(searchTypeaheadResult.g), new Object[0]);
                break;
            default:
                string = "";
                break;
        }
        CharSequence obj = Html.fromHtml(string).toString();
        this.f5124c.setText(obj);
        if (StringUtil.a(obj)) {
            this.f5124c.setVisibility(8);
        } else {
            this.f5124c.setVisibility(0);
        }
        this.f5125d.a(searchTypeaheadResult.f, f5122a);
        switch (C06714.f5120b[searchTypeaheadResult.l.ordinal()]) {
            case 1:
                switch (C06714.f5119a[searchTypeaheadResult.c.ordinal()]) {
                    case 1:
                        if (searchTypeaheadResult.b() == null) {
                            this.f5126e.setVisibility(8);
                            break;
                        }
                        this.f5126e.setImageResource(2130843774);
                        this.f5126e.setContentDescription(this.f5139r);
                        this.f5126e.setOnClickListener(this.f5129h);
                        this.f5126e.setVisibility(0);
                        break;
                    case 2:
                    case 3:
                        this.f5126e.setImageResource(2130843770);
                        this.f5126e.setContentDescription(this.f5137p);
                        this.f5126e.setVisibility(0);
                        this.f5126e.setOnClickListener(this.f5128g);
                        break;
                    case 4:
                        this.f5126e.setOnClickListener(this.f5128g);
                        this.f5126e.setImageResource(2130843773);
                        this.f5126e.setContentDescription(this.f5138q);
                        this.f5126e.setVisibility(0);
                        break;
                    default:
                        this.f5126e.setVisibility(8);
                        break;
                }
            case 2:
                if (!((Boolean) this.f5131j.get()).booleanValue()) {
                    this.f5126e.setVisibility(8);
                    break;
                }
                if (searchTypeaheadResult.x) {
                    this.f5126e.setImageResource(2130843780);
                    this.f5126e.setContentDescription(this.f5136o);
                } else {
                    this.f5126e.setImageResource(2130843779);
                    this.f5126e.setContentDescription(this.f5135n);
                }
                this.f5126e.setOnClickListener(this.f5130i);
                this.f5126e.setVisibility(0);
                break;
            default:
                this.f5126e.setVisibility(8);
                break;
        }
        if (searchTypeaheadResult.n) {
            this.f5123b.setCompoundDrawablesWithIntrinsicBounds(null, null, this.f5127f.getDrawable(2130843782), null);
            this.f5123b.setContentDescription(getResources().getString(2131236542, new Object[]{searchTypeaheadResult.k}));
        } else {
            this.f5123b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        return this;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setTouchDelegate(TouchDelegateUtils.a(this.f5126e, 12));
        }
    }

    protected /* bridge */ /* synthetic */ FbEventBus getEventBus() {
        return this.f5132k;
    }
}
