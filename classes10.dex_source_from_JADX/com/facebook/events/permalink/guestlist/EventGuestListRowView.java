package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.forcemessenger.ForceMessengerHandler;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bool[] */
public class EventGuestListRowView extends ContentViewWithButton {
    public static SeenCheckmarkImageSpan f18448o;
    @Nullable
    private static Drawable f18449p;
    @Nullable
    private static Drawable f18450q;
    @Inject
    EventPermalinkController f18451h;
    @Inject
    ForceMessengerHandler f18452i;
    @Inject
    FriendingButtonController f18453j;
    @Inject
    public GlyphColorizer f18454k;
    @Inject
    public Resources f18455l;
    @Inject
    SecureContextHelper f18456m;
    @Inject
    EventGuestListManagementControllerProvider f18457n;
    private String f18458r;
    public EventUser f18459s;
    public EventGuestListType f18460t;
    private EventActionContext f18461u;
    public EventGuestListFragment f18462v;
    private ImmutableList<EventGuestSingleListModel> f18463w;
    public EventGuestListManagementController f18464x;

    /* compiled from: bool[] */
    public class C26151 implements OnClickListener {
        final /* synthetic */ EventGuestListRowView f18434a;

        public C26151(EventGuestListRowView eventGuestListRowView) {
            this.f18434a = eventGuestListRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -485380434);
            if (this.f18434a.f18459s != null) {
                this.f18434a.f18451h.m18268a(this.f18434a.getContext(), this.f18434a.f18459s);
                if (this.f18434a.f18462v != null) {
                    EventGuestListFragment eventGuestListFragment = this.f18434a.f18462v;
                    eventGuestListFragment.am++;
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -25436328, a);
        }
    }

    /* compiled from: bool[] */
    class C26173 implements OnClickListener {
        final /* synthetic */ EventGuestListRowView f18437a;

        C26173(EventGuestListRowView eventGuestListRowView) {
            this.f18437a = eventGuestListRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 563061025);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("sms:" + PhoneNumberUtil.normalize(this.f18437a.f18459s.f)));
            this.f18437a.f18456m.b(Intent.createChooser(intent, this.f18437a.f18455l.getString(2131237098)), this.f18437a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 228260252, a);
        }
    }

    /* compiled from: bool[] */
    class C26184 implements OnClickListener {
        final /* synthetic */ EventGuestListRowView f18438a;

        C26184(EventGuestListRowView eventGuestListRowView) {
            this.f18438a = eventGuestListRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -465402246);
            this.f18438a.f18452i.a(this.f18438a.f18459s.b, "events");
            if (this.f18438a.f18462v != null) {
                EventGuestListFragment eventGuestListFragment = this.f18438a.f18462v;
                eventGuestListFragment.ao++;
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1450966604, a);
        }
    }

    /* compiled from: bool[] */
    /* synthetic */ class C26247 {
        static final /* synthetic */ int[] f18447a = new int[EventGuestListType.values().length];

        static {
            try {
                f18447a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18447a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18447a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m18784a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventGuestListRowView) obj).m18781a(EventPermalinkController.m18262b(injectorLike), ForceMessengerHandler.b(injectorLike), FriendingButtonController.b(injectorLike), GlyphColorizer.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (EventGuestListManagementControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventGuestListManagementControllerProvider.class));
    }

    public EventGuestListRowView(Context context) {
        super(context);
        Class cls = EventGuestListRowView.class;
        m18784a((Object) this, getContext());
        setThumbnailSize(ThumbnailSize.LARGE);
        setActionButtonTheme(Theme.NONE);
        setOnClickListener(new C26151(this));
        Drawable a = this.f18454k.a(2130839774, -7235677);
        a.setBounds(0, 0, this.f18455l.getDimensionPixelSize(2131431141), this.f18455l.getDimensionPixelSize(2131431141));
        f18448o = new SeenCheckmarkImageSpan(a, this.f18455l.getDimensionPixelSize(2131431140));
    }

    private Drawable m18780a(EventUserType eventUserType) {
        if (eventUserType == EventUserType.EMAIL_SYNTHETIC) {
            if (f18449p != null) {
                return f18449p.getConstantState().newDrawable();
            }
        } else if (eventUserType != EventUserType.SMS_SYNTHETIC) {
            throw new IllegalArgumentException("Synthetic Guest Profile Photo doesn't exist for this User Type");
        } else if (f18450q != null) {
            return f18450q.getConstantState().newDrawable();
        }
        float dimension = this.f18455l.getDimension(2131431324);
        float dimension2 = this.f18455l.getDimension(2131431325);
        this.f18454k.a(eventUserType == EventUserType.EMAIL_SYNTHETIC ? 2130839845 : 2130839805, -1).setBounds(0, 0, (int) dimension2, (int) dimension2);
        int i = ((int) (dimension - dimension2)) / 2;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setBounds(0, 0, (int) dimension, (int) dimension);
        shapeDrawable.getPaint().setColor(this.f18455l.getColor(2131362101));
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, r4});
        layerDrawable.setLayerInset(1, i, i, i, i);
        if (eventUserType == EventUserType.EMAIL_SYNTHETIC) {
            f18449p = layerDrawable;
        } else {
            f18450q = layerDrawable;
        }
        return layerDrawable.getConstantState().newDrawable();
    }

    public final void m18788a(String str, EventUser eventUser, EventGuestListType eventGuestListType, EventGuestListType eventGuestListType2, EventActionContext eventActionContext, boolean z, ImmutableList<EventGuestSingleListModel> immutableList, String str2) {
        this.f18458r = str;
        EventUser eventUser2 = this.f18459s;
        this.f18460t = eventGuestListType;
        this.f18461u = eventActionContext;
        this.f18459s = eventUser;
        this.f18463w = immutableList;
        this.f18464x = this.f18457n.m18741a(this.f18458r, this.f18460t, this.f18463w, this.f18461u, ActionMechanism.GUEST_LIST_EDIT_GUEST_RSVP);
        if (eventUser2 == null || !Objects.equal(this.f18459s.e(), eventUser2.e())) {
            this.f18459s = eventUser;
            setThumbnailUri(this.f18459s.i());
            setTitleText(this.f18459s.d());
        }
        if (this.f18459s.c() == EventUserType.EMAIL_USER) {
            setupEmailActionButton(str2);
        } else if (this.f18459s.c() == EventUserType.SMS_USER) {
            m18785h();
        } else {
            m18783a(this.f18459s.k(), z, this.f18459s.m());
        }
        setupSubtitle(this.f18459s);
        if (eventGuestListType2 == this.f18460t) {
            m18787j();
            return;
        }
        m18786i(this);
        m18782a(this, this.f18460t);
    }

    public CharSequence getContentDescription() {
        if (this.f18459s != null) {
            return this.f18459s.c;
        }
        return super.getContentDescription();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 167421050);
        super.onAttachedToWindow();
        this.f18453j.d = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2022869767, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 198260835);
        this.f18453j.d = true;
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -228855688, a);
    }

    private void setupEmailActionButton(final String str) {
        setActionButtonDrawable(this.f18454k.a(2130839845, -4341303));
        setActionButtonContentDescription(getResources().getString(2131237096));
        setEnableActionButton(true);
        setActionButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventGuestListRowView f18436b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -184380432);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/html");
                intent.putExtra("android.intent.extra.SUBJECT", str);
                intent.putExtra("android.intent.extra.EMAIL", new String[]{this.f18436b.f18459s.e});
                this.f18436b.f18456m.b(Intent.createChooser(intent, this.f18436b.getResources().getString(2131237098)), this.f18436b.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1338901475, a);
            }
        });
        setShowActionButton(true);
    }

    private void m18781a(EventPermalinkController eventPermalinkController, ForceMessengerHandler forceMessengerHandler, FriendingButtonController friendingButtonController, GlyphColorizer glyphColorizer, Resources resources, SecureContextHelper secureContextHelper, EventGuestListManagementControllerProvider eventGuestListManagementControllerProvider) {
        this.f18451h = eventPermalinkController;
        this.f18452i = forceMessengerHandler;
        this.f18453j = friendingButtonController;
        this.f18454k = glyphColorizer;
        this.f18455l = resources;
        this.f18456m = secureContextHelper;
        this.f18457n = eventGuestListManagementControllerProvider;
    }

    private void m18785h() {
        setActionButtonDrawable(this.f18454k.a(2130839805, -4341303));
        setActionButtonContentDescription(getResources().getString(2131237097));
        setEnableActionButton(true);
        setActionButtonOnClickListener(new C26173(this));
        setShowActionButton(true);
    }

    private void m18783a(final GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z, final boolean z2) {
        if (graphQLFriendshipStatus == null || graphQLFriendshipStatus == GraphQLFriendshipStatus.CANNOT_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            setShowActionButton(false);
            return;
        }
        EventGuestListGuestButtonType eventGuestListButton = EventGuestListGuestButtonType.getEventGuestListButton(graphQLFriendshipStatus, z);
        if (eventGuestListButton == null) {
            setShowActionButton(false);
            return;
        }
        int guestButtonDrawableResId = eventGuestListButton.getGuestButtonDrawableResId();
        int guestButtonColorResId = eventGuestListButton.getGuestButtonColorResId();
        int guestButtonDescriptionResId = eventGuestListButton.getGuestButtonDescriptionResId();
        setActionButtonDrawable(this.f18454k.a(guestButtonDrawableResId, guestButtonColorResId));
        setActionButtonContentDescription(getResources().getString(guestButtonDescriptionResId));
        setEnableActionButton(true);
        if (eventGuestListButton == EventGuestListGuestButtonType.MESSAGE) {
            setActionButtonOnClickListener(new C26184(this));
        } else if (eventGuestListButton == EventGuestListGuestButtonType.EDIT) {
            setActionButtonOnClickListener(new OnClickListener(this) {
                public final /* synthetic */ EventGuestListRowView f18444b;

                /* compiled from: bool[] */
                public class C26202 implements DialogInterface.OnClickListener {
                    final /* synthetic */ C26225 f18441a;

                    public C26202(C26225 c26225) {
                        this.f18441a = c26225;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }

                /* compiled from: bool[] */
                public class C26213 implements DialogInterface.OnClickListener {
                    final /* synthetic */ C26225 f18442a;

                    public C26213(C26225 c26225) {
                        this.f18442a = c26225;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        EventGuestListRowView.m18786i(this.f18442a.f18444b);
                        EventGuestListRowView.m18782a(this.f18442a.f18444b, null);
                        this.f18442a.f18444b.f18464x.m18739a(this.f18442a.f18444b.f18459s);
                        this.f18442a.f18444b.f18462v.m18713a(this.f18442a.f18444b.f18459s, null);
                        dialogInterface.dismiss();
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1392307620);
                    Context context = this.f18444b.getContext();
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
                    BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(context);
                    m18779a(bottomSheetAdapter, 2131237151, 2130839920, null);
                    if (this.f18444b.f18460t != EventGuestListType.PRIVATE_GOING && z2) {
                        m18779a(bottomSheetAdapter, 2131233837, 2130839848, EventGuestListType.PRIVATE_GOING);
                    }
                    if (this.f18444b.f18460t != EventGuestListType.PRIVATE_MAYBE && z2) {
                        m18779a(bottomSheetAdapter, 2131233838, 2130839852, EventGuestListType.PRIVATE_MAYBE);
                    }
                    if (this.f18444b.f18460t != EventGuestListType.PRIVATE_NOT_GOING) {
                        m18779a(bottomSheetAdapter, 2131233839, 2130839853, EventGuestListType.PRIVATE_NOT_GOING);
                    }
                    bottomSheetDialog.a(bottomSheetAdapter);
                    bottomSheetDialog.show();
                    Logger.a(2, EntryType.UI_INPUT_END, 1377748197, a);
                }

                private void m18779a(BottomSheetAdapter bottomSheetAdapter, int i, int i2, final EventGuestListType eventGuestListType) {
                    bottomSheetAdapter.e(i).setIcon(this.f18444b.f18454k.a(i2, -9801344)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ C26225 f18440b;

                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (eventGuestListType == null) {
                                C26225 c26225 = this.f18440b;
                                new Builder(c26225.f18444b.getContext()).a(2131237115).b(c26225.f18444b.getContext().getResources().getString(2131237116, new Object[]{c26225.f18444b.f18459s.c})).a(2131237117, new C26213(c26225)).b(2131237118, new C26202(c26225)).a(true).a().show();
                            } else {
                                EventGuestListRowView.m18786i(this.f18440b.f18444b);
                                EventGuestListRowView.m18782a(this.f18440b.f18444b, eventGuestListType);
                                this.f18440b.f18444b.f18464x.m18740a(this.f18440b.f18444b.f18459s, eventGuestListType);
                                this.f18440b.f18444b.f18462v.m18713a(this.f18440b.f18444b.f18459s, eventGuestListType);
                            }
                            return true;
                        }
                    });
                }
            });
        } else {
            setActionButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EventGuestListRowView f18446b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -411872388);
                    this.f18446b.setEnableActionButton(false);
                    this.f18446b.f18453j.a(Long.parseLong(this.f18446b.f18459s.b), this.f18446b.f18459s.c, FriendingLocation.EVENT_GYMK, graphQLFriendshipStatus);
                    if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && this.f18446b.f18462v != null) {
                        EventGuestListFragment eventGuestListFragment = this.f18446b.f18462v;
                        eventGuestListFragment.an++;
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 1117482964, a);
                }
            });
        }
        setShowActionButton(true);
    }

    private void setupSubtitle(EventUser eventUser) {
        EventUserType eventUserType = eventUser.a;
        if (eventUserType == EventUserType.EMAIL_SYNTHETIC) {
            setThumbnailDrawable(m18780a(eventUserType));
            setSubtitleText(this.f18455l.getString(2131237094));
            return;
        }
        String str;
        if (eventUserType == EventUserType.EMAIL_USER) {
            str = eventUser.e;
            if (!Objects.equal(str, eventUser.c)) {
                setSubtitleText(str);
                return;
            }
        } else if (eventUserType == EventUserType.SMS_SYNTHETIC) {
            setThumbnailDrawable(m18780a(eventUserType));
            setSubtitleText(this.f18455l.getString(2131237095));
            return;
        } else if (eventUserType == EventUserType.SMS_USER) {
            str = eventUser.f;
            if (!Objects.equal(str, eventUser.c)) {
                setSubtitleText(str);
                return;
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f18460t == EventGuestListType.PRIVATE_INVITED && eventUser.i == GraphQLEventSeenState.SEEN) {
            spannableStringBuilder.append("[checkmark_placeholder]");
            spannableStringBuilder.setSpan(f18448o, 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(this.f18455l.getString(2131237087));
        }
        int i = this.f18459s.g;
        if (eventUser.h == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append(" ⋅ ");
            }
            spannableStringBuilder.append(this.f18455l.getString(2131233219));
        } else if (eventUser.h != GraphQLFriendshipStatus.ARE_FRIENDS && i > 0) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append(" ⋅ ");
            }
            spannableStringBuilder.append(this.f18455l.getQuantityString(2131689674, i, new Object[]{Integer.valueOf(i)}));
        }
        setSubtitleText(spannableStringBuilder);
    }

    public static void m18786i(EventGuestListRowView eventGuestListRowView) {
        eventGuestListRowView.setAlpha(0.5f);
        eventGuestListRowView.setClickable(false);
        eventGuestListRowView.setEnableActionButton(false);
    }

    private void m18787j() {
        setAlpha(1.0f);
        setClickable(true);
        setEnableActionButton(true);
    }

    public static void m18782a(EventGuestListRowView eventGuestListRowView, EventGuestListType eventGuestListType) {
        eventGuestListRowView.f18460t = eventGuestListType;
        if (eventGuestListRowView.f18460t == null) {
            eventGuestListRowView.setSubtitleText(2131237099);
            return;
        }
        switch (C26247.f18447a[eventGuestListRowView.f18460t.ordinal()]) {
            case 1:
                eventGuestListRowView.setSubtitleText(2131237100);
                return;
            case 2:
                eventGuestListRowView.setSubtitleText(2131237101);
                return;
            case 3:
                eventGuestListRowView.setSubtitleText(2131237102);
                return;
            default:
                return;
        }
    }
}
