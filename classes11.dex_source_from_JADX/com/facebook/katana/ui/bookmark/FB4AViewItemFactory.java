package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BaseViewItemFactory;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import javax.inject.Inject;

/* compiled from: wasSearchButtonNuxShown */
public class FB4AViewItemFactory extends BaseViewItemFactory {
    private static final Class<FB4AViewItemFactory> f164d = FB4AViewItemFactory.class;
    private final AnalyticsLogger f165e;
    private final Context f166f;
    private final PreferredFeedTypeManager f167g;

    /* compiled from: wasSearchButtonNuxShown */
    public class C00201 implements ViewItem {
        final /* synthetic */ RowType f162a;
        final /* synthetic */ FB4AViewItemFactory f163b;

        public C00201(FB4AViewItemFactory fB4AViewItemFactory, RowType rowType) {
            this.f163b = fB4AViewItemFactory;
            this.f162a = rowType;
        }

        public final View m162a(int i, View view, ViewGroup viewGroup) {
            if (view != null) {
                return view;
            }
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130903415, viewGroup, false);
            ((TextView) view.findViewById(2131559951)).setText(viewGroup.getContext().getText(2131233366));
            return view;
        }

        public final Bookmark m164c() {
            return null;
        }

        public final RowType m163a() {
            return this.f162a;
        }
    }

    public static FB4AViewItemFactory m166b(InjectorLike injectorLike) {
        return new FB4AViewItemFactory((Context) injectorLike.getInstance(Context.class), ActivityMethodAutoProvider.b(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PreferredFeedTypeManager.a(injectorLike), JewelCounters.a(injectorLike));
    }

    public static FB4AViewItemFactory m165a(InjectorLike injectorLike) {
        return m166b(injectorLike);
    }

    @Inject
    public FB4AViewItemFactory(Context context, Activity activity, LayoutInflater layoutInflater, AnalyticsLogger analyticsLogger, PreferredFeedTypeManager preferredFeedTypeManager, JewelCounters jewelCounters) {
        super(activity, layoutInflater, jewelCounters);
        this.f166f = context;
        this.f165e = analyticsLogger;
        this.f167g = preferredFeedTypeManager;
    }

    protected final int m167a(Bookmark bookmark) {
        int a = super.a(bookmark);
        return a > 0 ? a : 0;
    }
}
