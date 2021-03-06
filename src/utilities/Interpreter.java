package utilities;

import com.sun.java.swing.action.NewAction;
import game.logic.Action;
import game.logic.Mission;
import game.logic.Unit;

import java.util.ArrayList;
public class Interpreter {

    //converts in the format: unit.move(3);
    //possible commands: turn, move
    //for now assumes unit is the implicit parameter
    public static Action parseLine(String string){
        String[] arr = string.split("\\.");
        String[] command = arr[1].split("\\(");   //["move", "3);"]
        String method = command[0];
        String value = command[1].split("\\)")[0];

            if (method.equals("move")) {
                return new Action(Action.ActionType.MOVE, Integer.parseInt(value));
            } else if (method.equals("turn")) {
                if (value.equals("right")) {
                    return new Action(Action.ActionType.TURN_RIGHT, -1);
                } else {
                    return new Action(Action.ActionType.TURN_LEFT, -1);
                }
            }

        return null;

    }

    public static String parseName(String[] command){
        String unitChoiceOne = command[4];
        String[] unitChoiceTwo = unitChoiceOne.split("\\(");
        String[] unitChoiceThree = unitChoiceTwo[1].split("\\)");
        String unitSelection = unitChoiceThree[0];
            switch (unitSelection) {
                case "normal":
                    return unitSelection;
                case "scout":
                    return unitSelection;
                case "champ":
                    return unitSelection;
            }
        unitSelection = "normal";
        return unitSelection;



    }

    public static Mission parseScript(String script, Vec2d start){
        ArrayList<Action> actions = new ArrayList<>();
        String[] arr = script.split("\\\n"); //Unit unit = new Unit(normal/scout/champ)
        String[] name = arr[0].split(" ");

        Unit unit = new Unit(parseName(name), start);
        System.out.println(parseName(name));
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("")){
                actions.add(parseLine(arr[i]));
            }
        }

        return new Mission(unit, actions);
    }


}
