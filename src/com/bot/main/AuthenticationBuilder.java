package com.bot.main;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class AuthenticationBuilder {
	public static Configuration authnticate() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(Constants.OAuthConsumerKeyString)
				.setOAuthConsumerSecret(Constants.OAuthConsumerSecretString)
				.setOAuthAccessToken(Constants.OAuthAccessTokenString)
				.setOAuthAccessTokenSecret(
						Constants.OAuthAccessTokenSecretString);
		return cb.build();
	}
}
