package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

public class ItemNoPerson extends Gossip {
    static private String[] whats = {"was melted in a biochem activity","was broken","was repaired"};
    private String what;
    ItemNoPerson(){
        what = whats[rand.nextInt(whats.length-1)];
    }
    public String whatHappened(){
        return what;
    }
}