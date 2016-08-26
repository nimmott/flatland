package flatland;

import java.util.ArrayList;

/**
 *
 * @author hbrace
 */
public class BugFarm {

    private int initNumBugs;
    private int initNumMales;
    private int initNumFemales;
    private int range;

    private int aliveBugs;
    private int deadBugs;
    private int maleBugs;
    private int femaleBugs;
    private int aliveMale;
    private int aliveFemale;
    private int deadMale;
    private int deadFemale;

    private ArrayList<Bug> bugList;

    public BugFarm() {

    }

    public BugFarm(int numBugs, int range) {
        initNumBugs = numBugs;
        this.range = range;

        bugList = new ArrayList<Bug>();

        for (int i = 0; i < numBugs; i++) {
            bugList.add(new Bug(range));
        }
        initNumMales = getMales();
        initNumFemales = getFemales();
    }

    public void getGenderCount() {
        maleBugs = 0;
        femaleBugs = 0;
        for (int i = 0; i < bugList.size(); i++) {
            boolean temp = bugList.get(i).getMale();
            if (temp) {
                maleBugs++;
            } else {
                femaleBugs++;
            }
        }

    }

    public int getMales() {
        getGenderCount();
        return maleBugs;
    }

    public int getFemales() {
        getGenderCount();
        return femaleBugs;
    }

    public void updateStats() {
        aliveBugs = 0;
        deadBugs = 0;
        maleBugs = 0;
        femaleBugs = 0;
        aliveFemale = 0;
        aliveMale = 0;
        deadFemale = 0;
        deadMale = 0;

        for (int i = 0; i < bugList.size(); i++) {
            boolean male = bugList.get(i).getMale();
            boolean alive = bugList.get(i).getIsAlive();
            if (alive) {
                aliveBugs++;
            }
            if (!alive) {
                deadBugs++;
            }
            if (male) {
                maleBugs++;
            }
            if (!male) {
                femaleBugs++;
            }
            if (male && alive) {
                aliveMale++;
            }
            if (male && !alive) {
                deadMale++;
            }
            if (!male && alive) {
                aliveFemale++;
            }
            if (!male && !alive) {
                deadFemale++;
            }

        }

    }

    public void moveBugs() {
        for (int i = 0; i < bugList.size(); i++) {
            bugList.get(i).move();
        }
    }

    public void fightOrMate() {
        int limit = bugList.size();

        for (int k = 0; k < limit; k++) {
            for (int o = k + 1; o < limit; o++) {
                if (bugList.get(k).equals(bugList.get(o))
                        && bugList.get(k).getIsAlive() && bugList.get(o).getIsAlive()) {
                    if (bugList.get(k).getMale() == bugList.get(o).getMale()) {
                        //fight
                        //System.out.println("One bug must die");
                        double temp = Math.random();
                        if (temp >= .5) {
                            bugList.get(k).killBug();
                            //  System.out.println("Bug killed");
                        }
                        if (temp < .5) {
                            bugList.get(o).killBug();
                            //   System.out.println("Bug killed");
                        }
                    }
                }
                if (bugList.get(k).getMale() != bugList.get(o).getMale()
                        && bugList.get(k).equals(bugList.get(o))
                        && bugList.get(k).getIsAlive() && bugList.get(o).getIsAlive()) {
                    Bug temp = new Bug(range);
                    bugList.add(temp);
                    // System.out.println("new bug added");
                }
            }
        }
    }
}
