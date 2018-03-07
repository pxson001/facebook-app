package com.facebook.places.checkin.lightweight;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass73;
import com.facebook.composer.location.LocationLightweightPickerSproutItem;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.ViewProvider.C08471;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;

/* compiled from: TopicFeedOptionDeselectMutation */
public class LightweightPlaceViewHolder extends ViewHolder {
    public final FbTextView f10584l;
    public CheckinPlaceModel f10585m;
    public int f10586n;

    public LightweightPlaceViewHolder(View view) {
        super(view);
        this.f10586n = -1;
        this.f10584l = null;
    }

    public LightweightPlaceViewHolder(FbTextView fbTextView, final C08471 c08471) {
        super(fbTextView);
        this.f10586n = -1;
        this.f10584l = fbTextView;
        this.f10584l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LightweightPlaceViewHolder f10583b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1458808580);
                if (this.f10583b.f10585m != null) {
                    C08471 c08471 = c08471;
                    CheckinPlaceModel checkinPlaceModel = this.f10583b.f10585m;
                    int i = this.f10583b.f10586n;
                    AnonymousClass73 anonymousClass73 = c08471.f6683a.f6685a.f6690d;
                    ComposerFragment.bp(anonymousClass73.f6114a);
                    ComposerFragment.m7541a(anonymousClass73.f6114a, checkinPlaceModel, null, null);
                    LocationLightweightPickerSproutItem locationLightweightPickerSproutItem = c08471.f6683a.f6685a;
                    ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(locationLightweightPickerSproutItem.f6687a.get());
                    ComposerLocationInfo g = ((ProvidesLocationInfo) composerDataProviderImpl).g();
                    locationLightweightPickerSproutItem.f6691e.a(((ProvidesSessionId) composerDataProviderImpl).ab(), g.h(), g.i(), i, g.g());
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1028066007, a);
            }
        });
    }
}
