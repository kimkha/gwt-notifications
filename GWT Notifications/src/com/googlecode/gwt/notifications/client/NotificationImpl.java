package com.googlecode.gwt.notifications.client;

import com.google.gwt.user.client.Window;
import com.googlecode.gwt.notifications.client.event.RequestPermissionHandler;

public class NotificationImpl {
	public static final int PERMISSION_ALLOWED = 0;
	public static final int PERMISSION_NOT_ALLOWED = 1;
	public static final int PERMISSION_DENIED = 2;
	private RequestPermissionHandler requestPermissionHandler;

	protected NotificationImpl() {
		
	}
	
	private void debug(String msg) {
		Window.alert(msg);
	}
	
	public native int checkPermission() /*-{
		return $wnd.webkitNotifications.checkPermission();
	}-*/;
	
	public void requestPermission() {
		this.requestPermission(this);
	}
	
	public void requestPermission(RequestPermissionHandler handler) {
		this.requestPermissionHandler = handler;
		this.requestPermission(this);
	}

	private void callbackRequestPermission() {
		if (requestPermissionHandler != null) {
			requestPermissionHandler.onPermissionReady();
		}
	}
	
	private native void requestPermission(NotificationImpl x) /*-{
		$wnd.webkitNotifications.requestPermission($entry(function() {
			x.@com.googlecode.gwt.notifications.client.NotificationImpl::callbackRequestPermission()();
		}));
	}-*/;
}
