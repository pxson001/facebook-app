package com.facebook.redspace.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: PRIVACY_REVIEW_WRITE_EXIT_ON_FAILURE */
public class RedSpaceProfileNavigationButton extends CustomLinearLayout {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> f12354a = UltralightRuntime.b;
    @Inject
    @Lazy
    @LoggedInUserId
    private com.facebook.inject.Lazy<String> f12355b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceLogger> f12356c = UltralightRuntime.b;
    private FbTextView f12357d;

    private static <T extends View> void m12774a(Class<T> cls, T t) {
        m12775a((Object) t, t.getContext());
    }

    private static void m12775a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceProfileNavigationButton) obj).m12773a(IdBasedLazy.a(fbInjector, 10220), IdBasedLazy.a(fbInjector, 4442), IdBasedSingletonScopeProvider.b(fbInjector, 10162));
    }

    public RedSpaceProfileNavigationButton(Context context) {
        super(context);
        m12777b();
    }

    public RedSpaceProfileNavigationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12777b();
    }

    public RedSpaceProfileNavigationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12777b();
    }

    private void m12777b() {
        setId(2131558604);
        m12774a(RedSpaceProfileNavigationButton.class, (View) this);
        setContentView(2130906783);
        this.f12357d = (FbTextView) a(2131566883);
    }

    public final void m12779a(final RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        setText(redSpaceFeedProfileFragmentModel);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RedSpaceProfileNavigationButton f12353b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1728390601);
                RedSpaceFriendOptionsHelper redSpaceFriendOptionsHelper = (RedSpaceFriendOptionsHelper) this.f12353b.f12354a.get();
                Context context = view.getContext();
                RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = redSpaceFeedProfileFragmentModel;
                if (context != null) {
                    ((IFeedIntentBuilder) redSpaceFriendOptionsHelper.f12315d.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, redSpaceFeedProfileFragmentModel.k()));
                }
                RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f12353b.f12356c.get();
                String k = redSpaceFeedProfileFragmentModel.k();
                HoneyClientEventFast a2 = redSpaceLogger.b.a("open_profile", false);
                if (a2.a()) {
                    a2.a("redspace");
                    a2.a("person_id", k);
                    a2.b();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1583353771, a);
            }
        });
    }

    public final void m12778a() {
        setOnClickListener(null);
    }

    private void setText(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        CharSequence string;
        Resources resources = getResources();
        if (StringUtil.a(redSpaceFeedProfileFragmentModel.k(), (String) this.f12355b.get())) {
            string = resources.getString(2131235742);
        } else if (redSpaceFeedProfileFragmentModel.n() == null || redSpaceFeedProfileFragmentModel.n().a().isEmpty()) {
            string = resources.getString(2131235743);
        } else {
            string = resources.getString(2131235741, new Object[]{GraphQLHelper.a(redSpaceFeedProfileFragmentModel.n())});
        }
        this.f12357d.setText(string);
    }

    private void m12773a(com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> lazy, com.facebook.inject.Lazy<String> lazy2, com.facebook.inject.Lazy<RedSpaceLogger> lazy3) {
        this.f12354a = lazy;
        this.f12355b = lazy2;
        this.f12356c = lazy3;
    }
}
