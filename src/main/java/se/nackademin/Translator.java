package se.nackademin;

public class Translator {

    private final String[] adjectives = {"stor", "liten", "stark", "svag", "mjuk", "hård", "snabb", "vacker", "ljus", "mörk"};
    private final String[] nouns = {"en lönehöjning", "en lönesänkning", "en fotboja", "en katt", "en hund", "ett hus", "ett barn", "ett elstängsel", "en dator", "ett golv"};
    private final String[] verbs = {"springa", "ljuga", "flyga", "se", "vara", "äta", "mäta", "gå", "röra", "resa"};

    public String getNoun(int idx) {
        return nouns[idx];
    }

    public String getVerb(int idx) {
        return verbs[idx];
    }

    public String getAdjective(int idx) {
        return adjectives[idx];
    }
}
