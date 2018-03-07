package com.facebook.events.permalink.about;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.model.EventArtist;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: cancellation_reason */
public class EventArtistRowView extends CustomRelativeLayout {
    private static final CallerContext f17911d = CallerContext.a(EventArtistRowView.class);
    @Inject
    public NumberTruncationUtil f17912a;
    @Inject
    public Provider<IFeedIntentBuilder> f17913b;
    @Inject
    public SecureContextHelper f17914c;
    public FbDraweeView f17915e = ((FbDraweeView) a(2131559119));
    public FbTextView f17916f = ((FbTextView) a(2131558927));
    public FbTextView f17917g = ((FbTextView) a(2131558926));
    public EventArtist f17918h;
    public OnClickListener f17919i = new C25361(this);

    /* compiled from: cancellation_reason */
    public class C25361 implements OnClickListener {
        final /* synthetic */ EventArtistRowView f17910a;

        public C25361(EventArtistRowView eventArtistRowView) {
            this.f17910a = eventArtistRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1248526657);
            this.f17910a.f17914c.a(((IFeedIntentBuilder) this.f17910a.f17913b.get()).b(this.f17910a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, this.f17910a.f17918h.a)), this.f17910a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 199927036, a);
        }
    }

    public static void m18320a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventArtistRowView eventArtistRowView = (EventArtistRowView) obj;
        NumberTruncationUtil a = NumberTruncationUtil.a(fbInjector);
        Provider a2 = IdBasedSingletonScopeProvider.a(fbInjector, 2347);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        eventArtistRowView.f17912a = a;
        eventArtistRowView.f17913b = a2;
        eventArtistRowView.f17914c = secureContextHelper;
    }

    public EventArtistRowView(Context context) {
        super(context);
        Class cls = EventArtistRowView.class;
        m18320a(this, getContext());
        setContentView(2130903989);
    }

    private String m18322d(EventArtist eventArtist) {
        if (eventArtist.d) {
            return getContext().getString(2131237018, new Object[]{eventArtist.b});
        }
        String str;
        int i = eventArtist.e;
        if (i == 0) {
            str = null;
        } else {
            str = getContext().getResources().getQuantityString(2131689664, i, new Object[]{this.f17912a.a(i)});
        }
        return str;
    }

    public final void m18323a(EventArtist eventArtist) {
        this.f17918h = eventArtist;
        if (eventArtist.c != null) {
            this.f17915e.a(Uri.parse(eventArtist.c), f17911d);
        }
        this.f17916f.setText(eventArtist.b);
        this.f17917g.setText(m18321b(eventArtist));
        setOnClickListener(this.f17919i);
    }

    private String m18321b(EventArtist eventArtist) {
        String str = eventArtist.f;
        if (str != null) {
            str = (String) Splitter.on(", ").limit(1).split(str).iterator().next();
        } else {
            str = null;
        }
        String str2 = str;
        String d = m18322d(eventArtist);
        if (!Strings.isNullOrEmpty(str2) && !Strings.isNullOrEmpty(d)) {
            return getContext().getString(2131237017, new Object[]{str2, d});
        } else if (!Strings.isNullOrEmpty(str2)) {
            return str2;
        } else {
            if (Strings.isNullOrEmpty(d)) {
                return null;
            }
            return d;
        }
    }
}
