package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

class Crime  extends Gossip {
    static private String [] crimes = {"smoked weed on school property","stole a laptop","cut in the lunch line","fell asleep during class","skipped class","yelled at a teacher"};
    private String crime;
    Crime(){
        crime = crimes[rand.nextInt(crimes.length-1)];
    }
    public String whatHappened(){
        return crime;
    }
}