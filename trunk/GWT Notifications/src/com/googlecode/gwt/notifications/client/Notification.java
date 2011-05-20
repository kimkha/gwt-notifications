package com.googlecode.gwt.notifications.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.PartialSupport;

@PartialSupport
public class Notification {
	/**
	 * Detector for browser support of Desktop Notification.
	 */
	private static class NotificationSupportDetector {
		private final boolean isNotificationSupported = detectNotificationSupport();
		
		public boolean isNotificationSupported() {
			return this.isNotificationSupported;
		}
		
		private native boolean detectNotificationSupport() /*-{
			return typeof $wnd.webkitNotifications != "undefined";
		}-*/;
	}
	
	/**
	 * Detector for browser support of Desktop Notification.
	 */
	@SuppressWarnings("unused")
	private static class NotificationSupportDetectorNo extends NotificationSupportDetector {
		@Override
		public boolean isNotificationSupported() {
			return false;
		}
	}
	
	private static final NotificationImpl impl = GWT.create(NotificationImpl.class);
	
	private int permission = impl.checkPermission();

	private static NotificationSupportDetector supportDetectorImpl;
	
	//TODO: Some variable
	
	//TODO: Some API function for event
	
	/**
	 * Check current status of notification is allowed or not
	 * 
	 * @return true if user allow to use notification
	 */
	public boolean isNotificationAllowed() {
		return permission == NotificationImpl.PERMISSION_ALLOWED;
	}
	
	/**
	 * Check current status of notification is set or not
	 * 
	 * @return true if user doesn't set permission (never choose 'Allow' or 'Deny')
	 */
	public boolean isNotificationNotAllowed() {
		return permission == NotificationImpl.PERMISSION_NOT_ALLOWED;
	}
	
	/**
	 * Check current status of notification is denied or not
	 * 
	 * @return true if user deny to use notification
	 */
	public boolean isNotificationDenied() {
		return permission == NotificationImpl.PERMISSION_DENIED;
	}
	
	/**
	 * Get current status of notification permission
	 * @return
	 */
	public int checkPermission() {
		return permission;
	}
	
	public static boolean isSupported() {
		return getNotificationSupportDetector().isNotificationSupported();
	}
	
	private static NotificationSupportDetector getNotificationSupportDetector() {
		if (supportDetectorImpl == null) {
			supportDetectorImpl = GWT.create(NotificationSupportDetector.class);
		}
		return supportDetectorImpl;
	}

}
