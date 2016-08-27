
package flatland;

/**
 *
 * @author hbrace
 */
public class Bug implements Comparable <Bug>{
   private int x_location;
   private int y_location;
   private boolean isAlive;
   private int x_range;
   private int y_range;
   private boolean isMale;
  
   
   public Bug (int range){
       isAlive = true;
       x_range = range;
       y_range = range;
       x_location =  (int) (Math.random() * (range + 1));
       y_location =  (int) (Math.random() * (range + 1));
         
       double genderDice = Math.random();   
       if (genderDice > .5){
           isMale = true;
       }
       
       else {
           isMale = false;
       }
            
   }
   public boolean getMale(){
       return isMale;
   }
   
   public boolean getIsAlive(){
       return isAlive;
   }
   
   @Override
   public int compareTo (Bug other){
       if (x_location == other.x_location && y_location == other.y_location){
           return 0;
       }
       
       if (x_location > other.x_location && y_location > other.y_location)
       {
         return 1;  
       }
       else
           return -1;
   }
   
   @Override 
   public boolean equals (Object other){
       if (!(other instanceof Bug)){
           return false;
       }
       Bug b = (Bug) other;
       if (x_location == b.x_location && y_location == b.y_location)
       { return true;}
       return false;
   }
public void move (){
    
    if (!isAlive){
        return;
    }
    
    //Select one of 8 possible directions. 
    //0 indicates the bug stays in place
    int move = (int) (Math.random() * 9);
    int temp_x_location = x_location;
    int temp_y_location = y_location;
    
    if (move == 0)
        return;
    if (move ==1)
    {temp_x_location -= 1;}
    if (move == 2)
    {temp_y_location += 1;
    temp_x_location -= 1;
    }
    if (move == 3){
        temp_y_location += 1;
    }
    if (move == 4)
    { temp_x_location += 1;
      temp_y_location += 1;
    } 
    if (move == 5){
        temp_x_location += 1;
    }
    
    if (move == 6){
        temp_x_location += 1;
        temp_y_location -= 1;
    }
    
    if (move == 7){
        temp_y_location -= 1;
    }
    
    if (move == 8){
        temp_x_location -= 1;
        temp_y_location -= 1;
    }
    
    if (temp_x_location < 0 || temp_y_location < 0)
    {return;}
    
    if (temp_x_location > x_range || temp_y_location > y_range){
        return;
    }
    
    x_location = temp_x_location;
    y_location = temp_y_location;
}

public void killBug (){
    isAlive = false;
}

}


