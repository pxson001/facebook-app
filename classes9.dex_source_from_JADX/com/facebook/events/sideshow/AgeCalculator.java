package com.facebook.events.sideshow;

import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel.BirthdateModel;
import java.util.GregorianCalendar;

/* compiled from: Tab switched */
public class AgeCalculator {
    public static boolean m26234a(BirthdateModel birthdateModel) {
        return birthdateModel.m26311k() > 1850;
    }

    public static int m26235b(BirthdateModel birthdateModel) {
        return (int) Math.round(((double) (new GregorianCalendar().getTimeInMillis() - new GregorianCalendar(birthdateModel.m26311k(), birthdateModel.m26310j() - 1, birthdateModel.m26306a()).getTimeInMillis())) / 3.15576E10d);
    }
}
