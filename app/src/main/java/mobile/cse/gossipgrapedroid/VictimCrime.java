package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

class VictimCrime extends Gossip {
    private Person victim;
    static private String [] crimes = {"ate","murdered","is in a relationship with","stabbed","burned","was seen cuddling","was seen kissing"};
    private String crime;
    VictimCrime(boolean swarmMode){
        victim = new Person(swarmMode, "");
        crime = crimes[rand.nextInt(crimes.length-1)];
    }
    public String whatHappened(){
        return crime+ " " +victim.getName();
    }

}