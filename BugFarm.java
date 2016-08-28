package flatland;

import java.io.PrintWriter;
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
    private int numMoves;

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
        //  numMoves++;
        for (int i = 0; i < bugList.size(); i++) {
            bugList.get(i).move();
        }
    }

    public void fightOrMate() {
        int limit = bugList.size();

        for (int k = 0; k < limit; k++) {
            for (int o = k + 1; o < limit -1 ; o++) {
                if (bugList.get(k).equals(bugList.get(o))
                        && bugList.get(k).getIsAlive() && bugList.get(o).getIsAlive()) {
                    if (bugList.get(k).getMale() == bugList.get(o).getMale()) {
                        //fight
                        double temp = Math.random();
                        if (temp >= .5) {
                            bugList.get(k).killBug();
                        }
                        if (temp < .5) {
                            bugList.get(o).killBug();
                        }
                    }

                    if (bugList.get(k).getMale() != bugList.get(o).getMale()) {
                        //mate
                        Bug temp = new Bug(range);
                        bugList.add(temp);

                    }
                }
            }
        }
    }

    void printBugReport(String filename) {
        java.io.File f = new java.io.File(filename);

        if (f.exists()) {
            System.out.println("Error: File already exists");
            return;
        }
        if (!f.exists()) {
            java.io.PrintWriter printer;
            try {
                printer = new PrintWriter(f);
            } catch (Exception e) {
                System.out.println("IOException error" + e);
                return;
            }
            printer.println("Initial number of bugs: " + initNumBugs);
            printer.println("Initial number of male bugs: " + initNumMales);
            printer.println("Initial number of female bugs: " + initNumFemales);
            printer.println(" ");
            printer.println("---------------------After Simulation________________");
            printer.println("Number of alive bugs: " + aliveBugs);
            printer.println("Number of dead bugs: " + deadBugs);
            printer.println("Number of male bugs: " + maleBugs);
            printer.println("Number of alive male bugs: " + aliveMale);
            printer.println("Number of dead male bugs: " + deadMale);
            printer.println("Number of female bugs: " + femaleBugs);
            printer.println("Number of alive female bugs: " + aliveFemale);
            printer.println("Number of dead female bugs: " + deadFemale);
            printer.close();

        }
    }
}
