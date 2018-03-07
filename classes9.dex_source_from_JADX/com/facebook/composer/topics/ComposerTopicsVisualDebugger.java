package com.facebook.composer.topics;

import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.topics.protocol.TopicClassificationQueryModels.TopicClassificationQueryModel.PredictedFeedTopicsModel;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Trying to invite participants to a null conference call object */
public class ComposerTopicsVisualDebugger {
    private final boolean f23924a;
    private final Toaster f23925b;

    @Inject
    public ComposerTopicsVisualDebugger(FbSharedPreferences fbSharedPreferences, Toaster toaster) {
        this.f23924a = fbSharedPreferences.a(FeedPrefKeys.h, false);
        this.f23925b = toaster;
    }

    public final void m25887a(String str) {
        if (this.f23924a) {
            m25886b("Query sent, with text: \"" + str + "\"");
        }
    }

    public final void m25889a(List<PredictedFeedTopicsModel> list) {
        if (this.f23924a) {
            StringBuilder stringBuilder;
            if (list.isEmpty()) {
                stringBuilder = new StringBuilder("No predicted topics");
            } else {
                StringBuilder stringBuilder2 = new StringBuilder("Predicted:");
                for (PredictedFeedTopicsModel predictedFeedTopicsModel : list) {
                    stringBuilder2.append(" ");
                    stringBuilder2.append(predictedFeedTopicsModel.k().c());
                }
                stringBuilder = stringBuilder2;
            }
            m25886b(stringBuilder.toString());
        }
    }

    public final void m25888a(Throwable th) {
        if (this.f23924a) {
            m25886b("SERVER ERROR: " + th.getMessage());
        }
    }

    private void m25886b(String str) {
        this.f23925b.a(new ToastBuilder(str));
    }
}
