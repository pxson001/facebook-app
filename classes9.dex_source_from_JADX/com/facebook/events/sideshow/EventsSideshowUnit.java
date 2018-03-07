package com.facebook.events.sideshow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.events.sideshow.EventsSideshowDataHolder.C29311;
import com.facebook.events.sideshow.FetchEventsAndBirthdaysRequest.C29361;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQuery.SideshowEventsBirthdaysQueryString;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

/* compiled from: TYPE_SFIXED32 */
public class EventsSideshowUnit implements SideshowUnit {
    private View f24435a;
    private View f24436b;
    private View f24437c;
    private View f24438d;
    private TextView f24439e;
    private TextView f24440f;
    public Context f24441g;
    public EventsSideshowDataHolder f24442h;
    public UriIntentMapper f24443i;

    /* compiled from: TYPE_SFIXED32 */
    class C29321 implements OnClickListener {
        final /* synthetic */ EventsSideshowUnit f24432a;

        C29321(EventsSideshowUnit eventsSideshowUnit) {
            this.f24432a = eventsSideshowUnit;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1549571213);
            EventsSideshowUnit eventsSideshowUnit = this.f24432a;
            if (eventsSideshowUnit.f24442h.m26282c() && !eventsSideshowUnit.f24442h.f24430c.isEmpty()) {
                ImmutableList immutableList = eventsSideshowUnit.f24442h.f24430c;
                Parcelable[] parcelableArr = (Parcelable[]) immutableList.toArray(new Parcelable[immutableList.size()]);
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("birthday_cards_fragment_arg", parcelableArr);
                BirthdayCardsDialogFragment birthdayCardsDialogFragment = (BirthdayCardsDialogFragment) Fragment.a(eventsSideshowUnit.f24441g, BirthdayCardsDialogFragment.class.getCanonicalName(), bundle);
                birthdayCardsDialogFragment.a(((FragmentActivity) eventsSideshowUnit.f24441g).kO_(), birthdayCardsDialogFragment.getClass().getName());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1812152324, a);
        }
    }

    /* compiled from: TYPE_SFIXED32 */
    class C29332 implements OnClickListener {
        final /* synthetic */ EventsSideshowUnit f24433a;

        C29332(EventsSideshowUnit eventsSideshowUnit) {
            this.f24433a = eventsSideshowUnit;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -664040989);
            EventsSideshowUnit eventsSideshowUnit = this.f24433a;
            eventsSideshowUnit.f24441g.startActivity(eventsSideshowUnit.f24443i.a(eventsSideshowUnit.f24441g, FBLinks.by));
            Logger.a(2, EntryType.UI_INPUT_END, -1787930601, a);
        }
    }

    /* compiled from: TYPE_SFIXED32 */
    public class C29343 {
        public final /* synthetic */ EventsSideshowUnit f24434a;

        C29343(EventsSideshowUnit eventsSideshowUnit) {
            this.f24434a = eventsSideshowUnit;
        }
    }

    public EventsSideshowUnit(EventsSideshowDataHolder eventsSideshowDataHolder, UriIntentMapper uriIntentMapper) {
        this.f24442h = eventsSideshowDataHolder;
        this.f24443i = uriIntentMapper;
    }

    public final View mo1139a(Context context, ViewGroup viewGroup) {
        this.f24441g = context;
        this.f24435a = LayoutInflater.from(context).inflate(2130907093, viewGroup);
        this.f24438d = this.f24435a.findViewById(2131567438);
        this.f24436b = this.f24435a.findViewById(2131567441);
        this.f24439e = (TextView) this.f24436b.findViewById(2131567442);
        this.f24437c = this.f24435a.findViewById(2131567439);
        this.f24440f = (TextView) this.f24437c.findViewById(2131567440);
        m26295e();
        return this.f24435a;
    }

    public final void mo1140a() {
        this.f24437c.setOnClickListener(new C29321(this));
        this.f24436b.setOnClickListener(new C29332(this));
    }

    public final void mo1142b() {
        this.f24437c.setOnClickListener(null);
        this.f24436b.setOnClickListener(null);
    }

    public final void mo1143c() {
        this.f24435a = null;
        this.f24436b = null;
        this.f24437c = null;
        this.f24439e = null;
        this.f24440f = null;
        this.f24441g = null;
    }

    public final void m26295e() {
        if (this.f24435a != null && this.f24442h.m26282c()) {
            Resources resources = this.f24441g.getResources();
            int i = this.f24442h.f24429b;
            if (i > 0) {
                this.f24436b.setVisibility(0);
                this.f24439e.setText(resources.getQuantityString(2131689798, i, new Object[]{Integer.valueOf(i)}));
            } else {
                this.f24436b.setVisibility(8);
            }
            ImmutableList immutableList = this.f24442h.f24430c;
            if (immutableList == null || immutableList.isEmpty()) {
                this.f24437c.setVisibility(8);
                return;
            }
            this.f24437c.setVisibility(0);
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, 2130843372);
            if (decodeResource != null) {
                CustomViewUtils.b(this.f24438d, new SimpleClippingBitmapDrawable(decodeResource, 53));
            }
            int size = immutableList.size();
            CharSequence l = ((BirthdayPersonModel) immutableList.get(0)).m26327l();
            if (size != 1) {
                l = resources.getQuantityString(2131689796, size, new Object[]{l, Integer.valueOf(size - 1)});
            }
            this.f24440f.setText(l);
        }
    }

    public final void mo1141a(Context context, 1 1) {
        EventsSideshowDataHolder eventsSideshowDataHolder = this.f24442h;
        eventsSideshowDataHolder.f24428a.a(new C29343(this));
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131433970);
        EventsSideshowDataHolder eventsSideshowDataHolder2 = this.f24442h;
        Preconditions.checkNotNull(1);
        FetchEventsAndBirthdaysRequest fetchEventsAndBirthdaysRequest = eventsSideshowDataHolder2.f24431d;
        long a = fetchEventsAndBirthdaysRequest.f24453c.a() + 604800;
        Futures.a(fetchEventsAndBirthdaysRequest.f24451a.a(GraphQLRequest.a((SideshowEventsBirthdaysQueryString) new SideshowEventsBirthdaysQueryString().a("profile_image_size", Integer.valueOf(dimensionPixelSize)).a("one_week_from_now", Long.valueOf(a)))), new C29361(fetchEventsAndBirthdaysRequest, new C29311(eventsSideshowDataHolder2, 1)), fetchEventsAndBirthdaysRequest.f24452b);
    }

    public final String mo1144d() {
        return "events";
    }
}
