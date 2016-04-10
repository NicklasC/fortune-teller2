package se.nackademin;

public class MagicNumbers {

    private String name;
    private int income;
    private String location;
    private int age;
    private int height;

    public int calculateA() {
        int a = name.split(" ").length;
        a += age;
        while (a > 10) {
            a -= 7;
        }
        return a;
    }

    public int calculateB() {
        int b = location.length();
        b += income;
        while (b >= 10) {
            b -= 7;
        }
        return b;
    }

    public int calculateC() {
        int c = calculateA() + calculateB();
        c -= height;
        //fixing issue #38
        c = -Math.abs(c);
        while (c < 0) {
            c += 10;
        }
        return c;
    }

    public int calculateD() {
        int d = calculateA();
        if (d > 5) {
            d += calculateB();
        } else {
            d += calculateC();
        }
        d -= income;
        //fixing issue #41
        d = -Math.abs(d);
        while (d < 0) {
            d += 10;
        }
        return d;
    }

    public int calculateE() {
        long e = age;
        e *= income;
        e *= income;
        e *= height;
        double ef = Math.sqrt(e);
        while (ef >= 10) {
            ef /= 2.0;
            ef = Math.round(ef);
        }
        e = Math.round(ef);
        return (int) e;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncome(int income) {
        this.income = Math.abs(income);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAge(int age) {
        this.age = Math.abs(age);
    }

    public void setHeight(int height) {
        this.height = Math.abs(height);
    }
}
