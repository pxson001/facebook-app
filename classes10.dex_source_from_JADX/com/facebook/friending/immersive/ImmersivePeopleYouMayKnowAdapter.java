package com.facebook.friending.immersive;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.immersive.ImmersivePeopleYouMayKnowLoadingState.LoadingState;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingButtonControllerWithCallback;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: addUniversalFeedbackToken */
public class ImmersivePeopleYouMayKnowAdapter extends Adapter<ViewHolder> {
    public static final CallerContext f20206a = CallerContext.a(ImmersivePeopleYouMayKnowAdapter.class);
    public final FriendshipStatusChangedEventSubscriber f20207b = new C28691(this);
    public final PYMKBlacklistedEventSubscriber f20208c = new C28702(this);
    public Type f20209d = Type.GRID;
    public final List<PersonYouMayKnow> f20210e = new ArrayList();
    private final AllCapsTransformationMethod f20211f;
    public final Context f20212g;
    public final FbUriIntentHandler f20213h;
    public final FriendingButtonControllerWithCallback f20214i;
    public final FriendingClient f20215j;
    public final FriendingEventBus f20216k;
    private final GlyphColorizer f20217l;
    private final Resources f20218m;
    private final ImmersivePeopleYouMayKnowLoadingState f20219n;
    private final OnClickListener f20220o;

    /* compiled from: addUniversalFeedbackToken */
    class C28691 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ ImmersivePeopleYouMayKnowAdapter f20179a;

        C28691(ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter) {
            this.f20179a = immersivePeopleYouMayKnowAdapter;
        }

        public final void m20494b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && friendshipStatusChangedEvent.b != null) {
                int a = ImmersivePeopleYouMayKnowAdapter.m20498a(this.f20179a, friendshipStatusChangedEvent.a);
                if (a != -1) {
                    PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) this.f20179a.f20210e.get(a);
                    if (personYouMayKnow.f() != friendshipStatusChangedEvent.b) {
                        personYouMayKnow.f = null;
                        personYouMayKnow.b(friendshipStatusChangedEvent.b);
                        this.f20179a.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    class C28702 extends PYMKBlacklistedEventSubscriber {
        final /* synthetic */ ImmersivePeopleYouMayKnowAdapter f20180a;

        C28702(ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter) {
            this.f20180a = immersivePeopleYouMayKnowAdapter;
        }

        public final void m20495b(FbEvent fbEvent) {
            PYMKBlacklistedEvent pYMKBlacklistedEvent = (PYMKBlacklistedEvent) fbEvent;
            if (pYMKBlacklistedEvent != null) {
                int a = ImmersivePeopleYouMayKnowAdapter.m20498a(this.f20180a, pYMKBlacklistedEvent.a);
                if (a != -1) {
                    this.f20180a.f20210e.remove(a);
                    this.f20180a.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public class C28713 extends SpanSizeLookup {
        final /* synthetic */ ImmersivePeopleYouMayKnowAdapter f20181b;

        public C28713(ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter) {
            this.f20181b = immersivePeopleYouMayKnowAdapter;
        }

        public final int m20496a(int i) {
            if (ImmersivePeopleYouMayKnowAdapter.m20505j(this.f20181b) && i == this.f20181b.f20210e.size()) {
                return 2;
            }
            return 1;
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public /* synthetic */ class C28767 {
        public static final /* synthetic */ int[] f20192a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f20192a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20192a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20192a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20192a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public class ErrorViewHolder extends ViewHolder {
        public View f20193l;
        public TextView f20194m;
        public ImageWithTextView f20195n;

        public ErrorViewHolder(View view) {
            super(view);
            this.f20193l = view;
            this.f20194m = (TextView) view.findViewById(2131563532);
            this.f20195n = (ImageWithTextView) view.findViewById(2131563533);
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public class PersonYouMayKnowCardViewHolder extends ViewHolder {
        public final FbDraweeView f20196l;
        public final TextView f20197m;
        public final TextView f20198n;
        public final SmartButtonLite f20199o;
        public final SmartButtonLite f20200p;

        public PersonYouMayKnowCardViewHolder(View view) {
            super(view);
            this.f20196l = (FbDraweeView) view.findViewById(2131565859);
            this.f20197m = (TextView) view.findViewById(2131565860);
            this.f20198n = (TextView) view.findViewById(2131565861);
            this.f20199o = (SmartButtonLite) view.findViewById(2131565863);
            this.f20200p = (SmartButtonLite) view.findViewById(2131565862);
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public class PersonYouMayKnowGridViewHolder extends ViewHolder {
        public final FbDraweeView f20201l;
        public final TextView f20202m;
        public final TextView f20203n;
        public final SmartButtonLite f20204o;
        public final ImageView f20205p;

        public PersonYouMayKnowGridViewHolder(View view) {
            super(view);
            this.f20201l = (FbDraweeView) view.findViewById(2131565859);
            this.f20202m = (TextView) view.findViewById(2131565860);
            this.f20203n = (TextView) view.findViewById(2131565861);
            this.f20204o = (SmartButtonLite) view.findViewById(2131565863);
            this.f20205p = (ImageView) view.findViewById(2131565864);
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public class ProgressBarViewHolder extends ViewHolder {
        public ProgressBarViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: addUniversalFeedbackToken */
    public enum Type {
        GRID,
        CARD
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: addUniversalFeedbackToken */
    public @interface ViewType {
    }

    @Inject
    public ImmersivePeopleYouMayKnowAdapter(AllCapsTransformationMethod allCapsTransformationMethod, Context context, FbUriIntentHandler fbUriIntentHandler, FriendingButtonControllerWithCallback friendingButtonControllerWithCallback, FriendingClient friendingClient, FriendingEventBus friendingEventBus, GlyphColorizer glyphColorizer, Resources resources, ImmersivePeopleYouMayKnowLoadingState immersivePeopleYouMayKnowLoadingState, @Assisted OnClickListener onClickListener) {
        this.f20211f = allCapsTransformationMethod;
        this.f20212g = context;
        this.f20213h = fbUriIntentHandler;
        this.f20214i = friendingButtonControllerWithCallback;
        this.f20215j = friendingClient;
        this.f20216k = friendingEventBus;
        this.f20217l = glyphColorizer;
        this.f20218m = resources;
        this.f20219n = immersivePeopleYouMayKnowLoadingState;
        this.f20220o = onClickListener;
    }

    public int getItemViewType(int i) {
        if (i != this.f20210e.size()) {
            return this.f20209d == Type.GRID ? 0 : 1;
        } else {
            if (this.f20219n.f20241a == LoadingState.LOADING) {
                return 2;
            }
            return 3;
        }
    }

    public final ViewHolder m20506a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new PersonYouMayKnowGridViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906183, viewGroup, false));
            case 1:
                return new PersonYouMayKnowCardViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906182, viewGroup, false));
            case 2:
                return new ProgressBarViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130904845, viewGroup, false));
            case 3:
                return new ErrorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130905113, viewGroup, false));
            default:
                throw new IllegalArgumentException("Not a supported ViewType");
        }
    }

    public final void m20507a(ViewHolder viewHolder, int i) {
        PersonYouMayKnow personYouMayKnow;
        if (viewHolder instanceof PersonYouMayKnowGridViewHolder) {
            PersonYouMayKnowGridViewHolder personYouMayKnowGridViewHolder = (PersonYouMayKnowGridViewHolder) viewHolder;
            personYouMayKnow = (PersonYouMayKnow) this.f20210e.get(i);
            m20501a(personYouMayKnowGridViewHolder.f20201l, personYouMayKnow);
            m20500a(personYouMayKnowGridViewHolder.f20202m, personYouMayKnow);
            m20504b(personYouMayKnowGridViewHolder.f20203n, personYouMayKnow);
            m20502a(personYouMayKnowGridViewHolder.f20204o, personYouMayKnow, i);
            m20499a(personYouMayKnowGridViewHolder.f20205p, personYouMayKnow, i);
        } else if (viewHolder instanceof PersonYouMayKnowCardViewHolder) {
            PersonYouMayKnowCardViewHolder personYouMayKnowCardViewHolder = (PersonYouMayKnowCardViewHolder) viewHolder;
            personYouMayKnow = (PersonYouMayKnow) this.f20210e.get(i);
            m20501a(personYouMayKnowCardViewHolder.f20196l, personYouMayKnow);
            m20500a(personYouMayKnowCardViewHolder.f20197m, personYouMayKnow);
            m20504b(personYouMayKnowCardViewHolder.f20198n, personYouMayKnow);
            m20502a(personYouMayKnowCardViewHolder.f20199o, personYouMayKnow, i);
            m20499a(personYouMayKnowCardViewHolder.f20200p, personYouMayKnow, i);
        } else if (viewHolder instanceof ErrorViewHolder) {
            ErrorViewHolder errorViewHolder = (ErrorViewHolder) viewHolder;
            errorViewHolder.f20194m.setText(2131230761);
            errorViewHolder.f20195n.setText(2131230764);
            errorViewHolder.f20193l.setOnClickListener(this.f20220o);
        }
    }

    public final int aZ_() {
        return (m20505j(this) ? 1 : 0) + this.f20210e.size();
    }

    public final void m20509a(List<PersonYouMayKnow> list) {
        this.f20210e.addAll(list);
        notifyDataSetChanged();
    }

    public final void m20508a(Type type) {
        this.f20209d = type;
        notifyDataSetChanged();
    }

    public static boolean m20505j(ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter) {
        return immersivePeopleYouMayKnowAdapter.f20219n.f20241a == LoadingState.LOADING || immersivePeopleYouMayKnowAdapter.f20219n.f20241a == LoadingState.ERROR;
    }

    private static void m20501a(FbDraweeView fbDraweeView, PersonYouMayKnow personYouMayKnow) {
        fbDraweeView.a(Uri.parse(personYouMayKnow.d()), f20206a);
        fbDraweeView.setContentDescription(personYouMayKnow.b());
    }

    private void m20500a(TextView textView, final PersonYouMayKnow personYouMayKnow) {
        textView.setText(personYouMayKnow.b());
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImmersivePeopleYouMayKnowAdapter f20183b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1051459866);
                this.f20183b.f20213h.a(this.f20183b.f20212g, StringFormatUtil.a(FBLinks.aX, new Object[]{Long.valueOf(personYouMayKnow.a())}));
                Logger.a(2, EntryType.UI_INPUT_END, 1904485596, a);
            }
        });
    }

    private void m20504b(TextView textView, PersonYouMayKnow personYouMayKnow) {
        int e = personYouMayKnow.e();
        switch (C28767.f20192a[personYouMayKnow.f().ordinal()]) {
            case 1:
                textView.setVisibility(0);
                textView.setText(2131233219);
                return;
            case 2:
                textView.setVisibility(0);
                textView.setText(2131233222);
                return;
            case 3:
                if (personYouMayKnow.f == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                    textView.setVisibility(0);
                    textView.setText(2131233220);
                    return;
                }
                break;
        }
        if (e > 0) {
            textView.setVisibility(0);
            textView.setText(this.f20218m.getQuantityString(2131689520, e, new Object[]{Integer.valueOf(e)}));
            return;
        }
        textView.setVisibility(8);
    }

    private void m20502a(SmartButtonLite smartButtonLite, final PersonYouMayKnow personYouMayKnow, final int i) {
        final GraphQLFriendshipStatus f = personYouMayKnow.f();
        switch (C28767.f20192a[f.ordinal()]) {
            case 1:
                m20503a(smartButtonLite, this.f20211f.getTransformation(this.f20218m.getString(2131233214), null), this.f20211f.getTransformation(this.f20218m.getString(2131230727), null), this.f20218m.getColor(2131362106), this.f20209d == Type.GRID ? 2130840354 : 2130840353, 2130839891);
                break;
            case 2:
                m20503a(smartButtonLite, this.f20211f.getTransformation(this.f20218m.getString(2131233209), null), null, this.f20218m.getColor(2131362106), this.f20209d == Type.GRID ? 2130840354 : 2130840353, 2130839883);
                break;
            case 3:
            case 4:
                m20503a(smartButtonLite, this.f20211f.getTransformation(this.f20218m.getString(2131233212), null), this.f20211f.getTransformation(this.f20218m.getString(2131233213), null), this.f20218m.getColor(2131361920), this.f20209d == Type.GRID ? 2130840350 : 2130840349, 2130840447);
                break;
            default:
                smartButtonLite.setVisibility(8);
                break;
        }
        smartButtonLite.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImmersivePeopleYouMayKnowAdapter f20188d;

            /* compiled from: addUniversalFeedbackToken */
            class C28731 implements FriendingButtonControllerCallback {
                final /* synthetic */ C28745 f20184a;

                C28731(C28745 c28745) {
                    this.f20184a = c28745;
                }

                public final void m20497a() {
                    personYouMayKnow.f = null;
                    personYouMayKnow.b(f);
                    this.f20184a.f20188d.notifyDataSetChanged();
                }
            }

            public void onClick(View view) {
                GraphQLFriendshipStatus graphQLFriendshipStatus;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -858886385);
                FriendingButtonControllerWithCallback friendingButtonControllerWithCallback = this.f20188d.f20214i;
                long a2 = personYouMayKnow.a();
                personYouMayKnow.b();
                friendingButtonControllerWithCallback.a(a2, FriendingLocation.FRIENDS_CENTER_SUGGESTIONS, f, new C28731(this));
                personYouMayKnow.f = f;
                PersonYouMayKnow personYouMayKnow = personYouMayKnow;
                switch (C28767.f20192a[f.ordinal()]) {
                    case 1:
                        graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
                        break;
                    case 2:
                        graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
                        break;
                    case 3:
                        graphQLFriendshipStatus = GraphQLFriendshipStatus.OUTGOING_REQUEST;
                        break;
                    case 4:
                        graphQLFriendshipStatus = GraphQLFriendshipStatus.ARE_FRIENDS;
                        break;
                    default:
                        graphQLFriendshipStatus = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                        break;
                }
                personYouMayKnow.b(graphQLFriendshipStatus);
                this.f20188d.j_(i);
                Logger.a(2, EntryType.UI_INPUT_END, -10949085, a);
            }
        });
    }

    private void m20499a(View view, PersonYouMayKnow personYouMayKnow, final int i) {
        if (this.f20209d != Type.GRID) {
            switch (C28767.f20192a[personYouMayKnow.f().ordinal()]) {
                case 3:
                case 4:
                    view.setVisibility(0);
                    m20503a((SmartButtonLite) view, this.f20211f.getTransformation(this.f20218m.getString(2131233211), null), null, this.f20218m.getColor(2131362106), 2130840353, 2130839818);
                    break;
                default:
                    view.setVisibility(8);
                    break;
            }
        }
        ((ImageView) view).setImageDrawable(this.f20217l.a(2130839816, this.f20218m.getColor(2131361920)));
        final long a = personYouMayKnow.a();
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImmersivePeopleYouMayKnowAdapter f20191c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1099869026);
                this.f20191c.f20215j.a(a, ImmersivePeopleYouMayKnowAdapter.f20206a);
                this.f20191c.f20210e.remove(i);
                this.f20191c.l_(i);
                this.f20191c.a(i, this.f20191c.aZ_());
                this.f20191c.f20216k.a(new PYMKBlacklistedEvent(a));
                Logger.a(2, EntryType.UI_INPUT_END, 477382984, a);
            }
        });
    }

    private void m20503a(SmartButtonLite smartButtonLite, CharSequence charSequence, CharSequence charSequence2, @ColorInt int i, @DrawableRes int i2, @DrawableRes int i3) {
        smartButtonLite.a(charSequence, charSequence2);
        smartButtonLite.setBackgroundResource(i2);
        smartButtonLite.setTextColor(i);
        smartButtonLite.setImageDrawable(this.f20217l.a(i3, i));
    }

    public static int m20498a(ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter, long j) {
        int size = immersivePeopleYouMayKnowAdapter.f20210e.size();
        for (int i = 0; i < size; i++) {
            if (((PersonYouMayKnow) immersivePeopleYouMayKnowAdapter.f20210e.get(i)).a() == j) {
                return i;
            }
        }
        return -1;
    }
}
