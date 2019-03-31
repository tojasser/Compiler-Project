import java.util.LinkedList;

public class NFA {
    private LinkedList<State> nfa;

    public NFA () {
        this.setNfa(new LinkedList<State> ());
        this.getNfa().clear();
    }

    public LinkedList<State> getNfa() {
        return nfa;
    }

    public void setNfa(LinkedList<State> nfa) {
        this.nfa = nfa;
    }

    public void printNFA(){
        LinkedList<State> nfa = this.getNfa();
        if (!nfa.isEmpty()){
            for (int i=0; i<nfa.size(); i++){
                nfa.get(i).printStates();
            }
        }
    }
}