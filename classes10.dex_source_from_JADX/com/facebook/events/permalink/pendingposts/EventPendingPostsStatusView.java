package com.facebook.events.permalink.pendingposts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: bae414fb2ce743f9c61308a6feb68134 */
public class EventPendingPostsStatusView extends SegmentedLinearLayout {
    @Inject
    @LoggedInUserId
    Provider<String> f18758a;
    @Inject
    SecureContextHelper f18759b;
    @Inject
    UriIntentMapper f18760c;
    private BetterTextView f18761d;
    private BetterTextView f18762e;
    private BetterTextView f18763f;
    private Resources f18764g;
    public Event f18765h;

    /* compiled from: bae414fb2ce743f9c61308a6feb68134 */
    class C26691 implements OnClickListener {
        final /* synthetic */ EventPendingPostsStatusView f18757a;

        C26691(EventPendingPostsStatusView eventPendingPostsStatusView) {
            this.f18757a = eventPendingPostsStatusView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1493473617);
            if (this.f18757a.f18765h == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -228971547, a);
                return;
            }
            Context context = view.getContext();
            Intent a2 = this.f18757a.f18760c.a(context, StringFormatUtil.a(FBLinks.bN, new Object[]{this.f18757a.f18765h.a}));
            if (a2 != null) {
                this.f18757a.f18759b.a(a2, context);
            }
            LogUtils.a(-1756364142, a);
        }
    }

    private static <T extends View> void m19063a(Class<T> cls, T t) {
        m19064a((Object) t, t.getContext());
    }

    private static void m19064a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventPendingPostsStatusView) obj).m19065a(IdBasedProvider.a(fbInjector, 4442), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector));
    }

    public EventPendingPostsStatusView(Context context) {
        super(context);
        m19062a();
    }

    public EventPendingPostsStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19062a();
    }

    private void m19062a() {
        m19063a(EventPendingPostsStatusView.class, (View) this);
        setContentView(2130904051);
        setOrientation(1);
        this.f18764g = getResources();
        setBackgroundDrawable(new ColorDrawable(this.f18764g.getColor(2131361920)));
        setShowSegmentedDividers(2);
        setSegmentedDividerThickness(1);
        setSegmentedDivider(this.f18764g.getDrawable(2131361940));
        this.f18761d = (BetterTextView) a(2131561336);
        this.f18762e = (BetterTextView) a(2131561337);
        this.f18763f = (BetterTextView) a(2131561338);
        this.f18763f.setOnClickListener(new C26691(this));
    }

    private void m19065a(Provider<String> provider, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f18758a = provider;
        this.f18759b = secureContextHelper;
        this.f18760c = uriIntentMapper;
    }

    public final void m19066a(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f18765h = event;
        boolean a = event.a((String) this.f18758a.get());
        this.f18761d.setText(this.f18764g.getQuantityString(a ? 2131689682 : 2131689683, fetchEventPermalinkFragmentModel.aN(), new Object[]{Integer.valueOf(fetchEventPermalinkFragmentModel.aN())}));
        this.f18762e.setText(a ? 2131237255 : 2131237256);
        this.f18763f.setText(this.f18764g.getString(a ? 2131237257 : 2131237258));
    }
}
