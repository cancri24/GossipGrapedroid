package mobile.cse.gossipgrapedroid;

import static mobile.cse.gossipgrapedroid.MainActivity.rand;

public class Item implements Subject {
    //edited by Eleanor
    static private String Type[] = {"table","chair","vending machine","desk","ruler","apple","laptop","phone"};
    static private String Adjective[] = {"bONELESS","peasy","yeezy","tainted","infected","crusty","ashy","crispy"};
    static private String vowels[] = {"a", "e", "i", "o", "u"};
    private String type;
    private String adj;

    Item() {
        type = Type[rand.nextInt(Type.length-1)];
        adj = Adjective[rand.nextInt(Adjective.length-1)];
    }
    public String getName(){
        for(String i : vowels) {
            if(String.valueOf(adj.charAt(0)).equals(i)) return "an "+adj+" "+type;
        }
        return "a "+adj+" "+type;
    }
}
