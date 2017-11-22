package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

class ItemPersonInvolved extends Gossip {
    private Person thedude;
    static private String[] whats = {"tripped over","vandalized","eaten","body slammed","smashed","hurt by an arrow to the knee"};
    private String what;
    ItemPersonInvolved(boolean swarmMode){
        thedude = new Person(swarmMode);
        what = whats[rand.nextInt(whats.length-1)];
    }
    public String whatHappened(){
        return "was "+what+" by "+thedude.getName();
    }
}