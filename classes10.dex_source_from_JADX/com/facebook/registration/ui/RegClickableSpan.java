package com.facebook.registration.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.browser.lite.BrowserLiteActivity;
import com.facebook.browser.lite.ipc.BrowserLiteIntent.Builder;
import com.facebook.content.SecureContextHelper;
import com.facebook.growth.friendfinder.FriendFinderLearnMoreActivity;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: jimdfgyrjdkfkmzxxxuuujoeyuifpfjgjsexghjuckluvvfvjhjhgfcbznbvqrfbigfvfbvjwayjvflovysqhbdhbzjkzwbzxyzvbkfnzfnjvjqfyzfcn0.0byf */
public class RegClickableSpan extends ClickableSpan {
    @Nullable
    private final String f8935a;
    private final TargetActivity f8936b;
    private final Lazy<SecureContextHelper> f8937c;

    /* compiled from: jimdfgyrjdkfkmzxxxuuujoeyuifpfjgjsexghjuckluvvfvjhjhgfcbznbvqrfbigfvfbvjwayjvflovysqhbdhbzjkzwbzxyzvbkfnzfnjvjqfyzfcn0.0byf */
    public enum TargetActivity {
        BROWSER,
        FRIEND_FINDER_LEARN_MORE
    }

    @Inject
    public RegClickableSpan(Lazy<SecureContextHelper> lazy, @Assisted TargetActivity targetActivity, @Nullable @Assisted String str) {
        this.f8937c = lazy;
        this.f8936b = targetActivity;
        this.f8935a = str;
    }

    public void onClick(View view) {
        Intent intent;
        Context context = view.getContext();
        switch (this.f8936b) {
            case BROWSER:
                Intent data = new Intent(context, BrowserLiteActivity.class).setData(Uri.parse(this.f8935a));
                data.putExtras(new Builder().a(context.getResources().getConfiguration().locale).c(false).a());
                intent = data;
                break;
            case FRIEND_FINDER_LEARN_MORE:
                intent = new Intent(context, FriendFinderLearnMoreActivity.class);
                break;
            default:
                return;
        }
        ((SecureContextHelper) this.f8937c.get()).a(intent, context);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
