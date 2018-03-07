package com.facebook.contacts.background;

/* compiled from: photo_menu_upload */
public class AddressBookPeriodicRunner$1 implements Runnable {
    final /* synthetic */ boolean f8119a;
    final /* synthetic */ AddressBookPeriodicRunner f8120b;

    public AddressBookPeriodicRunner$1(AddressBookPeriodicRunner addressBookPeriodicRunner, boolean z) {
        this.f8120b = addressBookPeriodicRunner;
        this.f8119a = z;
    }

    public void run() {
        this.f8120b.a(this.f8119a);
    }
}
