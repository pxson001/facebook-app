package com.facebook.reaction.ui.welcomeheader;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: Unable to remove offer claim */
public class ReactionNuxView extends CustomLinearLayout {
    @Inject
    public FbUriIntentHandler f21211a;
    @Inject
    public PlaceTipsSettingsHelper f21212b;
    public final TextView f21213c = ((TextView) a(2131566743));
    public final TextView f21214d = ((TextView) a(2131566744));
    public final TextView f21215e = ((TextView) a(2131566745));

    /* compiled from: Unable to remove offer claim */
    public class C22581 implements OnClickListener {
        final /* synthetic */ String f21209a;
        final /* synthetic */ ReactionNuxView f21210b;

        public C22581(ReactionNuxView reactionNuxView, String str) {
            this.f21210b = reactionNuxView;
            this.f21209a = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1756166122);
            this.f21210b.f21211a.a(this.f21210b.getContext(), this.f21209a);
            Logger.a(2, EntryType.UI_INPUT_END, 1548167649, a);
        }
    }

    public static void m24826a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ReactionNuxView reactionNuxView = (ReactionNuxView) obj;
        FbUriIntentHandler a = FbUriIntentHandler.a(injectorLike);
        PlaceTipsSettingsHelper a2 = PlaceTipsSettingsHelper.m3886a(injectorLike);
        reactionNuxView.f21211a = a;
        reactionNuxView.f21212b = a2;
    }

    public ReactionNuxView(Context context) {
        super(context);
        Class cls = ReactionNuxView.class;
        m24826a(this, getContext());
        setContentView(2130906691);
    }
}
