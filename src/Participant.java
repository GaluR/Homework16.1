public class Participant implements Comparable<Participant>{
    private String name;
    private int result;

    public Participant(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public Participant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return name + ':' + result + "\n";
    }

    @Override
    public int compareTo(Participant o) {
        if(this.result > o.result){
            return 1;
        }else if (this.result < o.result){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }

    }
}
