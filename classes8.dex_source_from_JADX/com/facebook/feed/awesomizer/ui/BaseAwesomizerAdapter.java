package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: gysj_profile */
public abstract class BaseAwesomizerAdapter<T> extends Adapter<ViewHolder> {
    private static final String f11797d = BaseAwesomizerAdapter.class.getSimpleName();
    public FeedAwesomizerLogger f11798a;
    public String f11799b = "/feed/control/feed_awesomizer/learn_more/?card=";
    protected final AbstractFbErrorReporter f11800c;
    public final SecureContextHelper f11801e;
    public final UriIntentMapper f11802f;
    public T f11803g;
    public boolean f11804h;
    public int f11805i;

    /* compiled from: gysj_profile */
    public class ViewHolderHeader extends ViewHolder {
        final /* synthetic */ BaseAwesomizerAdapter f11793l;
        public View f11794m;

        public ViewHolderHeader(BaseAwesomizerAdapter baseAwesomizerAdapter, View view) {
            this.f11793l = baseAwesomizerAdapter;
            super(view);
            this.f11794m = view;
            Theme theme = this.f11794m.getContext().getTheme();
            TypedValue typedValue = new TypedValue();
            final TypedValue typedValue2 = new TypedValue();
            theme.resolveAttribute(2130773487, typedValue, true);
            theme.resolveAttribute(2130773489, typedValue2, true);
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f11794m.getContext().getResources().getString(typedValue.resourceId));
            String string = this.f11794m.getContext().getResources().getString(2131236161);
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new ClickableSpan(this) {
                final /* synthetic */ ViewHolderHeader f11792b;

                public void onClick(View view) {
                    BaseAwesomizerAdapter baseAwesomizerAdapter = this.f11792b.f11793l;
                    Context context = view.getContext();
                    Intent a = baseAwesomizerAdapter.f11802f.a(context, FBLinks.cr.concat(baseAwesomizerAdapter.f11799b + baseAwesomizerAdapter.mo807g()));
                    a.putExtra("titlebar_with_modal_done", true);
                    baseAwesomizerAdapter.f11801e.a(a, context);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(typedValue2.data);
                }
            }, spannableStringBuilder.length() - string.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(this.f11794m.getContext(), 2131625678), 0, spannableStringBuilder.length() - string.length(), 18);
            FbTextView fbTextView = (FbTextView) FindViewUtil.b(this.f11794m, 2131559789);
            fbTextView.setText(spannableStringBuilder);
            fbTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* compiled from: gysj_profile */
    public class ViewHolderItem extends ViewHolder implements OnClickListener {
        public View f11795l;
        final /* synthetic */ BaseAwesomizerAdapter f11796m;

        public ViewHolderItem(BaseAwesomizerAdapter baseAwesomizerAdapter, View view) {
            this.f11796m = baseAwesomizerAdapter;
            super(view);
            this.f11795l = view;
            this.f11795l.setOnClickListener(this);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -389548745);
            this.f11796m.mo802a(view, e());
            Logger.a(2, EntryType.UI_INPUT_END, -243767205, a);
        }
    }

    public abstract void mo802a(View view, int i);

    public abstract int aZ_();

    protected abstract ViewHolderItem mo805c(ViewGroup viewGroup);

    public abstract String mo807g();

    protected BaseAwesomizerAdapter(AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f11800c = abstractFbErrorReporter;
        this.f11801e = secureContextHelper;
        this.f11802f = uriIntentMapper;
    }

    public ViewHolder mo835a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ViewHolderHeader(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903334, viewGroup, false));
        }
        if (i == 1) {
            return mo805c(viewGroup);
        }
        if (i == 2) {
            return mo801a(viewGroup);
        }
        if (i == 3) {
            return mo804b(viewGroup);
        }
        this.f11800c.b(f11797d, "Invalid view type " + i + " in the awesomizer card adapter");
        return null;
    }

    public final void m13882a(T t, boolean z, int i) {
        this.f11803g = t;
        this.f11804h = z;
        this.f11805i = i;
        notifyDataSetChanged();
    }

    public final long H_(int i) {
        return (long) i;
    }

    public boolean mo817e(int i) {
        return i == 0;
    }

    public boolean mo806f(int i) {
        return false;
    }

    public boolean mo808g(int i) {
        return false;
    }

    public int getItemViewType(int i) {
        if (mo817e(i)) {
            return 0;
        }
        if (mo806f(i)) {
            return 2;
        }
        if (mo808g(i)) {
            return 3;
        }
        return 1;
    }

    protected ViewHolderItem mo801a(ViewGroup viewGroup) {
        return null;
    }

    protected ViewHolderItem mo804b(ViewGroup viewGroup) {
        return null;
    }
}
