import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class State {
    private int stateID;
    private Map<String,ArrayList<State>> nextState;
    private Set<State> DFAStates;
    private boolean endState;


    //constructor for NFA
    public State (int ID) {
        HashMap<String, ArrayList<State>> newNextState = new HashMap <String, ArrayList<State>> ();
        this.setStateID(ID);
        this.setNextState(newNextState);
        this.setEndState(false); //default is not end state
    }

    //constructor for DFA
    public State(Set<State> states, int ID) {
        this.setDFAStates(states);
        this.setStateID(ID);
        this.setNextState(new HashMap <String, ArrayList<State>> ());

        // find if there is final state in this set of states
        for (State p : states) {
            if (p.isEndState()) {
                this.setEndState(true);
                break;
            }
        }
    }

    //auto generated
    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public Map<String, ArrayList<State>> getNextState() {
        return nextState;
    }

    public void setNextState(Map<String, ArrayList<State>> nextState) {
        this.nextState = nextState;
    }

    public Set<State> getDFAStates() {
        return DFAStates;
    }

    public void setDFAStates(Set<State> DFAStates) {
        this.DFAStates = DFAStates;
    }

    public boolean isEndState() {
        return endState;
    }

    // Get all transition states based on symbol
    public ArrayList<State> getAllTransitions(char c) {
        if (this.nextState.get(c) == null)	{	return new ArrayList<State> ();	}
        else 								{	return this.nextState.get(c);	}
    }

    public void setEndState(boolean endState) {
        this.endState = endState;
    }

    // Add transition between states and insert into the arrayList
    // or create the arrayList based on key
    public void addTransition (State next, char key) {
        ArrayList <State> list = this.nextState.get(key);

        if (list == null) {
            list = new ArrayList<State> ();
            this.nextState.put(String.valueOf(key), list);
        }

        list.add(next);
    }

    //this is for printing the States and where it is going to.
    public void printStates(){

        //if it is NOT an empty list of states
        if(!nextState.isEmpty()) {
            System.out.print("  ******** stateID  :  "+ stateID);
            for (Map.Entry<String, ArrayList<State>> entry : nextState.entrySet()) {
                ArrayList<State> Stetes = entry.getValue();
                String nextStates = "";
                for (int i=0; i<Stetes.size(); i++){
                    int stateID = Stetes.get(i).getStateID();
                    nextStates+= " "+stateID+" , ";
                }
                System.out.println("   character  : "+ entry.getKey() + "  ,  nextStates  : "+ nextStates);//here maybe an error since we are trying to print an ArrayList.. I didnt check yet.
            }
        }
    }
}
