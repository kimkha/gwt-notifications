package com.googlecode.gwt.notifications.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_Notifications implements EntryPoint {
	public void onModuleLoad() {
		HTML notif = new HTML();
		if (Notification.isDesktopNotificationSupported()) {
			notif.setText("Supported");
		} else {
			notif.setText("Unsupport");
		}
		
		RootPanel.get().add(notif);
	}
}
