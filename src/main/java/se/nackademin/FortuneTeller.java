package se.nackademin;

public class FortuneTeller {
    MagicNumbers magicNumbers;
    Translator translator;

    /*
     * Returns a fortune based on name, income, location, age and height
     *
     * Calculates the magical numbers A-E, and then feeds these numbers to the Translator. The translator class returns
     * individual words which are fed into the magical template. The result of this operation is a scientifically
     * proven fortune.
     *
     * @return A scientifically proven fortune
     *
     */
    public String calculate() {
        String adjectiveA = translator.getAdjective(magicNumbers.calculateA());
        String verbB = translator.getVerb(magicNumbers.calculateB());
        String nounC = translator.getNoun(magicNumbers.calculateC());
        String verbD = translator.getVerb(magicNumbers.calculateD());
        String adjectiveE = translator.getAdjective(magicNumbers.calculateE());

        String template = "Din framtid är %s. " +
                "Du borde sluta %s. " +
                "Vi ser att du snart kommer att skaffa %s. " +
                "Snart kommer du vilja %s, " +
                "men då är det viktigt att du är %s.";
        return String.format(template, adjectiveA, verbB, nounC, verbD, adjectiveE);
    }


    FortuneTeller(MagicNumbers magicNumbers, Translator translator) {
        this.magicNumbers = magicNumbers;
        this.translator = translator;
    }

    public boolean setName(String name) {

        magicNumbers.setName(name);
        return name != null && !"".equals(name);
    }

    private Integer convertToInteger(String input) {
        Integer output = null;
        try {
            output = Integer.valueOf(input);
        } catch (NumberFormatException numberFormatException) {
            //if an exception is caught we'll return null
        }
        return output;
    }

    public boolean setIncome(String income) {
        Integer incomeValue = convertToInteger(income);
        if (incomeValue == null) {
            return false;
        } else {
            magicNumbers.setIncome(incomeValue);
            return incomeValue <= 10_000_000;
        }
    }

    public boolean setLocation(String location) {
        magicNumbers.setLocation(location);
        return location != null && !"".equals(location);
    }

    public boolean setAge(String age) {
        Integer ageValue = convertToInteger(age);
        if (ageValue == null) {
            return false;
        } else {
            magicNumbers.setAge(ageValue);
            return true;
        }
    }

    public boolean setHeight(String height) {
        Integer heightValue = convertToInteger(height);
        if (heightValue == null) {
            return false;
        } else {
            magicNumbers.setHeight(heightValue);
            return true;
        }
    }
}
