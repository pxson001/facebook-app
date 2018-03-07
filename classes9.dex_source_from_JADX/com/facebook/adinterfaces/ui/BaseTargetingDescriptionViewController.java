package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetingDescriptionModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetingDescriptionModel.TargetingDescriptorsModel.NodesModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import javax.annotation.Nullable;

/* compiled from: Unsupported search type found in creating future. */
public abstract class BaseTargetingDescriptionViewController<D extends AdInterfacesDataModel> extends BaseAdInterfacesViewController<BetterTextView, D> {
    public static final String f23067a = System.getProperty("line.separator");
    public D f23068b;

    /* compiled from: Unsupported search type found in creating future. */
    class C27071 implements IntentHandler {
        final /* synthetic */ BaseTargetingDescriptionViewController f23065a;

        C27071(BaseTargetingDescriptionViewController baseTargetingDescriptionViewController) {
            this.f23065a = baseTargetingDescriptionViewController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                this.f23065a.f22440b.m22429a(new InvalidateEvent());
            }
        }
    }

    /* compiled from: Unsupported search type found in creating future. */
    class C27082 implements OnClickListener {
        final /* synthetic */ BaseTargetingDescriptionViewController f23066a;

        C27082(BaseTargetingDescriptionViewController baseTargetingDescriptionViewController) {
            this.f23066a = baseTargetingDescriptionViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1825474850);
            this.f23066a.mo1021a(view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -2144815168, a);
        }
    }

    protected abstract void mo1021a(Context context);

    protected abstract ImmutableList<TargetingDescriptionModel> mo1022b();

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        BetterTextView betterTextView = (BetterTextView) view;
        super.mo982a(betterTextView, adInterfacesCardLayout);
        ImmutableList b = mo1022b();
        if (b.isEmpty()) {
            betterTextView.setVisibility(8);
            if (adInterfacesCardLayout != null) {
                adInterfacesCardLayout.setVisibility(8);
            }
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < b.size(); i++) {
            if (i > 0) {
                spannableStringBuilder.append(f23067a);
            }
            TargetingDescriptionModel targetingDescriptionModel = (TargetingDescriptionModel) b.get(i);
            CharSequence spannableString = new SpannableString(targetingDescriptionModel.m23749a());
            spannableString.setSpan(new TextAppearanceSpan(betterTextView.getContext(), 2131625330), 0, spannableString.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(f23067a);
            if (targetingDescriptionModel.m23750j() != null) {
                UnmodifiableIterator it = targetingDescriptionModel.m23750j().m23746a().iterator();
                if (it.hasNext()) {
                    spannableStringBuilder.append(((NodesModel) it.next()).m23742a());
                }
                while (it.hasNext()) {
                    spannableStringBuilder.append(", ").append(((NodesModel) it.next()).m23742a());
                }
            }
        }
        betterTextView.setText(spannableStringBuilder);
        if (adInterfacesCardLayout == null) {
            return;
        }
        if (this.f23068b.f21748d == AdInterfacesStatus.ACTIVE || this.f23068b.f21748d == AdInterfacesStatus.EXTENDABLE || this.f23068b.f21748d == AdInterfacesStatus.PENDING || this.f23068b.f21748d == AdInterfacesStatus.PAUSED) {
            m25052b(betterTextView, adInterfacesCardLayout);
        }
    }

    public final void mo983a(D d) {
        this.f23068b = d;
    }

    private void m25052b(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        this.f22440b.m22428a(4, new C27071(this));
        adInterfacesCardLayout.setCallToActionText(view.getResources().getString(2131233956));
        adInterfacesCardLayout.setCallToActionClickListener(new C27082(this));
    }
}
