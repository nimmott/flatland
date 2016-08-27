// Your Name: Harrison Brace   
// Your CLID: HAB5597
// CMPS 360
// Programming Project : # 1
// Due Date : 6 Septtember 2016
// Program Description: Simulaiton of bugfarm in flatland
// Certificate of Authenticity:
// I certify that the code in the method functions including
// method function main of this project are entirely my own
// work.

package flatland;

import java.util.Scanner;

/**
 *
 * @author hbrace
 */
public class Flatland {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numBugs;
        String filename;
        int range;
        int numMoves;
        
        Scanner scan = new Scanner(System.in);
        System.out.println ("What is the inital number of bugs for the bugfarm?");
        numBugs = scan.nextInt();
        System.out.println ("What is the range of the bugs int the farm?");
        System.out.println("Please enter a number from 0 to 99:");
        range = scan.nextInt();
        System.out.println ("How many times should the bugs move?");
        numMoves = scan.nextInt();
        if (range < 0 || range > 99){
            System.out.println("Number was outside range");
            return;
        }
        System.out.println("What is the name of the report file?");
        filename = scan.next();
        BugFarm farm = new BugFarm (numBugs, range);
 //       farm.updateStats();
 
        for (int i=0;i<numMoves;i++){
            farm.moveBugs();
            farm.fightOrMate();
        }
        
        farm.updateStats();
        farm.printBugReport(filename);
       

//        farm.moveBugs();
//        farm.fightOrMate();
//        farm.moveBugs();
//        farm.fightOrMate();
//        farm.updateStats();
        
        System.out.println("Hello World");
        
    }

}
