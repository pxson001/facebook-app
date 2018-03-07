package com.facebook.pages.fb4a.videohub.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoListModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: privacy_review_write_exit_on_failure */
public class PagesVideoHubVideoListView extends CustomFrameLayout {
    @Inject
    public FbUriIntentHandler f3141a;
    private View[] f3142b;
    public BadgeTextView f3143c;
    private String f3144d;

    public static void m4230a(Object obj, Context context) {
        ((PagesVideoHubVideoListView) obj).f3141a = FbUriIntentHandler.a(FbInjector.get(context));
    }

    public PagesVideoHubVideoListView(Context context, int i) {
        this(context, null, i);
    }

    private PagesVideoHubVideoListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PagesVideoHubVideoListView.class;
        m4230a((Object) this, getContext());
        setContentView(2130907686);
        this.f3144d = context.getString(2131235506);
        this.f3143c = (BadgeTextView) findViewById(2131568349);
        int[] iArr = new int[]{2131568350, 2131568351, 2131568352};
        this.f3142b = new View[3];
        for (int i2 = 0; i2 < 3; i2++) {
            this.f3142b[i2] = findViewById(iArr[i2]);
            this.f3142b[i2].setVisibility(0);
        }
    }

    public final void m4232a(long j, PageVideoListModel pageVideoListModel) {
        if (pageVideoListModel.m4182m() == null || pageVideoListModel.m4182m().m4175j().isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        m4231b(j, pageVideoListModel);
        ImmutableList j2 = pageVideoListModel.m4182m().m4175j();
        for (int i = 0; i < 3; i++) {
            PagesVideoHubVideoListItem pagesVideoHubVideoListItem = (PagesVideoHubVideoListItem) this.f3142b[i];
            if (i < j2.size()) {
                pagesVideoHubVideoListItem.m4227a((VideoDetailFragmentModel) j2.get(i));
                pagesVideoHubVideoListItem.setVisibility(0);
            } else {
                pagesVideoHubVideoListItem.setVisibility(8);
            }
        }
    }

    public static String m4228a(int i) {
        if (i <= 20) {
            return String.valueOf(i);
        }
        return "20" + "+";
    }

    private void m4231b(final long j, PageVideoListModel pageVideoListModel) {
        Preconditions.checkNotNull(pageVideoListModel);
        final String j2 = pageVideoListModel.m4179j();
        CharSequence a = m4229a(pageVideoListModel.m4181l());
        int a2 = pageVideoListModel.m4182m().m4171a();
        OnClickListener c04281 = new OnClickListener(this) {
            final /* synthetic */ PagesVideoHubVideoListView f3140c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1509077508);
                PagesVideoHubVideoListView pagesVideoHubVideoListView = this.f3140c;
                long j = j;
                pagesVideoHubVideoListView.f3141a.a(pagesVideoHubVideoListView.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.av, Long.valueOf(Long.parseLong(j2)), Long.valueOf(j), "VideoHubFragment"));
                Logger.a(2, EntryType.UI_INPUT_END, -1450327622, a);
            }
        };
        this.f3143c.setText(a);
        this.f3143c.setBadgeText(m4228a(a2));
        this.f3143c.setOnClickListener(c04281);
    }

    private String m4229a(String str) {
        if (str == null) {
            return this.f3144d;
        }
        return str;
    }
}
