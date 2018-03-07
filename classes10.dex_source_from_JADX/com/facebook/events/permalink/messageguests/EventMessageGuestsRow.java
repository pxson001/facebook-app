package com.facebook.events.permalink.messageguests;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.SeenCheckmarkImageSpan;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.fbui.widget.contentview.CheckedContentView.Position;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: before_threads */
public class EventMessageGuestsRow extends CheckedContentView {
    public static SeenCheckmarkImageSpan f18674j;
    @Inject
    public GlyphColorizer f18675h;
    @Inject
    public Resources f18676i;

    public static void m18980a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventMessageGuestsRow eventMessageGuestsRow = (EventMessageGuestsRow) obj;
        GlyphColorizer a = GlyphColorizer.a(fbInjector);
        Resources a2 = ResourcesMethodAutoProvider.a(fbInjector);
        eventMessageGuestsRow.f18675h = a;
        eventMessageGuestsRow.f18676i = a2;
    }

    public EventMessageGuestsRow(Context context) {
        super(context);
        Class cls = EventMessageGuestsRow.class;
        m18980a((Object) this, getContext());
        int dimensionPixelSize = this.f18676i.getDimensionPixelSize(2131431247);
        int dimensionPixelSize2 = this.f18676i.getDimensionPixelSize(2131431271);
        setThumbnailSize(ThumbnailSize.SMALL);
        setMaxLinesFromThumbnailSize(false);
        e(1, 1);
        setPadding(dimensionPixelSize2, dimensionPixelSize, 0, dimensionPixelSize);
        setCheckMarkPosition(Position.START);
        Drawable a = this.f18675h.a(2130839774, -7235677);
        a.setBounds(0, 0, this.f18676i.getDimensionPixelSize(2131431141), this.f18676i.getDimensionPixelSize(2131431141));
        f18674j = new SeenCheckmarkImageSpan(a, this.f18676i.getDimensionPixelSize(2131431140));
    }

    public final void m18981a(EventUser eventUser, EventGuestListType eventGuestListType) {
        setTitleText(eventUser.c);
        if (eventGuestListType == EventGuestListType.PRIVATE_INVITED && eventUser.i == GraphQLEventSeenState.SEEN) {
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append("[checkmark_placeholder]");
            spannableStringBuilder.setSpan(f18674j, 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append(this.f18676i.getString(2131237087));
            setSubtitleText(spannableStringBuilder);
        }
        setThumbnailUri(eventUser.i());
        setChecked(eventUser.k);
    }
}
