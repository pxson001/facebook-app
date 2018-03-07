package com.facebook.privacy.selector;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fb4a_timeline */
public class CustomPrivacyAdapter extends FbBaseAdapter {
    private static final CallerContext f15207a = CallerContext.a(CustomPrivacyAdapter.class);
    private final LayoutInflater f15208b;
    public List<BaseToken> f15209c = new ArrayList();
    public RemoveTokensUpdater f15210d;
    private final OnClickListener f15211e = new C10421(this);

    /* compiled from: fb4a_timeline */
    class C10421 implements OnClickListener {
        final /* synthetic */ CustomPrivacyAdapter f15206a;

        C10421(CustomPrivacyAdapter customPrivacyAdapter) {
            this.f15206a = customPrivacyAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1803457076);
            if (this.f15206a.f15210d != null) {
                BaseToken baseToken = (BaseToken) view.getTag(2131566266);
                this.f15206a.f15209c.remove(baseToken);
                this.f15206a.f15210d.mo1213a(this.f15206a.f15209c, baseToken);
                AdapterDetour.a(this.f15206a, 382663106);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1877208544, a);
        }
    }

    /* compiled from: fb4a_timeline */
    public interface RemoveTokensUpdater {
        void mo1213a(List<BaseToken> list, BaseToken baseToken);
    }

    public static CustomPrivacyAdapter m22877b(InjectorLike injectorLike) {
        return new CustomPrivacyAdapter(LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public CustomPrivacyAdapter(LayoutInflater layoutInflater) {
        this.f15208b = layoutInflater;
    }

    public final void m22880a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        BaseToken baseToken = (BaseToken) obj;
        LinearLayout linearLayout = (LinearLayout) view;
        FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131566263);
        GlyphView glyphView = (GlyphView) linearLayout.findViewById(2131566264);
        BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131566265);
        GlyphView glyphView2 = (GlyphView) linearLayout.findViewById(2131566266);
        if (baseToken.mo1190h() > 0) {
            glyphView.setImageResource(baseToken.mo1190h());
            fbDraweeView.setVisibility(8);
            glyphView.setVisibility(0);
        } else {
            fbDraweeView.a(Uri.parse(baseToken.mo1191i()), f15207a);
            fbDraweeView.setVisibility(0);
            glyphView.setVisibility(8);
        }
        betterTextView.setText(baseToken.mo1185b());
        glyphView2.setTag(2131566266, baseToken);
        glyphView2.setOnClickListener(this.f15211e);
    }

    public final View m22878a(int i, ViewGroup viewGroup) {
        return this.f15208b.inflate(2130906390, viewGroup, false);
    }

    public int getCount() {
        return this.f15209c.size();
    }

    public Object getItem(int i) {
        return this.f15209c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final void m22881a(List<BaseToken> list) {
        this.f15209c = new ArrayList(list);
        AdapterDetour.a(this, -1697213158);
    }

    public final List<BaseToken> m22879a() {
        return new ArrayList(this.f15209c);
    }
}
