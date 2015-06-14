package com.bot.main;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TwitterProcessor twitterBot = new TwitterProcessor(AuthenticationBuilder.authnticate());

        twitterBot.postStaticTweet();
        twitterBot.postDynamicallyGeneratedTweet();

        twitterBot.replyToTopNTweetsForSpecificKeyword(dynamicallyConstructKeywordToSearchFor(),Constants.NumberOfTweetsRetrievalPerQuery,constructReplyForQuery(Constants.EMPTY_STRING));
    }

    private static String constructReplyForQuery(String tempParameterCanBeRemovedIfNotNeeded) {
        /* todo
        * Implement a reply construction logic that can be used per keyword
        * suggestions : read from a file, fetch from a web site
        * ,or select from a predefined list based on time of the day
        * */
        return Constants.StaticReplyToBeReplacedByConstructionLogic;
    }

    private static String dynamicallyConstructKeywordToSearchFor() {
        /* todo
        * Implement a keyword  construction logic that can be used for search
        * suggestions : read from a file, fetch from a web site
        * ,or select from a predefined list based on time of the day
        * */
        return Constants.StaticKeywordToBeReplacedByConstructionLogic;
    }

}
