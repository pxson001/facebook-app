package com.facebook.appdiscovery.composer.fragment;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: cta_lead_gen_quit_form_without_submission */
public class ApplicationAdapter extends ArrayAdapter<ApplicationInfo> {
    private final Context f16448a;
    private PackageManager f16449b;
    private ViewHolder f16450c;

    /* compiled from: cta_lead_gen_quit_form_without_submission */
    public class ViewHolder {
        public TextView f16446a;
        public ImageView f16447b;

        public ViewHolder(TextView textView, ImageView imageView) {
            this.f16446a = textView;
            this.f16447b = imageView;
        }
    }

    @Inject
    public ApplicationAdapter(@Assisted Context context, PackageManager packageManager) {
        super(context, 0);
        this.f16448a = context;
        this.f16449b = packageManager;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        ImageView imageView;
        ApplicationInfo applicationInfo = (ApplicationInfo) getItem(i);
        if (view == null) {
            view = ((LayoutInflater) this.f16448a.getSystemService("layout_inflater")).inflate(2130903264, viewGroup, false);
            textView = (TextView) view.findViewById(2131559622);
            imageView = (ImageView) view.findViewById(2131559621);
            view.setTag(new ViewHolder(textView, imageView));
        } else {
            this.f16450c = (ViewHolder) view.getTag();
            textView = this.f16450c.f16446a;
            imageView = this.f16450c.f16447b;
        }
        textView.setText(applicationInfo.loadLabel(this.f16449b));
        imageView.setImageDrawable(applicationInfo.loadIcon(this.f16449b));
        return view;
    }
}
