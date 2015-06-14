package com.bot.main;

import twitter4j.*;
import twitter4j.conf.Configuration;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alisaleh on 6/14/15.
 */
public class TwitterProcessor {
    private Twitter tweetingAPIsActuator;

    public TwitterProcessor(Configuration defaultAccountConfiguration) {
        tweetingAPIsActuator = new TwitterFactory(defaultAccountConfiguration).getInstance();
    }

    public void postStaticTweet() {
        try {
            tweetingAPIsActuator.updateStatus(Constants.staticTweetString);
        } catch (TwitterException e) {
            e.printStackTrace();
        } catch (Exception generalExceptionThatWontBeThrown) {
            generalExceptionThatWontBeThrown.printStackTrace();
        }
    }

    public void postDynamicallyGeneratedTweet() {
        try {
            tweetingAPIsActuator.updateStatus(this.constructDynamicTweetString());
        } catch (TwitterException e) {
            e.printStackTrace();
        } catch (Exception generalExceptionThatWontBeThrown) {
            generalExceptionThatWontBeThrown.printStackTrace();
        }
    }

    public void replyToTopNTweetsForSpecificKeyword(String keyword, int N, String reply) {
        ArrayList<twitter4j.Status> topNTweets = this.getTopNTweetsForKeyword(keyword, N, Query.ResultType.popular);

        for (Iterator<Status> statusIterator = topNTweets.iterator(); statusIterator.hasNext(); ) {
            Status status;
            status = statusIterator.next();
            this.replyToTweetWithTheProvidedReply(status, reply);
        }
    }

    private void replyToTweetWithTheProvidedReply(Status status, String reply) {
        /* todo
        * Implement the reply technique
        * */
    }

    private String constructDynamicTweetString() {
        /* todo
        * Construct a tweet for testing
        * */
        return Constants.EMPTY_STRING;
    }

    public ArrayList<twitter4j.Status> getTopNTweetsForKeyword(String keyWord, int N, Query.ResultType type) {
        Query query = new Query(keyWord);
        query.setCount(N);
        query.resultType(type);
        try {
            QueryResult result = tweetingAPIsActuator.search(query);
            return (ArrayList<Status>) result.getTweets();
        } catch (TwitterException te) {
            te.printStackTrace();
        } catch (Exception generalExceptionThatWontBeThrown) {
            generalExceptionThatWontBeThrown.printStackTrace();
        }
        return null;
    }
}
