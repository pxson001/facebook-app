package com.facebook.placetips.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData.FeedbackType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.settings.PlaceTipsLocationData;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: captcha_solve_request_failed */
public class PlaceTipsBlacklistFeedbackItem extends CustomLinearLayout {
    final TextView f18427a;
    public FragmentFactoryMap f18428b;
    public PlaceTipsSettingsHelper f18429c;
    public Clock f18430d;

    public static void m22361a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PlaceTipsBlacklistFeedbackItem placeTipsBlacklistFeedbackItem = (PlaceTipsBlacklistFeedbackItem) obj;
        FragmentFactoryMap fragmentFactoryMap = (FragmentFactoryMap) FragmentFactoryMapImpl.a(injectorLike);
        PlaceTipsSettingsHelper a = PlaceTipsSettingsHelper.m3886a(injectorLike);
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(injectorLike);
        placeTipsBlacklistFeedbackItem.f18428b = fragmentFactoryMap;
        placeTipsBlacklistFeedbackItem.f18429c = a;
        placeTipsBlacklistFeedbackItem.f18430d = clock;
    }

    public PlaceTipsBlacklistFeedbackItem(Context context) {
        this(context, null);
    }

    private PlaceTipsBlacklistFeedbackItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = PlaceTipsBlacklistFeedbackItem.class;
        m22361a(this, getContext());
        setContentView(2130906276);
        this.f18427a = (TextView) a(2131566037);
    }

    public final void m22363a(FeedbackType feedbackType, FragmentManager fragmentManager, @Nullable PlaceTipsLocationData placeTipsLocationData, int i, @Nullable String str, int i2) {
        this.f18427a.setText(i2);
        final String str2 = str;
        final FeedbackType feedbackType2 = feedbackType;
        final PlaceTipsLocationData placeTipsLocationData2 = placeTipsLocationData;
        final FragmentManager fragmentManager2 = fragmentManager;
        final int i3 = i;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsBlacklistFeedbackItem f18423f;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -704566435);
                if (str2 != null) {
                    this.f18423f.f18429c.m3891a(feedbackType2, placeTipsLocationData2, str2, this.f18423f.f18430d.a());
                }
                PlaceTipsBlacklistFeedbackItem.m22360a(this.f18423f, feedbackType2, fragmentManager2, i3);
                Logger.a(2, EntryType.UI_INPUT_END, -1745298170, a);
            }
        });
    }

    public final void m22362a(final FragmentManager fragmentManager, final int i, int i2) {
        this.f18427a.setText(i2);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsBlacklistFeedbackItem f18426c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -339058398);
                PlaceTipsBlacklistFeedbackItem.m22360a(this.f18426c, null, fragmentManager, i);
                Logger.a(2, EntryType.UI_INPUT_END, 523158117, a);
            }
        });
    }

    public static void m22360a(@Nullable PlaceTipsBlacklistFeedbackItem placeTipsBlacklistFeedbackItem, FeedbackType feedbackType, FragmentManager fragmentManager, int i) {
        Intent intent = new Intent();
        if (feedbackType != null) {
            intent.putExtra("negative_feedback_type", feedbackType);
        }
        fragmentManager.a().b(2131558429, placeTipsBlacklistFeedbackItem.f18428b.a(i).a(intent)).a(null).b();
    }
}
