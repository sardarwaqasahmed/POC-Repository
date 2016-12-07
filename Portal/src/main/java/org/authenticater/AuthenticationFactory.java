package org.authenticater;

public class AuthenticationFactory {

	private static Authenticater auth = null;

	public static Authenticater getInstace() {

		if (auth == null) {

			auth = AuthenticaterImpl.getInstance();
		}

		return auth;

	}

}
