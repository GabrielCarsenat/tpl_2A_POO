package simulation.events;

public abstract class Evenement implements Comparable<Evenement>{
    private long date;
    public Evenement(long date){
        this.date=date;
    }
    public long getDate() {
        return date;
    }
    public abstract void execute();

    @Override
    public int compareTo(Evenement evt) {
        if (evt.date==this.date) return 0;
        return (this.date>evt.date)?1:-1;
    }

}
