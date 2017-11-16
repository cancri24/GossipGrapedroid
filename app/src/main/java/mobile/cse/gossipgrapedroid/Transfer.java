package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

class Transfer extends Gossip {
    static private String[] transferTypes = {"left SLA", "dropped out of high school", "left for college early","expelled of SLA"};
    static private String[] reasons = {"their ex still goes there","their chem teacher was bad","they hate the school lunch","someone broke their laptop on purpose",
            "someone cut in front of them in the lunch line", "Peed on the principal"};
    private String type;
    private String reason;
    Transfer(){
        type = transferTypes[rand.nextInt(transferTypes.length-1)];
        reason = reasons[rand.nextInt(reasons.length-1)];
    }
    public String whatHappened(){
        return type+" because "+reason;
    }
}