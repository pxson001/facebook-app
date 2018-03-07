package com.facebook.appirater.ratingdialog.screencontroller;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: crowdsourcing_post_action_vote */
public abstract class MessageScreenController extends AbstractAppiraterDialogScreenController {
    protected abstract void mo1287a(ImageView imageView, TextView textView);

    public final View mo1284a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2130903287, null, false);
        mo1287a((ImageView) inflate.findViewById(2131559687), (TextView) inflate.findViewById(2131559688));
        return inflate;
    }
}
