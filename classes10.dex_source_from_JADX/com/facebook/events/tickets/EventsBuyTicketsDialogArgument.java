package com.facebook.events.tickets;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventCreatorModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.payments.paymentsflow.PayViewControllerParams;
import java.util.Date;

/* compiled from: attachmentResources */
public class EventsBuyTicketsDialogArgument implements Parcelable {
    public static final Creator<EventsBuyTicketsDialogArgument> CREATOR = new C27181();
    public final PayViewControllerParams f19175a;
    public final String f19176b;
    public final String f19177c;
    public final Uri f19178d;
    public final boolean f19179e;
    public final Date f19180f;
    public final EventCreatorModel f19181g;
    public final TicketTiersModel f19182h;
    public final ActionMechanism f19183i;

    /* compiled from: attachmentResources */
    final class C27181 implements Creator<EventsBuyTicketsDialogArgument> {
        C27181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventsBuyTicketsDialogArgument(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventsBuyTicketsDialogArgument[i];
        }
    }

    public EventsBuyTicketsDialogArgument(PayViewControllerParams payViewControllerParams, String str, String str2, Uri uri, boolean z, Date date, EventCreatorModel eventCreatorModel, TicketTiersModel ticketTiersModel, ActionMechanism actionMechanism) {
        this.f19175a = payViewControllerParams;
        this.f19176b = str;
        this.f19177c = str2;
        this.f19178d = uri;
        this.f19179e = z;
        this.f19180f = date;
        this.f19181g = eventCreatorModel;
        this.f19182h = ticketTiersModel;
        this.f19183i = actionMechanism;
    }

    protected EventsBuyTicketsDialogArgument(Parcel parcel) {
        Date date;
        this.f19175a = (PayViewControllerParams) parcel.readParcelable(PayViewControllerParams.class.getClassLoader());
        this.f19176b = parcel.readString();
        this.f19177c = parcel.readString();
        this.f19179e = ParcelUtil.a(parcel);
        if (parcel.readInt() == 1) {
            date = new Date(parcel.readLong());
        } else {
            date = null;
        }
        this.f19180f = date;
        this.f19178d = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f19181g = (EventCreatorModel) FlatBufferModelHelper.a(parcel);
        this.f19182h = (TicketTiersModel) FlatBufferModelHelper.a(parcel);
        this.f19183i = (ActionMechanism) parcel.readParcelable(ActionMechanism.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f19175a, i);
        parcel.writeString(this.f19176b);
        parcel.writeString(this.f19177c);
        ParcelUtil.a(parcel, this.f19179e);
        Date date = this.f19180f;
        if (date == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(date.getTime());
        }
        parcel.writeParcelable(this.f19178d, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f19181g);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f19182h);
        parcel.writeParcelable(this.f19183i, i);
    }

    public int describeContents() {
        return 0;
    }
}
