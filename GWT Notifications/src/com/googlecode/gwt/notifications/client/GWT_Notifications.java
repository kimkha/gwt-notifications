package com.googlecode.gwt.notifications.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_Notifications implements EntryPoint {
	public void onModuleLoad() {
		final Notification no = Notification.createIfSupported();
		HTML notif = new HTML();
		if (Notification.isSupported()) {
			notif.setText("Supported "+no.checkPermission());
		} else {
			notif.setText("Unsupported");
		}
		//final OldNotification no = new OldNotification("http://www.gstatic.com/codesite/ph/images/defaultlogo.png", "Demo", "Demo content");
		Anchor link = new Anchor("Run!");
		link.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//no.fire();
				Notification.requestPermission();
			}
		});
		RootPanel.get().add(notif);
		RootPanel.get().add(link);
	}
}
