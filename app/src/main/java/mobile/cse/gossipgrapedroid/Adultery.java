package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

class Adultery extends Gossip {
    private Person wife;
    private Person handmaid;
    static private String[] femRoles = {"girlfriend", "wife"};
    static private String[] mascRoles = {"boyfriend", "husband"};
    static private String[] andRoles = {"partner", "spouse"};
    private String wifeRole;

    Adultery(boolean swarmMode) {
        wife = new Person(swarmMode, "");
        handmaid = new Person(swarmMode, "");
        switch (wife.getGender()) {
            case "female":
                wifeRole = femRoles[rand.nextInt(1)];
                break;
            case "male":
                wifeRole = mascRoles[rand.nextInt(1)];
                break;
            default:
                wifeRole = andRoles[rand.nextInt(1)];
                break;
        }
    }

    public String whatHappened() {
        return "cheated on their " + wifeRole + " " + wife.getName() + " with " + handmaid.getName();
    }
}