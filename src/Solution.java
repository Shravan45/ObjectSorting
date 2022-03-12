import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Solution {

  List<Robot> robots;

  public Solution() {
    robots = new ArrayList<>();
    robots.add(new Robot("Vision", 46));
    robots.add(new Robot("Ultron", 67));
    robots.add(new Robot("Mechamaru", 21));
    robots.add(new Robot("Wall-e", 3));
    robots.add(new Robot("Rocket", 32));
    robots.add(new Robot("Rocket", 33));
    robots.add(new Robot("Cyborg", 85));
    robots.add(new Robot("Panda", 50));
    robots.add(new Robot("Atom", 50));
  }

  public static void main(String[] args){

    Solution solution = new Solution();
    System.out.println("Sort Robots using just name: ");
    solution.sortByName().forEach(item -> System.out.println(item.getName() + " " + item.getEfficiency()));

    System.out.println("\nSort Robots in descending using just efficiency: ");
    solution.sortByEfficiencyDesc().forEach(item -> System.out.println(item.getName() + " " + item.getEfficiency()));
    
    System.out.println("\nSort Robots using name and then efficiency: ");
    solution.sortByNameAndThenEfficiency().forEach(item -> System.out.println(item.getName() + " " + item.getEfficiency()));
    
    System.out.println("\nSort Robots using efficiency and then name: ");
    solution.sortByEfficiencyThenByName().forEach(item -> System.out.println(item.getName() + " " + item.getEfficiency()));
  }

  private List<Robot> sortByEfficiencyThenByName() {
    Collections.sort(this.robots, new Comparator<Robot>() {
      @Override
      public int compare(Robot o1, Robot o2) {
        int value1 = o1.getEfficiency().compareTo(o2.getEfficiency());
        if(value1 == 0){
          return o1.getName().compareTo(o2.getName());
        }
        return value1;
      }
    });
    return this.robots;
  }

  private List<Robot> sortByNameAndThenEfficiency() {
    Collections.sort(this.robots, new Comparator<Robot>() {
      @Override
      public int compare(Robot o1, Robot o2) {
        int value1 = o1.getName().compareTo(o2.getName());
        if(value1 == 0){
          return o1.getEfficiency().compareTo(o2.getEfficiency());
        }
        return value1;
      }
    });
    return this.robots;
  }

  private List<Robot> sortByEfficiencyDesc() {
    Collections.sort(this.robots, new Comparator<Robot>() {
      @Override
      public int compare(Robot o1, Robot o2) {
        return o2.getEfficiency().compareTo(o1.getEfficiency());
      }
    });
    return this.robots;
  }

  private List<Robot> sortByName() {
    Collections.sort(this.robots, Comparator.comparing(Robot::getName));
    return this.robots;
  }
}

class Robot {
  public String getName() {
    return name;
  }

  public Integer getEfficiency() {
    return efficiency;
  }

  private String name;
  private Integer efficiency;

  public Robot(String name, int efficiency) {
    this.name = name;
    this.efficiency = efficiency;
  }
}

